package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.internal.connection.RealConnection;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 #2\u00020\u0001:\u0001#J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\tH&¢\u0006\u0004\b\u000E\u0010\rJ\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001A\u00020\u000FH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0015\u001A\u00020\u0014H&¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001C\u001A\u00020\u001BH&¢\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\tH&¢\u0006\u0004\b\u001E\u0010\rR\u0014\u0010\"\u001A\u00020\u001F8&X¦\u0004¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006$"}, d2 = {"Lokhttp3/internal/http/ExchangeCodec;", "", "Lokhttp3/Request;", "request", "", "contentLength", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;J)Lokio/Sink;", "Lie/H;", "writeRequestHeaders", "(Lokhttp3/Request;)V", "flushRequest", "()V", "finishRequest", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "Lokhttp3/Response;", "response", "reportedContentLength", "(Lokhttp3/Response;)J", "Lokio/Source;", "openResponseBodySource", "(Lokhttp3/Response;)Lokio/Source;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "cancel", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface ExchangeCodec {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/http/ExchangeCodec$Companion;", "", "()V", "DISCARD_STREAM_TIMEOUT_MILLIS", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE = null;
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    static {
        ExchangeCodec.Companion = Companion.$$INSTANCE;
    }

    void cancel();

    @NotNull
    Sink createRequestBody(@NotNull Request arg1, long arg2);

    void finishRequest();

    void flushRequest();

    @NotNull
    RealConnection getConnection();

    @NotNull
    Source openResponseBodySource(@NotNull Response arg1);

    @Nullable
    Builder readResponseHeaders(boolean arg1);

    long reportedContentLength(@NotNull Response arg1);

    @NotNull
    Headers trailers();

    void writeRequestHeaders(@NotNull Request arg1);
}

