package com.iloen.melon.player.playlist.drawernew;

import M6.B;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.P2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.t;
import oc.v;
import oc.w;
import oe.e;
import oe.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$onSwapSongPosition$1", f = "DrawerSongFragmentViewModel.kt", l = {0x30D}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.onSwapSongPosition.1 extends i implements n {
    public final DrawerSongFragmentViewModel B;
    public final int D;
    public final int E;
    public int r;
    public Object w;

    public DrawerSongFragmentViewModel.onSwapSongPosition.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v, int v1, Continuation continuation0) {
        this.B = drawerSongFragmentViewModel0;
        this.D = v;
        this.E = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new DrawerSongFragmentViewModel.onSwapSongPosition.1(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.onSwapSongPosition.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.1 drawerSongFragmentViewModel$onSwapSongPosition$1$10 = new k(this.D, this.E, coroutineScope0, null) {
                    public final int B;
                    public final int D;
                    public final CoroutineScope E;
                    public int r;
                    public final DrawerSongFragmentViewModel w;

                    {
                        this.w = drawerSongFragmentViewModel0;
                        this.B = v;
                        this.D = v1;
                        this.E = coroutineScope0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.1(this.w, this.B, this.D, this.E, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.1)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        v v2;
                        a a0 = a.a;
                        int v = this.D;
                        int v1 = this.B;
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                Object object1 = drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                                v2 = null;
                                w w0 = object1 instanceof w ? ((w)object1) : null;
                                if(w0 != null) {
                                    this.r = 1;
                                    object0 = w0.q(v1, v, this);
                                    if(object0 == a0) {
                                        return a0;
                                    }
                                    v2 = (v)object0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                v2 = (v)object0;
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(v2 instanceof t) {
                            DrawerSongFragmentViewModel.access$cancelSwapSongPosition(drawerSongFragmentViewModel0, this.E.hashCode(), v1, v);
                        }
                        return H.a;
                    }
                };
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.2 drawerSongFragmentViewModel$onSwapSongPosition$1$20 = new k(this.D, this.E, coroutineScope0, null) {
                    public final int B;
                    public final int D;
                    public final CoroutineScope E;
                    public int r;
                    public final DrawerSongFragmentViewModel w;

                    {
                        this.w = drawerSongFragmentViewModel0;
                        this.B = v;
                        this.D = v1;
                        this.E = coroutineScope0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.2(this.w, this.B, this.D, this.E, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.onSwapSongPosition.1.2)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        Object object1;
                        a a0 = a.a;
                        int v = this.D;
                        int v1 = this.B;
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                s2 s20 = DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0);
                                PlaylistId playlistId0 = DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel0);
                                ((d3)s20).getClass();
                                q.g(playlistId0, "playlistId");
                                P2 p20 = new P2(((d3)s20), playlistId0, v1, v, null);
                                B b0 = ListenableFutureKt.future$default(((d3)s20).b, null, null, p20, 3, null);
                                this.r = 1;
                                object1 = ListenableFutureKt.await(b0, this);
                                if(object1 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                object1 = object0;
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(((v)object1) instanceof t) {
                            DrawerSongFragmentViewModel.access$cancelSwapSongPosition(drawerSongFragmentViewModel0, this.E.hashCode(), v1, v);
                        }
                        return H.a;
                    }
                };
                this.w = null;
                this.r = 1;
                return DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(this.B, drawerSongFragmentViewModel$onSwapSongPosition$1$10, drawerSongFragmentViewModel$onSwapSongPosition$1$20, this) == a0 ? a0 : H.a;
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

