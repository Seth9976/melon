package gd;

import Cc.c1;
import Yc.D;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import d8.d;
import ed.f;
import ie.H;
import java.util.List;
import we.a;
import we.n;

public final class f0 implements n {
    public final int a;
    public final K4 b;
    public final g0 c;

    public f0(K4 k40, g0 g00, int v) {
        this.a = v;
        this.b = k40;
        this.c = g00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((j0)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            List list0 = ((l0)this.b).a;
            g0 g00 = this.c;
            boolean z = ((p)(((l)object0))).i(g00);
            D d0 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || d0 == v1) {
                D d1 = new D(1, g00, g0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 20);
                ((p)(((l)object0))).l0(d1);
                d0 = d1;
            }
            boolean z1 = ((p)(((l)object0))).i(g00);
            f f0 = ((p)(((l)object0))).N();
            if(z1 || f0 == v1) {
                f0 = new f(g00, 6);
                ((p)(((l)object0))).l0(f0);
            }
            d.e(0, ((p)(((l)object0))), list0, f0, d0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

