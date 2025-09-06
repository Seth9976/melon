package com.iloen.melon.player.video;

import M6.B;
import com.iloen.melon.constants.LiveStatusCode;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.player.video.cheer.CheerAnimationCnt;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kc.E2;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.e;
import oe.i;
import okhttp3.internal.Util;
import uc.j;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.LiveViewModel$updateLiveRes$1", f = "LiveViewModel.kt", l = {0x101}, m = "invokeSuspend")
final class LiveViewModel.updateLiveRes.1 extends i implements n {
    public final String B;
    public int r;
    public final LiveViewModel w;

    public LiveViewModel.updateLiveRes.1(LiveViewModel liveViewModel0, String s, Continuation continuation0) {
        this.w = liveViewModel0;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new LiveViewModel.updateLiveRes.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((LiveViewModel.updateLiveRes.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        String s;
        a a0 = a.a;
        LiveViewModel liveViewModel0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d3 d30 = (d3)liveViewModel0.getPlaylistManager();
                E2 e20 = new E2(d30, null);
                B b0 = ListenableFutureKt.future$default(d30.b, null, null, e20, 3, null);
                this.r = 1;
                object0 = ListenableFutureKt.await(b0, this);
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
        LiveDetailRes liveDetailRes0 = ((j)(((uc.a)object0))).c().c;
        H h0 = H.a;
        if(liveDetailRes0 != null) {
            LiveViewModel.access$get_liveRes$p(liveViewModel0).setValue(liveDetailRes0);
            MutableStateFlow mutableStateFlow0 = LiveViewModel.access$get_viewCnt$p(liveViewModel0);
            Response liveDetailRes$Response0 = liveDetailRes0.response;
            if(liveDetailRes$Response0 == null) {
                s = "";
            }
            else {
                Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
                if(liveDetailRes$Response$Live0 == null) {
                    s = "";
                }
                else {
                    s = liveDetailRes$Response$Live0.viewCnt;
                    if(s == null) {
                        s = "";
                    }
                }
            }
            mutableStateFlow0.setValue(s);
            Response liveDetailRes$Response1 = liveDetailRes0.response;
            long v = 0L;
            if(liveDetailRes$Response1 != null) {
                Live liveDetailRes$Response$Live1 = liveDetailRes$Response1.live;
                if(liveDetailRes$Response$Live1 != null) {
                    String s1 = liveDetailRes$Response$Live1.likeCnt;
                    if(s1 != null) {
                        v = Util.toLongOrDefault(s1, 0L);
                    }
                }
            }
            Response liveDetailRes$Response2 = liveDetailRes0.response;
            if(liveDetailRes$Response2 == null) {
                z = false;
            }
            else {
                Live liveDetailRes$Response$Live2 = liveDetailRes$Response2.live;
                z = liveDetailRes$Response$Live2 == null ? false : liveDetailRes$Response$Live2.isCheer;
            }
            LiveViewModel.access$get_pollingAble$p(liveViewModel0).setValue(Boolean.valueOf(z));
            liveViewModel0.setIgnoreCheerUnit(CheerAnimationCnt.Companion.convertCheerAnimationCnt(v));
            LogU.Companion.d("LiveViewModel", "ignoreCheerable set = " + liveViewModel0.getIgnoreCheerUnit());
            LiveViewModel.access$setLikeCntNum(liveViewModel0, v);
            LiveViewModel.access$getPollingManager(liveViewModel0).setTotalCnt(LiveViewModel.access$getLikeCntNum$p(liveViewModel0));
            if(liveDetailRes0.response.live.liveStatusCode == LiveStatusCode.LiveStreaming) {
                LiveViewModel.access$getPollingManager(liveViewModel0).startPolling(this.B);
            }
        }
        return h0;
    }
}

