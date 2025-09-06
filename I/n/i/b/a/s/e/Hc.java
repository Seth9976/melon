package i.n.i.b.a.s.e;

import B6.f;
import Nf.p;
import com.iloen.melon.fragments.radio.a;
import h9.d;
import java.util.Collections;
import java.util.List;
import o9.b;

public final class hc implements u3 {
    public final d3 a;
    public final b b;
    public j3 c;
    public final E4 d;
    public p e;
    public final long f;
    public final long g;
    public final List h;
    public d i;
    public Gd j;
    public long k;
    public Md l;

    public hc(d3 d30, b b0) {
        this.a = d30;
        this.b = b0;
        this.c = new f(3);
        this.e = new p(-1);
        this.f = 0x8000000000000001L;
        this.g = 30000L;
        this.d = new E4(14);
        this.h = Collections.EMPTY_LIST;
        this.j = Gd.h0;
        this.k = 0x8000000000000001L;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a() {
        this.j = null;
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
        h2 h20 = new h2(this.j);
        List list0 = e0.b.c;
        List list1 = list0.isEmpty() ? this.h : list0;
        d5.e e1 = list1.isEmpty() ? h20 : new d5.e(10, h20, list1);
        boolean z = false;
        boolean z1 = list0.isEmpty() && !list1.isEmpty();
        long v = this.f;
        if(Long.compare(e0.c.a, 0x8000000000000001L) == 0 && v != 0x8000000000000001L) {
            z = true;
        }
        if(z1 || z) {
            i.n.i.b.a.s.e.a a0 = e0.a();
            if(z1) {
                a0.b(list1);
            }
            if(z) {
                a0.i = v;
            }
            e0 = a0.a();
        }
        d d0 = this.i;
        C2 c20 = this.c.b(e0);
        return new jc(e0, d0, this.b, e1, this.a, this.d, c20, this.e, this.g, this.l, this.k, this.j);
    }
}

