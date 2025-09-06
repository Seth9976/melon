package rd;

import android.content.DialogInterface;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class z implements k {
    public final int a;
    public final P b;

    public z(P p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                X0 x00 = new X0(((int)(((Integer)object0))));
                this.b.sendUserEvent(x00);
                return H.a;
            }
            case 1: {
                V0 v00 = new V0(((int)(((Integer)object0))));
                this.b.sendUserEvent(v00);
                return H.a;
            }
            case 2: {
                q.g(((DialogInterface)object0), "it");
                ((K1)this.b.getViewModel()).k();
                return H.a;
            }
            default: {
                W0 w00 = new W0(((int)(((Integer)object0))));
                this.b.sendUserEvent(w00);
                return H.a;
            }
        }
    }
}

