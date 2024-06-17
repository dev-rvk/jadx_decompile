package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: EventLoop.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0080\b\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\b\u0010\b\u001a\u00020\u0007H\u0001\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0001¨\u0006\f"}, d2 = {"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "platformAutoreleasePool", "", "block", "Lkotlin/Function0;", "processNextEventInCurrentThread", "", "runSingleTaskFromCurrentSystemDispatcher", "isIoDispatcherThread", "", "Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class EventLoopKt {
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    public static final long processNextEventInCurrentThread() {
        EventLoop currentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        if (currentOrNull$kotlinx_coroutines_core != null) {
            return currentOrNull$kotlinx_coroutines_core.processNextEvent();
        }
        return Long.MAX_VALUE;
    }

    public static final void platformAutoreleasePool(Function0<Unit> function0) {
        function0.invoke();
    }

    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof CoroutineScheduler.Worker)) {
            throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + thread);
        }
        return ((CoroutineScheduler.Worker) thread).runSingleTask();
    }

    public static final boolean isIoDispatcherThread(Thread $this$isIoDispatcherThread) {
        if ($this$isIoDispatcherThread instanceof CoroutineScheduler.Worker) {
            return ((CoroutineScheduler.Worker) $this$isIoDispatcherThread).isIo();
        }
        return false;
    }
}
