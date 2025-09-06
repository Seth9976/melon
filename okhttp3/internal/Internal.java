package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\'\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001A\u001D\u0010\f\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\r\u001A\u001D\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001A%\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0015\u001A\u001F\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018¢\u0006\u0004\b\u001B\u0010\u001C\u001A%\u0010#\u001A\u00020\"2\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\n¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"", "currentTimeMillis", "Lokhttp3/HttpUrl;", "url", "", "setCookie", "Lokhttp3/Cookie;", "parseCookie", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "cookie", "", "forObsoleteRfc2965", "cookieToString", "(Lokhttp3/Cookie;Z)Ljava/lang/String;", "Lokhttp3/Headers$Builder;", "builder", "line", "addHeaderLenient", "(Lokhttp3/Headers$Builder;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "name", "value", "(Lokhttp3/Headers$Builder;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "Lokhttp3/Cache;", "cache", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "cacheGet", "(Lokhttp3/Cache;Lokhttp3/Request;)Lokhttp3/Response;", "Lokhttp3/ConnectionSpec;", "connectionSpec", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "Lie/H;", "applyConnectionSpec", "(Lokhttp3/ConnectionSpec;Ljavax/net/ssl/SSLSocket;Z)V", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class Internal {
    @NotNull
    public static final Builder addHeaderLenient(@NotNull Builder headers$Builder0, @NotNull String s) {
        q.g(headers$Builder0, "builder");
        q.g(s, "line");
        return headers$Builder0.addLenient$okhttp(s);
    }

    @NotNull
    public static final Builder addHeaderLenient(@NotNull Builder headers$Builder0, @NotNull String s, @NotNull String s1) {
        q.g(headers$Builder0, "builder");
        q.g(s, "name");
        q.g(s1, "value");
        return headers$Builder0.addLenient$okhttp(s, s1);
    }

    public static final void applyConnectionSpec(@NotNull ConnectionSpec connectionSpec0, @NotNull SSLSocket sSLSocket0, boolean z) {
        q.g(connectionSpec0, "connectionSpec");
        q.g(sSLSocket0, "sslSocket");
        connectionSpec0.apply$okhttp(sSLSocket0, z);
    }

    @Nullable
    public static final Response cacheGet(@NotNull Cache cache0, @NotNull Request request0) {
        q.g(cache0, "cache");
        q.g(request0, "request");
        return cache0.get$okhttp(request0);
    }

    @NotNull
    public static final String cookieToString(@NotNull Cookie cookie0, boolean z) {
        q.g(cookie0, "cookie");
        return cookie0.toString$okhttp(z);
    }

    @Nullable
    public static final Cookie parseCookie(long v, @NotNull HttpUrl httpUrl0, @NotNull String s) {
        q.g(httpUrl0, "url");
        q.g(s, "setCookie");
        return Cookie.Companion.parse$okhttp(v, httpUrl0, s);
    }
}

