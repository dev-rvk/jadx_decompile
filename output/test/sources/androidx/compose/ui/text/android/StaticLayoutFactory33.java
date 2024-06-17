package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory33;", "", "()V", "isFallbackLineSpacingEnabled", "", "layout", "Landroid/text/StaticLayout;", "setLineBreakConfig", "", "builder", "Landroid/text/StaticLayout$Builder;", "lineBreakStyle", "", "lineBreakWordStyle", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    @JvmStatic
    public static final boolean isFallbackLineSpacingEnabled(StaticLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        return layout.isFallbackLineSpacingEnabled();
    }

    @JvmStatic
    public static final void setLineBreakConfig(StaticLayout.Builder builder, int lineBreakStyle, int lineBreakWordStyle) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        LineBreakConfig lineBreakConfig = new LineBreakConfig.Builder().setLineBreakStyle(lineBreakStyle).setLineBreakWordStyle(lineBreakWordStyle).build();
        Intrinsics.checkNotNullExpressionValue(lineBreakConfig, "Builder()\n              …\n                .build()");
        builder.setLineBreakConfig(lineBreakConfig);
    }
}