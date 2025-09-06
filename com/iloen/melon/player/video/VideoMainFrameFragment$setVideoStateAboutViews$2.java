package com.iloen.melon.player.video;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setVideoStateAboutViews$2", f = "VideoMainFrameFragment.kt", l = {607}, m = "invokeSuspend")
final class VideoMainFrameFragment.setVideoStateAboutViews.2 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setVideoStateAboutViews.2(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setVideoStateAboutViews.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setVideoStateAboutViews.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = VideoMainFrameFragment.access$getVideoViewModel(this.w).getVideoStatus();
                com.iloen.melon.player.video.VideoMainFrameFragment.setVideoStateAboutViews.2.1 videoMainFrameFragment$setVideoStateAboutViews$2$10 = new FlowCollector() {
                    public final VideoMainFrameFragment a;

                    {
                        this.a = videoMainFrameFragment0;
                    }

                    public final Object emit(VideoStatus videoStatus0, Continuation continuation0) {
                        VideoMainFrameFragment videoMainFrameFragment0 = this.a;
                        VideoMotionLayout videoMotionLayout0 = videoMainFrameFragment0.getBinding().o;
                        q.f(videoMotionLayout0, "videoFrameContainer");
                        if(videoMotionLayout0.getCurrentState() != videoStatus0.getMotionStateId()) {
                            VideoMainFrameFragmentKt.access$jumpToStateAndSetTransition(videoMotionLayout0, videoStatus0.getMotionStateId());
                        }
                        VideoMainFrameFragment.access$updateSystemUI(videoMainFrameFragment0, videoStatus0);
                        videoMainFrameFragment0.getBinding().o.setInteractionEnabled(true);
                        return H.a;
                    }

                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object object0, Continuation continuation0) {
                        return this.emit(((VideoStatus)object0), continuation0);
                    }
                };
                this.r = 1;
                if(stateFlow0.collect(videoMainFrameFragment$setVideoStateAboutViews$2$10, this) == a0) {
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
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

