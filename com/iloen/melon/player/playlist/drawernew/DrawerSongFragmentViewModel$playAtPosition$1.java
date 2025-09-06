package com.iloen.melon.player.playlist.drawernew;

import M6.B;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListItemData;
import ie.H;
import java.util.List;
import je.p;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.C0;
import nc.u0;
import ne.a;
import oe.e;
import oe.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$playAtPosition$1", f = "DrawerSongFragmentViewModel.kt", l = {830}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.playAtPosition.1 extends i implements n {
    public final int B;
    public int r;
    public final DrawerSongFragmentViewModel w;

    public DrawerSongFragmentViewModel.playAtPosition.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, int v, Continuation continuation0) {
        this.w = drawerSongFragmentViewModel0;
        this.B = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new DrawerSongFragmentViewModel.playAtPosition.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.playAtPosition.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.1 drawerSongFragmentViewModel$playAtPosition$1$10 = new k(this.B, null) {
                    public int B;
                    public int D;
                    public final DrawerSongFragmentViewModel E;
                    public final int G;
                    public Object r;
                    public DrawerSongFragmentViewModel w;

                    {
                        this.E = drawerSongFragmentViewModel0;
                        this.G = v;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.1(this.E, this.G, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.1)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        Object object1;
                        int v;
                        a a0 = a.a;
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.E;
                        switch(this.D) {
                            case 0: {
                                d5.n.D(object0);
                                nc.a a1 = (nc.a)drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                                C0 c00 = a1 == null ? null : ((u0)a1).I();
                                if(c00 != null) {
                                    C0 c01 = C0.f(c00, null, this.G, null, null, false, false, null, false, null, 509);
                                    B b0 = ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).x(c01);
                                    this.r = c01;
                                    this.w = drawerSongFragmentViewModel0;
                                    v = this.G;
                                    this.B = v;
                                    this.D = 1;
                                    if(ListenableFutureKt.await(b0, this) == a0) {
                                        return a0;
                                    }
                                    DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).w(DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel0), v);
                                }
                                goto label_23;
                            }
                            case 1: {
                                v = this.B;
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel1 = this.w;
                                C0 c02 = (C0)this.r;
                                d5.n.D(object0);
                                DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel1).w(DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel1), v);
                            label_23:
                                B b1 = ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).l();
                                this.r = drawerSongFragmentViewModel0;
                                this.w = null;
                                this.D = 2;
                                object1 = ListenableFutureKt.await(b1, this);
                                if(object1 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 2: {
                                drawerSongFragmentViewModel0 = (DrawerSongFragmentViewModel)this.r;
                                d5.n.D(object0);
                                object1 = object0;
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        drawerSongFragmentViewModel0.updateInternalPlaylist(((nc.a)object1), "playAtPosition replaceDrawerPlaylist");
                        return H.a;
                    }
                };
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.2 drawerSongFragmentViewModel$playAtPosition$1$20 = new k(this.B, null) {
                    public final DrawerSongFragmentViewModel r;
                    public final int w;

                    {
                        this.r = drawerSongFragmentViewModel0;
                        this.w = v;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.2(this.r, this.w, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.playAtPosition.1.2)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        d5.n.D(object0);
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = this.r;
                        List list0 = (List)drawerSongFragmentViewModel0.getSongListState().getValue();
                        int v = this.w;
                        DrawerSongListItemData drawerSongListItemData0 = (DrawerSongListItemData)p.n0(v, list0);
                        H h0 = H.a;
                        if(drawerSongListItemData0 != null) {
                            if(!drawerSongListItemData0.isCurrent()) {
                                DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).v(v);
                                return h0;
                            }
                            else if(!DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).n()) {
                                DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).u();
                                return h0;
                            }
                        }
                        return h0;
                    }
                };
                this.r = 1;
                if(DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(drawerSongFragmentViewModel0, drawerSongFragmentViewModel$playAtPosition$1$10, drawerSongFragmentViewModel$playAtPosition$1$20, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        DrawerSongFragmentViewModel.access$isPlayRequest$p(drawerSongFragmentViewModel0).set(false);
        return H.a;
    }
}

