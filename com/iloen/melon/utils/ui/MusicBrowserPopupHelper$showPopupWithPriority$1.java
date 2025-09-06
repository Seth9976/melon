package com.iloen.melon.utils.ui;

import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MainNoticePopupReq.Params;
import com.iloen.melon.net.v4x.request.MainNoticePopupReq;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes;
import e1.u;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$showPopupWithPriority$1", f = "MusicBrowserPopupHelper.kt", l = {585}, m = "invokeSuspend")
final class MusicBrowserPopupHelper.showPopupWithPriority.1 extends i implements n {
    public int r;
    public final MusicBrowserPopupHelper w;

    public MusicBrowserPopupHelper.showPopupWithPriority.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        this.w = musicBrowserPopupHelper0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new MusicBrowserPopupHelper.showPopupWithPriority.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MusicBrowserPopupHelper.showPopupWithPriority.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = u.v(((e0)o.a()).j());
                this.r = 1;
                object0 = MusicBrowserPopupHelper.access$getBannedJson(musicBrowserPopupHelper0, s, "NOTICE", this);
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
        Params mainNoticePopupReq$Params0 = new Params();
        mainNoticePopupReq$Params0.notibannings = (String)object0;
        MusicBrowserPopupHelper.access$dismissNoticePopup(musicBrowserPopupHelper0);
        musicBrowserPopupHelper0.n.setValue(Boolean.TRUE);
        RequestBuilder.newInstance(new MainNoticePopupReq(musicBrowserPopupHelper0.getActivity(), mainNoticePopupReq$Params0)).tag("MusicBrowserPopupHelper").listener(new k(musicBrowserPopupHelper0, 0)).errorListener(new k(musicBrowserPopupHelper0, 5)).request();
        return H.a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$showPopupWithPriority$1$1$1", f = "MusicBrowserPopupHelper.kt", l = {601}, m = "invokeSuspend")
        final class com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showPopupWithPriority.1.1.1 extends i implements n {
            public final MainNoticePopupRes B;
            public int r;
            public final MusicBrowserPopupHelper w;

            public com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showPopupWithPriority.1.1.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, MainNoticePopupRes mainNoticePopupRes0, Continuation continuation0) {
                this.w = musicBrowserPopupHelper0;
                this.B = mainNoticePopupRes0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showPopupWithPriority.1.1.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showPopupWithPriority.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        object0 = MusicBrowserPopupHelper.access$showNoticePopup(musicBrowserPopupHelper0, this.B, this);
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
                if(!((Boolean)object0).booleanValue()) {
                    MusicBrowserPopupHelper.access$showMixUpMalrangGuidePopup(musicBrowserPopupHelper0);
                }
                return H.a;
            }
        }

    }
}

