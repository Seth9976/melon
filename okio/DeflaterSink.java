package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u000F\u0010\u0018\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010!\u001A\u00020\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljava/util/zip/Deflater;", "deflater", "<init>", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "", "syncFlush", "Lie/H;", "deflate", "(Z)V", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "flush", "()V", "finishDeflate$okio", "finishDeflate", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "Lokio/BufferedSink;", "Ljava/util/zip/Deflater;", "closed", "Z", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DeflaterSink implements Sink {
    private boolean closed;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink bufferedSink0, @NotNull Deflater deflater0) {
        q.g(bufferedSink0, "sink");
        q.g(deflater0, "deflater");
        super();
        this.sink = bufferedSink0;
        this.deflater = deflater0;
    }

    public DeflaterSink(@NotNull Sink sink0, @NotNull Deflater deflater0) {
        q.g(sink0, "sink");
        q.g(deflater0, "deflater");
        this(Okio.buffer(sink0), deflater0);
    }

    @Override  // okio.Sink
    public void close() {
        if(!this.closed) {
            try {
                this.finishDeflate$okio();
                throwable0 = null;
            }
            catch(Throwable throwable0) {
            }
            try {
                this.deflater.end();
            }
            catch(Throwable throwable1) {
                if(throwable0 == null) {
                    throwable0 = throwable1;
                }
            }
            try {
                this.sink.close();
            }
            catch(Throwable throwable2) {
                if(throwable0 == null) {
                    throwable0 = throwable2;
                }
            }
            this.closed = true;
            if(throwable0 != null) {
                throw throwable0;
            }
        }
    }

    private final void deflate(boolean z) {
        int v;
        Segment segment0;
        Buffer buffer0 = this.sink.getBuffer();
        while(true) {
            segment0 = buffer0.writableSegment$okio(1);
            try {
                v = z ? this.deflater.deflate(segment0.data, segment0.limit, 0x2000 - segment0.limit, 2) : this.deflater.deflate(segment0.data, segment0.limit, 0x2000 - segment0.limit);
            }
            catch(NullPointerException nullPointerException0) {
                throw new IOException("Deflater already closed", nullPointerException0);
            }
            if(v > 0) {
                segment0.limit += v;
                buffer0.setSize$okio(buffer0.size() + ((long)v));
                this.sink.emitCompleteSegments();
            }
            else if(this.deflater.needsInput()) {
                break;
            }
        }
        if(segment0.pos == segment0.limit) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        this.deflate(false);
    }

    @Override  // okio.Sink
    public void flush() {
        this.deflate(true);
        this.sink.flush();
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        while(Long.compare(v, 0L) > 0) {
            Segment segment0 = buffer0.head;
            q.d(segment0);
            int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
            this.deflater.setInput(segment0.data, segment0.pos, v1);
            this.deflate(false);
            buffer0.setSize$okio(buffer0.size() - ((long)v1));
            int v2 = segment0.pos + v1;
            segment0.pos = v2;
            if(v2 == segment0.limit) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            v -= (long)v1;
        }
        this.deflater.setInput(new byte[0], 0, 0);
    }
}

