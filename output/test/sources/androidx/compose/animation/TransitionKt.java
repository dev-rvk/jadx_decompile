package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0088\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0002\b\u0014H\u0087\bø\u0001\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u0082\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "label", "", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TransitionKt {
    public static final <S> State<Color> animateColor(Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> function3, String label, Function3<? super S, ? super Composer, ? super Integer, Color> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(targetValueByState, "targetValueByState");
        $composer.startReplaceableGroup(-1939694975);
        ComposerKt.sourceInformation($composer, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        Function3 transitionSpec = (i & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Color>>() { // from class: androidx.compose.animation.TransitionKt$animateColor$1
            public final SpringSpec<Color> invoke(Transition.Segment<S> segment, Composer $composer2, int $changed2) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                $composer2.startReplaceableGroup(-1457805428);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1457805428, $changed2, -1, "androidx.compose.animation.animateColor.<anonymous> (Transition.kt:64)");
                }
                SpringSpec<Color> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Color> invoke(Object p1, Composer composer, Integer num) {
                return invoke((Transition.Segment) p1, composer, num.intValue());
            }
        } : function3;
        if ((i & 2) == 0) {
            label2 = label;
        } else {
            label2 = "ColorAnimation";
        }
        ColorSpace colorSpace = Color.m2953getColorSpaceimpl(targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed >> 6) & 112)).m2959unboximpl());
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(colorSpace);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpace);
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        TwoWayConverter typeConverter = (TwoWayConverter) value$iv$iv;
        int $changed$iv = ($changed & 14) | 64 | (($changed << 3) & 896) | (($changed << 3) & 7168) | (($changed << 3) & 57344);
        $composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation($composer, "CC(animateValue)P(3,2)857@34142L32,858@34197L31,859@34253L23,861@34289L89:Transition.kt#pdpnli");
        Object initialValue$iv = targetValueByState.invoke(transition.getCurrentState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        Object targetValue$iv = targetValueByState.invoke(transition.getTargetState(), $composer, Integer.valueOf(($changed$iv >> 9) & 112));
        FiniteAnimationSpec<Color> animationSpec$iv = transitionSpec.invoke(transition.getSegment(), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        State<Color> createTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, initialValue$iv, targetValue$iv, animationSpec$iv, typeConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (458752 & ($changed$iv << 6)));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    /* renamed from: animateColor-DTcfvLk, reason: not valid java name */
    public static final State<Color> m82animateColorDTcfvLk(InfiniteTransition animateColor, long initialValue, long targetValue, InfiniteRepeatableSpec<Color> animationSpec, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(1901963533);
        ComposerKt.sourceInformation($composer, "C(animateColor)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color)102@4596L72,105@4680L72:Transition.kt#xbi5r1");
        String label2 = (i & 8) != 0 ? "ColorAnimation" : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1901963533, $changed, -1, "androidx.compose.animation.animateColor (Transition.kt:96)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m2953getColorSpaceimpl(targetValue));
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        TwoWayConverter converter = (TwoWayConverter) value$iv$iv;
        State<Color> animateValue = InfiniteTransitionKt.animateValue(animateColor, Color.m2939boximpl(initialValue), Color.m2939boximpl(targetValue), converter, animationSpec, label2, $composer, InfiniteTransition.$stable | 4096 | ($changed & 14) | ($changed & 112) | ($changed & 896) | (InfiniteRepeatableSpec.$stable << 12) | (($changed << 3) & 57344) | (458752 & ($changed << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    /* renamed from: animateColor-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ State m83animateColorRIQooxk(InfiniteTransition animateColor, long initialValue, long targetValue, InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        $composer.startReplaceableGroup(1400583834);
        ComposerKt.sourceInformation($composer, "C(animateColor)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color)117@5040L143:Transition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400583834, $changed, -1, "androidx.compose.animation.animateColor (Transition.kt:113)");
        }
        State<Color> m82animateColorDTcfvLk = m82animateColorDTcfvLk(animateColor, initialValue, targetValue, animationSpec, "ColorAnimation", $composer, InfiniteTransition.$stable | 24576 | ($changed & 14) | ($changed & 112) | ($changed & 896) | (InfiniteRepeatableSpec.$stable << 9) | ($changed & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m82animateColorDTcfvLk;
    }
}
