package kotlinx.coroutines;

import d5.n;
import ie.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\u001A\'\u0010\u0005\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001A5\u0010\u000B\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001A\u00020\tH\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u0017\u0010\r\u001A\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000E\"\u0018\u0010\u000F\u001A\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010\"\u0018\u0010\u0011\u001A\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/DispatchedTask;", "", "mode", "Lie/H;", "dispatch", "(Lkotlinx/coroutines/DispatchedTask;I)V", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", "resume", "(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;Z)V", "resumeUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "isCancellableMode", "(I)Z", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class DispatchedTaskKt {
    public static final void dispatch(@NotNull DispatchedTask dispatchedTask0, int v) {
        Continuation continuation0 = dispatchedTask0.getDelegate$kotlinx_coroutines_core();
        if(v != 4 && continuation0 instanceof DispatchedContinuation && DispatchedTaskKt.isCancellableMode(v) == DispatchedTaskKt.isCancellableMode(dispatchedTask0.resumeMode)) {
            CoroutineDispatcher coroutineDispatcher0 = ((DispatchedContinuation)continuation0).dispatcher;
            i i0 = ((DispatchedContinuation)continuation0).getContext();
            if(DispatchedContinuationKt.safeIsDispatchNeeded(coroutineDispatcher0, i0)) {
                DispatchedContinuationKt.safeDispatch(coroutineDispatcher0, i0, dispatchedTask0);
                return;
            }
            DispatchedTaskKt.resumeUnconfined(dispatchedTask0);
            return;
        }
        DispatchedTaskKt.resume(dispatchedTask0, continuation0, v == 4);
    }

    public static final boolean isCancellableMode(int v) {
        return v == 1 || v == 2;
    }

    public static final boolean isReusableMode(int v) {
        return v == 2;
    }

    public static final void resume(@NotNull DispatchedTask dispatchedTask0, @NotNull Continuation continuation0, boolean z) {
        Object object0 = dispatchedTask0.takeState$kotlinx_coroutines_core();
        Throwable throwable0 = dispatchedTask0.getExceptionalResult$kotlinx_coroutines_core(object0);
        o o0 = throwable0 == null ? dispatchedTask0.getSuccessfulResult$kotlinx_coroutines_core(object0) : n.t(throwable0);
        if(z) {
            q.e(continuation0, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation0 = (DispatchedContinuation)continuation0;
            i i0 = dispatchedContinuation0.continuation.getContext();
            Object object1 = ThreadContextKt.updateThreadContext(i0, dispatchedContinuation0.countOrElement);
            UndispatchedCoroutine undispatchedCoroutine0 = object1 == ThreadContextKt.NO_THREAD_ELEMENTS ? null : CoroutineContextKt.updateUndispatchedCompletion(dispatchedContinuation0.continuation, i0, object1);
            try {
                dispatchedContinuation0.continuation.resumeWith(o0);
            }
            catch(Throwable throwable1) {
                if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(i0, object1);
                }
                throw throwable1;
            }
            if(undispatchedCoroutine0 != null && !undispatchedCoroutine0.clearThreadContext()) {
                return;
            }
            ThreadContextKt.restoreThreadContext(i0, object1);
            return;
        }
        continuation0.resumeWith(o0);
    }

    private static final void resumeUnconfined(DispatchedTask dispatchedTask0) {
        EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(eventLoop0.isUnconfinedLoopActive()) {
            eventLoop0.dispatchUnconfined(dispatchedTask0);
            return;
        }
        eventLoop0.incrementUseCount(true);
        try {
            DispatchedTaskKt.resume(dispatchedTask0, dispatchedTask0.getDelegate$kotlinx_coroutines_core(), true);
            while(eventLoop0.processUnconfinedEvent()) {
            }
        }
        catch(Throwable throwable0) {
            dispatchedTask0.handleFatalException$kotlinx_coroutines_core(throwable0);
        }
        finally {
            eventLoop0.decrementUseCount(true);
        }
    }
}

