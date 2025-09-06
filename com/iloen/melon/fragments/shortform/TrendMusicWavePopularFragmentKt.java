package com.iloen.melon.fragments.shortform;

import Cc.G3;
import Cc.N1;
import Cc.U;
import Cc.c1;
import Cc.e0;
import Cc.s3;
import M.c;
import M.g;
import M.p0;
import M.y;
import N0.M;
import P.F;
import P.I;
import P.b;
import P.m;
import P.v;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.N;
import Q0.k0;
import T.e;
import U4.x;
import U8.z;
import Vc.L;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.B1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.BANNER;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.Channel;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import r0.a;
import r0.d;
import r0.n;
import r0.q;
import wc.u;
import we.o;
import y0.s;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A;\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000B\u001A\'\u0010\u000F\u001A\u00020\t2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0001\u001A\u00020\u0000H\u0003¢\u0006\u0004\b\u000F\u0010\u0010\u001A7\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u00042\b\b\u0002\u0010\u0001\u001A\u00020\u00002\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\t0\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001A%\u0010\u001A\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u00172\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\t0\u0013H\u0003¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u000F\u0010\u001C\u001A\u00020\tH\u0003¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u000F\u0010\u001E\u001A\u00020\tH\u0003¢\u0006\u0004\b\u001E\u0010\u001D\u001A\u000F\u0010\u001F\u001A\u00020\tH\u0003¢\u0006\u0004\b\u001F\u0010\u001D\u001A\u000F\u0010 \u001A\u00020\tH\u0003¢\u0006\u0004\b \u0010\u001D¨\u0006&²\u0006\u000E\u0010\"\u001A\u00020!8\n@\nX\u008A\u008E\u0002²\u0006\u000E\u0010$\u001A\u00020#8\n@\nX\u008A\u008E\u0002²\u0006\u000E\u0010%\u001A\u00020!8\n@\nX\u008A\u008E\u0002"}, d2 = {"Lr0/q;", "modifier", "", "isEvent", "", "backgroundImg", "title", "", "visitorCount", "Lie/H;", "ThumbnailTypeItem", "(Lr0/q;ZLjava/lang/String;Ljava/lang/String;JLandroidx/compose/runtime/l;II)V", "", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST$Channel;", "itemList", "ThumbnailTypeGridLayout", "(Ljava/util/List;Lr0/q;Landroidx/compose/runtime/l;II)V", "imgUrl", "text", "Lkotlin/Function0;", "clickAction", "TrendMusicWavePopularLayoutExtra", "(Ljava/lang/String;Ljava/lang/String;Lr0/q;Lwe/a;Landroidx/compose/runtime/l;II)V", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotItem", "linkClickAction", "TrendMusicWavePopularScreen", "(Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;Lwe/a;Landroidx/compose/runtime/l;I)V", "ThumbnailTypeItemPreview", "(Landroidx/compose/runtime/l;I)V", "TrendMusicWavePopularLayoutExtraPreview", "ThumbnailTypeGridLayoutPreview", "TrendMusiTrendMusicWavePopularScreenPreview", "", "bgColor", "LN0/k;", "contentScale", "viewHeight", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMusicWavePopularFragmentKt {
    private static final void ThumbnailTypeGridLayout(List list0, q q0, l l0, int v, int v1) {
        q q1;
        p p0 = (p)l0;
        p0.c0(68408125);
        int v2 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
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
            n n0 = n.a;
            q q2 = (v1 & 2) == 0 ? q1 : n0;
            M m0 = M.p.d(d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q3 = a.d(p0, q2);
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
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q3, j.d);
            F f0 = I.a(p0);
            P.a a0 = new P.a(2);
            q q4 = androidx.compose.ui.input.nestedscroll.a.a(n0, N.u(p0), null);
            g g0 = M.j.h(11.0f);
            g g1 = M.j.h(11.0f);
            boolean z = p0.i(list0);
            com.iloen.melon.fragments.shortform.h h1 = p0.N();
            if(z || h1 == androidx.compose.runtime.k.a) {
                h1 = new com.iloen.melon.fragments.shortform.h(list0, 1);
                p0.l0(h1);
            }
            c1.r(a0, q4, f0, null, g0, g1, null, false, h1, p0, 0x1B0000, 408);
            p0.p(true);
            q1 = q2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.shortform.g(list0, q1, v, v1);
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.1 extends r implements we.k {
            final List $items;
            final we.n $key;

            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "LP/m;", "", "it", "LP/b;", "invoke-_-orMbw", "(LP/m;I)J", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.2 extends r implements we.n {
            final List $items;
            final o $span;

            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.2(o o0, List list0) {
                this.$span = o0;
                this.$items = list0;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return new b(this.invoke-_-orMbw(((m)object0), ((Number)object1).intValue()));
            }

            public final long invoke-_-orMbw(m m0, int v) {
                Object object0 = this.$items.get(v);
                return ((b)this.$span.invoke(m0, v, object0)).a;
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.3 extends r implements we.k {
            final List $items;

            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.3(List list0) {
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


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "LP/k;", "", "it", "Lie/H;", "invoke", "(LP/k;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.4 extends r implements we.p {
            final List $items;

            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.4(List list0) {
                this.$items = list0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((P.k)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(P.k k0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(k0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Channel trendShortFormRes$Response$SLOTLIST$Channel0 = (Channel)this.$items.get(v);
                    ((p)l0).a0(-881603362);
                    q q0 = a.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n.a, 140.0f), 190.0f), e.b(10.0f)), e0.T(((p)l0), 0x7F060146), y0.M.a), new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15.lambda.14..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, trendShortFormRes$Response$SLOTLIST$Channel0));  // color:gray050s_dark
                    Boolean boolean0 = trendShortFormRes$Response$SLOTLIST$Channel0.isEvent;
                    kotlin.jvm.internal.q.f(boolean0, "isEvent");
                    String s = trendShortFormRes$Response$SLOTLIST$Channel0.imgUrl;
                    String s1 = trendShortFormRes$Response$SLOTLIST$Channel0.channelTitle;
                    kotlin.jvm.internal.q.f(s1, "channelTitle");
                    TrendMusicWavePopularFragmentKt.access$ThumbnailTypeItem(q0, boolean0.booleanValue(), s, s1, (trendShortFormRes$Response$SLOTLIST$Channel0.viewCnt == null ? 0L : Long.parseLong(trendShortFormRes$Response$SLOTLIST$Channel0.viewCnt)), ((p)l0), 0, 0);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15.lambda.14..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15.lambda.14..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, Channel trendShortFormRes$Response$SLOTLIST$Channel0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.$role);
                com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15.lambda.14..inlined.noRippleClickable-YQRRFTQ.default.1.1 trendMusicWavePopularFragmentKt$ThumbnailTypeGridLayout$lambda$17$lambda$16$lambda$15$lambda$14$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.$item$inlined);
                        MelonLinkExecutor.open(MelonLinkInfo.b(this.$item$inlined));
                    }
                };
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.$enabled, this.$onClickLabel, i0, trendMusicWavePopularFragmentKt$ThumbnailTypeGridLayout$lambda$17$lambda$16$lambda$15$lambda$14$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }

    }

    private static final H ThumbnailTypeGridLayout$lambda$17$lambda$16$lambda$15(List list0, v v0) {
        kotlin.jvm.internal.q.g(v0, "$this$MelonLazyVerticalGrid");
        ((P.i)v0).t(list0.size(), new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.1(new B1(5), list0), null, new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.3(list0), new m0.b(0x49456F69, new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout.lambda.17.lambda.16.lambda.15..inlined.itemsIndexed.default.4(list0), true));
        return H.a;
    }

    private static final Object ThumbnailTypeGridLayout$lambda$17$lambda$16$lambda$15$lambda$12(int v, Channel trendShortFormRes$Response$SLOTLIST$Channel0) {
        kotlin.jvm.internal.q.g(trendShortFormRes$Response$SLOTLIST$Channel0, "item");
        return v + trendShortFormRes$Response$SLOTLIST$Channel0.contsId;
    }

    private static final H ThumbnailTypeGridLayout$lambda$18(List list0, q q0, int v, int v1, l l0, int v2) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout(list0, q0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    private static final void ThumbnailTypeGridLayoutPreview(l l0, int v) {
        ((p)l0).c0(-1500894246);
        if(((p)l0).Q(v & 1, v != 0)) {
            Channel trendShortFormRes$Response$SLOTLIST$Channel0 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel0.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel0.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel0.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel0.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel0.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel1 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel1.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel1.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel1.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel1.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel1.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel2 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel2.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel2.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel2.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel2.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel2.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel3 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel3.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel3.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel3.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel3.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel3.viewCnt = "190";
            TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout(e.k.A(new Channel[]{trendShortFormRes$Response$SLOTLIST$Channel0, trendShortFormRes$Response$SLOTLIST$Channel1, trendShortFormRes$Response$SLOTLIST$Channel2, trendShortFormRes$Response$SLOTLIST$Channel3}), null, ((p)l0), 0, 2);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 10, 0);
        }
    }

    private static final H ThumbnailTypeGridLayoutPreview$lambda$38(int v, l l0, int v1) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayoutPreview(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final void ThumbnailTypeItem(q q0, boolean z, String s, String s1, long v, l l0, int v1, int v2) {
        q q11;
        h h4;
        i i3;
        q q6;
        n n1;
        r0.i i2;
        int v3;
        p p0 = (p)l0;
        p0.c0(0xEF6934CA);
        if((v2 & 1) == 0) {
            v3 = (v1 & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v1 : v1;
        }
        else {
            v3 = v1 | 6;
        }
        if((v1 & 0x30) == 0) {
            v3 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.g(s1) ? 0x800 : 0x400);
        }
        if((v1 & 0x6000) == 0) {
            v3 |= (p0.f(v) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            n n0 = n.a;
            q q1 = (v2 & 1) == 0 ? q0 : n0;
            M m0 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q2 = a.d(p0, q1);
            k.y.getClass();
            r0.i i0 = d.a;
            i i1 = j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            CoroutineScope coroutineScope0 = p0.N();
            V v5 = androidx.compose.runtime.k.a;
            if(coroutineScope0 == v5) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            a0 a00 = p0.N();
            if(a00 == v5) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            b0 b00 = p0.N();
            if(b00 == v5) {
                b00 = w.s(N0.j.e);
                p0.l0(b00);
            }
            q q3 = androidx.compose.foundation.layout.d.n(n0, 140.0f);
            N0.k k0 = TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$4(b00);
            boolean z1 = p0.i(coroutineScope0);
            L l1 = p0.N();
            if(z1 || l1 == v5) {
                l1 = new L(coroutineScope0, b00, a00, 1);
                p0.l0(l1);
            }
            c1.n(q3, s, null, k0, false, 0x7F08078A, l1, null, null, 0.0f, null, 0, 0, false, false, p0, v3 >> 3 & 0x70 | 0x30006, 0, 0x7F94);  // drawable:noimage_logo_medium_w
            if(z) {
                p0.a0(0x4981A1D3);
                i2 = i0;
                n1 = n0;
                c1.n(androidx.compose.foundation.layout.a.n(n0, 10.0f, 10.0f, 0.0f, 0.0f, 12), 0x7F0800AA, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:badge_event_22
            }
            else {
                i2 = i0;
                n1 = n0;
                p0.a0(1222290238);
            }
            p0.p(false);
            q q4 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 140.0f), 115.0f);
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            q q5 = b0.a(q4, d.h);
            if(s == null || TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$1(a00) == 0) {
                p0.a0(0x49908486);
                p0.p(false);
                q6 = n1;
            }
            else {
                p0.a0(0x49883F52);
                q6 = androidx.compose.foundation.q.e(n1, u.f(e.k.A(new s[]{new s(s.f), new s(s.c(y0.M.c(TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$1(a00)), 1.0f))}), 0.0f, e0.a0(57.5f, p0), 8), null, 6);
                p0.p(false);
            }
            q q7 = q5.then(q6);
            M m1 = M.p.d(i2, false);
            int v6 = p0.P;
            i0 i01 = p0.m();
            q q8 = a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                i3 = i1;
                p0.l(i3);
            }
            else {
                i3 = i1;
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v6)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v6, p0, v6, h4);
            }
            w.x(p0, q8, h3);
            q q9 = b0.a(androidx.compose.foundation.layout.a.l(n1, 12.0f, 0.0f, 2), d.g);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v7 = p0.P;
            i0 i02 = p0.m();
            q q10 = a.d(p0, q9);
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h4);
            }
            w.x(p0, q10, h3);
            N1.b(s1, null, e0.T(p0, 0x7F0604A0), 14.0f, null, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 14 & v3 >> 9 | 0xC00, 0xC30, 0x1D7F2);  // color:white
            c.d(p0, androidx.compose.foundation.layout.d.h(n1, 5.0f));
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            kotlin.jvm.internal.q.f("%s명 방문", "getString(...)");
            N1.b(String.format("%s명 방문", Arrays.copyOf(new Object[]{d5.w.r(context0, v)}, 1)), n1, e0.T(p0, 0x7F0604A7), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:white000e_69
            c.d(p0, androidx.compose.foundation.layout.d.h(n1, 12.0f));
            p0.p(true);
            p0.p(true);
            p0.p(true);
            q11 = q1;
        }
        else {
            p0.T();
            q11 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new s3(q11, z, s, s1, v, v1, v2);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt$ThumbnailTypeItem$1$1$1$1", f = "TrendMusicWavePopularFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeItem.1.1.1.1 extends oe.i implements we.n {
            final a0 $bgColor$delegate;
            final Drawable $drawable;
            int label;

            public com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeItem.1.1.1.1(Drawable drawable0, a0 a00, Continuation continuation0) {
                this.$drawable = drawable0;
                this.$bgColor$delegate = a00;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeItem.1.1.1.1(this.$drawable, this.$bgColor$delegate, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeItem.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Bitmap bitmap0 = H0.e.a0(this.$drawable);
                if(bitmap0 != null) {
                    Bitmap bitmap1 = bitmap0.copy(Bitmap.Config.ARGB_8888, true);
                    if(bitmap1 != null) {
                        m4.e e0 = new m4.e(bitmap1);
                        e0.a = 24;
                        m4.g g0 = e0.a().a(m4.i.h);
                        TrendMusicWavePopularFragmentKt.access$ThumbnailTypeItem$lambda$10$lambda$2(this.$bgColor$delegate, (g0 == null ? 0 : g0.d));
                    }
                }
                return H.a;
            }
        }

    }

    private static final int ThumbnailTypeItem$lambda$10$lambda$1(a0 a00) {
        return ((K0)a00).m();
    }

    private static final void ThumbnailTypeItem$lambda$10$lambda$2(a0 a00, int v) {
        ((K0)a00).n(v);
    }

    private static final N0.k ThumbnailTypeItem$lambda$10$lambda$4(b0 b00) {
        return (N0.k)b00.getValue();
    }

    private static final void ThumbnailTypeItem$lambda$10$lambda$5(b0 b00, N0.k k0) {
        b00.setValue(k0);
    }

    private static final H ThumbnailTypeItem$lambda$10$lambda$7$lambda$6(CoroutineScope coroutineScope0, b0 b00, a0 a00, Drawable drawable0) {
        kotlin.jvm.internal.q.g(drawable0, "drawable");
        if(drawable0.getIntrinsicWidth() > drawable0.getIntrinsicHeight()) {
            TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$5(b00, N0.j.d);
        }
        if(TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$1(a00) == 0) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.ThumbnailTypeItem.1.1.1.1(drawable0, a00, null), 3, null);
        }
        return H.a;
    }

    private static final H ThumbnailTypeItem$lambda$11(q q0, boolean z, String s, String s1, long v, int v1, int v2, l l0, int v3) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeItem(q0, z, s, s1, v, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)), v2);
        return H.a;
    }

    private static final void ThumbnailTypeItemPreview(l l0, int v) {
        ((p)l0).c0(0x700FAAF7);
        if(((p)l0).Q(v & 1, v != 0)) {
            TrendMusicWavePopularFragmentKt.ThumbnailTypeItem(null, true, "", "테스트", 1000000L, ((p)l0), 28080, 1);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 9, 0);
        }
    }

    private static final H ThumbnailTypeItemPreview$lambda$30(int v, l l0, int v1) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeItemPreview(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final void TrendMusiTrendMusicWavePopularScreenPreview(l l0, int v) {
        ((p)l0).c0(0xD2449F0B);
        if(((p)l0).Q(v & 1, v != 0)) {
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = new SLOTLIST();
            BANNER trendShortFormRes$Response$SLOTLIST$BANNER0 = new BANNER();
            trendShortFormRes$Response$SLOTLIST$BANNER0.text = "바로가기";
            trendShortFormRes$Response$SLOTLIST$BANNER0.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST0.banner = trendShortFormRes$Response$SLOTLIST$BANNER0;
            Channel trendShortFormRes$Response$SLOTLIST$Channel0 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel0.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel0.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel0.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel0.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel0.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel1 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel1.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel1.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel1.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel1.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel1.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel2 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel2.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel2.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel2.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel2.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel2.viewCnt = "190";
            Channel trendShortFormRes$Response$SLOTLIST$Channel3 = new Channel();
            trendShortFormRes$Response$SLOTLIST$Channel3.isEvent = Boolean.TRUE;
            trendShortFormRes$Response$SLOTLIST$Channel3.channelTitle = "test1";
            trendShortFormRes$Response$SLOTLIST$Channel3.imgUrl = "";
            trendShortFormRes$Response$SLOTLIST$Channel3.contsId = "1";
            trendShortFormRes$Response$SLOTLIST$Channel3.viewCnt = "190";
            trendShortFormRes$Response$SLOTLIST0.channelList = e.k.e(new Channel[]{trendShortFormRes$Response$SLOTLIST$Channel0, trendShortFormRes$Response$SLOTLIST$Channel1, trendShortFormRes$Response$SLOTLIST$Channel2, trendShortFormRes$Response$SLOTLIST$Channel3});
            com.iloen.melon.fragments.mymusic.dna.d d0 = ((p)l0).N();
            if(d0 == androidx.compose.runtime.k.a) {
                d0 = new com.iloen.melon.fragments.mymusic.dna.d(10);
                ((p)l0).l0(d0);
            }
            TrendMusicWavePopularFragmentKt.TrendMusicWavePopularScreen(trendShortFormRes$Response$SLOTLIST0, d0, ((p)l0), 0x30);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 11, 0);
        }
    }

    private static final H TrendMusiTrendMusicWavePopularScreenPreview$lambda$46$lambda$45() {
        return H.a;
    }

    private static final H TrendMusiTrendMusicWavePopularScreenPreview$lambda$47(int v, l l0, int v1) {
        TrendMusicWavePopularFragmentKt.TrendMusiTrendMusicWavePopularScreenPreview(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final void TrendMusicWavePopularLayoutExtra(String s, String s1, q q0, we.a a0, l l0, int v, int v1) {
        q q6;
        p p0 = (p)l0;
        p0.c0(0xAE59B313);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(a0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            q q1 = (v1 & 4) == 0 ? q0 : n0;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = a.d(p0, q1);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q2, j.d);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 30.0f));
            kotlin.jvm.internal.q.f("지금 인기 있는 뮤직웨이브 채널을 확인해 보세요", "getString(...)");
            long v4 = e0.T(p0, 0x7F0604A0);  // color:white
            h h3 = j.d;
            N1.b("지금 인기 있는 뮤직웨이브 채널을 확인해 보세요", null, v4, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
            q q3 = a.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(x.s(n0, 15.0f, p0, n0, 1.0f), 42.0f), e.b(4.0f)), e0.T(p0, 0x7F060081), y0.M.a), new o() {  // color:color_283dc0
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    K.m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtra.lambda.21..inlined.noRippleClickable-YQRRFTQ.default.1.1 trendMusicWavePopularFragmentKt$TrendMusicWavePopularLayoutExtra$lambda$21$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.$clickAction$inlined);
                            this.$clickAction$inlined.invoke();
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, trendMusicWavePopularFragmentKt$TrendMusicWavePopularLayoutExtra$lambda$21$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(M.j.a, d.k, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q4 = a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q4, h3);
            c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.n(n0, 15.0f, 0.0f, 0.0f, 0.0f, 14), 12.0f), s, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 << 3 & 0x70 | 6, 0, 0x7FFC);
            N1.b(s1, null, A7.d.g(n0, 4.0f, p0, 0x7F0604A0, p0), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 0, 0x1FFF2);  // color:white
            l1.x(1.0f, true, p0);
            q q5 = androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 6.0f, 0.0f, 11), 30.0f);
            y0.k k0 = new y0.k(e0.T(p0, 0x7F0604A0), 5);  // color:white
            c1.n(q5, 0x7F08008C, null, null, false, 0, null, null, d.f, 0.0f, k0, 0, 0, false, false, p0, 0x6000036, 0, 0x7AFC);  // drawable:arrow_common_list
            p0.p(true);
            A7.d.v(n0, 17.0f, p0, true);
            q6 = q1;
        }
        else {
            p0.T();
            q6 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(v, v1, s, s1, q6, a0);
        }
    }

    private static final H TrendMusicWavePopularLayoutExtra$lambda$22(String s, String s1, q q0, we.a a0, int v, int v1, l l0, int v2) {
        TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtra(s, s1, q0, a0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    private static final void TrendMusicWavePopularLayoutExtraPreview(l l0, int v) {
        ((p)l0).c0(1590812998);
        if(((p)l0).Q(v & 1, v != 0)) {
            com.iloen.melon.fragments.mymusic.dna.d d0 = ((p)l0).N();
            if(d0 == androidx.compose.runtime.k.a) {
                d0 = new com.iloen.melon.fragments.mymusic.dna.d(9);
                ((p)l0).l0(d0);
            }
            TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtra("", "바로가기", null, d0, ((p)l0), 0xC36, 4);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 8, 0);
        }
    }

    private static final H TrendMusicWavePopularLayoutExtraPreview$lambda$32$lambda$31() {
        return H.a;
    }

    private static final H TrendMusicWavePopularLayoutExtraPreview$lambda$33(int v, l l0, int v1) {
        TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtraPreview(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final void TrendMusicWavePopularScreen(SLOTLIST trendShortFormRes$Response$SLOTLIST0, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xD09DA028);
        int v1 = 4;
        int v2 = (v & 6) == 0 ? (p0.i(trendShortFormRes$Response$SLOTLIST0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            a0 a00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(a00 == v3) {
                a00 = w.p(0);
                p0.l0(a00);
            }
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            com.iloen.melon.fragments.shortform.h h0 = p0.N();
            if(h0 == v3) {
                h0 = new com.iloen.melon.fragments.shortform.h(a00, 0);
                p0.l0(h0);
            }
            q q0 = androidx.compose.ui.layout.a.f(fillElement0, h0);
            M m0 = M.p.d(d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
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
            h h1 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h1);
            }
            w.x(p0, q1, j.d);
            int v5 = ScreenUtils.getStatusBarHeight(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
            float f = e0.a0(50.0f, p0);
            float f1 = e0.a0(124.0f, p0);
            if(e0.a0(391.0f, p0) > ((float)TrendMusicWavePopularFragmentKt.TrendMusicWavePopularScreen$lambda$24(a00)) - (f1 + (f + ((float)v5)))) {
                v1 = 2;
            }
            ArrayList arrayList0 = trendShortFormRes$Response$SLOTLIST0.channelList;
            kotlin.jvm.internal.q.f(arrayList0, "channelList");
            List list0 = je.p.K0(v1, arrayList0);
            float f2 = e0.Z(p0, v5);
            TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout(list0, androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.a.n(n.a, 0.0f, f2 + 50.0f, 0.0f, 124.0f, 5), 291.0f), p0, 0, 0);
            String s = trendShortFormRes$Response$SLOTLIST0.banner.imgUrl;
            kotlin.jvm.internal.q.f(s, "imgUrl");
            String s1 = trendShortFormRes$Response$SLOTLIST0.banner.text;
            kotlin.jvm.internal.q.f(s1, "text");
            q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 124.0f), 20.0f, 0.0f, 2);
            TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtra(s, s1, (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q2, d.h), a0, p0, v2 << 6 & 0x1C00, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U(trendShortFormRes$Response$SLOTLIST0, a0, v, 12);
        }
    }

    private static final int TrendMusicWavePopularScreen$lambda$24(a0 a00) {
        return ((K0)a00).m();
    }

    private static final void TrendMusicWavePopularScreen$lambda$25(a0 a00, int v) {
        ((K0)a00).n(v);
    }

    private static final H TrendMusicWavePopularScreen$lambda$27$lambda$26(a0 a00, r1.l l0) {
        TrendMusicWavePopularFragmentKt.TrendMusicWavePopularScreen$lambda$25(a00, ((int)(l0.a & 0xFFFFFFFFL)));
        return H.a;
    }

    private static final H TrendMusicWavePopularScreen$lambda$29(SLOTLIST trendShortFormRes$Response$SLOTLIST0, we.a a0, int v, l l0, int v1) {
        TrendMusicWavePopularFragmentKt.TrendMusicWavePopularScreen(trendShortFormRes$Response$SLOTLIST0, a0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H a(int v, l l0, int v1) {
        return TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtraPreview$lambda$33(v, l0, v1);
    }

    public static final void access$ThumbnailTypeItem(q q0, boolean z, String s, String s1, long v, l l0, int v1, int v2) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeItem(q0, z, s, s1, v, l0, v1, v2);
    }

    public static final void access$ThumbnailTypeItem$lambda$10$lambda$2(a0 a00, int v) {
        TrendMusicWavePopularFragmentKt.ThumbnailTypeItem$lambda$10$lambda$2(a00, v);
    }

    public static final void access$TrendMusicWavePopularScreen(SLOTLIST trendShortFormRes$Response$SLOTLIST0, we.a a0, l l0, int v) {
        TrendMusicWavePopularFragmentKt.TrendMusicWavePopularScreen(trendShortFormRes$Response$SLOTLIST0, a0, l0, v);
    }

    public static H b() {
        return TrendMusicWavePopularFragmentKt.TrendMusiTrendMusicWavePopularScreenPreview$lambda$46$lambda$45();
    }

    public static Object f(int v, Channel trendShortFormRes$Response$SLOTLIST$Channel0) {
        return TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayout$lambda$17$lambda$16$lambda$15$lambda$12(v, trendShortFormRes$Response$SLOTLIST$Channel0);
    }

    public static H k(int v, l l0, int v1) {
        return TrendMusicWavePopularFragmentKt.ThumbnailTypeItemPreview$lambda$30(v, l0, v1);
    }

    public static H l(int v, l l0, int v1) {
        return TrendMusicWavePopularFragmentKt.TrendMusiTrendMusicWavePopularScreenPreview$lambda$47(v, l0, v1);
    }

    public static H m(int v, l l0, int v1) {
        return TrendMusicWavePopularFragmentKt.ThumbnailTypeGridLayoutPreview$lambda$38(v, l0, v1);
    }

    public static H n() {
        return TrendMusicWavePopularFragmentKt.TrendMusicWavePopularLayoutExtraPreview$lambda$32$lambda$31();
    }
}

