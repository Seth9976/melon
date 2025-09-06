package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"okhttp3/internal/http2/Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/internal/http2/Http2Stream;", "stream", "Lie/H;", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1 extends Listener {
    @Override  // okhttp3.internal.http2.Http2Connection$Listener
    public void onStream(@NotNull Http2Stream http2Stream0) {
        q.g(http2Stream0, "stream");
        http2Stream0.close(ErrorCode.REFUSED_STREAM, null);
    }
}

