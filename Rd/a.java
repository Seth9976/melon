package rd;

import Ac.R0;
import Ac.Z1;
import Ac.g1;
import Ac.h1;
import Ac.h2;
import Ac.i1;
import Bd.e;
import Cc.N1;
import Cc.P;
import Cc.a0;
import Cc.b3;
import Cc.c1;
import Cc.e0;
import Cc.u1;
import Cc.v3;
import De.I;
import F.S;
import F.X;
import F.Y;
import G.C;
import G.f;
import G.x0;
import M.c;
import M.p0;
import M.y;
import M.z;
import N0.M;
import N0.g0;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import U8.m;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.s;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.request.ImageRequest.Builder;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerPageData;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import d5.n;
import e1.x;
import ed.w0;
import gd.S7;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.Arrays;
import java.util.List;
import jd.c2;
import kd.U;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import m0.b;
import pb.r;
import r0.d;
import r0.g;
import r0.q;
import wc.u;

public abstract class a {
    public static final b a;
    public static final int b;
    public static final int c;

    static {
        a.a = new b(0x8B129FD2, new P(29), false);
    }

    public static final void a(q q0, String s, long v, l l0, int v1) {
        ((p)l0).c0(-803308740);
        int v2 = v1 | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).g(s) ? 0x20 : 16) | (((p)l0).f(v) ? 0x100 : 0x80);
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            c.a(q0, null, false, m0.c.e(-1021695578, ((p)l0), new j0(s, v, e0.T(((p)l0), 0x7F060171))), ((p)l0), v2 & 14 | 0xC00, 6);  // color:gray990e
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U(q0, s, v, v1);
        }
    }

    public static final void b(q q0, pc.b b0, boolean z, long v, long v1, l l0, int v2) {
        long v7;
        long v6;
        int v5;
        rd.b b1;
        n0 n00;
        p p0 = (p)l0;
        p0.c0(0x273D44E1);
        int v3 = v2 | (p0.e((b0 == null ? -1 : b0.ordinal())) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | 0x6C00;
        if(!p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            p0.T();
            v7 = v;
            v6 = v1;
        label_53:
            n00 = p0.t();
            if(n00 != null) {
                b1 = new rd.b(q0, b0, z, v7, v6, v2, 1);
                n00.d = b1;
            }
        }
        else if(b0 == null) {
            n00 = p0.t();
            if(n00 != null) {
                b1 = new rd.b(q0, null, z, 75L, 0xAFL, v2, 0);
                n00.d = b1;
            }
        }
        else {
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, j.d);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            switch(b0.ordinal()) {
                case 0: {
                    v5 = 0x7F080628;  // drawable:img_dj_malang_player_bg_1
                    break;
                }
                case 1: {
                    v5 = 0x7F080629;  // drawable:img_dj_malang_player_bg_2
                    break;
                }
                case 2: {
                    v5 = 0x7F08062A;  // drawable:img_dj_malang_player_bg_3
                    break;
                }
                case 3: {
                    v5 = 0x7F08062B;  // drawable:img_dj_malang_player_bg_4
                    break;
                }
                case 4: {
                    v5 = 0x7F08062C;  // drawable:img_dj_malang_player_bg_5
                    break;
                }
                case 5: {
                    v5 = 0x7F08062D;  // drawable:img_dj_malang_player_bg_6
                    break;
                }
                case 6: {
                    v5 = 0x7F08062E;  // drawable:img_dj_malang_player_bg_7
                    break;
                }
                case 7: {
                    v5 = 0x7F08062F;  // drawable:img_dj_malang_player_bg_8
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            c1.n(fillElement0, v5, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xD86, 0, 0x7FF0);
            androidx.compose.animation.b.d(z, null, S.b(f.r(0xAF, 0, C.d, 2), 2), S.c(f.r(75, 0, C.d, 2), 2), null, m0.c.e(0x6AF72F3F, p0, new e(b0, 22)), p0, v3 >> 6 & 14 | 0x30000, 18);
            p0.p(true);
            v6 = 0xAFL;
            v7 = 75L;
            goto label_53;
        }
    }

    public static final void c(q q0, DjMalrangPlayerPageData djMalrangPlayerPageData0, we.a a0, we.a a1, we.a a2, l l0, int v) {
        h h5;
        i i2;
        int v8;
        int v7;
        String s4;
        String s2;
        String s;
        kotlin.jvm.internal.q.g(a0, "transformationPositionProvider");
        p p0 = (p)l0;
        p0.c0(0x58E30732);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(djMalrangPlayerPageData0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.e(300) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.d(0.92f) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(a1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v1 |= (p0.i(a2) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v1 & 1, (0x92493 & v1) != 0x92492)) {
            Bc.h h0 = x.I(p0);
            u1 u10 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((((v1 & 0x1C00) == 0x800 ? 1 : 0) | ((0xE000 & v1) == 0x4000 ? 1 : 0)) != 0 || u10 == v2) {
                u10 = new u1(13, a0);
                p0.l0(u10);
            }
            q q1 = androidx.compose.ui.graphics.a.a(q0, u10);
            r0.i i0 = d.a;
            M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = j.f;
            w.x(p0, m0, h1);
            h h2 = j.e;
            w.x(p0, i00, h2);
            h h3 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h3);
            }
            h h4 = j.d;
            w.x(p0, q2, h4);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            q q3 = n.o(fillElement0, T.e.b(15.0f));
            q q4 = androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F0604AE), q3, T.e.b(15.0f));  // color:white120e
            M m1 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h1);
            w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            w.x(p0, q5, h4);
            if(djMalrangPlayerPageData0 == null) {
                s = null;
            }
            else {
                List list0 = djMalrangPlayerPageData0.a;
                s = list0 == null ? null : ((String)je.p.m0(list0));
            }
            a.i(v1 & 0x380 | 6, p0, s, fillElement0);
            M.p.a(androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F060140), y0.M.a), p0, 0);  // color:gray001e_support_high_contrast
            r0.n n0 = r0.n.a;
            q q6 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            q q7 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, d.h);
            M.d d0 = M.j.c;
            g g0 = d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i02, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            w.x(p0, q8, h4);
            q q9 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.l(n0, 18.0f, 0.0f, 2), 1.0f);
            String s1 = "";
            if(djMalrangPlayerPageData0 == null) {
                s2 = "";
            }
            else {
                s2 = djMalrangPlayerPageData0.b;
                if(s2 == null) {
                    s2 = "";
                }
            }
            a1.U u0 = a.x(p0);
            long v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
            s s3 = new s(20.0f, 0);
            c1.g(q9, s2, v6, 16.0f, e1.y.i, u0, s3, 0, 0, p0, 0x6C06, 0x180);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 3.0f));
            if(djMalrangPlayerPageData0 == null) {
                s4 = "";
            }
            else {
                s4 = djMalrangPlayerPageData0.c;
                if(s4 == null) {
                    s4 = "";
                }
            }
            boolean z = p0.g(s4);
            String s5 = p0.N();
            if(z || s5 == v2) {
                if(h0 == null) {
                    s5 = "";
                }
                else {
                    String s6 = h0.a(s4);
                    s5 = s6 == null ? "" : s6;
                }
                p0.l0(s5);
            }
            q q10 = r0.a.a(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.l(n0, 18.0f, 0.0f, 2), 1.0f), new a0(0, 0, H0.e.Y(p0, 0x7F130B3A), a1, true));  // string:talkback_go_to_artist_channel_button "아티스트 채널 가기"
            boolean z1 = p0.g(s5);
            com.iloen.melon.playback.playlist.db.d d1 = p0.N();
            if(z1 || d1 == v2) {
                d1 = new com.iloen.melon.playback.playlist.db.d(s5, 22);
                p0.l0(d1);
            }
            q q11 = X0.n.b(q10, d1);
            if(djMalrangPlayerPageData0 != null) {
                String s7 = djMalrangPlayerPageData0.c;
                if(s7 != null) {
                    s1 = s7;
                }
            }
            a1.U u1 = a.x(p0);
            c1.g(q11, s1, e0.T(p0, 0x7F0604A1), 14.0f, null, u1, new s(20.0f, 0), 0, 0, p0, 0xC00, 400);  // color:white000e
            if(djMalrangPlayerPageData0 == null || !djMalrangPlayerPageData0.d) {
                v7 = 0xE7E60553;
                v8 = 0x7F130B63;  // string:talkback_like_turn_on "좋아요, 선택하기"
            }
            else {
                v7 = -404452942;
                v8 = 0x7F130B62;  // string:talkback_like_turn_off "좋아요, 취소하기"
            }
            String s8 = l1.h(p0, v7, v8, p0, false);
            q q12 = r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 51.0f), new a0(2, 0, s8, a2, true));
            y y1 = M.w.a(d0, g0, p0, 0);
            int v9 = p0.P;
            i0 i03 = p0.m();
            q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            w.x(p0, y1, h1);
            w.x(p0, i03, h2);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v9)) {
                h5 = h3;
            }
            else {
                h5 = h3;
                A7.d.q(v9, p0, v9, h5);
            }
            w.x(p0, q13, h4);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 10.0f));
            q q14 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 25.0f);
            p0 p00 = M.n0.a(M.j.a, d.j, p0, 0);
            int v10 = p0.P;
            i0 i04 = p0.m();
            q q15 = r0.a.d(p0, q14);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h1);
            w.x(p0, i04, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h5);
            }
            w.x(p0, q15, h4);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 16.0f));
            a.k(null, (djMalrangPlayerPageData0 == null ? false : djMalrangPlayerPageData0.d), (djMalrangPlayerPageData0 == null ? -1 : djMalrangPlayerPageData0.e), p0, 0);
            p0.p(true);
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
            n00.d = new k0(q0, djMalrangPlayerPageData0, a0, a1, a2, v);
        }
    }

    public static final void d(boolean z, int v, we.a a0, we.a a1, we.a a2, we.a a3, we.a a4, we.a a5, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0x6F4B8594);
        int v2 = (v1 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.i(a3) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v2 |= (p0.i(a4) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v2 |= (p0.i(a5) ? 0x800000 : 0x400000);
        }
        if(p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            r0.n n0 = r0.n.a;
            q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), E9.h.t(p0, 0x7F0700E9));  // dimen:dj_malrang_player_more_mid_button_area_height
            M m0 = M.p.d(d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            q q2 = androidx.compose.foundation.layout.d.s(n0, 280.0f, 0.0f, 2);
            a.p((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, d.b), z, v, a0, a1, a2, a3, a4, p0, v2 << 3 & 0x1FFFFF0);
            a.q((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.h), a5, p0, v2 >> 18 & 0x70);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c2(z, v, a0, a1, a2, a3, a4, a5, v1);
        }
    }

    public static final void e(String s, String s1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(119418059);
        int v1 = (p0.g(s) ? 4 : 2) | v | (p0.g(s1) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), E9.h.t(p0, 0x7F0700EA));  // dimen:dj_malrang_player_more_song_and_artist_name_height
            y y0 = M.w.a(M.j.c, d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            a.r(v1 << 3 & 0x70, p0, s, androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.a.l(n0, E9.h.t(p0, 0x7F07040D), 0.0f, 2), 0.0f, 14.0f, 0.0f, 4.0f, 5));  // dimen:player_horizontal_margin
            a.m(v1 & 0x70, p0, s1, androidx.compose.foundation.layout.a.l(n0, E9.h.t(p0, 0x7F07040D), 0.0f, 2));  // dimen:player_horizontal_margin
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Bd.i(v, 6, s, s1);
        }
    }

    public static final void f(r r0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x17FD6DB3);
        int v1 = (v & 6) == 0 ? (p0.e(r0.ordinal()) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), E9.h.t(p0, 0x7F0700EB));  // dimen:dj_malrang_player_more_sound_area_height
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            a.s(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, d.h), 0.0f, 0.0f, 0.0f, 14.0f, 7), r0, a0, p0, v1 << 3 & 0x3F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.U(r0, a0, v, 22);
        }
    }

    public static final void g(q q0, b0 b00, boolean z, we.a a0, long v, we.a a1, we.a a2, we.a a3, we.a a4, we.a a5, we.a a6, we.k k0, we.a a7, l l0, int v1) {
        r0.n n1;
        M.d d1;
        b1 b10;
        pc.b b0;
        androidx.compose.runtime.b0 b03;
        V v9;
        W w0;
        int v8;
        r0.i i0 = d.a;
        kotlin.jvm.internal.q.g(b00, "moreUiState");
        p p0 = (p)l0;
        p0.c0(0xB60E2E1E);
        int v2 = 16;
        int v3 = 0x80;
        int v4 = v1 | (p0.g(b00) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.i(a0) ? 0x800 : 0x400) | (p0.i(a1) ? 0x20000 : 0x10000) | (p0.i(a2) ? 0x100000 : 0x80000) | (p0.i(a3) ? 0x800000 : 0x400000) | (p0.i(a4) ? 0x4000000 : 0x2000000) | (p0.i(a5) ? 0x20000000 : 0x10000000);
        int v5 = p0.i(a6) ? 4 : 2;
        if(p0.i(k0)) {
            v2 = 0x20;
        }
        if(p0.i(a7)) {
            v3 = 0x100;
        }
        int v6 = v5 | v2 | v3;
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (v6 & 0x93) != 0x92)) {
            androidx.compose.runtime.b0 b01 = p0.N();
            V v7 = androidx.compose.runtime.k.a;
            if(b01 == v7) {
                b01 = w.s(b00);
                p0.l0(b01);
            }
            androidx.compose.runtime.b0 b02 = p0.N();
            if(b02 == v7) {
                b02 = w.s(Boolean.valueOf(b00 instanceof rd.a0));
                p0.l0(b02);
            }
            Object object0 = p0.N();
            if((v4 & 0x70) == 0x20 || object0 == v7) {
                v9 = v7;
                b03 = b02;
                v8 = v6;
                w0 = new W(b00, v, b01, b03, null);
                p0.l0(w0);
            }
            else {
                v8 = v6;
                w0 = object0;
                v9 = v7;
                b03 = b02;
            }
            J.d(p0, b00, w0);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            androidx.compose.runtime.b0 b04 = p0.N();
            if(b04 == v9) {
                b04 = w.s(new r1.l(0L));
                p0.l0(b04);
            }
            androidx.compose.runtime.a0 a00 = p0.N();
            if(a00 == v9) {
                a00 = w.p(ScreenUtils.getStatusBarHeight(context0));
                p0.l0(a00);
            }
            androidx.compose.runtime.b0 b05 = p0.N();
            if(b05 == v9) {
                b05 = w.s(new r1.l(0L));
                p0.l0(b05);
            }
            b0 b06 = (b0)b01.getValue();
            boolean z1 = p0.g(b06);
            E e0 = p0.N();
            if(z1 || e0 == v9) {
                e0 = w.i(new Z1(b06, context0, b05, 24));
                p0.l0(e0);
            }
            rd.a0 a01 = b06 instanceof rd.a0 ? ((rd.a0)b06) : null;
            if(a01 == null) {
                b0 = null;
            }
            else {
                DjMalrangInfo djMalrangInfo0 = a01.a.a;
                b0 = djMalrangInfo0 == null ? null : djMalrangInfo0.i;
            }
            long v10 = b0 == null ? y0.s.f : y0.M.e(x1.a.z(b0));
            q q1 = androidx.compose.foundation.q.f(q0, v10, y0.M.a);
            R0 r00 = p0.N();
            if(r00 == v9) {
                b10 = e0;
                r00 = new R0(b04, 24);
                p0.l0(r00);
            }
            else {
                b10 = e0;
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, r00);
            M.d d0 = M.j.c;
            g g0 = d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v11 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O) {
                d1 = d0;
                A7.d.q(v11, p0, v11, h2);
            }
            else {
                d1 = d0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q3, h3);
            q q4 = z.a(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 1.0f);
            boolean z2 = p0.i(context0);
            com.iloen.melon.player.playlist.mixup.composables.c c0 = p0.N();
            r0.n n0 = r0.n.a;
            if(z2 || c0 == v9) {
                c0 = new com.iloen.melon.player.playlist.mixup.composables.c(a00, context0, b05, 27);
                p0.l0(c0);
            }
            q q5 = androidx.compose.ui.layout.a.f(q4, c0);
            M m0 = M.p.d(i0, false);
            int v12 = p0.P;
            i0 i01 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h2);
            }
            w.x(p0, q6, h3);
            if(b06 instanceof rd.a0) {
                p0.a0(0x2C8A9B01);
                Q0 q00 = androidx.compose.foundation.q.t(p0);
                E e1 = p0.N();
                if(e1 == v9) {
                    e1 = w.i(new rd.S(q00, 0));
                    p0.l0(e1);
                }
                q q7 = androidx.compose.foundation.q.x(q0.then(androidx.compose.foundation.layout.d.c), q00, false, 14);
                y y1 = M.w.a(d1, g0, p0, 0);
                int v13 = p0.P;
                i0 i02 = p0.m();
                q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y1, h0);
                w.x(p0, i02, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v13)) {
                    A7.d.q(v13, p0, v13, h2);
                }
                w.x(p0, q8, h3);
                n1 = n0;
                c.d(p0, androidx.compose.foundation.layout.d.h(n1, e0.Z(p0, ((K0)a00).m())));
                a.f(((rd.a0)b06).a.l, a0, p0, v4 >> 6 & 0x70);
                HorizontalAlignElement horizontalAlignElement0 = new HorizontalAlignElement(d.n);
                long v14 = ((r1.l)b04.getValue()).a;
                boolean z3 = ((Boolean)b03.getValue()).booleanValue();
                int v15 = ((Number)b10.getValue()).intValue();
                a.l(horizontalAlignElement0, v14, z3, z, ((rd.a0)b06).a.i.toString(), v15, v, p0, v4 << 3 & 0x1C00 | 0x180000);
                a.e(((rd.a0)b06).a.g, ((rd.a0)b06).a.h, p0, 0);
                a.d(((rd.a0)b06).a.j, ((rd.a0)b06).a.k, a1, a2, a3, a4, a5, a6, p0, v4 >> 9 & 0x3FFF80 | v8 << 21 & 0x1C00000);
                p0.a0(0xE3FA0B80);
                for(Object object1: je.p.A0(((rd.a0)b06).b, ((rd.a0)b06).c)) {
                    MelonBottomSheetItem melonBottomSheetItem0 = (MelonBottomSheetItem)object1;
                    String s = H0.e.Y(p0, melonBottomSheetItem0.b);
                    boolean z4 = melonBottomSheetItem0.e;
                    boolean z5 = p0.g(melonBottomSheetItem0);
                    w0 w00 = p0.N();
                    if((v8 & 0x70) == 0x20 || z5 || w00 == v9) {
                        w00 = new w0(27, k0, melonBottomSheetItem0);
                        p0.l0(w00);
                    }
                    a.n(s, z4, w00, p0, 0);
                }
                p0.p(false);
                c.d(p0, androidx.compose.foundation.layout.d.h(n1, E9.h.t(p0, 0x7F0700E7)));  // dimen:dj_malrang_player_more_bottom_spacer_height
                p0.p(true);
                q q9 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n1, d.h);
                boolean z6 = ((Boolean)e1.getValue()).booleanValue();
                X x0 = S.b(f.r(200, 0, null, 6), 2);
                b b1 = m0.c.e(-910499443, p0, new S7(v10, 1));
                androidx.compose.animation.b.d(z6, q9, x0, Y.b, null, b1, p0, 0x30180, 16);
            }
            else {
                n1 = n0;
                p0.a0(740879560);
            }
            p0.p(false);
            p0.p(true);
            q q10 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n1, 1.0f), E9.h.t(p0, 0x7F0702FF));  // dimen:melon_popup_footer_close_button_height
            M m1 = M.p.d(i0, false);
            int v16 = p0.P;
            i0 i03 = p0.m();
            q q11 = r0.a.d(p0, q10);
            k.y.getClass();
            i i2 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, j.f);
            w.x(p0, i03, j.e);
            h h4 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v16)) {
                A7.d.q(v16, p0, v16, h4);
            }
            w.x(p0, q11, j.d);
            if(b06 instanceof rd.a0) {
                p0.a0(0xAC70305F);
                a.o(a7, p0, v8 >> 6 & 14);
            }
            else {
                p0.a0(0xABDA5B71);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T(q0, b00, z, a0, v, a1, a2, a3, a4, a5, a6, k0, a7, v1);
        }
    }

    public static final void h(DjMalrangPlayerPageData djMalrangPlayerPageData0, we.a a0, we.k k0, we.a a1, we.a a2, we.a a3, l l0, int v) {
        androidx.compose.runtime.a0 a01;
        p p0 = (p)l0;
        p0.c0(0x5C4B2CAF);
        int v1 = v | (p0.i(djMalrangPlayerPageData0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(a1) ? 0x4000 : 0x2000) | (p0.i(a2) ? 0x100000 : 0x80000) | (p0.i(a3) ? 0x800000 : 0x400000);
        if(p0.Q(v1 & 1, (0x492493 & v1) != 4793490)) {
            androidx.compose.runtime.b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(new r1.l(0L));
                p0.l0(b00);
            }
            androidx.compose.runtime.b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(new Point(0, 0));
                p0.l0(b01);
            }
            androidx.compose.runtime.a0 a00 = p0.N();
            if(a00 == v2) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            Bd.x x0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 0x380) == 0x100 ? 1 : 0)) != 0 || x0 == v2) {
                a01 = a00;
                Bd.x x1 = new Bd.x(b00, k0, a01, a0, b01, 6);
                p0.l0(x1);
                x0 = x1;
            }
            else {
                a01 = a00;
            }
            q q0 = androidx.compose.ui.layout.a.f(fillElement0, x0);
            y y0 = M.w.a(M.j.c, d.n, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            p0.a0(0xF81376A2);
            if(!((Point)b01.getValue()).equals(0, 0)) {
                float f = e0.Z(p0, ((Point)b01.getValue()).x);
                float f1 = e0.Z(p0, ((Point)b01.getValue()).y);
                float f2 = e0.Z(p0, ((K0)a01).m());
                c.d(p0, androidx.compose.foundation.layout.d.h(r0.n.a, f2));
                a.c(androidx.compose.foundation.layout.d.o(r0.n.a, f, f1), djMalrangPlayerPageData0, a1, a2, a3, p0, v1 << 3 & 0x70 | 0x180 | v1 >> 3 & 0x1C00 | 0x6000 | 0x70000 & v1 >> 3 | v1 >> 3 & 0x380000);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new h2(djMalrangPlayerPageData0, a0, k0, a1, a2, a3, v);
        }
    }

    public static final void i(int v, l l0, String s, q q0) {
        G.e e3;
        androidx.compose.runtime.b0 b06;
        androidx.compose.runtime.b0 b05;
        androidx.compose.runtime.b0 b04;
        V v3;
        G.e e2;
        Context context1;
        p p0 = (p)l0;
        p0.c0(0x51F7AC11);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.e(300) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            androidx.compose.runtime.b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(null);
                p0.l0(b00);
            }
            androidx.compose.runtime.b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(null);
                p0.l0(b01);
            }
            androidx.compose.runtime.b0 b02 = p0.N();
            if(b02 == v2) {
                context1 = context0;
                b02 = w.s(new y0.s(y0.s.f));
                p0.l0(b02);
            }
            else {
                context1 = context0;
            }
            androidx.compose.runtime.b0 b03 = p0.N();
            if(b03 == v2) {
                b03 = w.s(new y0.s(y0.s.f));
                p0.l0(b03);
            }
            G.e e0 = p0.N();
            if(e0 == v2) {
                e0 = f.a(1.0f);
                p0.l0(e0);
            }
            G.e e1 = p0.N();
            if(e1 == v2) {
                e1 = f.a(0.0f);
                p0.l0(e1);
            }
            x0 x00 = f.r(300, 0, C.d, 2);
            boolean z = p0.i(context1);
            boolean z1 = p0.i(e1);
            boolean z2 = p0.g(x00);
            boolean z3 = p0.i(e0);
            o0 o00 = p0.N();
            if(((v1 & 0x70) == 0x20 | z | z1 | z2 | z3) != 0 || o00 == v2) {
                b06 = b01;
                e3 = e0;
                v3 = v2;
                o0 o01 = new o0(s, context1, b00, b06, b02, b03, e1, x00, e3, null);
                b04 = b02;
                e2 = e1;
                b05 = b00;
                p0.l0(o01);
                o00 = o01;
            }
            else {
                e2 = e1;
                v3 = v2;
                b04 = b02;
                b05 = b00;
                b06 = b01;
                e3 = e0;
            }
            J.d(p0, s, o00);
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, j.d);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            M.p.a(androidx.compose.foundation.q.f(fillElement0, e0.T(p0, 0x7F060144), y0.M.a), p0, 0);  // color:gray050e
            boolean z4 = p0.i(e2);
            l0 l00 = p0.N();
            if(z4 || l00 == v3) {
                l00 = new l0(e2, 0);
                p0.l0(l00);
            }
            a.a(androidx.compose.ui.graphics.a.a(fillElement0, l00), ((String)b06.getValue()), ((y0.s)b03.getValue()).a, p0, 0);
            boolean z5 = p0.i(e3);
            l0 l01 = p0.N();
            if(z5 || l01 == v3) {
                l01 = new l0(e3, 1);
                p0.l0(l01);
            }
            a.a(androidx.compose.ui.graphics.a.a(fillElement0, l01), ((String)b05.getValue()), ((y0.s)b04.getValue()).a, p0, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.w0(q0, s, v, 6);
        }
    }

    public static final void j(long v, l l0, int v1) {
        ((p)l0).c0(1533625550);
        int v2 = (((p)l0).f(v) ? 4 : 2) | v1;
        if(((p)l0).Q(v2 & 1, (v2 & 3) != 2)) {
            M.p.a(androidx.compose.foundation.q.e(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 90.0f), u.f(e.k.A(new y0.s[]{new y0.s(y0.s.f), new y0.s(v)}), 0.0f, 0.0f, 14), null, 6), ((p)l0), 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new rd.V(v, v1);
        }
    }

    public static final void k(q q0, boolean z, int v, l l0, int v1) {
        q q5;
        y0.k k0;
        p p0 = (p)l0;
        p0.c0(0x44F65F52);
        int v2 = v1 | 6 | (p0.h(z) ? 0x20 : 16) | (p0.e(v) ? 0x100 : 0x80);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            String s = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((v2 & 0x380) == 0x100 || s == v3) {
                s = v <= -1 ? "" : Cb.k.b(context0, String.valueOf(v));
                p0.l0(s);
            }
            boolean z1 = p0.g(s);
            String s1 = p0.N();
            if((v2 & 0x70) == 0x20 || z1 || s1 == v3) {
                kotlin.jvm.internal.q.f("좋아요, %1$s명", "getString(...)");
                s1 = String.format("좋아요, %1$s명", Arrays.copyOf(new Object[]{s}, 1));
                p0.l0(s1);
            }
            r0.n n0 = r0.n.a;
            q q1 = X0.n.c(androidx.compose.foundation.q.p(n0), false, S.a.f);
            boolean z2 = p0.g(s1);
            com.iloen.melon.playback.playlist.db.d d0 = p0.N();
            if(z2 || d0 == v3) {
                d0 = new com.iloen.melon.playback.playlist.db.d(s1, 23);
                p0.l0(d0);
            }
            q q2 = X0.n.b(q1, d0);
            p0 p00 = M.n0.a(M.j.a, d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, j.d);
            q q4 = androidx.compose.foundation.layout.d.n(n0, 25.0f);
            C0.c c0 = I.Q((z ? 0x7F08018B : 0x7F08018A), p0, 0);  // drawable:btn_detail_like_25_w
            if(z) {
                p0.a0(-29400644);
                k0 = new y0.k(e0.T(p0, 0x7F06017A), 5);  // color:green500e_support_high_contrast
                p0.p(false);
            }
            else {
                p0.a0(0xC9AE124F);
                p0.p(false);
                k0 = null;
            }
            androidx.compose.foundation.q.c(c0, null, q4, null, null, 0.0f, k0, p0, 0x1B0, 56);
            N1.b(s, null, A7.d.g(n0, 3.0f, p0, 0x7F0604A1, p0), 14.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, a.x(p0), p0, 0xC00, 0xC00, 0xDFF2);  // color:white000e
            p0.p(true);
            q5 = n0;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.x(q5, z, v, v1);
        }
    }

    public static final void l(q q0, long v, boolean z, boolean z1, String s, int v1, long v2, l l0, int v3) {
        float f5;
        float f4;
        float f3;
        float f2;
        float f1;
        p p0 = (p)l0;
        p0.c0(0x67635C5A);
        int v4 = (v3 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v3 : v3;
        if((v3 & 0x30) == 0) {
            v4 |= (p0.f(v) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v4 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            v4 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        if((v3 & 0x6000) == 0) {
            v4 |= (p0.g(s) ? 0x4000 : 0x2000);
        }
        if((v3 & 0x30000) == 0) {
            v4 |= (p0.e(v1) ? 0x20000 : 0x10000);
        }
        if((v3 & 0x180000) == 0) {
            v4 |= (p0.f(v2) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v4 & 1, (v4 & 0x92493) != 0x92492)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            androidx.compose.runtime.b0 b00 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(b00 == v5) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            rd.X x0 = p0.N();
            if((v4 & 0x380) == 0x100 || x0 == v5) {
                x0 = new rd.X(b00, null, z);
                p0.l0(x0);
            }
            J.d(p0, boolean0, x0);
            DjMalrangPlayerViewCalculator djMalrangPlayerViewCalculator0 = p0.N();
            if(djMalrangPlayerViewCalculator0 == v5) {
                djMalrangPlayerViewCalculator0 = new DjMalrangPlayerViewCalculator(context0);
                p0.l0(djMalrangPlayerViewCalculator0);
            }
            djMalrangPlayerViewCalculator0.getClass();
            Point point0 = djMalrangPlayerViewCalculator0.a(new Point(((int)(v >> 0x20)), ((int)(v & 0xFFFFFFFFL))));
            G.w w0 = C.a;
            M m0 = M.p.d(d.a, false);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.n n0 = r0.n.a;
            if(point0.x > 0) {
                p0.a0(0x60F45BD1);
                if(z1) {
                    p0.a0(0x60FA92A0);
                    p0.p(false);
                    f1 = 0.0f;
                }
                else {
                    p0.a0(0x60F6F9D4);
                    float f = ((float)djMalrangPlayerViewCalculator0.b()) - e0.a0(E9.h.t(p0, 0x7F0700EB), p0) - ((float)ScreenUtils.getStatusBarHeight(context0));  // dimen:dj_malrang_player_more_sound_area_height
                    p0.p(false);
                    f1 = f;
                }
                if(((Boolean)b00.getValue()).booleanValue()) {
                    p0.a0(1715057410);
                    p0.p(false);
                    f2 = 0.0f;
                }
                else {
                    p0.a0(1715058566);
                    f2 = e0.Y(f1, p0);
                    p0.p(false);
                }
                b1 b10 = G.j.a(f2, f.r(((int)v2), 0, w0, 2), "spacerHeightAnimation", p0);
                if(((Boolean)b00.getValue()).booleanValue()) {
                    p0.a0(1715067430);
                    f3 = e0.Z(p0, v1);
                }
                else {
                    p0.a0(1715068454);
                    f3 = e0.Z(p0, point0.x);
                }
                p0.p(false);
                int v7 = 4;
                b1 b11 = G.j.a(f3, f.r(((int)v2), 0, w0, 2), "thumbSizeAnimation", p0);
                if(!((Boolean)b00.getValue()).booleanValue() && !z1) {
                    v7 = 15;
                }
                b1 b12 = G.j.a(v7, f.r(((int)v2), 0, w0, 2), "cornerRadiusAnimation", p0);
                if(((Boolean)b00.getValue()).booleanValue()) {
                    f4 = 1.0f;
                }
                else if(z1) {
                    f4 = 0.0f;
                }
                else {
                    f4 = 1.0f;
                }
                b1 b13 = G.j.b(f4, f.r(((int)v2), 0, w0, 2), "thumbAlphaAnimation", null, p0, 0xC00, 20);
                y y0 = M.w.a(M.j.c, d.m, p0, 0);
                int v8 = p0.P;
                i0 i01 = p0.m();
                q q2 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                w.x(p0, q2, h3);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, ((r1.f)b10.getValue()).a));
                a.t(e2.a.r(androidx.compose.foundation.layout.d.n(n0, ((r1.f)b11.getValue()).a), ((Number)b13.getValue()).floatValue()), s, ((r1.f)b12.getValue()).a, p0, v4 >> 9 & 0x70, 0);
                p0.p(true);
            }
            else {
                p0.a0(0x611502CC);
                if(((Boolean)b00.getValue()).booleanValue()) {
                    p0.a0(0x663A9266);
                    f5 = e0.Z(p0, v1);
                    p0.p(false);
                }
                else {
                    p0.a0(1715115042);
                    p0.p(false);
                    f5 = 0.0f;
                }
                b1 b14 = G.j.a(f5, f.r(((int)v2), 0, w0, 2), "thumbSizeAnimation", p0);
                b1 b15 = G.j.b((((Boolean)b00.getValue()).booleanValue() ? 1.0f : 0.0f), f.r(((int)v2), 0, w0, 2), "thumbAlphaAnimation", null, p0, 0xC00, 20);
                a.t(e2.a.r(androidx.compose.foundation.layout.d.n(n0, ((r1.f)b14.getValue()).a), ((Number)b15.getValue()).floatValue()), s, 0.0f, p0, v4 >> 9 & 0x70, 4);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new rd.U(q0, v, z, z1, s, v1, v2, v3);
        }
    }

    public static final void m(int v, l l0, String s, q q0) {
        ((p)l0).c0(0xF5F4DB67);
        int v1 = (((p)l0).g(q0) ? 4 : 2) | v | (((p)l0).g(s) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            N1.b(s, androidx.compose.foundation.layout.d.f(q0, 1.0f), e0.T(((p)l0), 0x7F0604B7), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, ((p)l0), v1 >> 3 & 14 | 0xC00, 0xC30, 0x1D5F0);  // color:white700e
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.h(q0, s, v, 6);
        }
    }

    public static final void n(String s, boolean z, we.a a0, l l0, int v) {
        kotlin.jvm.internal.q.g(s, "text");
        p p0 = (p)l0;
        p0.c0(-1101979373);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            q q0 = e0.Q(androidx.compose.foundation.layout.a.n(r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), E9.h.t(p0, 0x7F070412)), new a0(0, 0, null, a0, z)), 20.0f, 0.0f, 0.0f, 0.0f, 14), z);  // dimen:player_more_menu_item_height
            M m0 = M.p.d(d.d, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            N1.b(s, null, e0.T(p0, 0x7F0604A1), 16.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 0, 0x1FFF2);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new m(s, z, a0, v, 1);
        }
    }

    public static final void o(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1974248407);
        int v1 = (v & 6) == 0 ? (p0.i(a0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            a0 a00 = new a0(0, 0, null, a0, true);
            q q0 = r0.a.a(androidx.compose.foundation.layout.d.c, a00);
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            c.d(p0, androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 20.0f, 0.0f, 2), 0.5f), e0.T(p0, 0x7F0604AE), y0.M.a));  // color:white120e
            N1.b(H0.e.Y(p0, 0x7F1301D2), (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(r0.n.a, d.e), e0.T(p0, 0x7F0604A1), 16.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.x0(v, 4, a0);
        }
    }

    public static final void p(q q0, boolean z, int v, we.a a0, we.a a1, we.a a2, we.a a3, we.a a4, l l0, int v1) {
        androidx.compose.runtime.b0 b02;
        x1.m m1;
        p p0 = (p)l0;
        p0.c0(0x144A0054);
        int v2 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.i(a1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v2 |= (p0.i(a2) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v2 |= (p0.i(a3) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v2 |= (p0.i(a4) ? 0x800000 : 0x400000);
        }
        if(p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(Q0.k0.h);
            x1.q q1 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(q1 == v3) {
                q1 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v3) {
                j0 = l1.u(p0);
            }
            androidx.compose.runtime.b0 b00 = p0.N();
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            x1.m m0 = p0.N();
            if(m0 == v3) {
                m0 = l1.v(j0, p0);
            }
            androidx.compose.runtime.b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            boolean z1 = p0.i(q1);
            boolean z2 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z1 || z2 || g10 == v3) {
                g10 = new g1(b01, q1, m0, 13, b00);
                m1 = m0;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                m1 = m0;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v3) {
                h10 = new h1(b02, m1, 13);
                p0.l0(h10);
            }
            boolean z3 = p0.i(q1);
            i1 i10 = p0.N();
            if(z3 || i10 == v3) {
                i10 = new i1(q1, 13);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q0, false, i10), m0.c.e(1200550679, p0, new rd.Y(b01, j0, h10, a0, a1, v, z, ((Context)object0), a2, a3, a4)), g10, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c2(q0, z, v, a0, a1, a2, a3, a4, v1);
        }
    }

    public static final void q(q q0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xE6330559);
        int v1 = (v & 6) == 0 ? v | (p0.g(q0) ? 4 : 2) : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            q q1 = r0.a.a(androidx.compose.foundation.layout.d.h(q0, 44.0f), new a0(0, 0, H0.e.Y(p0, 0x7F13080D), a0, true));  // string:play_mixup_by_this_song "이 곡으로 믹스업"
            M m0 = M.p.d(d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            r0.n n0 = r0.n.a;
            q q3 = androidx.compose.foundation.layout.d.h(n0, 36.0f);
            q q4 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F0604B1), q3, T.e.a), 13.0f, 0.0f, 2);  // color:white220e
            p0 p00 = M.n0.a(M.j.a, d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q5, h3);
            c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 24.0f), 14.4f), 0x7F080155, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 438, 0, 0x7FF8);  // drawable:btn_common_mixup_18
            N1.b(l1.s(n0, 6.0f, p0, 0x7F13080D, p0), null, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:play_mixup_by_this_song "이 곡으로 믹스업"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new qd.j(q0, a0, v, 1);
        }
    }

    public static final void r(int v, l l0, String s, q q0) {
        ((p)l0).c0(0x4F8F0BB5);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            q q1 = androidx.compose.foundation.layout.d.f(q0, 1.0f);
            long v2 = e0.T(((p)l0), 0x7F0604A1);  // color:white000e
            l1.k k0 = new l1.k(3);
            N1.b(s, q1, v2, 16.0f, e1.y.i, null, 0L, k0, 0.0f, 2, false, 1, 0, null, null, ((p)l0), v1 >> 3 & 14 | 0x30C00, 0xC30, 0x1D5D0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Cc.w0(q0, s, v, 5);
        }
    }

    public static final void s(q q0, r r0, we.a a0, l l0, int v) {
        kotlin.jvm.internal.q.g(r0, "soundType");
        ((p)l0).c0(0xA82C0E77);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).e(r0.ordinal()) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).i(a0) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            ie.m m0 = x.I(((p)l0)) == null ? new ie.m(-1, -1) : Bc.h.d(r0);
            q q1 = r0.a.a(q0, new a0(0, 0, null, a0, true));
            String s = H0.e.Y(((p)l0), ((Number)m0.b).intValue());
            c1.n(q1, ((Integer)m0.a), s, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x6000, 0, 0x7FE8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.e(q0, r0, a0, v, 17);
        }
    }

    public static final void t(q q0, String s, float f, l l0, int v, int v1) {
        ((p)l0).c0(0x300415BB);
        int v2 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (((p)l0).d(f) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if((v1 & 4) != 0) {
                f = 4.0f;
            }
            q q1 = androidx.compose.foundation.q.f(n.o(q0, T.e.b(f)), e0.T(((p)l0), 0x7F060161), y0.M.a);  // color:gray601s
            a.u(androidx.compose.foundation.q.i(0.5f, e0.T(((p)l0), 0x7F0604AE), q1, T.e.b(f)), s, null, null, 0x7F080788, ((p)l0), v2 & 0x70 | 0x36180, 8);  // color:white120e
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new v3(q0, s, f, v, v1, 2);
        }
    }

    public static final void u(q q0, String s, String s1, N0.k k0, int v, l l0, int v1, int v2) {
        N0.k k1;
        p p0 = (p)l0;
        p0.c0(0x1A01EF14);
        int v3 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
            k1 = k0;
        }
        else if((v1 & 0xC00) == 0) {
            k1 = k0;
            v3 |= (p0.g(k1) ? 0x800 : 0x400);
        }
        else {
            k1 = k0;
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.h(true) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v3 |= (p0.e(v) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v3 & 1, (74899 & v3) != 74898)) {
            N0.k k2 = (v2 & 8) == 0 ? k1 : N0.j.c;
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, j.d);
            p0.a0(-1369220987);
            q q2 = androidx.compose.foundation.layout.d.u(r0.n.a, 3);
            q q3 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, d.e);
            androidx.compose.foundation.q.c(I.Q(v, p0, v3 >> 15 & 14), s1, q3, null, null, 0.0f, null, p0, v3 >> 3 & 0x70, 120);
            p0.p(false);
            j5.n.b(s, s1, androidx.compose.foundation.layout.d.c, null, k2, null, p0, v3 << 9 & 0x380000 | (v3 >> 3 & 0x70 | (v3 >> 3 & 14 | 0x180)), 0xFB8);
            p0.p(true);
            k1 = k2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b3(q0, s, s1, k1, v, v1, v2);
        }
    }

    public static final Object v(BitmapDrawable bitmapDrawable0, oe.c c0) {
        rd.p0 p00;
        if(c0 instanceof rd.p0) {
            p00 = (rd.p0)c0;
            int v = p00.w;
            if((v & 0x80000000) == 0) {
                p00 = new rd.p0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                p00.w = v ^ 0x80000000;
            }
        }
        else {
            p00 = new rd.p0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = p00.r;
        ne.a a0 = ne.a.a;
        switch(p00.w) {
            case 0: {
                n.D(object0);
                if(bitmapDrawable0 == null) {
                    return new y0.s(y0.s.f);
                }
                q0 q00 = new q0(bitmapDrawable0, null);
                p00.w = 1;
                object0 = BuildersKt.withContext(Dispatchers.getDefault(), q00, p00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((m4.g)object0) != null) {
            float[] arr_f = ((m4.g)object0).b();
            float f = arr_f[0];
            float f1 = 0.25f;
            if(Float.compare(40.0f, f) <= 0 && f <= 195.0f) {
                float f2 = arr_f[2];
                if(f2 >= 0.25f) {
                    f1 = f2;
                }
                if(f1 > 0.45f) {
                    f1 = 0.45f;
                }
                arr_f[2] = f1;
                return new y0.s(y0.M.c(S1.c.a(arr_f)));
            }
            float f3 = arr_f[2];
            if(f3 >= 0.25f) {
                f1 = f3;
            }
            if(f1 > 0.6f) {
                f1 = 0.6f;
            }
            arr_f[2] = f1;
            return new y0.s(y0.M.c(S1.c.a(arr_f)));
        }
        return new y0.s(y0.s.f);
    }

    public static final Object w(Context context0, String s, oe.c c0) {
        r0 r00;
        if(c0 instanceof r0) {
            r00 = (r0)c0;
            int v = r00.w;
            if((v & 0x80000000) == 0) {
                r00 = new r0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                r00.w = v ^ 0x80000000;
            }
        }
        else {
            r00 = new r0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = r00.r;
        ne.a a0 = ne.a.a;
        switch(r00.w) {
            case 0: {
                n.D(object0);
                i5.e e0 = i5.a.a(context0);
                ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(context0);
                imageRequest$Builder0.c = s;
                imageRequest$Builder0.n = Boolean.FALSE;
                t5.j j0 = imageRequest$Builder0.a();
                r00.w = 1;
                object0 = ((i5.n)e0).c(j0, r00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Drawable drawable0 = ((t5.k)object0).a();
        return drawable0 instanceof BitmapDrawable ? ((BitmapDrawable)drawable0) : null;
    }

    public static final a1.U x(l l0) {
        return new a1.U(0L, 0L, null, null, 0L, new y0.P(e0.T(l0, 0x7F060157), 2), 0, 0L, 0xFFDFFF);  // color:gray400e
    }

    public static final DjMalrangPlayerPageData y(PlayableData playableData0, boolean z) {
        List list0 = playableData0.a.getAlbumImgs();
        if(list0 == null) {
            throw new NullPointerException();
        }
        List list1 = je.p.i0(list0);
        return list1 == null || list1.size() < 2 ? new DjMalrangPlayerPageData(e.k.z(playableData0.n.toString()), playableData0.h, playableData0.i, playableData0.k, playableData0.l, z) : new DjMalrangPlayerPageData(list1, playableData0.h, playableData0.i, playableData0.k, playableData0.l, z);
    }
}

