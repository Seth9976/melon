package gd;

import Cc.c1;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import df.d;
import ie.H;
import we.a;
import we.n;

public final class o2 implements n {
    public final int a;
    public final K4 b;
    public final p2 c;

    public o2(K4 k40, p2 p20, int v) {
        this.a = v;
        this.b = k40;
        this.c = p20;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((s2)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            u2 u20 = (u2)this.b;
            p2 p20 = this.c;
            boolean z = ((p)(((l)object0))).i(p20);
            Z0 z00 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || z00 == v1) {
                Z0 z01 = new Z0(1, p20, p2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 20);
                ((p)(((l)object0))).l0(z01);
                z00 = z01;
            }
            boolean z1 = ((p)(((l)object0))).i(p20);
            Z0 z02 = ((p)(((l)object0))).N();
            if(z1 || z02 == v1) {
                z02 = new Z0(1, p20, p2.class, "showTitleBarUnderLine", "showTitleBarUnderLine(Z)V", 0, 21);
                ((p)(((l)object0))).l0(z02);
            }
            d.c(u20, z00, z02, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

