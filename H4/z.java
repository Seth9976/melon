package h4;

import B3.s;
import e3.p;
import e3.v;
import e3.x;

public final class z {
    public final int a;
    public final v b;
    public final p c;
    public boolean d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public long i;

    public z(int v) {
        this.a = v;
        if(v != 1) {
            super();
            this.b = new v(0L);
            this.g = 0x8000000000000001L;
            this.h = 0x8000000000000001L;
            this.i = 0x8000000000000001L;
            this.c = new p();
            return;
        }
        super();
        this.b = new v(0L);
        this.g = 0x8000000000000001L;
        this.h = 0x8000000000000001L;
        this.i = 0x8000000000000001L;
        this.c = new p();
    }

    public final void a(s s0) {
        if(this.a != 0) {
            this.c.getClass();
            this.c.E(x.f, x.f.length);
            this.d = true;
            s0.resetPeekPosition();
            return;
        }
        this.c.getClass();
        this.c.E(x.f, x.f.length);
        this.d = true;
        s0.resetPeekPosition();
    }

    public static int b(byte[] arr_b, int v) {
        return arr_b[v + 3] & 0xFF | ((arr_b[v] & 0xFF) << 24 | (arr_b[v + 1] & 0xFF) << 16 | (arr_b[v + 2] & 0xFF) << 8);
    }

    public static long c(p p0) {
        int v = p0.b;
        if(p0.a() < 9) {
            return 0x8000000000000001L;
        }
        byte[] arr_b = new byte[9];
        p0.e(arr_b, 0, 9);
        p0.G(v);
        int v1 = arr_b[0];
        if((v1 & 0xC4) == 68) {
            int v2 = arr_b[2];
            if((v2 & 4) == 4) {
                int v3 = arr_b[4];
                return (v3 & 4) != 4 || (arr_b[5] & 1) != 1 || (arr_b[8] & 3) != 3 ? 0x8000000000000001L : (((long)v2) & 3L) << 13 | ((((long)v1) & 3L) << 28 | (56L & ((long)v1)) >> 3 << 30 | (((long)arr_b[1]) & 0xFFL) << 20 | (((long)v2) & 0xF8L) >> 3 << 15) | (((long)arr_b[3]) & 0xFFL) << 5 | (((long)v3) & 0xF8L) >> 3;
            }
        }
        return 0x8000000000000001L;
    }
}

