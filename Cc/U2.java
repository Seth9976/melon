package Cc;

import Ac.D;
import Ac.R0;
import F.f0;
import G.C;
import G.H;
import G.e;
import G.f;
import G.x0;
import P0.h;
import P0.j;
import android.content.Context;
import android.graphics.PathMeasure;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.AndroidSettings;
import com.melon.ui.common.composable.PlayBgColorData;
import e.k;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import oe.c;
import r0.n;
import r0.q;
import wc.u;
import y0.M;
import y0.i;
import y0.s;

public abstract class u2 {
    public static final x0 a;
    public static final x0 b;
    public static final x0 c;
    public static final H d;
    public static final List e;

    static {
        u2.a = new x0(15000, C.d, 2);
        u2.b = new x0(500, C.a, 2);
        u2.c = new x0(20000, C.d, 2);
        u2.d = f.n(f.r(28000, 0, C.d, 2), null, 0L, 6);
        u2.e = k.A(new Float[]{1.0f, 0.85f, 0.6f, 0.7f});
    }

    public static final void a(PlayBgColorData playBgColorData0, x0 x00, float f, float f1, x0 x01, x0 x02, H h0, List list0, boolean z, l l0, int v, int v1) {
        x0 x014;
        float f9;
        x0 x013;
        H h5;
        List list8;
        float f8;
        x0 x012;
        b0 b011;
        b0 b010;
        b0 b09;
        b1 b16;
        b0 b04;
        List list7;
        b1 b15;
        b1 b14;
        List list6;
        H h3;
        b1 b13;
        b1 b12;
        b1 b11;
        b1 b10;
        x0 x011;
        boolean z23;
        float f5;
        b0 b03;
        float f4;
        boolean z22;
        e e12;
        e e10;
        b0 b02;
        boolean z19;
        boolean z18;
        boolean z17;
        boolean z15;
        e e8;
        boolean z14;
        boolean z13;
        b0 b01;
        e e6;
        boolean z11;
        boolean z10;
        boolean z9;
        x0 x010;
        int v14;
        int v13;
        e e3;
        x0 x09;
        List list5;
        int v11;
        e e2;
        x0 x08;
        boolean z5;
        List list4;
        int v10;
        x0 x07;
        List list1;
        H h1;
        boolean z2;
        int v6;
        x0 x05;
        float f3;
        float f2;
        x0 x04;
        int v7;
        int v5;
        boolean z1;
        x0 x03;
        p p0 = (p)l0;
        p0.c0(0x72D3DFE4);
        int v2 = (p0.i(playBgColorData0) ? 4 : 2) | v;
        int v3 = v2 | 0xDB0;
        if((v1 & 16) != 0) {
            v3 = v2 | 28080;
            x03 = x01;
        }
        else if((v & 0x6000) == 0) {
            x03 = x01;
            v3 |= (p0.g(x03) ? 0x4000 : 0x2000);
        }
        else {
            x03 = x01;
        }
        int v4 = v3 | 0x4B0000;
        if((v & 0x6000000) == 0) {
            if((v1 & 0x100) == 0) {
                z1 = z;
                v5 = p0.h(z1) ? 0x4000000 : 0x2000000;
            }
            else {
                z1 = z;
                v5 = 0x2000000;
            }
            v4 |= v5;
        }
        else {
            z1 = z;
        }
        if(p0.Q(v4 & 1, (0x2492493 & v4) != 0x2492492)) {
            p0.V();
            if((v & 1) == 0 || p0.B()) {
                if((v1 & 16) != 0) {
                    x03 = u2.b;
                }
                x04 = u2.a;
                f3 = 1.2f;
                x0 x06 = u2.c;
                H h2 = u2.d;
                List list2 = u2.e;
                if((v1 & 0x100) == 0) {
                    v6 = v4 & 0xFE07FFFF;
                    z2 = z1;
                }
                else {
                    if(MelonSettingInfo.isLowMemoryMode()) {
                        p0.a0(0x9E1F452C);
                        p0.p(false);
                        v7 = 0;
                    }
                    else {
                        p0.a0(224123081);
                        v7 = !AndroidSettings.isAnimationDisabled(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
                        p0.p(false);
                    }
                    v6 = v4 & 0xF007FFFF;
                    z2 = v7;
                }
                x05 = x06;
                h1 = h2;
                list1 = list2;
                f2 = 1.5f;
            }
            else {
                p0.T();
                x04 = x00;
                f2 = f;
                f3 = f1;
                x05 = x02;
                v6 = (v1 & 0x100) == 0 ? v4 & 0xFE07FFFF : v4 & 0xF007FFFF;
                z2 = z1;
                h1 = h0;
                list1 = list0;
            }
            p0.q();
            List list3 = k.A(new Integer[]{4605510, 0x333333, 0x242424});
            b0 b00 = p0.N();
            V v8 = androidx.compose.runtime.k.a;
            if(b00 == v8) {
                b00 = w.s(new r1.l(0L));
                p0.l0(b00);
            }
            e e0 = p0.N();
            if(e0 == v8) {
                e0 = f0.a(s.f);
                p0.l0(e0);
            }
            boolean z3 = p0.i(e0);
            boolean z4 = p0.i(playBgColorData0);
            int v9 = v6 & 0xE000000 ^ 0x6000000;
            if(v9 > 0x4000000 && p0.h(z2)) {
                x07 = x03;
                v10 = 1;
            }
            else {
                x07 = x03;
                v10 = (v6 & 0x6000000) == 0x4000000 ? 1 : 0;
            }
            g2 g20 = p0.N();
            if((v10 | (z3 | z4 | ((v6 & 0xE000) == 0x4000 ? 1 : 0))) != 0 || g20 == v8) {
                g20 = new g2(e0, playBgColorData0, x07, x05, list3, z2, null);
                x08 = x05;
                list4 = list3;
                z5 = z2;
                p0.l0(g20);
            }
            else {
                list4 = list3;
                z5 = z2;
                x08 = x05;
            }
            J.d(p0, playBgColorData0, g20);
            e e1 = p0.N();
            if(e1 == v8) {
                e1 = f0.a(s.f);
                p0.l0(e1);
            }
            boolean z6 = p0.i(e1);
            boolean z7 = p0.i(playBgColorData0);
            if(v9 > 0x4000000 && p0.h(z5)) {
                e2 = e1;
                v11 = 1;
            }
            else {
                e2 = e1;
                v11 = (v6 & 0x6000000) == 0x4000000 ? 1 : 0;
            }
            k2 k20 = p0.N();
            if((z6 | z7 | ((v6 & 0xE000) == 0x4000 ? 1 : 0) | v11) != 0 || k20 == v8) {
                k20 = new k2(e2, playBgColorData0, x07, x08, list4, z5, null);
                e3 = e2;
                x09 = x08;
                list5 = list4;
                p0.l0(k20);
            }
            else {
                list5 = list4;
                x09 = x08;
                e3 = e2;
            }
            J.d(p0, playBgColorData0, k20);
            e e4 = p0.N();
            if(e4 == v8) {
                e4 = f0.a(s.f);
                p0.l0(e4);
            }
            int v12 = p0.i(e4) | p0.i(playBgColorData0) | ((v6 & 0xE000) == 0x4000 ? 1 : 0);
            if(v9 > 0x4000000 && p0.h(z5)) {
                v13 = v12;
                v14 = 1;
            }
            else {
                v13 = v12;
                v14 = (v6 & 0x6000000) == 0x4000000 ? 1 : 0;
            }
            l2 l20 = p0.N();
            if((v13 | v14) != 0 || l20 == v8) {
                l20 = new l2(e4, playBgColorData0, x07, x09, list5, z5, null);
                x010 = x07;
                p0.l0(l20);
            }
            else {
                x010 = x07;
            }
            J.d(p0, playBgColorData0, l20);
            e e5 = p0.N();
            if(e5 == v8) {
                e5 = f.a(1.0f);
                p0.l0(e5);
            }
            Object object0 = b00.getValue();
            boolean z8 = p0.i(e5);
            if(v9 > 0x4000000 && p0.h(z5)) {
                z9 = z5;
                z10 = true;
            }
            else {
                z9 = z5;
                z10 = (v6 & 0x6000000) == 0x4000000;
            }
            m2 m20 = p0.N();
            if(z8 || z10 || m20 == v8) {
                m20 = new m2(e5, b00, f2, f3, x04, z9, null);
                e6 = e5;
                b01 = b00;
                z11 = z9;
                p0.l0(m20);
            }
            else {
                z11 = z9;
                e6 = e5;
                b01 = b00;
            }
            J.d(p0, object0, m20);
            e e7 = p0.N();
            if(e7 == v8) {
                e7 = f.a(1.0f);
                p0.l0(e7);
            }
            Object object1 = b01.getValue();
            boolean z12 = p0.i(e7);
            if(v9 > 0x4000000 && p0.h(z11)) {
                z13 = z11;
                z14 = true;
            }
            else {
                z13 = z11;
                z14 = (v6 & 0x6000000) == 0x4000000;
            }
            n2 n20 = p0.N();
            if(z12 || z14 || n20 == v8) {
                n20 = new n2(e7, b01, f2, f3, x04, z13, null);
                e8 = e7;
                z15 = z13;
                p0.l0(n20);
            }
            else {
                e8 = e7;
                z15 = z13;
            }
            J.d(p0, object1, n20);
            e e9 = p0.N();
            if(e9 == v8) {
                e9 = f.a(1.0f);
                p0.l0(e9);
            }
            Object object2 = b01.getValue();
            boolean z16 = p0.i(e9);
            if(v9 > 0x4000000 && p0.h(z15)) {
                z17 = z15;
                z18 = true;
            }
            else {
                z17 = z15;
                z18 = (v6 & 0x6000000) == 0x4000000;
            }
            o2 o20 = p0.N();
            if(z16 || z18 || o20 == v8) {
                b02 = b01;
                o20 = new o2(e9, b02, f2, f3, x04, z17, null);
                e10 = e9;
                z19 = z17;
                p0.l0(o20);
            }
            else {
                z19 = z17;
                b02 = b01;
                e10 = e9;
            }
            J.d(p0, object2, o20);
            e e11 = p0.N();
            if(e11 == v8) {
                e11 = f.a(1.0f);
                p0.l0(e11);
            }
            Object object3 = b02.getValue();
            boolean z20 = p0.i(e11);
            boolean z21 = v9 > 0x4000000 && p0.h(z19) || (v6 & 0x6000000) == 0x4000000;
            p2 p20 = p0.N();
            if(z20 || z21 || p20 == v8) {
                p20 = new p2(e11, b02, f2, f3, x04, z19, null);
                e12 = e11;
                b03 = b02;
                f4 = f3;
                z22 = z19;
                p0.l0(p20);
            }
            else {
                e12 = e11;
                z22 = z19;
                f4 = f3;
                b03 = b02;
            }
            J.d(p0, object3, p20);
            if(z22) {
                p0.a0(-1638307753);
                e e13 = p0.N();
                if(e13 == v8) {
                    e13 = f.a(0.0f);
                    p0.l0(e13);
                }
                i i0 = p0.N();
                if(i0 == v8) {
                    f5 = f4;
                    i0 = new i(new PathMeasure());
                    p0.l0(i0);
                }
                else {
                    f5 = f4;
                }
                a a0 = p0.N();
                if(a0 == v8) {
                    z23 = true;
                    x011 = x09;
                    K1 k10 = new K1(2);
                    a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a0.a = k10;
                    p0.l0(a0);
                }
                else {
                    z23 = true;
                    x011 = x09;
                }
                E e14 = p0.N();
                if(e14 == v8) {
                    e14 = w.i(new f2(e13, i0, a0, 0));
                    p0.l0(e14);
                }
                E e15 = p0.N();
                if(e15 == v8) {
                    b10 = e14;
                    e15 = w.i(new f2(e13, i0, a0, 1));
                    p0.l0(e15);
                }
                else {
                    b10 = e14;
                }
                E e16 = p0.N();
                if(e16 == v8) {
                    b11 = e15;
                    e16 = w.i(new f2(e13, i0, a0, 2));
                    p0.l0(e16);
                }
                else {
                    b11 = e15;
                }
                E e17 = p0.N();
                if(e17 == v8) {
                    b12 = e16;
                    e17 = w.i(new f2(e13, i0, a0, 3));
                    p0.l0(e17);
                }
                else {
                    b12 = e16;
                }
                b13 = e17;
                Object object4 = b03.getValue();
                boolean z24 = p0.i(i0);
                boolean z25 = p0.i(a0);
                boolean z26 = p0.i(list1);
                boolean z27 = p0.i(e13);
                boolean z28 = p0.i(h1);
                h2 h20 = p0.N();
                if((z24 | z25 | z26 | z27 | z28) != 0 || h20 == v8) {
                    h20 = new h2(b03, f2, i0, a0, list1, e13, h1, null);
                    list6 = list1;
                    h3 = h1;
                    p0.l0(h20);
                }
                else {
                    h3 = h1;
                    list6 = list1;
                }
                J.d(p0, object4, h20);
                p0.p(false);
                b14 = b10;
                b15 = b12;
                list7 = list6;
                b04 = b03;
                b16 = b11;
            }
            else {
                f5 = f4;
                z23 = false;
                h3 = h1;
                x011 = x09;
                p0.a0(0x9E8145C2);
                b0 b05 = p0.N();
                z z29 = z.d;
                if(b05 == v8) {
                    b05 = w.s(z29);
                    p0.l0(b05);
                }
                b0 b06 = p0.N();
                if(b06 == v8) {
                    b06 = w.s(z29);
                    p0.l0(b06);
                }
                b0 b07 = p0.N();
                if(b07 == v8) {
                    b07 = w.s(z29);
                    p0.l0(b07);
                }
                b0 b08 = p0.N();
                if(b08 == v8) {
                    b08 = w.s(z29);
                    p0.l0(b08);
                }
                Object object5 = b03.getValue();
                boolean z30 = p0.g(b05);
                boolean z31 = p0.i(list1);
                boolean z32 = p0.g(b06);
                boolean z33 = p0.g(b07);
                boolean z34 = p0.g(b08);
                i2 i20 = p0.N();
                if((z30 | z31 | z32 | z33 | z34) != 0 || i20 == v8) {
                    list7 = list1;
                    b09 = b06;
                    b010 = b07;
                    b011 = b08;
                    i20 = new i2(b03, f2, b05, list7, b09, b010, b011, null);
                    b04 = b03;
                    p0.l0(i20);
                }
                else {
                    list7 = list1;
                    b09 = b06;
                    b010 = b07;
                    b011 = b08;
                    b04 = b03;
                }
                J.d(p0, object5, i20);
                p0.p(false);
                b14 = b05;
                b16 = b09;
                b15 = b010;
                b13 = b011;
            }
            y0.e e18 = B.a.Q(p0, 0x7F0802EE);  // drawable:circle_shape_70
            n n0 = n.a;
            q q0 = d.c(d.f(n0, 1.0f), 1.0f);
            long v15 = e0.T(p0, 0x7F060170);  // color:gray920e_support_high_contrast
            u u0 = M.a;
            q q1 = androidx.compose.foundation.q.f(q0, v15, u0);
            R0 r00 = p0.N();
            if(r00 == v8) {
                r00 = new R0(b04, 4);
                p0.l0(r00);
            }
            q q2 = androidx.compose.ui.layout.a.f(q1, r00);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v16 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h4 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v16)) {
                A7.d.q(v16, p0, v16, h4);
            }
            w.x(p0, q3, j.d);
            if(r1.l.b(((r1.l)b04.getValue()).a, 0L)) {
                p0.a0(0x4CF7B438);
            }
            else {
                p0.a0(1304509804);
                float f6 = e0.Y(((float)(((int)(((r1.l)b04.getValue()).a >> 0x20)))) * f2, p0);
                float f7 = e0.Y(((float)(((int)(((r1.l)b04.getValue()).a & 0xFFFFFFFFL)))) * 0.5f * f2, p0);
                boolean z35 = p0.g(b13);
                Cc.b0 b012 = p0.N();
                if(z35 || b012 == v8) {
                    b012 = new Cc.b0(b13, 1);
                    p0.l0(b012);
                }
                boolean z36 = p0.i(e12);
                b2 b20 = p0.N();
                if(z36 || b20 == v8) {
                    b20 = new b2(e12, 0);
                    p0.l0(b20);
                }
                boolean z37 = p0.i(e0);
                j2 j20 = p0.N();
                if(z37 || j20 == v8) {
                    j20 = new j2(e0, 1);
                    p0.l0(j20);
                }
                u2.b(e18, b012, f6, f7, b20, j20, p0, 0);
                boolean z38 = p0.g(b15);
                Cc.b0 b013 = p0.N();
                if(z38 || b013 == v8) {
                    b013 = new Cc.b0(b15, 2);
                    p0.l0(b013);
                }
                boolean z39 = p0.i(e10);
                b2 b21 = p0.N();
                if(z39 || b21 == v8) {
                    b21 = new b2(e10, 1);
                    p0.l0(b21);
                }
                boolean z40 = p0.i(e4);
                j2 j21 = p0.N();
                if(z40 || j21 == v8) {
                    j21 = new j2(e4, 2);
                    p0.l0(j21);
                }
                u2.b(e18, b013, f6, f7, b21, j21, p0, 0);
                boolean z41 = p0.g(b16);
                Cc.b0 b014 = p0.N();
                if(z41 || b014 == v8) {
                    b014 = new Cc.b0(b16, 3);
                    p0.l0(b014);
                }
                boolean z42 = p0.i(e8);
                b2 b22 = p0.N();
                if(z42 || b22 == v8) {
                    b22 = new b2(e8, 2);
                    p0.l0(b22);
                }
                boolean z43 = p0.i(e3);
                j2 j22 = p0.N();
                if(z43 || j22 == v8) {
                    j22 = new j2(e3, 3);
                    p0.l0(j22);
                }
                u2.b(e18, b014, f6, f7, b22, j22, p0, 0);
                boolean z44 = p0.g(b14);
                Cc.b0 b015 = p0.N();
                if(z44 || b015 == v8) {
                    b015 = new Cc.b0(b14, 4);
                    p0.l0(b015);
                }
                boolean z45 = p0.i(e6);
                b2 b23 = p0.N();
                if(z45 || b23 == v8) {
                    b23 = new b2(e6, 3);
                    p0.l0(b23);
                }
                boolean z46 = p0.i(e0);
                j2 j23 = p0.N();
                if(z46 || j23 == v8) {
                    j23 = new j2(e0, 0);
                    p0.l0(j23);
                }
                u2.b(e18, b015, f6, f7, b23, j23, p0, 0);
                M.p.a(androidx.compose.foundation.q.f(d.c(d.f(n0, 1.0f), 1.0f), e0.T(p0, 0x7F060140), u0), p0, 0);  // color:gray001e_support_high_contrast
                M.p.a(androidx.compose.foundation.q.e(d.c(d.f(n0, 1.0f), 1.0f), u.f(k.A(new s[]{new s(e0.T(p0, 0x7F06016F)), new s(e0.T(p0, 0x7F060170))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:gray920e_10_support_high_contrast
            }
            p0.p(false);
            p0.p(true);
            x012 = x04;
            f8 = f2;
            list8 = list7;
            h5 = h3;
            x013 = x010;
            f9 = f5;
            z1 = z23;
            x014 = x011;
        }
        else {
            p0.T();
            f8 = f;
            f9 = f1;
            x014 = x02;
            h5 = h0;
            list8 = list0;
            x013 = x03;
            x012 = x00;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new e2(playBgColorData0, x012, f8, f9, x013, x014, h5, list8, z1, v, v1);
        }
    }

    public static final void b(y0.e e0, we.a a0, float f, float f1, we.a a1, we.a a2, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-65104007);
        int v1 = v | (p0.i(e0) ? 4 : 2) | (p0.i(a0) ? 0x20 : 16) | (p0.d(f) ? 0x100 : 0x80) | (p0.d(f1) ? 0x800 : 0x400) | (p0.i(a1) ? 0x4000 : 0x2000) | (p0.i(a2) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            n n0 = n.a;
            q q0 = d.u(n0, 1);
            u1 u10 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 0x70) == 0x20 || u10 == v2) {
                u10 = new u1(1, a0);
                p0.l0(u10);
            }
            q q1 = androidx.compose.ui.graphics.a.a(q0, u10);
            r0.i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            q q3 = d.o(n0, f, f1);
            u1 u11 = p0.N();
            if((v1 & 0x70) == 0x20 || u11 == v2) {
                u11 = new u1(2, a0);
                p0.l0(u11);
            }
            q q4 = androidx.compose.ui.graphics.a.a(q3, u11);
            N0.M m1 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q5, h3);
            FillElement fillElement0 = d.c;
            u1 u12 = p0.N();
            if((v1 & 0xE000) == 0x4000 || u12 == v2) {
                u12 = new u1(3, a1);
                p0.l0(u12);
            }
            q q6 = androidx.compose.ui.graphics.a.a(fillElement0, u12);
            boolean z = p0.i(e0);
            D d0 = p0.N();
            if(z || (v1 & 0x70000) == 0x20000 || d0 == v2) {
                d0 = new D(20, a2, e0);
                p0.l0(d0);
            }
            q q7 = androidx.compose.ui.draw.a.c(q6, d0);
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q7, r0.d.e), p0, 0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c2(e0, a0, f, f1, a1, a2, v);
        }
    }

    public static final Object c(e e0, Integer integer0, long v, PlayBgColorData playBgColorData0, x0 x00, x0 x01, List list0, boolean z, c c0) {
        PlayBgColorData playBgColorData2;
        x0 x03;
        List list2;
        Integer integer2;
        long v5;
        boolean z2;
        long v4;
        e e2;
        PlayBgColorData playBgColorData3;
        x0 x04;
        List list3;
        Integer integer3;
        Job job0;
        long v7;
        boolean z3;
        long v6;
        long v8;
        long v10;
        q2 q20;
        if(c0 instanceof q2) {
            q20 = (q2)c0;
            int v1 = q20.T;
            if((v1 & 0x80000000) == 0) {
                q20 = new q2(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                q20.T = v1 ^ 0x80000000;
            }
        }
        else {
            q20 = new q2(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = q20.S;
        ne.a a0 = ne.a.a;
    alab1:
        switch(q20.T) {
            case 0: {
                d5.n.D(object0);
                Integer integer4 = playBgColorData0 == null || !(integer0 == null ? false : P4.a.K(0, playBgColorData0.b.size()).d(((int)integer0))) ? u2.h(playBgColorData0, null) : integer0;
                s s0 = new s(u2.f(integer4, playBgColorData0, list0));
                q20.r = e0;
                q20.w = playBgColorData0;
                q20.B = x01;
                q20.D = list0;
                q20.E = integer4;
                v10 = v;
                q20.I = v10;
                q20.N = z;
                q20.T = 1;
                if(e.c(e0, s0, x00, null, q20, 12) != a0) {
                    playBgColorData2 = playBgColorData0;
                    list2 = list0;
                    integer2 = integer4;
                    x03 = x01;
                    e2 = e0;
                    z2 = z;
                label_81:
                    if(!z2) {
                        return ie.H.a;
                    }
                    q20.r = e2;
                    q20.w = playBgColorData2;
                    q20.B = x03;
                    q20.D = list2;
                    q20.E = integer2;
                    q20.I = v10;
                    q20.N = true;
                    q20.T = 2;
                    if(DelayKt.delay(v10, q20) != a0) {
                        v5 = v10;
                        v8 = (long)x03.a;
                    label_93:
                        while(JobKt.isActive(q20.getContext())) {
                            Integer integer5 = u2.h(playBgColorData2, integer2);
                            Job job1 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(q20.getContext()), null, null, new r2(v8, null), 3, null);
                            s s1 = new s(u2.f(integer5, playBgColorData2, list2));
                            q20.r = e2;
                            q20.w = playBgColorData2;
                            q20.B = x03;
                            q20.D = list2;
                            q20.E = integer5;
                            q20.G = job1;
                            q20.I = v5;
                            q20.N = z2;
                            q20.M = v8;
                            q20.T = 3;
                            if(e.c(e2, s1, x03, null, q20, 12) == a0) {
                                break alab1;
                            }
                            job0 = job1;
                            z3 = z2;
                            integer3 = integer5;
                            v6 = v8;
                            playBgColorData3 = playBgColorData2;
                            x04 = x03;
                            list3 = list2;
                            v7 = v5;
                        label_116:
                            q20.r = e2;
                            q20.w = playBgColorData3;
                            q20.B = x04;
                            q20.D = list3;
                            q20.E = integer3;
                            q20.G = null;
                            q20.I = v7;
                            q20.N = z3;
                            q20.M = v6;
                            q20.T = 4;
                            if(job0.join(q20) == a0) {
                                break alab1;
                            }
                            x03 = x04;
                            v4 = v6;
                            z2 = z3;
                            v5 = v7;
                            integer2 = integer3;
                            list2 = list3;
                            playBgColorData2 = playBgColorData3;
                        label_134:
                            v8 = v4;
                        }
                        return ie.H.a;
                    }
                }
                break;
            }
            case 1: {
                z2 = q20.N;
                long v9 = q20.I;
                integer2 = q20.E;
                list2 = q20.D;
                x03 = q20.B;
                playBgColorData2 = q20.w;
                e2 = q20.r;
                d5.n.D(object0);
                v10 = v9;
                goto label_81;
            }
            case 2: {
                z2 = q20.N;
                v5 = q20.I;
                integer2 = q20.E;
                list2 = q20.D;
                x03 = q20.B;
                playBgColorData2 = q20.w;
                e2 = q20.r;
                d5.n.D(object0);
                v8 = (long)x03.a;
                goto label_93;
            }
            case 3: {
                v6 = q20.M;
                z3 = q20.N;
                v7 = q20.I;
                job0 = q20.G;
                integer3 = q20.E;
                list3 = q20.D;
                x04 = q20.B;
                playBgColorData3 = q20.w;
                e2 = q20.r;
                d5.n.D(object0);
                goto label_116;
            }
            case 4: {
                long v2 = q20.M;
                boolean z1 = q20.N;
                long v3 = q20.I;
                Integer integer1 = q20.E;
                List list1 = q20.D;
                x0 x02 = q20.B;
                PlayBgColorData playBgColorData1 = q20.w;
                e e1 = q20.r;
                d5.n.D(object0);
                e2 = e1;
                v4 = v2;
                z2 = z1;
                v5 = v3;
                integer2 = integer1;
                list2 = list1;
                x03 = x02;
                playBgColorData2 = playBgColorData1;
                goto label_134;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public static final Object d(e e0, long v, float f, float f1, x0 x00, boolean z, c c0) {
        long v8;
        float f8;
        float f7;
        long v7;
        ne.a a1;
        e e2;
        ie.H h1;
        float f6;
        int v6;
        x0 x02;
        boolean z2;
        s2 s21;
        List list0;
        int v4;
        float f3;
        float f15;
        Job job1;
        x0 x04;
        float f14;
        e e4;
        float f13;
        s2 s22;
        List list2;
        ne.a a2;
        int v14;
        int v11;
        boolean z3;
        int v10;
        e e5;
        x0 x05;
        List list3;
        long v17;
        float f19;
        int v16;
        float f17;
        float f16;
        int v15;
        float f25;
        int v20;
        ne.a a3;
        s2 s20;
        if(c0 instanceof s2) {
            s20 = (s2)c0;
            int v1 = s20.Z;
            if((v1 & 0x80000000) == 0) {
                s20 = new s2(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                s20.Z = v1 ^ 0x80000000;
            }
        }
        else {
            s20 = new s2(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = s20.Y;
        ne.a a0 = ne.a.a;
        ie.H h0 = ie.H.a;
        switch(s20.Z) {
            case 0: {
                d5.n.D(object0);
                if(!r1.l.b(v, 0L) && ((int)(0xFFFFFFFFL & v)) != 0) {
                    float f20 = ((float)(((int)(0xFFFFFFFFL & v)))) * 0.5f;
                    float f21 = ((float)(((int)(v >> 0x20)))) / f20;
                    if(z) {
                        ArrayList arrayList0 = new ArrayList();
                        if(Float.compare(0.0f, f21) >= 0 || f21 >= 3.0f) {
                            for(float f23 = f; f23 > (f + f1) / 2.0f; f23 -= 0.1f) {
                                arrayList0.add(new Float(f23 / f));
                            }
                        }
                        else {
                            for(float f22 = f; f22 >= f1; f22 -= 0.1f) {
                                arrayList0.add(new Float(f22 / f));
                            }
                        }
                        if(!arrayList0.isEmpty()) {
                            goto label_133;
                        }
                        s20.r = null;
                        s20.w = null;
                        s20.B = null;
                        s20.E = v;
                        s20.I = f;
                        s20.M = f1;
                        s20.T = true;
                        s20.V = (int)(v >> 0x20);
                        s20.N = f20;
                        s20.S = f21;
                        s20.Z = 2;
                        if(e0.e(new Float(1.0f), s20) == a0) {
                            return a0;
                        label_133:
                            int v18 = P4.a.y(k.r(arrayList0));
                            Object object1 = arrayList0.get(v18);
                            s20.r = e0;
                            x05 = x00;
                            s20.w = x05;
                            s20.B = arrayList0;
                            s20.E = v;
                            s20.I = f;
                            s20.M = f1;
                            s20.T = true;
                            s20.V = (int)(v >> 0x20);
                            s20.N = f20;
                            s20.S = f21;
                            s20.W = v18;
                            s20.Z = 3;
                            if(e0.e(object1, s20) != a0) {
                                f19 = f;
                                v16 = (int)(v >> 0x20);
                                f17 = f20;
                                f16 = f21;
                                list3 = arrayList0;
                                e5 = e0;
                                v15 = v18;
                                v17 = v;
                            label_157:
                                f6 = f1;
                                h1 = h0;
                                e2 = e5;
                                f3 = f17;
                                x0 x06 = x05;
                                long v19 = (long)x05.a;
                                List list4 = list3;
                                v6 = v15;
                                v7 = v17;
                                f7 = f19;
                                s21 = s20;
                                z2 = z;
                                v4 = v16;
                                float f24 = f16;
                                while(JobKt.isActive(s21.getContext())) {
                                    if(v6 == 0) {
                                        a3 = a0;
                                        v20 = list4.size() - 1;
                                        if(1 <= v20) {
                                            v20 = 1;
                                        }
                                        f25 = f24;
                                    }
                                    else {
                                        a3 = a0;
                                        if(v6 == list4.size() - 1) {
                                            v20 = v6 - 1 >= 0 ? v6 - 1 : 0;
                                            f25 = f24;
                                        }
                                        else {
                                            f25 = f24;
                                            v20 = ((Number)je.p.B0(k.A(new Integer[]{new Integer(v6 - 1), new Integer(v6 + 1)}), Ae.f.a)).intValue();
                                        }
                                    }
                                    Job job2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(s21.getContext()), null, null, new t2(v19, null), 3, null);
                                    Object object2 = list4.get(v20);
                                    s21.r = e2;
                                    s21.w = x06;
                                    s21.B = list4;
                                    s21.D = job2;
                                    s21.E = v7;
                                    s21.I = f7;
                                    s21.M = f6;
                                    s21.T = z2;
                                    s21.V = v4;
                                    s21.N = f3;
                                    f8 = f25;
                                    s21.S = f8;
                                    s21.W = v20;
                                    s21.G = v19;
                                    s21.X = v20;
                                    s21.Z = 4;
                                    s22 = s21;
                                    if(e.c(e2, object2, x06, null, s21, 12) == a3) {
                                        return a3;
                                    }
                                    v10 = v4;
                                    f15 = f6;
                                    v14 = v20;
                                    job1 = job2;
                                    list2 = list4;
                                    v11 = v14;
                                    v8 = v19;
                                    x04 = x06;
                                    a2 = a3;
                                    f13 = f7;
                                    z3 = z2;
                                    f14 = f3;
                                    e4 = e2;
                                label_220:
                                    s22.r = e4;
                                    s22.w = x04;
                                    x02 = x04;
                                    s22.B = list2;
                                    s22.D = null;
                                    s22.E = v7;
                                    s22.I = f13;
                                    s22.M = f15;
                                    s22.T = z3;
                                    s22.V = v10;
                                    s22.N = f14;
                                    s22.S = f8;
                                    s22.W = v14;
                                    s22.G = v8;
                                    s22.X = v11;
                                    s22.Z = 5;
                                    a1 = a2;
                                    if(job1.join(s22) == a1) {
                                        return a1;
                                    }
                                    f6 = f15;
                                    v6 = v14;
                                    v4 = v10;
                                    s21 = s22;
                                    e2 = e4;
                                    f3 = f14;
                                    z2 = z3;
                                    f7 = f13;
                                    list0 = list2;
                                label_248:
                                    a0 = a1;
                                    v19 = v8;
                                    f24 = f8;
                                    list4 = list0;
                                    x06 = x02;
                                }
                                return h1;
                            }
                            return a0;
                        }
                    }
                    else {
                        s20.r = null;
                        s20.w = null;
                        s20.E = v;
                        s20.I = f;
                        s20.M = f1;
                        s20.T = false;
                        s20.V = (int)(v >> 0x20);
                        s20.N = f20;
                        s20.S = f21;
                        s20.Z = 1;
                        if(e0.e(new Float(1.0f), s20) == a0) {
                            return a0;
                        }
                    }
                }
                return h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            case 3: {
                v15 = s20.W;
                f16 = s20.S;
                f17 = s20.N;
                v16 = s20.V;
                boolean z4 = s20.T;
                float f18 = s20.M;
                f19 = s20.I;
                v17 = s20.E;
                list3 = s20.B;
                x05 = s20.w;
                e5 = s20.r;
                d5.n.D(object0);
                z = z4;
                f1 = f18;
                goto label_157;
            }
            case 4: {
                int v9 = s20.W;
                float f9 = s20.S;
                float f10 = s20.N;
                v10 = s20.V;
                z3 = s20.T;
                float f11 = s20.M;
                float f12 = s20.I;
                v11 = s20.X;
                long v12 = s20.G;
                long v13 = s20.E;
                Job job0 = s20.D;
                List list1 = s20.B;
                x0 x03 = s20.w;
                e e3 = s20.r;
                d5.n.D(object0);
                v14 = v9;
                a2 = a0;
                h1 = h0;
                list2 = list1;
                f8 = f9;
                s22 = s20;
                f13 = f12;
                e4 = e3;
                f14 = f10;
                x04 = x03;
                job1 = job0;
                f15 = f11;
                v8 = v12;
                v7 = v13;
                goto label_220;
            }
            case 5: {
                long v2 = s20.G;
                int v3 = s20.W;
                float f2 = s20.S;
                f3 = s20.N;
                v4 = s20.V;
                boolean z1 = s20.T;
                float f4 = s20.M;
                float f5 = s20.I;
                long v5 = s20.E;
                list0 = s20.B;
                x0 x01 = s20.w;
                e e1 = s20.r;
                d5.n.D(object0);
                s21 = s20;
                z2 = z1;
                x02 = x01;
                v6 = v3;
                f6 = f4;
                h1 = h0;
                e2 = e1;
                a1 = a0;
                v7 = v5;
                f7 = f5;
                f8 = f2;
                v8 = v2;
                goto label_248;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final z e(float f, float f1, i i0, a a0) {
        long v;
        float f2 = (f1 + f) % 1.0f;
        float f3 = i0.a.getLength();
        if(i0.b == null) {
            i0.b = new float[2];
        }
        if(i0.c == null) {
            i0.c = new float[2];
        }
        if(i0.a.getPosTan(f3 * f2, i0.b, i0.c)) {
            float[] arr_f = i0.b;
            kotlin.jvm.internal.q.d(arr_f);
            float f4 = arr_f[0];
            float[] arr_f1 = i0.b;
            kotlin.jvm.internal.q.d(arr_f1);
            v = ((long)Float.floatToRawIntBits(f4)) << 0x20 | ((long)Float.floatToRawIntBits(arr_f1[1])) & 0xFFFFFFFFL;
        }
        else {
            v = 0x7FC000007FC00000L;
        }
        float f5 = ((Number)a0.a.invoke(f2)).floatValue();
        return x0.b.b(v, 0x7FC000007FC00000L) ? z.d : new z(((int)Float.intBitsToFloat(((int)(v >> 0x20)))), ((int)Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))), f5);
    }

    public static final long f(Integer integer0, PlayBgColorData playBgColorData0, List list0) {
        Integer integer1 = integer0 == null || playBgColorData0 == null ? null : ((Integer)je.p.n0(((int)integer0), playBgColorData0.b));
        return integer1 == null ? M.c(((Number)je.p.B0(list0, Ae.f.a)).intValue()) : M.c(((int)integer1));
    }

    public static final List g(long v, float f) {
        float f1 = f > 1.0f ? (f - 1.0f) / 2.0f : 0.0f;
        float f2 = (float)(((int)(v >> 0x20)));
        float f3 = 0.5f * (-1.0f * f);
        float f4 = (float)(((int)(v & 0xFFFFFFFFL)));
        int v1 = (int)((1.0f - f * 0.6f + f1) * f2);
        int v2 = (int)((0.5 - ((double)f) * 0.3) * ((double)(((int)(v & 0xFFFFFFFFL)))));
        return k.A(new z[]{new z(((int)((-1.0f * f * 0.3f + f1) * f2)), ((int)(0.3f * f3 * f4)), 1.0f), new z(v1, ((int)(f3 * 0.4f * f4)), 0.85f), new z(v1, v2, 0.6f), new z(((int)((-1.0f * f * 0.4f + f1) * f2)), v2, 0.7f)});
    }

    public static final Integer h(PlayBgColorData playBgColorData0, Integer integer0) {
        if(playBgColorData0 != null) {
            ArrayList arrayList0 = playBgColorData0.b;
            if(arrayList0.size() != 0) {
                ArrayList arrayList1 = new ArrayList();
                Ce.f f0 = k.r(arrayList0).b();
                while(f0.c) {
                    int v = f0.nextInt();
                    if(integer0 != null && v == ((int)integer0)) {
                    }
                    else if(v < playBgColorData0.a) {
                        for(int v1 = 0; v1 < 2; v1 = com.iloen.melon.utils.a.d(v, v1, 1, arrayList1)) {
                        }
                    }
                    else {
                        arrayList1.add(v);
                    }
                }
                if(!arrayList1.isEmpty()) {
                    return je.p.h0(Ae.f.b.c(arrayList1.size()), arrayList1);
                }
            }
        }
        return null;
    }
}

