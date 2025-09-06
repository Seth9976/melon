package com.iloen.melon.player.playlist.common;

import M6.B;
import Pc.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import e1.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import je.C;
import je.p;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.z;
import oc.T;
import oc.U;
import oc.w;
import org.jetbrains.annotations.NotNull;
import we.a;
import we.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000E¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001BR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "LPc/d;", "stringProvider", "<init>", "(Lkc/s2;Lob/z;LPc/d;)V", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "userEvent", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lkotlin/Function1;", "Lcom/melon/ui/I4;", "Lie/H;", "sendUiEvent", "handleUserEvent", "(Lcom/iloen/melon/player/playlist/common/DeletePlaylist;Lkotlinx/coroutines/CoroutineScope;Lwe/k;)V", "a", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "b", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "c", "LPc/d;", "getStringProvider", "()LPc/d;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistDeleteHelper {
    public static final int $stable = 8;
    public final s2 a;
    public final z b;
    public final d c;
    public final LogU d;

    @Inject
    public PlaylistDeleteHelper(@NotNull s2 s20, @NotNull z z0, @NotNull d d0) {
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        q.g(d0, "stringProvider");
        super();
        this.a = s20;
        this.b = z0;
        this.c = d0;
        this.d = new LogU("PlaylistDeleteHelper");
    }

    public final Object a(PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, a a1, a a2, Continuation continuation0) {
        int v5;
        List list1;
        k k1;
        s2 s21;
        PlaylistId playlistId1;
        List list2;
        a a5;
        k k2;
        a a4;
        boolean z4;
        boolean z3;
        int v2;
        int v1;
        a a9;
        boolean z7;
        a a8;
        a a15;
        boolean z10;
        a a14;
        a a13;
        Object object1;
        k k4;
        PlaylistId playlistId4;
        PlaylistId playlistId3;
        PlaylistDeleteHelper.deleteInPlaylistByIndices.1 playlistDeleteHelper$deleteInPlaylistByIndices$10;
        if(continuation0 instanceof PlaylistDeleteHelper.deleteInPlaylistByIndices.1) {
            playlistDeleteHelper$deleteInPlaylistByIndices$10 = (PlaylistDeleteHelper.deleteInPlaylistByIndices.1)continuation0;
            int v = playlistDeleteHelper$deleteInPlaylistByIndices$10.X;
            if((v & 0x80000000) == 0) {
                playlistDeleteHelper$deleteInPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInPlaylistByIndices.1(this, continuation0);
            }
            else {
                playlistDeleteHelper$deleteInPlaylistByIndices$10.X = v ^ 0x80000000;
            }
        }
        else {
            playlistDeleteHelper$deleteInPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInPlaylistByIndices.1(this, continuation0);
        }
        Object object0 = playlistDeleteHelper$deleteInPlaylistByIndices$10.V;
        ne.a a3 = ne.a.a;
        z z2 = this.b;
        s2 s20 = this.a;
        H h0 = H.a;
        switch(playlistDeleteHelper$deleteInPlaylistByIndices$10.X) {
            case 0: {
                n.D(object0);
                if(list0.isEmpty()) {
                    LogU.error$default(this.d, "deleteInPlaylist() failed. indices is empty", null, false, 6, null);
                    return h0;
                }
                B b0 = ((d3)s20).h();
                playlistDeleteHelper$deleteInPlaylistByIndices$10.r = playlistId0;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.w = list0;
                a15 = a0;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.B = a15;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.D = k0;
                a14 = a1;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.E = a14;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.G = a2;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.I = playlistId0;
                z10 = z;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.M = z10;
                z7 = z1;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.N = z7;
                playlistDeleteHelper$deleteInPlaylistByIndices$10.X = 1;
                Object object2 = ListenableFutureKt.await(b0, playlistDeleteHelper$deleteInPlaylistByIndices$10);
                if(object2 != a3) {
                    list2 = list0;
                    object1 = object2;
                    a13 = a2;
                    playlistId4 = playlistId0;
                    k4 = k0;
                    playlistId3 = playlistId4;
                label_97:
                    int v4 = playlistId3 == object1 ? 1 : 0;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.r = playlistId4;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.w = list2;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.B = a15;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.D = k4;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.E = a14;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.G = a13;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.I = null;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.M = z10;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.N = z7;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.S = v4;
                    playlistDeleteHelper$deleteInPlaylistByIndices$10.X = 2;
                    Object object3 = z2.l(playlistDeleteHelper$deleteInPlaylistByIndices$10);
                    if(object3 != a3) {
                        k2 = k4;
                        a8 = a15;
                        v2 = v4;
                        playlistId1 = playlistId4;
                        a4 = a13;
                        object0 = object3;
                        a9 = a14;
                        z4 = z10;
                    label_119:
                        v5 = 0;
                        HashSet hashSet2 = p.N0(((Iterable)object0));
                        if(v2 == 0) {
                            s21 = s20;
                        }
                        else {
                            s21 = s20;
                            if(!(list2 instanceof Collection) || !list2.isEmpty()) {
                                for(Object object4: list2) {
                                    if(hashSet2.contains(new Integer(((Number)object4).intValue()))) {
                                        v5 = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        if(v5 == 0) {
                        label_154:
                            if(z7) {
                                a4.invoke();
                                return h0;
                            }
                            a8.invoke();
                            B b1 = ((d3)s21).w(playlistId1, list2);
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.r = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.w = list2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.B = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.D = k2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.E = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.G = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.I = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.M = z4;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.N = false;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.S = v2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.T = v5;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.X = 4;
                            object0 = ListenableFutureKt.await(b1, playlistDeleteHelper$deleteInPlaylistByIndices$10);
                            if(object0 != a3) {
                                k1 = k2;
                                list1 = list2;
                            label_175:
                                if(((U)object0) instanceof T) {
                                    ToastManager.showFormatted(0x7F1307AC, new Object[]{new Integer(list1.size())});  // string:nowplaying_deleted_n_selected "%1$d곡이 삭제되었습니다."
                                }
                                k1.invoke(((U)object0));
                                return h0;
                            }
                        }
                        else {
                            if(z4) {
                                a9.invoke();
                                return h0;
                            }
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.r = playlistId1;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.w = list2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.B = a8;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.D = k2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.E = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.G = a4;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.I = null;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.M = false;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.N = z7;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.S = v2;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.T = v5;
                            playlistDeleteHelper$deleteInPlaylistByIndices$10.X = 3;
                            if(z2.b(0x7F13090F, playlistDeleteHelper$deleteInPlaylistByIndices$10) != a3) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                                z3 = z7;
                                a5 = a8;
                                v1 = v5;
                                v5 = v1;
                                a8 = a5;
                                z7 = z3;
                                goto label_154;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                boolean z8 = playlistDeleteHelper$deleteInPlaylistByIndices$10.N;
                boolean z9 = playlistDeleteHelper$deleteInPlaylistByIndices$10.M;
                playlistId3 = playlistDeleteHelper$deleteInPlaylistByIndices$10.I;
                a a10 = playlistDeleteHelper$deleteInPlaylistByIndices$10.G;
                a a11 = playlistDeleteHelper$deleteInPlaylistByIndices$10.E;
                k k3 = playlistDeleteHelper$deleteInPlaylistByIndices$10.D;
                a a12 = playlistDeleteHelper$deleteInPlaylistByIndices$10.B;
                list2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.w;
                playlistId4 = playlistDeleteHelper$deleteInPlaylistByIndices$10.r;
                n.D(object0);
                z7 = z8;
                k4 = k3;
                object1 = object0;
                a13 = a10;
                a14 = a11;
                z10 = z9;
                a15 = a12;
                goto label_97;
            }
            case 2: {
                int v3 = playlistDeleteHelper$deleteInPlaylistByIndices$10.S;
                boolean z5 = playlistDeleteHelper$deleteInPlaylistByIndices$10.N;
                boolean z6 = playlistDeleteHelper$deleteInPlaylistByIndices$10.M;
                a4 = playlistDeleteHelper$deleteInPlaylistByIndices$10.G;
                a a6 = playlistDeleteHelper$deleteInPlaylistByIndices$10.E;
                k2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.D;
                a a7 = playlistDeleteHelper$deleteInPlaylistByIndices$10.B;
                List list3 = playlistDeleteHelper$deleteInPlaylistByIndices$10.w;
                PlaylistId playlistId2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.r;
                n.D(object0);
                v2 = v3;
                a8 = a7;
                z4 = z6;
                playlistId1 = playlistId2;
                z7 = z5;
                list2 = list3;
                a9 = a6;
                goto label_119;
            }
            case 3: {
                v1 = playlistDeleteHelper$deleteInPlaylistByIndices$10.T;
                v2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.S;
                z3 = playlistDeleteHelper$deleteInPlaylistByIndices$10.N;
                z4 = playlistDeleteHelper$deleteInPlaylistByIndices$10.M;
                HashSet hashSet1 = (HashSet)playlistDeleteHelper$deleteInPlaylistByIndices$10.I;
                a4 = playlistDeleteHelper$deleteInPlaylistByIndices$10.G;
                k2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.D;
                a5 = playlistDeleteHelper$deleteInPlaylistByIndices$10.B;
                list2 = playlistDeleteHelper$deleteInPlaylistByIndices$10.w;
                playlistId1 = playlistDeleteHelper$deleteInPlaylistByIndices$10.r;
                n.D(object0);
                s21 = s20;
                v5 = v1;
                a8 = a5;
                z7 = z3;
                goto label_154;
            }
            case 4: {
                HashSet hashSet0 = (HashSet)playlistDeleteHelper$deleteInPlaylistByIndices$10.I;
                k1 = playlistDeleteHelper$deleteInPlaylistByIndices$10.D;
                list1 = playlistDeleteHelper$deleteInPlaylistByIndices$10.w;
                n.D(object0);
                goto label_175;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a3;
    }

    public static final Object access$deleteInDrawerPlaylistByIndices(PlaylistDeleteHelper playlistDeleteHelper0, List list0, boolean z, boolean z1, a a0, k k0, a a1, a a2, Continuation continuation0) {
        k k1;
        List list1;
        a a5;
        k k2;
        a a4;
        PlaylistId playlistId0;
        boolean z4;
        boolean z3;
        int v2;
        int v1;
        Object object1;
        List list3;
        PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1 playlistDeleteHelper$deleteInDrawerPlaylistByIndices$11;
        int v6;
        PlaylistId playlistId2;
        a a11;
        a a10;
        a a9;
        Iterator iterator1;
        k k4;
        int v5;
        boolean z8;
        boolean z7;
        List list5;
        boolean z12;
        a a17;
        boolean z11;
        Object object2;
        k k6;
        PlaylistId playlistId6;
        PlaylistId playlistId5;
        a a16;
        a a15;
        int v10;
        a a20;
        List list6;
        boolean z13;
        PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1 playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10;
        z z2 = playlistDeleteHelper0.b;
        s2 s20 = playlistDeleteHelper0.a;
        if(continuation0 instanceof PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1) {
            playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10 = (PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1)continuation0;
            int v = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y;
            if((v & 0x80000000) == 0) {
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1(playlistDeleteHelper0, continuation0);
            }
            else {
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y = v ^ 0x80000000;
            }
        }
        else {
            playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInDrawerPlaylistByIndices.1(playlistDeleteHelper0, continuation0);
        }
        Object object0 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.W;
        ne.a a3 = ne.a.a;
        H h0 = H.a;
    alab1:
        switch(playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y) {
            case 0: {
                n.D(object0);
                PlaylistId playlistId7 = PlaylistId.DRAWER;
                B b0 = ((d3)s20).h();
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r = list0;
                a17 = a0;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w = a17;
                k6 = k0;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B = k6;
                a16 = a1;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D = a16;
                a15 = a2;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E = a15;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G = playlistId7;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I = playlistId7;
                z11 = z;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N = z11;
                z12 = z1;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S = z12;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y = 1;
                Object object3 = ListenableFutureKt.await(b0, playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10);
                if(object3 != a3) {
                    playlistId5 = playlistId7;
                    playlistId6 = playlistId5;
                    object2 = object3;
                    list5 = list0;
                label_103:
                    int v7 = playlistId5 == object2 ? 1 : 0;
                    if(v7 == 0) {
                    label_187:
                        list6 = list5;
                        a20 = a16;
                        z4 = z11;
                        a4 = a15;
                        v10 = 0;
                    }
                    else {
                        if(!(list5 instanceof Collection) || !list5.isEmpty()) {
                            int v8 = v7;
                            PlaylistId playlistId8 = playlistId6;
                            boolean z14 = z11;
                            boolean z15 = z12;
                            k k7 = k6;
                            a a18 = a15;
                            a a19 = a17;
                            int v9 = 0;
                            Iterator iterator2 = list5.iterator();
                            while(iterator2.hasNext()) {
                                Object object4 = iterator2.next();
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r = list5;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w = a19;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B = k7;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D = a16;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E = a18;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G = playlistId8;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I = null;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.M = iterator2;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N = z14;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S = z15;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.T = v8;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.V = v9;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y = 2;
                                object1 = z2.m(((Number)object4).intValue(), playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10);
                                if(object1 == a3) {
                                    break alab1;
                                }
                                z7 = z14;
                                z8 = z15;
                                v5 = v8;
                                k4 = k7;
                                iterator1 = iterator2;
                                a9 = a19;
                                a10 = a16;
                                a11 = a18;
                                playlistId2 = playlistId8;
                                v6 = v9;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$11 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10;
                                list3 = list5;
                            label_146:
                                if(((Boolean)object1).booleanValue()) {
                                    a15 = a11;
                                    a16 = a10;
                                    list5 = list3;
                                    playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$11;
                                    a17 = a9;
                                    v7 = v5;
                                    z12 = z8;
                                    z11 = z7;
                                    z13 = true;
                                    playlistId6 = playlistId2;
                                    k6 = k4;
                                    goto label_180;
                                }
                                list5 = list3;
                                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$11;
                                v9 = v6;
                                playlistId8 = playlistId2;
                                a18 = a11;
                                a16 = a10;
                                a19 = a9;
                                iterator2 = iterator1;
                                k7 = k4;
                                v8 = v5;
                                z15 = z8;
                                z14 = z7;
                            }
                            a17 = a19;
                            z11 = z14;
                            playlistId6 = playlistId8;
                            a15 = a18;
                            k6 = k7;
                            v7 = v8;
                            z12 = z15;
                        }
                        z13 = false;
                    label_180:
                        if(z13) {
                            list6 = list5;
                            a20 = a16;
                            z4 = z11;
                            a4 = a15;
                            v10 = 1;
                            goto label_192;
                        }
                        goto label_187;
                    }
                label_192:
                    a5 = a17;
                    v2 = v7;
                    k2 = k6;
                    z3 = z12;
                    if(v10 == 0) {
                    label_220:
                        if(z3) {
                            a4.invoke();
                            return h0;
                        }
                        a5.invoke();
                        B b1 = ((d3)s20).w(playlistId6, list6);
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B = k2;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.M = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N = z4;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S = false;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.T = v2;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.V = v10;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y = 4;
                        object0 = ListenableFutureKt.await(b1, playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10);
                        if(object0 != a3) {
                            k1 = k2;
                            k1.invoke(((U)object0));
                            return h0;
                        }
                    }
                    else {
                        if(z4) {
                            a20.invoke();
                            return h0;
                        }
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r = list6;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w = a5;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B = k2;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E = a4;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G = playlistId6;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.M = null;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N = false;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S = z3;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.T = v2;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.V = v10;
                        playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.Y = 3;
                        if(z2.b(0x7F13090F, playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10) != a3) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                            v1 = v10;
                            playlistId0 = playlistId6;
                            list1 = list6;
                            list6 = list1;
                            playlistId6 = playlistId0;
                            v10 = v1;
                            goto label_220;
                        }
                    }
                }
                break;
            }
            case 1: {
                boolean z9 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S;
                boolean z10 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N;
                PlaylistId playlistId3 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I;
                PlaylistId playlistId4 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G;
                a a12 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E;
                a a13 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D;
                k k5 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B;
                a a14 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w;
                List list4 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r;
                n.D(object0);
                a15 = a12;
                a16 = a13;
                playlistId5 = playlistId3;
                playlistId6 = playlistId4;
                k6 = k5;
                object2 = object0;
                z11 = z10;
                a17 = a14;
                z12 = z9;
                list5 = list4;
                goto label_103;
            }
            case 2: {
                int v3 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.V;
                int v4 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.T;
                boolean z5 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S;
                boolean z6 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N;
                Iterator iterator0 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.M;
                Iterable iterable0 = (Iterable)playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.I;
                PlaylistId playlistId1 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G;
                a a6 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E;
                a a7 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.D;
                k k3 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B;
                a a8 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w;
                List list2 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r;
                n.D(object0);
                z7 = z6;
                z8 = z5;
                v5 = v4;
                k4 = k3;
                iterator1 = iterator0;
                a9 = a8;
                a10 = a7;
                a11 = a6;
                playlistId2 = playlistId1;
                v6 = v3;
                playlistDeleteHelper$deleteInDrawerPlaylistByIndices$11 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10;
                list3 = list2;
                object1 = object0;
                goto label_146;
            }
            case 3: {
                v1 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.V;
                v2 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.T;
                z3 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.S;
                z4 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.N;
                playlistId0 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.G;
                a4 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.E;
                k2 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B;
                a5 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.w;
                list1 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.r;
                n.D(object0);
                list6 = list1;
                playlistId6 = playlistId0;
                v10 = v1;
                goto label_220;
            }
            case 4: {
                k1 = playlistDeleteHelper$deleteInDrawerPlaylistByIndices$10.B;
                n.D(object0);
                k1.invoke(((U)object0));
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a3;
    }

    public static final Object access$deleteInPlaylistByPlayables(PlaylistDeleteHelper playlistDeleteHelper0, PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, a a1, a a2, Continuation continuation0) {
        List list1;
        boolean z3;
        a a6;
        boolean z2;
        a a5;
        a a4;
        k k1;
        PlaylistDeleteHelper.deleteInPlaylistByPlayables.1 playlistDeleteHelper$deleteInPlaylistByPlayables$10;
        playlistDeleteHelper0.getClass();
        if(continuation0 instanceof PlaylistDeleteHelper.deleteInPlaylistByPlayables.1) {
            playlistDeleteHelper$deleteInPlaylistByPlayables$10 = (PlaylistDeleteHelper.deleteInPlaylistByPlayables.1)continuation0;
            int v = playlistDeleteHelper$deleteInPlaylistByPlayables$10.T;
            if((v & 0x80000000) == 0) {
                playlistDeleteHelper$deleteInPlaylistByPlayables$10 = new PlaylistDeleteHelper.deleteInPlaylistByPlayables.1(playlistDeleteHelper0, continuation0);
            }
            else {
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.T = v ^ 0x80000000;
            }
        }
        else {
            playlistDeleteHelper$deleteInPlaylistByPlayables$10 = new PlaylistDeleteHelper.deleteInPlaylistByPlayables.1(playlistDeleteHelper0, continuation0);
        }
        Object object0 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.N;
        ne.a a3 = ne.a.a;
        switch(playlistDeleteHelper$deleteInPlaylistByPlayables$10.T) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)playlistDeleteHelper0.a).p(playlistId0);
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.r = playlistId0;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.w = list0;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.B = a0;
                k1 = k0;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.D = k1;
                a4 = a1;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.E = a4;
                a5 = a2;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.G = a5;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.I = z;
                z2 = z1;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.M = z2;
                playlistDeleteHelper$deleteInPlaylistByPlayables$10.T = 1;
                object0 = ListenableFutureKt.await(b0, playlistDeleteHelper$deleteInPlaylistByPlayables$10);
                if(object0 == a3) {
                    return a3;
                }
                a6 = a0;
                z3 = z;
                list1 = list0;
                break;
            }
            case 1: {
                boolean z4 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.M;
                z3 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.I;
                a a7 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.G;
                a a8 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.E;
                k k2 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.D;
                a a9 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.B;
                list1 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.w;
                PlaylistId playlistId1 = playlistDeleteHelper$deleteInPlaylistByPlayables$10.r;
                n.D(object0);
                z2 = z4;
                playlistId0 = playlistId1;
                a5 = a7;
                a6 = a9;
                a4 = a8;
                k1 = k2;
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ArrayList arrayList0 = b.B(((oc.H)object0).getState());
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        int v1 = 0;
        Iterator iterator0 = arrayList0.iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            if(v1 >= 0) {
                arrayList1.add(new m("", new Integer(v1)));
                ++v1;
                continue;
            }
            e.k.O();
            throw null;
        }
        Map map0 = C.Y(arrayList1);
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator1 = list1.iterator();
        while(iterator1.hasNext()) {
            iterator1.next();
            Integer integer0 = (Integer)map0.get("");
            if(integer0 != null) {
                arrayList2.add(integer0);
            }
        }
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.r = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.w = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.B = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.D = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.E = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.G = null;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.I = z3;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.M = z2;
        playlistDeleteHelper$deleteInPlaylistByPlayables$10.T = 2;
        return playlistDeleteHelper0.a(playlistId0, arrayList2, z3, z2, a6, k1, a4, a5, playlistDeleteHelper$deleteInPlaylistByPlayables$10) == a3 ? a3 : H.a;
    }

    public static final Object access$deleteInViewModeDrawerPlaylistByIndices(PlaylistDeleteHelper playlistDeleteHelper0, nc.a a0, List list0, boolean z, a a1, k k0, a a2, Continuation continuation0) {
        PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1 playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10;
        playlistDeleteHelper0.getClass();
        if(continuation0 instanceof PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1) {
            playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10 = (PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1)continuation0;
            int v = playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.D;
            if((v & 0x80000000) == 0) {
                playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1(playlistDeleteHelper0, continuation0);
            }
            else {
                playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.D = v ^ 0x80000000;
            }
        }
        else {
            playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10 = new PlaylistDeleteHelper.deleteInViewModeDrawerPlaylistByIndices.1(playlistDeleteHelper0, continuation0);
        }
        Object object0 = playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.w;
        ne.a a3 = ne.a.a;
        H h0 = H.a;
        switch(playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.D) {
            case 0: {
                n.D(object0);
                if(z) {
                    a2.invoke();
                    return h0;
                }
                a1.invoke();
                q.e(a0, "null cannot be cast to non-null type com.melon.playlist.interfaces.MutablePlaylist<*>");
                playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.r = k0;
                playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.D = 1;
                object0 = ((w)a0).i(list0, playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10);
                if(object0 == a3) {
                    return a3;
                }
                break;
            }
            case 1: {
                k0 = playlistDeleteHelper$deleteInViewModeDrawerPlaylistByIndices$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        k0.invoke(((U)object0));
        return h0;
    }

    @NotNull
    public final z getPlayerUseCase() {
        return this.b;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        return this.a;
    }

    @NotNull
    public final d getStringProvider() {
        return this.c;
    }

    public final void handleUserEvent(@NotNull DeletePlaylist deletePlaylist0, @NotNull CoroutineScope coroutineScope0, @NotNull k k0) {
        q.g(deletePlaylist0, "userEvent");
        q.g(coroutineScope0, "viewModelScope");
        q.g(k0, "sendUiEvent");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new we.n(this, k0, null) {
            public final PlaylistDeleteHelper B;
            public final k D;
            public int r;
            public final DeletePlaylist w;

            {
                this.w = deletePlaylist0;
                this.B = playlistDeleteHelper0;
                this.D = k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.common.PlaylistDeleteHelper.handleUserEvent.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.common.PlaylistDeleteHelper.handleUserEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        DeletePlaylist deletePlaylist0 = this.w;
                        PlaylistDeleteHelper playlistDeleteHelper0 = this.B;
                        k k0 = this.D;
                        if(deletePlaylist0 instanceof DeletePlaylistByIndices) {
                            PlaylistId playlistId0 = ((DeletePlaylistByIndices)deletePlaylist0).getPlaylistId();
                            List list0 = ((DeletePlaylistByIndices)deletePlaylist0).getIndices();
                            boolean z = ((DeletePlaylistByIndices)deletePlaylist0).getConfirmWhenOnSelectRepeat();
                            boolean z1 = ((DeletePlaylistByIndices)deletePlaylist0).getConfirmBeforeDelete();
                            a a1 = ((DeletePlaylistByIndices)deletePlaylist0).getBeforeDeleteTask();
                            k k1 = ((DeletePlaylistByIndices)deletePlaylist0).getAfterDeleteTask();
                            com.iloen.melon.player.playlist.common.k k2 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 0);
                            com.iloen.melon.player.playlist.common.k k3 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 1);
                            this.r = 1;
                            return playlistDeleteHelper0.a(playlistId0, list0, z, z1, a1, k1, k2, k3, this) != a0 ? H.a : a0;
                        }
                        if(deletePlaylist0 instanceof DeletePlaylistByPlayables) {
                            PlaylistId playlistId1 = ((DeletePlaylistByPlayables)deletePlaylist0).getPlaylistId();
                            List list1 = ((DeletePlaylistByPlayables)deletePlaylist0).getPlayables();
                            boolean z2 = ((DeletePlaylistByPlayables)deletePlaylist0).getConfirmWhenOnSelectRepeat();
                            boolean z3 = ((DeletePlaylistByPlayables)deletePlaylist0).getConfirmBeforeDelete();
                            a a2 = ((DeletePlaylistByPlayables)deletePlaylist0).getBeforeDeleteTask();
                            k k4 = ((DeletePlaylistByPlayables)deletePlaylist0).getAfterDeleteTask();
                            com.iloen.melon.player.playlist.common.k k5 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 2);
                            com.iloen.melon.player.playlist.common.k k6 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 3);
                            this.r = 2;
                            return PlaylistDeleteHelper.access$deleteInPlaylistByPlayables(playlistDeleteHelper0, playlistId1, list1, z2, z3, a2, k4, k5, k6, this) != a0 ? H.a : a0;
                        }
                        if(deletePlaylist0 instanceof DeleteDrawerPlaylist) {
                            List list2 = ((DeleteDrawerPlaylist)deletePlaylist0).getIndices();
                            boolean z4 = ((DeleteDrawerPlaylist)deletePlaylist0).getConfirmWhenOnSelectRepeat();
                            boolean z5 = ((DeleteDrawerPlaylist)deletePlaylist0).getConfirmBeforeDelete();
                            a a3 = ((DeleteDrawerPlaylist)deletePlaylist0).getBeforeDeleteTask();
                            k k7 = ((DeleteDrawerPlaylist)deletePlaylist0).getAfterDeleteTask();
                            com.iloen.melon.player.playlist.common.k k8 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 4);
                            com.iloen.melon.player.playlist.common.k k9 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 5);
                            this.r = 3;
                            return PlaylistDeleteHelper.access$deleteInDrawerPlaylistByIndices(playlistDeleteHelper0, list2, z4, z5, a3, k7, k8, k9, this) != a0 ? H.a : a0;
                        }
                        if(!(deletePlaylist0 instanceof DeleteViewModeDrawerPlaylist)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        nc.a a4 = ((DeleteViewModeDrawerPlaylist)deletePlaylist0).getViewModeDrawerPlaylist();
                        List list3 = ((DeleteViewModeDrawerPlaylist)deletePlaylist0).getIndices();
                        boolean z6 = ((DeleteViewModeDrawerPlaylist)deletePlaylist0).getConfirmBeforeDelete();
                        a a5 = ((DeleteViewModeDrawerPlaylist)deletePlaylist0).getBeforeDeleteTask();
                        k k10 = ((DeleteViewModeDrawerPlaylist)deletePlaylist0).getAfterDeleteTask();
                        com.iloen.melon.player.playlist.common.k k11 = new com.iloen.melon.player.playlist.common.k(k0, deletePlaylist0, 6);
                        this.r = 4;
                        return PlaylistDeleteHelper.access$deleteInViewModeDrawerPlaylistByIndices(playlistDeleteHelper0, a4, list3, z6, a5, k10, k11, this) == a0 ? a0 : H.a;
                    }
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }
}

