package U;

import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class m0 extends r implements a {
    public final int f;
    public final t0 g;

    public m0(t0 t00, int v) {
        this.f = v;
        this.g = t00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            this.g.onCancel();
            return H.a;
        }
        this.g.onStop();
        return H.a;
    }
}

