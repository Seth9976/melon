package com.iloen.melon.player.video;

import android.content.Context;
import android.content.res.Resources;
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
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setMiniPlayerRatio$1", f = "VideoMainFrameFragment.kt", l = {678}, m = "invokeSuspend")
final class VideoMainFrameFragment.setMiniPlayerRatio.1 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setMiniPlayerRatio.1(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setMiniPlayerRatio.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setMiniPlayerRatio.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = VideoMainFrameFragment.access$getVideoViewModel(this.w).isVideoPortraitRatio();
                com.iloen.melon.player.video.VideoMainFrameFragment.setMiniPlayerRatio.1.1 videoMainFrameFragment$setMiniPlayerRatio$1$10 = new n(null) {
                    public boolean r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.setMiniPlayerRatio.1.1(this.w, continuation0);
                        continuation1.r = ((Boolean)object0).booleanValue();
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                    }

                    public final Object invoke(boolean z, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setMiniPlayerRatio.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        Float float1;
                        boolean z = this.r;
                        d5.n.D(object0);
                        androidx.constraintlayout.widget.n n0 = new androidx.constraintlayout.widget.n();
                        VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                        n0.g(videoMainFrameFragment0.getBinding().o.getConstraintSet(0x7F0A0808));  // id:mini
                        Float float0 = null;
                        if(z) {
                            Context context0 = videoMainFrameFragment0.getContext();
                            if(context0 == null) {
                                float1 = null;
                            }
                            else {
                                Resources resources0 = context0.getResources();
                                float1 = resources0 == null ? null : new Float(resources0.getDimension(0x7F070477));  // dimen:video_miniplayer_potrait_ratio_height
                            }
                        }
                        else {
                            Context context1 = videoMainFrameFragment0.getContext();
                            if(context1 == null) {
                                float1 = null;
                            }
                            else {
                                Resources resources1 = context1.getResources();
                                float1 = resources1 == null ? null : new Float(resources1.getDimension(0x7F070475));  // dimen:video_miniplayer_landscape_ratio_height
                            }
                        }
                        if(z) {
                            Context context2 = videoMainFrameFragment0.getContext();
                            if(context2 != null) {
                                Resources resources2 = context2.getResources();
                                if(resources2 != null) {
                                    float0 = new Float(resources2.getDimension(0x7F070478));  // dimen:video_miniplayer_potrait_ratio_width
                                }
                            }
                        }
                        else {
                            Context context3 = videoMainFrameFragment0.getContext();
                            if(context3 != null) {
                                Resources resources3 = context3.getResources();
                                if(resources3 != null) {
                                    float0 = new Float(resources3.getDimension(0x7F070476));  // dimen:video_miniplayer_landscape_ratio_width
                                }
                            }
                        }
                        int v = videoMainFrameFragment0.getBinding().r.getId();
                        int v1 = 0;
                        n0.l(v).e.d = float1 == null ? 0 : ((int)(((float)float1)));
                        if(float0 != null) {
                            v1 = (int)(((float)float0));
                        }
                        n0.l(v).e.c = v1;
                        videoMainFrameFragment0.getBinding().o.updateState(0x7F0A0808, n0);  // id:mini
                        return H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$setMiniPlayerRatio$1$10, this) == a0 ? a0 : H.a;
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

