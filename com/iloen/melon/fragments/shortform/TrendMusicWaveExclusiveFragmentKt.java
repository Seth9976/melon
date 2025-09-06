package com.iloen.melon.fragments.shortform;

import Ac.A2;
import Ac.C0;
import Ac.a4;
import Cc.G3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import G.B;
import G.x0;
import M.g;
import M.j0;
import M.p0;
import M.y;
import N0.j;
import O.F;
import O.I;
import P0.h;
import P0.i;
import T.e;
import U4.x;
import U8.z;
import Uf.b;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kd.T;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import m0.c;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.d;
import r0.n;
import r0.q;
import y0.M;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0002\u001A=\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u001A\u0010\u0005\u001A\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001A\'\u0010\u000F\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u000F\u0010\u0010\u001A1\u0010\u0014\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u000F\u0010\u0016\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u000F\u0010\u0018\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u001B²\u0006\u000E\u0010\u001A\u001A\u00020\u00198\n@\nX\u008A\u008E\u0002"}, d2 = {"Lr0/q;", "modifier", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "imageUrlList", "LUf/b;", "intervalSeconds", "Lie/H;", "AutoSwitchingImage-WPi__2c", "(Lr0/q;Ljava/util/ArrayList;JLandroidx/compose/runtime/l;II)V", "AutoSwitchingImage", "", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST$CHAT;", "chatList", "MusicWaveChatList", "(Lr0/q;Ljava/util/List;Landroidx/compose/runtime/l;II)V", "message", "name", "imgUrl", "MusicWaveChatItem", "(Lr0/q;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/l;II)V", "PreviewMusicWaveChat", "(Landroidx/compose/runtime/l;I)V", "PreviewMusicWaveInfo", "", "currentIndex", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMusicWaveExclusiveFragmentKt {
    public static final void AutoSwitchingImage-WPi__2c(@Nullable q q0, @Nullable ArrayList arrayList0, long v, @Nullable l l0, int v1, int v2) {
        a0 a01;
        f f0;
        n0 n00;
        q q1;
        int v3;
        ((p)l0).c0(236280957);
        if((v2 & 1) != 0) {
            v3 = v1 | 6;
            q1 = q0;
        }
        else if((v1 & 6) == 0) {
            q1 = q0;
            v3 = (((p)l0).g(q1) ? 4 : 2) | v1;
        }
        else {
            q1 = q0;
            v3 = v1;
        }
        if((v1 & 0x30) == 0) {
            v3 |= (((p)l0).i(arrayList0) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (((p)l0).f(v) ? 0x100 : 0x80);
        }
        boolean z = true;
        if(((p)l0).Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            q q2 = (v2 & 1) == 0 ? q1 : n.a;
            if(arrayList0 == null || arrayList0.isEmpty()) {
                n00 = ((p)l0).t();
                if(n00 != null) {
                    f0 = new f(q2, arrayList0, v, v1, v2, 0);
                    n00.d = f0;
                }
            }
            else {
                a0 a00 = ((p)l0).N();
                V v4 = k.a;
                if(a00 == v4) {
                    a00 = w.p(0);
                    ((p)l0).l0(a00);
                }
                b b0 = new b(v);
                if((v3 & 0x380) != 0x100) {
                    z = false;
                }
                boolean z1 = ((p)l0).i(arrayList0);
                com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage.2.1 trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$10 = ((p)l0).N();
                if(!z1 && !z && trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$10 != v4) {
                    a01 = a00;
                }
                else {
                    a01 = a00;
                    com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage.2.1 trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$11 = new we.n(v, arrayList0, a01, null) {
                        final a0 $currentIndex$delegate;
                        final ArrayList $imageUrlList;
                        final long $intervalSeconds;
                        int label;

                        {
                            this.$intervalSeconds = v;
                            this.$imageUrlList = arrayList0;
                            this.$currentIndex$delegate = a00;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage.2.1(this.$intervalSeconds, this.$imageUrlList, this.$currentIndex$delegate, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    goto label_8;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            do {
                                int v = TrendMusicWaveExclusiveFragmentKt.access$AutoSwitchingImage_WPi__2c$lambda$2(this.$currentIndex$delegate);
                                TrendMusicWaveExclusiveFragmentKt.access$AutoSwitchingImage_WPi__2c$lambda$3(this.$currentIndex$delegate, (v + 1) % this.$imageUrlList.size());
                            label_8:
                                this.label = 1;
                            }
                            while(DelayKt.delay-VtjQ1oo(this.$intervalSeconds, this) != a0);
                            return a0;
                        }
                    };
                    ((p)l0).l0(trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$11);
                    trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$10 = trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$11;
                }
                J.f(arrayList0, b0, trendMusicWaveExclusiveFragmentKt$AutoSwitchingImage$2$10, ((p)l0));
                ye.a.e(TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage_WPi__2c$lambda$2(a01), null, new x0(800, 0, B.a), "", c.e(0x173AA003, ((p)l0), new a4(11, q2, arrayList0)), ((p)l0), 0x6C00, 2);
                q1 = q2;
                goto label_48;
            }
        }
        else {
            ((p)l0).T();
        label_48:
            n00 = ((p)l0).t();
            if(n00 != null) {
                f0 = new f(q1, arrayList0, v, v1, v2, 1);
                n00.d = f0;
            }
        }
    }

    private static final H AutoSwitchingImage_WPi__2c$lambda$0(q q0, ArrayList arrayList0, long v, int v1, int v2, l l0, int v3) {
        TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage-WPi__2c(q0, arrayList0, v, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)), v2);
        return H.a;
    }

    private static final int AutoSwitchingImage_WPi__2c$lambda$2(a0 a00) {
        return ((K0)a00).m();
    }

    private static final void AutoSwitchingImage_WPi__2c$lambda$3(a0 a00, int v) {
        ((K0)a00).n(v);
    }

    private static final H AutoSwitchingImage_WPi__2c$lambda$5(q q0, ArrayList arrayList0, int v, l l0, int v1) {
        int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).e(v) ? 4 : 2) : v1;
        if(((p)l0).Q(v2 & 1, (v2 & 19) != 18)) {
            c1.n(q0, arrayList0.get(v), null, j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)l0), 0xC00, 0, 0x7FF4);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H AutoSwitchingImage_WPi__2c$lambda$6(q q0, ArrayList arrayList0, long v, int v1, int v2, l l0, int v3) {
        TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage-WPi__2c(q0, arrayList0, v, l0, (v1 | 1) & -920350135 | ((0x24924924 & (v1 | 1)) >> 1 | 306783378 & (v1 | 1)) | (306783378 & (v1 | 1)) << 1 & (0x24924924 & (v1 | 1)), v2);
        return H.a;
    }

    public static final void MusicWaveChatItem(@Nullable q q0, @NotNull String s, @NotNull String s1, @NotNull String s2, @Nullable l l0, int v, int v1) {
        h h4;
        i i1;
        q q4;
        int v2;
        kotlin.jvm.internal.q.g(s, "message");
        kotlin.jvm.internal.q.g(s1, "name");
        kotlin.jvm.internal.q.g(s2, "imgUrl");
        p p0 = (p)l0;
        p0.c0(0x4004E324);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.g(s2) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
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
            w.x(p0, y0, h0);
            h h1 = P0.j.e;
            w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q2, h3);
            M.b b0 = M.j.a;
            p0 p00 = M.n0.a(b0, d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q3 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            q4 = q1;
            N1.b(s1, androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n0, 15.0f), 41.0f, 0.0f, 0.0f, 0.0f, 14).then(new LayoutWeightElement(1.0f, false)), e0.T(p0, 0x7F0604A1), 12.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 >> 6 & 14 | 0x30C00, 0xC30, 0x1D7D0);  // color:white000e
            e1.y y1 = e1.y.i;
            c1.n(androidx.compose.foundation.layout.d.n(androidx.compose.foundation.layout.a.n(n0, 4.0f, 0.0f, 10.0f, 0.0f, 10), 10.0f), 0x7F08041A, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_common_verify_10
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 6.0f));
            p0 p01 = M.n0.a(b0, d.j, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q5 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i02, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v5)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v5, p0, v5, h4);
            }
            w.x(p0, q5, h3);
            q q6 = androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.n(n0, 33.0f), e.a), e0.T(p0, 0x7F060144), M.a);  // color:gray050e
            androidx.compose.foundation.y y2 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604A1), 1.0f);  // color:white000e
            c1.n(androidx.compose.foundation.q.j(q6, y2.a, y2.b, e.a), s2, null, j.b, false, 0x7F0807A2, null, null, null, 0.0f, null, 0, 0, false, false, p0, v2 >> 6 & 0x70 | 0x30C00, 0, 0x7FD4);  // drawable:noimage_person_xmini
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 8.0f));
            q q7 = androidx.compose.foundation.q.f(new LayoutWeightElement(1.0f, false), e0.T(p0, 0x7F0604A1), e.b(16.5f));  // color:white000e
            N0.M m0 = M.p.d(d.a, false);
            int v6 = p0.P;
            i0 i03 = p0.m();
            q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h4);
            }
            w.x(p0, q8, h3);
            N1.b(s, androidx.compose.foundation.layout.a.k(n0, 12.0f, 8.0f), ye.a.v(p0, 0x7F06002F), 0.0f, y1, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0x30000, 0, 0x1FFD8);  // color:black
            A7.d.s(p0, true, true, true);
        }
        else {
            p0.T();
            q4 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new G3(q4, s, s1, s2, v, v1);
        }
    }

    private static final H MusicWaveChatItem$lambda$15(q q0, String s, String s1, String s2, int v, int v1, l l0, int v2) {
        TrendMusicWaveExclusiveFragmentKt.MusicWaveChatItem(q0, s, s1, s2, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public static final void MusicWaveChatList(@Nullable q q0, @NotNull List list0, @Nullable l l0, int v, int v1) {
        q q1;
        int v2;
        kotlin.jvm.internal.q.g(list0, "chatList");
        p p0 = (p)l0;
        p0.c0(0xD6724AEC);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            q1 = q0;
        }
        else if((v & 6) == 0) {
            q1 = q0;
            v2 = (p0.g(q1) ? 4 : 2) | v;
        }
        else {
            q1 = q0;
            v2 = v;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.i(list0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            n n0 = n.a;
            q q2 = (v1 & 1) == 0 ? q1 : n0;
            N0.M m0 = M.p.d(d.e, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            w.x(p0, q3, h3);
            F f0 = I.a(0, 0, 3, p0);
            q q4 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.d.c(n0, 0.5f), 1.0f), 40.0f, 0.0f, 40.0f, 0.0f, 10);
            kotlin.jvm.internal.q.g(q4, "<this>");
            kotlin.jvm.internal.q.g(f0, "scrollableState");
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            q q5 = q4.then(androidx.compose.ui.draw.a.c(androidx.compose.ui.graphics.a.a(fillElement0, new C0(22)), new A2(f0, 9)));
            N0.M m1 = M.p.d(d.a, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q6, h3);
            List list1 = p0.N();
            if(list1 == k.a) {
                p0.l0(list0);
                list1 = list0;
            }
            j0 j00 = androidx.compose.foundation.layout.a.a(0.0f, 15.0f, 1);
            g g0 = M.j.h(15.0f);
            D8.i.a(list1, x1.a.P(3, Uf.d.d), j00, g0, null, fillElement0, f0, ComposableSingletons.TrendMusicWaveExclusiveFragmentKt.INSTANCE.getLambda$1323796333$app_playstoreProdRelease(), p0, 0xC30D80);
            p0.p(true);
            p0.p(true);
            q1 = q2;
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.fragments.shortform.g(q1, list0, v, v1);
        }
    }

    private static final H MusicWaveChatList$lambda$10(q q0, List list0, int v, int v1, l l0, int v2) {
        TrendMusicWaveExclusiveFragmentKt.MusicWaveChatList(q0, list0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public static final void PreviewMusicWaveChat(@Nullable l l0, int v) {
        ((p)l0).c0(0x9E9E26D1);
        if(((p)l0).Q(v & 1, v != 0)) {
            TrendMusicWaveExclusiveFragmentKt.MusicWaveChatItem(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 3), "좋아해주셨음 좋겠네요 히히 이번 앨범\n실물 봤는데 너무 예뻐ㅠㅠ", "카리나(KARINA)", "", ((p)l0), 0xD86, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 7, 0);
        }
    }

    private static final H PreviewMusicWaveChat$lambda$16(int v, l l0, int v1) {
        TrendMusicWaveExclusiveFragmentKt.PreviewMusicWaveChat(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static final void PreviewMusicWaveInfo(@Nullable l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x279603A7);
        if(p0.Q(v & 1, v != 0)) {
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), 20.0f, 0.0f, 2);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            w.x(p0, q1, P0.j.d);
            c1.n(null, 0x7F0805DA, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:ic_shortmusic_musicwave_25
            T.g(x.s(n0, 12.0f, p0, n0, 1.0f), "asepa의 뮤직웨이브", "asepa", "", 11000L, "8760000", true, p0, 0x1B6DB6);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z(v, 6, 0);
        }
    }

    private static final H PreviewMusicWaveInfo$lambda$18(int v, l l0, int v1) {
        TrendMusicWaveExclusiveFragmentKt.PreviewMusicWaveInfo(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H a(List list0, q q0, int v, int v1, l l0, int v2) {
        return TrendMusicWaveExclusiveFragmentKt.MusicWaveChatList$lambda$10(q0, list0, v, v1, l0, v2);
    }

    public static final int access$AutoSwitchingImage_WPi__2c$lambda$2(a0 a00) {
        return TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage_WPi__2c$lambda$2(a00);
    }

    public static final void access$AutoSwitchingImage_WPi__2c$lambda$3(a0 a00, int v) {
        TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage_WPi__2c$lambda$3(a00, v);
    }

    public static H e(int v, l l0, int v1) {
        return TrendMusicWaveExclusiveFragmentKt.PreviewMusicWaveInfo$lambda$18(v, l0, v1);
    }

    public static H g(int v, l l0, int v1) {
        return TrendMusicWaveExclusiveFragmentKt.PreviewMusicWaveChat$lambda$16(v, l0, v1);
    }
}

