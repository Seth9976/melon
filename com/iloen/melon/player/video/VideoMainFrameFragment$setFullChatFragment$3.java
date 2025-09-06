package com.iloen.melon.player.video;

import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.utils.log.LogU;
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
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setFullChatFragment$3", f = "VideoMainFrameFragment.kt", l = {474}, m = "invokeSuspend")
final class VideoMainFrameFragment.setFullChatFragment.3 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setFullChatFragment.3(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setFullChatFragment.3(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setFullChatFragment.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                D d0 = this.w.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.3.1 videoMainFrameFragment$setFullChatFragment$3$10 = new n(null) {
                    public int r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.3.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                StateFlow stateFlow0 = VideoMainFrameFragment.access$getLiveViewModel(this.w).isFullChatCreate();
                                com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.3.1.1 videoMainFrameFragment$setFullChatFragment$3$1$10 = new FlowCollector() {
                                    public final VideoMainFrameFragment a;

                                    {
                                        this.a = videoMainFrameFragment0;
                                    }

                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public Object emit(Object object0, Continuation continuation0) {
                                        return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                    }

                                    public final Object emit(boolean z, Continuation continuation0) {
                                        VideoMainFrameFragment videoMainFrameFragment0 = this.a;
                                        LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "isFullChatCreateFlow, collect() isCreate: " + z, null, false, 6, null);
                                        if(z) {
                                            if(VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0) == null) {
                                                VideoMainFrameFragment.access$setChatFragmentForFull$p(videoMainFrameFragment0, VideoChatFragment.Companion.newInstance(true));
                                                l0 l00 = videoMainFrameFragment0.getChildFragmentManager();
                                                q.f(l00, "getChildFragmentManager(...)");
                                                androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
                                                int v = videoMainFrameFragment0.getBinding().g.getId();
                                                I i0 = VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0);
                                                q.d(i0);
                                                a0.g(v, i0, null);
                                                a0.m();
                                                VideoMainFrameFragment.access$adjustChatFrameLayout(videoMainFrameFragment0, ((Boolean)VideoMainFrameFragment.access$getLiveViewModel(videoMainFrameFragment0).isOrientationPortrait().getValue()).booleanValue());
                                                return H.a;
                                            }
                                        }
                                        else if(VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0) != null) {
                                            l0 l01 = videoMainFrameFragment0.getChildFragmentManager();
                                            androidx.fragment.app.a a1 = com.iloen.melon.utils.a.f(l01, "getChildFragmentManager(...)", l01);
                                            I i1 = VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0);
                                            q.d(i1);
                                            a1.f(i1);
                                            a1.m();
                                            VideoMainFrameFragment.access$setChatFragmentForFull$p(videoMainFrameFragment0, null);
                                        }
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                if(stateFlow0.collect(videoMainFrameFragment$setFullChatFragment$3$1$10, this) == a0) {
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
                };
                this.r = 1;
                return f0.j(d0, s.d, videoMainFrameFragment$setFullChatFragment$3$10, this) == a0 ? a0 : H.a;
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

