package okio.internal;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.AsyncTimeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000E"}, d2 = {"Lokio/internal/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lie/H;", "timedOut", "()V", "Ljava/net/Socket;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SocketAsyncTimeout extends AsyncTimeout {
    @NotNull
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket0) {
        q.g(socket0, "socket");
        super();
        this.socket = socket0;
    }

    @Override  // okio.AsyncTimeout
    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException0) {
        IOException iOException1 = new SocketTimeoutException("timeout");
        if(iOException0 != null) {
            iOException1.initCause(iOException0);
        }
        return iOException1;
    }

    @Override  // okio.AsyncTimeout
    public void timedOut() {
        try {
            this.socket.close();
        }
        catch(Exception exception0) {
            _JavaIoKt.access$getLogger$p().log(Level.WARNING, "Failed to close timed out socket " + this.socket, exception0);
        }
        catch(AssertionError assertionError0) {
            if(!_JavaIoKt.isAndroidGetsocknameError(assertionError0)) {
                throw assertionError0;
            }
            _JavaIoKt.access$getLogger$p().log(Level.WARNING, "Failed to close timed out socket " + this.socket, assertionError0);
        }
    }
}

