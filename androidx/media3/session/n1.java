package androidx.media3.session;

import b3.E;
import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;
import b3.y;
import e3.x;

public final class n1 extends p0 {
    public final E e;
    public final boolean f;
    public final boolean g;
    public final y h;
    public final long i;
    public static final Object j;

    static {
        n1.j = new Object();
    }

    public n1(o1 o10) {
        this.e = o10.W();
        this.f = o10.a0();
        this.g = o10.Z();
        this.h = o10.c0() ? y.f : null;
        this.i = x.M(o10.getContentDuration());
    }

    // 去混淆评级： 低(20)
    @Override  // b3.p0
    public final int b(Object object0) {
        return n1.j.equals(object0) ? 0 : -1;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        m00.getClass();
        m00.i(n1.j, n1.j, 0, this.i, 0L, b.f, false);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return 1;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        return n1.j;
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        o00.b(n1.j, this.e, null, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, this.f, this.g, this.h, 0L, this.i, 0, 0, 0L);
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return 1;
    }
}

