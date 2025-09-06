package com.iloen.melon.popup;

import Cc.e0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import T.e;
import android.content.Context;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes.Response.Banner;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import java.util.List;
import r0.a;
import r0.d;
import r0.q;
import we.n;
import y0.M;

public final class f implements n {
    public final int a;
    public final Object b;
    public final Object c;

    public f(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        long v4;
        r0.n n0 = r0.n.a;
        H h0 = H.a;
        V v0 = k.a;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                int v5 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v5 & 1, (v5 & 3) != 2)) {
                    q q0 = androidx.compose.foundation.q.f(n0, e0.T(((p)(((l)object0))), 0x7F0604AB), e.d(5.0f, 5.0f, 0.0f, 0.0f, 12));  // color:white001s
                    y y0 = w.a(j.c, d.m, ((p)(((l)object0))), 0);
                    int v6 = ((p)(((l)object0))).P;
                    i0 i00 = ((p)(((l)object0))).m();
                    q q1 = a.d(((p)(((l)object0))), q0);
                    P0.k.y.getClass();
                    i i0 = P0.j.b;
                    ((p)(((l)object0))).e0();
                    if(((p)(((l)object0))).O) {
                        ((p)(((l)object0))).l(i0);
                    }
                    else {
                        ((p)(((l)object0))).o0();
                    }
                    androidx.compose.runtime.w.x(((p)(((l)object0))), y0, P0.j.f);
                    androidx.compose.runtime.w.x(((p)(((l)object0))), i00, P0.j.e);
                    h h1 = P0.j.g;
                    if(((p)(((l)object0))).O || !kotlin.jvm.internal.q.b(((p)(((l)object0))).N(), v6)) {
                        A7.d.q(v6, ((p)(((l)object0))), v6, h1);
                    }
                    androidx.compose.runtime.w.x(((p)(((l)object0))), q1, P0.j.d);
                    CommonFilterPopupKt.CommonBtmSheetHeader(0x7F1307D1, ((p)(((l)object0))), 6);  // string:order_by "정렬"
                    CommonFilterPopupKt.CommonFilterAlyac(((List)object3), 0, null, null, ((p)(((l)object0))), 0x30, 12);
                    CommonFilterPopupKt.CommonFilterListBasic(((List)object2), 0, null, false, new LayoutWeightElement(1.0f, true), ((p)(((l)object0))), 0x30, 12);
                    CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), E9.h.t(((p)(((l)object0))), 0x7F0700A1)), ((p)(((l)object0))), 0, 0);  // dimen:common_filter_divider_width
                    p8.e e0 = ((p)(((l)object0))).N();
                    if(e0 == v0) {
                        e0 = new p8.e(24);
                        ((p)(((l)object0))).l0(e0);
                    }
                    CommonFilterPopupKt.CommonFilterCloseBtn(e0, null, ((p)(((l)object0))), 6, 2);
                    ((p)(((l)object0))).p(true);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 1: {
                int v7 = (int)(((Integer)object1));
                p p1 = (p)(((l)object0));
                if(p1.Q(v7 & 1, (v7 & 3) != 2)) {
                    q q2 = androidx.compose.foundation.q.f(n0, e0.T(p1, 0x7F0604AB), e.d(5.0f, 5.0f, 0.0f, 0.0f, 12));  // color:white001s
                    y y1 = w.a(j.c, d.m, p1, 0);
                    int v8 = p1.P;
                    i0 i01 = p1.m();
                    q q3 = a.d(p1, q2);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p1.e0();
                    if(p1.O) {
                        p1.l(i1);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y1, P0.j.f);
                    androidx.compose.runtime.w.x(p1, i01, P0.j.e);
                    h h2 = P0.j.g;
                    if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v8)) {
                        A7.d.q(v8, p1, v8, h2);
                    }
                    androidx.compose.runtime.w.x(p1, q3, P0.j.d);
                    CommonFilterPopupKt.CommonBtmSheetHeader(0x7F1307D1, p1, 6);  // string:order_by "정렬"
                    CommonFilterPopupKt.CommonFilterAlyac(((List)object3), 0, null, null, p1, 0x30, 12);
                    CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), E9.h.t(p1, 0x7F0700A1)), p1, 0, 0);  // dimen:common_filter_divider_width
                    CommonFilterPopupKt.CommonFilterListTowDepthHorizontal(((List)object2), 0, 0, null, false, new LayoutWeightElement(1.0f, true), p1, 0, 30);
                    CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), E9.h.t(p1, 0x7F0700A1)), p1, 0, 0);  // dimen:common_filter_divider_width
                    p8.e e1 = p1.N();
                    if(e1 == v0) {
                        e1 = new p8.e(24);
                        p1.l0(e1);
                    }
                    CommonFilterPopupKt.CommonFilterCloseBtn(e1, null, p1, 6, 2);
                    p1.p(true);
                    return h0;
                }
                p1.T();
                return h0;
            }
            default: {
                int v1 = (int)(((Integer)object1));
                p p0 = (p)(((l)object0));
                if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
                    Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
                    String s = ((Banner)object2).imgurl;
                    String s1 = ((Banner)object2).buttonText;
                    String s2 = ((Banner)object2).buttonTextColor;
                    String s3 = "";
                    if(s2 == null) {
                        s2 = "";
                    }
                    long v2 = M.c(ColorUtils.getColorFromHexStr(context0, s2, 0x7F0604A1));  // color:white000e
                    String s4 = ((Banner)object2).buttonBgColor;
                    if(s4 != null) {
                        s3 = s4;
                    }
                    long v3 = M.c(ColorUtils.getColorFromHexStr(context0, s3, 0x7F06017A));  // color:green500e_support_high_contrast
                    String s5 = ((Banner)object2).dpTitle;
                    String s6 = ((Banner)object2).dismissColor;
                    if(s6 == null || s6.length() == 0) {
                        v4 = A7.d.f(p0, 0x6530D0F1, 0x7F0604A1, p0, false);  // color:white000e
                    }
                    else {
                        p0.a0(0x65319F49);
                        p0.p(false);
                        v4 = M.c(ColorUtils.getColorFromHexStr(((Banner)object2).dismissColor));
                    }
                    boolean z = p0.i(((MainBottomPopup)object3));
                    boolean z1 = p0.i(((Banner)object2));
                    B b0 = p0.N();
                    if(z || z1 || b0 == v0) {
                        b0 = new B(0, ((MainBottomPopup)object3), ((Banner)object2));
                        p0.l0(b0);
                    }
                    boolean z2 = p0.i(((MainBottomPopup)object3));
                    boolean z3 = p0.i(((Banner)object2));
                    B b1 = p0.N();
                    if(z2 || z3 || b1 == v0) {
                        b1 = new B(1, ((MainBottomPopup)object3), ((Banner)object2));
                        p0.l0(b1);
                    }
                    boolean z4 = p0.i(((MainBottomPopup)object3));
                    boolean z5 = p0.i(((Banner)object2));
                    B b2 = p0.N();
                    if(z4 || z5 || b2 == v0) {
                        b2 = new B(2, ((MainBottomPopup)object3), ((Banner)object2));
                        p0.l0(b2);
                    }
                    ((MainBottomPopup)object3).BottomSheetDialogScreen-_ZOWojw(s, s1, v2, v3, s5, v4, b0, b1, b2, p0, 0, 0);
                    return h0;
                }
                p0.T();
                return h0;
            }
        }
    }
}

