package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 &2\u00020\u0001:\u0002\'&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000F\u0010\u000E\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000E\u0010\u0003J\u0015\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u0018\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00152\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001C\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0001¢\u0006\u0004\b\u001C\u0010\u001DJ\u0019\u0010\u001E\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0014¢\u0006\u0004\b\u001E\u0010\u001DR\u0016\u0010 \u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001A\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "<init>", "()V", "", "now", "remainingNanos", "(J)J", "Lie/H;", "enter", "", "exit", "()Z", "cancel", "timedOut", "Lokio/Sink;", "sink", "(Lokio/Sink;)Lokio/Sink;", "Lokio/Source;", "source", "(Lokio/Source;)Lokio/Source;", "T", "Lkotlin/Function0;", "block", "withTimeout", "(Lwe/a;)Ljava/lang/Object;", "Ljava/io/IOException;", "cause", "access$newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "newTimeoutException", "", "state", "I", "next", "Lokio/AsyncTimeout;", "timeoutAt", "J", "Companion", "Watchdog", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class AsyncTimeout extends Timeout {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001A\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001FR\u0014\u0010!\u001A\u00020\u001B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001DR\u0014\u0010\"\u001A\u00020\u001B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001DR\u0014\u0010#\u001A\u00020\u001B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001DR\u0014\u0010$\u001A\u00020\u001B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001DR\u0018\u0010%\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "<init>", "()V", "Lokio/AsyncTimeout;", "node", "", "timeoutNanos", "", "hasDeadline", "Lie/H;", "insertIntoQueue", "(Lokio/AsyncTimeout;JZ)V", "removeFromQueue", "(Lokio/AsyncTimeout;)V", "awaitTimeout", "()Lokio/AsyncTimeout;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "", "TIMEOUT_WRITE_SIZE", "I", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "STATE_CANCELED", "head", "Lokio/AsyncTimeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$insertIntoQueue(Companion asyncTimeout$Companion0, AsyncTimeout asyncTimeout0, long v, boolean z) {
            asyncTimeout$Companion0.insertIntoQueue(asyncTimeout0, v, z);
        }

        public static final void access$removeFromQueue(Companion asyncTimeout$Companion0, AsyncTimeout asyncTimeout0) {
            asyncTimeout$Companion0.removeFromQueue(asyncTimeout0);
        }

        @Nullable
        public final AsyncTimeout awaitTimeout() {
            AsyncTimeout asyncTimeout0 = AsyncTimeout.head;
            q.d(asyncTimeout0);
            AsyncTimeout asyncTimeout1 = asyncTimeout0.next;
            if(asyncTimeout1 == null) {
                this.getCondition().await(60000L, TimeUnit.MILLISECONDS);
                q.d(AsyncTimeout.head);
                return null;
            }
            long v = asyncTimeout1.remainingNanos(System.nanoTime());
            if(v > 0L) {
                this.getCondition().await(v, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
            q.d(asyncTimeout2);
            asyncTimeout2.next = asyncTimeout1.next;
            asyncTimeout1.next = null;
            asyncTimeout1.state = 2;
            return asyncTimeout1;
        }

        @NotNull
        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        @NotNull
        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        private final void insertIntoQueue(AsyncTimeout asyncTimeout0, long v, boolean z) {
            if(AsyncTimeout.head == null) {
                AsyncTimeout.head = new AsyncTimeout();
                new Watchdog().start();
            }
            long v1 = System.nanoTime();
            int v2 = Long.compare(v, 0L);
            if(v2 != 0 && z) {
                asyncTimeout0.timeoutAt = Math.min(v, asyncTimeout0.deadlineNanoTime() - v1) + v1;
            }
            else if(v2 != 0) {
                asyncTimeout0.timeoutAt = v + v1;
            }
            else if(z) {
                asyncTimeout0.timeoutAt = asyncTimeout0.deadlineNanoTime();
            }
            else {
                throw new AssertionError();
            }
            long v3 = asyncTimeout0.remainingNanos(v1);
            AsyncTimeout asyncTimeout1 = AsyncTimeout.head;
            q.d(asyncTimeout1);
            while(asyncTimeout1.next != null) {
                AsyncTimeout asyncTimeout2 = asyncTimeout1.next;
                q.d(asyncTimeout2);
                if(v3 < asyncTimeout2.remainingNanos(v1)) {
                    break;
                }
                asyncTimeout1 = asyncTimeout1.next;
                q.d(asyncTimeout1);
            }
            asyncTimeout0.next = asyncTimeout1.next;
            asyncTimeout1.next = asyncTimeout0;
            if(asyncTimeout1 == AsyncTimeout.head) {
                this.getCondition().signal();
            }
        }

        private final void removeFromQueue(AsyncTimeout asyncTimeout0) {
            for(AsyncTimeout asyncTimeout1 = AsyncTimeout.head; asyncTimeout1 != null; asyncTimeout1 = asyncTimeout1.next) {
                if(asyncTimeout1.next == asyncTimeout0) {
                    asyncTimeout1.next = asyncTimeout0.next;
                    asyncTimeout0.next = null;
                    return;
                }
            }
            throw new IllegalStateException("node was not found in the queue");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "<init>", "()V", "Lie/H;", "run", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            this.setDaemon(true);
        }

        @Override
        public void run() {
            AsyncTimeout asyncTimeout0;
            while(true) {
                try {
                    ReentrantLock reentrantLock0 = AsyncTimeout.Companion.getLock();
                    reentrantLock0.lock();
                    try {
                        asyncTimeout0 = AsyncTimeout.Companion.awaitTimeout();
                        if(asyncTimeout0 == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                    }
                    finally {
                        reentrantLock0.unlock();
                    }
                    if(asyncTimeout0 != null) {
                        asyncTimeout0.timedOut();
                    }
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
    }

    @NotNull
    private static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0L;
    private static final long IDLE_TIMEOUT_NANOS = 0L;
    private static final int STATE_CANCELED = 3;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_QUEUE = 1;
    private static final int STATE_TIMED_OUT = 2;
    private static final int TIMEOUT_WRITE_SIZE = 0x10000;
    @NotNull
    private static final Condition condition;
    @Nullable
    private static AsyncTimeout head;
    @NotNull
    private static final ReentrantLock lock;
    @Nullable
    private AsyncTimeout next;
    private int state;
    private long timeoutAt;

    static {
        AsyncTimeout.Companion = new Companion(null);
        ReentrantLock reentrantLock0 = new ReentrantLock();
        AsyncTimeout.lock = reentrantLock0;
        Condition condition0 = reentrantLock0.newCondition();
        q.f(condition0, "newCondition(...)");
        AsyncTimeout.condition = condition0;
        long v = TimeUnit.SECONDS.toMillis(60L);
        AsyncTimeout.IDLE_TIMEOUT_MILLIS = v;
        AsyncTimeout.IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(v);
    }

    public static final long access$getIDLE_TIMEOUT_MILLIS$cp() [...] // 潜在的解密器

    public static final long access$getIDLE_TIMEOUT_NANOS$cp() [...] // 潜在的解密器

    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException iOException0) {
        return this.newTimeoutException(iOException0);
    }

    @Override  // okio.Timeout
    public void cancel() {
        super.cancel();
        ReentrantLock reentrantLock0 = AsyncTimeout.lock;
        reentrantLock0.lock();
        try {
            if(this.state == 1) {
                Companion.access$removeFromQueue(AsyncTimeout.Companion, this);
                this.state = 3;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    public final void enter() {
        long v = this.timeoutNanos();
        boolean z = this.hasDeadline();
        if(v == 0L && !z) {
            return;
        }
        ReentrantLock reentrantLock0 = AsyncTimeout.lock;
        reentrantLock0.lock();
        try {
            if(this.state == 0) {
                this.state = 1;
                Companion.access$insertIntoQueue(AsyncTimeout.Companion, this, v, z);
                return;
            }
        }
        finally {
            reentrantLock0.unlock();
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        ReentrantLock reentrantLock0 = AsyncTimeout.lock;
        reentrantLock0.lock();
        try {
            int v1 = this.state;
            boolean z = false;
            this.state = 0;
            if(v1 == 1) {
                Companion.access$removeFromQueue(AsyncTimeout.Companion, this);
                return false;
            }
            if(v1 == 2) {
                z = true;
            }
            return z;
        }
        finally {
            reentrantLock0.unlock();
        }
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException0) {
        IOException iOException1 = new InterruptedIOException("timeout");
        if(iOException0 != null) {
            iOException1.initCause(iOException0);
        }
        return iOException1;
    }

    private final long remainingNanos(long v) {
        return this.timeoutAt - v;
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        return new Sink() {
            @Override  // okio.Sink
            public void close() {
                AsyncTimeout asyncTimeout0 = sink0;
                asyncTimeout0.enter();
                try {
                    try {
                        this.$sink.close();
                    }
                    catch(IOException iOException0) {
                        if(asyncTimeout0.exit()) {
                            iOException0 = asyncTimeout0.access$newTimeoutException(iOException0);
                        }
                        throw iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    asyncTimeout0.exit();
                    throw throwable0;
                }
                if(asyncTimeout0.exit()) {
                    throw asyncTimeout0.access$newTimeoutException(null);
                }
            }

            @Override  // okio.Sink
            public void flush() {
                AsyncTimeout asyncTimeout0 = sink0;
                asyncTimeout0.enter();
                try {
                    try {
                        this.$sink.flush();
                    }
                    catch(IOException iOException0) {
                        if(asyncTimeout0.exit()) {
                            iOException0 = asyncTimeout0.access$newTimeoutException(iOException0);
                        }
                        throw iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    asyncTimeout0.exit();
                    throw throwable0;
                }
                if(asyncTimeout0.exit()) {
                    throw asyncTimeout0.access$newTimeoutException(null);
                }
            }

            public AsyncTimeout timeout() {
                return sink0;
            }

            @Override  // okio.Sink
            public Timeout timeout() {
                return this.timeout();
            }

            @Override
            public String toString() {
                return "AsyncTimeout.sink(" + this.$sink + ')';
            }

            @Override  // okio.Sink
            public void write(Buffer buffer0, long v) {
                q.g(buffer0, "source");
                -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
                while(true) {
                    long v1 = 0L;
                    if(v <= 0L) {
                        break;
                    }
                    Segment segment0 = buffer0.head;
                    q.d(segment0);
                    while(v1 < 0x10000L) {
                        v1 += (long)(segment0.limit - segment0.pos);
                        if(v1 >= v) {
                            v1 = v;
                            break;
                        }
                        segment0 = segment0.next;
                        q.d(segment0);
                    }
                    AsyncTimeout asyncTimeout0 = sink0;
                    asyncTimeout0.enter();
                    try {
                        try {
                            this.$sink.write(buffer0, v1);
                        }
                        catch(IOException iOException0) {
                            throw asyncTimeout0.exit() ? asyncTimeout0.access$newTimeoutException(iOException0) : iOException0;
                        }
                    }
                    catch(Throwable throwable0) {
                        asyncTimeout0.exit();
                        throw throwable0;
                    }
                    if(asyncTimeout0.exit()) {
                        throw asyncTimeout0.access$newTimeoutException(null);
                    }
                    v -= v1;
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull Source source0) {
        q.g(source0, "source");
        return new Source() {
            @Override  // okio.Source
            public void close() {
                AsyncTimeout asyncTimeout0 = source0;
                asyncTimeout0.enter();
                try {
                    try {
                        this.$source.close();
                    }
                    catch(IOException iOException0) {
                        if(asyncTimeout0.exit()) {
                            iOException0 = asyncTimeout0.access$newTimeoutException(iOException0);
                        }
                        throw iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    asyncTimeout0.exit();
                    throw throwable0;
                }
                if(asyncTimeout0.exit()) {
                    throw asyncTimeout0.access$newTimeoutException(null);
                }
            }

            @Override  // okio.Source
            public long read(Buffer buffer0, long v) {
                long v1;
                q.g(buffer0, "sink");
                AsyncTimeout asyncTimeout0 = source0;
                asyncTimeout0.enter();
                try {
                    try {
                        v1 = this.$source.read(buffer0, v);
                    }
                    catch(IOException iOException0) {
                        if(asyncTimeout0.exit()) {
                            iOException0 = asyncTimeout0.access$newTimeoutException(iOException0);
                        }
                        throw iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    asyncTimeout0.exit();
                    throw throwable0;
                }
                if(asyncTimeout0.exit()) {
                    throw asyncTimeout0.access$newTimeoutException(null);
                }
                return v1;
            }

            public AsyncTimeout timeout() {
                return source0;
            }

            @Override  // okio.Source
            public Timeout timeout() {
                return this.timeout();
            }

            @Override
            public String toString() {
                return "AsyncTimeout.source(" + this.$source + ')';
            }
        };
    }

    public void timedOut() {
    }

    public final Object withTimeout(@NotNull a a0) {
        Object object0;
        q.g(a0, "block");
        this.enter();
        try {
            try {
                object0 = a0.invoke();
            }
            catch(IOException iOException0) {
                if(this.exit()) {
                    iOException0 = this.access$newTimeoutException(iOException0);
                }
                throw iOException0;
            }
        }
        catch(Throwable throwable0) {
            this.exit();
            throw throwable0;
        }
        if(this.exit()) {
            throw this.access$newTimeoutException(null);
        }
        return object0;
    }
}

