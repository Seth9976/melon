package e1;

import B3.s;
import Cc.M0;
import Cc.N1;
import Cc.U;
import Cc.c1;
import Cc.e0;
import Cc.h0;
import Cc.w3;
import Dd.k2;
import M.j0;
import M.n0;
import M.p0;
import M.y;
import M6.B;
import N0.M;
import P0.h;
import P0.i;
import Q0.D;
import Q0.k0;
import T.e;
import U4.x;
import U8.K;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkRequest.Builder;
import android.net.Uri;
import android.os.SystemClock;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.c;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.f0;
import androidx.media3.session.G0;
import androidx.media3.session.N;
import b3.I;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.SchemeAllowedUrlManager;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.playlist.interfaces.PlayableData;
import dd.z;
import e3.p;
import gd.B2;
import gd.E2;
import gd.o6;
import gd.r6;
import gd.u6;
import gd.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import je.w;
import k8.Y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import m8.F;
import m8.G;
import m8.m;
import m8.r;
import m8.t;
import oc.Q;
import r0.g;
import s5.f;
import v3.o;
import w9.a;
import x0.d;
import y8.j;
import y8.k;
import y8.q;

public abstract class b {
    public static final int a;
    public static final int b;
    public static final int c;

    public static String A(int v, int v1) {
        switch(v) {
            case 6: {
                String s = MelonPrefs.getInstance().getString("EqualizerName10B", "");
                return s == null ? "" : s;
            }
            case 7: {
                j j0 = q.a(v1);
                if(j0 != null) {
                    return j0.d == null ? "" : j0.d;
                }
                return "";
            }
            case 11: {
                return "";
            }
            case 12: {
                return "";
            }
            default: {
                return "";
            }
        }
    }

