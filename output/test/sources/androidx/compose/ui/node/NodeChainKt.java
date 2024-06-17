package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ActualKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: NodeChain.kt */
@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0002\u001a$\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0015"}, d2 = {"ActionReplace", "", "ActionReuse", "ActionUpdate", "SentinelHead", "androidx/compose/ui/node/NodeChainKt$SentinelHead$1", "Landroidx/compose/ui/node/NodeChainKt$SentinelHead$1;", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "updateUnsafe", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;
    private static final NodeChainKt$SentinelHead$1 SentinelHead;

    public static final /* synthetic */ MutableVector access$fillVector(Modifier $receiver, MutableVector result) {
        return fillVector($receiver, result);
    }

    public static final /* synthetic */ NodeChainKt$SentinelHead$1 access$getSentinelHead$p() {
        return SentinelHead;
    }

    public static final /* synthetic */ void access$updateUnsafe(ModifierNodeElement $receiver, Modifier.Node node) {
        updateUnsafe($receiver, node);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.node.NodeChainKt$SentinelHead$1] */
    static {
        ?? r0 = new Modifier.Node() { // from class: androidx.compose.ui.node.NodeChainKt$SentinelHead$1
            public String toString() {
                return "<Head>";
            }
        };
        r0.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = r0;
    }

    public static final int actionForModifiers(Modifier.Element prev, Modifier.Element next) {
        Intrinsics.checkNotNullParameter(prev, "prev");
        Intrinsics.checkNotNullParameter(next, "next");
        if (Intrinsics.areEqual(prev, next)) {
            return 2;
        }
        if (ActualKt.areObjectsOfSameType(prev, next)) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Modifier.Node> void updateUnsafe(ModifierNodeElement<T> modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        modifierNodeElement.update(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MutableVector<Modifier.Element> fillVector(Modifier $this$fillVector, final MutableVector<Modifier.Element> mutableVector) {
        int capacity = RangesKt.coerceAtLeast(mutableVector.getSize(), 16);
        MutableVector it = new MutableVector(new Modifier[capacity], 0);
        it.add($this$fillVector);
        while (it.isNotEmpty()) {
            Modifier next = (Modifier) it.removeAt(it.getSize() - 1);
            if (next instanceof CombinedModifier) {
                it.add(((CombinedModifier) next).getInner());
                it.add(((CombinedModifier) next).getOuter());
            } else if (next instanceof Modifier.Element) {
                mutableVector.add(next);
            } else {
                next.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt$fillVector$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Modifier.Element it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        mutableVector.add(it2);
                        return true;
                    }
                });
            }
        }
        return mutableVector;
    }
}
