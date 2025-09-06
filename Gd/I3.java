package gd;

import Cc.c1;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import e1.x;
import ie.H;
import java.util.List;
import we.a;
import we.n;

public final class i3 implements n {
    public final int a;
    public final K4 b;
    public final k3 c;

    public i3(K4 k40, k3 k30, int v) {
        this.a = v;
        this.b = k40;
        this.c = k30;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((t3)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            List list0 = ((v3)this.b).a;
            k3 k30 = this.c;
            boolean z = ((p)(((l)object0))).i(k30);
            h3 h30 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || h30 == v1) {
                h30 = new h3(k30, 1);
                ((p)(((l)object0))).l0(h30);
            }
            boolean z1 = ((p)(((l)object0))).i(k30);
            j3 j30 = ((p)(((l)object0))).N();
            if(z1 || j30 == v1) {
                j3 j31 = new j3(1, k30, k3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2);
                ((p)(((l)object0))).l0(j31);
                j30 = j31;
            }
            boolean z2 = ((p)(((l)object0))).i(k30);
            j3 j32 = ((p)(((l)object0))).N();
            if(z2 || j32 == v1) {
                j32 = new j3(1, k30, k3.class, "showTitleBarUnderLine", "showTitleBarUnderLine(Z)V", 0, 3);
                ((p)(((l)object0))).l0(j32);
            }
            x.n(0, ((p)(((l)object0))), list0, h30, j30, j32);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

