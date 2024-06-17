package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextLayoutResultProxy.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m842coerceIn3MmeM6k(long $this$coerceIn_u2d3MmeM6k, Rect rect) {
        float xOffset;
        float yOffset;
        if (Offset.m2710getXimpl($this$coerceIn_u2d3MmeM6k) < rect.getLeft()) {
            xOffset = rect.getLeft();
        } else {
            xOffset = Offset.m2710getXimpl($this$coerceIn_u2d3MmeM6k) > rect.getRight() ? rect.getRight() : Offset.m2710getXimpl($this$coerceIn_u2d3MmeM6k);
        }
        if (Offset.m2711getYimpl($this$coerceIn_u2d3MmeM6k) < rect.getTop()) {
            yOffset = rect.getTop();
        } else {
            yOffset = Offset.m2711getYimpl($this$coerceIn_u2d3MmeM6k) > rect.getBottom() ? rect.getBottom() : Offset.m2711getYimpl($this$coerceIn_u2d3MmeM6k);
        }
        return OffsetKt.Offset(xOffset, yOffset);
    }
}
