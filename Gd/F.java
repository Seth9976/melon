package gd;

import Ac.X2;
import Cc.w3;
import android.content.Context;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import com.iloen.melon.utils.StringUtils;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import r0.a;
import r0.n;
import we.k;
import we.p;

public final class f extends r implements p {
    public final List f;
    public final float g;
    public final Context h;
    public final k i;

    public f(List list0, float f, Context context0, k k0) {
        this.f = list0;
        this.g = f;
        this.h = context0;
        this.i = k0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((P.k)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            B b0 = (B)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0x185902EF);
            q.e(b0, "null cannot be cast to non-null type com.melon.ui.melondj.DjHomeSubContentListItem.DjHomeNewDjSubContentListItem");
            r0.q q0 = d.h(a.a(d.q(n.a, this.g), new X2(this.i, b0, v, 8)), 88.0f);
            String s = ((u)b0).a;
            String s1 = ((u)b0).b;
            String s2 = StringUtils.getFriendDisplayName(((u)b0).d, ((u)b0).c);
            boolean z = ((u)b0).e;
            String s3 = ((u)b0).f;
            String s4 = ((u)b0).g;
            if(s4 == null) {
                s4 = 0;
            }
            w3.l(q0, s, s1, s2, z, s3, "플레이리스트 " + s4, false, false, ((u)b0).d, null, null, ((androidx.compose.runtime.p)(((l)object2))), 0x6C00000, 6, 0x800);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

