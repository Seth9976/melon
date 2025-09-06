package gd;

import Cc.c1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import d3.g;
import ie.H;
import we.a;
import we.n;

public final class q5 implements n {
    public final int a;
    public final K4 b;
    public final s5 c;

    public q5(K4 k40, s5 s50, int v) {
        this.a = v;
        this.b = k40;
        this.c = s50;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((D5)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            F5 f50 = (F5)this.b;
            s5 s50 = this.c;
            boolean z = ((p)(((l)object0))).i(s50);
            j3 j30 = ((p)(((l)object0))).N();
            if(z || j30 == k.a) {
                j3 j31 = new j3(1, s50, s5.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 29);
                ((p)(((l)object0))).l0(j31);
                j30 = j31;
            }
            g.o(f50, j30, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

