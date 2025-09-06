package com.iloen.melon.player.playlist.mixup;

import Bc.h;
import Cc.N1;
import Cc.a3;
import Cc.c1;
import Cc.e0;
import Cc.o1;
import Cc.x2;
import Dc.u;
import H8.i;
import J8.D2;
import M.p0;
import M.y;
import N0.M;
import O.F;
import P0.j;
import Q0.k0;
import R6.c;
import R6.d;
import U4.x;
import Zc.N;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.E;
import androidx.compose.runtime.G;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.l0;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddResult.Success;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.PlaylistTab;
import com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEvent;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEventHelper;
import com.iloen.melon.player.playlist.common.PlaylistUiExtensionsKt;
import com.iloen.melon.player.playlist.common.scrollbar.AppScrollbarsKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarExtKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarState;
import com.iloen.melon.player.playlist.common.scrollbar.ThumbExtKt;
import com.iloen.melon.player.playlist.mixup.composables.MixUpSongListKt;
import com.iloen.melon.player.playlist.mixup.composables.SongListClickListener;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistViewImpLogHelper;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.L0;
import com.melon.ui.M2;
import com.melon.ui.O0;
import com.melon.ui.a;
import com.melon.ui.common.composable.PlayBgColorData;
import com.melon.ui.e;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.x4;
import d3.g;
import e1.m;
import h7.u0;
import ie.H;
import ie.r;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;
import we.o;
import zd.Q;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u0092\u00012\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0092\u0001B\u0007\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b \u0010\tJ\u000F\u0010!\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b!\u0010\tJ\u000F\u0010\"\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\"\u0010\tJ\u0017\u0010%\u001A\u00020\u00102\u0006\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b)\u0010(J\u000F\u0010*\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b*\u0010(J\u000F\u0010+\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b+\u0010(J\u000F\u0010,\u001A\u00020\u0010H\u0007\u00A2\u0006\u0004\b,\u0010(J\\\u00108\u001A\u00020\u00102\u0006\u0010$\u001A\u00020-2\u0006\u0010/\u001A\u00020.2\u000E\u00101\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0010022\u0006\u00106\u001A\u0002052\u000E\u00107\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u000100H\u0096\u0001\u00A2\u0006\u0004\b8\u00109Jb\u0010@\u001A\u00020\u00102\u0006\u0010/\u001A\u00020.2\u0006\u0010;\u001A\u00020:2\f\u0010>\u001A\b\u0012\u0004\u0012\u00020=0<2\u000E\u00101\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0010022\u0006\u00106\u001A\u0002052\u0006\u0010?\u001A\u00020:H\u0096\u0001\u00A2\u0006\u0004\b@\u0010AJF\u0010E\u001A\u00020\u00102\u0006\u0010$\u001A\u00020B2\u0006\u0010/\u001A\u00020.2$\u0010D\u001A \u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0010\u0018\u00010CH\u0096\u0001\u00A2\u0006\u0004\bE\u0010FJ6\u0010K\u001A\u00020\u00102\u0006\u0010/\u001A\u00020.2\u0006\u0010H\u001A\u00020G2\u0014\u0010J\u001A\u0010\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u0010\u0018\u000102H\u0096\u0001\u00A2\u0006\u0004\bK\u0010LJ>\u0010N\u001A\u00020\u00102\u0006\u0010M\u001A\u00020=2\u0006\u0010/\u001A\u00020.2\b\u0010;\u001A\u0004\u0018\u00010:2\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001002H\u0096\u0001\u00A2\u0006\u0004\bN\u0010OJ>\u0010P\u001A\u00020\u00102\u0006\u0010/\u001A\u00020.2\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0010022\b\u0010H\u001A\u0004\u0018\u00010G2\u0006\u0010$\u001A\u00020IH\u0096\u0001\u00A2\u0006\u0004\bP\u0010QJ8\u0010V\u001A\u00020\u00102\b\u0010S\u001A\u0004\u0018\u00010R2\b\u0010;\u001A\u0004\u0018\u00010:2\u0012\u0010U\u001A\u000E\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020T02H\u0096\u0001\u00A2\u0006\u0004\bV\u0010WJF\u0010]\u001A\u00020\u00102\u0006\u0010Y\u001A\u00020X2\u0006\u0010$\u001A\u00020Z2\b\u0010S\u001A\u0004\u0018\u00010R2\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0010022\u0006\u0010\\\u001A\u00020[H\u0096\u0001\u00A2\u0006\u0004\b]\u0010^JF\u0010b\u001A\u00020\u00102\u0006\u0010Y\u001A\u00020X2\u0006\u0010$\u001A\u00020_2\b\u0010a\u001A\u0004\u0018\u00010`2\u0012\u00104\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0010022\u0006\u0010\\\u001A\u00020[H\u0096\u0001\u00A2\u0006\u0004\bb\u0010cR\"\u0010e\u001A\u00020d8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\be\u0010f\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001A\u00020k8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bl\u0010m\u001A\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001A\u00020r8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bs\u0010t\u001A\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001A\u00020y8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bz\u0010{\u001A\u0004\b|\u0010}\"\u0004\b~\u0010\u007FR*\u0010\u0081\u0001\u001A\u00030\u0080\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u008E\u0001\u001A\u00030\u0087\u00018\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001\"\u0006\b\u008C\u0001\u0010\u008D\u0001R\u001F\u0010\u008F\u0001\u001A\u0002058\u0016X\u0096D\u00A2\u0006\u0010\n\u0006\b\u008F\u0001\u0010\u0090\u0001\u001A\u0006\b\u008F\u0001\u0010\u0091\u0001\u00A8\u0006\u0094\u0001\u00B2\u0006\r\u0010\u0093\u0001\u001A\u0002058\nX\u008A\u0084\u0002"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment;", "Lcom/melon/ui/J0;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeViewModel;", "LJ8/D2;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "Lcom/melon/ui/L0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/D2;", "Lcom/melon/ui/K4;", "uiState", "Lie/H;", "renderUi", "(Lcom/melon/ui/K4;)V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onStop", "onDestroyView", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "SourceTitle", "(Landroidx/compose/runtime/l;I)V", "SelectableFilter", "MixUpPlaylistList", "WaitingTitle", "MixUpTabEmptyViewLayout", "Lcom/melon/ui/o3;", "Landroidx/fragment/app/I;", "fragment", "Lkotlin/Function0;", "afterAction", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "", "isNowPlayingList", "afterDismissAction", "handlePutPopupUiEvent", "(Lcom/melon/ui/o3;Landroidx/fragment/app/I;Lwe/a;Lwe/k;ZLwe/a;)V", "", "menuId", "", "Lcom/iloen/melon/playback/Playable;", "playableList", "ocrGroupId", "showContextMenuAddTo", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/util/List;Lwe/a;Lwe/k;ZLjava/lang/String;)V", "Lcom/melon/ui/m2;", "Lkotlin/Function3;", "artistClickLogAction", "handleMorePopupUiEvent", "(Lcom/melon/ui/m2;Landroidx/fragment/app/I;Lwe/o;)V", "Lzd/Q;", "popupType", "Lcom/melon/ui/k2;", "onEvent", "showContextMorePopup", "(Landroidx/fragment/app/I;Lzd/Q;Lwe/k;)V", "playable", "showContextPopupSongType", "(Lcom/iloen/melon/playback/Playable;Landroidx/fragment/app/I;Ljava/lang/String;Lwe/k;)V", "handleMoreListPopupOnEvent", "(Landroidx/fragment/app/I;Lwe/k;Lzd/Q;Lcom/melon/ui/k2;)V", "Landroid/content/Context;", "context", "Lp8/f;", "action", "getTiaraEventBuilder", "(Landroid/content/Context;Ljava/lang/String;Lwe/k;)V", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/melon/ui/b;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "handleAddPlayUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/b;Landroid/content/Context;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "Lcom/melon/ui/O0;", "Landroid/app/Activity;", "activity", "handleDjMalrangUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/O0;Landroid/app/Activity;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "LPc/d;", "stringProvider", "LPc/d;", "getStringProvider", "()LPc/d;", "setStringProvider", "(LPc/d;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Ldb/c;", "locationUseCase", "Ldb/c;", "getLocationUseCase", "()Ldb/c;", "setLocationUseCase", "(Ldb/c;)V", "LCc/x2;", "playBgColorExtractor", "LCc/x2;", "getPlayBgColorExtractor", "()LCc/x2;", "setPlayBgColorExtractor", "(LCc/x2;)V", "Lcom/iloen/melon/custom/f1;", "k", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "isShowTabAndMiniPlayer", "Z", "()Z", "Companion", "isEmptyView", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistComposeFragment extends Hilt_MixUpPlaylistComposeFragment implements L0, M2, a, k3 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment$Companion;", "", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment;", "newInstance", "()Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment;", "", "TAG", "Ljava/lang/String;", "RECOMMEND_POPUP_TAG", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MixUpPlaylistComposeFragment newInstance() {
            return new MixUpPlaylistComposeFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MixUpPlaylistComposeFragment";
    public final p3 d;
    public final d e;
    public final e f;
    public final c g;
    public final r h;
    public D2 i;
    public final LogU j;
    public f1 k;
    public ToolBar l;
    @Inject
    public db.c locationUseCase;
    public final i m;
    public final r n;
    public final r o;
    @Inject
    public x2 playBgColorExtractor;
    @Inject
    public h playerUiHelper;
    @Inject
    public z playerUseCase;
    public String r;
    @Inject
    public Pc.d stringProvider;

    static {
        MixUpPlaylistComposeFragment.Companion = new Companion(null);
        MixUpPlaylistComposeFragment.$stable = 8;
    }

    public MixUpPlaylistComposeFragment() {
        this.d = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new d(25);
        this.f = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = new c(25);
        this.h = g.Q(new com.iloen.melon.fragments.mymusic.dna.d(17));
        this.j = LogU.Companion.create("MixUpPlaylistComposeFragment", true, Category.UI);
        this.k = f1.b;
        De.d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.special..inlined.activityViewModels.default.1 mixUpPlaylistComposeFragment$special$$inlined$activityViewModels$default$10 = new we.a() {
            public final androidx.fragment.app.I f;

            {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return this.f.requireActivity().getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.special..inlined.activityViewModels.default.2 mixUpPlaylistComposeFragment$special$$inlined$activityViewModels$default$20 = new we.a(this) {
            public final we.a f;
            public final androidx.fragment.app.I g;

            {
                this.f = a0;
                this.g = i0;
                super(0);
            }

            @NotNull
            public final S2.c invoke() {
                we.a a0 = this.f;
                if(a0 != null) {
                    S2.c c0 = (S2.c)a0.invoke();
                    return c0 == null ? this.g.requireActivity().getDefaultViewModelCreationExtras() : c0;
                }
                return this.g.requireActivity().getDefaultViewModelCreationExtras();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.m = new i(d0, mixUpPlaylistComposeFragment$special$$inlined$activityViewModels$default$10, new we.a() {
            public final androidx.fragment.app.I f;

            {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                return this.f.requireActivity().getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, mixUpPlaylistComposeFragment$special$$inlined$activityViewModels$default$20);
        this.n = g.Q(new com.iloen.melon.player.playlist.mixup.g(this, 0));
        this.o = g.Q(new com.iloen.melon.player.playlist.mixup.g(this, 1));
    }

    public final void MixUpPlaylistList(@Nullable l l0, int v) {
        p p2;
        a3 a30;
        V v6;
        F f1;
        Dc.g g1;
        ((p)l0).c0(0x7975F8C6);
        int v1 = (v & 6) == 0 ? v | (((p)l0).i(this) ? 4 : 2) : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            F0.a a0 = (F0.a)((p)l0).k(k0.l);
            p0.p p0 = ((MixUpPlaylistComposeViewModel)this.getViewModel()).getUiList();
            F f0 = O.I.a(0, 0, 3, ((p)l0));
            boolean z = ((p)l0).i(a0);
            boolean z1 = ((p)l0).i(this);
            N n0 = ((p)l0).N();
            V v2 = k.a;
            if(z || z1 || n0 == v2) {
                n0 = new N(20, a0, this);
                ((p)l0).l0(n0);
            }
            boolean z2 = ((p)l0).i(this);
            com.iloen.melon.player.playlist.mixup.e e0 = ((p)l0).N();
            if(z2 || e0 == v2) {
                e0 = new com.iloen.melon.player.playlist.mixup.e(this, 1);
                ((p)l0).l0(e0);
            }
            boolean z3 = ((p)l0).i(this);
            com.iloen.melon.player.playlist.mixup.e e1 = ((p)l0).N();
            if(z3 || e1 == v2) {
                e1 = new com.iloen.melon.player.playlist.mixup.e(this, 2);
                ((p)l0).l0(e1);
            }
            u u0 = u0.P(f0, n0, e0, e1, ((p)l0), 0);
            ScrollbarState scrollbarState0 = ScrollbarExtKt.scrollbarState(f0, p0.size(), null, ((p)l0), 0, 2);
            p p1 = (p)l0;
            MixUpPlaylistComposeFragment.getClickListener.1 mixUpPlaylistComposeFragment$getClickListener$10 = new MixUpPlaylistComposeFragment.getClickListener.1(f0, this);
            E e2 = p1.N();
            if(e2 == v2) {
                e2 = w.i(new N(21, f0, this));
                p1.l0(e2);
            }
            CoroutineScope coroutineScope0 = p1.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p1);
                p1.l0(coroutineScope0);
            }
            b0 b00 = p1.N();
            if(b00 == v2) {
                b00 = w.s(Boolean.FALSE);
                p1.l0(b00);
            }
            I0.a a1 = PlaylistCommonSongListComposableKt.topButtonManagingNestedScrollConnection(f0, b00, 0L, p1, 0x30, 4);
            Dc.g g0 = PlaylistCommonSongListComposableKt.getPlaylistCommonItemBgColor(p1, 0);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            r0.i i0 = r0.d.a;
            M m0 = M.p.d(i0, false);
            int v3 = p1.P;
            i0 i00 = p1.m();
            q q0 = r0.a.d(p1, fillElement0);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p1.e0();
            if(p1.O) {
                p1.l(i1);
            }
            else {
                p1.o0();
            }
            P0.h h0 = j.f;
            w.x(p1, m0, h0);
            P0.h h1 = j.e;
            w.x(p1, i00, h1);
            P0.h h2 = j.g;
            if(p1.O) {
                g1 = g0;
                A7.d.q(v3, p1, v3, h2);
            }
            else {
                g1 = g0;
                if(!kotlin.jvm.internal.q.b(p1.N(), v3)) {
                    A7.d.q(v3, p1, v3, h2);
                }
            }
            P0.h h3 = j.d;
            w.x(p1, q0, h3);
            y y0 = M.w.a(M.j.c, r0.d.m, p1, 0);
            int v4 = p1.P;
            i0 i01 = p1.m();
            q q1 = r0.a.d(p1, fillElement0);
            p1.e0();
            if(p1.O) {
                p1.l(i1);
            }
            else {
                p1.o0();
            }
            w.x(p1, y0, h0);
            w.x(p1, i01, h1);
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v4)) {
                A7.d.q(v4, p1, v4, h2);
            }
            w.x(p1, q1, h3);
            b0 b01 = B.a.r(((MixUpPlaylistComposeViewModel)this.getViewModel()).getHasToolbarPadding(), p1, 0);
            n n1 = n.a;
            q q2 = x.r(1.0f, androidx.compose.foundation.layout.d.f(n1, 1.0f), true);
            M m1 = M.p.d(i0, false);
            int v5 = p1.P;
            i0 i02 = p1.m();
            q q3 = r0.a.d(p1, q2);
            p1.e0();
            if(p1.O) {
                p1.l(i1);
            }
            else {
                p1.o0();
            }
            w.x(p1, m1, h0);
            w.x(p1, i02, h1);
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v5)) {
                A7.d.q(v5, p1, v5, h2);
            }
            w.x(p1, q3, h3);
            q q4 = androidx.compose.ui.input.nestedscroll.a.a(fillElement0, a1, null);
            com.iloen.melon.player.playlist.mixup.h h4 = p1.N();
            if(h4 == v2) {
                h4 = new com.iloen.melon.player.playlist.mixup.h(e2, 0);
                p1.l0(h4);
            }
            q q5 = e0.R(q4, f0, 40.0f, true, false, h4, 0x20);
            M.i0 i03 = PlaylistCommonSongListComposableKt.getPlaylistCommonListContentPadding();
            boolean z4 = p1.g(p0);
            boolean z5 = p1.i(u0);
            boolean z6 = p1.g(g1);
            boolean z7 = p1.g(mixUpPlaylistComposeFragment$getClickListener$10);
            boolean z8 = p1.g(f0);
            boolean z9 = p1.i(this);
            Object object0 = p1.N();
            if((z4 | z5 | z6 | z7 | z8 | z9) == 0 && object0 != v2) {
                f1 = f0;
                v6 = v2;
                a30 = object0;
            }
            else {
                f1 = f0;
                v6 = v2;
                a30 = new a3(p0, u0, g1, this, mixUpPlaylistComposeFragment$getClickListener$10, f1);
                p1.l0(a30);
            }
            ye.a.i(q5, f1, i03, false, null, null, null, false, null, a30, p1, 0x180, 504);
            q q6 = androidx.compose.foundation.layout.d.c(n1, 1.0f);
            q q7 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q6, r0.d.f);
            p2 = p1;
            AppScrollbarsKt.DraggableScrollbar(f1, scrollbarState0, ThumbExtKt.rememberDraggableScroller(f1, p0.size(), p1, 0), q7, p2, 0, 0);
            p2.p(true);
            if(((Boolean)b01.getValue()).booleanValue()) {
                p2.a0(0x8F84B82B);
                M.c.d(p2, androidx.compose.foundation.layout.d.h(n1, E9.h.t(p2, 0x7F070464)));  // dimen:toolbar_height
            }
            else {
                p2.a0(0x8DDF5560);
            }
            p2.p(false);
            p2.p(true);
            com.iloen.melon.player.playlist.mixup.a a2 = p2.N();
            if(a2 == v6) {
                a2 = new com.iloen.melon.player.playlist.mixup.a(b00, 1);
                p2.l0(a2);
            }
            boolean z10 = p2.i(coroutineScope0);
            boolean z11 = p2.g(f1);
            boolean z12 = p2.i(this);
            com.iloen.melon.player.playlist.mixup.n n2 = p2.N();
            if((z10 | z11 | z12) != 0 || n2 == v6) {
                n2 = new com.iloen.melon.player.playlist.mixup.n(coroutineScope0, f1, this, 1);
                p2.l0(n2);
            }
            PlaylistCommonSongListComposableKt.PlaylistTopBtn(a2, n2, p2, 6);
            p2.p(true);
            D d0 = (D)p2.k(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean z13 = p2.i(this);
            boolean z14 = p2.i(coroutineScope0);
            boolean z15 = p2.g(f1);
            boolean z16 = p2.i(d0);
            com.iloen.melon.player.playlist.mixup.k k0 = p2.N();
            if((z13 | z14 | z15 | z16) != 0 || k0 == v6) {
                k0 = new com.iloen.melon.player.playlist.mixup.k(d0, this, coroutineScope0, f1);
                p2.l0(k0);
            }
            J.b(d0, k0, p2);
            boolean z17 = p2.i(this);
            boolean z18 = p2.g(f1);
            com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$3$10 = p2.N();
            if(z17 || z18 || mixUpPlaylistComposeFragment$MixUpPlaylistList$3$10 == v6) {
                mixUpPlaylistComposeFragment$MixUpPlaylistList$3$10 = new we.n(this, null) {
                    public final MixUpPlaylistComposeFragment B;
                    public final F D;
                    public int r;
                    public int w;

                    {
                        this.B = mixUpPlaylistComposeFragment0;
                        this.D = f0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1(this.D, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        int v;
                        ne.a a0 = ne.a.a;
                        F f0 = this.D;
                        H h0 = H.a;
                        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.B;
                        switch(this.w) {
                            case 0: {
                                d5.n.D(object0);
                                v = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getCurrentIndex();
                                if(v != -1) {
                                    this.r = v;
                                    this.w = 1;
                                    if(f0.j(v, 0, this) == a0) {
                                        return a0;
                                    }
                                    goto label_17;
                                }
                                break;
                            }
                            case 1: {
                                v = this.r;
                                d5.n.D(object0);
                            label_17:
                                SharedFlow sharedFlow0 = MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).getCurrentFocusPlayableFlow();
                                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$3$1$10 = new we.n(mixUpPlaylistComposeFragment0, null) {
                                    public final MixUpPlaylistComposeFragment B;
                                    public int r;
                                    public final F w;

                                    {
                                        this.w = f0;
                                        this.B = mixUpPlaylistComposeFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1.1(this.w, this.B, continuation0);
                                    }

                                    public final Object invoke(Playable playable0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.3.1.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((Playable)object0), ((Continuation)object1));
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        F f0 = this.w;
                                        H h0 = H.a;
                                        switch(this.r) {
                                            case 0: {
                                                d5.n.D(object0);
                                                if(!f0.h.b()) {
                                                    this.r = 1;
                                                    if(DelayKt.delay(500L, this) == a0) {
                                                        return a0;
                                                    }
                                                    goto label_13;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                            label_13:
                                                int v = MixUpPlaylistComposeFragment.access$getViewModel(this.B).getCurrentIndex();
                                                if(v != -1) {
                                                    this.r = 2;
                                                    if(f0.f(v, 0, this) == a0) {
                                                        return a0;
                                                    }
                                                }
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
                                        return h0;
                                    }
                                };
                                this.r = v;
                                this.w = 2;
                                if(FlowKt.collectLatest(sharedFlow0, mixUpPlaylistComposeFragment$MixUpPlaylistList$3$1$10, this) == a0) {
                                    return a0;
                                }
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
                        return h0;
                    }
                };
                p2.l0(mixUpPlaylistComposeFragment$MixUpPlaylistList$3$10);
            }
            J.d(p2, Boolean.TRUE, mixUpPlaylistComposeFragment$MixUpPlaylistList$3$10);
        }
        else {
            p2 = (p)l0;
            p2.T();
        }
        n0 n00 = p2.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.d(this, v, 3);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1 implements we.p {
            public final MixUpUIItemData a;
            public final SongListClickListener b;
            public final F c;
            public final MixUpPlaylistComposeFragment d;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1(PlayableItem mixUpUIItemData$PlayableItem0, SongListClickListener songListClickListener0, F f0, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
                this.a = mixUpUIItemData$PlayableItem0;
                this.b = songListClickListener0;
                this.c = f0;
                this.d = mixUpPlaylistComposeFragment0;
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((Dc.h)object0), ((Boolean)object1).booleanValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(Dc.h h0, boolean z, l l0, int v) {
                kotlin.jvm.internal.q.g(h0, "$this$MovableItem");
                if((v & 6) == 0) {
                    v |= (((v & 8) == 0 ? ((p)l0).g(h0) : ((p)l0).i(h0)) ? 4 : 2);
                }
                if(((p)l0).Q(v & 1, (v & 0x83) != 130)) {
                    q q0 = Dc.h.a(h0, false, 15);
                    MixUpUIItemData mixUpUIItemData0 = this.a;
                    boolean z1 = ((p)l0).i(mixUpUIItemData0);
                    com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1.1.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$1$10 = ((p)l0).N();
                    V v1 = k.a;
                    if(z1 || mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$1$10 == v1) {
                        mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$1$10 = new we.a() {
                            public final MixUpUIItemData a;

                            {
                                this.a = mixUpUIItemData0;
                            }

                            public final MixUpUIItemData invoke() {
                                return this.a;
                            }

                            @Override  // we.a
                            public Object invoke() {
                                return this.invoke();
                            }
                        };
                        ((p)l0).l0(mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$1$10);
                    }
                    MixUpSongListKt.MixUpSongItemInPlaylist(null, q0, mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$1$10, this.b, ((p)l0), 0, 1);
                    F f0 = this.c;
                    boolean z2 = ((p)l0).g(f0);
                    boolean z3 = ((p)l0).i(mixUpUIItemData0);
                    MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.d;
                    boolean z4 = ((p)l0).i(mixUpPlaylistComposeFragment0);
                    com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1.2.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$2$10 = ((p)l0).N();
                    if((z2 | z3 | z4) != 0 || mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$2$10 == v1) {
                        mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$2$10 = new we.n(mixUpUIItemData0, mixUpPlaylistComposeFragment0, null) {
                            public final F B;
                            public final MixUpUIItemData D;
                            public final MixUpPlaylistComposeFragment E;
                            public long r;
                            public int w;

                            {
                                this.B = f0;
                                this.D = mixUpUIItemData0;
                                this.E = mixUpPlaylistComposeFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1.2.1(this.B, this.D, this.E, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                long v1;
                                ne.a a0 = ne.a.a;
                                switch(this.w) {
                                    case 0: {
                                        d5.n.D(object0);
                                        long v = System.currentTimeMillis();
                                        this.r = v;
                                        this.w = 1;
                                        if(DelayKt.delay(1000L, this) == a0) {
                                            return a0;
                                        }
                                        v1 = v;
                                        break;
                                    }
                                    case 1: {
                                        long v2 = this.r;
                                        d5.n.D(object0);
                                        v1 = v2;
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                PlayableItem mixUpUIItemData$PlayableItem0 = (PlayableItem)this.D;
                                String s = mixUpUIItemData$PlayableItem0.getId();
                                Integer integer0 = PlaylistUiExtensionsKt.getPositionFromKey(this.B, s);
                                if(integer0 != null) {
                                    od.a a1 = MixUpPlaylistComposeFragment.access$getViewModel(this.E).getMixUpAreaOrNull(((int)integer0));
                                    MixUpPlaylistComposeFragment.access$getViewImpLogHelper(this.E).putImpLog(v1, m.s(((int)integer0)), a1, mixUpUIItemData$PlayableItem0.getPlayableData().a);
                                }
                                return H.a;
                            }
                        };
                        ((p)l0).l0(mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$2$10);
                    }
                    J.d(((p)l0), Boolean.TRUE, mixUpPlaylistComposeFragment$MixUpPlaylistList$1$1$1$2$1$3$1$2$10);
                    return;
                }
                ((p)l0).T();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment$MixUpPlaylistList$1$3$1$1$1", f = "MixUpPlaylistComposeFragment.kt", l = {714}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1 extends oe.i implements we.n {
            public int r;
            public final F w;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1(F f0, Continuation continuation0) {
                this.w = f0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.j(0, 0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment$MixUpPlaylistList$2$1$observer$1$1", f = "MixUpPlaylistComposeFragment.kt", l = {733}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1 extends oe.i implements we.n {
            public final int B;
            public int r;
            public final F w;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1(F f0, int v, Continuation continuation0) {
                this.w = f0;
                this.B = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.2.1.observer.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        return this.w.j(this.B, 0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.1 extends kotlin.jvm.internal.r implements we.k {
            public final we.k f;
            public final List g;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.1(we.k k0, List list0) {
                this.f = k0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "index", "", "invoke", "(I)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.2 extends kotlin.jvm.internal.r implements we.k {
            public final we.k f;
            public final List g;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.2(we.k k0, List list0) {
                this.f = k0;
                this.g = list0;
                super(1);
            }

            public final Object invoke(int v) {
                Object object0 = this.g.get(v);
                return this.f.invoke(object0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).intValue());
            }
        }


        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u000B¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Landroidx/compose/foundation/lazy/a;", "", "it", "Lie/H;", "invoke", "(Landroidx/compose/foundation/lazy/a;ILandroidx/compose/runtime/l;I)V", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.3 extends kotlin.jvm.internal.r implements we.p {
            public final List f;
            public final u g;
            public final Dc.g h;
            public final MixUpPlaylistComposeFragment i;
            public final SongListClickListener j;
            public final F k;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.55.lambda.54.lambda.53.lambda.52..inlined.items.3(List list0, u u0, Dc.g g0, MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, SongListClickListener songListClickListener0, F f0) {
                this.f = list0;
                this.g = u0;
                this.h = g0;
                this.i = mixUpPlaylistComposeFragment0;
                this.j = songListClickListener0;
                this.k = f0;
                super(4);
            }

            @Override  // we.p
            public Object invoke(Object object0, Object object1, Object object2, Object object3) {
                this.invoke(((androidx.compose.foundation.lazy.a)object0), ((Number)object1).intValue(), ((l)object2), ((Number)object3).intValue());
                return H.a;
            }

            public final void invoke(androidx.compose.foundation.lazy.a a0, int v, l l0, int v1) {
                int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(a0) ? 4 : 2) : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((p)l0).e(v) ? 0x20 : 16);
                }
                if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)this.f.get(v);
                    ((p)l0).a0(0xC149009D);
                    MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.i;
                    if(mixUpUIItemData0 instanceof PlayableItem) {
                        ((p)l0).a0(-1052142566);
                        String s = ((PlayableItem)mixUpUIItemData0).getId();
                        m0.b b0 = m0.c.e(0x5F9E58FE, ((p)l0), new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.1.1.2.1.3.1(((PlayableItem)mixUpUIItemData0), this.j, this.k, mixUpPlaylistComposeFragment0));
                        u0.e(a0, this.g, s, null, false, this.h, b0, ((p)l0), v2 & 14 | 0x180000);
                    }
                    else {
                        ((p)l0).a0(-1050772459);
                        mixUpPlaylistComposeFragment0.WaitingTitle(((p)l0), 0);
                    }
                    ((p)l0).p(false);
                    ((p)l0).p(false);
                    return;
                }
                ((p)l0).T();
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.61.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.61.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v, CoroutineScope coroutineScope0, F f0) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
            }

            public final q invoke(q q0, l l0, int v) {
                kotlin.jvm.internal.q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                K.m m0 = ((p)l0).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.61.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$lambda$62$lambda$61$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.d);
                        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1 mixUpPlaylistComposeFragment$MixUpPlaylistList$1$3$1$1$10 = new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.1.3.1.1.1(this.c, null);
                        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, mixUpPlaylistComposeFragment$MixUpPlaylistList$1$3$1$1$10, 3, null);
                    }
                };
                q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, mixUpPlaylistComposeFragment$MixUpPlaylistList$lambda$62$lambda$61$lambda$60$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }


        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/iloen/melon/player/playlist/mixup/MixUpPlaylistComposeFragment$MixUpPlaylistList$lambda$66$lambda$65$$inlined$onDispose$1", "Landroidx/compose/runtime/G;", "Lie/H;", "dispose", "()V", "runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.66.lambda.65..inlined.onDispose.1 implements G {
            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.66.lambda.65..inlined.onDispose.1(D d0, B b0) {
            }

            @Override  // androidx.compose.runtime.G
            public void dispose() {
                this.a.getLifecycle().c(this.b);
            }
        }

    }

    public final void MixUpTabEmptyViewLayout(@Nullable l l0, int v) {
        P0.h h4;
        P0.i i1;
        p p0 = (p)l0;
        p0.c0(0xD8AABA7D);
        int v1 = (v & 6) == 0 ? v | (p0.i(this) ? 4 : 2) : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            Q0 q00 = androidx.compose.foundation.q.t(p0);
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.x(androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.f(n0, 1.0f), 1.0f), q00, false, 14);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, y0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            w.x(p0, q1, j.d);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 142.0f));
            C0.c c0 = De.I.Q(0x7F0806A4, p0, 6);  // drawable:logo_mixup_148
            q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 148.0f), 24.0f);
            String s = H0.e.Y(p0, 0x7F130A18);  // string:smart_mixup_playlist_title "믹스업"
            P0.h h3 = j.d;
            androidx.compose.foundation.q.c(c0, s, q2, null, null, 0.0f, null, p0, 0x180, 120);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 14.0f));
            N1.b("", null, e0.T(p0, 0x7F0604B7), 15.0f, null, null, 0L, new l1.k(3), 18.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // color:white700e
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 20.0f));
            q q3 = androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(n0, 3), null, 3);
            M m0 = M.p.d(r0.d.e, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(!p0.O && kotlin.jvm.internal.q.b(p0.N(), v3)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v3, p0, v3, h4);
            }
            w.x(p0, q4, h3);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604B1), 0.5f);  // color:white220e
            T.d d0 = T.e.b(21.0f);
            q q5 = r0.a.a(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.j(n0, y1.a, y1.b, d0), 16.0f, 10.0f, 16.0f, 9.0f), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    K.m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(this);
                    com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpTabEmptyViewLayout.lambda.76.lambda.75..inlined.noRippleClickable-YQRRFTQ.default.1.1 mixUpPlaylistComposeFragment$MixUpTabEmptyViewLayout$lambda$76$lambda$75$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            this.b.n().logClickPopularPlay();
                            MixUpPlaylistComposeFragment.access$getViewModel(this.b).playPopularPlaylist();
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, mixUpPlaylistComposeFragment$MixUpTabEmptyViewLayout$lambda$76$lambda$75$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h4);
            }
            w.x(p0, q6, h3);
            c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 24.0f), 14.0f), 0x7F080153, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_common_mixup_14
            N1.b(l1.s(n0, 4.0f, p0, 0x7F13069F, p0), null, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:mixup_empty_popular_btn "인기 플레이리스트 믹스업"
            p0.p(true);
            p0.p(true);
            A7.d.v(n0, 40.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.d(this, v, 1);
        }
    }

    public final void SelectableFilter(@Nullable l l0, int v) {
        ((p)l0).c0(677750153);
        int v1 = (v & 6) == 0 ? (((p)l0).i(this) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            boolean z = ((MixUpPlaylistComposeViewModel)this.getViewModel()).isSelectedAny();
            q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n.a, 42.0f), 0.0f, 14.0f, 0.0f, 10.0f, 5);
            boolean z1 = ((p)l0).h(z);
            boolean z2 = ((p)l0).i(this);
            o1 o10 = ((p)l0).N();
            if(z1 || z2 || o10 == k.a) {
                o10 = new o1(z, this);
                ((p)l0).l0(o10);
            }
            PlaylistCommonHeaderComposableKt.AllSelectButton(q0, z, null, null, o10, ((p)l0), 6, 12);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.d(this, v, 4);
        }
    }

    public final void SourceTitle(@Nullable l l0, int v) {
        Playable playable0;
        String s2;
        p p0 = (p)l0;
        p0.c0(0xD78C25FC);
        int v1 = (v & 6) == 0 ? (p0.i(this) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = B.a.r(((MixUpPlaylistComposeViewModel)this.getViewModel()).getMixUpInfoStateFlow(), p0, 0);
            b0 b01 = B.a.r(((MixUpPlaylistComposeViewModel)this.getViewModel()).isCurrentPlaylistStateFlow(), p0, 0);
            pc.c c0 = (pc.c)b00.getValue();
            V v2 = k.a;
            if(c0 instanceof pc.a) {
                p0.a0(0x7E3CDB80);
                String s = ((pc.a)c0).a;
                String s1 = ((pc.a)c0).b;
                boolean z = p0.i(this);
                com.iloen.melon.player.playlist.mixup.g g0 = p0.N();
                if(z || g0 == v2) {
                    g0 = new com.iloen.melon.player.playlist.mixup.g(this, 4);
                    p0.l0(g0);
                }
                MixUpComposablesKt.SourceTitleCommon(s, s1, g0, p0, 0, 0);
            }
            else if(c0 instanceof DjMalrangInfo) {
                p0.a0(0x7E428064);
                if(A8.b.d()) {
                    p0.a0(2118300480);
                    boolean z1 = ((Boolean)b01.getValue()).booleanValue();
                    boolean z2 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g1 = p0.N();
                    if(z2 || g1 == v2) {
                        g1 = new com.iloen.melon.player.playlist.mixup.g(this, 5);
                        p0.l0(g1);
                    }
                    boolean z3 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g2 = p0.N();
                    if(z3 || g2 == v2) {
                        g2 = new com.iloen.melon.player.playlist.mixup.g(this, 6);
                        p0.l0(g2);
                    }
                    boolean z4 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g3 = p0.N();
                    if(z4 || g3 == v2) {
                        g3 = new com.iloen.melon.player.playlist.mixup.g(this, 7);
                        p0.l0(g3);
                    }
                    MixUpComposablesKt.SourceTitleForDjMalrang(((DjMalrangInfo)c0), z1, g1, g2, null, g3, p0, 0, 16);
                }
                else {
                    Object object0 = null;
                    p0.a0(2118930059);
                    ListIterator listIterator0 = ((MixUpPlaylistComposeViewModel)this.getViewModel()).getUiList().listIterator();
                    while(true) {
                        s2 = null;
                        if(!((P0.r)listIterator0).hasNext()) {
                            break;
                        }
                        Object object1 = ((P0.r)listIterator0).next();
                        if(((MixUpUIItemData)object1) instanceof PlayableItem && ((PlayableItem)(((MixUpUIItemData)object1))).isCurrent()) {
                            object0 = object1;
                            break;
                        }
                    }
                    PlayableItem mixUpUIItemData$PlayableItem0 = object0 instanceof PlayableItem ? ((PlayableItem)object0) : null;
                    if(mixUpUIItemData$PlayableItem0 == null) {
                        playable0 = null;
                    }
                    else {
                        PlayableData playableData0 = mixUpUIItemData$PlayableItem0.getPlayableData();
                        playable0 = playableData0 == null ? null : playableData0.a;
                    }
                    StatsElementsBase statsElementsBase0 = StatsElementsBase.toStatsElementsBase((playable0 == null ? null : ""));
                    if(statsElementsBase0 != null) {
                        s2 = statsElementsBase0.impressionId;
                    }
                    String s3 = String.valueOf(s2);
                    boolean z5 = ((Boolean)b01.getValue()).booleanValue();
                    boolean z6 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g4 = p0.N();
                    if(z6 || g4 == v2) {
                        g4 = new com.iloen.melon.player.playlist.mixup.g(this, 8);
                        p0.l0(g4);
                    }
                    boolean z7 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g5 = p0.N();
                    if(z7 || g5 == v2) {
                        g5 = new com.iloen.melon.player.playlist.mixup.g(this, 9);
                        p0.l0(g5);
                    }
                    boolean z8 = p0.i(this);
                    com.iloen.melon.player.playlist.mixup.g g6 = p0.N();
                    if(z8 || g6 == v2) {
                        g6 = new com.iloen.melon.player.playlist.mixup.g(this, 10);
                        p0.l0(g6);
                    }
                    MixUpComposablesKt.SourceTitleForDjMalrangDebug(((DjMalrangInfo)c0), z5, g4, g5, g6, s3, p0, 0, 0);
                }
                p0.p(false);
            }
            else {
                p0.a0(2098025798);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.d(this, v, 0);
        }
    }

    public final void WaitingTitle(@Nullable l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x6F134226);
        if(p0.Q(v & 1, (v & 1) != 0)) {
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.d.f(androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n0, 48.0f), 20.0f, 0.0f, 0.0f, 12.0f, 6), 1.0f);
            M m0 = M.p.d(r0.d.g, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            w.x(p0, q1, j.d);
            com.iloen.melon.player.playlist.common.h h1 = p0.N();
            if(h1 == k.a) {
                h1 = new com.iloen.melon.player.playlist.common.h(11);
                p0.l0(h1);
            }
            N1.b("", X0.n.c(n0, false, h1), e0.T(p0, 0x7F0604A1), 15.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0x30C00, 0xC30, 0x1D7D0);  // color:white000e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.d(this, v, 2);
        }
    }

    public static final String access$getLastPvDummyAction$p(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        return mixUpPlaylistComposeFragment0.r;
    }

    public static final Object access$getPvDummyAction(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, Continuation continuation0) {
        MixUpPlaylistComposeFragment.getPvDummyAction.1 mixUpPlaylistComposeFragment$getPvDummyAction$10;
        mixUpPlaylistComposeFragment0.getClass();
        if(continuation0 instanceof MixUpPlaylistComposeFragment.getPvDummyAction.1) {
            mixUpPlaylistComposeFragment$getPvDummyAction$10 = (MixUpPlaylistComposeFragment.getPvDummyAction.1)continuation0;
            int v = mixUpPlaylistComposeFragment$getPvDummyAction$10.B;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistComposeFragment$getPvDummyAction$10 = new MixUpPlaylistComposeFragment.getPvDummyAction.1(mixUpPlaylistComposeFragment0, continuation0);
            }
            else {
                mixUpPlaylistComposeFragment$getPvDummyAction$10.B = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistComposeFragment$getPvDummyAction$10 = new MixUpPlaylistComposeFragment.getPvDummyAction.1(mixUpPlaylistComposeFragment0, continuation0);
        }
        Object object0 = mixUpPlaylistComposeFragment$getPvDummyAction$10.r;
        ne.a a0 = ne.a.a;
        switch(mixUpPlaylistComposeFragment$getPvDummyAction$10.B) {
            case 0: {
                d5.n.D(object0);
                MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = (MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel();
                mixUpPlaylistComposeFragment$getPvDummyAction$10.B = 1;
                object0 = mixUpPlaylistComposeViewModel0.getIsDjMalrang(mixUpPlaylistComposeFragment$getPvDummyAction$10);
                if(object0 == a0) {
                    return a0;
                }
                return ((Boolean)object0).booleanValue() ? "simplePlaylist" : "connMixup";
            }
            case 1: {
                d5.n.D(object0);
                return ((Boolean)object0).booleanValue() ? "simplePlaylist" : "connMixup";
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        return (PlaylistSharedViewModel)mixUpPlaylistComposeFragment0.m.getValue();
    }

    public static final MixUpPlaylistViewImpLogHelper access$getViewImpLogHelper(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        return (MixUpPlaylistViewImpLogHelper)mixUpPlaylistComposeFragment0.o.getValue();
    }

    public static final MixUpPlaylistComposeViewModel access$getViewModel(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        return (MixUpPlaylistComposeViewModel)mixUpPlaylistComposeFragment0.getViewModel();
    }

    public static final void access$updateToolBar(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, int v) {
        if(v > 0) {
            ToolBar toolBar0 = mixUpPlaylistComposeFragment0.l;
            if(toolBar0 != null) {
                toolBar0.setOnToolBarAnimationListener(new MixUpPlaylistComposeFragment.updateToolBar.1.1(mixUpPlaylistComposeFragment0));
                toolBar0.h(true);
                toolBar0.l(v);
            }
        }
        else {
            ToolBar toolBar1 = mixUpPlaylistComposeFragment0.l;
            if(toolBar1 != null) {
                toolBar1.setOnToolBarAnimationListener(new MixUpPlaylistComposeFragment.updateToolBar.2.1(mixUpPlaylistComposeFragment0));
                toolBar1.h(false);
                toolBar1.d();
            }
        }
    }

    @Override  // com.melon.ui.c0
    @NotNull
    public f1 getInsetHandlingType() {
        return this.k;
    }

    @NotNull
    public final db.c getLocationUseCase() {
        db.c c0 = this.locationUseCase;
        if(c0 != null) {
            return c0;
        }
        kotlin.jvm.internal.q.m("locationUseCase");
        throw null;
    }

    @NotNull
    public final x2 getPlayBgColorExtractor() {
        x2 x20 = this.playBgColorExtractor;
        if(x20 != null) {
            return x20;
        }
        kotlin.jvm.internal.q.m("playBgColorExtractor");
        throw null;
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        kotlin.jvm.internal.q.m("playerUiHelper");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        kotlin.jvm.internal.q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final Pc.d getStringProvider() {
        Pc.d d0 = this.stringProvider;
        if(d0 != null) {
            return d0;
        }
        kotlin.jvm.internal.q.m("stringProvider");
        throw null;
    }

    public void getTiaraEventBuilder(@Nullable Context context0, @Nullable String s, @NotNull we.k k0) {
        kotlin.jvm.internal.q.g(k0, "action");
        this.e.v(context0, s, k0);
    }

    @NotNull
    public D2 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        D2 d20 = D2.a(layoutInflater0, null);
        this.i = d20;
        return d20;
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return MixUpPlaylistComposeViewModel.class;
    }

    @Override  // com.melon.ui.a
    public void handleAddPlayUiEvent(@NotNull l0 l00, @NotNull com.melon.ui.b b0, @Nullable Context context0, @NotNull we.k k0, @NotNull CoroutineScope coroutineScope0) {
        kotlin.jvm.internal.q.g(l00, "fragmentManager");
        kotlin.jvm.internal.q.g(b0, "event");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutineScope");
        this.f.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.L0
    public void handleDjMalrangUiEvent(@NotNull l0 l00, @NotNull O0 o00, @Nullable Activity activity0, @NotNull we.k k0, @NotNull CoroutineScope coroutineScope0) {
        kotlin.jvm.internal.q.g(l00, "fragmentManager");
        kotlin.jvm.internal.q.g(o00, "event");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutineScope");
        this.g.handleDjMalrangUiEvent(l00, o00, activity0, k0, coroutineScope0);
    }

    public void handleMoreListPopupOnEvent(@NotNull androidx.fragment.app.I i0, @NotNull we.k k0, @Nullable Q q0, @NotNull k2 k20) {
        kotlin.jvm.internal.q.g(i0, "fragment");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        kotlin.jvm.internal.q.g(k20, "event");
        this.e.x(i0, k0, q0, k20);
    }

    @Override  // com.melon.ui.M2
    public void handleMorePopupUiEvent(@NotNull m2 m20, @NotNull androidx.fragment.app.I i0, @Nullable o o0) {
        kotlin.jvm.internal.q.g(m20, "event");
        kotlin.jvm.internal.q.g(i0, "fragment");
        this.e.handleMorePopupUiEvent(m20, i0, o0);
    }

    @Override  // com.melon.ui.k3
    public void handlePutPopupUiEvent(@NotNull o3 o30, @NotNull androidx.fragment.app.I i0, @Nullable we.a a0, @NotNull we.k k0, boolean z, @Nullable we.a a1) {
        kotlin.jvm.internal.q.g(o30, "event");
        kotlin.jvm.internal.q.g(i0, "fragment");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        this.d.handlePutPopupUiEvent(o30, i0, a0, k0, z, a1);
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final MixUpPlaylistTiaraLogHelper n() {
        return (MixUpPlaylistTiaraLogHelper)this.n.getValue();
    }

    @Override  // com.melon.ui.J0
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        D2 d20 = D2.a(layoutInflater0, viewGroup0);
        this.i = d20;
        return d20.a;
    }

    @Override  // com.melon.ui.J0
    public void onDestroyView() {
        super.onDestroyView();
        this.l = null;
        this.i = null;
        ((MixUpPlaylistComposeViewModel)this.getViewModel()).updateHasToolbarPadding(false);
    }

    @Override  // com.melon.ui.c0
    public void onResume() {
        super.onResume();
        if(this.isVisible()) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new MixUpPlaylistComposeFragment.onForegroundEvent.1(this, null), 3, null);
            ((PlaylistSharedViewModel)this.m.getValue()).updateControllerVisibility(true);
            ((MixUpPlaylistComposeViewModel)this.getViewModel()).releaseSelectedAll();
        }
    }

    @Override  // com.melon.ui.c0
    public void onStop() {
        super.onStop();
        l0 l00 = this.getChildFragmentManager();
        vd.E e0 = vd.E.a;
        if(l00 != null) {
            androidx.fragment.app.w w0 = com.melon.ui.popup.b.b(l00, "MixUpPlaylistComposeFragment.RecommendPopup", e0, null, 8);
            if(w0 != null) {
                w0.dismissAllowingStateLoss();
            }
        }
        ((MixUpPlaylistViewImpLogHelper)this.o.getValue()).flush();
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        kotlin.jvm.internal.q.g(i40, "event");
        if(i40 instanceof com.melon.ui.e0) {
            ((PlaylistSharedViewModel)this.m.getValue()).updateTiaraProperty(PlaylistTab.MIX_UP, ((com.melon.ui.e0)i40).a);
            return;
        }
        if(i40 instanceof OpenOtherRecommendDialog) {
            if(((OpenOtherRecommendDialog)i40).getThumbUriForBg() == null) {
                com.melon.ui.popup.b.i(this.getContext(), this.getChildFragmentManager(), ((OpenOtherRecommendDialog)i40).getCurrentDjMalrangInfo(), null, "MixUpPlaylistComposeFragment.RecommendPopup");
                return;
            }
            D d0 = this.getViewLifecycleOwner();
            kotlin.jvm.internal.q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(i40, null) {
                public final I4 B;
                public int r;
                public final MixUpPlaylistComposeFragment w;

                {
                    this.w = mixUpPlaylistComposeFragment0;
                    this.B = i40;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onUiEvent.1(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onUiEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    I4 i40 = this.B;
                    MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.w;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            x2 x20 = mixUpPlaylistComposeFragment0.getPlayBgColorExtractor();
                            Uri uri0 = ((OpenOtherRecommendDialog)i40).getThumbUriForBg();
                            this.r = 1;
                            object0 = x20.a(uri0, this);
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
                    com.melon.ui.popup.b.i(mixUpPlaylistComposeFragment0.getContext(), mixUpPlaylistComposeFragment0.getChildFragmentManager(), ((OpenOtherRecommendDialog)i40).getCurrentDjMalrangInfo(), ((PlayBgColorData)object0), "MixUpPlaylistComposeFragment.RecommendPopup");
                    return H.a;
                }
            }, 3, null);
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            com.melon.ui.popup.b.s(this.getContext(), this.getChildFragmentManager(), ((ShowSelectionRepeatInterruptPopup)i40).getOkAction(), null);
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            return;
        }
        if(i40 instanceof u4) {
            Navigator.openUrl("", ((u4)i40).a, OpenType.FullScreen, ((u4)i40).b);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, new com.iloen.melon.player.playlist.mixup.i(this));
            return;
        }
        if(i40 instanceof PlaylistDeleteUiEvent) {
            Object object0 = this.h.getValue();
            Pc.d d1 = this.getStringProvider();
            l0 l00 = this.getChildFragmentManager();
            kotlin.jvm.internal.q.f(l00, "getChildFragmentManager(...)");
            ((PlaylistDeleteUiEventHelper)object0).handleUiEvent(((PlaylistDeleteUiEvent)i40), d1, l00, this.getPlayerUiHelper(), new we.k(0, MixUpPlaylistComposeFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    kotlin.jvm.internal.q.g(e0, "p0");
                    ((MixUpPlaylistComposeFragment)this.receiver).sendUserEvent(e0);
                }
            });
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new com.iloen.melon.player.playlist.mixup.g(this, 2), new we.k(0, MixUpPlaylistComposeFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    kotlin.jvm.internal.q.g(e0, "p0");
                    ((MixUpPlaylistComposeFragment)this.receiver).sendUserEvent(e0);
                }
            }, false, 0x30);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l01 = this.getChildFragmentManager();
            kotlin.jvm.internal.q.f(l01, "getChildFragmentManager(...)");
            a.f(this, l01, ((com.melon.ui.b)i40), this.getContext(), new we.k(0, MixUpPlaylistComposeFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    kotlin.jvm.internal.q.g(e0, "p0");
                    ((MixUpPlaylistComposeFragment)this.receiver).sendUserEvent(e0);
                }
            });
            AddResult addResult0 = ((com.melon.ui.b)i40).a;
            if(addResult0 instanceof Success && ((Success)addResult0).getRequestAddResult().b() == PlaylistId.MIX_UP) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
                    public int r;
                    public final MixUpPlaylistComposeFragment w;

                    {
                        this.w = mixUpPlaylistComposeFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onUiEvent.7(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onUiEvent.7)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                this.r = 1;
                                object0 = MixUpPlaylistComposeFragment.access$getPvDummyAction(mixUpPlaylistComposeFragment0, this);
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
                        MixUpPlaylistComposeFragment.access$getViewModel(mixUpPlaylistComposeFragment0).clearTiaraPropertyAndPerformPvDummyLogging(((String)object0));
                        mixUpPlaylistComposeFragment0.r = (String)object0;
                        return H.a;
                    }
                }, 3, null);
            }
            return;
        }
        if(i40 instanceof O0) {
            l0 l02 = this.getChildFragmentManager();
            kotlin.jvm.internal.q.f(l02, "getChildFragmentManager(...)");
            L0.a(this, l02, ((O0)i40), this.getActivity(), new we.k(0, MixUpPlaylistComposeFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    kotlin.jvm.internal.q.g(e0, "p0");
                    ((MixUpPlaylistComposeFragment)this.receiver).sendUserEvent(e0);
                }
            });
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D2 d20 = this.i;
        if(d20 == null) {
            return;
        }
        D d0 = this.getViewLifecycleOwner();
        kotlin.jvm.internal.q.f(d0, "getViewLifecycleOwner(...)");
        I7.c c0 = new I7.c(d0);
        d20.b.setViewCompositionStrategy(c0);
        m0.b b0 = new m0.b(0x96C6C27A, new com.iloen.melon.player.playlist.mixup.e(this, 0), true);
        d20.b.setContent(b0);
        ToolBar toolBar0 = ToolBar.f(((ToolBar)d20.c.c), 0x3F0);
        toolBar0.setOnToolBarListener(new f(this));
        this.l = toolBar0;
        D d1 = this.getViewLifecycleOwner();
        kotlin.jvm.internal.q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new we.n(null) {
            public int r;
            public final MixUpPlaylistComposeFragment w;

            {
                this.w = mixUpPlaylistComposeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.3.1 mixUpPlaylistComposeFragment$onViewCreated$3$10 = new we.n(null) {
                            public int r;
                            public final MixUpPlaylistComposeFragment w;

                            {
                                this.w = mixUpPlaylistComposeFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.3.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = MixUpPlaylistComposeFragment.access$getViewModel(this.w);
                                        this.r = 1;
                                        return mixUpPlaylistComposeViewModel0.updateCurrentFocus(this) == a0 ? a0 : H.a;
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
                        return f0.j(this.w, s.d, mixUpPlaylistComposeFragment$onViewCreated$3$10, this) == a0 ? a0 : H.a;
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

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment$onViewCreated$1$3$1", f = "MixUpPlaylistComposeFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1 extends oe.i implements we.n {
            public final MixUpPlaylistComposeFragment r;
            public final int w;

            public com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, int v, Continuation continuation0) {
                this.r = mixUpPlaylistComposeFragment0;
                this.w = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1(this.r, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.onViewCreated.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                MixUpPlaylistComposeFragment.access$updateToolBar(this.r, this.w);
                return H.a;
            }
        }

    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        kotlin.jvm.internal.q.g(k40, "uiState");
    }

    @Override  // com.melon.ui.c0
    public void setInsetHandlingType(@NotNull f1 f10) {
        kotlin.jvm.internal.q.g(f10, "<set-?>");
        this.k = f10;
    }

    public final void setLocationUseCase(@NotNull db.c c0) {
        kotlin.jvm.internal.q.g(c0, "<set-?>");
        this.locationUseCase = c0;
    }

    public final void setPlayBgColorExtractor(@NotNull x2 x20) {
        kotlin.jvm.internal.q.g(x20, "<set-?>");
        this.playBgColorExtractor = x20;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        kotlin.jvm.internal.q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        kotlin.jvm.internal.q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setStringProvider(@NotNull Pc.d d0) {
        kotlin.jvm.internal.q.g(d0, "<set-?>");
        this.stringProvider = d0;
    }

    @Override  // com.melon.ui.k3
    public void showContextMenuAddTo(@NotNull androidx.fragment.app.I i0, @NotNull String s, @NotNull List list0, @Nullable we.a a0, @NotNull we.k k0, boolean z, @NotNull String s1) {
        kotlin.jvm.internal.q.g(i0, "fragment");
        kotlin.jvm.internal.q.g(s, "menuId");
        kotlin.jvm.internal.q.g(list0, "playableList");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        kotlin.jvm.internal.q.g(s1, "ocrGroupId");
        this.d.showContextMenuAddTo(i0, s, list0, a0, k0, z, s1);
    }

    public void showContextMorePopup(@NotNull androidx.fragment.app.I i0, @NotNull Q q0, @Nullable we.k k0) {
        kotlin.jvm.internal.q.g(i0, "fragment");
        kotlin.jvm.internal.q.g(q0, "popupType");
        this.e.z(i0, q0, k0);
    }

    public void showContextPopupSongType(@NotNull Playable playable0, @NotNull androidx.fragment.app.I i0, @Nullable String s, @NotNull we.k k0) {
        kotlin.jvm.internal.q.g(playable0, "playable");
        kotlin.jvm.internal.q.g(i0, "fragment");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        this.e.A(playable0, i0, s, k0);
    }
}

