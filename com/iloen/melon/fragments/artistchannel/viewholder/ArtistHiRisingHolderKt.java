package com.iloen.melon.fragments.artistchannel.viewholder;

import Cc.H3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import K.m;
import M.c;
import M.g;
import M.j0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import Q0.k0;
import T.e;
import U8.z;
import X0.u;
import X0.x;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.request.ImageRequest.Builder;
import com.iloen.melon.custom.B1;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIRISINGLIST;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import m0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.a;
import we.n;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A7\u0010\u0007\u001A\u00020\u00052\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00002\u0018\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001AA\u0010\r\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u000B2\u0018\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000E\u001A\u000F\u0010\u000F\u001A\u00020\u0005H\u0001¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIRISINGLIST;", "list", "Lkotlin/Function2;", "", "Lie/H;", "onClickItem", "ArtistHiRisingSlot", "(Ljava/util/List;Lwe/n;Landroidx/compose/runtime/l;I)V", "index", "item", "Lr0/q;", "modifier", "HiRisingItem", "(ILcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIRISINGLIST;Lr0/q;Lwe/n;Landroidx/compose/runtime/l;I)V", "ArtistHiRisingSlotPreView", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistHiRisingHolderKt {
    public static final void ArtistHiRisingSlot(@NotNull List list0, @NotNull n n0, @Nullable l l0, int v) {
        q.g(list0, "list");
        q.g(n0, "onClickItem");
        p p0 = (p)l0;
        p0.c0(0xC7FA854F);
        int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(n0) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.n n1 = r0.n.a;
            r0.q q0 = d.t(d.f(n1, 1.0f), 3);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            c.d(p0, d.h(n1, E9.h.t(p0, 0x7F070053)));  // dimen:artist_detail_viewholder_spacing
            C0.c c0 = I.Q(0x7F080648, p0, 6);  // drawable:img_logo_hirising
            r0.q q2 = androidx.compose.foundation.layout.a.n(n1, E9.h.t(p0, 0x7F07044C), 0.0f, 0.0f, 0.0f, 14);  // dimen:tab_common_title_padding
            f f0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(f0 == v3) {
                f0 = new f(1);
                p0.l0(f0);
            }
            androidx.compose.foundation.q.c(c0, null, X0.n.c(q2, false, f0), null, null, 0.0f, null, p0, 0x30, 120);
            if(list0.size() == 1) {
                p0.a0(1496023876);
                ArtistHiRisingHolderKt.HiRisingItem(0, ((HIRISINGLIST)list0.get(0)), androidx.compose.foundation.layout.a.l(d.t(d.f(n1, 1.0f), 3), 20.0f, 0.0f, 2), n0, p0, v1 << 6 & 0x1C00 | 390);
            }
            else {
                p0.a0(0x59302A58);
                r0.q q3 = d.t(d.f(n1, 1.0f), 3);
                g g0 = j.h(11.0f);
                j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
                boolean z = p0.i(list0);
                com.iloen.melon.fragments.artistchannel.viewholder.i i1 = p0.N();
                if(z || (v1 & 0x70) == 0x20 || i1 == v3) {
                    i1 = new com.iloen.melon.fragments.artistchannel.viewholder.i(list0, n0, 0);
                    p0.l0(i1);
                }
                c1.q(q3, null, j00, g0, null, null, false, i1, p0, 0x6186, 0xEA);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.artistchannel.viewholder.j(list0, n0, v, 0);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final n $key;

            public com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.1(n n0, List list0) {
                this.$key = n0;
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.$items.get(v);
                return this.$key.invoke(v, object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.2 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.2(List list0) {
                this.$items = list0;
                super(1);
            }

            public final Object invoke(int v) {
                this.$items.get(v);
                return null;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.3 extends r implements we.p {
            final List $items;
            final n $onClickItem$inlined;

            public com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.3(List list0, n n0) {
                this.$items = list0;
                this.$onClickItem$inlined = n0;
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
                    Object object0 = this.$items.get(v);
                    ((p)l0).a0(0xA2EDAC44);
                    ArtistHiRisingHolderKt.HiRisingItem(v, ((HIRISINGLIST)object0), d.t(d.q(r0.n.a, 320.0f), 3), this.$onClickItem$inlined, ((p)l0), (v2 & 0x7E) >> 3 & 14 | 0x180);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }

    }

    private static final H ArtistHiRisingSlot$lambda$5$lambda$1$lambda$0(x x0) {
        q.g(x0, "$this$semantics");
        u.h(x0, "");
        u.e(x0);
        return H.a;
    }

    private static final H ArtistHiRisingSlot$lambda$5$lambda$4$lambda$3(List list0, n n0, O.w w0) {
        q.g(w0, "$this$MelonLazyRow");
        ((O.j)w0).u(list0.size(), null, new com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.2(list0), new b(0xBEF78951, new com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.ArtistHiRisingSlot.lambda.5.lambda.4.lambda.3..inlined.itemsIndexed.default.3(list0, n0), true));
        return H.a;
    }

    private static final H ArtistHiRisingSlot$lambda$6(List list0, n n0, int v, l l0, int v1) {
        ArtistHiRisingHolderKt.ArtistHiRisingSlot(list0, n0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static final void ArtistHiRisingSlotPreView(@Nullable l l0, int v) {
        ((p)l0).c0(0x7C6BD3EF);
        if(((p)l0).Q(v & 1, v != 0)) {
            HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0 = new HIRISINGLIST();
            artistHomeContentsRes$RESPONSE$HIRISINGLIST0.title = "#1. Melon Hi-RiSING의 첫 번째 주인공! ITZY";
            artistHomeContentsRes$RESPONSE$HIRISINGLIST0.regDate = "2023.06.28";
            artistHomeContentsRes$RESPONSE$HIRISINGLIST0.imageBgColor = "#FF0000";
            Q1.c.g(null, null, e0.T(((p)l0), 0x7F06048A), 0L, 0.0f, m0.c.e(0x9F3F132B, ((p)l0), new com.iloen.melon.fragments.artistchannel.viewholder.h(artistHomeContentsRes$RESPONSE$HIRISINGLIST0, 1)), ((p)l0), 0x180000, 59);  // color:transparent
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 2, 0);
        }
    }

    private static final H ArtistHiRisingSlotPreView$lambda$14(HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            List list0 = e.k.z(artistHomeContentsRes$RESPONSE$HIRISINGLIST0);
            B1 b10 = ((p)l0).N();
            if(b10 == androidx.compose.runtime.k.a) {
                b10 = new B1(1);
                ((p)l0).l0(b10);
            }
            ArtistHiRisingHolderKt.ArtistHiRisingSlot(list0, b10, ((p)l0), 0x30);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H ArtistHiRisingSlotPreView$lambda$14$lambda$13$lambda$12(HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, int v) {
        q.g(artistHomeContentsRes$RESPONSE$HIRISINGLIST0, "<unused var>");
        return H.a;
    }

    private static final H ArtistHiRisingSlotPreView$lambda$15(int v, l l0, int v1) {
        ArtistHiRisingHolderKt.ArtistHiRisingSlotPreView(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static final void HiRisingItem(int v, @NotNull HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, @NotNull r0.q q0, @NotNull n n0, @Nullable l l0, int v1) {
        r0.n n2;
        q.g(artistHomeContentsRes$RESPONSE$HIRISINGLIST0, "item");
        q.g(q0, "modifier");
        q.g(n0, "onClickItem");
        p p0 = (p)l0;
        p0.c0(598860826);
        int v2 = (v1 & 6) == 0 ? (p0.e(v) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.i(artistHomeContentsRes$RESPONSE$HIRISINGLIST0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(n0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            r0.q q1 = a.a(q0, new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.fragments.artistchannel.viewholder.ArtistHiRisingHolderKt.HiRisingItem..inlined.noRippleClickable-YQRRFTQ.default.1.1 artistHiRisingHolderKt$HiRisingItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$onClickItem$inlined);
                            this.$item$inlined.invoke(this.$index$inlined, this.$index$inlined);
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, artistHiRisingHolderKt$HiRisingItem$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = a.d(p0, q1);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            r0.n n1 = r0.n.a;
            r0.q q3 = e0.K(d5.n.o(d.h(d.f(n1, 1.0f), 180.0f), e.b(4.0f)));
            androidx.compose.runtime.c1 c10 = AndroidCompositionLocals_androidKt.b;
            long v4 = M.c(ColorUtils.getColorFromHexStr(((Context)p0.k(c10)), artistHomeContentsRes$RESPONSE$HIRISINGLIST0.imageBgColor, 0x7F060145));  // color:gray050s
            wc.u u0 = M.a;
            r0.q q4 = androidx.compose.foundation.q.f(q3, v4, u0);
            r0.i i1 = r0.d.a;
            N0.M m0 = M.p.d(i1, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            C0.c c0 = I.Q(0x7F080788, p0, 6);  // drawable:noimage_logo_medium
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            androidx.compose.foundation.q.c(c0, null, b0.a(n1, r0.d.e), null, null, 0.0f, null, p0, 0x30, 120);
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(c10)));
            imageRequest$Builder0.c = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.imageUrl;
            j5.n.b(imageRequest$Builder0.a(), null, b0.a(d.c(d.v(n1, null, 3), 1.0f), r0.d.e), null, N0.j.d, null, p0, 0x180030, 0xFB8);
            if(artistHomeContentsRes$RESPONSE$HIRISINGLIST0.logoImageUrl == null || !Tf.o.H0(artistHomeContentsRes$RESPONSE$HIRISINGLIST0.logoImageUrl) != 1) {
                n2 = n1;
                p0.a0(-1095250196);
            }
            else {
                p0.a0(0xBF299084);
                List list0 = e.k.A(new s[]{new s(s.f), new s(e0.T(p0, 0x7F06015B))});  // color:gray500e
                c.d(p0, b0.a(androidx.compose.foundation.q.e(d.h(d.f(n1, 1.0f), 90.0f), wc.u.f(list0, 0.0f, 0.0f, 14), u0, 4), r0.d.g));
                ImageRequest.Builder imageRequest$Builder1 = new ImageRequest.Builder(((Context)p0.k(c10)));
                imageRequest$Builder1.c = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.logoImageUrl;
                n2 = n1;
                j5.n.b(imageRequest$Builder1.a(), null, b0.a(d.h(d.q(androidx.compose.foundation.layout.a.n(n1, 10.0f, 0.0f, 0.0f, 10.0f, 6), 260.0f), 50.0f), r0.d.g), i1, N0.j.c, null, p0, 0x1B0030, 0xF98);
            }
            p0.p(false);
            p0.p(true);
            c.d(p0, d.h(n2, 8.0f));
            String s = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.title;
            q.f(s, "title");
            N1.b(s, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0, 0xC30, 120830);
            c.d(p0, d.h(n2, 5.0f));
            String s1 = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.regDate;
            q.f(s1, "regDate");
            N1.b(s1, null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(v, v1, 4, n0, artistHomeContentsRes$RESPONSE$HIRISINGLIST0, q0);
        }
    }

    private static final H HiRisingItem$lambda$10(int v, HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, r0.q q0, n n0, int v1, l l0, int v2) {
        ArtistHiRisingHolderKt.HiRisingItem(v, artistHomeContentsRes$RESPONSE$HIRISINGLIST0, q0, n0, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)));
        return H.a;
    }

    public static H d(HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, int v) {
        return ArtistHiRisingHolderKt.ArtistHiRisingSlotPreView$lambda$14$lambda$13$lambda$12(artistHomeContentsRes$RESPONSE$HIRISINGLIST0, v);
    }

    public static H g(int v, l l0, int v1) {
        return ArtistHiRisingHolderKt.ArtistHiRisingSlotPreView$lambda$15(v, l0, v1);
    }
}

