package okhttp3.logging;

import Tf.v;
import U4.x;
import ie.d;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import je.u;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\'(B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u001A\u001A\u00020\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001C\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00100!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010\u0015\u001A\u00020\u00142\u0006\u0010$\u001A\u00020\u00148\u0006@GX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001A\u0004\b\u001A\u0010\u0019\"\u0004\b\u0015\u0010&¨\u0006)"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Lokhttp3/Headers;", "headers", "", "i", "Lie/H;", "logHeader", "(Lokhttp3/Headers;I)V", "", "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", "", "name", "redactHeader", "(Ljava/lang/String;)V", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "-deprecated_level", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "headersToRedact", "Ljava/util/Set;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class HttpLoggingInterceptor implements Interceptor {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY;

        private static final Level[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "", "message", "Lie/H;", "log", "(Ljava/lang/String;)V", "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Logger {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "()V", "", "message", "Lie/H;", "log", "(Ljava/lang/String;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
            static final class DefaultLogger implements Logger {
                @Override  // okhttp3.logging.HttpLoggingInterceptor$Logger
                public void log(@NotNull String s) {
                    q.g(s, "message");
                    Platform.log$default(Platform.Companion.get(), s, 0, null, 6, null);
                }
            }

            static final Companion $$INSTANCE;

            static {
                Companion.$$INSTANCE = new Companion();
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        public static final Logger DEFAULT;

        static {
            Logger.Companion = Companion.$$INSTANCE;
            Logger.DEFAULT = new DefaultLogger();
        }

        void log(@NotNull String arg1);
    }

    @NotNull
    private volatile Set headersToRedact;
    @NotNull
    private volatile Level level;
    @NotNull
    private final Logger logger;

    @d
    @NotNull
    public final Level -deprecated_level() {
        return this.level;
    }

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(@NotNull Logger httpLoggingInterceptor$Logger0) {
        q.g(httpLoggingInterceptor$Logger0, "logger");
        super();
        this.logger = httpLoggingInterceptor$Logger0;
        this.headersToRedact = y.a;
        this.level = Level.NONE;
    }

    public HttpLoggingInterceptor(Logger httpLoggingInterceptor$Logger0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            httpLoggingInterceptor$Logger0 = Logger.DEFAULT;
        }
        this(httpLoggingInterceptor$Logger0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers0) {
        String s = headers0.get("Content-Encoding");
        return s == null ? false : !s.equalsIgnoreCase("identity") && !s.equalsIgnoreCase("gzip");
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    @Override  // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Chain interceptor$Chain0) {
        Charset charset1;
        Long long0;
        Response response0;
        Charset charset0;
        int v1;
        boolean z = true;
        q.g(interceptor$Chain0, "chain");
        Level httpLoggingInterceptor$Level0 = this.level;
        Request request0 = interceptor$Chain0.request();
        if(httpLoggingInterceptor$Level0 == Level.NONE) {
            return interceptor$Chain0.proceed(request0);
        }
        int v = httpLoggingInterceptor$Level0 == Level.BODY ? 1 : 0;
        if(v == 0 && httpLoggingInterceptor$Level0 != Level.HEADERS) {
            z = false;
        }
        RequestBody requestBody0 = request0.body();
        Connection connection0 = interceptor$Chain0.connection();
        String s = "--> " + request0.method() + ' ' + request0.url() + (connection0 == null ? "" : " " + connection0.protocol());
        if(!z && requestBody0 != null) {
            StringBuilder stringBuilder0 = x.p(s, " (");
            stringBuilder0.append(requestBody0.contentLength());
            stringBuilder0.append("-byte body)");
            s = stringBuilder0.toString();
        }
        this.logger.log(s);
        if(z) {
            Headers headers0 = request0.headers();
            if(requestBody0 == null) {
                v1 = v;
            }
            else {
                MediaType mediaType0 = requestBody0.contentType();
                if(mediaType0 == null || headers0.get("Content-Type") != null) {
                    v1 = v;
                }
                else {
                    v1 = v;
                    this.logger.log("Content-Type: " + mediaType0);
                }
                if(requestBody0.contentLength() != -1L && headers0.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + requestBody0.contentLength());
                }
            }
            int v2 = headers0.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                this.logHeader(headers0, v3);
            }
            if(v1 == 0 || requestBody0 == null) {
                this.logger.log("--> END " + request0.method());
            }
            else if(this.bodyHasUnknownEncoding(request0.headers())) {
                this.logger.log("--> END " + request0.method() + " (encoded body omitted)");
            }
            else {
                Buffer buffer0 = new Buffer();
                requestBody0.writeTo(buffer0);
                MediaType mediaType1 = requestBody0.contentType();
                if(mediaType1 == null) {
                    charset0 = StandardCharsets.UTF_8;
                    q.f(charset0, "UTF_8");
                }
                else {
                    charset0 = mediaType1.charset(StandardCharsets.UTF_8);
                    if(charset0 == null) {
                        charset0 = StandardCharsets.UTF_8;
                        q.f(charset0, "UTF_8");
                    }
                }
                this.logger.log("");
                if(Utf8Kt.isProbablyUtf8(buffer0)) {
                    String s1 = buffer0.readString(charset0);
                    this.logger.log(s1);
                    this.logger.log("--> END " + request0.method() + " (" + requestBody0.contentLength() + "-byte body)");
                }
                else {
                    this.logger.log("--> END " + request0.method() + " (binary " + requestBody0.contentLength() + "-byte body omitted)");
                }
            }
        }
        else {
            v1 = v;
        }
        try {
            response0 = interceptor$Chain0.proceed(request0);
        }
        catch(Exception exception0) {
            this.logger.log("<-- HTTP FAILED: " + exception0);
            throw exception0;
        }
        long v4 = TimeUnit.NANOSECONDS.toMillis(0L);
        ResponseBody responseBody0 = response0.body();
        q.d(responseBody0);
        long v5 = responseBody0.contentLength();
        this.logger.log("<-- " + response0.code() + (response0.message().length() == 0 ? "" : " " + response0.message()) + ' ' + response0.request().url() + " (" + v4 + "ms" + (z ? "" : ", " + (v5 == -1L ? "unknown-length" : v5 + "-byte") + " body") + ')');
        if(z) {
            Headers headers1 = response0.headers();
            int v6 = headers1.size();
            for(int v7 = 0; v7 < v6; ++v7) {
                this.logHeader(headers1, v7);
            }
            if(v1 != 0 && HttpHeaders.promisesBody(response0)) {
                if(this.bodyHasUnknownEncoding(response0.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                    return response0;
                }
                BufferedSource bufferedSource0 = responseBody0.source();
                bufferedSource0.request(0x7FFFFFFFFFFFFFFFL);
                Buffer buffer1 = bufferedSource0.getBuffer();
                if("gzip".equalsIgnoreCase(headers1.get("Content-Encoding"))) {
                    long0 = buffer1.size();
                    GzipSource gzipSource0 = new GzipSource(buffer1.clone());
                    try {
                        buffer1 = new Buffer();
                        buffer1.writeAll(gzipSource0);
                    }
                    catch(Throwable throwable0) {
                        d8.d.l(gzipSource0, throwable0);
                        throw throwable0;
                    }
                    gzipSource0.close();
                }
                else {
                    long0 = null;
                }
                MediaType mediaType2 = responseBody0.contentType();
                if(mediaType2 == null) {
                    charset1 = StandardCharsets.UTF_8;
                    q.f(charset1, "UTF_8");
                }
                else {
                    charset1 = mediaType2.charset(StandardCharsets.UTF_8);
                    if(charset1 == null) {
                        charset1 = StandardCharsets.UTF_8;
                        q.f(charset1, "UTF_8");
                    }
                }
                if(!Utf8Kt.isProbablyUtf8(buffer1)) {
                    this.logger.log("");
                    this.logger.log("<-- END HTTP (binary " + buffer1.size() + "-byte body omitted)");
                    return response0;
                }
                if(v5 != 0L) {
                    this.logger.log("");
                    String s2 = buffer1.clone().readString(charset1);
                    this.logger.log(s2);
                }
                if(long0 != null) {
                    this.logger.log("<-- END HTTP (" + buffer1.size() + "-byte, " + long0 + "-gzipped-byte body)");
                    return response0;
                }
                this.logger.log("<-- END HTTP (" + buffer1.size() + "-byte body)");
                return response0;
            }
            this.logger.log("<-- END HTTP");
        }
        return response0;
    }

    public final void level(@NotNull Level httpLoggingInterceptor$Level0) {
        q.g(httpLoggingInterceptor$Level0, "<set-?>");
        this.level = httpLoggingInterceptor$Level0;
    }

    private final void logHeader(Headers headers0, int v) {
        String s = this.headersToRedact.contains(headers0.name(v)) ? "██" : headers0.value(v);
        this.logger.log(headers0.name(v) + ": " + s);
    }

    public final void redactHeader(@NotNull String s) {
        q.g(s, "name");
        v.k0();
        TreeSet treeSet0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        u.U(treeSet0, this.headersToRedact);
        treeSet0.add(s);
        this.headersToRedact = treeSet0;
    }

    @NotNull
    public final HttpLoggingInterceptor setLevel(@NotNull Level httpLoggingInterceptor$Level0) {
        q.g(httpLoggingInterceptor$Level0, "level");
        this.level = httpLoggingInterceptor$Level0;
        return this;
    }
}

