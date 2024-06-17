package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraphLayoutCache.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0016\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001eJ%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020\u001eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103J#\u00104\u001a\u00020\u000b2\u0006\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\b\u00107\u001a\u000208H\u0002J\u000e\u00109\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001eJ\u001d\u0010:\u001a\u00020\r2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u000e\u0010=\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001eJ\u0010\u0010>\u001a\u00020(2\u0006\u0010-\u001a\u00020\u001eH\u0002J-\u0010)\u001a\u00020 2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020/H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJa\u0010C\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ+\u0010F\u001a\u00020\u000b*\u0004\u0018\u00010 2\u0006\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020\u001eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010!\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b*\u0010#\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006I"}, d2 = {"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cachedIntrinsicHeight", "cachedIntrinsicHeightInputWidth", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "()Landroidx/compose/ui/text/TextLayoutResult;", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "I", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "textLayoutResult", "getTextLayoutResult", "intrinsicHeight", "width", "layoutDirection", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layoutWithConstraints", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "", "maxIntrinsicWidth", "maxWidth", "maxWidth-BRTryo0", "(J)I", "minIntrinsicWidth", "setLayoutDirection", "finalConstraints", "multiParagraph", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "update", "update-ZNqEYIc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;)V", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MultiParagraphLayoutCache {
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private TextLayoutResult layoutCache;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, i, z, i2, i3, list);
    }

    private MultiParagraphLayoutCache(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> list) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = list;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public /* synthetic */ MultiParagraphLayoutCache(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i4 & 8) != 0 ? TextOverflow.INSTANCE.m5137getClipgIe3tQ8() : i, (i4 & 16) != 0 ? true : z, (i4 & 32) != 0 ? Integer.MAX_VALUE : i2, (i4 & 64) != 0 ? 1 : i3, (i4 & 128) != 0 ? null : list, null);
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density value) {
        Density localField = this.density;
        if (localField == null) {
            this.density = value;
            return;
        }
        if (value == null) {
            this.density = value;
            markDirty();
            return;
        }
        if (localField.getDensity() == value.getDensity()) {
            if (localField.getFontScale() == value.getFontScale()) {
                return;
            }
        }
        this.density = value;
        markDirty();
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult textLayoutResult = this.layoutCache;
        if (textLayoutResult != null) {
            return textLayoutResult;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    /* renamed from: getLayoutOrNull, reason: from getter */
    public final TextLayoutResult getLayoutCache() {
        return this.layoutCache;
    }

    /* renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m852layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        long finalConstraints;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (this.minLines > 1) {
            MinLinesConstrainer.Companion companion = MinLinesConstrainer.INSTANCE;
            MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
            TextStyle textStyle = this.style;
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            MinLinesConstrainer localMin = companion.from(minLinesConstrainer, layoutDirection, textStyle, density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = localMin;
            finalConstraints = localMin.m846coerceMinLinesOh53vG4$foundation_release(constraints, this.minLines);
        } else {
            finalConstraints = constraints;
        }
        if (!m850newLayoutWillBeDifferentVKLhPVY(this.layoutCache, finalConstraints, layoutDirection)) {
            TextLayoutResult textLayoutResult = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult);
            if (Constraints.m5167equalsimpl0(finalConstraints, textLayoutResult.getLayoutInput().getConstraints())) {
                return false;
            }
            TextLayoutResult textLayoutResult2 = this.layoutCache;
            Intrinsics.checkNotNull(textLayoutResult2);
            this.layoutCache = m851textLayoutResultVKLhPVY(layoutDirection, finalConstraints, textLayoutResult2.getMultiParagraph());
            return true;
        }
        MultiParagraph multiParagraph = m848layoutTextK40F9xA(finalConstraints, layoutDirection);
        this.layoutCache = m851textLayoutResultVKLhPVY(layoutDirection, finalConstraints, multiParagraph);
        return true;
    }

    /* renamed from: textLayoutResult-VKLhPVY, reason: not valid java name */
    private final TextLayoutResult m851textLayoutResultVKLhPVY(LayoutDirection layoutDirection, long finalConstraints, MultiParagraph multiParagraph) {
        AnnotatedString annotatedString = this.text;
        TextStyle textStyle = this.style;
        List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        int i = this.maxLines;
        boolean z = this.softWrap;
        int i2 = this.overflow;
        Density density = this.density;
        Intrinsics.checkNotNull(density);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, textStyle, list, i, z, i2, density, layoutDirection, this.fontFamilyResolver, finalConstraints, (DefaultConstructorMarker) null), multiParagraph, ConstraintsKt.m5185constrain4WqzIAM(finalConstraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(multiParagraph.getWidth()), TextDelegateKt.ceilToIntPx(multiParagraph.getHeight()))), null);
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int localWidth = this.cachedIntrinsicHeightInputWidth;
        int localHeght = this.cachedIntrinsicHeight;
        if (width == localWidth && localWidth != -1) {
            return localHeght;
        }
        int result = TextDelegateKt.ceilToIntPx(m848layoutTextK40F9xA(ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = result;
        return result;
    }

    /* renamed from: update-ZNqEYIc, reason: not valid java name */
    public final void m853updateZNqEYIc(AnnotatedString text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines, List<AnnotatedString.Range<Placeholder>> placeholders) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        this.placeholders = placeholders;
        markDirty();
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics intrinsics;
        MultiParagraphIntrinsics localIntrinsics = this.paragraphIntrinsics;
        if (localIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || localIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            AnnotatedString annotatedString = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            FontFamily.Resolver resolver = this.fontFamilyResolver;
            List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            intrinsics = new MultiParagraphIntrinsics(annotatedString, resolveDefaults, list, density, resolver);
        } else {
            intrinsics = localIntrinsics;
        }
        this.paragraphIntrinsics = intrinsics;
        return intrinsics;
    }

    /* renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final MultiParagraph m848layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics localParagraphIntrinsics = setLayoutDirection(layoutDirection);
        return new MultiParagraph(localParagraphIntrinsics, LayoutUtilsKt.m843finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, localParagraphIntrinsics.getMaxIntrinsicWidth()), LayoutUtilsKt.m844finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m5130equalsimpl0(this.overflow, TextOverflow.INSTANCE.m5138getEllipsisgIe3tQ8()), null);
    }

    /* renamed from: newLayoutWillBeDifferent-VKLhPVY, reason: not valid java name */
    private final boolean m850newLayoutWillBeDifferentVKLhPVY(TextLayoutResult $this$newLayoutWillBeDifferent_u2dVKLhPVY, long constraints, LayoutDirection layoutDirection) {
        if ($this$newLayoutWillBeDifferent_u2dVKLhPVY == null || $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() || layoutDirection != $this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getLayoutDirection()) {
            return true;
        }
        if (Constraints.m5167equalsimpl0(constraints, $this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getConstraints())) {
            return false;
        }
        return Constraints.m5174getMaxWidthimpl(constraints) != Constraints.m5174getMaxWidthimpl($this$newLayoutWillBeDifferent_u2dVKLhPVY.getLayoutInput().getConstraints()) || ((float) Constraints.m5173getMaxHeightimpl(constraints)) < $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getHeight() || $this$newLayoutWillBeDifferent_u2dVKLhPVY.getMultiParagraph().getDidExceedMaxLines();
    }

    /* renamed from: maxWidth-BRTryo0, reason: not valid java name */
    private final int m849maxWidthBRTryo0(long constraints) {
        boolean z = this.softWrap;
        int i = this.overflow;
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        Intrinsics.checkNotNull(multiParagraphIntrinsics);
        return LayoutUtilsKt.m845finalMaxWidthtfFHcEY(constraints, z, i, multiParagraphIntrinsics.getMaxIntrinsicWidth());
    }

    private final void markDirty() {
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }
}
