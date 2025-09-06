package i.n.i.b.a.s.e;

import B6.f;
import Nf.p;
import com.iloen.melon.fragments.radio.a;
import d5.v;
import h9.d;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class i2 implements u3 {
    public final d3 a;
    public re b;
    public cd c;
    public zd d;
    public final E4 e;
    public j3 f;
    public p g;
    public final int h;
    public final List i;
    public final long j;
    public Map k;
    public int l;
    public d m;
    public Gd n;
    public Md o;
    public long p;
    public E4 q;

    public i2(d3 d30) {
        this.l = -1;
        this.a = d30;
        this.f = new f(3);
        this.c = new E4(13);
        this.d = W8.D;
        this.b = re.a;
        this.g = new p(-1);
        this.e = new E4(14);
        this.h = 1;
        this.i = Collections.EMPTY_LIST;
        this.j = 0x8000000000000001L;
        this.n = Gd.h0;
        this.p = 0x8000000000000001L;
        this.k = Collections.EMPTY_MAP;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a() {
        this.n = null;
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final u3 a(C2 c20) {
        if(c20 == null) {
            this.f = new f(3);
            return this;
        }
        this.f = new a(c20, 13);
        return this;
    }

    @Override  // i.n.i.b.a.s.e.u3
    public final a6 b(e e0) {
        e0.b.getClass();
        cd cd0 = this.c;
        List list0 = e0.b.c;
        List list1 = list0.isEmpty() ? this.i : list0;
        cd cd1 = list1.isEmpty() ? cd0 : new v(cd0, list1);
        if(list0.isEmpty() && !list1.isEmpty()) {
            i.n.i.b.a.s.e.a a0 = e0.a();
            a0.b(list1);
            e0 = a0.a();
        }
        re re0 = this.b;
        C2 c20 = this.f.b(e0);
        p p0 = this.g;
        zd zd0 = this.d;
        e0.b.getClass();
        W8 w80 = zd0.d(this.a, p0, cd1, e0.b.b, this.m);
        Map map0 = this.k;
        Md md0 = this.o;
        Gd gd0 = this.n;
        gd0.b();
        return new j2(e0, this.a, re0, this.e, c20, p0, w80, this.j, this.h, map0, md0, gd0, this.l, this.p, this.q);
    }
}

