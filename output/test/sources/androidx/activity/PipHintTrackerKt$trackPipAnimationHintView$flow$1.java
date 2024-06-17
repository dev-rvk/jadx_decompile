package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: PipHintTracker.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<ProducerScope<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> continuation) {
        super(2, continuation);
        this.$view = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, continuation);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Rect> producerScope, Continuation<? super Unit> continuation) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Rect trackPipAnimationHintView$positionInWindow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final View.OnLayoutChangeListener layoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$0(ProducerScope.this, view, i, i2, i3, i4, i5, i6, i7, i8);
                    }
                };
                final View view = this.$view;
                final ViewTreeObserver.OnScrollChangedListener scrollChangeListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$$ExternalSyntheticLambda1
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        PipHintTrackerKt$trackPipAnimationHintView$flow$1.invokeSuspend$lambda$1(ProducerScope.this, view);
                    }
                };
                final View view2 = this.$view;
                final ?? r5 = new View.OnAttachStateChangeListener() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View v) {
                        Rect trackPipAnimationHintView$positionInWindow2;
                        Intrinsics.checkNotNullParameter(v, "v");
                        ProducerScope<Rect> producerScope = $this$callbackFlow;
                        trackPipAnimationHintView$positionInWindow2 = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(view2);
                        producerScope.mo7116trySendJP2dKIU(trackPipAnimationHintView$positionInWindow2);
                        view2.getViewTreeObserver().addOnScrollChangedListener(scrollChangeListener);
                        view2.addOnLayoutChangeListener(layoutChangeListener);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View v) {
                        Intrinsics.checkNotNullParameter(v, "v");
                        v.getViewTreeObserver().removeOnScrollChangedListener(scrollChangeListener);
                        v.removeOnLayoutChangeListener(layoutChangeListener);
                    }
                };
                if (this.$view.isAttachedToWindow()) {
                    trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(this.$view);
                    $this$callbackFlow.mo7116trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
                    this.$view.getViewTreeObserver().addOnScrollChangedListener(scrollChangeListener);
                    this.$view.addOnLayoutChangeListener(layoutChangeListener);
                }
                this.$view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) r5);
                final View view3 = this.$view;
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0<Unit>() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        view3.getViewTreeObserver().removeOnScrollChangedListener(scrollChangeListener);
                        view3.removeOnLayoutChangeListener(layoutChangeListener);
                        view3.removeOnAttachStateChangeListener(r5);
                    }
                }, this) != coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope $$this$callbackFlow, View v, int l, int t, int r, int b, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Rect trackPipAnimationHintView$positionInWindow;
        if (l != oldLeft || r != oldRight || t != oldTop || b != oldBottom) {
            Intrinsics.checkNotNullExpressionValue(v, "v");
            trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow(v);
            $$this$callbackFlow.mo7116trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(ProducerScope $$this$callbackFlow, View $view) {
        Rect trackPipAnimationHintView$positionInWindow;
        trackPipAnimationHintView$positionInWindow = PipHintTrackerKt.trackPipAnimationHintView$positionInWindow($view);
        $$this$callbackFlow.mo7116trySendJP2dKIU(trackPipAnimationHintView$positionInWindow);
    }
}
