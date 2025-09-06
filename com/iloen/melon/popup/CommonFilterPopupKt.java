package com.iloen.melon.popup;

import Cc.B;
import Cc.N1;
import Cc.P2;
import Cc.e0;
import E9.h;
import M.g;
import M.j0;
import M.p0;
import M.q0;
import N0.M;
import Nc.C1;
import O.F;
import O.I;
import P0.i;
import P0.j;
import P0.k;
import Q1.c;
import T.e;
import U4.x;
import U8.z;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.ResourceUtilsKt;
import d5.n;
import ie.H;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wc.u;
import we.a;
import we.o;
import y0.s;

@Metadata(d1 = {"\u0000D\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\u001A\u0089\u0001\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00002\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\"\b\u0002\u0010\u000F\u001A\u001C\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011\u001A\u0017\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0001\u001A\u00020\u0000H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013\u001AQ\u0010\u0019\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001A\u00020\u00002\u0016\b\u0002\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001A\u001Ac\u0010\u001C\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00002\u001C\b\u0002\u0010\u000F\u001A\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u001B2\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001D\u001Ac\u0010\u001E\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00002\u001C\b\u0002\u0010\u000F\u001A\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u001B2\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001D\u001As\u0010\u001F\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\t\u001A\u00020\u00002\"\b\u0002\u0010\u000F\u001A\u001C\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\u001F\u0010 \u001AG\u0010#\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010!\u001A\u00020\u00002\u0016\b\u0002\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b#\u0010$\u001A]\u0010\'\u001A\u00020\f2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010!\u001A\u00020\u00002\b\b\u0002\u0010%\u001A\u00020\u00002\b\b\u0002\u0010&\u001A\u00020\u00152\u0016\b\u0002\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b\'\u0010(\u001AA\u0010+\u001A\u00020\f2\u0006\u0010)\u001A\u00020\u00022\u0006\u0010*\u001A\u00020\u00152\u0006\u0010&\u001A\u00020\u00152\u000E\u0010\"\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b+\u0010,\u001A+\u0010-\u001A\u00020\f2\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b-\u0010.\u001A\u0019\u0010/\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b/\u00100\u001A\u0019\u00101\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0007\u00A2\u0006\u0004\b1\u00100\u001A\u000F\u00102\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b2\u00103\u001A\u000F\u00104\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b4\u00103\u00A8\u00067\u00B2\u0006\u000E\u00105\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u00105\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u00105\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u00105\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002\u00B2\u0006\u000E\u00106\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002"}, d2 = {"", "titleResId", "", "listType", "", "Lv9/j;", "filterList", "prevOneDepthSelectedIndex", "prevTwoDepthSelectedIndex", "prevThreeDepthSelectedIndex", "orientation", "Lkotlin/Function0;", "Lie/H;", "onClickClose", "Lkotlin/Function3;", "onClickFilter", "BottomSheetDialogScreen", "(ILjava/lang/String;Ljava/util/List;IIIILwe/a;Lwe/o;Landroidx/compose/runtime/l;II)V", "CommonBtmSheetHeader", "(ILandroidx/compose/runtime/l;I)V", "Lkotlin/Function1;", "", "isPortrait", "Lr0/q;", "modifier", "CommonFilterListBasic", "(Ljava/util/List;ILwe/k;ZLr0/q;Landroidx/compose/runtime/l;II)V", "Lkotlin/Function2;", "CommonFilterListTwoDepthAlyac", "(Ljava/util/List;IILwe/n;ZLr0/q;Landroidx/compose/runtime/l;II)V", "CommonFilterListTowDepthHorizontal", "CommonFilterListThreeDepth", "(Ljava/util/List;IIILwe/o;ZLr0/q;Landroidx/compose/runtime/l;II)V", "selectedIndex", "onClickItem", "CommonFilterAlyac", "(Ljava/util/List;ILwe/k;Lr0/q;Landroidx/compose/runtime/l;II)V", "gradientStandardCount", "showCheckImage", "CommonFilterList", "(Ljava/util/List;IIZLwe/k;Lr0/q;Landroidx/compose/runtime/l;II)V", "title", "isSelected", "CommonFilterListItem", "(Ljava/lang/String;ZZLwe/a;Lr0/q;Landroidx/compose/runtime/l;II)V", "CommonFilterCloseBtn", "(Lwe/a;Lr0/q;Landroidx/compose/runtime/l;II)V", "CommonFilterGradient", "(Lr0/q;Landroidx/compose/runtime/l;II)V", "CommonFilterDivider", "CommonFilterBasicPreview", "(Landroidx/compose/runtime/l;I)V", "CommonFilterTwoDepthHorizontalPreview", "currentOneDepthSelectedIndex", "currentTwoDepthSelectedIndex", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class CommonFilterPopupKt {
    public static final void BottomSheetDialogScreen(int v, @NotNull String s, @NotNull List list0, int v1, int v2, int v3, int v4, @Nullable a a0, @Nullable o o0, @Nullable l l0, int v5, int v6) {
        o o2;
        a a2;
        int v14;
        int v11;
        int v10;
        int v9;
        int v8;
        q.g(s, "listType");
        q.g(list0, "filterList");
        ((p)l0).c0(0x82850263);
        int v7 = (v5 & 6) == 0 ? (((p)l0).e(v) ? 4 : 2) | v5 : v5;
        if((v5 & 0x30) == 0) {
            v7 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v5 & 0x180) == 0) {
            v7 |= (((p)l0).i(list0) ? 0x100 : 0x80);
        }
        if((v6 & 8) != 0) {
            v7 |= 0xC00;
        }
        else if((v5 & 0xC00) == 0) {
            v7 |= (((p)l0).e(v1) ? 0x800 : 0x400);
        }
        if((v6 & 16) != 0) {
            v7 |= 0x6000;
            v8 = v2;
        }
        else if((v5 & 0x6000) == 0) {
            v8 = v2;
            v7 |= (((p)l0).e(v8) ? 0x4000 : 0x2000);
        }
        else {
            v8 = v2;
        }
        if((v6 & 0x20) != 0) {
            v7 |= 0x30000;
        }
        else if((0x30000 & v5) == 0) {
            v7 |= (((p)l0).e(v3) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v5) == 0) {
            v7 |= (((p)l0).e(v4) ? 0x100000 : 0x80000);
        }
        if((v6 & 0x80) != 0) {
            v7 |= 0xC00000;
        }
        else if((0xC00000 & v5) == 0) {
            v7 |= (((p)l0).i(a0) ? 0x800000 : 0x400000);
        }
        if((v6 & 0x100) != 0) {
            v9 = v7 | 0x6000000;
            v10 = v6 & 0x100;
        }
        else if((v5 & 0x6000000) == 0) {
            v10 = v6 & 0x100;
            v9 = v7 | (((p)l0).i(o0) ? 0x4000000 : 0x2000000);
        }
        else {
            v10 = v6 & 0x100;
            v9 = v7;
        }
        if(((p)l0).Q(v9 & 1, (v9 & 0x2492493) != 0x2492492)) {
            v11 = (v6 & 8) == 0 ? v1 : 0;
            if((v6 & 16) != 0) {
                v8 = 0;
            }
            int v12 = (v6 & 0x20) == 0 ? v3 : 0;
            a a1 = (v6 & 0x80) == 0 ? a0 : null;
            o o1 = v10 == 0 ? o0 : null;
            long v13 = e0.T(((p)l0), 0x7F0604AB);  // color:white001s
            c.g(n.o(d.t(r0.n.a, 3), e.d(15.0f, 15.0f, 0.0f, 0.0f, 12)), null, v13, 0L, 0.0f, m0.c.e(0xF8E8A2A7, ((p)l0), new com.iloen.melon.popup.n(v, s, list0, v11, o1, v4 == 1, v8, v12, a1)), ((p)l0), 0x180000, 58);
            v14 = v12;
            a2 = a1;
            o2 = o1;
        }
        else {
            ((p)l0).T();
            v11 = v1;
            v14 = v3;
            a2 = a0;
            o2 = o0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.o(v, s, list0, v11, v8, v14, v4, a2, o2, v5, v6);
        }
    }

    public static final void CommonBtmSheetHeader(int v, @Nullable l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0xB9CBA247);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            float f = h.t(p0, 0x7F0700A3);  // dimen:common_filter_header_height
            r0.q q0 = androidx.compose.foundation.layout.a.l(d.h(r0.n.a, f), 20.0f, 0.0f, 2);
            M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, j.d);
            N1.b(H0.e.Y(p0, v), null, e0.T(p0, 0x7F06016D), 18.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray900s
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new m(v, v1);
        }
    }

    public static final void CommonFilterAlyac(@NotNull List list0, int v, @Nullable we.k k0, @Nullable r0.q q0, @Nullable l l0, int v1, int v2) {
        r0.q q3;
        we.k k2;
        q.g(list0, "filterList");
        ((p)l0).c0(80400460);
        int v3 = (v1 & 6) == 0 ? (((p)l0).i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (((p)l0).e(v) ? 0x20 : 16);
        }
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (((p)l0).i(k0) ? 0x100 : 0x80);
        }
        if((v2 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            v3 |= (((p)l0).g(q0) ? 0x800 : 0x400);
        }
        if(((p)l0).Q(v3 & 1, (v3 & 0x493) != 1170)) {
            we.k k1 = (v2 & 4) == 0 ? k0 : null;
            r0.q q1 = (v2 & 8) == 0 ? q0 : r0.n.a;
            g g0 = M.j.h(8.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            r0.q q2 = d.h(q1, h.t(((p)l0), 0x7F0700A0));  // dimen:common_filter_alyac_container_height
            r0.h h0 = r0.d.j;
            boolean z = ((p)l0).i(list0);
            com.iloen.melon.popup.j j0 = ((p)l0).N();
            if(((v3 & 0x70) == 0x20 | z | ((v3 & 0x380) == 0x100 ? 1 : 0)) != 0 || j0 == androidx.compose.runtime.k.a) {
                j0 = new com.iloen.melon.popup.j(list0, v, k1);
                ((p)l0).l0(j0);
            }
            ye.a.j(q2, null, j00, g0, h0, null, false, null, j0, ((p)l0), 0x36180, 458);
            k2 = k1;
            q3 = q1;
        }
        else {
            ((p)l0).T();
            k2 = k0;
            q3 = q0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new C1(list0, v, k2, q3, v1, v2);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.1.1.1.1.1 implements a {
            public final we.k a;
            public final int b;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.1.1.1.1.1(int v, we.k k0) {
                this.a = k0;
                this.b = v;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                we.k k0 = this.a;
                if(k0 != null) {
                    k0.invoke(this.b);
                }
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.1 extends r implements we.k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.1(we.n n0, List list0) {
                this.f = n0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.2 extends r implements we.k {
            public final List f;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.2(List list0) {
                this.f = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.f.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;
            public final int g;
            public final we.k h;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.3(List list0, int v, we.k k0) {
                this.f = list0;
                this.g = v;
                this.h = k0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                p p0 = (p)l0;
                if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    v9.j j0 = (v9.j)this.f.get(v);
                    p0.a0(0x52C55B2A);
                    boolean z = this.g == v;
                    y y0 = androidx.compose.foundation.q.a(e0.T(p0, (z ? 0x7F06017A : 0x7F060152)), 0.5f);  // color:green500e_support_high_contrast
                    T.d d0 = e.b(15.5f);
                    r0.q q0 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(r0.n.a, y0.a, y0.b, d0), e0.T(p0, (z ? 0x7F06017A : 0x7F06048A)), e.b(18.0f)), 15.0f, 0.0f, 2);  // color:green500e_support_high_contrast
                    we.k k0 = this.h;
                    boolean z1 = p0.g(k0);
                    boolean z2 = (v2 & 0x70 ^ 0x30) > 0x20 && p0.e(v) || (v2 & 0x30) == 0x20;
                    com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.1.1.1.1.1 commonFilterPopupKt$CommonFilterAlyac$1$1$1$1$10 = p0.N();
                    if(z2 || z1 || commonFilterPopupKt$CommonFilterAlyac$1$1$1$1$10 == androidx.compose.runtime.k.a) {
                        commonFilterPopupKt$CommonFilterAlyac$1$1$1$1$10 = new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.1.1.1.1.1(v, k0);
                        p0.l0(commonFilterPopupKt$CommonFilterAlyac$1$1$1$1$10);
                    }
                    r0.q q1 = d.h(androidx.compose.foundation.q.n(q0, null, commonFilterPopupKt$CommonFilterAlyac$1$1$1$1$10, 7), 30.0f);
                    M m0 = M.p.d(r0.d.e, false);
                    int v3 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q2 = r0.a.d(p0, q1);
                    k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, m0, j.f);
                    w.x(p0, i00, j.e);
                    P0.h h0 = j.g;
                    if(p0.O || !q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h0);
                    }
                    w.x(p0, q2, j.d);
                    String s = j0.a == null || j0.a.length() == 0 ? j0.b : j0.a;
                    q.d(s);
                    N1.b(s, null, e0.T(p0, (z ? 0x7F0604A1 : 0x7F060163)), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:white000e
                    p0.p(true);
                    p0.p(false);
                    return;
                }
                p0.T();
            }
        }

    }

    public static final void CommonFilterBasicPreview(@Nullable l l0, int v) {
        ((p)l0).c0(680880923);
        if(((p)l0).Q(v & 1, v != 0)) {
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = "해외 팝 음악";
            v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.b = "그외 인기 장르";
            v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j2.b = "국내 인디 음악";
            v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j3.b = "해외 인디 음악";
            v9.j j4 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j4.b = "해외 신곡";
            v9.j j5 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j5.b = "오리진 차트 음악";
            List list0 = e.k.A(new v9.j[]{j0, j1, j2, j3, j4, j5});
            v9.j j6 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j6.b = "내설정순";
            v9.j j7 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j7.b = "많이들은순";
            v9.j j8 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j8.b = "최근담은순";
            v9.j j9 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j9.b = "오래된순";
            v9.j j10 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j10.b = "아티스트순(가나다)";
            v9.j j11 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j11.b = "아티스트순(다나가)";
            v9.j j12 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j12.b = "곡제목순(가나다)";
            v9.j j13 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j13.b = "곡제목순(다나가)";
            v9.j j14 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j14.b = "앨범순(가나다)";
            v9.j j15 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j15.b = "앨범순(다나가)";
            List list1 = e.k.A(new v9.j[]{j6, j7, j8, j9, j10, j11, j12, j13, j14, j15});
            c.g(null, null, e0.T(((p)l0), 0x7F06048A), 0L, 0.0f, m0.c.e(-875207585, ((p)l0), new f(0, list0, list1)), ((p)l0), 0x180000, 59);  // color:transparent
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 15, 0);
        }
    }

    public static final void CommonFilterCloseBtn(@Nullable a a0, @Nullable r0.q q0, @Nullable l l0, int v, int v1) {
        r0.q q1;
        a a1;
        int v2;
        p p0 = (p)l0;
        p0.c0(-607899942);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            a1 = a0;
        }
        else if((v & 6) == 0) {
            a1 = a0;
            v2 = v | (p0.i(a1) ? 4 : 2);
        }
        else {
            a1 = a0;
            v2 = v;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
            q1 = q0;
        }
        else if((v & 0x30) == 0) {
            q1 = q0;
            v2 |= (p0.g(q1) ? 0x20 : 16);
        }
        else {
            q1 = q0;
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            a a2 = (v1 & 1) == 0 ? a1 : null;
            r0.n n0 = r0.n.a;
            r0.q q2 = (v1 & 2) == 0 ? q1 : n0;
            com.iloen.melon.popup.e e0 = p0.N();
            if((v2 & 14) == 4 || e0 == androidx.compose.runtime.k.a) {
                e0 = new com.iloen.melon.popup.e(1, a2);
                p0.l0(e0);
            }
            r0.q q3 = d.h(d.f(androidx.compose.foundation.q.n(q2, null, e0, 7), 1.0f), h.t(p0, 0x7F0700A2));  // dimen:common_filter_footer_height
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q4, j.d);
            String s = H0.e.Y(p0, 0x7F1301D2);  // string:close "닫기"
            long v4 = e0.T(p0, 0x7F060169);  // color:gray850s
            N1.b(s, (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e), v4, 16.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            p0.p(true);
            q1 = q2;
            a1 = a2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.r(a1, q1, v, v1);
        }
    }

    public static final void CommonFilterDivider(@Nullable r0.q q0, @Nullable l l0, int v, int v1) {
        int v2;
        ((p)l0).c0(0xC368F761);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if(((p)l0).Q(v2 & 1, (v2 & 3) != 2)) {
            if((v1 & 1) != 0) {
                q0 = r0.n.a;
            }
            P4.a.b(q0, e0.T(((p)l0), 0x7F060147), 0.0f, 0.0f, ((p)l0), v2 & 14, 12);  // color:gray075a
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new P2(q0, v, v1, 4);
        }
    }

    public static final void CommonFilterGradient(@Nullable r0.q q0, @Nullable l l0, int v, int v1) {
        int v2;
        p p0 = (p)l0;
        p0.c0(1215060858);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            if((v1 & 1) != 0) {
                q0 = r0.n.a;
            }
            r0.q q1 = d.f(d.h(androidx.compose.foundation.q.e(q0, u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F0604AB))}), 0.0f, 0.0f, 14), null, 6), 60.0f), 1.0f);  // color:transparent
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, j.d);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P2(q0, v, v1, 3);
        }
    }

    public static final void CommonFilterList(@NotNull List list0, int v, int v1, boolean z, @Nullable we.k k0, @Nullable r0.q q0, @Nullable l l0, int v2, int v3) {
        int v11;
        we.k k2;
        boolean z6;
        int v10;
        r0.q q1;
        we.k k1;
        int v5;
        q.g(list0, "filterList");
        p p0 = (p)l0;
        p0.c0(0x602562FB);
        int v4 = (v2 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v2 : v2;
        if((v3 & 2) != 0) {
            v4 |= 0x30;
            v5 = v;
        }
        else if((v2 & 0x30) == 0) {
            v5 = v;
            v4 |= (p0.e(v5) ? 0x20 : 16);
        }
        else {
            v5 = v;
        }
        if((v3 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v2 & 0x180) == 0) {
            v4 |= (p0.e(v1) ? 0x100 : 0x80);
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            v4 |= (p0.h(z) ? 0x800 : 0x400);
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
            k1 = k0;
        }
        else if((v2 & 0x6000) == 0) {
            k1 = k0;
            v4 |= (p0.i(k1) ? 0x4000 : 0x2000);
        }
        else {
            k1 = k0;
        }
        if((v3 & 0x20) == 0) {
            q1 = q0;
            if((v2 & 0x30000) == 0) {
                v4 |= (p0.g(q1) ? 0x20000 : 0x10000);
            }
        }
        else {
            v4 |= 0x30000;
            q1 = q0;
        }
        if(p0.Q(v4 & 1, (v4 & 74899) != 74898)) {
            if((v3 & 2) != 0) {
                v5 = 0;
            }
            int v6 = (v3 & 4) == 0 ? v1 : 4;
            boolean z1 = (v3 & 8) == 0 ? z : false;
            if((v3 & 16) != 0) {
                k1 = null;
            }
            r0.n n0 = r0.n.a;
            if((v3 & 0x20) != 0) {
                q1 = n0;
            }
            CoroutineScope coroutineScope0 = p0.N();
            V v7 = androidx.compose.runtime.k.a;
            if(coroutineScope0 == v7) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            M m0 = M.p.d(r0.d.a, false);
            int v8 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h0);
            }
            w.x(p0, q2, j.d);
            F f0 = I.a(0, 0, 3, p0);
            boolean z2 = p0.i(list0);
            com.iloen.melon.fragments.detail.viewholder.e e0 = p0.N();
            if((z2 | (v4 & 0x70) == 0x20 | ((v4 & 0x1C00) == 0x800 ? 1 : 0) | ((0xE000 & v4) == 0x4000 ? 1 : 0)) != 0 || e0 == v7) {
                e0 = new com.iloen.melon.fragments.detail.viewholder.e(list0, v5, z1, k1);
                p0.l0(e0);
            }
            ye.a.i(q1, f0, null, false, null, null, null, false, null, e0, p0, v4 >> 15 & 14, 508);
            if(list0.size() > v6) {
                p0.a0(0xC0F65894);
                if(f0.d()) {
                    p0.a0(0xC0F6CC1A);
                    CommonFilterPopupKt.CommonFilterGradient((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.h), p0, 0, 0);
                }
                else {
                    p0.a0(0xBF9E4081);
                }
                p0.p(false);
                int v9 = v5 < 0 || v5 >= list0.size() ? 0 : v5;
                String s = list0.toString();
                boolean z3 = p0.i(coroutineScope0);
                boolean z4 = p0.g(f0);
                boolean z5 = p0.e(v9);
                com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1 commonFilterPopupKt$CommonFilterList$1$2$10 = p0.N();
                if(((v4 & 0x380) == 0x100 | z3 | z4 | z5) != 0 || commonFilterPopupKt$CommonFilterList$1$2$10 == v7) {
                    v10 = v6;
                    commonFilterPopupKt$CommonFilterList$1$2$10 = new we.n(coroutineScope0, v10, f0, v9, null) {
                        public final F B;
                        public final int D;
                        public final CoroutineScope r;
                        public final int w;

                        {
                            this.r = coroutineScope0;
                            this.w = v;
                            this.B = f0;
                            this.D = v1;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1(this.r, this.w, this.B, this.D, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            n.D(object0);
                            com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1.1 commonFilterPopupKt$CommonFilterList$1$2$1$10 = new we.n(this.w, this.D, null) {
                                public final F B;
                                public final int D;
                                public int r;
                                public final int w;

                                {
                                    this.w = v;
                                    this.B = f0;
                                    this.D = v1;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1.1(this.B, this.w, this.D, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    ne.a a0 = ne.a.a;
                                    switch(this.r) {
                                        case 0: {
                                            n.D(object0);
                                            float f = ResourceUtilsKt.getDimension(0x7F0700A4);  // dimen:common_filter_list_item_height
                                            this.r = 1;
                                            return this.B.j(this.D, -((int)((((float)this.w) * f - f) / 2.0f)), this) == a0 ? a0 : H.a;
                                        }
                                        case 1: {
                                            n.D(object0);
                                            return H.a;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                }
                            };
                            BuildersKt__Builders_commonKt.launch$default(this.r, null, null, commonFilterPopupKt$CommonFilterList$1$2$1$10, 3, null);
                            return H.a;
                        }
                    };
                    p0.l0(commonFilterPopupKt$CommonFilterList$1$2$10);
                }
                else {
                    v10 = v6;
                }
                J.d(p0, s, commonFilterPopupKt$CommonFilterList$1$2$10);
            }
            else {
                v10 = v6;
                p0.a0(0xBF9E4081);
            }
            p0.p(false);
            p0.p(true);
            z6 = z1;
            k2 = k1;
            v11 = v10;
        }
        else {
            p0.T();
            k2 = k1;
            z6 = z;
            v11 = v1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.i(list0, v5, v11, z6, k2, q1, v2, v3);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.1.1.1.1.1 implements a {
            public final we.k a;
            public final int b;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.1.1.1.1.1(int v, we.k k0) {
                this.a = k0;
                this.b = v;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                we.k k0 = this.a;
                if(k0 != null) {
                    k0.invoke(this.b);
                }
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.1 extends r implements we.k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.1(we.n n0, List list0) {
                this.f = n0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.2 extends r implements we.k {
            public final List f;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.2(List list0) {
                this.f = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.f.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;
            public final int g;
            public final boolean h;
            public final we.k i;

            public com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.lambda.70.lambda.68.lambda.67..inlined.itemsIndexed.default.3(List list0, int v, boolean z, we.k k0) {
                this.f = list0;
                this.g = v;
                this.h = z;
                this.i = k0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                boolean z = true;
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    v9.j j0 = (v9.j)this.f.get(v);
                    ((p)l0).a0(-1961215150);
                    String s = j0.a == null || j0.a.length() == 0 ? j0.b : j0.a;
                    q.d(s);
                    boolean z1 = this.g == v;
                    we.k k0 = this.i;
                    boolean z2 = ((p)l0).g(k0);
                    if(((v2 & 0x70 ^ 0x30) <= 0x20 || !((p)l0).e(v)) && (v2 & 0x30) != 0x20) {
                        z = false;
                    }
                    com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.1.1.1.1.1 commonFilterPopupKt$CommonFilterList$1$1$1$1$1$10 = ((p)l0).N();
                    if(z2 || z || commonFilterPopupKt$CommonFilterList$1$1$1$1$1$10 == androidx.compose.runtime.k.a) {
                        commonFilterPopupKt$CommonFilterList$1$1$1$1$1$10 = new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterList.1.1.1.1.1.1(v, k0);
                        ((p)l0).l0(commonFilterPopupKt$CommonFilterList$1$1$1$1$1$10);
                    }
                    CommonFilterPopupKt.CommonFilterListItem(s, z1, this.h, commonFilterPopupKt$CommonFilterList$1$1$1$1$1$10, null, ((p)l0), 0, 16);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }

    public static final void CommonFilterListBasic(@NotNull List list0, int v, @Nullable we.k k0, boolean z, @Nullable r0.q q0, @Nullable l l0, int v1, int v2) {
        boolean z2;
        we.k k2;
        r0.q q1;
        we.k k1;
        q.g(list0, "filterList");
        p p0 = (p)l0;
        p0.c0(1314022472);
        int v3 = 4;
        int v4 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v4 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v2 & 4) != 0) {
            v4 |= 0x180;
            k1 = k0;
        }
        else if((v1 & 0x180) == 0) {
            k1 = k0;
            v4 |= (p0.i(k1) ? 0x100 : 0x80);
        }
        else {
            k1 = k0;
        }
        if((v2 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            v4 |= (p0.h(z) ? 0x800 : 0x400);
        }
        if((v2 & 16) != 0) {
            v4 |= 0x6000;
            q1 = q0;
        }
        else if((v1 & 0x6000) == 0) {
            q1 = q0;
            v4 |= (p0.g(q1) ? 0x4000 : 0x2000);
        }
        else {
            q1 = q0;
        }
        if(p0.Q(v4 & 1, (v4 & 9363) != 9362)) {
            if((v2 & 4) != 0) {
                k1 = null;
            }
            boolean z1 = (v2 & 8) == 0 ? z : true;
            r0.n n0 = r0.n.a;
            if((v2 & 16) != 0) {
                q1 = n0;
            }
            if(z1) {
                v3 = 5;
            }
            int v5 = Math.min(list0.size(), v3);
            b0 b00 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(b00 == v6) {
                b00 = x.d(v, p0);
            }
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v7 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, n0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h0);
            }
            w.x(p0, q2, j.d);
            r0.q q3 = d.h(q1, h.t(p0, 0x7F0700A4) * ((float)v5));  // dimen:common_filter_list_item_height
            int v8 = ((Number)b00.getValue()).intValue();
            com.iloen.melon.popup.l l1 = p0.N();
            if((v4 & 0x380) == 0x100 || l1 == v6) {
                l1 = new com.iloen.melon.popup.l(0, k1, b00);
                p0.l0(l1);
            }
            CommonFilterPopupKt.CommonFilterList(list0, v8, v3, true, l1, q3, p0, v4 & 14 | 0xC00, 0);
            p0.p(true);
            k2 = k1;
            z2 = z1;
        }
        else {
            p0.T();
            k2 = k1;
            z2 = z;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.b(list0, v, k2, z2, q1, v1, v2);
        }
    }

    public static final void CommonFilterListItem(@NotNull String s, boolean z, boolean z1, @Nullable a a0, @Nullable r0.q q0, @Nullable l l0, int v, int v1) {
        r0.q q5;
        q.g(s, "title");
        p p0 = (p)l0;
        p0.c0(0x620F19F0);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.h(z1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.g(q0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            r0.n n0 = r0.n.a;
            r0.q q1 = (v1 & 16) == 0 ? q0 : n0;
            com.iloen.melon.popup.e e0 = p0.N();
            if((v2 & 0x1C00) == 0x800 || e0 == androidx.compose.runtime.k.a) {
                e0 = new com.iloen.melon.popup.e(0, a0);
                p0.l0(e0);
            }
            r0.q q2 = androidx.compose.foundation.layout.a.l(d.h(androidx.compose.foundation.q.n(q1, null, e0, 7), h.t(p0, 0x7F0700A4)), 20.0f, 0.0f, 2);  // dimen:common_filter_list_item_height
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q3, j.d);
            long v4 = e0.T(p0, (z ? 0x7F06017C : 0x7F060169));  // color:green500s_support_high_contrast
            N1.b(s, new LayoutWeightElement(1.0f, true), v4, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v2 & 14 | 0xC00, 0, 0x1FFF0);
            if(!z || !z1) {
                p0.a0(-1006421618);
            }
            else {
                p0.a0(0xC5710471);
                C0.c c0 = De.I.Q(0x7F080128, p0, 6);  // drawable:btn_common_check_19
                String s1 = H0.e.Y(p0, 0x7F130C44);  // string:talkback_selected "선택됨"
                r0.q q4 = d.n(n0, 19.0f);
                y0.k k0 = new y0.k(e0.T(p0, 0x7F06017C), 5);  // color:green500s_support_high_contrast
                androidx.compose.foundation.q.c(c0, s1, q4, r0.d.e, null, 0.0f, k0, p0, 0xD80, 0x30);
            }
            p0.p(false);
            p0.p(true);
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new hd.k(s, z, z1, a0, q5, v, v1);
        }
    }

    public static final void CommonFilterListThreeDepth(@NotNull List list0, int v, int v1, int v2, @Nullable o o0, boolean z, @Nullable r0.q q0, @Nullable l l0, int v3, int v4) {
        int v21;
        r0.q q7;
        boolean z2;
        int v20;
        o o3;
        int v19;
        o o2;
        b0 b04;
        b0 b03;
        int v14;
        b0 b02;
        int v13;
        r0.q q1;
        int v7;
        int v6;
        q.g(list0, "filterList");
        p p0 = (p)l0;
        p0.c0(0x4B0FB69B);
        int v5 = (v3 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v3 : v3;
        if((v4 & 2) != 0) {
            v5 |= 0x30;
            v6 = v;
        }
        else if((v3 & 0x30) == 0) {
            v6 = v;
            v5 |= (p0.e(v6) ? 0x20 : 16);
        }
        else {
            v6 = v;
        }
        if((v4 & 4) != 0) {
            v5 |= 0x180;
            v7 = v1;
        }
        else if((v3 & 0x180) == 0) {
            v7 = v1;
            v5 |= (p0.e(v7) ? 0x100 : 0x80);
        }
        else {
            v7 = v1;
        }
        if((v4 & 8) != 0) {
            v5 |= 0xC00;
        }
        else if((v3 & 0xC00) == 0) {
            v5 |= (p0.e(v2) ? 0x800 : 0x400);
        }
        if((v4 & 16) != 0) {
            v5 |= 0x6000;
        }
        else if((v3 & 0x6000) == 0) {
            v5 |= (p0.i(o0) ? 0x4000 : 0x2000);
        }
        if((v4 & 0x20) != 0) {
            v5 |= 0x30000;
        }
        else if((v3 & 0x30000) == 0) {
            v5 |= (p0.h(z) ? 0x20000 : 0x10000);
        }
        if((v4 & 0x40) == 0) {
            q1 = q0;
            if((v3 & 0x180000) == 0) {
                v5 |= (p0.g(q1) ? 0x100000 : 0x80000);
            }
        }
        else {
            v5 |= 0x180000;
            q1 = q0;
        }
        if(p0.Q(v5 & 1, (v5 & 0x92493) != 0x92492)) {
            if((v4 & 2) != 0) {
                v6 = 0;
            }
            if((v4 & 4) != 0) {
                v7 = 0;
            }
            int v8 = (v4 & 8) == 0 ? v2 : 0;
            o o1 = (v4 & 16) == 0 ? o0 : null;
            boolean z1 = (v4 & 0x20) == 0 ? z : true;
            r0.n n0 = r0.n.a;
            if((v4 & 0x40) != 0) {
                q1 = n0;
            }
            int v9 = 0;
            for(Object object0: list0) {
                v9 = Math.max(((v9.j)object0).e.size(), v9);
                List list1 = ((v9.j)object0).e;
                q.f(list1, "filterDataList");
                for(Object object1: list1) {
                    v9 = Math.max(((v9.j)object1).e.size(), v9);
                }
            }
            float f = ((float)Math.min(v9, (z1 ? 5 : 3))) * h.t(p0, 0x7F0700A4);  // dimen:common_filter_list_item_height
            b0 b00 = p0.N();
            V v10 = androidx.compose.runtime.k.a;
            if(b00 == v10) {
                b00 = x.d(v6, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v10) {
                b01 = x.d(v7, p0);
            }
            M.d d0 = M.j.c;
            r0.g g0 = r0.d.m;
            M.y y0 = M.w.a(d0, g0, p0, 0);
            int v11 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, y0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q2, h3);
            int v12 = ((Number)b00.getValue()).intValue();
            B b0 = p0.N();
            if((((v5 & 0x380) == 0x100 ? 1 : 0) | ((v5 & 0x70) == 0x20 ? 1 : 0)) != 0 || b0 == v10) {
                b0 = new B(v6, v7, b00, b01, 1);
                v14 = v6;
                v13 = v7;
                b03 = b00;
                b02 = b01;
                p0.l0(b0);
            }
            else {
                v13 = v7;
                b02 = b01;
                v14 = v6;
                b03 = b00;
            }
            CommonFilterPopupKt.CommonFilterAlyac(list0, v12, b0, null, p0, v5 & 14, 8);
            M.y y1 = M.w.a(d0, g0, p0, 0);
            int v15 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v15)) {
                A7.d.q(v15, p0, v15, h2);
            }
            w.x(p0, q3, h3);
            CommonFilterPopupKt.CommonFilterDivider(d.h(androidx.compose.foundation.layout.a.l(d.f(n0, 1.0f), 20.0f, 0.0f, 2), h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v16 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v16)) {
                A7.d.q(v16, p0, v16, h2);
            }
            w.x(p0, q4, h3);
            r0.q q5 = q0.a(d.h(n0, f), 1.0f);
            List list2 = ((v9.j)list0.get(((Number)b03.getValue()).intValue())).e;
            q.f(list2, "filterDataList");
            int v17 = ((Number)b02.getValue()).intValue();
            com.iloen.melon.popup.g g1 = p0.N();
            if(g1 == v10) {
                b04 = b02;
                g1 = new com.iloen.melon.popup.g(b04, 1);
                p0.l0(g1);
            }
            else {
                b04 = b02;
            }
            CommonFilterPopupKt.CommonFilterList(list2, v17, (z1 ? 5 : 3), false, g1, q5, p0, 0x6C00, 0);
            CommonFilterPopupKt.CommonFilterDivider(d.q(d.h(n0, f), h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            r0.q q6 = q0.a(d.h(n0, f), 1.0f);
            List list3 = ((v9.j)((v9.j)list0.get(((Number)b03.getValue()).intValue())).e.get(((Number)b04.getValue()).intValue())).e;
            q.f(list3, "filterDataList");
            int v18 = v14 != ((Number)b03.getValue()).intValue() || v13 != ((Number)b04.getValue()).intValue() ? -1 : v8;
            com.iloen.melon.player.playlist.mixup.composables.c c0 = p0.N();
            if((v5 & 0xE000) == 0x4000 || c0 == v10) {
                o2 = o1;
                c0 = new com.iloen.melon.player.playlist.mixup.composables.c(o2, b03, b04, 1);
                p0.l0(c0);
            }
            else {
                o2 = o1;
            }
            CommonFilterPopupKt.CommonFilterList(list3, v18, (z1 ? 5 : 3), true, c0, q6, p0, 0xC00, 0);
            A7.d.s(p0, true, true, true);
            v19 = v13;
            o3 = o2;
            v20 = v8;
            z2 = z1;
            q7 = q1;
            v21 = v14;
        }
        else {
            p0.T();
            q7 = q1;
            v21 = v6;
            v19 = v7;
            v20 = v2;
            z2 = z;
            o3 = o0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.k(list0, v21, v19, v20, o3, z2, q7, v3, v4);
        }
    }

    public static final void CommonFilterListTowDepthHorizontal(@NotNull List list0, int v, int v1, @Nullable we.n n0, boolean z, @Nullable r0.q q0, @Nullable l l0, int v2, int v3) {
        boolean z3;
        int v15;
        r0.q q6;
        int v14;
        we.n n4;
        we.n n3;
        q.g(list0, "filterList");
        p p0 = (p)l0;
        p0.c0(0xBDB97071);
        int v4 = (v2 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v2 : v2;
        if((v3 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v2 & 0x30) == 0) {
            v4 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v3 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v2 & 0x180) == 0) {
            v4 |= (p0.e(v1) ? 0x100 : 0x80);
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            v4 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v2 & 0x6000) == 0) {
            v4 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((v3 & 0x20) != 0) {
            v4 |= 0x30000;
        }
        else if((v2 & 0x30000) == 0) {
            v4 |= (p0.g(q0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v4 & 1, (v4 & 74899) != 74898)) {
            int v5 = (v3 & 2) == 0 ? v : 0;
            int v6 = (v3 & 4) == 0 ? v1 : 0;
            we.n n1 = (v3 & 8) == 0 ? n0 : null;
            boolean z1 = (v3 & 16) == 0 ? z : true;
            r0.n n2 = r0.n.a;
            r0.q q1 = (v3 & 0x20) == 0 ? q0 : n2;
            Iterator iterator0 = list0.iterator();
            if(!iterator0.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = iterator0.next();
            int v7 = ((v9.j)object0).e.size();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                int v8 = ((v9.j)object1).e.size();
                if(v7 < v8) {
                    v7 = v8;
                }
            }
            float f = h.t(p0, 0x7F0700A4) * ((float)Math.min(v7, (z1 ? 5 : 4)));  // dimen:common_filter_list_item_height
            b0 b00 = p0.N();
            V v9 = androidx.compose.runtime.k.a;
            if(b00 == v9) {
                b00 = x.d(v5, p0);
            }
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v10 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, y0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q2, h3);
            CommonFilterPopupKt.CommonFilterDivider(d.h(androidx.compose.foundation.layout.a.l(d.f(n2, 1.0f), 20.0f, 0.0f, 2), h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v11 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, n2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            w.x(p0, q3, h3);
            r0.q q4 = q0.a(d.h(n2, f), 1.0f);
            int v12 = ((Number)b00.getValue()).intValue();
            com.iloen.melon.popup.g g0 = p0.N();
            if(g0 == v9) {
                g0 = new com.iloen.melon.popup.g(b00, 2);
                p0.l0(g0);
            }
            CommonFilterPopupKt.CommonFilterList(list0, v12, (z1 ? 5 : 4), false, g0, q4, p0, v4 & 14 | 0x6C00, 0);
            boolean z2 = false;
            CommonFilterPopupKt.CommonFilterDivider(d.q(d.h(n2, f), h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            r0.q q5 = q0.a(d.h(n2, f), 1.0f);
            List list1 = ((v9.j)list0.get(((Number)b00.getValue()).intValue())).e;
            q.f(list1, "filterDataList");
            int v13 = v5 == ((Number)b00.getValue()).intValue() ? v6 : -1;
            if((v4 & 0x1C00) == 0x800) {
                z2 = true;
            }
            com.iloen.melon.popup.h h4 = p0.N();
            if(z2 || h4 == v9) {
                n3 = n1;
                h4 = new com.iloen.melon.popup.h(n3, b00, 1);
                p0.l0(h4);
            }
            else {
                n3 = n1;
            }
            CommonFilterPopupKt.CommonFilterList(list1, v13, (z1 ? 5 : 4), true, h4, q5, p0, 0xC00, 0);
            p0.p(true);
            p0.p(true);
            n4 = n3;
            v14 = v6;
            q6 = q1;
            v15 = v5;
            z3 = z1;
        }
        else {
            p0.T();
            v14 = v1;
            n4 = n0;
            q6 = q0;
            v15 = v;
            z3 = z;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.i(list0, v15, v14, n4, z3, q6, v2, v3, 1);
        }
    }

    public static final void CommonFilterListTwoDepthAlyac(@NotNull List list0, int v, int v1, @Nullable we.n n0, boolean z, @Nullable r0.q q0, @Nullable l l0, int v2, int v3) {
        int v15;
        boolean z2;
        int v14;
        we.n n3;
        r0.q q3;
        q.g(list0, "filterList");
        p p0 = (p)l0;
        p0.c0(-2001181567);
        int v4 = (v2 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v2 : v2;
        if((v3 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v2 & 0x30) == 0) {
            v4 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v3 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v2 & 0x180) == 0) {
            v4 |= (p0.e(v1) ? 0x100 : 0x80);
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            v4 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v2 & 0x6000) == 0) {
            v4 |= (p0.h(z) ? 0x4000 : 0x2000);
        }
        if((v3 & 0x20) != 0) {
            v4 |= 0x30000;
        }
        else if((0x30000 & v2) == 0) {
            v4 |= (p0.g(q0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v4 & 1, (v4 & 74899) != 74898)) {
            int v5 = (v3 & 2) == 0 ? v : 0;
            int v6 = (v3 & 4) == 0 ? v1 : 0;
            we.n n1 = (v3 & 8) == 0 ? n0 : null;
            boolean z1 = (v3 & 16) == 0 ? z : true;
            r0.n n2 = r0.n.a;
            r0.q q1 = (v3 & 0x20) == 0 ? q0 : n2;
            Iterator iterator0 = list0.iterator();
            if(!iterator0.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = iterator0.next();
            int v7 = ((v9.j)object0).e.size();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                int v8 = ((v9.j)object1).e.size();
                if(v7 < v8) {
                    v7 = v8;
                }
            }
            int v9 = Math.min(v7, (z1 ? 5 : 3));
            b0 b00 = p0.N();
            V v10 = androidx.compose.runtime.k.a;
            if(b00 == v10) {
                b00 = x.d(v5, p0);
            }
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v11 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h0);
            }
            w.x(p0, q2, j.d);
            int v12 = ((Number)b00.getValue()).intValue();
            com.iloen.melon.popup.g g0 = p0.N();
            if(g0 == v10) {
                g0 = new com.iloen.melon.popup.g(b00, 0);
                p0.l0(g0);
            }
            CommonFilterPopupKt.CommonFilterAlyac(list0, v12, g0, null, p0, v4 & 14 | 0x180, 8);
            CommonFilterPopupKt.CommonFilterDivider(d.h(androidx.compose.foundation.layout.a.l(d.f(n2, 1.0f), 20.0f, 0.0f, 2), h.t(p0, 0x7F0700A1)), p0, 0, 0);  // dimen:common_filter_divider_width
            List list1 = ((v9.j)list0.get(((Number)b00.getValue()).intValue())).e;
            q.f(list1, "filterDataList");
            int v13 = v5 == ((Number)b00.getValue()).intValue() ? v6 : -1;
            com.iloen.melon.popup.h h1 = p0.N();
            if((v4 & 0x1C00) == 0x800 || h1 == v10) {
                h1 = new com.iloen.melon.popup.h(n1, b00, 0);
                p0.l0(h1);
            }
            CommonFilterPopupKt.CommonFilterList(list1, v13, (z1 ? 5 : 3), true, h1, d.h(n2, h.t(p0, 0x7F0700A4) * ((float)v9)), p0, 0xC00, 0);  // dimen:common_filter_list_item_height
            p0.p(true);
            q3 = q1;
            n3 = n1;
            v14 = v5;
            z2 = z1;
            v15 = v6;
        }
        else {
            p0.T();
            v14 = v;
            v15 = v1;
            n3 = n0;
            z2 = z;
            q3 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.popup.i(list0, v14, v15, n3, z2, q3, v2, v3, 0);
        }
    }

    public static final void CommonFilterTwoDepthHorizontalPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0x9DFCA48C);
        if(((p)l0).Q(v & 1, v != 0)) {
            v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j0.b = "해외 팝 음악";
            v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j1.b = "그외 인기 장르";
            v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j2.b = "국내 인디 음악";
            v9.j j3 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j3.b = "해외 인디 음악";
            v9.j j4 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j4.b = "해외 신곡";
            v9.j j5 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j5.b = "오리진 차트 음악";
            List list0 = e.k.A(new v9.j[]{j0, j1, j2, j3, j4, j5});
            v9.j j6 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j6.b = "내설정순";
            j6.e = list0;
            v9.j j7 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j7.b = "많이들은순";
            j7.e = list0;
            v9.j j8 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j8.b = "최근담은순";
            j8.e = list0;
            v9.j j9 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j9.b = "오래된순";
            j9.e = list0;
            v9.j j10 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j10.b = "아티스트순(가나다)";
            j10.e = list0;
            v9.j j11 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j11.b = "아티스트순(다나가)";
            j11.e = list0;
            v9.j j12 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j12.b = "곡제목순(가나다)";
            j12.e = list0;
            v9.j j13 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j13.b = "곡제목순(다나가)";
            j13.e = list0;
            v9.j j14 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j14.b = "앨범순(가나다)";
            j14.e = list0;
            v9.j j15 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
            j15.b = "앨범순(다나가)";
            j15.e = list0;
            List list1 = e.k.A(new v9.j[]{j6, j7, j8, j9, j10, j11, j12, j13, j14, j15});
            c.g(null, null, e0.T(((p)l0), 0x7F06048A), 0L, 0.0f, m0.c.e(824367560, ((p)l0), new f(1, list0, list1)), ((p)l0), 0x180000, 59);  // color:transparent
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 16, 0);
        }
    }
}

