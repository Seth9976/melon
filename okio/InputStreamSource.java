package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.internal._JavaIoKt;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\f\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "Ljava/io/InputStream;", "input", "Lokio/Timeout;", "timeout", "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "close", "()V", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "Ljava/io/InputStream;", "Lokio/Timeout;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
class InputStreamSource implements Source {
    @NotNull
    private final InputStream input;
    @NotNull
    private final Timeout timeout;

    public InputStreamSource(@NotNull InputStream inputStream0, @NotNull Timeout timeout0) {
        q.g(inputStream0, "input");
        q.g(timeout0, "timeout");
        super();
        this.input = inputStream0;
        this.timeout = timeout0;
    }

    @Override  // okio.Source
    public void close() {
        this.input.close();
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 == 0) {
            return 0L;
        }
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment segment0 = buffer0.writableSegment$okio(1);
            int v2 = this.input.read(segment0.data, segment0.limit, ((int)Math.min(v, 0x2000 - segment0.limit)));
            if(v2 == -1) {
                if(segment0.pos == segment0.limit) {
                    buffer0.head = segment0.pop();
                    SegmentPool.recycle(segment0);
                    return -1L;
                }
                return -1L;
            }
            segment0.limit += v2;
            buffer0.setSize$okio(buffer0.size() + ((long)v2));
            return (long)v2;
        }
        catch(AssertionError assertionError0) {
        }
        if(!_JavaIoKt.isAndroidGetsocknameError(assertionError0)) {
            throw assertionError0;
        }
        throw new IOException(assertionError0);
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @Override
    @NotNull
    public String toString() {
        return "source(" + this.input + ')';
    }
}