    public static final ArrayList B(Q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        Iterable iterable0 = q0.c();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(((PlayableData)object0).a);
        }
        return arrayList0;
    }

    public abstract float C(v6.j arg1);

    public static final boolean D(Q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        return q0.c().isEmpty();
    }

    public static final boolean E(d d0) {
        return d0.e >>> 0x20 == (0xFFFFFFFFL & d0.e) && d0.e == d0.f && d0.e == d0.g && d0.e == d0.h;
    }

    public static k F() {
        float[] arr_f2;
        List list0;
        int v2;
        String s = "";
        String s1 = MelonPrefs.getInstance().getString("g_eq_status", "");
        if(s1 != null) {
            s = s1;
        }
        if(s.length() > 0) {
            Object object0 = new n().e(s, k.class);
            kotlin.jvm.internal.q.d(object0);
            return (k)object0;
        }
        int v = MelonPrefs.getInstance().getInt("EqualizerType10B", -1);
        int v1 = MelonPrefs.getInstance().getInt("Equalizerid10B", -1);
        switch(v) {
            case 5: {
                v2 = 6;
                break;
            }
            case 7: {
                v2 = q.a(v1) == null ? 11 : 7;
                break;
            }
            case 6: 
            case 11: {
                v2 = v;
                break;
            }
            default: {
                v2 = v == 12 ? 12 : 11;
            }
        }
        float[] arr_f = null;
        switch(v2) {
            case 5: 
            case 6: {
                MelonDb melonDb0 = a.a.h();
                if(melonDb0 == null) {
                    list0 = w.a;
                }
                else {
                    list0 = melonDb0.fetchUserEqualizer();
                    melonDb0.close();
                    if(list0 == null) {
                        list0 = w.a;
                    }
                }
                Object object1 = null;
                for(Object object2: list0) {
                    if(((K)object2).b == v1) {
                        object1 = object2;
                        break;
                    }
                }
                if(((K)object1) != null) {
                    arr_f = ((K)object1).e;
                }
                break;
            }
            case 7: {
                j j0 = q.a(v1);
                if(j0 != null) {
                    arr_f = j0.e;
                }
            }
        }
        int v4 = MelonPrefs.getInstance().getInt("EqualizerStatus", 0);
        String s2 = b.A(v2, v1);
        if(arr_f == null) {
            float[] arr_f1 = new float[10];
            for(int v3 = 0; v3 < 10; ++v3) {
                arr_f1[v3] = 0.0f;
            }
            arr_f2 = arr_f1;
        }
        else {
            arr_f2 = arr_f;
        }
        k k0 = new k(v4, v2, v1, s2, arr_f2);
        MelonPrefs.getInstance().setString("g_eq_status", new n().k(k0));
        return k0;
    }

    public static final long G(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) + ((float)(((int)(v1 >> 0x20)))))) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + ((float)(((int)(v1 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL;
    }

    public static final void H(E0 e00, c c0, int v) {
        while((v <= e00.v || v >= e00.u) && (e00.v != 0 || v != 0)) {
            e00.J();
            if(e00.w(e00.v)) {
                c0.q();
            }
            e00.i();
        }
    }

    public static String I(InputStream inputStream0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(Math.max(inputStream0.available(), 1500));
        while(true) {
            int v = inputStream0.read();
            if(v >= 0) {
                if(v == 10) {
                    goto label_6;
                }
            }
            else if(byteArrayOutputStream0.size() == 0) {
                throw new IOException("can\'t read from InputStream");
            }
            else {
            label_6:
                String s = byteArrayOutputStream0.toString("UTF-8");
                kotlin.jvm.internal.q.f(s, "toOutputStream {\n       …ng(Charsets.UTF_8.name())");
                return s;
            }
            if(v != 13) {
                byteArrayOutputStream0.write(v);
            }
        }
    }

    public static final long J(long v) {
        return ((long)Math.round(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Math.round(Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
    }

    public abstract void K(v6.j arg1, float arg2);

    public static N L(int v, s s0, p p0) {
        N n0 = N.a(s0, p0);
        int v1;
        while((v1 = n0.a) != v) {
            com.iloen.melon.utils.a.r(v1, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long v2 = n0.b % 2L == 0L ? n0.b + 8L : n0.b + 9L;
            if(v2 > 0x7FFFFFFFL) {
                throw I.c(("Chunk is too large (~2GB+) to skip; id: " + v1));
            }
            s0.skipFully(((int)v2));
            n0 = N.a(s0, p0);
        }
        return n0;
    }

    public static float M(float f, float f1, float f2, int v) {
        return v <= 0 ? f : f2 / 2.0f + f1;
    }

    public static final void a(v v0, int v1, we.k k0, l l0, int v2) {
        long v10;
        String s3;
        Integer integer0;
        String s = v0.d;
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xAF8EDDD2);
        int v3 = (v2 & 6) == 0 ? (p0.g(v0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.e(v1) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            Object object0 = p0.k(AndroidCompositionLocals_androidKt.b);
            int v4 = ScreenUtils.dipToPixel(((Context)object0), 380.0f);
            if(ScreenUtils.isPortrait(((Context)object0))) {
                v4 = ScreenUtils.getScreenWidth(((Context)object0)) - ScreenUtils.dipToPixel(((Context)object0), 20.0f) * 2;
            }
            float f = ((r1.c)p0.k(k0.h)).R(v4);
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.q(n0, f);
            ed.s s1 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(s1 == v5) {
                s1 = new ed.s(6);
                p0.l0(s1);
            }
            r0.q q1 = r0.a.a(X0.n.c(q0, false, s1), new gd.j(k0, v0, v1, 0));
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v6 = p0.P;
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
            androidx.compose.runtime.w.x(p0, p00, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 6.0f, 0.0f, 11);
            M m0 = M.p.d(r0.d.a, false);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            r0.q q5 = d5.n.o(androidx.compose.foundation.layout.d.n(n0, 80.0f), e.b(4.0f));
            Drawable drawable0 = ViewUtils.getDefaultImage(((Context)object0), ((int)e0.a0(80.0f, p0)), false);
            w3.h(v0.a, q5, drawable0, p0, 0, 0);
            r0.q q6 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 4.0f, 0.0f, 9);
            c1.n(r0.a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.c), new gd.j(k0, v0, v1, 1)), 0x7F080309, "재생", N0.j.g, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC30, 0, 0x7FF0);  // drawable:common_btn_play_01
            p0.p(true);
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 21.0f, 6.0f, 0.0f, 9);
            M.d d0 = M.j.c;
            g g0 = r0.d.m;
            y y0 = M.w.a(d0, g0, p0, 0);
            int v8 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            String s2 = v0.e == null ? "" : v0.e;
            r0.q q9 = androidx.compose.foundation.layout.d.q(n0, 29.0f);
            z z0 = p0.N();
            if((v3 & 14) == 4 || z0 == v5) {
                z0 = new z(v0, 12);
                p0.l0(z0);
            }
            N1.b(s2, X0.n.c(q9, false, z0), e0.T(p0, 0x7F06016D), 17.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:gray900s
            r0.q q10 = androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 4.0f, 0.0f, 0.0f, 13), 29.0f);
            r0.h h4 = r0.d.k;
            p0 p01 = n0.a(M.j.e, h4, p0, 54);
            int v9 = p0.P;
            i0 i03 = p0.m();
            r0.q q11 = r0.a.d(p0, q10);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            androidx.compose.runtime.w.x(p0, q11, h3);
            if(s == null) {
                integer0 = null;
            }
            else {
                switch(s) {
                    case "DOWN": {
                        integer0 = 0x7F0803D7;  // drawable:ic_common_arrow_down
                        break;
                    }
                    case "NEW": {
                        integer0 = 0x7F080401;  // drawable:ic_common_new
                        break;
                    }
                    case "NONE": {
                        integer0 = 0x7F0803DB;  // drawable:ic_common_arrow_equal_tint
                        break;
                    }
                    case "UP": {
                        integer0 = 0x7F0803DC;  // drawable:ic_common_arrow_up
                        break;
                    }
                    default: {
                        integer0 = null;
                    }
                }
            }
            c1.n(null, integer0, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFD);
            if(kotlin.jvm.internal.q.b(s, "NEW")) {
                s3 = "NEW";
            }
            else if(kotlin.jvm.internal.q.b(s, "NONE")) {
                s3 = "";
            }
            else {
                String s4 = v0.f;
                s3 = s4 == null ? "" : s4;
            }
            if(s == null) {
                v10 = A7.d.f(p0, 1840500377, 0x7F06045A, p0, false);  // color:rank_up_color
            }
            else {
                switch(s) {
                    case "DOWN": {
                        v10 = A7.d.f(p0, 1840494826, 0x7F060046, p0, false);  // color:blue400s_support_high_contrast
                        break;
                    }
                    case "NEW": {
                        v10 = A7.d.f(p0, 1840497978, 0x7F060459, p0, false);  // color:rank_new_color
                        break;
                    }
                    case "UP": {
                        v10 = A7.d.f(p0, 1840492153, 0x7F06045A, p0, false);  // color:rank_up_color
                        break;
                    }
                    default: {
                        v10 = A7.d.f(p0, 1840500377, 0x7F06045A, p0, false);  // color:rank_up_color
                    }
                }
            }
            N1.b(s3, androidx.compose.foundation.layout.a.n(n0, 1.0f, 0.0f, 0.0f, 0.0f, 14), v10, ((float)(kotlin.jvm.internal.q.b(s, "NEW") ? 10 : 12)), null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30, 0, 0x1FFF0);
            p0.p(true);
            p0.p(true);
            r0.q q12 = H0.b.r(h4, x.r(1.0f, androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 5.0f, 0.0f, 11), true));
            y y1 = M.w.a(d0, g0, p0, 0);
            int v11 = p0.P;
            i0 i04 = p0.m();
            r0.q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            androidx.compose.runtime.w.x(p0, q13, h3);
            N1.b((v0.b == null ? "" : v0.b), null, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);  // color:gray900s
            long v12 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
            N1.b((v0.c == null ? "" : v0.c), androidx.compose.foundation.layout.a.n(n0, 0.0f, 5.0f, 0.0f, 0.0f, 13), v12, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(v0, v1, k0, v2, 8);
        }
    }

    public static final void b(B2 b20, we.k k0, l l0, int v) {
        kotlin.jvm.internal.q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(0x94180000);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 8.0f, 0.0f, 30.0f, 5);
            df.v.d(b20.a, q0, "전체보기", true, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0xC30 | v1 << 12 & 0x70000, 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 2);
        }
    }

    public static final void c(E2 e20, we.k k0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-1038771904);
        int v1 = (((androidx.compose.runtime.p)l0).i(e20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        boolean z = false;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(((androidx.compose.runtime.p)l0), 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z1 = ((androidx.compose.runtime.p)l0).i(e20);
            if((v1 & 0x70) == 0x20) {
                z = true;
            }
            gd.l l1 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || l1 == androidx.compose.runtime.k.a) {
                l1 = new gd.l(11, e20, k0);
                ((androidx.compose.runtime.p)l0).l0(l1);
            }
            c1.o(null, null, j00, false, null, null, null, false, l1, ((androidx.compose.runtime.p)l0), 0, 0xFB);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.e(e20, k0, v, 19);
        }
    }

    public static final void d(o6 o60, we.k k0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x8EFBD920);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).i(o60) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            c1.n(r0.a.a(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 54.0f), new Ac.l(19, k0, o60)), o60.a, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0, 0, 0x7FFC);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new U(o60, k0, v, 18);
        }
    }

    public static final void e(r0.q q0, u6 u60, we.k k0, l l0, int v) {
        r0.n n1;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x1BA9A012);
        int v1 = v | (p0.i(u60) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            r0.q q1 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(q0, 255.0f), 1.0f);
            M m0 = M.p.d(r0.d.a, false);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            o6 o60 = u60.c;
            b.h(u60.b, p0, 0);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(r0.n.a, 1.0f), 16.0f, 132.0f, 68.0f, 0.0f, 8);
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            r0.n n0 = r0.n.a;
            N1.b(u60.a, q4, v4, 22.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);
            r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 16.0f, 7.0f, 0.0f, 0.0f, 12);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            c1.n(null, 0x7F08042B, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:ic_dj_playlist_01_2
            r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
            long v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b(u60.d, q7, v6, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);
            if(u60.e != null && u60.e.length() != 0) {
                p0.a0(0x335ACACF);
                M.c.d(p0, androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 1.0f), 11.0f), 8.0f, 0.0f, 0.0f, 0.0f, 14), e0.T(p0, 0x7F0604AF), y0.M.a));  // color:white160e_support_high_contrast
                String s = H0.e.Y(p0, 0x7F130647);  // string:melondj_genre_shortcut "장르 바로가기"
                long v7 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(s, androidx.compose.foundation.layout.a.n(r0.a.a(n0, new Ac.l(20, k0, u60)), 8.0f, 0.0f, 0.0f, 0.0f, 14), v7, 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
                n1 = n0;
                c1.n(androidx.compose.foundation.layout.a.n(n0, 1.0f, 0.0f, 0.0f, 0.0f, 14), 0x7F0801C7, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_genre_arrow_w
            }
            else {
                n1 = n0;
                p0.a0(0x32C0D9F0);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
            b.g(v1 & 0x380, p0, androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n1, r0.d.c), 0.0f, 126.0f, 16.0f, 0.0f, 9), k0, u60.f);
            b0 b00 = B.a.r(u60.h, p0, 0);
            r0.q q8 = androidx.compose.foundation.layout.a.n(e2.a.r(androidx.compose.foundation.layout.d.f(n1, 1.0f), ((Number)b00.getValue()).floatValue()), 0.0f, 0.0f, 0.0f, 24.0f, 7);
            r0.q q9 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q8, r0.d.g);
            boolean z = p0.i(u60);
            gd.l l1 = p0.N();
            if(z || (v1 & 0x380) == 0x100 || l1 == androidx.compose.runtime.k.a) {
                l1 = new gd.l(26, u60, k0);
                p0.l0(l1);
            }
            c1.q(q9, null, null, null, null, null, false, l1, p0, 0, 0xFE);
            p0.p(true);
            if(o60 == null) {
                p0.a0(0x1FF8E190);
            }
            else {
                p0.a0(0x20B37834);
                b.d(o60, k0, p0, v1 >> 3 & 0x70);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(q0, u60, k0, v, 19);
        }
    }

    public static final void f(boolean z, boolean z1, r6 r60, we.k k0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xCB5CC47F);
        int v1 = v | (p0.h(z) ? 4 : 2) | (p0.h(z1) ? 0x20 : 16) | (p0.g(r60) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n0, 30.0f), (z ? 16.0f : 10.0f), 0.0f, (z1 ? 16.0f : 0.0f), 0.0f, 10), e0.T(p0, 0x7F0604B0), y0.M.a), new Ac.l(21, k0, r60));  // color:white160en
            M m0 = M.p.d(r0.d.e, false);
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
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = androidx.compose.foundation.layout.a.l(n0, 8.0f, 0.0f, 2);
            long v3 = e0.T(p0, 0x7F0604A1);  // color:white000e
            l1.k k1 = new l1.k(3);
            N1.b(r60.b, q2, v3, 13.0f, null, null, 0L, k1, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Mc.j(z, z1, r60, k0, v, 5);
        }
    }

    public static final void g(int v, l l0, r0.q q0, we.k k0, boolean z) {
        ((androidx.compose.runtime.p)l0).c0(-933530169);
        int v1 = (((androidx.compose.runtime.p)l0).h(z) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).g(q0) ? 0x20 : 16);
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.b);
            c1.n(r0.a.a(q0, new M0(k0, z, 4)), ((int)(z ? 0x7F08014F : 0x7F080150)), (z ? "좋아요 취소 버튼" : "좋아요 버튼"), N0.j.h, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((androidx.compose.runtime.p)l0), 0xC00, 0, 0x7FF0);  // drawable:btn_common_like_36_on
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new Rc.c(z, q0, k0, v);
        }
    }

    public static final void h(String s, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF910916C);
        int v1 = v | (p0.g(s) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            long v2 = e0.T(p0, 0x7F060157);  // color:gray400e
            boolean z = p0.f(v2);
            h0 h00 = p0.N();
            if(z || h00 == androidx.compose.runtime.k.a) {
                h00 = new h0(v2, 17);
                p0.l0(h00);
            }
            r0.q q0 = androidx.compose.ui.draw.a.c(r0.n.a, h00);
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
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c1.n(androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.d.c, 0x7F06014A), e0.T(p0, 0x7F060145), y0.M.a), 0x7F080788, null, N0.j.f, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C30, 0, 0x7FE4);  // color:gray100a
            androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(androidx.compose.foundation.layout.d.c, y0.a, y0.b, y0.M.a), e0.T(p0, 0x7F060145), y0.M.a), s, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 << 3 & 0x70 | 0x6C00, 0, 0x7FE4);  // color:gray050s
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new k2(s, v, 2);
        }
    }

    public static final f i(Context context0, x5.l l0, x5.k k0) {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)P1.c.getSystemService(context0, ConnectivityManager.class);
        if(connectivityManager0 != null && P1.c.checkSelfPermission(context0, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            try {
                f f0 = new androidx.media3.session.legacy.V();  // 初始化器: Ljava/lang/Object;-><init>()V
                f0.a = connectivityManager0;
                f0.b = l0;
                Z4.d d0 = new Z4.d(f0, 2);
                f0.c = d0;
                connectivityManager0.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), d0);
                return f0;
            }
            catch(Exception exception0) {
                if(k0 != null) {
                    x5.k.a("NetworkObserver", 6, null, new RuntimeException("Failed to register network observer.", exception0));
                }
                return new e3.h();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
        if(k0 != null) {
            x5.k.a("NetworkObserver", 5, "Unable to register network observer.", null);
        }
        return new e3.h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final d j(x0.c c0, long v, long v1, long v2, long v3) {
        return new d(c0.a, c0.b, c0.c, c0.d, v, v1, v2, v3);
    }

    public static d k(x0.c c0, long v, long v1) {
        return b.j(c0, v, v1, 0L, 0L);
    }

    public static final d l(float f, float f1, float f2, float f3, long v) {
        long v1 = ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20 | 0xFFFFFFFFL & ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))));
        return new d(f, f1, f2, f3, v1, v1, v1, v1);
    }

    public static float m(float f, float f1, int v) {
        return ((float)Math.max(0, v - 1)) * f1 + f;
    }

    public static float n(float f, float f1, int v) {
        return v <= 0 ? f : f1 / 2.0f + f;
    }

    public static final Object o(B b0, oe.c c0) {
        try {
            if(b0.isDone()) {
                return w1.i.f(b0);
            }
        }
        catch(ExecutionException executionException0) {
            Throwable throwable0 = executionException0.getCause();
            if(throwable0 != null) {
                throw throwable0;
            }
            ie.h h0 = new ie.h();  // 初始化器: Ljava/lang/NullPointerException;-><init>()V
            kotlin.jvm.internal.q.l(h0, "kotlin.jvm.internal.q");
            throw h0;
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(c0), 1);
        b0.addListener(new M6.u(21, b0, cancellableContinuationImpl0), w1.n.a);
        cancellableContinuationImpl0.invokeOnCancellation(new androidx.compose.foundation.w(b0, 25));
        return cancellableContinuationImpl0.getResult();
    }

    public static boolean p(s s0) {
        p p0 = new p(8);
        switch(N.a(s0, p0).a) {
            case 1380333108: 
            case 1380533830: {
                s0.peekFully(p0.a, 0, 4);
                p0.G(0);
                int v = p0.g();
                if(v != 0x57415645) {
                    e3.b.p("WavHeaderReader", "Unsupported form type: " + v);
                    return false;
                }
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static D q(we.k[] arr_k) {
        if(arr_k.length <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return new D(arr_k, 3);
    }

    public static int r(Comparable comparable0, Comparable comparable1) [...] // Inlined contents

    public static void s(InputStream inputStream0, ByteArrayOutputStream byteArrayOutputStream0, int v) {
        byte[] arr_b = new byte[1500];
        for(int v1 = v; v1 > 0; v1 -= v2) {
            int v2 = inputStream0.read(arr_b, 0, (v1 <= 1500 ? v1 : 1500));
            if(v2 < 0) {
                throw new IOException("can\'t read from InputStream: " + (v - v1) + " / " + v);
            }
            byteArrayOutputStream0.write(arr_b, 0, v2);
        }
    }

    public static androidx.recyclerview.widget.p0 t(o o0) {
        long v = SystemClock.elapsedRealtime();
        int v1 = o0.length();
        int v3 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(o0.a(v2, v)) {
                ++v3;
            }
        }
        return new androidx.recyclerview.widget.p0(v1, v3);
    }

    public static String u() [...] // 潜在的解密器

    public static void v(BaseActivity baseActivity0, Uri uri0) {
        if(baseActivity0 != null) {
            String s = uri0.getPath();
            if(s != null) {
                Class class0 = Ma.g.class;
                switch(s) {
                    case "/connect": {
                        m8.o o3 = new m8.o(0);
                        o3.i1(uri0);
                        Qd.e e1 = baseActivity0.getKakaoLoginHelper();
                        mb.f f2 = baseActivity0.getKakaoLoginUseCase();
                        f0.f(baseActivity0);
                        e1.a(new com.iloen.melon.player.playlist.mixup.composables.c(f2, baseActivity0, o3, 21));
                        return;
                    }
                    case "/connect/account": {
                        String s11 = uri0.getQueryParameter("url");
                        if(s11 != null) {
                            m m0 = new m(0);  // 初始化器: Lm8/o;-><init>(I)V
                            m0.i1(uri0);
                            SchemeAllowedUrlManager schemeAllowedUrlManager0 = SchemeAllowedUrlManager.getInstance();
                            schemeAllowedUrlManager0.updateAllowedUrl(new G0(schemeAllowedUrlManager0, s11, baseActivity0, m0));
                            return;
                        }
                        break;
                    }
                    case "/disconnect": {
                        boolean z = "Y".equals(uri0.getQueryParameter("close"));
                        mb.f f4 = baseActivity0.getKakaoLoginUseCase();
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new m8.p(f4, z, baseActivity0, null), 3, null);
                        return;
                    }
                    case "/login": {
                        uri0.getQueryParameter("userId");
                        String s10 = uri0.getQueryParameter("url");
                        m8.o o4 = new m8.o(1);
                        mb.f f3 = baseActivity0.getKakaoLoginUseCase();
                        mb.k k2 = baseActivity0.getLoginUseCase();
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new r(o4, baseActivity0, s10, f3, k2, null), 3, null);
                        return;
                    }
                    case "/login/integration": {
                        String s1 = uri0.getQueryParameter("expiredId");
                        mb.k k0 = baseActivity0.getLoginUseCase();
                        mb.f f0 = baseActivity0.getKakaoLoginUseCase();
                        mb.o o0 = ((k8.o)(((Ma.g)Y.f(MelonAppBase.Companion, class0)))).m();
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new m8.q(baseActivity0, s1, o0, k0, f0, null), 3, null);
                        return;
                    }
                    case "/logout": {
                        mb.k k3 = baseActivity0.getLoginUseCase();
                        BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new m8.s(k3, baseActivity0, null), 3, null);
                        return;
                    }
                    case "/sdklogin": {
                        int v = ProtocolUtils.parseInt(uri0.getQueryParameter("type"), -1);
                        m8.o o1 = new m8.o(2);
                        o1.i1(uri0);
                        Qd.e e0 = baseActivity0.getKakaoLoginHelper();
                        mb.f f1 = baseActivity0.getKakaoLoginUseCase();
                        k8.o o2 = (k8.o)(((Ma.g)Y.f(MelonAppBase.Companion, class0)));
                        mb.j j0 = new mb.j(((mb.k)o2.m.get()), o2.f(), new kb.D(((mb.l)o2.j.get())));
                        mb.k k1 = baseActivity0.getLoginUseCase();
                        androidx.lifecycle.y y0 = f0.f(baseActivity0);
                        if(v != 1000) {
                            String s2 = "7";
                            String s3 = "0";
                            switch(v) {
                                case 0: {
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.w(e0, baseActivity0, null, f1, k1), 3, null);
                                    return;
                                }
                                case 1: {
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.B(f1, e0, baseActivity0, o1, null), 3, null);
                                    return;
                                }
                                case 2: {
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.D(f1, e0, baseActivity0, null), 3, null);
                                    return;
                                }
                                case 3: {
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new F(f1, e0, baseActivity0, o1, null), 3, null);
                                    return;
                                }
                                case 4: {
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.y(e0, baseActivity0, null, f1, k1), 3, null);
                                    return;
                                }
                                case 5: {
                                    String s4 = o1.c1().getQueryParameter("loginOption");
                                    if(s4 != null) {
                                        s3 = s4;
                                    }
                                    String s5 = o1.c1().getQueryParameter("loginType");
                                    String s6 = s5 == null ? "7" : s5;
                                    String s7 = o1.c1().getQueryParameter("redirectUrl");
                                    A8.l l0 = f1.a.c();
                                    if(l0 != null) {
                                        BuildersKt__Builders_commonKt.launch$default(y0, null, null, new G(j0, l0, s6, s3, s7, null), 3, null);
                                        return;
                                    }
                                    e0.a(new t(f1, baseActivity0, o1, j0, s6, s3, s7));
                                    return;
                                }
                                case 6: {
                                    String s8 = o1.c1().getQueryParameter("loginOption");
                                    if(s8 != null) {
                                        s3 = s8;
                                    }
                                    String s9 = o1.c1().getQueryParameter("loginType");
                                    if(s9 != null) {
                                        s2 = s9;
                                    }
                                    BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.K(f1, e0, baseActivity0, o1, o1.c1().getQueryParameter("redirectUrl"), j0, s2, s3, null), 3, null);
                                    return;
                                }
                                default: {
                                    return;
                                }
                            }
                        }
                        BuildersKt__Builders_commonKt.launch$default(y0, null, null, new m8.M(e0, baseActivity0, null, f1, k1), 3, null);
                    }
                }
            }
        }
    }

    public static final ArrayList w(Q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        Iterable iterable0 = q0.c();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            Playable playable0 = ((PlayableData)object0).a;
            if(playable0.hasSongId() && playable0.isTypeOfSong()) {
                arrayList0.add(object0);
            }
        }
        return arrayList0;
    }

    public static final int x(int v, e1.y y0) {
        boolean z = y0.a(e1.y.d) >= 0;
        if(v == 1 && z) {
            return 3;
        }
        if(z) {
            return 1;
        }
        return v == 1 ? 0 : 2;
    }

    public static final Playable y(Q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        PlayableData playableData0 = b.z(q0);
        return playableData0 == null ? null : playableData0.a;
    }

    public static final PlayableData z(Q q0) {
        kotlin.jvm.internal.q.g(q0, "<this>");
        List list0 = q0.c();
        return (PlayableData)je.p.n0(q0.b(), list0);
    }
}

