package s3;

import b3.E;
import b3.o0;
import b3.p0;
import e3.b;
import java.util.ArrayList;

public final class g extends h0 {
    public final long l;
    public final long m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final ArrayList q;
    public final o0 r;
    public e s;
    public f t;
    public long u;
    public long v;

    public g(a a0, long v, long v1, boolean z, boolean z1, boolean z2) {
        a0.getClass();
        super(a0);
        b.c(v >= 0L);
        this.l = v;
        this.m = v1;
        this.n = z;
        this.o = z1;
        this.p = z2;
        this.q = new ArrayList();
        this.r = new o0();
    }

    public final void B(p0 p00) {
        e e0;
        long v4;
        long v3;
        long v5;
        o0 o00 = this.r;
        p00.n(0, o00);
        long v = o00.p;
        long v1 = this.m;
        long v2 = 0x8000000000000000L;
        ArrayList arrayList0 = this.q;
        if(this.s == null || arrayList0.isEmpty() || this.o) {
            v3 = this.l;
            if(this.p) {
                v3 += o00.l;
                v5 = o00.l + v1;
            }
            else {
                v5 = v1;
            }
            this.u = v + v3;
            if(v1 != 0x8000000000000000L) {
                v2 = v + v5;
            }
            this.v = v2;
            int v6 = arrayList0.size();
            for(int v7 = 0; v7 < v6; ++v7) {
                d d0 = (d)arrayList0.get(v7);
                d0.e = this.u;
                d0.f = this.v;
            }
            v4 = v5;
        }
        else {
            v3 = this.u - v;
            if(v1 != 0x8000000000000000L) {
                v2 = this.v - v;
            }
            v4 = v2;
        }
        try {
            e0 = new e(p00, v3, v4);
            this.s = e0;
        }
        catch(f f0) {
            this.t = f0;
            for(int v8 = 0; v8 < arrayList0.size(); ++v8) {
                d d1 = (d)arrayList0.get(v8);
                d1.g = this.t;
            }
            return;
        }
        this.m(e0);
    }

    // 去混淆评级： 低(20)
    @Override  // s3.a
    public final boolean a(E e0) {
        return this.k.h().e.equals(e0.e) && this.k.a(e0);
    }

    @Override  // s3.a
    public final x b(z z0, w3.d d0, long v) {
        x x0 = new d(this.k.b(z0, d0, v), this.n, this.u, this.v);
        this.q.add(x0);
        return x0;
    }

    @Override  // s3.k
    public final void j() {
        f f0 = this.t;
        if(f0 != null) {
            throw f0;
        }
        super.j();
    }

    @Override  // s3.a
    public final void n(x x0) {
        b.j(this.q.remove(x0));
        this.k.n(((d)x0).a);
        if(this.q.isEmpty() && !this.o) {
            e e0 = this.s;
            e0.getClass();
            this.B(e0.e);
        }
    }

    @Override  // s3.k
    public final void p() {
        super.p();
        this.t = null;
        this.s = null;
    }

    @Override  // s3.h0
    public final void z(p0 p00) {
        if(this.t != null) {
            return;
        }
        this.B(p00);
    }
}

