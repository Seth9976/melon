package s3;

import b3.E;
import b3.p0;
import g3.x;

public abstract class h0 extends k {
    public final a k;

    public h0(a a0) {
        this.k = a0;
    }

    public void A() {
        this.x(null, this.k);
    }

    @Override  // s3.a
    public final p0 g() {
        return this.k.g();
    }

    @Override  // s3.a
    public final E h() {
        return this.k.h();
    }

    @Override  // s3.a
    public final boolean i() {
        return this.k.i();
    }

    @Override  // s3.a
    public final void l(x x0) {
        this.j = x0;
        this.i = e3.x.l(null);
        this.A();
    }

    @Override  // s3.a
    public void s(E e0) {
        this.k.s(e0);
    }

    @Override  // s3.k
    public final z t(Object object0, z z0) {
        Void void0 = (Void)object0;
        return this.y(z0);
    }

    @Override  // s3.k
    public final long u(Object object0, long v) {
        Void void0 = (Void)object0;
        return v;
    }

    @Override  // s3.k
    public final int v(Object object0, int v) {
        Void void0 = (Void)object0;
        return v;
    }

    @Override  // s3.k
    public final void w(Object object0, a a0, p0 p00) {
        Void void0 = (Void)object0;
        this.z(p00);
    }

    public z y(z z0) {
        return z0;
    }

    public abstract void z(p0 arg1);
}

