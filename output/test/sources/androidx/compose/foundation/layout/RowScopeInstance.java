package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Row.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0017J\f\u0010\u000e\u001a\u00020\u0004*\u00020\u0004H\u0017J\u001c\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/RowScopeInstance;", "Landroidx/compose/foundation/layout/RowScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RowScopeInstance implements RowScope {
    public static final RowScopeInstance INSTANCE = new RowScopeInstance();

    private RowScopeInstance() {
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier weight(Modifier $this$weight, float weight, boolean fill) {
        Intrinsics.checkNotNullParameter($this$weight, "<this>");
        if (!(((double) weight) > 0.0d)) {
            throw new IllegalArgumentException(("invalid weight " + weight + "; must be greater than zero").toString());
        }
        return $this$weight.then(new LayoutWeightElement(weight, fill));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier align(Modifier $this$align, Alignment.Vertical alignment) {
        Intrinsics.checkNotNullParameter($this$align, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return $this$align.then(new VerticalAlignElement(alignment));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier $this$alignBy, HorizontalAlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter($this$alignBy, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return $this$alignBy.then(new WithAlignmentLineElement(alignmentLine));
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignByBaseline(Modifier $this$alignByBaseline) {
        Intrinsics.checkNotNullParameter($this$alignByBaseline, "<this>");
        return alignBy($this$alignByBaseline, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public Modifier alignBy(Modifier $this$alignBy, Function1<? super Measured, Integer> alignmentLineBlock) {
        Intrinsics.checkNotNullParameter($this$alignBy, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLineBlock, "alignmentLineBlock");
        return $this$alignBy.then(new WithAlignmentLineBlockElement(alignmentLineBlock));
    }
}
