package okhttp3.internal.connection;

import Tf.p;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u00EE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00A0\u00012\u00020\u00012\u00020\u0002:\u0002\u00A0\u0001B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\f\u001A\u00020\tH\u0000\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\u000E\u001A\u00020\tH\u0000\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u0010\u001A\u00020\tH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u000BJE\u0010\u001C\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\'\u0010$\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\u001E2\u000E\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 H\u0000\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010,\u001A\u00020)2\u0006\u0010&\u001A\u00020%2\u0006\u0010(\u001A\u00020\'H\u0000\u00A2\u0006\u0004\b*\u0010+J\u0017\u00102\u001A\u00020/2\u0006\u0010.\u001A\u00020-H\u0000\u00A2\u0006\u0004\b0\u00101J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u00103J\r\u00104\u001A\u00020\t\u00A2\u0006\u0004\b4\u0010\u000BJ\u000F\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b6\u00107J\u0015\u00109\u001A\u00020\u00162\u0006\u00108\u001A\u00020\u0016\u00A2\u0006\u0004\b9\u0010:J\u0017\u0010=\u001A\u00020\t2\u0006\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010C\u001A\u00020\t2\u0006\u0010@\u001A\u00020?2\u0006\u0010B\u001A\u00020AH\u0016\u00A2\u0006\u0004\bC\u0010DJ\u0011\u0010F\u001A\u0004\u0018\u00010EH\u0016\u00A2\u0006\u0004\bF\u0010GJ\'\u0010M\u001A\u00020\t2\u0006\u0010&\u001A\u00020%2\u0006\u0010H\u001A\u00020\u00052\u0006\u0010J\u001A\u00020IH\u0000\u00A2\u0006\u0004\bK\u0010LJ!\u0010R\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020N2\b\u0010O\u001A\u0004\u0018\u00010IH\u0000\u00A2\u0006\u0004\bP\u0010QJ\u000F\u0010T\u001A\u00020SH\u0016\u00A2\u0006\u0004\bT\u0010UJ\u000F\u0010W\u001A\u00020VH\u0016\u00A2\u0006\u0004\bW\u0010XJ7\u0010Y\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\bY\u0010ZJ/\u0010[\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b[\u0010\\J/\u0010_\u001A\u00020\t2\u0006\u0010^\u001A\u00020]2\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b_\u0010`J\u0017\u0010a\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001A\u00020\t2\u0006\u0010^\u001A\u00020]H\u0002\u00A2\u0006\u0004\bc\u0010dJ1\u0010i\u001A\u0004\u0018\u00010e2\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010f\u001A\u00020e2\u0006\u0010h\u001A\u00020gH\u0002\u00A2\u0006\u0004\bi\u0010jJ\u000F\u0010k\u001A\u00020eH\u0002\u00A2\u0006\u0004\bk\u0010lJ\u001D\u0010n\u001A\u00020\u00162\f\u0010m\u001A\b\u0012\u0004\u0012\u00020\u00050 H\u0002\u00A2\u0006\u0004\bn\u0010oJ\u0017\u0010p\u001A\u00020\u00162\u0006\u0010h\u001A\u00020gH\u0002\u00A2\u0006\u0004\bp\u0010qJ\u001F\u0010r\u001A\u00020\u00162\u0006\u0010h\u001A\u00020g2\u0006\u0010F\u001A\u00020EH\u0002\u00A2\u0006\u0004\br\u0010sR\u0017\u0010\u0004\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010t\u001A\u0004\bu\u0010vR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010wR\u0018\u0010x\u001A\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u00106\u001A\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u0010yR\u0018\u0010F\u001A\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010zR\u0018\u0010T\u001A\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010{R\u0018\u0010|\u001A\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b|\u0010}R\u0019\u0010\u007F\u001A\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u007F\u0010\u0080\u0001R\u001C\u0010\u0082\u0001\u001A\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\'\u0010\f\u001A\u00020\u00168\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0005\b\f\u0010\u0084\u0001\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u000E\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u000E\u0010\u0084\u0001R(\u0010\u0089\u0001\u001A\u00020\u00118\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0017\n\u0006\b\u0089\u0001\u0010\u008A\u0001\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001\"\u0005\b\u008D\u0001\u0010bR\u0019\u0010\u008E\u0001\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008E\u0001\u0010\u008A\u0001R\u0019\u0010\u008F\u0001\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u008A\u0001R\u0019\u0010\u0090\u0001\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0090\u0001\u0010\u008A\u0001R*\u0010\u0093\u0001\u001A\u0010\u0012\u000B\u0012\t\u0012\u0004\u0012\u00020N0\u0092\u00010\u0091\u00018\u0006\u00A2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001A\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u0098\u0001\u001A\u00030\u0097\u00018\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001A\u0006\b\u009A\u0001\u0010\u009B\u0001\"\u0006\b\u009C\u0001\u0010\u009D\u0001R\u0017\u0010\u009F\u0001\u001A\u00020\u00168@X\u0080\u0004\u00A2\u0006\b\u001A\u0006\b\u009E\u0001\u0010\u0086\u0001\u00A8\u0006\u00A1\u0001"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "Lie/H;", "noNewExchanges$okhttp", "()V", "noNewExchanges", "noCoalescedConnections$okhttp", "noCoalescedConnections", "incrementSuccessCount$okhttp", "incrementSuccessCount", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "eventListener", "connect", "(IIIIZLokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/Address;", "address", "", "routes", "isEligible$okhttp", "(Lokhttp3/Address;Ljava/util/List;)Z", "isEligible", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/Route;", "cancel", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Lokhttp3/Handshake;", "handshake", "()Lokhttp3/Handshake;", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/Route;Ljava/io/IOException;)V", "connectFailed", "Lokhttp3/internal/connection/RealCall;", "e", "trackFailure$okhttp", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "trackFailure", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "", "toString", "()Ljava/lang/String;", "connectTunnel", "(IIILokhttp3/Call;Lokhttp3/EventListener;)V", "connectSocket", "(IILokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectionSpecSelector", "establishProtocol", "(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/EventListener;)V", "startHttp2", "(I)V", "connectTls", "(Lokhttp3/internal/connection/ConnectionSpecSelector;)V", "Lokhttp3/Request;", "tunnelRequest", "Lokhttp3/HttpUrl;", "url", "createTunnel", "(IILokhttp3/Request;Lokhttp3/HttpUrl;)Lokhttp3/Request;", "createTunnelRequest", "()Lokhttp3/Request;", "candidates", "routeMatchesAny", "(Ljava/util/List;)Z", "supportsUrl", "(Lokhttp3/HttpUrl;)Z", "certificateSupportHost", "(Lokhttp3/HttpUrl;Lokhttp3/Handshake;)Z", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/Route;", "rawSocket", "Ljava/net/Socket;", "Lokhttp3/Handshake;", "Lokhttp3/Protocol;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "Lokio/BufferedSource;", "source", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSink;", "Z", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "routeFailureCount", "I", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "successCount", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "calls", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "", "idleAtNs", "J", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed$okhttp", "isMultiplexed", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RealConnection extends Listener implements Connection {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull RealConnectionPool realConnectionPool0, @NotNull Route route0, @NotNull Socket socket0, long v) {
            q.g(realConnectionPool0, "connectionPool");
            q.g(route0, "route");
            q.g(socket0, "socket");
            RealConnection realConnection0 = new RealConnection(realConnectionPool0, route0);
            realConnection0.socket = socket0;
            realConnection0.setIdleAtNs$okhttp(v);
            return realConnection0;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Proxy.Type.values().length];
            try {
                arr_v[Proxy.Type.DIRECT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Proxy.Type.HTTP.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    @NotNull
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    @NotNull
    private final List calls;
    @NotNull
    private final RealConnectionPool connectionPool;
    @Nullable
    private Handshake handshake;
    @Nullable
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    @Nullable
    private Protocol protocol;
    @Nullable
    private Socket rawSocket;
    private int refusedStreamCount;
    @NotNull
    private final Route route;
    private int routeFailureCount;
    @Nullable
    private BufferedSink sink;
    @Nullable
    private Socket socket;
    @Nullable
    private BufferedSource source;
    private int successCount;

    static {
        RealConnection.Companion = new Companion(null);
    }

    public RealConnection(@NotNull RealConnectionPool realConnectionPool0, @NotNull Route route0) {
        q.g(realConnectionPool0, "connectionPool");
        q.g(route0, "route");
        super();
        this.connectionPool = realConnectionPool0;
        this.route = route0;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = 0x7FFFFFFFFFFFFFFFL;
    }

    public final void cancel() {
        Socket socket0 = this.rawSocket;
        if(socket0 != null) {
            Util.closeQuietly(socket0);
        }
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl0, Handshake handshake0) {
        List list0 = handshake0.peerCertificates();
        if(!list0.isEmpty()) {
            Object object0 = list0.get(0);
            q.e(object0, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return OkHostnameVerifier.INSTANCE.verify(httpUrl0.host(), ((X509Certificate)object0));
        }
        return false;
    }

    public final void connect(int v, int v1, int v2, int v3, boolean z, @NotNull Call call0, @NotNull EventListener eventListener0) {
        q.g(call0, "call");
        q.g(eventListener0, "eventListener");
        if(this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        List list0 = this.route.address().connectionSpecs();
        ConnectionSpecSelector connectionSpecSelector0 = new ConnectionSpecSelector(list0);
        if(this.route.address().sslSocketFactory() == null) {
            if(!list0.contains(ConnectionSpec.CLEARTEXT)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String s = this.route.address().url().host();
            if(!Platform.Companion.get().isCleartextTrafficPermitted(s)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + s + " not permitted by network security policy"));
            }
        }
        else if(this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException0 = null;
        while(true) {
            try {
                if(this.route.requiresTunnel()) {
                    this.connectTunnel(v, v1, v2, call0, eventListener0);
                    if(this.rawSocket != null) {
                        this.establishProtocol(connectionSpecSelector0, v3, call0, eventListener0);
                        eventListener0.connectEnd(call0, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        break;
                    }
                    break;
                }
                else {
                    this.connectSocket(v, v1, call0, eventListener0);
                }
                this.establishProtocol(connectionSpecSelector0, v3, call0, eventListener0);
                eventListener0.connectEnd(call0, this.route.socketAddress(), this.route.proxy(), this.protocol);
                break;
            }
            catch(IOException iOException0) {
                Socket socket0 = this.socket;
                if(socket0 != null) {
                    Util.closeQuietly(socket0);
                }
                Socket socket1 = this.rawSocket;
                if(socket1 != null) {
                    Util.closeQuietly(socket1);
                }
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                this.http2Connection = null;
                this.allocationLimit = 1;
                eventListener0.connectFailed(call0, this.route.socketAddress(), this.route.proxy(), null, iOException0);
                if(routeException0 == null) {
                    routeException0 = new RouteException(iOException0);
                }
                else {
                    routeException0.addConnectException(iOException0);
                }
                if(!z || !connectionSpecSelector0.connectionFailed(iOException0)) {
                    throw routeException0;
                }
            }
        }
        if(this.route.requiresTunnel() && this.rawSocket == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void connectFailed$okhttp(@NotNull OkHttpClient okHttpClient0, @NotNull Route route0, @NotNull IOException iOException0) {
        q.g(okHttpClient0, "client");
        q.g(route0, "failedRoute");
        q.g(iOException0, "failure");
        if(route0.proxy().type() != Proxy.Type.DIRECT) {
            Address address0 = route0.address();
            address0.proxySelector().connectFailed(address0.url().uri(), route0.proxy().address(), iOException0);
        }
        okHttpClient0.getRouteDatabase().failed(route0);
    }

    private final void connectSocket(int v, int v1, Call call0, EventListener eventListener0) {
        Socket socket0;
        Proxy proxy0 = this.route.proxy();
        Address address0 = this.route.address();
        Proxy.Type proxy$Type0 = proxy0.type();
        int v2 = proxy$Type0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[proxy$Type0.ordinal()];
        if(v2 == 1 || v2 == 2) {
            socket0 = address0.socketFactory().createSocket();
            q.d(socket0);
        }
        else {
            socket0 = new Socket(proxy0);
        }
        this.rawSocket = socket0;
        eventListener0.connectStart(call0, this.route.socketAddress(), proxy0);
        socket0.setSoTimeout(v1);
        try {
            Platform.Companion.get().connectSocket(socket0, this.route.socketAddress(), v);
        }
        catch(ConnectException connectException0) {
            ConnectException connectException1 = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException1.initCause(connectException0);
            throw connectException1;
        }
        try {
            this.source = Okio.buffer(Okio.source(socket0));
            this.sink = Okio.buffer(Okio.sink(socket0));
        }
        catch(NullPointerException nullPointerException0) {
            if(q.b(nullPointerException0.getMessage(), "throw with null exception")) {
                throw new IOException(nullPointerException0);
            }
        }
    }

    private final void connectTls(ConnectionSpecSelector connectionSpecSelector0) {
        SSLSocket sSLSocket1;
        Address address0 = this.route.address();
        SSLSocketFactory sSLSocketFactory0 = address0.sslSocketFactory();
        SSLSocket sSLSocket0 = null;
        try {
            q.d(sSLSocketFactory0);
            Socket socket0 = sSLSocketFactory0.createSocket(this.rawSocket, address0.url().host(), address0.url().port(), true);
            q.e(socket0, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            sSLSocket1 = (SSLSocket)socket0;
        }
        catch(Throwable throwable0) {
            goto label_39;
        }
        try {
            ConnectionSpec connectionSpec0 = connectionSpecSelector0.configureSecureSocket(sSLSocket1);
            if(connectionSpec0.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sSLSocket1, address0.url().host(), address0.protocols());
            }
            sSLSocket1.startHandshake();
            SSLSession sSLSession0 = sSLSocket1.getSession();
            q.f(sSLSession0, "sslSocketSession");
            Handshake handshake0 = Handshake.Companion.get(sSLSession0);
            HostnameVerifier hostnameVerifier0 = address0.hostnameVerifier();
            q.d(hostnameVerifier0);
            if(!hostnameVerifier0.verify(address0.url().host(), sSLSession0)) {
                List list0 = handshake0.peerCertificates();
                if(list0.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address0.url().host() + " not verified (no certificates)");
                }
                Object object0 = list0.get(0);
                q.e(object0, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                throw new SSLPeerUnverifiedException(p.d0(("\n              |Hostname " + address0.url().host() + " not verified:\n              |    certificate: " + CertificatePinner.Companion.pin(((X509Certificate)object0)) + "\n              |    DN: " + ((X509Certificate)object0).getSubjectDN().getName() + "\n              |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(((X509Certificate)object0)) + "\n              ")));
            }
            CertificatePinner certificatePinner0 = address0.certificatePinner();
            q.d(certificatePinner0);
            this.handshake = new Handshake(handshake0.tlsVersion(), handshake0.cipherSuite(), handshake0.localCertificates(), new a(handshake0, address0) {
                final Address $address;
                final CertificatePinner $certificatePinner;
                final Handshake $unverifiedHandshake;

                {
                    this.$certificatePinner = certificatePinner0;
                    this.$unverifiedHandshake = handshake0;
                    this.$address = address0;
                    super(0);
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }

                @NotNull
                public final List invoke() {
                    CertificateChainCleaner certificateChainCleaner0 = this.$certificatePinner.getCertificateChainCleaner$okhttp();
                    q.d(certificateChainCleaner0);
                    return certificateChainCleaner0.clean(this.$unverifiedHandshake.peerCertificates(), this.$address.url().host());
                }
            });
            certificatePinner0.check$okhttp(address0.url().host(), new a() {
                {
                    RealConnection.this = realConnection0;
                    super(0);
                }

                @Override  // we.a
                public Object invoke() {
                    return this.invoke();
                }

                @NotNull
                public final List invoke() {
                    Handshake handshake0 = RealConnection.this.handshake;
                    q.d(handshake0);
                    Iterable iterable0 = handshake0.peerCertificates();
                    List list0 = new ArrayList(je.q.Q(10, iterable0));
                    for(Object object0: iterable0) {
                        q.e(((Certificate)object0), "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        list0.add(((X509Certificate)(((Certificate)object0))));
                    }
                    return list0;
                }
            });
            if(connectionSpec0.supportsTlsExtensions()) {
                sSLSocket0 = Platform.Companion.get().getSelectedProtocol(sSLSocket1);
            }
            this.socket = sSLSocket1;
            this.source = Okio.buffer(Okio.source(sSLSocket1));
            this.sink = Okio.buffer(Okio.sink(sSLSocket1));
            this.protocol = sSLSocket0 == null ? Protocol.HTTP_1_1 : Protocol.Companion.get(((String)sSLSocket0));
            goto label_44;
        }
        catch(Throwable throwable0) {
            sSLSocket0 = sSLSocket1;
        }
    label_39:
        if(sSLSocket0 != null) {
            Platform.Companion.get().afterHandshake(sSLSocket0);
        }
        if(sSLSocket0 != null) {
            Util.closeQuietly(sSLSocket0);
        }
        throw throwable0;
    label_44:
        Platform.Companion.get().afterHandshake(sSLSocket1);
    }

    private final void connectTunnel(int v, int v1, int v2, Call call0, EventListener eventListener0) {
        Request request0 = this.createTunnelRequest();
        HttpUrl httpUrl0 = request0.url();
        for(int v3 = 0; v3 < 21; ++v3) {
            this.connectSocket(v, v1, call0, eventListener0);
            request0 = this.createTunnel(v1, v2, request0, httpUrl0);
            if(request0 == null) {
                break;
            }
            Socket socket0 = this.rawSocket;
            if(socket0 != null) {
                Util.closeQuietly(socket0);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener0.connectEnd(call0, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private final Request createTunnel(int v, int v1, Request request0, HttpUrl httpUrl0) {
        Request request1;
        String s = "CONNECT " + Util.toHostHeader(httpUrl0, true) + " HTTP/1.1";
    alab1:
        while(true) {
            BufferedSource bufferedSource0 = this.source;
            q.d(bufferedSource0);
            BufferedSink bufferedSink0 = this.sink;
            q.d(bufferedSink0);
            Http1ExchangeCodec http1ExchangeCodec0 = new Http1ExchangeCodec(null, this, bufferedSource0, bufferedSink0);
            Timeout timeout0 = bufferedSource0.timeout();
            TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
            timeout0.timeout(((long)v), timeUnit0);
            bufferedSink0.timeout().timeout(((long)v1), timeUnit0);
            http1ExchangeCodec0.writeRequest(request0.headers(), s);
            http1ExchangeCodec0.finishRequest();
            Builder response$Builder0 = http1ExchangeCodec0.readResponseHeaders(false);
            q.d(response$Builder0);
            Response response0 = response$Builder0.request(request0).build();
            http1ExchangeCodec0.skipConnectBody(response0);
            switch(response0.code()) {
                case 200: {
                    if(!bufferedSource0.getBuffer().exhausted() || !bufferedSink0.getBuffer().exhausted()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return null;
                }
                case 407: {
                    request1 = this.route.address().proxyAuthenticator().authenticate(this.route, response0);
                    if(request1 == null) {
                        break alab1;
                    }
                    if("close".equalsIgnoreCase(Response.header$default(response0, "Connection", null, 2, null))) {
                        return request1;
                    }
                    break;
                }
                default: {
                    throw new IOException("Unexpected response code for CONNECT: " + response0.code());
                }
            }
            request0 = request1;
        }
        throw new IOException("Failed to authenticate with proxy");
    }

    private final Request createTunnelRequest() {
        Request request0 = new okhttp3.Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", "okhttp/4.12.0").build();
        Response response0 = new Builder().request(request0).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request request1 = this.route.address().proxyAuthenticator().authenticate(this.route, response0);
        return request1 == null ? request0 : request1;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector0, int v, Call call0, EventListener eventListener0) {
        if(this.route.address().sslSocketFactory() == null) {
            Protocol protocol0 = Protocol.H2_PRIOR_KNOWLEDGE;
            if(this.route.address().protocols().contains(protocol0)) {
                this.socket = this.rawSocket;
                this.protocol = protocol0;
                this.startHttp2(v);
                return;
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
            return;
        }
        eventListener0.secureConnectStart(call0);
        this.connectTls(connectionSpecSelector0);
        eventListener0.secureConnectEnd(call0, this.handshake);
        if(this.protocol == Protocol.HTTP_2) {
            this.startHttp2(v);
        }
    }

    @NotNull
    public final List getCalls() {
        return this.calls;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    @Override  // okhttp3.Connection
    @Nullable
    public Handshake handshake() {
        return this.handshake;
    }

    public final void incrementSuccessCount$okhttp() {
        synchronized(this) {
            ++this.successCount;
        }
    }

    public final boolean isEligible$okhttp(@NotNull Address address0, @Nullable List list0) {
        q.g(address0, "address");
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2437 MUST hold lock on " + this);
        }
        if(this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address0)) {
            return false;
        }
        if(q.b(address0.url().host(), this.route().address().url().host())) {
            return true;
        }
        if(this.http2Connection == null) {
            return false;
        }
        if(list0 == null || !this.routeMatchesAny(list0) || address0.hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
            return false;
        }
        if(!this.supportsUrl(address0.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner0 = address0.certificatePinner();
            q.d(certificatePinner0);
            Handshake handshake0 = this.handshake();
            q.d(handshake0);
            certificatePinner0.check(address0.url().host(), handshake0.peerCertificates());
            return true;
        }
        catch(SSLPeerUnverifiedException unused_ex) {
            return false;
        }
    }

    public final boolean isHealthy(boolean z) {
        if(Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2528 MUST NOT hold lock on " + this);
        }
        long v = System.nanoTime();
        Socket socket0 = this.rawSocket;
        q.d(socket0);
        Socket socket1 = this.socket;
        q.d(socket1);
        BufferedSource bufferedSource0 = this.source;
        q.d(bufferedSource0);
        if(!socket0.isClosed() && !socket1.isClosed() && !socket1.isInputShutdown() && !socket1.isOutputShutdown()) {
            Http2Connection http2Connection0 = this.http2Connection;
            if(http2Connection0 != null) {
                return http2Connection0.isHealthy(v);
            }
            return v - this.idleAtNs < 10000000000L || !z ? true : Util.isHealthy(socket1, bufferedSource0);
        }
        return false;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull OkHttpClient okHttpClient0, @NotNull RealInterceptorChain realInterceptorChain0) {
        q.g(okHttpClient0, "client");
        q.g(realInterceptorChain0, "chain");
        Socket socket0 = this.socket;
        q.d(socket0);
        BufferedSource bufferedSource0 = this.source;
        q.d(bufferedSource0);
        BufferedSink bufferedSink0 = this.sink;
        q.d(bufferedSink0);
        Http2Connection http2Connection0 = this.http2Connection;
        if(http2Connection0 != null) {
            return new Http2ExchangeCodec(okHttpClient0, this, realInterceptorChain0, http2Connection0);
        }
        socket0.setSoTimeout(realInterceptorChain0.readTimeoutMillis());
        Timeout timeout0 = bufferedSource0.timeout();
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        timeout0.timeout(((long)realInterceptorChain0.getReadTimeoutMillis$okhttp()), timeUnit0);
        bufferedSink0.timeout().timeout(((long)realInterceptorChain0.getWriteTimeoutMillis$okhttp()), timeUnit0);
        return new Http1ExchangeCodec(okHttpClient0, this, bufferedSource0, bufferedSink0);
    }

    @NotNull
    public final Streams newWebSocketStreams$okhttp(@NotNull Exchange exchange0) {
        q.g(exchange0, "exchange");
        Socket socket0 = this.socket;
        q.d(socket0);
        BufferedSource bufferedSource0 = this.source;
        q.d(bufferedSource0);
        BufferedSink bufferedSink0 = this.sink;
        q.d(bufferedSink0);
        socket0.setSoTimeout(0);
        this.noNewExchanges$okhttp();
        return new Streams(bufferedSink0, exchange0) {
            final Exchange $exchange;

            {
                this.$exchange = exchange0;
                super(true, bufferedSource0, bufferedSink0);
            }

            @Override
            public void close() {
                this.$exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final void noCoalescedConnections$okhttp() {
        synchronized(this) {
            this.noCoalescedConnections = true;
        }
    }

    public final void noNewExchanges$okhttp() {
        synchronized(this) {
            this.noNewExchanges = true;
        }
    }

    @Override  // okhttp3.internal.http2.Http2Connection$Listener
    public void onSettings(@NotNull Http2Connection http2Connection0, @NotNull Settings settings0) {
        synchronized(this) {
            q.g(http2Connection0, "connection");
            q.g(settings0, "settings");
            this.allocationLimit = settings0.getMaxConcurrentStreams();
        }
    }

    @Override  // okhttp3.internal.http2.Http2Connection$Listener
    public void onStream(@NotNull Http2Stream http2Stream0) {
        q.g(http2Stream0, "stream");
        http2Stream0.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override  // okhttp3.Connection
    @NotNull
    public Protocol protocol() {
        Protocol protocol0 = this.protocol;
        q.d(protocol0);
        return protocol0;
    }

    @Override  // okhttp3.Connection
    @NotNull
    public Route route() {
        return this.route;
    }

    private final boolean routeMatchesAny(List list0) {
        if(list0 instanceof Collection && list0.isEmpty()) {
            return false;
        }
        for(Object object0: list0) {
            Proxy.Type proxy$Type0 = ((Route)object0).proxy().type();
            Proxy.Type proxy$Type1 = Proxy.Type.DIRECT;
            if(proxy$Type0 == proxy$Type1 && this.route.proxy().type() == proxy$Type1 && q.b(this.route.socketAddress(), ((Route)object0).socketAddress())) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void setIdleAtNs$okhttp(long v) {
        this.idleAtNs = v;
    }

    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    public final void setRouteFailureCount$okhttp(int v) {
        this.routeFailureCount = v;
    }

    @Override  // okhttp3.Connection
    @NotNull
    public Socket socket() {
        Socket socket0 = this.socket;
        q.d(socket0);
        return socket0;
    }

    private final void startHttp2(int v) {
        Socket socket0 = this.socket;
        q.d(socket0);
        BufferedSource bufferedSource0 = this.source;
        q.d(bufferedSource0);
        BufferedSink bufferedSink0 = this.sink;
        q.d(bufferedSink0);
        socket0.setSoTimeout(0);
        Http2Connection http2Connection0 = new okhttp3.internal.http2.Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket0, this.route.address().url().host(), bufferedSource0, bufferedSink0).listener(this).pingIntervalMillis(v).build();
        this.http2Connection = http2Connection0;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(http2Connection0, false, null, 3, null);
    }

    private final boolean supportsUrl(HttpUrl httpUrl0) {
        if(Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2454 MUST hold lock on " + this);
        }
        HttpUrl httpUrl1 = this.route.address().url();
        if(httpUrl0.port() != httpUrl1.port()) {
            return false;
        }
        if(q.b(httpUrl0.host(), httpUrl1.host())) {
            return true;
        }
        if(!this.noCoalescedConnections) {
            Handshake handshake0 = this.handshake;
            if(handshake0 != null) {
                q.d(handshake0);
                return this.certificateSupportHost(httpUrl0, handshake0);
            }
        }
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        CipherSuite cipherSuite0;
        StringBuilder stringBuilder0 = new StringBuilder("Connection{");
        stringBuilder0.append(this.route.address().url().host());
        stringBuilder0.append(':');
        stringBuilder0.append(this.route.address().url().port());
        stringBuilder0.append(", proxy=");
        stringBuilder0.append(this.route.proxy());
        stringBuilder0.append(" hostAddress=");
        stringBuilder0.append(this.route.socketAddress());
        stringBuilder0.append(" cipherSuite=");
        Handshake handshake0 = this.handshake;
        if(handshake0 == null) {
            cipherSuite0 = "none";
        }
        else {
            cipherSuite0 = handshake0.cipherSuite();
            if(cipherSuite0 == null) {
                cipherSuite0 = "none";
            }
        }
        stringBuilder0.append(cipherSuite0);
        stringBuilder0.append(" protocol=");
        stringBuilder0.append(this.protocol);
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    public final void trackFailure$okhttp(@NotNull RealCall realCall0, @Nullable IOException iOException0) {
        synchronized(this) {
            q.g(realCall0, "call");
            if(!(iOException0 instanceof StreamResetException)) {
                if(!this.isMultiplexed$okhttp() || iOException0 instanceof ConnectionShutdownException) {
                    this.noNewExchanges = true;
                    if(this.successCount == 0) {
                        if(iOException0 != null) {
                            this.connectFailed$okhttp(realCall0.getClient(), this.route, iOException0);
                        }
                        ++this.routeFailureCount;
                    }
                }
            }
            else if(((StreamResetException)iOException0).errorCode == ErrorCode.REFUSED_STREAM) {
                int v1 = this.refusedStreamCount + 1;
                this.refusedStreamCount = v1;
                if(v1 > 1) {
                    this.noNewExchanges = true;
                    ++this.routeFailureCount;
                }
            }
            else if(((StreamResetException)iOException0).errorCode != ErrorCode.CANCEL || !realCall0.isCanceled()) {
                this.noNewExchanges = true;
                ++this.routeFailureCount;
            }
        }
    }
}

