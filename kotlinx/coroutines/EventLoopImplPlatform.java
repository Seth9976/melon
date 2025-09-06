package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001F\u0010\n\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\f8$X¤\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "<init>", "()V", "Lie/H;", "unpark", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class EventLoopImplPlatform extends EventLoop {
    @NotNull
    public abstract Thread getThread();

    public void reschedule(long v, @NotNull DelayedTask eventLoopImplBase$DelayedTask0) {
        DefaultExecutor.INSTANCE.schedule(v, eventLoopImplBase$DelayedTask0);
    }

    public final void unpark() {
        Thread thread0 = this.getThread();
        if(Thread.currentThread() != thread0) {
            LockSupport.unpark(thread0);
        }
    }
}

