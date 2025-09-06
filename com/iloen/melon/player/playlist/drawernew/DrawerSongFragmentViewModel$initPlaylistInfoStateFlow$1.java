package com.iloen.melon.player.playlist.drawernew;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import nc.C0;
import nc.u0;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$initPlaylistInfoStateFlow$1", f = "DrawerSongFragmentViewModel.kt", l = {322}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1 extends i implements n {
    public final DrawerSongFragmentViewModel B;
    public int r;
    public Object w;

    public DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
        this.B = drawerSongFragmentViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1 drawerSongFragmentViewModel$initPlaylistInfoStateFlow$1$10 = new n(null) {
                    public final ProducerScope B;
                    public int r;
                    public Object w;

                    {
                        this.B = producerScope0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1(this.B, continuation0);
                        continuation1.w = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((nc.a)object0), ((Continuation)object1));
                    }

                    public final Object invoke(nc.a a0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1)this.create(a0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        nc.a a0 = (nc.a)this.w;
                        a a1 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                if(a0 != null) {
                                    MutableStateFlow mutableStateFlow0 = ((u0)a0).h;
                                    if(mutableStateFlow0 != null) {
                                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1.1 drawerSongFragmentViewModel$initPlaylistInfoStateFlow$1$1$10 = new n(null) {
                                            public final ProducerScope B;
                                            public int r;
                                            public Object w;

                                            {
                                                this.B = producerScope0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1.1(this.B, continuation0);
                                                continuation1.w = object0;
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((C0)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(C0 c00, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.initPlaylistInfoStateFlow.1.1.1)this.create(c00, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                C0 c00 = (C0)this.w;
                                                a a0 = a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        this.w = null;
                                                        this.r = 1;
                                                        return this.B.send(c00.g, this) == a0 ? a0 : H.a;
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
                                        this.r = 1;
                                        if(FlowKt.collectLatest(mutableStateFlow0, drawerSongFragmentViewModel$initPlaylistInfoStateFlow$1$1$10, this) == a1) {
                                            return a1;
                                        }
                                    }
                                }
                                return H.a;
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
                this.r = 1;
                return FlowKt.collectLatest(this.B.getInternalPlaylist(), drawerSongFragmentViewModel$initPlaylistInfoStateFlow$1$10, this) == a0 ? a0 : H.a;
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

