package com.iloen.melon.player.video;

import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.x0;
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
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$setFullChatFragment$2", f = "VideoMainFrameFragment.kt", l = {456}, m = "invokeSuspend")
final class VideoMainFrameFragment.setFullChatFragment.2 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.setFullChatFragment.2(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.setFullChatFragment.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.setFullChatFragment.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                D d0 = this.w.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.2.1 videoMainFrameFragment$setFullChatFragment$2$10 = new n(null) {
                    public int r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.2.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                StateFlow stateFlow0 = VideoMainFrameFragment.access$getLiveViewModel(this.w).isFullChatEnable();
                                com.iloen.melon.player.video.VideoMainFrameFragment.setFullChatFragment.2.1.1 videoMainFrameFragment$setFullChatFragment$2$1$10 = new FlowCollector() {
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
                                        LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "isFullChatOpenFlow, collect() isOpen: " + z, null, false, 6, null);
                                        if(z) {
                                            I i0 = VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0);
                                            if(i0 != null) {
                                                l0 l00 = videoMainFrameFragment0.getChildFragmentManager();
                                                androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
                                                a0.b(new x0(i0, 7));
                                                a0.m();
                                                return H.a;
                                            }
                                        }
                                        else {
                                            I i1 = VideoMainFrameFragment.access$getChatFragmentForFull$p(videoMainFrameFragment0);
                                            if(i1 != null) {
                                                l0 l01 = videoMainFrameFragment0.getChildFragmentManager();
                                                q.f(l01, "getChildFragmentManager(...)");
                                                androidx.fragment.app.a a1 = new androidx.fragment.app.a(l01);
                                                a1.d(i1);
                                                a1.m();
                                            }
                                        }
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                if(stateFlow0.collect(videoMainFrameFragment$setFullChatFragment$2$1$10, this) == a0) {
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
                return f0.j(d0, s.d, videoMainFrameFragment$setFullChatFragment$2$10, this) == a0 ? a0 : H.a;
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

