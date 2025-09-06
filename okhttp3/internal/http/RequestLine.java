package okhttp3.internal.http;

import java.net.Proxy.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bJ\u0018\u0010\t\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0002J\u000E\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\r¨\u0006\u000E"}, d2 = {"Lokhttp3/internal/http/RequestLine;", "", "()V", "get", "", "request", "Lokhttp3/Request;", "proxyType", "Ljava/net/Proxy$Type;", "includeAuthorityInRequestLine", "", "requestPath", "url", "Lokhttp3/HttpUrl;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RequestLine {
    @NotNull
    public static final RequestLine INSTANCE;

    static {
        RequestLine.INSTANCE = new RequestLine();
    }

    @NotNull
    public final String get(@NotNull Request request0, @NotNull Proxy.Type proxy$Type0) {
        q.g(request0, "request");
        q.g(proxy$Type0, "proxyType");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(request0.method());
        stringBuilder0.append(' ');
        RequestLine requestLine0 = RequestLine.INSTANCE;
        if(requestLine0.includeAuthorityInRequestLine(request0, proxy$Type0)) {
            stringBuilder0.append(request0.url());
        }
        else {
            stringBuilder0.append(requestLine0.requestPath(request0.url()));
        }
        stringBuilder0.append(" HTTP/1.1");
        String s = stringBuilder0.toString();
        q.f(s, "StringBuilder().apply(builderAction).toString()");
        return s;
    }

    private final boolean includeAuthorityInRequestLine(Request request0, Proxy.Type proxy$Type0) {
        return !request0.isHttps() && proxy$Type0 == Proxy.Type.HTTP;
    }

    @NotNull
    public final String requestPath(@NotNull HttpUrl httpUrl0) {
        q.g(httpUrl0, "url");
        String s = httpUrl0.encodedPath();
        String s1 = httpUrl0.encodedQuery();
        return s1 == null ? s : s + '?' + s1;
    }
}

