package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\r\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\r\u0010\u0011J\'\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J)\u0010\u001A\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lokhttp3/WebSocketListener;", "", "<init>", "()V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "Lie/H;", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", "text", "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", "code", "reason", "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class WebSocketListener {
    public void onClosed(@NotNull WebSocket webSocket0, int v, @NotNull String s) {
        q.g(webSocket0, "webSocket");
        q.g(s, "reason");
    }

    public void onClosing(@NotNull WebSocket webSocket0, int v, @NotNull String s) {
        q.g(webSocket0, "webSocket");
        q.g(s, "reason");
    }

    public void onFailure(@NotNull WebSocket webSocket0, @NotNull Throwable throwable0, @Nullable Response response0) {
        q.g(webSocket0, "webSocket");
        q.g(throwable0, "t");
    }

    public void onMessage(@NotNull WebSocket webSocket0, @NotNull String s) {
        q.g(webSocket0, "webSocket");
        q.g(s, "text");
    }

    public void onMessage(@NotNull WebSocket webSocket0, @NotNull ByteString byteString0) {
        q.g(webSocket0, "webSocket");
        q.g(byteString0, "bytes");
    }

    public void onOpen(@NotNull WebSocket webSocket0, @NotNull Response response0) {
        q.g(webSocket0, "webSocket");
        q.g(response0, "response");
    }
}

