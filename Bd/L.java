package bd;

import Cc.e0;
import L5.c;
import N0.i;
import N0.j;
import P0.h;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;
import r0.n;
import wc.u;
import we.a;
import y0.M;
import y0.s;

public abstract class l {
    public static final void a(Content flexibleRes$RESPONSE$Flexible$Content0, boolean z, a a0, androidx.compose.runtime.l l0, int v) {
        V v5;
        V v3;
        q.g(flexibleRes$RESPONSE$Flexible$Content0, "content");
        p p0 = (p)l0;
        p0.c0(0xC6FAEBE6);
        int v1 = v | (p0.i(flexibleRes$RESPONSE$Flexible$Content0) ? 4 : 2) | (p0.h(z) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(null);
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(null);
                p0.l0(b01);
            }
            i i0 = z ? j.b : j.c;
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.f(d.h(d.f(n0, 1.0f), 200.0f), M.c(ColorUtils.getColorFromHexStr(flexibleRes$RESPONSE$Flexible$Content0.getBgColor())), M.a);
            Bc.d d0 = p0.N();
            if((v1 & 0x380) == 0x100) {
                v3 = v2;
                d0 = new Bc.d(17, a0);
                p0.l0(d0);
            }
            else {
                v3 = v2;
                if(d0 == v3) {
                    d0 = new Bc.d(17, a0);
                    p0.l0(d0);
                }
            }
            r0.q q1 = androidx.compose.foundation.q.n(q0, null, d0, 7);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q2, P0.j.d);
            r0.q q3 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(d.c, r0.d.e);
            androidx.compose.foundation.q.c(c.a(((Drawable)b00.getValue()), p0), "", q3, null, i0, 0.0f, null, p0, 0x30, 104);
            r0.q q4 = d.h(d.f(n0, 1.0f), 100.0f);
            M.p.a(androidx.compose.foundation.q.e((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.h), u.f(e.k.A(new s[]{new s(s.f), new s(e0.T(p0, 0x7F0604AA))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:white000s_support_high_contrast
            r0.q q5 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(d.c, r0.d.e);
            androidx.compose.foundation.q.c(c.a(((Drawable)b01.getValue()), p0), "", q5, null, i0, 0.0f, null, p0, 0x30, 104);
            p0.p(true);
            String s = flexibleRes$RESPONSE$Flexible$Content0.getImgUrl();
            boolean z1 = p0.i(flexibleRes$RESPONSE$Flexible$Content0);
            boolean z2 = p0.i(context0);
            bd.j j0 = p0.N();
            if(z1 || z2) {
                v5 = v3;
                j0 = new bd.j(context0, b00, flexibleRes$RESPONSE$Flexible$Content0, null);
                p0.l0(j0);
            }
            else {
                v5 = v3;
                if(j0 == v5) {
                    j0 = new bd.j(context0, b00, flexibleRes$RESPONSE$Flexible$Content0, null);
                    p0.l0(j0);
                }
            }
            J.d(p0, s, j0);
            String s1 = flexibleRes$RESPONSE$Flexible$Content0.getEffectImgUrl();
            boolean z3 = p0.i(flexibleRes$RESPONSE$Flexible$Content0);
            boolean z4 = p0.i(context0);
            bd.k k0 = p0.N();
            if(z3 || z4 || k0 == v5) {
                k0 = new bd.k(context0, b01, flexibleRes$RESPONSE$Flexible$Content0, null);
                p0.l0(k0);
            }
            J.d(p0, s1, k0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new bd.h(flexibleRes$RESPONSE$Flexible$Content0, z, a0, v, 1);
        }
    }
}

