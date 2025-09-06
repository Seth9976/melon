package com.iloen.melon.player.video;

import A9.f;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import e1.b;
import ie.H;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.Q;
import oe.c;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.video.VideoViewModel$collectVideoPlayable$2", f = "VideoViewModel.kt", l = {332}, m = "invokeSuspend")
final class VideoViewModel.collectVideoPlayable.2 extends i implements n {
    public int r;
    public final VideoViewModel w;

    public VideoViewModel.collectVideoPlayable.2(VideoViewModel videoViewModel0, Continuation continuation0) {
        this.w = videoViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new VideoViewModel.collectVideoPlayable.2(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((VideoViewModel.collectVideoPlayable.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.invokeSuspend..inlined.filter.1 videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$10 = new Flow() {
                    @Override  // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                        com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.invokeSuspend..inlined.filter.1.2 videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$20 = new FlowCollector() {
                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object object0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.invokeSuspend..inlined.filter.1.2.1 videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10;
                                if(continuation0 instanceof com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.invokeSuspend..inlined.filter.1.2.1) {
                                    videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10 = (com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.invokeSuspend..inlined.filter.1.2.1)continuation0;
                                    int v = videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10.w;
                                    if((v & 0x80000000) == 0) {
                                        videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                        videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10.w = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                Object object1 = videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10.r;
                                switch(videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$2$10.w) {
                                    case 0: {
                                        d5.n.D(object1);
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
                        Object object0 = this.a.collect(videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$1$20, continuation0);
                        return object0 == a.a ? object0 : H.a;
                    }
                };
                com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2 videoViewModel$collectVideoPlayable$2$20 = new n(null) {
                    public final VideoViewModel B;
                    public int r;
                    public Object w;

                    {
                        this.B = videoViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2(this.B, continuation0);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                        return ((com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2)this.create(playlistId0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        PlaylistId playlistId0 = (PlaylistId)this.w;
                        a a0 = a.a;
                        VideoViewModel videoViewModel0 = this.B;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.w = null;
                                this.r = 1;
                                object0 = ListenableFutureKt.await(((d3)videoViewModel0.getPlaylistManager()).p(playlistId0), this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        MutableStateFlow mutableStateFlow0 = ((oc.H)object0).d();
                        com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2.1 videoViewModel$collectVideoPlayable$2$2$10 = new n(null) {
                            public Object r;
                            public final VideoViewModel w;

                            {
                                this.w = videoViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Q)object0), ((Continuation)object1));
                            }

                            public final Object invoke(Q q0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoViewModel.collectVideoPlayable.2.2.1)this.create(q0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Q q0 = (Q)this.r;
                                d5.n.D(object0);
                                Playable playable0 = b.y(q0);
                                if(playable0 != null) {
                                    if(!playable0.isTypeOfMv()) {
                                        if(playable0.isTypeOfLive()) {
                                            q.f("", "getLiveStatusCode(...)");
                                        }
                                        playable0 = null;
                                    }
                                    if(playable0 != null) {
                                        this.w.g.setValue(playable0);
                                        f.a("collectVideoPlayable() Changed Video Playable");
                                    }
                                }
                                return H.a;
                            }
                        };
                        this.w = null;
                        this.r = 2;
                        return FlowKt.collectLatest(mutableStateFlow0, videoViewModel$collectVideoPlayable$2$2$10, this) == a0 ? a0 : H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(videoViewModel$collectVideoPlayable$2$invokeSuspend$$inlined$filter$10, videoViewModel$collectVideoPlayable$2$20, this) == a0 ? a0 : H.a;
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

