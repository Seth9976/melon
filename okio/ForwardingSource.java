package okio;

import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001A\u00020\u00018G¢\u0006\f\n\u0004\b\u0002\u0010\u0016\u001A\u0004\b\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lie/H;", "close", "()V", "", "toString", "()Ljava/lang/String;", "-deprecated_delegate", "()Lokio/Source;", "Lokio/Source;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ForwardingSource implements Source {
    @NotNull
    private final Source delegate;

    @d
    @NotNull
    public final Source -deprecated_delegate() {
        return this.delegate;
    }

    public ForwardingSource(@NotNull Source source0) {
        q.g(source0, "delegate");
        super();
        this.delegate = source0;
    }

    @Override  // okio.Source
    public void close() {
        this.delegate.close();
    }

    @NotNull
    public final Source delegate() {
        return this.delegate;
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        return this.delegate.read(buffer0, v);
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override
    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}

