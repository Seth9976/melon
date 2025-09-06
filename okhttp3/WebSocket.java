package okhttp3;

import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH&¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000B\u0010\u000FJ!\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokhttp3/WebSocket;", "", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "", "queueSize", "()J", "", "text", "", "send", "(Ljava/lang/String;)Z", "Lokio/ByteString;", "bytes", "(Lokio/ByteString;)Z", "", "code", "reason", "close", "(ILjava/lang/String;)Z", "Lie/H;", "cancel", "()V", "Factory", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface WebSocket {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&¨\u0006\b"}, d2 = {"Lokhttp3/WebSocket$Factory;", "", "newWebSocket", "Lokhttp3/WebSocket;", "request", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Factory {
        @NotNull
        WebSocket newWebSocket(@NotNull Request arg1, @NotNull WebSocketListener arg2);
    }

    void cancel();

    boolean close(int arg1, @Nullable String arg2);

    long queueSize();

    @NotNull
    Request request();

    boolean send(@NotNull String arg1);

    boolean send(@NotNull ByteString arg1);
}

