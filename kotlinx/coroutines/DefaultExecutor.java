package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000E\u0010\u0005J\u001B\u0010\u0010\u001A\u00020\u00062\n\u0010\u000F\u001A\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J+\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0019\u001A\u00020\u00122\n\u0010\u001A\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0005J\u000F\u0010\"\u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001E\u0010&\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\f\n\u0004\b&\u0010\'\u0012\u0004\b(\u0010\u0005R\u0016\u0010*\u001A\u00020)8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b,\u0010\rR\u0014\u0010-\u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b-\u0010\rR\u0014\u0010/\u001A\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b.\u0010\n¨\u00060"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "Lie/H;", "shutdownError", "Ljava/lang/Thread;", "createThreadSync", "()Ljava/lang/Thread;", "", "notifyStartup", "()Z", "acknowledgeShutdownIfNeeded", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "shutdown", "timeMillis", "block", "Lme/i;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "run", "", "toString", "()Ljava/lang/String;", "KEEP_ALIVE_NANOS", "J", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "debugStatus", "I", "isShutDown", "isShutdownRequested", "getThread", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    @NotNull
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        DefaultExecutor defaultExecutor0 = new DefaultExecutor();
        DefaultExecutor.INSTANCE = defaultExecutor0;
        EventLoop.incrementUseCount$default(defaultExecutor0, false, 1, null);
        DefaultExecutor.KEEP_ALIVE_NANOS = TimeUnit.MILLISECONDS.toNanos(1000L);
    }

    private final void acknowledgeShutdownIfNeeded() {
        synchronized(this) {
        }
    }

    private final Thread createThreadSync() {
        synchronized(this) {
            Thread thread0 = DefaultExecutor._thread;
            if(thread0 == null) {
                thread0 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                DefaultExecutor._thread = thread0;
                thread0.setContextClassLoader(DefaultExecutor.INSTANCE.getClass().getClassLoader());
                thread0.setDaemon(true);
                thread0.start();
            }
            return thread0;
        }
    }

    @Override  // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(@NotNull Runnable runnable0) {
        if(this.isShutDown()) {
            this.shutdownError();
        }
        super.enqueue(runnable0);
    }

    @Override  // kotlinx.coroutines.EventLoopImplPlatform
    @NotNull
    public Thread getThread() {
        return DefaultExecutor._thread == null ? this.createThreadSync() : DefaultExecutor._thread;
    }

    @Override  // kotlinx.coroutines.EventLoopImplBase
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        return this.scheduleInvokeOnTimeout(v, runnable0);
    }

    private final boolean isShutDown() {
        return false;
    }

    private final boolean isShutdownRequested() [...] // 潜在的解密器

    private final boolean notifyStartup() {
        synchronized(this) {
            DefaultExecutor.debugStatus = 1;
            this.notifyAll();
            return true;
        }
    }

    @Override  // kotlinx.coroutines.EventLoopImplPlatform
    public void reschedule(long v, @NotNull DelayedTask eventLoopImplBase$DelayedTask0) {
        this.shutdownError();
    }

    @Override
    public void run() {
        long v1;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        try {
            if(!this.notifyStartup()) {
                goto label_2;
            }
            goto label_7;
        }
        catch(Throwable throwable0) {
            goto label_30;
        }
    label_2:
        DefaultExecutor._thread = null;
        this.acknowledgeShutdownIfNeeded();
        if(this.isEmpty()) {
            return;
        }
        this.getThread();
        return;
    label_7:
        long v = 0x7FFFFFFFFFFFFFFFL;
        while(true) {
            try {
            label_8:
                Thread.interrupted();
                v1 = this.processNextEvent();
                if(Long.compare(v1, 0x7FFFFFFFFFFFFFFFL) != 0) {
                    v = 0x7FFFFFFFFFFFFFFFL;
                    goto label_26;
                }
            }
            catch(Throwable throwable0) {
                break;
            }
            long v2 = System.nanoTime();
            if(v == 0x7FFFFFFFFFFFFFFFL) {
                v = DefaultExecutor.KEEP_ALIVE_NANOS + v2;
            }
            long v3 = v - v2;
            if(v3 <= 0L) {
                DefaultExecutor._thread = null;
                this.acknowledgeShutdownIfNeeded();
                if(!this.isEmpty()) {
                    this.getThread();
                    return;
                }
                return;
            }
            if(v1 > v3) {
                v1 = v3;
            }
        label_26:
            if(v1 <= 0L) {
                goto label_8;
            }
            try {
                LockSupport.parkNanos(this, v1);
                goto label_8;
            }
            catch(Throwable throwable0) {
            }
            break;
        }
    label_30:
        DefaultExecutor._thread = null;
        this.acknowledgeShutdownIfNeeded();
        if(!this.isEmpty()) {
            this.getThread();
        }
        throw throwable0;
    }

    @Override  // kotlinx.coroutines.EventLoopImplBase
    public void shutdown() {
        DefaultExecutor.debugStatus = 4;
        super.shutdown();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "DefaultExecutor";
    }
}

