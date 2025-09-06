package Ge;

import De.I;
import Ne.g;
import Pe.K;
import tf.m;
import we.a;

public final class k0 implements a {
    public final int a;
    public final l0 b;

    public k0(l0 l00, int v) {
        this.a = v;
        this.b = l00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return I.l(this.b, false);
        }
        K k0 = this.b.s().t().b();
        return k0 == null ? m.g(this.b.s().t(), g.a) : k0;
    }
}

