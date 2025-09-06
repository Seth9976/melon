package d8;

import Ac.Z3;
import Ac.i2;
import B3.N;
import Cc.H3;
import Cc.N1;
import Cc.S;
import Cc.c1;
import Cc.c2;
import Cc.e0;
import Cc.w3;
import Cc.z2;
import E9.w;
import G.C;
import G.P;
import G.X;
import M.c;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.y;
import O.F;
import O.I;
import P0.h;
import P0.i;
import Q0.C0;
import U4.x;
import Vc.T;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.E0;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.draw.ShadowGraphicsLayerElement;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.f0;
import cd.V2;
import cd.x1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.artistchannel.viewholder.e;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.s;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import d5.t;
import e3.b;
import ed.D;
import gd.c0;
import gd.d0;
import gd.h4;
import i.n.i.b.a.s.e.Ga;
import ie.H;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.StringReader;
import java.net.MulticastSocket;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import o3.m;
import o3.v;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import r0.a;
import r0.g;
import r0.n;
import rd.k0;
import td.m0;
import vd.W;
import wc.u;
import we.k;
import xd.f;
import y0.B;
import y0.M;
import y0.Q;
import zc.K;
import zc.U;

public abstract class d {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static final Document A(String s) {
        q.g(s, "xml");
        StringReader stringReader0 = new StringReader(s);
        DocumentBuilderFactory documentBuilderFactory0 = DocumentBuilderFactory.newInstance();
        q.f(documentBuilderFactory0, "it");
        documentBuilderFactory0.setNamespaceAware(true);
        DocumentBuilder documentBuilder0 = documentBuilderFactory0.newDocumentBuilder();
        q.f(documentBuilder0, "DocumentBuilderFactory.n…   }.newDocumentBuilder()");
        Document document0 = documentBuilder0.parse(new InputSource(stringReader0));
        q.f(document0, "newDocumentBuilder(aware…arse(InputSource(reader))");
        return document0;
    }

    public static h4 B(String s) {
        h4 h40 = new h4();
        Bundle bundle0 = new Bundle();
        q.g(h40.h, "<this>");
        int v = h40.h.indexOf(s);
        if(v < 0) {
            v = 0;
        }
        bundle0.putInt("argSortIndex", v);
        h40.setArguments(bundle0);
        return h40;
    }

    public static int C(N n0, int v, int v1, int v2) {
        b.c(Math.max(Math.max(v, v1), v2) <= 0x1F);
        int v3 = (1 << v) - 1;
        int v4 = (1 << v1) - 1;
        w.m(w.m(v3, v4), 1 << v2);
        if(n0.m() >= v) {
            int v5 = n0.D(v);
            if(v5 != v3) {
                return v5;
            }
            if(n0.m() >= v1) {
                int v6 = n0.D(v1);
                v5 += v6;
                if(v6 == v4) {
                    return n0.m() >= v2 ? n0.D(v2) + v5 : -1;
                }
                return v5;
            }
        }
        return -1;
    }

    public static void D(int v, Exception exception0, String s, Object[] arr_object) {
        if(v < 0x7FFFFFFF) {
            return;
        }
        if(s != null && arr_object.length != 0) {
            Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
            Arrays.copyOf(arr_object1, arr_object1.length);
        }
    }

    public static final void E(long v, List list0) {
        q.g(list0, "<this>");
        for(Object object0: list0) {
            ((Playable)object0).setCreatedAt(v);
        }
    }

    public static r0.q F(r0.q q0, float f, Q q1, int v) {
        if((v & 4) != 0) {
            boolean z = Float.compare(f, 0.0f) > 0;
            return Float.compare(f, 0.0f) > 0 || z ? q0.then(new ShadowGraphicsLayerElement(f, q1, z, B.a, B.a)) : q0;
        }
        return Float.compare(f, 0.0f) > 0 ? q0.then(new ShadowGraphicsLayerElement(f, q1, false, B.a, B.a)) : q0;
    }

    public static void G(N n0) {
        n0.O(3);
        n0.O(8);
        boolean z = n0.C();
        boolean z1 = n0.C();
        if(z) {
            n0.O(5);
        }
        if(z1) {
            n0.O(6);
        }
    }

    public static void H(N n0) {
        int v5;
        int v = n0.D(2);
        int v1 = 6;
        if(v == 0) {
            n0.O(6);
            return;
        }
        int v2 = 5;
        int v3 = d.C(n0, 5, 8, 16);
        if(v == 1) {
            n0.O((v3 + 1) * 7);
            return;
        }
        if(v == 2) {
            boolean z = n0.C();
            if(z) {
                v2 = 7;
            }
            if(z) {
                v1 = 8;
            }
            for(int v4 = 0; v4 < v3 + 1; ++v4) {
                if(n0.C()) {
                    n0.O(7);
                    v5 = 0;
                }
                else {
                    if(n0.D(2) == 3 && n0.D(v2) * (z ? 1 : 5) != 0) {
                        n0.N();
                    }
                    v5 = n0.D(v1) * (z ? 1 : 5);
                    if(v5 != 0 && v5 != 180) {
                        n0.N();
                    }
                    n0.N();
                }
                if(v5 != 0 && v5 != 180 && n0.C()) {
                    ++v4;
                }
            }
        }
    }

