package cd;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.q0;
import M.c;
import M.g;
import M.j0;
import M.j;
import M.y;
import N0.M;
import Nc.Y;
import O.F;
import O.I;
import P0.h;
import T.e;
import U4.x;
import Vb.i;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import b9.a;
import bd.s;
import com.google.firebase.b;
import com.iloen.melon.net.v4x.common.ContentListInfo.Tag;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAGCONTENTS;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.StringUtils;
import d5.w;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.q;
import kotlinx.coroutines.CoroutineScope;
import r0.n;

public abstract class m2 {
    public static final void a(d2 d20, String s, l l0, int v) {
        String s1;
        ((p)l0).c0(-581300659);
        int v1 = (((p)l0).i(d20) ? 4 : 2) | v | (((p)l0).g(s) ? 0x20 : 16);
        boolean z = false;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            TAGCONTENTS mainMusicRes$RESPONSE$TAGCONTENTS0 = d20.a;
            List list0 = mainMusicRes$RESPONSE$TAGCONTENTS0.tagList;
            if(list0 == null) {
                s1 = "";
            }
            else {
                if(list0.isEmpty()) {
                    list0 = null;
                }
                if(list0 == null) {
                    s1 = "";
                }
                else {
                    ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
                    for(Object object0: list0) {
                        arrayList0.add(((Tag)object0).tagName);
                    }
                    s1 = je.p.q0(arrayList0, " ", null, null, null, 62);
                }
            }
            String s2 = mainMusicRes$RESPONSE$TAGCONTENTS0.thumbimg;
            kotlin.jvm.internal.q.f(s2, "thumbimg");
            String s3 = mainMusicRes$RESPONSE$TAGCONTENTS0.plylsttitle;
            kotlin.jvm.internal.q.f(s3, "plylsttitle");
            boolean z1 = ((p)l0).i(d20);
            j2 j20 = ((p)l0).N();
            V v2 = k.a;
            if(z1 || (v1 & 0x70) == 0x20 || j20 == v2) {
                j20 = new j2(d20, s, 0);
                ((p)l0).l0(j20);
            }
            boolean z2 = ((p)l0).i(d20);
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            j2 j21 = ((p)l0).N();
            if(z2 || z || j21 == v2) {
                j21 = new j2(d20, s, 1);
                ((p)l0).l0(j21);
            }
            boolean z3 = ((p)l0).i(d20);
            a a0 = ((p)l0).N();
            if(z3 || a0 == v2) {
                a0 = new a(d20, 14);
                ((p)l0).l0(a0);
            }
            q0.b(s2, s3, null, null, s1, null, null, true, null, 0.0f, 0.0f, 0, 0.0f, 0.0f, 2, 1, null, j20, j21, a0, ResourceUtilsKt.getString(0x7F130BE5, new Object[]{mainMusicRes$RESPONSE$TAGCONTENTS0.plylsttitle + " " + s1}), 0, false, ((p)l0), 0xC00000, 0x36000, 0xE13F6C);  // string:talkback_playlist_detail "%s 플레이리스트 상세보기"
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Y(d20, s, v, 29);
        }
    }

    public static final void b(n2 n20, l l0, int v) {
        V v5;
        F f2;
        K0 k00;
        Bd.F f1;
        Object object3;
        String s1;
        kotlin.jvm.internal.q.g(n20, "uiState");
        List list0 = n20.b;
        p p0 = (p)l0;
        p0.c0(-215201938);
        int v1 = v | (p0.i(n20) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Object object0 = n20.c;
            i i0 = p0.N();
            V v2 = k.a;
            if(i0 == v2) {
                i0 = new i(16);
                p0.l0(i0);
            }
            a0 a00 = (a0)w.P(new Object[0], null, null, i0, p0, 0, 6);
            F f0 = I.a(0, 0, 3, p0);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            HeaderBase headerBase0 = n20.a == null ? null : n20.a.a;
            if(headerBase0 == null) {
                p0.a0(-464970357);
            }
            else {
                p0.a0(-464970356);
                boolean z = p0.i(n20);
                i2 i20 = p0.N();
                if(z || i20 == v2) {
                    i20 = new i2(n20, 0);
                    p0.l0(i20);
                }
                boolean z1 = p0.i(n20);
                i2 i21 = p0.N();
                if(z1 || i21 == v2) {
                    i21 = new i2(n20, 1);
                    p0.l0(i21);
                }
                b.j(new s(headerBase0, i20, i21, null, 0x4FE), p0, 0);
            }
            p0.p(false);
            c.d(p0, d.h(n0, 2.0f));
            ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
            for(Object object1: list0) {
                CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0 = (CONTENTS)object1;
                if(mainMusicRes$RESPONSE$TAG$CONTENTS0 == null) {
                    s1 = "";
                }
                else {
                    String s = mainMusicRes$RESPONSE$TAG$CONTENTS0.getTagName();
                    if(s != null) {
                        s1 = s;
                    }
                }
                arrayList0.add(s1);
            }
            int v4 = ((K0)a00).m();
            boolean z2 = p0.g(((K0)a00));
            boolean z3 = p0.i(n20);
            boolean z4 = p0.i(coroutineScope0);
            boolean z5 = p0.g(f0);
            Object object2 = p0.N();
            if((z2 | z3 | z4 | z5) != 0 || object2 == v2) {
                object3 = object0;
                k00 = (K0)a00;
                f2 = f0;
                v5 = v2;
                f1 = new Bd.F(k00, n20, coroutineScope0, f2, 7);
                p0.l0(f1);
            }
            else {
                object3 = object0;
                f1 = object2;
                k00 = (K0)a00;
                f2 = f0;
                v5 = v2;
            }
            c1.N(arrayList0, null, v4, null, f1, p0, 0, 10);
            c.d(p0, d.h(n0, 12.0f));
            g g0 = j.h(12.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            boolean z6 = p0.i(object3);
            boolean z7 = p0.g(k00);
            boolean z8 = p0.i(n20);
            Ac.m2 m20 = p0.N();
            if((z6 | z7 | z8) != 0 || m20 == v5) {
                m20 = new Ac.m2(object3, k00, n20, 24);
                p0.l0(m20);
            }
            c1.q(null, f2, j00, g0, null, null, false, m20, p0, 0x6180, 0xE9);
            r0.q q2 = r0.a.a(d5.n.o(androidx.compose.foundation.layout.a.l(d.h(x.s(n0, 20.0f, p0, n0, 1.0f), 48.0f), 20.0f, 0.0f, 2), e.b(4.0f)), new Ac.l(15, n20, k00));
            M m0 = M.p.d(r0.d.a, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i2 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i01, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h1);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS1 = (CONTENTS)list0.get(k00.m());
            String s2 = mainMusicRes$RESPONSE$TAG$CONTENTS1 == null ? null : mainMusicRes$RESPONSE$TAG$CONTENTS1.getTagName();
            if(s2 == null) {
                s2 = "";
            }
            N1.b(va.e.c(StringUtils.getTrimmed(s2, 13), " ", H0.e.Y(p0, 0x7F1306AE)), d.u(androidx.compose.foundation.q.f(n0, e0.T(p0, 0x7F060145), y0.M.a).then(d.c), 2), 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFC);  // string:more_title "더보기"
            p0.p(true);
            p0.p(true);
            boolean z9 = p0.g(f2);
            l2 l20 = p0.N();
            if(z9 || l20 == v5) {
                l20 = new l2(f2, null);
                p0.l0(l20);
            }
            J.d(p0, H.a, l20);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Zc.c(n20, v, 25);
        }
    }
}

