package cd;

import P.k;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import r0.n;
import r0.q;
import we.p;

public final class m extends r implements p {
    public final List f;
    public final float g;
    public final ChartHeader h;
    public final List i;
    public final K0 j;
    public final CoroutineScope k;
    public final cd.r l;

    public m(List list0, float f, ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0, List list1, K0 k00, CoroutineScope coroutineScope0, cd.r r0) {
        this.f = list0;
        this.g = f;
        this.h = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0;
        this.i = list1;
        this.j = k00;
        this.k = coroutineScope0;
        this.l = r0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((k)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Object object4 = this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-1646402134);
            q q0 = d.h(n.a, this.g);
            K0 k00 = this.j;
            int v3 = k00.m();
            ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = ((Chart)this.i.get(v3)).getHeader();
            boolean z = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 != null && mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0.getUseHighLight() && kotlin.jvm.internal.q.b(((b)object4).a.getCurrentRank(), "1");
            cd.r r0 = this.l;
            boolean z1 = ((androidx.compose.runtime.p)(((l)object2))).i(r0);
            boolean z2 = ((androidx.compose.runtime.p)(((l)object2))).g(k00);
            boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).i(((b)object4));
            Ac.k k0 = ((androidx.compose.runtime.p)(((l)object2))).N();
            if((z1 | z2 | z3) != 0 || k0 == androidx.compose.runtime.k.a) {
                k0 = new Ac.k(r0, k00, ((b)object4), 17);
                ((androidx.compose.runtime.p)(((l)object2))).l0(k0);
            }
            cd.q.b(q0, ((b)object4), this.h, z, this.k, k0, ((androidx.compose.runtime.p)(((l)object2))), 6);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

