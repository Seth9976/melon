package com.iloen.melon.popup;

import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import java.util.List;
import r0.d;
import r0.q;
import we.a;
import we.o;

public final class n implements we.n {
    public final int a;
    public final String b;
    public final List c;
    public final int d;
    public final o e;
    public final boolean f;
    public final int g;
    public final int h;
    public final a i;

    public n(int v, String s, List list0, int v1, o o0, boolean z, int v2, int v3, a a0) {
        this.a = v;
        this.b = s;
        this.c = list0;
        this.d = v1;
        this.e = o0;
        this.f = z;
        this.g = v2;
        this.h = v3;
        this.i = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        r0.n n1;
        int v = (int)(((Integer)object1));
        p p0 = (p)(((l)object0));
        if(p0.Q(v & 1, (v & 3) != 2)) {
            y y0 = w.a(j.c, d.m, p0, 0);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.n n0 = r0.n.a;
            q q0 = r0.a.d(p0, n0);
            k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            CommonFilterPopupKt.CommonBtmSheetHeader(this.a, p0, 0);
            String s = this.b;
            List list0 = this.c;
            int v2 = this.d;
            o o0 = this.e;
            boolean z = this.f;
            int v3 = this.g;
            V v4 = androidx.compose.runtime.k.a;
            switch(s.hashCode()) {
                case 0x880EE8B7: {
                    n1 = n0;
                    if(s.equals("LIST_TYPE_DEPTH_TWO_HORIZONTAL")) {
                        p0.a0(0xBB8E9DAB);
                        boolean z1 = p0.g(o0);
                        com.iloen.melon.popup.q q1 = p0.N();
                        if(z1 || q1 == v4) {
                            q1 = new com.iloen.melon.popup.q(o0, 1);
                            p0.l0(q1);
                        }
                        CommonFilterPopupKt.CommonFilterListTowDepthHorizontal(list0, v2, v3, q1, z, null, p0, 0, 0x20);
                    }
                    else {
                        p0.a0(0xBB01FBC5);
                    }
                    p0.p(false);
                    break;
                }
                case 0x9E1319BD: {
                    n1 = n0;
                    if(s.equals("LIST_TYPE_DEPTH_TWO_ALYAC")) {
                        p0.a0(0xBB858411);
                        boolean z2 = p0.g(o0);
                        com.iloen.melon.popup.q q2 = p0.N();
                        if(z2 || q2 == v4) {
                            q2 = new com.iloen.melon.popup.q(o0, 0);
                            p0.l0(q2);
                        }
                        CommonFilterPopupKt.CommonFilterListTwoDepthAlyac(list0, v2, v3, q2, z, null, p0, 0, 0x20);
                    }
                    else {
                        p0.a0(0xBB01FBC5);
                    }
                    p0.p(false);
                    break;
                }
                case 0xDD0C35: {
                    n1 = n0;
                    if(s.equals("LIST_TYPE_DEPTH_ONE_BASIC")) {
                        p0.a0(-1149403691);
                        boolean z3 = p0.g(o0);
                        com.iloen.melon.popup.p p1 = p0.N();
                        if(z3 || p1 == v4) {
                            p1 = new com.iloen.melon.popup.p(o0, 0);
                            p0.l0(p1);
                        }
                        CommonFilterPopupKt.CommonFilterListBasic(list0, v2, p1, z, n1, p0, 0x6000, 0);
                    }
                    else {
                        p0.a0(0xBB01FBC5);
                    }
                    p0.p(false);
                    break;
                }
                case 970212574: {
                    if(s.equals("LIST_TYPE_DEPTH_THREE")) {
                        p0.a0(0xBB97B7A2);
                        boolean z4 = p0.g(o0);
                        com.iloen.melon.popup.d d0 = p0.N();
                        if(z4 || d0 == v4) {
                            d0 = new com.iloen.melon.popup.d(o0, 1);
                            p0.l0(d0);
                        }
                        n1 = n0;
                        CommonFilterPopupKt.CommonFilterListThreeDepth(list0, v2, v3, this.h, d0, z, null, p0, 0, 0x40);
                    }
                    else {
                        n1 = n0;
                        p0.a0(0xBB01FBC5);
                    }
                    p0.p(false);
                    break;
                }
                default: {
                    n1 = n0;
                    p0.a0(0xBB01FBC5);
                    p0.p(false);
                }
            }
            CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n1, 1.0f), 20.0f, 0.0f, 2), E9.h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            CommonFilterPopupKt.CommonFilterCloseBtn(this.i, null, p0, 0, 2);
            p0.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

