package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {59, LockFreeTaskQueueCore.CLOSED_SHIFT}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0195, code lost:
    
        if (androidx.compose.ui.geometry.Offset.m2707equalsimpl0(r1, androidx.compose.ui.geometry.Offset.INSTANCE.m2726getZeroF1C5BW0()) == false) goto L63;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00c0 -> B:7:0x00cc). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
