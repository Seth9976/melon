package com.iloen.melon.player.playlist.common.scrollbar;

import I.F;
import I.Z0;
import I.u0;
import J0.y;
import K.l;
import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import P0.h;
import P0.i;
import P0.j;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.layout.a;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import je.x;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.q;
import we.k;
import we.n;
import x0.b;

@Metadata(d1 = {"\u0000d\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001D\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u001B\u0010\u000B\u001A\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001A\u001B\u0010\u000B\u001A\u00020\u000E*\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0000¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u001B\u0010\u000B\u001A\u00020\u000E*\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0010\u001A]\u0010#\u001A\u00020\u001D2\u0006\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010\u0017\u001A\u00020\u00162\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001B\u001A\u00020\u001A2\u0016\b\u0002\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001D\u0018\u00010\u001C2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001D0\u001FH\u0007¢\u0006\u0004\b!\u0010\"¨\u0006(²\u0006\u000E\u0010$\u001A\u00020\u00078\n@\nX\u008A\u008E\u0002²\u0006\u000E\u0010%\u001A\u00020\u00008\n@\nX\u008A\u008E\u0002²\u0006\u000E\u0010\'\u001A\u00020&8\n@\nX\u008A\u008E\u0002"}, d2 = {"", "thumbSizePercent", "thumbMovedPercent", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarStateValue;", "scrollbarStateValue", "(FF)J", "LI/u0;", "Lx0/b;", "offset", "valueOf-Uv8p0NA", "(LI/u0;J)F", "valueOf", "Lr1/l;", "intSize", "", "valueOf-O0kMr_c", "(LI/u0;J)I", "Lr1/j;", "intOffset", "valueOf-I_oMVgE", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "state", "Lr0/q;", "modifier", "LK/l;", "interactionSource", "Lr1/f;", "minThumbSize", "Lkotlin/Function1;", "Lie/H;", "onThumbMoved", "Lkotlin/Function0;", "thumb", "Scrollbar-jIwJxvA", "(Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;Lr0/q;LK/l;FLwe/k;Lwe/n;Landroidx/compose/runtime/l;II)V", "Scrollbar", "draggedOffset", "interactionThumbTravelPercent", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarTrack;", "track", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ScrollbarKt {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[u0.values().length];
            try {
                arr_v[1] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final void Scrollbar-jIwJxvA(@NotNull ScrollbarState scrollbarState0, @Nullable q q0, @Nullable l l0, float f, @Nullable k k0, @NotNull n n0, @Nullable androidx.compose.runtime.l l1, int v, int v1) {
        q q9;
        float f3;
        k k2;
        l l3;
        c c0;
        n0 n00;
        h h4;
        float f2;
        q q5;
        com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.3.1 scrollbarKt$Scrollbar$3$10;
        q q2;
        float f1;
        kotlin.jvm.internal.q.g(scrollbarState0, "state");
        kotlin.jvm.internal.q.g(n0, "thumb");
        p p0 = (p)l1;
        p0.c0(0xB88E26C2);
        int v2 = (v & 6) == 0 ? (p0.g(scrollbarState0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.g(l0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
            f1 = f;
        }
        else if((v & 0xC00) == 0) {
            f1 = f;
            v2 |= (p0.d(f1) ? 0x800 : 0x400);
        }
        else {
            f1 = f;
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.i(k0) ? 0x4000 : 0x2000);
        }
        if((v & 0x30000) == 0) {
            v2 |= (p0.i(n0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (v2 & 74899) != 74898)) {
            r0.n n1 = r0.n.a;
            q q1 = (v1 & 2) == 0 ? q0 : n1;
            l l2 = (v1 & 4) == 0 ? l0 : null;
            if((v1 & 8) != 0) {
                f1 = 40.0f;
            }
            k k1 = (v1 & 16) == 0 ? k0 : null;
            b0 b00 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(new b(0x7FC000007FC00000L));
                p0.l0(b00);
            }
            Z z0 = p0.N();
            if(z0 == v3) {
                z0 = w.o(NaNf);
                p0.l0(z0);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.s(ScrollbarTrack.box-impl(0L));
                p0.l0(b01);
            }
            if(l2 == null) {
                q2 = q1;
            }
            else {
                q2 = androidx.compose.foundation.q.r(q1, l2);
                if(q2 == null) {
                    q2 = q1;
                }
            }
            q q3 = d.c(q2, 1.0f);
            com.iloen.melon.player.playlist.common.scrollbar.b b0 = p0.N();
            if(b0 == v3) {
                b0 = new com.iloen.melon.player.playlist.common.scrollbar.b(b01);
                p0.l0(b0);
            }
            q q4 = a.d(q3, b0);
            Object object0 = p0.N();
            if((((v2 & 0x380) == 0x100 ? 1 : 0) | (((v2 & 0x1C00) == 0x800 ? 1 : 0) | ((v2 & 14) == 4 ? 1 : 0))) != 0 || object0 == v3) {
                q5 = q1;
                f2 = f1;
                scrollbarKt$Scrollbar$3$10 = new PointerInputEventHandler() {
                    public final ScrollbarState a;
                    public final float b;
                    public final l c;
                    public final b0 d;
                    public final b0 e;

                    {
                        ScrollbarState scrollbarState0 = scrollbarState0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        float f = f2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        l l0 = l2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        b0 b00 = b01;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        b0 b01 = b00;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = scrollbarState0;
                        this.b = f;
                        this.c = l0;
                        this.d = b00;
                        this.e = b01;
                    }

                    @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(y y0, Continuation continuation0) {
                        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        cd.h h1 = new cd.h(this.a, y0, this.b, h0, this.c, this.d, this.e);
                        ie.H h2 = Z0.c(y0, new F(null, new com.iloen.melon.player.playlist.common.scrollbar.d(h0, this.c, this.e, 0), new com.iloen.melon.player.playlist.common.scrollbar.d(h0, this.c, this.e, 1), h1, new e(this.e)), continuation0);
                        ne.a a0 = ne.a.a;
                        ie.H h3 = ie.H.a;
                        if(h2 != a0) {
                            h2 = h3;
                        }
                        return h2 == a0 ? h2 : h3;
                    }
                };
                p0.l0(scrollbarKt$Scrollbar$3$10);
            }
            else {
                scrollbarKt$Scrollbar$3$10 = object0;
                q5 = q1;
                f2 = f1;
            }
            q q6 = J0.H.a(q4, ie.H.a, scrollbarKt$Scrollbar$3$10);
            M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q7 = r0.a.d(p0, q6);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            ie.H h0 = ie.H.a;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h1 = j.f;
            w.x(p0, m0, h1);
            h h2 = j.e;
            w.x(p0, i00, h2);
            h h3 = j.g;
            if(p0.O) {
                h4 = h2;
                A7.d.q(v4, p0, v4, h3);
            }
            else {
                h4 = h2;
                if(!kotlin.jvm.internal.q.b(p0.N(), v4)) {
                    A7.d.q(v4, p0, v4, h3);
                }
            }
            h h5 = j.d;
            w.x(p0, q7, h5);
            com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.4.2.1 scrollbarKt$Scrollbar$4$2$10 = p0.N();
            if((((v2 & 14) == 4 ? 1 : 0) | ((v2 & 0x1C00) == 0x800 ? 1 : 0)) != 0 || scrollbarKt$Scrollbar$4$2$10 == v3) {
                scrollbarKt$Scrollbar$4$2$10 = new M() {
                    public final ScrollbarState a;
                    public final float b;
                    public final b0 c;
                    public final Z d;

                    {
                        ScrollbarState scrollbarState0 = scrollbarState0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        float f = f2;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        b0 b00 = b01;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        Z z0 = z0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = scrollbarState0;
                        this.b = f;
                        this.c = b00;
                        this.d = z0;
                    }

                    @Override  // N0.M
                    public int maxIntrinsicHeight(N0.q q0, List list0, int v) {
                        return M.super.maxIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int maxIntrinsicWidth(N0.q q0, List list0, int v) {
                        return M.super.maxIntrinsicWidth(q0, list0, v);
                    }

                    @Override  // N0.M
                    public final N measure-3p2s80s(O o0, List list0, long v) {
                        kotlin.jvm.internal.q.g(o0, "$this$Layout");
                        kotlin.jvm.internal.q.g(list0, "measurables");
                        L l0 = (L)je.p.k0(list0);
                        float f = this.a.getThumbSizePercent();
                        float f1 = Math.max(ScrollbarKt.access$getSize-GRq-Twk(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$7(this.c)) * f, o0.Y(this.b));
                        float f2 = this.a.getThumbTrackSizePercent() == 0.0f ? ScrollbarKt.access$getSize-GRq-Twk(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$7(this.c)) : (ScrollbarKt.access$getSize-GRq-Twk(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$7(this.c)) - f1) / this.a.getThumbTrackSizePercent();
                        int v1 = ye.a.V(Math.max(Math.min((Float.isNaN(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$4(this.d)) ? this.a.getThumbMovedPercent() : ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$4(this.d)), this.a.getThumbTrackSizePercent()), 0.0f) * f2);
                        a0 a00 = l0.O(r1.a.a(v, 0, 0, ye.a.V(f1), ye.a.V(f1), 3));
                        int v2 = a00.a;
                        int v3 = a00.b;
                        C8.e e0 = new C8.e(a00, v1, 8);
                        return o0.w(v2, v3, x.a, e0);
                    }

                    @Override  // N0.M
                    public int minIntrinsicHeight(N0.q q0, List list0, int v) {
                        return M.super.minIntrinsicHeight(q0, list0, v);
                    }

                    @Override  // N0.M
                    public int minIntrinsicWidth(N0.q q0, List list0, int v) {
                        return M.super.minIntrinsicWidth(q0, list0, v);
                    }
                };
                p0.l0(scrollbarKt$Scrollbar$4$2$10);
            }
            int v5 = p0.P;
            i0 i01 = p0.m();
            q q8 = r0.a.d(p0, n1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, scrollbarKt$Scrollbar$4$2$10, h1);
            w.x(p0, i01, h4);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            w.x(p0, q8, h5);
            n0.invoke(p0, ((int)(v2 >> 15 & 14)));
            boolean z1 = true;
            p0.p(true);
            p0.p(true);
            if(k1 == null) {
                n00 = p0.t();
                if(n00 != null) {
                    c0 = new c(scrollbarState0, q5, l2, f2, null, n0, v, v1, 0);
                    n00.d = c0;
                }
            }
            else {
                l3 = l2;
                k2 = k1;
                if((v2 & 0xE000) != 0x4000) {
                    z1 = false;
                }
                com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.6.1 scrollbarKt$Scrollbar$6$10 = p0.N();
                if(z1 || scrollbarKt$Scrollbar$6$10 == v3) {
                    scrollbarKt$Scrollbar$6$10 = new n(b00, k2, z0, b01, null) {
                        public final k B;
                        public final Z D;
                        public final b0 E;
                        public int r;
                        public final b0 w;

                        {
                            this.w = b00;
                            this.B = k0;
                            this.D = z0;
                            this.E = b01;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.6.1(this.w, this.B, this.D, this.E, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.6.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.r) {
                                case 0: {
                                    d5.n.D(object0);
                                    Flow flow0 = w.y(new f(this.w));
                                    com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt.Scrollbar.6.1.2 scrollbarKt$Scrollbar$6$1$20 = new FlowCollector() {
                                        public final k a;
                                        public final Z b;
                                        public final b0 c;

                                        {
                                            k k0 = this.D;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                            Z z0 = this.E;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                            this.a = k0;
                                            this.b = z0;
                                            this.c = b00;
                                        }

                                        @Override  // kotlinx.coroutines.flow.FlowCollector
                                        public Object emit(Object object0, Continuation continuation0) {
                                            return this.emit-3MmeM6k(((b)object0).a, continuation0);
                                        }

                                        public final Object emit-3MmeM6k(long v, Continuation continuation0) {
                                            ie.H h0 = ie.H.a;
                                            Z z0 = this.b;
                                            if(b.b(v, 0x7FC000007FC00000L)) {
                                                ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$5(z0, NaNf);
                                                return h0;
                                            }
                                            float f = ScrollbarKt.access$thumbPosition-DX8FE2o(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$7(this.c), ScrollbarKt.valueOf-Uv8p0NA(u0.a, v));
                                            this.a.invoke(new Float(f));
                                            ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$5(z0, f);
                                            return h0;
                                        }
                                    };
                                    this.r = 1;
                                    return flow0.collect(scrollbarKt$Scrollbar$6$1$20, this) == a0 ? a0 : ie.H.a;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    return ie.H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    p0.l0(scrollbarKt$Scrollbar$6$10);
                }
                J.d(p0, h0, scrollbarKt$Scrollbar$6$10);
                f3 = f2;
                q9 = q5;
                goto label_146;
            }
        }
        else {
            p0.T();
            q9 = q0;
            l3 = l0;
            f3 = f1;
            k2 = k0;
        label_146:
            n00 = p0.t();
            if(n00 != null) {
                c0 = new c(scrollbarState0, q9, l3, f3, k2, n0, v, v1, 1);
                n00.d = c0;
            }
        }
    }

    public static final long access$Scrollbar_jIwJxvA$lambda$1(b0 b00) {
        return ((b)b00.getValue()).a;
    }

    public static final void access$Scrollbar_jIwJxvA$lambda$2(b0 b00, long v) {
        b00.setValue(new b(v));
    }

    public static final float access$Scrollbar_jIwJxvA$lambda$4(Z z0) {
        return ((I0)z0).m();
    }

    public static final void access$Scrollbar_jIwJxvA$lambda$5(Z z0, float f) {
        ((I0)z0).n(f);
    }

    public static final long access$Scrollbar_jIwJxvA$lambda$7(b0 b00) {
        return ((ScrollbarTrack)b00.getValue()).unbox-impl();
    }

    public static final float access$getSize-GRq-Twk(long v) {
        return Float.intBitsToFloat(((int)(0xFFFFFFFFL & v))) - Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public static final float access$thumbPosition-DX8FE2o(long v, float f) {
        return Math.max(Math.min(f / (Float.intBitsToFloat(((int)(0xFFFFFFFFL & v))) - Float.intBitsToFloat(((int)(v >> 0x20)))), 1.0f), 0.0f);
    }

    public static final long scrollbarStateValue(float f, float f1) {
        return ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
    }

    public static final int valueOf-I_oMVgE(@NotNull u0 u00, long v) {
        kotlin.jvm.internal.q.g(u00, "$this$valueOf");
        switch(WhenMappings.$EnumSwitchMapping$0[u00.ordinal()]) {
            case 1: {
                return (int)(v >> 0x20);
            }
            case 2: {
                return (int)(v & 0xFFFFFFFFL);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final int valueOf-O0kMr_c(@NotNull u0 u00, long v) {
        kotlin.jvm.internal.q.g(u00, "$this$valueOf");
        switch(WhenMappings.$EnumSwitchMapping$0[u00.ordinal()]) {
            case 1: {
                return (int)(v >> 0x20);
            }
            case 2: {
                return (int)(v & 0xFFFFFFFFL);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static final float valueOf-Uv8p0NA(@NotNull u0 u00, long v) {
        kotlin.jvm.internal.q.g(u00, "$this$valueOf");
        switch(WhenMappings.$EnumSwitchMapping$0[u00.ordinal()]) {
            case 1: {
                return Float.intBitsToFloat(((int)(v >> 0x20)));
            }
            case 2: {
                return Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

