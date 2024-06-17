package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingValues;", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)V", "getInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class InsetsPaddingValues implements PaddingValues {
    private final Density density;
    private final WindowInsets insets;

    public InsetsPaddingValues(WindowInsets insets, Density density) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(density, "density");
        this.insets = insets;
        this.density = density;
    }

    public final WindowInsets getInsets() {
        return this.insets;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float mo435calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density $this$calculateLeftPadding_u2uoSUM_u24lambda_u240 = this.density;
        return $this$calculateLeftPadding_u2uoSUM_u24lambda_u240.mo326toDpu2uoSUM(this.insets.getLeft($this$calculateLeftPadding_u2uoSUM_u24lambda_u240, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float getTop() {
        Density $this$calculateTopPadding_D9Ej5fM_u24lambda_u241 = this.density;
        return $this$calculateTopPadding_D9Ej5fM_u24lambda_u241.mo326toDpu2uoSUM(this.insets.getTop($this$calculateTopPadding_D9Ej5fM_u24lambda_u241));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float mo436calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density $this$calculateRightPadding_u2uoSUM_u24lambda_u242 = this.density;
        return $this$calculateRightPadding_u2uoSUM_u24lambda_u242.mo326toDpu2uoSUM(this.insets.getRight($this$calculateRightPadding_u2uoSUM_u24lambda_u242, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float getBottom() {
        Density $this$calculateBottomPadding_D9Ej5fM_u24lambda_u243 = this.density;
        return $this$calculateBottomPadding_D9Ej5fM_u24lambda_u243.mo326toDpu2uoSUM(this.insets.getBottom($this$calculateBottomPadding_D9Ej5fM_u24lambda_u243));
    }

    public String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InsetsPaddingValues) {
            return Intrinsics.areEqual(this.insets, ((InsetsPaddingValues) other).insets) && Intrinsics.areEqual(this.density, ((InsetsPaddingValues) other).density);
        }
        return false;
    }

    public int hashCode() {
        int result = this.insets.hashCode();
        return (result * 31) + this.density.hashCode();
    }
}
