package e1;

import Ac.R0;
import Ac.X2;
import Ac.Y1;
import Ac.Z3;
import Cc.N1;
import Cc.O3;
import Cc.Q3;
import Cc.R3;
import Cc.c1;
import Cc.e0;
import Cc.w3;
import Cc.z0;
import Dd.k1;
import Hd.F0;
import Hf.x;
import Je.p;
import M.j0;
import M.p0;
import M.q0;
import M.w;
import Me.S;
import O.I;
import Pe.z;
import Q0.k0;
import Rc.r;
import Tf.o;
import Tf.v;
import U.d0;
import U4.F;
import a1.U;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.f0;
import cd.H0;
import com.iloen.melon.LoginUser;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.a;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.U0;
import e.k;
import ed.s;
import gd.A;
import gd.B2;
import gd.K6;
import gd.L6;
import gd.M6;
import gd.O6;
import gd.S6;
import gd.T6;
import gd.U6;
import gd.g3;
import gd.h7;
import gd.r5;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jg.h;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import me.i;
import me.j;
import nf.f;
import oe.c;
import qf.e;
import s8.b;
import sf.l;
import tf.g;
import we.n;
import xf.d;
import y0.M;
import y0.T;

public abstract class u {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    public static final long A(double f) [...] // 潜在的解密器

    public static final long B(int v) [...] // 潜在的解密器

    public static final boolean C(h h0, InetAddress inetAddress0) {
        q.g(inetAddress0, "sourceAddress");
        String s = h0.g();
        int v = 0;
        if(s != null && v.r0(s, "http://", true)) {
            try {
                v = inetAddress0.equals(InetAddress.getByName(new URL(s).getHost()));
            }
            catch(IOException unused_ex) {
            }
        }
        return v ^ 1;
    }

    public static Continuation D(Continuation continuation0) {
        q.g(continuation0, "<this>");
        c c0 = continuation0 instanceof c ? ((c)continuation0) : null;
        if(c0 != null) {
            Continuation continuation1 = c0.intercepted();
            return continuation1 == null ? continuation0 : continuation1;
        }
        return continuation0;
    }

    public static final boolean E(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        return !"0".equals("");
    }

    public static final boolean F(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        q.f("", "getArtistId(...)");
        Integer integer0 = v.t0("");
        return integer0 != null && ((int)integer0) > 0;
    }

    public abstract boolean G();

    public static final boolean H(b b0, Integer integer0, long v) {
        return integer0 == null || b0.d != ((int)integer0) || (b0.c < 0L || System.currentTimeMillis() - b0.c > v);
    }

    public static final boolean I(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        return k.A(new Integer[]{1, 3}).contains(loginUser0.getMemberType());
    }

    public static final boolean J(h h0) {
        if(h0.getHeader() != null) {
            Arrays.copyOf(new Object[0], 0);
            return true;
        }
        return false;
    }

    public abstract void K(int arg1);

    public abstract void L(Typeface arg1, boolean arg2);

    public static final long M(long v, float f) {
        return v | ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL;
    }

    public static final String N(e e0) {
        q.g(e0, "<this>");
        String s = e0.b();
        q.f(s, "asString(...)");
        if(!l.a.contains(s)) {
            int v = 0;
            while(v < s.length()) {
                int v1 = s.charAt(v);
                if(!Character.isLetterOrDigit(((char)v1)) && v1 != 0x5F) {
                    goto label_14;
                }
                ++v;
            }
            if(s.length() != 0 && Character.isJavaIdentifierStart(s.codePointAt(0))) {
                String s1 = e0.b();
                q.f(s1, "asString(...)");
                return s1;
            }
        }
    label_14:
        String s2 = e0.b();
        q.f(s2, "asString(...)");
        return "`" + s2 + '`';
    }

