package s3;

import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.x;

public final class e extends o {
    public final long f;
    public final long g;
    public final long h;
    public final boolean i;

    public e(p0 p00, long v, long v1) {
        super(p00);
        boolean z = false;
        if(p00.h() != 1) {
            throw new f(0);
        }
        o0 o00 = p00.m(0, new o0(), 0L);
        long v2 = Math.max(0L, v);
        if(!o00.k && v2 != 0L && !o00.h) {
            throw new f(1);
        }
        long v3 = v1 == 0x8000000000000000L ? o00.m : Math.max(0L, v1);
        long v4 = o00.m;
        if(v4 != 0x8000000000000001L) {
            long v5 = v3 <= v4 ? v3 : v4;
            if(v2 > v5) {
                throw new f(2, v2, v5);
            }
            v3 = v5;
        }
        this.f = v2;
        this.g = v3;
        int v6 = Long.compare(v3, 0x8000000000000001L);
        this.h = v6 == 0 ? 0x8000000000000001L : v3 - v2;
        if(o00.i && (v6 == 0 || v4 != 0x8000000000000001L && v3 == v4)) {
            z = true;
        }
        this.i = z;
    }

    @Override  // s3.o
    public final m0 f(int v, m0 m00, boolean z) {
        this.e.f(0, m00, z);
        long v1 = m00.e - this.f;
        m00.i(m00.a, m00.b, 0, (this.h == 0x8000000000000001L ? 0x8000000000000001L : this.h - v1), v1, b.f, false);
        return m00;
    }

    @Override  // s3.o
    public final o0 m(int v, o0 o00, long v1) {
        this.e.m(0, o00, 0L);
        long v2 = this.f;
        o00.p += v2;
        o00.m = this.h;
        o00.i = this.i;
        long v3 = o00.l;
        if(v3 != 0x8000000000000001L) {
            long v4 = Math.max(v3, v2);
            o00.l = v4;
            long v5 = this.g;
            if(v5 != 0x8000000000000001L) {
                v4 = Math.min(v4, v5);
            }
            o00.l = v4 - v2;
        }
        long v6 = x.Z(v2);
        long v7 = o00.e;
        if(v7 != 0x8000000000000001L) {
            o00.e = v7 + v6;
        }
        long v8 = o00.f;
        if(v8 != 0x8000000000000001L) {
            o00.f = v8 + v6;
        }
        return o00;
    }
}

