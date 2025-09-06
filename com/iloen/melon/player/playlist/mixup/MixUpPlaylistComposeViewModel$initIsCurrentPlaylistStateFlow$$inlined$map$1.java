package com.iloen.melon.player.playlist.mixup;

import com.iloen.melon.playback.playlist.PlaylistId;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.c;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001E\u0010\u0005\u001A\u00020\u00042\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lie/H;", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1 implements Flow {
    public final Flow a;

    public MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1(Flow flow0) {
        this.a = flow0;
        super();
    }

    @Override  // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1.2 mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$20 = new FlowCollector() {
            @Override  // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object object0, Continuation continuation0) {
                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1.2.1 mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10;
                if(continuation0 instanceof com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1.2.1) {
                    mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1.2.1)continuation0;
                    int v = mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10.w;
                    if((v & 0x80000000) == 0) {
                        mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10.w = v ^ 0x80000000;
                    }
                }
                else {
                    mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                Object object1 = mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10.r;
                a a0 = a.a;
                switch(mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10.w) {
                    case 0: {
                        n.D(object1);
                        Boolean boolean0 = Boolean.valueOf(((PlaylistId)object0).isMixUp());
                        mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10.w = 1;
                        return this.a.emit(boolean0, mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object1);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        Object object0 = this.a.collect(mixUpPlaylistComposeViewModel$initIsCurrentPlaylistStateFlow$$inlined$map$1$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

