package i.n.i.b.a.s.e;

import android.util.Pair;
import java.io.IOException;
import java.util.UUID;

public final class f3 implements L2, Y1 {
    public final h3 a;
    public K2 b;
    public X1 c;
    public final i3 d;

    public f3(i3 i30, h3 h30) {
        this.d = i30;
        this.b = i30.e;
        this.c = i30.f;
        this.a = h30;
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void B(int v, e2 e20, Exception exception0, B2 b20) {
        if(this.a(v, e20)) {
            this.c.d(exception0, b20);
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void F(int v, e2 e20, int v1) {
        if(this.a(v, e20)) {
            this.c.b(v1);
        }
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void G(int v, e2 e20, Sd sd0, Z z0) {
        if(this.a(v, e20)) {
            this.b.p(sd0, z0);
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void P(int v, e2 e20) {
        if(this.a(v, e20)) {
            this.c.g();
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void R(int v, e2 e20) {
        if(this.a(v, e20)) {
            this.c.a();
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void S(int v, e2 e20, UUID uUID0, B2 b20, byte[] arr_b) {
        if(this.a(v, e20)) {
            this.c.f(uUID0, b20, arr_b);
        }
    }

    public final boolean a(int v, e2 e20) {
        h3 h30 = this.a;
        e2 e21 = null;
        if(e20 != null) {
            for(int v1 = 0; v1 < h30.c.size(); ++v1) {
                if(((e2)h30.c.get(v1)).d == e20.d) {
                    e21 = e20.b(Pair.create(h30.b, e20.a));
                    break;
                }
            }
            if(e21 == null) {
                return false;
            }
        }
        int v2 = v + h30.d;
        i3 i30 = this.d;
        if(this.b.a != v2 || !L7.p(this.b.b, e21)) {
            this.b = new K2(i30.e.c, v2, e21, 0L);
        }
        if(this.c.a == v2 && L7.p(this.c.b, e21)) {
            return true;
        }
        this.c = new X1(i30.f.c, v2, e21);
        return true;
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void l(int v, e2 e20, Z z0) {
        if(this.a(v, e20)) {
            this.b.m(z0);
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void n(int v, e2 e20, UUID uUID0) {
        if(this.a(v, e20)) {
            this.c.h(uUID0);
        }
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void o(int v, e2 e20, Z z0) {
        if(this.a(v, e20)) {
            this.b.e(z0);
        }
    }

    @Override  // i.n.i.b.a.s.e.Y1
    public final void p(int v, e2 e20, UUID uUID0) {
        if(this.a(v, e20)) {
            this.c.e(uUID0);
        }
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void r(int v, e2 e20, Sd sd0, Z z0) {
        if(this.a(v, e20)) {
            this.b.s(sd0, z0);
        }
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void u(int v, e2 e20, Sd sd0, Z z0) {
        if(this.a(v, e20)) {
            this.b.j(sd0, z0);
        }
    }

    @Override  // i.n.i.b.a.s.e.L2
    public final void z(int v, e2 e20, Sd sd0, Z z0, IOException iOException0, boolean z1) {
        if(this.a(v, e20)) {
            this.b.k(sd0, z0, iOException0, z1);
        }
    }
}

