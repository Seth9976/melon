package com.iloen.melon.playback.playlist.add;

import H0.b;
import M6.B;
import Ma.m;
import Qb.z;
import Ub.s;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.exception.MelonNetworkError;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import je.p;
import k8.o;
import k8.t;
import kc.d3;
import kc.s2;
import kc.t2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.H;
import oc.V;
import oc.W;
import oc.X;
import oc.Y;
import oc.Z;
import oc.b0;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.F;

@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 N2\u00020\u0001:\u0001NJ(\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0082@\u00A2\u0006\u0004\b\t\u0010\nJ$\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\f0\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0082@\u00A2\u0006\u0004\b\u000F\u0010\u0010J$\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\f0\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0082@\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u000F\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0014\u0010\u001C\u001A\u00020\u0006*\u00020\u001BH\u0096@\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0004H\u00A6@\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\bH\u0096@\u00A2\u0006\u0004\b \u0010\u001FJ\u001A\u0010\"\u001A\u0004\u0018\u00010!2\u0006\u0010\u0007\u001A\u00020\u0006H\u0096@\u00A2\u0006\u0004\b\"\u0010#R\u0014\u0010&\u001A\u00020\u00158&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b$\u0010%R\u0016\u0010*\u001A\u0004\u0018\u00010\'8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b(\u0010)R\u0014\u0010.\u001A\u00020+8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010-R\u0014\u00101\u001A\u00020\u001B8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b/\u00100R\u001C\u00102\u001A\u00020\u00128&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b2\u0010\u0014\"\u0004\b3\u00104R\u0014\u00105\u001A\u00020\u00128&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u0010\u0014R\u0014\u00107\u001A\u00020\u00128&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b6\u0010\u0014R\u0014\u0010;\u001A\u0002088&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b9\u0010:R\u0016\u0010?\u001A\u0004\u0018\u00010<8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b=\u0010>R\u0014\u0010\u0003\u001A\u00020\u00028VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b@\u0010AR\u0014\u0010E\u001A\u00020B8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bC\u0010DR\u0014\u0010I\u001A\u00020F8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bG\u0010HR\u0014\u0010M\u001A\u00020J8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bK\u0010L\u0082\u0001\u0004OPQR\u00A8\u0006S\u00C0\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddToPlaylist;", "", "Lkc/s2;", "playlistManager", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "addPlayableListInfo", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "Lcom/iloen/melon/playback/playlist/add/AddResult;", "doAdd", "(Lkc/s2;Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lcom/iloen/melon/playback/playlist/PlaylistId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/iloen/melon/playback/Playable;", "playables", "", "getListToRemoveExcludedArtists", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListToRemoveExcludedGenre", "", "isVideoContents", "()Z", "", "checkRemoteConnectIfNeededWithToastMsg", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)Ljava/lang/String;", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "getSuccessExtra", "(Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;)Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "Lcom/iloen/melon/constants/CType;", "getPlaylistId", "(Lcom/iloen/melon/constants/CType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAddPlayableListInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "checkPreCondition", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuId", "()Ljava/lang/String;", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElements", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "getAddAction", "()Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "getCType", "()Lcom/iloen/melon/constants/CType;", "cType", "isAllowedBannedContents", "setAllowedBannedContents", "(Z)V", "isExcludeGenre", "getNeedToClear", "needToClear", "Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "getDeviceConnectInfo", "()Lcom/iloen/melon/playback/playlist/add/DeviceConnectableInfo;", "deviceConnectInfo", "Lcom/iloen/melon/custom/L0;", "getProgressUpdater", "()Lcom/iloen/melon/custom/L0;", "progressUpdater", "getPlaylistManager", "()Lkc/s2;", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "playerUseCase", "LQb/z;", "getPlayerController", "()LQb/z;", "playerController", "LUb/s;", "getRemotePlayerManager", "()LUb/s;", "remotePlayerManager", "Companion", "Lcom/iloen/melon/playback/playlist/add/AddContentUri;", "Lcom/iloen/melon/playback/playlist/add/AddPlayServiceScheme;", "Lcom/iloen/melon/playback/playlist/add/AddPlayableList;", "Lcom/iloen/melon/playback/playlist/add/AddServerContent;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface AddToPlaylist {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddToPlaylist$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE = null;
        @NotNull
        public static final String TAG = "AddToPlaylist";

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object checkPreCondition(@NotNull AddToPlaylist addToPlaylist0, @NotNull PlaylistId playlistId0, @NotNull Continuation continuation0) {
            return addToPlaylist0.super.checkPreCondition(playlistId0, continuation0);
        }

        @Deprecated
        @Nullable
        public static Object execute(@NotNull AddToPlaylist addToPlaylist0, @NotNull Continuation continuation0) {
            return addToPlaylist0.super.execute(continuation0);
        }

        @Deprecated
        @NotNull
        public static z getPlayerController(@NotNull AddToPlaylist addToPlaylist0) {
            return addToPlaylist0.super.getPlayerController();
        }

        @Deprecated
        @NotNull
        public static ob.z getPlayerUseCase(@NotNull AddToPlaylist addToPlaylist0) {
            return addToPlaylist0.super.getPlayerUseCase();
        }

        @Deprecated
        @Nullable
        public static Object getPlaylistId(@NotNull AddToPlaylist addToPlaylist0, @NotNull CType cType0, @NotNull Continuation continuation0) {
            return addToPlaylist0.super.getPlaylistId(cType0, continuation0);
        }

        @Deprecated
        @NotNull
        public static s2 getPlaylistManager(@NotNull AddToPlaylist addToPlaylist0) {
            return addToPlaylist0.super.getPlaylistManager();
        }

        @Deprecated
        @NotNull
        public static s getRemotePlayerManager(@NotNull AddToPlaylist addToPlaylist0) {
            return addToPlaylist0.super.getRemotePlayerManager();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[PlaylistId.values().length];
            try {
                arr_v[PlaylistId.MUSIC_WAVE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.VOD.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.LIVE.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "AddToPlaylist";

    static {
        AddToPlaylist.Companion = Companion.$$INSTANCE;
    }

    @Nullable
    default Object checkPreCondition(@NotNull PlaylistId playlistId0, @NotNull Continuation continuation0) {
        return AddToPlaylist.checkPreCondition$suspendImpl(this, playlistId0, continuation0);
    }

    static Object checkPreCondition$suspendImpl(AddToPlaylist addToPlaylist0, PlaylistId playlistId0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.add.AddToPlaylist.checkPreCondition.1 addToPlaylist$checkPreCondition$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddToPlaylist.checkPreCondition.1) {
            addToPlaylist$checkPreCondition$10 = (com.iloen.melon.playback.playlist.add.AddToPlaylist.checkPreCondition.1)continuation0;
            int v = addToPlaylist$checkPreCondition$10.label;
            if((v & 0x80000000) == 0) {
                addToPlaylist$checkPreCondition$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return AddToPlaylist.checkPreCondition$suspendImpl(addToPlaylist0, null, this);
                    }
                };
            }
            else {
                addToPlaylist$checkPreCondition$10.label = v ^ 0x80000000;
            }
        }
        else {
            addToPlaylist$checkPreCondition$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return AddToPlaylist.checkPreCondition$suspendImpl(addToPlaylist0, null, this);
                }
            };
        }
        Object object0 = addToPlaylist$checkPreCondition$10.result;
        a a0 = a.a;
        switch(addToPlaylist$checkPreCondition$10.label) {
            case 0: {
                n.D(object0);
                MelonAppBase.Companion.getClass();
                if(t.a().isCarConnected() && addToPlaylist0.isVideoContents()) {
                    LogU.Companion.d("AddToPlaylist", "execute() ignore - caused by videoplaylist");
                    return VideoOpenWhenAuto.INSTANCE;
                }
                AddAction addAction0 = addToPlaylist0.getAddAction();
                s2 s20 = addToPlaylist0.getPlaylistManager();
                ob.z z0 = addToPlaylist0.getPlayerUseCase();
                s s0 = addToPlaylist0.getRemotePlayerManager();
                addToPlaylist$checkPreCondition$10.L$0 = null;
                addToPlaylist$checkPreCondition$10.L$1 = null;
                addToPlaylist$checkPreCondition$10.label = 1;
                object0 = addAction0.checkCanAdded(s20, z0, playlistId0, s0, addToPlaylist$checkPreCondition$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                PlaylistId playlistId1 = (PlaylistId)addToPlaylist$checkPreCondition$10.L$1;
                AddToPlaylist addToPlaylist1 = (AddToPlaylist)addToPlaylist$checkPreCondition$10.L$0;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((AddFailType)object0) != null ? ((AddFailType)object0) : null;
    }

    default private String checkRemoteConnectIfNeededWithToastMsg(PlaylistId playlistId0) {
        if(!this.getDeviceConnectInfo().getCanChromeCast() && ((Ub.t)this.getRemotePlayerManager()).d()) {
            ((Ub.t)this.getRemotePlayerManager()).b.f("AddToPlaylist", null);
            return WhenMappings.$EnumSwitchMapping$0[playlistId0.ordinal()] == 1 ? "" : "";
        }
        if(!this.getDeviceConnectInfo().getCanDlna() && ((Ub.t)this.getRemotePlayerManager()).e()) {
            ((Ub.t)this.getRemotePlayerManager()).c.g("AddToPlaylist", null);
            switch(WhenMappings.$EnumSwitchMapping$0[playlistId0.ordinal()]) {
                case 1: {
                    return "";
                }
                case 2: 
                case 3: {
                    return "";
                }
                default: {
                    return "";
                }
            }
        }
        return "";
    }

    default private Object doAdd(s2 s20, AddRequestPlayableListInfo addRequestPlayableListInfo0, PlaylistId playlistId0, Continuation continuation0) {
        AddRequestPlayableListInfo addRequestPlayableListInfo1;
        s2 s23;
        AddRequestPlayableListInfo addRequestPlayableListInfo2;
        PlaylistId playlistId3;
        H h2;
        AddPosition addPosition2;
        int v5;
        int v4;
        int v3;
        AddPosition addPosition4;
        Object object1;
        List list12;
        s2 s25;
        AddRequestPlayableListInfo addRequestPlayableListInfo3;
        com.iloen.melon.playback.playlist.add.AddToPlaylist.doAdd.1 addToPlaylist$doAdd$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddToPlaylist.doAdd.1) {
            addToPlaylist$doAdd$10 = (com.iloen.melon.playback.playlist.add.AddToPlaylist.doAdd.1)continuation0;
            int v = addToPlaylist$doAdd$10.label;
            if((v & 0x80000000) == 0) {
                addToPlaylist$doAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    Object L$9;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.doAdd(null, null, null, this);
                    }
                };
            }
            else {
                addToPlaylist$doAdd$10.label = v ^ 0x80000000;
            }
        }
        else {
            addToPlaylist$doAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                Object L$8;
                Object L$9;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.doAdd(null, null, null, this);
                }
            };
        }
        Object object0 = addToPlaylist$doAdd$10.result;
        a a0 = a.a;
        ListKeepOption listKeepOption0 = ListKeepOption.c;
        switch(addToPlaylist$doAdd$10.label) {
            case 0: {
                n.D(object0);
                list12 = addRequestPlayableListInfo0.getUserRequestedPlaylist();
                if(list12.isEmpty()) {
                    LogU.Companion.d("AddToPlaylist", "doAdd() strategy list is empty");
                    return new Failure(Normal.INSTANCE);
                }
                s25 = (d3)s20;
                B b1 = ((d3)s25).p(playlistId0);
                addToPlaylist$doAdd$10.L$0 = s25;
                addRequestPlayableListInfo3 = addRequestPlayableListInfo0;
                addToPlaylist$doAdd$10.L$1 = addRequestPlayableListInfo3;
                addToPlaylist$doAdd$10.L$2 = playlistId0;
                addToPlaylist$doAdd$10.L$3 = list12;
                addToPlaylist$doAdd$10.label = 1;
                object1 = ListenableFutureKt.await(b1, addToPlaylist$doAdd$10);
                if(object1 != a0) {
                label_141:
                    AddAction addAction4 = this.getAddAction();
                    int v8 = !(addAction4 instanceof ShufflePlay) || !((ShufflePlay)addAction4).isShufflePlay() ? 0 : 1;
                    if(v8 != 0) {
                        q.g(list12, "<this>");
                        list12 = p.R0(list12);
                        Collections.shuffle(list12);
                    }
                    AddPosition addPosition5 = ((H)object1).C();
                    addRequestPlayableListInfo3.setUserRequestedPlaylist(list12);
                    V v9 = new V(!(addAction4 instanceof Add) && ((H)object1).x() == listKeepOption0 || this.getNeedToClear(), MelonSettingInfo.getUseRemoveDuplicatedPlaylist(), addRequestPlayableListInfo3, addPosition5, !(addAction4 instanceof Add));
                    ((d3)s25).getClass();
                    t2 t21 = new t2(((d3)s25), playlistId0, v9, null);
                    B b2 = ListenableFutureKt.future$default(((d3)s25).b, null, null, t21, 3, null);
                    addToPlaylist$doAdd$10.L$0 = null;
                    addToPlaylist$doAdd$10.L$1 = addRequestPlayableListInfo3;
                    addToPlaylist$doAdd$10.L$2 = null;
                    addToPlaylist$doAdd$10.L$3 = null;
                    addToPlaylist$doAdd$10.L$4 = null;
                    addToPlaylist$doAdd$10.L$5 = null;
                    addToPlaylist$doAdd$10.L$6 = null;
                    addToPlaylist$doAdd$10.L$7 = null;
                    addToPlaylist$doAdd$10.L$8 = null;
                    addToPlaylist$doAdd$10.I$0 = v8;
                    addToPlaylist$doAdd$10.I$1 = list12.size();
                    addToPlaylist$doAdd$10.I$2 = addAction4 instanceof Add;
                    addToPlaylist$doAdd$10.label = 5;
                    object0 = ListenableFutureKt.await(b2, addToPlaylist$doAdd$10);
                    if(object0 != a0) {
                        addRequestPlayableListInfo1 = addRequestPlayableListInfo3;
                    label_169:
                        if(((b0)object0) instanceof Z) {
                            return new Success(((b0)object0), this.getSuccessExtra(addRequestPlayableListInfo1), null, 4, null);
                        }
                        if(((b0)object0) instanceof X) {
                            return new Success(((b0)object0), this.getSuccessExtra(addRequestPlayableListInfo1), null, 4, null);
                        }
                        if(((b0)object0) instanceof Y) {
                            return new Success(((b0)object0), this.getSuccessExtra(addRequestPlayableListInfo1), null, 4, null);
                        }
                        if(!(((b0)object0) instanceof W)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        return new Failure(Normal.INSTANCE);
                    }
                }
                break;
            }
            case 1: {
                List list11 = (List)addToPlaylist$doAdd$10.L$3;
                PlaylistId playlistId4 = (PlaylistId)addToPlaylist$doAdd$10.L$2;
                addRequestPlayableListInfo3 = (AddRequestPlayableListInfo)addToPlaylist$doAdd$10.L$1;
                s25 = (s2)addToPlaylist$doAdd$10.L$0;
                n.D(object0);
                list12 = list11;
                playlistId0 = playlistId4;
                object1 = object0;
                goto label_141;
            }
            case 2: {
                v3 = addToPlaylist$doAdd$10.I$2;
                v4 = addToPlaylist$doAdd$10.I$1;
                v5 = addToPlaylist$doAdd$10.I$0;
                AddPosition addPosition3 = (AddPosition)addToPlaylist$doAdd$10.L$7;
                List list8 = (List)addToPlaylist$doAdd$10.L$6;
                AddAction addAction3 = (AddAction)addToPlaylist$doAdd$10.L$5;
                H h3 = (H)addToPlaylist$doAdd$10.L$4;
                List list9 = (List)addToPlaylist$doAdd$10.L$3;
                playlistId3 = (PlaylistId)addToPlaylist$doAdd$10.L$2;
                addRequestPlayableListInfo2 = (AddRequestPlayableListInfo)addToPlaylist$doAdd$10.L$1;
                s2 s24 = (s2)addToPlaylist$doAdd$10.L$0;
                n.D(object0);
                List list10 = (List)object0;
                if(this.isExcludeGenre()) {
                    addToPlaylist$doAdd$10.L$0 = s24;
                    addToPlaylist$doAdd$10.L$1 = addRequestPlayableListInfo2;
                    addToPlaylist$doAdd$10.L$2 = playlistId3;
                    addToPlaylist$doAdd$10.L$3 = null;
                    addToPlaylist$doAdd$10.L$4 = h3;
                    addToPlaylist$doAdd$10.L$5 = null;
                    addToPlaylist$doAdd$10.L$6 = null;
                    addToPlaylist$doAdd$10.L$7 = addPosition3;
                    addToPlaylist$doAdd$10.L$8 = null;
                    addToPlaylist$doAdd$10.I$0 = v5;
                    addToPlaylist$doAdd$10.I$1 = v4;
                    addToPlaylist$doAdd$10.I$2 = v3;
                    addToPlaylist$doAdd$10.label = 3;
                    object0 = this.getListToRemoveExcludedGenre(list10, addToPlaylist$doAdd$10);
                    if(object0 != a0) {
                        addPosition2 = addPosition3;
                        h2 = h3;
                        s23 = s24;
                    label_83:
                        list10 = (List)object0;
                        addPosition4 = addPosition2;
                        s24 = s23;
                        h3 = h2;
                        goto label_89;
                    }
                }
                else {
                    addPosition4 = addPosition3;
                label_89:
                    int v6 = list10.size();
                    if(v4 > 0 && v6 == 0) {
                        return new Failure(AddAllBan.INSTANCE);
                    }
                    addRequestPlayableListInfo2.setUserRequestedPlaylist(list10);
                    V v7 = new V(v3 == 0 && h3.x() == listKeepOption0 || this.getNeedToClear(), MelonSettingInfo.getUseRemoveDuplicatedPlaylist(), addRequestPlayableListInfo2, addPosition4, v3 == 0);
                    ((d3)s24).getClass();
                    q.g(playlistId3, "playlistId");
                    t2 t20 = new t2(((d3)s24), playlistId3, v7, null);
                    B b0 = ListenableFutureKt.future$default(((d3)s24).b, null, null, t20, 3, null);
                    addToPlaylist$doAdd$10.L$0 = null;
                    addToPlaylist$doAdd$10.L$1 = addRequestPlayableListInfo2;
                    addToPlaylist$doAdd$10.L$2 = null;
                    addToPlaylist$doAdd$10.L$3 = null;
                    addToPlaylist$doAdd$10.L$4 = null;
                    addToPlaylist$doAdd$10.L$5 = null;
                    addToPlaylist$doAdd$10.L$6 = null;
                    addToPlaylist$doAdd$10.L$7 = null;
                    addToPlaylist$doAdd$10.L$8 = null;
                    addToPlaylist$doAdd$10.L$9 = null;
                    addToPlaylist$doAdd$10.I$0 = v5;
                    addToPlaylist$doAdd$10.I$1 = v4;
                    addToPlaylist$doAdd$10.I$2 = v3;
                    addToPlaylist$doAdd$10.I$3 = v6;
                    addToPlaylist$doAdd$10.label = 4;
                    object0 = ListenableFutureKt.await(b0, addToPlaylist$doAdd$10);
                    if(object0 != a0) {
                        addRequestPlayableListInfo1 = addRequestPlayableListInfo2;
                        goto label_169;
                    }
                }
                break;
            }
            case 3: {
                v3 = addToPlaylist$doAdd$10.I$2;
                v4 = addToPlaylist$doAdd$10.I$1;
                v5 = addToPlaylist$doAdd$10.I$0;
                List list5 = (List)addToPlaylist$doAdd$10.L$8;
                addPosition2 = (AddPosition)addToPlaylist$doAdd$10.L$7;
                List list6 = (List)addToPlaylist$doAdd$10.L$6;
                AddAction addAction2 = (AddAction)addToPlaylist$doAdd$10.L$5;
                h2 = (H)addToPlaylist$doAdd$10.L$4;
                List list7 = (List)addToPlaylist$doAdd$10.L$3;
                playlistId3 = (PlaylistId)addToPlaylist$doAdd$10.L$2;
                addRequestPlayableListInfo2 = (AddRequestPlayableListInfo)addToPlaylist$doAdd$10.L$1;
                s23 = (s2)addToPlaylist$doAdd$10.L$0;
                n.D(object0);
                goto label_83;
            }
            case 4: {
                V v2 = (V)addToPlaylist$doAdd$10.L$9;
                List list2 = (List)addToPlaylist$doAdd$10.L$8;
                AddPosition addPosition1 = (AddPosition)addToPlaylist$doAdd$10.L$7;
                List list3 = (List)addToPlaylist$doAdd$10.L$6;
                AddAction addAction1 = (AddAction)addToPlaylist$doAdd$10.L$5;
                H h1 = (H)addToPlaylist$doAdd$10.L$4;
                List list4 = (List)addToPlaylist$doAdd$10.L$3;
                PlaylistId playlistId2 = (PlaylistId)addToPlaylist$doAdd$10.L$2;
                addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addToPlaylist$doAdd$10.L$1;
                s2 s22 = (s2)addToPlaylist$doAdd$10.L$0;
                n.D(object0);
                goto label_169;
            }
            case 5: {
                V v1 = (V)addToPlaylist$doAdd$10.L$8;
                AddPosition addPosition0 = (AddPosition)addToPlaylist$doAdd$10.L$7;
                List list0 = (List)addToPlaylist$doAdd$10.L$6;
                AddAction addAction0 = (AddAction)addToPlaylist$doAdd$10.L$5;
                H h0 = (H)addToPlaylist$doAdd$10.L$4;
                List list1 = (List)addToPlaylist$doAdd$10.L$3;
                PlaylistId playlistId1 = (PlaylistId)addToPlaylist$doAdd$10.L$2;
                addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addToPlaylist$doAdd$10.L$1;
                s2 s21 = (s2)addToPlaylist$doAdd$10.L$0;
                n.D(object0);
                goto label_169;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    @Nullable
    default Object execute(@NotNull Continuation continuation0) {
        return AddToPlaylist.execute$suspendImpl(this, continuation0);
    }

    static Object execute$suspendImpl(AddToPlaylist addToPlaylist0, Continuation continuation0) {
        Success addResult$Success0;
        String s22_1;
        AddResult addResult2;
        AddResult addResult1;
        AddToPlaylist addToPlaylist23;
        int v27;
        String s21_1;
        int v26;
        L0 l011;
        Object object7;
        String s19;
        PlaylistId playlistId7;
        AddRequestPlayableListInfo addRequestPlayableListInfo3;
        AddToPlaylist addToPlaylist20;
        Failure addResult$Failure1;
        AddRequestPlayableListInfo addRequestPlayableListInfo2;
        L0 l09;
        int v21;
        String s17;
        AddToPlaylist addToPlaylist17;
        int v20;
        String s16;
        Object object6;
        String s15;
        Failure addResult$Failure0;
        PlaylistId playlistId5;
        int v17;
        AddToPlaylist addToPlaylist14;
        Object object5;
        PlaylistId playlistId4;
        String s11;
        AddResult addResult0;
        String s8;
        PlaylistId playlistId2;
        AddToPlaylist addToPlaylist7;
        int v13;
        int v12;
        AddRequestPlayableListInfo addRequestPlayableListInfo0;
        String s5;
        int v11;
        int v10;
        PlaylistId playlistId0;
        AddToPlaylist addToPlaylist3;
        int v6;
        Object object2;
        int v5;
        int v4;
        L0 l01;
        String s1;
        Object object1;
        int v3;
        int v2;
        String s;
        L0 l00;
        com.iloen.melon.playback.playlist.add.AddToPlaylist.execute.1 addToPlaylist$execute$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddToPlaylist.execute.1) {
            addToPlaylist$execute$10 = (com.iloen.melon.playback.playlist.add.AddToPlaylist.execute.1)continuation0;
            int v = addToPlaylist$execute$10.label;
            if((v & 0x80000000) == 0) {
                addToPlaylist$execute$10 = new c(continuation0) {
                    int I$0;
                    int I$1;
                    int I$2;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return AddToPlaylist.execute$suspendImpl(addToPlaylist0, this);
                    }
                };
            }
            else {
                addToPlaylist$execute$10.label = v ^ 0x80000000;
            }
        }
        else {
            addToPlaylist$execute$10 = new c(continuation0) {
                int I$0;
                int I$1;
                int I$2;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                Object L$8;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return AddToPlaylist.execute$suspendImpl(addToPlaylist0, this);
                }
            };
        }
        Object object0 = addToPlaylist$execute$10.result;
        a a0 = a.a;
        int v1 = 0;
        switch(addToPlaylist$execute$10.label) {
            case 0: {
                n.D(object0);
                l00 = addToPlaylist0.getProgressUpdater();
                s = "AddToPlaylist";
                if(l00 == null) {
                    try {
                        CType cType0 = addToPlaylist0.getCType();
                        addToPlaylist$execute$10.L$0 = null;
                        addToPlaylist$execute$10.L$1 = null;
                        addToPlaylist$execute$10.L$2 = null;
                        addToPlaylist$execute$10.L$3 = addToPlaylist0;
                        addToPlaylist$execute$10.I$0 = 0;
                        addToPlaylist$execute$10.I$1 = 0;
                        addToPlaylist$execute$10.I$2 = 0;
                        addToPlaylist$execute$10.label = 1;
                        object0 = addToPlaylist0.getPlaylistId(cType0, addToPlaylist$execute$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        v2 = 0;
                        v3 = 0;
                        goto label_63;
                    }
                    catch(Throwable throwable0) {
                        goto label_226;
                    }
                }
                l00.a("AddToPlaylist true", true);
                try {
                    CType cType1 = addToPlaylist0.getCType();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = l00;
                    addToPlaylist$execute$10.L$2 = "AddToPlaylist";
                    addToPlaylist$execute$10.L$3 = addToPlaylist0;
                    addToPlaylist$execute$10.I$0 = 0;
                    addToPlaylist$execute$10.I$1 = 0;
                    addToPlaylist$execute$10.I$2 = 0;
                    addToPlaylist$execute$10.label = 7;
                    object1 = addToPlaylist0.getPlaylistId(cType1, addToPlaylist$execute$10);
                    if(object1 != a0) {
                        goto label_44;
                    }
                    return a0;
                }
                catch(Throwable throwable1) {
                    goto label_477;
                }
            label_44:
                s1 = "AddToPlaylist";
                l01 = l00;
                v4 = 0;
                v5 = 0;
                object2 = object1;
                v6 = 0;
                goto label_245;
            }
            case 1: {
                int v7 = addToPlaylist$execute$10.I$2;
                int v8 = addToPlaylist$execute$10.I$1;
                int v9 = addToPlaylist$execute$10.I$0;
                AddToPlaylist addToPlaylist1 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s2 = (String)addToPlaylist$execute$10.L$2;
                L0 l02 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist2 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    v2 = v8;
                    addToPlaylist0 = addToPlaylist1;
                    v3 = v7;
                    v1 = v9;
                label_63:
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = null;
                    addToPlaylist$execute$10.L$2 = null;
                    addToPlaylist$execute$10.L$3 = addToPlaylist0;
                    addToPlaylist$execute$10.L$4 = (PlaylistId)object0;
                    addToPlaylist$execute$10.I$0 = v1;
                    addToPlaylist$execute$10.I$1 = v2;
                    addToPlaylist$execute$10.I$2 = v3;
                    addToPlaylist$execute$10.label = 2;
                    Object object3 = addToPlaylist0.checkPreCondition(((PlaylistId)object0), addToPlaylist$execute$10);
                    if(object3 == a0) {
                        return a0;
                    }
                    addToPlaylist3 = addToPlaylist0;
                    playlistId0 = (PlaylistId)object0;
                    v10 = v3;
                    object0 = object3;
                    v11 = v1;
                    goto label_91;
                }
                catch(Throwable throwable0) {
                    goto label_226;
                }
            }
            case 2: {
                v10 = addToPlaylist$execute$10.I$2;
                v2 = addToPlaylist$execute$10.I$1;
                v11 = addToPlaylist$execute$10.I$0;
                PlaylistId playlistId1 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist4 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s3 = (String)addToPlaylist$execute$10.L$2;
                L0 l03 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist5 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    addToPlaylist3 = addToPlaylist4;
                    playlistId0 = playlistId1;
                label_91:
                    if(((AddFailType)object0) != null) {
                        return new Failure(((AddFailType)object0));
                    }
                    String s4 = addToPlaylist3.checkRemoteConnectIfNeededWithToastMsg(playlistId0);
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = null;
                    addToPlaylist$execute$10.L$2 = null;
                    addToPlaylist$execute$10.L$3 = addToPlaylist3;
                    addToPlaylist$execute$10.L$4 = playlistId0;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s4;
                    addToPlaylist$execute$10.I$0 = v11;
                    addToPlaylist$execute$10.I$1 = v2;
                    addToPlaylist$execute$10.I$2 = v10;
                    addToPlaylist$execute$10.label = 3;
                    Object object4 = addToPlaylist3.getAddPlayableListInfo(addToPlaylist$execute$10);
                    if(object4 == a0) {
                        return a0;
                    }
                    s5 = s4;
                    object0 = object4;
                    goto label_122;
                }
                catch(Throwable throwable0) {
                    goto label_226;
                }
            }
            case 3: {
                v10 = addToPlaylist$execute$10.I$2;
                v2 = addToPlaylist$execute$10.I$1;
                v11 = addToPlaylist$execute$10.I$0;
                String s6 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType0 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId0 = (PlaylistId)addToPlaylist$execute$10.L$4;
                addToPlaylist3 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s7 = (String)addToPlaylist$execute$10.L$2;
                L0 l04 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist6 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    s5 = s6;
                label_122:
                    ((AddRequestPlayableListInfo)object0).convertCanAddPlayableListInfo(playlistId0);
                    if(((AddRequestPlayableListInfo)object0).getUserRequestedPlaylist().isEmpty()) {
                        return new Failure(EmptyPlaylist.INSTANCE);
                    }
                    AddAction addAction0 = addToPlaylist3.getAddAction();
                    s2 s20 = addToPlaylist3.getPlaylistManager();
                    ob.z z0 = addToPlaylist3.getPlayerUseCase();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = null;
                    addToPlaylist$execute$10.L$2 = null;
                    addToPlaylist$execute$10.L$3 = addToPlaylist3;
                    addToPlaylist$execute$10.L$4 = playlistId0;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s5;
                    addToPlaylist$execute$10.L$7 = (AddRequestPlayableListInfo)object0;
                    addToPlaylist$execute$10.I$0 = v11;
                    addToPlaylist$execute$10.I$1 = v2;
                    addToPlaylist$execute$10.I$2 = v10;
                    addToPlaylist$execute$10.label = 4;
                    if(addAction0.beforeAddTask(s20, z0, playlistId0, ((AddRequestPlayableListInfo)object0), addToPlaylist$execute$10) == a0) {
                        return a0;
                    }
                    addRequestPlayableListInfo0 = (AddRequestPlayableListInfo)object0;
                    v12 = v2;
                    v13 = v11;
                    addToPlaylist7 = addToPlaylist3;
                    playlistId2 = playlistId0;
                    s8 = s5;
                    goto label_160;
                }
                catch(Throwable throwable0) {
                    goto label_226;
                }
            }
            case 4: {
                v10 = addToPlaylist$execute$10.I$2;
                v12 = addToPlaylist$execute$10.I$1;
                v13 = addToPlaylist$execute$10.I$0;
                addRequestPlayableListInfo0 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$7;
                s8 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType1 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId2 = (PlaylistId)addToPlaylist$execute$10.L$4;
                addToPlaylist7 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s9 = (String)addToPlaylist$execute$10.L$2;
                L0 l05 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist8 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                label_160:
                    s2 s21 = addToPlaylist7.getPlaylistManager();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = null;
                    addToPlaylist$execute$10.L$2 = null;
                    addToPlaylist$execute$10.L$3 = addToPlaylist7;
                    addToPlaylist$execute$10.L$4 = playlistId2;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s8;
                    addToPlaylist$execute$10.L$7 = addRequestPlayableListInfo0;
                    addToPlaylist$execute$10.I$0 = v13;
                    addToPlaylist$execute$10.I$1 = v12;
                    addToPlaylist$execute$10.I$2 = v10;
                    addToPlaylist$execute$10.label = 5;
                    object0 = addToPlaylist7.doAdd(s21, addRequestPlayableListInfo0, playlistId2, addToPlaylist$execute$10);
                    if(object0 != a0) {
                        goto label_188;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    goto label_226;
                }
                goto label_188;
            }
            case 5: {
                v10 = addToPlaylist$execute$10.I$2;
                v12 = addToPlaylist$execute$10.I$1;
                v13 = addToPlaylist$execute$10.I$0;
                addRequestPlayableListInfo0 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$7;
                s8 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType2 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId2 = (PlaylistId)addToPlaylist$execute$10.L$4;
                addToPlaylist7 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s10 = (String)addToPlaylist$execute$10.L$2;
                L0 l06 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist9 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                label_188:
                    if(!(((AddResult)object0) instanceof Success)) {
                        return (AddResult)object0;
                    }
                    if(addToPlaylist7.getAddAction() instanceof AddPlaySetAvailable) {
                        addToPlaylist7.getPlayerController().o(true);
                    }
                    AddAction addAction1 = addToPlaylist7.getAddAction();
                    s2 s22 = addToPlaylist7.getPlaylistManager();
                    ob.z z1 = addToPlaylist7.getPlayerUseCase();
                    b0 b00 = ((Success)(((AddResult)object0))).getRequestAddResult();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = null;
                    addToPlaylist$execute$10.L$2 = null;
                    addToPlaylist$execute$10.L$3 = null;
                    addToPlaylist$execute$10.L$4 = null;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s8;
                    addToPlaylist$execute$10.L$7 = (AddResult)object0;
                    addToPlaylist$execute$10.L$8 = null;
                    addToPlaylist$execute$10.I$0 = v13;
                    addToPlaylist$execute$10.I$1 = v12;
                    addToPlaylist$execute$10.I$2 = v10;
                    addToPlaylist$execute$10.label = 6;
                    if(addAction1.afterTask(s22, z1, playlistId2, addRequestPlayableListInfo0, b00, addToPlaylist$execute$10) == a0) {
                        return a0;
                    }
                    addResult0 = (AddResult)object0;
                    s11 = s8;
                    return Success.copy$default(((Success)addResult0), null, null, s11, 3, null);
                }
                catch(Throwable throwable0) {
                    goto label_226;
                }
            }
            case 6: {
                AddRequestPlayableListInfo addRequestPlayableListInfo1 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$8;
                addResult0 = (AddResult)addToPlaylist$execute$10.L$7;
                String s12 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType3 = (AddFailType)addToPlaylist$execute$10.L$5;
                PlaylistId playlistId3 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist10 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s13 = (String)addToPlaylist$execute$10.L$2;
                L0 l07 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist11 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    s11 = s12;
                    return Success.copy$default(((Success)addResult0), null, null, s11, 3, null);
                }
                catch(Throwable throwable0) {
                label_226:
                    Throwable throwable2 = ie.p.a(n.t(throwable0));
                    if(throwable2 != null) {
                        if(!(throwable2 instanceof MelonNetworkError) && !(throwable2 instanceof VolleyError)) {
                            return throwable2 instanceof AddOnlyLocalSongOnSmartPlaylistException ? new Failure(SmartPlaylistAlert.INSTANCE) : new Failure(Normal.INSTANCE);
                        }
                        return new Failure(new ShowNetworkPopup(throwable2.getMessage()));
                    }
                    return new Failure(Normal.INSTANCE);
                }
            }
            case 7: {
                int v14 = addToPlaylist$execute$10.I$2;
                int v15 = addToPlaylist$execute$10.I$1;
                int v16 = addToPlaylist$execute$10.I$0;
                AddToPlaylist addToPlaylist12 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                s1 = (String)addToPlaylist$execute$10.L$2;
                l01 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist13 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    v6 = v14;
                    addToPlaylist0 = addToPlaylist12;
                    v5 = v16;
                    v4 = v15;
                    object2 = object0;
                label_245:
                    playlistId4 = (PlaylistId)object2;
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = l01;
                    addToPlaylist$execute$10.L$2 = s1;
                    addToPlaylist$execute$10.L$3 = addToPlaylist0;
                    addToPlaylist$execute$10.L$4 = playlistId4;
                    addToPlaylist$execute$10.I$0 = v5;
                    addToPlaylist$execute$10.I$1 = v4;
                    addToPlaylist$execute$10.I$2 = v6;
                    addToPlaylist$execute$10.label = 8;
                    object5 = addToPlaylist0.checkPreCondition(playlistId4, addToPlaylist$execute$10);
                }
                catch(Throwable throwable1) {
                    s = s1;
                    l00 = l01;
                    goto label_477;
                }
                if(object5 == a0) {
                    return a0;
                }
                addToPlaylist14 = addToPlaylist0;
                v17 = v6;
                object0 = object5;
                playlistId5 = playlistId4;
                s = s1;
                goto label_287;
            }
            case 8: {
                v17 = addToPlaylist$execute$10.I$2;
                int v18 = addToPlaylist$execute$10.I$1;
                int v19 = addToPlaylist$execute$10.I$0;
                PlaylistId playlistId6 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist15 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s14 = (String)addToPlaylist$execute$10.L$2;
                L0 l08 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist16 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    s = s14;
                    n.D(object0);
                    v4 = v18;
                    s = s14;
                    l01 = l08;
                    addToPlaylist14 = addToPlaylist15;
                    playlistId5 = playlistId6;
                    v5 = v19;
                }
                catch(Throwable throwable1) {
                    l00 = l08;
                    goto label_477;
                }
                try {
                label_287:
                    if(((AddFailType)object0) != null) {
                        addResult$Failure0 = new Failure(((AddFailType)object0));
                        goto label_289;
                    }
                    goto label_291;
                }
                catch(Throwable throwable1) {
                    l00 = l01;
                    goto label_477;
                }
            label_289:
                k8.Y.v(s, " false", l01, false);
                return addResult$Failure0;
                try {
                label_291:
                    s15 = addToPlaylist14.checkRemoteConnectIfNeededWithToastMsg(playlistId5);
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = l01;
                    addToPlaylist$execute$10.L$2 = s;
                    addToPlaylist$execute$10.L$3 = addToPlaylist14;
                    addToPlaylist$execute$10.L$4 = playlistId5;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s15;
                    addToPlaylist$execute$10.I$0 = v5;
                    addToPlaylist$execute$10.I$1 = v4;
                    addToPlaylist$execute$10.I$2 = v17;
                    addToPlaylist$execute$10.label = 9;
                    object6 = addToPlaylist14.getAddPlayableListInfo(addToPlaylist$execute$10);
                }
                catch(Throwable throwable1) {
                    l00 = l01;
                    goto label_477;
                }
                if(object6 == a0) {
                    return a0;
                }
                s16 = s15;
                object0 = object6;
                v20 = v4;
                addToPlaylist17 = addToPlaylist14;
                s17 = s;
                v21 = v5;
                l09 = l01;
                goto label_338;
            }
            case 9: {
                v17 = addToPlaylist$execute$10.I$2;
                int v22 = addToPlaylist$execute$10.I$1;
                int v23 = addToPlaylist$execute$10.I$0;
                String s18 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType4 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId5 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist18 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                s17 = (String)addToPlaylist$execute$10.L$2;
                L0 l010 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist19 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    v21 = v23;
                    addToPlaylist17 = addToPlaylist18;
                    l09 = l010;
                    v20 = v22;
                    s16 = s18;
                }
                catch(Throwable throwable1) {
                    s = s17;
                    l00 = l010;
                    goto label_477;
                }
                try {
                label_338:
                    ((AddRequestPlayableListInfo)object0).convertCanAddPlayableListInfo(playlistId5);
                    addRequestPlayableListInfo2 = (AddRequestPlayableListInfo)object0;
                    if(addRequestPlayableListInfo2.getUserRequestedPlaylist().isEmpty()) {
                        addResult$Failure1 = new Failure(EmptyPlaylist.INSTANCE);
                        goto label_342;
                    }
                    goto label_344;
                }
                catch(Throwable throwable1) {
                    s = s17;
                    l00 = l09;
                    goto label_477;
                }
            label_342:
                k8.Y.v(s17, " false", l09, false);
                return addResult$Failure1;
                try {
                label_344:
                    AddAction addAction2 = addToPlaylist17.getAddAction();
                    s2 s23 = addToPlaylist17.getPlaylistManager();
                    ob.z z2 = addToPlaylist17.getPlayerUseCase();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = l09;
                    addToPlaylist$execute$10.L$2 = s17;
                    addToPlaylist$execute$10.L$3 = addToPlaylist17;
                    addToPlaylist$execute$10.L$4 = playlistId5;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s16;
                    addToPlaylist$execute$10.L$7 = addRequestPlayableListInfo2;
                    addToPlaylist$execute$10.I$0 = v21;
                    addToPlaylist$execute$10.I$1 = v20;
                    addToPlaylist$execute$10.I$2 = v17;
                    addToPlaylist$execute$10.label = 10;
                    addToPlaylist20 = addToPlaylist17;
                    if(addAction2.beforeAddTask(s23, z2, playlistId5, addRequestPlayableListInfo2, addToPlaylist$execute$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable1) {
                    s = s17;
                    l00 = l09;
                    goto label_477;
                }
                addRequestPlayableListInfo3 = addRequestPlayableListInfo2;
                s = s17;
                playlistId7 = playlistId5;
                s19 = s16;
                l00 = l09;
                goto label_394;
            }
            case 10: {
                v17 = addToPlaylist$execute$10.I$2;
                int v24 = addToPlaylist$execute$10.I$1;
                int v25 = addToPlaylist$execute$10.I$0;
                addRequestPlayableListInfo3 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$7;
                s19 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType5 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId7 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist21 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                String s20_1 = (String)addToPlaylist$execute$10.L$2;
                l09 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist22 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    s = s20_1;
                    n.D(object0);
                    v20 = v24;
                    s = s20_1;
                    v21 = v25;
                    addToPlaylist20 = addToPlaylist21;
                }
                catch(Throwable throwable1) {
                    l00 = l09;
                    goto label_477;
                }
                l00 = l09;
                try {
                label_394:
                    s2 s24 = addToPlaylist20.getPlaylistManager();
                    addToPlaylist$execute$10.L$0 = null;
                    addToPlaylist$execute$10.L$1 = l00;
                    addToPlaylist$execute$10.L$2 = s;
                    addToPlaylist$execute$10.L$3 = addToPlaylist20;
                    addToPlaylist$execute$10.L$4 = playlistId7;
                    addToPlaylist$execute$10.L$5 = null;
                    addToPlaylist$execute$10.L$6 = s19;
                    addToPlaylist$execute$10.L$7 = addRequestPlayableListInfo3;
                    addToPlaylist$execute$10.I$0 = v21;
                    addToPlaylist$execute$10.I$1 = v20;
                    addToPlaylist$execute$10.I$2 = v17;
                    addToPlaylist$execute$10.label = 11;
                    object7 = addToPlaylist20.doAdd(s24, addRequestPlayableListInfo3, playlistId7, addToPlaylist$execute$10);
                    if(object7 != a0) {
                        goto label_409;
                    }
                    return a0;
                }
                catch(Throwable throwable1) {
                    goto label_477;
                }
            label_409:
                l011 = l00;
                v26 = v21;
                s21_1 = s;
                v27 = v20;
                addToPlaylist23 = addToPlaylist20;
                object0 = object7;
                goto label_428;
            }
            case 11: {
                v17 = addToPlaylist$execute$10.I$2;
                v27 = addToPlaylist$execute$10.I$1;
                v26 = addToPlaylist$execute$10.I$0;
                addRequestPlayableListInfo3 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$7;
                s19 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType6 = (AddFailType)addToPlaylist$execute$10.L$5;
                playlistId7 = (PlaylistId)addToPlaylist$execute$10.L$4;
                addToPlaylist23 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                s21_1 = (String)addToPlaylist$execute$10.L$2;
                l011 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist24 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                label_428:
                    addResult1 = (AddResult)object0;
                    if(addResult1 instanceof Success) {
                        if(addToPlaylist23.getAddAction() instanceof AddPlaySetAvailable) {
                            addToPlaylist23.getPlayerController().o(true);
                        }
                        AddAction addAction3 = addToPlaylist23.getAddAction();
                        s2 s25 = addToPlaylist23.getPlaylistManager();
                        ob.z z3 = addToPlaylist23.getPlayerUseCase();
                        b0 b01 = ((Success)addResult1).getRequestAddResult();
                        addToPlaylist$execute$10.L$0 = null;
                        addToPlaylist$execute$10.L$1 = l011;
                        addToPlaylist$execute$10.L$2 = s21_1;
                        addToPlaylist$execute$10.L$3 = null;
                        addToPlaylist$execute$10.L$4 = null;
                        addToPlaylist$execute$10.L$5 = null;
                        addToPlaylist$execute$10.L$6 = s19;
                        addToPlaylist$execute$10.L$7 = addResult1;
                        addToPlaylist$execute$10.L$8 = null;
                        addToPlaylist$execute$10.I$0 = v26;
                        addToPlaylist$execute$10.I$1 = v27;
                        addToPlaylist$execute$10.I$2 = v17;
                        addToPlaylist$execute$10.label = 12;
                        if(addAction3.afterTask(s25, z3, playlistId7, addRequestPlayableListInfo3, b01, addToPlaylist$execute$10) == a0) {
                            return a0;
                        }
                        addResult2 = addResult1;
                        s22_1 = s19;
                        break;
                    }
                }
                catch(Throwable throwable1) {
                    goto label_475;
                }
                k8.Y.v(s21_1, " false", l011, false);
                return addResult1;
            }
            case 12: {
                AddRequestPlayableListInfo addRequestPlayableListInfo4 = (AddRequestPlayableListInfo)addToPlaylist$execute$10.L$8;
                addResult2 = (AddResult)addToPlaylist$execute$10.L$7;
                String s23_1 = (String)addToPlaylist$execute$10.L$6;
                AddFailType addFailType7 = (AddFailType)addToPlaylist$execute$10.L$5;
                PlaylistId playlistId8 = (PlaylistId)addToPlaylist$execute$10.L$4;
                AddToPlaylist addToPlaylist25 = (AddToPlaylist)addToPlaylist$execute$10.L$3;
                s = (String)addToPlaylist$execute$10.L$2;
                l00 = (L0)addToPlaylist$execute$10.L$1;
                AddToPlaylist addToPlaylist26 = (AddToPlaylist)addToPlaylist$execute$10.L$0;
                try {
                    n.D(object0);
                    s21_1 = s;
                    l011 = l00;
                    s22_1 = s23_1;
                    break;
                }
                catch(Throwable throwable1) {
                    goto label_477;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            addResult$Success0 = Success.copy$default(((Success)addResult2), null, null, s22_1, 3, null);
            goto label_493;
        }
        catch(Throwable throwable1) {
        label_475:
            s = s21_1;
            l00 = l011;
        }
    label_477:
        try {
            Throwable throwable3 = ie.p.a(n.t(throwable1));
            if(throwable3 != null) {
                if(throwable3 instanceof MelonNetworkError || throwable3 instanceof VolleyError) {
                    return new Failure(new ShowNetworkPopup(throwable3.getMessage()));
                }
                else if(throwable3 instanceof AddOnlyLocalSongOnSmartPlaylistException) {
                    return new Failure(SmartPlaylistAlert.INSTANCE);
                }
            }
            return new Failure(Normal.INSTANCE);
        }
        finally {
            k8.Y.v(s, " false", l00, false);
        }
    label_493:
        k8.Y.v(s21_1, " false", l011, false);
        return addResult$Success0;
    }

    @NotNull
    AddAction getAddAction();

    @Nullable
    Object getAddPlayableListInfo(@NotNull Continuation arg1);

    @NotNull
    CType getCType();

    @NotNull
    DeviceConnectableInfo getDeviceConnectInfo();

    default private Object getListToRemoveExcludedArtists(Collection collection0, Continuation continuation0) {
        int v2;
        List list1;
        F f2;
        Iterator iterator2;
        Playable playable0;
        Iterator iterator1;
        int v1;
        Iterator iterator0;
        Object object1;
        F f0;
        List list0;
        com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedArtists.1 addToPlaylist$getListToRemoveExcludedArtists$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedArtists.1) {
            addToPlaylist$getListToRemoveExcludedArtists$10 = (com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedArtists.1)continuation0;
            int v = addToPlaylist$getListToRemoveExcludedArtists$10.label;
            if((v & 0x80000000) == 0) {
                addToPlaylist$getListToRemoveExcludedArtists$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getListToRemoveExcludedArtists(null, this);
                    }
                };
            }
            else {
                addToPlaylist$getListToRemoveExcludedArtists$10.label = v ^ 0x80000000;
            }
        }
        else {
            addToPlaylist$getListToRemoveExcludedArtists$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getListToRemoveExcludedArtists(null, this);
                }
            };
        }
        Object object0 = addToPlaylist$getListToRemoveExcludedArtists$10.result;
        a a0 = a.a;
    alab1:
        switch(addToPlaylist$getListToRemoveExcludedArtists$10.label) {
            case 0: {
                list0 = b.m(object0);
                f0 = F.a;
                addToPlaylist$getListToRemoveExcludedArtists$10.L$0 = collection0;
                addToPlaylist$getListToRemoveExcludedArtists$10.L$1 = list0;
                addToPlaylist$getListToRemoveExcludedArtists$10.L$2 = f0;
                addToPlaylist$getListToRemoveExcludedArtists$10.label = 1;
                object1 = f0.j(addToPlaylist$getListToRemoveExcludedArtists$10);
                if(object1 != a0) {
                    goto label_29;
                }
                break;
            }
            case 1: {
                F f1 = (F)addToPlaylist$getListToRemoveExcludedArtists$10.L$2;
                list0 = (List)addToPlaylist$getListToRemoveExcludedArtists$10.L$1;
                Collection collection1 = (Collection)addToPlaylist$getListToRemoveExcludedArtists$10.L$0;
                n.D(object0);
                f0 = f1;
                collection0 = collection1;
                object1 = object0;
            label_29:
                if(!((Boolean)object1).booleanValue()) {
                    list0.addAll(collection0);
                    return list0;
                }
                iterator0 = collection0.iterator();
                goto label_73;
            }
            case 2: {
                v1 = addToPlaylist$getListToRemoveExcludedArtists$10.I$0;
                String s = (String)addToPlaylist$getListToRemoveExcludedArtists$10.L$7;
                iterator1 = (Iterator)addToPlaylist$getListToRemoveExcludedArtists$10.L$6;
                StringIds stringIds0 = (StringIds)addToPlaylist$getListToRemoveExcludedArtists$10.L$5;
                playable0 = (Playable)addToPlaylist$getListToRemoveExcludedArtists$10.L$4;
                iterator2 = (Iterator)addToPlaylist$getListToRemoveExcludedArtists$10.L$3;
                f2 = (F)addToPlaylist$getListToRemoveExcludedArtists$10.L$2;
                list1 = (List)addToPlaylist$getListToRemoveExcludedArtists$10.L$1;
                Collection collection2 = (Collection)addToPlaylist$getListToRemoveExcludedArtists$10.L$0;
                n.D(object0);
                while(true) {
                    if(((Boolean)object0).booleanValue()) {
                        iterator0 = iterator2;
                        f0 = f2;
                        list0 = list1;
                        v2 = 1;
                        goto label_69;
                    }
                label_50:
                    if(!iterator1.hasNext()) {
                        goto label_65;
                    }
                    Object object2 = iterator1.next();
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$0 = null;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$1 = list1;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$2 = f2;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$3 = iterator2;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$4 = playable0;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$5 = null;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$6 = iterator1;
                    addToPlaylist$getListToRemoveExcludedArtists$10.L$7 = null;
                    addToPlaylist$getListToRemoveExcludedArtists$10.I$0 = v1;
                    addToPlaylist$getListToRemoveExcludedArtists$10.label = 2;
                    object0 = f2.a(((String)object2), addToPlaylist$getListToRemoveExcludedArtists$10);
                    if(object0 != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    label_65:
        f0 = f2;
        list0 = list1;
        v2 = v1;
        iterator0 = iterator2;
    alab2:
        while(true) {
        label_69:
            if(v2 == 0) {
                list0.add(playable0);
            }
            else {
                k8.Y.w("getListToRemoveExcludedArtists() ignored: ", "", LogU.Companion, "AddToPlaylist");
            }
            while(true) {
            label_73:
                if(!iterator0.hasNext()) {
                    break alab2;
                }
                Object object3 = iterator0.next();
                playable0 = (Playable)object3;
                if(!playable0.isOriginLocal()) {
                    StringIds stringIds1 = StringIds.e("");
                    if(!stringIds1.isEmpty()) {
                        Iterator iterator3 = stringIds1.iterator();
                        q.f(iterator3, "iterator(...)");
                        iterator2 = iterator0;
                        v1 = 0;
                        list1 = list0;
                        iterator1 = iterator3;
                        f2 = f0;
                        goto label_50;
                    }
                    v2 = 0;
                    break;
                }
                list0.add(playable0);
            }
        }
        return list0;
    }

    default private Object getListToRemoveExcludedGenre(Collection collection0, Continuation continuation0) {
        List list1;
        F f2;
        Iterator iterator2;
        Playable playable0;
        Iterator iterator1;
        int v1;
        Iterator iterator0;
        Object object1;
        F f0;
        List list0;
        com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedGenre.1 addToPlaylist$getListToRemoveExcludedGenre$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedGenre.1) {
            addToPlaylist$getListToRemoveExcludedGenre$10 = (com.iloen.melon.playback.playlist.add.AddToPlaylist.getListToRemoveExcludedGenre.1)continuation0;
            int v = addToPlaylist$getListToRemoveExcludedGenre$10.label;
            if((v & 0x80000000) == 0) {
                addToPlaylist$getListToRemoveExcludedGenre$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getListToRemoveExcludedGenre(null, this);
                    }
                };
            }
            else {
                addToPlaylist$getListToRemoveExcludedGenre$10.label = v ^ 0x80000000;
            }
        }
        else {
            addToPlaylist$getListToRemoveExcludedGenre$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getListToRemoveExcludedGenre(null, this);
                }
            };
        }
        Object object0 = addToPlaylist$getListToRemoveExcludedGenre$10.result;
        a a0 = a.a;
    alab1:
        switch(addToPlaylist$getListToRemoveExcludedGenre$10.label) {
            case 0: {
                list0 = b.m(object0);
                f0 = F.a;
                addToPlaylist$getListToRemoveExcludedGenre$10.L$0 = collection0;
                addToPlaylist$getListToRemoveExcludedGenre$10.L$1 = list0;
                addToPlaylist$getListToRemoveExcludedGenre$10.L$2 = f0;
                addToPlaylist$getListToRemoveExcludedGenre$10.label = 1;
                object1 = f0.k(addToPlaylist$getListToRemoveExcludedGenre$10);
                if(object1 != a0) {
                    goto label_29;
                }
                break;
            }
            case 1: {
                F f1 = (F)addToPlaylist$getListToRemoveExcludedGenre$10.L$2;
                list0 = (List)addToPlaylist$getListToRemoveExcludedGenre$10.L$1;
                Collection collection1 = (Collection)addToPlaylist$getListToRemoveExcludedGenre$10.L$0;
                n.D(object0);
                f0 = f1;
                collection0 = collection1;
                object1 = object0;
            label_29:
                if(!((Boolean)object1).booleanValue()) {
                    list0.addAll(collection0);
                    return list0;
                }
                iterator0 = collection0.iterator();
                goto label_67;
            }
            case 2: {
                v1 = addToPlaylist$getListToRemoveExcludedGenre$10.I$0;
                GenreInfoBase genreInfoBase0 = (GenreInfoBase)addToPlaylist$getListToRemoveExcludedGenre$10.L$6;
                iterator1 = (Iterator)addToPlaylist$getListToRemoveExcludedGenre$10.L$5;
                playable0 = (Playable)addToPlaylist$getListToRemoveExcludedGenre$10.L$4;
                iterator2 = (Iterator)addToPlaylist$getListToRemoveExcludedGenre$10.L$3;
                f2 = (F)addToPlaylist$getListToRemoveExcludedGenre$10.L$2;
                list1 = (List)addToPlaylist$getListToRemoveExcludedGenre$10.L$1;
                Collection collection2 = (Collection)addToPlaylist$getListToRemoveExcludedGenre$10.L$0;
                n.D(object0);
                while(true) {
                    if(((Boolean)object0).booleanValue()) {
                        v1 = 1;
                        goto label_60;
                    }
                label_46:
                    if(!iterator1.hasNext()) {
                        goto label_60;
                    }
                    Object object2 = iterator1.next();
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$0 = null;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$1 = list1;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$2 = f2;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$3 = iterator2;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$4 = playable0;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$5 = iterator1;
                    addToPlaylist$getListToRemoveExcludedGenre$10.L$6 = null;
                    addToPlaylist$getListToRemoveExcludedGenre$10.I$0 = v1;
                    addToPlaylist$getListToRemoveExcludedGenre$10.label = 2;
                    object0 = f2.c(((GenreInfoBase)object2).genreCode, addToPlaylist$getListToRemoveExcludedGenre$10);
                    if(object0 != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    label_60:
        if(v1 == 0) {
            list1.add(playable0);
        }
        else {
            LogU.Companion.d("AddToPlaylist", "getListToRemoveExcludedGenre() ignored: " + playable0.getGenreList());
        }
        f0 = f2;
        list0 = list1;
        iterator0 = iterator2;
    label_67:
        while(iterator0.hasNext()) {
            Object object3 = iterator0.next();
            playable0 = (Playable)object3;
            if(!playable0.isOriginLocal()) {
                list1 = list0;
                iterator1 = playable0.getGenreList().iterator();
                iterator2 = iterator0;
                v1 = 0;
                f2 = f0;
                goto label_46;
            }
            list0.add(playable0);
        }
        return list0;
    }

    @NotNull
    String getMenuId();

    boolean getNeedToClear();

    @NotNull
    default z getPlayerController() {
        return (z)((o)(((m)k8.Y.g(MelonAppBase.Companion, "context", m.class)))).t.get();
    }

    @NotNull
    default ob.z getPlayerUseCase() {
        return ((o)(((Ma.o)k8.Y.g(MelonAppBase.Companion, "context", Ma.o.class)))).k();
    }

    @Nullable
    default Object getPlaylistId(@NotNull CType cType0, @NotNull Continuation continuation0) {
        return AddToPlaylist.getPlaylistId$suspendImpl(this, cType0, continuation0);
    }

    static Object getPlaylistId$suspendImpl(AddToPlaylist addToPlaylist0, CType cType0, Continuation continuation0) {
        if(q.b(cType0, CType.MV)) {
            return PlaylistId.VOD;
        }
        if(q.b(cType0, CType.LIVE)) {
            return PlaylistId.LIVE;
        }
        if(q.b(cType0, CType.STATION)) {
            return PlaylistId.STATION;
        }
        if(q.b(cType0, CType.DRAWER_PLAYLIST)) {
            return PlaylistId.DRAWER;
        }
        if(q.b(cType0, CType.MIX_UP_PLAYLIST)) {
            return PlaylistId.MIX_UP;
        }
        return q.b(cType0, CType.MUSIC_WAVE) ? PlaylistId.MUSIC_WAVE : ((com.melon.playlist.b)((d3)addToPlaylist0.getPlaylistManager()).a).w(continuation0);
    }

    @NotNull
    default s2 getPlaylistManager() {
        return (s2)((o)(((m)k8.Y.g(MelonAppBase.Companion, "context", m.class)))).w.get();
    }

    @Nullable
    L0 getProgressUpdater();

    @NotNull
    default s getRemotePlayerManager() {
        return (s)((o)(((m)k8.Y.g(MelonAppBase.Companion, "context", m.class)))).z.get();
    }

    @Nullable
    StatsElementsBase getStatsElements();

    default private SuccessExtra getSuccessExtra(AddRequestPlayableListInfo addRequestPlayableListInfo0) {
        if(addRequestPlayableListInfo0 instanceof MixUpAddRequestPlayableListInfo && ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getMixUpRequestInfo() instanceof DjMalrangRequestInfo) {
            return MixUpSimple.INSTANCE;
        }
        return addRequestPlayableListInfo0 instanceof MixUpAddRequestPlayableListInfo && ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getMixUpSeedOverMaxSize() ? MixUpSeedOverMaxSize.INSTANCE : com.iloen.melon.playback.playlist.add.SuccessExtra.Normal.INSTANCE;
    }

    boolean isAllowedBannedContents();

    boolean isExcludeGenre();

    default private boolean isVideoContents() {
        return k.A(new CType[]{CType.MV, CType.LIVE}).contains(this.getCType());
    }

    void setAllowedBannedContents(boolean arg1);
}

