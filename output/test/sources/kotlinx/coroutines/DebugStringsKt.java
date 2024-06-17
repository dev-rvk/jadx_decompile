package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* compiled from: DebugStrings.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class DebugStringsKt {
    public static final String getHexAddress(Object $this$hexAddress) {
        return Integer.toHexString(System.identityHashCode($this$hexAddress));
    }

    public static final String toDebugString(Continuation<?> continuation) {
        Object m5615constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m5615constructorimpl = Result.m5615constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m5615constructorimpl = Result.m5615constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5618exceptionOrNullimpl(m5615constructorimpl) != null) {
            m5615constructorimpl = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) m5615constructorimpl;
    }

    public static final String getClassSimpleName(Object $this$classSimpleName) {
        return $this$classSimpleName.getClass().getSimpleName();
    }
}
