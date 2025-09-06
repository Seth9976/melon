package okhttp3.internal.connection;

import e2.a;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\u0006R\u0017\u0010\u0004\u001A\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001A\u0004\b\u000B\u0010\fR$\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00038\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u000E\u0010\n\u001A\u0004\b\u000F\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/connection/RouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/io/IOException;", "firstConnectException", "<init>", "(Ljava/io/IOException;)V", "e", "Lie/H;", "addConnectException", "Ljava/io/IOException;", "getFirstConnectException", "()Ljava/io/IOException;", "<set-?>", "lastConnectException", "getLastConnectException", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RouteException extends RuntimeException {
    @NotNull
    private final IOException firstConnectException;
    @NotNull
    private IOException lastConnectException;

    public RouteException(@NotNull IOException iOException0) {
        q.g(iOException0, "firstConnectException");
        super(iOException0);
        this.firstConnectException = iOException0;
        this.lastConnectException = iOException0;
    }

    public final void addConnectException(@NotNull IOException iOException0) {
        q.g(iOException0, "e");
        a.q(this.firstConnectException, iOException0);
        this.lastConnectException = iOException0;
    }

    @NotNull
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    @NotNull
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}

