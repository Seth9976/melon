package i.n.i.b.a.s.e;

import B6.f;
import Nf.p;
import com.iloen.melon.fragments.radio.a;

public final class c6 implements u3 {
    public final C0 a;
    public final a b;
    public j3 c;
    public p d;
    public final int e;
    public Gd f;

    public c6(C0 c00, Y6 y60) {
        a a0 = new a(y60, 18);
        super();
        this.a = c00;
        this.b = a0;
        this.c = new f(3);
        this.d = new p(-1);
        this.e = 0x100000;
        this.f = Gd.h0;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a() {
        this.f = null;
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a(C2 c20) {
        if(c20 == null) {
            this.c = new f(3);
            return this;
        }
        this.c = new a(c20, 13);
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final a6 b(e e0) {
        e0.b.getClass();
        this.f.b();
        e0.b.getClass();
        C2 c20 = this.c.b(e0);
        return new d6(e0, this.a, this.b, c20, this.d, this.e, this.f);
    }
}

