package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NestedScrollModifier.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NestedScrollModifierKt {
    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }

    public static final Modifier nestedScroll(Modifier $this$nestedScroll, NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter($this$nestedScroll, "<this>");
        Intrinsics.checkNotNullParameter(connection, "connection");
        return $this$nestedScroll.then(new NestedScrollElement(connection, dispatcher));
    }
}
