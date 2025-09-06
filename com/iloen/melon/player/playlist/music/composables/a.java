package com.iloen.melon.player.playlist.music.composables;

import Cc.N1;
import Cc.e0;
import H0.e;
import Ib.b;
import M.j;
import M.n0;
import M.p0;
import M.v;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import U4.x;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.c;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt;
import ie.H;
import kotlin.jvm.internal.q;
import oc.c0;
import r0.d;
import r0.g;
import r0.n;
import we.o;

public final class a implements o {
    public final String a;
    public final String b;
    public final boolean c;
    public final b d;
    public final we.a e;
    public final boolean f;
    public final we.a g;
    public final c0 h;
    public final we.a i;
    public final we.a j;
    public final boolean k;
    public final we.a l;

    public a(String s, String s1, boolean z, b b0, we.a a0, boolean z1, we.a a1, c0 c00, we.a a2, we.a a3, boolean z2, we.a a4) {
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = b0;
        this.e = a0;
        this.f = z1;
        this.g = a1;
        this.h = c00;
        this.i = a2;
        this.j = a3;
        this.k = z2;
        this.l = a4;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        n n1;
        p p1;
        int v = (int)(((Integer)object2));
        g g0 = d.m;
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        String s = "";
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            String s1 = Float.compare(((c)(((v)object0))).c(), 210.0f) <= 0 ? "" : this.a;
            if(Float.compare(((c)(((v)object0))).c(), 300.0f) > 0) {
                s = this.b;
            }
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            p0 p00 = n0.a(j.a, d.k, p0, 0x30);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, fillElement0);
            k.y.getClass();
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
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q0, h3);
            r0.q q1 = androidx.compose.foundation.layout.d.t(new LayoutWeightElement(1.0f, true), 3);
            M m0 = M.p.d(d.a, false);
            int v2 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            w.x(p0, q2, h3);
            c0 c00 = this.h;
            String s2 = c00.name();
            boolean z = q.b(s2, "SECTION_STEP1");
            we.a a0 = this.j;
            n n0 = n.a;
            if(z) {
                p0.a0(0x4C80071B);
                r0.q q3 = r0.a.a(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(fillElement0, 20.0f, 0.0f, 20.0f, 0.0f, 10), 2), g0, 2), new com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, a0));
                long v3 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(e.Y(p0, 0x7F130A3E), q3, v3, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF8);  // string:smartplaylist_section_start_description "구간선택 첫 번째 곡을 선택하세요."
                p1 = p0;
                p1.p(false);
                n1 = n0;
            }
            else if(q.b(s2, "SECTION_STEP2")) {
                p0.a0(0x4C8C0B9D);
                r0.q q4 = r0.a.a(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(fillElement0, 20.0f, 0.0f, 20.0f, 0.0f, 10), 2), g0, 2), new com.iloen.melon.player.playlist.music.composables.MusicPlaylistHeaderKt.MusicPlaylistHeader.lambda.8.lambda.7.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.2(true, null, 0, a0));
                long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(e.Y(p0, 0x7F130A3D), q4, v4, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF8);  // string:smartplaylist_section_end_description "구간선택 마지막 곡을 선택하세요."
                p1 = p0;
                p1.p(false);
                n1 = n0;
            }
            else {
                p0.a0(1284990770);
                r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 14.0f, 0.0f, 10.0f, 5);
                n1 = n0;
                r0.q q6 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.d);
                we.a a1 = this.l;
                boolean z1 = p0.g(a1);
                com.iloen.melon.player.playlist.common.g g1 = p0.N();
                if(z1 || g1 == androidx.compose.runtime.k.a) {
                    g1 = new com.iloen.melon.player.playlist.common.g(4, a1);
                    p0.l0(g1);
                }
                PlaylistCommonHeaderComposableKt.AllSelectButton(q6, this.k, s1, null, g1, p0, 0, 8);
                p1 = p0;
                p1.p(false);
            }
            p1.p(true);
            if(this.c) {
                p1.a0(0x2DB3EFE5);
                PlaylistCommonHeaderComposableKt.OfflineButton(androidx.compose.foundation.layout.a.n(n1, 0.0f, 14.0f, 0.0f, 10.0f, 5), this.d, this.e, p1, 6, 0);
                x.z(n1, 18.0f, p1, false);
            }
            else {
                p1.a0(0x2D69A011);
                p1.p(false);
            }
            if(this.f) {
                p1.a0(767098033);
                PlaylistCommonHeaderComposableKt.SortButton(androidx.compose.foundation.layout.a.n(n1, 0.0f, 14.0f, 0.0f, 10.0f, 5), s, this.g, p1, 6, 0);
            }
            else {
                p1.a0(767327650);
                PlaylistCommonHeaderComposableKt.SectionSelectButton(c00, this.i, a0, p1, 0);
            }
            p1.p(false);
            x.z(n1, 20.0f, p1, true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

