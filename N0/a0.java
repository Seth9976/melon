package N0;

import P4.a;
import r1.l;
import we.k;

public abstract class a0 {
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;

    public a0() {
        this.c = 0L;
        this.d = c0.a;
        this.e = 0L;
    }

    public abstract int n0(o arg1);

    public int o0() {
        return (int)(this.c & 0xFFFFFFFFL);
    }

    public int p0() {
        return (int)(this.c >> 0x20);
    }

    public Object q() {
        return null;
    }

    public final void q0() {
        this.a = a.j(((int)(this.c >> 0x20)), r1.a.j(this.d), r1.a.h(this.d));
        int v = a.j(((int)(this.c & 0xFFFFFFFFL)), r1.a.i(this.d), r1.a.g(this.d));
        this.b = v;
        this.e = ((long)((this.a - ((int)(this.c >> 0x20))) / 2)) << 0x20 | 0xFFFFFFFFL & ((long)((v - ((int)(this.c & 0xFFFFFFFFL))) / 2));
    }

    public abstract void r0(long arg1, float arg2, k arg3);

    public final void s0(long v) {
        if(!l.b(this.c, v)) {
            this.c = v;
            this.q0();
        }
    }

    public final void t0(long v) {
        if(!r1.a.b(this.d, v)) {
            this.d = v;
            this.q0();
        }
    }
}

