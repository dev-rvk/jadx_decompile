package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.TooltipSync$show$6", f = "Tooltip.kt", i = {}, l = {655}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TooltipSync$show$6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $cleanUp;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $runBlock;
    final /* synthetic */ TooltipState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TooltipSync$show$6(TooltipState tooltipState, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function0<Unit> function0, Continuation<? super TooltipSync$show$6> continuation) {
        super(1, continuation);
        this.$state = tooltipState;
        this.$runBlock = function1;
        this.$cleanUp = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TooltipSync$show$6(this.$state, this.$runBlock, this.$cleanUp, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TooltipSync$show$6) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Throwable th;
        TooltipSync$show$6 tooltipSync$show$6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    TooltipSync.INSTANCE.setMutexOwner(this.$state);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$runBlock;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tooltipSync$show$6 = this;
                    TooltipSync.INSTANCE.setMutexOwner(null);
                    tooltipSync$show$6.$cleanUp.invoke();
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    tooltipSync$show$6 = this;
                    TooltipSync.INSTANCE.setMutexOwner(null);
                    tooltipSync$show$6.$cleanUp.invoke();
                    throw th;
                }
            case 1:
                tooltipSync$show$6 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    TooltipSync.INSTANCE.setMutexOwner(null);
                    tooltipSync$show$6.$cleanUp.invoke();
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    TooltipSync.INSTANCE.setMutexOwner(null);
                    tooltipSync$show$6.$cleanUp.invoke();
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
