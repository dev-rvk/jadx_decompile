package androidx.compose.ui.text.input;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MathUtils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\bø\u0001\u0000\u001a\"\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int $this$addExactOrElse, int right, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int result = $this$addExactOrElse + right;
        return (($this$addExactOrElse ^ result) & (right ^ result)) < 0 ? defaultValue.invoke().intValue() : result;
    }

    public static final int subtractExactOrElse(int $this$subtractExactOrElse, int right, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int result = $this$subtractExactOrElse - right;
        return (($this$subtractExactOrElse ^ right) & ($this$subtractExactOrElse ^ result)) < 0 ? defaultValue.invoke().intValue() : result;
    }
}
