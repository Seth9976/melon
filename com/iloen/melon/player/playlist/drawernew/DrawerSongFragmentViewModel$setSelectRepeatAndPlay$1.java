package com.iloen.melon.player.playlist.drawernew;

import M6.B;
import ie.H;
import java.util.ArrayList;
import java.util.List;
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
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$setSelectRepeatAndPlay$1", f = "DrawerSongFragmentViewModel.kt", l = {890}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1 extends i implements n {
    public final ArrayList B;
    public int r;
    public final DrawerSongFragmentViewModel w;

    public DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1(DrawerSongFragmentViewModel drawerSongFragmentViewModel0, ArrayList arrayList0, Continuation continuation0) {
        this.w = drawerSongFragmentViewModel0;
        this.B = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.1 drawerSongFragmentViewModel$setSelectRepeatAndPlay$1$10 = new k(this.B, null) {
                    public int B;
                    public int D;
                    public final DrawerSongFragmentViewModel E;
                    public final ArrayList G;
                    public DrawerSongFragmentViewModel r;
                    public Object w;

                    {
                        this.E = drawerSongFragmentViewModel0;
                        this.G = arrayList0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.1(this.E, this.G, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.1)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel1;
                        int v;
                        List list0;
                        DrawerSongFragmentViewModel drawerSongFragmentViewModel0;
                        a a0 = a.a;
                        switch(this.D) {
                            case 0: {
                                d5.n.D(object0);
                                drawerSongFragmentViewModel0 = this.E;
                                nc.a a1 = (nc.a)drawerSongFragmentViewModel0.getInternalPlaylist().getValue();
                                if(a1 != null) {
                                    C0 c00 = ((u0)a1).I();
                                    if(c00 != null) {
                                        B b0 = ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).x(c00);
                                        this.r = drawerSongFragmentViewModel0;
                                        ArrayList arrayList0 = this.G;
                                        this.w = arrayList0;
                                        this.B = 0;
                                        this.D = 1;
                                        if(ListenableFutureKt.await(b0, this) == a0) {
                                            return a0;
                                        }
                                        list0 = arrayList0;
                                        v = 0;
                                        goto label_23;
                                    }
                                }
                                break;
                            }
                            case 1: {
                                v = this.B;
                                list0 = (List)this.w;
                                drawerSongFragmentViewModel0 = this.r;
                                d5.n.D(object0);
                            label_23:
                                ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel0)).a(DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel0));
                                this.r = drawerSongFragmentViewModel0;
                                this.w = null;
                                this.B = v;
                                this.D = 2;
                                if(DrawerSongFragmentViewModel.access$getPlayerUseCase$p(drawerSongFragmentViewModel0).H(DrawerSongFragmentViewModel.access$getPlaylistId$p(drawerSongFragmentViewModel0), list0, this) == a0) {
                                    return a0;
                                }
                                drawerSongFragmentViewModel1 = drawerSongFragmentViewModel0;
                                goto label_35;
                            }
                            case 2: {
                                v = this.B;
                                C0 c01 = (C0)this.w;
                                drawerSongFragmentViewModel1 = this.r;
                                d5.n.D(object0);
                            label_35:
                                B b1 = ((d3)DrawerSongFragmentViewModel.access$getPlaylistManager$p(drawerSongFragmentViewModel1)).l();
                                this.r = null;
                                this.w = drawerSongFragmentViewModel1;
                                this.B = v;
                                this.D = 3;
                                object0 = ListenableFutureKt.await(b1, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                drawerSongFragmentViewModel1.updateInternalPlaylist(((nc.a)object0), "setSelectRepeatAndPlay");
                                return H.a;
                            }
                            case 3: {
                                DrawerSongFragmentViewModel drawerSongFragmentViewModel2 = (DrawerSongFragmentViewModel)this.w;
                                C0 c02 = (C0)this.r;
                                d5.n.D(object0);
                                drawerSongFragmentViewModel2.updateInternalPlaylist(((nc.a)object0), "setSelectRepeatAndPlay");
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        return H.a;
                    }
                };
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.2 drawerSongFragmentViewModel$setSelectRepeatAndPlay$1$20 = new k(this.B, null) {
                    public final ArrayList B;
                    public int r;
                    public final DrawerSongFragmentViewModel w;

                    {
                        this.w = drawerSongFragmentViewModel0;
                        this.B = arrayList0;
                        super(1, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.2(this.w, this.B, continuation0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        return this.invoke(((Continuation)object0));
                    }

                    public final Object invoke(Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.setSelectRepeatAndPlay.1.2)this.create(continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                return DrawerSongFragmentViewModel.access$getPlayerUseCase$p(this.w).H(DrawerSongFragmentViewModel.access$getPlaylistId$p(this.w), this.B, this) == a0 ? a0 : H.a;
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
                this.r = 1;
                return DrawerSongFragmentViewModel.access$checkViewModeAndRunAction(this.w, drawerSongFragmentViewModel$setSelectRepeatAndPlay$1$10, drawerSongFragmentViewModel$setSelectRepeatAndPlay$1$20, this) == a0 ? a0 : H.a;
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

