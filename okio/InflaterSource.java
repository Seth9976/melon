package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u0012\u0010\u0011J\r\u0010\u0014\u001A\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u000BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001AR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001BR\u0016\u0010\u001D\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "Lokio/BufferedSource;", "source", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lie/H;", "releaseBytesAfterInflate", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "readOrInflate", "", "refill", "()Z", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/BufferedSource;", "Ljava/util/zip/Inflater;", "", "bufferBytesHeldByInflater", "I", "closed", "Z", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final BufferedSource source;

    public InflaterSource(@NotNull BufferedSource bufferedSource0, @NotNull Inflater inflater0) {
        q.g(bufferedSource0, "source");
        q.g(inflater0, "inflater");
        super();
        this.source = bufferedSource0;
        this.inflater = inflater0;
    }

    public InflaterSource(@NotNull Source source0, @NotNull Inflater inflater0) {
        q.g(source0, "source");
        q.g(inflater0, "inflater");
        this(Okio.buffer(source0), inflater0);
    }

    @Override  // okio.Source
    public void close() {
        if(this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        while(true) {
            long v1 = this.readOrInflate(buffer0, v);
            if(v1 > 0L) {
                return v1;
            }
            if(this.inflater.finished() || this.inflater.needsDictionary()) {
                break;
            }
            if(this.source.exhausted()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        return -1L;
    }

    public final long readOrInflate(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(v1 == 0) {
            return 0L;
        }
        try {
            Segment segment0 = buffer0.writableSegment$okio(1);
            int v2 = (int)Math.min(v, 0x2000 - segment0.limit);
            this.refill();
            int v3 = this.inflater.inflate(segment0.data, segment0.limit, v2);
            this.releaseBytesAfterInflate();
            if(v3 > 0) {
                segment0.limit += v3;
                buffer0.setSize$okio(buffer0.size() + ((long)v3));
                return (long)v3;
            }
            if(segment0.pos == segment0.limit) {
                buffer0.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            return 0L;
        }
        catch(DataFormatException dataFormatException0) {
        }
        throw new IOException(dataFormatException0);
    }

    public final boolean refill() {
        if(!this.inflater.needsInput()) {
            return false;
        }
        if(this.source.exhausted()) {
            return true;
        }
        Segment segment0 = this.source.getBuffer().head;
        q.d(segment0);
        int v = segment0.limit - segment0.pos;
        this.bufferBytesHeldByInflater = v;
        this.inflater.setInput(segment0.data, segment0.pos, v);
        return false;
    }

    private final void releaseBytesAfterInflate() {
        int v = this.bufferBytesHeldByInflater;
        if(v == 0) {
            return;
        }
        int v1 = v - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= v1;
        this.source.skip(((long)v1));
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}

