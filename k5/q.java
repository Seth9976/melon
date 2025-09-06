package k5;

import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;

public final class q extends ForwardingSource {
    public final Buffer a;
    public static final ByteString b;

    static {
        q.b = ByteString.Companion.decodeHex("0021F904");
    }

    public q(BufferedSource bufferedSource0) {
        super(bufferedSource0);
        this.a = new Buffer();
    }

    public final boolean c(long v) {
        Buffer buffer0 = this.a;
        if(Long.compare(buffer0.size(), v) >= 0) {
            return true;
        }
        long v1 = v - buffer0.size();
        return super.read(buffer0, v1) == v1;
    }

    @Override  // okio.ForwardingSource
    public final long read(Buffer buffer0, long v) {
        this.c(v);
        Buffer buffer1 = this.a;
        if(buffer1.size() == 0L) {
            return v == 0L ? 0L : -1L;
        }
        long v1 = 0L;
        while(true) {
            long v2 = -1L;
            do {
                v2 = buffer1.indexOf(q.b.getByte(0), v2 + 1L);
                int v3 = Long.compare(v2, -1L);
            }
            while(v3 != 0 && (!this.c(((long)q.b.size())) || !buffer1.rangeEquals(v2, q.b)));
            if(v3 == 0) {
                break;
            }
            long v4 = buffer1.read(buffer0, v2 + 4L);
            if(v4 < 0L) {
                v4 = 0L;
            }
            v1 += v4;
            if(this.c(5L) && buffer1.getByte(4L) == 0 && ((buffer1.getByte(2L) & 0xFF) << 8 | buffer1.getByte(1L) & 0xFF) < 2) {
                buffer0.writeByte(buffer1.getByte(0L));
                buffer0.writeByte(10);
                buffer0.writeByte(0);
                buffer1.skip(3L);
            }
        }
        if(v1 < v) {
            long v5 = buffer1.read(buffer0, v - v1);
            if(v5 < 0L) {
                v5 = 0L;
            }
            v1 += v5;
        }
        return v1 == 0L ? -1L : v1;
    }
}

