package i.n.i.b.a.s.e;

import ea.b;

public final class O4 implements B7 {
    public final Q4 a;
    public final e7 b;
    public final int c;
    public boolean d;
    public final Q4 e;

    public O4(Q4 q40, Q4 q41, e7 e70, int v) {
        this.e = q40;
        this.a = q41;
        this.b = e70;
        this.c = v;
    }

    public final void a() {
        if(!this.d) {
            this.e.g.c(this.e.b[this.c], this.e.c[this.c], 0, null, -1L, this.e.G);
            this.d = true;
        }
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        Q4 q40 = this.e;
        if(!q40.q()) {
            e7 e70 = this.b;
            if(q40.M == null || q40.M.d(this.c + 1) > e70.C()) {
                this.a();
                return e70.i(b0, i80, v, q40.N);
            }
        }
        return -3;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        Q4 q40 = this.e;
        if(q40.q()) {
            return 0;
        }
        e7 e70 = this.b;
        int v1 = e70.h(v, q40.N);
        w0 w00 = q40.M;
        if(w00 != null) {
            v1 = Math.min(v1, w00.d(this.c + 1) - e70.C());
        }
        e70.A(v1);
        if(v1 > 0) {
            this.a();
        }
        return v1;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return !this.e.q() && this.b.l(this.e.N);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return -1;
    }
}

