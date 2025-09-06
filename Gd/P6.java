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

public final class p6 implements n {
    public final int a;
    public final K4 b;
    public final q6 c;

    public p6(K4 k40, q6 q60, int v) {
        this.a = v;
        this.b = k40;
        this.c = q60;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        boolean z = false;
        K4 k40 = this.b;
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            if((v & 3) != 2) {
                z = true;
            }
            if(((p)(((l)object0))).Q(v & 1, z)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((s6)k40).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return h0;
            }
            ((p)(((l)object0))).T();
            return h0;
        }
        int v1 = (int)(((Integer)object1));
        if((v1 & 3) != 2) {
            z = true;
        }
        if(((p)(((l)object0))).Q(v1 & 1, z)) {
            q6 q60 = this.c;
            boolean z1 = ((p)(((l)object0))).i(q60);
            v5 v50 = ((p)(((l)object0))).N();
            if(z1 || v50 == k.a) {
                v5 v51 = new v5(1, q60, q6.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9);
                ((p)(((l)object0))).l0(v51);
                v50 = v51;
            }
            b.e(r0.n.a, ((u6)k40), v50, ((p)(((l)object0))), 6);
            return h0;
        }
        ((p)(((l)object0))).T();
        return h0;
    }
}

