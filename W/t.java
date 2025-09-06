package W;

import L.a;
import P0.f;
import Q0.R0;
import Q0.k0;
import Q0.l0;
import f1.r;

public abstract class t implements r {
    public W.r a;

    @Override  // f1.r
    public final void d() {
        W.r r0 = this.a;
        if(r0 != null) {
            R0 r00 = (R0)f.i(r0, k0.p);
            if(r00 != null) {
                ((l0)r00).a();
            }
        }
    }

    @Override  // f1.r
    public final void g() {
        W.r r0 = this.a;
        if(r0 != null) {
            R0 r00 = (R0)f.i(r0, k0.p);
            if(r00 != null) {
                ((l0)r00).b();
            }
        }
    }

    public final void i(W.r r0) {
        if(this.a != r0) {
            a.c(("Expected textInputModifierNode to be " + r0 + " but was " + this.a));
        }
        this.a = null;
    }
}

