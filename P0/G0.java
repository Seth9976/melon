package P0;

import ie.H;
import kotlin.jvm.internal.r;
import we.a;
import y0.q;

public final class g0 extends r implements a {
    public final int f;
    public final j0 g;

    public g0(j0 j00, int v) {
        this.f = v;
        this.g = j00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            j0 j00 = this.g.n;
            if(j00 != null) {
                j00.Y0();
            }
            return H.a;
        }
        q q0 = this.g.W;
        kotlin.jvm.internal.q.d(q0);
        this.g.K0(q0, this.g.V);
        return H.a;
    }
}

