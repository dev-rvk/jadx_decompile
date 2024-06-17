package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForEachOneBit.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u000226\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"forEachOneBit", "", "", "body", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "mask", "index", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ForEachOneBitKt {
    public static final void forEachOneBit(int $this$forEachOneBit, Function2<? super Integer, ? super Integer, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        int mask = $this$forEachOneBit;
        int index = 0;
        while (mask != 0) {
            int bit = Integer.lowestOneBit(mask);
            body.invoke(Integer.valueOf(bit), Integer.valueOf(index));
            index++;
            mask ^= bit;
        }
    }
}
