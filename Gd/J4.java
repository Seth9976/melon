package gd;

import Cc.c1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.K4;
import df.v;
import ie.H;
import java.util.ArrayList;
import we.a;
import we.n;

public final class j4 implements n {
    public final int a;
    public final K4 b;
    public final l4 c;

    public j4(K4 k40, l4 l40, int v) {
        this.a = v;
        this.b = k40;
        this.c = l40;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                a a0 = this.c.getDefaultNetworkErrorHandle().a();
                a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((t4)this.b).a, a0, a1, 0.0f, 0.0f, ((p)(((l)object0))), 0, 24);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            ArrayList arrayList0 = ((v4)this.b).a;
            l4 l40 = this.c;
            boolean z = ((p)(((l)object0))).i(l40);
            j3 j30 = ((p)(((l)object0))).N();
            if(z || j30 == k.a) {
                j3 j31 = new j3(1, l40, l4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 20);
                ((p)(((l)object0))).l0(j31);
                j30 = j31;
            }
            v.g(arrayList0, j30, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

