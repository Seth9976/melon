package com.iloen.melon.popup;

import Cc.H3;
import Cc.N1;
import Cc.e0;
import De.I;
import M.j;
import M.p0;
import P0.h;
import P0.i;
import Q1.c;
import T.e;
import U4.x;
import U8.z;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.request.ImageRequest.Builder;
import d5.n;
import gd.R7;
import ie.H;
import j5.o;
import j5.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;
import y0.M;

@Metadata(d1 = {"\u0000$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u001AG\u0010\b\u001A\u00020\u00042\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00002\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\b\u0010\t\u001A/\u0010\u000B\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00012\u0016\b\u0002\u0010\u0005\u001A\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u000B\u0010\f\u001A\u000F\u0010\r\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u0011²\u0006\u000E\u0010\u0010\u001A\u00020\u000F8\n@\nX\u008A\u008E\u0002"}, d2 = {"", "Lcom/iloen/melon/popup/DjSelectionPopup$DjSelectionPopupData;", "djList", "Lkotlin/Function1;", "Lie/H;", "onClickItem", "Lkotlin/Function0;", "onClickClose", "DjSelectionPopupBase", "(Ljava/util/List;Lwe/k;Lwe/a;Landroidx/compose/runtime/l;II)V", "dj", "DjSelectionPopupListItem", "(Lcom/iloen/melon/popup/DjSelectionPopup$DjSelectionPopupData;Lwe/k;Landroidx/compose/runtime/l;II)V", "DjSelectionPopupPreview", "(Landroidx/compose/runtime/l;I)V", "", "imgSize", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DjSelectionPopupKt {
    public static final void DjSelectionPopupBase(@NotNull List list0, @Nullable k k0, @Nullable a a0, @Nullable l l0, int v, int v1) {
        a a2;
        k k2;
        k k1;
        q.g(list0, "djList");
        ((p)l0).c0(0xA5F67E21);
        int v2 = (v & 6) == 0 ? (((p)l0).i(list0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
            k1 = k0;
        }
        else if((v & 0x30) == 0) {
            k1 = k0;
            v2 |= (((p)l0).i(k1) ? 0x20 : 16);
        }
        else {
            k1 = k0;
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (((p)l0).i(a0) ? 0x100 : 0x80);
        }
        a a1 = null;
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            if((v1 & 2) != 0) {
                k1 = null;
            }
            if((v1 & 4) == 0) {
                a1 = a0;
            }
            long v3 = e0.T(((p)l0), 0x7F0604AB);  // color:white001s
            c.g(n.o(d.t(r0.n.a, 3), e.d(8.0f, 8.0f, 0.0f, 0.0f, 12)), null, v3, 0L, 0.0f, m0.c.e(0xD4D6D65D, ((p)l0), new s(list0, k1, a1)), ((p)l0), 0x180000, 58);
            k2 = k1;
            a2 = a1;
        }
        else {
            ((p)l0).T();
            k2 = k1;
            a2 = a0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new H3(list0, k2, a2, v, v1, 16);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.1 extends r implements k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;
            public final k g;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.3(List list0, k k0) {
                this.f = list0;
                this.g = k0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? (((p)l0).g(a0) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0 = (DjSelectionPopupData)this.f.get(v);
                    ((p)l0).a0(0xF733D7BF);
                    DjSelectionPopupKt.DjSelectionPopupListItem(djSelectionPopup$DjSelectionPopupData0, this.g, ((p)l0), 0, 0);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }

    public static final void DjSelectionPopupListItem(@NotNull DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0, @Nullable k k0, @Nullable l l0, int v, int v1) {
        k k2;
        q.g(djSelectionPopup$DjSelectionPopupData0, "dj");
        p p0 = (p)l0;
        p0.c0(0xDA391D67);
        int v2 = (v & 6) == 0 ? v | (p0.g(djSelectionPopup$DjSelectionPopupData0) ? 4 : 2) : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.i(k0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            k k1 = (v1 & 2) == 0 ? k0 : null;
            r0.n n0 = r0.n.a;
            r0.q q0 = d.f(d.h(n0, 92.0f), 1.0f);
            B b0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((((v2 & 14) == 4 ? 1 : 0) | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || b0 == v3) {
                b0 = new B(3, k1, djSelectionPopup$DjSelectionPopupData0);
                p0.l0(b0);
            }
            r0.q q1 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.q.n(q0, null, b0, 7), 20.0f, 0.0f, 24.0f, 0.0f, 10);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
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
            h h0 = P0.j.f;
            w.x(p0, p00, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q2, P0.j.d);
            r0.q q3 = d.n(n.o(n0, e.a), 65.0f);
            h h3 = P0.j.d;
            r0.q q4 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q3, e.a), e0.T(p0, 0x7F060145), M.a);  // color:gray100a
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            b0 b00 = p0.N();
            if(b00 == v3) {
                b00 = x.d(65, p0);
            }
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
            imageRequest$Builder0.c = "";
            t5.j j0 = imageRequest$Builder0.a();
            C0.c c0 = I.Q(0x7F080799, p0, 6);  // drawable:noimage_man_medium
            C0.c c1 = I.Q(0x7F080799, p0, 6);  // drawable:noimage_man_medium
            N0.i i1 = N0.j.b;
            r0.q q6 = d.n(n0, ((float)((Number)b00.getValue()).intValue()));
            r0.i i2 = r0.d.e;
            r0.q q7 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, i2);
            g g0 = p0.N();
            if(g0 == v3) {
                g0 = new g(b00, 3);
                p0.l0(g0);
            }
            p0.b0(0x64F5E82F);
            i5.e e0 = j5.n.g(v.a, p0);
            p0.b0(0xA7B15BB8);
            o o0 = new o(j0, j5.n.b, e0);
            com.iloen.melon.player.playlist.mixup.composables.c c2 = c0 != null || c1 != null ? new com.iloen.melon.player.playlist.mixup.composables.c(c0, c1, c1, 17) : j5.l.r;
            j5.n.a(o0, null, q7, c2, (g0 == null ? null : new R7(10, null, g0)), i2, i1, null, p0, 0x180030, 0);
            A7.d.s(p0, false, false, true);
            P4.a.b(d.h(d.q(n0, 14.0f), 0.0f), 0L, 0.0f, 0.0f, p0, 6, 14);
            long v6 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b("", new LayoutWeightElement(1.0f, true), v6, 16.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            p0.p(true);
            k2 = k1;
        }
        else {
            p0.T();
            k2 = k0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(djSelectionPopup$DjSelectionPopupData0, k2, v, v1, 7);
        }
    }

    public static final void DjSelectionPopupPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0xEFB7FEDB);
        if(((p)l0).Q(v & 1, v != 0)) {
            List list0 = e.k.A(new DjSelectionPopupData[]{new DjSelectionPopupData("https://picsum.photos/300/300", "hello", "123"), new DjSelectionPopupData("https://picsum.photos/400/400", "hello2", "123123")});
            long v1 = e0.T(((p)l0), 0x7F0604AA);  // color:white000s_support_high_contrast
            c.g(n.o(d.t(r0.n.a, 3), e.d(15.0f, 15.0f, 0.0f, 0.0f, 12)), null, v1, 0L, 0.0f, m0.c.e(0x6A6D791F, ((p)l0), new y(list0, 3)), ((p)l0), 0x180000, 58);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 17, 0);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1 implements k {
            public static final com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1 INSTANCE;

            static {
                com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1.INSTANCE = new com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((DjSelectionPopupData)object0));
                return H.a;
            }

            public final void invoke(DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0) {
                q.g(djSelectionPopup$DjSelectionPopupData0, "it");
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.1 extends r implements k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;

            public com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.3(List list0) {
                this.f = list0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? (((p)l0).g(a0) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0 = (DjSelectionPopupData)this.f.get(v);
                    ((p)l0).a0(857372108);
                    com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1 djSelectionPopupKt$DjSelectionPopupPreview$1$1$1$1$1$1$10 = ((p)l0).N();
                    if(djSelectionPopupKt$DjSelectionPopupPreview$1$1$1$1$1$1$10 == androidx.compose.runtime.k.a) {
                        djSelectionPopupKt$DjSelectionPopupPreview$1$1$1$1$1$1$10 = com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.1.1.1.1.1.1.1.INSTANCE;
                        ((p)l0).l0(djSelectionPopupKt$DjSelectionPopupPreview$1$1$1$1$1$1$10);
                    }
                    DjSelectionPopupKt.DjSelectionPopupListItem(djSelectionPopup$DjSelectionPopupData0, djSelectionPopupKt$DjSelectionPopupPreview$1$1$1$1$1$1$10, ((p)l0), 0x30, 0);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }
}

