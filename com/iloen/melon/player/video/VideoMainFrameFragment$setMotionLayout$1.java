package com.iloen.melon.player.video;

import J8.n2;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setMotionLayout$1", f = "VideoMainFrameFragment.kt", l = {529}, m = "invokeSuspend")
final class VideoMainFrameFragment.setMotionLayout.1 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setMotionLayout.1(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setMotionLayout.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setMotionLayout.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                D d0 = this.w.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1 videoMainFrameFragment$setMotionLayout$1$10 = new n(null) {
                    public final VideoMainFrameFragment B;
                    public int r;
                    public Object w;

                    {
                        this.B = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1(this.B, continuation0);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                StateFlow stateFlow0 = VideoMainFrameFragment.access$getVideoViewModel(this.B).isTopBottomSplit();
                                com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1.1 videoMainFrameFragment$setMotionLayout$1$1$10 = new n(coroutineScope0, null) {
                                    public final CoroutineScope B;
                                    public boolean r;
                                    public final VideoMainFrameFragment w;

                                    {
                                        this.w = videoMainFrameFragment0;
                                        this.B = coroutineScope0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1.1(this.w, this.B, continuation0);
                                        continuation1.r = ((Boolean)object0).booleanValue();
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                    }

                                    public final Object invoke(boolean z, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setMotionLayout.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        boolean z = this.r;
                                        d5.n.D(object0);
                                        VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                                        LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "isTopBottomSplit-collectLatest-newIsTopBottomSplit:" + z, null, false, 6, null);
                                        CoroutineScope coroutineScope0 = VideoMainFrameFragment.access$getMotionSceneScope$p(videoMainFrameFragment0);
                                        if(coroutineScope0 != null) {
                                            CoroutineScopeKt.cancel$default(coroutineScope0, "Change motion scene", null, 2, null);
                                        }
                                        if(z) {
                                            videoMainFrameFragment0.getBinding().o.loadLayoutDescription(0x7F160011);  // xml:melon_video_main_frame_layout_scene
                                        }
                                        else {
                                            float f = ScreenUtils.isTablet(videoMainFrameFragment0.getContext()) ? VideoMainFrameFragmentKt.access$getFloat(videoMainFrameFragment0.getContext(), 0x7F070129, 0.5f) : VideoMainFrameFragmentKt.access$getFloat(videoMainFrameFragment0.getContext(), 0x7F070128, 0.5f);  // dimen:left_right_split_video_ratio_for_tablet
                                            videoMainFrameFragment0.getBinding().e.setGuidelinePercent(f);
                                            videoMainFrameFragment0.getBinding().o.loadLayoutDescription(0x7F160012);  // xml:melon_video_main_frame_layout_scene_landscape
                                        }
                                        n2 n20 = videoMainFrameFragment0.getBinding();
                                        q.f(n20.o, "videoFrameContainer");
                                        int v = ((VideoStatus)VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).getVideoStatus().getValue()).getMotionStateId();
                                        int v1 = n20.o.getWidth();
                                        int v2 = n20.o.getHeight();
                                        n20.o.setState(0x7F0A0471, v1, v2);  // id:expand
                                        VideoMainFrameFragmentKt.access$jumpToStateAndSetTransition(n20.o, v);
                                        VideoMainFrameFragment.access$setMotionSceneScope$p(videoMainFrameFragment0, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.B.getCoroutineContext()).plus(SupervisorKt.SupervisorJob$default(null, 1, null))));
                                        CoroutineScope coroutineScope1 = VideoMainFrameFragment.access$getMotionSceneScope$p(videoMainFrameFragment0);
                                        q.d(coroutineScope1);
                                        VideoMainFrameFragment.access$setMotionAboutViews(videoMainFrameFragment0, coroutineScope1);
                                        return H.a;
                                    }
                                };
                                this.w = null;
                                this.r = 1;
                                return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$setMotionLayout$1$1$10, this) == a0 ? a0 : H.a;
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
                };
                this.r = 1;
                return f0.j(d0, s.e, videoMainFrameFragment$setMotionLayout$1$10, this) == a0 ? a0 : H.a;
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

