package a3;

import b3.O;
import b3.P;
import b3.m;
import e3.j;
import e3.k;

public final class c implements j, k {
    public final int a;
    public final n b;

    public c(n n0, int v) {
        this.a = v;
        this.b = n0;
        super();
    }

    @Override  // e3.k
    public void a(Object object0, m m0) {
        O o0 = new O(m0);
        ((P)object0).M(this.b, o0);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).t(3, this.b.W());
                return;
            }
            case 1: {
                ((P)object0).n0(this.b.s);
                return;
            }
            case 2: {
                ((P)object0).t(1, this.b.W());
                return;
            }
            case 3: {
                ((P)object0).Y(this.b.r);
                return;
            }
            case 4: {
                ((P)object0).J0(this.b.A);
                return;
            }
            default: {
                ((P)object0).J0(this.b.A);
            }
        }
    }
}

