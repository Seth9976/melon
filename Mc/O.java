package Mc;

import Oc.x;
import androidx.fragment.app.I;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class o implements a {
    public final int a;
    public final v b;

    public o(v v0, int v1) {
        this.a = v1;
        this.b = v0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            case 1: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            case 2: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            default: {
                I i0 = this.b.requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                return i0;
            }
        }
    }
}

