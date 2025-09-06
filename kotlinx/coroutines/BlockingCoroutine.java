package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\b\u001A\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lme/i;", "parentContext", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "<init>", "(Lme/i;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "", "state", "Lie/H;", "afterCompletion", "(Ljava/lang/Object;)V", "joinBlocking", "()Ljava/lang/Object;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/EventLoop;", "", "isScopedCoroutine", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class BlockingCoroutine extends AbstractCoroutine {
    @NotNull
    private final Thread blockedThread;
    @Nullable
    private final EventLoop eventLoop;

    public BlockingCoroutine(@NotNull i i0, @NotNull Thread thread0, @Nullable EventLoop eventLoop0) {
        super(i0, true, true);
        this.blockedThread = thread0;
        this.eventLoop = eventLoop0;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object object0) {
        if(!q.b(Thread.currentThread(), this.blockedThread)) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    @Override  // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }

    public final Object joinBlocking() {
        EventLoop eventLoop0 = this.eventLoop;
        CompletedExceptionally completedExceptionally0 = null;
        if(eventLoop0 != null) {
            EventLoop.incrementUseCount$default(eventLoop0, false, 1, null);
        }
        try {
            while(true) {
                long v1 = this.eventLoop == null ? 0x7FFFFFFFFFFFFFFFL : this.eventLoop.processNextEvent();
                if(this.isCompleted()) {
                    break;
                }
                LockSupport.parkNanos(this, v1);
                if(Thread.interrupted()) {
                    this.cancelCoroutine(new InterruptedException());
                }
            }
        }
        finally {
            EventLoop eventLoop1 = this.eventLoop;
            if(eventLoop1 != null) {
                EventLoop.decrementUseCount$default(eventLoop1, false, 1, null);
            }
        }
        Object object0 = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if(object0 instanceof CompletedExceptionally) {
            completedExceptionally0 = (CompletedExceptionally)object0;
        }
        if(completedExceptionally0 != null) {
            throw completedExceptionally0.cause;
        }
        return object0;
    }
}

