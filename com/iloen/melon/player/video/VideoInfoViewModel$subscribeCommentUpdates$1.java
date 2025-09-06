package com.iloen.melon.player.video;

import Ac.V3;
import androidx.lifecycle.f0;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.c;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoInfoViewModel$subscribeCommentUpdates$1", f = "VideoInfoViewModel.kt", l = {441}, m = "invokeSuspend")
final class VideoInfoViewModel.subscribeCommentUpdates.1 extends i implements n {
    public int r;
    public final VideoInfoViewModel w;

    public VideoInfoViewModel.subscribeCommentUpdates.1(Continuation continuation0, VideoInfoViewModel videoInfoViewModel0) {
        this.w = videoInfoViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoInfoViewModel.subscribeCommentUpdates.1(continuation0, this.w);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoInfoViewModel.subscribeCommentUpdates.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.1 videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$10 = new Flow() {
                    @Override  // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                        com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.1.2 videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$20 = new FlowCollector() {
                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object object0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.1.2.1 videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10;
                                if(continuation0 instanceof com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.1.2.1) {
                                    videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10 = (com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.1.2.1)continuation0;
                                    int v = videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10.w;
                                    if((v & 0x80000000) == 0) {
                                        videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            public Object r;
                                            public int w;

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                this.r = object0;
                                                this.w |= 0x80000000;
                                                return continuation0.emit(null, this);
                                            }
                                        };
                                    }
                                    else {
                                        videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10.w = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        public Object r;
                                        public int w;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.r = object0;
                                            this.w |= 0x80000000;
                                            return continuation0.emit(null, this);
                                        }
                                    };
                                }
                                Object object1 = videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10.r;
                                a a0 = a.a;
                                switch(videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10.w) {
                                    case 0: {
                                        d5.n.D(object1);
                                        if(object0 instanceof V3) {
                                            videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10.w = 1;
                                            if(this.a.emit(object0, videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$2$10) == a0) {
                                                return a0;
                                            }
                                        }
                                        return H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object1);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        Object object0 = this.a.collect(videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$1$20, continuation0);
                        return object0 == a.a ? object0 : H.a;
                    }
                };
                com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.2 videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$20 = new n(this.w) {
                    public Object r;
                    public final VideoInfoViewModel w;

                    {
                        this.w = videoInfoViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.2(continuation0, this.w);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(object0, ((Continuation)object1));
                    }

                    public final Object invoke(Object object0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.invokeSuspend..inlined.subscribe.2)this.create(object0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        Object object1 = this.r;
                        d5.n.D(object0);
                        JobKt.ensureActive(this.getContext());
                        LogU.Companion.d("VideoInfoViewModel", "CommentUpdateAction onEvent: " + ((V3)object1));
                        int v = ((V3)object1).a();
                        VideoInfoViewModel videoInfoViewModel0 = this.w;
                        if(v == videoInfoViewModel0.getBbsChannelSeq() && q.b(((V3)object1).b(), videoInfoViewModel0.getMvId())) {
                            BuildersKt__Builders_commonKt.launch$default(f0.h(videoInfoViewModel0), null, null, new com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.1.1(videoInfoViewModel0, ((V3)object1), null), 3, null);
                        }
                        return H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$10, videoInfoViewModel$subscribeCommentUpdates$1$invokeSuspend$$inlined$subscribe$20, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.player.video.VideoInfoViewModel$subscribeCommentUpdates$1$1$1", f = "VideoInfoViewModel.kt", l = {331}, m = "invokeSuspend")
        final class com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.1.1 extends i implements n {
            public final V3 B;
            public int r;
            public final VideoInfoViewModel w;

            public com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.1.1(VideoInfoViewModel videoInfoViewModel0, V3 v30, Continuation continuation0) {
                this.w = videoInfoViewModel0;
                this.B = v30;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.1.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoInfoViewModel.subscribeCommentUpdates.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return VideoInfoViewModel.access$processCommentUpdateAction(this.w, this.B, this) == a0 ? a0 : H.a;
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

    }
}

