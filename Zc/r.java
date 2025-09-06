package zc;

import O.F;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHCHARTINFO;
import com.iloen.melon.net.v4x.common.GraphDataListInfo;
import ie.H;
import java.util.List;
import jd.D1;
import kotlinx.coroutines.CoroutineScope;
import we.n;
import we.p;

public final class r extends kotlin.jvm.internal.r implements p {
    public final List f;
    public final int g;
    public final n h;
    public final CoroutineScope i;
    public final F j;
    public final n k;

    public r(List list0, int v, n n0, CoroutineScope coroutineScope0, F f0, n n1) {
        this.f = list0;
        this.g = v;
        this.h = n0;
        this.i = coroutineScope0;
        this.j = f0;
        this.k = n1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        boolean z = true;
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            GraphDataListInfo graphDataListInfo0 = (GraphDataListInfo)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0x57654976);
            GRAPHCHARTINFO graphDataListInfo$GRAPHCHARTINFO0 = graphDataListInfo0.graphChartInfo;
            n n0 = this.h;
            boolean z1 = ((androidx.compose.runtime.p)(((l)object2))).g(n0);
            int v3 = v2 & 0x70 ^ 0x30;
            boolean z2 = v3 > 0x20 && ((androidx.compose.runtime.p)(((l)object2))).e(v) || (v2 & 0x30) == 0x20;
            CoroutineScope coroutineScope0 = this.i;
            boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).i(coroutineScope0);
            F f0 = this.j;
            boolean z4 = ((androidx.compose.runtime.p)(((l)object2))).g(f0);
            q q0 = ((androidx.compose.runtime.p)(((l)object2))).N();
            V v4 = k.a;
            if((z1 | z2 | z3 | z4) != 0 || q0 == v4) {
                q0 = new q(n0, v, coroutineScope0, f0);
                ((androidx.compose.runtime.p)(((l)object2))).l0(q0);
            }
            n n1 = this.k;
            boolean z5 = ((androidx.compose.runtime.p)(((l)object2))).g(n1);
            if((v3 <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v)) && (v2 & 0x30) != 0x20) {
                z = false;
            }
            D1 d10 = ((androidx.compose.runtime.p)(((l)object2))).N();
            if(z5 || z || d10 == v4) {
                d10 = new D1(n1, v, 1);
                ((androidx.compose.runtime.p)(((l)object2))).l0(d10);
            }
            s.b(v, graphDataListInfo$GRAPHCHARTINFO0, this.g, q0, d10, ((androidx.compose.runtime.p)(((l)object2))), (v2 & 0x7E) >> 3 & 14);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

