package kotlinx.coroutines.internal;

import androidx.appcompat.app.o;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B!\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\n\u0018\u00010\rj\u0004\u0018\u0001`\u000EH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u00132\n\u0010\u0015\u001A\u00060\rj\u0002`\u000EH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u0014\u001A\u00020\u00132\n\u0010\u0015\u001A\u00060\rj\u0002`\u000EH\u0017\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ&\u0010 \u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001C2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00160\u001EH\u0096\u0001\u00A2\u0006\u0004\b \u0010!J,\u0010#\u001A\u00020\"2\u0006\u0010\u001D\u001A\u00020\u001C2\n\u0010\u0015\u001A\u00060\rj\u0002`\u000E2\u0006\u0010\u0014\u001A\u00020\u0013H\u0096\u0001\u00A2\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\'R\u001E\u0010)\u001A\f\u0012\b\u0012\u00060\rj\u0002`\u000E0(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001A\u00060+j\u0002`,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u000B\u00100\u001A\u00020/8\u0002X\u0082\u0004\u00A8\u00062"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "", "parallelism", "", "name", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;ILjava/lang/String;)V", "", "tryAllocateWorker", "()Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "obtainTaskOrDeallocateWorker", "()Ljava/lang/Runnable;", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "Lme/i;", "context", "block", "Lie/H;", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "dispatchYield", "toString", "()Ljava/lang/String;", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "workerAllocationLock", "Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001A\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001A\u0010\u0003\u001A\u00060\u0001j\u0002`\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "<init>", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "Lie/H;", "run", "()V", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class Worker implements Runnable {
        @NotNull
        private Runnable currentTask;

        public Worker(@NotNull Runnable runnable0) {
            this.currentTask = runnable0;
        }

        @Override
        public void run() {
            int v = 0;
            while(true) {
                try {
                label_1:
                    this.currentTask.run();
                    goto label_5;
                }
                catch(Throwable throwable0) {
                    try {
                        CoroutineExceptionHandlerKt.handleCoroutineException(j.a, throwable0);
                    label_5:
                        Runnable runnable0 = LimitedDispatcher.this.obtainTaskOrDeallocateWorker();
                        if(runnable0 != null) {
                            this.currentTask = runnable0;
                            ++v;
                            if(v >= 16 && DispatchedContinuationKt.safeIsDispatchNeeded(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this)) {
                                DispatchedContinuationKt.safeDispatch(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this, this);
                                return;
                            }
                            goto label_1;
                        }
                        return;
                    }
                    catch(Throwable throwable1) {
                        break;
                    }
                }
            }
            synchronized(LimitedDispatcher.this.workerAllocationLock) {
                LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(LimitedDispatcher.this);
            }
            throw throwable1;
        }
    }

    private final Delay $$delegate_0;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @Nullable
    private final String name;
    private final int parallelism;
    @NotNull
    private final LockFreeTaskQueue queue;
    private volatile int runningWorkers$volatile;
    private static final AtomicIntegerFieldUpdater runningWorkers$volatile$FU;
    @NotNull
    private final Object workerAllocationLock;

    static {
        LimitedDispatcher.runningWorkers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    }

    public LimitedDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher0, int v, @Nullable String s) {
        Delay delay0 = coroutineDispatcher0 instanceof Delay ? ((Delay)coroutineDispatcher0) : null;
        if(delay0 == null) {
            delay0 = DefaultExecutorKt.getDefaultDelay();
        }
        this.$$delegate_0 = delay0;
        this.dispatcher = coroutineDispatcher0;
        this.parallelism = v;
        this.name = s;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        this.queue.addLast(runnable0);
        if(LimitedDispatcher.runningWorkers$volatile$FU.get(this) < this.parallelism && this.tryAllocateWorker()) {
            Runnable runnable1 = this.obtainTaskOrDeallocateWorker();
            if(runnable1 != null) {
                try {
                    Worker limitedDispatcher$Worker0 = new Worker(this, runnable1);
                    DispatchedContinuationKt.safeDispatch(this.dispatcher, this, limitedDispatcher$Worker0);
                }
                catch(Throwable throwable0) {
                    LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this);
                    throw throwable0;
                }
            }
        }
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        this.queue.addLast(runnable0);
        if(LimitedDispatcher.runningWorkers$volatile$FU.get(this) < this.parallelism && this.tryAllocateWorker()) {
            Runnable runnable1 = this.obtainTaskOrDeallocateWorker();
            if(runnable1 != null) {
                try {
                    Worker limitedDispatcher$Worker0 = new Worker(this, runnable1);
                    this.dispatcher.dispatchYield(this, limitedDispatcher$Worker0);
                }
                catch(Throwable throwable0) {
                    LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this);
                    throw throwable0;
                }
            }
        }
    }

    @Override  // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        return this.$$delegate_0.invokeOnTimeout(v, runnable0, i0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        LimitedDispatcherKt.checkParallelism(v);
        return v < this.parallelism ? super.limitedParallelism(v, s) : LimitedDispatcherKt.namedOrThis(this, s);
    }

    private final Runnable obtainTaskOrDeallocateWorker() {
        Runnable runnable0;
        while((runnable0 = (Runnable)this.queue.removeFirstOrNull()) == null) {
            synchronized(this.workerAllocationLock) {
                LimitedDispatcher.runningWorkers$volatile$FU.decrementAndGet(this);
                if(this.queue.getSize() == 0) {
                    return null;
                }
                LimitedDispatcher.runningWorkers$volatile$FU.incrementAndGet(this);
            }
        }
        return runnable0;
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, @NotNull CancellableContinuation cancellableContinuation0) {
        this.$$delegate_0.scheduleResumeAfterDelay(v, cancellableContinuation0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String s = this.name;
        if(s == null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(this.dispatcher);
            stringBuilder0.append(".limitedParallelism(");
            return o.q(stringBuilder0, this.parallelism, ')');
        }
        return s;
    }

    private final boolean tryAllocateWorker() {
        synchronized(this.workerAllocationLock) {
            if(LimitedDispatcher.runningWorkers$volatile$FU.get(this) >= this.parallelism) {
                return false;
            }
            LimitedDispatcher.runningWorkers$volatile$FU.incrementAndGet(this);
            return true;
        }
    }
}

