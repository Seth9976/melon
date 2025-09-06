package kc;

import M6.B;
import Tf.o;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddAction;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylist;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.b;
import d5.n;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.a;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.z;
import oe.c;
import pc.w1;

public final class t1 {
    public final s2 a;
    public final z b;
    public final a c;
    public final LogU d;

    public t1(s2 s20, z z0, a a0) {
        q.g(s20, "playlistManager");
        q.g(a0, "blockingProgressDialogManage");
        super();
        this.a = s20;
        this.b = z0;
        this.c = a0;
        this.d = new LogU("MelonLibrarySessionPlayContentsConnectImpl");
    }

    public final Object a(DrawerPlaylistInfo drawerPlaylistInfo0, String s, c c0) {
        AddPlay addAction$AddPlay1;
        o1 o10;
        if(c0 instanceof o1) {
            o10 = (o1)c0;
            int v = o10.D;
            if((v & 0x80000000) == 0) {
                o10 = new o1(this, c0);
            }
            else {
                o10.D = v ^ 0x80000000;
            }
        }
        else {
            o10 = new o1(this, c0);
        }
        Object object0 = o10.w;
        ne.a a0 = ne.a.a;
        switch(o10.D) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.d, "onPlayWithDrawerInfo - info:" + drawerPlaylistInfo0 + ", menuId:" + s, null, false, 6, null);
                AddPlay addAction$AddPlay0 = new AddPlay(false);
                DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo0, s, null);
                AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlay0, false, false, this.c, playDataForSeverContent$DrawerPlaylist0, 6, null);
                o10.r = addAction$AddPlay0;
                o10.D = 1;
                object0 = addServerContent0.execute(o10);
                if(object0 == a0) {
                    return a0;
                }
                addAction$AddPlay1 = addAction$AddPlay0;
                break;
            }
            case 1: {
                addAction$AddPlay1 = o10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object0).handleToast(addAction$AddPlay1);
        return H.a;
    }

    public final Object b(w1 w10, String s, c c0) {
        AddPlay addAction$AddPlay1;
        p1 p10;
        if(c0 instanceof p1) {
            p10 = (p1)c0;
            int v = p10.D;
            if((v & 0x80000000) == 0) {
                p10 = new p1(this, c0);
            }
            else {
                p10.D = v ^ 0x80000000;
            }
        }
        else {
            p10 = new p1(this, c0);
        }
        Object object0 = p10.w;
        ne.a a0 = ne.a.a;
        switch(p10.D) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.d, "onPlayWithMixUpType - mixUpType:" + w10 + ", menuId:" + s, null, false, 6, null);
                AddPlay addAction$AddPlay0 = new AddPlay(false);
                MixUp playDataForSeverContent$MixUp0 = new MixUp(w10, s, null);
                AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlay0, false, false, this.c, playDataForSeverContent$MixUp0, 6, null);
                p10.r = addAction$AddPlay0;
                p10.D = 1;
                object0 = addServerContent0.execute(p10);
                if(object0 == a0) {
                    return a0;
                }
                addAction$AddPlay1 = addAction$AddPlay0;
                break;
            }
            case 1: {
                addAction$AddPlay1 = p10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object0).handleToast(addAction$AddPlay1);
        return H.a;
    }

    public final Object c(ArrayList arrayList0, boolean z, c c0) {
        AddPlay addAction$AddPlay1;
        q1 q10;
        if(c0 instanceof q1) {
            q10 = (q1)c0;
            int v = q10.D;
            if((v & 0x80000000) == 0) {
                q10 = new q1(this, c0);
            }
            else {
                q10.D = v ^ 0x80000000;
            }
        }
        else {
            q10 = new q1(this, c0);
        }
        Object object0 = q10.w;
        ne.a a0 = ne.a.a;
        switch(q10.D) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.d, "onPlayWithPlayables - size:" + arrayList0.size() + ", isExcludeGenre:" + z, null, false, 6, null);
                AddPlay addAction$AddPlay0 = new AddPlay(false);
                AddPlayableList addPlayableList0 = new AddPlayableList(null, addAction$AddPlay0, false, z, false, null, arrayList0, 0x20, null);
                q10.r = addAction$AddPlay0;
                q10.D = 1;
                object0 = addPlayableList0.execute(q10);
                if(object0 == a0) {
                    return a0;
                }
                addAction$AddPlay1 = addAction$AddPlay0;
                break;
            }
            case 1: {
                addAction$AddPlay1 = q10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object0).handleToast(addAction$AddPlay1);
        return H.a;
    }

    public final Object d(String s, c c0) {
        PlaylistId playlistId0;
        s2 s20;
        z z0;
        ne.a a0;
        Enum enum0;
        r1 r10;
        if(c0 instanceof r1) {
            r10 = (r1)c0;
            int v = r10.D;
            if((v & 0x80000000) == 0) {
                r10 = new r1(this, c0);
            }
            else {
                r10.D = v ^ 0x80000000;
            }
        }
        else {
            r10 = new r1(this, c0);
        }
        try {
            enum0 = r10.w;
            a0 = ne.a.a;
            z0 = this.b;
            s20 = this.a;
            switch(r10.D) {
                case 0: {
                    goto label_15;
                }
                case 1: {
                    goto label_26;
                }
                case 2: {
                    goto label_34;
                }
                case 3: {
                    goto label_44;
                }
            }
        }
        catch(Exception unused_ex) {
            return H.a;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_15:
        n.D(enum0);
        LogU.debug$default(this.d, "onPlayWithPlaylistId - mediaId:" + s, null, false, 6, null);
        List list0 = o.R0(s, new String[]{"/"}, 0, 6);
        try {
            if(q.b(list0.get(1), "musicplaylist")) {
                r10.D = 1;
                enum0 = ((b)((d3)s20).a).w(r10);
                if(enum0 == a0) {
                    return a0;
                }
                goto label_27;
            }
            else {
                int v1 = Integer.parseInt(((String)list0.get(1)));
                playlistId0 = PlaylistId.Companion.makePlaylistId(v1);
                goto label_28;
            label_26:
                n.D(enum0);
            label_27:
                playlistId0 = (PlaylistId)enum0;
            }
        label_28:
            B b0 = ((d3)s20).p(playlistId0);
            r10.r = playlistId0;
            r10.D = 2;
            enum0 = ListenableFutureKt.await(b0, r10);
            if(enum0 == a0) {
                return a0;
            }
            goto label_36;
        label_34:
            playlistId0 = r10.r;
            n.D(enum0);
        label_36:
            if(k.y(((oc.H)enum0))) {
                ToastManager.show(z0.f(playlistId0));
                return H.a;
            }
            B b1 = ((d3)s20).a(playlistId0);
            r10.r = null;
            r10.D = 3;
            if(ListenableFutureKt.await(b1, r10) == a0) {
                return a0;
            label_44:
                n.D(enum0);
            }
            z0.u();
        }
        catch(Exception unused_ex) {
        }
        return H.a;
    }

    public final Object e(String s, CType cType0, String s1, boolean z, c c0) {
        AddAction addAction0;
        VideoPlayAndOpen addAction$VideoPlayAndOpen0;
        s1 s10;
        if(c0 instanceof s1) {
            s10 = (s1)c0;
            int v = s10.D;
            if((v & 0x80000000) == 0) {
                s10 = new s1(this, c0);
            }
            else {
                s10.D = v ^ 0x80000000;
            }
        }
        else {
            s10 = new s1(this, c0);
        }
        Object object0 = s10.w;
        ne.a a0 = ne.a.a;
        switch(s10.D) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.d, "onPlayWithServerContent - cId:" + s + ", cType:" + cType0 + ", menuId:" + s1 + ", openPlayer:" + z, null, false, 6, null);
                if(q.b(cType0, CType.MV)) {
                    addAction$VideoPlayAndOpen0 = new VideoPlayAndOpen(true);
                }
                else if(z) {
                    addAction$VideoPlayAndOpen0 = new AddPlayOpenPlayer(false);
                }
                else {
                    addAction$VideoPlayAndOpen0 = new AddPlay(false);
                }
                AddToPlaylist addToPlaylist0 = AddServerContent.Companion.with(cType0, s, s1, addAction$VideoPlayAndOpen0, this.c);
                s10.r = addAction$VideoPlayAndOpen0;
                s10.D = 1;
                object0 = addToPlaylist0.execute(s10);
                if(object0 == a0) {
                    return a0;
                }
                addAction0 = addAction$VideoPlayAndOpen0;
                break;
            }
            case 1: {
                addAction0 = s10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object0).handleToast(addAction0);
        return H.a;
    }
}

