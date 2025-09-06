package okio;

import Tf.o;
import U4.x;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\'\u0010\u000E\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001D\u0010\u0007R\u0016\u0010\u001F\u001A\u00020\u001E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010\u0002\u001A\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\"R\u0018\u0010%\u001A\u00060#j\u0002`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001A\u00060*j\u0002`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "Lie/H;", "consumeHeader", "()V", "consumeTrailer", "Lokio/Buffer;", "buffer", "", "offset", "byteCount", "updateCrc", "(Lokio/Buffer;JJ)V", "", "name", "", "expected", "actual", "checkEqual", "(Ljava/lang/String;II)V", "sink", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "", "section", "B", "Lokio/RealBufferedSource;", "Lokio/RealBufferedSource;", "Ljava/util/zip/Inflater;", "Lokio/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/InflaterSource;", "inflaterSource", "Lokio/InflaterSource;", "Ljava/util/zip/CRC32;", "Lokio/internal/CRC32;", "crc", "Ljava/util/zip/CRC32;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class GzipSource implements Source {
    @NotNull
    private final CRC32 crc;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final InflaterSource inflaterSource;
    private byte section;
    @NotNull
    private final RealBufferedSource source;

    public GzipSource(@NotNull Source source0) {
        q.g(source0, "source");
        super();
        RealBufferedSource realBufferedSource0 = new RealBufferedSource(source0);
        this.source = realBufferedSource0;
        Inflater inflater0 = new Inflater(true);
        this.inflater = inflater0;
        this.inflaterSource = new InflaterSource(realBufferedSource0, inflater0);
        this.crc = new CRC32();
    }

    private final void checkEqual(String s, int v, int v1) {
        if(v1 == v) {
            return;
        }
        StringBuilder stringBuilder0 = x.p(s, ": actual 0x");
        stringBuilder0.append(o.L0(8, -SegmentedByteString.toHexString(v1)));
        stringBuilder0.append(" != expected 0x");
        stringBuilder0.append(o.L0(8, -SegmentedByteString.toHexString(v)));
        throw new IOException(stringBuilder0.toString());
    }

    @Override  // okio.Source
    public void close() {
        this.inflaterSource.close();
    }

    private final void consumeHeader() {
        this.source.require(10L);
        int v = this.source.bufferField.getByte(3L);
        boolean z = (v >> 1 & 1) == 1;
        if(z) {
            this.updateCrc(this.source.bufferField, 0L, 10L);
        }
        this.checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if((v >> 2 & 1) == 1) {
            this.source.require(2L);
            if(z) {
                this.updateCrc(this.source.bufferField, 0L, 2L);
            }
            int v1 = this.source.bufferField.readShortLe();
            this.source.require(((long)(v1 & 0xFFFF)));
            if(z) {
                this.updateCrc(this.source.bufferField, 0L, ((long)(v1 & 0xFFFF)));
            }
            this.source.skip(((long)(v1 & 0xFFFF)));
        }
        if((v >> 3 & 1) == 1) {
            long v2 = this.source.indexOf(0);
            if(v2 == -1L) {
                throw new EOFException();
            }
            if(z) {
                this.updateCrc(this.source.bufferField, 0L, v2 + 1L);
            }
            this.source.skip(v2 + 1L);
        }
        if((v >> 4 & 1) == 1) {
            long v3 = this.source.indexOf(0);
            if(v3 == -1L) {
                throw new EOFException();
            }
            if(z) {
                this.updateCrc(this.source.bufferField, 0L, v3 + 1L);
            }
            this.source.skip(v3 + 1L);
        }
        if(z) {
            this.checkEqual("FHCRC", this.source.readShortLe(), ((int)(((short)(((int)this.crc.getValue()))))));
            this.crc.reset();
        }
    }

    private final void consumeTrailer() {
        this.checkEqual("CRC", this.source.readIntLe(), ((int)this.crc.getValue()));
        this.checkEqual("ISIZE", this.source.readIntLe(), ((int)this.inflater.getBytesWritten()));
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(v1 == 0) {
            return 0L;
        }
        if(this.section == 0) {
            this.consumeHeader();
            this.section = 1;
        }
        if(this.section == 1) {
            long v2 = buffer0.size();
            long v3 = this.inflaterSource.read(buffer0, v);
            if(v3 != -1L) {
                this.updateCrc(buffer0, v2, v3);
                return v3;
            }
            this.section = 2;
        }
        if(this.section == 2) {
            this.consumeTrailer();
            this.section = 3;
            if(!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    private final void updateCrc(Buffer buffer0, long v, long v1) {
        Segment segment0 = buffer0.head;
        q.d(segment0);
        while(true) {
            int v2 = segment0.limit;
            int v3 = segment0.pos;
            if(v < ((long)(v2 - v3))) {
                break;
            }
            v -= (long)(v2 - v3);
            segment0 = segment0.next;
            q.d(segment0);
        }
        while(v1 > 0L) {
            int v4 = (int)(((long)segment0.pos) + v);
            int v5 = (int)Math.min(segment0.limit - v4, v1);
            this.crc.update(segment0.data, v4, v5);
            v1 -= (long)v5;
            segment0 = segment0.next;
            q.d(segment0);
            v = 0L;
        }
    }
}

