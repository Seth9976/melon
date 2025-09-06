package yd;

import Ac.U0;
import Bd.F;
import Cc.G3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.g1;
import M.j;
import M.p0;
import M.q0;
import N0.M;
import P0.i;
import Q0.k0;
import U4.x;
import android.content.res.Configuration;
import androidx.compose.foundation.D0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.custom.l1;
import com.melon.ui.popup.context.more.ExtraProperties.AddPositionInfo;
import com.melon.ui.popup.context.more.ExtraProperties.CheckedItemInfo;
import com.melon.ui.popup.context.more.ExtraProperties.QualityInfo;
import com.melon.ui.popup.context.more.ExtraProperties.ToggleInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import e1.y;
import kd.C;
import kotlin.jvm.internal.q;
import r0.n;
import r1.c;
import r1.f;
import y0.t;
import zd.Q;

public abstract class h {
    public static final void a(String s, boolean z, float f, l l0, int v, int v1) {
        float f4;
        float f3;
        int v4;
        q.g(s, "bodyText");
        p p0 = (p)l0;
        p0.c0(0xB577E2F6);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.d(f) ? 0x100 : 0x80);
        }
        boolean z1 = true;
        if(p0.Q((v2 | 0xC00) & 1, ((v2 | 0xC00) & 0x493) != 1170)) {
            float f1 = (v1 & 4) == 0 ? f : 26.0f;
            Object object0 = p0.k(k0.h);
            b0 b00 = p0.N();
            V v3 = k.a;
            if(b00 == v3) {
                b00 = w.s(new f(0.0f));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            if(((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation == 1) {
                v4 = 339;
            }
            else {
                z1 = false;
                v4 = 0xC7;
            }
            float f2 = !z1 || !((Boolean)b01.getValue()).booleanValue() ? 0.0f : 7.0f;
            b0 b02 = p0.N();
            if(b02 == v3) {
                b02 = w.s(new f(15.0f));
                p0.l0(b02);
            }
            b0 b03 = p0.N();
            if(b03 == v3) {
                f3 = f2;
                b03 = w.s(new r1.l(0L));
                p0.l0(b03);
            }
            else {
                f3 = f2;
            }
            Boolean boolean0 = Boolean.valueOf(z1);
            boolean z2 = p0.g(((c)object0));
            boolean z3 = p0.d(((float)v4));
            d d0 = p0.N();
            if(z2 || z3 || d0 == v3) {
                d d1 = new d(((c)object0), ((float)v4), b03, b00, b01, b02, null);
                p0.l0(d1);
                d0 = d1;
            }
            J.d(p0, boolean0, d0);
            w.a(D0.a.a(null), m0.c.e(1046840886, p0, new a(f3, ((float)v4), b03, z, s, f1, b02, b01)), p0, 56);
            f4 = f1;
        }
        else {
            p0.T();
            f4 = f;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b(s, z, f4, v, v1);
        }
    }

    public static final void b(boolean z, boolean z1, r0.q q0, String s, String s1, boolean z2, we.a a0, we.a a1, we.a a2, l l0, int v, int v1) {
        String s8;
        we.a a7;
        String s7;
        boolean z4;
        we.a a6;
        String s6;
        P0.h h4;
        i i2;
        String s5;
        we.a a5;
        String s4;
        int v3;
        String s2;
        r0.i i0 = r0.d.e;
        q.g(a2, "dismissAction");
        p p0 = (p)l0;
        p0.c0(0x3F993DC);
        int v2 = (v & 6) == 0 ? (p0.h(z) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
            s2 = s;
        }
        else if((v & 0xC00) == 0) {
            s2 = s;
            v2 |= (p0.g(s2) ? 0x800 : 0x400);
        }
        else {
            s2 = s;
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.g(s1) ? 0x4000 : 0x2000);
        }
        if((v1 & 0x20) != 0) {
            v2 |= 0x30000;
        }
        else if((0x30000 & v) == 0) {
            v2 |= (p0.h(z2) ? 0x20000 : 0x10000);
        }
        if((v1 & 0x40) != 0) {
            v2 |= 0x180000;
        }
        else if((v & 0x180000) == 0) {
            v2 |= (p0.i(a0) ? 0x100000 : 0x80000);
        }
        if((v1 & 0x80) != 0) {
            v2 |= 0xC00000;
            v3 = v1 & 0x80;
        }
        else if((v & 0xC00000) == 0) {
            v3 = v1 & 0x80;
            v2 |= (p0.i(a1) ? 0x800000 : 0x400000);
        }
        else {
            v3 = v1 & 0x80;
        }
        if((v & 0x6000000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000000 : 0x2000000);
        }
        we.a a3 = null;
        if(p0.Q(v2 & 1, (v2 & 0x2492493) != 0x2492492)) {
            if((v1 & 8) != 0) {
                s2 = null;
            }
            String s3 = (v1 & 16) == 0 ? s1 : null;
            boolean z3 = (v1 & 0x20) == 0 ? z2 : true;
            we.a a4 = (v1 & 0x40) == 0 ? a0 : null;
            if(v3 == 0) {
                a3 = a1;
            }
            p0 p00 = M.n0.a(j.g, r0.d.k, p0, 54);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O) {
                s4 = s2;
                A7.d.q(v4, p0, v4, h2);
            }
            else {
                s4 = s2;
                if(!q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h2);
                }
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q1, h3);
            n n0 = n.a;
            if(z) {
                p0.a0(0x972955C0);
                r0.q q2 = r0.a.a(q0.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), 1.0f), new g1(a4, a2, 8));
                M m0 = M.p.d(i0, false);
                int v5 = p0.P;
                a5 = a4;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, h0);
                w.x(p0, i01, h1);
                if(p0.O || !q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                w.x(p0, q3, h3);
                if(s4 == null || s4.length() == 0) {
                    s5 = l1.h(p0, 0x427A0F7B, 0x7F130199, p0, false);  // string:cancel "취소"
                }
                else {
                    p0.a0(1115296930);
                    p0.p(false);
                    s5 = s4;
                }
                i2 = i1;
                h4 = h2;
                N1.b(s5, null, e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF2);  // color:gray600s_support_high_contrast
                p0.p(true);
            }
            else {
                a5 = a4;
                i2 = i1;
                h4 = h2;
                p0.a0(0x96B0E70A);
            }
            p0.p(false);
            if(z1) {
                p0.a0(0x9734AE2F);
                r0.q q4 = r0.a.a(q0.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), 1.0f), new Ac.j(z3, a3, a2, 1));
                M m1 = M.p.d(i0, false);
                int v6 = p0.P;
                i0 i02 = p0.m();
                r0.q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i02, h1);
                if(p0.O || !q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h4);
                }
                w.x(p0, q5, h3);
                r0.q q6 = e0.Q(n0, z3);
                if(s3 == null || s3.length() == 0) {
                    s6 = l1.h(p0, 0x8FCFBDE5, 0x7F130227, p0, false);  // string:confirm "확인"
                }
                else {
                    p0.a0(0x8FCFC32C);
                    p0.p(false);
                    s6 = s3;
                }
                N1.b(s6, q6, e0.T(p0, 0x7F06017C), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:green500s_support_high_contrast
                p0.p(true);
            }
            else {
                p0.a0(0x96B0E70A);
            }
            p0.p(false);
            p0.p(true);
            a6 = a3;
            z4 = z3;
            s7 = s4;
            a7 = a5;
            s8 = s3;
        }
        else {
            p0.T();
            a6 = a1;
            s7 = s2;
            s8 = s1;
            z4 = z2;
            a7 = a0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new yd.c(z, z1, q0, s7, s8, z4, a7, a6, a2, v, v1);
        }
    }

    public static final void c(String s, l l0, int v) {
        q.g(s, "titleText");
        ((p)l0).c0(1430953145);
        int v1 = (v & 6) == 0 ? v | (((p)l0).g(s) ? 4 : 2) : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            N1.b(s, null, e0.T(((p)l0), 0x7F06016D), 19.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, ((p)l0), v1 & 14 | 0xC00, 0, 0x1FDF2);  // color:gray900s
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U0(s, v, 6);
        }
    }

    public static final void d(Q q0, MelonBottomSheetItem melonBottomSheetItem0, int v, r0.q q1, we.k k0, l l0, int v1) {
        int v21;
        int v20;
        int v16;
        int v15;
        int v14;
        int v13;
        P0.h h10;
        String s;
        r0.h h9;
        n n1;
        P0.h h8;
        P0.h h7;
        P0.h h6;
        M.b b1;
        int v10;
        t t0;
        P0.h h5;
        boolean z1;
        int v6;
        q.g(q0, "popupType");
        q.g(melonBottomSheetItem0, "item");
        int v2 = melonBottomSheetItem0.b;
        ExtraProperties extraProperties0 = melonBottomSheetItem0.f;
        zd.M m0 = melonBottomSheetItem0.a;
        boolean z = melonBottomSheetItem0.e;
        q.g(k0, "onUserEvent");
        p p0 = (p)l0;
        p0.c0(0xE052FF57);
        int v3 = (v1 & 6) == 0 ? (p0.i(q0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.g(melonBottomSheetItem0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.g(q1) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.i(k0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            r0.h h0 = r0.d.k;
            M.b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v4 = p0.P;
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
            P0.h h1 = P0.j.f;
            w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q2, h4);
            int v5 = 0x7F06017C;  // color:green500s_support_high_contrast
            if(!(extraProperties0 instanceof CheckedItemInfo) || !((CheckedItemInfo)extraProperties0).c) {
                z1 = extraProperties0 instanceof CheckedItemInfo;
                v6 = 0x390A5FF3;
                v5 = 0x7F060169;  // color:gray850s
            }
            else {
                v6 = 0x390909DC;
                z1 = extraProperties0 instanceof CheckedItemInfo;
            }
            long v7 = A7.d.f(p0, v6, v5, p0, false);
            int[] arr_v = g.a;
            y y0 = arr_v[m0.ordinal()] == 1 ? y.i : null;
            n n0 = n.a;
            r0.q q3 = x.r(1.0f, e0.Q(n0, z), true);
            p0 p01 = M.n0.a(b0, h0, p0, 0x30);
            int v8 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h3);
            }
            w.x(p0, q4, h4);
            if(melonBottomSheetItem0.c == null) {
                h8 = h4;
                h6 = h1;
                b1 = b0;
                h7 = h2;
                n1 = n0;
                v10 = v3;
                h9 = h0;
                p0.a0(0x34140233);
                p0.p(false);
            }
            else {
                p0.a0(884358306);
                int v9 = m0 == zd.M.g0 || m0 == zd.M.k0 || m0 == zd.M.l0 || m0 == zd.M.m0 || m0 == zd.M.p0 || m0 == zd.M.w0 || m0 == zd.M.j0 || m0 == zd.M.n0 || m0 == zd.M.o0 ? 20 : 22;
                if(m0 != zd.M.g0 && m0 != zd.M.k0 && m0 != zd.M.l0 && m0 != zd.M.m0 && m0 != zd.M.p0 && m0 != zd.M.w0 && m0 != zd.M.j0 && m0 != zd.M.n0 && m0 != zd.M.o0 && m0 != zd.M.h1 && m0 != zd.M.v0 && m0 != zd.M.u0 && m0 != zd.M.s0 && m0 != zd.M.r0 && m0 != zd.M.q0 && m0 != zd.M.t0) {
                    p0.a0(886343701);
                    h5 = h2;
                    y0.k k1 = new y0.k(e0.T(p0, 0x7F060165), 5);  // color:gray800s
                    p0.p(false);
                    t0 = k1;
                }
                else {
                    h5 = h2;
                    p0.a0(0x34D3C047);
                    p0.p(false);
                    t0 = null;
                }
                v10 = v3;
                b1 = b0;
                h6 = h1;
                h7 = h5;
                h8 = h4;
                n1 = n0;
                h9 = h0;
                c1.n(androidx.compose.foundation.layout.d.n(n0, ((float)v9)), melonBottomSheetItem0.c, null, null, false, 0, null, null, null, 0.0f, t0, 0, 0, false, false, p0, 0, 0, 0x7BFC);
                x.z(n1, 10.0f, p0, false);
            }
            if(v2 > 0) {
                s = l1.h(p0, 0x34DACD4D, v2, p0, false);
            }
            else {
                p0.a0(0x34DBF2D5);
                p0.p(false);
                s = melonBottomSheetItem0.d;
                if(s == null) {
                    s = "";
                }
            }
            N1.b(s, null, v7, 16.0f, y0, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFD2);
            p0.p(true);
            if(arr_v[m0.ordinal()] == 2) {
                p0.a0(0x393DF042);
                r0.q q5 = r0.a.a(e0.Q(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), z), new C(melonBottomSheetItem0, k0, 3));
                p0 p02 = M.n0.a(j.b, h9, p0, 54);
                int v11 = p0.P;
                i0 i02 = p0.m();
                r0.q q6 = r0.a.d(p0, q5);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p02, h6);
                w.x(p0, i02, h7);
                if(p0.O || !q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h3);
                }
                h10 = h8;
                w.x(p0, q6, h10);
                c1.n(null, 0x7F0804EF, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F060165), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFD);  // drawable:ic_more_setting_22
                p0.p(true);
            }
            else {
                h10 = h8;
                p0.a0(0x394B21ED);
            }
            p0.p(false);
            if(extraProperties0 instanceof AddPositionInfo) {
                p0.a0(961388009);
                r0.q q7 = r0.a.a(e0.Q(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), 86.0f), z), new hd.y(melonBottomSheetItem0, k0, q0, ((AddPositionInfo)extraProperties0)));
                p0 p03 = M.n0.a(j.b, h9, p0, 54);
                int v12 = p0.P;
                i0 i03 = p0.m();
                r0.q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p03, h6);
                w.x(p0, i03, h7);
                if(p0.O || !q.b(p0.N(), v12)) {
                    A7.d.q(v12, p0, v12, h3);
                }
                w.x(p0, q8, h10);
                AddPosition addPosition0 = ((AddPositionInfo)extraProperties0).a;
                switch((addPosition0 == null ? -1 : g.b[addPosition0.ordinal()])) {
                    case -1: 
                    case 1: {
                        v13 = -980090183;
                        v14 = 0x7F13092B;  // string:setting_addposition_first "맨 처음"
                        break;
                    }
                    case 2: {
                        v13 = 0x58F45D2F;
                        v14 = 0x7F13092A;  // string:setting_addposition_end "맨 끝"
                        break;
                    }
                    case 3: {
                        v13 = 0x58F469F1;
                        v14 = 0x7F130929;  // string:setting_addposition_after "재생 곡 뒤"
                        break;
                    }
                    default: {
                        throw l1.c(p0, 0x58F4409D, false);
                    }
                }
                String s1 = l1.h(p0, v13, v14, p0, false);
                if(z) {
                    v15 = 0x58F48743;
                    v16 = 0x7F060163;  // color:gray700s
                }
                else {
                    v15 = 0x58F48CCF;
                    v16 = 0x7F060160;  // color:gray600s_support_high_contrast
                }
                N1.b(s1, null, A7.d.f(p0, v15, v16, p0, false), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
                c1.n(null, 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, new y0.k(A7.d.g(n1, 4.0f, p0, 0x7F060159, p0), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFD);  // drawable:arrow_common_menu
                p0.p(true);
            }
            else if(extraProperties0 instanceof ToggleInfo) {
                p0.a0(0x396D1AC2);
                r0.q q9 = e0.Q(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), 56.0f), z);
                p0 p04 = M.n0.a(j.b, h9, p0, 54);
                int v17 = p0.P;
                i0 i04 = p0.m();
                r0.q q10 = r0.a.d(p0, q9);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p04, h6);
                w.x(p0, i04, h7);
                if(p0.O || !q.b(p0.N(), v17)) {
                    A7.d.q(v17, p0, v17, h3);
                }
                w.x(p0, q10, h10);
                b0 b00 = p0.N();
                V v18 = k.a;
                if(b00 == v18) {
                    b00 = w.s(Boolean.valueOf(((ToggleInfo)extraProperties0).a));
                    p0.l0(b00);
                }
                boolean z2 = ((Boolean)b00.getValue()).booleanValue();
                boolean z3 = p0.i(q0);
                F f0 = p0.N();
                if((((v10 & 0xE000) == 0x4000 ? 1 : 0) | ((v10 & 0x70) == 0x20 ? 1 : 0) | z3) != 0 || f0 == v18) {
                    F f1 = new F(melonBottomSheetItem0, k0, q0, b00, 25);
                    p0.l0(f1);
                    f0 = f1;
                }
                c1.u(z2, f0, false, 0L, 0L, e0.T(p0, 0x7F06017C), e0.T(p0, 0x7F060159), 0L, p0, 0);  // color:green500s_support_high_contrast
                p0.p(true);
            }
            else if(extraProperties0 instanceof QualityInfo) {
                p0.a0(964882081);
                r0.q q11 = r0.a.a(e0.Q(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14), 86.0f), z), new yd.f(melonBottomSheetItem0, k0, v, q0, 0));
                p0 p05 = M.n0.a(j.b, h9, p0, 54);
                int v19 = p0.P;
                i0 i05 = p0.m();
                r0.q q12 = r0.a.d(p0, q11);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p05, h6);
                w.x(p0, i05, h7);
                if(p0.O || !q.b(p0.N(), v19)) {
                    A7.d.q(v19, p0, v19, h3);
                }
                w.x(p0, q12, h10);
                String s2 = ((QualityInfo)extraProperties0).a;
                if(z) {
                    v20 = 801970715;
                    v21 = 0x7F060163;  // color:gray700s
                }
                else {
                    v20 = 0x2FCD1FA7;
                    v21 = 0x7F060160;  // color:gray600s_support_high_contrast
                }
                N1.b(s2, null, A7.d.f(p0, v20, v21, p0, false), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
                c1.n(null, 0x7F08008D, null, null, false, 0, null, null, null, 0.0f, new y0.k(A7.d.g(n1, 4.0f, p0, 0x7F060159, p0), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFD);  // drawable:arrow_common_menu
                p0.p(true);
            }
            else if(z1) {
                p0.a0(0x399AAD89);
                if(((CheckedItemInfo)extraProperties0).c) {
                    p0.a0(0x399B768D);
                    r0.q q13 = androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 0.0f, 14);
                    p0 p06 = M.n0.a(b1, r0.d.j, p0, 0);
                    int v22 = p0.P;
                    i0 i06 = p0.m();
                    r0.q q14 = r0.a.d(p0, q13);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, p06, h6);
                    w.x(p0, i06, h7);
                    if(p0.O || !q.b(p0.N(), v22)) {
                        A7.d.q(v22, p0, v22, h3);
                    }
                    w.x(p0, q14, h10);
                    c1.n(null, 0x7F0804D3, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F06017C), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFD);  // drawable:ic_more_check_22
                    p0.p(true);
                }
                else {
                    p0.a0(0x38715FEF);
                }
                p0.p(false);
            }
            else {
                p0.a0(0x39A2251F);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(q0, melonBottomSheetItem0, v, q1, k0, v1);
        }
    }
}

