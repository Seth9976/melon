package hd;

import Ac.Z2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import T.e;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.CARDINFO.CONTENTS.TAGLIST;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import r0.a;
import r0.n;
import r0.q;
import wc.u;
import we.k;
import we.p;
import y0.s;

public final class x extends r implements p {
    public final List f;
    public final Context g;
    public final int h;
    public final k i;

    public x(List list0, Context context0, int v, k k0) {
        this.f = list0;
        this.g = context0;
        this.h = v;
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
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            TAGLIST musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO$CONTENTS$TAGLIST0 = (TAGLIST)this.f.get(v);
            p0.a0(-239550181);
            n n0 = n.a;
            q q0 = d.h(d.f(n0, 1.0f), 75.0f);
            q q1 = a.a(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q0, e.b(4.0f)), new Z2(this.g, this.h, musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO$CONTENTS$TAGLIST0, this.i));  // color:gray100a
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = a.d(p0, q1);
            P0.k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, j.d);
            T.d d0 = e.b(4.0f);
            c1.n(androidx.compose.foundation.q.f(d5.n.o(d.c, d0), e0.T(p0, 0x7F060142), y0.M.a), musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO$CONTENTS$TAGLIST0.imgUrl, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);  // color:gray030s
            q q3 = androidx.compose.foundation.q.e(d.h(d.q(n0, 125.0f), 35.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F06014D))}), 0.0f, 0.0f, 14), e.b(4.0f), 4);  // color:transparent
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.g), p0, 0);
            N1.b((musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO$CONTENTS$TAGLIST0.tagName == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO$CONTENTS$TAGLIST0.tagName), (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(androidx.compose.foundation.layout.a.n(d.f(n0, 1.0f), 10.0f, 0.0f, 0.0f, 7.0f, 6), r0.d.g), e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:white000e
            p0.p(true);
            p0.p(false);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

