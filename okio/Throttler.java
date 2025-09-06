package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001A\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ+\u0010\n\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\bJ\u001F\u0010\u0015\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001BR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u001CR\u0016\u0010\n\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\n\u0010\u001CR\u0016\u0010\u000B\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000B\u0010\u001CR\u0016\u0010\f\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\f\u0010\u001CR\u0017\u0010\u001E\u001A\u00020\u001D8\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u0017\u0010#\u001A\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lokio/Throttler;", "", "", "allocatedUntil", "<init>", "(J)V", "()V", "nanosToBytes", "(J)J", "bytesToNanos", "bytesPerSecond", "waitByteCount", "maxByteCount", "Lie/H;", "(JJJ)V", "byteCount", "take$okio", "take", "now", "byteCountOrWaitNanos$okio", "(JJ)J", "byteCountOrWaitNanos", "Lokio/Source;", "source", "(Lokio/Source;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", "J", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    @NotNull
    private final Condition condition;
    @NotNull
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler() {
        this(System.nanoTime());
    }

    public Throttler(long v) {
        this.allocatedUntil = v;
        this.waitByteCount = 0x2000L;
        this.maxByteCount = 0x40000L;
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        Condition condition0 = reentrantLock0.newCondition();
        q.f(condition0, "newCondition(...)");
        this.condition = condition0;
    }

    public final long byteCountOrWaitNanos$okio(long v, long v1) {
        if(this.bytesPerSecond == 0L) {
            return v1;
        }
        long v2 = Math.max(this.allocatedUntil - v, 0L);
        long v3 = this.maxByteCount - this.nanosToBytes(v2);
        if(v3 >= v1) {
            this.allocatedUntil = v + v2 + this.bytesToNanos(v1);
            return v1;
        }
        long v4 = this.waitByteCount;
        if(v3 >= v4) {
            this.allocatedUntil = v + this.bytesToNanos(this.maxByteCount);
            return v3;
        }
        long v5 = Math.min(v4, v1);
        long v6 = v2 + this.bytesToNanos(v5 - this.maxByteCount);
        if(v6 == 0L) {
            this.allocatedUntil = v + this.bytesToNanos(this.maxByteCount);
            return v5;
        }
        return -v6;
    }

    public final void bytesPerSecond(long v) {
        Throttler.bytesPerSecond$default(this, v, 0L, 0L, 6, null);
    }

    public final void bytesPerSecond(long v, long v1) {
        Throttler.bytesPerSecond$default(this, v, v1, 0L, 4, null);
    }

    public final void bytesPerSecond(long v, long v1, long v2) {
        ReentrantLock reentrantLock0 = this.lock;
        reentrantLock0.lock();
        try {
            if(Long.compare(v, 0L) >= 0 && v1 > 0L && v2 >= v1) {
                this.bytesPerSecond = v;
                this.waitByteCount = v1;
                this.maxByteCount = v2;
                this.condition.signalAll();
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static void bytesPerSecond$default(Throttler throttler0, long v, long v1, long v2, int v3, Object object0) {
        if((v3 & 2) != 0) {
            v1 = throttler0.waitByteCount;
        }
        if((v3 & 4) != 0) {
            v2 = throttler0.maxByteCount;
        }
        throttler0.bytesPerSecond(v, v1, v2);
    }

    private final long bytesToNanos(long v) {
        return v * 1000000000L / this.bytesPerSecond;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    private final long nanosToBytes(long v) {
        return v * this.bytesPerSecond / 1000000000L;
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        return new ForwardingSink(this) {
            @Override  // okio.ForwardingSink
            public void write(Buffer buffer0, long v) {
                q.g(buffer0, "source");
                while(v > 0L) {
                    try {
                        long v1 = Throttler.this.take$okio(v);
                        super.write(buffer0, v1);
                        v -= v1;
                    }
                    catch(InterruptedException unused_ex) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull Source source0) {
        q.g(source0, "source");
        return new ForwardingSource(this) {
            @Override  // okio.ForwardingSource
            public long read(Buffer buffer0, long v) {
                q.g(buffer0, "sink");
                try {
                    return super.read(buffer0, Throttler.this.take$okio(v));
                }
                catch(InterruptedException unused_ex) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long v) {
        if(v > 0L) {
            ReentrantLock reentrantLock0 = this.lock;
            reentrantLock0.lock();
            try {
                long v2;
                while((v2 = this.byteCountOrWaitNanos$okio(System.nanoTime(), v)) < 0L) {
                    this.condition.awaitNanos(-v2);
                }
                return v2;
            }
            finally {
                reentrantLock0.unlock();
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}

