package okio;

import ie.d;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\f\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\rJ\u000F\u0010\u0010\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J\u0013\u0010\u0019\u001A\u00060\u0015j\u0002`\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001BR\u001B\u0010\u0019\u001A\u00060\u0015j\u0002`\u00168G¢\u0006\f\n\u0004\b\u0019\u0010\u001C\u001A\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0016\u0010!\u001A\u00020 8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001A\u00060#j\u0002`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006\'"}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lie/H;", "writeFooter", "()V", "Lokio/Buffer;", "buffer", "", "byteCount", "updateCrc", "(Lokio/Buffer;J)V", "source", "write", "flush", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "Ljava/util/zip/Deflater;", "Lokio/Deflater;", "-deprecated_deflater", "()Ljava/util/zip/Deflater;", "deflater", "Lokio/RealBufferedSink;", "Lokio/RealBufferedSink;", "Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "deflaterSink", "Lokio/DeflaterSink;", "", "closed", "Z", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "crc", "Ljava/util/zip/CRC32;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class GzipSink implements Sink {
    private boolean closed;
    @NotNull
    private final CRC32 crc;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final DeflaterSink deflaterSink;
    @NotNull
    private final RealBufferedSink sink;

    @d
    @NotNull
    public final Deflater -deprecated_deflater() {
        return this.deflater;
    }

    public GzipSink(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        super();
        RealBufferedSink realBufferedSink0 = new RealBufferedSink(sink0);
        this.sink = realBufferedSink0;
        Deflater deflater0 = new Deflater(-1, true);
        this.deflater = deflater0;
        this.deflaterSink = new DeflaterSink(realBufferedSink0, deflater0);
        this.crc = new CRC32();
        realBufferedSink0.bufferField.writeShort(8075);
        realBufferedSink0.bufferField.writeByte(8);
        realBufferedSink0.bufferField.writeByte(0);
        realBufferedSink0.bufferField.writeInt(0);
        realBufferedSink0.bufferField.writeByte(0);
        realBufferedSink0.bufferField.writeByte(0);
    }

    @Override  // okio.Sink
    public void close() {
        if(!this.closed) {
            try {
                this.deflaterSink.finishDeflate$okio();
                this.writeFooter();
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

    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override  // okio.Sink
    public void flush() {
        this.deflaterSink.flush();
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    private final void updateCrc(Buffer buffer0, long v) {
        Segment segment0 = buffer0.head;
        q.d(segment0);
        while(v > 0L) {
            int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
            this.crc.update(segment0.data, segment0.pos, v1);
            v -= (long)v1;
            segment0 = segment0.next;
            q.d(segment0);
        }
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(v1 == 0) {
            return;
        }
        this.updateCrc(buffer0, v);
        this.deflaterSink.write(buffer0, v);
    }

    private final void writeFooter() {
        int v = (int)this.crc.getValue();
        this.sink.writeIntLe(v);
        int v1 = (int)this.deflater.getBytesRead();
        this.sink.writeIntLe(v1);
    }
}

