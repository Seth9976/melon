package Ic;

import Hc.O;
import Jc.B;
import Jc.K;
import Jc.X;
import Jc.e0;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class f extends O {
    public final int d;

    public f(int v) {
        this.d = v;
        super();
    }

    @Override  // com.melon.ui.V
    public final boolean b(K4 k40, K4 k41) {
        if(this.d != 0) {
            if(((e0)k40) instanceof X && ((e0)k41) instanceof X) {
                return q.b(((X)(((e0)k40))).r, ((X)(((e0)k41))).r);
            }
            return !(((e0)k40) instanceof K) || !(((e0)k41) instanceof K) ? ((e0)k40).equals(((e0)k41)) : ((K)(((e0)k40))).a == ((K)(((e0)k41))).a;
        }
        if(((e0)k40) instanceof X && ((e0)k41) instanceof X) {
            return q.b(((X)(((e0)k40))).r, ((X)(((e0)k41))).r);
        }
        if(((e0)k40) instanceof K && ((e0)k41) instanceof K) {
            return ((K)(((e0)k40))).a == ((K)(((e0)k41))).a;
        }
        return !(((e0)k40) instanceof B) || !(((e0)k41) instanceof B) ? ((e0)k40).equals(((e0)k41)) : q.b(((B)(((e0)k40))).h, ((B)(((e0)k41))).h);
    }
}

