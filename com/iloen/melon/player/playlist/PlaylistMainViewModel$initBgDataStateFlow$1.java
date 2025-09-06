package com.iloen.melon.player.playlist;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.Q;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/iloen/melon/player/playlist/PlaylistMainBgData;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.PlaylistMainViewModel$initBgDataStateFlow$1", f = "PlaylistMainViewModel.kt", l = {100}, m = "invokeSuspend")
final class PlaylistMainViewModel.initBgDataStateFlow.1 extends i implements n {
    public final PlaylistMainViewModel B;
    public int r;
    public Object w;

    public PlaylistMainViewModel.initBgDataStateFlow.1(PlaylistMainViewModel playlistMainViewModel0, Continuation continuation0) {
        this.B = playlistMainViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new PlaylistMainViewModel.initBgDataStateFlow.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((PlaylistMainViewModel.initBgDataStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((d3)this.B.getPlaylistManager()).i();
                com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1 playlistMainViewModel$initBgDataStateFlow$1$10 = new n(null, producerScope0) {
                    public final PlaylistMainViewModel B;
                    public final ProducerScope D;
                    public int r;
                    public Object w;

                    {
                        this.B = playlistMainViewModel0;
                        this.D = producerScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1(this.B, continuation0, this.D);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1)this.create(playlistId0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        PlaylistId playlistId0 = (PlaylistId)this.w;
                        a a0 = a.a;
                        PlaylistMainViewModel playlistMainViewModel0 = this.B;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                B b0 = ((d3)playlistMainViewModel0.getPlaylistManager()).p(playlistId0);
                                this.w = null;
                                this.r = 1;
                                object0 = ListenableFutureKt.await(b0, this);
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
                        com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1.1 playlistMainViewModel$initBgDataStateFlow$1$1$10 = new n(null, this.D) {
                            public final ProducerScope B;
                            public final PlaylistMainViewModel D;
                            public int r;
                            public Object w;

                            {
                                this.B = producerScope0;
                                this.D = playlistMainViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1.1(this.D, continuation0, this.B);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Q)object0), ((Continuation)object1));
                            }

                            public final Object invoke(Q q0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistMainViewModel.initBgDataStateFlow.1.1.1)this.create(q0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Q q0 = (Q)this.w;
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        PlaylistMainBgData playlistMainBgData0 = PlaylistMainViewModel.access$getPlaylistMainBgData(this.D, q0);
                                        this.w = null;
                                        this.r = 1;
                                        return this.B.send(playlistMainBgData0, this) == a0 ? a0 : H.a;
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
                        this.w = null;
                        this.r = 2;
                        return FlowKt.collectLatest(mutableStateFlow0, playlistMainViewModel$initBgDataStateFlow$1$1$10, this) == a0 ? a0 : H.a;
                    }
                };
                this.w = null;
                this.r = 1;
                return FlowKt.collectLatest(flow0, playlistMainViewModel$initBgDataStateFlow$1$10, this) == a0 ? a0 : H.a;
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

