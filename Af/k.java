package Af;

import ie.H;
import we.a;

public final class k implements a {
    public final int a;
    public final a b;

    public k(int v, a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                p p0 = (p)this.b.invoke();
                return p0 instanceof l ? ((l)p0).h() : p0;
            }
            case 1: {
                this.b.invoke();
                return H.a;
            }
            case 2: {
                a a0 = this.b;
                if(a0 != null) {
                    a0.invoke();
                }
                return H.a;
            }
            case 3: {
                a a1 = this.b;
                if(a1 != null) {
                    a1.invoke();
                }
                return H.a;
            }
            case 4: {
                a a2 = this.b;
                if(a2 != null) {
                    a2.invoke();
                }
                return H.a;
            }
            case 5: {
                return je.p.T0(((Iterable)this.b.invoke()));
            }
            case 6: {
                this.b.invoke();
                return H.a;
            }
            case 7: {
                this.b.invoke();
                return H.a;
            }
            default: {
                this.b.invoke();
                return H.a;
            }
        }
    }
}

