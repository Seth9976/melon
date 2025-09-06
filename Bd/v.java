package bd;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import M.c;
import M.j;
import M.n0;
import M.p0;
import P0.h;
import P0.i;
import P0.k;
import Q.B;
import T.e;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v5x.response.FlexibleRes.Chat;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;
import we.p;
import y0.M;

public final class v implements p {
    public final List a;
    public final long b;

    public v(long v, List list0) {
        this.a = list0;
        this.b = v;
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        ((Integer)object3).getClass();
        q.g(((B)object0), "$this$VerticalPager");
        Chat flexibleRes$Chat0 = (Chat)this.a.get(((int)(((Integer)object1))) % this.a.size());
        n n0 = n.a;
        r0.q q0 = d.f(n0, 1.0f);
        p0 p00 = n0.a(j.a, r0.d.k, ((l)object2), 0x30);
        int v = ((androidx.compose.runtime.p)(((l)object2))).P;
        i0 i00 = ((androidx.compose.runtime.p)(((l)object2))).m();
        r0.q q1 = a.d(((l)object2), q0);
        k.y.getClass();
        i i0 = P0.j.b;
        ((androidx.compose.runtime.p)(((l)object2))).e0();
        if(((androidx.compose.runtime.p)(((l)object2))).O) {
            ((androidx.compose.runtime.p)(((l)object2))).l(i0);
        }
        else {
            ((androidx.compose.runtime.p)(((l)object2))).o0();
        }
        w.x(((l)object2), p00, P0.j.f);
        w.x(((l)object2), i00, P0.j.e);
        h h0 = P0.j.g;
        if(((androidx.compose.runtime.p)(((l)object2))).O || !q.b(((androidx.compose.runtime.p)(((l)object2))).N(), v)) {
            A7.d.q(v, ((androidx.compose.runtime.p)(((l)object2))), v, h0);
        }
        w.x(((l)object2), q1, P0.j.d);
        r0.q q2 = d5.n.o(d.n(n0, 22.0f), e.a);
        y y0 = androidx.compose.foundation.q.a(e0.T(((l)object2), 0x7F0604AE), 0.5f);  // color:white120e
        c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q2, y0.a, y0.b, e.a), e0.T(((l)object2), 0x7F060145), M.a), flexibleRes$Chat0.getProfileImgUrl(), null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((l)object2), 0x6C00, 0, 0x7FE4);  // color:gray050s
        c.d(((l)object2), d.q(n0, 6.0f));
        N1.b((flexibleRes$Chat0.getText() == null ? "" : flexibleRes$Chat0.getText()), null, this.b, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((l)object2), 0xC00, 0xC30, 0x1D7F2);
        ((androidx.compose.runtime.p)(((l)object2))).p(true);
        return H.a;
    }
}

