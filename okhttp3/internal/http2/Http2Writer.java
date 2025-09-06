package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0012\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0019\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\f\u00A2\u0006\u0004\b\u001B\u0010\u0010J\u001D\u0010\u001E\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u001C\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\r\u0010 \u001A\u00020\b\u00A2\u0006\u0004\b \u0010!J/\u0010%\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b2\b\u0010$\u001A\u0004\u0018\u00010#2\u0006\u0010\u000B\u001A\u00020\b\u00A2\u0006\u0004\b%\u0010&J/\u0010)\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\b2\b\u0010(\u001A\u0004\u0018\u00010#2\u0006\u0010\u000B\u001A\u00020\b\u00A2\u0006\u0004\b)\u0010*J\u0015\u0010+\u001A\u00020\f2\u0006\u0010+\u001A\u00020\u0011\u00A2\u0006\u0004\b+\u0010\u0014J%\u0010/\u001A\u00020\f2\u0006\u0010,\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\b2\u0006\u0010.\u001A\u00020\b\u00A2\u0006\u0004\b/\u00100J%\u00104\u001A\u00020\f2\u0006\u00101\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u00103\u001A\u000202\u00A2\u0006\u0004\b4\u00105J\u001D\u00107\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u00106\u001A\u00020\n\u00A2\u0006\u0004\b7\u0010\u000EJ-\u0010:\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u00108\u001A\u00020\b2\u0006\u00109\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\b\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b<\u0010\u0010J+\u0010>\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b2\f\u0010=\u001A\b\u0012\u0004\u0012\u00020\u00170\u0016\u00A2\u0006\u0004\b>\u0010?R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010@R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010AR\u0014\u0010B\u001A\u00020#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010AR\u0017\u0010H\u001A\u00020G8\u0006\u00A2\u0006\f\n\u0004\bH\u0010I\u001A\u0004\bJ\u0010K\u00A8\u0006M"}, d2 = {"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "Lokio/BufferedSink;", "sink", "", "client", "<init>", "(Lokio/BufferedSink;Z)V", "", "streamId", "", "byteCount", "Lie/H;", "writeContinuationFrames", "(IJ)V", "connectionPreface", "()V", "Lokhttp3/internal/http2/Settings;", "peerSettings", "applyAndAckSettings", "(Lokhttp3/internal/http2/Settings;)V", "promisedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "flush", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "maxDataLength", "()I", "outFinished", "Lokio/Buffer;", "source", "data", "(ZILokio/Buffer;I)V", "flags", "buffer", "dataFrame", "(IILokio/Buffer;I)V", "settings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;[B)V", "windowSizeIncrement", "windowUpdate", "length", "type", "frameHeader", "(IIII)V", "close", "headerBlock", "headers", "(ZILjava/util/List;)V", "Lokio/BufferedSink;", "Z", "hpackBuffer", "Lokio/Buffer;", "maxFrameSize", "I", "closed", "Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http2Writer implements Closeable {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    private final boolean client;
    private boolean closed;
    @NotNull
    private final Buffer hpackBuffer;
    @NotNull
    private final Writer hpackWriter;
    private static final Logger logger;
    private int maxFrameSize;
    @NotNull
    private final BufferedSink sink;

    static {
        Http2Writer.Companion = new Companion(null);
        Http2Writer.logger = Logger.getLogger("okhttp3.internal.http2.Http2");
    }

    public Http2Writer(@NotNull BufferedSink bufferedSink0, boolean z) {
        q.g(bufferedSink0, "sink");
        super();
        this.sink = bufferedSink0;
        this.client = z;
        Buffer buffer0 = new Buffer();
        this.hpackBuffer = buffer0;
        this.maxFrameSize = 0x4000;
        this.hpackWriter = new Writer(0, false, buffer0, 3, null);
    }

    public final void applyAndAckSettings(@NotNull Settings settings0) {
        synchronized(this) {
            q.g(settings0, "peerSettings");
            if(!this.closed) {
                this.maxFrameSize = settings0.getMaxFrameSize(this.maxFrameSize);
                if(settings0.getHeaderTableSize() != -1) {
                    int v1 = settings0.getHeaderTableSize();
                    this.hpackWriter.resizeHeaderTable(v1);
                }
                this.frameHeader(0, 0, 4, 1);
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    @Override
    public void close() {
        synchronized(this) {
            this.closed = true;
            this.sink.close();
        }
    }

    public final void connectionPreface() {
        synchronized(this) {
            if(!this.closed) {
                if(!this.client) {
                    return;
                }
                Logger logger0 = Http2Writer.logger;
                if(logger0.isLoggable(Level.FINE)) {
                    logger0.fine(">> CONNECTION 505249202a20485454502f322e300d0a0d0a534d0d0a0d0a");
                }
                this.sink.write(Http2.CONNECTION_PREFACE);
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void data(boolean z, int v, @Nullable Buffer buffer0, int v1) {
        synchronized(this) {
            if(!this.closed) {
                this.dataFrame(v, ((int)z), buffer0, v1);
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void dataFrame(int v, int v1, @Nullable Buffer buffer0, int v2) {
        this.frameHeader(v, v2, 0, v1);
        if(v2 > 0) {
            q.d(buffer0);
            this.sink.write(buffer0, ((long)v2));
        }
    }

    public final void flush() {
        synchronized(this) {
            if(!this.closed) {
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void frameHeader(int v, int v1, int v2, int v3) {
        Logger logger0 = Http2Writer.logger;
        if(logger0.isLoggable(Level.FINE)) {
            logger0.fine(Http2.INSTANCE.frameLog(false, v, v1, v2, v3));
        }
        if(v1 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + v1).toString());
        }
        if((0x80000000 & v) != 0) {
            throw new IllegalArgumentException(("reserved bit set: " + v).toString());
        }
        Util.writeMedium(this.sink, v1);
        this.sink.writeByte(v2 & 0xFF);
        this.sink.writeByte(v3 & 0xFF);
        this.sink.writeInt(0x7FFFFFFF & v);
    }

    @NotNull
    public final Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void goAway(int v, @NotNull ErrorCode errorCode0, @NotNull byte[] arr_b) {
        synchronized(this) {
            q.g(errorCode0, "errorCode");
            q.g(arr_b, "debugData");
            if(!this.closed) {
                if(errorCode0.getHttpCode() == -1) {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
                this.frameHeader(0, arr_b.length + 8, 7, 0);
                this.sink.writeInt(v);
                this.sink.writeInt(errorCode0.getHttpCode());
                if(arr_b.length != 0) {
                    this.sink.write(arr_b);
                }
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void headers(boolean z, int v, @NotNull List list0) {
        synchronized(this) {
            q.g(list0, "headerBlock");
            if(!this.closed) {
                this.hpackWriter.writeHeaders(list0);
                long v2 = this.hpackBuffer.size();
                long v3 = Math.min(this.maxFrameSize, v2);
                int v4 = Long.compare(v2, v3);
                int v5 = v4 == 0 ? 4 : 0;
                if(z) {
                    v5 |= 1;
                }
                this.frameHeader(v, ((int)v3), 1, v5);
                this.sink.write(this.hpackBuffer, v3);
                if(v4 > 0) {
                    this.writeContinuationFrames(v, v2 - v3);
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void ping(boolean z, int v, int v1) {
        synchronized(this) {
            if(!this.closed) {
                this.frameHeader(0, 8, 6, ((int)z));
                this.sink.writeInt(v);
                this.sink.writeInt(v1);
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void pushPromise(int v, int v1, @NotNull List list0) {
        synchronized(this) {
            q.g(list0, "requestHeaders");
            if(!this.closed) {
                this.hpackWriter.writeHeaders(list0);
                long v3 = this.hpackBuffer.size();
                int v4 = (int)Math.min(((long)this.maxFrameSize) - 4L, v3);
                int v5 = Long.compare(v3, v4);
                this.frameHeader(v, v4 + 4, 5, (v5 == 0 ? 4 : 0));
                this.sink.writeInt(v1 & 0x7FFFFFFF);
                this.sink.write(this.hpackBuffer, ((long)v4));
                if(v5 > 0) {
                    this.writeContinuationFrames(v, v3 - ((long)v4));
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void rstStream(int v, @NotNull ErrorCode errorCode0) {
        synchronized(this) {
            q.g(errorCode0, "errorCode");
            if(!this.closed) {
                if(errorCode0.getHttpCode() == -1) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                this.frameHeader(v, 4, 3, 0);
                this.sink.writeInt(errorCode0.getHttpCode());
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void settings(@NotNull Settings settings0) {
        int v2;
        synchronized(this) {
            q.g(settings0, "settings");
            if(!this.closed) {
                this.frameHeader(0, settings0.size() * 6, 4, 0);
                for(int v1 = 0; v1 < 10; ++v1) {
                    if(settings0.isSet(v1)) {
                        switch(v1) {
                            case 4: {
                                v2 = 3;
                                break;
                            }
                            case 7: {
                                v2 = 4;
                                break;
                            }
                            default: {
                                v2 = v1;
                            }
                        }
                        this.sink.writeShort(v2);
                        int v3 = settings0.get(v1);
                        this.sink.writeInt(v3);
                    }
                }
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    public final void windowUpdate(int v, long v1) {
        synchronized(this) {
            if(!this.closed) {
                if(v1 == 0L || v1 > 0x7FFFFFFFL) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + v1).toString());
                }
                this.frameHeader(v, 4, 8, 0);
                this.sink.writeInt(((int)v1));
                this.sink.flush();
                return;
            }
        }
        throw new IOException("closed");
    }

    private final void writeContinuationFrames(int v, long v1) {
        while(v1 > 0L) {
            long v2 = Math.min(this.maxFrameSize, v1);
            v1 -= v2;
            this.frameHeader(v, ((int)v2), 9, (v1 == 0L ? 4 : 0));
            this.sink.write(this.hpackBuffer, v2);
        }
    }
}

