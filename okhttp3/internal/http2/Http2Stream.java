package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 u2\u00020\u0001:\u0004uvwxB3\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\t\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\t\u00A2\u0006\u0004\b\u000F\u0010\u000EJ+\u0010\u0015\u001A\u00020\u00142\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u000F\u001A\u00020\t\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\r\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\r\u0010!\u001A\u00020 \u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010\'\u001A\u00020\u00142\u0006\u0010$\u001A\u00020#2\b\u0010&\u001A\u0004\u0018\u00010%\u00A2\u0006\u0004\b\'\u0010(J\u0015\u0010*\u001A\u00020\u00142\u0006\u0010)\u001A\u00020#\u00A2\u0006\u0004\b*\u0010+J\u001D\u0010/\u001A\u00020\u00142\u0006\u0010-\u001A\u00020,2\u0006\u0010.\u001A\u00020\u0002\u00A2\u0006\u0004\b/\u00100J\u001D\u00101\u001A\u00020\u00142\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0006\u00A2\u0006\u0004\b1\u00102J\u0015\u00103\u001A\u00020\u00142\u0006\u0010)\u001A\u00020#\u00A2\u0006\u0004\b3\u0010+J\u000F\u00106\u001A\u00020\u0014H\u0000\u00A2\u0006\u0004\b4\u00105J\u0015\u00109\u001A\u00020\u00142\u0006\u00108\u001A\u000207\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010<\u001A\u00020\u0014H\u0000\u00A2\u0006\u0004\b;\u00105J\u000F\u0010>\u001A\u00020\u0014H\u0000\u00A2\u0006\u0004\b=\u00105J!\u0010?\u001A\u00020\u00062\u0006\u0010)\u001A\u00020#2\b\u0010&\u001A\u0004\u0018\u00010%H\u0002\u00A2\u0006\u0004\b?\u0010@R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010A\u001A\u0004\bB\u0010CR\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010D\u001A\u0004\bE\u0010FR*\u0010H\u001A\u0002072\u0006\u0010G\u001A\u0002078\u0006@@X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010K\"\u0004\bL\u0010:R*\u0010M\u001A\u0002072\u0006\u0010G\u001A\u0002078\u0006@@X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bM\u0010I\u001A\u0004\bN\u0010K\"\u0004\bO\u0010:R*\u0010P\u001A\u0002072\u0006\u0010G\u001A\u0002078\u0006@@X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bP\u0010I\u001A\u0004\bQ\u0010K\"\u0004\bR\u0010:R*\u0010S\u001A\u0002072\u0006\u0010G\u001A\u0002078\u0006@@X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bS\u0010I\u001A\u0004\bT\u0010K\"\u0004\bU\u0010:R\u001A\u0010W\u001A\b\u0012\u0004\u0012\u00020\t0V8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u001E\u0010-\u001A\u00060[R\u00020\u00008\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b-\u0010\\\u001A\u0004\b]\u0010^R\u001E\u0010`\u001A\u00060_R\u00020\u00008\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b`\u0010a\u001A\u0004\bb\u0010cR\u001E\u0010\u001A\u001A\u00060dR\u00020\u00008\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u001A\u0010e\u001A\u0004\bf\u0010gR\u001E\u0010\u001C\u001A\u00060dR\u00020\u00008\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u001C\u0010e\u001A\u0004\bh\u0010gR$\u0010)\u001A\u0004\u0018\u00010#8@@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010+R$\u0010&\u001A\u0004\u0018\u00010%8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010m\u001A\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0011\u0010r\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\br\u0010sR\u0011\u0010t\u001A\u00020\u00068F\u00A2\u0006\u0006\u001A\u0004\bt\u0010s\u00A8\u0006y"}, d2 = {"Lokhttp3/internal/http2/Http2Stream;", "", "", "id", "Lokhttp3/internal/http2/Http2Connection;", "connection", "", "outFinished", "inFinished", "Lokhttp3/Headers;", "headers", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "takeHeaders", "()Lokhttp3/Headers;", "trailers", "", "Lokhttp3/internal/http2/Header;", "responseHeaders", "flushHeaders", "Lie/H;", "writeHeaders", "(Ljava/util/List;ZZ)V", "enqueueTrailers", "(Lokhttp3/Headers;)V", "Lokio/Timeout;", "readTimeout", "()Lokio/Timeout;", "writeTimeout", "Lokio/Source;", "getSource", "()Lokio/Source;", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "Lokhttp3/internal/http2/ErrorCode;", "rstStatusCode", "Ljava/io/IOException;", "errorException", "close", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "errorCode", "closeLater", "(Lokhttp3/internal/http2/ErrorCode;)V", "Lokio/BufferedSource;", "source", "length", "receiveData", "(Lokio/BufferedSource;I)V", "receiveHeaders", "(Lokhttp3/Headers;Z)V", "receiveRstStream", "cancelStreamIfNecessary$okhttp", "()V", "cancelStreamIfNecessary", "", "delta", "addBytesToWriteWindow", "(J)V", "checkOutNotClosed$okhttp", "checkOutNotClosed", "waitForIo$okhttp", "waitForIo", "closeInternal", "(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)Z", "I", "getId", "()I", "Lokhttp3/internal/http2/Http2Connection;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "<set-?>", "readBytesTotal", "J", "getReadBytesTotal", "()J", "setReadBytesTotal$okhttp", "readBytesAcknowledged", "getReadBytesAcknowledged", "setReadBytesAcknowledged$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "Ljava/util/ArrayDeque;", "headersQueue", "Ljava/util/ArrayDeque;", "hasResponseHeaders", "Z", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getWriteTimeout$okhttp", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "isOpen", "()Z", "isLocallyInitiated", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http2Stream {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\tR\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR$\u0010\u001D\u001A\u0004\u0018\u00010\u001C8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b#\u0010\u0016\u001A\u0004\b$\u0010\u0018\"\u0004\b%\u0010\t¨\u0006&"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "outFinishedOnLastFrame", "Lie/H;", "emitFrame", "(Z)V", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Z", "getFinished", "()Z", "setFinished", "sendBuffer", "Lokio/Buffer;", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed", "setClosed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        @NotNull
        private final Buffer sendBuffer;
        @Nullable
        private Headers trailers;

        public FramingSink(boolean z) {
            this.finished = z;
            this.sendBuffer = new Buffer();
        }

        public FramingSink(boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                z = false;
            }
            this(z);
        }

        @Override  // okio.Sink
        public void close() {
            boolean z;
            Http2Stream http2Stream0 = Http2Stream.this;
            if(Util.assertionsEnabled && Thread.holdsLock(http2Stream0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2531 MUST NOT hold lock on " + http2Stream0);
            }
            Http2Stream http2Stream1 = Http2Stream.this;
            synchronized(http2Stream1) {
                if(this.closed) {
                    return;
                }
                z = http2Stream1.getErrorCode$okhttp() == null;
            }
            if(!Http2Stream.this.getSink$okhttp().finished) {
                boolean z1 = this.sendBuffer.size() > 0L;
                if(this.trailers != null) {
                    while(this.sendBuffer.size() > 0L) {
                        this.emitFrame(false);
                    }
                    Headers headers0 = this.trailers;
                    q.d(headers0);
                    List list0 = Util.toHeaderList(headers0);
                    Http2Stream.this.getConnection().writeHeaders$okhttp(Http2Stream.this.getId(), z, list0);
                }
                else if(z1) {
                    while(this.sendBuffer.size() > 0L) {
                        this.emitFrame(true);
                    }
                }
                else if(z) {
                    Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                }
            }
            synchronized(Http2Stream.this) {
                this.closed = true;
            }
            Http2Stream.this.getConnection().flush();
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        private final void emitFrame(boolean z) {
            long v2;
            Http2Stream http2Stream0 = Http2Stream.this;
            synchronized(http2Stream0) {
                http2Stream0.getWriteTimeout$okhttp().enter();
                try {
                    while(http2Stream0.getWriteBytesTotal() >= http2Stream0.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream0.getErrorCode$okhttp() == null) {
                        http2Stream0.waitForIo$okhttp();
                    }
                }
                finally {
                    http2Stream0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                }
                http2Stream0.checkOutNotClosed$okhttp();
                v2 = Math.min(http2Stream0.getWriteBytesMaximum() - http2Stream0.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream0.setWriteBytesTotal$okhttp(http2Stream0.getWriteBytesTotal() + v2);
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z && v2 == this.sendBuffer.size(), this.sendBuffer, v2);
            }
            finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override  // okio.Sink
        public void flush() {
            Http2Stream http2Stream0 = Http2Stream.this;
            if(Util.assertionsEnabled && Thread.holdsLock(http2Stream0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2537 MUST NOT hold lock on " + http2Stream0);
            }
            synchronized(Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed$okhttp();
            }
            while(this.sendBuffer.size() > 0L) {
                this.emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@Nullable Headers headers0) {
            this.trailers = headers0;
        }

        @Override  // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override  // okio.Sink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            Http2Stream http2Stream0 = Http2Stream.this;
            if(Util.assertionsEnabled && Thread.holdsLock(http2Stream0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2534 MUST NOT hold lock on " + http2Stream0);
            }
            this.sendBuffer.write(buffer0, v);
            while(this.sendBuffer.size() >= 0x4000L) {
                this.emitFrame(false);
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\b\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u000FJ\u001F\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001AR\"\u0010\u0005\u001A\u00020\u00048\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0017\u0010 \u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u0017\u0010$\u001A\u00020\f8\u0006¢\u0006\f\n\u0004\b$\u0010!\u001A\u0004\b%\u0010#R$\u0010\'\u001A\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001A\u00020\u00048\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b-\u0010\u001B\u001A\u0004\b.\u0010\u001D\"\u0004\b/\u0010\u001F¨\u00060"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "", "maxByteCount", "", "finished", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "read", "Lie/H;", "updateConnectionFlowControl", "(J)V", "Lokio/Buffer;", "sink", "byteCount", "(Lokio/Buffer;J)J", "Lokio/BufferedSource;", "source", "receive$okhttp", "(Lokio/BufferedSource;J)V", "receive", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "()V", "J", "Z", "getFinished$okhttp", "()Z", "setFinished$okhttp", "(Z)V", "receiveBuffer", "Lokio/Buffer;", "getReceiveBuffer", "()Lokio/Buffer;", "readBuffer", "getReadBuffer", "Lokhttp3/Headers;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "closed", "getClosed$okhttp", "setClosed$okhttp", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        @NotNull
        private final Buffer readBuffer;
        @NotNull
        private final Buffer receiveBuffer;
        @Nullable
        private Headers trailers;

        public FramingSource(long v, boolean z) {
            this.maxByteCount = v;
            this.finished = z;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        @Override  // okio.Source
        public void close() {
            long v1;
            synchronized(Http2Stream.this) {
                this.closed = true;
                v1 = this.readBuffer.size();
                this.readBuffer.clear();
                q.e(Http2Stream.this, "null cannot be cast to non-null type java.lang.Object");
                Http2Stream.this.notifyAll();
            }
            if(v1 > 0L) {
                this.updateConnectionFlowControl(v1);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @NotNull
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @NotNull
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @Nullable
        public final Headers getTrailers() {
            return this.trailers;
        }

        // This method was un-flattened
        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            long v2;
            IOException iOException1;
            int v1;
            Http2Stream http2Stream0;
            q.g(buffer0, "sink");
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            while(true) {
                http2Stream0 = Http2Stream.this;
                __monitor_enter(http2Stream0);
                v1 = FIN.finallyOpen$NT();
                http2Stream0.getReadTimeout$okhttp().enter();
                try {
                    if(http2Stream0.getErrorCode$okhttp() == null || this.finished) {
                        iOException1 = null;
                    }
                    else {
                        IOException iOException0 = http2Stream0.getErrorException$okhttp();
                        if(iOException0 == null) {
                            ErrorCode errorCode0 = http2Stream0.getErrorCode$okhttp();
                            q.d(errorCode0);
                            iOException1 = new StreamResetException(errorCode0);
                        }
                        else {
                            iOException1 = iOException0;
                        }
                    }
                    if(this.closed) {
                        throw new IOException("stream closed");
                    }
                    if(Long.compare(this.readBuffer.size(), 0L) > 0) {
                        goto label_26;
                    }
                    if(this.finished || iOException1 != null) {
                        v2 = -1L;
                        break;
                    }
                    http2Stream0.waitForIo$okhttp();
                }
                catch(Throwable throwable0) {
                    goto label_34;
                }
                http2Stream0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                FIN.finallyExec$NT(v1);
                continue;
                try {
                label_26:
                    v2 = this.readBuffer.read(buffer0, Math.min(v, this.readBuffer.size()));
                    http2Stream0.setReadBytesTotal$okhttp(http2Stream0.getReadBytesTotal() + v2);
                    long v3 = http2Stream0.getReadBytesTotal() - http2Stream0.getReadBytesAcknowledged();
                    if(iOException1 == null && v3 >= ((long)(http2Stream0.getConnection().getOkHttpSettings().getInitialWindowSize() / 2))) {
                        http2Stream0.getConnection().writeWindowUpdateLater$okhttp(http2Stream0.getId(), v3);
                        http2Stream0.setReadBytesAcknowledged$okhttp(http2Stream0.getReadBytesTotal());
                    }
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_34:
                http2Stream0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                FIN.finallyExec$NT(v1);
                throw throwable0;
            }
            http2Stream0.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
            FIN.finallyCodeBegin$NT(v1);
            __monitor_exit(http2Stream0);
            FIN.finallyCodeEnd$NT(v1);
            if(v2 != -1L) {
                return v2;
            }
            if(iOException1 != null) {
                throw iOException1;
            }
            return -1L;
        }

        public final void receive$okhttp(@NotNull BufferedSource bufferedSource0, long v) {
            boolean z;
            q.g(bufferedSource0, "source");
            Http2Stream http2Stream0 = Http2Stream.this;
            if(Util.assertionsEnabled && Thread.holdsLock(http2Stream0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2520 MUST NOT hold lock on " + http2Stream0);
            }
            long v1 = v;
            while(v1 > 0L) {
                synchronized(Http2Stream.this) {
                    z = false;
                    boolean z1 = this.finished;
                }
                if(Long.compare(this.readBuffer.size() + v1, this.maxByteCount) > 0) {
                    bufferedSource0.skip(v1);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if(z1) {
                    bufferedSource0.skip(v1);
                    return;
                }
                long v3 = bufferedSource0.read(this.receiveBuffer, v1);
                if(v3 == -1L) {
                    throw new EOFException();
                }
                v1 -= v3;
                Http2Stream http2Stream1 = Http2Stream.this;
                synchronized(http2Stream1) {
                    if(this.closed) {
                        this.receiveBuffer.clear();
                    }
                    else {
                        if(this.readBuffer.size() == 0L) {
                            z = true;
                        }
                        this.readBuffer.writeAll(this.receiveBuffer);
                        if(z) {
                            q.e(http2Stream1, "null cannot be cast to non-null type java.lang.Object");
                            http2Stream1.notifyAll();
                        }
                    }
                }
            }
            this.updateConnectionFlowControl(v);
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@Nullable Headers headers0) {
            this.trailers = headers0;
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }

        private final void updateConnectionFlowControl(long v) {
            Http2Stream http2Stream0 = Http2Stream.this;
            if(Util.assertionsEnabled && Thread.holdsLock(http2Stream0)) {
                throw new AssertionError("Thread jeb-dexdec-sb-st-2527 MUST NOT hold lock on " + http2Stream0);
            }
            Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(v);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lie/H;", "timedOut", "()V", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "exitAndThrowIfTimedOut", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class StreamTimeout extends AsyncTimeout {
        public final void exitAndThrowIfTimedOut() {
            if(this.exit()) {
                throw this.newTimeoutException(null);
            }
        }

        @Override  // okio.AsyncTimeout
        @NotNull
        public IOException newTimeoutException(@Nullable IOException iOException0) {
            IOException iOException1 = new SocketTimeoutException("timeout");
            if(iOException0 != null) {
                iOException1.initCause(iOException0);
            }
            return iOException1;
        }

        @Override  // okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long EMIT_BUFFER_SIZE = 0x4000L;
    @NotNull
    private final Http2Connection connection;
    @Nullable
    private ErrorCode errorCode;
    @Nullable
    private IOException errorException;
    private boolean hasResponseHeaders;
    @NotNull
    private final ArrayDeque headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @NotNull
    private final StreamTimeout readTimeout;
    @NotNull
    private final FramingSink sink;
    @NotNull
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @NotNull
    private final StreamTimeout writeTimeout;

    static {
        Http2Stream.Companion = new Companion(null);
    }

    public Http2Stream(int v, @NotNull Http2Connection http2Connection0, boolean z, boolean z1, @Nullable Headers headers0) {
        q.g(http2Connection0, "connection");
        super();
        this.id = v;
        this.connection = http2Connection0;
        this.writeBytesMaximum = (long)http2Connection0.getPeerSettings().getInitialWindowSize();
        ArrayDeque arrayDeque0 = new ArrayDeque();
        this.headersQueue = arrayDeque0;
        this.source = new FramingSource(this, ((long)http2Connection0.getOkHttpSettings().getInitialWindowSize()), z1);
        this.sink = new FramingSink(this, z);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if(headers0 != null) {
            if(this.isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn\'t have headers yet");
            }
            arrayDeque0.add(headers0);
            return;
        }
        if(!this.isLocallyInitiated()) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public final void addBytesToWriteWindow(long v) {
        this.writeBytesMaximum += v;
        if(v > 0L) {
            this.notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() {
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2537 MUST NOT hold lock on " + this);
        }
        synchronized(this) {
            boolean z = this.isOpen();
        }
        if(!this.source.getFinished$okhttp() && this.source.getClosed$okhttp() && (this.sink.getFinished() || this.sink.getClosed())) {
            this.close(ErrorCode.CANCEL, null);
            return;
        }
        if(!z) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() {
        if(this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if(this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if(this.errorCode != null) {
            IOException iOException0 = this.errorException;
            if(iOException0 == null) {
                ErrorCode errorCode0 = this.errorCode;
                q.d(errorCode0);
                iOException0 = new StreamResetException(errorCode0);
            }
            throw iOException0;
        }
    }

    public final void close(@NotNull ErrorCode errorCode0, @Nullable IOException iOException0) {
        q.g(errorCode0, "rstStatusCode");
        if(!this.closeInternal(errorCode0, iOException0)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, errorCode0);
    }

    private final boolean closeInternal(ErrorCode errorCode0, IOException iOException0) {
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2536 MUST NOT hold lock on " + this);
        }
        synchronized(this) {
            if(this.errorCode != null) {
                return false;
            }
            this.errorCode = errorCode0;
            this.errorException = iOException0;
            this.notifyAll();
            if(this.source.getFinished$okhttp() && this.sink.getFinished()) {
                return false;
            }
        }
        this.connection.removeStream$okhttp(this.id);
        return true;
    }

    public final void closeLater(@NotNull ErrorCode errorCode0) {
        q.g(errorCode0, "errorCode");
        if(!this.closeInternal(errorCode0, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode0);
    }

    public final void enqueueTrailers(@NotNull Headers headers0) {
        q.g(headers0, "trailers");
        synchronized(this) {
            if(!this.sink.getFinished()) {
                if(headers0.size() == 0) {
                    throw new IllegalArgumentException("trailers.size() == 0");
                }
                this.sink.setTrailers(headers0);
                return;
            }
        }
        throw new IllegalStateException("already finished");
    }

    @NotNull
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @Nullable
    public final ErrorCode getErrorCode$okhttp() {
        synchronized(this) {
        }
        return this.errorCode;
    }

    @Nullable
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    @NotNull
    public final Sink getSink() {
        synchronized(this) {
            if(!this.hasResponseHeaders && !this.isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.sink;
        }
    }

    @NotNull
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @NotNull
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        return this.connection.getClient$okhttp() == ((this.id & 1) == 1);
    }

    public final boolean isOpen() {
        synchronized(this) {
            if(this.errorCode != null) {
                return false;
            }
            return (this.source.getFinished$okhttp() || this.source.getClosed$okhttp()) && (this.sink.getFinished() || this.sink.getClosed()) && this.hasResponseHeaders ? false : true;
        }
    }

    @NotNull
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@NotNull BufferedSource bufferedSource0, int v) {
        q.g(bufferedSource0, "source");
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2527 MUST NOT hold lock on " + this);
        }
        this.source.receive$okhttp(bufferedSource0, ((long)v));
    }

    public final void receiveHeaders(@NotNull Headers headers0, boolean z) {
        q.g(headers0, "headers");
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2534 MUST NOT hold lock on " + this);
        }
        synchronized(this) {
            if(!this.hasResponseHeaders || !z) {
                this.hasResponseHeaders = true;
                this.headersQueue.add(headers0);
            }
            else {
                this.source.setTrailers(headers0);
            }
            if(z) {
                this.source.setFinished$okhttp(true);
            }
            boolean z1 = this.isOpen();
            this.notifyAll();
        }
        if(!z1) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void receiveRstStream(@NotNull ErrorCode errorCode0) {
        synchronized(this) {
            q.g(errorCode0, "errorCode");
            if(this.errorCode == null) {
                this.errorCode = errorCode0;
                this.notifyAll();
            }
        }
    }

    public final void setErrorCode$okhttp(@Nullable ErrorCode errorCode0) {
        this.errorCode = errorCode0;
    }

    public final void setErrorException$okhttp(@Nullable IOException iOException0) {
        this.errorException = iOException0;
    }

    public final void setReadBytesAcknowledged$okhttp(long v) {
        this.readBytesAcknowledged = v;
    }

    public final void setReadBytesTotal$okhttp(long v) {
        this.readBytesTotal = v;
    }

    public final void setWriteBytesMaximum$okhttp(long v) {
        this.writeBytesMaximum = v;
    }

    public final void setWriteBytesTotal$okhttp(long v) {
        this.writeBytesTotal = v;
    }

    @NotNull
    public final Headers takeHeaders() {
        IOException iOException0;
        synchronized(this) {
            this.readTimeout.enter();
            try {
                while(this.headersQueue.isEmpty() && this.errorCode == null) {
                    this.waitForIo$okhttp();
                }
            }
            finally {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
            if(!this.headersQueue.isEmpty()) {
                Object object0 = this.headersQueue.removeFirst();
                q.f(object0, "headersQueue.removeFirst()");
                return (Headers)object0;
            }
            iOException0 = this.errorException;
            if(iOException0 == null) {
                ErrorCode errorCode0 = this.errorCode;
                q.d(errorCode0);
                iOException0 = new StreamResetException(errorCode0);
            }
        }
        throw iOException0;
    }

    @NotNull
    public final Headers trailers() {
        synchronized(this) {
            if(this.source.getFinished$okhttp() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
                Headers headers0 = this.source.getTrailers();
                if(headers0 == null) {
                    headers0 = Util.EMPTY_HEADERS;
                }
                return headers0;
            }
            if(this.errorCode != null) {
                IOException iOException0 = this.errorException;
                if(iOException0 == null) {
                    ErrorCode errorCode0 = this.errorCode;
                    q.d(errorCode0);
                    iOException0 = new StreamResetException(errorCode0);
                }
                throw iOException0;
            }
        }
        throw new IllegalStateException("too early; can\'t read the trailers yet");
    }

    public final void waitForIo$okhttp() {
        try {
            this.wait();
        }
        catch(InterruptedException unused_ex) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@NotNull List list0, boolean z, boolean z1) {
        boolean z2;
        q.g(list0, "responseHeaders");
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2525 MUST NOT hold lock on " + this);
        }
        synchronized(this) {
            z2 = true;
            this.hasResponseHeaders = true;
            if(z) {
                this.sink.setFinished(true);
            }
        }
        if(!z1) {
            synchronized(this.connection) {
                if(this.connection.getWriteBytesTotal() < this.connection.getWriteBytesMaximum()) {
                    z2 = false;
                }
            }
            z1 = z2;
        }
        this.connection.writeHeaders$okhttp(this.id, z, list0);
        if(z1) {
            this.connection.flush();
        }
    }

    @NotNull
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }
}

