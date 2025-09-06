package i.n.i.b.a.s.e;

import ea.b;
import java.io.IOException;

public final class t5 implements B7 {
    public final int a;
    public final v5 b;

    public t5(v5 v50, int v) {
        this.b = v50;
        this.a = v;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        v5 v50 = this.b;
        if(v50.y()) {
            return -3;
        }
        int v1 = this.a;
        v50.c(v1);
        int v2 = v50.B[v1].i(b0, i80, v, v50.f0);
        if(v2 == -3) {
            v50.e(v1);
        }
        return v2;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
        this.b.B[this.a].E();
        sa sa0 = this.b.j;
        int v = this.b.d.a(this.b.V);
        IOException iOException0 = (IOException)sa0.d;
        if(iOException0 != null) {
            throw iOException0;
        }
        eb eb0 = (eb)sa0.c;
        if(eb0 != null) {
            if(v == 0x80000000) {
                v = eb0.b;
            }
            IOException iOException1 = eb0.d;
            if(iOException1 != null && eb0.e > v) {
                throw iOException1;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        v5 v50 = this.b;
        if(v50.y()) {
            return 0;
        }
        int v1 = this.a;
        v50.c(v1);
        e7 e70 = v50.B[v1];
        int v2 = e70.h(v, v50.f0);
        e70.A(v2);
        if(v2 == 0) {
            v50.e(v1);
        }
        return v2;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return !this.b.y() && this.b.B[this.a].l(this.b.f0);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return -1;
    }
}

