package com.iloen.melon.player.playlist.search;

import M6.B;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.C0;
import ne.a;
import oc.Q;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchViewModel$playAtPosition$2", f = "PlaylistSearchViewModel.kt", l = {420, 422, 0x1AF, 443}, m = "invokeSuspend")
final class PlaylistSearchViewModel.playAtPosition.2 extends i implements n {
    public PlaylistSearchViewModel B;
    public int D;
    public final PlaylistSearchViewModel E;
    public final int G;
    public int r;
    public int w;

    public PlaylistSearchViewModel.playAtPosition.2(PlaylistSearchViewModel playlistSearchViewModel0, int v, Continuation continuation0) {
        this.E = playlistSearchViewModel0;
        this.G = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new PlaylistSearchViewModel.playAtPosition.2(this.E, this.G, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((PlaylistSearchViewModel.playAtPosition.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v4;
        int v6;
        int v5;
        a a0 = a.a;
        int v = this.G;
        H h0 = H.a;
        int v1 = 1;
        PlaylistSearchViewModel playlistSearchViewModel0 = this.E;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                if(playlistSearchViewModel0.isDrawerViewMode()) {
                    oc.H h2 = playlistSearchViewModel0.p;
                    if(h2 == null) {
                        goto label_47;
                    }
                    else {
                        Q q0 = h2.getState();
                        C0 c00 = q0 instanceof C0 ? ((C0)q0) : null;
                        int v7 = this.G;
                        C0 c01 = c00 == null ? null : C0.f(c00, null, v7, null, null, false, false, null, false, null, 509);
                        s2 s20 = playlistSearchViewModel0.c;
                        if(c01 != null) {
                            B b0 = ((d3)s20).x(c01);
                            this.B = playlistSearchViewModel0;
                            this.r = v7;
                            this.w = 0;
                            this.D = 1;
                            if(ListenableFutureKt.await(b0, this) == a0) {
                                return a0;
                            }
                            v5 = 0;
                            v6 = v7;
                        label_41:
                            playlistSearchViewModel0.d.w(playlistSearchViewModel0.getPlaylistId(), v6);
                            this.B = null;
                            this.r = v5;
                            this.D = 2;
                            if(playlistSearchViewModel0.u.emit(Boolean.TRUE, this) == a0) {
                                return a0;
                            }
                        }
                    }
                }
                else {
                label_47:
                    v4 = ((d3)playlistSearchViewModel0.c).j() == playlistSearchViewModel0.getPlaylistId() ? 1 : 0;
                    oc.H h3 = playlistSearchViewModel0.b();
                    if(h3 == null) {
                        v1 = 0;
                    }
                    else {
                        Q q1 = h3.getState();
                        if(q1 == null || q1.b() != v) {
                            v1 = 0;
                        }
                    }
                    if(v4 == 0) {
                        B b1 = ((d3)playlistSearchViewModel0.c).a(playlistSearchViewModel0.getPlaylistId());
                        this.r = 0;
                        this.w = v1;
                        this.D = 3;
                        if(ListenableFutureKt.await(b1, this) == a0) {
                            return a0;
                        }
                        v4 = 0;
                    }
                label_62:
                    if(v1 == 0) {
                        playlistSearchViewModel0.d.v(v);
                    }
                    else if(!playlistSearchViewModel0.d.n()) {
                        playlistSearchViewModel0.d.u();
                    }
                    this.r = v4;
                    this.w = v1;
                    this.D = 4;
                    if(playlistSearchViewModel0.u.emit(Boolean.TRUE, this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                v5 = this.w;
                v6 = this.r;
                playlistSearchViewModel0 = this.B;
                d5.n.D(object0);
                goto label_41;
            }
            case 2: {
                oc.H h1 = (oc.H)this.B;
                d5.n.D(object0);
                return h0;
            }
            case 3: {
                int v2 = this.w;
                int v3 = this.r;
                d5.n.D(object0);
                v1 = v2;
                v4 = v3;
                goto label_62;
            }
            case 4: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

