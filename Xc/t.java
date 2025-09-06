package xc;

import Cc.w3;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class t implements n {
    public final int a;
    public final z b;

    public t(z z0, int v) {
        this.a = v;
        this.b = z0;
        super();
    }

    public t(z z0, int v, int v1) {
        this.a = v1;
        this.b = z0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    this.b.o(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                this.b.p(((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                this.b.n(((l)object0), 1);
                return H.a;
            }
            case 3: {
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    z z0 = this.b;
                    boolean z1 = ((p)(((l)object0))).i(z0);
                    u u0 = ((p)(((l)object0))).N();
                    if(z1 || u0 == k.a) {
                        u0 = new u(z0, 1);
                        ((p)(((l)object0))).l0(u0);
                    }
                    w3.a(u0, ((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 4: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    z z2 = this.b;
                    boolean z3 = ((p)(((l)object0))).i(z2);
                    u u1 = ((p)(((l)object0))).N();
                    if(z3 || u1 == k.a) {
                        u1 = new u(z2, 2);
                        ((p)(((l)object0))).l0(u1);
                    }
                    w3.b(u1, ((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 5: {
                int v3 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v3 & 1, (v3 & 3) != 2)) {
                    this.b.n(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 6: {
                ((Integer)object1).getClass();
                this.b.o(((l)object0), 1);
                return H.a;
            }
            case 7: {
                ((Integer)object1).getClass();
                this.b.r(((l)object0), 1);
                return H.a;
            }
            case 8: {
                int v4 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v4 & 1, (v4 & 3) != 2)) {
                    this.b.p(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 9: {
                int v5 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v5 & 1, (v5 & 3) != 2)) {
                    this.b.q(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                this.b.q(((l)object0), 1);
                return H.a;
            }
        }
    }
}

