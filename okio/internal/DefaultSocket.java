package okio.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.-SegmentedByteString;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001C\u001DB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u0010\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0013\u001A\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0018\u001A\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001E"}, d2 = {"Lokio/internal/DefaultSocket;", "Lokio/Socket;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "Lie/H;", "cancel", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/net/Socket;", "getSocket", "()Ljava/net/Socket;", "Ljava/util/concurrent/atomic/AtomicInteger;", "closeBits", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lokio/Source;", "source", "Lokio/Source;", "getSource", "()Lokio/Source;", "Lokio/Sink;", "sink", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "SocketSink", "SocketSource", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DefaultSocket implements Socket {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0014¨\u0006\u0015"}, d2 = {"Lokio/internal/DefaultSocket$SocketSink;", "Lokio/Sink;", "<init>", "(Lokio/internal/DefaultSocket;)V", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lokio/internal/SocketAsyncTimeout;", "timeout", "()Lokio/internal/SocketAsyncTimeout;", "", "toString", "()Ljava/lang/String;", "Lokio/internal/SocketAsyncTimeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public final class SocketSink implements Sink {
        @NotNull
        private final SocketAsyncTimeout timeout;

        public SocketSink() {
            this.timeout = new SocketAsyncTimeout(defaultSocket0.getSocket());
        }

        @Override  // okio.Sink
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout0 = this.timeout;
            DefaultSocket defaultSocket0 = DefaultSocket.this;
            socketAsyncTimeout0.enter();
            try {
                switch(_AtomicKt.setBitsOrZero(defaultSocket0.closeBits, 1)) {
                    case 0: {
                        goto label_5;
                    }
                    case 3: {
                        goto label_13;
                    }
                }
            }
            catch(IOException iOException0) {
                goto label_16;
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
            goto label_7;
        label_5:
            socketAsyncTimeout0.exit();
            return;
            try {
            label_7:
                if(!defaultSocket0.getSocket().isClosed() && !defaultSocket0.getSocket().isOutputShutdown()) {
                    defaultSocket0.getSocket().getOutputStream().flush();
                    defaultSocket0.getSocket().shutdownOutput();
                    goto label_22;
                }
            }
            catch(IOException iOException0) {
                goto label_16;
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
            socketAsyncTimeout0.exit();
            return;
            try {
                try {
                label_13:
                    defaultSocket0.getSocket().close();
                }
                catch(IOException iOException0) {
                label_16:
                    if(socketAsyncTimeout0.exit()) {
                        iOException0 = socketAsyncTimeout0.access$newTimeoutException(iOException0);
                    }
                    throw iOException0;
                }
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
        label_22:
            if(socketAsyncTimeout0.exit()) {
                throw socketAsyncTimeout0.access$newTimeoutException(null);
            }
        }

        @Override  // okio.Sink
        public void flush() {
            SocketAsyncTimeout socketAsyncTimeout0 = this.timeout;
            socketAsyncTimeout0.enter();
            try {
                try {
                    DefaultSocket.this.getSocket().getOutputStream().flush();
                }
                catch(IOException iOException0) {
                    if(socketAsyncTimeout0.exit()) {
                        iOException0 = socketAsyncTimeout0.access$newTimeoutException(iOException0);
                    }
                    throw iOException0;
                }
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
            if(socketAsyncTimeout0.exit()) {
                throw socketAsyncTimeout0.access$newTimeoutException(null);
            }
        }

        @Override  // okio.Sink
        public Timeout timeout() {
            return this.timeout();
        }

        @NotNull
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        @Override
        @NotNull
        public String toString() {
            return "sink(" + DefaultSocket.this.getSocket() + ')';
        }

        @Override  // okio.Sink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
            while(v > 0L) {
                this.timeout.throwIfReached();
                Segment segment0 = buffer0.head;
                q.d(segment0);
                int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
                SocketAsyncTimeout socketAsyncTimeout0 = this.timeout;
                socketAsyncTimeout0.enter();
                try {
                    try {
                        DefaultSocket.this.getSocket().getOutputStream().write(segment0.data, segment0.pos, v1);
                    }
                    catch(IOException iOException0) {
                        throw socketAsyncTimeout0.exit() ? socketAsyncTimeout0.access$newTimeoutException(iOException0) : iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    socketAsyncTimeout0.exit();
                    throw throwable0;
                }
                if(socketAsyncTimeout0.exit()) {
                    throw socketAsyncTimeout0.access$newTimeoutException(null);
                }
                segment0.pos += v1;
                v -= (long)v1;
                buffer0.setSize$okio(buffer0.size() - ((long)v1));
                if(segment0.pos == segment0.limit) {
                    buffer0.head = segment0.pop();
                    SegmentPool.recycle(segment0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u0013¨\u0006\u0014"}, d2 = {"Lokio/internal/DefaultSocket$SocketSource;", "Lokio/Source;", "<init>", "(Lokio/internal/DefaultSocket;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "close", "()V", "Lokio/internal/SocketAsyncTimeout;", "timeout", "()Lokio/internal/SocketAsyncTimeout;", "", "toString", "()Ljava/lang/String;", "Lokio/internal/SocketAsyncTimeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public final class SocketSource implements Source {
        @NotNull
        private final SocketAsyncTimeout timeout;

        public SocketSource() {
            this.timeout = new SocketAsyncTimeout(defaultSocket0.getSocket());
        }

        @Override  // okio.Source
        public void close() {
            SocketAsyncTimeout socketAsyncTimeout0 = this.timeout;
            DefaultSocket defaultSocket0 = DefaultSocket.this;
            socketAsyncTimeout0.enter();
            try {
                switch(_AtomicKt.setBitsOrZero(defaultSocket0.closeBits, 2)) {
                    case 0: {
                        goto label_5;
                    }
                    case 3: {
                        goto label_12;
                    }
                }
            }
            catch(IOException iOException0) {
                goto label_15;
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
            goto label_7;
        label_5:
            socketAsyncTimeout0.exit();
            return;
            try {
            label_7:
                if(!defaultSocket0.getSocket().isClosed() && !defaultSocket0.getSocket().isInputShutdown()) {
                    defaultSocket0.getSocket().shutdownInput();
                    goto label_21;
                }
            }
            catch(IOException iOException0) {
                goto label_15;
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
            socketAsyncTimeout0.exit();
            return;
            try {
                try {
                label_12:
                    defaultSocket0.getSocket().close();
                }
                catch(IOException iOException0) {
                label_15:
                    if(socketAsyncTimeout0.exit()) {
                        iOException0 = socketAsyncTimeout0.access$newTimeoutException(iOException0);
                    }
                    throw iOException0;
                }
            }
            catch(Throwable throwable0) {
                socketAsyncTimeout0.exit();
                throw throwable0;
            }
        label_21:
            if(socketAsyncTimeout0.exit()) {
                throw socketAsyncTimeout0.access$newTimeoutException(null);
            }
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            int v3;
            q.g(buffer0, "sink");
            int v1 = Long.compare(v, 0L);
            if(v1 == 0) {
                return 0L;
            }
            if(v1 < 0) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            this.timeout.throwIfReached();
            Segment segment0 = buffer0.writableSegment$okio(1);
            int v2 = (int)Math.min(v, 0x2000 - segment0.limit);
            try {
                SocketAsyncTimeout socketAsyncTimeout0 = this.timeout;
                socketAsyncTimeout0.enter();
                try {
                    try {
                        v3 = DefaultSocket.this.getSocket().getInputStream().read(segment0.data, segment0.limit, v2);
                    }
                    catch(IOException iOException0) {
                        if(socketAsyncTimeout0.exit()) {
                            iOException0 = socketAsyncTimeout0.access$newTimeoutException(iOException0);
                        }
                        throw iOException0;
                    }
                }
                catch(Throwable throwable0) {
                    socketAsyncTimeout0.exit();
                    throw throwable0;
                }
                if(socketAsyncTimeout0.exit()) {
                    throw socketAsyncTimeout0.access$newTimeoutException(null);
                }
            }
            catch(AssertionError assertionError0) {
                if(_JavaIoKt.isAndroidGetsocknameError(assertionError0)) {
                    throw new IOException(assertionError0);
                }
                throw assertionError0;
            }
            if(v3 == -1) {
                if(segment0.pos == segment0.limit) {
                    buffer0.head = segment0.pop();
                    SegmentPool.recycle(segment0);
                }
                return -1L;
            }
            segment0.limit += v3;
            buffer0.setSize$okio(buffer0.size() + ((long)v3));
            return (long)v3;
        }

        @Override  // okio.Source
        public Timeout timeout() {
            return this.timeout();
        }

        @NotNull
        public SocketAsyncTimeout timeout() {
            return this.timeout;
        }

        @Override
        @NotNull
        public String toString() {
            return "source(" + DefaultSocket.this.getSocket() + ')';
        }
    }

    @NotNull
    private AtomicInteger closeBits;
    @NotNull
    private final Sink sink;
    @NotNull
    private final java.net.Socket socket;
    @NotNull
    private final Source source;

    public DefaultSocket(@NotNull java.net.Socket socket0) {
        q.g(socket0, "socket");
        super();
        this.socket = socket0;
        this.closeBits = new AtomicInteger();
        this.source = new SocketSource(this);
        this.sink = new SocketSink(this);
    }

    @Override  // okio.Socket
    public void cancel() {
        this.socket.close();
    }

    @Override  // okio.Socket
    @NotNull
    public Sink getSink() {
        return this.sink;
    }

    @NotNull
    public final java.net.Socket getSocket() {
        return this.socket;
    }

    @Override  // okio.Socket
    @NotNull
    public Source getSource() {
        return this.source;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.socket.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

