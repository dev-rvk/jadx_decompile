package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineHeightStyleSpan.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J8\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J'\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b%R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "(FIIZZF)V", "ascent", "descent", "firstAscent", "<set-?>", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescent", "lastDescentDiff", "getLastDescentDiff", "getLineHeight", "()F", "getTrimLastLineBottom", "()Z", "calculateTargetMetrics", "", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "text", "", "start", "end", "spanStartVertical", "copy", "copy$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    private final int endIndex;
    private int firstAscentDiff;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;
    private int firstAscent = Integer.MIN_VALUE;
    private int ascent = Integer.MIN_VALUE;
    private int descent = Integer.MIN_VALUE;
    private int lastDescent = Integer.MIN_VALUE;

    public LineHeightStyleSpan(float lineHeight, int startIndex, int endIndex, boolean trimFirstLineTop, boolean trimLastLineBottom, float topRatio) {
        this.lineHeight = lineHeight;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.trimFirstLineTop = trimFirstLineTop;
        this.trimLastLineBottom = trimLastLineBottom;
        this.topRatio = topRatio;
        float f = this.topRatio;
        boolean z = true;
        if (!(0.0f <= f && f <= 1.0f)) {
            if (!(this.topRatio == -1.0f)) {
                z = false;
            }
        }
        if (z) {
        } else {
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }

    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanStartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        int currentHeight = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        if (currentHeight <= 0) {
            return;
        }
        boolean isFirstLine = start == this.startIndex;
        boolean isLastLine = end == this.endIndex;
        if (isFirstLine && isLastLine && this.trimFirstLineTop && this.trimLastLineBottom) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        fontMetricsInt.ascent = isFirstLine ? this.firstAscent : this.ascent;
        fontMetricsInt.descent = isLastLine ? this.lastDescent : this.descent;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        float ascentRatio;
        int descentDiff;
        int currentHeight = LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        int ceiledLineHeight = (int) Math.ceil(this.lineHeight);
        int diff = ceiledLineHeight - currentHeight;
        if (this.topRatio == -1.0f) {
            ascentRatio = Math.abs(fontMetricsInt.ascent) / LineHeightStyleSpanKt.lineHeight(fontMetricsInt);
        } else {
            ascentRatio = this.topRatio;
        }
        if (diff <= 0) {
            descentDiff = (int) Math.ceil(diff * ascentRatio);
        } else {
            descentDiff = (int) Math.ceil(diff * (1.0f - ascentRatio));
        }
        this.descent = fontMetricsInt.descent + descentDiff;
        this.ascent = this.descent - ceiledLineHeight;
        this.firstAscent = this.trimFirstLineTop ? fontMetricsInt.ascent : this.ascent;
        this.lastDescent = this.trimLastLineBottom ? fontMetricsInt.descent : this.descent;
        this.firstAscentDiff = fontMetricsInt.ascent - this.firstAscent;
        this.lastDescentDiff = this.lastDescent - fontMetricsInt.descent;
    }

    public static /* synthetic */ LineHeightStyleSpan copy$ui_text_release$default(LineHeightStyleSpan lineHeightStyleSpan, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text_release(i, i2, z);
    }

    public final LineHeightStyleSpan copy$ui_text_release(int startIndex, int endIndex, boolean trimFirstLineTop) {
        return new LineHeightStyleSpan(this.lineHeight, startIndex, endIndex, trimFirstLineTop, this.trimLastLineBottom, this.topRatio);
    }
}
