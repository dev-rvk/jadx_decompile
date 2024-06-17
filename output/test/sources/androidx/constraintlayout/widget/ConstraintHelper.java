package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    private HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attrs);
    }

    public ConstraintHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attrs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.mReferenceIds = a.getString(attr);
                    setIds(this.mReferenceIds);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mReferenceIds != null) {
            setIds(this.mReferenceIds);
        }
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.mReferenceIds = null;
            addRscID(view.getId());
            requestLayout();
        }
    }

    public void removeView(View view) {
        int id = view.getId();
        if (id == -1) {
            return;
        }
        this.mReferenceIds = null;
        int i = 0;
        while (true) {
            if (i >= this.mCount) {
                break;
            }
            if (this.mIds[i] != id) {
                i++;
            } else {
                for (int j = i; j < this.mCount - 1; j++) {
                    this.mIds[j] = this.mIds[j + 1];
                }
                this.mIds[this.mCount - 1] = 0;
                this.mCount--;
            }
        }
        requestLayout();
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] ids) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i : ids) {
            addRscID(i);
        }
    }

    private void addRscID(int id) {
        if (id == getId()) {
            return;
        }
        if (this.mCount + 1 > this.mIds.length) {
            this.mIds = Arrays.copyOf(this.mIds, this.mIds.length * 2);
        }
        this.mIds[this.mCount] = id;
        this.mCount++;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mUseViewMeasure) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams params = getLayoutParams();
        if (params instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) params;
            layoutParams.widget = (ConstraintWidget) this.mHelperWidget;
        }
    }

    private void addID(String idString) {
        if (idString == null || idString.length() == 0 || this.myContext == null) {
            return;
        }
        String idString2 = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int rscId = findId(idString2);
        if (rscId != 0) {
            this.mMap.put(Integer.valueOf(rscId), idString2);
            addRscID(rscId);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + idString2 + "\"");
        }
    }

    private int findId(String referenceId) {
        ConstraintLayout parent = null;
        if (getParent() instanceof ConstraintLayout) {
            parent = (ConstraintLayout) getParent();
        }
        int rscId = 0;
        if (isInEditMode() && parent != null) {
            Object value = parent.getDesignInformation(0, referenceId);
            if (value instanceof Integer) {
                rscId = ((Integer) value).intValue();
            }
        }
        if (rscId == 0 && parent != null) {
            rscId = findId(parent, referenceId);
        }
        if (rscId == 0) {
            try {
                Field field = R.id.class.getField(referenceId);
                rscId = field.getInt(null);
            } catch (Exception e) {
            }
        }
        if (rscId == 0) {
            return this.myContext.getResources().getIdentifier(referenceId, "id", this.myContext.getPackageName());
        }
        return rscId;
    }

    private int findId(ConstraintLayout container, String idString) {
        Resources resources;
        if (idString == null || container == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int count = container.getChildCount();
        for (int j = 0; j < count; j++) {
            View child = container.getChildAt(j);
            if (child.getId() != -1) {
                String res = null;
                try {
                    res = resources.getResourceEntryName(child.getId());
                } catch (Resources.NotFoundException e) {
                }
                if (idString.equals(res)) {
                    return child.getId();
                }
            }
        }
        return 0;
    }

    protected void setIds(String idList) {
        this.mReferenceIds = idList;
        if (idList == null) {
            return;
        }
        int begin = 0;
        this.mCount = 0;
        while (true) {
            int end = idList.indexOf(44, begin);
            if (end == -1) {
                addID(idList.substring(begin));
                return;
            } else {
                addID(idList.substring(begin, end));
                begin = end + 1;
            }
        }
    }

    protected void applyLayoutFeatures(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.mCount; i++) {
            int id = this.mIds[i];
            View view = container.getViewById(id);
            if (view != null) {
                view.setVisibility(visibility);
                if (elevation > 0.0f) {
                    view.setTranslationZ(view.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            applyLayoutFeatures((ConstraintLayout) parent);
        }
    }

    public void updatePreLayout(ConstraintLayout container) {
        String candidate;
        int foundId;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        if (this.mHelperWidget == null) {
            return;
        }
        this.mHelperWidget.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            int id = this.mIds[i];
            View view = container.getViewById(id);
            if (view == null && (foundId = findId(container, (candidate = this.mMap.get(Integer.valueOf(id))))) != 0) {
                this.mIds[i] = foundId;
                this.mMap.put(Integer.valueOf(foundId), candidate);
                view = container.getViewById(foundId);
            }
            if (view != null) {
                this.mHelperWidget.add(container.getViewWidget(view));
            }
        }
        this.mHelperWidget.updateConstraints(container.mLayoutWidget);
    }

    public void updatePreLayout(ConstraintWidgetContainer container, Helper helper, SparseArray<ConstraintWidget> map) {
        helper.removeAllIds();
        for (int i = 0; i < this.mCount; i++) {
            int id = this.mIds[i];
            helper.add(map.get(id));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] getViews(ConstraintLayout layout) {
        if (this.mViews == null || this.mViews.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i = 0; i < this.mCount; i++) {
            int id = this.mIds[i];
            this.mViews[i] = layout.getViewById(id);
        }
        return this.mViews;
    }

    public void updatePostLayout(ConstraintLayout container) {
    }

    public void updatePostMeasure(ConstraintLayout container) {
    }

    public void updatePostConstraints(ConstraintLayout constainer) {
    }

    public void updatePreDraw(ConstraintLayout container) {
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        if (constraint.layout.mReferenceIds != null) {
            setReferencedIds(constraint.layout.mReferenceIds);
        } else if (constraint.layout.mReferenceIdString != null && constraint.layout.mReferenceIdString.length() > 0) {
            constraint.layout.mReferenceIds = convertReferenceString(this, constraint.layout.mReferenceIdString);
        }
        child.removeAllIds();
        if (constraint.layout.mReferenceIds != null) {
            for (int i = 0; i < constraint.layout.mReferenceIds.length; i++) {
                int id = constraint.layout.mReferenceIds[i];
                ConstraintWidget widget = mapIdToWidget.get(id);
                if (widget != null) {
                    child.add(widget);
                }
            }
        }
    }

    private int[] convertReferenceString(View view, String referenceIdString) {
        String[] split = referenceIdString.split(",");
        view.getContext();
        int[] rscIds = new int[split.length];
        int count = 0;
        for (String idString : split) {
            int id = findId(idString.trim());
            if (id != 0) {
                rscIds[count] = id;
                count++;
            }
        }
        int i = split.length;
        if (count != i) {
            return Arrays.copyOf(rscIds, count);
        }
        return rscIds;
    }

    public void resolveRtl(ConstraintWidget widget, boolean isRtl) {
    }
}
