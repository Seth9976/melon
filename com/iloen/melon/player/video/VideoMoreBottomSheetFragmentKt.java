package com.iloen.melon.player.video;

import Cc.H3;
import Cc.c1;
import M.c;
import M.j0;
import M.j;
import M.w;
import M.y;
import P0.i;
import Q0.N;
import U4.x;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.Metadata;
import r0.a;
import r0.n;
import r0.q;
import we.k;
import yd.h;
import zd.Q;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002¨\u0006\u0002²\u0006\u000E\u0010\u0001\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002"}, d2 = {"", "contentHeight", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMoreBottomSheetFragmentKt {
    public static final void a(int v, Q q0, MelonBottomSheetItem melonBottomSheetItem0, k k0, l l0, int v1) {
        ((p)l0).c0(-2030321880);
        int v2 = (v1 & 6) == 0 ? (((p)l0).e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((p)l0).i(q0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((p)l0).g(melonBottomSheetItem0) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x800 : 0x400);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x493) != 1170)) {
            h.d(q0, melonBottomSheetItem0, v, a.a(d.h(d.f(n.a, 1.0f), 52.0f), new VideoMoreBottomSheetFragmentKt.BodyLayout..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, melonBottomSheetItem0, k0, v, q0)), k0, ((p)l0), v2 >> 3 & 0x7E | v2 << 6 & 0x380 | v2 << 3 & 0xE000);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new H3(v, v1, 15, k0, q0, melonBottomSheetItem0);
        }
    }

    public static final void access$BodyLayout(int v, Q q0, MelonBottomSheetItem melonBottomSheetItem0, k k0, l l0, int v1) {
        VideoMoreBottomSheetFragmentKt.a(v, q0, melonBottomSheetItem0, k0, l0, v1);
    }

    public static final void b(Q q0, int v, k k0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(-784410440);
        int v2 = (v1 & 6) == 0 ? (p0.i(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = x.d(0, p0);
            }
            n n0 = n.a;
            q q1 = d.f(n0, 1.0f);
            o0 o00 = p0.N();
            if(o00 == v3) {
                o00 = new o0(b00, 4);
                p0.l0(o00);
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, o00);
            y y0 = w.a(j.e, r0.d.n, p0, 54);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q3, P0.j.d);
            ArrayList arrayList0 = q0.c();
            q q4 = androidx.compose.ui.input.nestedscroll.a.a(d.f(n0, 1.0f), N.u(p0), null);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            boolean z = p0.i(q0);
            boolean z1 = p0.i(arrayList0);
            com.iloen.melon.player.video.n n1 = p0.N();
            if(((v2 & 0x380) == 0x100 | z | z1) != 0 || n1 == v3) {
                n1 = new com.iloen.melon.player.video.n(arrayList0, q0, k0, 3);
                p0.l0(n1);
            }
            c1.o(q4, null, j00, false, null, null, null, false, n1, p0, 0x180, 0xFA);
            if(((Number)b00.getValue()).intValue() > v) {
                p0.a0(0x243D36D);
                c.d(p0, new LayoutWeightElement(1.0f, true));
            }
            else {
                p0.a0(0xC9B3A0);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(q0, v, k0, v1, 6);
        }
    }
}

