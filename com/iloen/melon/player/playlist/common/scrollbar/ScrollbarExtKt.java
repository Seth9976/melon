package com.iloen.melon.player.playlist.common.scrollbar;

import Cc.P0;
import I.u0;
import O.F;
import O.v;
import P.t;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A1\u0010\u0007\u001A\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A1\u0010\u0007\u001A\u00020\u0006*\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00012\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\u000B¨\u0006\f"}, d2 = {"LO/F;", "", "itemsAvailable", "Lkotlin/Function1;", "LO/v;", "itemIndex", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "scrollbarState", "(LO/F;ILwe/k;Landroidx/compose/runtime/l;II)Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "LP/F;", "LP/t;", "(LP/F;ILwe/k;Landroidx/compose/runtime/l;II)Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ScrollbarExtKt {
    @NotNull
    public static final ScrollbarState scrollbarState(@NotNull F f0, int v, @Nullable k k0, @Nullable l l0, int v1, int v2) {
        q.g(f0, "<this>");
        if((v2 & 2) != 0) {
            k0 = com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.1.INSTANCE;
        }
        ScrollbarState scrollbarState0 = ((p)l0).N();
        V v3 = androidx.compose.runtime.k.a;
        if(scrollbarState0 == v3) {
            scrollbarState0 = new ScrollbarState();
            ((p)l0).l0(scrollbarState0);
        }
        Integer integer0 = v;
        int v4 = 0;
        int v5 = ((v1 & 0x70 ^ 0x30) <= 0x20 || !((p)l0).e(v)) && (v1 & 0x30) != 0x20 ? 0 : 1;
        int v6 = ((v1 & 14 ^ 6) <= 4 || !((p)l0).g(f0)) && (v1 & 6) != 4 ? 0 : 1;
        if((v1 & 0x380 ^ 0x180) > 0x100 && ((p)l0).g(k0) || (v1 & 0x180) == 0x100) {
            v4 = 1;
        }
        com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.2.1 scrollbarExtKt$scrollbarState$2$10 = ((p)l0).N();
        if((v5 | v6 | v4) != 0 || scrollbarExtKt$scrollbarState$2$10 == v3) {
            scrollbarExtKt$scrollbarState$2$10 = new n(v, f0, k0, scrollbarState0, null) {
                public final F B;
                public final k D;
                public final ScrollbarState E;
                public int r;
                public final int w;

                {
                    this.w = v;
                    this.B = f0;
                    this.D = k0;
                    this.E = scrollbarState0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.2.1(this.w, this.B, this.D, this.E, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = FlowKt.distinctUntilChanged(FlowKt.filterNotNull(w.y(new P0(this.w, this.B, this.D, 7))));
                            com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.2.1.2 scrollbarExtKt$scrollbarState$2$1$20 = new FlowCollector() {
                                public final ScrollbarState a;

                                {
                                    this.a = scrollbarState0;
                                }

                                @Override  // kotlinx.coroutines.flow.FlowCollector
                                public Object emit(Object object0, Continuation continuation0) {
                                    return this.emit-oNeDkYs(((ScrollbarStateValue)object0).unbox-impl(), continuation0);
                                }

                                public final Object emit-oNeDkYs(long v, Continuation continuation0) {
                                    this.a.onScroll-L0Nbrkk$app_playstoreProdRelease(v);
                                    return H.a;
                                }
                            };
                            this.r = 1;
                            return flow0.collect(scrollbarExtKt$scrollbarState$2$1$20, this) == a0 ? a0 : H.a;
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
            ((p)l0).l0(scrollbarExtKt$scrollbarState$2$10);
        }
        J.f(f0, integer0, scrollbarExtKt$scrollbarState$2$10, ((p)l0));
        return scrollbarState0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.1 extends z {
            public static final com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.1 INSTANCE;

            static {
                com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.1.INSTANCE = new com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.1(v.class, "index", "getIndex()I", 0);  // 初始化器: Lkotlin/jvm/internal/z;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
            }

            @Override  // kotlin.jvm.internal.z
            public Object get(Object object0) {
                return ((v)object0).a;
            }
        }

    }

    @NotNull
    public static final ScrollbarState scrollbarState(@NotNull P.F f0, int v, @Nullable k k0, @Nullable l l0, int v1, int v2) {
        q.g(f0, "<this>");
        if((v2 & 2) != 0) {
            k0 = com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.3.INSTANCE;
        }
        ScrollbarState scrollbarState0 = ((p)l0).N();
        V v3 = androidx.compose.runtime.k.a;
        if(scrollbarState0 == v3) {
            scrollbarState0 = new ScrollbarState();
            ((p)l0).l0(scrollbarState0);
        }
        Integer integer0 = v;
        int v4 = 0;
        int v5 = ((v1 & 0x70 ^ 0x30) <= 0x20 || !((p)l0).e(v)) && (v1 & 0x30) != 0x20 ? 0 : 1;
        int v6 = ((v1 & 14 ^ 6) <= 4 || !((p)l0).g(f0)) && (v1 & 6) != 4 ? 0 : 1;
        if((v1 & 0x380 ^ 0x180) > 0x100 && ((p)l0).g(k0) || (v1 & 0x180) == 0x100) {
            v4 = 1;
        }
        com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.4.1 scrollbarExtKt$scrollbarState$4$10 = ((p)l0).N();
        if((v5 | v6 | v4) != 0 || scrollbarExtKt$scrollbarState$4$10 == v3) {
            scrollbarExtKt$scrollbarState$4$10 = new n(v, f0, k0, scrollbarState0, null) {
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                public static final class WhenMappings {
                    public static final int[] $EnumSwitchMapping$0;

                    static {
                        int[] arr_v = new int[u0.values().length];
                        try {
                            arr_v[0] = 1;
                        }
                        catch(NoSuchFieldError unused_ex) {
                        }
                        try {
                            arr_v[1] = 2;
                        }
                        catch(NoSuchFieldError unused_ex) {
                        }
                        WhenMappings.$EnumSwitchMapping$0 = arr_v;
                    }
                }

                public final P.F B;
                public final k D;
                public final ScrollbarState E;
                public int r;
                public final int w;

                {
                    this.w = v;
                    this.B = f0;
                    this.D = k0;
                    this.E = scrollbarState0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.4.1(this.w, this.B, this.D, this.E, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            Flow flow0 = FlowKt.distinctUntilChanged(FlowKt.filterNotNull(w.y(new P0(this.w, this.B, this.D, 8))));
                            com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.4.1.2 scrollbarExtKt$scrollbarState$4$1$20 = new FlowCollector() {
                                public final ScrollbarState a;

                                {
                                    this.a = scrollbarState0;
                                }

                                @Override  // kotlinx.coroutines.flow.FlowCollector
                                public Object emit(Object object0, Continuation continuation0) {
                                    return this.emit-oNeDkYs(((ScrollbarStateValue)object0).unbox-impl(), continuation0);
                                }

                                public final Object emit-oNeDkYs(long v, Continuation continuation0) {
                                    this.a.onScroll-L0Nbrkk$app_playstoreProdRelease(v);
                                    return H.a;
                                }
                            };
                            this.r = 1;
                            return flow0.collect(scrollbarExtKt$scrollbarState$4$1$20, this) == a0 ? a0 : H.a;
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
            ((p)l0).l0(scrollbarExtKt$scrollbarState$4$10);
        }
        J.f(f0, integer0, scrollbarExtKt$scrollbarState$4$10, ((p)l0));
        return scrollbarState0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.3 extends z {
            public static final com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.3 INSTANCE;

            static {
                com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.3.INSTANCE = new com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt.scrollbarState.3(t.class, "index", "getIndex()I", 0);  // 初始化器: Lkotlin/jvm/internal/z;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
            }

            @Override  // kotlin.jvm.internal.z
            public Object get(Object object0) {
                return ((t)object0).a;
            }
        }

    }
}

