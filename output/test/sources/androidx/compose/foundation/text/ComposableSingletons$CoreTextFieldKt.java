package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ComposableSingletons$CoreTextFieldKt {
    public static final ComposableSingletons$CoreTextFieldKt INSTANCE = new ComposableSingletons$CoreTextFieldKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f4lambda1 = ComposableLambdaKt.composableLambdaInstance(671295101, false, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
            ComposerKt.sourceInformation($composer, "C200@11235L16:CoreTextField.kt#423gt5");
            int $dirty = $changed;
            if (($changed & 14) == 0) {
                $dirty |= $composer.changedInstance(innerTextField) ? 4 : 2;
            }
            if (($dirty & 91) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(671295101, $dirty, -1, "androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.lambda-1.<anonymous> (CoreTextField.kt:200)");
            }
            innerTextField.invoke($composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$foundation_release, reason: not valid java name */
    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m758getLambda1$foundation_release() {
        return f4lambda1;
    }
}
