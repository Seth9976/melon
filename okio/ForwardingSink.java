package okio;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001A\u00020\u00018G¢\u0006\f\n\u0004\b\u0002\u0010\u0017\u001A\u0004\b\u0002\u0010\u0016¨\u0006\u0018"}, d2 = {"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "", "toString", "()Ljava/lang/String;", "-deprecated_delegate", "()Lokio/Sink;", "Lokio/Sink;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ForwardingSink implements Sink {
    @NotNull
    private final Sink delegate;

    @d
    @NotNull
    public final Sink -deprecated_delegate() {
        return this.delegate;
    }

    public ForwardingSink(@NotNull Sink sink0) {
        q.g(sink0, "delegate");
        super();
        this.delegate = sink0;
    }

    @Override  // okio.Sink
    public void close() {
        this.delegate.close();
    }

    @NotNull
    public final Sink delegate() {
        return this.delegate;
    }

    @Override  // okio.Sink
    public void flush() {
        this.delegate.flush();
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override
    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        this.delegate.write(buffer0, v);
    }
}

