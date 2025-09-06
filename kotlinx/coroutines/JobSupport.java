package kotlinx.coroutines;

import androidx.appcompat.app.o;
import e1.u;
import e2.a;
import ie.H;
import ie.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@d
@Metadata(d1 = {"\u0000\u00B2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u00A9\u0001\u00AA\u0001\u00AB\u0001B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0001H\u0004\u00A2\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\u0004\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0011\u0010\u0012\u001A\u00060\u0010j\u0002`\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001A\u00060\u0010j\u0002`\u0011*\u00020\u00142\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u001D\u001A\u00020\u001C2\u0018\u0010\u001B\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\t0\u0019j\u0002`\u001A\u00A2\u0006\u0004\b\u001D\u0010\u001EJ7\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\u00042\u0018\u0010\u001B\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\t0\u0019j\u0002`\u001A\u00A2\u0006\u0004\b\u001D\u0010!J\u001F\u0010&\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u00042\u0006\u0010#\u001A\u00020\"H\u0000\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010\'\u001A\u00020\tH\u0086@\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010+\u001A\u00020\t2\u0006\u0010#\u001A\u00020\"H\u0000\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010-\u001A\u00020\t2\u000E\u0010,\u001A\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020\t2\u0006\u0010,\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b1\u00102J\u0015\u00104\u001A\u00020\t2\u0006\u00103\u001A\u00020\u0003\u00A2\u0006\u0004\b4\u00105J\u0017\u00106\u001A\u00020\u00042\u0006\u0010,\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\u00042\b\u0010,\u001A\u0004\u0018\u00010\u0014\u00A2\u0006\u0004\b8\u00107J\u0019\u0010<\u001A\u00020\u00042\b\u0010,\u001A\u0004\u0018\u000109H\u0000\u00A2\u0006\u0004\b:\u0010;J\u0013\u0010=\u001A\u00060\u0010j\u0002`\u0011H\u0016\u00A2\u0006\u0004\b=\u0010\u0013J\u0019\u0010@\u001A\u00020\u00042\b\u0010>\u001A\u0004\u0018\u000109H\u0000\u00A2\u0006\u0004\b?\u0010;J\u001B\u0010C\u001A\u0004\u0018\u0001092\b\u0010>\u001A\u0004\u0018\u000109H\u0000\u00A2\u0006\u0004\bA\u0010BJ\u0015\u0010F\u001A\u00020E2\u0006\u0010D\u001A\u00020\u0002\u00A2\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001A\u00020\t2\u0006\u0010H\u001A\u00020\u0014H\u0010\u00A2\u0006\u0004\bI\u00102J\u0019\u0010\u001F\u001A\u00020\t2\b\u0010,\u001A\u0004\u0018\u00010\u0014H\u0014\u00A2\u0006\u0004\b\u001F\u00102J\u0017\u0010K\u001A\u00020\u00042\u0006\u0010H\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\bK\u00107J\u0019\u0010M\u001A\u00020\t2\b\u0010L\u001A\u0004\u0018\u000109H\u0014\u00A2\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001A\u00020\t2\b\u0010L\u001A\u0004\u0018\u000109H\u0014\u00A2\u0006\u0004\bO\u0010NJ\u000F\u0010P\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\bP\u00100J\u000F\u0010Q\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\bQ\u00100J\u000F\u0010S\u001A\u00020\u0015H\u0010\u00A2\u0006\u0004\bR\u00100J\u0011\u0010V\u001A\u0004\u0018\u000109H\u0000\u00A2\u0006\u0004\bT\u0010UJ\u0012\u0010W\u001A\u0004\u0018\u000109H\u0084@\u00A2\u0006\u0004\bW\u0010(J#\u0010Y\u001A\u0004\u0018\u0001092\u0006\u0010L\u001A\u00020X2\b\u0010>\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bY\u0010ZJ\'\u0010]\u001A\u0004\u0018\u00010\u00142\u0006\u0010L\u001A\u00020X2\f\u0010\\\u001A\b\u0012\u0004\u0012\u00020\u00140[H\u0002\u00A2\u0006\u0004\b]\u0010^J%\u0010`\u001A\u00020\t2\u0006\u0010_\u001A\u00020\u00142\f\u0010\\\u001A\b\u0012\u0004\u0012\u00020\u00140[H\u0002\u00A2\u0006\u0004\b`\u0010aJ!\u0010d\u001A\u00020\u00042\u0006\u0010L\u001A\u00020b2\b\u0010c\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bd\u0010eJ!\u0010f\u001A\u00020\t2\u0006\u0010L\u001A\u00020b2\b\u0010c\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bf\u0010gJ\u001F\u0010j\u001A\u00020\t2\u0006\u0010i\u001A\u00020h2\u0006\u0010,\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001A\u00020\u00042\u0006\u0010,\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\bl\u00107J\u001D\u0010m\u001A\u00020\t*\u00020h2\b\u0010,\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\bm\u0010kJ\u0019\u0010o\u001A\u00020n2\b\u0010L\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bo\u0010pJ\u0017\u0010r\u001A\u00020\t2\u0006\u0010L\u001A\u00020qH\u0002\u00A2\u0006\u0004\br\u0010sJ\u0017\u0010t\u001A\u00020\t2\u0006\u0010L\u001A\u00020\"H\u0002\u00A2\u0006\u0004\bt\u0010*J\u000F\u0010u\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bu\u0010\rJ\u0010\u0010v\u001A\u00020\tH\u0082@\u00A2\u0006\u0004\bv\u0010(J\u001B\u0010w\u001A\u0004\u0018\u0001092\b\u0010,\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bw\u0010BJ\u0019\u0010x\u001A\u00020\u00142\b\u0010,\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bx\u0010yJ\u001B\u0010z\u001A\u0004\u0018\u0001092\b\u0010,\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\bz\u0010BJ\u0019\u0010{\u001A\u0004\u0018\u00010h2\u0006\u0010L\u001A\u00020bH\u0002\u00A2\u0006\u0004\b{\u0010|J\u001F\u0010}\u001A\u00020\u00042\u0006\u0010L\u001A\u00020b2\u0006\u0010_\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b}\u0010~J&\u0010\u007F\u001A\u0004\u0018\u0001092\b\u0010L\u001A\u0004\u0018\u0001092\b\u0010>\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J&\u0010\u0081\u0001\u001A\u0004\u0018\u0001092\u0006\u0010L\u001A\u00020b2\b\u0010>\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J.\u0010\u0084\u0001\u001A\u00020\u00042\u0006\u0010L\u001A\u00020X2\u0007\u0010D\u001A\u00030\u0083\u00012\b\u0010>\u001A\u0004\u0018\u000109H\u0082\u0010\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J.\u0010\u0087\u0001\u001A\u00020\t2\u0006\u0010L\u001A\u00020X2\b\u0010\u0086\u0001\u001A\u00030\u0083\u00012\b\u0010>\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001A\u0010\u008A\u0001\u001A\u0005\u0018\u00010\u0083\u0001*\u00030\u0089\u0001H\u0002\u00A2\u0006\u0006\b\u008A\u0001\u0010\u008B\u0001J\u001C\u0010\u008C\u0001\u001A\u00020\u00152\b\u0010L\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0006\b\u008C\u0001\u0010\u008D\u0001J\u0014\u0010\u008E\u0001\u001A\u0004\u0018\u000109H\u0082@\u00A2\u0006\u0005\b\u008E\u0001\u0010(R\u0019\u0010\u0092\u0001\u001A\u0007\u0012\u0002\b\u00030\u008F\u00018F\u00A2\u0006\b\u001A\u0006\b\u0090\u0001\u0010\u0091\u0001R.\u0010\u0098\u0001\u001A\u0004\u0018\u00010E2\t\u0010\u0093\u0001\u001A\u0004\u0018\u00010E8@@@X\u0080\u000E\u00A2\u0006\u0010\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\b\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u0099\u0001\u0010\u009A\u0001R\u0017\u0010L\u001A\u0004\u0018\u0001098@X\u0080\u0004\u00A2\u0006\u0007\u001A\u0005\b\u009B\u0001\u0010UR\u0016\u0010\u009C\u0001\u001A\u00020\u00048VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u009C\u0001\u0010\rR\u0013\u0010\u009D\u0001\u001A\u00020\u00048F\u00A2\u0006\u0007\u001A\u0005\b\u009D\u0001\u0010\rR\u0013\u0010\u009E\u0001\u001A\u00020\u00048F\u00A2\u0006\u0007\u001A\u0005\b\u009E\u0001\u0010\rR\u0016\u0010\u00A0\u0001\u001A\u00020\u00048PX\u0090\u0004\u00A2\u0006\u0007\u001A\u0005\b\u009F\u0001\u0010\rR\u0016\u0010\u00A1\u0001\u001A\u00020\u00048TX\u0094\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00A1\u0001\u0010\rR\u0016\u0010\u00A3\u0001\u001A\u00020\u00048PX\u0090\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00A2\u0001\u0010\rR\u001E\u0010\u00A5\u0001\u001A\u0004\u0018\u00010\u0014*\u0004\u0018\u0001098BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00A4\u0001\u0010yR\u0015\u0010\u00A7\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u0001090\u00A6\u00018\u0002X\u0082\u0004R\u0015\u0010\u00A8\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010E0\u00A6\u00018\u0002X\u0082\u0004\u00A8\u0006\u00AC\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "", "active", "<init>", "(Z)V", "parent", "Lie/H;", "initParentJob", "(Lkotlinx/coroutines/Job;)V", "start", "()Z", "onStart", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "", "", "message", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lwe/k;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLwe/k;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/JobNode;", "node", "invokeOnCompletionInternal$kotlinx_coroutines_core", "(ZLkotlinx/coroutines/JobNode;)Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletionInternal", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/JobNode;)V", "removeNode", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "()Ljava/lang/String;", "cancelInternal", "(Ljava/lang/Throwable;)V", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "childCancelled", "(Ljava/lang/Throwable;)Z", "cancelCoroutine", "", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "getChildJobCancellationCause", "proposedUpdate", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "makeCompletingOnce", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "handleJobException", "state", "onCompletionInternal", "(Ljava/lang/Object;)V", "afterCompletion", "toString", "toDebugString", "nameString$kotlinx_coroutines_core", "nameString", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "awaitInternal", "Lkotlinx/coroutines/JobSupport$Finishing;", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "", "exceptions", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/Incomplete;", "update", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/NodeList;", "list", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "cancelParent", "notifyCompletion", "", "startInternal", "(Ljava/lang/Object;)I", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "joinInternal", "joinSuspend", "cancelMakeCompleting", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "makeCancelling", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/ChildHandleNode;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "lastChild", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "awaitSuspend", "Lme/h;", "getKey", "()Lme/h;", "key", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getParent", "()Lkotlinx/coroutines/Job;", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "isScopedCoroutine", "getHandlesException$kotlinx_coroutines_core", "handlesException", "getExceptionOrNull", "exceptionOrNull", "Lkotlinx/atomicfu/AtomicRef;", "_state", "_parentHandle", "Finishing", "ChildCompletion", "AwaitContinuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class JobSupport implements ChildJob, Job, ParentJob {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0014R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class AwaitContinuation extends CancellableContinuationImpl {
        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation continuation0, @NotNull JobSupport jobSupport0) {
            super(continuation0, 1);
            this.job = jobSupport0;
        }

        @Override  // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job0) {
            Object object0 = this.job.getState$kotlinx_coroutines_core();
            if(object0 instanceof Finishing) {
                Throwable throwable0 = ((Finishing)object0).getRootCause();
                if(throwable0 != null) {
                    return throwable0;
                }
            }
            return object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0).cause : job0.getCancellationException();
        }

        @Override  // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0016\u0010\t\u001A\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "parent", "Lkotlinx/coroutines/JobSupport$Finishing;", "state", "Lkotlinx/coroutines/ChildHandleNode;", "child", "", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "Ljava/lang/Object;", "", "getOnCancelling", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class ChildCompletion extends JobNode {
        @NotNull
        private final ChildHandleNode child;
        @NotNull
        private final JobSupport parent;
        @Nullable
        private final Object proposedUpdate;
        @NotNull
        private final Finishing state;

        public ChildCompletion(@NotNull JobSupport jobSupport0, @NotNull Finishing jobSupport$Finishing0, @NotNull ChildHandleNode childHandleNode0, @Nullable Object object0) {
            this.parent = jobSupport0;
            this.state = jobSupport$Finishing0;
            this.child = childHandleNode0;
            this.proposedUpdate = object0;
        }

        @Override  // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override  // kotlinx.coroutines.JobNode
        public void invoke(@Nullable Throwable throwable0) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\b0\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\b\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR(\u0010#\u001A\u0004\u0018\u00010\u00012\b\u0010\u001E\u001A\u0004\u0018\u00010\u00018B@BX\u0082\u000E\u00A2\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R$\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u00068F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\u0007\u0010$\"\u0004\b%\u0010&R(\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u001E\u001A\u0004\u0018\u00010\b8F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010\u0017R\u0011\u0010*\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b*\u0010$R\u0011\u0010+\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\b+\u0010$R\u0014\u0010,\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010$R\u000B\u0010.\u001A\u00020-8\u0002X\u0082\u0004R\u0013\u00100\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0/8\u0002X\u0082\u0004R\u0013\u00101\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010/8\u0002X\u0082\u0004\u00A8\u00062"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lie/H;", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "()Z", "setCompleting", "(Z)V", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "isSealed", "isCancelling", "isActive", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleting", "Lkotlinx/atomicfu/AtomicRef;", "_rootCause", "_exceptionsHolder", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder$volatile;
        private static final AtomicReferenceFieldUpdater _exceptionsHolder$volatile$FU;
        private volatile int _isCompleting$volatile;
        private static final AtomicIntegerFieldUpdater _isCompleting$volatile$FU;
        private volatile Object _rootCause$volatile;
        private static final AtomicReferenceFieldUpdater _rootCause$volatile$FU;
        @NotNull
        private final NodeList list;

        static {
            Finishing._isCompleting$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");
            Finishing._rootCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");
            Finishing._exceptionsHolder$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");
        }

        public Finishing(@NotNull NodeList nodeList0, boolean z, @Nullable Throwable throwable0) {
            this.list = nodeList0;
            this._isCompleting$volatile = z;
            this._rootCause$volatile = throwable0;
        }

        public final void addExceptionLocked(@NotNull Throwable throwable0) {
            Throwable throwable1 = this.getRootCause();
            if(throwable1 == null) {
                this.setRootCause(throwable0);
                return;
            }
            if(throwable0 != throwable1) {
                Object object0 = this.getExceptionsHolder();
                if(object0 == null) {
                    this.setExceptionsHolder(throwable0);
                    return;
                }
                if(!(object0 instanceof Throwable)) {
                    if(!(object0 instanceof ArrayList)) {
                        throw new IllegalStateException(("State is " + object0).toString());
                    }
                    ((ArrayList)object0).add(throwable0);
                }
                else if(throwable0 != object0) {
                    ArrayList arrayList0 = this.allocateList();
                    arrayList0.add(object0);
                    arrayList0.add(throwable0);
                    this.setExceptionsHolder(arrayList0);
                }
            }
        }

        private final ArrayList allocateList() {
            return new ArrayList(4);
        }

        private final Object getExceptionsHolder() {
            return Finishing.get_exceptionsHolder$volatile$FU().get(this);
        }

        @Override  // kotlinx.coroutines.Incomplete
        @NotNull
        public NodeList getList() {
            return this.list;
        }

        @Nullable
        public final Throwable getRootCause() {
            return (Throwable)Finishing._rootCause$volatile$FU.get(this);
        }

        @Override  // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return this.getRootCause() == null;
        }

        public final boolean isCancelling() {
            return this.getRootCause() != null;
        }

        public final boolean isCompleting() {
            return Finishing._isCompleting$volatile$FU.get(this) == 1;
        }

        public final boolean isSealed() {
            return this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
        }

        @NotNull
        public final List sealLocked(@Nullable Throwable throwable0) {
            List list0;
            Object object0 = this.getExceptionsHolder();
            if(object0 == null) {
                list0 = this.allocateList();
            }
            else if(object0 instanceof Throwable) {
                ArrayList arrayList0 = this.allocateList();
                arrayList0.add(object0);
                list0 = arrayList0;
            }
            else if(object0 instanceof ArrayList) {
                list0 = (ArrayList)object0;
            }
            else {
                throw new IllegalStateException(("State is " + object0).toString());
            }
            Throwable throwable1 = this.getRootCause();
            if(throwable1 != null) {
                ((ArrayList)list0).add(0, throwable1);
            }
            if(throwable0 != null && !throwable0.equals(throwable1)) {
                ((ArrayList)list0).add(throwable0);
            }
            this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return list0;
        }

        public final void setCompleting(boolean z) {
            Finishing._isCompleting$volatile$FU.set(this, ((int)z));
        }

        private final void setExceptionsHolder(Object object0) {
            Finishing._exceptionsHolder$volatile$FU.set(this, object0);
        }

        public final void setRootCause(@Nullable Throwable throwable0) {
            Finishing._rootCause$volatile$FU.set(this, throwable0);
        }

        @Override
        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + this.isCancelling() + ", completing=" + this.isCompleting() + ", rootCause=" + this.getRootCause() + ", exceptions=" + this.getExceptionsHolder() + ", list=" + this.getList() + ']';
        }
    }

    private volatile Object _parentHandle$volatile;
    private static final AtomicReferenceFieldUpdater _parentHandle$volatile$FU;
    private volatile Object _state$volatile;
    private static final AtomicReferenceFieldUpdater _state$volatile$FU;

    static {
        JobSupport._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
        JobSupport._parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
    }

    // 去混淆评级： 低(20)
    public static final String access$cancellationExceptionMessage(JobSupport jobSupport0) {
        return "Job was cancelled";
    }

    private final void addSuppressedExceptions(Throwable throwable0, List list0) {
        if(list0.size() > 1) {
            Set set0 = Collections.newSetFromMap(new IdentityHashMap(list0.size()));
            for(Object object0: list0) {
                Throwable throwable1 = (Throwable)object0;
                if(throwable1 != throwable0 && !(throwable1 instanceof CancellationException) && set0.add(throwable1)) {
                    a.q(throwable0, throwable1);
                }
            }
        }
    }

    public void afterCompletion(@Nullable Object object0) {
    }

    @Override  // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob0) {
        Throwable throwable0;
        ChildHandle childHandle0 = new ChildHandleNode(childJob0);
        ((JobNode)childHandle0).setJob(this);
        while(true) {
            throwable0 = null;
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof Empty)) {
                if(object0 instanceof Incomplete) {
                    NodeList nodeList0 = ((Incomplete)object0).getList();
                    if(nodeList0 == null) {
                        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.promoteSingleToNodeList(((JobNode)object0));
                        continue;
                    }
                    if(!nodeList0.addLast(((LockFreeLinkedListNode)childHandle0), 7)) {
                        boolean z = nodeList0.addLast(((LockFreeLinkedListNode)childHandle0), 3);
                        Object object1 = this.getState$kotlinx_coroutines_core();
                        if(object1 instanceof Finishing) {
                            throwable0 = ((Finishing)object1).getRootCause();
                        }
                        else {
                            CompletedExceptionally completedExceptionally0 = object1 instanceof CompletedExceptionally ? ((CompletedExceptionally)object1) : null;
                            if(completedExceptionally0 != null) {
                                throwable0 = completedExceptionally0.cause;
                            }
                        }
                        ((ChildHandleNode)childHandle0).invoke(throwable0);
                        if(!z) {
                            return NonDisposableHandle.INSTANCE;
                        }
                    }
                    return childHandle0;
                }
                break;
            }
            if(((Empty)object0).isActive()) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, childHandle0)) {
                        return childHandle0;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == object0);
            }
            else {
                this.promoteEmptyToNodeList(((Empty)object0));
            }
        }
        Object object2 = this.getState$kotlinx_coroutines_core();
        CompletedExceptionally completedExceptionally1 = object2 instanceof CompletedExceptionally ? ((CompletedExceptionally)object2) : null;
        if(completedExceptionally1 != null) {
            throwable0 = completedExceptionally1.cause;
        }
        ((ChildHandleNode)childHandle0).invoke(throwable0);
        return NonDisposableHandle.INSTANCE;
    }

    @Nullable
    public final Object awaitInternal(@NotNull Continuation continuation0) {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof Incomplete)) {
                if(object0 instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally)object0).cause;
                }
                return JobSupportKt.unboxState(object0);
            }
        }
        while(this.startInternal(object0) < 0);
        return this.awaitSuspend(continuation0);
    }

    private final Object awaitSuspend(Continuation continuation0) {
        AwaitContinuation jobSupport$AwaitContinuation0 = new AwaitContinuation(u.D(continuation0), this);
        jobSupport$AwaitContinuation0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(jobSupport$AwaitContinuation0, JobKt.invokeOnCompletion$default(this, false, new ResumeAwaitOnCompletion(jobSupport$AwaitContinuation0), 1, null));
        return jobSupport$AwaitContinuation0.getResult();
    }

    @Override  // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cancellationException0) {
        if(cancellationException0 == null) {
            cancellationException0 = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), null, this);
        }
        this.cancelInternal(cancellationException0);
    }

    public final boolean cancelCoroutine(@Nullable Throwable throwable0) {
        return this.cancelImpl$kotlinx_coroutines_core(throwable0);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object object0) {
        Symbol symbol0 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if(this.getOnCancelComplete$kotlinx_coroutines_core()) {
            symbol0 = this.cancelMakeCompleting(object0);
            if(symbol0 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        if(symbol0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            symbol0 = this.makeCancelling(object0);
        }
        if(symbol0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            return true;
        }
        if(symbol0 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if(symbol0 == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
            return false;
        }
        this.afterCompletion(symbol0);
        return true;
    }

    public void cancelInternal(@NotNull Throwable throwable0) {
        this.cancelImpl$kotlinx_coroutines_core(throwable0);
    }

    private final Object cancelMakeCompleting(Object object0) {
        while(true) {
            Object object1 = this.getState$kotlinx_coroutines_core();
            if(!(object1 instanceof Incomplete) || object1 instanceof Finishing && ((Finishing)object1).isCompleting()) {
                break;
            }
            Object object2 = this.tryMakeCompleting(object1, new CompletedExceptionally(this.createCauseException(object0), false, 2, null));
            if(object2 != JobSupportKt.access$getCOMPLETING_RETRY$p()) {
                return object2;
            }
        }
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final boolean cancelParent(Throwable throwable0) {
        if(this.isScopedCoroutine()) {
            return true;
        }
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        return childHandle0 == null || childHandle0 == NonDisposableHandle.INSTANCE ? throwable0 instanceof CancellationException : childHandle0.childCancelled(throwable0) || throwable0 instanceof CancellationException;
    }

    @NotNull
    public String cancellationExceptionMessage() [...] // 潜在的解密器

    // 去混淆评级： 低(40)
    public boolean childCancelled(@NotNull Throwable throwable0) {
        return throwable0 instanceof CancellationException ? true : this.cancelImpl$kotlinx_coroutines_core(throwable0) && this.getHandlesException$kotlinx_coroutines_core();
    }

    private final void completeStateFinalization(Incomplete incomplete0, Object object0) {
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        if(childHandle0 != null) {
            childHandle0.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        Throwable throwable0 = null;
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        if(completedExceptionally0 != null) {
            throwable0 = completedExceptionally0.cause;
        }
        if(incomplete0 instanceof JobNode) {
            try {
                ((JobNode)incomplete0).invoke(throwable0);
            }
            catch(Throwable throwable1) {
                this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete0 + " for " + this, throwable1));
            }
            return;
        }
        NodeList nodeList0 = incomplete0.getList();
        if(nodeList0 != null) {
            this.notifyCompletion(nodeList0, throwable0);
        }
    }

    private final void continueCompleting(Finishing jobSupport$Finishing0, ChildHandleNode childHandleNode0, Object object0) {
        ChildHandleNode childHandleNode1 = this.nextChild(childHandleNode0);
        if(childHandleNode1 == null || !this.tryWaitForChild(jobSupport$Finishing0, childHandleNode1, object0)) {
            jobSupport$Finishing0.getList().close(2);
            ChildHandleNode childHandleNode2 = this.nextChild(childHandleNode0);
            if(childHandleNode2 == null || !this.tryWaitForChild(jobSupport$Finishing0, childHandleNode2, object0)) {
                this.afterCompletion(this.finalizeFinishingState(jobSupport$Finishing0, object0));
            }
        }
    }

    private final Throwable createCauseException(Object object0) {
        if((object0 == null ? true : object0 instanceof Throwable)) {
            return ((Throwable)object0) == null ? new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), null, this) : ((Throwable)object0);
        }
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob)object0).getChildJobCancellationCause();
    }

    private final Object finalizeFinishingState(Finishing jobSupport$Finishing0, Object object0) {
        Throwable throwable1;
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        Throwable throwable0 = completedExceptionally0 == null ? null : completedExceptionally0.cause;
        synchronized(jobSupport$Finishing0) {
            jobSupport$Finishing0.isCancelling();
            List list0 = jobSupport$Finishing0.sealLocked(throwable0);
            throwable1 = this.getFinalRootCause(jobSupport$Finishing0, list0);
            if(throwable1 != null) {
                this.addSuppressedExceptions(throwable1, list0);
            }
        }
        if(throwable1 != null && throwable1 != throwable0) {
            object0 = new CompletedExceptionally(throwable1, false, 2, null);
        }
        if(throwable1 != null && (this.cancelParent(throwable1) || this.handleJobException(throwable1))) {
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally)object0).makeHandled();
        }
        this.onCompletionInternal(object0);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport.get_state$volatile$FU();
        Object object1 = JobSupportKt.boxIncomplete(object0);
        while(!atomicReferenceFieldUpdater0.compareAndSet(this, jobSupport$Finishing0, object1) && atomicReferenceFieldUpdater0.get(this) == jobSupport$Finishing0) {
        }
        this.completeStateFinalization(jobSupport$Finishing0, object0);
        return object0;
    }

    @Override  // me.i
    public Object fold(Object object0, @NotNull n n0) {
        return DefaultImpls.fold(this, object0, n0);
    }

    @Override  // me.i
    @Nullable
    public g get(@NotNull h h0) {
        return DefaultImpls.get(this, h0);
    }

    @Override  // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof Finishing) {
            Throwable throwable0 = ((Finishing)object0).getRootCause();
            if(throwable0 != null) {
                CancellationException cancellationException0 = this.toCancellationException(throwable0, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if(cancellationException0 != null) {
                    return cancellationException0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if(object0 instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        return object0 instanceof CompletedExceptionally ? JobSupport.toCancellationException$default(this, ((CompletedExceptionally)object0).cause, null, 1, null) : new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
    }

    @Override  // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable throwable0;
        Object object0 = this.getState$kotlinx_coroutines_core();
        CancellationException cancellationException0 = null;
        if(object0 instanceof Finishing) {
            throwable0 = ((Finishing)object0).getRootCause();
        }
        else if(object0 instanceof CompletedExceptionally) {
            throwable0 = ((CompletedExceptionally)object0).cause;
        }
        else if(!(object0 instanceof Incomplete)) {
            throwable0 = null;
        }
        else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + object0).toString());
        }
        if(throwable0 instanceof CancellationException) {
            cancellationException0 = (CancellationException)throwable0;
        }
        return cancellationException0 == null ? new JobCancellationException("Parent job is " + this.stateString(object0), throwable0, this) : cancellationException0;
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        return JobSupportKt.unboxState(object0);
    }

    private final Throwable getExceptionOrNull(Object object0) {
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        return completedExceptionally0 == null ? null : completedExceptionally0.cause;
    }

    private final Throwable getFinalRootCause(Finishing jobSupport$Finishing0, List list0) {
        if(list0.isEmpty()) {
            return jobSupport$Finishing0.isCancelling() ? new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), null, this) : null;
        }
        Object object0 = null;
        for(Object object1: list0) {
            if(!(((Throwable)object1) instanceof CancellationException)) {
                object0 = object1;
                break;
            }
        }
        if(((Throwable)object0) != null) {
            return (Throwable)object0;
        }
        Throwable throwable0 = (Throwable)list0.get(0);
        if(throwable0 instanceof TimeoutCancellationException) {
            for(Object object2: list0) {
                if(((Throwable)object2) != throwable0 && ((Throwable)object2) instanceof TimeoutCancellationException) {
                    return ((Throwable)object2) == null ? throwable0 : ((Throwable)object2);
                }
                if(false) {
                    break;
                }
            }
            return throwable0;
        }
        return throwable0;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override  // me.g
    @NotNull
    public final h getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete0) {
        NodeList nodeList0 = incomplete0.getList();
        if(nodeList0 == null) {
            if(incomplete0 instanceof Empty) {
                return new NodeList();
            }
            if(!(incomplete0 instanceof JobNode)) {
                throw new IllegalStateException(("State should have list: " + incomplete0).toString());
            }
            this.promoteSingleToNodeList(((JobNode)incomplete0));
            return null;
        }
        return nodeList0;
    }

    @Nullable
    public Job getParent() {
        ChildHandle childHandle0 = this.getParentHandle$kotlinx_coroutines_core();
        return childHandle0 == null ? null : childHandle0.getParent();
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)JobSupport._parentHandle$volatile$FU.get(this);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return JobSupport._state$volatile$FU.get(this);
    }

    public boolean handleJobException(@NotNull Throwable throwable0) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable throwable0) {
        throw throwable0;
    }

    public final void initParentJob(@Nullable Job job0) {
        if(job0 == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        job0.start();
        ChildHandle childHandle0 = job0.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core(childHandle0);
        if(this.isCompleted()) {
            childHandle0.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override  // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull k k0) {
        return this.invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(k0));
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z1, @NotNull k k0) {
        return z ? this.invokeOnCompletionInternal$kotlinx_coroutines_core(z1, new InvokeOnCancelling(k0)) : this.invokeOnCompletionInternal$kotlinx_coroutines_core(z1, new InvokeOnCompletion(k0));
    }

    @NotNull
    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z, @NotNull JobNode jobNode0) {
        boolean z2;
        Throwable throwable0;
        boolean z1;
        jobNode0.setJob(this);
    alab1:
        while(true) {
            Object object0 = this.getState$kotlinx_coroutines_core();
            z1 = true;
            throwable0 = null;
            if(object0 instanceof Empty) {
                if(((Empty)object0).isActive()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
                    while(true) {
                        if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, jobNode0)) {
                            break alab1;
                        }
                        if(atomicReferenceFieldUpdater0.get(this) == object0) {
                            continue;
                        }
                        continue alab1;
                    }
                }
                else {
                    this.promoteEmptyToNodeList(((Empty)object0));
                    continue;
                }
            }
            if(object0 instanceof Incomplete) {
                NodeList nodeList0 = ((Incomplete)object0).getList();
                if(nodeList0 == null) {
                    q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    this.promoteSingleToNodeList(((JobNode)object0));
                    continue;
                }
                else {
                    if(jobNode0.getOnCancelling()) {
                        Finishing jobSupport$Finishing0 = ((Incomplete)object0) instanceof Finishing ? ((Finishing)(((Incomplete)object0))) : null;
                        Throwable throwable1 = jobSupport$Finishing0 == null ? null : jobSupport$Finishing0.getRootCause();
                        if(throwable1 == null) {
                            z2 = nodeList0.addLast(jobNode0, 5);
                            goto label_28;
                        }
                        if(z) {
                            jobNode0.invoke(throwable1);
                        }
                        return NonDisposableHandle.INSTANCE;
                    }
                    else {
                        z2 = nodeList0.addLast(jobNode0, 1);
                    }
                label_28:
                    if(!z2) {
                        continue;
                    }
                    break;
                }
            }
            goto label_30;
        }
        goto label_31;
    label_30:
        z1 = false;
    label_31:
        if(z1) {
            return jobNode0;
        }
        if(z) {
            Object object1 = this.getState$kotlinx_coroutines_core();
            CompletedExceptionally completedExceptionally0 = object1 instanceof CompletedExceptionally ? ((CompletedExceptionally)object1) : null;
            if(completedExceptionally0 != null) {
                throwable0 = completedExceptionally0.cause;
            }
            jobNode0.invoke(throwable0);
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Job
    public boolean isActive() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        return object0 instanceof Incomplete && ((Incomplete)object0).isActive();
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        return object0 instanceof CompletedExceptionally || object0 instanceof Finishing && ((Finishing)object0).isCancelling();
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    @Override  // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation continuation0) {
        boolean z = this.joinInternal();
        H h0 = H.a;
        if(!z) {
            JobKt.ensureActive(continuation0.getContext());
            return h0;
        }
        Object object0 = this.joinSuspend(continuation0);
        return object0 == ne.a.a ? object0 : h0;
    }

    private final boolean joinInternal() {
        do {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof Incomplete)) {
                return false;
            }
        }
        while(this.startInternal(object0) < 0);
        return true;
    }

    private final Object joinSuspend(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl0, JobKt.invokeOnCompletion$default(this, false, new ResumeOnCompletion(cancellableContinuationImpl0), 1, null));
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == ne.a.a ? object0 : H.a;
    }

    private final Object makeCancelling(Object object0) {
        Object object2;
        Object object1;
        Throwable throwable0 = null;
        Throwable throwable1 = null;
        do {
            do {
                object1 = this.getState$kotlinx_coroutines_core();
                if(object1 instanceof Finishing) {
                    synchronized(object1) {
                        if(((Finishing)object1).isSealed()) {
                            return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                        }
                        boolean z = ((Finishing)object1).isCancelling();
                        if(object0 != null || !z) {
                            if(throwable1 == null) {
                                throwable1 = this.createCauseException(object0);
                            }
                            ((Finishing)object1).addExceptionLocked(throwable1);
                        }
                        Throwable throwable2 = ((Finishing)object1).getRootCause();
                        if(!z) {
                            throwable0 = throwable2;
                        }
                    }
                    if(throwable0 != null) {
                        this.notifyCancelling(((Finishing)object1).getList(), throwable0);
                    }
                    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
                }
                if(!(object1 instanceof Incomplete)) {
                    return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
                }
                if(throwable1 == null) {
                    throwable1 = this.createCauseException(object0);
                }
                if(!((Incomplete)object1).isActive()) {
                    goto label_29;
                }
            }
            while(!this.tryMakeCancelling(((Incomplete)object1), throwable1));
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        label_29:
            object2 = this.tryMakeCompleting(object1, new CompletedExceptionally(throwable1, false, 2, null));
            if(object2 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                throw new IllegalStateException(("Cannot happen in " + object1).toString());
            }
        }
        while(object2 == JobSupportKt.access$getCOMPLETING_RETRY$p());
        return object2;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object object0) {
        Object object1;
        do {
            object1 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object0);
            if(object1 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return false;
            }
            if(object1 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        }
        while(object1 == JobSupportKt.access$getCOMPLETING_RETRY$p());
        this.afterCompletion(object1);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object object0) {
        Object object1;
        while((object1 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), object0)) != JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            if(object1 != JobSupportKt.access$getCOMPLETING_RETRY$p()) {
                return object1;
            }
        }
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + object0, this.getExceptionOrNull(object0));
    }

    @Override  // me.i
    @NotNull
    public i minusKey(@NotNull h h0) {
        return DefaultImpls.minusKey(this, h0);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        while(lockFreeLinkedListNode0.isRemoved()) {
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getPrevNode();
        }
        do {
            do {
                lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
            }
            while(lockFreeLinkedListNode0.isRemoved());
            if(lockFreeLinkedListNode0 instanceof ChildHandleNode) {
                return (ChildHandleNode)lockFreeLinkedListNode0;
            }
        }
        while(!(lockFreeLinkedListNode0 instanceof NodeList));
        return null;
    }

    private final void notifyCancelling(NodeList nodeList0, Throwable throwable0) {
        nodeList0.close(4);
        Object object0 = nodeList0.getNext();
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)object0;
        Throwable throwable1 = null;
        while(!q.b(lockFreeLinkedListNode0, nodeList0)) {
            if(lockFreeLinkedListNode0 instanceof JobNode && ((JobNode)lockFreeLinkedListNode0).getOnCancelling()) {
                try {
                    ((JobNode)lockFreeLinkedListNode0).invoke(throwable0);
                }
                catch(Throwable throwable2) {
                    if(throwable1 == null) {
                        throwable1 = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode0 + " for " + this, throwable2);
                    }
                    else {
                        a.q(throwable1, throwable2);
                    }
                }
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        if(throwable1 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(throwable1);
        }
        this.cancelParent(throwable0);
    }

    private final void notifyCompletion(NodeList nodeList0, Throwable throwable0) {
        nodeList0.close(1);
        Object object0 = nodeList0.getNext();
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)object0;
        Throwable throwable1 = null;
        while(!q.b(lockFreeLinkedListNode0, nodeList0)) {
            if(lockFreeLinkedListNode0 instanceof JobNode) {
                try {
                    ((JobNode)lockFreeLinkedListNode0).invoke(throwable0);
                }
                catch(Throwable throwable2) {
                    if(throwable1 == null) {
                        throwable1 = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode0 + " for " + this, throwable2);
                    }
                    else {
                        a.q(throwable1, throwable2);
                    }
                }
            }
            lockFreeLinkedListNode0 = lockFreeLinkedListNode0.getNextNode();
        }
        if(throwable1 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(throwable1);
        }
    }

    public void onCancelling(@Nullable Throwable throwable0) {
    }

    public void onCompletionInternal(@Nullable Object object0) {
    }

    public void onStart() {
    }

    @Override  // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob0) {
        this.cancelImpl$kotlinx_coroutines_core(parentJob0);
    }

    @Override  // me.i
    @NotNull
    public i plus(@NotNull i i0) {
        return DefaultImpls.plus(this, i0);
    }

    private final void promoteEmptyToNodeList(Empty empty0) {
        NodeList nodeList0 = new NodeList();
        if(!empty0.isActive()) {
            nodeList0 = new InactiveNodeList(nodeList0);
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, empty0, nodeList0)) {
                return;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == empty0);
    }

    private final void promoteSingleToNodeList(JobNode jobNode0) {
        jobNode0.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode lockFreeLinkedListNode0 = jobNode0.getNextNode();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, jobNode0, lockFreeLinkedListNode0)) {
                return;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == jobNode0);
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode jobNode0) {
        while(true) {
            Object object0 = this.getState$kotlinx_coroutines_core();
            if(!(object0 instanceof JobNode)) {
                if(!(object0 instanceof Incomplete) || ((Incomplete)object0).getList() == null) {
                    break;
                }
                jobNode0.remove();
                break;
            }
            if(object0 != jobNode0) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
            Empty empty0 = JobSupportKt.access$getEMPTY_ACTIVE$p();
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, empty0)) {
                    return;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == object0);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle0) {
        JobSupport._parentHandle$volatile$FU.set(this, childHandle0);
    }

    @Override  // kotlinx.coroutines.Job
    public final boolean start() {
    alab1:
        while(true) {
            switch(this.startInternal(this.getState$kotlinx_coroutines_core())) {
                case 0: {
                    return false;
                }
                case 1: {
                    break alab1;
                }
            }
        }
        return true;
    }

    private final int startInternal(Object object0) {
        if(object0 instanceof Empty) {
            if(((Empty)object0).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
            Empty empty0 = JobSupportKt.access$getEMPTY_ACTIVE$p();
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, empty0)) {
                    this.onStart();
                    return 1;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == object0);
            return -1;
        }
        if(object0 instanceof InactiveNodeList) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = JobSupport._state$volatile$FU;
            NodeList nodeList0 = ((InactiveNodeList)object0).getList();
            do {
                if(atomicReferenceFieldUpdater1.compareAndSet(this, object0, nodeList0)) {
                    this.onStart();
                    return 1;
                }
            }
            while(atomicReferenceFieldUpdater1.get(this) == object0);
            return -1;
        }
        return 0;
    }

    private final String stateString(Object object0) {
        if(object0 instanceof Finishing) {
            if(((Finishing)object0).isCancelling()) {
                return "Cancelling";
            }
            return ((Finishing)object0).isCompleting() ? "Completing" : "Active";
        }
        if(object0 instanceof Incomplete) {
            return ((Incomplete)object0).isActive() ? "Active" : "New";
        }
        return object0 instanceof CompletedExceptionally ? "Cancelled" : "Completed";
    }

    @NotNull
    public final CancellationException toCancellationException(@NotNull Throwable throwable0, @Nullable String s) {
        CancellationException cancellationException0 = throwable0 instanceof CancellationException ? ((CancellationException)throwable0) : null;
        if(cancellationException0 == null) {
            if(s == null) {
                s = JobSupport.access$cancellationExceptionMessage(this);
            }
            return new JobCancellationException(s, throwable0, this);
        }
        return cancellationException0;
    }

    public static CancellationException toCancellationException$default(JobSupport jobSupport0, Throwable throwable0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if((v & 1) != 0) {
            s = null;
        }
        return jobSupport0.toCancellationException(throwable0, s);
    }

    @NotNull
    public final String toDebugString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.nameString$kotlinx_coroutines_core());
        stringBuilder0.append('{');
        return o.r(stringBuilder0, this.stateString(this.getState$kotlinx_coroutines_core()), '}');
    }

    @Override
    @NotNull
    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete0, Object object0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
        Object object1 = JobSupportKt.boxIncomplete(object0);
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, incomplete0, object1)) {
                this.onCompletionInternal(object0);
                this.completeStateFinalization(incomplete0, object0);
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == incomplete0);
        return false;
    }

    private final boolean tryMakeCancelling(Incomplete incomplete0, Throwable throwable0) {
        NodeList nodeList0 = this.getOrPromoteCancellingList(incomplete0);
        if(nodeList0 == null) {
            return false;
        }
        Finishing jobSupport$Finishing0 = new Finishing(nodeList0, false, throwable0);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, incomplete0, jobSupport$Finishing0)) {
                this.notifyCancelling(nodeList0, throwable0);
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == incomplete0);
        return false;
    }

    private final Object tryMakeCompleting(Object object0, Object object1) {
        if(!(object0 instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if((object0 instanceof Empty || object0 instanceof JobNode) && !(object0 instanceof ChildHandleNode) && !(object1 instanceof CompletedExceptionally)) {
            return this.tryFinalizeSimpleState(((Incomplete)object0), object1) ? object1 : JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        return this.tryMakeCompletingSlowPath(((Incomplete)object0), object1);
    }

    private final Object tryMakeCompletingSlowPath(Incomplete incomplete0, Object object0) {
        Throwable throwable0 = null;
        NodeList nodeList0 = this.getOrPromoteCancellingList(incomplete0);
        if(nodeList0 == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        Finishing jobSupport$Finishing0 = incomplete0 instanceof Finishing ? ((Finishing)incomplete0) : null;
        boolean z = false;
        if(jobSupport$Finishing0 == null) {
            jobSupport$Finishing0 = new Finishing(nodeList0, false, null);
        }
        synchronized(jobSupport$Finishing0) {
            if(jobSupport$Finishing0.isCompleting()) {
                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }
            jobSupport$Finishing0.setCompleting(true);
            if(jobSupport$Finishing0 != incomplete0) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = JobSupport._state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, incomplete0, jobSupport$Finishing0)) {
                        z = true;
                        break;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == incomplete0);
                if(!z) {
                    return JobSupportKt.access$getCOMPLETING_RETRY$p();
                }
            }
            boolean z1 = jobSupport$Finishing0.isCancelling();
            CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
            if(completedExceptionally0 != null) {
                jobSupport$Finishing0.addExceptionLocked(completedExceptionally0.cause);
            }
            Throwable throwable1 = jobSupport$Finishing0.getRootCause();
            if(!z1) {
                throwable0 = throwable1;
            }
        }
        if(throwable0 != null) {
            this.notifyCancelling(nodeList0, throwable0);
        }
        ChildHandleNode childHandleNode0 = this.nextChild(nodeList0);
        if(childHandleNode0 != null && this.tryWaitForChild(jobSupport$Finishing0, childHandleNode0, object0)) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
        nodeList0.close(2);
        ChildHandleNode childHandleNode1 = this.nextChild(nodeList0);
        return childHandleNode1 != null && this.tryWaitForChild(jobSupport$Finishing0, childHandleNode1, object0) ? JobSupportKt.COMPLETING_WAITING_CHILDREN : this.finalizeFinishingState(jobSupport$Finishing0, object0);
    }

    private final boolean tryWaitForChild(Finishing jobSupport$Finishing0, ChildHandleNode childHandleNode0, Object object0) {
        do {
            ChildCompletion jobSupport$ChildCompletion0 = new ChildCompletion(this, jobSupport$Finishing0, childHandleNode0, object0);
            if(JobKt.invokeOnCompletion(childHandleNode0.childJob, false, jobSupport$ChildCompletion0) != NonDisposableHandle.INSTANCE) {
                return true;
            }
            childHandleNode0 = this.nextChild(childHandleNode0);
        }
        while(childHandleNode0 != null);
        return false;
    }
}

