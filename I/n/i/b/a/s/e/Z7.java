package i.n.i.b.a.s.e;

import ea.b;

public final class z7 implements B7 {
    public final B7 a;
    public boolean b;
    public final A7 c;

    public z7(A7 a70, B7 b70) {
        this.c = a70;
        this.a = b70;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        A7 a70 = this.c;
        if(a70.d()) {
            return -3;
        }
        if(this.b) {
            i80.b = 4;
            return -4;
        }
        int v1 = this.a.b(b0, i80, v);
        if(v1 == -5) {
            u u0 = (u)b0.b;
            u0.getClass();
            int v2 = u0.X;
            int v3 = u0.W;
            if(v3 == 0 && v2 == 0) {
                return -5;
            }
            if(Long.compare(a70.e, 0L) != 0) {
                v3 = 0;
            }
            if(a70.f != 0x8000000000000000L) {
                v2 = 0;
            }
            ob ob0 = u0.a();
            ob0.A = v3;
            ob0.B = v2;
            b0.b = new u(ob0);
            return -5;
        }
        if(a70.f != 0x8000000000000000L && (v1 == -4 && i80.f >= a70.f || v1 == -3 && a70.c() == 0x8000000000000000L && !i80.e)) {
            i80.o();
            i80.b = 4;
            this.b = true;
            return -4;
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
        this.a.b();
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        return this.c.d() ? -3 : this.a.c(v);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
        this.a.c(q20);
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return !this.c.d() && this.a.d();
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return this.a.j();
    }
}