    public static final void I(Exception exception0) {
        d.D(5, exception0, "", new Object[0]);
    }

    public static final void a(f f0, r0.q q0, int v, k k0, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0xA69F8604);
        int v2 = (v1 & 6) == 0 ? v1 | (p0.g(f0) ? 4 : 2) : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            r0.q q1 = e0.Q(q0, f0.f);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            r0.q q3 = androidx.compose.foundation.layout.d.n(n.a, 36.0f);
            q.g(q3, "<this>");
            c1.n(androidx.compose.foundation.q.f(a.a(q3, new S(0x7F06014A, 1)), e0.T(p0, 0x7F060145), M.a), f0.d, null, null, false, 0x7F08079F, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30000, 0, 0x7FDC);  // color:gray100a
            c.d(p0, androidx.compose.foundation.layout.d.q(n.a, 10.0f));
            long v4 = e0.T(p0, 0x7F060169);  // color:gray850s
            N1.b((f0.c == null ? "" : f0.c), new LayoutWeightElement(1.0f, true), v4, 16.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(f0, q0, v, k0, v1, 21);
        }
    }

    public static final void b(xd.k k0, com.melon.ui.popup.context.more.a a0, k k1, int v, k k2, we.a a1, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(-1026521000);
        int v2 = v1 | (p0.i(k0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k1) ? 0x100 : 0x80) | (p0.e(v) ? 0x800 : 0x400) | (p0.i(k2) ? 0x4000 : 0x2000);
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = x.d(0, p0);
            }
            n n0 = n.a;
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), Q0.N.u(p0), null);
            Z3 z30 = p0.N();
            if((0xE000 & v2) == 0x4000 || z30 == v3) {
                z30 = new Z3(k2, b00, 4);
                p0.l0(z30);
            }
            r0.q q1 = androidx.compose.ui.layout.a.f(q0, z30);
            y y0 = M.w.a(j.e, r0.d.n, p0, 54);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = a.d(p0, q1);
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q2, P0.j.d);
            ArrayList arrayList0 = k0.a;
            r0.q q3 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            boolean z = p0.i(a0);
            boolean z1 = p0.i(arrayList0);
            m0 m00 = p0.N();
            if(((v2 & 0x380) == 0x100 | z | z1) != 0 || m00 == v3) {
                m00 = new m0(arrayList0, a0, k1, 5);
                p0.l0(m00);
            }
            c1.o(q3, null, j00, false, null, null, null, false, m00, p0, 390, 0xFA);
            if(v == 0 || ((Number)b00.getValue()).intValue() <= v) {
                p0.a0(0x3297DDA0);
            }
            else {
                p0.a0(861780648);
                c.d(p0, androidx.compose.foundation.q.x(x.r(1.0f, androidx.compose.foundation.layout.d.f(n0, 1.0f), true), androidx.compose.foundation.q.t(p0), false, 14));
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new k0(k0, a0, k1, v, k2, a1, v1);
        }
    }

    public static final void c(c0 c00, k k0, l l0, int v) {
        ((p)l0).c0(0x574253D9);
        int v1 = (((p)l0).g(c00) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(a.a(androidx.compose.foundation.layout.d.f(n.a, 1.0f), new Ac.l(c00, k0, 17)), E9.h.t(((p)l0), 0x7F0700AC), 0.0f, 2), 88.0f);  // dimen:context_list_padding_left_right
            String s = c00.b;
            String s1 = c00.g;
            String s2 = c00.c;
            String s3 = c00.e;
            boolean z = c00.f;
            boolean z1 = c00.d;
            String s4 = c00.a;
            String s5 = c00.h;
            gd.l l1 = ((p)l0).N();
            if((((v1 & 14) == 4 ? 1 : 0) | ((v1 & 0x70) == 0x20 ? 1 : 0)) != 0 || l1 == androidx.compose.runtime.k.a) {
                l1 = new gd.l(3, c00, k0);
                ((p)l0).l0(l1);
            }
            w3.l(q0, s1, s, s2, z1, s3, null, z, true, s4, s5, l1, ((p)l0), 0x6180000, 0, 0);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new e(c00, k0, v, 12);
        }
    }

    public static final void d(d0 d00, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1550281254);
        int v1 = v | (p0.g(d00) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            float f = E9.h.t(p0, 0x7F0700AC);  // dimen:context_list_padding_left_right
            float f1 = E9.h.t(p0, 0x7F0703F2);  // dimen:new_filter_layout_height
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), f, 8.0f, f, 0.0f, 8), f1);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            c1.n(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.n(n0, 22.0f), 0.0f, 0.0f, 4.0f, 0.0f, 11), 0x7F080485, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_like_16_g_tint
            q.f("좋아요한 %s명", "getString(...)");
            N1.b(String.format("좋아요한 %s명", Arrays.copyOf(new Object[]{d00.a}, 1)), androidx.compose.foundation.layout.d.u(n0, 3), e0.T(p0, 0x7F060165), 14.0f, null, null, 0L, new l1.k(5), 0.0f, 0, false, 1, 0, null, null, p0, 0xC30, 0xC00, 0x1DDF0);  // color:gray800s
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new V2(d00, v, 7);
        }
    }

    public static final void e(int v, l l0, List list0, we.a a0, k k0) {
        ((p)l0).c0(0x5BFB1716);
        int v1 = v | (((p)l0).i(list0) ? 4 : 2) | (((p)l0).i(k0) ? 0x20 : 16) | (((p)l0).i(a0) ? 0x100 : 0x80);
        boolean z = true;
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            F f0 = I.a(0, 0, 3, ((p)l0));
            C0 c00 = Q0.N.u(((p)l0));
            boolean z1 = ((p)l0).g(f0);
            gd.i0 i00 = ((p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x380) == 0x100 || z1 || i00 == v2) {
                i00 = new gd.i0(f0, a0, null);
                ((p)l0).l0(i00);
            }
            J.d(((p)l0), H.a, i00);
            r0.q q0 = androidx.compose.ui.input.nestedscroll.a.a(androidx.compose.foundation.layout.d.c(n.a, 1.0f), c00, null);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(((p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z2 = ((p)l0).i(list0);
            if((v1 & 0x70) != 0x20) {
                z = false;
            }
            gd.e e0 = ((p)l0).N();
            if(z2 || z || e0 == v2) {
                e0 = new gd.e(list0, 2, k0);
                ((p)l0).l0(e0);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, e0, ((p)l0), 0, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new s(list0, k0, a0, v, 2);
        }
    }

    public static final void f(int v, ArrayList arrayList0, U u0, l l0, int v1) {
        U u7;
        int v17;
        U u6;
        Context context2;
        int v16;
        u u5;
        P p3;
        h h6;
        V v6;
        U u1;
        r0.h h0 = r0.d.k;
        p p0 = (p)l0;
        p0.c0(2052189809);
        int v2 = v1 | (p0.e(v) ? 4 : 2) | (p0.i(arrayList0) ? 0x20 : 16) | 0x80;
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            p0.V();
            if((v1 & 1) == 0 || p0.B()) {
                u1 = new U();
            }
            else {
                p0.T();
                u1 = u0;
            }
            p0.q();
            Configuration configuration0 = (Configuration)p0.k(AndroidCompositionLocals_androidKt.a);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            Iterator iterator0 = arrayList0.iterator();
            while(true) {
                float f = 0.0f;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                float f1 = ((Number)object0).floatValue();
                for(Object object1: arrayList0) {
                    f = ((Number)object1).floatValue() + f;
                }
                arrayList1.add(((float)(f1 * 100.0f / f)));
            }
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object2: arrayList1) {
                arrayList2.add(((float)(360.0f * ((Number)object2).floatValue() / 100.0f)));
            }
            P p1 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(p1 == v3) {
                p1 = new P(Boolean.FALSE);
                p0.l0(p1);
            }
            Z z0 = p0.N();
            if(z0 == v3) {
                z0 = androidx.compose.runtime.w.o(0.0f);
                p0.l0(z0);
            }
            float f2 = ((Number)G.j.b(((I0)z0).m(), G.f.r(300, 0, null, 6), "", null, p0, 0xC30, 20).getValue()).floatValue();
            n n0 = n.a;
            r0.q q0 = e0.L(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(e2.a.r(n0, f2), 1.0f), u1.b), 0x7F06014B);  // color:gray100s_support_high_contrast
            long v4 = e0.T(p0, u1.e);
            u u2 = M.a;
            r0.q q1 = androidx.compose.foundation.q.f(q0, v4, u2);
            boolean z1 = p0.i(p1);
            xc.F f3 = p0.N();
            if(z1 || f3 == v3) {
                f3 = new xc.F(4, p1, z0);
                p0.l0(f3);
            }
            r0.q q2 = androidx.compose.ui.layout.a.d(q1, f3);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v5 = p0.P;
            M.d d0 = j.c;
            i0 i00 = p0.m();
            r0.q q3 = a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            g g0 = r0.d.m;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h1);
            h h2 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O) {
                v6 = v3;
                A7.d.q(v5, p0, v5, h3);
            }
            else {
                v6 = v3;
                if(!q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h3);
                }
            }
            h h4 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h4);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 18.0f));
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            p0 p00 = n0.a(j.a, h0, p0, 0x30);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h1);
            androidx.compose.runtime.w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h3);
            }
            androidx.compose.runtime.w.x(p0, q5, h4);
            r0.q q6 = androidx.compose.foundation.layout.d.n(n0, 19.0f);
            androidx.compose.foundation.q.c(De.I.Q(0x7F0803C3, p0, 6), null, q6, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:ic_chartgraph_2
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
            long v8 = e0.T(p0, 0x7F06016D);  // color:gray900s
            r0.h h5 = h0;
            U u3 = u1;
            N1.b(u1.f, null, v8, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 16.0f));
            r0.q q7 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n0, u3.c), 1.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v9 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h1);
            androidx.compose.runtime.w.x(p0, i02, h2);
            if(!p0.O && q.b(p0.N(), v9)) {
                h6 = h3;
            }
            else {
                h6 = h3;
                A7.d.q(v9, p0, v9, h6);
            }
            androidx.compose.runtime.w.x(p0, q8, h4);
            Context context1 = context0;
            androidx.compose.animation.b.e(p1, null, F.S.d(G.f.r(500, 400, null, 4), 6), null, null, m0.c.e(0x20E75CC5, p0, new i2(u3, arrayList2, context0, 7)), p0, 0x180C06);
            P p2 = p1;
            androidx.compose.animation.b.c(((Boolean)((O0)p1.b).getValue()).booleanValue(), null, F.S.d(G.f.r(300, 0, null, 6), 6), null, null, m0.c.e(0x5204A3BC, p0, new Uc.b(u3, arrayList2, v, context1)), p0, 0x180C06);
            M.p.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.n(n0, 100.0f), T.e.a(50)), e0.T(p0, 0x7F06013E), u2), p0, 0);  // color:gray000s
            u u4 = u2;
            androidx.compose.animation.b.c(((Boolean)((O0)p2.b).getValue()).booleanValue(), null, F.S.d(G.f.r(500, 0, null, 6), 6), null, null, m0.c.e(808063549, p0, new zc.J(v, arrayList1)), p0, 0x180C06);
            l1.y(p0, true, n0, 20.0f, p0);
            int v10 = (int)Math.ceil(((double)arrayList0.size()) / 3.0);
            g g1 = r0.d.n;
            r0.q q9 = androidx.compose.foundation.layout.a.n(new HorizontalAlignElement(g1), 1.0f, 0.0f, 0.0f, 0.0f, 14);
            if(configuration0.orientation != 2) {
                g1 = g0;
            }
            y y1 = M.w.a(d0, g1, p0, 0);
            int v11 = p0.P;
            i0 i03 = p0.m();
            r0.q q10 = a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h1);
            androidx.compose.runtime.w.x(p0, i03, h2);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h6);
            }
            androidx.compose.runtime.w.x(p0, q10, h4);
            p0.a0(1079370366);
            if(1 <= v10) {
                int v12 = 1;
                int v13 = 0;
                while(true) {
                    r0.h h7 = h5;
                    p0 p01 = n0.a(j.a, h7, p0, 0x30);
                    int v14 = p0.P;
                    i0 i04 = p0.m();
                    r0.q q11 = a.d(p0, n0);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, p01, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i04, P0.j.e);
                    h h8 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v14)) {
                        A7.d.q(v14, p0, v14, h8);
                    }
                    androidx.compose.runtime.w.x(p0, q11, P0.j.d);
                    p0.a0(0x9472B02A);
                    int v15 = 1;
                    while(true) {
                        if(v13 < arrayList0.size()) {
                            p0.a0(-1804420327);
                            M.p.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.o(n0, 14.0f, 3.0f), T.e.b(4.0f)), u3.a(context1, v13), u4), p0, 0);
                            r0.q q12 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.q(n0, 80.0f), 6.0f, 0.0f, 0.0f, 0.0f, 14);
                            h5 = h7;
                            p3 = p2;
                            u5 = u4;
                            v16 = v10;
                            context2 = context1;
                            u6 = u3;
                            v17 = v15;
                            N1.b((v13 + 1 + "위  " + ((int)((Number)arrayList0.get(v13)).floatValue()) + "%"), q12, e0.T(p0, 0x7F06016D), 13.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);  // color:gray900s
                            p0.p(false);
                            ++v13;
                        }
                        else {
                            context2 = context1;
                            u6 = u3;
                            v16 = v10;
                            v17 = v15;
                            h5 = h7;
                            u5 = u4;
                            p3 = p2;
                            p0.a0(-110408833);
                            p0.p(false);
                        }
                        if(v17 == 3) {
                            break;
                        }
                        v15 = v17 + 1;
                        p2 = p3;
                        h7 = h5;
                        v10 = v16;
                        context1 = context2;
                        u3 = u6;
                        u4 = u5;
                    }
                    p0.p(false);
                    p0.p(true);
                    c.d(p0, androidx.compose.foundation.layout.d.h(n0, 8.0f));
                    if(v12 == v16) {
                        break;
                    }
                    ++v12;
                    v10 = v16;
                    p2 = p3;
                    context1 = context2;
                    u3 = u6;
                    u4 = u5;
                }
            }
            else {
                u6 = u3;
                p3 = p2;
            }
            p0.p(false);
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 10.0f));
            p0.p(true);
            Integer integer0 = v;
            boolean z2 = p0.i(p3);
            K k0 = p0.N();
            if(z2 || k0 == v6) {
                k0 = new K(p3, z0, null);
                p0.l0(k0);
            }
            J.d(p0, integer0, k0);
            u7 = u6;
        }
        else {
            p0.T();
            u7 = u0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.U(v, arrayList0, u7, v1);
        }
    }

    public static final void g(int v, int v1, we.a a0, l l0, int v2) {
        p p0 = (p)l0;
        p0.c0(0xA2856012);
        int v3 = v2 | (p0.e(v) ? 4 : 2) | (p0.e(v1) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            T.d d0 = T.e.b(12.0f);
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.f(d5.n.o(n0, d0), e0.T(p0, 0x7F0604AB), M.a);  // color:white001s
            y y0 = M.w.a(j.c, r0.d.n, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            d.h(androidx.compose.foundation.layout.a.n(n0, 0.0f, 24.0f, 0.0f, 0.0f, 13), p0, 6);
            String s = String.format(H0.e.Y(p0, 0x7F130749), Arrays.copyOf(new Object[]{v + "/" + v1}, 1));  // string:music_wave_send_img_progress_dialog_content "사진 업로드 중 (%s)"
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 16.0f, 0.0f, 0.0f, 13);
            long v5 = e0.T(p0, 0x7F060165);  // color:gray800s
            l1.k k0 = new l1.k(3);
            h h3 = P0.j.d;
            N1.b(s, q2, v5, 15.0f, null, null, 0L, k0, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);
            e0.C(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, 24.0f, 0.0f, 0.0f, 13), 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            r0.q q3 = a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 44.0f), new D(14, a0));
            N0.M m0 = M.p.d(r0.d.e, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            N1.b(H0.e.Y(p0, 0x7F130199), null, e0.T(p0, 0x7F06017C), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // string:cancel "취소"
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.music.q(v, v1, a0, v2);
        }
    }

    public static final void h(r0.q q0, l l0, int v) {
        ((p)l0).c0(420901012);
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            G.I i0 = G.f.f(G.f.p("ProgressSpinner", ((p)l0), 0), 0.0f, 360.0f, G.f.n(G.f.r(1000, 0, C.d, 2), X.a, 0L, 4), "SendImageProgressSpinner", ((p)l0), 0x71B8, 0);
            c1.n(t.q(androidx.compose.foundation.layout.d.n(q0, 40.0f), ((Number)i0.getValue()).floatValue()), 0x7F080640, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0x30, 0, 0x7FFC);  // drawable:img_loading_40
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Bd.h(q0, v, 3);
        }
    }

    public static final void i(List list0, we.n n0, l l0, int v) {
        int v3;
        p p0 = (p)l0;
        p0.c0(0xE2A417E6);
        int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(n0) ? 0x20 : 16);
        }
        boolean z = true;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Object object0 = p0.k(Q0.k0.h);
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(new r1.f(0.0f));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 1) {
                v3 = 339;
            }
            else {
                z = false;
                v3 = 0xC7;
            }
            float f = !z || !((Boolean)b01.getValue()).booleanValue() ? 0.0f : 7.0f;
            b0 b02 = p0.N();
            if(b02 == v2) {
                b02 = androidx.compose.runtime.w.s(new r1.l(0L));
                p0.l0(b02);
            }
            Boolean boolean0 = Boolean.valueOf(z);
            boolean z1 = p0.g(((r1.c)object0));
            boolean z2 = p0.d(((float)v3));
            W w0 = p0.N();
            if(z1 || z2 || w0 == v2) {
                w0 = new W(((r1.c)object0), ((float)v3), b02, b00, b01, null);
                p0.l0(w0);
            }
            J.d(p0, boolean0, w0);
            androidx.compose.runtime.w.a(E0.a.a(null), m0.c.e(0x3B6CBCA6, p0, new c2(f, ((float)v3), b02, list0, n0, b01)), p0, 56);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.j(list0, n0, v, 2);
        }
    }

    public static final void j(String s, List list0, we.a a0, k k0, l l0, int v) {
        b0 b01;
        p p0 = (p)l0;
        p0.c0(0xF558393A);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(list0);
                p0.l0(b00);
            }
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.j(n0, 0.0f, 440.0f, 1), 270.0f);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.f(d5.n.o(n0, T.e.b(12.0f)), e0.T(p0, 0x7F0604AB), M.a);  // color:white001s
            M.d d0 = j.c;
            y y0 = M.w.a(d0, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.m(n0, 20.0f, 26.0f, 20.0f, 18.0f), 1.0f);
            N0.M m1 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            g g0 = r0.d.n;
            y y1 = M.w.a(d0, g0, p0, 0x30);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q6 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            yd.h.c(s, p0, v1 & 14);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 12.0f));
            x1 x10 = p0.N();
            if(x10 == v2) {
                b01 = b00;
                x10 = new x1(b01, 3);
                p0.l0(x10);
            }
            else {
                b01 = b00;
            }
            d.i(list0, x10, p0, v1 >> 3 & 14 | 0x30);
            p0.p(true);
            p0.p(true);
            e0.C(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            r0.q q7 = H0.b.q(g0, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 44.0f));
            T t0 = p0.N();
            if((v1 & 0x1C00) == 0x800 || t0 == v2) {
                t0 = new T(k0, b01, 1);
                p0.l0(t0);
            }
            yd.h.b(true, true, q7, null, null, false, null, t0, a0, p0, v1 << 18 & 0xE000000 | 54, 120);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new td.i(s, list0, a0, k0, v);
        }
    }

    public static final void k(ShortCutItem shortCutItem0, boolean z, k k0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x20E1C80B);
        int v1 = v | (p0.i(shortCutItem0) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 52.0f);
            r0.h h0 = r0.d.k;
            p0 p00 = n0.a(j.a, h0, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            if(b00 == androidx.compose.runtime.k.a) {
                b00 = androidx.compose.runtime.w.s(Boolean.valueOf(z));
                p0.l0(b00);
            }
            c1.n(androidx.compose.foundation.layout.d.n(n0, 32.0f), shortCutItem0.getImageId(), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 390, 0, 0x7FF8);
            String s = context0.getString(shortCutItem0.getStringId());
            q.f(s, "getString(...)");
            long v3 = e0.T(p0, 0x7F060165);  // color:gray800s
            N1.b(s, H0.b.r(h0, x.r(1.0f, androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 28.0f, 0.0f, 10), 3), true)), v3, 16.0f, null, null, 0L, new l1.k(5), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);
            int v4 = ((Boolean)b00.getValue()).booleanValue() ? 0x7F080123 : 0x7F080121;  // drawable:btn_common_check_01_s_tint
            c1.n(a.a(androidx.compose.foundation.layout.d.n(n0, 30.0f), new Ec.g(k0, b00, 7)), v4, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x180, 0, 0x7FF8);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z2(shortCutItem0, z, k0, v, 11);
        }
    }

    public static final void l(Closeable closeable0, Throwable throwable0) {
        if(closeable0 != null) {
            if(throwable0 == null) {
                closeable0.close();
                return;
            }
            try {
                closeable0.close();
            }
            catch(Throwable throwable1) {
                e2.a.q(throwable0, throwable1);
            }
        }
    }

    public static final void m(MulticastSocket multicastSocket0) {
        if(multicastSocket0 != null) {
            multicastSocket0.close();
        }
    }

    public static k2.c n(String s, l2.c0 c00, m2.a a0, k k0, int v) {
        if((v & 8) != 0) {
            k0 = k2.a.f;
        }
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        q.g(c00, "serializer");
        q.g(coroutineScope0, "scope");
        return new k2.c(s, new Ga(c00), a0, k0, coroutineScope0);
    }

    public static Bitmap o(byte[] arr_b, int v, int v1) {
        y2.g g0;
        BitmapFactory.Options bitmapFactory$Options0;
        if(v1 == -1) {
            bitmapFactory$Options0 = null;
        }
        else {
            bitmapFactory$Options0 = new BitmapFactory.Options();
            bitmapFactory$Options0.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(arr_b, 0, v, bitmapFactory$Options0);
            int v2 = Math.max(bitmapFactory$Options0.outWidth, bitmapFactory$Options0.outHeight);
            bitmapFactory$Options0.inJustDecodeBounds = false;
            bitmapFactory$Options0.inSampleSize = 1;
            while(v2 > v1) {
                bitmapFactory$Options0.inSampleSize *= 2;
                v2 /= 2;
            }
        }
        Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, v, bitmapFactory$Options0);
        if(bitmapFactory$Options0 != null) {
            bitmapFactory$Options0.inSampleSize = 1;
        }
        if(bitmap0 == null) {
            throw b3.I.a(new IllegalStateException(), "Could not decode image data");
        }
        try(ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b)) {
            g0 = new y2.g(byteArrayInputStream0);
        }
        int v3 = g0.l();
        if(v3 != 0) {
            Matrix matrix0 = new Matrix();
            matrix0.postRotate(((float)v3));
            return Bitmap.createBitmap(bitmap0, 0, 0, bitmap0.getWidth(), bitmap0.getHeight(), matrix0, false);
        }
        return bitmap0;
    }

    public static final void p(IllegalArgumentException illegalArgumentException0) {
        d.D(6, illegalArgumentException0, "", new Object[0]);
    }

    public static final pe.b q(Enum[] arr_enum) [...] // Inlined contents

    public static int r(boolean z) {
        try {
            b3.n n0 = new b3.n();
            n0.m = "video/avc";
            androidx.media3.common.b b0 = new androidx.media3.common.b(n0);
            I6.p0 p00 = v.g(o3.h.b, b0, z, false);
            int v = 0;
            while(v < p00.d) {
                if(((m)p00.get(v)).d == null || ((m)p00.get(v)).d.getVideoCapabilities() == null) {
                    ++v;
                    continue;
                }
                else {
                    List list0 = com.iloen.melon.utils.player.a.i(((m)p00.get(v)).d.getVideoCapabilities());
                    if(list0 == null || list0.isEmpty()) {
                        ++v;
                        continue;
                    }
                }
                MediaCodecInfo.VideoCapabilities.PerformancePoint mediaCodecInfo$VideoCapabilities$PerformancePoint0 = com.iloen.melon.utils.player.a.e();
                for(int v1 = 0; true; ++v1) {
                    if(v1 >= list0.size()) {
                        return 1;
                    }
                    if(com.iloen.melon.utils.player.a.u(com.iloen.melon.utils.player.a.g(list0.get(v1)), mediaCodecInfo$VideoCapabilities$PerformancePoint0)) {
                        return 2;
                    }
                }
            }
        }
        catch(o3.s unused_ex) {
        }
        return 0;
    }

    public static void s(Activity activity0, Uri uri0) {
        if(activity0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                switch(s) {
                    case "": {
                        ld.j j1 = new ld.j(1);
                        if(activity0 instanceof ComponentActivity) {
                            BuildersKt__Builders_commonKt.launch$default(f0.f(((androidx.lifecycle.D)activity0)), Dispatchers.getMain(), null, new m8.k0(activity0, j1, null), 2, null);
                            return;
                        }
                        break;
                    }
                    case "/eq": {
                        U8.l l0 = new U8.l();
                        Navigator.INSTANCE.open(l0);
                        return;
                    }
                    case "/playlist": {
                        ld.j j0 = new ld.j(2);
                        if(activity0 instanceof ComponentActivity) {
                            BuildersKt__Builders_commonKt.launch$default(f0.f(((androidx.lifecycle.D)activity0)), Dispatchers.getMain(), null, new m8.k0(activity0, j0, null), 2, null);
                            return;
                        }
                        break;
                    }
                }
            }
        }
    }

    public static int t(float[] arr_f, int[] arr_v, byte[] arr_b) {
        Arrays.fill(arr_b, 0);
        int v = 0x7FFFFFFF;
        for(int v1 = 0; v1 < 6; ++v1) {
            int v2 = (int)Math.ceil(arr_f[v1]);
            arr_v[v1] = v2;
            if(v > v2) {
                Arrays.fill(arr_b, 0);
                v = v2;
            }
            if(v == v2) {
                arr_b[v1] = (byte)(arr_b[v1] + 1);
            }
        }
        return v;
    }

    public static void u(char c) {
        String s = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - s.length()) + s) + ')');
    }

    public static final int v(AbstractList abstractList0, Playable playable0) {
        q.g(abstractList0, "list");
        if(playable0 != null) {
            Iterator iterator0 = abstractList0.iterator();
            for(int v = 0; iterator0.hasNext(); ++v) {
                iterator0.next();
                if(q.b("", "")) {
                    return v;
                }
            }
        }
        return -1;
    }

    public static boolean w(char c) {
        return c >= 0x30 && c <= 57;
    }

    public static boolean x(char c) {
        return c >= 0x80 && c <= 0xFF;
    }

    // 去混淆评级： 低(20)
    public static boolean y(char c) {
        return c == 13 || c == 0x20 || c == 42 || c == 62 || c >= 0x30 && c <= 57 || c >= 65 && c <= 90;
    }

    public static int z(CharSequence charSequence0, int v, int v1) {
        float[] arr_f;
        if(v >= charSequence0.length()) {
            return v1;
        }
        if(v1 == 0) {
            arr_f = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        }
        else {
            arr_f = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            arr_f[v1] = 0.0f;
        }
        int v2 = 0;
    alab1:
        while(true) {
            while(true) {
                while(true) {
                label_8:
                    int v3 = v + v2;
                    if(v3 != charSequence0.length()) {
                        goto label_24;
                    }
                    byte[] arr_b = new byte[6];
                    int[] arr_v = new int[6];
                    int v4 = d.t(arr_f, arr_v, arr_b);
                    int v5 = 0;
                    for(int v6 = 0; v6 < 6; ++v6) {
                        v5 += arr_b[v6];
                    }
                    if(arr_v[0] == v4) {
                        return 0;
                    }
                    if(v5 == 1 && arr_b[5] > 0) {
                        break alab1;
                    }
                    if(v5 == 1 && arr_b[4] > 0) {
                        return 4;
                    }
                    if(v5 != 1 || arr_b[2] <= 0) {
                        return v5 != 1 || arr_b[3] <= 0 ? 1 : 3;
                    label_24:
                        int v7 = charSequence0.charAt(v3);
                        ++v2;
                        if(d.w(((char)v7))) {
                            arr_f[0] += 0.5f;
                        }
                        else if(d.x(((char)v7))) {
                            float f = (float)Math.ceil(arr_f[0]);
                            arr_f[0] = f;
                            arr_f[0] = f + 2.0f;
                        }
                        else {
                            float f1 = (float)Math.ceil(arr_f[0]);
                            arr_f[0] = f1;
                            arr_f[0] = f1 + 1.0f;
                        }
                        if(v7 == 0x20 || v7 >= 0x30 && v7 <= 57 || v7 >= 65 && v7 <= 90) {
                            arr_f[1] += 0.666667f;
                        }
                        else if(d.x(((char)v7))) {
                            arr_f[1] += 2.666667f;
                        }
                        else {
                            arr_f[1] += 1.333333f;
                        }
                        if(v7 == 0x20 || v7 >= 0x30 && v7 <= 57 || v7 >= 97 && v7 <= 0x7A) {
                            arr_f[2] += 0.666667f;
                        }
                        else if(d.x(((char)v7))) {
                            arr_f[2] += 2.666667f;
                        }
                        else {
                            arr_f[2] += 1.333333f;
                        }
                        if(d.y(((char)v7))) {
                            arr_f[3] += 0.666667f;
                        }
                        else if(d.x(((char)v7))) {
                            arr_f[3] += 4.333333f;
                        }
                        else {
                            arr_f[3] += 3.333333f;
                        }
                        if(v7 >= 0x20 && v7 <= 94) {
                            arr_f[4] += 0.75f;
                        }
                        else if(d.x(((char)v7))) {
                            arr_f[4] += 4.25f;
                        }
                        else {
                            arr_f[4] += 3.25f;
                        }
                        ++arr_f[5];
                        if(v2 < 4) {
                            continue;
                        }
                        break;
                    }
                    return 2;
                }
                int[] arr_v1 = new int[6];
                byte[] arr_b1 = new byte[6];
                d.t(arr_f, arr_v1, arr_b1);
                int v8 = 0;
                for(int v9 = 0; v9 < 6; ++v9) {
                    v8 += arr_b1[v9];
                }
                int v10 = arr_v1[0];
                int v11 = arr_v1[5];
                if(v10 < v11 && v10 < arr_v1[1] && v10 < arr_v1[2] && v10 < arr_v1[3] && v10 < arr_v1[4]) {
                    return 0;
                }
                if(v11 < v10) {
                    break alab1;
                }
                int v12 = arr_b1[2];
                int v13 = arr_b1[3];
                int v14 = arr_b1[4];
                if(arr_b1[1] + v12 + v13 + v14 == 0) {
                    break alab1;
                }
                if(v8 == 1 && v14 > 0) {
                    return 4;
                }
                if(v8 == 1 && v12 > 0) {
                    return 2;
                }
                if(v8 == 1 && v13 > 0) {
                    return 3;
                }
                int v15 = arr_v1[1];
                int v16 = v15 + 1;
                if(v16 < v10 && v16 < v11 && v16 < arr_v1[4] && v16 < arr_v1[2]) {
                    int v17 = arr_v1[3];
                    if(v15 >= v17) {
                        if(v15 != v17) {
                            goto label_8;
                        }
                        break;
                    }
                    return 1;
                }
            }
            int v18 = v + v2 + 1;
            while(v18 < charSequence0.length()) {
                int v19 = charSequence0.charAt(v18);
                if(v19 != 13 && v19 != 42 && v19 != 62) {
                    if(!d.y(((char)v19))) {
                        break;
                    }
                    ++v18;
                    continue;
                }
                return 3;
            }
            return 1;
        }
        return 5;
    }
}

