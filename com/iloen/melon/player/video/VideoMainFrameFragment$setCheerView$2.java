package com.iloen.melon.player.video;

import com.iloen.melon.player.video.cheer.CheerAnimationCnt;
import com.iloen.melon.player.video.cheer.CheerAnimationManager;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setCheerView$2", f = "VideoMainFrameFragment.kt", l = {504}, m = "invokeSuspend")
final class VideoMainFrameFragment.setCheerView.2 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setCheerView.2(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setCheerView.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setCheerView.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = VideoMainFrameFragment.access$getLiveViewModel(this.w).getCntAnimation();
                com.iloen.melon.player.video.VideoMainFrameFragment.setCheerView.2.1 videoMainFrameFragment$setCheerView$2$10 = new n(null) {
                    public Object r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setCheerView.2.1(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(CheerAnimationCnt cheerAnimationCnt0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setCheerView.2.1)this.create(cheerAnimationCnt0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CheerAnimationCnt)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        CheerAnimationCnt cheerAnimationCnt0 = (CheerAnimationCnt)this.r;
                        d5.n.D(object0);
                        Companion logU$Companion0 = LogU.Companion;
                        logU$Companion0.d("VideoMainFrameFragment", "cheerAnimCnt collector() cheerAnimCnt = " + cheerAnimationCnt0);
                        VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                        boolean z = VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isMiniPlayerMode();
                        H h0 = H.a;
                        if(!z && !VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isPipMode()) {
                            if(cheerAnimationCnt0.getNum().length() == 0 || q.b(cheerAnimationCnt0.getNum(), "0")) {
                                logU$Companion0.d("VideoMainFrameFragment", "cheerAnimCnt collector(), cheerAnimCnt.num is Empty or 0");
                                return h0;
                            }
                            if(cheerAnimationCnt0.equals(VideoMainFrameFragment.access$getLiveViewModel(videoMainFrameFragment0).getIgnoreCheerUnit())) {
                                logU$Companion0.d("VideoMainFrameFragment", "cheerAnimCnt collector(), cheerAnimCnt == liveviewModel.ignoreCheerUnit");
                                return h0;
                            }
                            CheerAnimationManager cheerAnimationManager0 = VideoMainFrameFragment.access$getCheerAnimationManager$p(videoMainFrameFragment0);
                            if(cheerAnimationManager0 != null) {
                                cheerAnimationManager0.startCountAnim(cheerAnimationCnt0);
                            }
                        }
                        return h0;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$setCheerView$2$10, this) == a0 ? a0 : H.a;
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

