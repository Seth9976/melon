package qd;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.z2;
import H0.e;
import O.F;
import Qc.s;
import Rc.w;
import X0.n;
import android.text.Html;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import cd.W1;
import com.iloen.melon.playback.playlist.db.d;
import com.iloen.melon.utils.log.LogU;
import ed.I0;
import java.util.List;
import java.util.regex.Pattern;
import m0.b;
import m0.c;
import r0.q;
import we.k;

public abstract class h {
    public static final LogU a;

    static {
        h.a = new LogU("CollapsedLyricComposable");
    }

    public static final void a(q q0, d9.h h0, boolean z, k k0, l l0, int v) {
        kotlin.jvm.internal.q.g(h0, "lyricViewModel");
        kotlin.jvm.internal.q.g(k0, "onEvent");
        ((p)l0).c0(0x90354BEE);
        int v1 = (((p)l0).g(q0) ? 4 : 2) | v | (((p)l0).i(h0) ? 0x20 : 16) | (((p)l0).h(z) ? 0x100 : 0x80) | (((p)l0).i(k0) ? 0x800 : 0x400);
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            String s = e.Y(((p)l0), 0x7F130B6B);  // string:talkback_lyric_detail "전체 가사보기"
            boolean z1 = ((p)l0).g(s);
            d d0 = ((p)l0).N();
            if(z1 || d0 == androidx.compose.runtime.k.a) {
                d0 = new d(s, 17);
                ((p)l0).l0(d0);
            }
            q q1 = n.b(q0, d0);
            b b0 = c.e(0x7E8B02D8, ((p)l0), new W1(h0, z, k0, 1));
            M.c.a(q1, r0.d.e, false, b0, ((p)l0), 0xC30, 4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new w(q0, h0, z, k0, v);
        }
    }

    public static final void b(String s, boolean z, boolean z1, l l0, int v, int v1) {
        int v5;
        boolean z2;
        int v3;
        ((p)l0).c0(0x5228F1D);
        int v2 = v | (((p)l0).g(s) ? 4 : 2);
        if((v1 & 2) == 0) {
            z2 = z;
            v3 = v2 | (((p)l0).h(z2) ? 0x20 : 16);
        }
        else {
            v3 = v2 | 0x30;
            z2 = z;
        }
        int v4 = v3 | (((p)l0).h(z1) ? 0x100 : 0x80);
        if(((p)l0).Q(v4 & 1, (v4 & 0x93) != 0x92)) {
            if((v1 & 2) != 0) {
                z2 = false;
            }
            if(z1) {
                v5 = 0x7F0604AF;  // color:white160e_support_high_contrast
            }
            else {
                v5 = z2 ? 0x7F0604A1 : 0x7F0604B4;  // color:white000e
            }
            q q0 = androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f);
            Pattern pattern0 = Pattern.compile("\n");
            kotlin.jvm.internal.q.f(pattern0, "compile(...)");
            kotlin.jvm.internal.q.g(s, "input");
            String s1 = pattern0.matcher(s).replaceAll("<br>");
            kotlin.jvm.internal.q.f(s1, "replaceAll(...)");
            String s2 = Html.fromHtml(s1, 0).toString();
            long v6 = e0.T(((p)l0), v5);
            float f = E9.h.t(((p)l0), 0x7F07040F);  // dimen:player_lyric_view_collapsed_single_lyric_height
            N1.b(s2, q0, v6, 15.0f, null, null, 0L, new l1.k(3), f, 0, false, 0, 0, null, null, ((p)l0), 0xC30, 0, 0x1F9F0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new qd.b(v, s, v1, z2, z1);
        }
    }

    public static final void c(q q0, List list0, F f0, Integer integer0, long v, boolean z, l l0, int v1) {
        ((p)l0).c0(0xD16039F8);
        int v2 = ((p)l0).g(q0) ? 4 : 2;
        int v3 = ((p)l0).i(list0) ? 0x20 : 16;
        int v4 = ((p)l0).g(f0) ? 0x100 : 0x80;
        int v5 = ((p)l0).g(integer0) ? 0x800 : 0x400;
        int v6 = ((p)l0).f(v) ? 0x4000 : 0x2000;
        int v7 = (((p)l0).h(z) ? 0x20000 : 0x10000) | (v1 | v2 | v3 | v4 | v5 | v6);
        int v8 = 0;
        if(((p)l0).Q(v7 & 1, (74899 & v7) != 74898)) {
            boolean z1 = ((p)l0).i(list0);
            if((v7 & 0x1C00) == 0x800) {
                v8 = 1;
            }
            I0 i00 = ((p)l0).N();
            if((z1 | (0x70000 & v7) == 0x20000 | ((0xE000 & v7) == 0x4000 ? 1 : 0) | v8) != 0 || i00 == androidx.compose.runtime.k.a) {
                I0 i01 = new I0(list0, z, v, integer0);
                ((p)l0).l0(i01);
                i00 = i01;
            }
            c1.o(q0, f0, null, false, null, null, null, false, i00, ((p)l0), v7 & 14 | v7 >> 3 & 0x70, 0xFC);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new a(q0, list0, f0, integer0, v, z, v1);
        }
    }

    public static final void d(q q0, List list0, boolean z, l l0, int v) {
        ((p)l0).c0(0xEE2B8A15);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).i(list0) ? 0x20 : 16) | (((p)l0).h(z) ? 0x100 : 0x80);
        boolean z1 = false;
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            boolean z2 = ((p)l0).i(list0);
            if((v1 & 0x380) == 0x100) {
                z1 = true;
            }
            s s0 = ((p)l0).N();
            if(z2 || z1 || s0 == androidx.compose.runtime.k.a) {
                s0 = new s(list0, z, 9);
                ((p)l0).l0(s0);
            }
            c1.o(q0, null, null, false, null, null, null, false, s0, ((p)l0), v1 & 14, 0xFE);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z2(v, 9, q0, list0, z);
        }
    }
}

