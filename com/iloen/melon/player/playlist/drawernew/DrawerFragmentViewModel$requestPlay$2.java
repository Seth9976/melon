package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.playback.playlist.add.AddAction;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/iloen/melon/playback/playlist/add/AddResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel$requestPlay$2", f = "DrawerFragmentViewModel.kt", l = {654}, m = "invokeSuspend")
final class DrawerFragmentViewModel.requestPlay.2 extends i implements n {
    public final DrawerFragmentViewModel B;
    public final AddAction D;
    public int r;
    public final DrawerPlaylistInfo w;

    public DrawerFragmentViewModel.requestPlay.2(DrawerFragmentViewModel drawerFragmentViewModel0, AddAction addAction0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        this.w = drawerPlaylistInfo0;
        this.B = drawerFragmentViewModel0;
        this.D = addAction0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new DrawerFragmentViewModel.requestPlay.2(this.B, this.D, this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerFragmentViewModel.requestPlay.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(this.w, this.w.getMenuId(), null);
                AddServerContent addServerContent0 = new AddServerContent(this.D, false, false, DrawerFragmentViewModel.access$getDialogManage$p(this.B), playDataForSeverContent$DrawerPlaylist0, 6, null);
                this.r = 1;
                Object object1 = addServerContent0.execute(this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

