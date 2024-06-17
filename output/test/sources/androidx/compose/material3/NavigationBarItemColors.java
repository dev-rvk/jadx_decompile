package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BB\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019R\u0019\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u001d\u0010\f\u001a\u00020\u00038@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "(JJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "indicatorColor", "getIndicatorColor-0d7_KjU$material3_release", "()J", "equals", "", "other", "hashCode", "", "iconColor", "Landroidx/compose/runtime/State;", "selected", "enabled", "iconColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "textColor", "textColor$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7);
    }

    private NavigationBarItemColors(long selectedIconColor, long selectedTextColor, long selectedIndicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor) {
        this.selectedIconColor = selectedIconColor;
        this.selectedTextColor = selectedTextColor;
        this.selectedIndicatorColor = selectedIndicatorColor;
        this.unselectedIconColor = unselectedIconColor;
        this.unselectedTextColor = unselectedTextColor;
        this.disabledIconColor = disabledIconColor;
        this.disabledTextColor = disabledTextColor;
    }

    public final State<Color> iconColor$material3_release(boolean selected, boolean enabled, Composer $composer, int $changed) {
        long targetValue;
        $composer.startReplaceableGroup(-1012982249);
        ComposerKt.sourceInformation($composer, "C(iconColor)P(1)356@15817L132:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1012982249, $changed, -1, "androidx.compose.material3.NavigationBarItemColors.iconColor (NavigationBar.kt:350)");
        }
        if (enabled) {
            targetValue = selected ? this.selectedIconColor : this.unselectedIconColor;
        } else {
            targetValue = this.disabledIconColor;
        }
        State<Color> m72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(targetValue, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m72animateColorAsStateeuL9pac;
    }

    public final State<Color> textColor$material3_release(boolean selected, boolean enabled, Composer $composer, int $changed) {
        long targetValue;
        $composer.startReplaceableGroup(-1833866293);
        ComposerKt.sourceInformation($composer, "C(textColor)P(1)375@16447L132:NavigationBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1833866293, $changed, -1, "androidx.compose.material3.NavigationBarItemColors.textColor (NavigationBar.kt:369)");
        }
        if (enabled) {
            targetValue = selected ? this.selectedTextColor : this.unselectedTextColor;
        } else {
            targetValue = this.disabledTextColor;
        }
        State<Color> m72animateColorAsStateeuL9pac = SingleValueAnimationKt.m72animateColorAsStateeuL9pac(targetValue, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, $composer, 48, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return m72animateColorAsStateeuL9pac;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other != null && (other instanceof NavigationBarItemColors) && Color.m2950equalsimpl0(this.selectedIconColor, ((NavigationBarItemColors) other).selectedIconColor) && Color.m2950equalsimpl0(this.unselectedIconColor, ((NavigationBarItemColors) other).unselectedIconColor) && Color.m2950equalsimpl0(this.selectedTextColor, ((NavigationBarItemColors) other).selectedTextColor) && Color.m2950equalsimpl0(this.unselectedTextColor, ((NavigationBarItemColors) other).unselectedTextColor) && Color.m2950equalsimpl0(this.selectedIndicatorColor, ((NavigationBarItemColors) other).selectedIndicatorColor) && Color.m2950equalsimpl0(this.disabledIconColor, ((NavigationBarItemColors) other).disabledIconColor) && Color.m2950equalsimpl0(this.disabledTextColor, ((NavigationBarItemColors) other).disabledTextColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Color.m2956hashCodeimpl(this.selectedIconColor);
        return (((((((((((result * 31) + Color.m2956hashCodeimpl(this.unselectedIconColor)) * 31) + Color.m2956hashCodeimpl(this.selectedTextColor)) * 31) + Color.m2956hashCodeimpl(this.unselectedTextColor)) * 31) + Color.m2956hashCodeimpl(this.selectedIndicatorColor)) * 31) + Color.m2956hashCodeimpl(this.disabledIconColor)) * 31) + Color.m2956hashCodeimpl(this.disabledTextColor);
    }
}
