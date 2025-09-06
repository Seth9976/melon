package d5;

import Ac.l1;
import Cc.N1;
import Cc.b;
import Cc.c1;
import Cc.e0;
import Cc.w3;
import Hf.x;
import M.j0;
import M.p0;
import M.y;
import O.F;
import P0.j;
import P0.k;
import Pe.L;
import Pe.S;
import Pe.m;
import Q0.C0;
import Q0.N;
import Q0.k0;
import Tf.v;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.D0;
import androidx.compose.foundation.layout.a;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.t;
import c2.M;
import cd.V2;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.B1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.MusicWaveOpen;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MusicWave;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.popup.s;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.playlist.mixup.DjMalrangInfo;
import d3.g;
import e1.u;
import ed.w0;
import gd.H;
import gd.I3;
import gd.I;
import gd.J0;
import gd.J3;
import gd.L3;
import gd.M0;
import gd.M3;
import gd.N3;
import gd.O;
import h7.u0;
import ie.o;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import jf.r;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import qf.c;
import qf.d;
import qf.e;
import r1.f;
import vd.C;
import vd.D;
import y0.Q;
import z6.h;
import z6.i;

public abstract class n {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    public static void A(View view0, i i0) {
        ElevationOverlayProvider elevationOverlayProvider0 = i0.a.b;
        if(elevationOverlayProvider0 != null && elevationOverlayProvider0.a) {
            ViewParent viewParent0 = view0.getParent();
            float f = 0.0f;
            while(viewParent0 instanceof View) {
                f += M.e(((View)viewParent0));
                viewParent0 = viewParent0.getParent();
            }
            h h0 = i0.a;
            if(h0.l != f) {
                h0.l = f;
                i0.v();
            }
        }
    }

    public static void B(ViewGroup viewGroup0) {
        Drawable drawable0 = viewGroup0.getBackground();
        if(drawable0 instanceof i) {
            n.A(viewGroup0, ((i)drawable0));
        }
    }

    public static void C(Context context0, boolean z) {
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("pushinfo", 0).edit();
        sharedPreferences$Editor0.putBoolean("REG_ON_SERVER", z);
        sharedPreferences$Editor0.putLong("SEVER_EXPIRE_TIME", System.currentTimeMillis() + 604800000L);
        sharedPreferences$Editor0.apply();
    }

    public static final void D(Object object0) {
        if(object0 instanceof o) {
            throw ((o)object0).a;
        }
    }

    public static c E(e e0) {
        q.g(e0, "shortName");
        String s = e0.b();
        q.f(s, "asString(...)");
        return new c(new d(s, c.c.a, e0));
    }

