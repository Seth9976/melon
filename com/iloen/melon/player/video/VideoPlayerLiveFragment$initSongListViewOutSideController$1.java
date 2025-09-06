package com.iloen.melon.player.video;

import com.iloen.melon.utils.system.ScreenUtils;
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
@e(c = "com.iloen.melon.player.video.VideoPlayerLiveFragment$initSongListViewOutSideController$1", f = "VideoPlayerLiveFragment.kt", l = {354}, m = "invokeSuspend")
final class VideoPlayerLiveFragment.initSongListViewOutSideController.1 extends i implements n {
    public int r;
    public final VideoPlayerLiveFragment w;

    public VideoPlayerLiveFragment.initSongListViewOutSideController.1(VideoPlayerLiveFragment videoPlayerLiveFragment0, Continuation continuation0) {
        this.w = videoPlayerLiveFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoPlayerLiveFragment.initSongListViewOutSideController.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoPlayerLiveFragment.initSongListViewOutSideController.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = this.w.getLiveViewModel().getSongListVisibilityOutSideController();
                com.iloen.melon.player.video.VideoPlayerLiveFragment.initSongListViewOutSideController.1.1 videoPlayerLiveFragment$initSongListViewOutSideController$1$10 = new n(null) {
                    public boolean r;
                    public final VideoPlayerLiveFragment w;

                    {
                        this.w = videoPlayerLiveFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerLiveFragment.initSongListViewOutSideController.1.1(this.w, continuation0);
                        continuation1.r = ((Boolean)object0).booleanValue();
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                    }

                    public final Object invoke(boolean z, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.initSongListViewOutSideController.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        boolean z = this.r;
                        d5.n.D(object0);
                        VideoPlayerLiveFragment videoPlayerLiveFragment0 = this.w;
                        if(z) {
                            videoPlayerLiveFragment0.getBinding().j.setVisibility(0);
                            videoPlayerLiveFragment0.getBinding().b.setVisibility(0);
                            videoPlayerLiveFragment0.getBinding().j.animate().translationY(-((float)ScreenUtils.dipToPixel(videoPlayerLiveFragment0.getContext(), 52.0f))).alpha(1.0f).setDuration(300L);
                            return H.a;
                        }
                        videoPlayerLiveFragment0.getBinding().j.setVisibility(8);
                        videoPlayerLiveFragment0.getBinding().b.setVisibility(8);
                        videoPlayerLiveFragment0.getBinding().j.animate().translationY(0.0f).alpha(0.0f);
                        return H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, videoPlayerLiveFragment$initSongListViewOutSideController$1$10, this) == a0 ? a0 : H.a;
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

