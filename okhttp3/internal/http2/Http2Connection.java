package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u00B8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0007\u0018\u0000 \u00BA\u00012\u00020\u0001:\b\u00BB\u0001\u00BA\u0001\u00BC\u0001\u00BD\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\t\u001A\u00020\u0006\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\u0006H\u0000\u00A2\u0006\u0004\b\u000E\u0010\fJ\u0017\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001C\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u00062\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ#\u0010\u001E\u001A\u00020\n2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001E\u0010\u001FJ-\u0010$\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u001A2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000\u00A2\u0006\u0004\b\"\u0010#J/\u0010(\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u001A2\b\u0010&\u001A\u0004\u0018\u00010%2\u0006\u0010\'\u001A\u00020\u0010\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010.\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0000\u00A2\u0006\u0004\b,\u0010-J\u001F\u00101\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010/\u001A\u00020*H\u0000\u00A2\u0006\u0004\b0\u0010-J\u001F\u00105\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u00102\u001A\u00020\u0010H\u0000\u00A2\u0006\u0004\b3\u00104J%\u00109\u001A\u00020\u00122\u0006\u00106\u001A\u00020\u001A2\u0006\u00107\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u0006\u00A2\u0006\u0004\b9\u0010:J\r\u0010;\u001A\u00020\u0012\u00A2\u0006\u0004\b;\u0010<J\r\u00109\u001A\u00020\u0012\u00A2\u0006\u0004\b9\u0010<J\r\u0010=\u001A\u00020\u0012\u00A2\u0006\u0004\b=\u0010<J\r\u0010>\u001A\u00020\u0012\u00A2\u0006\u0004\b>\u0010<J\u0015\u0010?\u001A\u00020\u00122\u0006\u0010/\u001A\u00020*\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\bA\u0010<J)\u0010A\u001A\u00020\u00122\u0006\u0010B\u001A\u00020*2\u0006\u0010C\u001A\u00020*2\b\u0010E\u001A\u0004\u0018\u00010DH\u0000\u00A2\u0006\u0004\bF\u0010GJ#\u0010K\u001A\u00020\u00122\b\b\u0002\u0010H\u001A\u00020\u001A2\b\b\u0002\u0010J\u001A\u00020IH\u0007\u00A2\u0006\u0004\bK\u0010LJ\u0015\u0010O\u001A\u00020\u00122\u0006\u0010N\u001A\u00020M\u00A2\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001A\u00020\u001A2\u0006\u0010Q\u001A\u00020\u0010\u00A2\u0006\u0004\bR\u0010SJ\u000F\u0010U\u001A\u00020\u0012H\u0000\u00A2\u0006\u0004\bT\u0010<J\u0017\u0010X\u001A\u00020\u001A2\u0006\u0010\r\u001A\u00020\u0006H\u0000\u00A2\u0006\u0004\bV\u0010WJ%\u0010[\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0000\u00A2\u0006\u0004\bY\u0010ZJ-\u0010_\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\\\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\b]\u0010^J/\u0010d\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010a\u001A\u00020`2\u0006\u0010\'\u001A\u00020\u00062\u0006\u0010\\\u001A\u00020\u001AH\u0000\u00A2\u0006\u0004\bb\u0010cJ\u001F\u0010f\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0000\u00A2\u0006\u0004\be\u0010-J-\u0010\u001E\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u00062\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b\u001E\u0010\u001DJ\u0019\u0010h\u001A\u00020\u00122\b\u0010g\u001A\u0004\u0018\u00010DH\u0002\u00A2\u0006\u0004\bh\u0010iR\u001A\u0010j\u001A\u00020\u001A8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bj\u0010k\u001A\u0004\bl\u0010mR\u001A\u0010o\u001A\u00020n8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bo\u0010p\u001A\u0004\bq\u0010rR&\u0010t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0s8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bt\u0010u\u001A\u0004\bv\u0010wR\u001A\u0010y\u001A\u00020x8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\by\u0010z\u001A\u0004\b{\u0010|R$\u0010}\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0014\n\u0004\b}\u0010~\u001A\u0004\b\u007F\u0010\b\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\'\u0010\u0082\u0001\u001A\u00020\u00068\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0016\n\u0005\b\u0082\u0001\u0010~\u001A\u0005\b\u0083\u0001\u0010\b\"\u0006\b\u0084\u0001\u0010\u0081\u0001R\u0018\u0010\u0085\u0001\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0085\u0001\u0010kR\u0015\u0010J\u001A\u00020I8\u0002X\u0082\u0004\u00A2\u0006\u0007\n\u0005\bJ\u0010\u0086\u0001R\u0018\u0010\u0088\u0001\u001A\u00030\u0087\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008A\u0001\u001A\u00030\u0087\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u0089\u0001R\u0018\u0010\u008B\u0001\u001A\u00030\u0087\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u0089\u0001R\u0018\u0010\u008D\u0001\u001A\u00030\u008C\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\u0019\u0010\u008F\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0090\u0001R\u0019\u0010\u0092\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0019\u0010\u0093\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R\u0019\u0010\u0095\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0090\u0001R\u0019\u0010\u0096\u0001\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0090\u0001R\u001C\u0010\u0097\u0001\u001A\u00020M8\u0006\u00A2\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001A\u0006\b\u0099\u0001\u0010\u009A\u0001R(\u0010\u009B\u0001\u001A\u00020M8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u009B\u0001\u0010\u0098\u0001\u001A\u0006\b\u009C\u0001\u0010\u009A\u0001\"\u0005\b\u009D\u0001\u0010PR*\u0010\u009F\u0001\u001A\u00020\u00102\u0007\u0010\u009E\u0001\u001A\u00020\u00108\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u009F\u0001\u0010\u0090\u0001\u001A\u0006\b\u00A0\u0001\u0010\u00A1\u0001R*\u0010\u00A2\u0001\u001A\u00020\u00102\u0007\u0010\u009E\u0001\u001A\u00020\u00108\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u00A2\u0001\u0010\u0090\u0001\u001A\u0006\b\u00A3\u0001\u0010\u00A1\u0001R*\u0010\u00A4\u0001\u001A\u00020\u00102\u0007\u0010\u009E\u0001\u001A\u00020\u00108\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u00A4\u0001\u0010\u0090\u0001\u001A\u0006\b\u00A5\u0001\u0010\u00A1\u0001R*\u0010\u00A6\u0001\u001A\u00020\u00102\u0007\u0010\u009E\u0001\u001A\u00020\u00108\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u00A6\u0001\u0010\u0090\u0001\u001A\u0006\b\u00A7\u0001\u0010\u00A1\u0001R \u0010\u00A9\u0001\u001A\u00030\u00A8\u00018\u0000X\u0080\u0004\u00A2\u0006\u0010\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001\u001A\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\u001D\u0010\u00AE\u0001\u001A\u00030\u00AD\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001\u001A\u0006\b\u00B0\u0001\u0010\u00B1\u0001R!\u0010\u00B3\u0001\u001A\u00070\u00B2\u0001R\u00020\u00008\u0006\u00A2\u0006\u0010\n\u0006\b\u00B3\u0001\u0010\u00B4\u0001\u001A\u0006\b\u00B5\u0001\u0010\u00B6\u0001R\u001E\u0010\u00B8\u0001\u001A\t\u0012\u0004\u0012\u00020\u00060\u00B7\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u00B9\u0001\u00A8\u0006\u00BE\u0001"}, d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "", "openStreamCount", "()I", "id", "Lokhttp3/internal/http2/Http2Stream;", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "Lie/H;", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "out", "pushStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "newStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Lokio/Buffer;", "buffer", "byteCount", "writeData", "(IZLokio/Buffer;J)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", "statusCode", "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "Ljava/io/IOException;", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "start", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Lokio/BufferedSource;", "source", "pushDataLater$okhttp", "(ILokio/BufferedSource;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "e", "failConnection", "(Ljava/io/IOException;)V", "client", "Z", "getClient$okhttp", "()Z", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "lastGoodStreamId", "I", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "(I)V", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "isShutdown", "Lokhttp3/internal/concurrent/TaskRunner;", "Lokhttp3/internal/concurrent/TaskQueue;", "writerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "pushQueue", "settingsListenerQueue", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "intervalPingsSent", "J", "intervalPongsReceived", "degradedPingsSent", "degradedPongsReceived", "awaitPingsSent", "awaitPongsReceived", "degradedPongDeadlineNs", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "<set-?>", "readBytesTotal", "getReadBytesTotal", "()J", "readBytesAcknowledged", "getReadBytesAcknowledged", "writeBytesTotal", "getWriteBytesTotal", "writeBytesMaximum", "getWriteBytesMaximum", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "", "currentPushRequests", "Ljava/util/Set;", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http2Connection implements Closeable {
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u00107\u001A\u000208J\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0012J\u000E\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u001EJ.\u0010)\u001A\u00020\u00002\u0006\u0010)\u001A\u00020*2\b\b\u0002\u00109\u001A\u00020\f2\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u0010#\u001A\u00020$H\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u0012X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u0018X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\u001EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u001A\u0010#\u001A\u00020$X\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001A\u0010)\u001A\u00020*X\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001A\u0010/\u001A\u000200X\u0080.¢\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b5\u00106¨\u0006:"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "build", "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        private boolean client;
        public String connectionName;
        @NotNull
        private Listener listener;
        private int pingIntervalMillis;
        @NotNull
        private PushObserver pushObserver;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        @NotNull
        private final TaskRunner taskRunner;

        public Builder(boolean z, @NotNull TaskRunner taskRunner0) {
            q.g(taskRunner0, "taskRunner");
            super();
            this.client = z;
            this.taskRunner = taskRunner0;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String s = this.connectionName;
            if(s != null) {
                return s;
            }
            q.m("connectionName");
            throw null;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink0 = this.sink;
            if(bufferedSink0 != null) {
                return bufferedSink0;
            }
            q.m("sink");
            throw null;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket0 = this.socket;
            if(socket0 != null) {
                return socket0;
            }
            q.m("socket");
            throw null;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource0 = this.source;
            if(bufferedSource0 != null) {
                return bufferedSource0;
            }
            q.m("source");
            throw null;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Builder listener(@NotNull Listener http2Connection$Listener0) {
            q.g(http2Connection$Listener0, "listener");
            this.listener = http2Connection$Listener0;
            return this;
        }

        @NotNull
        public final Builder pingIntervalMillis(int v) {
            this.pingIntervalMillis = v;
            return this;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver0) {
            q.g(pushObserver0, "pushObserver");
            this.pushObserver = pushObserver0;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(@NotNull String s) {
            q.g(s, "<set-?>");
            this.connectionName = s;
        }

        public final void setListener$okhttp(@NotNull Listener http2Connection$Listener0) {
            q.g(http2Connection$Listener0, "<set-?>");
            this.listener = http2Connection$Listener0;
        }

        public final void setPingIntervalMillis$okhttp(int v) {
            this.pingIntervalMillis = v;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver0) {
            q.g(pushObserver0, "<set-?>");
            this.pushObserver = pushObserver0;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink0) {
            q.g(bufferedSink0, "<set-?>");
            this.sink = bufferedSink0;
        }

        public final void setSocket$okhttp(@NotNull Socket socket0) {
            q.g(socket0, "<set-?>");
            this.socket = socket0;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource0) {
            q.g(bufferedSource0, "<set-?>");
            this.source = bufferedSource0;
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket0) {
            q.g(socket0, "socket");
            return Builder.socket$default(this, socket0, null, null, null, 14, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket0, @NotNull String s) {
            q.g(socket0, "socket");
            q.g(s, "peerName");
            return Builder.socket$default(this, socket0, s, null, null, 12, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket0, @NotNull String s, @NotNull BufferedSource bufferedSource0) {
            q.g(socket0, "socket");
            q.g(s, "peerName");
            q.g(bufferedSource0, "source");
            return Builder.socket$default(this, socket0, s, bufferedSource0, null, 8, null);
        }

        @NotNull
        public final Builder socket(@NotNull Socket socket0, @NotNull String s, @NotNull BufferedSource bufferedSource0, @NotNull BufferedSink bufferedSink0) {
            q.g(socket0, "socket");
            q.g(s, "peerName");
            q.g(bufferedSource0, "source");
            q.g(bufferedSink0, "sink");
            this.setSocket$okhttp(socket0);
            this.setConnectionName$okhttp((this.client ? "OkHttp" + ' ' + s : "MockWebServer " + s));
            this.setSource$okhttp(bufferedSource0);
            this.setSink$okhttp(bufferedSink0);
            return this;
        }

        public static Builder socket$default(Builder http2Connection$Builder0, Socket socket0, String s, BufferedSource bufferedSource0, BufferedSink bufferedSink0, int v, Object object0) {
            if((v & 2) != 0) {
                s = Util.peerName(socket0);
            }
            if((v & 4) != 0) {
                bufferedSource0 = Okio.buffer(Okio.source(socket0));
            }
            if((v & 8) != 0) {
                bufferedSink0 = Okio.buffer(Okio.sink(socket0));
            }
            return http2Connection$Builder0.socket(socket0, s, bufferedSource0, bufferedSink0);
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "<init>", "()V", "Lokhttp3/internal/http2/Http2Stream;", "stream", "Lie/H;", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class Listener {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class okhttp3.internal.http2.Http2Connection.Listener.Companion {
            private okhttp3.internal.http2.Http2Connection.Listener.Companion() {
            }

            public okhttp3.internal.http2.Http2Connection.Listener.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final okhttp3.internal.http2.Http2Connection.Listener.Companion Companion;
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS;

        static {
            Listener.Companion = new okhttp3.internal.http2.Http2Connection.Listener.Companion(null);
            Listener.REFUSE_INCOMING_STREAMS = new Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1();
        }

        public void onSettings(@NotNull Http2Connection http2Connection0, @NotNull Settings settings0) {
            q.g(http2Connection0, "connection");
            q.g(settings0, "settings");
        }

        public abstract void onStream(@NotNull Http2Stream arg1);
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0003H\u0096\u0002\u00A2\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\f2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001B\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u001D\u0010!\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b!\u0010 J\u000F\u0010\"\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b\"\u0010\tJ\'\u0010&\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\n2\u0006\u0010$\u001A\u00020\f2\u0006\u0010%\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b&\u0010\'J\'\u0010+\u001A\u00020\u00032\u0006\u0010(\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010/\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u0010.\u001A\u00020-H\u0016\u00A2\u0006\u0004\b/\u00100J/\u00104\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u00101\u001A\u00020\f2\u0006\u00102\u001A\u00020\f2\u0006\u00103\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b4\u00105J-\u00108\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u00106\u001A\u00020\f2\f\u00107\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016\u00A2\u0006\u0004\b8\u00109J?\u0010@\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u0010;\u001A\u00020:2\u0006\u0010<\u001A\u00020)2\u0006\u0010=\u001A\u00020:2\u0006\u0010>\u001A\u00020\f2\u0006\u0010?\u001A\u00020-H\u0016\u00A2\u0006\u0004\b@\u0010AR\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010B\u001A\u0004\bC\u0010D\u00A8\u0006E"}, d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "Lie/H;", "Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "invoke", "()V", "", "inFinished", "", "streamId", "Lokio/BufferedSource;", "source", "length", "data", "(ZILokio/BufferedSource;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Lokio/ByteString;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class ReaderRunnable implements Handler, a {
        @NotNull
        private final Http2Reader reader;

        public ReaderRunnable(@NotNull Http2Reader http2Reader0) {
            q.g(http2Reader0, "reader");
            Http2Connection.this = http2Connection0;
            super();
            this.reader = http2Reader0;
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void ackSettings() {
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void alternateService(int v, @NotNull String s, @NotNull ByteString byteString0, @NotNull String s1, int v1, long v2) {
            q.g(s, "origin");
            q.g(byteString0, "protocol");
            q.g(s1, "host");
        }

        public final void applyAndAckSettings(boolean z, @NotNull Settings settings0) {
            Http2Stream[] arr_http2Stream;
            long v2;
            q.g(settings0, "settings");
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            Http2Writer http2Writer0 = Http2Connection.this.getWriter();
            Http2Connection http2Connection0 = Http2Connection.this;
            synchronized(http2Writer0) {
                synchronized(http2Connection0) {
                    Settings settings1 = http2Connection0.getPeerSettings();
                    if(!z) {
                        Settings settings2 = new Settings();
                        settings2.merge(settings1);
                        settings2.merge(settings0);
                        settings0 = settings2;
                    }
                    h0.a = settings0;
                    v2 = ((long)settings0.getInitialWindowSize()) - ((long)settings1.getInitialWindowSize());
                    arr_http2Stream = Long.compare(v2, 0L) == 0 || http2Connection0.getStreams$okhttp().isEmpty() ? null : ((Http2Stream[])http2Connection0.getStreams$okhttp().values().toArray(new Http2Stream[0]));
                    http2Connection0.setPeerSettings(((Settings)h0.a));
                    http2Connection0.settingsListenerQueue.schedule(new Task(true, http2Connection0) {
                        @Override  // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            h0.getListener$okhttp().onSettings(h0, ((Settings)this.$newPeerSettings$inlined.a));
                            return -1L;
                        }
                    }, 0L);
                }
                try {
                    http2Connection0.getWriter().applyAndAckSettings(((Settings)h0.a));
                }
                catch(IOException iOException0) {
                    http2Connection0.failConnection(iOException0);
                }
            }
            if(arr_http2Stream != null) {
                for(int v3 = 0; v3 < arr_http2Stream.length; ++v3) {
                    Http2Stream http2Stream0 = arr_http2Stream[v3];
                    synchronized(http2Stream0) {
                        http2Stream0.addBytesToWriteWindow(v2);
                    }
                }
            }
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void data(boolean z, int v, @NotNull BufferedSource bufferedSource0, int v1) {
            q.g(bufferedSource0, "source");
            if(Http2Connection.this.pushedStream$okhttp(v)) {
                Http2Connection.this.pushDataLater$okhttp(v, bufferedSource0, v1, z);
                return;
            }
            Http2Stream http2Stream0 = Http2Connection.this.getStream(v);
            if(http2Stream0 == null) {
                Http2Connection.this.writeSynResetLater$okhttp(v, ErrorCode.PROTOCOL_ERROR);
                Http2Connection.this.updateConnectionFlowControl$okhttp(((long)v1));
                bufferedSource0.skip(((long)v1));
                return;
            }
            http2Stream0.receiveData(bufferedSource0, v1);
            if(z) {
                http2Stream0.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void goAway(int v, @NotNull ErrorCode errorCode0, @NotNull ByteString byteString0) {
            Object[] arr_object;
            q.g(errorCode0, "errorCode");
            q.g(byteString0, "debugData");
            byteString0.size();
            synchronized(Http2Connection.this) {
                arr_object = Http2Connection.this.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                Http2Connection.this.isShutdown = true;
            }
            for(int v2 = 0; v2 < ((Http2Stream[])arr_object).length; ++v2) {
                Http2Stream http2Stream0 = ((Http2Stream[])arr_object)[v2];
                if(http2Stream0.getId() > v && http2Stream0.isLocallyInitiated()) {
                    http2Stream0.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream$okhttp(http2Stream0.getId());
                }
            }
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void headers(boolean z, int v, int v1, @NotNull List list0) {
            Http2Stream http2Stream0;
            q.g(list0, "headerBlock");
            if(Http2Connection.this.pushedStream$okhttp(v)) {
                Http2Connection.this.pushHeadersLater$okhttp(v, list0, z);
                return;
            }
            Http2Connection http2Connection0 = Http2Connection.this;
            synchronized(http2Connection0) {
                http2Stream0 = http2Connection0.getStream(v);
                if(http2Stream0 == null) {
                    if(http2Connection0.isShutdown) {
                        return;
                    }
                    if(v <= http2Connection0.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if(v % 2 == http2Connection0.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    Http2Stream http2Stream1 = new Http2Stream(v, http2Connection0, false, z, Util.toHeaders(list0));
                    http2Connection0.setLastGoodStreamId$okhttp(v);
                    http2Connection0.getStreams$okhttp().put(v, http2Stream1);
                    http2Connection0.taskRunner.newQueue().schedule(new Task(true, http2Connection0) {
                        @Override  // okhttp3.internal.concurrent.Task
                        public long runOnce() {
                            try {
                                http2Stream1.getListener$okhttp().onStream(this.$newStream$inlined);
                            }
                            catch(IOException iOException0) {
                                Platform.Companion.get().log("Http2Connection.Listener failure for " + http2Stream1.getConnectionName$okhttp(), 4, iOException0);
                                try {
                                    this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, iOException0);
                                }
                                catch(IOException unused_ex) {
                                }
                            }
                            return -1L;
                        }
                    }, 0L);
                    return;
                }
            }
            http2Stream0.receiveHeaders(Util.toHeaders(list0), z);
        }

        @Override  // we.a
        public Object invoke() {
            this.invoke();
            return ie.H.a;
        }

        public void invoke() {
            ErrorCode errorCode0;
            try {
                errorCode0 = ErrorCode.INTERNAL_ERROR;
                this.reader.readConnectionPreface(this);
                while(this.reader.nextFrame(false, this)) {
                }
            }
            catch(IOException iOException0) {
                Http2Connection.this.close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException0);
                Util.closeQuietly(this.reader);
                return;
            }
            catch(Throwable throwable0) {
                Http2Connection.this.close$okhttp(errorCode0, errorCode0, null);
                Util.closeQuietly(this.reader);
                throw throwable0;
            }
            Http2Connection.this.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
            Util.closeQuietly(this.reader);
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void ping(boolean z, int v, int v1) {
            if(z) {
                Http2Connection http2Connection0 = Http2Connection.this;
                synchronized(http2Connection0) {
                    switch(v) {
                        case 1: {
                            ++http2Connection0.intervalPongsReceived;
                            break;
                        }
                        case 2: {
                            ++http2Connection0.degradedPongsReceived;
                            break;
                        }
                        case 3: {
                            ++http2Connection0.awaitPongsReceived;
                            q.e(http2Connection0, "null cannot be cast to non-null type java.lang.Object");
                            http2Connection0.notifyAll();
                        }
                    }
                }
                return;
            }
            okhttp3.internal.http2.Http2Connection.ReaderRunnable.ping..inlined.execute.default.1 http2Connection$ReaderRunnable$ping$$inlined$execute$default$10 = new Task(true, Http2Connection.this) {
                @Override  // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    v.writePing(true, v1, this.$payload2$inlined);
                    return -1L;
                }
            };
            Http2Connection.this.writerQueue.schedule(http2Connection$ReaderRunnable$ping$$inlined$execute$default$10, 0L);
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void priority(int v, int v1, int v2, boolean z) {
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void pushPromise(int v, int v1, @NotNull List list0) {
            q.g(list0, "requestHeaders");
            Http2Connection.this.pushRequestLater$okhttp(v1, list0);
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void rstStream(int v, @NotNull ErrorCode errorCode0) {
            q.g(errorCode0, "errorCode");
            if(Http2Connection.this.pushedStream$okhttp(v)) {
                Http2Connection.this.pushResetLater$okhttp(v, errorCode0);
                return;
            }
            Http2Stream http2Stream0 = Http2Connection.this.removeStream$okhttp(v);
            if(http2Stream0 != null) {
                http2Stream0.receiveRstStream(errorCode0);
            }
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void settings(boolean z, @NotNull Settings settings0) {
            q.g(settings0, "settings");
            okhttp3.internal.http2.Http2Connection.ReaderRunnable.settings..inlined.execute.default.1 http2Connection$ReaderRunnable$settings$$inlined$execute$default$10 = new Task(true, this) {
                @Override  // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    z.applyAndAckSettings(settings0, this.$settings$inlined);
                    return -1L;
                }
            };
            Http2Connection.this.writerQueue.schedule(http2Connection$ReaderRunnable$settings$$inlined$execute$default$10, 0L);
        }

        @Override  // okhttp3.internal.http2.Http2Reader$Handler
        public void windowUpdate(int v, long v1) {
            if(v == 0) {
                synchronized(Http2Connection.this) {
                    Http2Connection.this.writeBytesMaximum = Http2Connection.this.getWriteBytesMaximum() + v1;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream http2Stream0 = Http2Connection.this.getStream(v);
            if(http2Stream0 != null) {
                synchronized(http2Stream0) {
                    http2Stream0.addBytesToWriteWindow(v1);
                }
            }
        }
    }

    public static final int AWAIT_PING = 3;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final Settings DEFAULT_SETTINGS = null;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    @NotNull
    private final String connectionName;
    @NotNull
    private final Set currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    @NotNull
    private final Listener listener;
    private int nextStreamId;
    @NotNull
    private final Settings okHttpSettings;
    @NotNull
    private Settings peerSettings;
    @NotNull
    private final PushObserver pushObserver;
    @NotNull
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    @NotNull
    private final ReaderRunnable readerRunnable;
    @NotNull
    private final TaskQueue settingsListenerQueue;
    @NotNull
    private final Socket socket;
    @NotNull
    private final Map streams;
    @NotNull
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    @NotNull
    private final Http2Writer writer;
    @NotNull
    private final TaskQueue writerQueue;

    static {
        Http2Connection.Companion = new Companion(null);
        Settings settings0 = new Settings();
        settings0.set(7, 0xFFFF);
        settings0.set(5, 0x4000);
        Http2Connection.DEFAULT_SETTINGS = settings0;
    }

    public Http2Connection(@NotNull Builder http2Connection$Builder0) {
        q.g(http2Connection$Builder0, "builder");
        super();
        boolean z = http2Connection$Builder0.getClient$okhttp();
        this.client = z;
        this.listener = http2Connection$Builder0.getListener$okhttp();
        this.streams = new LinkedHashMap();
        String s = http2Connection$Builder0.getConnectionName$okhttp();
        this.connectionName = s;
        this.nextStreamId = http2Connection$Builder0.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner0 = http2Connection$Builder0.getTaskRunner$okhttp();
        this.taskRunner = taskRunner0;
        TaskQueue taskQueue0 = taskRunner0.newQueue();
        this.writerQueue = taskQueue0;
        this.pushQueue = taskRunner0.newQueue();
        this.settingsListenerQueue = taskRunner0.newQueue();
        this.pushObserver = http2Connection$Builder0.getPushObserver$okhttp();
        Settings settings0 = new Settings();
        if(http2Connection$Builder0.getClient$okhttp()) {
            settings0.set(7, 0x1000000);
        }
        this.okHttpSettings = settings0;
        this.peerSettings = Http2Connection.DEFAULT_SETTINGS;
        this.writeBytesMaximum = (long)Http2Connection.DEFAULT_SETTINGS.getInitialWindowSize();
        this.socket = http2Connection$Builder0.getSocket$okhttp();
        this.writer = new Http2Writer(http2Connection$Builder0.getSink$okhttp(), z);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(http2Connection$Builder0.getSource$okhttp(), z));
        this.currentPushRequests = new LinkedHashSet();
        if(http2Connection$Builder0.getPingIntervalMillis$okhttp() != 0) {
            long v = TimeUnit.MILLISECONDS.toNanos(((long)http2Connection$Builder0.getPingIntervalMillis$okhttp()));
            taskQueue0.schedule(new Task(this, v) {
                final long $pingIntervalNanos$inlined;

                {
                    Http2Connection.this = http2Connection0;
                    this.$pingIntervalNanos$inlined = v;
                    super(s, false, 2, null);
                }

                @Override  // okhttp3.internal.concurrent.Task
                public long runOnce() {
                    boolean z;
                    synchronized(Http2Connection.this) {
                        if(Long.compare(Http2Connection.this.intervalPongsReceived, Http2Connection.this.intervalPingsSent) < 0) {
                            z = true;
                        }
                        else {
                            Http2Connection.access$setIntervalPingsSent$p(Http2Connection.this, Http2Connection.this.intervalPingsSent + 1L);
                            z = false;
                        }
                    }
                    if(z) {
                        Http2Connection.this.failConnection(null);
                        return -1L;
                    }
                    Http2Connection.this.writePing(false, 1, 0);
                    return this.$pingIntervalNanos$inlined;
                }
            }, v);
        }
    }

    public static final void access$setIntervalPingsSent$p(Http2Connection http2Connection0, long v) {
        http2Connection0.intervalPingsSent = v;
    }

    public final void awaitPong() {
        synchronized(this) {
            while(this.awaitPongsReceived < this.awaitPingsSent) {
                this.wait();
            }
        }
    }

    @Override
    public void close() {
        this.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(@NotNull ErrorCode errorCode0, @NotNull ErrorCode errorCode1, @Nullable IOException iOException0) {
        Object[] arr_object;
        q.g(errorCode0, "connectionCode");
        q.g(errorCode1, "streamCode");
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2512 MUST NOT hold lock on " + this);
        }
        try {
            this.shutdown(errorCode0);
        }
        catch(IOException unused_ex) {
        }
        synchronized(this) {
            if(this.streams.isEmpty()) {
                arr_object = null;
            }
            else {
                arr_object = this.streams.values().toArray(new Http2Stream[0]);
                this.streams.clear();
            }
        }
        if(((Http2Stream[])arr_object) != null) {
            for(int v = 0; v < ((Http2Stream[])arr_object).length; ++v) {
                Http2Stream http2Stream0 = ((Http2Stream[])arr_object)[v];
                try {
                    http2Stream0.close(errorCode1, iOException0);
                }
                catch(IOException unused_ex) {
                }
            }
        }
        try {
            this.writer.close();
        }
        catch(IOException unused_ex) {
        }
        try {
            this.socket.close();
        }
        catch(IOException unused_ex) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    private final void failConnection(IOException iOException0) {
        this.close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException0);
    }

    public final void flush() {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Nullable
    public final Http2Stream getStream(int v) {
        synchronized(this) {
            return (Http2Stream)this.streams.get(v);
        }
    }

    @NotNull
    public final Map getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final boolean isHealthy(long v) {
        synchronized(this) {
            if(this.isShutdown) {
                return false;
            }
            if(this.degradedPongsReceived < this.degradedPingsSent && v >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    private final Http2Stream newStream(int v, List list0, boolean z) {
        Http2Stream http2Stream0;
        int v2;
        Throwable throwable1;
        synchronized(this.writer) {
            __monitor_enter(this);
            try {
                if(this.nextStreamId > 0x3FFFFFFF) {
                    this.shutdown(ErrorCode.REFUSED_STREAM);
                }
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                __monitor_exit(this);
                throw throwable1;
            }
            try {
                if(this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                v2 = this.nextStreamId;
                this.nextStreamId = v2 + 2;
                http2Stream0 = new Http2Stream(v2, this, !z, false, null);
                boolean z1 = !z || this.writeBytesTotal >= this.writeBytesMaximum || http2Stream0.getWriteBytesTotal() >= http2Stream0.getWriteBytesMaximum();
                if(http2Stream0.isOpen()) {
                    this.streams.put(v2, http2Stream0);
                }
            }
            catch(Throwable throwable2) {
                throwable1 = throwable2;
                __monitor_exit(this);
                throw throwable1;
            }
            __monitor_exit(this);
            boolean z2 = false;
            if(v == 0) {
                z2 = true;
                this.writer.headers(!z, v2, list0);
            }
            else if(!this.client) {
                z2 = true;
                this.writer.pushPromise(v, v2, list0);
            }
            if(z2) {
                if(z1) {
                    this.writer.flush();
                }
                return http2Stream0;
            }
        }
        throw new IllegalArgumentException("client streams shouldn\'t have associated stream IDs");
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List list0, boolean z) {
        q.g(list0, "requestHeaders");
        return this.newStream(0, list0, z);
    }

    public final int openStreamCount() {
        synchronized(this) {
        }
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(int v, @NotNull BufferedSource bufferedSource0, int v1, boolean z) {
        q.g(bufferedSource0, "source");
        Buffer buffer0 = new Buffer();
        bufferedSource0.require(((long)v1));
        bufferedSource0.read(buffer0, ((long)v1));
        okhttp3.internal.http2.Http2Connection.pushDataLater..inlined.execute.default.1 http2Connection$pushDataLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    boolean z = v.pushObserver.onData(buffer0, v1, z, this.$inFinished$inlined);
                    if(z) {
                        v.getWriter().rstStream(buffer0, ErrorCode.CANCEL);
                    }
                    if(z || this.$inFinished$inlined) {
                        synchronized(v) {
                            v.currentPushRequests.remove(buffer0);
                            return -1L;
                        }
                    }
                }
                catch(IOException unused_ex) {
                }
                return -1L;
            }
        };
        this.pushQueue.schedule(http2Connection$pushDataLater$$inlined$execute$default$10, 0L);
    }

    public final void pushHeadersLater$okhttp(int v, @NotNull List list0, boolean z) {
        q.g(list0, "requestHeaders");
        okhttp3.internal.http2.Http2Connection.pushHeadersLater..inlined.execute.default.1 http2Connection$pushHeadersLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z = v.pushObserver.onHeaders(list0, z, this.$inFinished$inlined);
                try {
                    if(z) {
                        v.getWriter().rstStream(list0, ErrorCode.CANCEL);
                    }
                    if(z || this.$inFinished$inlined) {
                        synchronized(v) {
                            v.currentPushRequests.remove(list0);
                            return -1L;
                        }
                    }
                }
                catch(IOException unused_ex) {
                }
                return -1L;
            }
        };
        this.pushQueue.schedule(http2Connection$pushHeadersLater$$inlined$execute$default$10, 0L);
    }

    public final void pushRequestLater$okhttp(int v, @NotNull List list0) {
        Throwable throwable1;
        q.g(list0, "requestHeaders");
        __monitor_enter(this);
        try {
            if(!this.currentPushRequests.contains(v)) {
                this.currentPushRequests.add(v);
                goto label_8;
            }
            goto label_12;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            __monitor_exit(this);
            throw throwable1;
        }
    label_8:
        __monitor_exit(this);
        okhttp3.internal.http2.Http2Connection.pushRequestLater..inlined.execute.default.1 http2Connection$pushRequestLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                if(v.pushObserver.onRequest(list0, this.$requestHeaders$inlined)) {
                    try {
                        v.getWriter().rstStream(list0, ErrorCode.CANCEL);
                        synchronized(v) {
                            v.currentPushRequests.remove(list0);
                            return -1L;
                        }
                    }
                    catch(IOException unused_ex) {
                    }
                }
                return -1L;
            }
        };
        this.pushQueue.schedule(http2Connection$pushRequestLater$$inlined$execute$default$10, 0L);
        return;
        try {
        label_12:
            this.writeSynResetLater$okhttp(v, ErrorCode.PROTOCOL_ERROR);
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            __monitor_exit(this);
            throw throwable1;
        }
        __monitor_exit(this);
    }

    public final void pushResetLater$okhttp(int v, @NotNull ErrorCode errorCode0) {
        q.g(errorCode0, "errorCode");
        okhttp3.internal.http2.Http2Connection.pushResetLater..inlined.execute.default.1 http2Connection$pushResetLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                v.pushObserver.onReset(errorCode0, this.$errorCode$inlined);
                synchronized(v) {
                    v.currentPushRequests.remove(errorCode0);
                    return -1L;
                }
            }
        };
        this.pushQueue.schedule(http2Connection$pushResetLater$$inlined$execute$default$10, 0L);
    }

    @NotNull
    public final Http2Stream pushStream(int v, @NotNull List list0, boolean z) {
        q.g(list0, "requestHeaders");
        if(this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return this.newStream(v, list0, z);
    }

    public final boolean pushedStream$okhttp(int v) {
        return v != 0 && (v & 1) == 0;
    }

    @Nullable
    public final Http2Stream removeStream$okhttp(int v) {
        synchronized(this) {
            Http2Stream http2Stream0 = (Http2Stream)this.streams.remove(v);
            this.notifyAll();
            return http2Stream0;
        }
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized(this) {
            long v = this.degradedPingsSent;
            if(this.degradedPongsReceived < v) {
                return;
            }
            this.degradedPingsSent = v + 1L;
            this.degradedPongDeadlineNs = System.nanoTime() + 1000000000L;
        }
        okhttp3.internal.http2.Http2Connection.sendDegradedPingLater..inlined.execute.default.1 http2Connection$sendDegradedPingLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                Http2Connection.this.writePing(false, 2, 0);
                return -1L;
            }
        };
        this.writerQueue.schedule(http2Connection$sendDegradedPingLater$$inlined$execute$default$10, 0L);
    }

    public final void setLastGoodStreamId$okhttp(int v) {
        this.lastGoodStreamId = v;
    }

    public final void setNextStreamId$okhttp(int v) {
        this.nextStreamId = v;
    }

    public final void setPeerSettings(@NotNull Settings settings0) {
        q.g(settings0, "<set-?>");
        this.peerSettings = settings0;
    }

    public final void setSettings(@NotNull Settings settings0) {
        q.g(settings0, "settings");
        synchronized(this.writer) {
            synchronized(this) {
                if(this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings0);
            }
            this.writer.settings(settings0);
        }
    }

    public final void shutdown(@NotNull ErrorCode errorCode0) {
        q.g(errorCode0, "statusCode");
        synchronized(this.writer) {
            synchronized(this) {
                if(this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
            }
            this.writer.goAway(this.lastGoodStreamId, errorCode0, Util.EMPTY_BYTE_ARRAY);
        }
    }

    public final void start() {
        Http2Connection.start$default(this, false, null, 3, null);
    }

    public final void start(boolean z) {
        Http2Connection.start$default(this, z, null, 2, null);
    }

    public final void start(boolean z, @NotNull TaskRunner taskRunner0) {
        q.g(taskRunner0, "taskRunner");
        if(z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int v = this.okHttpSettings.getInitialWindowSize();
            if(v != 0xFFFF) {
                this.writer.windowUpdate(0, ((long)(v - 0xFFFF)));
            }
        }
        taskRunner0.newQueue().schedule(new okhttp3.internal.concurrent.TaskQueue.execute.1(this.connectionName, true, this.readerRunnable), 0L);
    }

    public static void start$default(Http2Connection http2Connection0, boolean z, TaskRunner taskRunner0, int v, Object object0) {
        if((v & 1) != 0) {
            z = true;
        }
        if((v & 2) != 0) {
            taskRunner0 = TaskRunner.INSTANCE;
        }
        http2Connection0.start(z, taskRunner0);
    }

    public final void updateConnectionFlowControl$okhttp(long v) {
        synchronized(this) {
            long v2 = this.readBytesTotal + v;
            this.readBytesTotal = v2;
            long v3 = v2 - this.readBytesAcknowledged;
            if(v3 >= ((long)(this.okHttpSettings.getInitialWindowSize() / 2))) {
                this.writeWindowUpdateLater$okhttp(0, v3);
                this.readBytesAcknowledged += v3;
            }
        }
    }

    public final void writeData(int v, boolean z, @Nullable Buffer buffer0, long v1) {
        long v4;
        long v3;
        if(Long.compare(v1, 0L) == 0) {
            this.writer.data(z, v, buffer0, 0);
            return;
        }
        while(v1 > 0L) {
            synchronized(this) {
                try {
                    while(true) {
                        v3 = this.writeBytesTotal;
                        v4 = this.writeBytesMaximum;
                        if(v3 < v4) {
                            break;
                        }
                        if(!this.streams.containsKey(v)) {
                            throw new IOException("stream closed");
                        }
                        this.wait();
                    }
                }
                catch(InterruptedException unused_ex) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
            int v5 = Math.min(((int)Math.min(v1, v4 - v3)), this.writer.maxDataLength());
            this.writeBytesTotal += (long)v5;
            v1 -= (long)v5;
            this.writer.data(z && v1 == 0L, v, buffer0, v5);
        }
    }

    public final void writeHeaders$okhttp(int v, boolean z, @NotNull List list0) {
        q.g(list0, "alternating");
        this.writer.headers(z, v, list0);
    }

    public final void writePing() {
        synchronized(this) {
            ++this.awaitPingsSent;
        }
        this.writePing(false, 3, 0x4F4B6F6B);
    }

    public final void writePing(boolean z, int v, int v1) {
        try {
            this.writer.ping(z, v, v1);
        }
        catch(IOException iOException0) {
            this.failConnection(iOException0);
        }
    }

    public final void writePingAndAwaitPong() {
        this.writePing();
        this.awaitPong();
    }

    public final void writeSynReset$okhttp(int v, @NotNull ErrorCode errorCode0) {
        q.g(errorCode0, "statusCode");
        this.writer.rstStream(v, errorCode0);
    }

    public final void writeSynResetLater$okhttp(int v, @NotNull ErrorCode errorCode0) {
        q.g(errorCode0, "errorCode");
        okhttp3.internal.http2.Http2Connection.writeSynResetLater..inlined.execute.default.1 http2Connection$writeSynResetLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    v.writeSynReset$okhttp(errorCode0, this.$errorCode$inlined);
                }
                catch(IOException iOException0) {
                    v.failConnection(iOException0);
                }
                return -1L;
            }
        };
        this.writerQueue.schedule(http2Connection$writeSynResetLater$$inlined$execute$default$10, 0L);
    }

    public final void writeWindowUpdateLater$okhttp(int v, long v1) {
        okhttp3.internal.http2.Http2Connection.writeWindowUpdateLater..inlined.execute.default.1 http2Connection$writeWindowUpdateLater$$inlined$execute$default$10 = new Task(true, this) {
            @Override  // okhttp3.internal.concurrent.Task
            public long runOnce() {
                try {
                    v.getWriter().windowUpdate(v1, this.$unacknowledgedBytesRead$inlined);
                }
                catch(IOException iOException0) {
                    v.failConnection(iOException0);
                }
                return -1L;
            }
        };
        this.writerQueue.schedule(http2Connection$writeWindowUpdateLater$$inlined$execute$default$10, 0L);
    }
}

