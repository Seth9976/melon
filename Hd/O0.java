package hd;

import C0.c;
import Cc.N1;
import Cc.U;
import Cc.Y1;
import Cc.c1;
import Cc.e0;
import Cc.w3;
import De.I;
import M.j;
import M.p0;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import T.e;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import cd.V2;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistMvInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRecentAlbumInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistTopSong3Info;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.KeywordInfo.Contents.Keyword;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.MonthlyInfo.GraphInfo.GraphDetailInfo;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.SongInfoBase;
import ed.D;
import gd.K6;
import gd.M6;
import gd.T7;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import r0.g;
import r0.n;
import wc.u;
import we.k;

public abstract class o0 {
    public static final void a(A1 a10, k k0, l l0, int v) {
        k0 k00;
        n0 n00;
        q.g(a10, "uiState");
        ArtistMvInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 = a10.j;
        ArtistRcmTrackInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 = a10.i;
        ArtistRecentAlbumInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 = a10.h;
        ArtistTopSong3Info musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 = a10.g;
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(0x9D135372);
        int v1 = (p0.i(a10) ? 4 : 2) | v | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            o0.c(a10.b, a10.c, 51.0f, p0, 0x180);
            n n0 = n.a;
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 != null || musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 != null || musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 != null || musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 != null) {
                p0.a0(0xB66BCD0);
                p0.p(false);
                r0.q q2 = a.n(androidx.compose.foundation.q.u(d.u(a.n(n0, 0.0f, 15.0f, 0.0f, 0.0f, 13), 3), androidx.compose.foundation.q.t(p0), true, false), 20.0f, 0.0f, 20.0f, 0.0f, 10);
                p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                P0.k.y.getClass();
                i i1 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p00, P0.j.f);
                w.x(p0, i01, P0.j.e);
                h h1 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h1);
                }
                w.x(p0, q3, P0.j.d);
                int v4 = v1 << 6 & 0x1C00;
                f0.b(d.o(n0, 300.0f, 375.0f), a10, false, k0, p0, v1 << 3 & 0x70 | 390 | v4);
                if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                    p0.a0(0x424D0BEC);
                }
                else {
                    p0.a0(0x42F88123);
                    List list0 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.songList == null ? null : je.p.K0(3, musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.songList);
                    int v5 = list0 == null ? 0 : list0.size();
                    if(v5 == 3) {
                        p0.a0(1125034407);
                        f0.d(a10, new b(0x533E065A, new U(3, a10, k0), true), k0, p0, v1 & 14 | v1 << 3 & 0x380);
                    }
                    else {
                        p0.a0(1125206023);
                        f0.a(a10, 0, new b(0x533E065A, new U(v5, a10, k0), true), k0, p0, v1 & 14 | 0x30 | v4);
                    }
                    p0.p(false);
                }
                p0.p(false);
                if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 == null) {
                    p0.a0(0x424D0BEC);
                }
                else {
                    p0.a0(0x43164B61);
                    f0.a(a10, 1, new b(0x89708E11, new k0(2, a10, k0), true), k0, p0, v1 & 14 | 0x30 | v4);
                }
                p0.p(false);
                if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 == null) {
                    p0.a0(0x424D0BEC);
                }
                else {
                    p0.a0(1127061993);
                    f0.a(a10, 2, new b(0x54B48ED2, new k0(k0, a10), true), k0, p0, v1 & 14 | 0x30 | v4);
                }
                p0.p(false);
                if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 == null) {
                    p0.a0(0x424D0BEC);
                }
                else {
                    p0.a0(0x4339D011);
                    f0.c(a10, new b(0x1FF88F93, new k0(3, a10, k0), true), k0, p0, v1 & 14 | v1 << 3 & 0x380);
                }
                p0.p(false);
                p0.p(true);
                goto label_97;
            }
            else {
                p0.a0(0xC03E2F1);
                r0.q q0 = a.n(n0, 20.0f, 15.0f, 20.0f, 0.0f, 8);
                M m0 = M.p.d(r0.d.a, false);
                int v2 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, P0.j.f);
                w.x(p0, i00, P0.j.e);
                h h0 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                w.x(p0, q1, P0.j.d);
                f0.b(d.h(d.f(n0, 1.0f), 400.0f), a10, true, k0, p0, v1 << 6 & 0x1C00 | (v1 << 3 & 0x70 | 390));
                p0.p(true);
                p0.p(false);
                n00 = p0.t();
                if(n00 != null) {
                    k00 = new k0(a10, k0, v, 0);
                    n00.d = k00;
                }
            }
        }
        else {
            p0.T();
        label_97:
            n00 = p0.t();
            if(n00 != null) {
                k00 = new k0(a10, k0, v, 1);
                n00.d = k00;
            }
        }
    }

    public static final void b(C1 c10, k k0, l l0, int v) {
        V v13;
        h h5;
        i i2;
        n n1;
        h h4;
        q.g(c10, "uiState");
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(-1977069028);
        int v1 = v | (p0.i(c10) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            o0.c(c10.b, c10.c, 51.0f, p0, 0x180);
            r0.q q0 = a.n(n.a, 20.0f, 15.0f, 20.0f, 0.0f, 8);
            n n0 = n.a;
            r0.q q1 = d5.n.o(d.h(d.f(q0, 1.0f), 400.0f), e.b(4.0f));
            long v2 = e0.T(p0, 0x7F060142);  // color:gray030s
            u u0 = y0.M.a;
            r0.q q2 = androidx.compose.foundation.q.f(q1, v2, u0);
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q3, h3);
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            long v5 = e0.T(p0, 0x7F0604B7);  // color:white700e
            long v6 = y0.M.c(ColorUtils.getColorFromHexStr("#FF2CA1"));
            if(c10.a) {
                p0.a0(-1568100727);
                v4 = e0.T(p0, 0x7F06016A);  // color:gray900e
                v5 = e0.T(p0, 0x7F060164);  // color:gray750e
                v6 = y0.M.c(ColorUtils.getColorFromHexStr("#AB8AFF"));
            }
            else {
                p0.a0(0xA1790320);
            }
            p0.p(false);
            r0.q q4 = androidx.compose.foundation.q.f(d.c, v6, u0);
            M m1 = M.p.d(i0, false);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v7)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v7, p0, v7, h4);
            }
            w.x(p0, q5, h3);
            r0.q q6 = d.n(n0, 280.0f);
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q7 = b0.a(q6, r0.d.c);
            h0 h00 = p0.N();
            V v8 = androidx.compose.runtime.k.a;
            if(h00 == v8) {
                n1 = n0;
                h00 = new h0(4);
                p0.l0(h00);
            }
            else {
                n1 = n0;
            }
            V v9 = v8;
            c1.n(X0.n.b(q7, h00), c10.h, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
            r0.q q8 = a.n(n1, 20.0f, 26.0f, 20.0f, 0.0f, 8);
            M.d d0 = j.c;
            g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v10 = p0.P;
            i0 i02 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v10)) {
                h5 = h4;
            }
            else {
                h5 = h4;
                A7.d.q(v10, p0, v10, h5);
            }
            w.x(p0, q9, h3);
            N1.b(c10.d, null, v4, 15.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 120786);
            r0.q q10 = a.n(n1, 0.0f, 10.0f, 0.0f, 0.0f, 13);
            N1.b(c10.e, q10, v4, 34.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0x30C30, 0xC30, 0x1D7D0);
            r0.q q11 = a.n(n1, 0.0f, 4.0f, 0.0f, 0.0f, 13);
            N1.b(c10.f, q11, v4, 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.p(true);
            List list0 = je.p.K0(3, c10.i);
            r0.q q12 = b0.a(a.n(n1, 0.0f, 0.0f, 12.0f, 0.0f, 11), r0.d.g);
            y y1 = M.w.a(d0, g0, p0, 0);
            int v11 = p0.P;
            i0 i03 = p0.m();
            r0.q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h5);
            }
            w.x(p0, q13, h3);
            r0.q q14 = a.n(n1, 20.0f, 0.0f, 8.0f, 7.0f, 2);
            N1.b(c10.g, q14, v4, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.a0(0xD75FCC52);
            int v12 = 0;
            for(Object object0: list0) {
                if(v12 >= 0) {
                    Kd.g g1 = Kd.h.c(((SongInfoBase)object0));
                    String s = String.valueOf(v12 + 1);
                    boolean z = p0.i(g1);
                    boolean z1 = p0.g(s);
                    j0 j00 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z | z1) == 0) {
                        v13 = v9;
                        if(j00 != v13) {
                            goto label_140;
                        }
                    }
                    else {
                        v13 = v9;
                    }
                    j00 = new j0(k0, g1, s, 0);
                    p0.l0(j00);
                label_140:
                    boolean z2 = p0.i(g1);
                    boolean z3 = p0.g(s);
                    j0 j01 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z2 | z3) != 0 || j01 == v13) {
                        j01 = new j0(k0, g1, s, 1);
                        p0.l0(j01);
                    }
                    v9 = v13;
                    e0.i(g1, s, v4, v5, v6, true, false, j00, j01, p0, 0x1B0000);
                    ++v12;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            M.p.a(d.h(d.f(n1, 1.0f), 14.0f), p0, 6);
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(c10, k0, v, 8);
        }
    }

    public static final void c(String s, String s1, float f, l l0, int v) {
        l0 l00;
        n0 n00;
        q.g(s, "title");
        q.g(s1, "subTitle1");
        p p0 = (p)l0;
        p0.c0(-601721275);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16);
        if(!p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            p0.T();
        label_38:
            n00 = p0.t();
            if(n00 != null) {
                l00 = new l0(s, s1, f, v, 1);
                n00.d = l00;
            }
        }
        else if(s.length() == 0) {
            n00 = p0.t();
            if(n00 != null) {
                l00 = new l0(s, s1, f, v, 0);
                n00.d = l00;
            }
        }
        else {
            String s2 = Cb.k.d(s, "을", l1.m("을", "getString(...)", ((Context)p0.k(AndroidCompositionLocals_androidKt.b)), 0x7F130AAD, "getString(...)"));  // string:suffix_reul "를"
            r0.q q0 = a.n(n.a, 20.0f, f, 20.0f, 0.0f, 8);
            n n0 = n.a;
            r0.q q1 = d.u(q0, 3);
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            N1.b(s, new LayoutWeightElement(1.0f, false), e0.T(p0, 0x7F06017C), 30.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0x30C00, 0xC30, 0x1D7D0);  // color:green500s_support_high_contrast
            N1.b(s2, null, e0.T(p0, 0x7F06016D), 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
            N1.b(s1, d.u(a.n(n0, 20.0f, 2.0f, 20.0f, 0.0f, 8), 3), e0.T(p0, 0x7F06016D), 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 3 & 14 | 0xC30, 0, 0x1FFF0);  // color:gray900s
            goto label_38;
        }
    }

    public static final void d(H1 h10, int v, we.a a0, l l0, int v1) {
        int v17;
        Object object0;
        h h4;
        q.g(h10, "uiState");
        p p0 = (p)l0;
        p0.c0(0x757F8E54);
        int v2 = v1 | (p0.i(h10) ? 4 : 2) | (p0.e(v) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = d.t(d.f(a.n(n0, 20.0f, 5.0f, 20.0f, 0.0f, 8), 1.0f), 3);
            M.d d0 = j.c;
            g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q1, h3);
            r0.q q2 = r0.a.a(a.n(n0, 0.0f, 10.0f, 0.0f, 0.0f, 13), new D(9, a0));
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            r0.q q4 = d.u(n0, 3);
            long v5 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
            N1.b(h10.b, q4, v5, 30.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            e1.y y1 = e1.y.i;
            c c0 = I.Q(0x7F080308, p0, 6);  // drawable:common_arrow_list
            y0.k k0 = new y0.k(e0.T(p0, 0x7F06017C), 5);  // color:green500s_support_high_contrast
            androidx.compose.foundation.q.c(c0, null, null, null, N0.j.g, 0.0f, k0, p0, 0x6030, 44);
            p0.p(true);
            r0.q q5 = d.u(a.n(n0, 0.0f, 2.0f, 0.0f, 0.0f, 13), 3);
            long v6 = e0.T(p0, 0x7F06016D);  // color:gray900s
            long v7 = e0.T(p0, 0x7F06016D);  // color:gray900s
            w3.e(q5, h10.c, v6, 30.0f, v7, null, p0, 0xC06, 0x20);
            r0.q q6 = d.u(a.n(n0, 0.0f, 2.0f, 0.0f, 0.0f, 13), 3);
            long v8 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(h10.d, q6, v8, 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);
            long v9 = e0.T(p0, 0x7F0604A1);  // color:white000e
            long v10 = y0.M.c(ColorUtils.getColorFromHexStr("#8C2CFF"));
            long v11 = y0.M.c(ColorUtils.getColorFromHexStr("#36DDE8"));
            long v12 = y0.M.c(ColorUtils.getColorFromHexStr("#FF2CA1"));
            if(h10.a) {
                p0.a0(2056372053);
                v9 = e0.T(p0, 0x7F06016A);  // color:gray900e
                v10 = y0.M.c(ColorUtils.getColorFromHexStr("#73F4DE"));
                v11 = y0.M.c(ColorUtils.getColorFromHexStr("#E7FF69"));
                v12 = y0.M.c(ColorUtils.getColorFromHexStr("#AB8AFF"));
            }
            else {
                p0.a0(2051454616);
            }
            p0.p(false);
            r0.q q7 = androidx.compose.foundation.q.f(d5.n.o(d.h(d.f(a.n(n0, 0.0f, 12.0f, 0.0f, 0.0f, 13), 1.0f), 400.0f), e.b(4.0f)), v12, y0.M.a);
            y y2 = M.w.a(d0, g0, p0, 0);
            int v13 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y2, h0);
            w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v13)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v13, p0, v13, h4);
            }
            w.x(p0, q8, h3);
            r0.q q9 = a.n(n0, 20.0f, 26.0f, 20.0f, 0.0f, 8);
            N1.b(h10.e, q9, v9, 15.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            r0.q q10 = a.n(n0, 20.0f, 10.0f, 20.0f, 0.0f, 8);
            N1.b(h10.f, q10, v9, 34.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            r0.q q11 = a.n(n0, 20.0f, 2.0f, 20.0f, 0.0f, 8);
            N1.b(h10.g, q11, v9, 34.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            r0.q q12 = a.m(n0, 15.0f, 10.0f, 15.0f, 20.0f);
            p0 p01 = M.n0.a(j.e, r0.d.j, p0, 6);
            int v14 = p0.P;
            i0 i03 = p0.m();
            r0.q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v14)) {
                A7.d.q(v14, p0, v14, h4);
            }
            w.x(p0, q13, h3);
            List list0 = h10.h == null ? null : je.p.L0(v, h10.h);
            if(list0 == null) {
                v17 = 0;
            }
            else {
                Iterator iterator0 = list0.iterator();
                if(iterator0.hasNext()) {
                    object0 = iterator0.next();
                    if(iterator0.hasNext()) {
                        String s = ((GraphDetailInfo)object0).cnt;
                        q.f(s, "cnt");
                        int v15 = Integer.parseInt(s);
                        while(true) {
                            Object object1 = iterator0.next();
                            String s1 = ((GraphDetailInfo)object1).cnt;
                            q.f(s1, "cnt");
                            int v16 = Integer.parseInt(s1);
                            if(v15 < v16) {
                                object0 = object1;
                                v15 = v16;
                            }
                            if(!iterator0.hasNext()) {
                                break;
                            }
                        }
                    }
                }
                else {
                    object0 = null;
                }
                if(((GraphDetailInfo)object0) == null) {
                    v17 = 0;
                }
                else {
                    String s2 = ((GraphDetailInfo)object0).cnt;
                    v17 = s2 == null ? 0 : Integer.parseInt(s2);
                }
            }
            int v18 = list0 == null ? 0 : list0.size();
            p0.a0(-2096304782);
            for(int v19 = 0; v19 < v18; ++v19) {
                boolean z = list0 != null && v19 == e.k.s(list0);
                GraphDetailInfo musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0 = list0 == null ? null : ((GraphDetailInfo)list0.get(v19));
                r0.q q14 = d.c(d.f(n0, 1.0f).then(new LayoutWeightElement(1.0f, true)), 1.0f);
                q.d(musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0);
                o0.k(q14, musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0, v9, (z ? v11 : v10), v17, p0, 0);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(h10, v, a0, v1, 20);
        }
    }

    public static final void e(String s, float f, l l0, int v) {
        p p0;
        q.g(s, "title");
        ((p)l0).c0(-1223038265);
        int v1 = v | (((p)l0).g(s) ? 4 : 2);
        boolean z = true;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            if(s.length() > 0) {
                ((p)l0).a0(0xB102B41A);
                r0.q q0 = d.u(a.m(n.a, 20.0f, f, 20.0f, 11.0f), 3);
                boolean z1 = ((p)l0).i(context0);
                if((v1 & 14) != 4) {
                    z = false;
                }
                Y y0 = ((p)l0).N();
                if(z1 || z || y0 == androidx.compose.runtime.k.a) {
                    y0 = new Y(context0, s, 1);
                    ((p)l0).l0(y0);
                }
                N1.b(s, X0.n.c(q0, false, y0), e0.T(((p)l0), 0x7F06016D), 22.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((p)l0), v1 & 14 | 0x30C00, 0, 0x1FFD0);  // color:gray900s
                p0 = (p)l0;
            }
            else {
                p0 = (p)l0;
                p0.a0(0xAF3F993B);
            }
            p0.p(false);
        }
        else {
            p0 = (p)l0;
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new K6(s, f, v, 1);
        }
    }

    public static final void f(l l0, int v) {
        ((p)l0).c0(1833093014);
        if(((p)l0).Q(v & 1, v != 0)) {
            M.p.a(d.h(d.f(n.a, 1.0f), 40.0f), ((p)l0), 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new M6(v, 8);
        }
    }

    public static final void g(D1 d10, l l0, int v) {
        h h4;
        i i1;
        q.g(d10, "uiState");
        p p0 = (p)l0;
        p0.c0(-441691270);
        int v1 = v | (p0.i(d10) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            r0.q q0 = a.n(n.a, 20.0f, 51.0f, 20.0f, 0.0f, 8);
            n n0 = n.a;
            r0.q q1 = d.u(q0, 3);
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            w.x(p0, q2, P0.j.d);
            long v3 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
            h h3 = P0.j.d;
            N1.b(d10.b, null, v3, 30.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);
            e1.y y0 = e1.y.i;
            long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(d10.c, null, v4, 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
            p0.p(true);
            r0.q q3 = a.n(n0, 20.0f, 2.0f, 20.0f, 0.0f, 8);
            long v5 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(d10.d, q3, v5, 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);
            long v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
            long v7 = y0.M.c(ColorUtils.getColorFromHexStr("#6F1FCE"));
            if(d10.a) {
                p0.a0(0x50D5E601);
                v6 = e0.T(p0, 0x7F06016A);  // color:gray900e
                v7 = y0.M.c(ColorUtils.getColorFromHexStr("#4EC9B4"));
            }
            else {
                p0.a0(0x4F80D988);
            }
            p0.p(false);
            r0.q q4 = androidx.compose.foundation.q.f(d5.n.o(d.h(d.f(a.n(n0, 20.0f, 15.0f, 20.0f, 0.0f, 8), 1.0f), 400.0f), e.b(4.0f)), v7, y0.M.a);
            M m0 = M.p.d(r0.d.a, false);
            int v8 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v8)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v8, p0, v8, h4);
            }
            w.x(p0, q5, h3);
            r0.q q6 = d.n(n0, 280.0f);
            c1.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.c), d10.f, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
            r0.q q7 = a.n(n0, 20.0f, 26.0f, 20.0f, 0.0f, 8);
            N1.b(d10.e, q7, v6, 15.0f, y0, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C30, 0xC30, 0x1D7D0);
            r0.q q8 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g);
            y y1 = M.w.a(j.c, r0.d.m, p0, 0);
            int v9 = p0.P;
            i0 i02 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h4);
            }
            w.x(p0, q9, h3);
            p0.a0(0x3358F2C5);
            for(Object object0: d10.g) {
                r0.q q10 = d.h(a.n(n0, 20.0f, 0.0f, 20.0f, 0.0f, 10), 50.0f);
                String s = ((Keyword)object0).keyword;
                q.f(s, "keyword");
                N1.b(s, q10, v6, 34.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C30, 0xC30, 0x1D7D0);
            }
            p0.p(false);
            M.p.a(d.h(d.f(n0, 1.0f), 14.0f), p0, 6);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new V2(d10, v, 13);
        }
    }

    public static final void h(E1 e10, k k0, l l0, int v) {
        String s4;
        String s3;
        q.g(e10, "uiState");
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(504726249);
        int v1 = v | (p0.i(e10) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = a.n(n0, 20.0f, 51.0f, 20.0f, 0.0f, 8);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            String s = e10.a;
            String s1 = e10.b;
            String s2 = e10.c;
            if(s.length() > 0) {
                p0.a0(0x4E5CFC1B);
                s3 = s1;
                s4 = s2;
                w3.e(null, s, e0.T(p0, 0x7F06016D), 30.0f, 0L, null, p0, 0xC00, 49);  // color:gray900s
            }
            else {
                s3 = s1;
                s4 = s2;
                p0.a0(1290247407);
            }
            p0.p(false);
            if(s3.length() > 0) {
                p0.a0(0x4E604C5E);
                w3.e(a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), s3, e0.T(p0, 0x7F06016D), 30.0f, 0L, null, p0, 0xC06, 0x30);  // color:gray900s
            }
            else {
                p0.a0(1290247407);
            }
            p0.p(false);
            if(s4.length() > 0) {
                p0.a0(0x4E648160);
                N1.b(s4, a.n(n0, 0.0f, 3.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F06016D), 30.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray900s
            }
            else {
                p0.a0(1290247407);
            }
            p0.p(false);
            p0.p(true);
            o0.e(e10.d, 46.0f, p0, 0x30);
            List list0 = je.p.K0(5, e10.e);
            p0.a0(0xEEC111EC);
            Iterator iterator0 = list0.iterator();
            int v3 = 0;
            while(true) {
                boolean z = iterator0.hasNext();
                V v4 = androidx.compose.runtime.k.a;
                if(!z) {
                    break;
                }
                Object object0 = iterator0.next();
                if(v3 >= 0) {
                    Kd.g g0 = Kd.h.c(((SongInfoBase)object0));
                    String s5 = String.valueOf(v3 + 1);
                    boolean z1 = p0.i(g0);
                    boolean z2 = p0.g(s5);
                    j0 j00 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z1 | z2) != 0 || j00 == v4) {
                        j00 = new j0(k0, g0, s5, 2);
                        p0.l0(j00);
                    }
                    boolean z3 = p0.i(g0);
                    boolean z4 = p0.g(s5);
                    j0 j01 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z3 | z4) != 0 || j01 == v4) {
                        j01 = new j0(k0, g0, s5, 3);
                        p0.l0(j01);
                    }
                    c1.P(g0, false, false, null, j00, j01, null, false, p0, 0x180, 0xFFCA);
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            o0.e(e10.f, 51.0f, p0, 0x30);
            List list1 = je.p.K0(5, e10.g);
            p0.a0(-289314602);
            int v5 = 0;
            for(Object object1: list1) {
                if(v5 >= 0) {
                    Bc.a a0 = Q1.c.V(((AlbumInfoBase)object1));
                    String s6 = String.valueOf(v5 + 1);
                    boolean z5 = p0.g(a0);
                    boolean z6 = p0.g(s6);
                    hd.n0 n00 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z5 | z6) != 0 || n00 == v4) {
                        n00 = new hd.n0(k0, a0, s6, 0);
                        p0.l0(n00);
                    }
                    boolean z7 = p0.g(a0);
                    boolean z8 = p0.g(s6);
                    hd.n0 n01 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z7 | z8) != 0 || n01 == v4) {
                        n01 = new hd.n0(k0, a0, s6, 1);
                        p0.l0(n01);
                    }
                    boolean z9 = p0.g(a0);
                    boolean z10 = p0.g(s6);
                    hd.n0 n02 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z9 | z10) != 0 || n02 == v4) {
                        n02 = new hd.n0(k0, a0, s6, 2);
                        p0.l0(n02);
                    }
                    e0.a(a0, n00, n01, n02, p0, 0);
                    ++v5;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            o0.e(e10.h, 51.0f, p0, 0x30);
            int v6 = 0;
            for(Object object2: je.p.K0(5, e10.i)) {
                if(v6 >= 0) {
                    q.g(((DjPlayListInfoBase)object2), "<this>");
                    String s7 = ((DjPlayListInfoBase)object2).plylstseq;
                    String s8 = ((DjPlayListInfoBase)object2).thumbimg;
                    String s9 = ((DjPlayListInfoBase)object2).plylsttitle;
                    String s10 = ((DjPlayListInfoBase)object2).ownernickname;
                    Bc.c c0 = new Bc.c((s7 == null ? "" : s7), (s8 == null ? "" : s8), (s9 == null ? "" : s9), (s10 == null ? "" : s10), StringUtils.getCountString(((DjPlayListInfoBase)object2).likecnt, 0x98967F));
                    String s11 = String.valueOf(v6 + 1);
                    boolean z11 = p0.g(c0);
                    boolean z12 = p0.g(s11);
                    hd.i0 i01 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z11 | z12) != 0 || i01 == v4) {
                        i01 = new hd.i0(k0, c0, s11, 2);
                        p0.l0(i01);
                    }
                    boolean z13 = p0.g(c0);
                    boolean z14 = p0.g(s11);
                    hd.i0 i02 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z13 | z14) != 0 || i02 == v4) {
                        i02 = new hd.i0(k0, c0, s11, 0);
                        p0.l0(i02);
                    }
                    boolean z15 = p0.g(c0);
                    boolean z16 = p0.g(s11);
                    hd.i0 i03 = p0.N();
                    if(((v1 & 0x70) == 0x20 | z15 | z16) != 0 || i03 == v4) {
                        i03 = new hd.i0(k0, c0, s11, 1);
                        p0.l0(i03);
                    }
                    e0.t(c0, i01, i02, i03, p0, 0);
                    ++v6;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
        else {
            p0.T();
        }
        n0 n03 = p0.t();
        if(n03 != null) {
            n03.d = new T7(e10, k0, v, 7);
        }
    }

    public static final void i(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x70C2DF49);
        int v1 = (p0.i(a0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = d.h(d.f(a.m(n0, 20.0f, 11.0f, 20.0f, 0.0f), 1.0f), 48.0f);
            r0.q q1 = r0.a.a(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F060154), q0, e.b(4.0f)), new D(10, a0));  // color:gray200s_support_high_contrast
            r0.i i0 = r0.d.e;
            M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q2, P0.j.d);
            r0.q q3 = d.t(d.v(n0, null, 3), 3);
            r0.q q4 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, i0);
            q.f("뮤직 DNA 보러 가기", "getString(...)");
            N1.b("뮤직 DNA 보러 가기", q4, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.j(v, 6, a0);
        }
    }

    public static final void j(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x52B239CE);
        int v1 = (p0.i(a0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.f(d.h(d.f(a.m(n0, 20.0f, 40.0f, 20.0f, 0.0f), 1.0f), 48.0f), e0.T(p0, 0x7F060145), e.b(4.0f)), new D(11, a0));  // color:gray050s
            r0.i i0 = r0.d.e;
            M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            r0.q q2 = d.t(d.v(n0, null, 3), 3);
            r0.q q3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, i0);
            q.f("지난 월간 로그 보러가기", "getString(...)");
            N1.b("지난 월간 로그 보러가기", q3, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C8.j(v, 7, a0);
        }
    }

    public static final void k(r0.q q0, GraphDetailInfo musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0, long v, long v1, int v2, l l0, int v3) {
        n n1;
        r0.q q4;
        q.g(q0, "modifier");
        p p0 = (p)l0;
        p0.c0(1002544374);
        int v4 = v3 | (p0.g(q0) ? 4 : 2) | (p0.i(musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0) ? 0x20 : 16) | (p0.f(v) ? 0x100 : 0x80) | (p0.f(v1) ? 0x800 : 0x400) | (p0.e(v2) ? 0x4000 : 0x2000);
        if(p0.Q(v4 & 1, (v4 & 9363) != 9362)) {
            p0.V();
            if((v3 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            boolean z = p0.i(musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0);
            hd.i i0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(z || i0 == v5) {
                i0 = new hd.i(musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0, 2);
                p0.l0(i0);
            }
            r0.q q1 = X0.n.c(q0, true, i0);
            y y0 = M.w.a(j.d, r0.d.n, p0, 54);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            w.x(p0, q2, P0.j.d);
            h0 h00 = p0.N();
            if(h00 == v5) {
                h00 = new h0(5);
                p0.l0(h00);
            }
            r0.q q3 = X0.n.b(n.a, h00);
            String s = musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0.graphDpCnt;
            q.f(s, "graphDpCnt");
            n n0 = n.a;
            N1.b(s, q3, v, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v4 & 0x380 | 0xC00, 0xC30, 0x1D7F0);
            String s1 = musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0.cnt;
            q.f(s1, "cnt");
            int v7 = Integer.parseInt(s1);
            if(v7 == 0) {
                q4 = androidx.compose.foundation.q.f(d.h(d.f(a.n(n0, 13.5f, 8.0f, 13.5f, 0.0f, 8), 1.0f), 2.0f), v1, y0.M.a);
                n1 = n0;
            }
            else {
                float f = (float)(v7 * 0xB7 / v2);
                float f1 = 15.0f;
                if(f <= 15.0f) {
                    f = 15.0f;
                }
                if(v2 != 1 || v7 != 1) {
                    f1 = f;
                }
                n1 = n0;
                q4 = androidx.compose.foundation.q.f(d.h(d.f(a.n(n1, 13.5f, 8.0f, 13.5f, 0.0f, 8), 1.0f), f1), v1, e.d(100.0f, 100.0f, 0.0f, 0.0f, 12));
            }
            M.p.a(q4, p0, 0);
            r0.q q5 = d.u(a.n(n1, 0.0f, 10.0f, 0.0f, 0.0f, 13), 3);
            h0 h01 = p0.N();
            if(h01 == v5) {
                h01 = new h0(6);
                p0.l0(h01);
            }
            r0.q q6 = X0.n.b(q5, h01);
            String s2 = musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0.graph;
            q.f(s2, "graph");
            N1.b(s2, q6, v, 14.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v4 & 0x380 | 0x30C00, 0, 0x1FFD0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Y1(q0, musicDnaMonthlyLogRes$RESPONSE$MonthlyInfo$GraphInfo$GraphDetailInfo0, v, v1, v2, v3);
        }
    }
}

