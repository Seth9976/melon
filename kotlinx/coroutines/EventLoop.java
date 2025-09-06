package kotlinx.coroutines;

import je.m;
import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0011\u001A\u00020\u00102\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u000E¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u00102\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\u00102\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\u001F\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001C\u0010\u0003R\u0016\u0010\u001D\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\"\u0010\"\u001A\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E\u0018\u00010!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001A\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b$\u0010\nR\u0011\u0010&\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b&\u0010\fR\u0011\u0010\'\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\'\u0010\f¨\u0006("}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "unconfined", "", "delta", "(Z)J", "processNextEvent", "()J", "processUnconfinedEvent", "()Z", "shouldBeProcessedFromContext", "Lkotlinx/coroutines/DispatchedTask;", "task", "Lie/H;", "dispatchUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "incrementUseCount", "(Z)V", "decrementUseCount", "", "parallelism", "", "name", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "shutdown", "useCount", "J", "shared", "Z", "Lje/m;", "unconfinedQueue", "Lje/m;", "getNextTime", "nextTime", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class EventLoop extends CoroutineDispatcher {
    private boolean shared;
    @Nullable
    private m unconfinedQueue;
    private long useCount;

    public final void decrementUseCount(boolean z) {
        long v = this.useCount - this.delta(z);
        this.useCount = v;
        if(v <= 0L && this.shared) {
            this.shutdown();
        }
    }

    public static void decrementUseCount$default(EventLoop eventLoop0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if((v & 1) != 0) {
            z = false;
        }
        eventLoop0.decrementUseCount(z);
    }

    // 去混淆评级： 低(20)
    private final long delta(boolean z) [...] // 潜在的解密器

    public final void dispatchUnconfined(@NotNull DispatchedTask dispatchedTask0) {
        m m0 = this.unconfinedQueue;
        if(m0 == null) {
            m0 = new m();
            this.unconfinedQueue = m0;
        }
        m0.addLast(dispatchedTask0);
    }

    public long getNextTime() {
        m m0 = this.unconfinedQueue;
        if(m0 == null) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        return m0.isEmpty() ? 0x7FFFFFFFFFFFFFFFL : 0L;
    }

    public final void incrementUseCount(boolean z) {
        this.useCount += this.delta(z);
        if(!z) {
            this.shared = true;
        }
    }

    public static void incrementUseCount$default(EventLoop eventLoop0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if((v & 1) != 0) {
            z = false;
        }
        eventLoop0.incrementUseCount(z);
    }

    // 去混淆评级： 低(20)
    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= 0x100000000L;
    }

    public final boolean isUnconfinedQueueEmpty() {
        return this.unconfinedQueue == null ? true : this.unconfinedQueue.isEmpty();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public final CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        LimitedDispatcherKt.checkParallelism(v);
        return LimitedDispatcherKt.namedOrThis(this, s);
    }

    public abstract long processNextEvent();

    public final boolean processUnconfinedEvent() {
        m m0 = this.unconfinedQueue;
        if(m0 != null) {
            Object object0 = m0.isEmpty() ? null : m0.removeFirst();
            if(((DispatchedTask)object0) != null) {
                ((DispatchedTask)object0).run();
                return true;
            }
        }
        return false;
    }

    public boolean shouldBeProcessedFromContext() [...] // Inlined contents

    public abstract void shutdown();
}

