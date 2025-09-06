package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001B\u0010\r\u001A\u00020\f*\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0015\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "size", "", "truncate", "<init>", "(Lokio/Source;JZ)V", "Lokio/Buffer;", "newSize", "Lie/H;", "truncateToSize", "(Lokio/Buffer;J)V", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "J", "Z", "bytesReceived", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(@NotNull Source source0, long v, boolean z) {
        q.g(source0, "delegate");
        super(source0);
        this.size = v;
        this.truncate = z;
    }

    @Override  // okio.ForwardingSource
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        long v1 = this.bytesReceived;
        long v2 = this.size;
        if(Long.compare(v1, v2) > 0) {
            v = 0L;
        }
        else if(this.truncate) {
            long v3 = v2 - v1;
            if(v3 == 0L) {
                return -1L;
            }
            v = Math.min(v, v3);
        }
        long v4 = super.read(buffer0, v);
        int v5 = Long.compare(v4, -1L);
        if(v5 != 0) {
            this.bytesReceived += v4;
        }
        long v6 = this.bytesReceived;
        long v7 = this.size;
        if(v6 < v7 && v5 == 0 || v6 > v7) {
            if(v4 > 0L && v6 > v7) {
                this.truncateToSize(buffer0, buffer0.size() - (this.bytesReceived - this.size));
            }
            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }
        return v4;
    }

    private final void truncateToSize(Buffer buffer0, long v) {
        Buffer buffer1 = new Buffer();
        buffer1.writeAll(buffer0);
        buffer0.write(buffer1, v);
        buffer1.clear();
    }
}

