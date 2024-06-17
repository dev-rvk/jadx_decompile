package kotlinx.coroutines;

import androidx.autofill.HintConstants;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: JobSupport.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n²\u0001³\u0001´\u0001µ\u0001¶\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010L\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0002J\u0013\u0010O\u001a\u0004\u0018\u00010\u000bH\u0084@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0012\u0010R\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010R\u001a\u00020H2\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u0011J\u0017\u0010W\u001a\u00020\u00052\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020]H\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010_\u001a\u00020H2\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010a\u001a\u00020H2\u0006\u00108\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010f\u001a\u00020\u00112\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010g\u001a\u00020h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0080\b¢\u0006\u0002\bjJ\u001c\u0010k\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010d2\u0006\u00108\u001a\u00020?H\u0002J\n\u0010m\u001a\u00060Tj\u0002`UJ\f\u0010n\u001a\u00060Tj\u0002`UH\u0016J\u000f\u0010o\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\bpJ\b\u0010q\u001a\u0004\u0018\u00010\u0011J \u0010r\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u00020b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0011H\u0014J\u0015\u0010v\u001a\u00020H2\u0006\u0010u\u001a\u00020\u0011H\u0010¢\u0006\u0002\bwJ\u0012\u0010x\u001a\u00020H2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0004JA\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J1\u0010y\u001a\u00020z2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020HH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010PJ\t\u0010\u0083\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020HH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\"\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020H0~H\u0082\bJ\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0089\u0001\u001a\u00020\u00052\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\b\u008c\u0001J<\u0010\u008d\u0001\u001a\u00020F2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u00012\u0006\u0010{\u001a\u00020\u0005H\u0002J\u000f\u0010\u008e\u0001\u001a\u00020]H\u0010¢\u0006\u0003\b\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u00020\u0011H\u0002J)\u0010\u0091\u0001\u001a\u00020H\"\u000b\b\u0000\u0010\u0092\u0001\u0018\u0001*\u00020F2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0082\bJ!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0096\u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010{\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0099\u0001\u001a\u00020H2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\t\u0010\u009a\u0001\u001a\u00020HH\u0014J\u0010\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u0012\u0010\u009d\u0001\u001a\u00020H2\u0007\u00108\u001a\u00030\u009e\u0001H\u0002J\u0011\u0010\u009f\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020FH\u0002J\"\u0010 \u0001\u001a\u00020H2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010¡\u0001\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0003\b¢\u0001J\u0007\u0010£\u0001\u001a\u00020\u0005J\u0014\u0010¤\u0001\u001a\u00030¥\u00012\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010¦\u0001\u001a\u00020]2\b\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010§\u0001\u001a\u00020]H\u0007J\t\u0010¨\u0001\u001a\u00020]H\u0016J\u001b\u0010©\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010ª\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\u000b2\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001d\u0010¬\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020?2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010\u00ad\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020b2\u0006\u0010N\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082\u0010J\u0010\u0010®\u0001\u001a\u0004\u0018\u00010d*\u00030¯\u0001H\u0002J\u0017\u0010°\u0001\u001a\u00020H*\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010±\u0001\u001a\u00060Tj\u0002`U*\u00020\u00112\n\b\u0002\u0010i\u001a\u0004\u0018\u00010]H\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u0006\u0012\u0002\b\u00030#8DX\u0084\u0004¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0017\u0010*\u001a\u00020+8F¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R(\u00103\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\t8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u00020\u0005*\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010@\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006·\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "(Z)V", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/ChildHandle;", "_state", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "completionCause", "", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "()V", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "addSuppressedExceptions", "", "rootCause", "exceptions", "", "afterCompletion", "attachChild", "child", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelInternal", "cancelMakeCompleting", "cancelParent", "cancellationExceptionMessage", "", "childCancelled", "completeStateFinalization", "update", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "message", "defaultCancellationException$kotlinx_coroutines_core", "finalizeFinishingState", "firstChild", "getCancellationException", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionExceptionOrNull", "getFinalRootCause", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onAwaitInternalProcessResFunc", "ignoredParam", "result", "onAwaitInternalRegFunc", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onCompletionInternal", "onStart", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectForOnJoin", "removeNode", "removeNode$kotlinx_coroutines_core", "start", "startInternal", "", "stateString", "toDebugString", "toString", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryMakeCompletingSlowPath", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes5.dex */
public class JobSupport implements Job, ChildJob, ParentJob {

    @Volatile
    private volatile Object _parentHandle;

    @Volatile
    private volatile Object _state;
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private static final AtomicReferenceFieldUpdater _parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle");

