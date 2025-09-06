package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0011R#\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/FaultHidingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "Lkotlin/Function1;", "Ljava/io/IOException;", "Lie/H;", "onException", "<init>", "(Lokio/Sink;Lwe/k;)V", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lwe/k;", "getOnException", "()Lwe/k;", "", "hasErrors", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    @NotNull
    private final k onException;

    public FaultHidingSink(@NotNull Sink sink0, @NotNull k k0) {
        q.g(sink0, "delegate");
        q.g(k0, "onException");
        super(sink0);
        this.onException = k0;
    }

    @Override  // okio.ForwardingSink
    public void close() {
        if(this.hasErrors) {
            return;
        }
        try {
            super.close();
        }
        catch(IOException iOException0) {
            this.hasErrors = true;
            this.onException.invoke(iOException0);
        }
    }

    @Override  // okio.ForwardingSink
    public void flush() {
        if(this.hasErrors) {
            return;
        }
        try {
            super.flush();
        }
        catch(IOException iOException0) {
            this.hasErrors = true;
            this.onException.invoke(iOException0);
        }
    }

    @NotNull
    public final k getOnException() {
        return this.onException;
    }

    @Override  // okio.ForwardingSink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        if(this.hasErrors) {
            buffer0.skip(v);
            return;
        }
        try {
            super.write(buffer0, v);
        }
        catch(IOException iOException0) {
            this.hasErrors = true;
            this.onException.invoke(iOException0);
        }
    }
}

