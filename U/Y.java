package U;

import Q0.P;
import Y.Q;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import x0.b;

public final class y extends r implements k {
    public final int f;
    public final Q g;

    public y(Q q0, int v) {
        this.f = v;
        this.g = q0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            b b0 = (b)object0;
            this.g.r();
            return H.a;
        }
        androidx.compose.runtime.H h0 = (androidx.compose.runtime.H)object0;
        return new P(this.g, 1);
    }
}

