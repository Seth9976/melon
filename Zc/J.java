package zc;

import Cc.e0;
import F.S;
import G.f;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import Q0.k0;
import Tf.u;
import android.content.Context;
import androidx.compose.animation.b;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.q;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import com.iloen.melon.net.v4x.common.GraphDataListInfo;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.ArrayList;
import java.util.List;
import r0.a;
import r0.d;
import r0.n;
import r1.c;

public abstract class j {
    public static final void a(int v, List list0, List list1, k k0, float f, l l0, int v1) {
        k k3;
        Z z6;
        b0 b01;
        k k2;
        float f6;
        k k1;
        p p0 = (p)l0;
        p0.c0(0x17225E85);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.i(list0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(list1) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= 0x400;
        }
        if((v1 & 0x6000) == 0) {
            v2 |= (p0.d(f) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            p0.V();
            if((v1 & 1) == 0 || p0.B()) {
                k1 = new k();
            }
            else {
                p0.T();
                k1 = k0;
            }
            p0.q();
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            c c0 = (c)p0.k(k0.h);
            Q0 q00 = q.t(p0);
            float f1 = k1.a;
            float f2 = k1.d;
            float f3 = e0.a0(k1.c, p0);
            int v3 = 0;
            for(Object object0: list1) {
                List list2 = ((GraphDataListInfo)object0).graphDataList;
                kotlin.jvm.internal.q.f(list2, "graphDataList");
                for(Object object1: list2) {
                    String s = ((GRAPHDATA)object1).value;
                    kotlin.jvm.internal.q.f(s, "value");
                    Double double0 = u.f0(s);
                    double f4 = double0 == null ? 0.0 : ((double)double0);
                    if(f4 > ((double)v3)) {
                        v3 = (int)Math.ceil(f4);
                    }
                }
            }
            float f5 = e0.a0(f1 - k1.f, p0);
            b0 b00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(b00 == v4) {
                b00 = w.s(Boolean.valueOf(list0.size() < 2));
                p0.l0(b00);
            }
            Z z0 = p0.N();
            if(z0 == v4) {
                z0 = w.o(0.0f);
                p0.l0(z0);
            }
            if(list0.size() == 1) {
                f6 = 0.0f;
            }
            else {
                int v5 = list0.size();
                f6 = (float)(2 > v5 || v5 >= 5 ? ViewUtilsKt.dpToPx((f - f2) / 3.0f) : ViewUtilsKt.dpToPx((f - f2) / ((float)(list0.size() - 1))));
            }
            float f7 = list0.size() <= 4 ? f : ((float)(list0.size() - 1)) * ((c)p0.k(k0.h)).S(f6) + f2;
            ArrayList arrayList0 = new ArrayList();
            int v6 = 0;
            for(Object object2: list1) {
                if(v6 >= 0) {
                    GraphDataListInfo graphDataListInfo0 = (GraphDataListInfo)object2;
                    if(v != v6) {
                        arrayList0.add(v6);
                    }
                    ++v6;
                    continue;
                }
                e.k.O();
                throw null;
            }
            arrayList0.add(v);
            M m0 = M.p.d(d.a, false);
            int v7 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
            r0.q q0 = a.d(p0, n0);
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
            w.x(p0, m0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q0, h3);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v8 = p0.P;
            i0 i01 = p0.m();
            r0.q q1 = a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            w.x(p0, q1, h3);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, k1.c));
            r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(q.f(q.u(n0, q00, true, false), e0.T(p0, 0x7F0604AA), y0.M.a), f7), f1);  // color:white000s_support_high_contrast
            boolean z1 = p0.g(c0);
            boolean z2 = p0.i(k1);
            boolean z3 = p0.i(context0);
            boolean z4 = p0.i(list0);
            boolean z5 = p0.d(f6);
            e e0 = p0.N();
            if((z1 | z2 | z3 | z4 | z5) != 0 || e0 == v4) {
                k2 = k1;
                b01 = b00;
                e e1 = new e(c0, k2, context0, list0, z0, f6);
                z6 = z0;
                p0.l0(e1);
                e0 = e1;
            }
            else {
                k2 = k1;
                b01 = b00;
                z6 = z0;
            }
            q.b(q2, e0, p0, 0);
            p0.p(true);
            b.d(((Boolean)b01.getValue()).booleanValue(), null, S.a(f.q(10.0f, 5, null)), null, null, m0.c.e(0xBD03E9E3, p0, new zc.f(f3, q00, f7, k2, arrayList0, list1, context0, list0, f6, ((float)v3) - 0.0f, f5, v, z6)), p0, 0x30180, 26);
            p0.p(true);
            Integer integer0 = v;
            boolean z7 = p0.d(f7);
            boolean z8 = p0.g(q00);
            zc.i i1 = p0.N();
            if(z7 || z8 || i1 == v4) {
                i1 = new zc.i(f7, q00, b01, null);
                p0.l0(i1);
            }
            J.d(p0, integer0, i1);
            k3 = k2;
        }
        else {
            p0.T();
            k3 = k0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new hd.f(v, list0, list1, k3, f, v1);
        }
    }
}

