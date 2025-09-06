package sc;

import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oc.Q;
import we.a;

public final class c implements a {
    public final int a;
    public final P0 b;

    public c(P0 p00, int v) {
        this.a = v;
        this.b = p00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return !((g1)this.b.l.getValue()).g || this.b.u ? false : true;
            }
            case 1: {
                return this.b.p();
            }
            case 2: {
                return this.b.p();
            }
            case 3: {
                return (Q)this.b.l.getValue();
            }
            case 4: {
                return this.b.m;
            }
            default: {
                E0 e00 = new E0(this.b, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.c, null, null, e00, 3, null);
                return H.a;
            }
        }
    }
}

