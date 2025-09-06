package com.melon.ui.playermusic;

import Ac.Z1;
import Ac.g1;
import Ac.h1;
import Ac.i1;
import Bd.e;
import Cc.c1;
import Cc.e0;
import Cc.n3;
import F.S;
import F.X;
import F.Y;
import G.f;
import N0.M;
import N0.g0;
import P0.i;
import Q0.k0;
import Tf.o;
import X0.n;
import ad.T;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.SpecialBgVideo;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.playlist.interfaces.PlayableData;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;
import r1.c;
import td.h;
import wc.u;
import we.a;
import we.k;
import x1.j;
import x1.m;
import y0.s;

public abstract class l {
    public static final void a(a a0, k k0, k k1, boolean z, boolean z1, a a1, Album bgType$Album0, androidx.compose.runtime.l l0, int v) {
        j j1;
        b0 b09;
        m m1;
        FillElement fillElement1;
        b0 b06;
        b0 b05;
        b0 b04;
        q.g(a0, "getAlbumImageTopMargin");
        q.g(k0, "getAlbumImageSizePx");
        q.g(k1, "getAlbumShadowSizePx");
        q.g(a1, "transformationPositionProvider");
        q.g(bgType$Album0, "imageType");
        p p0 = (p)l0;
        p0.c0(1415890849);
        int v1 = v | (p0.i(a0) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80) | (p0.h(z) ? 0x800 : 0x400) | (p0.h(z1) ? 0x4000 : 0x2000) | (p0.i(a1) ? 0x800000 : 0x400000) | (p0.i(bgType$Album0) ? 0x20000000 : 0x10000000);
        int v2 = 1;
        if(p0.Q(v1 & 1, (306783379 & v1) != 306783378)) {
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(new r1.l(0L));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(0);
                p0.l0(b01);
            }
            b0 b02 = p0.N();
            if(b02 == v3) {
                b02 = w.s(0);
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v3) {
                b03 = w.s(0);
                p0.l0(b03);
            }
            FillElement fillElement0 = d.c;
            if((v1 & 0x380) != 0x100) {
                v2 = 0;
            }
            T t0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0) | v2) != 0 || t0 == v3) {
                b05 = b01;
                b04 = b03;
                b06 = b02;
                fillElement1 = fillElement0;
                T t1 = new T(b00, k0, b04, a0, b06, k1, b05, 2);
                p0.l0(t1);
                t0 = t1;
            }
            else {
                b04 = b03;
                b05 = b01;
                b06 = b02;
                fillElement1 = fillElement0;
            }
            r0.q q0 = androidx.compose.ui.layout.a.f(fillElement1, t0);
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            c c0 = (c)p0.k(k0.h);
            x1.q q1 = p0.N();
            if(q1 == v3) {
                q1 = l1.w(c0, p0);
            }
            j j0 = p0.N();
            if(j0 == v3) {
                j0 = l1.u(p0);
            }
            b0 b07 = p0.N();
            if(b07 == v3) {
                b07 = w.s(Boolean.FALSE);
                p0.l0(b07);
            }
            m m0 = p0.N();
            if(m0 == v3) {
                m0 = l1.v(j0, p0);
            }
            b0 b08 = p0.N();
            if(b08 == v3) {
                b08 = w.r(H.a, V.c);
                p0.l0(b08);
            }
            boolean z2 = p0.i(q1);
            boolean z3 = p0.e(0x101);
            g1 g10 = p0.N();
            if(z2 || z3 || g10 == v3) {
                g10 = new g1(b08, q1, m0, 15, b07);
                m1 = m0;
                b09 = b07;
                p0.l0(g10);
            }
            else {
                m1 = m0;
                b09 = b07;
            }
            h1 h10 = p0.N();
            if(h10 == v3) {
                j1 = j0;
                h10 = new h1(b09, m1, 15);
                p0.l0(h10);
            }
            else {
                j1 = j0;
            }
            boolean z4 = p0.i(q1);
            i1 i10 = p0.N();
            if(z4 || i10 == v3) {
                i10 = new i1(q1, 15);
                p0.l0(i10);
            }
            g0.a(n.c(q0, false, i10), m0.c.e(1200550679, p0, new O.q(b08, j1, h10, b05, b06, b04, a1, ((Context)object0), bgType$Album0, z1, z)), g10, p0, 0x30);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new h(a0, k0, k1, z, z1, a1, bgType$Album0, v);
        }
    }

    public static final void b(boolean z, boolean z1, SpecialImage bgType$SpecialImage0, k k0, androidx.compose.runtime.l l0, int v) {
        q.g(bgType$SpecialImage0, "imageType");
        p p0 = (p)l0;
        p0.c0(0x1E77E76F);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.h(z1) ? 0x20 : 16) | (p0.i(bgType$SpecialImage0) ? 0x4000 : 0x2000) | (p0.i(k0) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (v1 & 74899) != 74898)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            FillElement fillElement0 = d.c;
            boolean z2 = p0.i(context0);
            boolean z3 = p0.i(bgType$SpecialImage0);
            m9.l l1 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(z2 || z3 || l1 == v2) {
                l1 = new m9.l(12, context0, bgType$SpecialImage0);
                p0.l0(l1);
            }
            r0.q q0 = n.c(fillElement0, false, l1);
            M m0 = M.p.d(r0.d.a, false);
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
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, P0.j.d);
            n3 n30 = c1.W(p0, 0);
            j5.n.b(((t5.j)((O0)n30.c).getValue()), null, fillElement0, null, N0.j.b, null, p0, 0x1801B0, 0xFB8);
            Boolean boolean0 = Boolean.valueOf(z1);
            Boolean boolean1 = Boolean.valueOf(z);
            boolean z4 = p0.i(bgType$SpecialImage0);
            boolean z5 = p0.i(n30);
            boolean z6 = p0.i(context0);
            com.melon.ui.playermusic.i i1 = p0.N();
            if((z4 | z5 | z6 | ((v1 & 0x70) == 0x20 ? 1 : 0) | ((v1 & 0x70000) == 0x20000 ? 1 : 0) | ((v1 & 14) == 4 ? 1 : 0)) != 0 || i1 == v2) {
                com.melon.ui.playermusic.i i2 = new com.melon.ui.playermusic.i(bgType$SpecialImage0, n30, context0, z1, k0, z, null);
                p0.l0(i2);
                i1 = i2;
            }
            J.e(bgType$SpecialImage0, boolean0, boolean1, i1, p0);
            r0.q q2 = androidx.compose.foundation.q.e(d.c(d.f(r0.n.a, 1.0f), 0.15f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06016B)), new s(s.f)}), 0.0f, 0.0f, 14), null, 6);  // color:gray900e_40
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.b), p0, 0);
            r0.q q3 = androidx.compose.foundation.q.e(d.c(d.f(r0.n.a, 1.0f), 0.5f), u.f(e.k.A(new s[]{new s(s.f), new s(e0.T(p0, 0x7F06016C))}), 0.0f, 0.0f, 14), null, 6);  // color:gray900e_80
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.h), p0, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Mc.j(z, z1, bgType$SpecialImage0, k0, v, 6);
        }
    }

    public static final void c(a a0, b1 b10, SpecialVideo bgType$SpecialVideo0, k k0, androidx.compose.runtime.l l0, int v) {
        SinglePlayer singlePlayer1;
        b0 b02;
        int v3;
        com.melon.ui.playermusic.j j0;
        q.g(b10, "isResumed");
        q.g(bgType$SpecialVideo0, "videoType");
        q.g(k0, "onVideoShow");
        p p0 = (p)l0;
        p0.c0(-765770135);
        int v1 = v | (p0.g(b10) ? 0x20 : 16) | (p0.g(bgType$SpecialVideo0) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            E e0 = p0.N();
            if(e0 == v2) {
                e0 = w.i(new Z1(b00, b10, b01, 25));
                p0.l0(e0);
            }
            SinglePlayer singlePlayer0 = p0.N();
            if(singlePlayer0 == v2) {
                singlePlayer0 = new SinglePlayer(((Context)object0));
                singlePlayer0.setCallback(new com.melon.ui.playermusic.k(b01));
                singlePlayer0.setVolume(0.0f);
                p0.l0(singlePlayer0);
            }
            boolean z = p0.i(singlePlayer0);
            Vc.E e1 = p0.N();
            if(z || e1 == v2) {
                e1 = new Vc.E(singlePlayer0, 3);
                p0.l0(e1);
            }
            J.b(H.a, e1, p0);
            boolean z1 = p0.i(singlePlayer0);
            Object object1 = p0.N();
            if(z1 || (v1 & 0x380) == 0x100 || object1 == v2) {
                v3 = v1 & 0x380;
                j0 = new com.melon.ui.playermusic.j(b01, singlePlayer0, b00, a0, bgType$SpecialVideo0, null);
                b02 = b01;
                singlePlayer1 = singlePlayer0;
                p0.l0(j0);
            }
            else {
                j0 = object1;
                v3 = v1 & 0x380;
                b02 = b01;
                singlePlayer1 = singlePlayer0;
            }
            J.d(p0, bgType$SpecialVideo0, j0);
            FillElement fillElement0 = d.c;
            boolean z2 = p0.i(((Context)object0));
            m9.l l1 = p0.N();
            if(z2 || v3 == 0x100 || l1 == v2) {
                l1 = new m9.l(13, ((Context)object0), bgType$SpecialVideo0);
                p0.l0(l1);
            }
            r0.q q0 = n.c(fillElement0, false, l1);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
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
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, P0.j.d);
            if(((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(0xCEABA067);
                sd.j j1 = p0.N();
                if(j1 == v2) {
                    j1 = new sd.j(1);
                    p0.l0(j1);
                }
                boolean z3 = p0.i(singlePlayer1);
                Vc.E e2 = p0.N();
                if(z3 || e2 == v2) {
                    e2 = new Vc.E(singlePlayer1, 4);
                    p0.l0(e2);
                }
                androidx.compose.ui.viewinterop.a.a(j1, fillElement0, e2, p0, 54, 0);
                if(((Boolean)e0.getValue()).booleanValue()) {
                    singlePlayer1.start();
                    k0.invoke(bgType$SpecialVideo0);
                }
                else {
                    singlePlayer1.pause();
                }
            }
            else {
                p0.a0(-841037197);
            }
            p0.p(false);
            boolean z4 = ((Boolean)b02.getValue()).booleanValue();
            Y y0 = S.c(f.r(1000, 0, null, 6), 2);
            m0.b b0 = m0.c.e(348868039, p0, new e(bgType$SpecialVideo0, 23));
            androidx.compose.animation.b.d(!z4, null, X.b, y0, null, b0, p0, 0x30C00, 18);
            r0.q q2 = androidx.compose.foundation.q.e(d.c(d.f(r0.n.a, 1.0f), 0.15f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06016B)), new s(s.f)}), 0.0f, 0.0f, 14), null, 6);  // color:gray900e_40
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, r0.d.b), p0, 0);
            r0.q q3 = androidx.compose.foundation.q.e(d.c(d.f(r0.n.a, 1.0f), 0.5f), u.f(e.k.A(new s[]{new s(s.f), new s(e0.T(p0, 0x7F06016C))}), 0.0f, 0.0f, 14), null, 6);  // color:gray900e_80
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.h), p0, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.i(a0, b10, bgType$SpecialVideo0, k0, v, 0);
        }
    }

    public static final BgType d(PlayableData playableData0) {
        SpecialBgVideo specialBgVideo0 = playableData0.o;
        String s = playableData0.i;
        String s1 = playableData0.h;
        String s2 = null;
        String s3 = specialBgVideo0 == null ? null : "";
        if(s3 != null && !o.H0(s3) && l.e()) {
            if(s1 == null) {
                s1 = "";
            }
            if(s == null) {
                s = "";
            }
            if(specialBgVideo0 != null) {
                s2 = "";
            }
            return new SpecialVideo(s1, s, s3, s2);
        }
        ArrayList arrayList0 = new ArrayList();
        Iterator iterator0 = playableData0.r.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
        }
        Iterable iterable0 = je.p.J0(arrayList0, new td.j());  // 初始化器: Ljava/lang/Object;-><init>()V
        ArrayList arrayList1 = new ArrayList();
        Iterator iterator1 = iterable0.iterator();
        while(iterator1.hasNext()) {
            iterator1.next();
            arrayList1.add("");
        }
        if(!arrayList1.isEmpty() && NetUtils.isConnected()) {
            if(s1 == null) {
                s1 = "";
            }
            if(s == null) {
                s = "";
            }
            return new SpecialImage(arrayList1, s1, s);
        }
        List list0 = playableData0.a.getAlbumImgs();
        if(list0 != null) {
            s2 = je.p.i0(list0);
        }
        if(s2 == null || ((List)s2).size() < 2) {
            s2 = e.k.z(playableData0.n.toString());
        }
        if(s1 == null) {
            s1 = "";
        }
        if(s == null) {
            s = "";
        }
        return new Album(s1, s, ((List)s2));
    }

    // 去混淆评级： 低(23)
    public static final boolean e() {
        if(MelonSettingInfo.isLowMemoryMode()) {
            return false;
        }
        return MelonSettingInfo.getUseWifiForBgAutoPlay() ? true : NetUtils.checkDataNetwork() == 1 && MelonSettingInfo.getUseDataForBgAutoPlay();
    }

    public static final String f(Context context0, BgType bgType0) {
        String s2;
        String s1;
        String s;
        if(bgType0 instanceof Album) {
            s = ((Album)bgType0).b;
            s1 = ((Album)bgType0).a;
            s2 = "앨범아트 표시됨";
            q.f("앨범아트 표시됨", "getString(...)");
        }
        else if(bgType0 instanceof SpecialVideo) {
            s = ((SpecialVideo)bgType0).b;
            s1 = ((SpecialVideo)bgType0).a;
            s2 = "스페셜 영상 재생중";
            q.f("스페셜 영상 재생중", "getString(...)");
        }
        else if(bgType0 instanceof SpecialImage) {
            s = ((SpecialImage)bgType0).b;
            s1 = ((SpecialImage)bgType0).a;
            s2 = "스페셜 포토 표시됨";
            q.f("스페셜 포토 표시됨", "getString(...)");
        }
        else {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("아티스트");
        stringBuilder0.append(": ");
        stringBuilder0.append(s);
        String s3 = A7.d.n(stringBuilder0, ", ", s1, " ", s2);
        q.f(s3, "toString(...)");
        return s3;
    }

    // 去混淆评级： 低(20)
    public static final boolean g(BgType bgType0) {
        return bgType0 instanceof SpecialVideo || bgType0 instanceof SpecialImage;
    }
}

