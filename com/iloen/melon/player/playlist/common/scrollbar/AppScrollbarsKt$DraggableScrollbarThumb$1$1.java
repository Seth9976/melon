package com.iloen.melon.player.playlist.common.scrollbar;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.common.scrollbar.AppScrollbarsKt$DraggableScrollbarThumb$1$1", f = "AppScrollbars.kt", l = {110}, m = "invokeSuspend")
final class AppScrollbarsKt.DraggableScrollbarThumb.1.1 extends i implements n {
    public final b0 B;
    public int r;
    public final boolean w;

    public AppScrollbarsKt.DraggableScrollbarThumb.1.1(b0 b00, Continuation continuation0, boolean z) {
        this.w = z;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new AppScrollbarsKt.DraggableScrollbarThumb.1.1(this.B, continuation0, this.w);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((AppScrollbarsKt.DraggableScrollbarThumb.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(this.w) {
                    AppScrollbarsKt.access$DraggableScrollbarThumb$lambda$5(b00, ThumbState.Active);
                    return H.a;
                }
                if(AppScrollbarsKt.access$DraggableScrollbarThumb$lambda$4(b00) == ThumbState.Active) {
                    AppScrollbarsKt.access$DraggableScrollbarThumb$lambda$5(b00, ThumbState.Inactive);
                    this.r = 1;
                    if(DelayKt.delay(2000L, this) == a0) {
                        return a0;
                    }
                    AppScrollbarsKt.access$DraggableScrollbarThumb$lambda$5(b00, ThumbState.Dormant);
                    return H.a;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                AppScrollbarsKt.access$DraggableScrollbarThumb$lambda$5(b00, ThumbState.Dormant);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

