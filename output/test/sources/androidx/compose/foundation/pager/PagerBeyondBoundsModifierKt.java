package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerBeyondBoundsModifier.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"pagerBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondBoundsPageCount", "", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;IZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PagerBeyondBoundsModifierKt {
    public static final Modifier pagerBeyondBoundsModifier(Modifier $this$pagerBeyondBoundsModifier, PagerState state, int beyondBoundsPageCount, boolean reverseLayout, Orientation orientation, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$pagerBeyondBoundsModifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        $composer.startReplaceableGroup(633480912);
        ComposerKt.sourceInformation($composer, "C(pagerBeyondBoundsModifier)P(3!1,2)39@1577L7,40@1606L374:PagerBeyondBoundsModifier.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(633480912, $changed, -1, "androidx.compose.foundation.pager.pagerBeyondBoundsModifier (PagerBeyondBoundsModifier.kt:33)");
        }
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume;
        Object[] keys$iv = {state, Integer.valueOf(beyondBoundsPageCount), Boolean.valueOf(reverseLayout), layoutDirection, orientation};
        $composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= $composer.changed(key$iv);
        }
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new LazyLayoutBeyondBoundsModifierLocal(new PagerBeyondBoundsState(state, beyondBoundsPageCount), state.getBeyondBoundsInfo(), reverseLayout, layoutDirection, orientation);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        Modifier then = $this$pagerBeyondBoundsModifier.then((Modifier) value$iv$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
