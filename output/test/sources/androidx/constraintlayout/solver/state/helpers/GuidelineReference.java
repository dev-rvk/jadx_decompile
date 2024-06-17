package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

/* loaded from: classes.dex */
public class GuidelineReference implements Reference {
    private Object key;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    final State mState;
    private int mStart = -1;
    private int mEnd = -1;
    private float mPercent = 0.0f;

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setKey(Object key) {
        this.key = key;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public Object getKey() {
        return this.key;
    }

    public GuidelineReference(State state) {
        this.mState = state;
    }

    public void start(Object margin) {
        this.mStart = this.mState.convertDimension(margin);
        this.mEnd = -1;
        this.mPercent = 0.0f;
    }

    public void end(Object margin) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(margin);
        this.mPercent = 0.0f;
    }

    public void percent(float percent) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = percent;
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        if (this.mStart != -1) {
            this.mGuidelineWidget.setGuideBegin(this.mStart);
        } else if (this.mEnd != -1) {
            this.mGuidelineWidget.setGuideEnd(this.mEnd);
        } else {
            this.mGuidelineWidget.setGuidePercent(this.mPercent);
        }
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget == null) {
            this.mGuidelineWidget = new Guideline();
        }
        return this.mGuidelineWidget;
    }

    @Override // androidx.constraintlayout.solver.state.Reference
    public void setConstraintWidget(ConstraintWidget widget) {
        if (widget instanceof Guideline) {
            this.mGuidelineWidget = (Guideline) widget;
        } else {
            this.mGuidelineWidget = null;
        }
    }
}
