package Ge;

import De.I;
import Ne.g;
import Pe.J;
import tf.m;
import we.a;

public final class i0 implements a {
    public final int a;
    public final j0 b;

    public i0(j0 j00, int v) {
        this.a = v;
        this.b = j00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return I.l(this.b, true);
        }
        J j0 = this.b.s().t().getGetter();
        return j0 == null ? m.f(this.b.s().t(), g.a) : j0;
    }
}

