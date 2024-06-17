package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontUtils.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"AndroidBold", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "getAndroidBold", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/ui/text/font/FontWeight;", "getAndroidTypefaceStyle", "", "fontWeight", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getAndroidTypefaceStyle-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)I", "isBold", "", "isItalic", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidFontUtils_androidKt {
    public static final FontWeight getAndroidBold(FontWeight.Companion $this$AndroidBold) {
        Intrinsics.checkNotNullParameter($this$AndroidBold, "<this>");
        return $this$AndroidBold.getW600();
    }

    /* renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
    public static final int m4775getAndroidTypefaceStyleFO1MlWM(FontWeight fontWeight, int fontStyle) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        boolean isBold = fontWeight.compareTo(getAndroidBold(FontWeight.INSTANCE)) >= 0;
        boolean isItalic = FontStyle.m4821equalsimpl0(fontStyle, FontStyle.INSTANCE.m4825getItalic_LCdwA());
        return getAndroidTypefaceStyle(isBold, isItalic);
    }

    public static final int getAndroidTypefaceStyle(boolean isBold, boolean isItalic) {
        if (isItalic && isBold) {
            return 3;
        }
        if (isBold) {
            return 1;
        }
        if (isItalic) {
            return 2;
        }
        return 0;
    }
}
