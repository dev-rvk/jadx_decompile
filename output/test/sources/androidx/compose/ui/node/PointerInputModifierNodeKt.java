package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInputModifierNode.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"isAttached", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PointerInputModifierNodeKt {
    public static final boolean isAttached(PointerInputModifierNode $this$isAttached) {
        Intrinsics.checkNotNullParameter($this$isAttached, "<this>");
        return $this$isAttached.getNode().getIsAttached();
    }

    public static final LayoutCoordinates getLayoutCoordinates(PointerInputModifierNode $this$layoutCoordinates) {
        Intrinsics.checkNotNullParameter($this$layoutCoordinates, "<this>");
        return DelegatableNodeKt.m4299requireCoordinator64DMado($this$layoutCoordinates, NodeKind.m4400constructorimpl(16));
    }
}
