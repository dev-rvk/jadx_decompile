package androidx.core.util;

import android.util.Half;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Half.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class HalfKt {
    public static final Half toHalf(short $this$toHalf) {
        return Half.valueOf($this$toHalf);
    }

    public static final Half toHalf(float $this$toHalf) {
        return Half.valueOf($this$toHalf);
    }

    public static final Half toHalf(double $this$toHalf) {
        float $this$toHalf$iv = (float) $this$toHalf;
        return Half.valueOf($this$toHalf$iv);
    }

    public static final Half toHalf(String $this$toHalf) {
        return Half.valueOf($this$toHalf);
    }
}
