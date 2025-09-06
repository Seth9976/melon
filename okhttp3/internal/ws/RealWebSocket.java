package okhttp3.internal.ws;

import Ce.g;
import U4.x;
import e.k;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00C2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000E\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\n\u0083\u0001\u0082\u0001\u0084\u0001\u0085\u0001\u0086\u0001BA\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\r\u0012\u0006\u0010\u000F\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010#\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0000\u00A2\u0006\u0004\b!\u0010\"J\u001D\u0010(\u001A\u00020\u00162\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&\u00A2\u0006\u0004\b(\u0010)J\r\u0010*\u001A\u00020\u0016\u00A2\u0006\u0004\b*\u0010\u0018J\r\u0010,\u001A\u00020+\u00A2\u0006\u0004\b,\u0010-J\u001D\u00101\u001A\u00020\u00162\u0006\u0010.\u001A\u00020\u000B2\u0006\u00100\u001A\u00020/\u00A2\u0006\u0004\b1\u00102J\r\u00103\u001A\u00020\u0016\u00A2\u0006\u0004\b3\u0010\u0018J\r\u00105\u001A\u000204\u00A2\u0006\u0004\b5\u00106J\r\u00107\u001A\u000204\u00A2\u0006\u0004\b7\u00106J\r\u00108\u001A\u000204\u00A2\u0006\u0004\b8\u00106J\u0017\u0010:\u001A\u00020\u00162\u0006\u00109\u001A\u00020$H\u0016\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010:\u001A\u00020\u00162\u0006\u0010=\u001A\u00020<H\u0016\u00A2\u0006\u0004\b:\u0010>J\u0017\u0010@\u001A\u00020\u00162\u0006\u0010?\u001A\u00020<H\u0016\u00A2\u0006\u0004\b@\u0010>J\u0017\u0010A\u001A\u00020\u00162\u0006\u0010?\u001A\u00020<H\u0016\u00A2\u0006\u0004\bA\u0010>J\u001F\u0010D\u001A\u00020\u00162\u0006\u0010B\u001A\u0002042\u0006\u0010C\u001A\u00020$H\u0016\u00A2\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001A\u00020+2\u0006\u00109\u001A\u00020$H\u0016\u00A2\u0006\u0004\bF\u0010GJ\u0017\u0010F\u001A\u00020+2\u0006\u0010=\u001A\u00020<H\u0016\u00A2\u0006\u0004\bF\u0010HJ\u0015\u0010I\u001A\u00020+2\u0006\u0010?\u001A\u00020<\u00A2\u0006\u0004\bI\u0010HJ!\u0010J\u001A\u00020+2\u0006\u0010B\u001A\u0002042\b\u0010C\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\bJ\u0010KJ\'\u0010J\u001A\u00020+2\u0006\u0010B\u001A\u0002042\b\u0010C\u001A\u0004\u0018\u00010$2\u0006\u0010L\u001A\u00020\u000B\u00A2\u0006\u0004\bJ\u0010MJ\u000F\u0010O\u001A\u00020+H\u0000\u00A2\u0006\u0004\bN\u0010-J\u000F\u0010Q\u001A\u00020\u0016H\u0000\u00A2\u0006\u0004\bP\u0010\u0018J#\u0010U\u001A\u00020\u00162\n\u0010T\u001A\u00060Rj\u0002`S2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D\u00A2\u0006\u0004\bU\u0010VJ\u0013\u0010W\u001A\u00020+*\u00020\rH\u0002\u00A2\u0006\u0004\bW\u0010XJ\u001F\u0010F\u001A\u00020+2\u0006\u0010Y\u001A\u00020<2\u0006\u0010Z\u001A\u000204H\u0002\u00A2\u0006\u0004\bF\u0010[J\u000F\u0010\\\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b\\\u0010\u0018R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010]R\u001A\u0010\b\u001A\u00020\u00078\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\b\u0010^\u001A\u0004\b_\u0010`R\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010aR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\f\u0010bR\u0018\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000E\u0010cR\u0016\u0010\u000F\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000F\u0010bR\u0014\u0010d\u001A\u00020$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001A\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001A\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001A\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010p\u001A\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001A\u00020r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010%\u001A\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u0010eR\u0018\u0010\'\u001A\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010uR\u001A\u0010w\u001A\b\u0012\u0004\u0012\u00020<0v8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bw\u0010xR\u001A\u0010z\u001A\b\u0012\u0004\u0012\u00020y0v8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bz\u0010xR\u0016\u0010\u0014\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0014\u0010bR\u0016\u0010{\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u007F\u001A\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u007F\u0010eR\u0018\u0010\u0080\u0001\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0080\u0001\u0010|R\u0016\u00105\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u0010~R\u0016\u00107\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u0010~R\u0016\u00108\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u0010~R\u0018\u0010\u0081\u0001\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0081\u0001\u0010|\u00A8\u0006\u0087\u0001"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/Request;", "originalRequest", "Lokhttp3/WebSocketListener;", "listener", "Ljava/util/Random;", "random", "", "pingIntervalMillis", "Lokhttp3/internal/ws/WebSocketExtensions;", "extensions", "minimumDeflateSize", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "request", "()Lokhttp3/Request;", "queueSize", "()J", "Lie/H;", "cancel", "()V", "Lokhttp3/OkHttpClient;", "client", "connect", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Response;", "response", "Lokhttp3/internal/connection/Exchange;", "exchange", "checkUpgradeSuccess$okhttp", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)V", "checkUpgradeSuccess", "", "name", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "streams", "initReaderAndWriter", "(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V", "loopReader", "", "processNextFrame", "()Z", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "awaitTermination", "(JLjava/util/concurrent/TimeUnit;)V", "tearDown", "", "sentPingCount", "()I", "receivedPingCount", "receivedPongCount", "text", "onReadMessage", "(Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)V", "payload", "onReadPing", "onReadPong", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "send", "(Ljava/lang/String;)Z", "(Lokio/ByteString;)Z", "pong", "close", "(ILjava/lang/String;)Z", "cancelAfterCloseMillis", "(ILjava/lang/String;J)Z", "writeOneFrame$okhttp", "writeOneFrame", "writePingFrame$okhttp", "writePingFrame", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failWebSocket", "(Ljava/lang/Exception;Lokhttp3/Response;)V", "isValid", "(Lokhttp3/internal/ws/WebSocketExtensions;)Z", "data", "formatOpcode", "(Lokio/ByteString;I)Z", "runWriter", "Lokhttp3/Request;", "Lokhttp3/WebSocketListener;", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "Ljava/util/Random;", "J", "Lokhttp3/internal/ws/WebSocketExtensions;", "key", "Ljava/lang/String;", "Lokhttp3/Call;", "call", "Lokhttp3/Call;", "Lokhttp3/internal/concurrent/Task;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "Lokhttp3/internal/ws/WebSocketReader;", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "Lokhttp3/internal/ws/WebSocketWriter;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/util/ArrayDeque;", "pongQueue", "Ljava/util/ArrayDeque;", "", "messageAndCloseQueue", "enqueuedClose", "Z", "receivedCloseCode", "I", "receivedCloseReason", "failed", "awaitingPong", "Companion", "Close", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RealWebSocket implements WebSocket, FrameCallback {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        @Nullable
        private final ByteString reason;

        public Close(int v, @Nullable ByteString byteString0, long v1) {
            this.code = v;
            this.reason = byteString0;
            this.cancelAfterCloseMillis = v1;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final ByteString getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Message {
        @NotNull
        private final ByteString data;
        private final int formatOpcode;

        public Message(int v, @NotNull ByteString byteString0) {
            q.g(byteString0, "data");
            super();
            this.formatOpcode = v;
            this.data = byteString0;
        }

        @NotNull
        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class Streams implements Closeable {
        private final boolean client;
        @NotNull
        private final BufferedSink sink;
        @NotNull
        private final BufferedSource source;

        public Streams(boolean z, @NotNull BufferedSource bufferedSource0, @NotNull BufferedSink bufferedSink0) {
            q.g(bufferedSource0, "source");
            q.g(bufferedSink0, "sink");
            super();
            this.client = z;
            this.source = bufferedSource0;
            this.sink = bufferedSink0;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final BufferedSink getSink() {
            return this.sink;
        }

        @NotNull
        public final BufferedSource getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class WriterTask extends Task {
        public WriterTask() {
            super(realWebSocket0.name + " writer", false, 2, null);
        }

        @Override  // okhttp3.internal.concurrent.Task
        public long runOnce() {
            try {
                if(RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0L;
                }
            }
            catch(IOException iOException0) {
                RealWebSocket.this.failWebSocket(iOException0, null);
            }
            return -1L;
        }
    }

    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
    @NotNull
    public static final Companion Companion = null;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 0x400L;
    private static final long MAX_QUEUE_SIZE = 0x1000000L;
    @NotNull
    private static final List ONLY_HTTP1;
    private boolean awaitingPong;
    @Nullable
    private Call call;
    private boolean enqueuedClose;
    @Nullable
    private WebSocketExtensions extensions;
    private boolean failed;
    @NotNull
    private final String key;
    @NotNull
    private final WebSocketListener listener;
    @NotNull
    private final ArrayDeque messageAndCloseQueue;
    private long minimumDeflateSize;
    @Nullable
    private String name;
    @NotNull
    private final Request originalRequest;
    private final long pingIntervalMillis;
    @NotNull
    private final ArrayDeque pongQueue;
    private long queueSize;
    @NotNull
    private final Random random;
    @Nullable
    private WebSocketReader reader;
    private int receivedCloseCode;
    @Nullable
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    @Nullable
    private Streams streams;
    @NotNull
    private TaskQueue taskQueue;
    @Nullable
    private WebSocketWriter writer;
    @Nullable
    private Task writerTask;

    static {
        RealWebSocket.Companion = new Companion(null);
        RealWebSocket.ONLY_HTTP1 = k.z(Protocol.HTTP_1_1);
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner0, @NotNull Request request0, @NotNull WebSocketListener webSocketListener0, @NotNull Random random0, long v, @Nullable WebSocketExtensions webSocketExtensions0, long v1) {
        q.g(taskRunner0, "taskRunner");
        q.g(request0, "originalRequest");
        q.g(webSocketListener0, "listener");
        q.g(random0, "random");
        super();
        this.originalRequest = request0;
        this.listener = webSocketListener0;
        this.random = random0;
        this.pingIntervalMillis = v;
        this.extensions = webSocketExtensions0;
        this.minimumDeflateSize = v1;
        this.taskQueue = taskRunner0.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if(!"GET".equals(request0.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + request0.method()).toString());
        }
        byte[] arr_b = new byte[16];
        random0.nextBytes(arr_b);
        this.key = okio.ByteString.Companion.of$default(ByteString.Companion, arr_b, 0, 0, 3, null).base64();
    }

    public final void awaitTermination(long v, @NotNull TimeUnit timeUnit0) {
        q.g(timeUnit0, "timeUnit");
        this.taskQueue.idleLatch().await(v, timeUnit0);
    }

    @Override  // okhttp3.WebSocket
    public void cancel() {
        Call call0 = this.call;
        q.d(call0);
        call0.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull Response response0, @Nullable Exchange exchange0) {
        q.g(response0, "response");
        if(response0.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was \'" + response0.code() + ' ' + response0.message() + '\'');
        }
        String s = Response.header$default(response0, "Connection", null, 2, null);
        if(!"Upgrade".equalsIgnoreCase(s)) {
            throw new ProtocolException("Expected \'Connection\' header value \'Upgrade\' but was \'" + s + '\'');
        }
        String s1 = Response.header$default(response0, "Upgrade", null, 2, null);
        if(!"websocket".equalsIgnoreCase(s1)) {
            throw new ProtocolException("Expected \'Upgrade\' header value \'websocket\' but was \'" + s1 + '\'');
        }
        String s2 = Response.header$default(response0, "Sec-WebSocket-Accept", null, 2, null);
        String s3 = ByteString.Companion.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if(!q.b(s3, s2)) {
            throw new ProtocolException("Expected \'Sec-WebSocket-Accept\' header value \'" + s3 + "\' but was \'" + s2 + '\'');
        }
        if(exchange0 == null) {
            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
        }
    }

    @Override  // okhttp3.WebSocket
    public boolean close(int v, @Nullable String s) {
        return this.close(v, s, 60000L);
    }

    public final boolean close(int v, @Nullable String s, long v1) {
        ByteString byteString0;
        synchronized(this) {
            WebSocketProtocol.INSTANCE.validateCloseCode(v);
            if(s == null) {
                byteString0 = null;
            }
            else {
                byteString0 = ByteString.Companion.encodeUtf8(s);
                if(((long)byteString0.size()) > 0x7BL) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + s).toString());
                }
            }
            if(!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                Close realWebSocket$Close0 = new Close(v, byteString0, v1);
                this.messageAndCloseQueue.add(realWebSocket$Close0);
                this.runWriter();
                return true;
            }
            return false;
        }
    }

    public final void connect(@NotNull OkHttpClient okHttpClient0) {
        q.g(okHttpClient0, "client");
        if(this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            this.failWebSocket(new ProtocolException("Request header not permitted: \'Sec-WebSocket-Extensions\'"), null);
            return;
        }
        OkHttpClient okHttpClient1 = okHttpClient0.newBuilder().eventListener(EventListener.NONE).protocols(RealWebSocket.ONLY_HTTP1).build();
        Request request0 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        RealCall realCall0 = new RealCall(okHttpClient1, request0, true);
        this.call = realCall0;
        realCall0.enqueue(new Callback() {
            @Override  // okhttp3.Callback
            public void onFailure(@NotNull Call call0, @NotNull IOException iOException0) {
                q.g(call0, "call");
                q.g(iOException0, "e");
                request0.failWebSocket(iOException0, null);
            }

            @Override  // okhttp3.Callback
            public void onResponse(@NotNull Call call0, @NotNull Response response0) {
                Streams realWebSocket$Streams0;
                q.g(call0, "call");
                q.g(response0, "response");
                Exchange exchange0 = response0.exchange();
                try {
                    request0.checkUpgradeSuccess$okhttp(response0, exchange0);
                    q.d(exchange0);
                    realWebSocket$Streams0 = exchange0.newWebSocketStreams();
                }
                catch(IOException iOException0) {
                    request0.failWebSocket(iOException0, response0);
                    Util.closeQuietly(response0);
                    if(exchange0 != null) {
                        exchange0.webSocketUpgradeFailed();
                    }
                    return;
                }
                WebSocketExtensions webSocketExtensions0 = WebSocketExtensions.Companion.parse(response0.headers());
                request0.extensions = webSocketExtensions0;
                if(!request0.isValid(webSocketExtensions0)) {
                    synchronized(request0) {
                        request0.messageAndCloseQueue.clear();
                        request0.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    request0.initReaderAndWriter("OkHttp WebSocket " + this.$request.url().redact(), realWebSocket$Streams0);
                    request0.getListener$okhttp().onOpen(request0, response0);
                    request0.loopReader();
                }
                catch(Exception exception0) {
                    request0.failWebSocket(exception0, null);
                }
            }
        });
    }

    public final void failWebSocket(@NotNull Exception exception0, @Nullable Response response0) {
        WebSocketWriter webSocketWriter0;
        WebSocketReader webSocketReader0;
        Streams realWebSocket$Streams0;
        q.g(exception0, "e");
        synchronized(this) {
            if(this.failed) {
                return;
            }
            this.failed = true;
            realWebSocket$Streams0 = this.streams;
            this.streams = null;
            webSocketReader0 = this.reader;
            this.reader = null;
            webSocketWriter0 = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
        }
        try {
            this.listener.onFailure(this, exception0, response0);
        }
        catch(Throwable throwable0) {
            if(realWebSocket$Streams0 != null) {
                Util.closeQuietly(realWebSocket$Streams0);
            }
            if(webSocketReader0 != null) {
                Util.closeQuietly(webSocketReader0);
            }
            if(webSocketWriter0 != null) {
                Util.closeQuietly(webSocketWriter0);
            }
            throw throwable0;
        }
        if(realWebSocket$Streams0 != null) {
            Util.closeQuietly(realWebSocket$Streams0);
        }
        if(webSocketReader0 != null) {
            Util.closeQuietly(webSocketReader0);
        }
        if(webSocketWriter0 != null) {
            Util.closeQuietly(webSocketWriter0);
        }
    }

    @NotNull
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(@NotNull String s, @NotNull Streams realWebSocket$Streams0) {
        Throwable throwable2;
        long v;
        q.g(s, "name");
        q.g(realWebSocket$Streams0, "streams");
        WebSocketExtensions webSocketExtensions0 = this.extensions;
        q.d(webSocketExtensions0);
        __monitor_enter(this);
        try {
            this.name = s;
            this.streams = realWebSocket$Streams0;
            boolean z = webSocketExtensions0.noContextTakeover(realWebSocket$Streams0.getClient());
            this.writer = new WebSocketWriter(realWebSocket$Streams0.getClient(), realWebSocket$Streams0.getSink(), this.random, webSocketExtensions0.perMessageDeflate, z, this.minimumDeflateSize);
            this.writerTask = new WriterTask(this);
            v = this.pingIntervalMillis;
            if(v != 0L) {
                goto label_12;
            }
            goto label_14;
        }
        catch(Throwable throwable0) {
            throwable2 = throwable0;
            __monitor_exit(this);
            throw throwable2;
        }
        try {
        label_12:
            long v1 = TimeUnit.MILLISECONDS.toNanos(v);
            this.taskQueue.schedule(new Task(this, v1) {
                final long $pingIntervalNanos$inlined;

                {
                    RealWebSocket.this = realWebSocket0;
                    this.$pingIntervalNanos$inlined = v;
                    super(s, false, 2, null);
                }

                @Override  // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    RealWebSocket.this.writePingFrame$okhttp();
                    return this.$pingIntervalNanos$inlined;
                }
            }, v1);
        }
        catch(Throwable throwable1) {
            throwable2 = throwable1;
            __monitor_exit(this);
            throw throwable2;
        }
        try {
        label_14:
            if(!this.messageAndCloseQueue.isEmpty()) {
                goto label_19;
            }
            goto label_25;
        }
        catch(Throwable throwable0) {
            throwable2 = throwable0;
            __monitor_exit(this);
            throw throwable2;
        }
        try {
        label_19:
            this.runWriter();
        }
        catch(Throwable throwable1) {
            throwable2 = throwable1;
            __monitor_exit(this);
            throw throwable2;
        }
    label_25:
        __monitor_exit(this);
        boolean z1 = webSocketExtensions0.noContextTakeover(!realWebSocket$Streams0.getClient());
        this.reader = new WebSocketReader(realWebSocket$Streams0.getClient(), realWebSocket$Streams0.getSource(), this, webSocketExtensions0.perMessageDeflate, z1);
    }

    private final boolean isValid(WebSocketExtensions webSocketExtensions0) {
        if(webSocketExtensions0.unknownValues) {
            return false;
        }
        return webSocketExtensions0.clientMaxWindowBits == null ? webSocketExtensions0.serverMaxWindowBits == null || new g(8, 15, 1).d(((int)webSocketExtensions0.serverMaxWindowBits)) : false;  // 初始化器: LCe/e;-><init>(III)V
    }

    public final void loopReader() {
        while(this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader0 = this.reader;
            q.d(webSocketReader0);
            webSocketReader0.processNextFrame();
        }
    }

    @Override  // okhttp3.internal.ws.WebSocketReader$FrameCallback
    public void onReadClose(int v, @NotNull String s) {
        WebSocketWriter webSocketWriter0;
        WebSocketReader webSocketReader0;
        q.g(s, "reason");
        if(v == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized(this) {
            if(this.receivedCloseCode == -1) {
                this.receivedCloseCode = v;
                this.receivedCloseReason = s;
                Streams realWebSocket$Streams0 = null;
                if(!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                    webSocketReader0 = null;
                    webSocketWriter0 = null;
                }
                else {
                    Streams realWebSocket$Streams1 = this.streams;
                    this.streams = null;
                    webSocketReader0 = this.reader;
                    this.reader = null;
                    webSocketWriter0 = this.writer;
                    this.writer = null;
                    this.taskQueue.shutdown();
                    realWebSocket$Streams0 = realWebSocket$Streams1;
                }
                try {
                    this.listener.onClosing(this, v, s);
                    if(realWebSocket$Streams0 != null) {
                        this.listener.onClosed(this, v, s);
                    }
                }
                finally {
                    if(realWebSocket$Streams0 != null) {
                        Util.closeQuietly(realWebSocket$Streams0);
                    }
                    if(webSocketReader0 != null) {
                        Util.closeQuietly(webSocketReader0);
                    }
                    if(webSocketWriter0 != null) {
                        Util.closeQuietly(webSocketWriter0);
                    }
                }
                return;
            }
        }
        throw new IllegalStateException("already closed");
    }

    @Override  // okhttp3.internal.ws.WebSocketReader$FrameCallback
    public void onReadMessage(@NotNull String s) {
        q.g(s, "text");
        this.listener.onMessage(this, s);
    }

    @Override  // okhttp3.internal.ws.WebSocketReader$FrameCallback
    public void onReadMessage(@NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        this.listener.onMessage(this, byteString0);
    }

    @Override  // okhttp3.internal.ws.WebSocketReader$FrameCallback
    public void onReadPing(@NotNull ByteString byteString0) {
        synchronized(this) {
            q.g(byteString0, "payload");
            if(!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString0);
                this.runWriter();
                ++this.receivedPingCount;
            }
        }
    }

    @Override  // okhttp3.internal.ws.WebSocketReader$FrameCallback
    public void onReadPong(@NotNull ByteString byteString0) {
        synchronized(this) {
            q.g(byteString0, "payload");
            ++this.receivedPongCount;
            this.awaitingPong = false;
        }
    }

    public final boolean pong(@NotNull ByteString byteString0) {
        synchronized(this) {
            q.g(byteString0, "payload");
            if(!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(byteString0);
                this.runWriter();
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean processNextFrame() {
        try {
            WebSocketReader webSocketReader0 = this.reader;
            q.d(webSocketReader0);
            webSocketReader0.processNextFrame();
            return this.receivedCloseCode == -1;
        }
        catch(Exception exception0) {
            this.failWebSocket(exception0, null);
            return false;
        }
    }

    @Override  // okhttp3.WebSocket
    public long queueSize() {
        synchronized(this) {
        }
        return this.queueSize;
    }

    public final int receivedPingCount() {
        synchronized(this) {
        }
        return this.receivedPingCount;
    }

    public final int receivedPongCount() {
        synchronized(this) {
        }
        return this.receivedPongCount;
    }

    @Override  // okhttp3.WebSocket
    @NotNull
    public Request request() {
        return this.originalRequest;
    }

    private final void runWriter() {
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2453 MUST hold lock on " + this);
        }
        Task task0 = this.writerTask;
        if(task0 != null) {
            TaskQueue.schedule$default(this.taskQueue, task0, 0L, 2, null);
        }
    }

    private final boolean send(ByteString byteString0, int v) {
        synchronized(this) {
            if(!this.failed && !this.enqueuedClose) {
                if(this.queueSize + ((long)byteString0.size()) > 0x1000000L) {
                    this.close(1001, null);
                    return false;
                }
                this.queueSize += (long)byteString0.size();
                Message realWebSocket$Message0 = new Message(v, byteString0);
                this.messageAndCloseQueue.add(realWebSocket$Message0);
                this.runWriter();
                return true;
            }
            return false;
        }
    }

    @Override  // okhttp3.WebSocket
    public boolean send(@NotNull String s) {
        q.g(s, "text");
        return this.send(ByteString.Companion.encodeUtf8(s), 1);
    }

    @Override  // okhttp3.WebSocket
    public boolean send(@NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        return this.send(byteString0, 2);
    }

    public final int sentPingCount() {
        synchronized(this) {
        }
        return this.sentPingCount;
    }

    public final void tearDown() {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    public final boolean writeOneFrame$okhttp() {
        WebSocketWriter webSocketWriter1;
        WebSocketReader webSocketReader0;
        Streams realWebSocket$Streams0;
        String s;
        int v;
        Object object2;
        Object object1;
        Object object0;
        WebSocketWriter webSocketWriter0;
        synchronized(this) {
            if(!this.failed) {
                webSocketWriter0 = this.writer;
                object0 = this.pongQueue.poll();
                object1 = null;
                if(object0 == null) {
                    object2 = this.messageAndCloseQueue.poll();
                    if(object2 instanceof Close) {
                        v = this.receivedCloseCode;
                        s = this.receivedCloseReason;
                        if(v == -1) {
                            long v1 = ((Close)object2).getCancelAfterCloseMillis();
                            TaskQueue taskQueue0 = this.taskQueue;
                            long v2 = TimeUnit.MILLISECONDS.toNanos(v1);
                            taskQueue0.schedule(new Task(true, this) {
                                @Override  // okhttp3.internal.concurrent.Task
                                public long runOnce() {
                                    RealWebSocket.this.cancel();
                                    return -1L;
                                }
                            }, v2);
                            realWebSocket$Streams0 = null;
                            webSocketReader0 = null;
                            webSocketWriter1 = null;
                        }
                        else {
                            realWebSocket$Streams0 = this.streams;
                            this.streams = null;
                            webSocketReader0 = this.reader;
                            this.reader = null;
                            webSocketWriter1 = this.writer;
                            this.writer = null;
                            this.taskQueue.shutdown();
                        }
                    }
                    else {
                        goto label_27;
                    }
                    object1 = object2;
                }
                else {
                    goto label_37;
                }
                goto label_46;
            }
            return false;
        }
    label_27:
        if(object2 == null) {
            return false;
        }
        s = null;
        webSocketReader0 = null;
        webSocketWriter1 = null;
        v = -1;
        realWebSocket$Streams0 = null;
        object1 = object2;
        goto label_46;
    label_37:
        s = null;
        webSocketReader0 = null;
        webSocketWriter1 = null;
        v = -1;
        realWebSocket$Streams0 = null;
    label_46:
        try {
            if(object0 != null) {
                q.d(webSocketWriter0);
                webSocketWriter0.writePong(((ByteString)object0));
                return true;
            }
            if(object1 instanceof Message) {
                Message realWebSocket$Message0 = (Message)object1;
                q.d(webSocketWriter0);
                webSocketWriter0.writeMessageFrame(realWebSocket$Message0.getFormatOpcode(), realWebSocket$Message0.getData());
                synchronized(this) {
                    this.queueSize -= (long)realWebSocket$Message0.getData().size();
                }
                return true;
            }
            if(object1 instanceof Close) {
                q.d(webSocketWriter0);
                webSocketWriter0.writeClose(((Close)object1).getCode(), ((Close)object1).getReason());
                if(realWebSocket$Streams0 != null) {
                    q.d(s);
                    this.listener.onClosed(this, v, s);
                }
                return true;
            }
        }
        finally {
            if(realWebSocket$Streams0 != null) {
                Util.closeQuietly(realWebSocket$Streams0);
            }
            if(webSocketReader0 != null) {
                Util.closeQuietly(webSocketReader0);
            }
            if(webSocketWriter1 != null) {
                Util.closeQuietly(webSocketWriter1);
            }
        }
        throw new AssertionError();
    }

    public final void writePingFrame$okhttp() {
        int v;
        WebSocketWriter webSocketWriter0;
        synchronized(this) {
            if(this.failed) {
                return;
            }
            webSocketWriter0 = this.writer;
            if(webSocketWriter0 == null) {
                return;
            }
            v = this.awaitingPong ? this.sentPingCount : -1;
            ++this.sentPingCount;
            this.awaitingPong = true;
        }
        if(v != -1) {
            StringBuilder stringBuilder0 = new StringBuilder("sent ping but didn\'t receive pong within ");
            stringBuilder0.append(this.pingIntervalMillis);
            stringBuilder0.append("ms (after ");
            this.failWebSocket(new SocketTimeoutException(x.g(v - 1, " successful ping/pongs)", stringBuilder0)), null);
            return;
        }
        try {
            webSocketWriter0.writePing(ByteString.EMPTY);
        }
        catch(IOException iOException0) {
            this.failWebSocket(iOException0, null);
        }
    }
}

