package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\n\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001C\u001A\u00020\u001B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0016\u0010\u001E\u001A\u00020\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "Lokio/BufferedSource;", "upstream", "<init>", "(Lokio/BufferedSource;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lie/H;", "close", "()V", "Lokio/BufferedSource;", "buffer", "Lokio/Buffer;", "Lokio/Segment;", "expectedSegment", "Lokio/Segment;", "", "expectedPos", "I", "", "closed", "Z", "pos", "J", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class PeekSource implements Source {
    @NotNull
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    @Nullable
    private Segment expectedSegment;
    private long pos;
    @NotNull
    private final BufferedSource upstream;

    public PeekSource(@NotNull BufferedSource bufferedSource0) {
        q.g(bufferedSource0, "upstream");
        super();
        this.upstream = bufferedSource0;
        Buffer buffer0 = bufferedSource0.getBuffer();
        this.buffer = buffer0;
        this.expectedSegment = buffer0.head;
        this.expectedPos = buffer0.head == null ? -1 : buffer0.head.pos;
    }

    @Override  // okio.Source
    public void close() {
        this.closed = true;
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        Segment segment0 = this.expectedSegment;
        if(segment0 != null) {
            Segment segment1 = this.buffer.head;
            if(segment0 != segment1) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            }
            int v2 = this.expectedPos;
            q.d(segment1);
            if(v2 != segment1.pos) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            }
        }
        if(v1 == 0) {
            return 0L;
        }
        if(!this.upstream.request(this.pos + 1L)) {
            return -1L;
        }
        if(this.expectedSegment == null) {
            Segment segment2 = this.buffer.head;
            if(segment2 != null) {
                this.expectedSegment = segment2;
                q.d(segment2);
                this.expectedPos = segment2.pos;
            }
        }
        long v3 = Math.min(v, this.buffer.size() - this.pos);
        this.buffer.copyTo(buffer0, this.pos, v3);
        this.pos += v3;
        return v3;
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}

