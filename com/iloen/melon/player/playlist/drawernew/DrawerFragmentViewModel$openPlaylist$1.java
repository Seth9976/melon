package com.iloen.melon.player.playlist.drawernew;

import M6.B;
import com.android.volley.VolleyError;
import com.iloen.melon.playback.playlist.PlaylistListType;
import com.iloen.melon.playback.playlist.PlaylistUtil;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfoKt;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import ie.o;
import ie.p;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import nc.u0;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel$openPlaylist$1", f = "DrawerFragmentViewModel.kt", l = {538, 549, 554}, m = "invokeSuspend")
final class DrawerFragmentViewModel.openPlaylist.1 extends i implements n {
    public PlaylistListType B;
    public int D;
    public int E;
    public Object G;
    public final DrawerFragmentViewModel I;
    public final DrawerPlaylistInfo M;
    public DrawerFragmentViewModel r;
    public DrawerPlaylistInfo w;

    public DrawerFragmentViewModel.openPlaylist.1(DrawerFragmentViewModel drawerFragmentViewModel0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        this.I = drawerFragmentViewModel0;
        this.M = drawerPlaylistInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new DrawerFragmentViewModel.openPlaylist.1(this.I, this.M, continuation0);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((DrawerFragmentViewModel.openPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o0;
        Throwable throwable2;
        DrawerFragmentViewModel drawerFragmentViewModel3;
        DrawerPlaylistInfo drawerPlaylistInfo3;
        Object object2;
        DrawerPlaylistInfo drawerPlaylistInfo0;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.G;
        a a0 = a.a;
        H h0 = H.a;
        DrawerFragmentViewModel drawerFragmentViewModel0 = this.I;
        try {
            switch(this.E) {
                case 0: {
                    goto label_6;
                }
                case 1: {
                    goto label_22;
                }
                case 2: {
                    goto label_47;
                }
                case 3: {
                    goto label_70;
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_78;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_6:
        d5.n.D(object0);
        DrawerFragmentViewModel.access$get_showProgressForIdle$p(drawerFragmentViewModel0).setValue(Boolean.TRUE);
        try {
            drawerPlaylistInfo0 = this.M;
        }
        catch(Throwable throwable1) {
            DrawerFragmentViewModel.access$get_showProgressForIdle$p(drawerFragmentViewModel0).setValue(Boolean.FALSE);
            throw throwable1;
        }
        try {
            if(drawerFragmentViewModel0.isBottomSheet()) {
                DrawerFragmentViewModel.access$updateUiState(drawerFragmentViewModel0, new h(7));
            }
            this.G = null;
            this.r = drawerFragmentViewModel0;
            this.w = drawerPlaylistInfo0;
            this.D = 0;
            this.E = 1;
            Object object1 = PlaylistUtil.INSTANCE.getTabSmartPlaylistListPlayable(drawerPlaylistInfo0, "DrawerFragmentViewModel", drawerPlaylistInfo0.getMenuId(), this);
            if(object1 == a0) {
                return a0;
            }
            DrawerPlaylistInfo drawerPlaylistInfo1 = drawerPlaylistInfo0;
            DrawerFragmentViewModel drawerFragmentViewModel1 = drawerFragmentViewModel0;
            int v = 0;
            goto label_29;
        label_22:
            v = this.D;
            DrawerPlaylistInfo drawerPlaylistInfo2 = this.w;
            DrawerFragmentViewModel drawerFragmentViewModel2 = this.r;
            d5.n.D(object0);
            drawerFragmentViewModel1 = drawerFragmentViewModel2;
            drawerPlaylistInfo1 = drawerPlaylistInfo2;
            object1 = object0;
        label_29:
            PlaylistListType playlistListType0 = (PlaylistListType)object1;
            if(playlistListType0.getPlayableList().isEmpty()) {
                ToastManager.show(0x7F131072);  // string:toast_nowplaylist_playlist_empty "재생 가능한 곡이 없습니다."
                DrawerFragmentViewModel.access$sendUiEvent(drawerFragmentViewModel1, OnFailOpenDrawerSmartPlaylist.INSTANCE);
                goto label_88;
            label_47:
                v = this.D;
                PlaylistListType playlistListType1 = this.B;
                DrawerPlaylistInfo drawerPlaylistInfo4 = this.w;
                drawerFragmentViewModel3 = this.r;
                d5.n.D(object0);
                drawerPlaylistInfo3 = drawerPlaylistInfo4;
                playlistListType0 = playlistListType1;
                object2 = object0;
            label_55:
                nc.a a1 = (nc.a)object2;
                if(DrawerPlaylistInfoKt.compareToViewMode(drawerPlaylistInfo3, ((u0)a1).I().g)) {
                    this.G = null;
                    this.r = drawerFragmentViewModel3;
                    this.w = null;
                    this.B = null;
                    this.D = v;
                    this.E = 3;
                    Object object3 = ((u0)a1).J(playlistListType0.getPlayableList(), drawerPlaylistInfo3, true, this);
                    if(object3 == a0) {
                        return a0;
                    }
                    a1 = (nc.a)object3;
                }
                DrawerFragmentViewModel.access$sendUiEvent(drawerFragmentViewModel3, new OnOpenDrawerSongPlaylist(new DrawerPlaylistTabInfo(a1)));
                throwable2 = p.a(h0);
                goto label_80;
            }
            else {
                drawerPlaylistInfo1.setDsPlyOrderDataList(playlistListType0.getDsplyOrderList());
                B b0 = ((d3)DrawerFragmentViewModel.access$getPlaylistManager$p(drawerFragmentViewModel1)).l();
                this.G = null;
                this.r = drawerFragmentViewModel1;
                this.w = drawerPlaylistInfo1;
                this.B = playlistListType0;
                this.D = v;
                this.E = 2;
                object2 = ListenableFutureKt.await(b0, this);
                if(object2 == a0) {
                    return a0;
                }
                drawerPlaylistInfo3 = drawerPlaylistInfo1;
                drawerFragmentViewModel3 = drawerFragmentViewModel1;
                goto label_55;
            }
            goto label_88;
        }
        catch(Throwable throwable0) {
            goto label_78;
        }
        try {
            throwable2 = p.a(h0);
            goto label_80;
        }
        catch(Throwable throwable1) {
            DrawerFragmentViewModel.access$get_showProgressForIdle$p(drawerFragmentViewModel0).setValue(Boolean.FALSE);
            throw throwable1;
        }
    label_70:
        nc.a a2 = (nc.a)this.B;
        CoroutineScope coroutineScope1 = (CoroutineScope)this.w;
        DrawerFragmentViewModel drawerFragmentViewModel4 = this.r;
        try {
            d5.n.D(object0);
            DrawerFragmentViewModel.access$sendUiEvent(drawerFragmentViewModel4, new OnOpenDrawerSongPlaylist(new DrawerPlaylistTabInfo(((nc.a)object0))));
            o0 = h0;
            goto label_79;
        }
        catch(Throwable throwable0) {
            try {
            label_78:
                o0 = d5.n.t(throwable0);
            label_79:
                throwable2 = p.a(o0);
            label_80:
                if(throwable2 != null) {
                    LogU.debug$default(DrawerFragmentViewModel.access$getLog$p(drawerFragmentViewModel0), "openPlaylist() exception: " + throwable2, null, false, 6, null);
                    if(throwable2 instanceof VolleyError) {
                        ToastManager.show(throwable2.getMessage());
                    }
                }
                goto label_88;
            }
            catch(Throwable throwable1) {
            }
        }
        DrawerFragmentViewModel.access$get_showProgressForIdle$p(drawerFragmentViewModel0).setValue(Boolean.FALSE);
        throw throwable1;
    label_88:
        DrawerFragmentViewModel.access$get_showProgressForIdle$p(drawerFragmentViewModel0).setValue(Boolean.FALSE);
        return h0;
    }
}

