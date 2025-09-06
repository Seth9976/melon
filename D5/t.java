package d5;

import Cc.c3;
import Cc.e0;
import Dd.g0;
import H0.b;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import Q0.k0;
import T.e;
import Tf.v;
import U8.z;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager.WakeLock;
import androidx.collection.K;
import androidx.collection.L;
import androidx.compose.foundation.D0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.mediarouter.media.MediaRouteProvider;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.melonchart.MelonChartPagerFragment;
import com.iloen.melon.fragments.mymusic.MyMusicTabFragment;
import com.iloen.melon.fragments.news.FeedLogsListFragment;
import com.iloen.melon.utils.Navigator;
import com.melon.playlist.mixup.DjMalrangInfo;
import df.B;
import e1.u;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.m;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import je.D;
import k8.Y;
import kotlin.jvm.internal.N;
import m0.c;
import pc.Z;
import r0.g;
import r0.n;
import r0.q;
import r1.f;
import va.o;
import we.a;

public abstract class t {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static PowerManager.WakeLock h;

    public static final void a(l l0, int v) {
        ((p)l0).c0(1903813942);
        int v1 = (v & 6) == 0 ? (((p)l0).g(null) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(null) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).g(null) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((p)l0).g(null) ? 0x800 : 0x400);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Object object0 = ((p)l0).k(k0.h);
            b0 b00 = ((p)l0).N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(new f(0.0f));
                ((p)l0).l0(b00);
            }
            b0 b01 = ((p)l0).N();
            if(b01 == v2) {
                b01 = w.s(Boolean.FALSE);
                ((p)l0).l0(b01);
            }
            float f = ((Boolean)b01.getValue()).booleanValue() ? 7.0f : 0.0f;
            Object object1 = ((p)l0).k(AndroidCompositionLocals_androidKt.b);
            w.a(D0.a.a(null), c.e(1972090998, ((p)l0), new vd.l(f, 339.0f, ((r1.c)object0), b00, b01, ((Context)object1))), ((p)l0), 56);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 20, 0);
        }
    }

    public static final void b(String s, a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x7E855191);
        int v1 = (p0.g(s) ? 4 : 2) | v | (p0.g(null) ? 0x20 : 16) | (p0.g(null) ? 0x100 : 0x80) | (p0.g(null) ? 0x800 : 0x400) | (p0.g(null) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            n n0 = n.a;
            q q0 = d.q(d.j(n0, 0.0f, 440.0f, 1), 270.0f);
            M m0 = M.p.d(r0.d.e, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            w.x(p0, q1, h3);
            q q2 = androidx.compose.foundation.q.f(d5.n.o(n0, e.b(12.0f)), e0.T(p0, 0x7F0604AB), y0.M.a);  // color:white001s
            M.d d0 = M.j.c;
            y y0 = M.w.a(d0, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            q q4 = d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 22.0f, 20.0f, 0.0f, 8), 1.0f);
            g g0 = r0.d.n;
            y y1 = M.w.a(d0, g0, p0, 0x30);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q5, h3);
            yd.h.c(s, p0, v1 & 14);
            M.c.d(p0, d.h(n0, 12.0f));
            t.a(p0, v1 >> 3 & 0x1FFE);
            p0.p(true);
            e0.C(d.f(n0, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
            yd.h.b(false, true, b.q(g0, d.h(d.f(n0, 1.0f), 44.0f)), null, null, false, null, null, a0, p0, v1 << 9 & 0xE000000 | 54, 0xF8);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c3(s, a0, v, 1);
        }
    }

    public static final void c(K k0, Object object0, Object object1) {
        int v = k0.f(object0);
        Object object2 = v >= 0 ? null : k0.c[v];
        if(object2 != null) {
            if(object2 instanceof L) {
                ((L)object2).a(object1);
                object1 = object2;
            }
            else if(object2 == object1) {
                object1 = object2;
            }
            else {
                L l0 = new L();
                l0.a(object2);
                l0.a(object1);
                object1 = l0;
            }
        }
        if(v < 0) {
            k0.b[~v] = object0;
            k0.c[~v] = object1;
            return;
        }
        k0.c[v] = object1;
    }

    public static final Object d(Object object0, boolean z) {
        kotlin.jvm.internal.q.g(object0, "possiblyPrimitiveType");
        if(z) {
            object0 = (jf.k)object0;
            if(object0 instanceof jf.j) {
                yf.c c0 = ((jf.j)object0).i;
                if(c0 != null) {
                    qf.c c1 = c0.d;
                    if(c1 != null) {
                        String s = yf.b.b(c1).d();
                        kotlin.jvm.internal.q.f(s, "getInternalName(...)");
                        return jf.f.d(s);
                    }
                    yf.c.a(15);
                    throw null;
                }
            }
        }
        return object0;
    }

    public static void e(Object object0) {
        if(object0 == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    public static K f() {
        return new K();
    }

    public static void g(Uri uri0) {
        String s10;
        String s = uri0.getPath();
        if(s != null) {
            int v = 0;
            switch(s) {
                case "": {
                    MelonFragmentManager.getInstance().open(MelonChartPagerFragment.newInstance());
                    return;
                }
                case "/age": {
                    String s3 = uri0.getQueryParameter("type");
                    String s4 = uri0.getQueryParameter("year");
                    String s5 = uri0.getQueryParameter("genre");
                    Navigator.INSTANCE.openChartAge(s3, s4, s5);
                    return;
                }
                case "/artist": {
                    Navigator.INSTANCE.openChartArtist();
                    return;
                }
                case "/genre": {
                    String s7 = uri0.getQueryParameter("genreCode");
                    Navigator.INSTANCE.openChartGenre(s7);
                    return;
                }
                case "/hot100": {
                    String s8 = uri0.getQueryParameter("filtercode");
                    if(kotlin.jvm.internal.q.b(s8, "d100")) {
                        v = 1;
                    }
                    else if(!kotlin.jvm.internal.q.b(s8, "d30")) {
                        v = 1;
                    }
                    Navigator.INSTANCE.openPeriodChart("H", v);
                    return;
                }
                case "/hot100/graph": {
                    String s6 = uri0.getQueryParameter("time");
                    Navigator.INSTANCE.openHot100Graph(s6);
                    return;
                }
                case "/hottrack": {
                    Navigator.INSTANCE.openChartHottrack();
                    return;
                }
                case "/hottrackdetail": {
                    String s1 = uri0.getQueryParameter("hottrackcode");
                    String s2 = uri0.getQueryParameter("filtercode");
                    Navigator.INSTANCE.openChartHottrackDetail(s1, s2);
                    return;
                }
                case "/shortcut": {
                    d3.g.a0("5", "R01", "E1");
                    MelonFragmentManager.getInstance().open(MelonChartPagerFragment.newInstance());
                    return;
                }
                case "/theme": {
                    Navigator.INSTANCE.openChartTheme();
                    return;
                }
                case "/top100": {
                    String s9 = uri0.getQueryParameter("period");
                    if(s9 == null) {
                        s10 = "T";
                    }
                    else {
                        switch(s9) {
                            case "DAILY": {
                                s10 = "D";
                                break;
                            }
                            case "MONTHLY": {
                                s10 = "M";
                                break;
                            }
                            case "WEEKLY": {
                                s10 = "W";
                                break;
                            }
                            default: {
                                s10 = "T";
                            }
                        }
                    }
                    Navigator.openPeriodChart$default(Navigator.INSTANCE, s10, 0, 2, null);
                    break;
                }
            }
        }
    }

    public static void h(Uri uri0) {
        String s = uri0.getPath();
        if(s != null) {
            int v = s.hashCode();
            boolean z = false;
            switch(v) {
                case -860101486: {
                    if(s.equals("/myorother")) {
                        String s1 = u0.y(uri0, "targetMemberKey");
                        if(s1 != null) {
                            if(((va.e0)o.a()).m() && u.v(((va.e0)o.a()).j()).equals(s1)) {
                                Navigator navigator0 = Navigator.INSTANCE;
                                g0 g00 = new g0();
                                Bundle bundle0 = Y.b("argMemberKey", s1);
                                if(u.o(s1) && s1.equals(u.v(((va.e0)o.a()).j()))) {
                                    z = true;
                                }
                                bundle0.putBoolean("argIsMySelf", z);
                                g00.setArguments(bundle0);
                                navigator0.open(g00);
                                return;
                            }
                            Navigator.openUserMain(s1);
                            return;
                        }
                    }
                    break;
                }
                case 0: {
                    if(s.equals("")) {
                        Set set0 = uri0.getQueryParameterNames();
                        kotlin.jvm.internal.q.f(set0, "getQueryParameterNames(...)");
                        int v1 = D.N(je.q.Q(10, set0));
                        if(v1 < 16) {
                            v1 = 16;
                        }
                        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v1);
                        for(Object object0: set0) {
                            linkedHashMap0.put(object0, uri0.getQueryParameter(((String)object0)));
                        }
                        String s2 = (String)linkedHashMap0.get("mode");
                        String s3 = (String)linkedHashMap0.get("tab");
                        String s4 = (String)linkedHashMap0.get("term");
                        if(s2 == null || Tf.o.H0(s2)) {
                            Navigator.openMainLibrary$default(Navigator.INSTANCE, false, false, 2, null);
                            return;
                        }
                        switch(s2) {
                            case "fanArtist": {
                                goto label_47;
                            }
                            case "like": {
                                Navigator.open(MyMusicTabFragment.Companion.newInstance("mylike", 0));
                                return;
                            }
                            case "manyListen": {
                                goto label_65;
                            }
                            case "playlist": {
                                Navigator.open(MyMusicTabFragment.Companion.newInstance("playlist", 1));
                                return;
                            }
                            case "recentListen": {
                                goto label_53;
                            }
                        }
                        Navigator.open(MyMusicTabFragment.Companion.newInstance("mylike", 0));
                        return;
                    label_47:
                        if(!kotlin.jvm.internal.q.b(s3, "fan") && kotlin.jvm.internal.q.b(s3, "friendly")) {
                            z = true;
                        }
                        Navigator.open(MyMusicTabFragment.Companion.newInstance("fanartist", ((int)z)));
                        return;
                    label_53:
                        if(s3 != null) {
                            switch(s3) {
                                case "mv": {
                                    z = true;
                                    break;
                                }
                                case "playlist": {
                                    z = true;
                                    break;
                                }
                                case "station": {
                                    z = false;
                                }
                            }
                        }
                        Navigator.open(MyMusicTabFragment.Companion.newInstance("listen", ((int)z)));
                        return;
                    label_65:
                        if(s3 != null) {
                            switch(s3) {
                                case "1m": {
                                    Navigator.open(MyMusicTabFragment.Companion.newInstance("mychart", 1));
                                    return;
                                }
                                case "1w": {
                                    Navigator.open(MyMusicTabFragment.Companion.newInstance("mychart", 0));
                                    return;
                                }
                                case "3m": {
                                    Navigator.open(MyMusicTabFragment.Companion.newInstance("mychart", 2));
                                    return;
                                }
                                case "period": {
                                    Navigator.INSTANCE.openMyMusicMyChartSpecificMonth(s4);
                                    return;
                                }
                                default: {
                                    return;
                                }
                            }
                            Navigator.openMainLibrary$default(Navigator.INSTANCE, false, false, 2, null);
                            return;
                        }
                    }
                    break;
                }
                default: {
                    if(v == 0x566C6B49 && s.equals("/mylog")) {
                        m8.Y y0 = new m8.Y();  // 初始化器: Ljava/lang/Object;-><init>()V
                        y0.i1(uri0);
                        if(!((va.e0)o.a()).m()) {
                            Navigator.openLoginView(y0.c1());
                            return;
                        }
                        Navigator.open(FeedLogsListFragment.Companion.newInstance());
                    }
                }
            }
        }
    }

    public static final d5.j i(d5.q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        return new d5.j(q0.a, q0.t);
    }

    public static final List j() {
        Enumeration enumeration0;
        List list0 = null;
        try {
            enumeration0 = null;
            enumeration0 = NetworkInterface.getNetworkInterfaces();
        }
        catch(Throwable unused_ex) {
        }
        if(enumeration0 != null) {
            list0 = Collections.list(enumeration0);
            kotlin.jvm.internal.q.f(list0, "java.util.Collections.list(this)");
        }
        return list0 == null ? je.w.a : list0;
    }

    public static final boolean k(pc.d d0) {
        kotlin.jvm.internal.q.g(d0, "<this>");
        return ((Z)d0).m().c instanceof DjMalrangInfo;
    }

    public static final d5.l l(we.n n0, we.k k0) {
        F.e e0 = new F.e(n0);
        N.e(1, k0);
        return new d5.l(13, e0, k0);
    }

    public abstract void m(MediaRouteProvider arg1, B arg2);

    public static void n() {
        if(t.h != null && t.h.isHeld()) {
            t.h.release();
            t.h = null;
        }
    }

    public static final boolean o(K k0, Object object0, Object object1) {
        Object object2 = k0.g(object0);
        if(object2 == null) {
            return false;
        }
        if(object2 instanceof L) {
            boolean z = ((L)object2).l(object1);
            if(z && ((L)object2).g()) {
                k0.j(object0);
            }
            return z;
        }
        if(object2.equals(object1)) {
            k0.j(object0);
            return true;
        }
        return false;
    }

    public static final void p(K k0, Object object0) {
        boolean z;
        long[] arr_v = k0.a;
        int v = arr_v.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            Object object1 = k0.b[v5];
                            Object object2 = k0.c[v5];
                            if(object2 instanceof L) {
                                kotlin.jvm.internal.q.e(object2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                ((L)object2).l(object0);
                                z = ((L)object2).g();
                            }
                            else {
                                z = object2 == object0;
                            }
                            if(z) {
                                k0.k(v5);
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_25;
                    }
                    break;
                }
            label_25:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
    }

    public static final q q(q q0, float f) {
        return f == 0.0f ? q0 : androidx.compose.ui.graphics.a.b(q0, 0.0f, 0.0f, 0.0f, 0.0f, f, null, false, 0x1FEFF);
    }

    public static final qf.c r(qf.c c0, qf.c c1) {
        kotlin.jvm.internal.q.g(c0, "<this>");
        qf.d d0 = c0.a;
        kotlin.jvm.internal.q.g(c1, "prefix");
        qf.d d1 = c1.a;
        if((c0.equals(c1) || d1.c() || v.r0(d0.a, d1.a, false) && d0.a.charAt(d1.a.length()) == 46) && !d1.c()) {
            if(c0.equals(c1)) {
                return qf.c.c;
            }
            String s = d0.a.substring(d1.a.length() + 1);
            kotlin.jvm.internal.q.f(s, "substring(...)");
            return new qf.c(s);
        }
        return c0;
    }

    public static final m s(Object object0, Object object1) {
        return new m(object0, object1);
    }

    public static final int t(e1.m m0, u5.f f0) {
        if(m0 instanceof u5.a) {
            return ((u5.a)m0).e;
        }
        switch(f0.ordinal()) {
            case 0: {
                return 0x80000000;
            }
            case 1: {
                return 0x7FFFFFFF;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

