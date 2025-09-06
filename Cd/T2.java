package cd;

import Ac.X;
import Cc.c1;
import Cc.e0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import T.e;
import Zc.c;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v6x.response.BannerRes.RESPONSE;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.d;
import r0.n;

public abstract class t2 {
    public static final void a(u2 u20, l l0, int v) {
        BannerBase bannerBase0;
        q.g(u20, "uiState");
        p p0 = (p)l0;
        p0.c0(0x4F315CD5);
        int v1 = (p0.i(u20) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            RESPONSE bannerRes$RESPONSE0 = u20.a.getResponse();
            if(bannerRes$RESPONSE0 == null) {
                bannerBase0 = null;
            }
            else {
                List list0 = bannerRes$RESPONSE0.getBannerList();
                bannerBase0 = list0 == null ? null : ((BannerBase)je.p.m0(list0));
            }
            if(bannerBase0 == null) {
                p0.a0(-1050393030);
            }
            else {
                p0.a0(-1050393029);
                n n0 = n.a;
                r0.q q0 = a.l(n0, 20.0f, 0.0f, 2);
                M m0 = M.p.d(d.a, false);
                int v2 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h0 = j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                w.x(p0, q1, j.d);
                r0.q q2 = d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 186.0f), e.b(4.0f));
                y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
                T.d d0 = e.b(4.0f);
                c1.n(r0.a.a(androidx.compose.foundation.q.j(q2, y0.a, y0.b, d0), new X(u20, 28)), bannerBase0.imgurl, H0.e.Y(p0, 0x7F130ADA), N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF0);  // string:talkback_banner "배너"
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c(u20, v, 27);
        }
    }
}

