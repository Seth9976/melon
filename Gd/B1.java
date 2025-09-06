package gd;

import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import e1.x;
import ie.H;
import we.a;
import we.n;

public final class b1 implements n {
    public final int a;
    public final K4 b;
    public final c1 c;

    public b1(K4 k40, c1 c10, int v) {
        this.a = v;
        this.b = k40;
        this.c = c10;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                Cc.c1.w(((g1)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            i1 i10 = (i1)this.b;
            c1 c10 = this.c;
            boolean z = ((p)(((l)object0))).i(c10);
            Z0 z00 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(z || z00 == v1) {
                Z0 z01 = new Z0(1, c10, c1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2);
                ((p)(((l)object0))).l0(z01);
                z00 = z01;
            }
            boolean z1 = ((p)(((l)object0))).i(c10);
            Z0 z02 = ((p)(((l)object0))).N();
            if(z1 || z02 == v1) {
                z02 = new Z0(1, c10, c1.class, "showTitleBarUnderLine", "showTitleBarUnderLine(Z)V", 0, 3);
                ((p)(((l)object0))).l0(z02);
            }
            x.j(i10, z00, z02, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

