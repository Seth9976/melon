package com.iloen.melon.player.video;

import a7.c;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setBottomSheetForSeparated$1", f = "VideoMainFrameFragment.kt", l = {620}, m = "invokeSuspend")
final class VideoMainFrameFragment.setBottomSheetForSeparated.1 extends i implements n {
    public final VideoMainFrameFragment B;
    public int r;
    public Object w;

    public VideoMainFrameFragment.setBottomSheetForSeparated.1(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.B = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new VideoMainFrameFragment.setBottomSheetForSeparated.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setBottomSheetForSeparated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = VideoMainFrameFragment.access$getVideoViewModel(this.B).getBottomSheetState();
                com.iloen.melon.player.video.VideoMainFrameFragment.setBottomSheetForSeparated.1.1 videoMainFrameFragment$setBottomSheetForSeparated$1$10 = new n(coroutineScope0, null) {
                    public Object B;
                    public final VideoMainFrameFragment D;
                    public final CoroutineScope E;
                    public boolean r;
                    public int w;

                    {
                        this.D = videoMainFrameFragment0;
                        this.E = coroutineScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setBottomSheetForSeparated.1.1(this.D, this.E, continuation0);
                        continuation1.B = object0;
                        return continuation1;
                    }

                    public final Object invoke(BottomSheetState videoViewModel$BottomSheetState0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setBottomSheetForSeparated.1.1)this.create(videoViewModel$BottomSheetState0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((BottomSheetState)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        boolean z1;
                        BottomSheetState videoViewModel$BottomSheetState0 = (BottomSheetState)this.B;
                        a a0 = a.a;
                        VideoMainFrameFragment videoMainFrameFragment0 = this.D;
                        switch(this.w) {
                            case 0: {
                                d5.n.D(object0);
                                LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "bottomSheetState Collect " + videoViewModel$BottomSheetState0, null, false, 6, null);
                                boolean z = ((Boolean)VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isTopBottomSplit().getValue()).booleanValue();
                                if(z) {
                                    VideoMainFrameFragment.access$setHeightInfoForFocusable(videoMainFrameFragment0, VideoMainFrameFragment.access$calculateHeightInfoForFocusable(videoMainFrameFragment0, videoViewModel$BottomSheetState0));
                                    CoroutineScopeKt.ensureActive(this.E);
                                    c.a().b("VideoMainFrameFragment setBottomSheetForSeparated() - " + videoMainFrameFragment0.hashCode());
                                    androidx.constraintlayout.widget.n n0 = new androidx.constraintlayout.widget.n();
                                    n0.g(videoMainFrameFragment0.getBinding().o.getConstraintSet(0x7F0A0471));  // id:expand
                                    n0.l(videoMainFrameFragment0.getBinding().l.getId()).e.d = VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMinVideoHeight();
                                    videoMainFrameFragment0.getBinding().o.updateState(0x7F0A0471, n0);  // id:expand
                                }
                                this.B = null;
                                this.r = z;
                                this.w = 1;
                                if(YieldKt.yield(this) == a0) {
                                    return a0;
                                }
                                z1 = z;
                                goto label_24;
                            }
                            case 1: {
                                z1 = this.r;
                                d5.n.D(object0);
                            label_24:
                                BottomSheetBehavior bottomSheetBehavior0 = VideoMainFrameFragment.access$getBottomSheetBehaviorForSeparated(videoMainFrameFragment0);
                                if(z1) {
                                    bottomSheetBehavior0.w(VideoMainFrameFragment.access$getBottomSheetForFocusableCallback$p(videoMainFrameFragment0));
                                    bottomSheetBehavior0.g0 = VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isBottomSheetDraggable();
                                    bottomSheetBehavior0.K(false);
                                    bottomSheetBehavior0.L(VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getPeekHeight());
                                }
                                else {
                                    bottomSheetBehavior0.t0.remove(VideoMainFrameFragment.access$getBottomSheetForFocusableCallback$p(videoMainFrameFragment0));
                                    bottomSheetBehavior0.g0 = VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isBottomSheetDraggable();
                                    bottomSheetBehavior0.K(false);
                                    bottomSheetBehavior0.L(0);
                                }
                                this.B = null;
                                this.r = z1;
                                this.w = 2;
                                if(YieldKt.yield(this) == a0) {
                                    return a0;
                                }
                                goto label_42;
                            }
                            case 2: {
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        z1 = this.r;
                        d5.n.D(object0);
                    label_42:
                        if(z1) {
                            VideoMainFrameFragment.access$getBottomSheetBehaviorForSeparated(videoMainFrameFragment0).M(4);
                            VideoMainFrameFragment.access$setVideoFocusState(videoMainFrameFragment0, true);
                            return H.a;
                        }
                        VideoMainFrameFragment.access$getBottomSheetBehaviorForSeparated(videoMainFrameFragment0).M(3);
                        VideoMainFrameFragment.access$updateVideoHeightAndSeparatedFragmentBottomMargin(videoMainFrameFragment0, 0, 0);
                        return H.a;
                    }
                };
                this.w = null;
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$setBottomSheetForSeparated$1$10, this) == a0 ? a0 : H.a;
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

