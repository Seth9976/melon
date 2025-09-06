package kotlinx.coroutines.internal;

import d5.n;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\'\u0010\u0007\u001A\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\n\u0010\u0005\u001A\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\u001B\u0010\n\u001A\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A-\u0010\u0010\u001A\u00020\u0006\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A\u0019\u0010\u0013\u001A\u00020\t*\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001A\u00020\u00158\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lme/i;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "runnable", "Lie/H;", "safeDispatch", "(Lkotlinx/coroutines/CoroutineDispatcher;Lme/i;Ljava/lang/Runnable;)V", "", "safeIsDispatchNeeded", "(Lkotlinx/coroutines/CoroutineDispatcher;Lme/i;)Z", "T", "Lkotlin/coroutines/Continuation;", "Lie/p;", "result", "resumeCancellableWith", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "yieldUndispatched", "(Lkotlinx/coroutines/internal/DispatchedContinuation;)Z", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class DispatchedContinuationKt {
    @NotNull
    public static final Symbol REUSABLE_CLAIMED;
    @NotNull
    private static final Symbol UNDEFINED;

    static {
        DispatchedContinuationKt.UNDEFINED = new Symbol("UNDEFINED");
        DispatchedContinuationKt.REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    }

    public static final Symbol access$getUNDEFINED$p() {
        return DispatchedContinuationKt.UNDEFINED;
    }

    public static final void resumeCancellableWith(@NotNull Continuation continuation0, @NotNull Object object0) {
        Object object2;
        i i2;
        if(continuation0 instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation0 = (DispatchedContinuation)continuation0;
            Object object1 = CompletionStateKt.toState(object0);
            i i0 = dispatchedContinuation0.getContext();
            if(DispatchedContinuationKt.safeIsDispatchNeeded(dispatchedContinuation0.dispatcher, i0)) {
                dispatchedContinuation0._state = object1;
                dispatchedContinuation0.resumeMode = 1;
                i i1 = dispatchedContinuation0.getContext();
                DispatchedContinuationKt.safeDispatch(dispatchedContinuation0.dispatcher, i1, dispatchedContinuation0);
                return;
            }
            EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if(eventLoop0.isUnconfinedLoopActive()) {
                dispatchedContinuation0._state = object1;
                dispatchedContinuation0.resumeMode = 1;
                eventLoop0.dispatchUnconfined(dispatchedContinuation0);
                return;
            }
            eventLoop0.incrementUseCount(true);
            try {
                Job job0 = (Job)dispatchedContinuation0.getContext().get(Job.Key);
                if(job0 == null || job0.isActive()) {
                    i2 = dispatchedContinuation0.continuation.getContext();
                    object2 = ThreadContextKt.updateThreadContext(i2, dispatchedContinuation0.countOrElement);
                    UndispatchedCoroutine undispatchedCoroutine0 = object2 == ThreadContextKt.NO_THREAD_ELEMENTS ? null : CoroutineContextKt.updateUndispatchedCompletion(dispatchedContinuation0.continuation, i2, object2);
                    goto label_26;
                }
                else {
                    CancellationException cancellationException0 = job0.getCancellationException();
                    dispatchedContinuation0.cancelCompletedResult$kotlinx_coroutines_core(object1, cancellationException0);
                    dispatchedContinuation0.resumeWith(n.t(cancellationException0));
                }
                goto label_40;
            }
            catch(Throwable throwable0) {
                goto label_43;
            }
            try {
            label_26:
                dispatchedContinuation0.continuation.resumeWith(object0);
                goto label_35;
            }
            catch(Throwable throwable1) {
                try {
                    if(undispatchedCoroutine0 == null) {
                        ThreadContextKt.restoreThreadContext(i2, object2);
                    }
                    else if(undispatchedCoroutine0.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(i2, object2);
                    }
                    throw throwable1;
                label_35:
                    if(undispatchedCoroutine0 == null) {
                        ThreadContextKt.restoreThreadContext(i2, object2);
                    }
                    else if(undispatchedCoroutine0.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(i2, object2);
                    }
                    while(true) {
                    label_40:
                        if(!eventLoop0.processUnconfinedEvent()) {
                            goto label_48;
                        }
                    }
                }
                catch(Throwable throwable0) {
                }
            }
            try {
            label_43:
                dispatchedContinuation0.handleFatalException$kotlinx_coroutines_core(throwable0);
            }
            catch(Throwable throwable2) {
                eventLoop0.decrementUseCount(true);
                throw throwable2;
            }
        label_48:
            eventLoop0.decrementUseCount(true);
            return;
        }
        continuation0.resumeWith(object0);
    }

    public static final void safeDispatch(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull i i0, @NotNull Runnable runnable0) {
        try {
            coroutineDispatcher0.dispatch(i0, runnable0);
        }
        catch(Throwable throwable0) {
            throw new DispatchException(throwable0, coroutineDispatcher0, i0);
        }
    }

    public static final boolean safeIsDispatchNeeded(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull i i0) {
        try {
            return coroutineDispatcher0.isDispatchNeeded(i0);
        }
        catch(Throwable throwable0) {
            throw new DispatchException(throwable0, coroutineDispatcher0, i0);
        }
    }

    public static final boolean yieldUndispatched(@NotNull DispatchedContinuation dispatchedContinuation0) {
        EventLoop eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(eventLoop0.isUnconfinedQueueEmpty()) {
            return false;
        }
        if(eventLoop0.isUnconfinedLoopActive()) {
            dispatchedContinuation0._state = H.a;
            dispatchedContinuation0.resumeMode = 1;
            eventLoop0.dispatchUnconfined(dispatchedContinuation0);
            return true;
        }
        eventLoop0.incrementUseCount(true);
        try {
            dispatchedContinuation0.run();
            while(eventLoop0.processUnconfinedEvent()) {
            }
        }
        catch(Throwable throwable0) {
            dispatchedContinuation0.handleFatalException$kotlinx_coroutines_core(throwable0);
        }
        finally {
            eventLoop0.decrementUseCount(true);
        }
        return false;
    }
}

