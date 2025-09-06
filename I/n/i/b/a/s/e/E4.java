package i.n.i.b.a.s.e;

import ea.b;

public final class e4 implements B7 {
    public final B7 a;
    public final long b;

    public e4(B7 b70, long v) {
        this.a = b70;
        this.b = v;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        int v1 = this.a.b(b0, i80, v);
        if(v1 == -4) {
            i80.f = Math.max(0L, i80.f + this.b);
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
        this.a.b();
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        return this.a.c(v - this.b);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
        this.a.c(q20);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return this.a.d();
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return this.a.j();
    }
}

