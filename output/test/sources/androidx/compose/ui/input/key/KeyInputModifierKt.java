package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyInputModifier.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002ø\u0001\u0000\u001a!\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"onKeyEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KeyInputModifierKt {
    public static final Modifier onKeyEvent(Modifier $this$onKeyEvent, Function1<? super KeyEvent, Boolean> onKeyEvent) {
        Intrinsics.checkNotNullParameter($this$onKeyEvent, "<this>");
        Intrinsics.checkNotNullParameter(onKeyEvent, "onKeyEvent");
        return $this$onKeyEvent.then(new KeyInputElement(onKeyEvent, null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier $this$onPreviewKeyEvent, Function1<? super KeyEvent, Boolean> onPreviewKeyEvent) {
        Intrinsics.checkNotNullParameter($this$onPreviewKeyEvent, "<this>");
        Intrinsics.checkNotNullParameter(onPreviewKeyEvent, "onPreviewKeyEvent");
        return $this$onPreviewKeyEvent.then(new KeyInputElement(null, onPreviewKeyEvent));
    }
}
