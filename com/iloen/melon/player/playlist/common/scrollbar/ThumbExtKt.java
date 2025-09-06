package com.iloen.melon.player.playlist.common.scrollbar;

import O.F;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\'\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\'\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\b2\u0006\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\t¨\u0006\f²\u0006\u000E\u0010\n\u001A\u00020\u00048\n@\nX\u008A\u008E\u0002²\u0006\f\u0010\u000B\u001A\u00020\u00018\nX\u008A\u0084\u0002"}, d2 = {"LO/F;", "", "itemsAvailable", "Lkotlin/Function1;", "", "Lie/H;", "rememberDraggableScroller", "(LO/F;ILandroidx/compose/runtime/l;I)Lwe/k;", "LP/F;", "(LP/F;ILandroidx/compose/runtime/l;I)Lwe/k;", "percentage", "itemCount", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ThumbExtKt {
    public static final float access$rememberDraggableScroller$lambda-2(Z z0) {
        return ((I0)z0).m();
    }

    public static final void access$rememberDraggableScroller$lambda-3(Z z0, float f) {
        ((I0)z0).n(f);
    }

    public static final int access$rememberDraggableScroller$lambda-4(b1 b10) {
        return ((Number)b10.getValue()).intValue();
    }

    @NotNull
    public static final k rememberDraggableScroller(@NotNull F f0, int v, @Nullable l l0, int v1) {
        q.g(f0, "<this>");
        Z z0 = ((p)l0).N();
        V v2 = androidx.compose.runtime.k.a;
        if(z0 == v2) {
            z0 = w.o(NaNf);
            ((p)l0).l0(z0);
        }
        b0 b00 = w.w(v, ((p)l0));
        J.d(((p)l0), ((I0)z0).m(), new n(z0, b00, null, f0) {
            public final b1 B;
            public final F D;
            public int r;
            public final Z w;

            {
                this.w = z0;
                this.B = b10;
                this.D = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt.rememberDraggableScroller..inlined.rememberDraggableScroller.1(this.w, this.B, continuation0, this.D);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt.rememberDraggableScroller..inlined.rememberDraggableScroller.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                H h0 = H.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Z z0 = this.w;
                        if(!Float.isNaN(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0))) {
                            float f = (float)ThumbExtKt.access$rememberDraggableScroller$lambda-4(this.B);
                            int v = ye.a.V(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0) * f);
                            this.r = 1;
                            if(this.D.j(v, 0, this) == a0) {
                                return a0;
                            }
                        }
                        return h0;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
        ThumbExtKt.rememberDraggableScroller.4.1 thumbExtKt$rememberDraggableScroller$4$10 = ((p)l0).N();
        if(thumbExtKt$rememberDraggableScroller$4$10 == v2) {
            thumbExtKt$rememberDraggableScroller$4$10 = new ThumbExtKt.rememberDraggableScroller.4.1(z0);
            ((p)l0).l0(thumbExtKt$rememberDraggableScroller$4$10);
        }
        return thumbExtKt$rememberDraggableScroller$4$10;
    }

    @NotNull
    public static final k rememberDraggableScroller(@NotNull P.F f0, int v, @Nullable l l0, int v1) {
        q.g(f0, "<this>");
        Z z0 = ((p)l0).N();
        V v2 = androidx.compose.runtime.k.a;
        if(z0 == v2) {
            z0 = w.o(NaNf);
            ((p)l0).l0(z0);
        }
        b0 b00 = w.w(v, ((p)l0));
        J.d(((p)l0), ((I0)z0).m(), new n(z0, b00, null, f0) {
            public final b1 B;
            public final P.F D;
            public int r;
            public final Z w;

            {
                this.w = z0;
                this.B = b10;
                this.D = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt.rememberDraggableScroller..inlined.rememberDraggableScroller.2(this.w, this.B, continuation0, this.D);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt.rememberDraggableScroller..inlined.rememberDraggableScroller.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                H h0 = H.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Z z0 = this.w;
                        if(!Float.isNaN(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0))) {
                            float f = (float)ThumbExtKt.access$rememberDraggableScroller$lambda-4(this.B);
                            int v = ye.a.V(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0) * f);
                            this.r = 1;
                            if(P.F.i(this.D, v, this) == a0) {
                                return a0;
                            }
                        }
                        return h0;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
        ThumbExtKt.rememberDraggableScroller.4.1 thumbExtKt$rememberDraggableScroller$4$10 = ((p)l0).N();
        if(thumbExtKt$rememberDraggableScroller$4$10 == v2) {
            thumbExtKt$rememberDraggableScroller$4$10 = new ThumbExtKt.rememberDraggableScroller.4.1(z0);
            ((p)l0).l0(thumbExtKt$rememberDraggableScroller$4$10);
        }
        return thumbExtKt$rememberDraggableScroller$4$10;
    }
}

