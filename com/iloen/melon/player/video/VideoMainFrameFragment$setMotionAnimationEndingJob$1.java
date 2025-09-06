package com.iloen.melon.player.video;

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
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setMotionAnimationEndingJob$1", f = "VideoMainFrameFragment.kt", l = {699}, m = "invokeSuspend")
final class VideoMainFrameFragment.setMotionAnimationEndingJob.1 extends i implements n {
    public final MotionProgress B;
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setMotionAnimationEndingJob.1(VideoMainFrameFragment videoMainFrameFragment0, MotionProgress motionProgress0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        this.B = motionProgress0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setMotionAnimationEndingJob.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setMotionAnimationEndingJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(DelayKt.delay(500L, this) == a0) {
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
        VideoMainFrameFragment videoMainFrameFragment0 = this.w;
        boolean z = VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isPipMode();
        H h0 = H.a;
        if(!z && !videoMainFrameFragment0.getBinding().o.isTouching()) {
            int v = ((double)this.B.getProgress()) > 0.4 ? this.B.getEndId() : this.B.getStartId();
            if(v != -1) {
                videoMainFrameFragment0.getBinding().o.transitionToState(v);
            }
        }
        return h0;
    }
}

