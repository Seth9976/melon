package Mc;

import Nc.v1;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import cd.E0;
import cd.I0;
import cd.K;
import cd.U;
import com.iloen.melon.net.v5x.response.FlexibleRes.BadgeType;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import d;
import e1.G;
import e;
import ie.H;
import java.util.List;
import r0.n;
import r0.q;
import we.p;

public final class r extends kotlin.jvm.internal.r implements p {
    public final int f;
    public final List g;

    public r(List list0, int v) {
        this.f = v;
        this.g = list0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                int v3 = ((Number)object1).intValue();
                int v4 = ((Number)object3).intValue();
                int v5 = (v4 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v4 : v4;
                if((v4 & 0x30) == 0) {
                    v5 |= (((androidx.compose.runtime.p)(((l)object2))).e(v3) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v5 & 1, (v5 & 0x93) != 0x92)) {
                    v1 v10 = (v1)this.g.get(v3);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(-2034415768);
                    a.a.f(null, v10, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                int v6 = ((Number)object1).intValue();
                int v7 = ((Number)object3).intValue();
                int v8 = (v7 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v7 : v7;
                if((v7 & 0x30) == 0) {
                    v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v6) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v8 & 1, (v8 & 0x93) != 0x92)) {
                    v1 v11 = (v1)this.g.get(v6);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x9EB35AF4);
                    a.a.f(null, v11, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 2: {
                int v9 = ((Number)object1).intValue();
                int v10_1 = ((Number)object3).intValue();
                int v11_1 = (v10_1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v10_1 : v10_1;
                if((v10_1 & 0x30) == 0) {
                    v11_1 |= (((androidx.compose.runtime.p)(((l)object2))).e(v9) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v11_1 & 1, (v11_1 & 0x93) != 0x92)) {
                    K k0 = (K)this.g.get(v9);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(-1830608995);
                    U.a(v9, k0, ((androidx.compose.runtime.p)(((l)object2))), (v11_1 & 0x7E) >> 3 & 14);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 3: {
                int v12 = ((Number)object1).intValue();
                int v13 = ((Number)object3).intValue();
                int v14 = (v13 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v13 : v13;
                if((v13 & 0x30) == 0) {
                    v14 |= (((androidx.compose.runtime.p)(((l)object2))).e(v12) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v14 & 1, (v14 & 0x93) != 0x92)) {
                    e e0 = (e)this.g.get(v12);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x252C2D39);
                    d.a(e0, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 4: {
                int v15 = ((Number)object1).intValue();
                int v16 = ((Number)object3).intValue();
                int v17 = (v16 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v16 : v16;
                if((v16 & 0x30) == 0) {
                    v17 |= (((androidx.compose.runtime.p)(((l)object2))).e(v15) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v17 & 1, (v17 & 0x93) != 0x92)) {
                    e e1 = (e)this.g.get(v15);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xED2C7A3B);
                    int v18 = BadgeType.EVENT == e1.a.getBadgeType() ? 0x7F08057D : 0;  // drawable:ic_music_event
                    q q0 = androidx.compose.foundation.layout.d.q(n.a, 320.0f);
                    String s1 = e1.a.getImgUrl();
                    String s2 = e1.a.getTitle();
                    String s3 = e1.a.getSubTitle();
                    boolean z = ((androidx.compose.runtime.p)(((l)object2))).i(e1);
                    E0 e00 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v19 = k.a;
                    if(z || e00 == v19) {
                        e00 = new E0(e1, 0);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(e00);
                    }
                    boolean z1 = ((androidx.compose.runtime.p)(((l)object2))).i(e1);
                    E0 e01 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z1 || e01 == v19) {
                        e01 = new E0(e1, 1);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(e01);
                    }
                    a.a.a(q0, (s1 == null ? "" : s1), (s2 == null ? "" : s2), (s3 == null ? "" : s3), v18, e00, e01, ((androidx.compose.runtime.p)(((l)object2))), 6);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 5: {
                int v20 = ((Number)object1).intValue();
                int v21 = ((Number)object3).intValue();
                int v22 = (v21 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v21 : v21;
                if((v21 & 0x30) == 0) {
                    v22 |= (((androidx.compose.runtime.p)(((l)object2))).e(v20) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v22 & 1, (v22 & 0x93) != 0x92)) {
                    e e2 = (e)this.g.get(v20);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(802833098);
                    Content flexibleRes$RESPONSE$Flexible$Content0 = e2.a;
                    boolean z2 = ((androidx.compose.runtime.p)(((l)object2))).i(e2);
                    I0 i00 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z2 || i00 == k.a) {
                        i00 = new I0(e2, 0);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(i00);
                    }
                    d.a(new e(flexibleRes$RESPONSE$Flexible$Content0, true, i00), ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 6: {
                int v23 = ((Number)object1).intValue();
                int v24 = ((Number)object3).intValue();
                int v25 = (v24 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v24 : v24;
                if((v24 & 0x30) == 0) {
                    v25 |= (((androidx.compose.runtime.p)(((l)object2))).e(v23) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v25 & 1, (v25 & 0x93) != 0x92)) {
                    e e3 = (e)this.g.get(v23);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xE54D1A0);
                    Content flexibleRes$RESPONSE$Flexible$Content1 = e3.a;
                    boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).i(e3);
                    I0 i01 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z3 || i01 == k.a) {
                        i01 = new I0(e3, 1);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(i01);
                    }
                    d.a(new e(flexibleRes$RESPONSE$Flexible$Content1, false, i01), ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    String s = (String)this.g.get(v);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(2004502081);
                    G.b(s, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
        }
    }
}

