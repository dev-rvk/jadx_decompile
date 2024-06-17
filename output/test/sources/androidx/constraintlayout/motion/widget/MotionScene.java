package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    StateSet mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mMotionOutsideRegion = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransition(int beginId, int endId) {
        int start = beginId;
        int end = endId;
        if (this.mStateSet != null) {
            int tmp = this.mStateSet.stateGetConstraintID(beginId, -1, -1);
            if (tmp != -1) {
                start = tmp;
            }
            int tmp2 = this.mStateSet.stateGetConstraintID(endId, -1, -1);
            if (tmp2 != -1) {
                end = tmp2;
            }
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if ((transition.mConstraintSetEnd == end && transition.mConstraintSetStart == start) || (transition.mConstraintSetEnd == endId && transition.mConstraintSetStart == beginId)) {
                this.mCurrentTransition = transition;
                if (this.mCurrentTransition == null || this.mCurrentTransition.mTouchResponse == null) {
                    return;
                }
                this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                return;
            }
        }
        Transition matchTransiton = this.mDefaultTransition;
        Iterator<Transition> it2 = this.mAbstractTransitionList.iterator();
        while (it2.hasNext()) {
            Transition transition2 = it2.next();
            if (transition2.mConstraintSetEnd == endId) {
                matchTransiton = transition2;
            }
        }
        Transition t = new Transition(this, matchTransiton);
        t.mConstraintSetStart = start;
        t.mConstraintSetEnd = end;
        if (start != -1) {
            this.mTransitionList.add(t);
        }
        this.mCurrentTransition = t;
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    private int getIndex(Transition transition) {
        int id = transition.mId;
        if (id == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int index = 0; index < this.mTransitionList.size(); index++) {
            if (this.mTransitionList.get(index).mId == id) {
                return index;
            }
        }
        return -1;
    }

    public boolean validateLayout(MotionLayout layout) {
        return layout == this.mMotionLayout && layout.mScene == this;
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (this.mCurrentTransition == null || this.mCurrentTransition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    private int getRealID(int stateid) {
        int tmp;
        if (this.mStateSet != null && (tmp = this.mStateSet.stateGetConstraintID(stateid, -1, -1)) != -1) {
            return tmp;
        }
        return stateid;
    }

    public List<Transition> getTransitionsWithState(int stateid) {
        int stateid2 = getRealID(stateid);
        ArrayList<Transition> ret = new ArrayList<>();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mConstraintSetStart == stateid2 || transition.mConstraintSetEnd == stateid2) {
                ret.add(transition);
            }
        }
        return ret;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int currentState) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mOnClicks.size() > 0) {
                Iterator it2 = transition.mOnClicks.iterator();
                while (it2.hasNext()) {
                    Transition.TransitionOnClick onClick = (Transition.TransitionOnClick) it2.next();
                    onClick.removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition transition2 = it3.next();
            if (transition2.mOnClicks.size() > 0) {
                Iterator it4 = transition2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    Transition.TransitionOnClick onClick2 = (Transition.TransitionOnClick) it4.next();
                    onClick2.removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition transition3 = it5.next();
            if (transition3.mOnClicks.size() > 0) {
                Iterator it6 = transition3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    Transition.TransitionOnClick onClick3 = (Transition.TransitionOnClick) it6.next();
                    onClick3.addOnClickListeners(motionLayout, currentState, transition3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition transition4 = it7.next();
            if (transition4.mOnClicks.size() > 0) {
                Iterator it8 = transition4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    Transition.TransitionOnClick onClick4 = (Transition.TransitionOnClick) it8.next();
                    onClick4.addOnClickListeners(motionLayout, currentState, transition4);
                }
            }
        }
    }

    public Transition bestTransitionFor(int currentState, float dx, float dy, MotionEvent mLastTouchDown) {
        float val;
        if (currentState != -1) {
            List<Transition> candidates = getTransitionsWithState(currentState);
            float max = 0.0f;
            Transition best = null;
            RectF cache = new RectF();
            for (Transition transition : candidates) {
                if (!transition.mDisable && transition.mTouchResponse != null) {
                    transition.mTouchResponse.setRTL(this.mRtl);
                    RectF region = transition.mTouchResponse.getTouchRegion(this.mMotionLayout, cache);
                    if (region == null || mLastTouchDown == null || region.contains(mLastTouchDown.getX(), mLastTouchDown.getY())) {
                        RectF region2 = transition.mTouchResponse.getTouchRegion(this.mMotionLayout, cache);
                        if (region2 == null || mLastTouchDown == null || region2.contains(mLastTouchDown.getX(), mLastTouchDown.getY())) {
                            float val2 = transition.mTouchResponse.dot(dx, dy);
                            if (transition.mConstraintSetEnd == currentState) {
                                val = val2 * (-1.0f);
                            } else {
                                val = val2 * 1.1f;
                            }
                            if (val > max) {
                                max = val;
                                best = transition;
                            }
                        }
                    }
                }
            }
            return best;
        }
        return this.mCurrentTransition;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public Transition getTransitionById(int id) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mId == id) {
                return transition;
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int[] ids = new int[this.mConstraintSetMap.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = this.mConstraintSetMap.keyAt(i);
        }
        return ids;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int currentState) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mAutoTransition != 0) {
                if (currentState == transition.mConstraintSetStart && (transition.mAutoTransition == 4 || transition.mAutoTransition == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(transition);
                    if (transition.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    }
                    return true;
                }
                if (currentState == transition.mConstraintSetEnd && (transition.mAutoTransition == 3 || transition.mAutoTransition == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(transition);
                    if (transition.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    public void setRtl(boolean rtl) {
        this.mRtl = rtl;
        if (this.mCurrentTransition == null || this.mCurrentTransition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* loaded from: classes.dex */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public void addOnClick(Context context, XmlPullParser parser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, parser));
        }

        public int getId() {
            return this.mId;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public void setDuration(int duration) {
            this.mDuration = duration;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public void setStagger(float stagger) {
            this.mStagger = stagger;
        }

        public void setPathMotionArc(int arcMode) {
            this.mPathMotionArc = arcMode;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public void setEnable(boolean enable) {
            this.mDisable = !enable;
        }

        public String debugString(Context context) {
            String ret;
            if (this.mConstraintSetStart == -1) {
                ret = "null";
            } else {
                ret = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return ret + " -> null";
            }
            return ret + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public boolean isTransitionFlag(int flag) {
            return (this.mTransitionFlags & flag) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser parser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray a = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.OnClick);
                int N = a.getIndexCount();
                for (int i = 0; i < N; i++) {
                    int attr = a.getIndex(i);
                    if (attr == R.styleable.OnClick_targetId) {
                        this.mTargetId = a.getResourceId(attr, this.mTargetId);
                    } else if (attr == R.styleable.OnClick_clickAction) {
                        this.mMode = a.getInt(attr, this.mMode);
                    }
                }
                a.recycle();
            }

            public void addOnClickListeners(MotionLayout motionLayout, int currentState, Transition transition) {
                View v = this.mTargetId == -1 ? motionLayout : motionLayout.findViewById(this.mTargetId);
                if (v != null) {
                    int start = transition.mConstraintSetStart;
                    int end = transition.mConstraintSetEnd;
                    if (start == -1) {
                        v.setOnClickListener(this);
                        return;
                    }
                    boolean listen = (this.mMode & 1) != 0 && currentState == start;
                    if (listen | ((this.mMode & 256) != 0 && currentState == start) | ((this.mMode & 1) != 0 && currentState == start) | ((this.mMode & 16) != 0 && currentState == end) | ((this.mMode & 4096) != 0 && currentState == end)) {
                        v.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e(MotionScene.TAG, "OnClick could not find id " + this.mTargetId);
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                if (this.mTargetId == -1) {
                    return;
                }
                View v = motionLayout.findViewById(this.mTargetId);
                if (v == null) {
                    Log.e(MotionScene.TAG, " (*)  could not find id " + this.mTargetId);
                } else {
                    v.setOnClickListener(null);
                }
            }

            boolean isTransitionViable(Transition current, MotionLayout tl) {
                if (this.mTransition == current) {
                    return true;
                }
                int dest = this.mTransition.mConstraintSetEnd;
                int from = this.mTransition.mConstraintSetStart;
                return from == -1 ? tl.mCurrentState != dest : tl.mCurrentState == from || tl.mCurrentState == dest;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout tl = this.mTransition.mMotionScene.mMotionLayout;
                if (tl.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart != -1) {
                        Transition current = this.mTransition.mMotionScene.mCurrentTransition;
                        boolean bidirectional = false;
                        boolean forward = ((this.mMode & 1) == 0 && (this.mMode & 256) == 0) ? false : true;
                        boolean backward = ((this.mMode & 16) == 0 && (this.mMode & 4096) == 0) ? false : true;
                        if (forward && backward) {
                            bidirectional = true;
                        }
                        if (bidirectional) {
                            if (this.mTransition.mMotionScene.mCurrentTransition != this.mTransition) {
                                tl.setTransition(this.mTransition);
                            }
                            if (tl.getCurrentState() == tl.getEndState() || tl.getProgress() > 0.5f) {
                                forward = false;
                            } else {
                                backward = false;
                            }
                        }
                        if (isTransitionViable(current, tl)) {
                            if (forward && (1 & this.mMode) != 0) {
                                tl.setTransition(this.mTransition);
                                tl.transitionToEnd();
                                return;
                            }
                            if (backward && (this.mMode & 16) != 0) {
                                tl.setTransition(this.mTransition);
                                tl.transitionToStart();
                                return;
                            } else if (forward && (this.mMode & 256) != 0) {
                                tl.setTransition(this.mTransition);
                                tl.setProgress(1.0f);
                                return;
                            } else {
                                if (backward && (this.mMode & 4096) != 0) {
                                    tl.setTransition(this.mTransition);
                                    tl.setProgress(0.0f);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    int currentState = tl.getCurrentState();
                    if (currentState == -1) {
                        tl.transitionToState(this.mTransition.mConstraintSetEnd);
                        return;
                    }
                    Transition t = new Transition(this.mTransition.mMotionScene, this.mTransition);
                    t.mConstraintSetStart = currentState;
                    t.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                    tl.setTransition(t);
                    tl.transitionToEnd();
                }
            }
        }

        Transition(MotionScene motionScene, Transition global) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (global != null) {
                this.mPathMotionArc = global.mPathMotionArc;
                this.mDefaultInterpolator = global.mDefaultInterpolator;
                this.mDefaultInterpolatorString = global.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = global.mDefaultInterpolatorID;
                this.mDuration = global.mDuration;
                this.mKeyFramesList = global.mKeyFramesList;
                this.mStagger = global.mStagger;
                this.mLayoutDuringTransition = global.mLayoutDuringTransition;
            }
        }

        public Transition(int id, MotionScene motionScene, int constraintSetStartId, int constraintSetEndId) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = id;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = constraintSetStartId;
            this.mConstraintSetEnd = constraintSetEndId;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser parser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(parser));
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Transition);
            fill(motionScene, context, a);
            a.recycle();
        }

        private void fill(MotionScene motionScene, Context context, TypedArray a) {
            int N = a.getIndexCount();
            for (int i = 0; i < N; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = a.getResourceId(attr, this.mConstraintSetEnd);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        ConstraintSet cSet = new ConstraintSet();
                        cSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, cSet);
                    }
                } else if (attr == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = a.getResourceId(attr, this.mConstraintSetStart);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        ConstraintSet cSet2 = new ConstraintSet();
                        cSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, cSet2);
                    }
                } else if (attr == R.styleable.Transition_motionInterpolator) {
                    TypedValue type = a.peekValue(attr);
                    if (type.type == 1) {
                        this.mDefaultInterpolatorID = a.getResourceId(attr, -1);
                        if (this.mDefaultInterpolatorID != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (type.type == 3) {
                        this.mDefaultInterpolatorString = a.getString(attr);
                        if (this.mDefaultInterpolatorString.indexOf("/") > 0) {
                            this.mDefaultInterpolatorID = a.getResourceId(attr, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = a.getInteger(attr, this.mDefaultInterpolator);
                    }
                } else if (attr == R.styleable.Transition_duration) {
                    this.mDuration = a.getInt(attr, this.mDuration);
                } else if (attr == R.styleable.Transition_staggered) {
                    this.mStagger = a.getFloat(attr, this.mStagger);
                } else if (attr == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = a.getInteger(attr, this.mAutoTransition);
                } else if (attr == R.styleable.Transition_android_id) {
                    this.mId = a.getResourceId(attr, this.mId);
                } else if (attr == R.styleable.Transition_transitionDisable) {
                    this.mDisable = a.getBoolean(attr, this.mDisable);
                } else if (attr == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = a.getInteger(attr, -1);
                } else if (attr == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = a.getInteger(attr, 0);
                } else if (attr == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = a.getInteger(attr, 0);
                }
            }
            int i2 = this.mConstraintSetStart;
            if (i2 == -1) {
                this.mIsAbstract = true;
            }
        }
    }

    public MotionScene(MotionLayout layout) {
        this.mMotionLayout = layout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionScene(Context context, MotionLayout layout, int resourceID) {
        this.mMotionLayout = layout;
        load(context, resourceID);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    private void load(Context context, int resourceId) {
        Resources res = context.getResources();
        XmlPullParser parser = res.getXml(resourceId);
        Transition transition = null;
        try {
            int eventType = parser.getEventType();
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    switch (eventType) {
                        case 0:
                            parser.getName();
                            break;
                        case 2:
                            String tagName = parser.getName();
                            if (this.DEBUG_DESKTOP) {
                                System.out.println("parsing = " + tagName);
                            }
                            switch (tagName.hashCode()) {
                                case -1349929691:
                                    if (tagName.equals("ConstraintSet")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                                case -1239391468:
                                    if (tagName.equals("KeyFrameSet")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                                case 269306229:
                                    if (tagName.equals("Transition")) {
                                        break;
                                    }
                                    break;
                                case 312750793:
                                    if (tagName.equals("OnClick")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 327855227:
                                    if (tagName.equals("OnSwipe")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 793277014:
                                    if (tagName.equals(TAG)) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (tagName.equals("StateSet")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                            }
                            c = 65535;
                            switch (c) {
                                case 0:
                                    parseMotionSceneTags(context, parser);
                                    break;
                                case 1:
                                    ArrayList<Transition> arrayList = this.mTransitionList;
                                    Transition transition2 = new Transition(this, context, parser);
                                    transition = transition2;
                                    arrayList.add(transition2);
                                    if (this.mCurrentTransition == null && !transition.mIsAbstract) {
                                        this.mCurrentTransition = transition;
                                        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
                                            this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                        }
                                    }
                                    if (transition.mIsAbstract) {
                                        if (transition.mConstraintSetEnd == -1) {
                                            this.mDefaultTransition = transition;
                                        } else {
                                            this.mAbstractTransitionList.add(transition);
                                        }
                                        this.mTransitionList.remove(transition);
                                        break;
                                    }
                                    break;
                                case 2:
                                    if (transition == null) {
                                        String name = context.getResources().getResourceEntryName(resourceId);
                                        int line = parser.getLineNumber();
                                        Log.v(TAG, " OnSwipe (" + name + ".xml:" + line + ")");
                                    }
                                    transition.mTouchResponse = new TouchResponse(context, this.mMotionLayout, parser);
                                    break;
                                case 3:
                                    transition.addOnClick(context, parser);
                                    break;
                                case 4:
                                    this.mStateSet = new StateSet(context, parser);
                                    break;
                                case 5:
                                    parseConstraintSet(context, parser);
                                    break;
                                case 6:
                                    KeyFrames keyFrames = new KeyFrames(context, parser);
                                    transition.mKeyFramesList.add(keyFrames);
                                    break;
                                default:
                                    Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + tagName);
                                    break;
                            }
                            break;
                    }
                    eventType = parser.next();
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser parser) {
        AttributeSet attrs = Xml.asAttributeSet(parser);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MotionScene);
        int count = a.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = a.getInt(attr, this.mDefaultDuration);
            } else if (attr == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = a.getInteger(attr, 0);
            }
        }
        a.recycle();
    }

    private int getId(Context context, String idString) {
        int id = -1;
        if (idString.contains("/")) {
            String tmp = idString.substring(idString.indexOf(47) + 1);
            id = context.getResources().getIdentifier(tmp, "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + id);
            }
        }
        if (id == -1) {
            if (idString != null && idString.length() > 1) {
                int id2 = Integer.parseInt(idString.substring(1));
                return id2;
            }
            Log.e(TAG, "error in parsing id");
            return id;
        }
        return id;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r8.equals("deriveConstraintsFrom") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseConstraintSet(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.setForceId(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = -1
            r5 = 0
        L10:
            r6 = 1
            r7 = -1
            if (r5 >= r2) goto L74
            java.lang.String r8 = r15.getAttributeName(r5)
            java.lang.String r9 = r15.getAttributeValue(r5)
            boolean r10 = r13.DEBUG_DESKTOP
            if (r10 == 0) goto L39
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "id string = "
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.StringBuilder r11 = r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L39:
            int r10 = r8.hashCode()
            switch(r10) {
                case -1496482599: goto L4c;
                case 3355: goto L41;
                default: goto L40;
            }
        L40:
            goto L55
        L41:
            java.lang.String r6 = "id"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L40
            r6 = r1
            goto L56
        L4c:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r10 = r8.equals(r10)
            if (r10 == 0) goto L40
            goto L56
        L55:
            r6 = r7
        L56:
            switch(r6) {
                case 0: goto L5f;
                case 1: goto L5a;
                default: goto L59;
            }
        L59:
            goto L71
        L5a:
            int r4 = r13.getId(r14, r9)
            goto L71
        L5f:
            int r3 = r13.getId(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r13.mConstraintSetIdMap
            java.lang.String r7 = stripID(r9)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            r6.put(r7, r10)
        L71:
            int r5 = r5 + 1
            goto L10
        L74:
            if (r3 == r7) goto L8e
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.mMotionLayout
            int r1 = r1.mDebugPath
            if (r1 == 0) goto L7f
            r0.setValidateOnParse(r6)
        L7f:
            r0.load(r14, r15)
            if (r4 == r7) goto L89
            android.util.SparseIntArray r1 = r13.mDeriveMap
            r1.put(r3, r4)
        L89:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r1 = r13.mConstraintSetMap
            r1.put(r3, r0)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    public ConstraintSet getConstraintSet(Context context, String id) {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + id);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int key = this.mConstraintSetMap.keyAt(i);
            String IdAsString = context.getResources().getResourceName(key);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i + "> is <" + IdAsString + "> looking for <" + id + ">");
            }
            if (id.equals(IdAsString)) {
                return this.mConstraintSetMap.get(key);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int id) {
        return getConstraintSet(id, -1, -1);
    }

    ConstraintSet getConstraintSet(int id, int width, int height) {
        int cid;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + id);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        if (this.mStateSet != null && (cid = this.mStateSet.stateGetConstraintID(id, width, height)) != -1) {
            id = cid;
        }
        if (this.mConstraintSetMap.get(id) == null) {
            Log.e(TAG, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), id) + " In MotionScene");
            return this.mConstraintSetMap.get(this.mConstraintSetMap.keyAt(0));
        }
        return this.mConstraintSetMap.get(id);
    }

    public void setConstraintSet(int id, ConstraintSet set) {
        this.mConstraintSetMap.put(id, set);
    }

    public void getKeyFrames(MotionController motionController) {
        if (this.mCurrentTransition != null) {
            Iterator it = this.mCurrentTransition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                KeyFrames keyFrames = (KeyFrames) it.next();
                keyFrames.addFrames(motionController);
            }
            return;
        }
        if (this.mDefaultTransition != null) {
            Iterator it2 = this.mDefaultTransition.mKeyFramesList.iterator();
            while (it2.hasNext()) {
                KeyFrames keyFrames2 = (KeyFrames) it2.next();
                keyFrames2.addFrames(motionController);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int type, int target, int position) {
        if (this.mCurrentTransition == null) {
            return null;
        }
        Iterator it = this.mCurrentTransition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer integer : keyFrames.getKeys()) {
                if (target == integer.intValue()) {
                    ArrayList<Key> keys = keyFrames.getKeyFramesForView(integer.intValue());
                    Iterator<Key> it2 = keys.iterator();
                    while (it2.hasNext()) {
                        Key key = it2.next();
                        if (key.mFramePosition == position && key.mType == type) {
                            return key;
                        }
                    }
                }
            }
        }
        return null;
    }

    int getTransitionDirection(int stateId) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mConstraintSetStart == stateId) {
                return 0;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int position) {
        if (this.mCurrentTransition == null) {
            return false;
        }
        Iterator it = this.mCurrentTransition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            ArrayList<Key> framePoints = keyFrames.getKeyFramesForView(view.getId());
            Iterator<Key> it2 = framePoints.iterator();
            while (it2.hasNext()) {
                Key framePoint = it2.next();
                if (framePoint.mFramePosition == position) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setKeyframe(View view, int position, String name, Object value) {
        if (this.mCurrentTransition != null) {
            Iterator it = this.mCurrentTransition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                KeyFrames keyFrames = (KeyFrames) it.next();
                ArrayList<Key> framePoints = keyFrames.getKeyFramesForView(view.getId());
                Iterator<Key> it2 = framePoints.iterator();
                while (it2.hasNext()) {
                    Key framePoint = it2.next();
                    if (framePoint.mFramePosition == position) {
                        float v = 0.0f;
                        if (value != null) {
                            v = ((Float) value).floatValue();
                        }
                        if (v == 0.0f) {
                        }
                        name.equalsIgnoreCase("app:PerpendicularPath_percent");
                    }
                }
            }
        }
    }

    public float getPathPercent(View view, int position) {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition transition = it.next();
            if (transition.mTouchResponse != null) {
                return true;
            }
        }
        return (this.mCurrentTransition == null || this.mCurrentTransition.mTouchResponse == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent event, int currentState, MotionLayout motionLayout) {
        RectF cache = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(event);
        if (currentState != -1) {
            boolean z = false;
            switch (event.getAction()) {
                case 0:
                    this.mLastTouchX = event.getRawX();
                    this.mLastTouchY = event.getRawY();
                    this.mLastTouchDown = event;
                    if (this.mCurrentTransition.mTouchResponse != null) {
                        RectF region = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, cache);
                        if (region == null || region.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            RectF region2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, cache);
                            if (region2 != null && !region2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                                this.mMotionOutsideRegion = true;
                            } else {
                                this.mMotionOutsideRegion = false;
                            }
                            this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                            return;
                        }
                        this.mLastTouchDown = null;
                        return;
                    }
                    return;
                case 2:
                    float dy = event.getRawY() - this.mLastTouchY;
                    float dx = event.getRawX() - this.mLastTouchX;
                    if ((dx == 0.0d && dy == 0.0d) || this.mLastTouchDown == null) {
                        return;
                    }
                    Transition transition = bestTransitionFor(currentState, dx, dy, this.mLastTouchDown);
                    if (transition != null) {
                        motionLayout.setTransition(transition);
                        RectF region3 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, cache);
                        if (region3 != null && !region3.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z = true;
                        }
                        this.mMotionOutsideRegion = z;
                        this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                        break;
                    }
                    break;
            }
        }
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(event, this.mVelocityTracker, currentState, this);
        }
        this.mLastTouchX = event.getRawX();
        this.mLastTouchY = event.getRawY();
        if (event.getAction() == 1 && this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            if (motionLayout.mCurrentState != -1) {
                autoTransition(motionLayout, motionLayout.mCurrentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollMove(float dx, float dy) {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollMove(dx, dy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processScrollUp(float dx, float dy) {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.scrollUp(dx, dy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgressDirection(float dx, float dy) {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getProgressDirection(dx, dy);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStartId() {
        if (this.mCurrentTransition != null) {
            return this.mCurrentTransition.mConstraintSetStart;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndId() {
        if (this.mCurrentTransition != null) {
            return this.mCurrentTransition.mConstraintSetEnd;
        }
        return -1;
    }

    public Interpolator getInterpolator() {
        switch (this.mCurrentTransition.mDefaultInterpolator) {
            case -2:
                return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
            case -1:
                final Easing easing = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float v) {
                        return (float) easing.get(v);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new AnticipateInterpolator();
            case 5:
                return new BounceInterpolator();
            default:
                return null;
        }
    }

    public int getDuration() {
        if (this.mCurrentTransition != null) {
            return this.mCurrentTransition.mDuration;
        }
        return this.mDefaultDuration;
    }

    public void setDuration(int duration) {
        if (this.mCurrentTransition != null) {
            this.mCurrentTransition.setDuration(duration);
        } else {
            this.mDefaultDuration = duration;
        }
    }

    public int gatPathMotionArc() {
        if (this.mCurrentTransition != null) {
            return this.mCurrentTransition.mPathMotionArc;
        }
        return -1;
    }

    public float getStaggered() {
        if (this.mCurrentTransition != null) {
            return this.mCurrentTransition.mStagger;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getMaxVelocity() {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupTouch() {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.setupTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
            return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int key = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(key)) {
                Log.e(TAG, "Cannot be derived from yourself");
                return;
            }
            readConstraintChain(key);
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            ConstraintSet cs = this.mConstraintSetMap.valueAt(i2);
            cs.readFallback(motionLayout);
        }
    }

    private boolean hasCycleDependency(int key) {
        int derived = this.mDeriveMap.get(key);
        int len = this.mDeriveMap.size();
        while (derived > 0) {
            if (derived == key) {
                return true;
            }
            int len2 = len - 1;
            if (len < 0) {
                return true;
            }
            derived = this.mDeriveMap.get(derived);
            len = len2;
        }
        return false;
    }

    private void readConstraintChain(int key) {
        int derivedFromId = this.mDeriveMap.get(key);
        if (derivedFromId > 0) {
            readConstraintChain(this.mDeriveMap.get(key));
            ConstraintSet cs = this.mConstraintSetMap.get(key);
            ConstraintSet derivedFrom = this.mConstraintSetMap.get(derivedFromId);
            if (derivedFrom == null) {
                Log.e(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), derivedFromId));
            } else {
                cs.readFallback(derivedFrom);
                this.mDeriveMap.put(key, -1);
            }
        }
    }

    public static String stripID(String id) {
        if (id == null) {
            return "";
        }
        int index = id.indexOf(47);
        if (index < 0) {
            return id;
        }
        return id.substring(index + 1);
    }

    public int lookUpConstraintId(String id) {
        return this.mConstraintSetIdMap.get(id).intValue();
    }

    public String lookUpConstraintName(int id) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            if (entry.getValue().intValue() == id) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void disableAutoTransition(boolean disable) {
        this.mDisableAutoTransition = disable;
    }
}
