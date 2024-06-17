package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.material3.TimePickerState$update$2", f = "TimePicker.kt", i = {}, l = {571, 573}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class TimePickerState$update$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromTap;
    final /* synthetic */ float $value;
    int label;
    final /* synthetic */ TimePickerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerState$update$2(TimePickerState timePickerState, float f, boolean z, Continuation<? super TimePickerState$update$2> continuation) {
        super(1, continuation);
        this.this$0 = timePickerState;
        this.$value = f;
        this.$fromTap = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TimePickerState$update$2(this.this$0, this.$value, this.$fromTap, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TimePickerState$update$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        int minute;
        int minute2;
        int minute3;
        float offsetHour;
        int hour;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Selection.m1695equalsimpl0(this.this$0.m1912getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m1699getHourJiIwxys())) {
                    TimePickerState timePickerState = this.this$0;
                    hour = this.this$0.toHour(this.$value);
                    timePickerState.setHourAngle$material3_release((hour % 12) * 0.5235988f);
                } else if (this.$fromTap) {
                    TimePickerState timePickerState2 = this.this$0;
                    minute2 = this.this$0.toMinute(this.$value);
                    minute3 = this.this$0.toMinute(this.$value);
                    timePickerState2.setMinuteAngle$material3_release((minute2 - (minute3 % 5)) * 0.10471976f);
                } else {
                    TimePickerState timePickerState3 = this.this$0;
                    minute = this.this$0.toMinute(this.$value);
                    timePickerState3.setMinuteAngle$material3_release(minute * 0.10471976f);
                }
                if (this.$fromTap) {
                    this.label = 1;
                    if (this.this$0.getCurrentAngle$material3_release().snapTo(Boxing.boxFloat(this.this$0.getMinuteAngle$material3_release()), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    Animatable<Float, AnimationVector1D> currentAngle$material3_release = this.this$0.getCurrentAngle$material3_release();
                    offsetHour = this.this$0.offsetHour(this.$value);
                    this.label = 2;
                    if (currentAngle$material3_release.snapTo(Boxing.boxFloat(offsetHour), this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
