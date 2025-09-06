package okhttp3.internal.http2;

import Ce.e;
import P4.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0003./0B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J5\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0010J/\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0010J\u001F\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0019\u0010\u0010J/\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0010J/\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001B\u0010\u0010J/\u0010\u001C\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0010J/\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u0010J/\u0010\u001E\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u0010J\u0015\u0010\u001F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u001F\u0010 J\u001D\u0010\"\u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001A\u00020+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-\u00A8\u00061"}, d2 = {"Lokhttp3/internal/http2/Http2Reader;", "Ljava/io/Closeable;", "Lokio/BufferedSource;", "source", "", "client", "<init>", "(Lokio/BufferedSource;Z)V", "Lokhttp3/internal/http2/Http2Reader$Handler;", "handler", "", "length", "flags", "streamId", "Lie/H;", "readHeaders", "(Lokhttp3/internal/http2/Http2Reader$Handler;III)V", "padding", "", "Lokhttp3/internal/http2/Header;", "readHeaderBlock", "(IIII)Ljava/util/List;", "readData", "readPriority", "(Lokhttp3/internal/http2/Http2Reader$Handler;I)V", "readRstStream", "readSettings", "readPushPromise", "readPing", "readGoAway", "readWindowUpdate", "readConnectionPreface", "(Lokhttp3/internal/http2/Http2Reader$Handler;)V", "requireSettings", "nextFrame", "(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z", "close", "()V", "Lokio/BufferedSource;", "Z", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "continuation", "Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokhttp3/internal/http2/Hpack$Reader;", "hpackReader", "Lokhttp3/internal/http2/Hpack$Reader;", "Companion", "ContinuationSource", "Handler", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http2Reader implements Closeable {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "getLogger", "()Ljava/util/logging/Logger;", "lengthWithoutPadding", "", "length", "flags", "padding", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int v, int v1, int v2) {
            if((v1 & 8) != 0) {
                --v;
            }
            if(v2 > v) {
                throw new IOException("PROTOCOL_ERROR padding " + v2 + " > remaining length " + v);
            }
            return v - v2;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\"\u0010\u0015\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\"\u0010\u001B\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001B\u0010\u0016\u001A\u0004\b\u001C\u0010\u0018\"\u0004\b\u001D\u0010\u001AR\"\u0010\u001E\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u0016\u001A\u0004\b\u001F\u0010\u0018\"\u0004\b \u0010\u001AR\"\u0010!\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\u0016\u001A\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001AR\"\u0010$\u001A\u00020\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001A\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001A¨\u0006\'"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "Lokio/BufferedSource;", "source", "<init>", "(Lokio/BufferedSource;)V", "Lie/H;", "readContinuationHeader", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/BufferedSource;", "", "length", "I", "getLength", "()I", "setLength", "(I)V", "flags", "getFlags", "setFlags", "streamId", "getStreamId", "setStreamId", "left", "getLeft", "setLeft", "padding", "getPadding", "setPadding", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        @NotNull
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(@NotNull BufferedSource bufferedSource0) {
            q.g(bufferedSource0, "source");
            super();
            this.source = bufferedSource0;
        }

        @Override  // okio.Source
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            int v1;
            while((v1 = this.left) == 0) {
                this.source.skip(((long)this.padding));
                this.padding = 0;
                if((this.flags & 4) != 0) {
                    return -1L;
                }
                this.readContinuationHeader();
            }
            long v2 = this.source.read(buffer0, Math.min(v, v1));
            if(v2 == -1L) {
                return -1L;
            }
            this.left -= (int)v2;
            return v2;
        }

        private final void readContinuationHeader() {
            int v = this.streamId;
            int v1 = Util.readMedium(this.source);
            this.left = v1;
            this.length = v1;
            int v2 = Util.and(this.source.readByte(), ((byte)0xFF));
            this.flags = Util.and(this.source.readByte(), ((byte)0xFF));
            Companion http2Reader$Companion0 = Http2Reader.Companion;
            if(http2Reader$Companion0.getLogger().isLoggable(Level.FINE)) {
                http2Reader$Companion0.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, v2, this.flags));
            }
            int v3 = this.source.readInt();
            this.streamId = v3 & 0x7FFFFFFF;
            if(v2 != 9) {
                throw new IOException(v2 + " != TYPE_CONTINUATION");
            }
            if((v3 & 0x7FFFFFFF) != v) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        public final void setFlags(int v) {
            this.flags = v;
        }

        public final void setLeft(int v) {
            this.left = v;
        }

        public final void setLength(int v) {
            this.length = v;
        }

        public final void setPadding(int v) {
            this.padding = v;
        }

        public final void setStreamId(int v) {
            this.streamId = v;
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\n\u0010\u000BJ5\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u00042\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH&\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H&\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0017H&\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001F\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u001F\u0010 J\'\u0010$\u001A\u00020\t2\u0006\u0010!\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"H&\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010(\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020&H&\u00A2\u0006\u0004\b(\u0010)J/\u0010-\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010*\u001A\u00020\u00042\u0006\u0010+\u001A\u00020\u00042\u0006\u0010,\u001A\u00020\u0002H&\u00A2\u0006\u0004\b-\u0010.J-\u00101\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010/\u001A\u00020\u00042\f\u00100\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH&\u00A2\u0006\u0004\b1\u00102J?\u00109\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u00020\"2\u0006\u00106\u001A\u0002032\u0006\u00107\u001A\u00020\u00042\u0006\u00108\u001A\u00020&H&\u00A2\u0006\u0004\b9\u0010:\u00A8\u0006;"}, d2 = {"Lokhttp3/internal/http2/Http2Reader$Handler;", "", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", "source", "length", "Lie/H;", "data", "(ZILokio/BufferedSource;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "ackSettings", "()V", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Handler {
        void ackSettings();

        void alternateService(int arg1, @NotNull String arg2, @NotNull ByteString arg3, @NotNull String arg4, int arg5, long arg6);

        void data(boolean arg1, int arg2, @NotNull BufferedSource arg3, int arg4);

        void goAway(int arg1, @NotNull ErrorCode arg2, @NotNull ByteString arg3);

        void headers(boolean arg1, int arg2, int arg3, @NotNull List arg4);

        void ping(boolean arg1, int arg2, int arg3);

        void priority(int arg1, int arg2, int arg3, boolean arg4);

        void pushPromise(int arg1, int arg2, @NotNull List arg3);

        void rstStream(int arg1, @NotNull ErrorCode arg2);

        void settings(boolean arg1, @NotNull Settings arg2);

        void windowUpdate(int arg1, long arg2);
    }

    @NotNull
    public static final Companion Companion;
    private final boolean client;
    @NotNull
    private final ContinuationSource continuation;
    @NotNull
    private final Reader hpackReader;
    @NotNull
    private static final Logger logger;
    @NotNull
    private final BufferedSource source;

    static {
        Http2Reader.Companion = new Companion(null);
        Logger logger0 = Logger.getLogger("okhttp3.internal.http2.Http2");
        q.f(logger0, "getLogger(Http2::class.java.name)");
        Http2Reader.logger = logger0;
    }

    public Http2Reader(@NotNull BufferedSource bufferedSource0, boolean z) {
        q.g(bufferedSource0, "source");
        super();
        this.source = bufferedSource0;
        this.client = z;
        ContinuationSource http2Reader$ContinuationSource0 = new ContinuationSource(bufferedSource0);
        this.continuation = http2Reader$ContinuationSource0;
        this.hpackReader = new Reader(http2Reader$ContinuationSource0, 0x1000, 0, 4, null);
    }

    @Override
    public void close() {
        this.source.close();
    }

    public final boolean nextFrame(boolean z, @NotNull Handler http2Reader$Handler0) {
        q.g(http2Reader$Handler0, "handler");
        try {
            this.source.require(9L);
        }
        catch(EOFException unused_ex) {
            return false;
        }
        int v = Util.readMedium(this.source);
        if(v <= 0x4000) {
            int v1 = Util.and(this.source.readByte(), ((byte)0xFF));
            int v2 = Util.and(this.source.readByte(), ((byte)0xFF));
            int v3 = this.source.readInt();
            Logger logger0 = Http2Reader.logger;
            if(logger0.isLoggable(Level.FINE)) {
                logger0.fine(Http2.INSTANCE.frameLog(true, v3 & 0x7FFFFFFF, v, v1, v2));
            }
            if(z && v1 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(v1));
            }
            switch(v1) {
                case 0: {
                    this.readData(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 1: {
                    this.readHeaders(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 2: {
                    this.readPriority(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 3: {
                    this.readRstStream(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 4: {
                    this.readSettings(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 5: {
                    this.readPushPromise(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 6: {
                    this.readPing(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 7: {
                    this.readGoAway(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                case 8: {
                    this.readWindowUpdate(http2Reader$Handler0, v, v2, v3 & 0x7FFFFFFF);
                    return true;
                }
                default: {
                    this.source.skip(((long)v));
                    return true;
                }
            }
        }
        throw new IOException("FRAME_SIZE_ERROR: " + v);
    }

    public final void readConnectionPreface(@NotNull Handler http2Reader$Handler0) {
        q.g(http2Reader$Handler0, "handler");
        if(this.client) {
            if(!this.nextFrame(true, http2Reader$Handler0)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        ByteString byteString0 = Http2.CONNECTION_PREFACE;
        ByteString byteString1 = this.source.readByteString(((long)byteString0.size()));
        Logger logger0 = Http2Reader.logger;
        if(logger0.isLoggable(Level.FINE)) {
            logger0.fine(Util.format(("<< CONNECTION " + byteString1.hex()), new Object[0]));
        }
        if(!q.b(byteString0, byteString1)) {
            throw new IOException("Expected a connection header but was " + byteString1.utf8());
        }
    }

    private final void readData(Handler http2Reader$Handler0, int v, int v1, int v2) {
        int v3 = 0;
        if(v2 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        if((v1 & 0x20) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        if((v1 & 8) != 0) {
            v3 = Util.and(this.source.readByte(), ((byte)0xFF));
        }
        int v4 = Http2Reader.Companion.lengthWithoutPadding(v, v1, v3);
        http2Reader$Handler0.data((v1 & 1) != 0, v2, this.source, v4);
        this.source.skip(((long)v3));
    }

    private final void readGoAway(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + v);
        }
        if(v2 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int v3 = this.source.readInt();
        int v4 = this.source.readInt();
        ErrorCode errorCode0 = ErrorCode.Companion.fromHttp2(v4);
        if(errorCode0 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + v4);
        }
        http2Reader$Handler0.goAway(v3, errorCode0, (v - 8 <= 0 ? ByteString.EMPTY : this.source.readByteString(((long)(v - 8)))));
    }

    private final List readHeaderBlock(int v, int v1, int v2, int v3) {
        this.continuation.setLeft(v);
        this.continuation.setLength(this.continuation.getLeft());
        this.continuation.setPadding(v1);
        this.continuation.setFlags(v2);
        this.continuation.setStreamId(v3);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler http2Reader$Handler0, int v, int v1, int v2) {
        int v3 = 0;
        if(v2 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        if((v1 & 8) != 0) {
            v3 = Util.and(this.source.readByte(), ((byte)0xFF));
        }
        if((v1 & 0x20) != 0) {
            this.readPriority(http2Reader$Handler0, v2);
            v -= 5;
        }
        http2Reader$Handler0.headers((v1 & 1) != 0, v2, -1, this.readHeaderBlock(Http2Reader.Companion.lengthWithoutPadding(v, v1, v3), v3, v1, v2));
    }

    private final void readPing(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v != 8) {
            throw new IOException("TYPE_PING length != 8: " + v);
        }
        if(v2 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        http2Reader$Handler0.ping((v1 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void readPriority(Handler http2Reader$Handler0, int v) {
        int v1 = this.source.readInt();
        http2Reader$Handler0.priority(v, v1 & 0x7FFFFFFF, Util.and(this.source.readByte(), ((byte)0xFF)) + 1, (0x80000000 & v1) != 0);
    }

    private final void readPriority(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v != 5) {
            throw new IOException("TYPE_PRIORITY length: " + v + " != 5");
        }
        if(v2 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        this.readPriority(http2Reader$Handler0, v2);
    }

    private final void readPushPromise(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v2 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int v3 = (v1 & 8) == 0 ? 0 : Util.and(this.source.readByte(), ((byte)0xFF));
        http2Reader$Handler0.pushPromise(v2, this.source.readInt() & 0x7FFFFFFF, this.readHeaderBlock(Http2Reader.Companion.lengthWithoutPadding(v - 4, v1, v3), v3, v1, v2));
    }

    private final void readRstStream(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + v + " != 4");
        }
        if(v2 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int v3 = this.source.readInt();
        ErrorCode errorCode0 = ErrorCode.Companion.fromHttp2(v3);
        if(errorCode0 == null) {
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + v3);
        }
        http2Reader$Handler0.rstStream(v2, errorCode0);
    }

    private final void readSettings(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v2 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if((v1 & 1) != 0) {
            if(v != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            http2Reader$Handler0.ackSettings();
            return;
        }
        if(v % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + v);
        }
        Settings settings0 = new Settings();
        e e0 = a.C(a.K(0, v), 6);
        int v3 = e0.a;
        int v4 = e0.b;
        int v5 = e0.c;
        if(v5 > 0 && v3 <= v4 || v5 < 0 && v4 <= v3) {
            while(true) {
                int v6 = Util.and(this.source.readShort(), ((short)0xFFFF));
                int v7 = this.source.readInt();
                if(v6 != 2) {
                    switch(v6) {
                        case 3: {
                            v6 = 4;
                            break;
                        }
                        case 4: {
                            if(v7 < 0) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                            }
                            v6 = 7;
                            break;
                        }
                        default: {
                            if(v6 == 5 && (v7 < 0x4000 || v7 > 0xFFFFFF)) {
                                throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + v7);
                            }
                        }
                    }
                }
                else if(v7 != 0 && v7 != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings0.set(v6, v7);
                if(v3 == v4) {
                    break;
                }
                v3 += v5;
            }
        }
        http2Reader$Handler0.settings(false, settings0);
    }

    private final void readWindowUpdate(Handler http2Reader$Handler0, int v, int v1, int v2) {
        if(v != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + v);
        }
        long v3 = Util.and(this.source.readInt(), 0x7FFFFFFFL);
        if(v3 == 0L) {
            throw new IOException("windowSizeIncrement was 0");
        }
        http2Reader$Handler0.windowUpdate(v2, v3);
    }
}

