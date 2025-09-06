package b0;

import P0.f;
import Z.q;
import Z.s;
import a0.b;
import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class l extends r implements a {
    public final int f;
    public final s g;

    public l(s s0, int v) {
        this.f = v;
        this.g = s0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        s s0 = this.g;
        if(this.f != 0) {
            if(((x)f.i(s0, z.b)) == null) {
                b b0 = s0.h;
                if(b0 != null) {
                    s0.n0(b0);
                    return H.a;
                }
            }
            else if(s0.h == null) {
                q q0 = new q(s0, 2);
                l l0 = new l(s0, 0);
                b b1 = new b(s0.d, s0.e, s0.f, q0, l0);
                s0.m0(b1);
                s0.h = b1;
            }
            return H.a;
        }
        x x0 = (x)f.i(s0, z.b);
        return y.a;
    }
}