    protected static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public JobSupport(boolean active) {
        this._state = active ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext context) {
        return Job.DefaultImpls.plus(this, context);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job other) {
        return Job.DefaultImpls.plus((Job) this, other);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) _parentHandle$FU.get(this);
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle value) {
        _parentHandle$FU.set(this, value);
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initParentJob(Job parent) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle handle = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(handle);
        if (isCompleted()) {
            handle.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    public final Object getState$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicfu$handler$iv = _state$FU;
        while (true) {
            Object state = atomicfu$handler$iv.get(this);
            if (!(state instanceof OpDescriptor)) {
                return state;
            }
            ((OpDescriptor) state).perform(this);
        }
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        while (true) {
            block.invoke(getState$kotlinx_coroutines_core());
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state = getState$kotlinx_coroutines_core();
        return (state instanceof Incomplete) && ((Incomplete) state).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state = getState$kotlinx_coroutines_core();
        return (state instanceof CompletedExceptionally) || ((state instanceof Finishing) && ((Finishing) state).isCancelling());
    }

    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) {
        boolean wasCancelling;
        Throwable finalCause;
        boolean handled = true;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((getState$kotlinx_coroutines_core() == state ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(!state.isSealed())) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !state.isCompleting()) {
            throw new AssertionError();
        }
        CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
        Throwable proposedException = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (state) {
            wasCancelling = state.isCancelling();
            List exceptions = state.sealLocked(proposedException);
            finalCause = getFinalRootCause(state, exceptions);
            if (finalCause != null) {
                addSuppressedExceptions(finalCause, exceptions);
            }
        }
        Object finalState = (finalCause == null || finalCause == proposedException) ? proposedUpdate : new CompletedExceptionally(finalCause, false, 2, null);
        if (finalCause != null) {
            if (!cancelParent(finalCause) && !handleJobException(finalCause)) {
                handled = false;
            }
            if (handled) {
                Intrinsics.checkNotNull(finalState, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((CompletedExceptionally) finalState).makeHandled();
            }
        }
        if (!wasCancelling) {
            onCancelling(finalCause);
        }
        onCompletionInternal(finalState);
        boolean casSuccess = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, JobSupportKt.boxIncomplete(finalState));
        if (DebugKt.getASSERTIONS_ENABLED() && !casSuccess) {
            throw new AssertionError();
        }
        completeStateFinalization(state, finalState);
        return finalState;
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Object element$iv;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> $this$firstOrNull$iv = exceptions;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                if (!(((Throwable) element$iv) instanceof CancellationException)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Throwable firstNonCancellation = (Throwable) element$iv;
        if (firstNonCancellation != null) {
            return firstNonCancellation;
        }
        Throwable first = exceptions.get(0);
        if (first instanceof TimeoutCancellationException) {
            List<? extends Throwable> $this$firstOrNull$iv2 = exceptions;
            Iterator it2 = $this$firstOrNull$iv2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object element$iv2 = it2.next();
                Throwable it3 = (Throwable) element$iv2;
                if (((it3 == first || !(it3 instanceof TimeoutCancellationException)) ? null : 1) != null) {
                    obj = element$iv2;
                    break;
                }
            }
            Throwable detailedTimeoutException = (Throwable) obj;
            if (detailedTimeoutException != null) {
                return detailedTimeoutException;
            }
        }
        return first;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        int expectedSize$iv = exceptions.size();
        Set seenExceptions = Collections.newSetFromMap(new IdentityHashMap(expectedSize$iv));
        Throwable unwrappedCause = !DebugKt.getRECOVER_STACK_TRACES() ? rootCause : StackTraceRecoveryKt.unwrapImpl(rootCause);
        for (Throwable exception : exceptions) {
            Throwable unwrapped = !DebugKt.getRECOVER_STACK_TRACES() ? exception : StackTraceRecoveryKt.unwrapImpl(exception);
            if (unwrapped != rootCause && unwrapped != unwrappedCause && !(unwrapped instanceof CancellationException) && seenExceptions.add(unwrapped)) {
                kotlin.ExceptionsKt.addSuppressed(rootCause, unwrapped);
            }
        }
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if ((((state instanceof Empty) || (state instanceof JobNode)) ? 1 : 0) == 0) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(update instanceof CompletedExceptionally))) {
            throw new AssertionError();
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, JobSupportKt.boxIncomplete(update))) {
            return false;
        }
        onCancelling(null);
        onCompletionInternal(update);
        completeStateFinalization(state, update);
        return true;
    }

    private final void completeStateFinalization(Incomplete state, Object update) {
        ChildHandle it = getParentHandle$kotlinx_coroutines_core();
        if (it != null) {
            it.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally) update : null;
        Throwable cause = completedExceptionally != null ? completedExceptionally.cause : null;
        if (state instanceof JobNode) {
            try {
                ((JobNode) state).invoke(cause);
                return;
            } catch (Throwable ex) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, ex));
                return;
            }
        }
        NodeList list = state.getList();
        if (list != null) {
            notifyCompletion(list, cause);
        }
    }

    private final void notifyCancelling(NodeList list, Throwable cause) {
        onCancelling(cause);
        NodeList this_$iv$iv = list;
        Object next = this_$iv$iv.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        Object exception$iv = null;
        for (LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(cur$iv$iv, this_$iv$iv); cur$iv$iv = cur$iv$iv.getNextNode()) {
            if (cur$iv$iv instanceof JobCancellingNode) {
                JobNode node$iv = (JobNode) cur$iv$iv;
                try {
                    node$iv.invoke(cause);
                } catch (Throwable ex$iv) {
                    Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv = (Throwable) exception$iv;
                    if ($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv != null) {
                        kotlin.ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv, ex$iv);
                        if ($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv != null) {
                        }
                    }
                    exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + this, ex$iv);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        Throwable it$iv = (Throwable) exception$iv;
        if (it$iv != null) {
            handleOnCompletionException$kotlinx_coroutines_core(it$iv);
        }
        cancelParent(cause);
    }

    private final boolean cancelParent(Throwable cause) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean isCancellation = cause instanceof CancellationException;
        ChildHandle parent = getParentHandle$kotlinx_coroutines_core();
        if (parent == null || parent == NonDisposableHandle.INSTANCE) {
            return isCancellation;
        }
        return parent.childCancelled(cause) || isCancellation;
    }

    private final void notifyCompletion(NodeList $this$notifyCompletion, Throwable cause) {
        NodeList this_$iv$iv = $this$notifyCompletion;
        Object next = this_$iv$iv.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        Object exception$iv = null;
        for (LockFreeLinkedListNode cur$iv$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(cur$iv$iv, this_$iv$iv); cur$iv$iv = cur$iv$iv.getNextNode()) {
            if (cur$iv$iv instanceof JobNode) {
                JobNode node$iv = (JobNode) cur$iv$iv;
                try {
                    node$iv.invoke(cause);
                } catch (Throwable ex$iv) {
                    Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv = (Throwable) exception$iv;
                    if ($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv != null) {
                        kotlin.ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv, ex$iv);
                        if ($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412$iv != null) {
                        }
                    }
                    exception$iv = new CompletionHandlerException("Exception in completion handler " + node$iv + " for " + this, ex$iv);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        Throwable it$iv = (Throwable) exception$iv;
        if (it$iv == null) {
            return;
        }
        handleOnCompletionException$kotlinx_coroutines_core(it$iv);
    }

    private final /* synthetic */ <T extends JobNode> void notifyHandlers(NodeList list, Throwable cause) {
        Object exception = null;
        NodeList this_$iv = list;
        Object next = this_$iv.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (LockFreeLinkedListNode cur$iv = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(cur$iv, this_$iv); cur$iv = cur$iv.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (cur$iv instanceof LockFreeLinkedListNode) {
                JobNode node = (JobNode) cur$iv;
                try {
                    node.invoke(cause);
                } catch (Throwable ex) {
                    Throwable th = (Throwable) exception;
                    if (th != null) {
                        Throwable $this$notifyHandlers_u24lambda_u2414_u24lambda_u2412 = th;
                        kotlin.ExceptionsKt.addSuppressed($this$notifyHandlers_u24lambda_u2414_u24lambda_u2412, ex);
                        if (th != null) {
                        }
                    }
                    JobSupport $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413 = this;
                    exception = new CompletionHandlerException("Exception in completion handler " + node + " for " + $this$notifyHandlers_u24lambda_u2414_u24lambda_u2413, ex);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        Throwable th2 = (Throwable) exception;
        if (th2 != null) {
            Throwable it = th2;
            handleOnCompletionException$kotlinx_coroutines_core(it);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        while (true) {
            Object state = getState$kotlinx_coroutines_core();
            switch (startInternal(state)) {
                case 0:
                    return false;
                case 1:
                    return true;
            }
        }
    }

    private final int startInternal(Object state) {
        Empty empty;
        if (state instanceof Empty) {
            if (((Empty) state).getIsActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            empty = JobSupportKt.EMPTY_ACTIVE;
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, state, empty)) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(state instanceof InactiveNodeList)) {
            return 0;
        }
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, ((InactiveNodeList) state).getList())) {
            return -1;
        }
        onStart();
        return 1;
    }

    protected void onStart() {
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        CancellationException cancellationException;
        Object state = getState$kotlinx_coroutines_core();
        if (!(state instanceof Finishing)) {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return state instanceof CompletedExceptionally ? toCancellationException$default(this, ((CompletedExceptionally) state).cause, null, 1, null) : new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
        Throwable rootCause = ((Finishing) state).getRootCause();
        if (rootCause == null || (cancellationException = toCancellationException(rootCause, DebugStringsKt.getClassSimpleName(this) + " is cancelling")) == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        return cancellationException;
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th, str);
    }

    protected final CancellationException toCancellationException(Throwable $this$toCancellationException, String message) {
        CancellationException cancellationException = $this$toCancellationException instanceof CancellationException ? (CancellationException) $this$toCancellationException : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException(message == null ? cancellationExceptionMessage() : message, $this$toCancellationException, this);
    }

    protected final Throwable getCompletionCause() {
        Object state = getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            Throwable rootCause = ((Finishing) state).getRootCause();
            if (rootCause == null) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return rootCause;
        }
        if (state instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state).cause;
        }
        return null;
    }

    protected final boolean getCompletionCauseHandled() {
        Object it = getState$kotlinx_coroutines_core();
        return (it instanceof CompletedExceptionally) && ((CompletedExceptionally) it).getHandled();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        JobNode node = makeNode(handler, onCancelling);
        while (true) {
            Object state = getState$kotlinx_coroutines_core();
            if (state instanceof Empty) {
                if (((Empty) state).getIsActive()) {
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, node)) {
                        return node;
                    }
                } else {
                    promoteEmptyToNodeList((Empty) state);
                }
            } else if (state instanceof Incomplete) {
                NodeList list = ((Incomplete) state).getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((JobNode) state);
                } else {
                    Object rootCause = null;
                    Object handle = NonDisposableHandle.INSTANCE;
                    if (onCancelling && (state instanceof Finishing)) {
                        synchronized (state) {
                            rootCause = ((Finishing) state).getRootCause();
                            if (rootCause != null) {
                                if ((handler instanceof ChildHandleNode) && !((Finishing) state).isCompleting()) {
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            if (addLastAtomic(state, list, node)) {
                                if (rootCause == null) {
                                    return node;
                                }
                                handle = node;
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                    }
                    if (rootCause != null) {
                        if (invokeImmediately) {
                            Object cause$iv = rootCause;
                            handler.invoke(cause$iv);
                        }
                        return (DisposableHandle) handle;
                    }
                    if (addLastAtomic(state, list, node)) {
                        return node;
                    }
                }
            } else {
                if (invokeImmediately) {
                    CompletedExceptionally completedExceptionally = state instanceof CompletedExceptionally ? (CompletedExceptionally) state : null;
                    Throwable cause$iv2 = completedExceptionally != null ? completedExceptionally.cause : null;
                    handler.invoke(cause$iv2);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    private final JobNode makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        InvokeOnCompletion node;
        if (onCancelling) {
            node = handler instanceof JobCancellingNode ? (JobCancellingNode) handler : null;
            if (node == null) {
                node = new InvokeOnCancelling(handler);
            }
            node = node;
        } else {
            node = handler instanceof JobNode ? (JobNode) handler : null;
            if (node != null) {
                JobNode it = node;
                if (DebugKt.getASSERTIONS_ENABLED() && !(!(it instanceof JobCancellingNode))) {
                    throw new AssertionError();
                }
            } else {
                node = new InvokeOnCompletion(handler);
            }
        }
        node.setJob(this);
        return node;
    }

    private final boolean addLastAtomic(final Object expect, NodeList list, JobNode node) {
        NodeList this_$iv = list;
        final JobNode jobNode = node;
        LockFreeLinkedListNode.CondAddOp condAdd$iv = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(LockFreeLinkedListNode affected) {
                if (this.getState$kotlinx_coroutines_core() == expect) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        while (true) {
            LockFreeLinkedListNode prev$iv = this_$iv.getPrevNode();
            switch (prev$iv.tryCondAddNext(node, this_$iv, condAdd$iv)) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList list = new NodeList();
        Incomplete update = state.getIsActive() ? list : new InactiveNodeList(list);
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, update);
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode list = state.getNextNode();
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, list);
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        if (!joinInternal()) {
            JobKt.ensureActive(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object joinSuspend = joinSuspend(continuation);
        return joinSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinSuspend : Unit.INSTANCE;
    }

    private final boolean joinInternal() {
        Object state;
        do {
            state = getState$kotlinx_coroutines_core();
            if (!(state instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellable$iv.initCancellability();
        CancellableContinuationImpl cont = cancellable$iv;
        CompletionHandlerBase $this$asHandler$iv = new ResumeOnCompletion(cont);
        CancellableContinuationKt.disposeOnCancellation(cont, invokeOnCompletion($this$asHandler$iv));
        Object result = cancellable$iv.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onJoin$1, 3), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForOnJoin(SelectInstance<?> select, Object ignoredParam) {
        if (!joinInternal()) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        CompletionHandlerBase $this$asHandler$iv = new SelectOnJoinCompletionHandler(select);
        DisposableHandle disposableHandle = invokeOnCompletion($this$asHandler$iv);
        select.disposeOnCompletion(disposableHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public final class SelectOnJoinCompletionHandler extends JobNode {
        private final SelectInstance<?> select;

        public SelectOnJoinCompletionHandler(SelectInstance<?> selectInstance) {
            this.select = selectInstance;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            this.select.trySelect(JobSupport.this, Unit.INSTANCE);
        }
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode node) {
        Object state;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Empty empty;
        do {
            state = getState$kotlinx_coroutines_core();
            if (state instanceof JobNode) {
                if (state != node) {
                    return;
                }
                atomicReferenceFieldUpdater = _state$FU;
                empty = JobSupportKt.EMPTY_ACTIVE;
            } else {
                if (!(state instanceof Incomplete) || ((Incomplete) state).getList() == null) {
                    return;
                }
                node.mo7171remove();
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, state, empty));
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cause) {
        JobCancellationException jobCancellationException;
        if (cause != null) {
            jobCancellationException = cause;
        } else {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable cause) {
        JobCancellationException jobCancellationException;
        if (cause == null || (jobCancellationException = toCancellationException$default(this, cause, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    public void cancelInternal(Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    public boolean childCancelled(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException();
    }

    public final boolean cancelCoroutine(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object cause) {
        Object finalState;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        finalState = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (finalState = cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol = JobSupportKt.COMPLETING_ALREADY;
        if (finalState == symbol) {
            finalState = makeCancelling(cause);
        }
        symbol2 = JobSupportKt.COMPLETING_ALREADY;
        if (finalState == symbol2 || finalState == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        symbol3 = JobSupportKt.TOO_LATE_TO_CANCEL;
        if (finalState == symbol3) {
            return false;
        }
        afterCompletion(finalState);
        return true;
    }

    private final Object cancelMakeCompleting(Object cause) {
        Symbol symbol;
        Object finalState;
        Symbol symbol2;
        do {
            Object state = getState$kotlinx_coroutines_core();
            if (!(state instanceof Incomplete) || ((state instanceof Finishing) && ((Finishing) state).isCompleting())) {
                symbol = JobSupportKt.COMPLETING_ALREADY;
                return symbol;
            }
            CompletedExceptionally proposedUpdate = new CompletedExceptionally(createCauseException(cause), false, 2, null);
            finalState = tryMakeCompleting(state, proposedUpdate);
            symbol2 = JobSupportKt.COMPLETING_RETRY;
        } while (finalState == symbol2);
        return finalState;
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport $this, String message, Throwable cause, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i & 1) != 0) {
            message = null;
        }
        if ((i & 2) != 0) {
            cause = null;
        }
        return new JobCancellationException(message == null ? $this.cancellationExceptionMessage() : message, cause, $this);
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String message, Throwable cause) {
        return new JobCancellationException(message == null ? cancellationExceptionMessage() : message, cause, this);
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException getChildJobCancellationCause() {
        Throwable rootCause;
        Object state = getState$kotlinx_coroutines_core();
        if (state instanceof Finishing) {
            rootCause = ((Finishing) state).getRootCause();
        } else if (state instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state).cause;
        } else {
            if (state instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        return cancellationException == null ? new JobCancellationException("Parent job is " + stateString(state), rootCause, this) : cancellationException;
    }

    private final Throwable createCauseException(Object cause) {
        if (!(cause == null ? true : cause instanceof Throwable)) {
            Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            return ((ParentJob) cause).getChildJobCancellationCause();
        }
        Throwable th = (Throwable) cause;
        if (th != null) {
            return th;
        }
        return new JobCancellationException(cancellationExceptionMessage(), null, this);
    }

    private final Object makeCancelling(Object cause) {
        Object causeExceptionCache;
        Symbol symbol;
        Symbol symbol2;
        Object causeExceptionCache2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Throwable th = null;
        while (true) {
            Throwable causeException = th;
            Object state = getState$kotlinx_coroutines_core();
            if (state instanceof Finishing) {
                synchronized (state) {
                    try {
                        if (((Finishing) state).isSealed()) {
                            symbol2 = JobSupportKt.TOO_LATE_TO_CANCEL;
                            return symbol2;
                        }
                        boolean wasCancelling = ((Finishing) state).isCancelling();
                        if (cause != null || !wasCancelling) {
                            if (causeException == null) {
                                Throwable it = createCauseException(cause);
                                causeExceptionCache = it;
                                causeException = it;
                            } else {
                                causeExceptionCache = causeException;
                            }
                            try {
                                ((Finishing) state).addExceptionLocked(causeException);
                            } catch (Throwable th2) {
                                notifyRootCause = th2;
                                throw notifyRootCause;
                            }
                        }
                        Throwable notifyRootCause = wasCancelling ? false : true ? ((Finishing) state).getRootCause() : null;
                        if (notifyRootCause != null) {
                            notifyCancelling(((Finishing) state).getList(), notifyRootCause);
                        }
                        symbol = JobSupportKt.COMPLETING_ALREADY;
                        return symbol;
                    } catch (Throwable th3) {
                        notifyRootCause = th3;
                    }
                }
            } else {
                if (!(state instanceof Incomplete)) {
                    causeExceptionCache2 = JobSupportKt.TOO_LATE_TO_CANCEL;
                    return causeExceptionCache2;
                }
                if (causeException == null) {
                    Throwable it2 = createCauseException(cause);
                    causeException = it2;
                    th = it2;
                } else {
                    th = causeException;
                }
                if (!((Incomplete) state).getIsActive()) {
                    Object finalState = tryMakeCompleting(state, new CompletedExceptionally(causeException, false, 2, null));
                    symbol3 = JobSupportKt.COMPLETING_ALREADY;
                    if (finalState == symbol3) {
                        throw new IllegalStateException(("Cannot happen in " + state).toString());
                    }
                    symbol4 = JobSupportKt.COMPLETING_RETRY;
                    if (finalState != symbol4) {
                        return finalState;
                    }
                } else if (tryMakeCancelling((Incomplete) state, causeException)) {
                    symbol5 = JobSupportKt.COMPLETING_ALREADY;
                    return symbol5;
                }
            }
        }
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList list = state.getList();
        if (list == null) {
            if (state instanceof Empty) {
                return new NodeList();
            }
            if (state instanceof JobNode) {
                promoteSingleToNodeList((JobNode) state);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + state).toString());
        }
        return list;
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(state instanceof Finishing))) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !state.getIsActive()) {
            throw new AssertionError();
        }
        NodeList list = getOrPromoteCancellingList(state);
        if (list == null) {
            return false;
        }
        Finishing cancelling = new Finishing(list, false, rootCause);
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, cancelling)) {
            return false;
        }
        notifyCancelling(list, rootCause);
        return true;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object proposedUpdate) {
        Object finalState;
        Symbol symbol;
        Symbol symbol2;
        do {
            Object state = getState$kotlinx_coroutines_core();
            finalState = tryMakeCompleting(state, proposedUpdate);
            symbol = JobSupportKt.COMPLETING_ALREADY;
            if (finalState == symbol) {
                return false;
            }
            if (finalState == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
            symbol2 = JobSupportKt.COMPLETING_RETRY;
        } while (finalState == symbol2);
        afterCompletion(finalState);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object proposedUpdate) {
        Object finalState;
        Symbol symbol;
        Symbol symbol2;
        do {
            Object state = getState$kotlinx_coroutines_core();
            finalState = tryMakeCompleting(state, proposedUpdate);
            symbol = JobSupportKt.COMPLETING_ALREADY;
            if (finalState != symbol) {
                symbol2 = JobSupportKt.COMPLETING_RETRY;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, getExceptionOrNull(proposedUpdate));
            }
        } while (finalState == symbol2);
        return finalState;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        Symbol symbol;
        Symbol symbol2;
        if (!(state instanceof Incomplete)) {
            symbol2 = JobSupportKt.COMPLETING_ALREADY;
            return symbol2;
        }
        if (((state instanceof Empty) || (state instanceof JobNode)) && !(state instanceof ChildHandleNode) && !(proposedUpdate instanceof CompletedExceptionally)) {
            if (!tryFinalizeSimpleState((Incomplete) state, proposedUpdate)) {
                symbol = JobSupportKt.COMPLETING_RETRY;
                return symbol;
            }
            return proposedUpdate;
        }
        return tryMakeCompletingSlowPath((Incomplete) state, proposedUpdate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        NodeList list = getOrPromoteCancellingList(state);
        if (list == null) {
            symbol3 = JobSupportKt.COMPLETING_RETRY;
            return symbol3;
        }
        Finishing finishing = state instanceof Finishing ? (Finishing) state : null;
        if (finishing == null) {
            finishing = new Finishing(list, false, null);
        }
        Ref.ObjectRef notifyRootCause = new Ref.ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                symbol2 = JobSupportKt.COMPLETING_ALREADY;
                return symbol2;
            }
            finishing.setCompleting(true);
            if (finishing != state && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_state$FU, this, state, finishing)) {
                symbol = JobSupportKt.COMPLETING_RETRY;
                return symbol;
            }
            if (DebugKt.getASSERTIONS_ENABLED() && !(!finishing.isSealed())) {
                throw new AssertionError();
            }
            boolean wasCancelling = finishing.isCancelling();
            CompletedExceptionally it = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
            if (it != null) {
                finishing.addExceptionLocked(it.cause);
            }
            notifyRootCause.element = Boolean.valueOf(wasCancelling ? false : true).booleanValue() ? finishing.getRootCause() : 0;
            Unit unit = Unit.INSTANCE;
            Throwable it2 = (Throwable) notifyRootCause.element;
            if (it2 != null) {
                notifyCancelling(list, it2);
            }
            ChildHandleNode child = firstChild(state);
            return (child == null || !tryWaitForChild(finishing, child, proposedUpdate)) ? finalizeFinishingState(finishing, proposedUpdate) : JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
    }

    private final Throwable getExceptionOrNull(Object $this$exceptionOrNull) {
        CompletedExceptionally completedExceptionally = $this$exceptionOrNull instanceof CompletedExceptionally ? (CompletedExceptionally) $this$exceptionOrNull : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete state) {
        ChildHandleNode childHandleNode = state instanceof ChildHandleNode ? (ChildHandleNode) state : null;
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = state.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (true) {
            ChildJob childJob = child.childJob;
            CompletionHandlerBase $this$asHandler$iv = new ChildCompletion(this, state, child, proposedUpdate);
            DisposableHandle handle = Job.DefaultImpls.invokeOnCompletion$default(childJob, false, false, $this$asHandler$iv, 1, null);
            if (handle != NonDisposableHandle.INSTANCE) {
                return true;
            }
            ChildHandleNode nextChild = nextChild(child);
            if (nextChild == null) {
                return false;
            }
            child = nextChild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getState$kotlinx_coroutines_core() == state)) {
                throw new AssertionError();
            }
        }
        ChildHandleNode waitChild = nextChild(lastChild);
        if (waitChild == null || !tryWaitForChild(state, waitChild, proposedUpdate)) {
            Object finalState = finalizeFinishingState(state, proposedUpdate);
            afterCompletion(finalState);
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode $this$nextChild) {
        LockFreeLinkedListNode cur = $this$nextChild;
        while (cur.isRemoved()) {
            cur = cur.getPrevNode();
        }
        while (true) {
            cur = cur.getNextNode();
            if (!cur.isRemoved()) {
                if (cur instanceof ChildHandleNode) {
                    return (ChildHandleNode) cur;
                }
                if (cur instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob child) {
        CompletionHandlerBase $this$asHandler$iv = new ChildHandleNode(child);
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, $this$asHandler$iv, 2, null);
        Intrinsics.checkNotNull(invokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) invokeOnCompletion$default;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        throw exception;
    }

    protected void onCancelling(Throwable cause) {
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    /* renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    protected boolean handleJobException(Throwable exception) {
        return false;
    }

    protected void onCompletionInternal(Object state) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterCompletion(Object state) {
    }

    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        return state instanceof Finishing ? ((Finishing) state).isCancelling() ? "Cancelling" : ((Finishing) state).isCompleting() ? "Completing" : "Active" : state instanceof Incomplete ? ((Incomplete) state).getIsActive() ? "Active" : "New" : state instanceof CompletedExceptionally ? "Cancelled" : "Completed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\b\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0)2\b\u0010*\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0017\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", "value", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class Finishing implements Incomplete {

        @Volatile
        private volatile Object _exceptionsHolder;

        @Volatile
        private volatile int _isCompleting;

        @Volatile
        private volatile Object _rootCause;
        private final NodeList list;
        private static final AtomicIntegerFieldUpdater _isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting");
        private static final AtomicReferenceFieldUpdater _rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause");
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder");

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList nodeList, boolean z, Throwable th) {
            this.list = nodeList;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final boolean isCompleting() {
            return _isCompleting$FU.get(this) != 0;
        }

        public final void setCompleting(boolean z) {
            _isCompleting$FU.set(this, z ? 1 : 0);
        }

        public final Throwable getRootCause() {
            return (Throwable) _rootCause$FU.get(this);
        }

        public final void setRootCause(Throwable value) {
            _rootCause$FU.set(this, value);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object value) {
            _exceptionsHolder$FU.set(this, value);
        }

        public final boolean isSealed() {
            Symbol symbol;
            Object exceptionsHolder = getExceptionsHolder();
            symbol = JobSupportKt.SEALED;
            return exceptionsHolder == symbol;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: isActive */
        public boolean getIsActive() {
            return getRootCause() == null;
        }

        public final List<Throwable> sealLocked(Throwable proposedException) {
            ArrayList it;
            Symbol symbol;
            Object eh = getExceptionsHolder();
            if (eh == null) {
                it = allocateList();
            } else if (eh instanceof Throwable) {
                it = allocateList();
                it.add(eh);
            } else {
                if (!(eh instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + eh).toString());
                }
                it = (ArrayList) eh;
            }
            ArrayList list = it;
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                list.add(0, rootCause);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                list.add(proposedException);
            }
            symbol = JobSupportKt.SEALED;
            setExceptionsHolder(symbol);
            return list;
        }

        public final void addExceptionLocked(Throwable exception) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(exception);
                return;
            }
            if (exception == rootCause) {
                return;
            }
            Object eh = getExceptionsHolder();
            if (eh != null) {
                if (eh instanceof Throwable) {
                    if (exception == eh) {
                        return;
                    }
                    ArrayList $this$addExceptionLocked_u24lambda_u242 = allocateList();
                    $this$addExceptionLocked_u24lambda_u242.add(eh);
                    $this$addExceptionLocked_u24lambda_u242.add(exception);
                    setExceptionsHolder($this$addExceptionLocked_u24lambda_u242);
                    return;
                }
                if (!(eh instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + eh).toString());
                }
                ((ArrayList) eh).add(exception);
                return;
            }
            setExceptionsHolder(exception);
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + ']';
        }
    }

    private final boolean isCancelling(Incomplete $this$isCancelling) {
        return ($this$isCancelling instanceof Finishing) && ((Finishing) $this$isCancelling).isCancelling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        public ChildCompletion(JobSupport parent, Finishing state, ChildHandleNode child, Object proposedUpdate) {
            this.parent = parent;
            this.state = state;
            this.child = child;
            this.proposedUpdate = proposedUpdate;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(Continuation<? super T> continuation, JobSupport job) {
            super(continuation, 1);
            this.job = job;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job parent) {
            Throwable it;
            Object state = this.job.getState$kotlinx_coroutines_core();
            if (!(state instanceof Finishing) || (it = ((Finishing) state).getRootCause()) == null) {
                return state instanceof CompletedExceptionally ? ((CompletedExceptionally) state).cause : parent.getCancellationException();
            }
            return it;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state = getState$kotlinx_coroutines_core();
        if (!(state instanceof Incomplete)) {
            return getExceptionOrNull(state);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state = getState$kotlinx_coroutines_core();
        if (!(!(state instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (state instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state).cause;
        }
        return JobSupportKt.unboxState(state);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object awaitInternal(Continuation<Object> continuation) {
        Object state;
        do {
            state = getState$kotlinx_coroutines_core();
            if (!(state instanceof Incomplete)) {
                if (state instanceof CompletedExceptionally) {
                    Throwable exception$iv = ((CompletedExceptionally) state).cause;
                    if (!DebugKt.getRECOVER_STACK_TRACES()) {
                        throw exception$iv;
                    }
                    if (continuation instanceof CoroutineStackFrame) {
                        throw StackTraceRecoveryKt.recoverFromStackFrame(exception$iv, (CoroutineStackFrame) continuation);
                    }
                    throw exception$iv;
                }
                return JobSupportKt.unboxState(state);
            }
        } while (startInternal(state) < 0);
        return awaitSuspend(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation cont = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        cont.initCancellability();
        CompletionHandlerBase $this$asHandler$iv = new ResumeAwaitOnCompletion(cont);
        CancellableContinuationKt.disposeOnCancellation(cont, invokeOnCompletion($this$asHandler$iv));
        Object result = cont.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SelectClause1<?> getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAwaitInternalRegFunc(SelectInstance<?> select, Object ignoredParam) {
        Object state;
        do {
            state = getState$kotlinx_coroutines_core();
            if (!(state instanceof Incomplete)) {
                Object result = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
                select.selectInRegistrationPhase(result);
                return;
            }
        } while (startInternal(state) < 0);
        CompletionHandlerBase $this$asHandler$iv = new SelectOnAwaitCompletionHandler(select);
        DisposableHandle disposableHandle = invokeOnCompletion($this$asHandler$iv);
        select.disposeOnCompletion(disposableHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onAwaitInternalProcessResFunc(Object ignoredParam, Object result) {
        if (result instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) result).cause;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JobSupport.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes5.dex */
    public final class SelectOnAwaitCompletionHandler extends JobNode {
        private final SelectInstance<?> select;

        public SelectOnAwaitCompletionHandler(SelectInstance<?> selectInstance) {
            this.select = selectInstance;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            Object state = JobSupport.this.getState$kotlinx_coroutines_core();
            Object result = state instanceof CompletedExceptionally ? state : JobSupportKt.unboxState(state);
            this.select.trySelect(JobSupport.this, result);
        }
    }
}
