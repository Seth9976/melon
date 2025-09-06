package xc;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class c implements n {
    public final int a;
    public final k b;

    public c(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    public c(k k0, int v, int v1) {
        this.a = v1;
        this.b = k0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                this.b.n(((l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                this.b.o(((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                this.b.p(((l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                this.b.q(((l)object0), 1);
                return H.a;
            }
            case 4: {
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    this.b.n(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 5: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    this.b.o(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    this.b.p(((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
        }
    }
}

