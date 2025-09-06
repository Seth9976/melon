package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.playback.Playable;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.k;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000E\u0010\u0000\u001A\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel$convertPlayableListToUiStateList$convertUiStateList$1$1", f = "DrawerSongFragmentViewModel.kt", l = {360}, m = "invokeSuspend")
final class DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1 extends i implements k {
    public final Playable B;
    public int r;
    public final DrawerSongFragmentViewModel w;

    public DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1(Playable playable0, DrawerSongFragmentViewModel drawerSongFragmentViewModel0, Continuation continuation0) {
        this.w = drawerSongFragmentViewModel0;
        this.B = playable0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1(this.B, this.w, continuation0);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        return this.invoke(((Continuation)object0));
    }

    public final Object invoke(Continuation continuation0) {
        return ((DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1)this.create(continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1.1 drawerSongFragmentViewModel$convertPlayableListToUiStateList$convertUiStateList$1$1$10 = new we.n(null) {
                    public final Playable r;

                    {
                        this.r = playable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1.1(this.r, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragmentViewModel.convertPlayableListToUiStateList.convertUiStateList.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        n.D(object0);
                        return this.r.getDisplayName();
                    }
                };
                this.r = 1;
                object0 = BuildersKt.withContext(DrawerSongFragmentViewModel.access$getIoDispatcher$p(this.w), drawerSongFragmentViewModel$convertPlayableListToUiStateList$convertUiStateList$1$1$10, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.f(object0, "withContext(...)");
        return object0;
    }
}

