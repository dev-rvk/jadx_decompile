package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.text.android.TextLayoutKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndentationFixSpan.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jp\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/android/style/IndentationFixSpan;", "Landroid/text/style/LeadingMarginSpan;", "()V", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "left", "", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "firstLine", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IndentationFixSpan implements LeadingMarginSpan {
    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean firstLine) {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int left, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        if (layout != null && paint != null) {
            int lineIndex = layout.getLineForOffset(start);
            if (lineIndex == layout.getLineCount() - 1 && TextLayoutKt.isLineEllipsized(layout, lineIndex)) {
                float padding = IndentationFixSpanKt.getEllipsizedLeftPadding(layout, lineIndex, paint) + IndentationFixSpanKt.getEllipsizedRightPadding(layout, lineIndex, paint);
                if (!(padding == 0.0f)) {
                    Intrinsics.checkNotNull(canvas);
                    canvas.translate(padding, 0.0f);
                }
            }
        }
    }
}
