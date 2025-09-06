package ld;

import androidx.fragment.app.I;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class h implements a {
    public final int a;
    public final m b;

    public h(m m0, int v) {
        this.a = v;
        this.b = m0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                I i0 = this.b.requireParentFragment();
                q.f(i0, "requireParentFragment(...)");
                return i0;
            }
            case 1: {
                this.b.sendUserEvent(g.a);
                return H.a;
            }
            case 2: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            case 3: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            case 4: {
                ((x)this.b.getViewModel()).selectAll(false);
                return H.a;
            }
            default: {
                this.b.sendUserEvent(e.a);
                return H.a;
            }
        }
    }
}

