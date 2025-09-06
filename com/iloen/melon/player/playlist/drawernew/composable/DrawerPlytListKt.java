package com.iloen.melon.player.playlist.drawernew.composable;

import Cc.c1;
import Cc.e0;
import M.c;
import M.j0;
import M.v;
import N0.M;
import O.F;
import P.m;
import P0.h;
import P0.i;
import P0.j;
import X0.x;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import com.iloen.melon.player.playlist.common.scrollbar.AppScrollbarsKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarState;
import com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytWrapper;
import com.iloen.melon.utils.system.AppUtils;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import r0.a;
import r0.n;
import r0.q;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001Ao\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00052\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000B2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000BH\u0007¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lr0/q;", "modifier", "", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "list", "", "viewType", "", "isBottomSheet", "isConnectNetwork", "selectedAlyacKey", "Lkotlin/Function1;", "Lie/H;", "onClickPlay", "onClickItem", "DrawerPlytPlyt", "(Lr0/q;Ljava/util/List;Ljava/lang/String;ZZLjava/lang/String;Lwe/k;Lwe/k;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlytListKt {
    public static final void DrawerPlytPlyt(@Nullable q q0, @NotNull List list0, @NotNull String s, boolean z, boolean z1, @NotNull String s1, @NotNull k k0, @NotNull k k1, @Nullable l l0, int v, int v1) {
        V v5;
        q q7;
        p p2;
        n n1;
        int v2;
        kotlin.jvm.internal.q.g(list0, "list");
        kotlin.jvm.internal.q.g(s, "viewType");
        kotlin.jvm.internal.q.g(s1, "selectedAlyacKey");
        kotlin.jvm.internal.q.g(k0, "onClickPlay");
        kotlin.jvm.internal.q.g(k1, "onClickItem");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x4204F636);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.i(list0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.h(z) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.h(z1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.g(s1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v2 |= (p0.i(k0) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v) == 0) {
            v2 |= (p0.i(k1) ? 0x800000 : 0x400000);
        }
        if(p0.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            p p1 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(p1 == v3) {
                p1 = new p();
                p0.l0(p1);
            }
            FillElement fillElement0 = d.c;
            q q2 = q1.then(fillElement0);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = a.d(p0, q2);
            P0.k.y.getClass();
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, j.d);
            if(s.equals("LIST")) {
                p0.a0(0xDDC5F8A9);
                F f0 = p0.N();
                if((0x70000 & v2) == 0x20000 || f0 == v3) {
                    f0 = new F(0, 0);
                    p0.l0(f0);
                }
                ScrollbarState scrollbarState0 = ScrollbarExtKt.scrollbarState(f0, list0.size(), null, p0, 0, 2);
                q q4 = e0.R(fillElement0, f0, 40.0f, false, true, null, 0x30);
                j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, (z ? 4 : 12), 0.0f, 0.0f, 13);
                com.iloen.melon.player.playlist.drawernew.composable.d d0 = p0.N();
                if((((0x1C00000 & v2) == 0x800000 ? 1 : 0) | ((0x380000 & v2) == 0x100000 ? 1 : 0) | ((v2 & 0x1C00) == 0x800 ? 1 : 0) | ((0xE000 & v2) == 0x4000 ? 1 : 0)) != 0 || d0 == v3) {
                    n1 = n0;
                    p2 = p1;
                    com.iloen.melon.player.playlist.drawernew.composable.d d1 = new com.iloen.melon.player.playlist.drawernew.composable.d(p2, k1, k0, z, z1);
                    p0.l0(d1);
                    d0 = d1;
                }
                else {
                    n1 = n0;
                    p2 = p1;
                }
                c1.o(q4, f0, j00, false, null, null, null, false, d0, p0, 0, 0xF8);
                q q5 = d.c(n1, 1.0f);
                q q6 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, r0.d.f);
                AppScrollbarsKt.DraggableScrollbar(f0, scrollbarState0, ThumbExtKt.rememberDraggableScroller(f0, list0.size(), p0, 0), q6, p0, 0, 0);
                p0.p(false);
                q7 = q1;
                v5 = v3;
            }
            else {
                p2 = p1;
                if(s.equals("GRID")) {
                    p0.a0(0xDDF6BB9C);
                    q7 = q1;
                    v5 = v3;
                    c.a(fillElement0, null, false, m0.c.e(0x2A8CE2F3, p0, new Dc.a(list0, k1, k0, z1, 3)), p0, 0xC06, 6);
                }
                else {
                    q7 = q1;
                    v5 = v3;
                    p0.a0(0xDDA1CFA6);
                }
                p0.p(false);
            }
            p0.p(true);
            boolean z2 = p0.i(list0);
            com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.2.1 drawerPlytListKt$DrawerPlytPlyt$2$10 = p0.N();
            if(z2 || drawerPlytListKt$DrawerPlytPlyt$2$10 == v5) {
                drawerPlytListKt$DrawerPlytPlyt$2$10 = new we.n(p2, list0, null) {
                    public final p r;
                    public final List w;

                    {
                        this.r = p0;
                        this.w = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.2.1(this.r, this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        this.r.clear();
                        this.r.addAll(this.w);
                        return H.a;
                    }
                };
                p0.l0(drawerPlytListKt$DrawerPlytPlyt$2$10);
            }
            J.d(p0, list0, drawerPlytListKt$DrawerPlytPlyt$2$10);
        }
        else {
            p0.T();
            q7 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new e(q7, list0, s, z, z1, s1, k0, k1, v, v1);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1 implements k {
            public final DrawerPlytWrapper a;
            public final k b;
            public final k c;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1(DrawerPlytWrapper drawerPlytWrapper0, k k0, k k1) {
                this.a = drawerPlytWrapper0;
                this.b = k0;
                this.c = k1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x)object0));
                return H.a;
            }

            public final void invoke(x x0) {
                kotlin.jvm.internal.q.g(x0, "$this$clearAndSetSemantics");
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1.1 drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$1$10 = new we.a() {
                    public final k a;
                    public final DrawerPlytWrapper b;

                    {
                        k k0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = k0;
                        this.b = drawerPlytWrapper0;
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        this.a.invoke(this.b);
                    }
                };
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1.2 drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$1$20 = new we.a() {
                    public final k a;
                    public final DrawerPlytWrapper b;

                    {
                        k k0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = k0;
                        this.b = drawerPlytWrapper0;
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        this.a.invoke(this.b);
                    }
                };
                DrawerPlytListItemKt.setDrawerPlaylistItemSemantics(x0, this.a.isSelect(), this.a.isPlaying(), this.a.getTitleForList(), this.a.getDesc(), drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$1$10, drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$1$20);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.2.1 implements we.a {
            public final k a;
            public final DrawerPlytWrapper b;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.2.1(k k0, DrawerPlytWrapper drawerPlytWrapper0) {
                this.a = k0;
                this.b = drawerPlytWrapper0;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                this.a.invoke(this.b);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.3.1 implements we.a {
            public final DrawerPlytWrapper a;
            public final k b;
            public final k c;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.3.1(DrawerPlytWrapper drawerPlytWrapper0, k k0, k k1) {
                this.a = drawerPlytWrapper0;
                this.b = k0;
                this.c = k1;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                DrawerPlytWrapper drawerPlytWrapper0 = this.a;
                k k0 = this.b;
                if(drawerPlytWrapper0.isSelect()) {
                    k0.invoke(drawerPlytWrapper0);
                    return;
                }
                if(!AppUtils.isAccessibilityTalkbackOn()) {
                    k0.invoke(drawerPlytWrapper0);
                    return;
                }
                this.c.invoke(drawerPlytWrapper0);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1 implements k {
            public final DrawerPlytWrapper a;
            public final k b;
            public final k c;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1(DrawerPlytWrapper drawerPlytWrapper0, k k0, k k1) {
                this.a = drawerPlytWrapper0;
                this.b = k0;
                this.c = k1;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((x)object0));
                return H.a;
            }

            public final void invoke(x x0) {
                kotlin.jvm.internal.q.g(x0, "$this$clearAndSetSemantics");
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1.1 drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$1$10 = new we.a() {
                    public final k a;
                    public final DrawerPlytWrapper b;

                    {
                        k k0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = k0;
                        this.b = drawerPlytWrapper0;
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        this.a.invoke(this.b);
                    }
                };
                com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1.2 drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$1$20 = new we.a() {
                    public final k a;
                    public final DrawerPlytWrapper b;

                    {
                        k k0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = k0;
                        this.b = drawerPlytWrapper0;
                    }

                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        this.a.invoke(this.b);
                    }
                };
                DrawerPlytListItemKt.setDrawerPlaylistItemSemantics(x0, this.a.isSelect(), this.a.isPlaying(), this.a.getTitleForList(), this.a.getDesc(), drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$1$10, drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$1$20);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.2.1 implements we.a {
            public final k a;
            public final DrawerPlytWrapper b;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.2.1(k k0, DrawerPlytWrapper drawerPlytWrapper0) {
                this.a = k0;
                this.b = drawerPlytWrapper0;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                this.a.invoke(this.b);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.3.1 implements we.a {
            public final DrawerPlytWrapper a;
            public final k b;
            public final k c;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.3.1(DrawerPlytWrapper drawerPlytWrapper0, k k0, k k1) {
                this.a = drawerPlytWrapper0;
                this.b = k0;
                this.c = k1;
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                DrawerPlytWrapper drawerPlytWrapper0 = this.a;
                k k0 = this.b;
                if(drawerPlytWrapper0.isSelect()) {
                    k0.invoke(drawerPlytWrapper0);
                    return;
                }
                if(!AppUtils.isAccessibilityTalkbackOn()) {
                    k0.invoke(drawerPlytWrapper0);
                    return;
                }
                this.c.invoke(drawerPlytWrapper0);
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.1 extends r implements k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "LP/m;", "", "it", "LP/b;", "invoke-_-orMbw", "(LP/m;I)J", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.2 extends r implements we.n {
            public final o f;
            public final List g;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.2(o o0, List list0) {
                this.f = o0;
                this.g = list0;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return new P.b(this.invoke-_-orMbw(((m)object0), ((Number)object1).intValue()));
            }

            public final long invoke-_-orMbw(m m0, int v) {
                Object object0 = this.g.get(v);
                return ((P.b)this.f.invoke(m0, v, object0)).a;
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.3 extends r implements k {
            public final List f;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.3(List list0) {
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


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "LP/k;", "", "it", "Lie/H;", "invoke", "(LP/k;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.4 extends r implements we.p {
            public final List f;
            public final k g;
            public final k h;
            public final boolean i;
            public final v j;
            public final int k;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.14.lambda.13.lambda.12..inlined.itemsIndexed.default.4(List list0, k k0, k k1, boolean z, v v0, int v1) {
                this.f = list0;
                this.g = k0;
                this.h = k1;
                this.i = z;
                this.j = v0;
                this.k = v1;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((P.k)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(P.k k0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(k0) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)l0).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    Object object0 = this.f.get(v);
                    ((androidx.compose.runtime.p)l0).a0(1662247870);
                    boolean z = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    k k1 = this.g;
                    boolean z1 = ((androidx.compose.runtime.p)l0).g(k1);
                    k k2 = this.h;
                    boolean z2 = ((androidx.compose.runtime.p)l0).g(k2);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1 drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$10 = ((androidx.compose.runtime.p)l0).N();
                    V v3 = androidx.compose.runtime.k.a;
                    if((z | z1 | z2) != 0 || drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.1.1(((DrawerPlytWrapper)object0), k1, k2);
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$10);
                    }
                    q q0 = X0.n.b(n.a, drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$1$10);
                    int v4 = (int)(((androidx.compose.foundation.layout.c)this.j).a.R(r1.a.j(((androidx.compose.foundation.layout.c)this.j).b)) / ((float)this.k));
                    boolean z3 = ((androidx.compose.runtime.p)l0).g(k2);
                    boolean z4 = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.2.1 drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$2$10 = ((androidx.compose.runtime.p)l0).N();
                    if(z3 || z4 || drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$2$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$2$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.2.1(k2, ((DrawerPlytWrapper)object0));
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$2$10);
                    }
                    boolean z5 = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    boolean z6 = ((androidx.compose.runtime.p)l0).g(k1);
                    boolean z7 = ((androidx.compose.runtime.p)l0).g(k2);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.3.1 drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$3$10 = ((androidx.compose.runtime.p)l0).N();
                    if((z5 | z6 | z7) != 0 || drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$3$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$3$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.2.1.1.1.3.1(((DrawerPlytWrapper)object0), k1, k2);
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$3$10);
                    }
                    DrawerPlytListItemKt.DrawerPlytListItemGrid(q0, ((DrawerPlytWrapper)object0), this.i, v4, drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$2$10, drawerPlytListKt$DrawerPlytPlyt$1$2$1$1$1$3$10, ((androidx.compose.runtime.p)l0), 0, 0);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return;
                }
                ((androidx.compose.runtime.p)l0).T();
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.1 extends r implements k {
            public final we.n f;
            public final List g;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.1(we.n n0, List list0) {
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
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.2 extends r implements k {
            public final List f;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.2(List list0) {
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
        public final class com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.3 extends r implements we.p {
            public final List f;
            public final k g;
            public final k h;
            public final boolean i;
            public final boolean j;

            public com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.lambda.15.lambda.7.lambda.6..inlined.itemsIndexed.default.3(List list0, k k0, k k1, boolean z, boolean z1) {
                this.f = list0;
                this.g = k0;
                this.h = k1;
                this.i = z;
                this.j = z1;
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
                    ((androidx.compose.runtime.p)l0).a0(0x22D06C4D);
                    boolean z = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    k k0 = this.g;
                    boolean z1 = ((androidx.compose.runtime.p)l0).g(k0);
                    k k1 = this.h;
                    boolean z2 = ((androidx.compose.runtime.p)l0).g(k1);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1 drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$10 = ((androidx.compose.runtime.p)l0).N();
                    V v3 = androidx.compose.runtime.k.a;
                    if((z | z1 | z2) != 0 || drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.1.1(((DrawerPlytWrapper)object0), k0, k1);
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$10);
                    }
                    q q0 = X0.n.b(n.a, drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$1$10);
                    boolean z3 = ((androidx.compose.runtime.p)l0).g(k1);
                    boolean z4 = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.2.1 drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$2$10 = ((androidx.compose.runtime.p)l0).N();
                    if(z3 || z4 || drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$2$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$2$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.2.1(k1, ((DrawerPlytWrapper)object0));
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$2$10);
                    }
                    boolean z5 = ((androidx.compose.runtime.p)l0).i(((DrawerPlytWrapper)object0));
                    boolean z6 = ((androidx.compose.runtime.p)l0).g(k0);
                    boolean z7 = ((androidx.compose.runtime.p)l0).g(k1);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.3.1 drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$3$10 = ((androidx.compose.runtime.p)l0).N();
                    if((z5 | z6 | z7) != 0 || drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$3$10 == v3) {
                        drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$3$10 = new com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt.DrawerPlytPlyt.1.1.1.1.3.1(((DrawerPlytWrapper)object0), k0, k1);
                        ((androidx.compose.runtime.p)l0).l0(drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$3$10);
                    }
                    DrawerPlytListItemKt.DrawerPlytListItemDefault(q0, ((DrawerPlytWrapper)object0), this.i, this.j, 58, drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$2$10, drawerPlytListKt$DrawerPlytPlyt$1$1$1$1$3$10, ((androidx.compose.runtime.p)l0), 0x6000, 0);
                    ((androidx.compose.runtime.p)l0).p(false);
                    return;
                }
                ((androidx.compose.runtime.p)l0).T();
            }
        }

    }
}

