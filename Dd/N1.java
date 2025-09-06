package Dd;

import Ac.E;
import Ac.R0;
import Ac.U;
import Ac.r;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import De.I;
import E9.h;
import F8.o;
import J8.W0;
import M.b;
import M.j0;
import M.p0;
import M.q0;
import M.w;
import M.y;
import N0.M;
import N0.j;
import N0.m;
import O.F;
import P0.i;
import T.e;
import U4.x;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.D4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import java.util.List;
import kotlin.Metadata;
import r0.g;
import r0.n;
import r0.q;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007²\u0006\u000E\u0010\u0006\u001A\u00020\u00058\n@\nX\u008A\u008E\u0002"}, d2 = {"LDd/n1;", "LDd/L1;", "LDd/K1;", "<init>", "()V", "", "hasVisualOverflow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class n1 extends c {
    public final LogU j;

    public n1() {
        LogU logU0 = new LogU("PartnerProfileFragment");
        logU0.setCategory(Category.UI);
        this.j = logU0;
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return K1.class;
    }

    public final void n(F f0, List list0, l l0, int v) {
        ((p)l0).c0(-48024024);
        int v1 = v | (((p)l0).g(f0) ? 4 : 2) | (((p)l0).i(list0) ? 0x20 : 16) | (((p)l0).i(this) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            FillElement fillElement0 = d.c;
            j0 j00 = a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(this);
            J j0 = ((p)l0).N();
            if(z || z1 || j0 == k.a) {
                j0 = new J(3, list0, this);
                ((p)l0).l0(j0);
            }
            c1.o(fillElement0, f0, j00, false, null, null, null, false, j0, ((p)l0), v1 << 3 & 0x70 | 6, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E(this, f0, list0, v, 24);
        }
    }

    public final void o(V1 v10, we.k k0, l l0, int v) {
        int v17;
        int v16;
        q q28;
        n n2;
        r0.h h6;
        b b1;
        P0.h h5;
        g g1;
        i i2;
        n n1;
        String s7;
        String s4;
        m m0 = j.g;
        r0.i i0 = r0.d.e;
        kotlin.jvm.internal.q.g(v10, "headerUiState");
        boolean z = v10.b;
        boolean z1 = v10.o;
        kotlin.jvm.internal.q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(-1726494055);
        int v1 = v | (p0.i(v10) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(this) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q0 = d.t(d.f(a.l(n0, 20.0f, 0.0f, 2), 1.0f), 3);
            M.d d0 = M.j.c;
            y y0 = w.a(d0, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            g g0 = r0.d.m;
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            q q2 = d.f(n0, 1.0f);
            r0.h h4 = r0.d.k;
            p0 p00 = M.n0.a(M.j.a, h4, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            b b0 = M.j.a;
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            String s = v10.f == null ? "" : v10.f;
            q q4 = d.n(a.n(n0, 0.0f, 0.0f, 16.0f, 0.0f, 11), 96.0f);
            String s1 = "";
            q q5 = r0.a.a(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q4, e.a), new f(s, k0, v10, 2));  // color:gray100a
            r0.b.e(q5, s, 96.0f, null, 0L, false, false, p0, 0xC00180, 120);
            q q6 = d.f(n0, 1.0f);
            p0 p01 = M.n0.a(b0, h4, p0, 0x30);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            q q8 = q0.a(n0, 1.0f);
            String s2 = v10.h == null ? "" : v10.h;
            String s3 = H0.e.Y(p0, 0x7F130C98);  // string:text_follower "팔로워"
            boolean z2 = p0.i(v10);
            Dd.d d1 = p0.N();
            V v5 = k.a;
            if((v1 & 0x70) == 0x20 || z2 || d1 == v5) {
                s4 = s2;
                d1 = new Dd.d(k0, v10, 6);
                p0.l0(d1);
            }
            else {
                s4 = s2;
            }
            H0.e.i(q8, s4, s3, d1, p0, 0);
            q q9 = q0.a(n0, 1.0f);
            String s5 = v10.j == null ? "" : v10.j;
            String s6 = H0.e.Y(p0, 0x7F130C9D);  // string:text_liked "좋아요"
            boolean z3 = p0.i(v10);
            Dd.d d2 = p0.N();
            if((v1 & 0x70) == 0x20 || z3 || d2 == v5) {
                s7 = s5;
                d2 = new Dd.d(k0, v10, 7);
                p0.l0(d2);
            }
            else {
                s7 = s5;
            }
            H0.e.i(q9, s7, s6, d2, p0, 0);
            q q10 = q0.a(n0, 1.0f);
            String s8 = v10.k == null ? "" : v10.k;
            String s9 = H0.e.Y(p0, 0x7F130CAE);  // string:text_playlist "플레이리스트"
            boolean z4 = p0.i(v10);
            Dd.d d3 = p0.N();
            if((v1 & 0x70) == 0x20 || z4 || d3 == v5) {
                d3 = new Dd.d(k0, v10, 8);
                p0.l0(d3);
            }
            H0.e.i(q10, s8, s9, d3, p0, 0);
            p0.p(true);
            p0.p(true);
            q q11 = d.f(a.n(n0, 0.0f, 21.0f, 0.0f, 7.0f, 5), 1.0f);
            p0 p02 = M.n0.a(b0, h4, p0, 54);
            int v6 = p0.P;
            i0 i03 = p0.m();
            q q12 = r0.a.d(p0, q11);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p02, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q12, h3);
            q q13 = q0.a(n0, 1.0f);
            p0 p03 = M.n0.a(b0, h4, p0, 0x30);
            int v7 = p0.P;
            i0 i04 = p0.m();
            q q14 = r0.a.d(p0, q13);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p03, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q14, h3);
            q q15 = a.n(n0, 0.0f, 0.0f, 4.0f, 0.0f, 11);
            String s10 = H0.e.Y(p0, 0x7F130C92);  // string:text_dj "DJ"
            ((K1)this.getViewModel()).getClass();
            N1.b(s10, q15, e0.T(p0, h2.d(v10.D)), 20.0f, e1.y.i, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FDD0);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, false);
            N1.b((v10.l == null ? "" : v10.l), layoutWeightElement0, e0.T(p0, 0x7F06016D), 20.0f, e1.y.i, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D5D0);  // color:gray900s
            if(v10.m) {
                p0.a0(0x589F0A6D);
                n1 = n0;
                q q16 = d.n(a.n(n0, 6.0f, 0.0f, 0.0f, 0.0f, 14), 14.0f);
                i2 = i1;
                g1 = g0;
                h5 = h1;
                b1 = b0;
                h6 = h4;
                androidx.compose.foundation.q.c(I.Q(0x7F08041C, p0, 6), null, q16, i0, null, 0.0f, null, p0, 0xDB0, 0x70);  // drawable:ic_common_verify_14
            }
            else {
                i2 = i1;
                g1 = g0;
                h5 = h1;
                b1 = b0;
                n1 = n0;
                h6 = h4;
                p0.a0(0x57ED2D1E);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            q q17 = d.f(a.n(n1, 0.0f, 3.0f, 0.0f, 0.0f, 13), 1.0f);
            long v8 = e0.T(p0, 0x7F060443);  // color:orange500s
            N1.b(v10.E, q17, v8, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            b0 b00 = p0.N();
            if(b00 == v5) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            q q18 = r0.a.a(d.f(a.n(n1, 0.0f, 3.0f, 0.0f, 0.0f, 13), 1.0f), new r(this, v10, b00, 7));
            y y1 = w.a(d0, g1, p0, 0);
            int v9 = p0.P;
            i0 i05 = p0.m();
            q q19 = r0.a.d(p0, q18);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i05, h5);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            androidx.compose.runtime.w.x(p0, q19, h3);
            String s11 = v10.n;
            if(s11 != null) {
                s1 = s11;
            }
            long v10_1 = e0.T(p0, 0x7F060165);  // color:gray800s
            R0 r00 = p0.N();
            if(r00 == v5) {
                r00 = new R0(b00, 10);
                p0.l0(r00);
            }
            N1.b(s1, null, v10_1, 14.0f, null, null, 0L, null, 17.0f, 2, false, (z1 ? 2 : 0x7FFFFFFF), 0, r00, null, p0, 0xC00, 0x30036, 87026);
            if(((Boolean)b00.getValue()).booleanValue() || !z1) {
                p0.a0(0x1B6F7B5);
                q q20 = d.f(a.n(n1, 0.0f, 6.0f, 0.0f, 0.0f, 13), 1.0f);
                N1.b(H0.e.Y(p0, (z1 ? 0x7F130CA2 : 0x7F13043E)), q20, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // string:text_more "더보기"
            }
            else {
                p0.a0(0xE7E1D5);
            }
            p0.p(false);
            p0.p(true);
            q q21 = d.f(a.n(n1, 0.0f, 20.0f, 0.0f, 0.0f, 13), 1.0f);
            p0 p04 = M.n0.a(b1, h6, p0, 0x30);
            int v11 = p0.P;
            i0 i06 = p0.m();
            q q22 = r0.a.d(p0, q21);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p04, h0);
            androidx.compose.runtime.w.x(p0, i06, h5);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            androidx.compose.runtime.w.x(p0, q22, h3);
            M.c.d(p0, new LayoutWeightElement(1.0f, true));
            List list0 = v10.V;
            SnsInfoBase profileBaseRes$SnsInfoBase0 = null;
            if(list0 != null) {
                for(Object object0: list0) {
                    if(((SnsInfoBase)object0).isRepnt) {
                        profileBaseRes$SnsInfoBase0 = object0;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            if(profileBaseRes$SnsInfoBase0 == null) {
                p0.a0(879615049);
                p0.p(false);
                n2 = n1;
            }
            else {
                p0.a0(879615050);
                K1 k10 = (K1)this.getViewModel();
                String s12 = profileBaseRes$SnsInfoBase0.dtlInfoCode;
                kotlin.jvm.internal.q.f(s12, "dtlInfoCode");
                k10.getClass();
                int v12 = h2.g(s12);
                if(v12 == -1) {
                    n2 = n1;
                    p0.a0(-1266401837);
                }
                else {
                    p0.a0(0xB562C4AF);
                    n2 = n1;
                    q q23 = r0.a.a(d.n(a.n(n1, 0.0f, 0.0f, 28.0f, 0.0f, 11), 22.0f), new Dd.h(k0, v10, 9));
                    androidx.compose.foundation.q.c(I.Q(v12, p0, 0), null, q23, null, m0, 0.0f, null, p0, 0x6030, 104);
                }
                p0.p(false);
                p0.p(false);
            }
            q q24 = r0.a.a(d.n(n2, 22.0f), new Dd.h(k0, v10, 8));
            androidx.compose.foundation.q.c(I.Q(0x7F080175, p0, 6), null, q24, null, m0, 0.0f, null, p0, 0x6030, 104);  // drawable:btn_common_share_22
            p0.p(true);
            q q25 = d.h(d.f(a.n(n2, 0.0f, 20.0f, 0.0f, 0.0f, 13), 1.0f), 48.0f);
            M.g g2 = M.j.h(10.0f);
            r0.h h7 = r0.d.j;
            p0 p05 = M.n0.a(g2, h7, p0, 6);
            int v13 = p0.P;
            i0 i07 = p0.m();
            q q26 = r0.a.d(p0, q25);
            P0.k.y.getClass();
            i i3 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            P0.h h8 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p05, h8);
            P0.h h9 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i07, h9);
            P0.h h10 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v13)) {
                A7.d.q(v13, p0, v13, h10);
            }
            P0.h h11 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q26, h11);
            p0.a0(0x712ADEB9);
            q q27 = x.r(1.0f, d.c(d.f(n2, 1.0f), 1.0f), true);
            if(z) {
                p0.a0(2077139371);
                q28 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F060152), q27, e.b(4.0f));  // color:gray200a
                p0.p(false);
            }
            else {
                p0.a0(0x7BD365B0);
                p0.p(false);
                q28 = e0.I(q27, 0, 3);
            }
            p0.p(false);
            q q29 = r0.a.a(q28, new Dd.h(k0, v10, 10));
            M m1 = M.p.d(r0.d.a, false);
            int v14 = p0.P;
            i0 i08 = p0.m();
            q q30 = r0.a.d(p0, q29);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h8);
            androidx.compose.runtime.w.x(p0, i08, h9);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v14)) {
                A7.d.q(v14, p0, v14, h10);
            }
            androidx.compose.runtime.w.x(p0, q30, h11);
            q q31 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n2, i0);
            p0 p06 = M.n0.a(M.j.a, h7, p0, 0);
            int v15 = p0.P;
            i0 i09 = p0.m();
            q q32 = r0.a.d(p0, q31);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p06, h8);
            androidx.compose.runtime.w.x(p0, i09, h9);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v15)) {
                A7.d.q(v15, p0, v15, h10);
            }
            androidx.compose.runtime.w.x(p0, q32, h11);
            if(z) {
                v16 = 0x7F0803EC;  // drawable:ic_common_following
                v17 = 0x7F130C9A;  // string:text_following "팔로잉"
            }
            else {
                v16 = 0x7F0803D6;  // drawable:ic_common_add_01
                v17 = 0x7F130C97;  // string:text_follow "팔로우"
            }
            androidx.compose.foundation.q.c(I.Q(v16, p0, 0), null, null, null, m0, 0.0f, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 0x6030, 44);  // color:gray900s
            N1.b(l1.s(n2, 8.0f, p0, v17, p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new E(this, v10, k0, v, 25);
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            kotlin.jvm.internal.q.f(bundle0, "requireArguments(...)");
        }
        K1 k10 = (K1)this.getViewModel();
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        k10.getClass();
        k10.e = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        kotlin.jvm.internal.q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", ((K1)this.getViewModel()).e);
    }

    @Override  // Dd.L1
    public final void onUiEvent(I4 i40) {
        kotlin.jvm.internal.q.g(i40, "event");
        if(i40 instanceof D4) {
            this.sendUserEvent(new com.melon.ui.p(((D4)i40).a));
            return;
        }
        if(i40 instanceof E1) {
            this.startActivity(new Intent("android.intent.action.VIEW", ((E1)i40).a));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        String s = va.e.b("targetMemberKey : ", ((K1)this.getViewModel()).e);
        LogU.debug$default(this.j, s, null, false, 6, null);
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        o o0 = B.a.s(7);
        ((TitleBar)w00.c.c).a(o0);
        Ud.j j0 = (Ud.j)this.f.getValue();
        U u0 = new U(this, 13);
        Ud.j.a(j0, ((TitleBar)w00.c.c), u0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        kotlin.jvm.internal.q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        m0.b b0 = new m0.b(-1982303314, new E(k40, this, w00, 23), true);
        w00.b.setContent(b0);
    }
}