    public static final String O(List list0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: list0) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append(".");
            }
            stringBuilder0.append(u.N(((e)object0)));
        }
        return stringBuilder0.toString();
    }

    public static final String P(String s, String s1, String s2, String s3, String s4) {
        q.g(s, "lowerRendered");
        q.g(s1, "lowerPrefix");
        q.g(s2, "upperRendered");
        q.g(s3, "upperPrefix");
        q.g(s4, "foldedPrefix");
        if(v.r0(s, s1, false) && v.r0(s2, s3, false)) {
            String s5 = s.substring(s1.length());
            q.f(s5, "substring(...)");
            String s6 = s2.substring(s3.length());
            q.f(s6, "substring(...)");
            String s7 = s4 + s5;
            if(s5.equals(s6)) {
                return s7;
            }
            return u.V(s5, s6) ? s7 + '!' : null;
        }
        return null;
    }

    public static final boolean Q(x x0) {
        Me.h h0 = x0.w().e();
        if(h0 == null || (!g.b(h0) || !g.f(h0) || d.g(((Me.e)h0)).equals(p.h)) && !g.h(x0)) {
            Me.h h1 = x0.w().e();
            S s0 = h1 instanceof S ? ((S)h1) : null;
            return s0 != null && u.Q(F.B(s0));
        }
        return true;
    }

    public static final void R(Object[] arr_object, int v, int v1) {
        q.g(arr_object, "<this>");
        while(v < v1) {
            arr_object[v] = null;
            ++v;
        }
    }

    public abstract void S(boolean arg1);

    public abstract void T(boolean arg1);

    public static final Object U(int v, Object object0, H h0, y y0, int v1) {
        boolean z1;
        if(!(object0 instanceof Typeface)) {
            return object0;
        }
        boolean z = (v & 1) != 0 && !q.b(h0.b, y0) && (y0.a(y.d) >= 0 && q.h(h0.b.a, y.d.a) < 0);
        if((v & 2) == 0) {
            z1 = false;
        }
        else {
            h0.getClass();
            z1 = v1 == 0 ? false : true;
        }
        if(!z1 && !z) {
            return object0;
        }
        if(Build.VERSION.SDK_INT < 28) {
            if(z1 && v1 == 1 && z) {
                return Typeface.create(((Typeface)object0), 1);
            }
            return z ? Typeface.create(((Typeface)object0), 1) : Typeface.create(((Typeface)object0), 0);
        }
        int v2 = z ? y0.a : h0.b.a;
        if(z1) {
            return v1 == 1 ? a.h(((Typeface)object0), v2, true) : a.h(((Typeface)object0), v2, false);
        }
        h0.getClass();
        return a.h(((Typeface)object0), v2, false);
    }

    public static final boolean V(String s, String s1) {
        q.g(s, "lower");
        q.g(s1, "upper");
        return s.equals(v.p0(s1, "?", "")) || v.i0(s1, "?", false) && q.b((s + "?"), s1) || q.b(("(" + s + ")?"), s1);
    }

    public abstract TransformationMethod W(TransformationMethod arg1);

    public static Object X(n n0, Object object0, Continuation continuation0) {
        q.g(n0, "<this>");
        q.g(continuation0, "completion");
        i i0 = continuation0.getContext();
        ne.d d0 = i0 == j.a ? new ne.d(continuation0) : new ne.e(continuation0, i0);  // 初始化器: Loe/g;-><init>(Lkotlin/coroutines/Continuation;)V / 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;Lme/i;)V
        N.e(2, n0);
        return n0.invoke(object0, d0);
    }

    public static final void a(B2 b20, we.k k0, androidx.compose.runtime.l l0, int v) {
        q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(0xB377F256);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 8.0f, 0.0f, 40.0f, 5);
            df.v.d(b20.a, q0, null, false, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0x30 | v1 << 12 & 0x70000, 12);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 7);
        }
    }

    public static final void b(androidx.compose.runtime.l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0xDF904EA4);
        if(((androidx.compose.runtime.p)l0).Q(v & 1, v != 0)) {
            e0.v(new U0(null, null, 0x1F), ((androidx.compose.runtime.p)l0), 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new M6(v, 0);
        }
    }

    public static final void c(gd.y y0, int v, we.k k0, androidx.compose.runtime.l l0, int v1) {
        r0.n n2;
        q.g(k0, "onUserEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xB1881295);
        int v2 = (v1 & 6) == 0 ? (p0.g(y0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v3 = ScreenUtils.dipToPixel(context0, 380.0f);
            if(ScreenUtils.isPortrait(context0)) {
                v3 = ScreenUtils.getScreenWidth(context0) - ScreenUtils.dipToPixel(context0, 20.0f) * 2;
            }
            r1.c c0 = (r1.c)p0.k(k0.h);
            int v4 = M.z(e0.T(p0, 0x7F060145));  // color:gray050s
            b0 b00 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(b00 == v5) {
                b00 = U4.x.d(v4, p0);
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.q.f(e0.L(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.h(n0, 230.0f), c0.R(v3)), 0x7F06014A), M.c(((Number)b00.getValue()).intValue()), M.a);  // color:gray100a
            s s0 = p0.N();
            if(s0 == v5) {
                s0 = new s(12);
                p0.l0(s0);
            }
            r0.q q1 = X0.n.c(q0, false, s0);
            boolean z = p0.i(context0);
            Cc.n n1 = p0.N();
            if(z || n1 == v5) {
                n1 = new Cc.n(context0, 10);
                p0.l0(n1);
            }
            r0.q q2 = r0.a.a(androidx.compose.ui.draw.a.a(q1, n1), new X2(k0, y0, v, 9));
            M.d d0 = M.j.c;
            M.y y1 = w.a(d0, r0.d.m, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            r0.g g0 = r0.d.m;
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y1, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O) {
                n2 = n0;
                A7.d.q(v6, p0, v6, h2);
            }
            else {
                n2 = n0;
                if(!q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.a.n(n2, 0.0f, 24.0f, 0.0f, 0.0f, 13);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v7 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            String s1 = y0.a;
            r0.q q6 = e0.J(androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n2, 20.0f, 0.0f, 0.0f, 0.0f, 14), 120.0f));
            Drawable drawable0 = ViewUtils.getDefaultImage(context0, ((int)e0.a0(120.0f, p0)), true);
            R0 r00 = p0.N();
            if(r00 == v5) {
                r00 = new R0(b00, 16);
                p0.l0(r00);
            }
            w3.g(s1, q6, drawable0, r00, p0, 0xC00, 0);
            r0.q q7 = U4.x.r(1.0f, androidx.compose.foundation.layout.a.n(n2, 24.0f, 0.0f, E9.h.t(p0, 0x7F0700E3), 0.0f, 10), true);  // dimen:detail_list_padding_left_right
            M.y y2 = w.a(d0, g0, p0, 0);
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
            androidx.compose.runtime.w.x(p0, y2, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            N1.b((y0.c == null ? "" : y0.c), n2, e0.T(p0, 0x7F0604A1), 18.0f, y.i, null, 0L, null, 20.0f, 2, false, 2, 0, null, null, p0, 0x30C30, 0xC36, 0x1D3D0);  // color:white000e
            q.f("팔로워 %s", "getString(...)");
            N1.b(String.format("팔로워 %s", Arrays.copyOf(new Object[]{y0.d}, 1)), androidx.compose.foundation.layout.a.n(n2, 0.0f, 7.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F0604B7), 12.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:white700e
            r0.q q9 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n2, 0.0f, 14.0f, 0.0f, 0.0f, 13), 28.0f);
            j0 j00 = androidx.compose.foundation.layout.a.c(10.0f, 0.0f, 14.0f, 0.0f, 10);
            R3[] arr_r3 = new R3[2];
            int v9 = 0;
            arr_r3[0] = O3.h;
            arr_r3[1] = Q3.h;
            List list0 = k.A(arr_r3);
            boolean z1 = y0.f;
            if((v2 & 0x70) == 0x20) {
                v9 = 1;
            }
            F0 f00 = p0.N();
            if((((v2 & 0x380) == 0x100 ? 1 : 0) | ((v2 & 14) == 4 ? 1 : 0) | v9) != 0 || f00 == v5) {
                f00 = new F0(k0, y0, v, 23);
                p0.l0(f00);
            }
            w3.k(q9, j00, list0, ((int)z1), f00, p0, 438);
            p0.p(true);
            p0.p(true);
            long v10 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b((y0.e == null ? "" : y0.e), U4.x.r(1.0f, androidx.compose.foundation.layout.a.n(n2, 20.0f, 24.0f, 20.0f, 0.0f, 8), true), v10, 14.0f, null, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(y0, v, k0, v1, 11);
        }
    }

    public static final void d(A a0, int v, we.k k0, androidx.compose.runtime.l l0, int v1) {
        P0.h h4;
        P0.i i1;
        q.g(k0, "onUserEvent");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x8BF948B7);
        int v2 = (v1 & 6) == 0 ? (p0.g(a0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v3 = ScreenUtils.dipToPixel(context0, 380.0f);
            if(ScreenUtils.isPortrait(context0)) {
                int v4 = ScreenUtils.getScreenWidth(context0) - ScreenUtils.dipToPixel(context0, 20.0f) * 2;
                if(v4 <= v3) {
                    v3 = v4;
                }
            }
            float f = ((r1.c)p0.k(k0.h)).R(v3);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, f), 200.0f), T.e.b(4.0f)), new g3(k0, a0, v, 0));
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            androidx.compose.runtime.w.x(p0, m0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            r0.q q2 = e0.K(androidx.compose.foundation.layout.d.h((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).b(), 200.0f));
            P0.h h3 = P0.j.d;
            c1.n(q2, a0.a, null, N0.j.b, false, 0, null, null, r0.d.e, 0.0f, null, 0, 0, false, false, p0, 0x6000C00, 0, 32500);
            r0.q q3 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 8.0f, 8.0f, 0.0f, 9), 24.0f);
            c1.n(r0.a.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q3, r0.d.c), new g3(k0, a0, v, 1)), 0x7F080309, "재생", null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FF8);  // drawable:common_btn_play_01
            r0.q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 100.0f);
            M.p.a(androidx.compose.foundation.q.e((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.h), wc.u.f(k.A(new y0.s[]{new y0.s(e0.T(p0, 0x7F06048A)), new y0.s(e0.T(p0, 0x7F06015F))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:transparent
            r0.q q5 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            r0.q q6 = androidx.compose.foundation.layout.a.l((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.h), 16.0f, 0.0f, 2);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v6 = p0.P;
            i0 i01 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v6)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v6, p0, v6, h4);
            }
            androidx.compose.runtime.w.x(p0, q7, h3);
            r0.q q8 = q0.a(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 15.0f, 7), 3), 1.0f);
            r0.q q9 = H0.b.r(r0.d.l, q8);
            M.y y0 = w.a(M.j.c, r0.d.m, p0, 0);
            int v7 = p0.P;
            i0 i02 = p0.m();
            r0.q q10 = r0.a.d(p0, q9);
            p0.e0();
            r0.h h5 = r0.d.l;
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h4);
            }
            androidx.compose.runtime.w.x(p0, q10, h3);
            String s = "";
            N1.b((a0.b == null ? "" : a0.b), androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 0.0f, 4.0f, 7), e0.T(p0, 0x7F0604A1), 16.0f, y.i, null, 0L, null, 19.0f, 2, false, 2, 0, null, null, p0, 0x30C30, 0xC36, 0x1D3D0);  // color:white000e
            String s1 = a0.c;
            if(s1 != null) {
                s = s1;
            }
            N1.b(s, null, e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, null, 16.0f, 2, false, 2, 0, null, null, p0, 0xC00, 0xC36, 0x1D3F2);  // color:white000e
            p0.p(true);
            if(a0.d != null && a0.d.length() != 0) {
                p0.a0(1646407382);
                r0.q q11 = androidx.compose.foundation.layout.d.u(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 0.0f, 0.0f, 14), 3);
                androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604A1), 0.5f);  // color:white000e
                T.d d0 = T.e.b(4.0f);
                r0.q q12 = r0.a.a(H0.b.r(h5, androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.j(q11, y1.a, y1.b, d0), 12.0f, 8.0f, 12.0f, 8.0f)), new g3(k0, a0, v, 2));
                long v8 = e0.T(p0, 0x7F0604A1);  // color:white000e
                N1.b(a0.d, q12, v8, 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            }
            else {
                p0.a0(1640457397);
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
            n00.d = new Nc.p(a0, v, k0, v1, 13);
        }
    }

    public static final void e(B2 b20, we.k k0, androidx.compose.runtime.l l0, int v) {
        q.g(k0, "onUserEvent");
        ((androidx.compose.runtime.p)l0).c0(0xC9F762FA);
        int v1 = (((androidx.compose.runtime.p)l0).i(b20) ? 4 : 2) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, 40.0f, 7);
            df.v.d(b20.a, q0, null, false, b20, k0, ((androidx.compose.runtime.p)l0), 0xE000 & v1 << 12 | 0x30 | v1 << 12 & 0x70000, 12);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new gd.a(b20, k0, v, 5);
        }
    }

    public static final void f(h7 h70, we.a a0, we.k k0, androidx.compose.runtime.l l0, int v) {
        boolean z2;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x7066CC5B);
        int v1 = v | (p0.i(h70) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            O.F f0 = I.a(0, 0, 3, p0);
            boolean z = p0.g(f0);
            O6 o60 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || z || o60 == v2) {
                o60 = new O6(f0, a0, null);
                p0.l0(o60);
            }
            J.d(p0, ie.H.a, o60);
            long v3 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            r0.q q0 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.c, v3, M.a);
            M.y y0 = w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
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
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            b0 b00 = p0.N();
            if(b00 == v2) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            U8.F f1 = p0.N();
            if(f1 == v2) {
                f1 = new U8.F(b00, 8);
                p0.l0(f1);
            }
            r0.q q2 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(r0.n.a, 0.0f, 0.0f, 0.0f, 4.0f, 7), 52.0f), 1.0f);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            boolean z1 = ((Boolean)b00.getValue()).booleanValue();
            u.i(h70.c, k0, z1, p0, v1 >> 3 & 0x70);
            p0.p(true);
            if(h70.f) {
                p0.a0(0xFEA65DBD);
                u.l(v1 & 0x380, p0, (h70.g == null ? "" : h70.g), h70.h, k0);
                z2 = false;
            }
            else {
                z2 = false;
                p0.a0(0xFDD27531);
            }
            p0.p(false);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, E9.h.t(p0, 0x7F070058), 7);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z3 = p0.i(h70);
            if((v1 & 0x380) == 0x100) {
                z2 = true;
            }
            com.iloen.melon.player.playlist.mixup.composables.c c0 = p0.N();
            if(z3 || z2 || c0 == v2) {
                c0 = new com.iloen.melon.player.playlist.mixup.composables.c(h70, k0, f1);
                p0.l0(c0);
            }
            c1.o(null, f0, j00, false, null, null, null, false, c0, p0, 0, 0xF9);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(h70, a0, k0, v, 21);
        }
    }

    public static final void g(String s, String s1, String s2, String s3, boolean z, int v, we.k k0, we.a a0, androidx.compose.runtime.l l0, int v1, int v2) {
        String s10;
        String s9;
        r0.n n1;
        String s4;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x94E08CC8);
        int v3 = (v1 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.g(s2) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
            s4 = s3;
        }
        else if((v1 & 0xC00) == 0) {
            s4 = s3;
            v3 |= (p0.g(s4) ? 0x800 : 0x400);
        }
        else {
            s4 = s3;
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v1) == 0) {
            v3 |= (p0.e(v) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v1) == 0) {
            v3 |= (p0.g("suggest") ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v1) == 0) {
            v3 |= (p0.i(k0) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v1) == 0) {
            v3 |= (p0.i(a0) ? 0x4000000 : 0x2000000);
        }
        if(p0.Q(v3 & 1, (0x2492493 & v3) != 0x2492492)) {
            if((v2 & 8) != 0) {
                s4 = null;
            }
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(n0, 45.0f), 1.0f), new k1(a0, k0, s, s1, v));
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            String s5 = s4 == null ? "" : Y.j("getDefault(...)", s4, "toLowerCase(...)");
            int v5 = o.F0(Y.j("getDefault(...)", s, "toLowerCase(...)"), s5, 0, false, 6);
            if(v5 >= 0) {
                p0.a0(0x5DA88DBD);
                int v6 = s5.length() + v5;
                String s6 = s.substring(0, v5);
                q.f(s6, "substring(...)");
                String s7 = s.substring(v5, v6);
                q.f(s7, "substring(...)");
                String s8 = s.substring(v6);
                q.f(s8, "substring(...)");
                p0.a0(0xF2816BA9);
                a1.d d0 = new a1.d();
                d0.d("#");
                d0.d(s6);
                int v7 = d0.g(new a1.M(e0.T(p0, 0x7F06017C), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));  // color:green500s_support_high_contrast
                try {
                    d0.d(s7);
                }
                finally {
                    d0.f(v7);
                }
                d0.d(s8);
                a1.g g0 = d0.h();
                p0.p(false);
                n1 = n0;
                s9 = s4;
                N1.a(g0, q0.a(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 12.0f, 0.0f, 10), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, p0, 0xC00, 0xC30, 0x3D7F0);  // color:gray900s
            }
            else {
                s9 = s4;
                n1 = n0;
                p0.a0(0x5DB6788F);
                N1.b(String.format("#%s", Arrays.copyOf(new Object[]{s}, 1)), q0.a(androidx.compose.foundation.layout.a.n(n1, 16.0f, 0.0f, 12.0f, 0.0f, 10), 1.0f), e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            }
            p0.p(false);
            if(s2 != null && s2.length() != 0) {
                p0.a0(1572709432);
                N1.b(StringUtils.getCountString(s2, 0x98967F), androidx.compose.foundation.layout.a.n(n1, 0.0f, 0.0f, 16.0f, 0.0f, 11), e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray500s_support_high_contrast
            }
            else {
                p0.a0(0x5B58489E);
            }
            p0.p(false);
            if(z) {
                p0.a0(1573072690);
                c1.n(r0.a.a(androidx.compose.foundation.layout.a.n(n1, 0.0f, 0.0f, 16.0f, 0.0f, 11), new X2(s, k0, v, 11)), 0x7F080130, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F060154), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFC);  // drawable:btn_common_delete_26
            }
            else {
                p0.a0(0x5B58489E);
            }
            p0.p(false);
            p0.p(true);
            s10 = s9;
        }
        else {
            p0.T();
            s10 = s4;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new L6(s, s1, s2, s10, z, v, k0, a0, v1, v2);
        }
    }

    public static final void h(String s, float f, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(592760381);
        int v1 = v | (p0.g(s) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n0 = r0.n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            M.y y0 = w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 16.0f, f, 0.0f, 0.0f, 12), e0.T(p0, 0x7F06015D), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:gray500s_support_high_contrast
            A7.d.v(n0, 4.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new K6(s, f, v, 0);
        }
    }

    public static final void i(List list0, we.k k0, boolean z, androidx.compose.runtime.l l0, int v) {
        r0.n n1;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(-43090125);
        int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(k0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Object object0 = p0.k(k0.i);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            d5.l l1 = f1.x.d;
            r5 r50 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(r50 == v3) {
                r50 = new r5(4);
                p0.l0(r50);
            }
            b0 b00 = d5.w.O(new Object[0], l1, r50, p0);
            Boolean boolean0 = Boolean.valueOf(z);
            boolean z1 = p0.g(b00);
            S6 s60 = p0.N();
            if((v1 & 0x380) == 0x100 || z1 || s60 == v3) {
                s60 = new S6(b00, null, z);
                p0.l0(s60);
            }
            J.d(p0, boolean0, s60);
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            Boolean boolean1 = (Boolean)b01.getValue();
            boolean1.getClass();
            boolean z2 = p0.g(b00);
            boolean z3 = p0.i(list0);
            T6 t60 = p0.N();
            if(z2 || z3 || t60 == v3) {
                t60 = new T6(b00, list0, b01, null);
                p0.l0(t60);
            }
            J.d(p0, boolean1, t60);
            w0.p p1 = p0.N();
            if(p1 == v3) {
                p1 = new w0.p();
                p0.l0(p1);
            }
            b0 b02 = p0.N();
            if(b02 == v3) {
                b02 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b02);
            }
            Boolean boolean2 = (Boolean)b02.getValue();
            boolean2.getClass();
            U6 u60 = p0.N();
            if(u60 == v3) {
                u60 = new U6(p1, null);
                p0.l0(u60);
            }
            J.d(p0, boolean2, u60);
            boolean z4 = p0.g(b00);
            boolean z5 = p0.i(list0);
            Vc.A a0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | (z4 | z5)) != 0 || a0 == v3) {
                a0 = new Vc.A(b00, list0, k0, b01);
                p0.l0(a0);
            }
            Object object1 = b00.getValue();
            boolean z6 = list0.size() <= 1;
            r0.q q1 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.h(androidx.compose.ui.focus.a.a(r0.n.a, p1), 31.0f), 1.0f);
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q2 = b0.a(q1, r0.d.d);
            boolean z7 = p0.i(list0);
            boolean z8 = p0.g(b00);
            r0.n n0 = r0.n.a;
            Bd.F f0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | (z7 | z8)) != 0 || f0 == v3) {
                n1 = n0;
                Bd.F f1 = new Bd.F(list0, b00, k0, b01, 14);
                p0.l0(f1);
                f0 = f1;
            }
            else {
                n1 = n0;
            }
            r0.q q3 = androidx.compose.ui.focus.a.b(q2, f0);
            T t0 = new T(e0.T(p0, 0x7F06017C));  // color:green500s_support_high_contrast
            long v4 = e0.N(15.0f, p0);
            U u0 = new U(e0.T(p0, 0x7F06017C), v4, null, N1.a, 0L, null, 0, 0L, 0xFFFFDC);  // color:green500s_support_high_contrast
            U.e0 e00 = new U.e0(3, 0x77);
            boolean z9 = p0.g(b00);
            boolean z10 = p0.i(((w0.h)object0));
            Cc.g3 g30 = p0.N();
            if(((v1 & 0x70) == 0x20 | z9 | z10) != 0 || g30 == v3) {
                g30 = new Cc.g3(k0, b00, ((w0.h)object0));
                p0.l0(g30);
            }
            d0 d00 = new d0(null, g30, 0x2F);
            boolean z11 = p0.g(b00);
            Z3 z30 = p0.N();
            if(z11 || (v1 & 0x70) == 0x20 || z30 == v3) {
                z30 = new Z3(b00, k0, 2);
                p0.l0(z30);
            }
            c1.h(((f1.x)object1), z30, q3, z6, u0, e00, d00, false, 0, 0, null, null, t0, m0.c.e(0x37375A98, p0, new H0(list0, b00, a0, b02, k0)), p0, 0x180000, 0x180000, 0x7F10);
            long v5 = e0.T(p0, 0x7F06016D);  // color:gray900s
            e0.C(b0.a(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n1, 16.0f, 0.0f, 16.0f, 2.0f, 2), 1.0f), r0.d.g), v5, 0, 2.0f, p0, 0xC00, 20);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Rc.c(v, 3, list0, k0, z);
        }
    }

    public static final void j(int v, we.k k0, androidx.compose.runtime.l l0, int v1) {
        ((androidx.compose.runtime.p)l0).c0(-1095142195);
        int v2 = (((androidx.compose.runtime.p)l0).e(v) ? 4 : 2) | v1 | (((androidx.compose.runtime.p)l0).i(k0) ? 0x20 : 16);
        boolean z = false;
        if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 19) != 18)) {
            List list0 = k.A(new String[]{H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F1307D7), H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F1307D4), H0.e.Y(((androidx.compose.runtime.p)l0), 0x7F1307D5)});  // string:order_by_popular "인기순"
            if((v2 & 0x70) == 0x20) {
                z = true;
            }
            Y1 y10 = ((androidx.compose.runtime.p)l0).N();
            if(z || y10 == androidx.compose.runtime.k.a) {
                y10 = new Y1(9, k0);
                ((androidx.compose.runtime.p)l0).l0(y10);
            }
            w3.d(list0, v, 0.0f, y10, ((androidx.compose.runtime.p)l0), v2 << 3 & 0x70);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new r(v, k0, v1);
        }
    }

    public static final void k(String s, we.k k0, we.a a0, androidx.compose.runtime.l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xD334A89);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.i(k0) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            int v2 = ScreenUtils.getScreenWidth(context0);
            int v3 = ScreenUtils.dipToPixel(context0, 86.0f);
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(n0, 31.0f), T.e.b(100.0f)), e0.T(p0, 0x7F06017F), M.a), 9.0f, 4.0f, 9.0f, 5.0f), new Ac.r(11, s, a0, k0));  // color:green502s_support_high_contrast
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            long v5 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b(("#" + s), androidx.compose.foundation.layout.d.s(n0, 0.0f, e0.Z(p0, (v2 - v3) / 3), 1), v5, 15.0f, null, null, 0L, new l1.k(3), 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D5F0);
            c1.n(androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14), 0x7F0801E3, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_green_tag_delete
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(v, 20, k0, a0, s);
        }
    }

    public static final void l(int v, androidx.compose.runtime.l l0, String s, List list0, we.k k0) {
        int v10;
        int v9;
        r0.i i0 = r0.d.a;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x8F87D439);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            M.y y0 = w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.d(p0, n0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            if(list0.isEmpty()) {
                p0.a0(0x26F90464);
                r0.q q1 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(n0, 16.0f, 0.0f, 16.0f, 0.0f, 10), 1.0f), 82.0f);
                N0.M m0 = M.p.d(i0, false);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q2 = r0.a.d(p0, q1);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m0, h0);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
                androidx.compose.runtime.w.x(p0, q2, h3);
                String s1 = String.format(H0.e.Y(p0, 0x7F130669), Arrays.copyOf(new Object[]{s}, 1));  // string:melondj_tag_search_relation_tag_empty "%s의 태그 검색 결과가 없습니다."
                p0.a0(-85191028);
                StringBuilder stringBuilder0 = new StringBuilder(16);
                new ArrayList();
                ArrayList arrayList0 = new ArrayList();
                new ArrayList();
                stringBuilder0.append(s1);
                arrayList0.add(new a1.c(new a1.M(e0.T(p0, 0x7F06017C), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE), 0, s.length(), 8));  // color:green500s_support_high_contrast
                String s2 = stringBuilder0.toString();
                ArrayList arrayList1 = new ArrayList(arrayList0.size());
                int v4 = arrayList0.size();
                for(int v5 = 0; v5 < v4; ++v5) {
                    arrayList1.add(((a1.c)arrayList0.get(v5)).a(stringBuilder0.length()));
                }
                a1.g g0 = new a1.g(s2, arrayList1);
                p0.p(false);
                long v6 = e0.T(p0, 0x7F060163);  // color:gray700s
                N1.a(g0, (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e), v6, 14.0f, null, null, 0L, new l1.k(3), 18.0f, 0, false, 0, 0, null, null, null, p0, 0xC00, 6, 0x3F9F0);
                p0.p(true);
                e0.C(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0L, 0, 0.0f, p0, 6, 30);
                r0.q q3 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 16.0f, 19.0f, 16.0f, 0.0f, 8), 23.0f);
                N0.M m1 = M.p.d(r0.d.e, false);
                int v7 = p0.P;
                i0 i02 = p0.m();
                r0.q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m1, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                androidx.compose.runtime.w.x(p0, q4, h3);
                N1.b(H0.e.Y(p0, 0x7F13066A), null, e0.T(p0, 0x7F06015D), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:melondj_tag_search_relation_tag_recommend "이 태그는 어때요?"
            }
            else {
                p0.a0(0x2713E493);
                r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 16.0f, 13.0f, 0.0f, 0.0f, 12);
                N0.M m2 = M.p.d(i0, false);
                int v8 = p0.P;
                i0 i03 = p0.m();
                r0.q q6 = r0.a.d(p0, q5);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m2, h0);
                androidx.compose.runtime.w.x(p0, i03, h1);
                if(p0.O || !q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                androidx.compose.runtime.w.x(p0, q6, h3);
                N1.b(H0.e.Y(p0, 0x7F130668), null, e0.T(p0, 0x7F060160), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:melondj_tag_search_relation_tag "연관 태그"
                p0.p(true);
                Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
                if(ScreenUtils.isPortrait(context0)) {
                    v9 = 887;
                    v10 = 2;
                }
                else {
                    v9 = 0x6EE;
                    v10 = 1;
                }
                r0.q q7 = androidx.compose.foundation.q.u(androidx.compose.foundation.layout.a.n(n0, 0.0f, 12.0f, 0.0f, 20.0f, 5), androidx.compose.foundation.q.t(p0), true, false);
                N0.M m3 = M.p.d(i0, false);
                int v11 = p0.P;
                i0 i04 = p0.m();
                r0.q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m3, h0);
                androidx.compose.runtime.w.x(p0, i04, h1);
                if(p0.O || !q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
                androidx.compose.runtime.w.x(p0, q8, h3);
                M.c.c(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.m(n0, ((float)v9)), 16.0f, 0.0f, 0.0f, 0.0f, 14), M.j.h(e0.Y(context0.getResources().getDimension(0x7F070450), p0)), M.j.h(e0.Y(context0.getResources().getDimension(0x7F070451), p0)), null, 0, v10, m0.c.e(0xFCB2667D, p0, new z0(list0, 1, k0)), p0, 0x180000, 24);  // dimen:tag_collection_horizontal_spacing
            }
            p0.p(true);
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(v, 22, list0, k0, s);
        }
    }

    public static final String m(Object[] arr_object, int v, int v1, je.h h0) {
        StringBuilder stringBuilder0 = new StringBuilder(v1 * 3 + 2);
        stringBuilder0.append("[");
        for(int v2 = 0; v2 < v1; ++v2) {
            if(v2 > 0) {
                stringBuilder0.append(", ");
            }
            Object object0 = arr_object[v + v2];
            if(object0 == h0) {
                stringBuilder0.append("(this Collection)");
            }
            else {
                stringBuilder0.append(object0);
            }
        }
        stringBuilder0.append("]");
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public static final Class n(String s) {
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classNotFoundException0) {
            Log.e("PreviewLogger", "Unable to find PreviewProvider \'" + s + '\'', classNotFoundException0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    public static final boolean o(String s) {
        return s != null && !o.H0(s) && !q.b(s, "0");
    }

    public static final boolean p(x0.c c0, float f, float f1) {
        return f <= c0.c && c0.a <= f && (f1 <= c0.d && c0.b <= f1);
    }

    public static Continuation q(n n0, Object object0, Continuation continuation0) {
        q.g(n0, "<this>");
        q.g(continuation0, "completion");
        if(n0 instanceof oe.a) {
            return ((oe.a)n0).create(object0, continuation0);
        }
        i i0 = continuation0.getContext();
        return i0 == j.a ? new ne.b(n0, object0, continuation0) : new ne.c(continuation0, i0, n0, object0);
    }

    public static void r(BaseActivity baseActivity0, Uri uri0) {
        String s = uri0.getPath();
        if(s != null && s.hashCode() == 0 && s.equals("") && baseActivity0 != null) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(baseActivity0), null, null, new m8.V(uri0, null), 3, null);
        }
    }

    public static void s() {
    }

    public abstract InputFilter[] t(InputFilter[] arg1);

    // 去混淆评级： 低(26)
    public static final String u(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        switch("") {
            case "1": 
            case "2": 
            case "3": {
                q.f("", "getHifiProdType(...)");
                return "";
            }
            default: {
                return "4";
            }
        }
    }

    public static final String v(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        String s = u.w(loginUser0);
        return s == null ? "0" : s;
    }

    // 去混淆评级： 低(30)
    public static final String w(LoginUser loginUser0) {
        q.g(loginUser0, "<this>");
        return u.o("") ? "" : null;
    }

    public static final Object[] x(int v, Class class0) {
        int v1 = 0;
        if(class0 != null) {
            try {
                Constructor[] arr_constructor = class0.getConstructors();
                boolean z = false;
                Constructor constructor0 = null;
                while(v1 < arr_constructor.length) {
                    Constructor constructor1 = arr_constructor[v1];
                    if(constructor1.getParameterTypes().length == 0) {
                        if(!z) {
                            z = true;
                            constructor0 = constructor1;
                            goto label_14;
                        }
                        constructor0 = null;
                        goto label_18;
                    }
                label_14:
                    ++v1;
                }
                if(!z) {
                    constructor0 = null;
                }
            label_18:
                if(constructor0 == null) {
                    throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
                }
                constructor0.setAccessible(true);
                q.e(constructor0.newInstance(null), "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
                throw new ClassCastException();
            }
            catch(ve.a unused_ex) {
                throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding \'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"\' to the module\'s build.gradle.");
            }
        }
        return new Object[0];
    }

    public static final jf.p y(lf.I i0, f f0, z z0, boolean z1, boolean z2, boolean z3) {
        q.g(i0, "proto");
        q.g(f0, "nameResolver");
        q.f(of.k.d, "propertySignature");
        of.e e0 = (of.e)e1.x.G(i0, of.k.d);
        if(e0 != null) {
            if(z1) {
                pf.d d0 = pf.g.b(i0, f0, z0, z3);
                return d0 == null ? null : e2.a.D(d0);
            }
            if(z2 && (e0.b & 2) == 2) {
                of.c c0 = e0.d;
                q.f(c0, "getSyntheticMethod(...)");
                return new jf.p(f0.getString(c0.c) + f0.getString(c0.d));
            }
        }
        return null;
    }

    public static jf.p z(lf.I i0, f f0, z z0, int v) {
        boolean z1 = (v & 8) == 0;
        return (v & 16) == 0 ? u.y(i0, f0, z0, z1, true, true) : u.y(i0, f0, z0, z1, false, true);
    }
}

