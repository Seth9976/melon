package e1;

import Ac.l1;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.w3;
import Df.t;
import M.p0;
import Me.N;
import N0.L;
import N0.M;
import Q0.w0;
import S1.c;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.B0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.m0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.u;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.f0;
import com.google.firebase.b;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import com.kakao.tiara.track.ViewImp;
import ed.s;
import gd.B2;
import i.n.i.b.a.s.e.M3;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import jd.Z0;
import jf.o;
import k8.Y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import m8.U;
import p8.q;
import q0.d;
import q8.h;
import q8.i;
import q8.j;
import r0.a;
import sf.g;
import u8.e;
import we.k;

public abstract class n {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;

    public static int A(float f, int v, int v1) {
        return c.h(c.k(v1, Math.round(((float)Color.alpha(v1)) * f)), v);
    }

    public static int B(Context context0, int v, int v1) {
        TypedValue typedValue0 = m.y(context0, v);
        return typedValue0 == null || typedValue0.type != 16 ? v1 : typedValue0.data;
    }

    public static TimeInterpolator C(Context context0, int v, TimeInterpolator timeInterpolator0) {
        TypedValue typedValue0 = new TypedValue();
        if(!context0.getTheme().resolveAttribute(v, typedValue0, true)) {
            return timeInterpolator0;
        }
        if(typedValue0.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String s = String.valueOf(typedValue0.string);
        if(!n.z(s, "cubic-bezier") && !n.z(s, "path")) {
            return AnimationUtils.loadInterpolator(context0, typedValue0.resourceId);
        }
        if(n.z(s, "cubic-bezier")) {
            String[] arr_s = s.substring(13, s.length() - 1).split(",");
            if(arr_s.length != 4) {
                throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + arr_s.length);
            }
            return new PathInterpolator(n.v(0, arr_s), n.v(1, arr_s), n.v(2, arr_s), n.v(3, arr_s));
        }
        if(!n.z(s, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: " + s);
        }
        return new PathInterpolator(b.y(s.substring(5, s.length() - 1)));
    }

    public static final ViewImp D(k k0) {
        j j0 = new j();  // 初始化器: LQb/h;-><init>()V
        j0.h = new ContentList();
        k0.invoke(j0);
        TiaraTracker tiaraTracker0 = q.c();
        String s = ((h)j0.b).a;
        ViewImp viewImp0 = s == null ? tiaraTracker0.trackViewImp() : tiaraTracker0.trackViewImp(s);
        kotlin.jvm.internal.q.d(viewImp0);
        q8.b b0 = (q8.b)j0.c;
        String s1 = null;
        viewImp0.section((b0 == null ? null : b0.a));
        q8.b b1 = (q8.b)j0.c;
        if(b1 != null) {
            s1 = b1.b;
        }
        viewImp0.page(s1);
        viewImp0.customProps(((LinkedHashMap)j0.g));
        viewImp0.adTrackId("2875552754074864296");
        viewImp0.viewImpContents(j0.h);
        return viewImp0;
    }

    public static final long E(long v) {
        return ((long)Float.floatToRawIntBits(((int)(v & 0xFFFFFFFFL)))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(((int)(v >> 0x20)))) << 0x20;
    }

    public static final ViewImpContent F(k k0) {
        i i0 = new i();
        k0.invoke(i0);
        return i0.build();
    }

    public static g G(k k0) {
        kotlin.jvm.internal.q.g(k0, "changeOptions");
        sf.j j0 = new sf.j();
        k0.invoke(j0);
        j0.a = true;
        return new g(j0);
    }

    public static H a(int v, y y0) {
        return new H(v, y0, new w(new v[0]));
    }

    public static final void b(m1.m m0, m0.b b0, l l0, int v) {
        ((p)l0).c0(0x9C7D7BAF);
        int v1 = (((p)l0).g(m0) ? 4 : 2) | v | (((p)l0).i(b0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            ((p)l0).p = true;
            ((p)l0).B = true;
            ((p)l0).c.g();
            ((p)l0).G.g();
            B0 b00 = ((p)l0).H.a;
            ((p)l0).H.e = b00.j;
            ((p)l0).H.f = b00.k;
            kotlin.jvm.internal.q.e(m0, "null cannot be cast to non-null type androidx.compose.ui.tooling.CompositionDataRecordImpl");
            Set set0 = m0.a;
            u u0 = ((p)l0).Q;
            if(u0 == null) {
                u0 = new u(((p)l0).g);
                ((p)l0).Q = u0;
            }
            set0.add(u0);
            androidx.compose.runtime.w.b(new m0[]{w0.a.a(Boolean.TRUE), d.a.a(set0)}, b0, ((p)l0), v1 & 0x70 | 8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new B2.p(m0, b0, v, 22);
        }
    }

    public static final long c(int v, int v1) [...] // Inlined contents

    public static final void d(gd.w w0, int v, k k0, l l0, int v1) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        p p0 = (p)l0;
        p0.c0(0x8AA489AE);
        int v2 = (v1 & 6) == 0 ? (p0.g(w0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.q(n0, 144.0f);
            s s0 = p0.N();
            if(s0 == androidx.compose.runtime.k.a) {
                s0 = new s(11);
                p0.l0(s0);
            }
            r0.q q1 = a.a(X0.n.c(q0, false, s0), new gd.s(k0, w0, v, 0));
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = e0.L(androidx.compose.foundation.layout.d.n(n0, 144.0f), 0x7F06014A);  // color:gray100a
            Drawable drawable0 = ViewUtils.getDefaultImage(context0, ((int)e0.a0(144.0f, p0)), false);
            w3.h(w0.a, q4, drawable0, p0, 0, 0);
            r0.q q5 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 6.0f, 0.0f, 9), 24.0f);
            c1.n(a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.c), new gd.s(k0, w0, v, 2)), 0x7F080309, "재생", null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FF8);  // drawable:common_btn_play_01
            p0.p(true);
            N1.b((w0.b == null ? "" : w0.b), a.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 7.0f, 6.0f, 0.0f, 9), new gd.s(k0, w0, v, 1)), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F0);  // color:gray900s
            long v5 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b((w0.d == null ? "" : w0.d), androidx.compose.foundation.layout.a.n(n0, 0.0f, 6.0f, 0.0f, 0.0f, 13), v5, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            A7.d.v(n0, 20.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(w0, v, k0, v1, 10);
        }
    }

    public static final void e(B2 b20, k k0, l l0, int v) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        ((p)l0).c0(0xB8CFF4DC);
        int v1 = (((p)l0).i(b20) ? 4 : 2) | v | (((p)l0).i(k0) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, 20.0f, 7);
            df.v.d(b20.a, q0, "전체보기", true, b20, k0, ((p)l0), 0xE000 & v1 << 12 | 0xC30 | v1 << 12 & 0x70000, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 4);
        }
    }

    public static final void f(k k0, l l0, int v) {
        P0.h h5;
        P0.i i3;
        P0.h h4;
        P0.i i2;
        p p0 = (p)l0;
        p0.c0(0x5B9FF015);
        int v1 = v | (p0.i(k0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(e0.X(n0, context0, p0), 1.0f), 48.0f);
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            P0.h h3 = P0.j.d;
            c1.n(q2, 0x7F080660, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:img_musicwave_logo_18
            M.c.d(p0, new LayoutWeightElement(1.0f, true));
            r0.q q3 = a.a(androidx.compose.foundation.layout.d.n(n0, 48.0f), new l1(29, k0));
            r0.i i1 = r0.d.e;
            M m0 = M.p.d(i1, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                i2 = i0;
                p0.l(i2);
            }
            else {
                i2 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v3)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v3, p0, v3, h4);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            c1.n(null, 0x7F0801D3, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:btn_gnb_cpplaylist_search
            p0.p(true);
            int v4 = ScreenUtils.isDarkMode(context0) ? 0x7F0801D6 : 0x7F0801D8;  // drawable:btn_gnb_more
            r0.q q5 = a.a(androidx.compose.foundation.layout.d.n(n0, 48.0f), new Z0(0, k0));
            M m1 = M.p.d(i1, false);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                i3 = i2;
                p0.l(i3);
            }
            else {
                i3 = i2;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v5)) {
                h5 = h4;
            }
            else {
                h5 = h4;
                A7.d.q(v5, p0, v5, h5);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            c1.n(null, v4, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFD);
            p0.p(true);
            r0.q q7 = a.a(androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 8.0f, 0.0f, 11), 48.0f), new Z0(1, k0));
            M m2 = M.p.d(i1, false);
            int v6 = p0.P;
            i0 i03 = p0.m();
            r0.q q8 = a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m2, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h5);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            c1.n(null, 0x7F080230, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:btn_player_gnb_down
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Rc.q(k0, v, 5);
        }
    }

    public static v8.i g(u8.d d0, v9.i i0) {
        kotlin.jvm.internal.q.g(d0, "<this>");
        HttpResponse httpResponse0 = d0.b;
        if(d0.a == e.a) {
            return httpResponse0 == null || !httpResponse0.isSuccessful(true) ? new v8.i(v8.h.b, i0, httpResponse0, null) : new v8.i(v8.h.a, i0, httpResponse0, null);
        }
        return new v8.i(v8.h.c, i0, null, d0.c);
    }

    public static final void h(x1.s s0, List list0) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            L l0 = (L)list0.get(v1);
            x1.b b0 = androidx.compose.ui.layout.a.a(l0);
            if(b0 == null) {
                l0.q();
                b0 = new x1.b();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            C1.b b1 = s0.b(b0.toString());
            if(b1 != null) {
                b1.f0 = l0;
                F1.e e0 = b1.g0;
                if(e0 != null) {
                    e0.i0 = l0;
                }
            }
            l0.q();
        }
    }

    public static final boolean i(PlaylistId playlistId0) {
        kotlin.jvm.internal.q.g(playlistId0, "<this>");
        return e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.SMART, PlaylistId.DRAWER}).contains(playlistId0);
    }

    public static final boolean j(PlaylistId playlistId0) {
        kotlin.jvm.internal.q.g(playlistId0, "<this>");
        return e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.SMART, PlaylistId.DRAWER}).contains(playlistId0);
    }

    public static final boolean k(PlaylistId playlistId0) {
        kotlin.jvm.internal.q.g(playlistId0, "<this>");
        return e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.SMART, PlaylistId.DRAWER, PlaylistId.MIX_UP, PlaylistId.STATION, PlaylistId.VOD}).contains(playlistId0);
    }

    public static int l(int v, int v1) {
        return c.k(v, Color.alpha(v) * v1 / 0xFF);
    }

    public static final ArrayList m(Iterable iterable0, k k0, k k1) {
        kotlin.jvm.internal.q.g(iterable0, "$this$createServerList");
        Y.r(com.iloen.melon.utils.a.a, "protocol");
        switch(e0.b.b(com.iloen.melon.utils.a.a)) {
            case 0: {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: iterable0) {
                    if(d5.w.K(((NetworkInterface)object0))) {
                        arrayList0.add(object0);
                    }
                }
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: arrayList0) {
                    Object object2 = k0.invoke(((NetworkInterface)object1));
                    if(object2 != null) {
                        arrayList1.add(object2);
                    }
                }
                return arrayList1;
            }
            case 1: {
                ArrayList arrayList2 = new ArrayList();
                for(Object object3: iterable0) {
                    if(d5.w.L(((NetworkInterface)object3))) {
                        arrayList2.add(object3);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                for(Object object4: arrayList2) {
                    Object object5 = k1.invoke(((NetworkInterface)object4));
                    if(object5 != null) {
                        arrayList3.add(object5);
                    }
                }
                return arrayList3;
            }
            case 2: {
                ArrayList arrayList4 = new ArrayList();
                for(Object object6: iterable0) {
                    NetworkInterface networkInterface0 = (NetworkInterface)object6;
                    if(d5.w.K(networkInterface0)) {
                        Object object7 = k0.invoke(networkInterface0);
                        if(object7 != null) {
                            arrayList4.add(object7);
                        }
                    }
                    if(d5.w.L(networkInterface0)) {
                        Object object8 = k1.invoke(networkInterface0);
                        if(object8 != null) {
                            arrayList4.add(object8);
                        }
                    }
                }
                return arrayList4;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static void n(BaseActivity baseActivity0, Uri uri0) {
        String s = uri0.getPath();
        if(s != null && s.hashCode() == 0 && s.equals("") && baseActivity0 != null) {
            String s1 = uri0.getQueryParameter("loginType");
            String s2 = uri0.getQueryParameter("url");
            String s3 = uri0.getQueryParameter("otp");
            String s4 = uri0.getQueryParameter("viewType");
            String s5 = uri0.getQueryParameter("close");
            m8.c c0 = new m8.c(1);
            BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new U(c0, (s1 == null ? "" : s1), s2, baseActivity0, s3, s5, s4, null), 3, null);
        }
    }

    public static int o(Context context0, int v, int v1) {
        TypedValue typedValue0 = m.y(context0, v);
        if(typedValue0 == null) {
            throw new NullPointerException();
        }
        Integer integer0 = (int)(typedValue0.resourceId == 0 ? typedValue0.data : P1.c.getColor(context0, typedValue0.resourceId));
        return integer0 == null ? v1 : ((int)integer0);
    }

    public static int p(Context context0, int v, String s) {
        TypedValue typedValue0 = m.A(context0, v, s);
        return typedValue0.resourceId == 0 ? typedValue0.data : P1.c.getColor(context0, typedValue0.resourceId);
    }

    public static int q(View view0, int v) {
        Context context0 = view0.getContext();
        TypedValue typedValue0 = m.A(view0.getContext(), v, view0.getClass().getCanonicalName());
        return typedValue0.resourceId == 0 ? typedValue0.data : P1.c.getColor(context0, typedValue0.resourceId);
    }

    public static ColorStateList r(Context context0, TypedArray typedArray0, int v) {
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            if(v1 != 0) {
                ColorStateList colorStateList0 = P1.c.getColorStateList(context0, v1);
                return colorStateList0 == null ? typedArray0.getColorStateList(v) : colorStateList0;
            }
        }
        return typedArray0.getColorStateList(v);
    }

    public static ColorStateList s(Context context0, d5.m m0, int v) {
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            if(v1 != 0) {
                ColorStateList colorStateList0 = P1.c.getColorStateList(context0, v1);
                return colorStateList0 == null ? m0.j(v) : colorStateList0;
            }
        }
        return m0.j(v);
    }

    public static int t(Context context0, TypedArray typedArray0, int v, int v1) {
        TypedValue typedValue0 = new TypedValue();
        if(typedArray0.getValue(v, typedValue0) && typedValue0.type == 2) {
            TypedArray typedArray1 = context0.getTheme().obtainStyledAttributes(new int[]{typedValue0.data});
            int v2 = typedArray1.getDimensionPixelSize(0, v1);
            typedArray1.recycle();
            return v2;
        }
        return typedArray0.getDimensionPixelSize(v, v1);
    }

    public static Drawable u(Context context0, TypedArray typedArray0, int v) {
        if(typedArray0.hasValue(v)) {
            int v1 = typedArray0.getResourceId(v, 0);
            if(v1 != 0) {
                Drawable drawable0 = d5.w.B(context0, v1);
                return drawable0 == null ? typedArray0.getDrawable(v) : drawable0;
            }
        }
        return typedArray0.getDrawable(v);
    }

    public static float v(int v, String[] arr_s) {
        float f = Float.parseFloat(arr_s[v]);
        if(f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
        }
        return f;
    }

    public static Re.c w(Df.u u0, boolean z, boolean z1, Boolean boolean0, boolean z2, Re.b b0, nf.e e0) {
        kotlin.jvm.internal.q.g(u0, "container");
        N n0 = (N)u0.d;
        kotlin.jvm.internal.q.g(e0, "metadataVersion");
        lf.j j0 = lf.j.c;
        if(z) {
            if(boolean0 == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + u0 + ')').toString());
            }
            if(u0 instanceof Df.s && ((Df.s)u0).h == j0) {
                qf.e e1 = qf.e.e("DefaultImpls");
                return G.q(b0, ((Df.s)u0).g.d(e1), e0);
            }
            if(boolean0.booleanValue() && u0 instanceof t) {
                jf.g g0 = n0 instanceof jf.g ? ((jf.g)n0) : null;
                yf.b b1 = g0 == null ? null : g0.b;
                if(b1 != null) {
                    String s = b1.d();
                    kotlin.jvm.internal.q.f(s, "getInternalName(...)");
                    qf.c c0 = new qf.c(Tf.v.o0(s, '/', '.'));
                    return G.q(b0, new qf.b(c0.b(), c0.a.f()), e0);
                }
            }
        }
        if(z1 && u0 instanceof Df.s && ((Df.s)u0).h == lf.j.f) {
            Df.s s1 = ((Df.s)u0).f;
            if(s1 != null && (s1.h == lf.j.b || s1.h == lf.j.d || z2 && (s1.h == j0 || s1.h == lf.j.e))) {
                N n1 = (N)s1.d;
                o o0 = n1 instanceof o ? ((o)n1) : null;
                return o0 == null ? null : o0.a;
            }
        }
        if(u0 instanceof t && n0 instanceof jf.g) {
            kotlin.jvm.internal.q.e(n0, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            Re.c c1 = ((jf.g)n0).c;
            return c1 == null ? G.q(b0, ((jf.g)n0).b(), e0) : c1;
        }
        return null;
    }

    public static boolean x(int v) [...] // Inlined contents

    public static boolean y(Context context0) {
        return context0.getResources().getConfiguration().fontScale >= 1.3f;
    }

    // 去混淆评级： 低(20)
    public static boolean z(String s, String s1) {
        return s.startsWith(s1 + "(") && s.endsWith(")");
    }
}

