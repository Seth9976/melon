package cd;

import A7.d;
import Ac.X;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import M.j;
import M.p0;
import P0.h;
import T.e;
import Zc.N;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.net.res.MainMusicMiddleBannerRes.Response.Banner;
import com.melon.net.res.MainMusicMiddleBannerRes.Response;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.i;
import r0.n;
import wc.u;
import y0.M;

public abstract class l1 {
    public static final void a(m1 m10, l l0, int v) {
        long v8;
        b b1;
        h h8;
        n n2;
        h h7;
        h h6;
        i i4;
        h h5;
        P0.i i3;
        h h4;
        P0.i i2;
        Banner mainMusicMiddleBannerRes$Response$Banner1;
        long v2;
        k1 k10;
        n0 n00;
        q.g(m10, "uiState");
        p p0 = (p)l0;
        p0.c0(875702601);
        int v1 = v | (p0.i(m10) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Response mainMusicMiddleBannerRes$Response0 = m10.a.getResponse();
            if(mainMusicMiddleBannerRes$Response0 == null) {
            label_193:
                n00 = p0.t();
                if(n00 != null) {
                    k10 = new k1(m10, v, 0);
                    n00.d = k10;
                }
            }
            else {
                List list0 = mainMusicMiddleBannerRes$Response0.getBannerList();
                if(list0 != null) {
                    Banner mainMusicMiddleBannerRes$Response$Banner0 = (Banner)je.p.m0(list0);
                    if(mainMusicMiddleBannerRes$Response$Banner0 != null) {
                        String s = mainMusicMiddleBannerRes$Response$Banner0.getImgUrl();
                        boolean z = s == null || s.length() == 0;
                        if(z) {
                            v2 = d.f(p0, 0x1955D100, 0x7F060145, p0, false);  // color:gray050s
                        }
                        else {
                            p0.a0(425117301);
                            p0.p(false);
                            v2 = M.c(ColorUtils.getColorFromHexStr(mainMusicMiddleBannerRes$Response$Banner0.getBgColor()));
                        }
                        n n0 = n.a;
                        r0.q q0 = androidx.compose.foundation.layout.d.h(a.l(n0, 20.0f, 0.0f, 2), 80.0f);
                        y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
                        T.d d0 = e.b(4.0f);
                        r0.q q1 = r0.a.a(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0), new X(m10, 27));
                        boolean z1 = p0.i(m10);
                        boolean z2 = p0.i(mainMusicMiddleBannerRes$Response$Banner0);
                        N n1 = p0.N();
                        if(z1 || z2 || n1 == k.a) {
                            n1 = new N(5, m10, mainMusicMiddleBannerRes$Response$Banner0);
                            p0.l0(n1);
                        }
                        r0.q q2 = m3.b(q1, n1);
                        p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
                        int v3 = p0.P;
                        i0 i00 = p0.m();
                        r0.q q3 = r0.a.d(p0, q2);
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
                        w.x(p0, p00, h0);
                        h h1 = P0.j.e;
                        w.x(p0, i00, h1);
                        h h2 = P0.j.g;
                        if(p0.O) {
                            mainMusicMiddleBannerRes$Response$Banner1 = mainMusicMiddleBannerRes$Response$Banner0;
                            d.q(v3, p0, v3, h2);
                        }
                        else {
                            mainMusicMiddleBannerRes$Response$Banner1 = mainMusicMiddleBannerRes$Response$Banner0;
                            if(!q.b(p0.N(), v3)) {
                                d.q(v3, p0, v3, h2);
                            }
                        }
                        h h3 = P0.j.d;
                        w.x(p0, q3, h3);
                        String s1 = mainMusicMiddleBannerRes$Response$Banner1.getImgUrl();
                        String s2 = "";
                        if(s1 == null) {
                            s1 = "";
                        }
                        c1.n(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n0, 1.0f), 80.0f), e.d(4.0f, 0.0f, 0.0f, 4.0f, 6)), e0.T(p0, 0x7F060145), M.a), s1, mainMusicMiddleBannerRes$Response$Banner1.getImgAltText(), N0.j.d, false, 0x7F08078B, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30C00, 0, 0x7FD0);  // color:gray050s
                        r0.q q4 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n0, 1.0f), 0.5f);
                        u u0 = M.a;
                        r0.q q5 = androidx.compose.foundation.q.f(q4, v2, u0);
                        i i1 = r0.d.a;
                        N0.M m0 = M.p.d(i1, false);
                        int v4 = p0.P;
                        i0 i01 = p0.m();
                        r0.q q6 = r0.a.d(p0, q5);
                        p0.e0();
                        if(p0.O) {
                            i2 = i0;
                            p0.l(i2);
                        }
                        else {
                            i2 = i0;
                            p0.o0();
                        }
                        w.x(p0, m0, h0);
                        w.x(p0, i01, h1);
                        if(!p0.O && q.b(p0.N(), v4)) {
                            h4 = h2;
                        }
                        else {
                            h4 = h2;
                            d.q(v4, p0, v4, h4);
                        }
                        w.x(p0, q6, h3);
                        M.p.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.c(n0, 1.0f), 0.5f), e0.T(p0, 0x7F06014A), u0), p0, 0);  // color:gray100a
                        p0.p(true);
                        r0.q q7 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.c(new LayoutWeightElement(1.0f, true), 1.0f), e.d(0.0f, 4.0f, 4.0f, 0.0f, 9)), v2, u0);
                        N0.M m1 = M.p.d(i1, false);
                        int v5 = p0.P;
                        i0 i02 = p0.m();
                        r0.q q8 = r0.a.d(p0, q7);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i2);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, m1, h0);
                        w.x(p0, i02, h1);
                        if(p0.O || !q.b(p0.N(), v5)) {
                            d.q(v5, p0, v5, h4);
                        }
                        w.x(p0, q8, h3);
                        r0.q q9 = a.n(n0, 16.0f, 0.0f, 12.0f, 0.0f, 10);
                        b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                        r0.q q10 = b0.a(q9, r0.d.d);
                        M.y y1 = M.w.a(j.c, r0.d.m, p0, 0);
                        int v6 = p0.P;
                        i0 i03 = p0.m();
                        r0.q q11 = r0.a.d(p0, q10);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i2);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, y1, h0);
                        w.x(p0, i03, h1);
                        if(p0.O || !q.b(p0.N(), v6)) {
                            d.q(v6, p0, v6, h4);
                        }
                        w.x(p0, q11, h3);
                        long v7 = z ? d.f(p0, 0x18B16B5F, 0x7F060172, p0, false) : d.f(p0, 0x18B2BC9E, 0x7F0604A1, p0, false);  // color:gray990s
                        String s3 = mainMusicMiddleBannerRes$Response$Banner1.getCapsuleText();
                        if(s3 != null && s3.length() != 0) {
                            p0.a0(0x18B5C6E3);
                            r0.q q12 = a.k(androidx.compose.foundation.q.i(1.0f, v7, n0, e.b(100.0f)), 6.0f, 3.0f);
                            N0.M m2 = M.p.d(i1, false);
                            int v9 = p0.P;
                            i0 i04 = p0.m();
                            r0.q q13 = r0.a.d(p0, q12);
                            p0.e0();
                            if(p0.O) {
                                p0.l(i2);
                            }
                            else {
                                p0.o0();
                            }
                            w.x(p0, m2, h0);
                            w.x(p0, i04, h1);
                            if(p0.O || !q.b(p0.N(), v9)) {
                                d.q(v9, p0, v9, h4);
                            }
                            w.x(p0, q13, h3);
                            v8 = v7;
                            i4 = i1;
                            b1 = b0;
                            h7 = h1;
                            h8 = h4;
                            h6 = h3;
                            i3 = i2;
                            h5 = h0;
                            n2 = n0;
                            N1.b((mainMusicMiddleBannerRes$Response$Banner1.getCapsuleText() == null ? "" : mainMusicMiddleBannerRes$Response$Banner1.getCapsuleText()), null, v8, 9.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C00, 0xC00, 0x1DFD2);
                            p0.p(true);
                            d.v(n2, 8.0f, p0, false);
                        }
                        else {
                            i3 = i2;
                            h5 = h0;
                            i4 = i1;
                            h6 = h3;
                            h7 = h1;
                            n2 = n0;
                            h8 = h4;
                            b1 = b0;
                            v8 = v7;
                            p0.a0(0x186F0D50);
                            p0.p(false);
                        }
                        String s4 = mainMusicMiddleBannerRes$Response$Banner1.getText();
                        if(s4 != null) {
                            s2 = s4;
                        }
                        N1.b(s2, null, v8, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);
                        p0.p(true);
                        if(mainMusicMiddleBannerRes$Response$Banner1.isAd()) {
                            p0.a0(0xCFA2598D);
                            long v10 = z ? d.f(p0, 0xCFA29AB3, 0x7F060160, p0, false) : d.f(p0, 0xCFA43E88, 0x7F0604B7, p0, false);  // color:gray600s_support_high_contrast
                            r0.q q14 = androidx.compose.foundation.q.i(0.5f, v10, b1.a(a.n(n2, 0.0f, 10.0f, 10.0f, 0.0f, 9), r0.d.c), e.b(100.0f));
                            N0.M m3 = M.p.d(i4, false);
                            int v11 = p0.P;
                            i0 i05 = p0.m();
                            r0.q q15 = r0.a.d(p0, q14);
                            p0.e0();
                            if(p0.O) {
                                p0.l(i3);
                            }
                            else {
                                p0.o0();
                            }
                            w.x(p0, m3, h5);
                            w.x(p0, i05, h7);
                            if(p0.O || !q.b(p0.N(), v11)) {
                                d.q(v11, p0, v11, h8);
                            }
                            w.x(p0, q15, h6);
                            r0.q q16 = a.k(n2, 6.0f, 2.0f);
                            N1.b(H0.e.Y(p0, 0x7F13001D), q16, v10, 9.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C30, 0xC00, 0x1DFD0);  // string:ad "AD"
                            p0.p(true);
                        }
                        else {
                            p0.a0(0xCF49E27A);
                        }
                        p0.p(false);
                        p0.p(true);
                        p0.p(true);
                        goto label_198;
                    }
                }
                goto label_193;
            }
        }
        else {
            p0.T();
        label_198:
            n00 = p0.t();
            if(n00 != null) {
                k10 = new k1(m10, v, 1);
                n00.d = k10;
            }
        }
    }
}

