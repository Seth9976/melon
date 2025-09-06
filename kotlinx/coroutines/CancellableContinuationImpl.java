package kotlinx.coroutines;

import Bd.e;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import me.i;
import ne.a;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000\u00C2\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u00052\u00020\u0006B\u001D\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0001\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0016\u001A\u0004\u0018\u00010\u0013H\u0010\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001C\u001A\u00020\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001A\u00020\u0018H\u0010\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001D\u001A\u00020\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010!\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u0018H\u0000\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010$\u001A\u00020\r2\u0006\u0010#\u001A\u00020\"2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018\u00A2\u0006\u0004\b$\u0010%JC\u0010+\u001A\u00020\r\"\u0004\b\u0001\u0010&2\u001E\u0010)\u001A\u001A\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r0\'2\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010*\u001A\u00028\u0001\u00A2\u0006\u0004\b+\u0010,J\u0017\u0010/\u001A\u00020\u00182\u0006\u0010.\u001A\u00020-H\u0016\u00A2\u0006\u0004\b/\u00100J\u0011\u00101\u001A\u0004\u0018\u00010\u0013H\u0001\u00A2\u0006\u0004\b1\u0010\u0015J\u000F\u00103\u001A\u00020\rH\u0000\u00A2\u0006\u0004\b2\u0010\u000FJ\u001D\u00106\u001A\u00020\r2\f\u00105\u001A\b\u0012\u0004\u0012\u00028\u000004H\u0016\u00A2\u0006\u0004\b6\u00107J-\u00109\u001A\u00020\r2\u0006\u0010*\u001A\u00028\u00002\u0014\u0010)\u001A\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r\u0018\u000108H\u0016\u00A2\u0006\u0004\b9\u0010:JC\u00109\u001A\u00020\r\"\b\b\u0001\u0010&*\u00028\u00002\u0006\u0010*\u001A\u00028\u00012 \u0010)\u001A\u001C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0018\u00010\'H\u0016\u00A2\u0006\u0004\b9\u0010;J#\u0010?\u001A\u00020\r2\n\u0010=\u001A\u0006\u0012\u0002\b\u00030<2\u0006\u0010>\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b?\u0010@J)\u0010?\u001A\u00020\r2\u0018\u0010#\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\r08j\u0002`AH\u0016\u00A2\u0006\u0004\b?\u0010BJ\u0017\u0010E\u001A\u00020\r2\u0006\u0010#\u001A\u00020\"H\u0000\u00A2\u0006\u0004\bC\u0010DJI\u0010I\u001A\u00020\r\"\u0004\b\u0001\u0010&2\u0006\u0010F\u001A\u00028\u00012\u0006\u0010\n\u001A\u00020\t2\"\b\u0002\u0010)\u001A\u001C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0018\u00010\'H\u0000\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010K\u001A\u00020\rH\u0000\u00A2\u0006\u0004\bJ\u0010\u000FJO\u0010M\u001A\u0004\u0018\u00010\u0013\"\b\b\u0001\u0010&*\u00028\u00002\u0006\u0010*\u001A\u00028\u00012\b\u0010L\u001A\u0004\u0018\u00010\u00132 \u0010)\u001A\u001C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0018\u00010\'H\u0016\u00A2\u0006\u0004\bM\u0010NJ\u0019\u0010P\u001A\u0004\u0018\u00010\u00132\u0006\u0010O\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\bP\u0010QJ\u0017\u0010S\u001A\u00020\r2\u0006\u0010R\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\bS\u00107J\u001B\u0010U\u001A\u00020\r*\u00020T2\u0006\u0010*\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\bU\u0010VJ\u001F\u0010Z\u001A\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010W\u001A\u0004\u0018\u00010\u0013H\u0010\u00A2\u0006\u0004\bX\u0010YJ\u001B\u0010]\u001A\u0004\u0018\u00010\u00182\b\u0010W\u001A\u0004\u0018\u00010\u0013H\u0010\u00A2\u0006\u0004\b[\u0010\\J\u000F\u0010_\u001A\u00020^H\u0016\u00A2\u0006\u0004\b_\u0010`J\u000F\u0010a\u001A\u00020^H\u0014\u00A2\u0006\u0004\ba\u0010`J\u000F\u0010b\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bb\u0010\u0012J\u0017\u0010c\u001A\u00020\u00102\u0006\u0010\u0019\u001A\u00020\u0018H\u0002\u00A2\u0006\u0004\bc\u0010\u001EJ%\u0010d\u001A\u00020\r2\n\u0010=\u001A\u0006\u0012\u0002\b\u00030<2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0002\u00A2\u0006\u0004\bd\u0010eJ\u000F\u0010f\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bf\u0010\u0012J\u000F\u0010M\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bM\u0010\u0012J\u0011\u0010h\u001A\u0004\u0018\u00010gH\u0002\u00A2\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001A\u00020\r2\u0006\u0010#\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\bj\u00107J!\u0010k\u001A\u00020\r2\u0006\u0010#\u001A\u00020\u00132\b\u0010W\u001A\u0004\u0018\u00010\u0013H\u0002\u00A2\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001A\u00020\r2\u0006\u0010m\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bn\u0010oJ[\u0010q\u001A\u0004\u0018\u00010\u0013\"\u0004\b\u0001\u0010&2\u0006\u0010W\u001A\u00020p2\u0006\u0010F\u001A\u00028\u00012\u0006\u0010\n\u001A\u00020\t2 \u0010)\u001A\u001C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0018\u00010\'2\b\u0010L\u001A\u0004\u0018\u00010\u0013H\u0002\u00A2\u0006\u0004\bq\u0010rJK\u0010t\u001A\u0004\u0018\u00010s\"\u0004\b\u0001\u0010&2\u0006\u0010F\u001A\u00028\u00012\b\u0010L\u001A\u0004\u0018\u00010\u00132 \u0010)\u001A\u001C\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\r\u0018\u00010\'H\u0002\u00A2\u0006\u0004\bt\u0010uJ\u0019\u0010w\u001A\u00020v2\b\u0010F\u001A\u0004\u0018\u00010\u0013H\u0002\u00A2\u0006\u0004\bw\u0010xJ\u000F\u0010y\u001A\u00020\rH\u0002\u00A2\u0006\u0004\by\u0010\u000FR \u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\b\u0010z\u001A\u0004\b{\u0010|R\u001B\u0010}\u001A\u00020(8\u0016X\u0096\u0004\u00A2\u0006\r\n\u0004\b}\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001R\u0017\u0010W\u001A\u0004\u0018\u00010\u00138@X\u0080\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0081\u0001\u0010\u0015R\u0016\u0010\u0082\u0001\u001A\u00020\u00108VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0082\u0001\u0010\u0012R\u0016\u0010\u0083\u0001\u001A\u00020\u00108VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0083\u0001\u0010\u0012R\u001F\u0010\u0086\u0001\u001A\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0088\u0001\u001A\u0004\u0018\u00010g8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0087\u0001\u0010iR\u0016\u0010\u008A\u0001\u001A\u00020^8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u0089\u0001\u0010`R\r\u0010\u008C\u0001\u001A\u00030\u008B\u00018\u0002X\u0082\u0004R\u0015\u0010\u008E\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u008D\u00018\u0002X\u0082\u0004R\u0015\u0010\u008F\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010g0\u008D\u00018\u0002X\u0082\u0004\u00A8\u0006\u0090\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Loe/d;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/Waiter;", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "Lie/H;", "initCancellability", "()V", "", "resetStateReusable", "()Z", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "(Ljava/lang/Throwable;)Z", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "Lkotlinx/coroutines/CancelHandler;", "handler", "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "R", "Lkotlin/Function3;", "Lme/i;", "onCancellation", "value", "callOnCancellation", "(Lwe/o;Ljava/lang/Throwable;Ljava/lang/Object;)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "releaseClaimedReusableContinuation$kotlinx_coroutines_core", "releaseClaimedReusableContinuation", "Lie/p;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "resume", "(Ljava/lang/Object;Lwe/k;)V", "(Ljava/lang/Object;Lwe/o;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "index", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CompletionHandler;", "(Lwe/k;)V", "invokeOnCancellationInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/CancelHandler;)V", "invokeOnCancellationInternal", "proposedUpdate", "resumeImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;ILwe/o;)V", "resumeImpl", "detachChild$kotlinx_coroutines_core", "detachChild", "idempotent", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;Lwe/o;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "isReusable", "cancelLater", "callSegmentOnCancellation", "(Lkotlinx/coroutines/internal/Segment;Ljava/lang/Throwable;)V", "trySuspend", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellationImpl", "multipleHandlersError", "(Ljava/lang/Object;Ljava/lang/Object;)V", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILwe/o;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lwe/o;)Lkotlinx/coroutines/internal/Symbol;", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "detachChildIfNonReusable", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "context", "Lme/i;", "getContext", "()Lme/i;", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "getCallerFrame", "()Loe/d;", "callerFrame", "getParentHandle", "parentHandle", "getStateDebugRepresentation", "stateDebugRepresentation", "Lkotlinx/atomicfu/AtomicInt;", "_decisionAndIndex", "Lkotlinx/atomicfu/AtomicRef;", "_state", "_parentHandle", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class CancellableContinuationImpl extends DispatchedTask implements CancellableContinuation, Waiter, d {
    private volatile int _decisionAndIndex$volatile;
    private static final AtomicIntegerFieldUpdater _decisionAndIndex$volatile$FU;
    private volatile Object _parentHandle$volatile;
    private static final AtomicReferenceFieldUpdater _parentHandle$volatile$FU;
    private volatile Object _state$volatile;
    private static final AtomicReferenceFieldUpdater _state$volatile$FU;
    @NotNull
    private final i context;
    @NotNull
    private final Continuation delegate;

    static {
        CancellableContinuationImpl._decisionAndIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");
        CancellableContinuationImpl._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");
        CancellableContinuationImpl._parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");
    }

    public CancellableContinuationImpl(@NotNull Continuation continuation0, int v) {
        super(v);
        this.delegate = continuation0;
        this.context = continuation0.getContext();
        this._decisionAndIndex$volatile = 0x1FFFFFFF;
        this._state$volatile = Active.INSTANCE;
    }

    public static H a(k k0, Throwable throwable0, Object object0, i i0) {
        return CancellableContinuationImpl.resume$lambda$13$lambda$12(k0, throwable0, object0, i0);
    }

    private final Void alreadyResumedError(Object object0) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + object0).toString());
    }

    public final void callCancelHandler(@NotNull CancelHandler cancelHandler0, @Nullable Throwable throwable0) {
        try {
            cancelHandler0.invoke(throwable0);
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable1));
        }
    }

    public final void callOnCancellation(@NotNull o o0, @NotNull Throwable throwable0, Object object0) {
        try {
            o0.invoke(throwable0, object0, this.getContext());
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, throwable1));
        }
    }

    private final void callSegmentOnCancellation(Segment segment0, Throwable throwable0) {
        int v = CancellableContinuationImpl.get_decisionAndIndex$volatile$FU().get(this);
        if((v & 0x1FFFFFFF) == 0x1FFFFFFF) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment0.onCancellation(v & 0x1FFFFFFF, throwable0, this.getContext());
        }
        catch(Throwable throwable1) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, throwable1));
        }
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable throwable0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._state$volatile$FU;
        while(true) {
            Object object0 = atomicReferenceFieldUpdater0.get(this);
            boolean z = false;
            if(!(object0 instanceof NotCompleted)) {
                return false;
            }
            if(object0 instanceof CancelHandler || object0 instanceof Segment) {
                z = true;
            }
            CancelledContinuation cancelledContinuation0 = new CancelledContinuation(this, throwable0, z);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = CancellableContinuationImpl._state$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater1.compareAndSet(this, object0, cancelledContinuation0)) {
                    if(((NotCompleted)object0) instanceof CancelHandler) {
                        this.callCancelHandler(((CancelHandler)object0), throwable0);
                    }
                    else if(((NotCompleted)object0) instanceof Segment) {
                        this.callSegmentOnCancellation(((Segment)object0), throwable0);
                    }
                    this.detachChildIfNonReusable();
                    this.dispatchResume(this.resumeMode);
                    return true;
                }
            }
            while(atomicReferenceFieldUpdater1.get(this) == object0);
        }
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object object0, @NotNull Throwable throwable0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._state$volatile$FU;
        Object object1;
        while(!((object1 = atomicReferenceFieldUpdater0.get(this)) instanceof NotCompleted)) {
            if(object1 instanceof CompletedExceptionally) {
                return;
            }
            if(object1 instanceof CompletedContinuation) {
                if(((CompletedContinuation)object1).getCancelled()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                CompletedContinuation completedContinuation0 = CompletedContinuation.copy$default(((CompletedContinuation)object1), null, null, null, null, throwable0, 15, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = CancellableContinuationImpl._state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, object1, completedContinuation0)) {
                        ((CompletedContinuation)object1).invokeHandlers(this, throwable0);
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == object1);
            }
            else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._state$volatile$FU;
                CompletedContinuation completedContinuation1 = new CompletedContinuation(object1, null, null, null, throwable0, 14, null);
                do {
                    if(atomicReferenceFieldUpdater2.compareAndSet(this, object1, completedContinuation1)) {
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater2.get(this) == object1);
            }
        }
        throw new IllegalStateException("Not completed");
    }

    private final boolean cancelLater(Throwable throwable0) {
        if(!this.isReusable()) {
            return false;
        }
        q.e(this.delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((DispatchedContinuation)this.delegate).postponeCancellation$kotlinx_coroutines_core(throwable0);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object object0) {
        this.dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle disposableHandle0 = this.getParentHandle();
        if(disposableHandle0 == null) {
            return;
        }
        disposableHandle0.dispose();
        CancellableContinuationImpl._parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
    }

    private final void detachChildIfNonReusable() {
        if(!this.isReusable()) {
            this.detachChild$kotlinx_coroutines_core();
        }
    }

    private final void dispatchResume(int v) {
        if(this.tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, v);
    }

    // 去混淆评级： 低(20)
    @Override  // oe.d
    @Nullable
    public d getCallerFrame() {
        return this.delegate instanceof d ? ((d)this.delegate) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public i getContext() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job job0) {
        return job0.getCancellationException();
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object object0) {
        Throwable throwable0 = super.getExceptionalResult$kotlinx_coroutines_core(object0);
        return throwable0 == null ? null : throwable0;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle)CancellableContinuationImpl._parentHandle$volatile$FU.get(this);
    }

    @Nullable
    public final Object getResult() {
        boolean z = this.isReusable();
        if(this.trySuspend()) {
            if(this.getParentHandle() == null) {
                this.installParentHandle();
            }
            if(z) {
                this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return a.a;
        }
        if(z) {
            this.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally)object0).cause;
        }
        if(DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
            Job job0 = (Job)this.getContext().get(Job.Key);
            if(job0 != null && !job0.isActive()) {
                CancellationException cancellationException0 = job0.getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(object0, cancellationException0);
                throw cancellationException0;
            }
        }
        return this.getSuccessfulResult$kotlinx_coroutines_core(object0);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return CancellableContinuationImpl._state$volatile$FU.get(this);
    }

    private final String getStateDebugRepresentation() {
        Object object0 = this.getState$kotlinx_coroutines_core();
        if(object0 instanceof NotCompleted) {
            return "Active";
        }
        return object0 instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.DispatchedTask
    public Object getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object object0) {
        return object0 instanceof CompletedContinuation ? ((CompletedContinuation)object0).result : object0;
    }

    public void initCancellability() {
        DisposableHandle disposableHandle0 = this.installParentHandle();
        if(disposableHandle0 != null && this.isCompleted()) {
            disposableHandle0.dispose();
            CancellableContinuationImpl._parentHandle$volatile$FU.set(this, NonDisposableHandle.INSTANCE);
        }
    }

    private final DisposableHandle installParentHandle() {
        Job job0 = (Job)this.getContext().get(Job.Key);
        if(job0 == null) {
            return null;
        }
        DisposableHandle disposableHandle0 = JobKt.invokeOnCompletion$default(job0, false, new ChildContinuation(this), 1, null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._parentHandle$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, disposableHandle0)) {
                return disposableHandle0;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        return disposableHandle0;
    }

    @Override  // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment segment0, int v) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
        while(true) {
            int v1 = atomicIntegerFieldUpdater0.get(this);
            if((v1 & 0x1FFFFFFF) != 0x1FFFFFFF) {
                break;
            }
            if(atomicIntegerFieldUpdater0.compareAndSet(this, v1, (v1 >> 29 << 29) + v)) {
                this.invokeOnCancellationImpl(segment0);
                return;
            }
        }
        throw new IllegalStateException("invokeOnCancellation should be called at most once");
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull k k0) {
        CancellableContinuationKt.invokeOnCancellation(this, new UserSupplied(k0));
    }

    private final void invokeOnCancellationImpl(Object object0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._state$volatile$FU;
        while(true) {
            Object object1 = atomicReferenceFieldUpdater0.get(this);
            if(object1 instanceof Active) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = CancellableContinuationImpl._state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, object1, object0)) {
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == object1);
            }
            else if(!(object1 instanceof CancelHandler) && !(object1 instanceof Segment)) {
                if(object1 instanceof CompletedExceptionally) {
                    CompletedExceptionally completedExceptionally0 = (CompletedExceptionally)object1;
                    if(!completedExceptionally0.makeHandled()) {
                        this.multipleHandlersError(object0, object1);
                    }
                    Throwable throwable0 = null;
                    if(object1 instanceof CancelledContinuation) {
                        if(object1 == null) {
                            completedExceptionally0 = null;
                        }
                        if(completedExceptionally0 != null) {
                            throwable0 = completedExceptionally0.cause;
                        }
                        if(object0 instanceof CancelHandler) {
                            this.callCancelHandler(((CancelHandler)object0), throwable0);
                            return;
                        }
                        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        this.callSegmentOnCancellation(((Segment)object0), throwable0);
                    }
                    return;
                }
                if(object1 instanceof CompletedContinuation) {
                    if(((CompletedContinuation)object1).cancelHandler != null) {
                        this.multipleHandlersError(object0, object1);
                    }
                    if(object0 instanceof Segment) {
                        return;
                    }
                    q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if(((CompletedContinuation)object1).getCancelled()) {
                        this.callCancelHandler(((CancelHandler)object0), ((CompletedContinuation)object1).cancelCause);
                        return;
                    }
                    CompletedContinuation completedContinuation0 = CompletedContinuation.copy$default(((CompletedContinuation)object1), null, ((CancelHandler)object0), null, null, null, 29, null);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = CancellableContinuationImpl._state$volatile$FU;
                    do {
                        if(atomicReferenceFieldUpdater2.compareAndSet(this, object1, completedContinuation0)) {
                            return;
                        }
                    }
                    while(atomicReferenceFieldUpdater2.get(this) == object1);
                }
                else {
                    if(object0 instanceof Segment) {
                        return;
                    }
                    q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    CompletedContinuation completedContinuation1 = new CompletedContinuation(object1, ((CancelHandler)object0), null, null, null, 28, null);
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = CancellableContinuationImpl._state$volatile$FU;
                    do {
                        if(atomicReferenceFieldUpdater3.compareAndSet(this, object1, completedContinuation1)) {
                            return;
                        }
                    }
                    while(atomicReferenceFieldUpdater3.get(this) == object1);
                }
            }
            else {
                this.multipleHandlersError(object0, object1);
            }
        }
    }

    public final void invokeOnCancellationInternal$kotlinx_coroutines_core(@NotNull CancelHandler cancelHandler0) {
        this.invokeOnCancellationImpl(cancelHandler0);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return this.getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(this.getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    private final boolean isReusable() {
        if(DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            q.e(this.delegate, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            return ((DispatchedContinuation)this.delegate).isReusable$kotlinx_coroutines_core();
        }
        return false;
    }

    private final void multipleHandlersError(Object object0, Object object1) {
        throw new IllegalStateException(("It\'s prohibited to register multiple handlers, tried to register " + object0 + ", already has " + object1).toString());
    }

    @NotNull
    public String nameString() [...] // 潜在的解密器

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable throwable0) {
        if(this.cancelLater(throwable0)) {
            return;
        }
        this.cancel(throwable0);
        this.detachChildIfNonReusable();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        DispatchedContinuation dispatchedContinuation0 = this.delegate instanceof DispatchedContinuation ? ((DispatchedContinuation)this.delegate) : null;
        if(dispatchedContinuation0 != null) {
            Throwable throwable0 = dispatchedContinuation0.tryReleaseClaimedContinuation$kotlinx_coroutines_core(this);
            if(throwable0 != null) {
                this.detachChild$kotlinx_coroutines_core();
                this.cancel(throwable0);
            }
        }
    }

    public final boolean resetStateReusable() {
        Object object0 = CancellableContinuationImpl._state$volatile$FU.get(this);
        if(object0 instanceof CompletedContinuation && ((CompletedContinuation)object0).idempotentResume != null) {
            this.detachChild$kotlinx_coroutines_core();
            return false;
        }
        CancellableContinuationImpl._decisionAndIndex$volatile$FU.set(this, 0x1FFFFFFF);
        CancellableContinuationImpl._state$volatile$FU.set(this, Active.INSTANCE);
        return true;
    }

    public void resume(Object object0, @Nullable k k0) {
        this.resumeImpl$kotlinx_coroutines_core(object0, this.resumeMode, (k0 == null ? null : new e(k0, 14)));
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void resume(Object object0, @Nullable o o0) {
        this.resumeImpl$kotlinx_coroutines_core(object0, this.resumeMode, o0);
    }

    private static final H resume$lambda$13$lambda$12(k k0, Throwable throwable0, Object object0, i i0) {
        k0.invoke(throwable0);
        return H.a;
    }

    public final void resumeImpl$kotlinx_coroutines_core(Object object0, int v, @Nullable o o0) {
        Object object1;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._state$volatile$FU;
        while(true) {
            object1 = atomicReferenceFieldUpdater0.get(this);
            if(!(object1 instanceof NotCompleted)) {
                break;
            }
            Object object2 = this.resumedState(((NotCompleted)object1), object0, v, o0, null);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = CancellableContinuationImpl._state$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater1.compareAndSet(this, object1, object2)) {
                    this.detachChildIfNonReusable();
                    this.dispatchResume(v);
                    return;
                }
            }
            while(atomicReferenceFieldUpdater1.get(this) == object1);
        }
        if(object1 instanceof CancelledContinuation && ((CancelledContinuation)object1).makeResumed()) {
            if(o0 != null) {
                this.callOnCancellation(o0, ((CancelledContinuation)object1).cause, object0);
            }
            return;
        }
        this.alreadyResumedError(object0);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public static void resumeImpl$kotlinx_coroutines_core$default(CancellableContinuationImpl cancellableContinuationImpl0, Object object0, int v, o o0, int v1, Object object1) {
        if(object1 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if((v1 & 4) != 0) {
            o0 = null;
        }
        cancellableContinuationImpl0.resumeImpl$kotlinx_coroutines_core(object0, v, o0);
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher0, Object object0) {
        CoroutineDispatcher coroutineDispatcher1 = null;
        DispatchedContinuation dispatchedContinuation0 = this.delegate instanceof DispatchedContinuation ? ((DispatchedContinuation)this.delegate) : null;
        if(dispatchedContinuation0 != null) {
            coroutineDispatcher1 = dispatchedContinuation0.dispatcher;
        }
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, object0, (coroutineDispatcher1 == coroutineDispatcher0 ? 4 : this.resumeMode), null, 4, null);
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object object0) {
        CancellableContinuationImpl.resumeImpl$kotlinx_coroutines_core$default(this, CompletionStateKt.toState(object0, this), this.resumeMode, null, 4, null);
    }

    private final Object resumedState(NotCompleted notCompleted0, Object object0, int v, o o0, Object object1) {
        if(object0 instanceof CompletedExceptionally) {
            return object0;
        }
        if(!DispatchedTaskKt.isCancellableMode(v) && object1 == null || o0 == null && !(notCompleted0 instanceof CancelHandler) && object1 == null) {
            return object0;
        }
        return notCompleted0 instanceof CancelHandler ? new CompletedContinuation(object0, ((CancelHandler)notCompleted0), o0, object1, null, 16, null) : new CompletedContinuation(object0, null, o0, object1, null, 16, null);
    }

    @Override  // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return this.getState$kotlinx_coroutines_core();
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "CancellableContinuation" + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + this.getStateDebugRepresentation() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
    alab1:
        while(true) {
            int v = atomicIntegerFieldUpdater0.get(this);
            switch(v >> 29) {
                case 0: {
                    if(!CancellableContinuationImpl._decisionAndIndex$volatile$FU.compareAndSet(this, v, 0x40000000 + (0x1FFFFFFF & v))) {
                        break;
                    }
                    break alab1;
                }
                case 1: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
        return true;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(Object object0, @Nullable Object object1, @Nullable o o0) {
        return this.tryResumeImpl(object0, object1, o0);
    }

    private final Symbol tryResumeImpl(Object object0, Object object1, o o0) {
        Object object2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = CancellableContinuationImpl._state$volatile$FU;
        while(true) {
            object2 = atomicReferenceFieldUpdater0.get(this);
            if(!(object2 instanceof NotCompleted)) {
                break;
            }
            Object object3 = this.resumedState(((NotCompleted)object2), object0, this.resumeMode, o0, object1);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = CancellableContinuationImpl._state$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater1.compareAndSet(this, object2, object3)) {
                    this.detachChildIfNonReusable();
                    return CancellableContinuationImplKt.RESUME_TOKEN;
                }
            }
            while(atomicReferenceFieldUpdater1.get(this) == object2);
        }
        return !(object2 instanceof CompletedContinuation) || object1 == null || ((CompletedContinuation)object2).idempotentResume != object1 ? null : CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @Override  // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable throwable0) {
        return this.tryResumeImpl(new CompletedExceptionally(throwable0, false, 2, null), null, null);
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = CancellableContinuationImpl._decisionAndIndex$volatile$FU;
    alab1:
        while(true) {
            int v = atomicIntegerFieldUpdater0.get(this);
            switch(v >> 29) {
                case 0: {
                    if(!CancellableContinuationImpl._decisionAndIndex$volatile$FU.compareAndSet(this, v, 0x20000000 + (0x1FFFFFFF & v))) {
                        break;
                    }
                    break alab1;
                }
                case 2: {
                    return false;
                }
                default: {
                    throw new IllegalStateException("Already suspended");
                }
            }
        }
        return true;
    }
}

