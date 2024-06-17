package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.font.FontVariation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformTypefaces.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u001a \u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¨\u0006\r"}, d2 = {"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "getWeightSuffixForFallbackFamilyName", "", HintConstants.AUTOFILL_HINT_NAME, "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PlatformTypefacesKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }
        return new PlatformTypefacesApi();
    }

    public static final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface $this$setFontVariationSettings, FontVariation.Settings variationSettings, Context context) {
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceCompatApi26.INSTANCE.setFontVariationSettings($this$setFontVariationSettings, variationSettings, context);
        }
        return $this$setFontVariationSettings;
    }

    public static final String getWeightSuffixForFallbackFamilyName(String name, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        int weight = fontWeight.getWeight() / 100;
        if (weight >= 0 && weight < 2) {
            return name + "-thin";
        }
        if (2 <= weight && weight < 4) {
            return name + "-light";
        }
        if (weight != 4) {
            if (weight == 5) {
                return name + "-medium";
            }
            if (!(6 <= weight && weight < 8)) {
                if (8 <= weight && weight < 11) {
                    return name + "-black";
                }
            }
        }
        return name;
    }
}
