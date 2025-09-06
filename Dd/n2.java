package Dd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class n2 implements a {
    public final h a;
    public final k b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public n2(h h0, k k0, boolean z, String s, String s1, String s2, int v) {
        this.a = h0;
        this.b = k0;
        this.c = z;
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = v;
    }

    @Override  // we.a
    public final Object invoke() {
        h.a(this.a);
        Z1 z10 = new Z1(this.d, this.e, this.f, this.g, this.c);
        this.b.invoke(z10);
        return H.a;
    }
}

