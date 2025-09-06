package N0;

import M0.a;
import java.util.Map;
import r1.m;
import we.k;

public final class u implements O, q {
    public final m a;
    public final q b;

    public u(q q0, m m0) {
        this.a = m0;
        this.b = q0;
    }

    @Override  // r1.c
    public final float B(long v) {
        return this.b.B(v);
    }

    @Override  // r1.c
    public final float R(int v) {
        return this.b.R(v);
    }

    @Override  // r1.c
    public final float S(float f) {
        return this.b.S(f);
    }

    @Override  // r1.c
    public final float W() {
        return this.b.W();
    }

    @Override  // r1.c
    public final float Y(float f) {
        return this.b.Y(f);
    }

    @Override  // r1.c
    public final float b() {
        return this.b.b();
    }

    @Override  // N0.q
    public final m getLayoutDirection() {
        return this.a;
    }

    @Override  // r1.c
    public final long i0(long v) {
        return this.b.i0(v);
    }

    @Override  // r1.c
    public final long j(float f) {
        return this.b.j(f);
    }

    @Override  // r1.c
    public final long k(long v) {
        return this.b.k(v);
    }

    @Override  // r1.c
    public final float m(long v) {
        return this.b.m(v);
    }

    @Override  // N0.O
    public final N n(int v, int v1, Map map0, k k0) {
        if(v < 0) {
            v = 0;
        }
        if(v1 < 0) {
            v1 = 0;
        }
        if((v & 0xFF000000) != 0 || (0xFF000000 & v1) != 0) {
            a.b(("Size(" + v + " x " + v1 + ") is out of range. Each dimension must be between 0 and 16777215."));
        }
        return new t(v, v1, map0);
    }

    @Override  // r1.c
    public final long p(float f) {
        return this.b.p(f);
    }

    @Override  // N0.q
    public final boolean u() {
        return this.b.u();
    }

    @Override  // r1.c
    public final int z(float f) {
        return this.b.z(f);
    }
}

