package okhttp3;

import kotlin.Metadata;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH&¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\nH&¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH&¢\u0006\u0004\b\u0012\u0010\u0011J\u000F\u0010\u0014\u001A\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0000H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lokhttp3/Call;", "", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "Lie/H;", "enqueue", "(Lokhttp3/Callback;)V", "cancel", "()V", "", "isExecuted", "()Z", "isCanceled", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "clone", "()Lokhttp3/Call;", "Factory", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface Call extends Cloneable {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lokhttp3/Call$Factory;", "", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Factory {
        @NotNull
        Call newCall(@NotNull Request arg1);
    }

    void cancel();

    @NotNull
    Call clone();

    void enqueue(@NotNull Callback arg1);

    @NotNull
    Response execute();

    boolean isCanceled();

    boolean isExecuted();

    @NotNull
    Request request();

    @NotNull
    Timeout timeout();
}

