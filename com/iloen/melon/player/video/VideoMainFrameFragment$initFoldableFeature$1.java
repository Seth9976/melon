package com.iloen.melon.player.video;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import ie.H;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoMainFrameFragment$initFoldableFeature$1", f = "VideoMainFrameFragment.kt", l = {316}, m = "invokeSuspend")
final class VideoMainFrameFragment.initFoldableFeature.1 extends i implements n {
    public int r;
    public final VideoMainFrameFragment w;

    public VideoMainFrameFragment.initFoldableFeature.1(VideoMainFrameFragment videoMainFrameFragment0, Continuation continuation0) {
        this.w = videoMainFrameFragment0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoMainFrameFragment.initFoldableFeature.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoMainFrameFragment.initFoldableFeature.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                D d0 = this.w.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1 videoMainFrameFragment$initFoldableFeature$1$10 = new n(null) {
                    public int r;
                    public final VideoMainFrameFragment w;

                    {
                        this.w = videoMainFrameFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                Context context0 = this.w.requireContext();
                                q.f(context0, "requireContext(...)");
                                WindowInfoTracker windowInfoTracker0 = WindowInfoTracker.Companion.getOrCreate(context0);
                                FragmentActivity fragmentActivity0 = this.w.requireActivity();
                                q.f(fragmentActivity0, "requireActivity(...)");
                                Flow flow0 = windowInfoTracker0.windowLayoutInfo(fragmentActivity0);
                                com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1.1 videoMainFrameFragment$initFoldableFeature$1$1$10 = new n(null) {
                                    public Object r;
                                    public final VideoMainFrameFragment w;

                                    {
                                        this.w = videoMainFrameFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1.1(this.w, continuation0);
                                        continuation1.r = object0;
                                        return continuation1;
                                    }

                                    public final Object invoke(WindowLayoutInfo windowLayoutInfo0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.video.VideoMainFrameFragment.initFoldableFeature.1.1.1)this.create(windowLayoutInfo0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((WindowLayoutInfo)object0), ((Continuation)object1));
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        Object object1 = null;
                                        WindowLayoutInfo windowLayoutInfo0 = (WindowLayoutInfo)this.r;
                                        d5.n.D(object0);
                                        List list0 = windowLayoutInfo0.getDisplayFeatures();
                                        ListIterator listIterator0 = list0.listIterator(list0.size());
                                        while(listIterator0.hasPrevious()) {
                                            Object object2 = listIterator0.previous();
                                            if(((DisplayFeature)object2) instanceof FoldingFeature) {
                                                object1 = object2;
                                                break;
                                            }
                                        }
                                        if(((DisplayFeature)object1) != null) {
                                            VideoMainFrameFragment.access$getVideoViewModel(this.w).updateFoldingState(new FoldingFeatureAndScreenLayout(((FoldingFeature)(((DisplayFeature)object1))), this.w.getResources().getConfiguration().screenLayout));
                                        }
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                return FlowKt.collectLatest(flow0, videoMainFrameFragment$initFoldableFeature$1$1$10, this) == a0 ? a0 : H.a;
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
                return f0.j(d0, s.e, videoMainFrameFragment$initFoldableFeature$1$10, this) == a0 ? a0 : H.a;
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

