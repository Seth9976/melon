package com.iloen.melon.player.playlist.drawernew.composable;

import Cc.A2;
import Cc.e0;
import Dc.g;
import Dc.u;
import K.m;
import M.y;
import N0.M;
import O.F;
import O.I;
import P0.h;
import P0.j;
import Q0.k0;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import com.iloen.melon.player.playlist.common.SongListItemRightIconType;
import com.iloen.melon.player.playlist.common.scrollbar.AppScrollbarsKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarState;
import com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt;
import h7.u0;
import ie.H;
import ie.s;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import r0.i;
import we.a;
import we.k;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000@\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001Aÿ\u0001\u0010\u0018\u001A\u00020\u000B2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001A\u00020\u00032\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\u0018\u0010\t\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000B0\r2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000B0\r2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000B0\r2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000B0\r2\u0018\u0010\u0013\u001A\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000B0\u00122\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00142\u001C\b\u0002\u0010\u0016\u001A\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u00122\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"", "Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "list", "", "isOnSelectRepeatMode", "Lkotlinx/coroutines/flow/StateFlow;", "isToolbarVisible", "Lie/s;", "", "swapCancelPosition", "Lkotlinx/coroutines/flow/Flow;", "Lie/H;", "scrollTopEventByFetch", "Lkotlin/Function1;", "onCheck", "onClickSongMore", "onClickItem", "onClickThumb", "Lkotlin/Function2;", "onLongClickItem", "Lkotlin/Function0;", "onMoveBefore", "onSwapped", "onTouchDownMoveIconWhenSelectRepeatOn", "DrawerSongList", "(Ljava/util/List;ZLkotlinx/coroutines/flow/StateFlow;Lie/s;Lkotlinx/coroutines/flow/Flow;Lwe/k;Lwe/k;Lwe/k;Lwe/k;Lwe/n;Lwe/a;Lwe/n;Lwe/a;Landroidx/compose/runtime/l;III)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongListKt {
    public static final void DrawerSongList(@NotNull List list0, boolean z, @NotNull StateFlow stateFlow0, @NotNull s s0, @NotNull Flow flow0, @NotNull k k0, @NotNull k k1, @NotNull k k2, @NotNull k k3, @NotNull n n0, @NotNull a a0, @Nullable n n1, @NotNull a a1, @Nullable l l0, int v, int v1, int v2) {
        n n5;
        V v17;
        b0 b02;
        CoroutineScope coroutineScope1;
        int v15;
        n n3;
        p p2;
        V v14;
        F f2;
        Context context1;
        V v13;
        g g2;
        int v8;
        q.g(list0, "list");
        q.g(stateFlow0, "isToolbarVisible");
        q.g(s0, "swapCancelPosition");
        q.g(flow0, "scrollTopEventByFetch");
        q.g(k0, "onCheck");
        q.g(k1, "onClickSongMore");
        q.g(k2, "onClickItem");
        q.g(k3, "onClickThumb");
        q.g(n0, "onLongClickItem");
        q.g(a0, "onMoveBefore");
        q.g(a1, "onTouchDownMoveIconWhenSelectRepeatOn");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x572C8817);
        int v3 = 2;
        int v4 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        int v5 = 16;
        if((v & 0x30) == 0) {
            v4 |= (p0.h(z) ? 0x20 : 16);
        }
        int v6 = v4;
        int v7 = 0x80;
        if((v & 0x180) == 0) {
            v6 |= (p0.i(stateFlow0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v6 |= (p0.g(s0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v6 |= (p0.i(flow0) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v6 |= (p0.i(k0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v6 |= (p0.i(k1) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v6 |= (p0.i(k2) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v) == 0) {
            v6 |= (p0.i(k3) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v) == 0) {
            v6 |= (p0.i(n0) ? 0x20000000 : 0x10000000);
        }
        if((v1 & 6) == 0) {
            if(p0.i(a0)) {
                v3 = 4;
            }
            v8 = v1 | v3;
        }
        else {
            v8 = v1;
        }
        if((v2 & 0x800) != 0) {
            v8 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            if(p0.i(n1)) {
                v5 = 0x20;
            }
            v8 |= v5;
        }
        if((v1 & 0x180) == 0) {
            if(p0.i(a1)) {
                v7 = 0x100;
            }
            v8 |= v7;
        }
        if(p0.Q(v6 & 1, (v6 & 306783379) != 306783378 || (v8 & 0x93) != 0x92)) {
            n n2 = (v2 & 0x800) == 0 ? n1 : null;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            F0.a a2 = (F0.a)p0.k(k0.l);
            p p1 = p0.N();
            V v9 = androidx.compose.runtime.k.a;
            if(p1 == v9) {
                p1 = new p();
                p0.l0(p1);
            }
            F f0 = I.a(0, 0, 3, p0);
            ScrollbarState scrollbarState0 = ScrollbarExtKt.scrollbarState(f0, p1.size(), null, p0, 0, 2);
            boolean z1 = p0.i(a2);
            f f1 = p0.N();
            if(z1 || (v8 & 14) == 4 || f1 == v9) {
                f1 = new f(a2, a0, 0);
                p0.l0(f1);
            }
            com.iloen.melon.player.playlist.drawernew.composable.g g0 = p0.N();
            if(g0 == v9) {
                g0 = new com.iloen.melon.player.playlist.drawernew.composable.g(p1, 0);
                p0.l0(g0);
            }
            A2 a20 = p0.N();
            if((v8 & 0x70) == 0x20 || a20 == v9) {
                a20 = new A2(n2, 3);
                p0.l0(a20);
            }
            u u0 = u0.P(f0, f1, g0, a20, p0, 0x30000);
            a0 a00 = p0.N();
            if(a00 == v9) {
                a00 = w.p(-1);
                p0.l0(a00);
            }
            g g1 = PlaylistCommonSongListComposableKt.getPlaylistCommonItemBgColor(p0, 0);
            FillElement fillElement0 = d.c;
            i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v10 = p0.P;
            i0 i00 = p0.m();
            r0.q q0 = r0.a.d(p0, fillElement0);
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
            if(p0.O) {
                g2 = g1;
                A7.d.q(v10, p0, v10, h2);
            }
            else {
                g2 = g1;
                if(!q.b(p0.N(), v10)) {
                    A7.d.q(v10, p0, v10, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q0, h3);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v9) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            b0 b00 = p0.N();
            if(b00 == v9) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            I0.a a3 = PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection(f0, b00, 0L, p0, 0x30, 4);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v11 = p0.P;
            i0 i01 = p0.m();
            r0.q q1 = r0.a.d(p0, fillElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h2);
            }
            w.x(p0, q1, h3);
            b0 b01 = B.a.r(stateFlow0, p0, v6 >> 6 & 14);
            r0.q q2 = fillElement0.then(new LayoutWeightElement(1.0f, true));
            M m1 = M.p.d(i0, false);
            int v12 = p0.P;
            i0 i02 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h2);
            }
            w.x(p0, q3, h3);
            r0.q q4 = e0.R(androidx.compose.ui.input.nestedscroll.a.a(fillElement0, a3, null), f0, 40.0f, true, false, null, 0x30);
            M.i0 i03 = PlaylistCommonSongListComposableKt.getPlaylistCommonListContentPadding();
            boolean z2 = p0.i(u0);
            boolean z3 = p0.g(g2);
            boolean z4 = p0.i(list0);
            boolean z5 = p0.g(f0);
            com.iloen.melon.player.playlist.drawernew.composable.h h4 = p0.N();
            if((((v8 & 0x70) == 0x20 ? 1 : 0) | ((v8 & 14) == 4 ? 1 : 0) | z2 | z3 | z4 | ((v6 & 0x70) == 0x20 ? 1 : 0) | z5 | ((v6 & 0x1C00000) == 0x800000 ? 1 : 0) | ((v6 & 0x70000000) == 0x20000000 ? 1 : 0) | ((v8 & 0x380) == 0x100 ? 1 : 0) | ((v6 & 0x380000) == 0x100000 ? 1 : 0) | ((v6 & 0xE000000) == 0x4000000 ? 1 : 0) | ((v6 & 0x70000) == 0x20000 ? 1 : 0)) == 0) {
                v13 = v9;
                if(h4 == v13) {
                    goto label_169;
                }
                else {
                    context1 = context0;
                    f2 = f0;
                    v14 = v13;
                    p2 = p1;
                    n3 = n2;
                    v15 = v6;
                    coroutineScope1 = coroutineScope0;
                    b02 = b00;
                }
            }
            else {
                v13 = v9;
            label_169:
                context1 = context0;
                v14 = v13;
                n3 = n2;
                v15 = v6;
                coroutineScope1 = coroutineScope0;
                b02 = b00;
                com.iloen.melon.player.playlist.drawernew.composable.h h5 = new com.iloen.melon.player.playlist.drawernew.composable.h(p1, a0, n3, u0, g2, list0, z, f0, k2, n0, a1, k1, k3, k0);
                p2 = p1;
                f2 = f0;
                p0.l0(h5);
                h4 = h5;
            }
            ye.a.i(q4, f2, i03, false, null, null, null, false, null, h4, p0, 0x180, 504);
            r0.n n4 = r0.n.a;
            r0.q q5 = d.c(n4, 1.0f);
            r0.q q6 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.f);
            AppScrollbarsKt.DraggableScrollbar(f2, scrollbarState0, ThumbExtKt.rememberDraggableScroller(f2, list0.size(), p0, 0), q6, p0, 0, 0);
            int v16 = 0;
            Iterator iterator0 = list0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    v16 = -1;
                    break;
                }
                Object object0 = iterator0.next();
                if(((DrawerSongListItemData)object0).isCurrent()) {
                    break;
                }
                ++v16;
            }
            ((K0)a00).n(v16);
            DrawerSongListItemData drawerSongListItemData0 = (DrawerSongListItemData)je.p.n0(((K0)a00).m(), list0);
            String s1 = drawerSongListItemData0 == null ? null : drawerSongListItemData0.getContentId();
            boolean z6 = p0.g(f2);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.3.1 drawerSongListKt$DrawerSongList$1$1$1$3$10 = p0.N();
            if(z6) {
                v17 = v14;
                drawerSongListKt$DrawerSongList$1$1$1$3$10 = new n(f2, ((K0)a00), null) {
                    public final K0 B;
                    public int r;
                    public final F w;

                    {
                        this.w = f0;
                        this.B = k00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.3.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                if(DelayKt.delay(100L, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        int v = this.B.m();
                        this.r = 2;
                        return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible$default(this.w, v, 0, this, 4, null) == a0 ? a0 : H.a;
                    }
                };
                p0.l0(drawerSongListKt$DrawerSongList$1$1$1$3$10);
            }
            else {
                v17 = v14;
                if(drawerSongListKt$DrawerSongList$1$1$1$3$10 == v17) {
                    drawerSongListKt$DrawerSongList$1$1$1$3$10 = new n(f2, ((K0)a00), null) {
                        public final K0 B;
                        public int r;
                        public final F w;

                        {
                            this.w = f0;
                            this.B = k00;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.3.1(this.w, this.B, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.r) {
                                case 0: {
                                    d5.n.D(object0);
                                    this.r = 1;
                                    if(DelayKt.delay(100L, this) == a0) {
                                        return a0;
                                    }
                                    break;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    break;
                                }
                                case 2: {
                                    d5.n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            int v = this.B.m();
                            this.r = 2;
                            return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible$default(this.w, v, 0, this, 4, null) == a0 ? a0 : H.a;
                        }
                    };
                    p0.l0(drawerSongListKt$DrawerSongList$1$1$1$3$10);
                }
            }
            J.d(p0, s1, drawerSongListKt$DrawerSongList$1$1$1$3$10);
            boolean z7 = p0.i(flow0);
            boolean z8 = p0.g(f2);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1 drawerSongListKt$DrawerSongList$1$1$1$4$10 = p0.N();
            if(z7 || z8 || drawerSongListKt$DrawerSongList$1$1$1$4$10 == v17) {
                drawerSongListKt$DrawerSongList$1$1$1$4$10 = new n(flow0, f2, ((K0)a00), null) {
                    public final F B;
                    public final K0 D;
                    public int r;
                    public final Flow w;

                    {
                        this.w = flow0;
                        this.B = f0;
                        this.D = k00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1(this.w, this.B, this.D, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1.1 drawerSongListKt$DrawerSongList$1$1$1$4$1$10 = new FlowCollector() {
                                    public final F a;
                                    public final K0 b;

                                    {
                                        F f0 = this.D;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                        this.a = f0;
                                        this.b = k00;
                                    }

                                    public final Object emit(H h0, Continuation continuation0) {
                                        com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1.1.emit.1 drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10;
                                        if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1.1.emit.1) {
                                            drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10 = (com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.4.1.1.emit.1)continuation0;
                                            int v = drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.B;
                                            if((v & 0x80000000) == 0) {
                                                drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                    public int B;
                                                    public Object r;

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        this.r = object0;
                                                        this.B |= 0x80000000;
                                                        return continuation0.emit(null, this);
                                                    }
                                                };
                                            }
                                            else {
                                                drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.B = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                public int B;
                                                public Object r;

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    this.r = object0;
                                                    this.B |= 0x80000000;
                                                    return continuation0.emit(null, this);
                                                }
                                            };
                                        }
                                        Object object0 = drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.r;
                                        ne.a a0 = ne.a.a;
                                        switch(drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.B) {
                                            case 0: {
                                                d5.n.D(object0);
                                                drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.B = 1;
                                                if(DelayKt.delay(100L, drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10) == a0) {
                                                    return a0;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                                break;
                                            }
                                            case 2: {
                                                d5.n.D(object0);
                                                return H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        int v1 = this.b.m();
                                        drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10.B = 2;
                                        return PlaylistCommonSongListComposableKt.scrollToCurrentWhenInvisible$default(this.a, v1, 0, drawerSongListKt$DrawerSongList$1$1$1$4$1$1$emit$10, 4, null) == a0 ? a0 : H.a;
                                    }

                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public Object emit(Object object0, Continuation continuation0) {
                                        return this.emit(((H)object0), continuation0);
                                    }
                                };
                                this.r = 1;
                                return this.w.collect(drawerSongListKt$DrawerSongList$1$1$1$4$1$10, this) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                p0.l0(drawerSongListKt$DrawerSongList$1$1$1$4$10);
            }
            J.d(p0, H.a, drawerSongListKt$DrawerSongList$1$1$1$4$10);
            boolean z9 = true;
            p0.p(true);
            if(((Boolean)b01.getValue()).booleanValue()) {
                p0.a0(0xD1E6F25A);
                M.c.d(p0, d.h(n4, E9.h.t(p0, 0x7F070464)));  // dimen:toolbar_height
            }
            else {
                p0.a0(0xD128F5A7);
            }
            p0.p(false);
            p0.p(true);
            U8.F f3 = p0.N();
            if(f3 == v17) {
                f3 = new U8.F(b02, 4);
                p0.l0(f3);
            }
            boolean z10 = p0.i(coroutineScope1);
            boolean z11 = p0.g(f2);
            boolean z12 = p0.i(context1);
            com.iloen.melon.player.playlist.drawernew.composable.i i2 = p0.N();
            if((z10 | z11 | z12) != 0 || i2 == v17) {
                i2 = new com.iloen.melon.player.playlist.drawernew.composable.i(coroutineScope1, f2, context1, 0);
                p0.l0(i2);
            }
            PlaylistCommonSongListComposableKt.PlaylistTopBtn(f3, i2, p0, 6);
            p0.p(true);
            Object object1 = s0.a;
            if((v15 & 0x1C00) != 0x800) {
                z9 = false;
            }
            boolean z13 = p0.i(list0);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.2.1 drawerSongListKt$DrawerSongList$2$10 = p0.N();
            if(z9 || z13 || drawerSongListKt$DrawerSongList$2$10 == v17) {
                drawerSongListKt$DrawerSongList$2$10 = new n(p2, s0, list0, null) {
                    public final List B;
                    public final p r;
                    public final s w;

                    {
                        this.r = p0;
                        this.w = s0;
                        this.B = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.2.1(this.r, this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        PlaylistUiExtensionsKt.move(this.r, ((Number)this.w.b).intValue(), ((Number)this.w.c).intValue());
                        this.r.clear();
                        this.r.addAll(this.B);
                        return H.a;
                    }
                };
                p0.l0(drawerSongListKt$DrawerSongList$2$10);
            }
            J.d(p0, object1, drawerSongListKt$DrawerSongList$2$10);
            boolean z14 = p0.i(list0);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.3.1 drawerSongListKt$DrawerSongList$3$10 = p0.N();
            if(z14 || drawerSongListKt$DrawerSongList$3$10 == v17) {
                drawerSongListKt$DrawerSongList$3$10 = new n(p2, list0, null) {
                    public final p r;
                    public final List w;

                    {
                        this.r = p0;
                        this.w = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.3.1(this.r, this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        this.r.clear();
                        this.r.addAll(this.w);
                        return H.a;
                    }
                };
                p0.l0(drawerSongListKt$DrawerSongList$3$10);
            }
            J.d(p0, list0, drawerSongListKt$DrawerSongList$3$10);
            n5 = n3;
        }
        else {
            p0.T();
            n5 = n1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.j(list0, z, stateFlow0, s0, flow0, k0, k1, k2, k3, n0, a0, n5, a1, v, v1, v2);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1 implements we.p {
            public final List a;
            public final DrawerSongListItemData b;
            public final boolean c;
            public final F d;
            public final k e;
            public final k f;
            public final k g;
            public final n h;
            public final a i;
            public final k j;
            public final k k;
            public final k l;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1(List list0, DrawerSongListItemData drawerSongListItemData0, boolean z, F f0, k k0, k k1, k k2, n n0, a a0, k k3, k k4, k k5) {
                this.a = list0;
                this.b = drawerSongListItemData0;
                this.c = z;
                this.d = f0;
                this.e = k0;
                this.f = k1;
                this.g = k2;
                this.h = n0;
                this.i = a0;
                this.j = k3;
                this.k = k4;
                this.l = k5;
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((Dc.h)object0), ((Boolean)object1).booleanValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(Dc.h h0, boolean z, l l0, int v) {
                a a1;
                a a0;
                q.g(h0, "$this$MovableItem");
                int v1 = (v & 6) == 0 ? v | (((v & 8) == 0 ? ((androidx.compose.runtime.p)l0).g(h0) : ((androidx.compose.runtime.p)l0).i(h0)) ? 4 : 2) : v;
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
                if(p0.Q(v1 & 1, (v1 & 0x83) != 130)) {
                    r0.q q0 = Dc.h.a(h0, this.a.size() > 1, 14);
                    DrawerSongListItemData drawerSongListItemData0 = this.b;
                    boolean z1 = drawerSongListItemData0.isOwnerThenMovable();
                    SongListItemRightIconType songListItemRightIconType0 = z1 ? SongListItemRightIconType.MOVE : SongListItemRightIconType.MORE;
                    boolean z2 = z1 && !this.c;
                    String s = drawerSongListItemData0.getTitle();
                    String s1 = drawerSongListItemData0.getSubTitle();
                    String s2 = String.valueOf(drawerSongListItemData0.getThumbImgUrl());
                    boolean z3 = drawerSongListItemData0.isViewMode();
                    boolean z4 = drawerSongListItemData0.isCurrent();
                    boolean z5 = drawerSongListItemData0.isPlaying();
                    boolean z6 = drawerSongListItemData0.isSelected();
                    boolean z7 = drawerSongListItemData0.isSelectedForSelectRepeat();
                    boolean z8 = drawerSongListItemData0.isAdult();
                    Integer integer0 = PlaylistCommonSongListComposableKt.getFileTypeDrawableResId(drawerSongListItemData0.getFileType());
                    boolean z9 = drawerSongListItemData0.isMarquee();
                    boolean z10 = drawerSongListItemData0.isOfflineContents();
                    V v2 = androidx.compose.runtime.k.a;
                    F f0 = this.d;
                    if(z2) {
                        p0.a0(0xE28F2F59);
                        boolean z11 = p0.g(f0);
                        boolean z12 = p0.i(drawerSongListItemData0);
                        k k0 = this.e;
                        boolean z13 = p0.g(k0);
                        com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.1.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$1$10 = p0.N();
                        if((z11 | z12 | z13) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$1$10 == v2) {
                            drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$1$10 = new a() {
                                public final F a;
                                public final DrawerSongListItemData b;
                                public final k c;

                                {
                                    F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    DrawerSongListItemData drawerSongListItemData0 = k0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    this.a = f0;
                                    this.b = drawerSongListItemData0;
                                    this.c = k0;
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                    if(integer0 != null) {
                                        this.c.invoke(integer0);
                                    }
                                }
                            };
                            p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$1$10);
                        }
                        p0.p(false);
                        a0 = drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$1$10;
                    }
                    else {
                        p0.a0(0xE293B4C2);
                        p0.p(false);
                        a0 = null;
                    }
                    if(z2) {
                        p0.a0(0xE29535D7);
                        boolean z14 = p0.g(f0);
                        boolean z15 = p0.i(drawerSongListItemData0);
                        k k1 = this.f;
                        boolean z16 = p0.g(k1);
                        com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.2.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$2$10 = p0.N();
                        if((z14 | z15 | z16) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$2$10 == v2) {
                            drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$2$10 = new a() {
                                public final F a;
                                public final DrawerSongListItemData b;
                                public final k c;

                                {
                                    F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    DrawerSongListItemData drawerSongListItemData0 = k1;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                    this.a = f0;
                                    this.b = drawerSongListItemData0;
                                    this.c = k0;
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                    if(integer0 != null) {
                                        this.c.invoke(integer0);
                                    }
                                }
                            };
                            p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$2$10);
                        }
                        p0.p(false);
                        a1 = drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$2$10;
                    }
                    else {
                        p0.a0(0xE299C2C2);
                        p0.p(false);
                        a1 = null;
                    }
                    boolean z17 = p0.g(f0);
                    boolean z18 = p0.i(drawerSongListItemData0);
                    k k2 = this.g;
                    boolean z19 = p0.g(k2);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.3.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$3$10 = p0.N();
                    if((z17 | z18 | z19) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$3$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$3$10 = new a() {
                            public final F a;
                            public final DrawerSongListItemData b;
                            public final k c;

                            {
                                F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                DrawerSongListItemData drawerSongListItemData0 = k2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = drawerSongListItemData0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$3$10);
                    }
                    boolean z20 = p0.g(f0);
                    boolean z21 = p0.i(drawerSongListItemData0);
                    n n0 = this.h;
                    boolean z22 = p0.g(n0);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.4.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$4$10 = p0.N();
                    if((z20 | z21 | z22) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$4$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$4$10 = new a() {
                            public final F a;
                            public final DrawerSongListItemData b;
                            public final n c;

                            {
                                F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                DrawerSongListItemData drawerSongListItemData0 = n0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = drawerSongListItemData0;
                                this.c = n0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                DrawerSongListItemData drawerSongListItemData0 = this.b;
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, drawerSongListItemData0.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0, Boolean.valueOf(drawerSongListItemData0.isOwnerThenMovable()));
                                }
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$4$10);
                    }
                    a a2 = this.i;
                    boolean z23 = p0.g(a2);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.5.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$5$10 = p0.N();
                    if(z23 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$5$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$5$10 = new a() {
                            public final a a;

                            {
                                this.a = a0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                this.a.invoke();
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$5$10);
                    }
                    boolean z24 = p0.g(f0);
                    boolean z25 = p0.i(drawerSongListItemData0);
                    k k3 = this.j;
                    boolean z26 = p0.g(k3);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.6.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$6$10 = p0.N();
                    if((z24 | z25 | z26) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$6$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$6$10 = new a() {
                            public final F a;
                            public final DrawerSongListItemData b;
                            public final k c;

                            {
                                F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                DrawerSongListItemData drawerSongListItemData0 = k3;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = drawerSongListItemData0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$6$10);
                    }
                    boolean z27 = p0.g(f0);
                    boolean z28 = p0.i(drawerSongListItemData0);
                    k k4 = this.k;
                    boolean z29 = p0.g(k4);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.7.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$7$10 = p0.N();
                    if((z27 | z28 | z29) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$7$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$7$10 = new a() {
                            public final F a;
                            public final DrawerSongListItemData b;
                            public final k c;

                            {
                                F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                DrawerSongListItemData drawerSongListItemData0 = k4;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = drawerSongListItemData0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$7$10);
                    }
                    boolean z30 = p0.g(f0);
                    boolean z31 = p0.i(drawerSongListItemData0);
                    k k5 = this.l;
                    boolean z32 = p0.g(k5);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1.8.1 drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$8$10 = p0.N();
                    if((z30 | z31 | z32) != 0 || drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$8$10 == v2) {
                        drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$8$10 = new a() {
                            public final F a;
                            public final DrawerSongListItemData b;
                            public final k c;

                            {
                                F f0 = drawerSongListItemData0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                DrawerSongListItemData drawerSongListItemData0 = k5;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = f0;
                                this.b = drawerSongListItemData0;
                                this.c = k0;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.a, this.b.getTrackId());
                                if(integer0 != null) {
                                    this.c.invoke(integer0);
                                }
                            }
                        };
                        p0.l0(drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$8$10);
                    }
                    PlaylistCommonSongListComposableKt.SongListItem(null, q0, s, s1, s2, !z3, z4, z5, z6, z7, z8, integer0, z10, songListItemRightIconType0, z2, z9, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$3$10, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$4$10, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$5$10, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$6$10, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$7$10, drawerSongListKt$DrawerSongList$1$1$1$1$1$2$1$8$10, a0, a1, p0, 0, 0, 0, 1);
                    return;
                }
                p0.T();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt$DrawerSongList$1$3$1$1$1", f = "DrawerSongList.kt", l = {274}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1 extends oe.i implements n {
            public int r;
            public final F w;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1(F f0, Continuation continuation0) {
                this.w = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.j(0, 0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.1 extends r implements k {
            public final n f;
            public final List g;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.1(n n0, List list0) {
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
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final k B;
            public final k D;
            public final List f;
            public final u g;
            public final g h;
            public final List i;
            public final boolean j;
            public final F k;
            public final k l;
            public final k m;
            public final k n;
            public final n o;
            public final a r;
            public final k w;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.19.lambda.18.lambda.14.lambda.13..inlined.itemsIndexed.default.3(List list0, u u0, g g0, List list1, boolean z, F f0, k k0, k k1, k k2, n n0, a a0, k k3, k k4, k k5) {
                this.f = list0;
                this.g = u0;
                this.h = g0;
                this.i = list1;
                this.j = z;
                this.k = f0;
                this.l = k0;
                this.m = k1;
                this.n = k2;
                this.o = n0;
                this.r = a0;
                this.w = k3;
                this.B = k4;
                this.D = k5;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((androidx.compose.runtime.p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object0 = this.f.get(v);
                    ((androidx.compose.runtime.p)l0).a0(774745800);
                    m0.b b0 = m0.c.e(0xFBE4367B, ((androidx.compose.runtime.p)l0), new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.1.1.1.1.2.1(this.i, ((DrawerSongListItemData)object0), this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.w, this.B, this.D));
                    u0.e(a0, this.g, ((DrawerSongListItemData)object0).getTrackId(), null, false, this.h, b0, ((androidx.compose.runtime.p)l0), v2 & 14 | 0x180000);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return;
                }
                ((androidx.compose.runtime.p)l0).T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, CoroutineScope coroutineScope0, F f0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, l l0, int v) {
                q.g(q0, "$this$composed");
                ((androidx.compose.runtime.p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((androidx.compose.runtime.p)l0).k(k0.i);
                m m0 = ((androidx.compose.runtime.p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((androidx.compose.runtime.p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerSongListKt$DrawerSongList$lambda$26$lambda$25$lambda$24$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.d);
                        com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1 drawerSongListKt$DrawerSongList$1$3$1$1$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.1.3.1.1.1(this.c, null);
                        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, drawerSongListKt$DrawerSongList$1$3$1$1$10, 3, null);
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, drawerSongListKt$DrawerSongList$lambda$26$lambda$25$lambda$24$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((androidx.compose.runtime.p)l0).p(false);
                return q1;
            }
        }

    }
}

