package okhttp3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\t2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00160\rH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001D\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010\u001F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001F\u0010\bJ!\u0010\"\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b\"\u0010#J1\u0010&\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u000E2\b\u0010%\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b&\u0010\'J9\u0010*\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u000E2\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010.\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010-\u001A\u00020,H\u0016\u00A2\u0006\u0004\b.\u0010/J\u001F\u00100\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010-\u001A\u00020,H\u0016\u00A2\u0006\u0004\b0\u0010/J\u0017\u00101\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b1\u0010\bJ\u001F\u00104\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b4\u00105J\u0017\u00106\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b6\u0010\bJ\u001F\u00109\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b9\u0010:J\u001F\u0010;\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010=\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b=\u0010\bJ\u001F\u0010@\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010?\u001A\u00020>H\u0016\u00A2\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bB\u0010\bJ\u001F\u0010C\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\bC\u0010:J\u001F\u0010D\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\bD\u0010<J\u0017\u0010E\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bE\u0010\bJ\u001F\u0010F\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\bF\u0010<J\u0017\u0010G\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bG\u0010\bJ\u001F\u0010H\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010?\u001A\u00020>H\u0016\u00A2\u0006\u0004\bH\u0010AJ\u001F\u0010I\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010?\u001A\u00020>H\u0016\u00A2\u0006\u0004\bI\u0010AJ\u0017\u0010J\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bJ\u0010\bJ\u001F\u0010L\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010K\u001A\u00020>H\u0016\u00A2\u0006\u0004\bL\u0010A\u00A8\u0006O"}, d2 = {"Lokhttp3/EventListener;", "", "<init>", "()V", "Lokhttp3/Call;", "call", "Lie/H;", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class EventListener {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/EventListener$Companion;", "", "()V", "NONE", "Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lokhttp3/EventListener$Factory;", "", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Factory {
        @NotNull
        EventListener create(@NotNull Call arg1);
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final EventListener NONE;

    static {
        EventListener.Companion = new Companion(null);
        EventListener.NONE = new EventListener.Companion.NONE.1();
    }

    public void cacheConditionalHit(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "cachedResponse");
    }

    public void cacheHit(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
    }

    public void cacheMiss(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void callEnd(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void callFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
    }

    public void callStart(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void canceled(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void connectEnd(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0, @Nullable Protocol protocol0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
    }

    public void connectFailed(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0, @Nullable Protocol protocol0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
        q.g(iOException0, "ioe");
    }

    public void connectStart(@NotNull Call call0, @NotNull InetSocketAddress inetSocketAddress0, @NotNull Proxy proxy0) {
        q.g(call0, "call");
        q.g(inetSocketAddress0, "inetSocketAddress");
        q.g(proxy0, "proxy");
    }

    public void connectionAcquired(@NotNull Call call0, @NotNull Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
    }

    public void connectionReleased(@NotNull Call call0, @NotNull Connection connection0) {
        q.g(call0, "call");
        q.g(connection0, "connection");
    }

    public void dnsEnd(@NotNull Call call0, @NotNull String s, @NotNull List list0) {
        q.g(call0, "call");
        q.g(s, "domainName");
        q.g(list0, "inetAddressList");
    }

    public void dnsStart(@NotNull Call call0, @NotNull String s) {
        q.g(call0, "call");
        q.g(s, "domainName");
    }

    public void proxySelectEnd(@NotNull Call call0, @NotNull HttpUrl httpUrl0, @NotNull List list0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
        q.g(list0, "proxies");
    }

    public void proxySelectStart(@NotNull Call call0, @NotNull HttpUrl httpUrl0) {
        q.g(call0, "call");
        q.g(httpUrl0, "url");
    }

    public void requestBodyEnd(@NotNull Call call0, long v) {
        q.g(call0, "call");
    }

    public void requestBodyStart(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void requestFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call call0, @NotNull Request request0) {
        q.g(call0, "call");
        q.g(request0, "request");
    }

    public void requestHeadersStart(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void responseBodyEnd(@NotNull Call call0, long v) {
        q.g(call0, "call");
    }

    public void responseBodyStart(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void responseFailed(@NotNull Call call0, @NotNull IOException iOException0) {
        q.g(call0, "call");
        q.g(iOException0, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
    }

    public void responseHeadersStart(@NotNull Call call0) {
        q.g(call0, "call");
    }

    public void satisfactionFailure(@NotNull Call call0, @NotNull Response response0) {
        q.g(call0, "call");
        q.g(response0, "response");
    }

    public void secureConnectEnd(@NotNull Call call0, @Nullable Handshake handshake0) {
        q.g(call0, "call");
    }

    public void secureConnectStart(@NotNull Call call0) {
        q.g(call0, "call");
    }
}

