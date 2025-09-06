package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u0018"}, d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "Ljava/io/OutputStream;", "out", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "Ljava/io/OutputStream;", "Lokio/Timeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class OutputStreamSink implements Sink {
    @NotNull
    private final OutputStream out;
    @NotNull
    private final Timeout timeout;

    public OutputStreamSink(@NotNull OutputStream outputStream0, @NotNull Timeout timeout0) {
        q.g(outputStream0, "out");
        q.g(timeout0, "timeout");
        super();
        this.out = outputStream0;
        this.timeout = timeout0;
    }

    @Override  // okio.Sink
    public void close() {
        this.out.close();
    }

    @Override  // okio.Sink
    public void flush() {
        this.out.flush();
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @Override
    @NotNull
    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        while(v > 0L) {
            this.timeout.throwIfReached();
            Segment segment0 = buffer0.head;
            q.d(segment0);
            int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
            this.out.write(segment0.data, segment0.pos, v1);
            segment0.pos += v1;
            v -= (long)v1;
            buffer0.setSize$okio(buffer0.size() - ((long)v1));
            if(segment0.pos == segment0.limit) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
        }
    }
}

