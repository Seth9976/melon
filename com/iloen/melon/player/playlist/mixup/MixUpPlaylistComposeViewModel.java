package com.iloen.melon.player.playlist.mixup;

import A7.d;
import M6.B;
import Na.f;
import Pc.e;
import U4.x;
import Ud.g;
import Ud.h;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.response.AuthLocationRes.Response;
import com.iloen.melon.net.v4x.response.AuthLocationRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddFailType.SectionRepeatInterrupt;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.player.playlist.common.DeletePlaylist.DeletePlaylistByPlayables;
import com.iloen.melon.player.playlist.common.DeletePlaylist;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N0;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.m3;
import com.melon.ui.n0;
import com.melon.ui.q3;
import com.melon.ui.s4;
import com.melon.ui.t3;
import db.c;
import e1.b;
import e1.m;
import eb.y;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import kc.Q2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import ob.a;
import ob.z;
import oc.T;
import oc.U;
import oc.t;
import oc.v;
import oc.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p0.p;
import pc.Z;
import pc.j1;
import pc.z0;
import va.e0;
import we.n;

@Metadata(d1 = {"\u0000\u00CE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 }2\u00020\u0001:\u0002}~Bs\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0011\u001A\u00020\u0010\u0012\u0006\u0010\u0013\u001A\u00020\u0012\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u0012\u0006\u0010\u0017\u001A\u00020\u0016\u0012\u0006\u0010\u0019\u001A\u00020\u0018\u0012\u0006\u0010\u001B\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b\u001F\u0010 J\r\u0010!\u001A\u00020\u001E\u00A2\u0006\u0004\b!\u0010 J\r\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u0004\u0018\u00010%\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010*\u001A\u0004\u0018\u00010)2\u0006\u0010(\u001A\u00020\"\u00A2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001A\u00020\u001EH\u0086@\u00A2\u0006\u0004\b,\u0010-J\u0017\u00101\u001A\u0002002\u0006\u0010/\u001A\u00020.H\u0014\u00A2\u0006\u0004\b1\u00102J\u001D\u00105\u001A\u0002002\u0006\u00103\u001A\u00020\"2\u0006\u00104\u001A\u00020\"\u00A2\u0006\u0004\b5\u00106J\u001D\u00107\u001A\u0002002\u0006\u00103\u001A\u00020\"2\u0006\u00104\u001A\u00020\"\u00A2\u0006\u0004\b7\u00106J!\u0010:\u001A\u0002002\b\u00108\u001A\u0004\u0018\u00010\"2\b\u00109\u001A\u0004\u0018\u00010%\u00A2\u0006\u0004\b:\u0010;J\u0015\u0010=\u001A\u0002002\u0006\u0010<\u001A\u00020\"\u00A2\u0006\u0004\b=\u0010>J\r\u0010?\u001A\u000200\u00A2\u0006\u0004\b?\u0010@J\r\u0010A\u001A\u000200\u00A2\u0006\u0004\bA\u0010@J\u0015\u0010C\u001A\u0002002\u0006\u0010B\u001A\u00020\u001E\u00A2\u0006\u0004\bC\u0010DJ\r\u0010E\u001A\u000200\u00A2\u0006\u0004\bE\u0010@J\u0010\u0010F\u001A\u000200H\u0086@\u00A2\u0006\u0004\bF\u0010-J\u0013\u0010H\u001A\b\u0012\u0004\u0012\u00020%0G\u00A2\u0006\u0004\bH\u0010IJ\r\u0010J\u001A\u000200\u00A2\u0006\u0004\bJ\u0010@J\u0015\u0010L\u001A\u0002002\u0006\u0010K\u001A\u00020%\u00A2\u0006\u0004\bL\u0010MJ\r\u0010N\u001A\u000200\u00A2\u0006\u0004\bN\u0010@J\r\u0010O\u001A\u000200\u00A2\u0006\u0004\bO\u0010@J\u0015\u0010R\u001A\u0002002\u0006\u0010Q\u001A\u00020P\u00A2\u0006\u0004\bR\u0010SR\u0017\u0010X\u001A\u00020T8\u0006\u00A2\u0006\f\n\u0004\b9\u0010U\u001A\u0004\bV\u0010WR\u001F\u0010_\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010Z0Y8\u0006\u00A2\u0006\f\n\u0004\b[\u0010\\\u001A\u0004\b]\u0010^R\u001D\u0010a\u001A\b\u0012\u0004\u0012\u00020\u001E0Y8\u0006\u00A2\u0006\f\n\u0004\b`\u0010\\\u001A\u0004\ba\u0010^R\u001D\u0010h\u001A\b\u0012\u0004\u0012\u00020c0b8\u0006\u00A2\u0006\f\n\u0004\bd\u0010e\u001A\u0004\bf\u0010gR\u001F\u0010n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010%0i8\u0006\u00A2\u0006\f\n\u0004\bj\u0010k\u001A\u0004\bl\u0010mR\u001D\u0010B\u001A\b\u0012\u0004\u0012\u00020\u001E0Y8\u0006\u00A2\u0006\f\n\u0004\bo\u0010\\\u001A\u0004\bp\u0010^R\u001B\u0010v\u001A\u00020q8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\br\u0010s\u001A\u0004\bt\u0010uR\u001B\u0010{\u001A\u00020w8FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\bx\u0010s\u001A\u0004\by\u0010zR\u0011\u0010|\u001A\u00020\u001E8F\u00A2\u0006\u0006\u001A\u0004\b|\u0010 \u00A8\u0006\u007F"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel;", "Lcom/melon/ui/n0;", "Landroid/content/Context;", "context", "LPc/d;", "stringProvider", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "Lob/a;", "playableUseCase", "Leb/y;", "uaLogUserCase", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;", "deleteHelper", "Lmb/k;", "loginUseCase", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "Lcom/melon/ui/b3;", "morePopupUserEventHelper", "Lcom/melon/ui/Q;", "addPlayUserEventHelper", "Ldb/c;", "locationUseCase", "Lk8/a;", "blockingProgressDialogManage", "<init>", "(Landroid/content/Context;LPc/d;Lkc/s2;Lob/z;Lob/a;Leb/y;Lcom/iloen/melon/player/playlist/common/PlaylistDeleteHelper;Lmb/k;Lcom/melon/ui/t3;Lcom/melon/ui/b3;Lcom/melon/ui/Q;Ldb/c;Lk8/a;)V", "", "isLoginUser", "()Z", "isDj", "", "getCurrentIndex", "()I", "Lcom/iloen/melon/playback/Playable;", "getCurrentPlayable", "()Lcom/iloen/melon/playback/Playable;", "uiOrder", "Lod/a;", "getMixUpAreaOrNull", "(I)Lod/a;", "getIsDjMalrang", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LPc/e;", "userEvent", "Lie/H;", "onUserEvent", "(LPc/e;)V", "fromUiPosition", "toUiPosition", "moveFromDragging", "(II)V", "moveFromDragEnd", "uiPosition", "p", "play", "(Ljava/lang/Integer;Lcom/iloen/melon/playback/Playable;)V", "index", "updateSelectedIndex", "(I)V", "releaseSelectedAll", "()V", "toggleSelectAll", "hasToolbarPadding", "updateHasToolbarPadding", "(Z)V", "selectAllWaitingList", "updateCurrentFocus", "", "getSelectedPlayableList", "()Ljava/util/List;", "deleteSelected", "playable", "deletePlayable", "(Lcom/iloen/melon/playback/Playable;)V", "playPopularPlaylist", "addAll", "", "pvAction", "clearTiaraPropertyAndPerformPvDummyLogging", "(Ljava/lang/String;)V", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "Lkotlinx/coroutines/flow/StateFlow;", "Lpc/c;", "r", "Lkotlinx/coroutines/flow/StateFlow;", "getMixUpInfoStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "mixUpInfoStateFlow", "s", "isCurrentPlaylistStateFlow", "Lp0/p;", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "t", "Lp0/p;", "getUiList", "()Lp0/p;", "uiList", "Lkotlinx/coroutines/flow/SharedFlow;", "x", "Lkotlinx/coroutines/flow/SharedFlow;", "getCurrentFocusPlayableFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentFocusPlayableFlow", "z", "getHasToolbarPadding", "Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistTiaraLogHelper;", "C", "Lie/j;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistTiaraLogHelper;", "tiaraLogHelper", "Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistViewImpLogHelper;", "D", "getViewImpLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistViewImpLogHelper;", "viewImpLogHelper", "isSelectedAny", "Companion", "MixUpRawUiData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeViewModel extends n0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000E\u0010\rJ4\u0010\u000F\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\rJ\u001A\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u000BR\u0017\u0010\u0006\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\rR\u0017\u0010\u0007\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u001D\u001A\u0004\b \u0010\r¨\u0006!"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel$MixUpRawUiData;", "", "", "Lcom/iloen/melon/player/playlist/mixup/MixUpUIItemData;", "uiList", "", "currentIndex", "waitingTitleIndex", "<init>", "(Ljava/util/List;II)V", "component1", "()Ljava/util/List;", "component2", "()I", "component3", "copy", "(Ljava/util/List;II)Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel$MixUpRawUiData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getUiList", "b", "I", "getCurrentIndex", "c", "getWaitingTitleIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class MixUpRawUiData {
        public final List a;
        public final int b;
        public final int c;

        public MixUpRawUiData(@NotNull List list0, int v, int v1) {
            q.g(list0, "uiList");
            super();
            this.a = list0;
            this.b = v;
            this.c = v1;
        }

        @NotNull
        public final List component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final MixUpRawUiData copy(@NotNull List list0, int v, int v1) {
            q.g(list0, "uiList");
            return new MixUpRawUiData(list0, v, v1);
        }

        public static MixUpRawUiData copy$default(MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0, List list0, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                list0 = mixUpPlaylistComposeViewModel$MixUpRawUiData0.a;
            }
            if((v2 & 2) != 0) {
                v = mixUpPlaylistComposeViewModel$MixUpRawUiData0.b;
            }
            if((v2 & 4) != 0) {
                v1 = mixUpPlaylistComposeViewModel$MixUpRawUiData0.c;
            }
            return mixUpPlaylistComposeViewModel$MixUpRawUiData0.copy(list0, v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MixUpRawUiData)) {
                return false;
            }
            if(!q.b(this.a, ((MixUpRawUiData)object0).a)) {
                return false;
            }
            return this.b == ((MixUpRawUiData)object0).b ? this.c == ((MixUpRawUiData)object0).c : false;
        }

        public final int getCurrentIndex() {
            return this.b;
        }

        @NotNull
        public final List getUiList() {
            return this.a;
        }

        public final int getWaitingTitleIndex() {
            return this.c;
        }

        @Override
        public int hashCode() {
            return this.c + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("MixUpRawUiData(uiList=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", currentIndex=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", waitingTitleIndex=");
            return x.g(this.c, ")", stringBuilder0);
        }
    }

    public static final int $stable;
    public final g A;
    public final r B;
    public final r C;
    @NotNull
    public static final Companion Companion;
    public final r D;
    public final Context a;
    public final Pc.d b;
    public final s2 c;
    public final z d;
    public final a e;
    public final y f;
    public final PlaylistDeleteHelper g;
    public final k h;
    public final t3 i;
    public final b3 j;
    public final Q k;
    public final c l;
    public final k8.a m;
    public final LogU n;
    public final r o;
    public final PlaylistId p;
    public pc.d q;
    public final StateFlow r;
    public final StateFlow s;
    public final p t;
    public int u;
    public int v;
    public final MutableSharedFlow w;
    public final SharedFlow x;
    public final MutableStateFlow y;
    public final StateFlow z;

    static {
        MixUpPlaylistComposeViewModel.Companion = new Companion(null);
        MixUpPlaylistComposeViewModel.$stable = 8;
    }

    @Inject
    public MixUpPlaylistComposeViewModel(@NotNull Context context0, @NotNull Pc.d d0, @NotNull s2 s20, @NotNull z z0, @NotNull a a0, @NotNull y y0, @NotNull PlaylistDeleteHelper playlistDeleteHelper0, @NotNull k k0, @NotNull t3 t30, @NotNull b3 b30, @NotNull Q q0, @NotNull c c0, @NotNull k8.a a1) {
        q.g(context0, "context");
        pc.c c1;
        q.g(d0, "stringProvider");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        q.g(a0, "playableUseCase");
        q.g(y0, "uaLogUserCase");
        q.g(playlistDeleteHelper0, "deleteHelper");
        q.g(k0, "loginUseCase");
        q.g(t30, "putPopupUserEventHelper");
        q.g(b30, "morePopupUserEventHelper");
        q.g(q0, "addPlayUserEventHelper");
        q.g(c0, "locationUseCase");
        q.g(a1, "blockingProgressDialogManage");
        super();
        this.a = context0;
        this.b = d0;
        this.c = s20;
        this.d = z0;
        this.e = a0;
        this.f = y0;
        this.g = playlistDeleteHelper0;
        this.h = k0;
        this.i = t30;
        this.j = b30;
        this.k = q0;
        this.l = c0;
        this.m = a1;
        this.n = LogU.Companion.create("MixUpPlaylistComposeViewModel", true, Category.UI);
        this.o = d3.g.Q(new l(this, 1));
        this.p = PlaylistId.MIX_UP;
        w w0 = ((d3)s20).k();
        pc.d d1 = w0 instanceof pc.d ? ((pc.d)w0) : null;
        if(d1 == null) {
            c1 = null;
        }
        else {
            z0 z00 = ((Z)d1).m();
            c1 = z00 == null ? null : z00.c;
        }
        this.r = FlowKt.stateIn(FlowKt.callbackFlow(new MixUpPlaylistComposeViewModel.initMixUpInfoStateFlow.1(this, null)), f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), c1);
        Flow flow0 = FlowKt.distinctUntilChanged(new MixUpPlaylistComposeViewModel.initIsCurrentPlaylistStateFlow..inlined.map.1(((d3)s20).i()));
        T2.a a2 = f0.h(this);
        SharingStarted sharingStarted0 = kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null);
        PlaylistId playlistId0 = ((d3)s20).j();
        this.s = FlowKt.stateIn(flow0, a2, sharingStarted0, Boolean.valueOf((playlistId0 == null ? false : playlistId0.isMixUp())));
        this.t = new p();
        this.u = -1;
        this.v = -1;
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.w = mutableSharedFlow0;
        this.x = FlowKt.asSharedFlow(mutableSharedFlow0);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.y = mutableStateFlow0;
        this.z = FlowKt.asStateFlow(mutableStateFlow0);
        g g0 = new g(new MixUpPlaylistComposeViewModel.initSelectHelper.1());  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.c = new MixUpPlaylistComposeViewModel.initSelectHelper.2.1();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.A = g0;
        this.B = d3.g.Q(new l(this, 8));
        this.C = d3.g.Q(new l(this, 9));
        this.D = d3.g.Q(new l(this, 10));
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public final MixUpPlaylistComposeViewModel B;
            public MixUpPlaylistComposeViewModel r;
            public int w;

            {
                this.B = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.1(this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel1;
                ne.a a0 = ne.a.a;
                switch(this.w) {
                    case 0: {
                        d5.n.D(object0);
                        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.B;
                        this.r = mixUpPlaylistComposeViewModel0;
                        this.w = 1;
                        Object object1 = MixUpPlaylistComposeViewModel.access$getMixUpPlaylist(mixUpPlaylistComposeViewModel0, this);
                        if(object1 == a0) {
                            return a0;
                        }
                        mixUpPlaylistComposeViewModel1 = mixUpPlaylistComposeViewModel0;
                        object0 = object1;
                        break;
                    }
                    case 1: {
                        mixUpPlaylistComposeViewModel1 = this.r;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                n0.updateTiaraProperty$default(mixUpPlaylistComposeViewModel1, null, null, ((Z)(((pc.d)object0))).getMenuId(), 3, null);
                return H.a;
            }
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public Object r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                d5.n.D(object0);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                    public int r;
                    public final MixUpPlaylistComposeViewModel w;

                    {
                        this.w = mixUpPlaylistComposeViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                                c0.a = true;
                                Flow flow0 = FlowKt.filterNotNull(MixUpPlaylistComposeViewModel.access$getRawUiDataStateFlow(this.w));
                                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.1.1 mixUpPlaylistComposeViewModel$2$1$10 = new n(this.w, null) {
                                    public final MixUpPlaylistComposeViewModel B;
                                    public Object r;
                                    public final C w;

                                    {
                                        this.w = c0;
                                        this.B = mixUpPlaylistComposeViewModel0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.1.1(this.w, this.B, continuation0);
                                        continuation1.r = object0;
                                        return continuation1;
                                    }

                                    public final Object invoke(MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.1.1)this.create(mixUpPlaylistComposeViewModel$MixUpRawUiData0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((MixUpRawUiData)object0), ((Continuation)object1));
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0 = (MixUpRawUiData)this.r;
                                        d5.n.D(object0);
                                        C c0 = this.w;
                                        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.B;
                                        if(c0.a) {
                                            MixUpPlaylistComposeViewModel.access$updateUiData(mixUpPlaylistComposeViewModel0, mixUpPlaylistComposeViewModel$MixUpRawUiData0.getUiList(), mixUpPlaylistComposeViewModel$MixUpRawUiData0.getCurrentIndex(), mixUpPlaylistComposeViewModel$MixUpRawUiData0.getWaitingTitleIndex());
                                            c0.a = false;
                                            return H.a;
                                        }
                                        MixUpPlaylistComposeViewModel.access$updateUiDataPreservePrevSelectedState(mixUpPlaylistComposeViewModel0, mixUpPlaylistComposeViewModel$MixUpRawUiData0);
                                        return H.a;
                                    }
                                };
                                this.r = 1;
                                return FlowKt.collectLatest(flow0, mixUpPlaylistComposeViewModel$2$1$10, this) == a0 ? a0 : H.a;
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
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                    public int r;
                    public final MixUpPlaylistComposeViewModel w;

                    {
                        this.w = mixUpPlaylistComposeViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.2(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                object0 = MixUpPlaylistComposeViewModel.access$getDistinctCurrentPlayableFlow(mixUpPlaylistComposeViewModel0, this);
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
                        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.2.1 mixUpPlaylistComposeViewModel$2$2$10 = new n(null) {
                            public final MixUpPlaylistComposeViewModel B;
                            public int r;
                            public Object w;

                            {
                                this.B = mixUpPlaylistComposeViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.2.1(this.B, continuation0);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.2.2.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Playable)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Playable playable0 = (Playable)this.w;
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        this.w = null;
                                        this.r = 1;
                                        return MixUpPlaylistComposeViewModel.access$updateCurrentFocus(this.B, playable0, this) == a0 ? a0 : H.a;
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
                        this.r = 2;
                        return FlowKt.collectLatest(((Flow)object0), mixUpPlaylistComposeViewModel$2$2$10, this) == a0 ? a0 : H.a;
                    }
                }, 3, null);
                return H.a;
            }
        }, 3, null);

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.toolBarEventHelper.2.1 extends kotlin.jvm.internal.n implements we.k {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((I4)object0));
                return H.a;
            }

            public final void invoke(I4 i40) {
                q.g(i40, "p0");
                MixUpPlaylistComposeViewModel.access$sendUiEvent(((MixUpPlaylistComposeViewModel)this.receiver), i40);
            }
        }

    }

    public static final void access$afterDeleteTask(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, boolean z, U u0) {
        d3 d30 = (d3)mixUpPlaylistComposeViewModel0.c;
        boolean z1 = false;
        boolean z2 = d30.j() == mixUpPlaylistComposeViewModel0.p;
        if(u0 instanceof T && b.D(((T)u0).d)) {
            z1 = true;
        }
        if(z2 && z && z1) {
            LogU.debug$default(mixUpPlaylistComposeViewModel0.n, "afterDeleteTask() - change to default playlist", null, false, 6, null);
            d30.b();
        }
    }

    public static final Q access$getAddPlayUserEventHelper$p(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        return mixUpPlaylistComposeViewModel0.k;
    }

    public static final Object access$getDistinctCurrentPlayableFlow(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1 mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10;
        mixUpPlaylistComposeViewModel0.getClass();
        if(continuation0 instanceof MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1) {
            mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10 = (MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10.B;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10 = new MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1(mixUpPlaylistComposeViewModel0, continuation0);
            }
            else {
                mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10.B = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10 = new MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow.1(mixUpPlaylistComposeViewModel0, continuation0);
        }
        Object object0 = mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10.r;
        ne.a a0 = ne.a.a;
        switch(mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10.B) {
            case 0: {
                d5.n.D(object0);
                mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10.B = 1;
                object0 = mixUpPlaylistComposeViewModel0.b(mixUpPlaylistComposeViewModel$getDistinctCurrentPlayableFlow$10);
                return object0 == a0 ? a0 : FlowKt.distinctUntilChanged(new MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow..inlined.map.1(((Z)(((pc.d)object0))).f));
            }
            case 1: {
                d5.n.D(object0);
                return FlowKt.distinctUntilChanged(new MixUpPlaylistComposeViewModel.getDistinctCurrentPlayableFlow..inlined.map.1(((Z)(((pc.d)object0))).f));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final LogU access$getLog$p(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        return mixUpPlaylistComposeViewModel0.n;
    }

    public static final z access$getPlayerUseCase$p(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        return mixUpPlaylistComposeViewModel0.d;
    }

    public static final StateFlow access$getRawUiDataStateFlow(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        w w0 = ((d3)mixUpPlaylistComposeViewModel0.c).k();
        if(w0 instanceof pc.d) {
            MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0 = mixUpPlaylistComposeViewModel0.d(((Z)(((pc.d)w0))).m(), mixUpPlaylistComposeViewModel0.d.n(), true);
            return FlowKt.stateIn(FlowKt.callbackFlow(new MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1(mixUpPlaylistComposeViewModel0, null)), f0.h(mixUpPlaylistComposeViewModel0), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), mixUpPlaylistComposeViewModel$MixUpRawUiData0);
        }
        return FlowKt.stateIn(FlowKt.callbackFlow(new MixUpPlaylistComposeViewModel.getRawUiDataStateFlow.1(mixUpPlaylistComposeViewModel0, null)), f0.h(mixUpPlaylistComposeViewModel0), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), null);
    }

    public static final StatsElementsBase access$getStatsElements(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        return mixUpPlaylistComposeViewModel0.getStatsElements();
    }

    public static final Jd.a access$getToolBarEventHelper(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        return (Jd.a)mixUpPlaylistComposeViewModel0.o.getValue();
    }

    public static final MixUpRawUiData access$makeRawUiData(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, z0 z00, boolean z, boolean z1) {
        return mixUpPlaylistComposeViewModel0.d(z00, z, z1);
    }

    public static final void access$playDjMalrangAfterLocationAgreementAndPermissionCheck(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, boolean z, boolean z1) {
        mixUpPlaylistComposeViewModel0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.h(mixUpPlaylistComposeViewModel0), null, null, new MixUpPlaylistComposeViewModel.playDjMalrangAfterLocationAgreementAndPermissionCheck.1(mixUpPlaylistComposeViewModel0, z, z1, null), 3, null);
    }

    public static final Object access$playInternal(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Integer integer0, Playable playable0, Continuation continuation0) {
        int v3;
        boolean z2;
        boolean z1;
        Object object1;
        int v1;
        MixUpPlaylistComposeViewModel.playInternal.1 mixUpPlaylistComposeViewModel$playInternal$10;
        PlaylistId playlistId0 = mixUpPlaylistComposeViewModel0.p;
        z z0 = mixUpPlaylistComposeViewModel0.d;
        if(continuation0 instanceof MixUpPlaylistComposeViewModel.playInternal.1) {
            mixUpPlaylistComposeViewModel$playInternal$10 = (MixUpPlaylistComposeViewModel.playInternal.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$playInternal$10.I;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$playInternal$10 = new MixUpPlaylistComposeViewModel.playInternal.1(mixUpPlaylistComposeViewModel0, continuation0);
            }
            else {
                mixUpPlaylistComposeViewModel$playInternal$10.I = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$playInternal$10 = new MixUpPlaylistComposeViewModel.playInternal.1(mixUpPlaylistComposeViewModel0, continuation0);
        }
        Object object0 = mixUpPlaylistComposeViewModel$playInternal$10.E;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(mixUpPlaylistComposeViewModel$playInternal$10.I) {
            case 0: {
                d5.n.D(object0);
                if(integer0 != null && playable0 != null) {
                    v1 = ((int)integer0) >= mixUpPlaylistComposeViewModel0.u ? ((int)integer0) - 1 : ((int)integer0);
                    mixUpPlaylistComposeViewModel$playInternal$10.r = integer0;
                    mixUpPlaylistComposeViewModel$playInternal$10.w = playable0;
                    mixUpPlaylistComposeViewModel$playInternal$10.B = v1;
                    mixUpPlaylistComposeViewModel$playInternal$10.I = 1;
                    object1 = z0.p(playlistId0, v1, mixUpPlaylistComposeViewModel$playInternal$10);
                    if(object1 == a0) {
                        return a0;
                    }
                    goto label_35;
                }
                LogU.error$default(mixUpPlaylistComposeViewModel0.n, "play() position or p is null", null, false, 6, null);
                return h0;
            }
            case 1: {
                int v2 = mixUpPlaylistComposeViewModel$playInternal$10.B;
                playable0 = mixUpPlaylistComposeViewModel$playInternal$10.w;
                Integer integer1 = mixUpPlaylistComposeViewModel$playInternal$10.r;
                d5.n.D(object0);
                v1 = v2;
                integer0 = integer1;
                object1 = object0;
            label_35:
                if(((Boolean)object1).booleanValue()) {
                    mixUpPlaylistComposeViewModel0.sendUiEvent(new ShowSelectionRepeatInterruptPopup(new com.iloen.melon.player.playlist.mixup.n(mixUpPlaylistComposeViewModel0, integer0, playable0, 0)));
                    return h0;
                }
                Object object2 = je.p.n0(((int)integer0), mixUpPlaylistComposeViewModel0.t);
                PlayableItem mixUpUIItemData$PlayableItem0 = object2 instanceof PlayableItem ? ((PlayableItem)object2) : null;
                if(mixUpUIItemData$PlayableItem0 == null) {
                    return h0;
                }
                z1 = mixUpUIItemData$PlayableItem0.isCurrent();
                if(!mixUpUIItemData$PlayableItem0.isCurrentPlaylist()) {
                    B b0 = ((d3)mixUpPlaylistComposeViewModel0.c).a(playlistId0);
                    mixUpPlaylistComposeViewModel$playInternal$10.r = null;
                    mixUpPlaylistComposeViewModel$playInternal$10.w = null;
                    mixUpPlaylistComposeViewModel$playInternal$10.B = v1;
                    mixUpPlaylistComposeViewModel$playInternal$10.D = z1;
                    mixUpPlaylistComposeViewModel$playInternal$10.I = 2;
                    if(ListenableFutureKt.await(b0, mixUpPlaylistComposeViewModel$playInternal$10) == a0) {
                        return a0;
                    }
                    z2 = z1;
                    v3 = v1;
                    goto label_57;
                }
                goto label_59;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z2 = mixUpPlaylistComposeViewModel$playInternal$10.D;
        v3 = mixUpPlaylistComposeViewModel$playInternal$10.B;
        d5.n.D(object0);
    label_57:
        v1 = v3;
        z1 = z2;
    label_59:
        if(z1) {
            if(!z0.n()) {
                z0.u();
            }
            return h0;
        }
        z0.v(v1);
        return h0;
    }

    public static final Object access$playPopularPlaylistInternal(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Continuation continuation0) {
        AddPlay addAction$AddPlay1;
        MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1 mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10;
        mixUpPlaylistComposeViewModel0.getClass();
        if(continuation0 instanceof MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1) {
            mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10 = (MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.D;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10 = new MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1(mixUpPlaylistComposeViewModel0, continuation0);
            }
            else {
                mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.D = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10 = new MixUpPlaylistComposeViewModel.playPopularPlaylistInternal.1(mixUpPlaylistComposeViewModel0, continuation0);
        }
        Object object0 = mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.w;
        ne.a a0 = ne.a.a;
        switch(mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.D) {
            case 0: {
                d5.n.D(object0);
                AddPlay addAction$AddPlay0 = new AddPlay(false);
                String s = mixUpPlaylistComposeViewModel0.getMenuId();
                MixUp playDataForSeverContent$MixUp0 = new MixUp(j1.c, s, mixUpPlaylistComposeViewModel0.getStatsElements());
                AddServerContent addServerContent0 = new AddServerContent(addAction$AddPlay0, false, false, mixUpPlaylistComposeViewModel0.m, playDataForSeverContent$MixUp0, 6, null);
                mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.r = addAction$AddPlay0;
                mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.D = 1;
                object0 = addServerContent0.execute(mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10);
                if(object0 == a0) {
                    return a0;
                }
                addAction$AddPlay1 = addAction$AddPlay0;
                break;
            }
            case 1: {
                addAction$AddPlay1 = mixUpPlaylistComposeViewModel$playPopularPlaylistInternal$10.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((AddResult)object0).handleToast(addAction$AddPlay1);
        if(((AddResult)object0) instanceof Failure && q.b(((Failure)(((AddResult)object0))).getType(), SectionRepeatInterrupt.INSTANCE)) {
            mixUpPlaylistComposeViewModel0.sendUiEvent(new ShowSelectionRepeatInterruptPopup(new l(mixUpPlaylistComposeViewModel0, 0)));
        }
        return H.a;
    }

    public static final Object access$releaseSelectionRepeat(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, boolean z, Continuation continuation0) {
        Object object0 = mixUpPlaylistComposeViewModel0.d.b(0x7F13090F, continuation0);  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
        return object0 == ne.a.a ? object0 : H.a;
    }

    public static final Object access$updateCurrentFocus(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, Playable playable0, Continuation continuation0) {
        Object object0 = mixUpPlaylistComposeViewModel0.w.emit(playable0, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public static final void access$updateUiData(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, List list0, int v, int v1) {
        mixUpPlaylistComposeViewModel0.e(v, v1, list0);
    }

    public static final void access$updateUiDataPreservePrevSelectedState(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0) {
        mixUpPlaylistComposeViewModel0.getClass();
        long v = System.currentTimeMillis();
        p p0 = mixUpPlaylistComposeViewModel0.t;
        ArrayList arrayList0 = new ArrayList();
        ListIterator listIterator0 = p0.listIterator();
        while(((P0.r)listIterator0).hasNext()) {
            Object object0 = ((P0.r)listIterator0).next();
            if(((MixUpUIItemData)object0) instanceof h && ((h)(((MixUpUIItemData)object0))).isSelected()) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            arrayList1.add(((MixUpUIItemData)object1).getId());
        }
        HashSet hashSet0 = je.p.N0(arrayList1);
        ArrayList arrayList2 = new ArrayList();
        ListIterator listIterator1 = p0.listIterator();
        while(((P0.r)listIterator1).hasNext()) {
            Object object2 = ((P0.r)listIterator1).next();
            if(((MixUpUIItemData)object2) instanceof Ud.a && ((Ud.a)(((MixUpUIItemData)object2))).isMarquee()) {
                arrayList2.add(object2);
            }
        }
        ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
        for(Object object3: arrayList2) {
            arrayList3.add(((MixUpUIItemData)object3).getId());
        }
        HashSet hashSet1 = je.p.N0(arrayList3);
        Iterable iterable0 = mixUpPlaylistComposeViewModel$MixUpRawUiData0.getUiList();
        ArrayList arrayList4 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object4: iterable0) {
            MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)object4;
            if(mixUpUIItemData0 instanceof PlayableItem) {
                String s = ((PlayableItem)mixUpUIItemData0).getId();
                mixUpUIItemData0 = PlayableItem.copy$default(((PlayableItem)mixUpUIItemData0), null, hashSet0.contains(s), hashSet1.contains(s), false, false, false, 57, null);
            }
            arrayList4.add(mixUpUIItemData0);
        }
        p0.clear();
        p0.addAll(arrayList4);
        mixUpPlaylistComposeViewModel0.v = mixUpPlaylistComposeViewModel$MixUpRawUiData0.getCurrentIndex();
        mixUpPlaylistComposeViewModel0.u = mixUpPlaylistComposeViewModel$MixUpRawUiData0.getWaitingTitleIndex();
        LogConstantsKt.debug(mixUpPlaylistComposeViewModel0.n, "updateUiDataPreserve - size:" + p0.size(), v);
    }

    public final void addAll() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.addAll.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.addAll.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        object0 = mixUpPlaylistComposeViewModel0.b(this);
                        if(object0 == a0) {
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
                ArrayList arrayList0 = b.B(((Z)(((pc.d)object0))).m());
                mixUpPlaylistComposeViewModel0.sendUiEvent(new m3(mixUpPlaylistComposeViewModel0.getMenuId(), "", arrayList0));
                return H.a;
            }
        }, 3, null);
    }

    public final Object b(Continuation continuation0) {
        MixUpPlaylistComposeViewModel.getMixUpPlaylist.1 mixUpPlaylistComposeViewModel$getMixUpPlaylist$10;
        if(continuation0 instanceof MixUpPlaylistComposeViewModel.getMixUpPlaylist.1) {
            mixUpPlaylistComposeViewModel$getMixUpPlaylist$10 = (MixUpPlaylistComposeViewModel.getMixUpPlaylist.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.D;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$getMixUpPlaylist$10 = new MixUpPlaylistComposeViewModel.getMixUpPlaylist.1(this, continuation0);
            }
            else {
                mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.D = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$getMixUpPlaylist$10 = new MixUpPlaylistComposeViewModel.getMixUpPlaylist.1(this, continuation0);
        }
        Object object0 = mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.w;
        ne.a a0 = ne.a.a;
        switch(mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.D) {
            case 0: {
                d5.n.D(object0);
                if(this.q == null) {
                    B b0 = ((d3)this.c).n();
                    mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.r = this;
                    mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.D = 1;
                    object0 = ListenableFutureKt.await(b0, mixUpPlaylistComposeViewModel$getMixUpPlaylist$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    this.q = (pc.d)object0;
                }
                break;
            }
            case 1: {
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = mixUpPlaylistComposeViewModel$getMixUpPlaylist$10.r;
                d5.n.D(object0);
                mixUpPlaylistComposeViewModel0.q = (pc.d)object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        pc.d d0 = this.q;
        q.d(d0);
        return d0;
    }

    public final od.b c() {
        return (od.b)this.B.getValue();
    }

    public final void clearTiaraPropertyAndPerformPvDummyLogging(@NotNull String s) {
        q.g(s, "pvAction");
        this.setTiaraProperty(null);
        n0.performPvDummyLogging$default(this, s, null, 2, null);
    }

    public final MixUpRawUiData d(z0 z00, boolean z, boolean z1) {
        je.w w0;
        long v = System.currentTimeMillis();
        int v1 = z00.b;
        int v2 = z00.d;
        if(b.B(z00).isEmpty()) {
            w0 = je.w.a;
        }
        else {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, z00.a));
            int v3 = 0;
            for(Object object0: z00.a) {
                if(v3 >= 0) {
                    arrayList0.add(new PlayableItem(((PlayableData)object0), false, false, v3 == v1, z1, z));
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
            w0 = je.p.Q0(arrayList0);
            int v4 = v2 <= ((ArrayList)w0).size() ? v2 : ((ArrayList)w0).size();
            if(v4 != ((ArrayList)w0).size()) {
                ((ArrayList)w0).add(v4, () -> "WaitingTitle");
            }
        }
        MixUpRawUiData mixUpPlaylistComposeViewModel$MixUpRawUiData0 = new MixUpRawUiData(w0, v1, v2);
        LogConstantsKt.debug(this.n, "makeRawUiData - size:" + w0.size(), v);
        return mixUpPlaylistComposeViewModel$MixUpRawUiData0;
    }

    public final void deletePlayable(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(playable0, null) {
            public final Playable B;
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                this.B = playable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.deletePlayable.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.deletePlayable.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                ne.a a0 = ne.a.a;
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        object1 = mixUpPlaylistComposeViewModel0.getIsDjMalrang(this);
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
                mixUpPlaylistComposeViewModel0.g.handleUserEvent(new DeletePlaylistByPlayables(mixUpPlaylistComposeViewModel0.getPlaylistId(), e.k.z(this.B), true, true, null, new o(mixUpPlaylistComposeViewModel0, ((Boolean)object1).booleanValue(), 0), 16, null), f0.h(mixUpPlaylistComposeViewModel0), new we.k(0, MixUpPlaylistComposeViewModel.class, mixUpPlaylistComposeViewModel0, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((I4)object0));
                        return H.a;
                    }

                    public final void invoke(I4 i40) {
                        q.g(i40, "p0");
                        ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                    }
                });
                return H.a;
            }
        }, 3, null);
    }

    public final void deleteSelected() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.deleteSelected.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.deleteSelected.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                ne.a a0 = ne.a.a;
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        object1 = mixUpPlaylistComposeViewModel0.getIsDjMalrang(this);
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
                mixUpPlaylistComposeViewModel0.g.handleUserEvent(new DeletePlaylistByPlayables(mixUpPlaylistComposeViewModel0.getPlaylistId(), mixUpPlaylistComposeViewModel0.getSelectedPlayableList(), true, true, null, new o(mixUpPlaylistComposeViewModel0, ((Boolean)object1).booleanValue(), 1), 16, null), f0.h(mixUpPlaylistComposeViewModel0), new we.k(0, MixUpPlaylistComposeViewModel.class, mixUpPlaylistComposeViewModel0, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.invoke(((I4)object0));
                        return H.a;
                    }

                    public final void invoke(I4 i40) {
                        q.g(i40, "p0");
                        ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                    }
                });
                return H.a;
            }
        }, 3, null);
    }

    public final void e(int v, int v1, List list0) {
        this.t.clear();
        this.t.addAll(list0);
        this.v = v;
        this.u = v1;
    }

    @NotNull
    public final SharedFlow getCurrentFocusPlayableFlow() {
        return this.x;
    }

    public final int getCurrentIndex() {
        return this.v;
    }

    @Nullable
    public final Playable getCurrentPlayable() {
        MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)je.p.n0(this.v, this.t);
        return mixUpUIItemData0 == null || !(mixUpUIItemData0 instanceof PlayableItem) ? null : ((PlayableItem)mixUpUIItemData0).getPlayableData().a;
    }

    @NotNull
    public final StateFlow getHasToolbarPadding() {
        return this.z;
    }

    @Nullable
    public final Object getIsDjMalrang(@NotNull Continuation continuation0) {
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getIsDjMalrang.1 mixUpPlaylistComposeViewModel$getIsDjMalrang$10;
        if(continuation0 instanceof com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getIsDjMalrang.1) {
            mixUpPlaylistComposeViewModel$getIsDjMalrang$10 = (com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.getIsDjMalrang.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$getIsDjMalrang$10.B;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$getIsDjMalrang$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.getIsDjMalrang(this);
                    }
                };
            }
            else {
                mixUpPlaylistComposeViewModel$getIsDjMalrang$10.B = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$getIsDjMalrang$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.getIsDjMalrang(this);
                }
            };
        }
        Object object0 = mixUpPlaylistComposeViewModel$getIsDjMalrang$10.r;
        ne.a a0 = ne.a.a;
        switch(mixUpPlaylistComposeViewModel$getIsDjMalrang$10.B) {
            case 0: {
                d5.n.D(object0);
                mixUpPlaylistComposeViewModel$getIsDjMalrang$10.B = 1;
                object0 = this.b(mixUpPlaylistComposeViewModel$getIsDjMalrang$10);
                if(object0 == a0) {
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
        pc.c c0 = ((Z)(((pc.d)object0))).m().c;
        return c0 == null ? false : Boolean.valueOf(c0 instanceof DjMalrangInfo);
    }

    @Nullable
    public final od.a getMixUpAreaOrNull(int v) {
        pc.d d0 = this.q;
        if(d0 != null) {
            z0 z00 = ((Z)d0).m();
            if(z00 != null) {
                return v >= z00.d ? od.a.b : od.a.a;
            }
        }
        return null;
    }

    @NotNull
    public final StateFlow getMixUpInfoStateFlow() {
        return this.r;
    }

    @NotNull
    public final PlaylistId getPlaylistId() {
        return this.p;
    }

    @NotNull
    public final List getSelectedPlayableList() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.t) {
            if(object0 instanceof PlayableItem) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            if(((PlayableItem)object1).isSelected()) {
                arrayList1.add(object1);
            }
        }
        List list0 = new ArrayList(je.q.Q(10, arrayList1));
        for(Object object2: arrayList1) {
            list0.add(((PlayableItem)object2).getPlayableData().a);
        }
        return list0;
    }

    @NotNull
    public final MixUpPlaylistTiaraLogHelper getTiaraLogHelper() {
        return (MixUpPlaylistTiaraLogHelper)this.C.getValue();
    }

    @NotNull
    public final p getUiList() {
        return this.t;
    }

    @NotNull
    public final MixUpPlaylistViewImpLogHelper getViewImpLogHelper() {
        return (MixUpPlaylistViewImpLogHelper)this.D.getValue();
    }

    @NotNull
    public final StateFlow isCurrentPlaylistStateFlow() {
        return this.s;
    }

    public final boolean isDj() {
        return ((e0)this.h).j().getIsDj();
    }

    public final boolean isLoginUser() {
        return ((e0)va.o.a()).m();
    }

    public final boolean isSelectedAny() {
        p p0 = this.t;
        if(p0 != null && p0.isEmpty()) {
            return false;
        }
        for(Object object0: p0) {
            if(((MixUpUIItemData)object0) instanceof h && ((h)(((MixUpUIItemData)object0))).isSelected()) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void moveFromDragEnd(int v, int v1) {
        MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)je.p.n0(v1, this.t);
        od.a a0 = this.getMixUpAreaOrNull(v);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(v, v1, m.s(v), (mixUpUIItemData0 instanceof PlayableItem ? ((PlayableItem)mixUpUIItemData0).getPlayableData().a : null), a0, null) {
            public final int B;
            public final int D;
            public final String E;
            public final Playable G;
            public final od.a I;
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                this.B = v;
                this.D = v1;
                this.E = s;
                this.G = playable0;
                this.I = a0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.moveFromDragEnd.1(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.moveFromDragEnd.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                int v = this.B;
                int v1 = this.D;
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        d3 d30 = (d3)mixUpPlaylistComposeViewModel0.c;
                        Q2 q20 = new Q2(d30, v, v1, null);
                        B b0 = ListenableFutureKt.future$default(d30.b, null, null, q20, 3, null);
                        this.r = 1;
                        object0 = ListenableFutureKt.await(b0, this);
                        if(object0 == a0) {
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
                if(((v)object0) instanceof t) {
                    PlaylistUiExtensionsKt.move(mixUpPlaylistComposeViewModel0.getUiList(), v1, v);
                }
                od.a a1 = mixUpPlaylistComposeViewModel0.getMixUpAreaOrNull(v1);
                mixUpPlaylistComposeViewModel0.getTiaraLogHelper().logMoveSongOrder(this.E, m.s(v1), this.G, this.I, a1);
                return H.a;
            }
        }, 3, null);
    }

    public final void moveFromDragging(int v, int v1) {
        PlaylistUiExtensionsKt.move(this.t, v, v1);
    }

    @Override  // com.melon.ui.n0
    public void onUserEvent(@NotNull e e0) {
        Uri uri0 = null;
        q.g(e0, "userEvent");
        if(e0 instanceof ClickSongItem) {
            if(this.isSelectedAny()) {
                this.updateSelectedIndex(((ClickSongItem)e0).getPosition());
                return;
            }
            this.play(((ClickSongItem)e0).getPosition(), ((ClickSongItem)e0).getPlayable());
            return;
        }
        if(e0 instanceof ClickAlbumThumbnail) {
            if(this.isSelectedAny()) {
                this.updateSelectedIndex(((ClickAlbumThumbnail)e0).getPosition());
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(e0, null) {
                public final e B;
                public int r;
                public final MixUpPlaylistComposeViewModel w;

                {
                    this.w = mixUpPlaylistComposeViewModel0;
                    this.B = e0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.1(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            Playable playable0 = ((ClickAlbumThumbnail)this.B).getPlayable();
                            L0 l00 = this.w.getProgressUpdater();
                            this.r = 1;
                            this.w.e.getClass();
                            return a.a(playable0, l00, this) == a0 ? a0 : H.a;
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
            return;
        }
        s4 s40 = s4.a;
        k k0 = this.h;
        if(e0 instanceof ClickOtherRecommend) {
            if(((e0)k0).m()) {
                Object object0 = this.r.getValue();
                DjMalrangInfo djMalrangInfo0 = object0 instanceof DjMalrangInfo ? ((DjMalrangInfo)object0) : null;
                if(djMalrangInfo0 == null) {
                    LogU.error$default(this.n, "ClickOtherRecommend - currentDjMalrangInfo is null", null, false, 6, null);
                }
                else {
                    w w0 = ((d3)this.c).k();
                    if((w0 == null ? null : w0.getId()) != PlaylistId.MIX_UP && w0 != null) {
                        oc.Q q0 = w0.getState();
                        if(q0 != null) {
                            PlayableData playableData0 = b.z(q0);
                            if(playableData0 != null) {
                                uri0 = playableData0.n;
                            }
                        }
                    }
                    this.sendUiEvent(new OpenOtherRecommendDialog(djMalrangInfo0, uri0));
                }
            }
            else {
                this.sendUiEvent(s40);
            }
            this.getTiaraLogHelper().logClickOpenOtherRecommendDjMalrang();
            return;
        }
        if(e0 instanceof PlayOtherRecommendInDjMalrang) {
            if(((e0)k0).m()) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
                    public int r;
                    public final MixUpPlaylistComposeViewModel w;

                    {
                        this.w = mixUpPlaylistComposeViewModel0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.2(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        boolean z;
                        ne.a a0 = ne.a.a;
                        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                object0 = ((db.g)mixUpPlaylistComposeViewModel0.l).c(this);
                                if(object0 == a0) {
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
                        AuthLocationRes authLocationRes0 = (AuthLocationRes)E9.h.H(((f)object0));
                        if(authLocationRes0 == null) {
                            z = false;
                        }
                        else {
                            Response authLocationRes$Response0 = authLocationRes0.response;
                            z = authLocationRes$Response0 == null ? false : authLocationRes$Response0.isAgree;
                        }
                        mixUpPlaylistComposeViewModel0.sendUiEvent(new N0(z, true, mixUpPlaylistComposeViewModel0.getMenuId(), new com.iloen.melon.player.playlist.mixup.f(mixUpPlaylistComposeViewModel0)));
                        return H.a;
                    }
                }, 3, null);
            }
            else {
                this.sendUiEvent(s40);
            }
            this.getTiaraLogHelper().logClickPlayOtherRecommendDjMalrang();
            return;
        }
        if(e0 instanceof Jd.g) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new MixUpPlaylistComposeViewModel.handleToolBarEvent.1(((Jd.g)e0), this, null), 3, null);
            return;
        }
        if(e0 instanceof q3) {
            T2.a a0 = f0.h(this);
            boolean z = this.isLoginUser();
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.3 mixUpPlaylistComposeViewModel$onUserEvent$30 = new we.k(0, MixUpPlaylistComposeViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l00 = this.getProgressUpdater();
            this.i.a(((q3)e0), a0, z, mixUpPlaylistComposeViewModel$onUserEvent$30, l00);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a1 = f0.h(this);
            boolean z1 = this.isLoginUser();
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.4 mixUpPlaylistComposeViewModel$onUserEvent$40 = new we.k(0, MixUpPlaylistComposeViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l01 = this.getProgressUpdater();
            this.j.b(((L2)e0), a1, z1, mixUpPlaylistComposeViewModel$onUserEvent$40, l01);
            return;
        }
        if(e0 instanceof Ed.a) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new n(e0, null) {
                public final e B;
                public int r;
                public final MixUpPlaylistComposeViewModel w;

                {
                    this.w = mixUpPlaylistComposeViewModel0;
                    this.B = e0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.5(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return this.w.f.a(((Ed.a)this.B).a, ((Ed.a)this.B).b, this) == a0 ? a0 : H.a;
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
            }, 2, null);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a2 = f0.h(this);
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.6 mixUpPlaylistComposeViewModel$onUserEvent$60 = new we.k(0, MixUpPlaylistComposeViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.k.d(((com.melon.ui.q)e0), a2, mixUpPlaylistComposeViewModel$onUserEvent$60);
            return;
        }
        if(e0 instanceof DeletePlaylist) {
            T2.a a3 = f0.h(this);
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.onUserEvent.7 mixUpPlaylistComposeViewModel$onUserEvent$70 = new we.k(0, MixUpPlaylistComposeViewModel.class, this, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((MixUpPlaylistComposeViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            this.g.handleUserEvent(((DeletePlaylist)e0), a3, mixUpPlaylistComposeViewModel$onUserEvent$70);
            return;
        }
        super.onUserEvent(e0);
    }

    public final void play(@Nullable Integer integer0, @Nullable Playable playable0) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(integer0, playable0, null) {
            public final Integer B;
            public final Playable D;
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                this.B = integer0;
                this.D = playable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.play.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.play.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return MixUpPlaylistComposeViewModel.access$playInternal(this.w, this.B, this.D, this) == a0 ? a0 : H.a;
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

    public final void playPopularPlaylist() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public int r;
            public final MixUpPlaylistComposeViewModel w;

            {
                this.w = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.playPopularPlaylist.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.playPopularPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return MixUpPlaylistComposeViewModel.access$playPopularPlaylistInternal(this.w, this) == a0 ? a0 : H.a;
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

    public final void releaseSelectedAll() {
        List list0 = this.A.a(this.t, false);
        this.e(this.v, this.u, list0);
    }

    public final void selectAllWaitingList() {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(null) {
            public final MixUpPlaylistComposeViewModel B;
            public ArrayList r;
            public int w;

            {
                this.B = mixUpPlaylistComposeViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.selectAllWaitingList.1(this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.selectAllWaitingList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ArrayList arrayList1;
                ne.a a0 = ne.a.a;
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.B;
                switch(this.w) {
                    case 0: {
                        ArrayList arrayList0 = H0.b.m(object0);
                        this.r = arrayList0;
                        this.w = 1;
                        Object object1 = mixUpPlaylistComposeViewModel0.b(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        arrayList1 = arrayList0;
                        object0 = object1;
                        break;
                    }
                    case 1: {
                        arrayList1 = this.r;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                z0 z00 = (z0)((Z)(((pc.d)object0))).f.getValue();
                ArrayList arrayList2 = b.B(z00);
                Iterable iterable0 = je.p.K0(z00.d, arrayList2);
                ArrayList arrayList3 = new ArrayList(je.q.Q(10, iterable0));
                Iterator iterator0 = iterable0.iterator();
                while(iterator0.hasNext()) {
                    iterator0.next();
                    arrayList3.add("");
                }
                HashSet hashSet0 = je.p.N0(arrayList3);
                ListIterator listIterator0 = mixUpPlaylistComposeViewModel0.getUiList().listIterator();
                while(((P0.r)listIterator0).hasNext()) {
                    MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)((P0.r)listIterator0).next();
                    if(mixUpUIItemData0 instanceof PlayableItem && !hashSet0.contains(((PlayableItem)mixUpUIItemData0).getPlayableData().b)) {
                        arrayList1.add(mixUpUIItemData0);
                    }
                }
                List list0 = mixUpPlaylistComposeViewModel0.A.a(mixUpPlaylistComposeViewModel0.getUiList(), false);
                for(Object object2: arrayList1) {
                    list0 = mixUpPlaylistComposeViewModel0.A.b(list0, ((MixUpUIItemData)object2));
                }
                MixUpPlaylistComposeViewModel.access$updateUiData(mixUpPlaylistComposeViewModel0, list0, mixUpPlaylistComposeViewModel0.v, mixUpPlaylistComposeViewModel0.u);
                return H.a;
            }
        }, 3, null);
    }

    public final void toggleSelectAll() {
        if(this.isSelectedAny()) {
            this.releaseSelectedAll();
            return;
        }
        List list0 = this.A.a(this.t, true);
        this.e(this.v, this.u, list0);
    }

    @Nullable
    public final Object updateCurrentFocus(@NotNull Continuation continuation0) {
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.updateCurrentFocus.1 mixUpPlaylistComposeViewModel$updateCurrentFocus$10;
        if(continuation0 instanceof com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.updateCurrentFocus.1) {
            mixUpPlaylistComposeViewModel$updateCurrentFocus$10 = (com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel.updateCurrentFocus.1)continuation0;
            int v = mixUpPlaylistComposeViewModel$updateCurrentFocus$10.B;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeViewModel$updateCurrentFocus$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateCurrentFocus(this);
                    }
                };
            }
            else {
                mixUpPlaylistComposeViewModel$updateCurrentFocus$10.B = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeViewModel$updateCurrentFocus$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateCurrentFocus(this);
                }
            };
        }
        Object object0 = mixUpPlaylistComposeViewModel$updateCurrentFocus$10.r;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(mixUpPlaylistComposeViewModel$updateCurrentFocus$10.B) {
            case 0: {
                d5.n.D(object0);
                mixUpPlaylistComposeViewModel$updateCurrentFocus$10.B = 1;
                object0 = this.b(mixUpPlaylistComposeViewModel$updateCurrentFocus$10);
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
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Playable playable0 = e.k.p(((oc.H)object0));
        mixUpPlaylistComposeViewModel$updateCurrentFocus$10.B = 2;
        H h1 = this.w.emit(playable0, mixUpPlaylistComposeViewModel$updateCurrentFocus$10);
        if(h1 != a0) {
            h1 = h0;
        }
        return h1 == a0 ? a0 : h0;
    }

    public final void updateHasToolbarPadding(boolean z) {
        this.y.setValue(Boolean.valueOf(z));
    }

    public final void updateSelectedIndex(int v) {
        K4 k40 = (K4)this.t.get(v);
        List list0 = this.A.b(this.t, k40);
        this.e(this.v, this.u, list0);
    }
}

