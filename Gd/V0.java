package gd;

import Cc.c1;
import Yc.D;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import df.v;
import ie.H;
import we.a;
import we.n;

public final class v0 implements n {
    public final int a;
    public final K4 b;
    public final w0 c;

    public v0(K4 k40, w0 w00, int v) {
        this.a = v;
        this.b = k40;
        this.c = w00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((z0)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            B0 b00 = (B0)this.b;
            w0 w00 = this.c;
            boolean z = ((p)(((l)object0))).i(w00);
            D d0 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || d0 == v1) {
                D d1 = new D(1, w00, w0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 21);
                ((p)(((l)object0))).l0(d1);
                d0 = d1;
            }
            boolean z1 = ((p)(((l)object0))).i(w00);
            D d2 = ((p)(((l)object0))).N();
            if(z1 || d2 == v1) {
                d2 = new D(1, w00, w0.class, "showTitleBarUnderLine", "showTitleBarUnderLine(Z)V", 0, 22);
                ((p)(((l)object0))).l0(d2);
            }
            v.f(b00, d0, d2, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

