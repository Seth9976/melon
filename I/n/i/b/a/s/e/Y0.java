package i.n.i.b.a.s.e;

import B6.f;
import Nf.p;
import com.iloen.melon.fragments.radio.a;
import h9.d;
import java.util.Collections;
import java.util.List;
import o9.b;

public final class y0 implements u3 {
    public final d3 a;
    public final b b;
    public final E4 c;
    public j3 d;
    public p e;
    public long f;
    public final List g;
    public d h;
    public Gd i;
    public Md j;

    public y0(d3 d30, b b0) {
        this.a = d30;
        this.b = b0;
        this.d = new f(3);
        this.e = new p(-1);
        this.f = 30000L;
        this.c = new E4(14);
        this.g = Collections.EMPTY_LIST;
        this.i = Gd.h0;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a() {
        this.i = null;
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a(C2 c20) {
        if(c20 == null) {
            this.d = new f(3);
            return this;
        }
        this.d = new a(c20, 13);
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final a6 b(e e0) {
        e0.b.getClass();
        ea.a a0 = new ea.a(this.i);
        List list0 = e0.b.c;
        List list1 = list0.isEmpty() ? this.g : list0;
        d5.e e1 = list1.isEmpty() ? a0 : new d5.e(10, a0, list1);
        if(list0.isEmpty() && !list1.isEmpty()) {
            i.n.i.b.a.s.e.a a1 = e0.a();
            a1.b(list1);
            e0 = a1.a();
        }
        d d0 = this.h;
        C2 c20 = this.d.b(e0);
        p p0 = this.e;
        long v = this.f;
        Md md0 = this.j;
        Gd gd0 = this.i;
        gd0.b();
        return new z0(e0, d0, this.b, e1, this.a, this.c, c20, p0, v, md0, gd0);
    }
}

