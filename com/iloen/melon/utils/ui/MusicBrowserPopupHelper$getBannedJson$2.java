package com.iloen.melon.utils.ui;

import Ra.d;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$getBannedJson$2", f = "MusicBrowserPopupHelper.kt", l = {0xBB}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.getBannedJson.2 extends i implements n {
    public final String B;
    public final String D;
    public final ArrayList E;
    public int r;
    public final MusicBrowserPopupHelper w;

    public MusicBrowserPopupHelper.getBannedJson.2(MusicBrowserPopupHelper musicBrowserPopupHelper0, String s, String s1, ArrayList arrayList0, Continuation continuation0) {
        this.w = musicBrowserPopupHelper0;
        this.B = s;
        this.D = s1;
        this.E = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.getBannedJson.2(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.getBannedJson.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.w);
                this.r = 1;
                object0 = d0.b(this.B, this.D, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Iterator iterator0 = ((Iterable)object0).iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            this.E.add("");
        }
        return H.a;
    }
}

