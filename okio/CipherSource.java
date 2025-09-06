package okio;

import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\nJ\u000F\u0010\f\u001A\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u001F\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0016\u0010!\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "Lokio/BufferedSource;", "source", "Ljavax/crypto/Cipher;", "cipher", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "Lie/H;", "refill", "()V", "update", "doFinal", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Lokio/BufferedSource;", "Ljavax/crypto/Cipher;", "getCipher", "()Ljavax/crypto/Cipher;", "", "blockSize", "I", "buffer", "Lokio/Buffer;", "", "final", "Z", "closed", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class CipherSource implements Source {
    private final int blockSize;
    @NotNull
    private final Buffer buffer;
    @NotNull
    private final Cipher cipher;
    private boolean closed;
    private boolean final;
    @NotNull
    private final BufferedSource source;

    public CipherSource(@NotNull BufferedSource bufferedSource0, @NotNull Cipher cipher0) {
        q.g(bufferedSource0, "source");
        q.g(cipher0, "cipher");
        super();
        this.source = bufferedSource0;
        this.cipher = cipher0;
        int v = cipher0.getBlockSize();
        this.blockSize = v;
        this.buffer = new Buffer();
        if(v <= 0) {
            throw new IllegalArgumentException(("Block cipher required " + cipher0).toString());
        }
    }

    @Override  // okio.Source
    public void close() {
        this.closed = true;
        this.source.close();
    }

    private final void doFinal() {
        int v = this.cipher.getOutputSize(0);
        if(v != 0) {
            Segment segment0 = this.buffer.writableSegment$okio(v);
            int v1 = this.cipher.doFinal(segment0.data, segment0.pos);
            segment0.limit += v1;
            this.buffer.setSize$okio(this.buffer.size() + ((long)v1));
            if(segment0.pos == segment0.limit) {
                this.buffer.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
        }
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
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
        if(v1 == 0) {
            return 0L;
        }
        this.refill();
        return this.buffer.read(buffer0, v);
    }

    private final void refill() {
        while(this.buffer.size() == 0L && !this.final) {
            if(this.source.exhausted()) {
                this.final = true;
                this.doFinal();
                return;
            }
            this.update();
        }
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    private final void update() {
        Segment segment0 = this.source.getBuffer().head;
        q.d(segment0);
        int v = segment0.limit - segment0.pos;
        int v1 = this.cipher.getOutputSize(v);
        int v2 = v;
        while(v1 > 0x2000) {
            int v3 = this.blockSize;
            if(v2 <= v3) {
                this.final = true;
                byte[] arr_b = this.source.readByteArray();
                byte[] arr_b1 = this.cipher.doFinal(arr_b);
                q.f(arr_b1, "doFinal(...)");
                this.buffer.write(arr_b1);
                return;
            }
            v2 -= v3;
            v1 = this.cipher.getOutputSize(v2);
        }
        Segment segment1 = this.buffer.writableSegment$okio(v1);
        int v4 = this.cipher.update(segment0.data, segment0.pos, v2, segment1.data, segment1.pos);
        this.source.skip(((long)v2));
        segment1.limit += v4;
        this.buffer.setSize$okio(this.buffer.size() + ((long)v4));
        if(segment1.pos == segment1.limit) {
            this.buffer.head = segment1.pop();
            SegmentPool.recycle(segment1);
        }
    }
}

