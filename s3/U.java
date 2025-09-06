package s3;

import android.util.Pair;
import androidx.media3.exoplayer.f0;
import b3.E;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.b;
import w3.d;

public final class u extends h0 {
    public final boolean l;
    public final o0 m;
    public final m0 n;
    public s o;
    public r p;
    public boolean q;
    public boolean r;
    public boolean s;

    public u(a a0, boolean z) {
        super(a0);
        this.l = z && a0.i();
        this.m = new o0();
        this.n = new m0();
        p0 p00 = a0.g();
        if(p00 != null) {
            this.o = new s(p00, null, null);
            this.s = true;
            return;
        }
        this.o = new s(new t(a0.h()), o0.q, s.h);
    }

    @Override  // s3.h0
    public final void A() {
        if(!this.l) {
            this.q = true;
            this.x(null, this.k);
        }
    }

    public final r B(z z0, d d0, long v) {
        r r0 = new r(z0, d0, v);
        b.j(r0.d == null);
        a a0 = this.k;
        r0.d = a0;
        if(this.r) {
            r0.h(z0.a((this.o.g == null || !z0.a.equals(s.h) ? z0.a : this.o.g)));
            return r0;
        }
        this.p = r0;
        if(!this.q) {
            this.q = true;
            this.x(null, a0);
        }
        return r0;
    }

    public final boolean C(long v) {
        r r0 = this.p;
        int v1 = this.o.b(r0.a.a);
        if(v1 == -1) {
            return false;
        }
        this.o.f(v1, this.n, false);
        long v2 = this.n.d;
        if(v2 != 0x8000000000000001L && v >= v2) {
            v = Math.max(0L, v2 - 1L);
        }
        r0.g = v;
        return true;
    }

    @Override  // s3.a
    public final boolean a(E e0) {
        return this.k.a(e0);
    }

    @Override  // s3.a
    public final x b(z z0, d d0, long v) {
        return this.B(z0, d0, v);
    }

    @Override  // s3.k
    public final void j() {
    }

    @Override  // s3.a
    public final void n(x x0) {
        if(((r)x0).e != null) {
            a a0 = ((r)x0).d;
            a0.getClass();
            a0.n(((r)x0).e);
        }
        if(x0 == this.p) {
            this.p = null;
        }
    }

    @Override  // s3.k
    public final void p() {
        this.r = false;
        this.q = false;
        super.p();
    }

    @Override  // s3.h0
    public final void s(E e0) {
        if(this.s) {
            s s0 = this.o;
            this.o = new s(new f0(this.o.e, e0), s0.f, s0.g);
        }
        else {
            this.o = new s(new t(e0), o0.q, s.h);
        }
        this.k.s(e0);
    }

    @Override  // s3.h0
    public final z y(z z0) {
        Object object0 = z0.a;
        Object object1 = this.o.g;
        if(object1 != null && object1.equals(object0)) {
            object0 = s.h;
        }
        return z0.a(object0);
    }

    @Override  // s3.h0
    public final void z(p0 p00) {
        long v2;
        z z0;
        if(this.r) {
            this.o = new s(p00, this.o.f, this.o.g);
            r r0 = this.p;
            if(r0 != null) {
                this.C(r0.g);
            }
            z0 = null;
        }
        else if(p00.p()) {
            this.o = this.s ? new s(p00, this.o.f, this.o.g) : new s(p00, o0.q, s.h);
            z0 = null;
        }
        else {
            o0 o00 = this.m;
            p00.n(0, o00);
            long v = o00.l;
            Object object0 = o00.a;
            r r1 = this.p;
            if(r1 == null) {
                v2 = v;
            }
            else {
                this.o.g(r1.a.a, this.n);
                long v1 = this.n.e + r1.b;
                this.o.m(0, o00, 0L);
                v2 = v1 == o00.l ? v : v1;
            }
            Pair pair0 = p00.i(this.m, this.n, 0, v2);
            Object object1 = pair0.first;
            long v3 = (long)(((Long)pair0.second));
            this.o = this.s ? new s(p00, this.o.f, this.o.g) : new s(p00, object0, object1);
            r r2 = this.p;
            if(r2 == null || !this.C(v3)) {
                z0 = null;
            }
            else {
                Object object2 = this.o.g == null || !r2.a.a.equals(s.h) ? r2.a.a : this.o.g;
                z0 = r2.a.a(object2);
            }
        }
        this.s = true;
        this.r = true;
        this.m(this.o);
        if(z0 != null) {
            r r3 = this.p;
            r3.getClass();
            r3.h(z0);
        }
    }
}

