package androidx.compose.runtime;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Recomposer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public final Object awaitFrameRequest(Object lock, Continuation<? super Unit> continuation) {
        Object obj;
        Object obj2;
        CancellableContinuation cancellableContinuation;
        Object obj3;
        Object obj4;
        synchronized (lock) {
            Object obj5 = this.pendingFrameContinuation;
            obj = RecomposerKt.ProduceAnotherFrame;
            if (obj5 == obj) {
                obj4 = RecomposerKt.FramePending;
                this.pendingFrameContinuation = obj4;
                return Unit.INSTANCE;
            }
            Unit unit = Unit.INSTANCE;
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellable$iv.initCancellability();
            CancellableContinuationImpl co = cancellable$iv;
            synchronized (lock) {
                Object obj6 = this.pendingFrameContinuation;
                obj2 = RecomposerKt.ProduceAnotherFrame;
                if (obj6 == obj2) {
                    obj3 = RecomposerKt.FramePending;
                    this.pendingFrameContinuation = obj3;
                    cancellableContinuation = co;
                } else {
                    this.pendingFrameContinuation = co;
                    cancellableContinuation = null;
                }
            }
            if (cancellableContinuation != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m5615constructorimpl(Unit.INSTANCE));
            }
            Object result = cancellable$iv.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
    }

    public final void takeFrameRequestLocked() {
        Object obj;
        Object obj2 = this.pendingFrameContinuation;
        obj = RecomposerKt.FramePending;
        if (!(obj2 == obj)) {
            throw new IllegalStateException("frame not pending".toString());
        }
        this.pendingFrameContinuation = null;
    }

    public final Continuation<Unit> requestFrameLocked() {
        Object obj;
        Object obj2;
        boolean areEqual;
        Object obj3;
        Object obj4;
        Object co = this.pendingFrameContinuation;
        if (co instanceof Continuation) {
            obj4 = RecomposerKt.FramePending;
            this.pendingFrameContinuation = obj4;
            return (Continuation) co;
        }
        obj = RecomposerKt.ProduceAnotherFrame;
        if (Intrinsics.areEqual(co, obj)) {
            areEqual = true;
        } else {
            obj2 = RecomposerKt.FramePending;
            areEqual = Intrinsics.areEqual(co, obj2);
        }
        if (areEqual) {
            return null;
        }
        if (co == null) {
            obj3 = RecomposerKt.ProduceAnotherFrame;
            this.pendingFrameContinuation = obj3;
            return null;
        }
        throw new IllegalStateException(("invalid pendingFrameContinuation " + co).toString());
    }
}
