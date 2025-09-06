package gd;

import Cc.c1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import e1.b;
import ie.H;
import we.a;
import we.n;

public final class z2 implements n {
    public final int a;
    public final K4 b;
    public final A2 c;

    public z2(K4 k40, A2 a20, int v) {
        this.a = v;
        this.b = k40;
        this.c = a20;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((C2)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            E2 e20 = (E2)this.b;
            A2 a20 = this.c;
            boolean z = ((p)(((l)object0))).i(a20);
            Z0 z00 = ((p)(((l)object0))).N();
            if(z || z00 == k.a) {
                Z0 z01 = new Z0(1, a20, A2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 24);
                ((p)(((l)object0))).l0(z01);
                z00 = z01;
            }
            b.c(e20, z00, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

