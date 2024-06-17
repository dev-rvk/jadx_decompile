package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OneDimensionalFocusSearch.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Lkotlin/Comparator;", "()V", "compare", "", "focusTarget1", "focusTarget2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetNode focusTarget1, FocusTargetNode focusTarget2) {
        if (focusTarget1 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (focusTarget2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (!FocusTraversalKt.isEligibleForFocusSearch(focusTarget1) || !FocusTraversalKt.isEligibleForFocusSearch(focusTarget2)) {
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget1)) {
                return -1;
            }
            return FocusTraversalKt.isEligibleForFocusSearch(focusTarget2) ? 1 : 0;
        }
        NodeCoordinator coordinator$ui_release = focusTarget1.getCoordinator();
        LayoutNode layoutNode1 = coordinator$ui_release != null ? coordinator$ui_release.getLayoutNode() : null;
        if (layoutNode1 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        NodeCoordinator coordinator$ui_release2 = focusTarget2.getCoordinator();
        LayoutNode layoutNode = coordinator$ui_release2 != null ? coordinator$ui_release2.getLayoutNode() : null;
        if (layoutNode == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        LayoutNode layoutNode2 = layoutNode;
        if (Intrinsics.areEqual(layoutNode1, layoutNode2)) {
            return 0;
        }
        MutableVector pathFromRoot1 = pathFromRoot(layoutNode1);
        MutableVector pathFromRoot2 = pathFromRoot(layoutNode2);
        int depth = 0;
        int min = Math.min(pathFromRoot1.getSize() - 1, pathFromRoot2.getSize() - 1);
        if (0 <= min) {
            while (Intrinsics.areEqual(pathFromRoot1.getContent()[depth], pathFromRoot2.getContent()[depth])) {
                if (depth != min) {
                    depth++;
                }
            }
            return Intrinsics.compare(pathFromRoot1.getContent()[depth].getPlaceOrder$ui_release(), pathFromRoot2.getContent()[depth].getPlaceOrder$ui_release());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector path = new MutableVector(new LayoutNode[16], 0);
        for (LayoutNode current = layoutNode; current != null; current = current.getParent$ui_release()) {
            path.add(0, current);
        }
        return path;
    }
}
