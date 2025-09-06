package cd;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import M.c;
import M.d;
import M.j;
import M.n0;
import M.p0;
import M.w;
import M.y;
import P0.h;
import T.e;
import Tf.o;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import b9.a;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.tab.MainTabConstants.StrategyIconType;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import r0.g;
import r0.i;
import r0.n;
import wc.u;
import y0.M;

public abstract class b2 {
    public static final void a(boolean z, R1 r10, l l0, int v) {
        h h16;
        float f;
        i i5;
        h h14;
        h h13;
        long v10;
        P0.i i4;
        b b1;
        h h12;
        h h11;
        h h15;
        h h10;
        P0.i i3;
        h h9;
        P0.i i1;
        OFFERING mainMusicRes$RESPONSE$STRATEGY$OFFERING1;
        h h8;
        h h7;
        g g1;
        d d1;
        n n1;
        h h6;
        long v4;
        h h5;
        h h3;
        long v2;
        q.g(r10, "uiState");
        p p0 = (p)l0;
        p0.c0(1501682867);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.i(r10) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            OFFERING mainMusicRes$RESPONSE$STRATEGY$OFFERING0 = r10.a;
            String s = mainMusicRes$RESPONSE$STRATEGY$OFFERING0.getImgUrl();
            boolean z1 = s == null || s.length() == 0;
            if(z1) {
                v2 = A7.d.f(p0, 255150710, 0x7F060145, p0, false);  // color:gray050s
            }
            else {
                p0.a0(0xF364029);
                p0.p(false);
                v2 = M.c(ColorUtils.getColorFromHexStr(mainMusicRes$RESPONSE$STRATEGY$OFFERING0.getBgColor()));
            }
            boolean z2 = p0.i(r10);
            a a0 = p0.N();
            if(z2 || a0 == k.a) {
                a0 = new a(r10, 13);
                p0.l0(a0);
            }
            n n0 = n.a;
            r0.q q0 = r0.a.a(m3.b(n0, a0), new Z1(r10, 0));
            d d0 = j.c;
            g g0 = r0.d.m;
            y y0 = w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O) {
                h3 = h0;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                h3 = h0;
                if(!q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h4);
            if(z) {
                p0.a0(0xACBC0C2E);
                h5 = h2;
                v4 = v2;
                h6 = h4;
                n1 = n0;
                d1 = d0;
                g1 = g0;
                h7 = h3;
                h8 = h1;
                mainMusicRes$RESPONSE$STRATEGY$OFFERING1 = mainMusicRes$RESPONSE$STRATEGY$OFFERING0;
                i1 = i0;
                N1.b((mainMusicRes$RESPONSE$STRATEGY$OFFERING0.getTitle() == null ? "" : mainMusicRes$RESPONSE$STRATEGY$OFFERING0.getTitle()), androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 37.0f), 2), 0.0f, 0.0f, 20.0f, 0.0f, 11), e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray600s_support_high_contrast
            }
            else {
                h6 = h4;
                h8 = h1;
                n1 = n0;
                h5 = h2;
                v4 = v2;
                d1 = d0;
                g1 = g0;
                mainMusicRes$RESPONSE$STRATEGY$OFFERING1 = mainMusicRes$RESPONSE$STRATEGY$OFFERING0;
                h7 = h3;
                i1 = i0;
                p0.a0(-1401060923);
            }
            p0.p(false);
            r0.q q2 = androidx.compose.foundation.layout.d.h(n1, 102.0f);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d2 = e.b(4.0f);
            r0.q q3 = androidx.compose.foundation.q.j(q2, y1.a, y1.b, d2);
            p0 p00 = n0.a(j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h7);
            androidx.compose.runtime.w.x(p0, i01, h8);
            if(!p0.O && q.b(p0.N(), v5)) {
                h9 = h5;
            }
            else {
                h9 = h5;
                A7.d.q(v5, p0, v5, h9);
            }
            androidx.compose.runtime.w.x(p0, q4, h6);
            String s1 = mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getImgUrl();
            if(s1 == null) {
                s1 = "";
            }
            r0.q q5 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n1, 1.0f), 102.0f), e.d(4.0f, 0.0f, 0.0f, 4.0f, 6)), e0.T(p0, 0x7F060145), M.a);  // color:gray050s
            u u0 = M.a;
            c1.n(q5, s1, mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getImgAltText(), N0.j.d, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF0);
            r0.q q6 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n1, 1.0f), 0.5f), v4, u0);
            i i2 = r0.d.a;
            N0.M m0 = M.p.d(i2, false);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                i3 = i1;
                p0.l(i3);
            }
            else {
                i3 = i1;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h7);
            androidx.compose.runtime.w.x(p0, i02, h8);
            if(!p0.O && q.b(p0.N(), v6)) {
                h10 = h9;
            }
            else {
                h10 = h9;
                A7.d.q(v6, p0, v6, h10);
            }
            androidx.compose.runtime.w.x(p0, q7, h6);
            M.p.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n1, 1.0f), 0.5f), e0.T(p0, 0x7F06014A), u0), p0, 0);  // color:gray100a
            p0.p(true);
            r0.q q8 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c(new LayoutWeightElement(1.0f, true), 1.0f), e.d(0.0f, 4.0f, 4.0f, 0.0f, 9)), v4, u0);
            N0.M m1 = M.p.d(i2, false);
            int v7 = p0.P;
            i0 i03 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h7);
            androidx.compose.runtime.w.x(p0, i03, h8);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h10);
            }
            androidx.compose.runtime.w.x(p0, q9, h6);
            r0.q q10 = androidx.compose.foundation.layout.a.n(n1, 16.0f, 0.0f, 12.0f, 0.0f, 10);
            b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q11 = b0.a(q10, r0.d.d);
            y y2 = w.a(d1, g1, p0, 0);
            int v8 = p0.P;
            i0 i04 = p0.m();
            r0.q q12 = r0.a.d(p0, q11);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y2, h7);
            androidx.compose.runtime.w.x(p0, i04, h8);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h10);
            }
            androidx.compose.runtime.w.x(p0, q12, h6);
            long v9 = z1 ? A7.d.f(p0, -80557405, 0x7F060172, p0, false) : A7.d.f(p0, -80463134, 0x7F0604A1, p0, false);  // color:gray990s
            String s2 = mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getLogoImgUrl();
            if((q.b(mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getLogoType(), "I") & ((s2 == null || s2.length() == 0 ? 1 : 0) ^ 1)) == 0) {
                i4 = i3;
                b1 = b0;
                p0.a0(0xFB3CFF5B);
                String s3 = mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getCapsuleText();
                if(s3 != null && s3.length() != 0) {
                    p0.a0(0xFB3E127B);
                    r0.q q13 = androidx.compose.foundation.layout.a.k(androidx.compose.foundation.q.i(1.0f, v9, n1, e.b(100.0f)), 6.0f, 3.0f);
                    N0.M m2 = M.p.d(i2, false);
                    int v11 = p0.P;
                    i0 i05 = p0.m();
                    r0.q q14 = r0.a.d(p0, q13);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i4);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m2, h7);
                    androidx.compose.runtime.w.x(p0, i05, h8);
                    if(!p0.O && q.b(p0.N(), v11)) {
                        h15 = h10;
                    }
                    else {
                        h15 = h10;
                        A7.d.q(v11, p0, v11, h15);
                    }
                    androidx.compose.runtime.w.x(p0, q14, h6);
                    v10 = v9;
                    h11 = h8;
                    h12 = h7;
                    h13 = h15;
                    h14 = h6;
                    i5 = i2;
                    N1.b((mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getCapsuleText() == null ? "" : mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getCapsuleText()), null, v10, 9.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C00, 0xC00, 0x1DFD2);
                    p0.p(true);
                }
                else {
                    v10 = v9;
                    h12 = h7;
                    h11 = h8;
                    h13 = h10;
                    h14 = h6;
                    i5 = i2;
                    p0.a0(0xFAD3C43C);
                }
                p0.p(false);
                p0.p(false);
            }
            else {
                p0.a0(-80170339);
                h11 = h8;
                h12 = h7;
                b1 = b0;
                i4 = i3;
                c1.n(null, mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getLogoImgUrl(), null, N0.j.c, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C00, 0, 0x7FE5);
                p0.p(false);
                v10 = v9;
                h13 = h10;
                h14 = h6;
                i5 = i2;
            }
            c.d(p0, androidx.compose.foundation.layout.d.h(n1, 8.0f));
            N1.b((mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getText1() == null ? "" : mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getText1()), null, v10, 14.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 120786);
            e1.y y3 = e1.y.i;
            c.d(p0, androidx.compose.foundation.layout.d.h(n1, 4.0f));
            N1.b((mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getText2() == null ? "" : mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getText2()), null, v10, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
            p0.p(true);
            StrategyIconType mainTabConstants$StrategyIconType0 = mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getISad() ? StrategyIconType.AD : StrategyIconType.Companion.getIconType((mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getContsTypeCode() == null ? "" : mainMusicRes$RESPONSE$STRATEGY$OFFERING1.getContsTypeCode()));
            int[] arr_v = a2.a;
            int v12 = arr_v[mainTabConstants$StrategyIconType0.ordinal()];
            if(v12 == 1) {
                f = 0.0f;
            }
            else {
                switch(v12) {
                    case 2: {
                        f = 6.0f;
                        break;
                    }
                    case 3: {
                        f = 10.0f;
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            r0.q q15 = b1.a(androidx.compose.foundation.layout.a.n(n1, 0.0f, f, f, 0.0f, 9), r0.d.c);
            N0.M m3 = M.p.d(i5, false);
            int v13 = p0.P;
            i0 i06 = p0.m();
            r0.q q16 = r0.a.d(p0, q15);
            p0.e0();
            if(p0.O) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m3, h12);
            androidx.compose.runtime.w.x(p0, i06, h11);
            if(!p0.O && q.b(p0.N(), v13)) {
                h16 = h13;
            }
            else {
                h16 = h13;
                A7.d.q(v13, p0, v13, h16);
            }
            androidx.compose.runtime.w.x(p0, q16, h14);
            switch(arr_v[mainTabConstants$StrategyIconType0.ordinal()]) {
                case 2: {
                    p0.a0(0xDAA032FE);
                    c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(n1, 24.0f), new Z1(r10, 1)), 0x7F080309, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x1B0, 0, 0x7FF8);  // drawable:common_btn_play_01
                    p0.p(false);
                    break;
                }
                case 3: {
                    p0.a0(0xDAAC4A83);
                    long v14 = z1 ? A7.d.f(p0, 0xDAACAA2D, 0x7F060160, p0, false) : A7.d.f(p0, 0xDAAEAB02, 0x7F0604B7, p0, false);  // color:gray600s_support_high_contrast
                    r0.q q17 = androidx.compose.foundation.q.i(0.5f, v14, n1, e.b(100.0f));
                    N0.M m4 = M.p.d(i5, false);
                    int v15 = p0.P;
                    i0 i07 = p0.m();
                    r0.q q18 = r0.a.d(p0, q17);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i4);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m4, h12);
                    androidx.compose.runtime.w.x(p0, i07, h11);
                    if(p0.O || !q.b(p0.N(), v15)) {
                        A7.d.q(v15, p0, v15, h16);
                    }
                    androidx.compose.runtime.w.x(p0, q18, h14);
                    r0.q q19 = androidx.compose.foundation.layout.a.k(n1, 6.0f, 2.0f);
                    N1.b(H0.e.Y(p0, 0x7F13001D), q19, v14, 9.0f, y3, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C30, 0xC00, 0x1DFD0);  // string:ad "AD"
                    p0.p(true);
                    p0.p(false);
                    break;
                }
                default: {
                    p0.a0(-625032887);
                    p0.p(false);
                }
            }
            p0.p(true);
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Fd.h(z, r10, v, 4);
        }
    }

    public static final void b(c2 c20, l l0, int v) {
        q.g(c20, "uiState");
        ((p)l0).c0(0xFBBB0B77);
        int v1 = (((p)l0).i(c20) ? 4 : 2) | v;
        boolean z = false;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, c20.a));
            for(Object object0: c20.a) {
                arrayList0.add(((R1)object0).a);
            }
            if(!arrayList0.isEmpty()) {
                for(Object object1: arrayList0) {
                    String s = ((OFFERING)object1).getTitle();
                    if(s != null && !o.H0(s) == 1) {
                        z = true;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            c.a(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 3), null, false, m0.c.e(0xBB6A92E1, ((p)l0), new W1(arrayList0, z, c20, 0)), ((p)l0), 0xC06, 6);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Zc.c(c20, v, 24);
        }
    }
}

