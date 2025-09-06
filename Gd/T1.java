package gd;

import Cc.c1;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import d3.g;
import ie.H;
import we.a;
import we.n;

public final class t1 implements n {
    public final int a;
    public final K4 b;
    public final u1 c;

    public t1(K4 k40, u1 u10, int v) {
        this.a = v;
        this.b = k40;
        this.c = u10;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((B1)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            D1 d10 = (D1)this.b;
            u1 u10 = this.c;
            boolean z = ((p)(((l)object0))).i(u10);
            s1 s10 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || s10 == v1) {
                s10 = new s1(u10, 3);
                ((p)(((l)object0))).l0(s10);
            }
            boolean z1 = ((p)(((l)object0))).i(u10);
            Z0 z00 = ((p)(((l)object0))).N();
            if(z1 || z00 == v1) {
                Z0 z01 = new Z0(1, u10, u1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8);
                ((p)(((l)object0))).l0(z01);
                z00 = z01;
            }
            g.n(d10, s10, z00, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

