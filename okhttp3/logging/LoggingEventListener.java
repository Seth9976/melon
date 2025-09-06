package okhttp3.logging;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001UB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ-\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000B2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001A\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u00142\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00180\u000FH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001F\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010!\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b!\u0010\nJ!\u0010$\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010#\u001A\u0004\u0018\u00010\"H\u0016\u00A2\u0006\u0004\b$\u0010%J1\u0010(\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u00102\b\u0010\'\u001A\u0004\u0018\u00010&H\u0016\u00A2\u0006\u0004\b(\u0010)J9\u0010,\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u00102\b\u0010\'\u001A\u0004\u0018\u00010&2\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\b,\u0010-J\u001F\u00100\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010/\u001A\u00020.H\u0016\u00A2\u0006\u0004\b0\u00101J\u001F\u00102\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010/\u001A\u00020.H\u0016\u00A2\u0006\u0004\b2\u00101J\u0017\u00103\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b3\u0010\nJ\u001F\u00106\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u00105\u001A\u000204H\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b8\u0010\nJ\u001F\u0010;\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010:\u001A\u000209H\u0016\u00A2\u0006\u0004\b;\u0010<J\u001F\u0010=\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010?\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b?\u0010\nJ\u001F\u0010B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010A\u001A\u00020@H\u0016\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\bD\u0010\nJ\u001F\u0010E\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010:\u001A\u000209H\u0016\u00A2\u0006\u0004\bE\u0010<J\u001F\u0010F\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\bF\u0010>J\u0017\u0010G\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\bG\u0010\nJ\u001F\u0010H\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010+\u001A\u00020*H\u0016\u00A2\u0006\u0004\bH\u0010>J\u0017\u0010I\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\bI\u0010\nJ\u001F\u0010J\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010A\u001A\u00020@H\u0016\u00A2\u0006\u0004\bJ\u0010CJ\u001F\u0010K\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010A\u001A\u00020@H\u0016\u00A2\u0006\u0004\bK\u0010CJ\u0017\u0010L\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\bL\u0010\nJ\u001F\u0010N\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010M\u001A\u00020@H\u0016\u00A2\u0006\u0004\bN\u0010CJ\u0017\u0010P\u001A\u00020\b2\u0006\u0010O\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\bP\u0010QR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010RR\u0016\u0010S\u001A\u0002098\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010T\u00A8\u0006V"}, d2 = {"Lokhttp3/logging/LoggingEventListener;", "Lokhttp3/EventListener;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Lokhttp3/Call;", "call", "Lie/H;", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "message", "logWithTime", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "startNs", "J", "Factory", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LoggingEventListener extends EventListener {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/logging/LoggingEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class Factory implements okhttp3.EventListener.Factory {
        @NotNull
        private final Logger logger;

        public Factory() {
            this(null, 1, null);
        }

        public Factory(@NotNull Logger httpLoggingInterceptor$Logger0) {
            q.g(httpLoggingInterceptor$Logger0, "logger");
            super();
            this.logger = httpLoggingInterceptor$Logger0;
        }

        public Factory(Logger httpLoggingInterceptor$Logger0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                httpLoggingInterceptor$Logger0 = Logger.DEFAULT;
            }
            this(httpLoggingInterceptor$Logger0);
        }

        @Override  // okhttp3.EventListener$Factory
        @NotNull
        public EventListener create(@NotNull Call call0) {
            q.g(call0, "call");
            return new LoggingEventListener(this.logger, null);
        }
    }

    @NotNull
    private final Logger logger;
    private long startNs;

    private LoggingEventListener(Logger httpLoggingInterceptor$Logger0) {
        this.logger = httpLoggingInterceptor$Logger0;
    }

    public LoggingEventListener(Logger httpLoggingInterceptor$Logger0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(httpLoggingInterceptor$Logger0);
    }

    @Override  // okhttp3.EventListener
    public void cacheConditionalHit(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "cachedResponse");
        this.logWithTime("cacheConditionalHit: " + response0);
    }

    @Override  // okhttp3.EventListener
    public void cacheHit(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        this.logWithTime("cacheHit: " + response0);
    }

    @Override  // okhttp3.EventListener
    public void cacheMiss(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("cacheMiss");
    }

    @Override  // okhttp3.EventListener
    public void callEnd(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("callEnd");
    }

    @Override  // okhttp3.EventListener
    public void callFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        this.logWithTime("callFailed: " + iOException0);
    }

    @Override  // okhttp3.EventListener
    public void callStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.startNs = System.nanoTime();
        this.logWithTime("callStart: " + call0.request());
    }

    @Override  // okhttp3.EventListener
    public void canceled(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("canceled");
    }

    @Override  // okhttp3.EventListener
    public void connectEnd(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0, @Nullable Protocol protocol0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        this.logWithTime("connectEnd: " + protocol0);
    }

    @Override  // okhttp3.EventListener
    public void connectFailed(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0, @Nullable Protocol protocol0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        q.g(iOException0, "ioe");
        this.logWithTime("connectFailed: " + protocol0 + ' ' + iOException0);
    }

    @Override  // okhttp3.EventListener
    public void connectStart(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        this.logWithTime("connectStart: " + inetSocketAddress0 + ' ' + proxy0);
    }

    @Override  // okhttp3.EventListener
    public void connectionAcquired(@NotNull Call call0, @NotNull Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
        this.logWithTime("connectionAcquired: " + connection0);
    }

    @Override  // okhttp3.EventListener
    public void connectionReleased(@NotNull Call call0, @NotNull Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
        this.logWithTime("connectionReleased");
    }

    @Override  // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call0, @NotNull String s, @NotNull List list0) {
        q.g(call0, "call");
        q.g(s, "domainName");
        q.g(list0, "inetAddressList");
        this.logWithTime("dnsEnd: " + list0);
    }

    @Override  // okhttp3.EventListener
    public void dnsStart(@NotNull Call call0, @NotNull String s) {
        q.g(call0, "call");
        q.g(s, "domainName");
        this.logWithTime("dnsStart: " + s);
    }

    private final void logWithTime(String s) {
        long v = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        this.logger.log("[" + v + " ms] " + s);
    }

    @Override  // okhttp3.EventListener
    public void proxySelectEnd(@NotNull Call call0, @NotNull HttpUrl httpUrl0, @NotNull List list0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
        q.g(list0, "proxies");
        this.logWithTime("proxySelectEnd: " + list0);
    }

    @Override  // okhttp3.EventListener
    public void proxySelectStart(@NotNull Call call0, @NotNull HttpUrl httpUrl0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
        this.logWithTime("proxySelectStart: " + httpUrl0);
    }

    @Override  // okhttp3.EventListener
    public void requestBodyEnd(@NotNull Call call0, long v) {
        q.g(call0, "call");
        this.logWithTime("requestBodyEnd: byteCount=" + v);
    }

    @Override  // okhttp3.EventListener
    public void requestBodyStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("requestBodyStart");
    }

    @Override  // okhttp3.EventListener
    public void requestFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        this.logWithTime("requestFailed: " + iOException0);
    }

    @Override  // okhttp3.EventListener
    public void requestHeadersEnd(@NotNull Call call0, @NotNull Request request0) {
        q.g(call0, "call");
        q.g(request0, "request");
        this.logWithTime("requestHeadersEnd");
    }

    @Override  // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("requestHeadersStart");
    }

    @Override  // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call0, long v) {
        q.g(call0, "call");
        this.logWithTime("responseBodyEnd: byteCount=" + v);
    }

    @Override  // okhttp3.EventListener
    public void responseBodyStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("responseBodyStart");
    }

    @Override  // okhttp3.EventListener
    public void responseFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
        this.logWithTime("responseFailed: " + iOException0);
    }

    @Override  // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        this.logWithTime("responseHeadersEnd: " + response0);
    }

    @Override  // okhttp3.EventListener
    public void responseHeadersStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("responseHeadersStart");
    }

    @Override  // okhttp3.EventListener
    public void satisfactionFailure(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
        this.logWithTime("satisfactionFailure: " + response0);
    }

    @Override  // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call0, @Nullable Handshake handshake0) {
        q.g(call0, "call");
        this.logWithTime("secureConnectEnd: " + handshake0);
    }

    @Override  // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call0) {
        q.g(call0, "call");
        this.logWithTime("secureConnectStart");
    }
}

