package Ac;

import Dd.N0;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class m1 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    public m1(h h0, k k0, int v, String s, String s1, String s2) {
        this.a = 0;
        super();
        this.b = h0;
        this.c = k0;
        this.g = v;
        this.d = s;
        this.e = s1;
        this.f = s2;
    }

    public m1(h h0, k k0, String s, String s1, String s2, int v) {
        this.a = 1;
        super();
        this.b = h0;
        this.c = k0;
        this.d = s;
        this.e = s1;
        this.f = s2;
        this.g = v;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            N0 n00 = new N0(this.g, this.d, this.e, this.f);
            this.c.invoke(n00);
            return H.a;
        }
        h.a(this.b);
        S1 s10 = new S1(this.g, this.d, this.e, this.e, this.f);
        this.c.invoke(s10);
        return H.a;
    }
}

