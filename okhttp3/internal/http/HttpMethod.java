package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u000E\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u0010\u0010\n\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u000B"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class HttpMethod {
    @NotNull
    public static final HttpMethod INSTANCE;

    static {
        HttpMethod.INSTANCE = new HttpMethod();
    }

    // 去混淆评级： 低(25)
    public final boolean invalidatesCache(@NotNull String s) {
        q.g(s, "method");
        return s.equals("POST") || s.equals("PATCH") || s.equals("PUT") || s.equals("DELETE") || s.equals("MOVE");
    }

    public static final boolean permitsRequestBody(@NotNull String s) {
        q.g(s, "method");
        return !s.equals("GET") && !s.equals("HEAD");
    }

    public final boolean redirectsToGet(@NotNull String s) {
        q.g(s, "method");
        return !s.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String s) {
        q.g(s, "method");
        return s.equals("PROPFIND");
    }

    // 去混淆评级： 低(25)
    public static final boolean requiresRequestBody(@NotNull String s) {
        q.g(s, "method");
        return s.equals("POST") || s.equals("PUT") || s.equals("PATCH") || s.equals("PROPPATCH") || s.equals("REPORT");
    }
}

