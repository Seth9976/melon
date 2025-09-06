package com.iloen.melon.player.video;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setMotionAnimationChangeListener$1", f = "VideoMainFrameFragment.kt", l = {713}, m = "invokeSuspend")
final class VideoMainFrameFragment.setMotionAnimationChangeListener.1 extends i implements n {
    public final VideoMainFrameFragment B;
    public int r;
    public Object w;

    public VideoMainFrameFragment.setMotionAnimationChangeListener.1(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.B = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new VideoMainFrameFragment.setMotionAnimationChangeListener.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setMotionAnimationChangeListener.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = VideoMainFrameFragment.access$getVideoViewModel(this.B).getMotionProgress();
                com.iloen.melon.player.video.VideoMainFrameFragment.setMotionAnimationChangeListener.1.1 videoMainFrameFragment$setMotionAnimationChangeListener$1$10 = new n(coroutineScope0, null) {
                    public final CoroutineScope B;
                    public Object r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        this.B = coroutineScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setMotionAnimationChangeListener.1.1(this.w, this.B, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(MotionProgress motionProgress0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setMotionAnimationChangeListener.1.1)this.create(motionProgress0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((MotionProgress)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        MotionProgress motionProgress0 = (MotionProgress)this.r;
                        d5.n.D(object0);
                        VideoMainFrameFragment.access$setMotionAnimationEndingJob(this.w, this.B, motionProgress0);
                        return H.a;
                    }
                };
                this.w = null;
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$setMotionAnimationChangeListener$1$10, this) == a0 ? a0 : H.a;
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

