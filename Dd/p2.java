package Dd;

import com.iloen.melon.net.v5x.common.StatsElementsBase;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class p2 implements a {
    public final h a;
    public final k b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final StatsElementsBase g;
    public final int h;

    public p2(h h0, k k0, boolean z, String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v) {
        this.a = h0;
        this.b = k0;
        this.c = z;
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = statsElementsBase0;
        this.h = v;
    }

    @Override  // we.a
    public final Object invoke() {
        h.a(this.a);
        a2 a20 = new a2(this.c, this.d, this.e, this.f, this.g, this.h);
        this.b.invoke(a20);
        return H.a;
    }
}

