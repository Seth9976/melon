package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ConcurrentKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0010\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u000F*\u00020\u00072\n\u0010\n\u001A\u00060\bj\u0002`\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u00020\u00142\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\u00142\u0006\u0010\f\u001A\u00020\u000B2\n\u0010\n\u001A\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u000E\u001A\u00020\r2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ+\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u000E\u001A\u00020\r2\n\u0010\n\u001A\u00060\bj\u0002`\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0014H\u0016¢\u0006\u0004\b \u0010!J\u000F\u0010#\u001A\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001A\u0010(\u001A\u00020\'2\b\u0010&\u001A\u0004\u0018\u00010%H\u0096\u0002¢\u0006\u0004\b(\u0010)J\u000F\u0010+\u001A\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010-\u001A\u0004\b.\u0010/¨\u00060"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lme/i;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "scheduleBlock", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lme/i;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "Lie/H;", "cancelJobOnRejection", "(Lme/i;Ljava/util/concurrent/RejectedExecutionException;)V", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "close", "()V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    @NotNull
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(@NotNull Executor executor0) {
        this.executor = executor0;
        ConcurrentKt.removeFutureOnCancel(this.getExecutor());
    }

    private final void cancelJobOnRejection(i i0, RejectedExecutionException rejectedExecutionException0) {
        JobKt.cancel(i0, ExceptionsKt.CancellationException("The task was rejected", rejectedExecutionException0));
    }

    @Override
    public void close() {
        Executor executor0 = this.getExecutor();
        ExecutorService executorService0 = executor0 instanceof ExecutorService ? ((ExecutorService)executor0) : null;
        if(executorService0 != null) {
            executorService0.shutdown();
        }
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        try {
            this.getExecutor().execute(runnable0);
        }
        catch(RejectedExecutionException rejectedExecutionException0) {
            this.cancelJobOnRejection(i0, rejectedExecutionException0);
            Dispatchers.getIO().dispatch(i0, runnable0);
        }
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof ExecutorCoroutineDispatcherImpl && ((ExecutorCoroutineDispatcherImpl)object0).getExecutor() == this.getExecutor();
    }

    @Override  // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.executor;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.getExecutor());
    }

    @Override  // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        long v1;
        Executor executor0 = this.getExecutor();
        ScheduledFuture scheduledFuture0 = null;
        ScheduledExecutorService scheduledExecutorService0 = executor0 instanceof ScheduledExecutorService ? ((ScheduledExecutorService)executor0) : null;
        if(scheduledExecutorService0 == null) {
            v1 = v;
        }
        else {
            v1 = v;
            scheduledFuture0 = this.scheduleBlock(scheduledExecutorService0, runnable0, i0, v1);
        }
        return scheduledFuture0 != null ? new DisposableFutureHandle(scheduledFuture0) : DefaultExecutor.INSTANCE.invokeOnTimeout(v1, runnable0, i0);
    }

    private final ScheduledFuture scheduleBlock(ScheduledExecutorService scheduledExecutorService0, Runnable runnable0, i i0, long v) {
        try {
            return scheduledExecutorService0.schedule(runnable0, v, TimeUnit.MILLISECONDS);
        }
        catch(RejectedExecutionException rejectedExecutionException0) {
            this.cancelJobOnRejection(i0, rejectedExecutionException0);
            return null;
        }
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, @NotNull CancellableContinuation cancellableContinuation0) {
        long v1;
        Executor executor0 = this.getExecutor();
        ScheduledFuture scheduledFuture0 = null;
        ScheduledExecutorService scheduledExecutorService0 = executor0 instanceof ScheduledExecutorService ? ((ScheduledExecutorService)executor0) : null;
        if(scheduledExecutorService0 == null) {
            v1 = v;
        }
        else {
            v1 = v;
            scheduledFuture0 = this.scheduleBlock(scheduledExecutorService0, new ResumeUndispatchedRunnable(this, cancellableContinuation0), cancellableContinuation0.getContext(), v1);
        }
        if(scheduledFuture0 != null) {
            CancellableContinuationKt.invokeOnCancellation(cancellableContinuation0, new CancelFutureOnCancel(scheduledFuture0));
            return;
        }
        DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(v1, cancellableContinuation0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return this.getExecutor().toString();
    }
}

