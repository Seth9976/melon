package zc;

import Bd.F;
import Cc.N1;
import Cc.e0;
import De.I;
import F.S;
import G.C;
import G.f;
import G.j;
import G.x0;
import M.c;
import M.n0;
import M.p0;
import M.y;
import P0.h;
import P0.i;
import T.e;
import Tf.u;
import android.content.Context;
import androidx.compose.animation.b;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.q;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import r0.g;
import r0.n;
import y0.M;
import y0.s;

public abstract class w {
    public static final void a(int v, List list0, List list1, int v1, float f, a a0, l l0, int v2) {
        a a2;
        V v14;
        b0 b02;
        Q0 q01;
        b0 b01;
        a a1;
        int v4;
        p p0 = (p)l0;
        p0.c0(0x59CE5105);
        int v3 = v2 | (p0.e(v) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.i(list1) ? 0x100 : 0x80) | (p0.e(v1) ? 0x800 : 0x400) | (p0.d(f) ? 0x4000 : 0x2000) | 0x10000;
        if(p0.Q(v3 & 1, (74899 & v3) != 74898)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                v4 = v3 & 0xFFF8FFFF;
                a1 = new a();
            }
            else {
                p0.T();
                v4 = v3 & 0xFFF8FFFF;
                a1 = a0;
            }
            p0.q();
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            Q0 q00 = q.t(p0);
            Iterator iterator0 = list1.iterator();
            if(!iterator0.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = iterator0.next();
            String s = ((GRAPHDATA)object0).value;
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                String s1 = ((GRAPHDATA)object1).value;
                if(s.compareTo(s1) < 0) {
                    s = s1;
                }
            }
            kotlin.jvm.internal.q.f(s, "maxOf(...)");
            Float float0 = u.g0(s);
            float f1 = ((float)Math.ceil((float0 == null ? 0.0f : ((float)float0)))) - 0.0f;
            float f2 = e0.a0(a1.a, p0);
            float f3 = a1.c + (((float)(list0.size() - 1)) * a1.e + ((float)list0.size()) * a1.d + a1.b);
            b0 b00 = p0.N();
            V v5 = k.a;
            if(b00 == v5) {
                b00 = androidx.compose.runtime.w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            a0 a00 = p0.N();
            if(a00 == v5) {
                a00 = androidx.compose.runtime.w.p(0);
                p0.l0(a00);
            }
            int v6 = ScreenUtils.getScreenWidth(context0);
            int v7 = ViewUtilsKt.dpToPx(40);
            List list2 = e.k.A(new s[]{new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.4f))), new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.1f))), new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.0f)))});  // color:gray990s
            List list3 = e.k.A(new s[]{new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 1.0f))), new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 0.4f))), new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 0.0f)))});  // color:green500s_support_high_contrast
            Z z0 = p0.N();
            if(z0 == v5) {
                z0 = androidx.compose.runtime.w.o(0.0f);
                p0.l0(z0);
            }
            float f4 = ((Number)j.b(((I0)z0).m(), f.r(300, 0, null, 6), "", null, p0, 0xC30, 20).getValue()).floatValue();
            n n0 = n.a;
            r0.q q0 = d5.n.o(q.f(d.f(e0.L(androidx.compose.foundation.layout.a.l(e2.a.r(n0, f4), 20.0f, 0.0f, 2), 0x7F06014B), 1.0f), e0.T(p0, a1.f), e.b(4.0f)), e.b(4.0f));  // color:gray100s_support_high_contrast
            ud.l l1 = p0.N();
            if(l1 == v5) {
                l1 = new ud.l(z0, 2);
                p0.l0(l1);
            }
            r0.q q1 = androidx.compose.ui.layout.a.d(q0, l1);
            g g0 = r0.d.m;
            y y0 = M.w.a(M.j.c, g0, p0, 0);
            int v8 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            M.d d0 = M.j.c;
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
            if(p0.O) {
                b01 = b00;
                A7.d.q(v8, p0, v8, h2);
            }
            else {
                b01 = b00;
                if(!kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            c.d(p0, d.h(n0, 18.0f));
            r0.q q3 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v9 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            r0.q q5 = d.n(n0, 19.0f);
            q.c(I.Q(0x7F0803C2, p0, 6), null, q5, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:ic_chart_nowgraph_01
            c.d(p0, d.q(n0, 4.0f));
            long v10 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(a1.g, null, v10, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
            p0.p(true);
            c.d(p0, d.h(n0, 10.0f));
            N1.b((v1 + "회"), androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 0.0f, 0.0f, 14), e0.T(p0, 0x7F06016D), 32.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);  // color:gray900s
            r0.q q6 = d.h(d.q(q.u(n0, q00, true, false), f3), 180.0f);
            vd.k k0 = p0.N();
            if(k0 == v5) {
                q01 = q00;
                b02 = b01;
                k0 = new vd.k(b02, 7);
                p0.l0(k0);
            }
            else {
                q01 = q00;
                b02 = b01;
            }
            r0.q q7 = androidx.compose.ui.layout.a.d(q6, k0);
            y y1 = M.w.a(d0, g0, p0, 0);
            int v11 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            androidx.compose.runtime.w.x(p0, q8, h3);
            c.d(p0, d.h(n0, 20.0f));
            N0.M m0 = M.p.d(r0.d.a, false);
            int v12 = p0.P;
            i0 i03 = p0.m();
            r0.q q9 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h2);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            boolean z1 = ((Boolean)b02.getValue()).booleanValue();
            x0 x00 = f.r(500, 0, C.a, 2);
            sd.j j0 = p0.N();
            if(j0 == v5) {
                j0 = new sd.j(25);
                p0.l0(j0);
            }
            int v13 = (v6 - v7) / 2;
            b.c(z1, null, S.g(x00, j0), null, null, m0.c.e(0x217FB9FB, p0, new t(a1, f3, list0, list1, f1, f2, list3, list2)), p0, 0x180006);
            r0.q q10 = d.q(d.h(n0, a1.a), f3);
            boolean z2 = p0.d(f1);
            boolean z3 = p0.d(f2);
            boolean z4 = p0.i(context0);
            ed.k k1 = p0.N();
            if(((v4 & 0xE000) == 0x4000 | z2 | z3 | z4) == 0) {
                v14 = v5;
                if(k1 == v14) {
                    k1 = new ed.k(f, f1, f2, context0);
                    p0.l0(k1);
                }
            }
            else {
                v14 = v5;
                k1 = new ed.k(f, f1, f2, context0);
                p0.l0(k1);
            }
            q.b(q10, k1, p0, 0);
            p0.p(true);
            r0.q q11 = q.f(d.q(n0, f3), e0.T(p0, 0x7F06013E), M.a);  // color:gray000s
            boolean z5 = p0.i(context0);
            boolean z6 = p0.i(list0);
            boolean z7 = p0.i(list1);
            boolean z8 = p0.g(a1);
            F f5 = p0.N();
            if((z5 | z6 | z7 | z8) != 0 || f5 == v14) {
                F f6 = new F(context0, list0, list1, a1, 26);
                p0.l0(f6);
                f5 = f6;
            }
            q.b(q11, f5, p0, 0);
            l1.y(p0, true, n0, 15.0f, p0);
            p0.p(true);
            Integer integer0 = v;
            boolean z9 = p0.i(list1);
            boolean z10 = p0.i(list0);
            boolean z11 = p0.g(a1);
            boolean z12 = p0.g(q01);
            boolean z13 = p0.e(v13);
            v v15 = p0.N();
            if((z9 | z10 | z11 | z12 | z13) != 0 || v15 == v14) {
                v v16 = new v(list1, list0, a1, q01, v13, z0, b02, a00, null);
                p0.l0(v16);
                v15 = v16;
            }
            J.d(p0, integer0, v15);
            a2 = a1;
        }
        else {
            p0.T();
            a2 = a0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new hd.f(v, list0, list1, v1, f, a2, v2);
        }
    }
}

