package i.n.i.b.a.s.e;

import java.util.ArrayList;

public final class x5 extends z5 implements Wc {
    public final f6 f;

    public x5(u u0, String s, f6 f60, ArrayList arrayList0) {
        super(u0, s, f60, arrayList0);
        this.f = f60;
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long a(long v) {
        return this.f.e(v);
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final boolean a() {
        return this.f.h();
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long b() {
        return this.f.d;
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long b(long v) {
        return this.f.b(v);
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long c(long v, long v1) {
        return this.f.g(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final R4 c(long v) {
        return this.f.d(this, v);
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long d(long v, long v1) {
        return this.f.i(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final String e() {
        return null;
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final Wc f() {
        return this;
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long g(long v, long v1) {
        return this.f.c(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long h(long v, long v1) {
        return this.f.f(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.z5
    public final R4 i() {
        return null;
    }

    @Override  // i.n.i.b.a.s.e.Wc
    public final long j(long v, long v1) {
        f6 f60 = this.f;
        if(f60.f != null) {
            return 0x8000000000000001L;
        }
        long v2 = f60.f(v, v1);
        long v3 = f60.c(v, v1) + v2;
        long v4 = f60.e(v3);
        return f60.g(v3, v) + v4 - f60.i;
    }
}

