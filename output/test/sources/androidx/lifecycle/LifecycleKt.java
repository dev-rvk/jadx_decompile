package androidx.lifecycle;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Lifecycle.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lkotlinx/coroutines/flow/Flow;", "lifecycle-common"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle $this$coroutineScope) {
        LifecycleCoroutineScopeImpl newScope;
        Intrinsics.checkNotNullParameter($this$coroutineScope, "<this>");
        do {
            LifecycleCoroutineScopeImpl existing = (LifecycleCoroutineScopeImpl) $this$coroutineScope.getInternalScopeRef().get();
            if (existing != null) {
                return existing;
            }
            newScope = new LifecycleCoroutineScopeImpl($this$coroutineScope, SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m($this$coroutineScope.getInternalScopeRef(), null, newScope));
        newScope.register();
        return newScope;
    }

    public static final Flow<Lifecycle.Event> getEventFlow(Lifecycle $this$eventFlow) {
        Intrinsics.checkNotNullParameter($this$eventFlow, "<this>");
        return FlowKt.flowOn(FlowKt.callbackFlow(new LifecycleKt$eventFlow$1($this$eventFlow, null)), Dispatchers.getMain().getImmediate());
    }
}
