package com.iloen.melon.popup;

import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import java.util.List;
import r0.d;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class s implements n {
    public final int a;
    public final List b;
    public final k c;
    public final a d;

    public s(List list0, a a0, k k0, int v) {
        this.a = 3;
        super();
        this.b = list0;
        this.d = a0;
        this.c = k0;
    }

    public s(List list0, k k0, a a0) {
        this.a = 0;
        super();
        this.b = list0;
        this.c = k0;
        this.d = a0;
    }

    public s(List list0, k k0, a a0, int v, int v1) {
        this.a = v1;
        this.b = list0;
        this.c = k0;
        this.d = a0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                int v = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v & 1, (v & 3) != 2)) {
                    y y0 = w.a(j.c, d.m, p0, 0);
                    int v1 = p0.P;
                    i0 i00 = p0.m();
                    r0.n n0 = r0.n.a;
                    q q0 = r0.a.d(p0, n0);
                    P0.k.y.getClass();
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
                    CommonFilterPopupKt.CommonBtmSheetHeader(0x7F13034D, p0, 6);  // string:dj_popup_list_title "DJ 선택"
                    List list0 = this.b;
                    boolean z = p0.i(list0);
                    k k0 = this.c;
                    boolean z1 = p0.g(k0);
                    com.iloen.melon.popup.l l0 = p0.N();
                    if(z || z1 || l0 == androidx.compose.runtime.k.a) {
                        l0 = new com.iloen.melon.popup.l(list0, k0);
                        p0.l0(l0);
                    }
                    ye.a.i(null, null, null, false, null, null, null, false, null, l0, p0, 0, 0x1FF);
                    CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), 1.0f), p0, 6, 0);
                    CommonFilterPopupKt.CommonFilterCloseBtn(this.d, null, p0, 0, 2);
                    p0.p(true);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                d5.n.f(1, ((l)object0), this.b, this.d, this.c);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                d8.d.e(1, ((l)object0), this.b, this.d, this.c);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                df.d.e(7, ((l)object0), this.b, this.d, this.c);
                return H.a;
            }
        }
    }
}

