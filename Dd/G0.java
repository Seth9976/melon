package Dd;

import Ac.A2;
import Ac.B1;
import Ac.E;
import Ac.O3;
import Ac.Q1;
import Ac.R0;
import Ac.U2;
import Ac.X;
import Ac.r;
import Ac.v2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cd.Q;
import De.I;
import E9.h;
import J8.W0;
import M.c;
import M.j0;
import M.p0;
import M.q0;
import M.r0;
import M.w;
import M.y;
import N0.M;
import N0.j;
import N0.m;
import O.F;
import T.e;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.MYPROFILE.FANLOUNGEINFO;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import e1.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import r0.g;
import r0.i;
import r0.n;
import r0.q;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b²\u0006\u000E\u0010\u0007\u001A\u00020\u00068\n@\nX\u008A\u008E\u0002"}, d2 = {"LDd/g0;", "LDd/L1;", "LDd/g1;", "", "<init>", "()V", "", "hasVisualOverflow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class g0 extends b {
    public final O3 j;
    public final LogU k;

    public g0() {
        this.j = new O3();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("MemberProfileFragment");
        logU0.setCategory(Category.UI);
        this.k = logU0;
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return g1.class;
    }

    public final void n(F f0, List list0, l l0, int v) {
        ((p)l0).c0(0xDA2D20BC);
        int v1 = v | (((p)l0).g(f0) ? 4 : 2) | (((p)l0).i(list0) ? 0x20 : 16) | (((p)l0).i(this) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            FillElement fillElement0 = d.c;
            j0 j00 = a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).i(this);
            J j0 = ((p)l0).N();
            if(z || z1 || j0 == k.a) {
                j0 = new J(2, list0, this);
                ((p)l0).l0(j0);
            }
            c1.o(fillElement0, f0, j00, false, null, null, null, false, j0, ((p)l0), v1 << 3 & 0x70 | 6, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E(this, f0, list0, v, 22);
        }
    }

    public final void o(V1 v10, Activity activity0, we.k k0, l l0, int v) {
        androidx.compose.foundation.layout.b b4;
        int v22;
        int v21;
        q q43;
        i i13;
        boolean z8;
        n n6;
        SnsInfoBase profileBaseRes$SnsInfoBase0;
        r0 r03;
        n n5;
        M.b b2;
        n n3;
        boolean z6;
        r0.h h9;
        n n2;
        M.d d4;
        i i7;
        V v9;
        r0.h h7;
        g g1;
        r0 r01;
        M.b b1;
        n n1;
        i i0 = r0.d.a;
        r0.h h0 = r0.d.j;
        i i1 = r0.d.e;
        m m0 = j.g;
        kotlin.jvm.internal.q.g(v10, "headerUiState");
        boolean z = v10.c;
        boolean z1 = v10.a;
        FANLOUNGEINFO myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0 = v10.I;
        kotlin.jvm.internal.q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(-832087526);
        int v1 = v | (p0.i(v10) ? 4 : 2) | (p0.i(activity0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(this) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            boolean z2 = v10.d;
            q q0 = d.t(d.g(a.l(n.a, 20.0f, 0.0f, 2)), 3);
            M.d d0 = M.j.c;
            n n0 = n.a;
            g g0 = r0.d.m;
            y y0 = w.a(d0, g0, p0, 0);
            int v2 = androidx.compose.runtime.w.j(p0);
            i0 i00 = p0.y();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i2 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.c());
            androidx.compose.runtime.w.x(p0, i00, P0.j.e());
            P0.h h1 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d());
            q q2 = d.g(n0);
            r0.h h2 = r0.d.k;
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, h2, p0, 0x30);
            int v3 = androidx.compose.runtime.w.j(p0);
            i0 i01 = p0.y();
            q q3 = r0.a.d(p0, q2);
            P0.i i3 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            P0.h h3 = A7.d.h(p0, p00, p0, i01);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d());
            String s = Cb.i.h(v10.f);
            q q4 = d.n(a.n(n0, 0.0f, 0.0f, 16.0f, 0.0f, 11), ((float)(z2 ? 0x60 : 0x40)));
            q q5 = r0.a.a(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q4, e.e()), new f(s, k0, v10, 1));  // color:gray100a
            Cc.r0.b.e(q5, s, ((float)(z2 ? 0x60 : 0x40)), null, 0L, false, false, p0, 0xC00000, 120);
            q q6 = d.g(n0);
            p0 p01 = M.n0.a(b0, h2, p0, 0x30);
            int v4 = androidx.compose.runtime.w.j(p0);
            i0 i02 = p0.y();
            q q7 = r0.a.d(p0, q6);
            P0.i i4 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            P0.h h4 = A7.d.h(p0, p01, p0, i02);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, P0.j.d());
            q q8 = q0.a(n0, 1.0f);
            String s1 = Cb.i.h(v10.h);
            String s2 = H0.e.Y(p0, 0x7F130C98);  // string:text_follower "팔로워"
            boolean z3 = p0.i(v10);
            Dd.d d1 = p0.N();
            V v5 = k.a;
            if((v1 & 0x380) == 0x100 || z3 || d1 == v5) {
                d1 = new Dd.d(k0, v10, 3);
                p0.l0(d1);
            }
            H0.e.i(q8, s1, s2, d1, p0, 0);
            q q9 = q0.a(n0, 1.0f);
            String s3 = Cb.i.h(v10.i);
            String s4 = H0.e.Y(p0, 0x7F130C9A);  // string:text_following "팔로잉"
            boolean z4 = p0.i(v10);
            Dd.d d2 = p0.N();
            if((v1 & 0x380) == 0x100 || z4 || d2 == v5) {
                d2 = new Dd.d(k0, v10, 4);
                p0.l0(d2);
            }
            H0.e.i(q9, s3, s4, d2, p0, 0);
            q q10 = q0.a(n0, 1.0f);
            String s5 = Cb.i.h(v10.k);
            String s6 = H0.e.Y(p0, 0x7F130CAE);  // string:text_playlist "플레이리스트"
            boolean z5 = p0.i(v10);
            Dd.d d3 = p0.N();
            if((v1 & 0x380) == 0x100 || z5 || d3 == v5) {
                d3 = new Dd.d(k0, v10, 5);
                p0.l0(d3);
            }
            H0.e.i(q10, s5, s6, d3, p0, 0);
            p0.r();
            p0.r();
            q q11 = d.g(a.n(n0, 0.0f, 21.0f, 0.0f, 7.0f, 5));
            p0 p02 = M.n0.a(b0, h2, p0, 54);
            int v6 = androidx.compose.runtime.w.j(p0);
            i0 i03 = p0.y();
            q q12 = r0.a.d(p0, q11);
            P0.i i5 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i5);
            }
            else {
                p0.o0();
            }
            P0.h h5 = A7.d.h(p0, p02, p0, i03);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h5);
            }
            androidx.compose.runtime.w.x(p0, q12, P0.j.d());
            q q13 = q0.a(n0, 1.0f);
            p0 p03 = M.n0.a(b0, h2, p0, 0x30);
            int v7 = androidx.compose.runtime.w.j(p0);
            i0 i04 = p0.y();
            q q14 = r0.a.d(p0, q13);
            P0.i i6 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i6);
            }
            else {
                p0.o0();
            }
            P0.h h6 = A7.d.h(p0, p03, p0, i04);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h6);
            }
            androidx.compose.runtime.w.x(p0, q14, P0.j.d());
            if(z2) {
                p0.a0(0x83EF0538);
                q q15 = a.n(n0, 0.0f, 0.0f, 4.0f, 0.0f, 11);
                String s7 = H0.e.Y(p0, 0x7F130C92);  // string:text_dj "DJ"
                ((g1)this.getViewModel()).getClass();
                N1.b(s7, q15, e0.T(p0, h2.d(v10.D)), 20.0f, x.F(), null, 0L, l1.k.a(3), 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FDD0);
            }
            else {
                p0.a0(-2096508269);
            }
            p0.s();
            r0 r00 = r0.a;
            q q16 = r00.c(1.0f, n0, false);
            long v8 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k1 = l1.k.a(3);
            N1.b(Cb.i.h(v10.l), q16, v8, 20.0f, x.F(), null, 0L, k1, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D5D0);
            if(v10.m) {
                p0.a0(0x83FFA6A2);
                n1 = n0;
                q q17 = d.n(a.n(n1, 6.0f, 0.0f, 0.0f, 0.0f, 14), 14.0f);
                b1 = b0;
                r01 = r00;
                g1 = g0;
                h7 = h2;
                v9 = v5;
                i7 = i1;
                d4 = d0;
                androidx.compose.foundation.q.c(I.Q(0x7F08041C, p0, 6), null, q17, i7, null, 0.0f, null, p0, 0xDB0, 0x70);  // drawable:ic_common_verify_14
            }
            else {
                r01 = r00;
                b1 = b0;
                v9 = v5;
                n1 = n0;
                g1 = g0;
                h7 = h2;
                i7 = i1;
                d4 = d0;
                p0.a0(-2096508269);
            }
            p0.s();
            if(z1) {
                p0.a0(-2079904886);
                q q18 = r0.a.a(d.n(a.n(n1, 4.0f, 0.0f, 0.0f, 0.0f, 14), 24.0f), new Dd.h(k0, v10, 4));
                androidx.compose.foundation.q.c(I.Q(0x7F080193, p0, 6), null, q18, i7, m0, 0.0f, null, p0, 0x6C30, 0x60);  // drawable:btn_edit_24
            }
            else {
                p0.a0(-2096508269);
            }
            p0.s();
            p0.r();
            if(v10.r) {
                p0.a0(0x401E094D);
                n2 = n1;
                q q19 = d.h(d.q(a.n(n1, 4.0f, 0.0f, 0.0f, 0.0f, 14), 93.0f), 28.0f);
                q q20 = r0.a.a(d.v(d.t(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F060152), q19, e.b(4.0f)), 2), r0.d.n, 2), new Dd.h(k0, v10, 3));  // color:gray200a
                N1.b(H0.e.Y(p0, 0x7F130C8E), q20, e0.T(p0, 0x7F060165), 12.0f, null, null, 0L, l1.k.a(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:text_artist_channel "아티스트 채널"
            }
            else {
                n2 = n1;
                p0.a0(0x3F122457);
            }
            p0.s();
            p0.r();
            if(!((g1)this.getViewModel()).i || v10.E.length() <= 0) {
                p0.a0(0xE06ACD8A);
                c.d(p0, d.h(n2, 5.0f));
            }
            else {
                p0.a0(0xE0645060);
                q q21 = d.g(a.n(n2, 0.0f, 3.0f, 0.0f, 0.0f, 13));
                long v10_1 = e0.T(p0, 0x7F060443);  // color:orange500s
                N1.b(v10.E, q21, v10_1, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            }
            p0.s();
            b0 b00 = p0.N();
            if(b00 == v9) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            q q22 = r0.a.a(d.g(a.n(n2, 0.0f, 3.0f, 0.0f, 0.0f, 13)), new r(this, v10, b00, 5));
            y y1 = w.a(d4, g1, p0, 0);
            int v11 = androidx.compose.runtime.w.j(p0);
            i0 i05 = p0.y();
            q q23 = r0.a.d(p0, q22);
            P0.i i8 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i8);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, P0.j.c());
            androidx.compose.runtime.w.x(p0, i05, P0.j.e());
            P0.h h8 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h8);
            }
            androidx.compose.runtime.w.x(p0, q23, P0.j.d());
            String s8 = Cb.i.h(v10.n);
            long v12 = e0.T(p0, 0x7F060165);  // color:gray800s
            int v13 = v10.c() ? 2 : 0x7FFFFFFF;
            R0 r02 = p0.N();
            if(r02 == v9) {
                r02 = new R0(b00, 9);
                p0.l0(r02);
            }
            N1.b(s8, null, v12, 14.0f, null, null, 0L, null, 17.0f, 2, false, v13, 0, r02, null, p0, 0xC00, 0x30036, 87026);
            if(((Boolean)b00.getValue()).booleanValue() || !v10.o) {
                p0.a0(-30142148);
                q q24 = d.g(a.n(n2, 0.0f, 6.0f, 0.0f, 0.0f, 13));
                N1.b(H0.e.Y(p0, (v10.c() ? 0x7F130CA2 : 0x7F13043E)), q24, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // string:text_more "더보기"
            }
            else {
                p0.a0(-50808484);
            }
            p0.s();
            p0.r();
            if(Cb.i.l(myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0)) {
                p0.a0(0xE08847FB);
                q q25 = d.h(a.n(n2, 0.0f, 10.0f, 0.0f, 10.0f, 5), 26.0f);
                q q26 = r0.a.a(androidx.compose.foundation.q.i(1.0f, e0.T(p0, 0x7F06017C), q25, e.b(100.0f)), new X(v10, 2));  // color:green500s_support_high_contrast
                h9 = h7;
                p0 p04 = M.n0.a(b1, h9, p0, 0x30);
                int v14 = androidx.compose.runtime.w.j(p0);
                i0 i06 = p0.y();
                q q27 = r0.a.d(p0, q26);
                z6 = true;
                P0.i i9 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i9);
                }
                else {
                    p0.o0();
                }
                P0.h h10 = A7.d.h(p0, p04, p0, i06);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v14)) {
                    A7.d.q(v14, p0, v14, h10);
                }
                androidx.compose.runtime.w.x(p0, q27, P0.j.d());
                q q28 = d.s(a.n(n2, 12.0f, 0.0f, 5.0f, 0.0f, 10), 0.0f, 100.0f, 1);
                N1.b(Cb.i.h((myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0.artistName)), q28, e0.T(p0, 0x7F06017C), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500s_support_high_contrast
                q q29 = d.v(n2, null, 3);
                N1.b(Cb.i.h((myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0.fanclubName)), q29, e0.T(p0, 0x7F06017C), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500s_support_high_contrast
                q q30 = a.n(n2, 0.0f, 0.0f, 9.0f, 0.0f, 11);
                n3 = n2;
                b2 = b1;
                androidx.compose.foundation.q.c(I.Q(0x7F08008A, p0, 6), null, q30, null, m0, 0.0f, null, p0, 25008, 104);  // drawable:arrow_common_datail_g
                p0.r();
            }
            else {
                z6 = false;
                n3 = n2;
                h9 = h7;
                b2 = b1;
                p0.a0(0xDF42AA12);
            }
            p0.s();
            n n4 = n3;
            q q31 = d.g(a.n(n3, 0.0f, (z6 ? 10.0f : 20.0f), 0.0f, 0.0f, 13));
            p0 p05 = M.n0.a(b2, h9, p0, 0x30);
            int v15 = androidx.compose.runtime.w.j(p0);
            i0 i07 = p0.y();
            q q32 = r0.a.d(p0, q31);
            P0.i i10 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i10);
            }
            else {
                p0.o0();
            }
            P0.h h11 = A7.d.h(p0, p05, p0, i07);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v15)) {
                A7.d.q(v15, p0, v15, h11);
            }
            androidx.compose.runtime.w.x(p0, q32, P0.j.d());
            if(v10.N) {
                p0.a0(0x4E7A7B55);
                q q33 = r0.a.a(n4, new Ac.l(5, k0, this));
                p0 p06 = M.n0.a(b2, h9, p0, 0x30);
                int v16 = androidx.compose.runtime.w.j(p0);
                i0 i08 = p0.y();
                q q34 = r0.a.d(p0, q33);
                P0.i i11 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i11);
                }
                else {
                    p0.o0();
                }
                P0.h h12 = A7.d.h(p0, p06, p0, i08);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v16)) {
                    A7.d.q(v16, p0, v16, h12);
                }
                androidx.compose.runtime.w.x(p0, q34, P0.j.d());
                q q35 = d.n(a.n(n4, 0.0f, 0.0f, 2.0f, 0.0f, 11), 22.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F08012B, p0, 6), null, q35, null, m0, 0.0f, null, p0, 25008, 104);  // drawable:btn_common_comment_22
                if(v10.S) {
                    p0.a0(1798035811);
                    n5 = n4;
                    q q36 = d.n(a.n(n4, 0.0f, 0.0f, 2.0f, 0.0f, 11), 24.0f);
                    androidx.compose.foundation.q.c(I.Q(0x7F0803F3, p0, 6), null, q36, null, m0, 0.0f, null, p0, 25008, 104);  // drawable:ic_common_hot_24
                }
                else {
                    n5 = n4;
                    p0.a0(0x69AC4297);
                }
                p0.s();
                N1.b(StringUtils.getCountString(v10.M, 0x98967F), null, e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray800s
                if(v10.T) {
                    p0.a0(0x6B38A07E);
                    q q37 = r01.b(h0, d.n(a.n(n5, 0.0f, 0.0f, 2.0f, 0.0f, 11), 4.0f));
                    androidx.compose.foundation.q.c(L5.c.a(d5.w.B(((Context)p0.k(AndroidCompositionLocals_androidKt.c())), 0x7F080403), p0), null, q37, null, m0, 0.0f, null, p0, 0x6030, 104);  // drawable:ic_common_new_4
                    p0.s();
                    n4 = n5;
                    r03 = r01;
                }
                else {
                    n4 = n5;
                    r03 = r01;
                    p0.a0(0x69AC4297);
                    p0.s();
                }
                p0.r();
            }
            else {
                r03 = r01;
                p0.a0(0x4D0FE196);
            }
            p0.s();
            c.d(p0, r03.c(1.0f, n4, true));
            boolean z7 = v10.e && !v10.G;
            List list0 = v10.V;
            if(list0 == null) {
                profileBaseRes$SnsInfoBase0 = null;
            }
            else {
                Object object0 = null;
                for(Object object1: list0) {
                    if(((SnsInfoBase)object1).isRepnt) {
                        object0 = object1;
                        break;
                    }
                }
                profileBaseRes$SnsInfoBase0 = (SnsInfoBase)object0;
            }
            if(profileBaseRes$SnsInfoBase0 == null) {
                p0.a0(0x4EAAE8C9);
                p0.s();
                n6 = n4;
                z8 = true;
            }
            else {
                p0.a0(0x4EAAE8CA);
                g1 g10 = (g1)this.getViewModel();
                String s9 = profileBaseRes$SnsInfoBase0.dtlInfoCode;
                kotlin.jvm.internal.q.f(s9, "dtlInfoCode");
                g10.getClass();
                int v17 = h2.g(s9);
                if(!z7 || v17 == -1) {
                    n6 = n4;
                    z8 = true;
                    p0.a0(0x8D4B0CFE);
                }
                else {
                    p0.a0(0x8EE8108C);
                    q q38 = r0.a.a(d.n(a.n(n4, 0.0f, 0.0f, 28.0f, 0.0f, 11), 22.0f), new Dd.h(k0, v10, 6));
                    n6 = n4;
                    z8 = true;
                    androidx.compose.foundation.q.c(I.Q(v17, p0, 0), null, q38, null, m0, 0.0f, null, p0, 0x6030, 104);
                }
                p0.s();
                p0.s();
            }
            q q39 = r0.a.a(d.n(n6, 22.0f), new Dd.h(k0, v10, 5));
            androidx.compose.foundation.q.c(I.Q(0x7F080175, p0, 6), null, q39, null, m0, 0.0f, null, p0, 0x6030, 104);  // drawable:btn_common_share_22
            p0.r();
            q q40 = d.h(d.g(a.n(n6, 0.0f, 20.0f, 0.0f, 0.0f, 13)), 48.0f);
            p0 p07 = M.n0.a(M.j.h(10.0f), h0, p0, 6);
            int v18 = androidx.compose.runtime.w.j(p0);
            i0 i09 = p0.y();
            q q41 = r0.a.d(p0, q40);
            P0.k.y.getClass();
            P0.i i12 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i12);
            }
            else {
                p0.o0();
            }
            P0.h h13 = A7.d.h(p0, p07, p0, i09);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v18)) {
                A7.d.q(v18, p0, v18, h13);
            }
            androidx.compose.runtime.w.x(p0, q41, P0.j.d());
            boolean z9 = z1 && Cb.i.l(v10.B);
            androidx.compose.foundation.layout.b b3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            if(!z1 || z9) {
                p0.a0(0x5D014E27);
                p0.a0(0xEA39E860);
                q q42 = q0.a(d.d(d.g(n6)), 1.0f);
                if(v10.b()) {
                    p0.a0(-954809773);
                    i13 = i7;
                    q43 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F060152), q42, e.b(4.0f));  // color:gray200a
                    p0.s();
                }
                else {
                    i13 = i7;
                    p0.a0(0xC71B8658);
                    p0.s();
                    q43 = e0.I(q42, 0, 3);
                }
                p0.s();
                q q44 = r0.a.a(q43, new Dd.h(k0, v10, 7));
                M m1 = M.p.d(i0, false);
                int v19 = androidx.compose.runtime.w.j(p0);
                i0 i010 = p0.y();
                q q45 = r0.a.d(p0, q44);
                P0.i i14 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i14);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m1, P0.j.c());
                androidx.compose.runtime.w.x(p0, i010, P0.j.e());
                P0.h h14 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v19)) {
                    A7.d.q(v19, p0, v19, h14);
                }
                androidx.compose.runtime.w.x(p0, q45, P0.j.d());
                i7 = i13;
                q q46 = b3.a(n6, i7);
                p0 p08 = M.n0.a(M.j.a, h0, p0, 0);
                int v20 = androidx.compose.runtime.w.j(p0);
                i0 i011 = p0.y();
                q q47 = r0.a.d(p0, q46);
                P0.i i15 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i15);
                }
                else {
                    p0.o0();
                }
                P0.h h15 = A7.d.h(p0, p08, p0, i011);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v20)) {
                    A7.d.q(v20, p0, v20, h15);
                }
                androidx.compose.runtime.w.x(p0, q47, P0.j.d());
                if(z9) {
                    v21 = 0x7F08040A;  // drawable:ic_common_report
                    v22 = 0x7F130CB2;  // string:text_report "리포트"
                }
                else if(v10.b()) {
                    v21 = 0x7F0803EC;  // drawable:ic_common_following
                    v22 = 0x7F130C9A;  // string:text_following "팔로잉"
                }
                else {
                    v21 = 0x7F0803D6;  // drawable:ic_common_add_01
                    v22 = 0x7F130C97;  // string:text_follow "팔로우"
                }
                b4 = b3;
                androidx.compose.foundation.q.c(I.Q(v21, p0, 0), null, null, null, m0, 0.0f, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 0x6030, 44);  // color:gray900s
                N1.b(l1.s(n6, 8.0f, p0, v22, p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
                p0.r();
                p0.r();
                p0.s();
            }
            else {
                p0.a0(0x5B481BD5);
                p0.s();
                b4 = b3;
            }
            if(z1 || z) {
                z8 = false;
            }
            if(z1 || !z8) {
                p0.a0(1563170860);
                q q48 = r0.a.a(e0.I(q0.a(d.d(d.g(n6)), 1.0f), 0, 3), new r(6, v10, activity0, k0));
                M m2 = M.p.d(i0, false);
                int v23 = androidx.compose.runtime.w.j(p0);
                i0 i012 = p0.y();
                q q49 = r0.a.d(p0, q48);
                P0.i i16 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i16);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m2, P0.j.c());
                androidx.compose.runtime.w.x(p0, i012, P0.j.e());
                P0.h h16 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v23)) {
                    A7.d.q(v23, p0, v23, h16);
                }
                androidx.compose.runtime.w.x(p0, q49, P0.j.d());
                q q50 = b4.a(n6, i7);
                p0 p09 = M.n0.a(M.j.a, h0, p0, 0);
                int v24 = androidx.compose.runtime.w.j(p0);
                i0 i013 = p0.y();
                q q51 = r0.a.d(p0, q50);
                P0.i i17 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i17);
                }
                else {
                    p0.o0();
                }
                P0.h h17 = A7.d.h(p0, p09, p0, i013);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v24)) {
                    A7.d.q(v24, p0, v24, h17);
                }
                androidx.compose.runtime.w.x(p0, q51, P0.j.d());
                androidx.compose.foundation.q.c(I.Q(0x7F0803FD, p0, 6), null, null, null, m0, 0.0f, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 0x6030, 44);  // drawable:ic_common_message
                N1.b(l1.s(n6, 8.0f, p0, (!z1 || z ? 0x7F130CA0 : 0x7F130CA1), p0), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:text_message "메시지"
                p0.r();
                p0.r();
            }
            else {
                p0.a0(0x5B481BD5);
            }
            p0.s();
            p0.r();
            p0.r();
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.f(new U2(this, v10, activity0, k0, v, 6));
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            kotlin.jvm.internal.q.f(bundle0, "requireArguments(...)");
        }
        g1 g10 = (g1)this.getViewModel();
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        g10.getClass();
        g10.e = s;
        g1 g11 = (g1)this.getViewModel();
        g11.f = bundle0.getBoolean("argIsMySelf");
        g1 g12 = (g1)this.getViewModel();
        g12.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(g12), null, null, new f1(g12, null), 3, null);
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        kotlin.jvm.internal.q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", ((g1)this.getViewModel()).e);
        bundle0.putBoolean("argIsMySelf", ((g1)this.getViewModel()).f);
    }

    @Override  // Dd.L1
    public final void onUiEvent(I4 i40) {
        kotlin.jvm.internal.q.g(i40, "event");
        if(i40 instanceof X1) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(zd.x.x);
            arrayList0.add(zd.x.y);
            if(((X1)i40).b) {
                arrayList0.add(zd.x.z);
            }
            l0 l00 = this.getChildFragmentManager();
            A2 a20 = new A2(this, 13);
            com.melon.ui.popup.b.u(l00, ((X1)i40).a, arrayList0, a20);
            return;
        }
        if(i40 instanceof Y1) {
            l0 l01 = this.getChildFragmentManager();
            J j0 = new J(1, this, i40);
            com.melon.ui.popup.b.o(l01, ((Y1)i40).a, j0, 12);
            return;
        }
        if(i40 instanceof B1) {
            if(((B1)i40) instanceof Q1) {
                String s = ((Q1)i40).a.getContentRefValue();
                kotlin.jvm.internal.q.g(s, "contentRefValue");
                v2 v20 = new v2();
                v20.setArguments(d5.f.j(new ie.m[]{new ie.m("key_cmt_seq", ((Q1)i40).b.getCommentSeq()), new ie.m("key_channel_seq", ((Q1)i40).a.getChannelSeq()), new ie.m("key_content_ref_value", s), new ie.m("key_cmt_config", ((Q1)i40).a)}));
                v20.m(this.getParentFragment());
                return;
            }
            l0 l02 = this.getChildFragmentManager();
            Q q0 = new Q(1, this, g0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
            kotlin.jvm.internal.q.g(((B1)i40), "uiEvent");
            this.j.b(l02, ((B1)i40), q0, null);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        String s = va.e.b("targetMemberKey : ", ((g1)this.getViewModel()).e);
        LogU.debug$default(this.k, s, null, false, 6, null);
        String s1 = o.p("isMyself : ", ((g1)this.getViewModel()).f);
        LogU.debug$default(this.k, s1, null, false, 6, null);
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            TitleBar titleBar0 = (TitleBar)w00.c.c;
            F8.I i0 = new F8.I(1);
            i0.c = new W(this, 0);
            boolean z = ((g1)this.getViewModel()).f;
            ie.r r0 = this.f;
            if(z) {
                F8.x x0 = new F8.x(3);
                x0.c = new W(this, 1);
                i0.j = 16.0f;
                F8.o o0 = B.a.s(7);
                o0.g(x0);
                o0.g(i0);
                titleBar0.a(o0);
                Ud.j.a(((Ud.j)r0.getValue()), titleBar0, new Dd.X(this, 0));
            }
            else {
                F8.o o1 = B.a.s(7);
                o1.g(i0);
                titleBar0.a(o1);
                Ud.j.a(((Ud.j)r0.getValue()), titleBar0, new Dd.X(this, 1));
            }
            D d0 = this.getViewLifecycleOwner();
            kotlin.jvm.internal.q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new Dd.b0(this, null), 3, null);
            D d1 = this.getViewLifecycleOwner();
            kotlin.jvm.internal.q.f(d1, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new Dd.e0(this, null), 3, null);
            if(((g1)this.getViewModel()).j) {
                g1 g10 = (g1)this.getViewModel();
                g10.getClass();
                BuildersKt__Builders_commonKt.launch$default(f0.h(g10), Dispatchers.getIO(), null, new Dd.c1(g10, null), 2, null);
            }
        }
    }

    public final void p(K4 k40, we.k k0, l l0, int v) {
        kotlin.jvm.internal.q.g(k40, "uiState");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        ((p)l0).c0(0x6B879000);
        int v1 = (((p)l0).g(k40) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16) | (((p)l0).i(this) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            this.j.a(k40, k0, ((p)l0), v1 & 0x7E);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new E(this, k40, k0, v, 20);
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        kotlin.jvm.internal.q.g(k40, "uiState");
        LogU.debug$default(this.k, "renderUi : " + k40, null, false, 6, null);
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        m0.b b0 = new m0.b(0x900007C2, new E(k40, this, w00, 21), true);
        w00.b.setContent(b0);
    }
}

