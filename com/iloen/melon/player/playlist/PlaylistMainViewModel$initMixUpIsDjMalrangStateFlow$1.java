package com.iloen.melon.player.playlist;

import M6.B;
import com.melon.playlist.mixup.DjMalrangInfo;
import ie.H;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.e;
import oe.i;
import pc.Z;
import pc.d;
import pc.z0;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.PlaylistMainViewModel$initMixUpIsDjMalrangStateFlow$1", f = "PlaylistMainViewModel.kt", l = {87, 88}, m = "invokeSuspend")
final class PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1 extends i implements n {
    public final PlaylistMainViewModel B;
    public int r;
    public Object w;

    public PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1(PlaylistMainViewModel playlistMainViewModel0, Continuation continuation0) {
        this.B = playlistMainViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)this.B.getPlaylistManager()).n();
                this.w = producerScope0;
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
        com.iloen.melon.player.playlist.PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1.1 playlistMainViewModel$initMixUpIsDjMalrangStateFlow$1$10 = new n(null) {
            public final ProducerScope B;
            public int r;
            public Object w;

            {
                this.B = producerScope0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1.1(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((z0)object0), ((Continuation)object1));
            }

            public final Object invoke(z0 z00, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainViewModel.initMixUpIsDjMalrangStateFlow.1.1)this.create(z00, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                z0 z00 = (z0)this.w;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.w = null;
                        this.r = 1;
                        return this.B.send(Boolean.valueOf(z00.c instanceof DjMalrangInfo), this) == a0 ? a0 : H.a;
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
        return FlowKt.collectLatest(((Z)(((d)object0))).f, playlistMainViewModel$initMixUpIsDjMalrangStateFlow$1$10, this) == a0 ? a0 : H.a;
    }
}

