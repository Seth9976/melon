package okio;

import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u0017R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001CR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001A\u00020\"8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "Lokio/BufferedSink;", "sink", "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "Lokio/Buffer;", "source", "", "remaining", "", "update", "(Lokio/Buffer;J)I", "", "doFinal", "()Ljava/lang/Throwable;", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/BufferedSink;", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", "I", "", "closed", "Z", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class CipherSink implements Sink {
    private final int blockSize;
    @NotNull
    private final Cipher cipher;
    private boolean closed;
    @NotNull
    private final BufferedSink sink;

    public CipherSink(@NotNull BufferedSink bufferedSink0, @NotNull Cipher cipher0) {
        q.g(bufferedSink0, "sink");
        q.g(cipher0, "cipher");
        super();
        this.sink = bufferedSink0;
        this.cipher = cipher0;
        int v = cipher0.getBlockSize();
        this.blockSize = v;
        if(v <= 0) {
            throw new IllegalArgumentException(("Block cipher required " + cipher0).toString());
        }
    }

    @Override  // okio.Sink
    public void close() {
        if(!this.closed) {
            this.closed = true;
            Throwable throwable0 = this.doFinal();
            try {
                this.sink.close();
            }
            catch(Throwable throwable1) {
                if(throwable0 == null) {
                    throwable0 = throwable1;
                }
            }
            if(throwable0 != null) {
                throw throwable0;
            }
        }
    }

    private final Throwable doFinal() {
        int v = this.cipher.getOutputSize(0);
        Throwable throwable0 = null;
        if(v == 0) {
            return null;
        }
        if(v > 0x2000) {
            try {
                byte[] arr_b = this.cipher.doFinal();
                q.f(arr_b, "doFinal(...)");
                this.sink.write(arr_b);
                return null;
            }
            catch(Throwable throwable1) {
                return throwable1;
            }
        }
        Buffer buffer0 = this.sink.getBuffer();
        Segment segment0 = buffer0.writableSegment$okio(v);
        try {
            int v1 = this.cipher.doFinal(segment0.data, segment0.limit);
            segment0.limit += v1;
            buffer0.setSize$okio(buffer0.size() + ((long)v1));
        }
        catch(Throwable throwable0) {
        }
        if(segment0.pos == segment0.limit) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return throwable0;
    }

    @Override  // okio.Sink
    public void flush() {
        this.sink.flush();
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    private final int update(Buffer buffer0, long v) {
        Segment segment0 = buffer0.head;
        q.d(segment0);
        int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
        Buffer buffer1 = this.sink.getBuffer();
        int v2 = this.cipher.getOutputSize(v1);
        int v3 = v1;
        while(v2 > 0x2000) {
            int v4 = this.blockSize;
            if(v3 <= v4) {
                byte[] arr_b = buffer0.readByteArray(v);
                byte[] arr_b1 = this.cipher.update(arr_b);
                q.f(arr_b1, "update(...)");
                this.sink.write(arr_b1);
                return (int)v;
            }
            v3 -= v4;
            v2 = this.cipher.getOutputSize(v3);
        }
        Segment segment1 = buffer1.writableSegment$okio(v2);
        int v5 = this.cipher.update(segment0.data, segment0.pos, v3, segment1.data, segment1.limit);
        segment1.limit += v5;
        buffer1.setSize$okio(buffer1.size() + ((long)v5));
        if(segment1.pos == segment1.limit) {
            buffer1.head = segment1.pop();
            SegmentPool.recycle(segment1);
        }
        this.sink.emitCompleteSegments();
        buffer0.setSize$okio(buffer0.size() - ((long)v3));
        int v6 = segment0.pos + v3;
        segment0.pos = v6;
        if(v6 == segment0.limit) {
            buffer0.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return v3;
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        for(long v1 = v; v1 > 0L; v1 -= (long)this.update(buffer0, v1)) {
        }
    }
}

