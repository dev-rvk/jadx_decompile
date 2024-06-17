package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Swipeable.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/SwipeProgress;", "T", "", "from", "to", "fraction", "", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFraction", "()F", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwipeProgress<T> {
    private final float fraction;
    private final T from;
    private final T to;

    public SwipeProgress(T t, T t2, float fraction) {
        this.from = t;
        this.to = t2;
        this.fraction = fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.to;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SwipeProgress) && Intrinsics.areEqual(this.from, ((SwipeProgress) other).from) && Intrinsics.areEqual(this.to, ((SwipeProgress) other).to)) {
            return (this.fraction > ((SwipeProgress) other).fraction ? 1 : (this.fraction == ((SwipeProgress) other).fraction ? 0 : -1)) == 0;
        }
        return false;
    }

    public int hashCode() {
        T t = this.from;
        int result = t != null ? t.hashCode() : 0;
        int i = result * 31;
        T t2 = this.to;
        int result2 = i + (t2 != null ? t2.hashCode() : 0);
        return (result2 * 31) + Float.hashCode(this.fraction);
    }

    public String toString() {
        return "SwipeProgress(from=" + this.from + ", to=" + this.to + ", fraction=" + this.fraction + ')';
    }
}
