package Cc;

import Mc.m;
import O.F;
import Oc.c;
import androidx.compose.runtime.l;
import ie.H;
import r0.q;
import we.a;
import we.n;

public final class k implements n {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public k(m m0, q q0, c c0, F f0, boolean z, boolean z1, int v) {
        this.a = 1;
        super();
        this.d = m0;
        this.e = q0;
        this.f = c0;
        this.g = f0;
        this.b = z;
        this.c = z1;
    }

    public k(String s, String s1, boolean z, boolean z1, a a0, a a1, int v) {
        this.a = 0;
        super();
        this.d = s;
        this.e = s1;
        this.b = z;
        this.c = z1;
        this.f = a0;
        this.g = a1;
    }

    public k(w8.q q0, B2.n n0, String s, String s1, boolean z, boolean z1, int v) {
        this.a = 2;
        super();
        this.f = q0;
        this.g = n0;
        this.d = s;
        this.e = s1;
        this.b = z;
        this.c = z1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                e0.d(((String)this.d), ((String)this.e), this.b, this.c, ((a)this.f), ((a)this.g), ((l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((m)this.d).n(((q)this.e), ((c)this.f), ((F)this.g), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                ((w8.q)this.f).w(((B2.n)this.g), ((String)this.d), ((String)this.e), this.b, this.c, ((l)object0), 0x6001);
                return H.a;
            }
        }
    }
}