    public static final void a(l l0, int v) {
        ((p)l0).c0(0x6769F8D1);
        if(((p)l0).Q(v & 1, v != 0)) {
            M.p.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.n(a.n(r0.n.a, 0.0f, 7.0f, 8.0f, 0.0f, 9), 3.0f), e0.T(((p)l0), 0x7F060159), T.e.a), ((p)l0), 0);  // color:gray400s_support_high_contrast
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new B1(v, 27);
        }
    }

    public static final void b(String s, we.a a0, we.a a1, we.a a2, l l0, int v) {
        float f1;
        p p0 = (p)l0;
        p0.c0(0x1552A0ED);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(a1) ? 0x100 : 0x80) | (p0.i(a2) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.j(n0, 0.0f, 440.0f, 1), 270.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, m0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.f(n.o(n0, T.e.b(12.0f)), e0.T(p0, 0x7F0604AB), y0.M.a);  // color:white001s
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            r1.c c0 = (r1.c)p0.k(k0.h);
            b0 b00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(b00 == v4) {
                b00 = w.s(new f(0.0f));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v4) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            boolean z = ((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 1;
            float f = !z || !((Boolean)b01.getValue()).booleanValue() ? 0.0f : 7.0f;
            b0 b02 = p0.N();
            if(b02 == v4) {
                b02 = w.s(new f(15.0f));
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v4) {
                b03 = w.s(new r1.l(0L));
                p0.l0(b03);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            boolean z1 = p0.g(c0);
            boolean z2 = p0.d(((float)(z ? 396 : 0x100)));
            D d0 = p0.N();
            if(z1 || z2 || d0 == v4) {
                f1 = (float)(z ? 396 : 0x100);
                d0 = new D(c0, f1, b03, b00, b01, b02, null);
                p0.l0(d0);
            }
            else {
                f1 = (float)(z ? 396 : 0x100);
            }
            J.d(p0, boolean0, d0);
            w.a(D0.a.a(null), m0.c.e(-1529109847, p0, new C(f, f1, a1, a0, b03, s, b02, a2, b01)), p0, 56);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.i(s, a0, a1, a2, v);
        }
    }

    public static final void c(int v, l l0, String s, r0.q q0) {
        p p0 = (p)l0;
        p0.c0(0xA284D656);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(q0) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, p00, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q1, h3);
            n.a(p0, 0);
            N0.M m0 = M.p.d(r0.d.d, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q2, h3);
            N1.b(s, null, e0.T(p0, 0x7F060163), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:gray700s
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.h(s, q0, v, 5);
        }
    }

    public static final void d(H h0, we.k k0, l l0, int v) {
        ((p)l0).c0(0x4B20B635);
        int v1 = (((p)l0).g(h0) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.d.h(a.l(r0.a.a(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), new Ac.l(h0, k0, 16)), E9.h.t(((p)l0), 0x7F0700AC), 0.0f, 2), 88.0f);  // dimen:context_list_padding_left_right
            String s = h0.b;
            String s1 = h0.g;
            String s2 = h0.c;
            String s3 = h0.e;
            boolean z = h0.f;
            boolean z1 = h0.d;
            String s4 = h0.a;
            String s5 = h0.h;
            gd.l l1 = ((p)l0).N();
            if((((v1 & 14) == 4 ? 1 : 0) | ((v1 & 0x70) == 0x20 ? 1 : 0)) != 0 || l1 == androidx.compose.runtime.k.a) {
                l1 = new gd.l(1, h0, k0);
                ((p)l0).l0(l1);
            }
            w3.l(q0, s1, s, s2, z1, s3, null, z, true, s4, s5, l1, ((p)l0), 0x6180000, 0, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(h0, k0, v, 11);
        }
    }

    public static final void e(I i0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-1980011198);
        int v1 = (p0.g(i0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            float f = E9.h.t(p0, 0x7F0700AC);  // dimen:context_list_padding_left_right
            float f1 = E9.h.t(p0, 0x7F0703F2);  // dimen:new_filter_layout_height
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), f, 8.0f, f, 0.0f, 8), f1);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            q.f("전체 %s명", "getString(...)");
            N1.b(String.format("전체 %s명", Arrays.copyOf(new Object[]{i0.a}, 1)), androidx.compose.foundation.layout.d.u(n0, 3), e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, new l1.k(5), 0.0f, 0, false, 1, 0, null, null, p0, 0xC30, 0xC00, 0x1DDF0);  // color:gray800s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new V2(i0, v, 6);
        }
    }

    public static final void f(int v, l l0, List list0, we.a a0, we.k k0) {
        ((p)l0).c0(0xDFFD6B96);
        int v1 = v | (((p)l0).i(list0) ? 4 : 2) | (((p)l0).i(k0) ? 0x20 : 16) | (((p)l0).i(a0) ? 0x100 : 0x80);
        boolean z = true;
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = O.I.a(0, 0, 3, ((p)l0));
            C0 c00 = N.u(((p)l0));
            boolean z1 = ((p)l0).g(f0);
            O o0 = ((p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x380) == 0x100 || z1 || o0 == v2) {
                o0 = new O(f0, a0, null);
                ((p)l0).l0(o0);
            }
            J.d(((p)l0), ie.H.a, o0);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c(r0.n.a, 1.0f), c00, null);
            j0 j00 = a.c(0.0f, 0.0f, 0.0f, E9.h.t(((p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z2 = ((p)l0).i(list0);
            if((v1 & 0x70) != 0x20) {
                z = false;
            }
            gd.e e0 = ((p)l0).N();
            if(z2 || z || e0 == v2) {
                e0 = new gd.e(list0, 1, k0);
                ((p)l0).l0(e0);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e0, ((p)l0), 0, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new s(list0, k0, a0, v, 1);
        }
    }

    public static final void g(M3 m30, we.k k0, l l0, int v) {
        ((p)l0).c0(0x7581AA7F);
        int v1 = (((p)l0).i(m30) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        boolean z = true;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            int v2 = m30.a;
            q.f("전체", "getString(...)");
            b b0 = new b("전체", "ALL");
            q.f("파워DJ", "getString(...)");
            List list0 = e.k.A(new b[]{b0, new b("파워DJ", "POWERDJ")});
            List list1 = m30.c;
            int v3 = m30.b;
            boolean z1 = ((p)l0).i(m30);
            gd.l l1 = ((p)l0).N();
            V v4 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z1 || l1 == v4) {
                l1 = new gd.l(17, k0, m30);
                ((p)l0).l0(l1);
            }
            if((v1 & 0x70) != 0x20) {
                z = false;
            }
            boolean z2 = ((p)l0).i(m30);
            w0 w00 = ((p)l0).N();
            if(z2 || z || w00 == v4) {
                w00 = new w0(8, k0, m30);
                ((p)l0).l0(w00);
            }
            e0.B(v2, list0, list1, v3, null, l1, w00, ((p)l0), 0, 16);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(m30, k0, v, 21);
        }
    }

    public static final void h(N3 n30, int v, we.k k0, l l0, int v1) {
        ((p)l0).c0(0x115DA31C);
        int v2 = (v1 & 6) == 0 ? (((p)l0).i(n30) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((p)l0).e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            String s = n30.b;
            String s1 = n30.c;
            String s2 = n30.e;
            String s3 = n30.f;
            boolean z = ((p)l0).i(n30);
            I3 i30 = ((p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if(((v2 & 0x380) == 0x100 | z | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || i30 == v3) {
                i30 = new I3(k0, n30, v, 0);
                ((p)l0).l0(i30);
            }
            boolean z1 = ((p)l0).i(n30);
            I3 i31 = ((p)l0).N();
            if(((v2 & 0x380) == 0x100 | z1 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || i31 == v3) {
                i31 = new I3(k0, n30, v, 1);
                ((p)l0).l0(i31);
            }
            boolean z2 = ((p)l0).i(n30);
            I3 i32 = ((p)l0).N();
            if(((v2 & 0x380) == 0x100 | z2 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || i32 == v3) {
                i32 = new I3(k0, n30, v, 2);
                ((p)l0).l0(i32);
            }
            c1.C(s, null, s1, s2, s3, 0.0f, 0.0f, i30, i31, i32, ((p)l0), 0, 0x60);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Nc.p(n30, v, k0, v1, 15);
        }
    }

    public static final void i(int v, l l0, List list0, we.a a0, we.k k0, we.k k1) {
        p p0 = (p)l0;
        p0.c0(0x31B3CBE9);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80) | (p0.i(k1) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            F f0 = O.I.a(0, 0, 3, p0);
            E e0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = w.i(new M0(f0, 11));
                p0.l0(e0);
            }
            E e1 = p0.N();
            if(e1 == v2) {
                e1 = w.i(new M0(f0, 12));
                p0.l0(e1);
            }
            Boolean boolean0 = (Boolean)e0.getValue();
            boolean0.booleanValue();
            Object object0 = e1.getValue();
            ((Boolean)object0).booleanValue();
            J3 j30 = p0.N();
            if((v1 & 0x1C00) == 0x800 || j30 == v2) {
                j30 = new J3(k1, e0, e1, null);
                p0.l0(j30);
            }
            J.f(boolean0, ((Boolean)object0), j30, p0);
            C0 c00 = N.u(p0);
            boolean z = p0.g(f0);
            L3 l30 = p0.N();
            if((v1 & 0x70) == 0x20 || z || l30 == v2) {
                l30 = new L3(f0, a0, null);
                p0.l0(l30);
            }
            J.d(p0, ie.H.a, l30);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c(r0.n.a, 1.0f), c00, null);
            j0 j00 = a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = p0.i(list0);
            gd.e e2 = p0.N();
            if(z1 || (v1 & 0x380) == 0x100 || e2 == v2) {
                e2 = new gd.e(list0, 5, k0);
                p0.l0(e2);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e2, p0, 0, 0xF8);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new J0(list0, a0, k0, k1, v, 2);
        }
    }

    public static final void j(we.k k0, l l0, int v) {
        P0.h h5;
        P0.i i3;
        P0.h h4;
        P0.i i2;
        p p0 = (p)l0;
        p0.c0(-1264893002);
        int v1 = v | (p0.i(k0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, y0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q0, h3);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.q q1 = a.n(r0.n.a, 28.0f, 19.0f, 28.0f, 0.0f, 8);
            r0.n n0 = r0.n.a;
            r0.q q2 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(q1, 23.0f), 1.0f);
            r0.i i1 = r0.d.e;
            N0.M m0 = M.p.d(i1, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            q.f("축하합니다.", "getString(...)");
            N1.b("축하합니다.", null, e0.T(p0, 0x7F06016D), 19.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF2);  // color:gray900s
            p0.p(true);
            r0.q q4 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(a.n(n0, 28.0f, 0.5f, 28.0f, 0.0f, 8), 23.0f), 1.0f);
            N0.M m1 = M.p.d(i1, false);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                i2 = i0;
                p0.l(i2);
            }
            else {
                i2 = i0;
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v4)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v4, p0, v4, h4);
            }
            w.x(p0, q5, h3);
            q.f("멜론DJ에 선정되셨습니다.", "getString(...)");
            N1.b("멜론DJ에 선정되셨습니다.", null, e0.T(p0, 0x7F06016D), 19.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF2);  // color:gray900s
            p0.p(true);
            r0.q q6 = androidx.compose.foundation.layout.d.f(a.n(n0, 28.0f, 27.0f, 28.0f, 0.0f, 8), 1.0f);
            N0.M m2 = M.p.d(i1, false);
            int v5 = p0.P;
            i0 i03 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                i3 = i2;
                p0.l(i3);
            }
            else {
                i3 = i2;
                p0.o0();
            }
            w.x(p0, m2, h0);
            w.x(p0, i03, h1);
            if(!p0.O && q.b(p0.N(), v5)) {
                h5 = h4;
            }
            else {
                h5 = h4;
                A7.d.q(v5, p0, v5, h5);
            }
            w.x(p0, q7, h3);
            q.f("다시 로그인 하시면 멜론DJ만을 위한 다양한 서비스를 이용할 수 있습니다.", "getString(...)");
            N1.b("다시 로그인 하시면 멜론DJ만을 위한 다양한 서비스를 이용할 수 있습니다.", null, e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, new l1.k(3), 18.5f, 0, false, 2, 0, null, null, p0, 0xC00, 0xC06, 0x1D9F2);  // color:gray900s
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.5f));
            q.f("음악서랍에서 내가 만든 DJ플레이리스트 관리", "getString(...)");
            n.c(0, p0, "음악서랍에서 내가 만든 DJ플레이리스트 관리", androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(a.n(n0, 28.0f, 17.5f, 28.0f, 0.0f, 8), 18.0f), 1.0f));
            q.f("DJ플레이리스트 새로 만들기", "getString(...)");
            n.c(0, p0, "DJ플레이리스트 새로 만들기", androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(a.n(n0, 28.0f, 6.0f, 28.0f, 0.0f, 8), 18.0f), 1.0f));
            q.f("DJ플레이리스트에 담기", "getString(...)");
            n.c(0, p0, "DJ플레이리스트에 담기", androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(a.n(n0, 28.0f, 6.0f, 28.0f, 0.0f, 8), 18.0f), 1.0f));
            r0.q q8 = r0.a.a(e0.M(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(a.n(n0, 16.0f, 28.0f, 16.0f, 0.0f, 8), 40.0f), 1.0f), 0x7F060152, 100.0f), new l1(25, k0));  // color:gray200a
            N0.M m3 = M.p.d(i1, false);
            int v6 = p0.P;
            i0 i04 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            w.x(p0, m3, h0);
            w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h5);
            }
            w.x(p0, q9, h3);
            q.f("확인하기", "getString(...)");
            N1.b("확인하기", null, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray800s
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Rc.q(k0, v, 3);
        }
    }

    public static final Object k(List list0, l2.l l0, oe.c c0) {
        Iterator iterator0;
        kotlin.jvm.internal.H h1;
        l2.f f0;
        if(c0 instanceof l2.f) {
            f0 = (l2.f)c0;
            int v = f0.D;
            if((v & 0x80000000) == 0) {
                f0 = new l2.f(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                f0.D = v ^ 0x80000000;
            }
        }
        else {
            f0 = new l2.f(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = f0.B;
        ne.a a0 = ne.a.a;
        switch(f0.D) {
            case 0: {
                ArrayList arrayList0 = H0.b.m(object0);
                l2.h h0 = new l2.h(list0, arrayList0, null);
                f0.r = arrayList0;
                f0.D = 1;
                if(l0.a(h0, f0) != a0) {
                    h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    iterator0 = arrayList0.iterator();
                    break;
                }
                return a0;
            }
            case 1: {
                List list1 = (List)f0.r;
                n.D(object0);
                h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                iterator0 = list1.iterator();
                break;
            }
            case 2: {
                iterator0 = f0.w;
                h1 = (kotlin.jvm.internal.H)f0.r;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_39;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            we.k k0 = (we.k)object1;
            try {
                f0.r = h1;
                f0.w = iterator0;
                f0.D = 2;
                if(k0.invoke(f0) != a0) {
                    continue;
                }
            }
            catch(Throwable throwable0) {
            label_39:
                Object object2 = h1.a;
                if(object2 == null) {
                    h1.a = throwable0;
                    continue;
                }
                e2.a.q(((Throwable)object2), throwable0);
                continue;
            }
            return a0;
        }
        Throwable throwable1 = (Throwable)h1.a;
        if(throwable1 != null) {
            throw throwable1;
        }
        return ie.H.a;
    }

    public static final Object l(t t0, oe.c c0) {
        Throwable throwable1;
        kotlin.jvm.internal.H h2;
        t t1;
        x5.c c1;
        if(c0 instanceof x5.c) {
            c1 = (x5.c)c0;
            int v = c1.D;
            if((v & 0x80000000) == 0) {
                c1 = new x5.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                c1.D = v ^ 0x80000000;
            }
        }
        else {
            c1 = new x5.c(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = c1.B;
        ne.a a0 = ne.a.a;
        ie.H h0 = ie.H.a;
        switch(c1.D) {
            case 0: {
                n.D(object0);
                if(t0.b().compareTo(androidx.lifecycle.s.d) >= 0) {
                    return h0;
                }
                kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                try {
                    c1.r = t0;
                    c1.w = h1;
                    c1.D = 1;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(c1), 1);
                    cancellableContinuationImpl0.initCancellability();
                    x5.d d0 = new x5.d(cancellableContinuationImpl0);
                    h1.a = d0;
                    t0.a(d0);
                    if(cancellableContinuationImpl0.getResult() == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    t1 = t0;
                    h2 = h1;
                    throwable1 = throwable0;
                    goto label_42;
                }
                t1 = t0;
                h2 = h1;
                break;
            }
            case 1: {
                try {
                    h2 = c1.w;
                    t1 = c1.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
            label_42:
                androidx.lifecycle.C c2 = (androidx.lifecycle.C)h2.a;
                if(c2 != null) {
                    t1.c(c2);
                }
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        androidx.lifecycle.C c3 = (androidx.lifecycle.C)h2.a;
        if(c3 != null) {
            t1.c(c3);
        }
        return h0;
    }

    public static long m(boolean z, int v, int v1, long v2, long v3, int v4, boolean z1, long v5, long v6, long v7, long v8) {
        Y.r(v1, "backoffPolicy");
        if(v8 != 0x7FFFFFFFFFFFFFFFL && z1) {
            return v4 == 0 || v8 >= v3 + 900000L ? v8 : v3 + 900000L;
        }
        if(z) {
            long v9 = v1 == 2 ? v2 * ((long)v) : ((long)Math.scalb(v2, v - 1));
            if(v9 > 18000000L) {
                v9 = 18000000L;
            }
            return v3 + v9;
        }
        if(z1) {
            long v10 = v4 == 0 ? v3 + v5 : v3 + v7;
            return v6 == v7 || v4 != 0 ? v10 : v7 - v6 + v10;
        }
        return v3 == -1L ? 0x7FFFFFFFFFFFFFFFL : v3 + v5;
    }

    public static void n(boolean z, String s, Object[] arr_object) {
        if(!z) {
            throw new IllegalStateException(String.format(s, arr_object));
        }
    }

    public static final r0.q o(r0.q q0, Q q1) {
        return androidx.compose.ui.graphics.a.b(q0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, q1, true, 0x1E7FF);
    }

    public static final r0.q p(r0.q q0) {
        return androidx.compose.ui.graphics.a.b(q0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, true, 0x1EFFF);
    }

    public static String q(Me.u u0, int v) {
        String s;
        q.g(u0, "<this>");
        StringBuilder stringBuilder0 = new StringBuilder();
        if((v & 2) != 0) {
            if(u0 instanceof Me.j) {
                s = "<init>";
            }
            else {
                s = ((m)u0).getName().b();
                q.f(s, "asString(...)");
            }
            stringBuilder0.append(s);
        }
        stringBuilder0.append("(");
        Pe.u u1 = u0.Q();
        Qf.c c0 = Qf.c.a;
        if(u1 != null) {
            x x0 = u1.getType();
            q.f(x0, "getType(...)");
            stringBuilder0.append(((jf.k)e1.x.J(x0, r.k, c0)));
        }
        for(Object object0: u0.F()) {
            x x1 = ((S)object0).getType();
            q.f(x1, "getType(...)");
            stringBuilder0.append(((jf.k)e1.x.J(x1, r.k, c0)));
        }
        stringBuilder0.append(")");
        if((v & 1) != 0) {
            if(!(u0 instanceof Me.j)) {
                x x2 = u0.getReturnType();
                q.d(x2);
                if(!Je.i.E(x2, Je.o.d)) {
                    goto label_32;
                }
                x x3 = u0.getReturnType();
                q.d(x3);
                if(Hf.Y.e(x3) || u0 instanceof Pe.J) {
                label_32:
                    x x4 = u0.getReturnType();
                    q.d(x4);
                    stringBuilder0.append(((jf.k)e1.x.J(x4, r.k, c0)));
                    return stringBuilder0.toString();
                }
            }
            stringBuilder0.append("V");
            return stringBuilder0.toString();
        }
        return stringBuilder0.toString();
    }

    public static final String r(Me.b b0) {
        q.g(b0, "<this>");
        if(!tf.e.n(b0)) {
            Me.k k0 = b0.e();
            Me.e e0 = k0 instanceof Me.e ? ((Me.e)k0) : null;
            if(e0 != null && !e0.getName().b) {
                Me.b b1 = b0.a();
                L l0 = b1 instanceof L ? ((L)b1) : null;
                return l0 == null ? null : g.g0(e0, n.q(l0, 3));
            }
        }
        return null;
    }

    public static g s(int v) {
        switch(v) {
            case 0: {
                return new z6.l();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            case 1: {
                return new z6.e();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            default: {
                return new z6.l();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
    }

    public static final o t(Throwable throwable0) {
        q.g(throwable0, "exception");
        return new o(throwable0);
    }

    public static void u(Uri uri0) {
        String s = uri0.getPath();
        if(s == null) {
            s = "";
        }
        if(v.r0(s, "/offerwall", false)) {
            String s1 = s.substring(10);
            q.f(s1, "substring(...)");
            String s2 = uri0.getQuery();
            Navigator.INSTANCE.openCashFriendsOfferWall((s1.length() <= 0 ? "?" : "/") + s2);
        }
    }

    public static void v(BaseActivity baseActivity0, Uri uri0) {
        k8.a a0;
        String s = uri0.getPath();
        if(s != null) {
            switch(s) {
                case "/channel/create": {
                    Navigator.INSTANCE.openCreateMusicWaveChannel();
                    break;
                }
                case "/listen": {
                    String s1 = u0.y(uri0, "seq");
                    String s2 = u0.y(uri0, "ctype");
                    String s3 = u0.y(uri0, "closewebview");
                    String s4 = u0.y(uri0, "menuid");
                    boolean z = v.j0(s3, "Y", true);
                    if(s1 != null && s2 != null) {
                        if(z) {
                            if(baseActivity0 == null) {
                                LogU.Companion.d("MUSIC_WAVE_MELON_APP_URI", "closeWebView but activity is null");
                                return;
                            }
                            baseActivity0.closeAllWebViewFragment();
                        }
                        MusicWaveChannelInfo musicWaveChannelInfo0 = new MusicWaveChannelInfo(s1, s2, null, null, null, null, null, null, 0xFC, null);
                        if(baseActivity0 == null) {
                            a0 = null;
                        }
                        else {
                            Context context0 = baseActivity0.getApplicationContext();
                            q.f(context0, "getApplicationContext(...)");
                            a0 = ((k8.o)(((Ma.c)com.google.firebase.b.B(context0, Ma.c.class)))).d();
                        }
                        MusicWave playDataForSeverContent$MusicWave0 = new MusicWave(musicWaveChannelInfo0, (s4 == null ? "" : s4), null);
                        if(s4 == null) {
                            s4 = "";
                        }
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddServerContent(new MusicWaveOpen(musicWaveChannelInfo0, s4), false, false, a0, playDataForSeverContent$MusicWave0, 6, null), false, 2, null);
                        return;
                    }
                    LogU.Companion.d("MUSIC_WAVE_MELON_APP_URI", "id or type is null");
                }
            }
        }
    }

    public static final String w(DjMalrangInfo djMalrangInfo0) {
        q.g(djMalrangInfo0, "<this>");
        return djMalrangInfo0.e + "_" + djMalrangInfo0.f + "_" + djMalrangInfo0.h;
    }

    public static final String x(Playable playable0, Context context0, DateTimeFormatter dateTimeFormatter0) {
        q.g(playable0, "<this>");
        q.g(dateTimeFormatter0, "dateFormatter");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(dateTimeFormatter0.format(Instant.ofEpochMilli(playable0.getCreatedAt())));
        stringBuilder0.append("_");
        if(context0 != null) {
            stringBuilder0.append(DeviceIdentifier.id(context0));
        }
        String s = stringBuilder0.toString();
        q.f(s, "let(...)");
        return s;
    }

    public static void y(AnimatorSet animatorSet0, ArrayList arrayList0) {
        int v = arrayList0.size();
        long v1 = 0L;
        for(int v2 = 0; v2 < v; ++v2) {
            Animator animator0 = (Animator)arrayList0.get(v2);
            long v3 = animator0.getStartDelay();
            v1 = Math.max(v1, animator0.getDuration() + v3);
        }
        ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{0, 0});
        valueAnimator0.setDuration(v1);
        arrayList0.add(0, valueAnimator0);
        animatorSet0.playTogether(arrayList0);
    }

    public static void z(ViewGroup viewGroup0, float f) {
        Drawable drawable0 = viewGroup0.getBackground();
        if(drawable0 instanceof i) {
            ((i)drawable0).l(f);
        }
    }
}

