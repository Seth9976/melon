package C8;

import Rc.U;
import Rc.Z;
import Rc.b0;
import Rc.c0;
import dc.g;
import gd.J1;
import gd.J5;
import gd.K1;
import ie.H;
import we.a;
import we.k;
import zd.F;

public final class c implements a {
    public final int a;
    public final k b;

    public c(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.invoke(0);
                return H.a;
            }
            case 1: {
                this.b.invoke(1);
                return H.a;
            }
            case 2: {
                this.b.invoke(Z.a);
                return H.a;
            }
            case 3: {
                this.b.invoke(U.a);
                return H.a;
            }
            case 4: {
                this.b.invoke(b0.a);
                return H.a;
            }
            case 5: {
                this.b.invoke(c0.a);
                return H.a;
            }
            case 6: {
                StringBuilder stringBuilder0 = new StringBuilder();
                this.b.invoke(stringBuilder0);
                return stringBuilder0.toString();
            }
            case 7: {
                StringBuilder stringBuilder1 = new StringBuilder();
                this.b.invoke(stringBuilder1);
                return stringBuilder1.toString();
            }
            case 8: {
                StringBuilder stringBuilder2 = new StringBuilder();
                this.b.invoke(stringBuilder2);
                return stringBuilder2.toString();
            }
            case 9: {
                StringBuilder stringBuilder3 = new StringBuilder();
                this.b.invoke(stringBuilder3);
                return stringBuilder3.toString();
            }
            case 10: {
                StringBuilder stringBuilder4 = new StringBuilder();
                this.b.invoke(stringBuilder4);
                return stringBuilder4.toString();
            }
            case 11: {
                Object object0 = g.d.getValue();
                Object object1 = this.b.invoke(object0);
                g.d.setValue(object1);
                return H.a;
            }
            case 12: {
                k k0 = this.b;
                if(k0 != null) {
                    k0.invoke(J1.a);
                }
                return H.a;
            }
            case 13: {
                k k1 = this.b;
                if(k1 != null) {
                    k1.invoke(K1.a);
                }
                return H.a;
            }
            case 14: {
                k k2 = this.b;
                if(k2 != null) {
                    k2.invoke(J5.a);
                }
                return H.a;
            }
            case 15: {
                this.b.invoke(Boolean.TRUE);
                return H.a;
            }
            default: {
                this.b.invoke(F.a);
                return H.a;
            }
        }
    }
}

