package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplineBasedFloatDecayAnimationSpec.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a!\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\f"}, d2 = {"platformFlingScrollFriction", "", "getPlatformFlingScrollFriction", "()F", "rememberSplineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "splineBasedDecayDeprecated", "density", "Landroidx/compose/ui/unit/Density;", "splineBasedDecay", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SplineBasedFloatDecayAnimationSpec_androidKt {
    private static final float platformFlingScrollFriction = ViewConfiguration.getScrollFriction();

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common code")
    public static final /* synthetic */ DecayAnimationSpec splineBasedDecay(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return SplineBasedDecayKt.splineBasedDecay(density);
    }

    public static final float getPlatformFlingScrollFriction() {
        return platformFlingScrollFriction;
    }

    public static final <T> DecayAnimationSpec<T> rememberSplineBasedDecay(Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(904445851);
        ComposerKt.sourceInformation($composer, "C(rememberSplineBasedDecay)43@1746L7,44@1765L114:SplineBasedFloatDecayAnimationSpec.android.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(904445851, $changed, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        Object key1$iv = Float.valueOf(density.getDensity());
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(key1$iv);
        Object it$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
            $composer.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        DecayAnimationSpec<T> decayAnimationSpec = (DecayAnimationSpec) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return decayAnimationSpec;
    }
}
