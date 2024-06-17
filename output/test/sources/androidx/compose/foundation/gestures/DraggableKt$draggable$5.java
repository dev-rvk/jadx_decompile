package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", "Landroidx/compose/ui/unit/Velocity;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$5", f = "Draggable.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class DraggableKt$draggable$5 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> $onDragStopped;
    final /* synthetic */ Orientation $orientation;
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DraggableKt$draggable$5(Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function3, Orientation orientation, Continuation<? super DraggableKt$draggable$5> continuation) {
        super(3, continuation);
        this.$onDragStopped = function3;
        this.$orientation = orientation;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Velocity velocity, Continuation<? super Unit> continuation) {
        return m297invokeLuvzFrg(coroutineScope, velocity.getPackedValue(), continuation);
    }

    /* renamed from: invoke-LuvzFrg, reason: not valid java name */
    public final Object m297invokeLuvzFrg(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
        DraggableKt$draggable$5 draggableKt$draggable$5 = new DraggableKt$draggable$5(this.$onDragStopped, this.$orientation, continuation);
        draggableKt$draggable$5.L$0 = coroutineScope;
        draggableKt$draggable$5.J$0 = j;
        return draggableKt$draggable$5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        float m294toFloatsFctU;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$$receiver = (CoroutineScope) this.L$0;
                long velocity = this.J$0;
                Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> function3 = this.$onDragStopped;
                m294toFloatsFctU = DraggableKt.m294toFloatsFctU(velocity, this.$orientation);
                Float boxFloat = Boxing.boxFloat(m294toFloatsFctU);
                this.label = 1;
                if (function3.invoke($this$$receiver, boxFloat, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
