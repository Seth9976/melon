package Ac;

import androidx.compose.runtime.a0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.melon.ui.K4;
import ie.H;
import we.n;
import x1.a;

public final class r0 implements n {
    public final K4 a;
    public final String[] b;
    public final u0 c;

    public r0(D0 d00, String[] arr_s, u0 u00) {
        this.a = d00;
        this.b = arr_s;
        this.c = u00;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = ((Number)object1).intValue();
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            a0 a00 = w.p(((D0)this.a).a);
            u0 u00 = this.c;
            boolean z = ((p)(((l)object0))).i(u00);
            q0 q00 = ((p)(((l)object0))).N();
            if(z || q00 == k.a) {
                q00 = new q0(u00, 0);
                ((p)(((l)object0))).l0(q00);
            }
            a.g(a00, this.b, 1, 239.0f, 85.0f, q00, ((p)(((l)object0))), 0x6D80, 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

