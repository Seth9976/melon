package com.iloen.melon.player.playlist.common.scrollbar;

import androidx.compose.runtime.Z;
import androidx.compose.runtime.b1;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt$rememberDraggableScroller$3", f = "ThumbExt.kt", l = {70}, m = "invokeSuspend")
public final class ThumbExtKt.rememberDraggableScroller.3 extends i implements n {
    public final Z B;
    public final b1 D;
    public int r;
    public final n w;

    public ThumbExtKt.rememberDraggableScroller.3(n n0, Z z0, b1 b10, Continuation continuation0) {
        this.w = n0;
        this.B = z0;
        this.D = b10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new ThumbExtKt.rememberDraggableScroller.3(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((ThumbExtKt.rememberDraggableScroller.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Z z0 = this.B;
                if(!Float.isNaN(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0))) {
                    float f = (float)ThumbExtKt.access$rememberDraggableScroller$lambda-4(this.D);
                    Integer integer0 = new Integer(ye.a.V(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0) * f));
                    this.r = 1;
                    if(this.w.invoke(integer0, this) == a0) {
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

    public final Object invokeSuspend$$forInline(Object object0) {
        Z z0 = this.B;
        boolean z1 = Float.isNaN(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0));
        H h0 = H.a;
        if(z1) {
            return h0;
        }
        float f = (float)ThumbExtKt.access$rememberDraggableScroller$lambda-4(this.D);
        Integer integer0 = ye.a.V(ThumbExtKt.access$rememberDraggableScroller$lambda-2(z0) * f);
        this.w.invoke(integer0, this);
        return h0;
    }
}

