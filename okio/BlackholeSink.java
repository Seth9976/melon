package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000F\u0010\u0003¨\u0006\u0010"}, d2 = {"Lokio/BlackholeSink;", "Lokio/Sink;", "<init>", "()V", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class BlackholeSink implements Sink {
    @Override  // okio.Sink
    public void close() {
    }

    @Override  // okio.Sink
    public void flush() {
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        buffer0.skip(v);
    }
}

