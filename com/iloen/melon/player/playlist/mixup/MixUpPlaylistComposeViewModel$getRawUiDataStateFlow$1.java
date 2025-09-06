package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.playlist.PlaylistId;
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
import pc.Z;
import pc.d;
import pc.z0;
import we.n;
import we.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel$MixUpRawUiData;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1", f = "MixUpPlaylistComposeViewModel.kt", l = {0xE4, 0xE9}, m = "invokeSuspend")
final class MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1 extends i implements n {
    public Object B;
    public final MixUpPlaylistComposeViewModel D;
    public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1 r;
    public int w;

    public MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        this.D = mixUpPlaylistComposeViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$10;
        ProducerScope producerScope0 = (ProducerScope)this.B;
        a a0 = a.a;
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$10 = new Flow() {
                    @Override  // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1.2 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object object0, Continuation continuation0) {
                                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1.2.1 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10;
                                if(continuation0 instanceof com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1.2.1) {
                                    mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.invokeSuspend..inlined.map.1.2.1)continuation0;
                                    int v = mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w;
                                    if((v & 0x80000000) == 0) {
                                        mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                        mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                Object object1 = mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10.r;
                                a a0 = a.a;
                                switch(mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w) {
                                    case 0: {
                                        d5.n.D(object1);
                                        Boolean boolean0 = Boolean.valueOf(((PlaylistId)object0).isMixUp());
                                        mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                        return this.a.emit(boolean0, mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                        Object object0 = this.a.collect(mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$1$20, continuation0);
                        return object0 == a.a ? object0 : H.a;
                    }
                };
                this.B = producerScope0;
                this.r = mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$10;
                this.w = 1;
                object0 = MixUpPlaylistComposeViewModel.access$getMixUpPlaylist(mixUpPlaylistComposeViewModel0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$10 = this.r;
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
        Flow flow0 = MixUpPlaylistComposeViewModel.access$getPlayerUseCase$p(mixUpPlaylistComposeViewModel0).h();
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.1 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10 = new p(null) {
            public boolean B;
            public final MixUpPlaylistComposeViewModel D;
            public z0 r;
            public boolean w;

            {
                this.D = mixUpPlaylistComposeViewModel0;
                super(4, continuation0);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                return this.invoke(((z0)object0), ((Boolean)object1).booleanValue(), ((Boolean)object2).booleanValue(), ((Continuation)object3));
            }

            public final Object invoke(z0 z00, boolean z, boolean z1, Continuation continuation0) {
                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.1 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.1(this.D, continuation0);
                mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10.r = z00;
                mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10.w = z;
                mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10.B = z1;
                return mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                z0 z00 = this.r;
                boolean z = this.w;
                boolean z1 = this.B;
                d5.n.D(object0);
                return MixUpPlaylistComposeViewModel.access$makeRawUiData(this.D, z00, z, z1);
            }
        };
        Flow flow1 = FlowKt.distinctUntilChanged(FlowKt.combine(((Z)(((d)object0))).f, flow0, mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$invokeSuspend$$inlined$map$10, mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$10));
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.2 mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$20 = new n(null) {
            public Object r;
            public final ProducerScope w;

            {
                this.w = producerScope0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1.2)this.create(mixUpPlaylistComposeViewModel$MixUpRawUiData0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((MixUpRawUiData)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0 = (MixUpRawUiData)this.r;
                d5.n.D(object0);
                this.w.trySend-JP2dKIU(mixUpPlaylistComposeViewModel$MixUpRawUiData0);
                return H.a;
            }
        };
        this.B = null;
        this.r = null;
        this.w = 2;
        return FlowKt.collectLatest(flow1, mixUpPlaylistComposeViewModel$getRawUiDataStateFlow$1$20, this) == a0 ? a0 : H.a;
    }
}

