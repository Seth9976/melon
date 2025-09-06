package androidx.media3.session;

import I6.Q;
import I6.V;
import b3.E;
import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.x;
import java.util.Arrays;
import java.util.List;
import x1.a;

public final class q1 extends p0 {
    public final V e;
    public final p1 f;
    public static final q1 g;
    public static final Object h;

    static {
        q1.g = new q1(I6.p0.e, null);
        q1.h = new Object();
    }

    public q1(V v0, p1 p10) {
        this.e = v0;
        this.f = p10;
    }

    @Override  // b3.p0
    public final int b(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override  // b3.p0
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q1 ? a.w(this.e, ((q1)object0).e) && a.w(this.f, ((q1)object0).f) : false;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        p1 p10 = this.s(v);
        m00.getClass();
        m00.i(p10.b, null, v, x.M(p10.c), 0L, b.f, false);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return this.o();
    }

    @Override  // b3.p0
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.e, this.f});
    }

    @Override  // b3.p0
    public final Object l(int v) {
        throw new UnsupportedOperationException();
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        p1 p10 = this.s(v);
        o00.b(q1.h, p10.a, null, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, true, false, null, 0L, x.M(p10.c), v, v, 0L);
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        int v = this.e.size();
        return this.f == null ? v : v + 1;
    }

    public final q1 q(int v, List list0) {
        Q q0 = new Q(4);  // 初始化器: LI6/N;-><init>(I)V
        V v1 = this.e;
        q0.d(v1.x(0, v));
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            q0.a(new p1(((E)list0.get(v2)), -1L, 0x8000000000000001L));
        }
        q0.d(v1.x(v, v1.size()));
        return new q1(q0.g(), this.f);
    }

    public final long r(int v) {
        if(v >= 0) {
            return v >= this.e.size() ? -1L : ((p1)this.e.get(v)).b;
        }
        return -1L;
    }

    public final p1 s(int v) {
        V v1 = this.e;
        if(v == v1.size()) {
            return this.f == null ? ((p1)v1.get(v)) : this.f;
        }
        return (p1)v1.get(v);
    }
}

