package okio;

import Uf.b;
import Uf.d;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000F\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\nJ\u0017\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0011\u0010\bJ\u000F\u0010\u0012\u001A\u00020\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000F\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001C\u001A\u00020\u0001H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ/\u0010#\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u001F2\u0006\u0010 \u001A\u00020\u00002\f\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0016\u0010\f\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\f\u0010%R\u0016\u0010\u000E\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010&R\u0016\u0010\t\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\t\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Lokio/Timeout;", "", "<init>", "()V", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lokio/Timeout;", "duration", "deadline", "clearTimeout", "()Lokio/Timeout;", "clearDeadline", "Lie/H;", "throwIfReached", "cancel", "Ljava/util/concurrent/locks/Condition;", "condition", "awaitSignal", "(Ljava/util/concurrent/locks/Condition;)V", "monitor", "waitUntilNotified", "(Ljava/lang/Object;)V", "T", "other", "Lkotlin/Function0;", "block", "intersectWith", "(Lokio/Timeout;Lwe/a;)Ljava/lang/Object;", "Z", "J", "cancelMark", "Ljava/lang/Object;", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class Timeout {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0006\u0010\tJ\u0019\u0010\u0006\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokio/Timeout$Companion;", "", "<init>", "()V", "Lokio/Timeout;", "", "timeout", "LUf/d;", "unit", "(Lokio/Timeout;JLUf/d;)Lokio/Timeout;", "LUf/b;", "duration", "timeout-HG0u8IE", "(Lokio/Timeout;J)Lokio/Timeout;", "aNanos", "bNanos", "minTimeout", "(JJ)J", "NONE", "Lokio/Timeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final long minTimeout(long v, long v1) {
            return v == 0L || v1 != 0L && v >= v1 ? v1 : v;
        }

        @NotNull
        public final Timeout timeout(@NotNull Timeout timeout0, long v, @NotNull d d0) {
            q.g(timeout0, "<this>");
            q.g(d0, "unit");
            return timeout0.timeout(v, d0.a);
        }

        @NotNull
        public final Timeout timeout-HG0u8IE(@NotNull Timeout timeout0, long v) {
            q.g(timeout0, "$this$timeout");
            return timeout0.timeout(b.e(v), TimeUnit.NANOSECONDS);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final Timeout NONE;
    @Nullable
    private volatile Object cancelMark;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    static {
        Timeout.Companion = new Companion(null);
        Timeout.NONE = new Timeout.Companion.NONE.1();
    }

    public void awaitSignal(@NotNull Condition condition0) {
        q.g(condition0, "condition");
        try {
            boolean z = this.hasDeadline();
            long v = this.timeoutNanos();
            if(!z && v == 0L) {
                condition0.await();
                return;
            }
            if(z && v != 0L) {
                v = Math.min(v, this.deadlineNanoTime() - System.nanoTime());
            }
            else if(z) {
                v = this.deadlineNanoTime() - System.nanoTime();
            }
            if(Long.compare(v, 0L) <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object object0 = this.cancelMark;
            if(condition0.awaitNanos(v) <= 0L && this.cancelMark == object0) {
                throw new InterruptedIOException("timeout");
            }
        }
        catch(InterruptedException unused_ex) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public void cancel() {
        this.cancelMark = new Object();
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @NotNull
    public final Timeout deadline(long v, @NotNull TimeUnit timeUnit0) {
        q.g(timeUnit0, "unit");
        if(v <= 0L) {
            throw new IllegalArgumentException(e.a(v, "duration <= 0: ").toString());
        }
        return this.deadlineNanoTime(timeUnit0.toNanos(v) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if(!this.hasDeadline) {
            throw new IllegalStateException("No deadline");
        }
        return this.deadlineNanoTime;
    }

    @NotNull
    public Timeout deadlineNanoTime(long v) {
        this.hasDeadline = true;
        this.deadlineNanoTime = v;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final Object intersectWith(@NotNull Timeout timeout0, @NotNull a a0) {
        Object object1;
        Object object0;
        q.g(timeout0, "other");
        q.g(a0, "block");
        long v = this.timeoutNanos();
        long v1 = timeout0.timeoutNanos();
        long v2 = this.timeoutNanos();
        TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
        this.timeout(Timeout.Companion.minTimeout(v1, v2), timeUnit0);
        if(this.hasDeadline()) {
            long v3 = this.deadlineNanoTime();
            if(timeout0.hasDeadline()) {
                this.deadlineNanoTime(Math.min(this.deadlineNanoTime(), timeout0.deadlineNanoTime()));
            }
            try {
                object0 = a0.invoke();
            }
            catch(Throwable throwable0) {
                this.timeout(v, TimeUnit.NANOSECONDS);
                if(timeout0.hasDeadline()) {
                    this.deadlineNanoTime(v3);
                }
                throw throwable0;
            }
            this.timeout(v, timeUnit0);
            if(timeout0.hasDeadline()) {
                this.deadlineNanoTime(v3);
            }
            return object0;
        }
        if(timeout0.hasDeadline()) {
            this.deadlineNanoTime(timeout0.deadlineNanoTime());
        }
        try {
            object1 = a0.invoke();
        }
        catch(Throwable throwable1) {
            this.timeout(v, TimeUnit.NANOSECONDS);
            if(timeout0.hasDeadline()) {
                this.clearDeadline();
            }
            throw throwable1;
        }
        this.timeout(v, timeUnit0);
        if(timeout0.hasDeadline()) {
            this.clearDeadline();
        }
        return object1;
    }

    public void throwIfReached() {
        if(Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if(this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0L) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public Timeout timeout(long v, @NotNull TimeUnit timeUnit0) {
        q.g(timeUnit0, "unit");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "timeout < 0: ").toString());
        }
        this.timeoutNanos = timeUnit0.toNanos(v);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public void waitUntilNotified(@NotNull Object object0) {
        q.g(object0, "monitor");
        try {
            boolean z = this.hasDeadline();
            long v = this.timeoutNanos();
            if(!z && v == 0L) {
                object0.wait();
                return;
            }
            long v1 = System.nanoTime();
            if(z && v != 0L) {
                v = Math.min(v, this.deadlineNanoTime() - v1);
            }
            else if(z) {
                v = this.deadlineNanoTime() - v1;
            }
            if(Long.compare(v, 0L) <= 0) {
                throw new InterruptedIOException("timeout");
            }
            Object object1 = this.cancelMark;
            object0.wait(v / 1000000L, ((int)(v - 1000000L * (v / 1000000L))));
            if(System.nanoTime() - v1 >= v && this.cancelMark == object1) {
                throw new InterruptedIOException("timeout");
            }
        }
        catch(InterruptedException unused_ex) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

