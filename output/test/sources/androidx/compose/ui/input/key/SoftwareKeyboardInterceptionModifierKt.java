package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoftwareKeyboardInterceptionModifier.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007ø\u0001\u0000\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"onInterceptKeyBeforeSoftKeyboard", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreInterceptKeyBeforeSoftKeyboard", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SoftwareKeyboardInterceptionModifierKt {
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(Modifier $this$onInterceptKeyBeforeSoftKeyboard, Function1<? super KeyEvent, Boolean> onInterceptKeyBeforeSoftKeyboard) {
        Intrinsics.checkNotNullParameter($this$onInterceptKeyBeforeSoftKeyboard, "<this>");
        Intrinsics.checkNotNullParameter(onInterceptKeyBeforeSoftKeyboard, "onInterceptKeyBeforeSoftKeyboard");
        return $this$onInterceptKeyBeforeSoftKeyboard.then(new SoftKeyboardInterceptionElement(onInterceptKeyBeforeSoftKeyboard, null));
    }

    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(Modifier $this$onPreInterceptKeyBeforeSoftKeyboard, Function1<? super KeyEvent, Boolean> onPreInterceptKeyBeforeSoftKeyboard) {
        Intrinsics.checkNotNullParameter($this$onPreInterceptKeyBeforeSoftKeyboard, "<this>");
        Intrinsics.checkNotNullParameter(onPreInterceptKeyBeforeSoftKeyboard, "onPreInterceptKeyBeforeSoftKeyboard");
        return $this$onPreInterceptKeyBeforeSoftKeyboard.then(new SoftKeyboardInterceptionElement(null, onPreInterceptKeyBeforeSoftKeyboard));
    }
}
