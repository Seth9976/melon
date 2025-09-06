package okhttp3.internal.http2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J%\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000B\u001A\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0007H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/http2/PushObserver;", "", "", "streamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "onRequest", "(ILjava/util/List;)Z", "responseHeaders", "last", "onHeaders", "(ILjava/util/List;Z)Z", "Lokio/BufferedSource;", "source", "byteCount", "onData", "(ILokio/BufferedSource;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lie/H;", "onReset", "(ILokhttp3/internal/http2/ErrorCode;)V", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface PushObserver {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/http2/PushObserver$Companion;", "", "()V", "CANCEL", "Lokhttp3/internal/http2/PushObserver;", "PushObserverCancel", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000BJ-\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ/\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lokhttp3/internal/http2/PushObserver$Companion$PushObserverCancel;", "Lokhttp3/internal/http2/PushObserver;", "<init>", "()V", "", "streamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "onRequest", "(ILjava/util/List;)Z", "responseHeaders", "last", "onHeaders", "(ILjava/util/List;Z)Z", "Lokio/BufferedSource;", "source", "byteCount", "onData", "(ILokio/BufferedSource;IZ)Z", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lie/H;", "onReset", "(ILokhttp3/internal/http2/ErrorCode;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        static final class PushObserverCancel implements PushObserver {
            @Override  // okhttp3.internal.http2.PushObserver
            public boolean onData(int v, @NotNull BufferedSource bufferedSource0, int v1, boolean z) {
                q.g(bufferedSource0, "source");
                bufferedSource0.skip(((long)v1));
                return true;
            }

            @Override  // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int v, @NotNull List list0, boolean z) {
                q.g(list0, "responseHeaders");
                return true;
            }

            @Override  // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int v, @NotNull List list0) {
                q.g(list0, "requestHeaders");
                return true;
            }

            @Override  // okhttp3.internal.http2.PushObserver
            public void onReset(int v, @NotNull ErrorCode errorCode0) {
                q.g(errorCode0, "errorCode");
            }
        }

        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @NotNull
    public static final PushObserver CANCEL;
    @NotNull
    public static final Companion Companion;

    static {
        PushObserver.Companion = Companion.$$INSTANCE;
        PushObserver.CANCEL = new PushObserverCancel();
    }

    boolean onData(int arg1, @NotNull BufferedSource arg2, int arg3, boolean arg4);

    boolean onHeaders(int arg1, @NotNull List arg2, boolean arg3);

    boolean onRequest(int arg1, @NotNull List arg2);

    void onReset(int arg1, @NotNull ErrorCode arg2);
}

