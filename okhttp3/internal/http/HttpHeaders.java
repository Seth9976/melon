package okhttp3.internal.http;

import Tf.v;
import ie.d;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.x;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001F\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001A!\u0010\u000B\u001A\u00020\n*\u00020\u00072\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000B\u0010\f\u001A\u0013\u0010\u000E\u001A\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u001B\u0010\u0012\u001A\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u0015\u0010\u0014\u001A\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u0015\u0010\u0016\u001A\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001A!\u0010\u001B\u001A\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0000¢\u0006\u0004\b\u001B\u0010\u001C\u001A\u0011\u0010\u001E\u001A\u00020\r*\u00020\u001D¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u0017\u0010!\u001A\u00020\r2\u0006\u0010 \u001A\u00020\u001DH\u0007¢\u0006\u0004\b!\u0010\u001F\"\u0014\u0010#\u001A\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0014\u0010%\u001A\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lokhttp3/Headers;", "", "headerName", "", "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lokio/Buffer;", "", "result", "Lie/H;", "readChallengeHeader", "(Lokio/Buffer;Ljava/util/List;)V", "", "skipCommasAndWhitespace", "(Lokio/Buffer;)Z", "", "prefix", "startsWith", "(Lokio/Buffer;B)Z", "readQuotedString", "(Lokio/Buffer;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class HttpHeaders {
    @NotNull
    private static final ByteString QUOTED_STRING_DELIMITERS;
    @NotNull
    private static final ByteString TOKEN_DELIMITERS;

    static {
        HttpHeaders.QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
        HttpHeaders.TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");
    }

    @d
    public static final boolean hasBody(@NotNull Response response0) {
        q.g(response0, "response");
        return HttpHeaders.promisesBody(response0);
    }

    @NotNull
    public static final List parseChallenges(@NotNull Headers headers0, @NotNull String s) {
        q.g(headers0, "<this>");
        q.g(s, "headerName");
        List list0 = new ArrayList();
        int v = headers0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(s.equalsIgnoreCase(headers0.name(v1))) {
                Buffer buffer0 = new Buffer().writeUtf8(headers0.value(v1));
                try {
                    HttpHeaders.readChallengeHeader(buffer0, list0);
                }
                catch(EOFException eOFException0) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, eOFException0);
                }
            }
        }
        return list0;
    }

    public static final boolean promisesBody(@NotNull Response response0) {
        q.g(response0, "<this>");
        if(q.b(response0.request().method(), "HEAD")) {
            return false;
        }
        int v = response0.code();
        return v >= 100 && v < 200 || (v == 204 || v == 304) ? Util.headersContentLength(response0) != -1L || "chunked".equalsIgnoreCase(Response.header$default(response0, "Transfer-Encoding", null, 2, null)) : true;
    }

    private static final void readChallengeHeader(Buffer buffer0, List list0) {
        int v;
        String s1;
        String s;
        while(true) {
            s = null;
        label_1:
            if(s == null) {
                HttpHeaders.skipCommasAndWhitespace(buffer0);
                s = HttpHeaders.readToken(buffer0);
                if(s != null) {
                    goto label_5;
                }
                return;
            }
        label_5:
            boolean z = HttpHeaders.skipCommasAndWhitespace(buffer0);
            s1 = HttpHeaders.readToken(buffer0);
            if(s1 == null) {
                if(!buffer0.exhausted()) {
                    return;
                }
                list0.add(new Challenge(s, x.a));
                return;
            }
            v = Util.skipAll(buffer0, 61);
            if(z || !HttpHeaders.skipCommasAndWhitespace(buffer0) && !buffer0.exhausted()) {
                break;
            }
            StringBuilder stringBuilder0 = Y.p(s1);
            stringBuilder0.append(v.n0(v, "="));
            Map map0 = Collections.singletonMap(null, stringBuilder0.toString());
            q.f(map0, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list0.add(new Challenge(s, map0));
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        int v1 = Util.skipAll(buffer0, 61) + v;
        while(true) {
            if(s1 == null) {
                s1 = HttpHeaders.readToken(buffer0);
                if(HttpHeaders.skipCommasAndWhitespace(buffer0)) {
                    list0.add(new Challenge(s, linkedHashMap0));
                    s = s1;
                    goto label_1;
                }
                else {
                    v1 = Util.skipAll(buffer0, 61);
                }
            }
            if(v1 == 0) {
                list0.add(new Challenge(s, linkedHashMap0));
                s = s1;
                goto label_1;
            }
            if(v1 > 1 || HttpHeaders.skipCommasAndWhitespace(buffer0)) {
                break;
            }
            String s2 = HttpHeaders.startsWith(buffer0, 34) ? HttpHeaders.readQuotedString(buffer0) : HttpHeaders.readToken(buffer0);
            if(s2 == null || ((String)linkedHashMap0.put(s1, s2)) != null || !HttpHeaders.skipCommasAndWhitespace(buffer0) && !buffer0.exhausted()) {
                break;
            }
            s1 = null;
        }
    }

    private static final String readQuotedString(Buffer buffer0) {
        if(buffer0.readByte() == 34) {
            Buffer buffer1 = new Buffer();
            while(true) {
                long v = buffer0.indexOfElement(HttpHeaders.QUOTED_STRING_DELIMITERS);
                if(Long.compare(v, -1L) == 0) {
                    return null;
                }
                if(buffer0.getByte(v) == 34) {
                    buffer1.write(buffer0, v);
                    buffer0.readByte();
                    return "";
                }
                if(buffer0.size() == v + 1L) {
                    return null;
                }
                buffer1.write(buffer0, v);
                buffer0.readByte();
                buffer1.write(buffer0, 1L);
            }
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final String readToken(Buffer buffer0) {
        long v = buffer0.indexOfElement(HttpHeaders.TOKEN_DELIMITERS);
        if(v == -1L) {
            v = buffer0.size();
        }
        return v == 0L ? null : buffer0.readUtf8(v);
    }

    public static final void receiveHeaders(@NotNull CookieJar cookieJar0, @NotNull HttpUrl httpUrl0, @NotNull Headers headers0) {
        q.g(cookieJar0, "<this>");
        q.g(httpUrl0, "url");
        q.g(headers0, "headers");
        if(cookieJar0 != CookieJar.NO_COOKIES) {
            List list0 = Cookie.Companion.parseAll(httpUrl0, headers0);
            if(!list0.isEmpty()) {
                cookieJar0.saveFromResponse(httpUrl0, list0);
            }
        }
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer0) {
        boolean z = false;
        while(!buffer0.exhausted()) {
            int v = buffer0.getByte(0L);
            if(v == 44) {
                buffer0.readByte();
                z = true;
            }
            else {
                if(v != 9 && v != 0x20) {
                    break;
                }
                buffer0.readByte();
            }
        }
        return z;
    }

    private static final boolean startsWith(Buffer buffer0, byte b) {
        return !buffer0.exhausted() && buffer0.getByte(0L) == b;
    }
}

