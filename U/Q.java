package U;

import Cc.Z;
import a1.Q;
import androidx.compose.runtime.H;
import androidx.compose.runtime.O0;
import kotlin.jvm.internal.r;
import we.k;

public final class q extends r implements k {
    public final int f;
    public final L0 g;
    public final k h;

    public q(L0 l00, k k0, int v) {
        this.f = v;
        this.g = l00;
        this.h = k0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            H h0 = (H)object0;
            this.g.c.add(this.h);
            return new Z(10, this.g, this.h);
        }
        L0 l00 = this.g;
        if(l00 != null) {
            ((O0)l00.a).setValue(((Q)object0));
        }
        k k0 = this.h;
        if(k0 != null) {
            k0.invoke(((Q)object0));
        }
        return ie.H.a;
    }
}

