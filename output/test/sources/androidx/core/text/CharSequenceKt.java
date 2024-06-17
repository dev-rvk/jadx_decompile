package androidx.core.text;

import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: CharSequence.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0086\b¨\u0006\u0005"}, d2 = {"isDigitsOnly", "", "", "trimmedLength", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence $this$isDigitsOnly) {
        return TextUtils.isDigitsOnly($this$isDigitsOnly);
    }

    public static final int trimmedLength(CharSequence $this$trimmedLength) {
        return TextUtils.getTrimmedLength($this$trimmedLength);
    }
}
