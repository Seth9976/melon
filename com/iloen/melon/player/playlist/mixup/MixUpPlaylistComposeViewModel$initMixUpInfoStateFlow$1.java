package com.iloen.melon.player.playlist.mixup;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.c;
import oe.e;
import oe.i;
import pc.z0;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lpc/c;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1", f = "MixUpPlaylistComposeViewModel.kt", l = {327, 330}, m = "invokeSuspend")
final class MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1 extends i implements n {
    public final MixUpPlaylistComposeViewModel B;
    public int r;
    public Object w;

    public MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.B = mixUpPlaylistComposeViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.w = producerScope0;
                this.r = 1;
                object0 = MixUpPlaylistComposeViewModel.access$getMixUpPlaylist(this.B, this);
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
        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.invokeSuspend..inlined.map.1.2 mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.invokeSuspend..inlined.map.1.2.1 mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.invokeSuspend..inlined.map.1.2.1) {
                            mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.invokeSuspend..inlined.map.1.2.1)continuation0;
                            int v = mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w) {
                            case 0: {
                                d5.n.D(object1);
                                mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(((z0)object0).c, mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$invokeSuspend$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        });
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.2 mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$20 = new n(null) {
            public Object r;
            public final ProducerScope w;

            {
                this.w = producerScope0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((pc.c)object0), ((Continuation)object1));
            }

            public final Object invoke(pc.c c0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1.2)this.create(c0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                pc.c c0 = (pc.c)this.r;
                d5.n.D(object0);
                this.w.trySend-JP2dKIU(c0);
                return H.a;
            }
        };
        this.w = null;
        this.r = 2;
        return FlowKt.collectLatest(flow0, mixUpPlaylistComposeViewModel$initMixUpInfoStateFlow$1$20, this) == a0 ? a0 : H.a;
    }
}

