package okio;

import ie.d;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001A\u00020\b*\u00020\u00062\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u0006\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\f\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0014\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\b\u00A2\u0006\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0003\u001A\u00020\u00028\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001B\u001A\u00020\u001A8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\"\u0010 \u001A\u00020\u001F8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001A\u00020\u001F8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010#\"\u0004\b(\u0010%R\"\u0010)\u001A\u00020\u001F8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010!\u001A\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001A\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b,\u0010-\u001A\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u000ER\u0017\u00101\u001A\u0002008\u0006\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104R\u0017\u00106\u001A\u0002058\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u00109R\u0017\u0010\f\u001A\u00020\u00068G\u00A2\u0006\f\n\u0004\b\f\u0010-\u001A\u0004\b\f\u0010\u0010R\u0017\u0010\u0014\u001A\u00020\u00118G\u00A2\u0006\f\n\u0004\b\u0014\u0010:\u001A\u0004\b\u0014\u0010\u0013\u00A8\u0006;"}, d2 = {"Lokio/Pipe;", "", "", "maxBufferSize", "<init>", "(J)V", "Lokio/Sink;", "Lkotlin/Function1;", "Lie/H;", "block", "forward", "(Lokio/Sink;Lwe/k;)V", "sink", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", "source", "cancel", "()V", "J", "getMaxBufferSize$okio", "()J", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "", "canceled", "Z", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "Lokio/Source;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Pipe {
    @NotNull
    private final Buffer buffer;
    private boolean canceled;
    @NotNull
    private final Condition condition;
    @Nullable
    private Sink foldedSink;
    @NotNull
    private final ReentrantLock lock;
    private final long maxBufferSize;
    @NotNull
    private final Sink sink;
    private boolean sinkClosed;
    @NotNull
    private final Source source;
    private boolean sourceClosed;

    @d
    @NotNull
    public final Sink -deprecated_sink() {
        return this.sink;
    }

    @d
    @NotNull
    public final Source -deprecated_source() {
        return this.source;
    }

    public Pipe(long v) {
        this.maxBufferSize = v;
        this.buffer = new Buffer();
        ReentrantLock reentrantLock0 = new ReentrantLock();
        this.lock = reentrantLock0;
        Condition condition0 = reentrantLock0.newCondition();
        q.f(condition0, "newCondition(...)");
        this.condition = condition0;
        if(v < 1L) {
            throw new IllegalArgumentException(e.a(v, "maxBufferSize < 1: ").toString());
        }
        this.sink = new Sink() {
            private final Timeout timeout;

            {
                this.timeout = new Timeout();
            }

            @Override  // okio.Sink
            public void close() {
                Sink sink0;
                ReentrantLock reentrantLock0 = Pipe.this.getLock();
                Pipe pipe0 = Pipe.this;
                reentrantLock0.lock();
                try {
                    if(!pipe0.getSinkClosed$okio()) {
                        sink0 = pipe0.getFoldedSink$okio();
                        if(sink0 == null) {
                            if(pipe0.getSourceClosed$okio() && pipe0.getBuffer$okio().size() > 0L) {
                                throw new IOException("source is closed");
                            }
                            pipe0.setSinkClosed$okio(true);
                            pipe0.getCondition().signalAll();
                            sink0 = null;
                        }
                        goto label_15;
                    }
                    goto label_53;
                }
                catch(Throwable throwable0) {
                }
                reentrantLock0.unlock();
                throw throwable0;
            label_15:
                reentrantLock0.unlock();
                if(sink0 != null) {
                    Timeout timeout0 = sink0.timeout();
                    Timeout timeout1 = Pipe.this.sink().timeout();
                    long v = timeout0.timeoutNanos();
                    long v1 = timeout1.timeoutNanos();
                    long v2 = timeout0.timeoutNanos();
                    TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
                    timeout0.timeout(Timeout.Companion.minTimeout(v1, v2), timeUnit0);
                    if(timeout0.hasDeadline()) {
                        long v3 = timeout0.deadlineNanoTime();
                        if(timeout1.hasDeadline()) {
                            timeout0.deadlineNanoTime(Math.min(timeout0.deadlineNanoTime(), timeout1.deadlineNanoTime()));
                        }
                        try {
                            sink0.close();
                        }
                        catch(Throwable throwable1) {
                            timeout0.timeout(v, TimeUnit.NANOSECONDS);
                            if(timeout1.hasDeadline()) {
                                timeout0.deadlineNanoTime(v3);
                            }
                            throw throwable1;
                        }
                        timeout0.timeout(v, timeUnit0);
                        if(timeout1.hasDeadline()) {
                            timeout0.deadlineNanoTime(v3);
                            return;
                        }
                    }
                    else {
                        if(timeout1.hasDeadline()) {
                            timeout0.deadlineNanoTime(timeout1.deadlineNanoTime());
                        }
                        try {
                            sink0.close();
                        }
                        catch(Throwable throwable2) {
                            timeout0.timeout(v, TimeUnit.NANOSECONDS);
                            if(timeout1.hasDeadline()) {
                                timeout0.clearDeadline();
                            }
                            throw throwable2;
                        }
                        timeout0.timeout(v, timeUnit0);
                        if(timeout1.hasDeadline()) {
                            timeout0.clearDeadline();
                            return;
                        }
                    }
                }
                return;
            label_53:
                reentrantLock0.unlock();
            }

            @Override  // okio.Sink
            public void flush() {
                ReentrantLock reentrantLock0 = Pipe.this.getLock();
                Pipe pipe0 = Pipe.this;
                reentrantLock0.lock();
                try {
                    if(!pipe0.getSinkClosed$okio()) {
                        if(pipe0.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        Sink sink0 = pipe0.getFoldedSink$okio();
                        if(sink0 == null) {
                            if(pipe0.getSourceClosed$okio() && pipe0.getBuffer$okio().size() > 0L) {
                                throw new IOException("source is closed");
                            }
                            sink0 = null;
                        }
                        if(sink0 != null) {
                            Timeout timeout0 = sink0.timeout();
                            Timeout timeout1 = Pipe.this.sink().timeout();
                            long v1 = timeout0.timeoutNanos();
                            long v2 = timeout1.timeoutNanos();
                            long v3 = timeout0.timeoutNanos();
                            TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
                            timeout0.timeout(Timeout.Companion.minTimeout(v2, v3), timeUnit0);
                            if(timeout0.hasDeadline()) {
                                long v4 = timeout0.deadlineNanoTime();
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(Math.min(timeout0.deadlineNanoTime(), timeout1.deadlineNanoTime()));
                                }
                                try {
                                    sink0.flush();
                                }
                                catch(Throwable throwable0) {
                                    timeout0.timeout(v1, TimeUnit.NANOSECONDS);
                                    if(timeout1.hasDeadline()) {
                                        timeout0.deadlineNanoTime(v4);
                                    }
                                    throw throwable0;
                                }
                                timeout0.timeout(v1, timeUnit0);
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(v4);
                                    return;
                                }
                            }
                            else {
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(timeout1.deadlineNanoTime());
                                }
                                try {
                                    sink0.flush();
                                }
                                catch(Throwable throwable1) {
                                    timeout0.timeout(v1, TimeUnit.NANOSECONDS);
                                    if(timeout1.hasDeadline()) {
                                        timeout0.clearDeadline();
                                    }
                                    throw throwable1;
                                }
                                timeout0.timeout(v1, timeUnit0);
                                if(timeout1.hasDeadline()) {
                                    timeout0.clearDeadline();
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
                finally {
                    reentrantLock0.unlock();
                }
                throw new IllegalStateException("closed");
            }

            @Override  // okio.Sink
            public Timeout timeout() {
                return this.timeout;
            }

            @Override  // okio.Sink
            public void write(Buffer buffer0, long v) {
                Sink sink1;
                q.g(buffer0, "source");
                ReentrantLock reentrantLock0 = Pipe.this.getLock();
                Pipe pipe0 = Pipe.this;
                reentrantLock0.lock();
                try {
                    if(!pipe0.getSinkClosed$okio()) {
                        if(pipe0.getCanceled$okio()) {
                            throw new IOException("canceled");
                        }
                        while(v > 0L) {
                            Sink sink0 = pipe0.getFoldedSink$okio();
                            if(sink0 != null) {
                                sink1 = sink0;
                                goto label_27;
                            }
                            if(pipe0.getSourceClosed$okio()) {
                                throw new IOException("source is closed");
                            }
                            long v2 = pipe0.getMaxBufferSize$okio() - pipe0.getBuffer$okio().size();
                            if(v2 == 0L) {
                                this.timeout.awaitSignal(pipe0.getCondition());
                                if(pipe0.getCanceled$okio()) {
                                    throw new IOException("canceled");
                                }
                            }
                            else {
                                long v3 = Math.min(v2, v);
                                pipe0.getBuffer$okio().write(buffer0, v3);
                                v -= v3;
                                pipe0.getCondition().signalAll();
                            }
                        }
                        sink1 = null;
                    label_27:
                        if(sink1 != null) {
                            Timeout timeout0 = sink1.timeout();
                            Timeout timeout1 = Pipe.this.sink().timeout();
                            long v4 = timeout0.timeoutNanos();
                            long v5 = timeout1.timeoutNanos();
                            long v6 = timeout0.timeoutNanos();
                            TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
                            timeout0.timeout(Timeout.Companion.minTimeout(v5, v6), timeUnit0);
                            if(timeout0.hasDeadline()) {
                                long v7 = timeout0.deadlineNanoTime();
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(Math.min(timeout0.deadlineNanoTime(), timeout1.deadlineNanoTime()));
                                }
                                try {
                                    sink1.write(buffer0, v);
                                }
                                catch(Throwable throwable0) {
                                    timeout0.timeout(v4, TimeUnit.NANOSECONDS);
                                    if(timeout1.hasDeadline()) {
                                        timeout0.deadlineNanoTime(v7);
                                    }
                                    throw throwable0;
                                }
                                timeout0.timeout(v4, timeUnit0);
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(v7);
                                    return;
                                }
                            }
                            else {
                                if(timeout1.hasDeadline()) {
                                    timeout0.deadlineNanoTime(timeout1.deadlineNanoTime());
                                }
                                try {
                                    sink1.write(buffer0, v);
                                }
                                catch(Throwable throwable1) {
                                    timeout0.timeout(v4, TimeUnit.NANOSECONDS);
                                    if(timeout1.hasDeadline()) {
                                        timeout0.clearDeadline();
                                    }
                                    throw throwable1;
                                }
                                timeout0.timeout(v4, timeUnit0);
                                if(timeout1.hasDeadline()) {
                                    timeout0.clearDeadline();
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
                finally {
                    reentrantLock0.unlock();
                }
                throw new IllegalStateException("closed");
            }
        };
        this.source = new Source() {
            private final Timeout timeout;

            {
                this.timeout = new Timeout();
            }

            @Override  // okio.Source
            public void close() {
                ReentrantLock reentrantLock0 = Pipe.this.getLock();
                reentrantLock0.lock();
                try {
                    Pipe.this.setSourceClosed$okio(true);
                    Pipe.this.getCondition().signalAll();
                }
                finally {
                    reentrantLock0.unlock();
                }
            }

            @Override  // okio.Source
            public long read(Buffer buffer0, long v) {
                long v1;
                q.g(buffer0, "sink");
                ReentrantLock reentrantLock0 = Pipe.this.getLock();
                Pipe pipe0 = Pipe.this;
                reentrantLock0.lock();
                try {
                    if(pipe0.getSourceClosed$okio()) {
                        throw new IllegalStateException("closed");
                    }
                    if(pipe0.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while(true) {
                    label_8:
                        if(pipe0.getBuffer$okio().size() != 0L) {
                            v1 = pipe0.getBuffer$okio().read(buffer0, v);
                            pipe0.getCondition().signalAll();
                            break;
                        }
                        goto label_13;
                    }
                }
                catch(Throwable throwable0) {
                    reentrantLock0.unlock();
                    throw throwable0;
                }
                reentrantLock0.unlock();
                return v1;
            label_13:
                if(pipe0.getSinkClosed$okio()) {
                    reentrantLock0.unlock();
                    return -1L;
                }
                try {
                    this.timeout.awaitSignal(pipe0.getCondition());
                    if(pipe0.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    goto label_8;
                }
                catch(Throwable throwable0) {
                }
                reentrantLock0.unlock();
                throw throwable0;
            }

            @Override  // okio.Source
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final void cancel() {
        this.lock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
        }
        finally {
            this.lock.unlock();
        }
    }

    public final void fold(@NotNull Sink sink0) {
        boolean z1;
        Buffer buffer0;
        int v;
        q.g(sink0, "sink");
        while(true) {
            ReentrantLock reentrantLock0 = this.lock;
            reentrantLock0.lock();
            v = FIN.finallyOpen$NT();
            if(this.foldedSink != null) {
                goto label_42;
            }
            if(this.canceled) {
                goto label_39;
            }
            boolean z = this.sinkClosed;
            if(this.buffer.exhausted()) {
                this.sourceClosed = true;
                this.foldedSink = sink0;
                buffer0 = null;
                z1 = true;
            }
            else {
                buffer0 = new Buffer();
                buffer0.write(this.buffer, this.buffer.size());
                this.condition.signalAll();
                z1 = false;
            }
            FIN.finallyCodeBegin$NT(v);
            reentrantLock0.unlock();
            FIN.finallyCodeEnd$NT(v);
            if(z1) {
                if(z) {
                    sink0.close();
                }
                return;
            }
            try {
                if(buffer0 == null) {
                    q.m("sinkBuffer");
                    throw null;
                }
                sink0.write(buffer0, buffer0.size());
                sink0.flush();
                continue;
            }
            catch(Throwable throwable0) {
            }
            break;
        }
        this.lock.lock();
        try {
            this.sourceClosed = true;
            this.condition.signalAll();
        }
        finally {
            this.lock.unlock();
        }
        throw throwable0;
    label_39:
        this.foldedSink = sink0;
        FIN.finallyExec$NT(v);
        throw new IOException("canceled");
    label_42:
        FIN.finallyExec$NT(v);
        throw new IllegalStateException("sink already folded");
    }

    private final void forward(Sink sink0, k k0) {
        Timeout timeout0 = sink0.timeout();
        Timeout timeout1 = this.sink().timeout();
        long v = timeout0.timeoutNanos();
        long v1 = timeout1.timeoutNanos();
        long v2 = timeout0.timeoutNanos();
        TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
        timeout0.timeout(Timeout.Companion.minTimeout(v1, v2), timeUnit0);
        if(timeout0.hasDeadline()) {
            long v3 = timeout0.deadlineNanoTime();
            if(timeout1.hasDeadline()) {
                timeout0.deadlineNanoTime(Math.min(timeout0.deadlineNanoTime(), timeout1.deadlineNanoTime()));
            }
            try {
                k0.invoke(sink0);
            }
            catch(Throwable throwable0) {
                timeout0.timeout(v, TimeUnit.NANOSECONDS);
                if(timeout1.hasDeadline()) {
                    timeout0.deadlineNanoTime(v3);
                }
                throw throwable0;
            }
            timeout0.timeout(v, timeUnit0);
            if(timeout1.hasDeadline()) {
                timeout0.deadlineNanoTime(v3);
            }
            return;
        }
        if(timeout1.hasDeadline()) {
            timeout0.deadlineNanoTime(timeout1.deadlineNanoTime());
        }
        try {
            k0.invoke(sink0);
        }
        catch(Throwable throwable1) {
            timeout0.timeout(v, TimeUnit.NANOSECONDS);
            if(timeout1.hasDeadline()) {
                timeout0.clearDeadline();
            }
            throw throwable1;
        }
        timeout0.timeout(v, timeUnit0);
        if(timeout1.hasDeadline()) {
            timeout0.clearDeadline();
        }
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink0) {
        this.foldedSink = sink0;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @NotNull
    public final Source source() {
        return this.source;
    }
}

