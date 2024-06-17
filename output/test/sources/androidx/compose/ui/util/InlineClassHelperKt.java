package androidx.compose.ui.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: InlineClassHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\b\u001a\u0019\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0086\b\u001a\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0086\b\u001a\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0086\b¨\u0006\f"}, d2 = {"packFloats", "", "val1", "", "val2", "packInts", "", "unpackFloat1", "value", "unpackFloat2", "unpackInt1", "unpackInt2", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class InlineClassHelperKt {
    public static final long packFloats(float val1, float val2) {
        long v1 = Float.floatToIntBits(val1);
        long v2 = Float.floatToIntBits(val2);
        return (v1 << 32) | (4294967295L & v2);
    }

    public static final float unpackFloat1(long value) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (value >> 32));
    }

    public static final float unpackFloat2(long value) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (4294967295L & value));
    }

    public static final long packInts(int val1, int val2) {
        return (val1 << 32) | (val2 & 4294967295L);
    }

    public static final int unpackInt1(long value) {
        return (int) (value >> 32);
    }

    public static final int unpackInt2(long value) {
        return (int) (4294967295L & value);
    }
}
