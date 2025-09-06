package com.iloen.melon.player.playlist;

import A7.d;
import M6.B;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import b3.Z;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.b;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import k8.Y;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import va.e;
import we.n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001:\u0001]B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b\u000E\u0010\rJ\u0018\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000FH\u0086@\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0014\u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b\u0014\u0010\rJ\u0015\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001D\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010\u001F\u001A\u00020\u000B\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u0010\u0010 \u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b \u0010\rJ\u0010\u0010!\u001A\u00020\u000BH\u0086@\u00A2\u0006\u0004\b!\u0010\rJ\u001D\u0010%\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u00152\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b%\u0010&J\u0015\u0010\'\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020#\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u0004\u0018\u00010#2\u0006\u0010\"\u001A\u00020\u0015\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u0004\u0018\u00010#\u00A2\u0006\u0004\b+\u0010,J\u0015\u0010.\u001A\u00020\u000B2\u0006\u0010-\u001A\u00020\b\u00A2\u0006\u0004\b.\u0010/J\u0015\u00102\u001A\u00020\u000B2\u0006\u00101\u001A\u000200\u00A2\u0006\u0004\b2\u00103R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u00107R\u001D\u0010>\u001A\b\u0012\u0004\u0012\u000209088\u0006\u00A2\u0006\f\n\u0004\b:\u0010;\u001A\u0004\b<\u0010=R\u001D\u0010B\u001A\b\u0012\u0004\u0012\u00020?088\u0006\u00A2\u0006\f\n\u0004\b@\u0010;\u001A\u0004\bA\u0010=R\u001D\u0010H\u001A\b\u0012\u0004\u0012\u00020\u000F0C8\u0006\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010GR\u001D\u0010L\u001A\b\u0012\u0004\u0012\u00020I088\u0006\u00A2\u0006\f\n\u0004\bJ\u0010;\u001A\u0004\bK\u0010=R\u001D\u0010O\u001A\b\u0012\u0004\u0012\u00020\u00150C8\u0006\u00A2\u0006\f\n\u0004\bM\u0010E\u001A\u0004\bN\u0010GR\u001D\u0010S\u001A\b\u0012\u0004\u0012\u00020P0C8\u0006\u00A2\u0006\f\n\u0004\bQ\u0010E\u001A\u0004\bR\u0010GR\u001D\u0010V\u001A\b\u0012\u0004\u0012\u00020\b0C8\u0006\u00A2\u0006\f\n\u0004\bT\u0010E\u001A\u0004\bU\u0010GR\u001D\u0010Y\u001A\b\u0012\u0004\u0012\u000200088\u0006\u00A2\u0006\f\n\u0004\bW\u0010;\u001A\u0004\bX\u0010=R\u0011\u0010\\\u001A\u00020\u00158F\u00A2\u0006\u0006\u001A\u0004\bZ\u0010[\u00A8\u0006^"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel;", "Landroidx/lifecycle/m0;", "Lkc/s2;", "playlistManager", "<init>", "(Lkc/s2;)V", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "curPlaylistId", "", "isValidPlaylistId", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)Z", "Lie/H;", "updateMusicTabContentToDefault", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDrawerTabDataToDefault", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "tabInfo", "updateDrawerTabContentToSongWithTabInfo", "(Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDrawerTabContentToPlaylistList", "updateMixUpContentToDefault", "Lcom/iloen/melon/player/playlist/PlaylistTab;", "tab", "updateFocusingTab", "(Lcom/iloen/melon/player/playlist/PlaylistTab;)V", "", "index", "updateFocusingTabByIndex", "(I)V", "updateFocusingTabToCurrentPlaylist", "()V", "reselectTab", "updateFocusingTabContentToSearch", "updateFocusingTabContentToSong", "page", "Lp8/s;", "tiaraCommon", "updateTiaraProperty", "(Lcom/iloen/melon/player/playlist/PlaylistTab;Lp8/s;)V", "updateFocusingTabTiaraProperty", "(Lp8/s;)V", "getTabTiaraProperty", "(Lcom/iloen/melon/player/playlist/PlaylistTab;)Lp8/s;", "getFocusingTabTiaraProperty", "()Lp8/s;", "isVisible", "updateControllerVisibility", "(Z)V", "Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent;", "event", "handleActivityResultEvent", "(Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent;)V", "a", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/iloen/melon/player/playlist/MusicPlaylistTabContent;", "d", "Lkotlinx/coroutines/flow/SharedFlow;", "getMusicTabContent", "()Lkotlinx/coroutines/flow/SharedFlow;", "musicTabContent", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabContent;", "f", "getDrawerTabContent", "drawerTabContent", "Lkotlinx/coroutines/flow/StateFlow;", "h", "Lkotlinx/coroutines/flow/StateFlow;", "getDrawerTabInfo", "()Lkotlinx/coroutines/flow/StateFlow;", "drawerTabInfo", "Lcom/iloen/melon/player/playlist/MixUpPlaylistTabContent;", "j", "getMixUpTabContent", "mixUpTabContent", "l", "getFocusingTabFlow", "focusingTabFlow", "Lcom/iloen/melon/player/playlist/PlaylistMainHeaderBtnState;", "n", "getHeaderBtnState", "headerBtnState", "p", "getVisibilityController", "visibilityController", "r", "getActivityResultEvent", "activityResultEvent", "getFocusingTab", "()Lcom/iloen/melon/player/playlist/PlaylistTab;", "focusingTab", "NewActivityEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSharedViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent;", "", "SharePlayable", "Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent$SharePlayable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class NewActivityEvent {
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent$SharePlayable;", "Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent;", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(Lcom/iloen/melon/playback/Playable;)V", "component1", "()Lcom/iloen/melon/playback/Playable;", "copy", "(Lcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/PlaylistSharedViewModel$NewActivityEvent$SharePlayable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class SharePlayable extends NewActivityEvent {
            public static final int $stable = 8;
            public final Playable a;

            public SharePlayable(@NotNull Playable playable0) {
                q.g(playable0, "playable");
                super(null);
                this.a = playable0;
            }

            @NotNull
            public final Playable component1() {
                return this.a;
            }

            @NotNull
            public final SharePlayable copy(@NotNull Playable playable0) {
                q.g(playable0, "playable");
                return new SharePlayable(playable0);
            }

            public static SharePlayable copy$default(SharePlayable playlistSharedViewModel$NewActivityEvent$SharePlayable0, Playable playable0, int v, Object object0) {
                if((v & 1) != 0) {
                    playable0 = playlistSharedViewModel$NewActivityEvent$SharePlayable0.a;
                }
                return playlistSharedViewModel$NewActivityEvent$SharePlayable0.copy(playable0);
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof SharePlayable ? q.b(this.a, ((SharePlayable)object0).a) : false;
            }

            @NotNull
            public final Playable getPlayable() {
                return this.a;
            }

            @Override
            public int hashCode() {
                return this.a.hashCode();
            }

            @Override
            @NotNull
            public String toString() {
                return "SharePlayable(playable=" + this.a + ")";
            }
        }

        public static final int $stable;

        public NewActivityEvent(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[PlaylistId.values().length];
            try {
                arr_v[PlaylistId.SMART.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.MUSIC.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.DRAWER.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.MIX_UP.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[PlaylistTab.values().length];
            try {
                arr_v1[PlaylistTab.MUSIC.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[PlaylistTab.DRAWER.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[PlaylistTab.MIX_UP.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final int $stable = 8;
    public final s2 a;
    public final LogU b;
    public final MutableSharedFlow c;
    public final SharedFlow d;
    public final MutableSharedFlow e;
    public final SharedFlow f;
    public final MutableStateFlow g;
    public final StateFlow h;
    public final MutableSharedFlow i;
    public final SharedFlow j;
    public final MutableStateFlow k;
    public final StateFlow l;
    public final LinkedHashMap m;
    public final StateFlow n;
    public final MutableStateFlow o;
    public final StateFlow p;
    public final MutableSharedFlow q;
    public final SharedFlow r;

    @Inject
    public PlaylistSharedViewModel(@NotNull s2 s20) {
        q.g(s20, "playlistManager");
        super();
        this.a = s20;
        LogU logU0 = Z.g("PlaylistSharedViewModel", true);
        logU0.setCategory(Category.UI);
        this.b = logU0;
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.c = mutableSharedFlow0;
        this.d = FlowKt.asSharedFlow(mutableSharedFlow0);
        MutableSharedFlow mutableSharedFlow1 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.e = mutableSharedFlow1;
        this.f = FlowKt.asSharedFlow(mutableSharedFlow1);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(new DrawerPlaylistTabInfo(null, 1, null));
        this.g = mutableStateFlow0;
        this.h = FlowKt.asStateFlow(mutableStateFlow0);
        MutableSharedFlow mutableSharedFlow2 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.i = mutableSharedFlow2;
        this.j = FlowKt.asSharedFlow(mutableSharedFlow2);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(this.b());
        this.k = mutableStateFlow1;
        this.l = FlowKt.asStateFlow(mutableStateFlow1);
        this.m = new LinkedHashMap();
        this.n = FlowKt.stateIn(FlowKt.callbackFlow(new PlaylistSharedViewModel.initHeaderBtnStateFlow.1(this, null)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), PlaylistMainHeaderBtnState.NONE);
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.o = mutableStateFlow2;
        this.p = FlowKt.asStateFlow(mutableStateFlow2);
        MutableSharedFlow mutableSharedFlow3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.q = mutableSharedFlow3;
        this.r = FlowKt.asSharedFlow(mutableSharedFlow3);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final PlaylistSharedViewModel w;

            {
                this.w = playlistSharedViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(FlowKt.filterNotNull(((b)((d3)this.w.getPlaylistManager()).a).r));
                        com.iloen.melon.player.playlist.PlaylistSharedViewModel.1.1 playlistSharedViewModel$1$10 = new n(null) {
                            public final PlaylistSharedViewModel B;
                            public int r;
                            public boolean w;

                            {
                                this.B = playlistSharedViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.1.1(this.B, continuation0);
                                continuation1.w = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.w;
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        PlaylistSharedViewModel playlistSharedViewModel0 = this.B;
                                        if(z) {
                                            this.w = true;
                                            this.r = 1;
                                            if(PlaylistSharedViewModel.access$updateMusicTabContent(playlistSharedViewModel0, MusicPlaylistTabContent.SONG_LIST_SMART, this) == a0) {
                                                return a0;
                                            }
                                        }
                                        else {
                                            this.w = false;
                                            this.r = 2;
                                            if(PlaylistSharedViewModel.access$updateMusicTabContent(playlistSharedViewModel0, MusicPlaylistTabContent.SONG_LIST_MUSIC, this) == a0) {
                                                return a0;
                                            }
                                        }
                                        return H.a;
                                    }
                                    case 1: 
                                    case 2: {
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
                        return FlowKt.collectLatest(flow0, playlistSharedViewModel$1$10, this) == a0 ? a0 : H.a;
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
        }, 3, null);
        mutableSharedFlow2.tryEmit(MixUpPlaylistTabContent.SONG_LIST);
    }

    public static final Object access$updateMixUpTabContent(PlaylistSharedViewModel playlistSharedViewModel0, MixUpPlaylistTabContent mixUpPlaylistTabContent0, Continuation continuation0) {
        return playlistSharedViewModel0.d(mixUpPlaylistTabContent0, continuation0);
    }

    public static final Object access$updateMusicTabContent(PlaylistSharedViewModel playlistSharedViewModel0, MusicPlaylistTabContent musicPlaylistTabContent0, Continuation continuation0) {
        return playlistSharedViewModel0.e(musicPlaylistTabContent0, continuation0);
    }

    public final PlaylistTab b() {
        PlaylistId playlistId0 = ((d3)this.a).j();
        switch((playlistId0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[playlistId0.ordinal()])) {
            case 1: 
            case 2: {
                return PlaylistTab.MUSIC;
            }
            case 3: {
                return PlaylistTab.DRAWER;
            }
            case 4: {
                return PlaylistTab.MIX_UP;
            }
            default: {
                return PlaylistTab.MUSIC;
            }
        }
    }

    public final Object c(DrawerPlaylistTabContent drawerPlaylistTabContent0, Continuation continuation0) {
        PlaylistSharedViewModel.updateDrawerTabContent.1 playlistSharedViewModel$updateDrawerTabContent$10;
        if(continuation0 instanceof PlaylistSharedViewModel.updateDrawerTabContent.1) {
            playlistSharedViewModel$updateDrawerTabContent$10 = (PlaylistSharedViewModel.updateDrawerTabContent.1)continuation0;
            int v = playlistSharedViewModel$updateDrawerTabContent$10.D;
            if((v & 0x80000000) == 0) {
                playlistSharedViewModel$updateDrawerTabContent$10 = new PlaylistSharedViewModel.updateDrawerTabContent.1(this, continuation0);
            }
            else {
                playlistSharedViewModel$updateDrawerTabContent$10.D = v ^ 0x80000000;
            }
        }
        else {
            playlistSharedViewModel$updateDrawerTabContent$10 = new PlaylistSharedViewModel.updateDrawerTabContent.1(this, continuation0);
        }
        Object object0 = playlistSharedViewModel$updateDrawerTabContent$10.w;
        a a0 = a.a;
        switch(playlistSharedViewModel$updateDrawerTabContent$10.D) {
            case 0: {
                d5.n.D(object0);
                playlistSharedViewModel$updateDrawerTabContent$10.r = drawerPlaylistTabContent0;
                playlistSharedViewModel$updateDrawerTabContent$10.D = 1;
                if(this.e.emit(drawerPlaylistTabContent0, playlistSharedViewModel$updateDrawerTabContent$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                drawerPlaylistTabContent0 = playlistSharedViewModel$updateDrawerTabContent$10.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateDrawerTabContent: " + drawerPlaylistTabContent0, null, false, 6, null);
        return H.a;
    }

    public final Object d(MixUpPlaylistTabContent mixUpPlaylistTabContent0, Continuation continuation0) {
        PlaylistSharedViewModel.updateMixUpTabContent.1 playlistSharedViewModel$updateMixUpTabContent$10;
        if(continuation0 instanceof PlaylistSharedViewModel.updateMixUpTabContent.1) {
            playlistSharedViewModel$updateMixUpTabContent$10 = (PlaylistSharedViewModel.updateMixUpTabContent.1)continuation0;
            int v = playlistSharedViewModel$updateMixUpTabContent$10.D;
            if((v & 0x80000000) == 0) {
                playlistSharedViewModel$updateMixUpTabContent$10 = new PlaylistSharedViewModel.updateMixUpTabContent.1(this, continuation0);
            }
            else {
                playlistSharedViewModel$updateMixUpTabContent$10.D = v ^ 0x80000000;
            }
        }
        else {
            playlistSharedViewModel$updateMixUpTabContent$10 = new PlaylistSharedViewModel.updateMixUpTabContent.1(this, continuation0);
        }
        Object object0 = playlistSharedViewModel$updateMixUpTabContent$10.w;
        a a0 = a.a;
        switch(playlistSharedViewModel$updateMixUpTabContent$10.D) {
            case 0: {
                d5.n.D(object0);
                playlistSharedViewModel$updateMixUpTabContent$10.r = mixUpPlaylistTabContent0;
                playlistSharedViewModel$updateMixUpTabContent$10.D = 1;
                if(this.i.emit(mixUpPlaylistTabContent0, playlistSharedViewModel$updateMixUpTabContent$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                mixUpPlaylistTabContent0 = playlistSharedViewModel$updateMixUpTabContent$10.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateMixUpTabContent: " + mixUpPlaylistTabContent0, null, false, 6, null);
        return H.a;
    }

    public final Object e(MusicPlaylistTabContent musicPlaylistTabContent0, Continuation continuation0) {
        PlaylistSharedViewModel.updateMusicTabContent.1 playlistSharedViewModel$updateMusicTabContent$10;
        if(continuation0 instanceof PlaylistSharedViewModel.updateMusicTabContent.1) {
            playlistSharedViewModel$updateMusicTabContent$10 = (PlaylistSharedViewModel.updateMusicTabContent.1)continuation0;
            int v = playlistSharedViewModel$updateMusicTabContent$10.D;
            if((v & 0x80000000) == 0) {
                playlistSharedViewModel$updateMusicTabContent$10 = new PlaylistSharedViewModel.updateMusicTabContent.1(this, continuation0);
            }
            else {
                playlistSharedViewModel$updateMusicTabContent$10.D = v ^ 0x80000000;
            }
        }
        else {
            playlistSharedViewModel$updateMusicTabContent$10 = new PlaylistSharedViewModel.updateMusicTabContent.1(this, continuation0);
        }
        Object object0 = playlistSharedViewModel$updateMusicTabContent$10.w;
        a a0 = a.a;
        switch(playlistSharedViewModel$updateMusicTabContent$10.D) {
            case 0: {
                d5.n.D(object0);
                playlistSharedViewModel$updateMusicTabContent$10.r = musicPlaylistTabContent0;
                playlistSharedViewModel$updateMusicTabContent$10.D = 1;
                if(this.c.emit(musicPlaylistTabContent0, playlistSharedViewModel$updateMusicTabContent$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                musicPlaylistTabContent0 = playlistSharedViewModel$updateMusicTabContent$10.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateMusicPageContent: " + musicPlaylistTabContent0, null, false, 6, null);
        return H.a;
    }

    @NotNull
    public final SharedFlow getActivityResultEvent() {
        return this.r;
    }

    @NotNull
    public final SharedFlow getDrawerTabContent() {
        return this.f;
    }

    @NotNull
    public final StateFlow getDrawerTabInfo() {
        return this.h;
    }

    @NotNull
    public final PlaylistTab getFocusingTab() {
        return (PlaylistTab)this.k.getValue();
    }

    @NotNull
    public final StateFlow getFocusingTabFlow() {
        return this.l;
    }

    @Nullable
    public final s getFocusingTabTiaraProperty() {
        Integer integer0 = this.getFocusingTab().getIndex();
        return (s)this.m.get(integer0);
    }

    @NotNull
    public final StateFlow getHeaderBtnState() {
        return this.n;
    }

    @NotNull
    public final SharedFlow getMixUpTabContent() {
        return this.j;
    }

    @NotNull
    public final SharedFlow getMusicTabContent() {
        return this.d;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        return this.a;
    }

    @Nullable
    public final s getTabTiaraProperty(@NotNull PlaylistTab playlistTab0) {
        q.g(playlistTab0, "page");
        return (s)this.m.get(playlistTab0.getIndex());
    }

    @NotNull
    public final StateFlow getVisibilityController() {
        return this.p;
    }

    public final void handleActivityResultEvent(@NotNull NewActivityEvent playlistSharedViewModel$NewActivityEvent0) {
        q.g(playlistSharedViewModel$NewActivityEvent0, "event");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(playlistSharedViewModel$NewActivityEvent0, null) {
            public final NewActivityEvent B;
            public int r;
            public final PlaylistSharedViewModel w;

            {
                this.w = playlistSharedViewModel0;
                this.B = playlistSharedViewModel$NewActivityEvent0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.handleActivityResultEvent.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.handleActivityResultEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.q.emit(this.B, this) == a0 ? a0 : H.a;
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
        }, 3, null);
    }

    public final boolean isValidPlaylistId(@NotNull PlaylistId playlistId0) {
        q.g(playlistId0, "curPlaylistId");
        return k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.MUSIC, PlaylistId.DRAWER, PlaylistId.MIX_UP}).contains(playlistId0);
    }

    public final void reselectTab() {
        if(this.getFocusingTab() == PlaylistTab.DRAWER) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
                public int r;
                public final PlaylistSharedViewModel w;

                {
                    this.w = playlistSharedViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.reselectTab.1(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.reselectTab.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return this.w.c(DrawerPlaylistTabContent.PLAYLIST_LIST, this) == a0 ? a0 : H.a;
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
            }, 3, null);
        }
        String s = e.b("reselectTab: ", this.getFocusingTab().name());
        LogU.debug$default(this.b, s, null, false, 6, null);
    }

    public final void updateControllerVisibility(boolean z) {
        this.o.setValue(Boolean.valueOf(z));
        LogU.debug$default(this.b, "updateControllerVisibility: " + z, null, false, 6, null);
    }

    @Nullable
    public final Object updateDrawerTabContentToPlaylistList(@NotNull Continuation continuation0) {
        Object object0 = this.c(DrawerPlaylistTabContent.PLAYLIST_LIST, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Object updateDrawerTabContentToSongWithTabInfo(@NotNull DrawerPlaylistTabInfo drawerPlaylistTabInfo0, @NotNull Continuation continuation0) {
        this.g.setValue(drawerPlaylistTabInfo0);
        Object object0 = this.c(DrawerPlaylistTabContent.SONG_LIST, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Object updateDrawerTabDataToDefault(@NotNull Continuation continuation0) {
        com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateDrawerTabDataToDefault.1 playlistSharedViewModel$updateDrawerTabDataToDefault$10;
        if(continuation0 instanceof com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateDrawerTabDataToDefault.1) {
            playlistSharedViewModel$updateDrawerTabDataToDefault$10 = (com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateDrawerTabDataToDefault.1)continuation0;
            int v = playlistSharedViewModel$updateDrawerTabDataToDefault$10.B;
            if((v & 0x80000000) == 0) {
                playlistSharedViewModel$updateDrawerTabDataToDefault$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateDrawerTabDataToDefault(this);
                    }
                };
            }
            else {
                playlistSharedViewModel$updateDrawerTabDataToDefault$10.B = v ^ 0x80000000;
            }
        }
        else {
            playlistSharedViewModel$updateDrawerTabDataToDefault$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateDrawerTabDataToDefault(this);
                }
            };
        }
        Object object0 = playlistSharedViewModel$updateDrawerTabDataToDefault$10.r;
        a a0 = a.a;
        H h0 = H.a;
        switch(playlistSharedViewModel$updateDrawerTabDataToDefault$10.B) {
            case 0: {
                d5.n.D(object0);
                B b0 = ((d3)this.a).g();
                playlistSharedViewModel$updateDrawerTabDataToDefault$10.B = 1;
                object0 = ListenableFutureKt.await(b0, playlistSharedViewModel$updateDrawerTabDataToDefault$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((oc.H)object0) instanceof nc.a) {
            DrawerPlaylistTabInfo drawerPlaylistTabInfo0 = new DrawerPlaylistTabInfo(((nc.a)(((oc.H)object0))));
            playlistSharedViewModel$updateDrawerTabDataToDefault$10.B = 2;
            if(this.updateDrawerTabContentToSongWithTabInfo(drawerPlaylistTabInfo0, playlistSharedViewModel$updateDrawerTabDataToDefault$10) == a0) {
                return a0;
            }
        }
        else {
            playlistSharedViewModel$updateDrawerTabDataToDefault$10.B = 3;
            if(this.c(DrawerPlaylistTabContent.PLAYLIST_LIST, playlistSharedViewModel$updateDrawerTabDataToDefault$10) == a0) {
                return a0;
            }
        }
        return h0;
    }

    public final void updateFocusingTab(@NotNull PlaylistTab playlistTab0) {
        q.g(playlistTab0, "tab");
        LogU.debug$default(this.b, e.b("updateFocusingTab: ", playlistTab0.name()), null, false, 6, null);
        this.k.setValue(playlistTab0);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public Object r;
            public final PlaylistSharedViewModel w;

            {
                this.w = playlistSharedViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                d5.n.D(object0);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                    public final PlaylistSharedViewModel B;
                    public List r;
                    public int w;

                    {
                        this.B = playlistSharedViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.1(this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        List list0;
                        a a0 = a.a;
                        PlaylistSharedViewModel playlistSharedViewModel0 = this.B;
                        switch(this.w) {
                            case 0: {
                                d5.n.D(object0);
                                list0 = k.A(new MusicPlaylistTabContent[]{MusicPlaylistTabContent.SEARCH_MUSIC, MusicPlaylistTabContent.SEARCH_SMART});
                                this.r = list0;
                                this.w = 1;
                                object0 = FlowKt.first(playlistSharedViewModel0.c, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                list0 = this.r;
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(list0.contains(object0)) {
                            this.r = null;
                            this.w = 2;
                            if(playlistSharedViewModel0.updateMusicTabContentToDefault(this) == a0) {
                                return a0;
                            }
                        }
                        return H.a;
                    }
                }, 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                    public int r;
                    public final PlaylistSharedViewModel w;

                    {
                        this.w = playlistSharedViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.2(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        PlaylistSharedViewModel playlistSharedViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                object0 = FlowKt.first(playlistSharedViewModel0.e, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(object0 == DrawerPlaylistTabContent.SEARCH) {
                            this.r = 2;
                            if(playlistSharedViewModel0.updateDrawerTabDataToDefault(this) == a0) {
                                return a0;
                            }
                        }
                        return H.a;
                    }
                }, 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                    public int r;
                    public final PlaylistSharedViewModel w;

                    {
                        this.w = playlistSharedViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.3(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateFocusingTab.1.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        PlaylistSharedViewModel playlistSharedViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                object0 = FlowKt.first(playlistSharedViewModel0.i, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                d5.n.D(object0);
                                break;
                            }
                            case 2: {
                                d5.n.D(object0);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(object0 == MixUpPlaylistTabContent.SEARCH) {
                            this.r = 2;
                            if(playlistSharedViewModel0.updateMixUpContentToDefault(this) == a0) {
                                return a0;
                            }
                        }
                        return H.a;
                    }
                }, 3, null);
                return H.a;
            }
        }, 3, null);
    }

    public final void updateFocusingTabByIndex(int v) {
        LogU.debug$default(this.b, "updateFocusingIndex: " + v, null, false, 6, null);
        PlaylistTab playlistTab0 = PlaylistTab.Companion.fromIndex(v);
        if(playlistTab0 == null) {
            LogU.error$default(this.b, "updateFocusingTabByIndex - Invalid index: " + v, null, false, 6, null);
            return;
        }
        this.updateFocusingTab(playlistTab0);
    }

    @Nullable
    public final Object updateFocusingTabContentToSearch(@NotNull Continuation continuation0) {
        int v = WhenMappings.$EnumSwitchMapping$1[this.getFocusingTab().ordinal()];
        H h0 = H.a;
        switch(v) {
            case 1: {
                if(q.b(((d3)this.a).m(), Boolean.TRUE)) {
                    Object object0 = this.e(MusicPlaylistTabContent.SEARCH_SMART, continuation0);
                    return object0 == a.a ? object0 : h0;
                }
                Object object1 = this.e(MusicPlaylistTabContent.SEARCH_MUSIC, continuation0);
                return object1 == a.a ? object1 : h0;
            }
            case 2: {
                Object object2 = this.c(DrawerPlaylistTabContent.SEARCH, continuation0);
                return object2 == a.a ? object2 : h0;
            }
            case 3: {
                Object object3 = this.d(MixUpPlaylistTabContent.SEARCH, continuation0);
                return object3 == a.a ? object3 : h0;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @Nullable
    public final Object updateFocusingTabContentToSong(@NotNull Continuation continuation0) {
        int v = WhenMappings.$EnumSwitchMapping$1[this.getFocusingTab().ordinal()];
        H h0 = H.a;
        switch(v) {
            case 1: {
                if(q.b(((d3)this.a).m(), Boolean.TRUE)) {
                    Object object0 = this.e(MusicPlaylistTabContent.SONG_LIST_SMART, continuation0);
                    return object0 == a.a ? object0 : h0;
                }
                Object object1 = this.e(MusicPlaylistTabContent.SONG_LIST_MUSIC, continuation0);
                return object1 == a.a ? object1 : h0;
            }
            case 2: {
                Object object2 = this.c(DrawerPlaylistTabContent.SONG_LIST, continuation0);
                return object2 == a.a ? object2 : h0;
            }
            case 3: {
                Object object3 = this.d(MixUpPlaylistTabContent.SONG_LIST, continuation0);
                return object3 == a.a ? object3 : h0;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public final void updateFocusingTabTiaraProperty(@NotNull s s0) {
        q.g(s0, "tiaraCommon");
        Integer integer0 = this.getFocusingTab().getIndex();
        this.m.put(integer0, s0);
        String s1 = Y.l(d.o("updateFocusingTabTiaraProperty: ", this.getFocusingTab().name(), ", ", s0.a, "/"), s0.b, "/", s0.c);
        LogU.debug$default(this.b, s1, null, false, 6, null);
    }

    public final void updateFocusingTabToCurrentPlaylist() {
        LogU.debug$default(this.b, "updateFocusingIndexToCurrentPlaylist", null, false, 6, null);
        this.updateFocusingTab(this.b());
    }

    @Nullable
    public final Object updateMixUpContentToDefault(@NotNull Continuation continuation0) {
        Object object0 = this.d(MixUpPlaylistTabContent.SONG_LIST, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Object updateMusicTabContentToDefault(@NotNull Continuation continuation0) {
        com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateMusicTabContentToDefault.1 playlistSharedViewModel$updateMusicTabContentToDefault$10;
        if(continuation0 instanceof com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateMusicTabContentToDefault.1) {
            playlistSharedViewModel$updateMusicTabContentToDefault$10 = (com.iloen.melon.player.playlist.PlaylistSharedViewModel.updateMusicTabContentToDefault.1)continuation0;
            int v = playlistSharedViewModel$updateMusicTabContentToDefault$10.B;
            if((v & 0x80000000) == 0) {
                playlistSharedViewModel$updateMusicTabContentToDefault$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateMusicTabContentToDefault(this);
                    }
                };
            }
            else {
                playlistSharedViewModel$updateMusicTabContentToDefault$10.B = v ^ 0x80000000;
            }
        }
        else {
            playlistSharedViewModel$updateMusicTabContentToDefault$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateMusicTabContentToDefault(this);
                }
            };
        }
        Object object0 = playlistSharedViewModel$updateMusicTabContentToDefault$10.r;
        a a0 = a.a;
        switch(playlistSharedViewModel$updateMusicTabContentToDefault$10.B) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = FlowKt.filterNotNull(((b)((d3)this.a).a).r);
                playlistSharedViewModel$updateMusicTabContentToDefault$10.B = 1;
                object0 = FlowKt.first(flow0, playlistSharedViewModel$updateMusicTabContentToDefault$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        playlistSharedViewModel$updateMusicTabContentToDefault$10.B = 2;
        return this.e((((Boolean)object0).booleanValue() ? MusicPlaylistTabContent.SONG_LIST_SMART : MusicPlaylistTabContent.SONG_LIST_MUSIC), playlistSharedViewModel$updateMusicTabContentToDefault$10) == a0 ? a0 : H.a;
    }

    public final void updateTiaraProperty(@NotNull PlaylistTab playlistTab0, @NotNull s s0) {
        q.g(playlistTab0, "page");
        q.g(s0, "tiaraCommon");
        this.m.put(playlistTab0.getIndex(), s0);
        String s1 = Y.l(d.o("updateTiaraProperty: ", playlistTab0.name(), ", ", s0.a, "/"), s0.b, "/", s0.c);
        LogU.debug$default(this.b, s1, null, false, 6, null);
    }
}

