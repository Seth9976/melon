package androidx.media3.session;

import b3.P;
import e3.j;

public final class z implements O, j {
    public final int a;
    public final Q b;
    public final boolean c;

    public z(Q q0, boolean z, int v) {
        this.a = v;
        this.b = q0;
        this.c = z;
        super();
    }

    @Override  // androidx.media3.session.O
    public void d(m m0, int v) {
        switch(this.a) {
            case 0: {
                m0.q0(this.b.c, v, this.c);
                return;
            }
            case 2: {
                m0.k(this.b.c, v, this.c);
                return;
            }
            default: {
                m0.O(this.b.c, v, this.c);
            }
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 1) {
            ((P)object0).H(this.b.n.r, this.c);
            return;
        }
        ((P)object0).H(this.b.n.r, this.c);
    }
}

