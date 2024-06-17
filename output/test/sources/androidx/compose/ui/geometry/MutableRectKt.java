package androidx.compose.ui.geometry;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutableRect.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class MutableRectKt {
    public static final Rect toRect(MutableRect $this$toRect) {
        Intrinsics.checkNotNullParameter($this$toRect, "<this>");
        return new Rect($this$toRect.getLeft(), $this$toRect.getTop(), $this$toRect.getRight(), $this$toRect.getBottom());
    }
}
