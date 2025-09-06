package com.iloen.melon.player.playlist.search;

import Bc.h;
import De.I;
import J8.G2;
import J8.s1;
import J8.t1;
import J8.v1;
import R6.d;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.Z;
import androidx.recyclerview.widget.v;
import c2.W;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.custom.f1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventMixUpPlaylistViewFocus;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddResult.Success;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEvent;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEventHelper;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TalkbackUtilKt;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e0;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.n0;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.t4;
import com.melon.ui.u4;
import com.melon.ui.x4;
import d3.g;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import ob.z;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;
import we.o;
import zd.Q;

@Metadata(d1 = {"\u0000\u00EA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 {2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0007{|}~\u007F\u0080\u0001B\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\tH\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001F\u0010\bJ\u000F\u0010 \u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b \u0010\bJ\u000F\u0010!\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b!\u0010\bJ\\\u0010-\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\"2\u0006\u0010$\u001A\u00020#2\u000E\u0010&\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120\'2\u0006\u0010+\u001A\u00020*2\u000E\u0010,\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%H\u0096\u0001\u00A2\u0006\u0004\b-\u0010.Jb\u00105\u001A\u00020\u00122\u0006\u0010$\u001A\u00020#2\u0006\u00100\u001A\u00020/2\f\u00103\u001A\b\u0012\u0004\u0012\u000202012\u000E\u0010&\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120\'2\u0006\u0010+\u001A\u00020*2\u0006\u00104\u001A\u00020/H\u0096\u0001\u00A2\u0006\u0004\b5\u00106JF\u0010:\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u0002072\u0006\u0010$\u001A\u00020#2$\u00109\u001A \u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0006\u0012\u0004\u0018\u00010/\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0012\u0018\u000108H\u0096\u0001\u00A2\u0006\u0004\b:\u0010;J6\u0010@\u001A\u00020\u00122\u0006\u0010$\u001A\u00020#2\u0006\u0010=\u001A\u00020<2\u0014\u0010?\u001A\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u0012\u0018\u00010\'H\u0096\u0001\u00A2\u0006\u0004\b@\u0010AJ>\u0010C\u001A\u00020\u00122\u0006\u0010B\u001A\u0002022\u0006\u0010$\u001A\u00020#2\b\u00100\u001A\u0004\u0018\u00010/2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120\'H\u0096\u0001\u00A2\u0006\u0004\bC\u0010DJ>\u0010E\u001A\u00020\u00122\u0006\u0010$\u001A\u00020#2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120\'2\b\u0010=\u001A\u0004\u0018\u00010<2\u0006\u0010\u001C\u001A\u00020>H\u0096\u0001\u00A2\u0006\u0004\bE\u0010FJ8\u0010K\u001A\u00020\u00122\b\u0010H\u001A\u0004\u0018\u00010G2\b\u00100\u001A\u0004\u0018\u00010/2\u0012\u0010J\u001A\u000E\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020I0\'H\u0096\u0001\u00A2\u0006\u0004\bK\u0010LJF\u0010R\u001A\u00020\u00122\u0006\u0010N\u001A\u00020M2\u0006\u0010\u001C\u001A\u00020O2\b\u0010H\u001A\u0004\u0018\u00010G2\u0012\u0010)\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00120\'2\u0006\u0010Q\u001A\u00020PH\u0096\u0001\u00A2\u0006\u0004\bR\u0010SR\"\u0010U\u001A\u00020T8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001A\u00020[8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001A\u00020b8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bc\u0010d\u001A\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001A\u00020i8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bj\u0010k\u001A\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010w\u001A\u00020p8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bq\u0010r\u001A\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001A\u0010x\u001A\u00020*8\u0016X\u0096D\u00A2\u0006\f\n\u0004\bx\u0010y\u001A\u0004\bx\u0010z\u00A8\u0006\u0081\u0001"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;", "Lcom/melon/ui/J0;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchViewModel;", "LJ8/G2;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/G2;", "Lcom/melon/ui/K4;", "uiState", "Lie/H;", "renderUi", "(Lcom/melon/ui/K4;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "onResume", "onStop", "onDestroyView", "Lcom/melon/ui/o3;", "Landroidx/fragment/app/I;", "fragment", "Lkotlin/Function0;", "afterAction", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "", "isNowPlayingList", "afterDismissAction", "handlePutPopupUiEvent", "(Lcom/melon/ui/o3;Landroidx/fragment/app/I;Lwe/a;Lwe/k;ZLwe/a;)V", "", "menuId", "", "Lcom/iloen/melon/playback/Playable;", "playableList", "ocrGroupId", "showContextMenuAddTo", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/util/List;Lwe/a;Lwe/k;ZLjava/lang/String;)V", "Lcom/melon/ui/m2;", "Lkotlin/Function3;", "artistClickLogAction", "handleMorePopupUiEvent", "(Lcom/melon/ui/m2;Landroidx/fragment/app/I;Lwe/o;)V", "Lzd/Q;", "popupType", "Lcom/melon/ui/k2;", "onEvent", "showContextMorePopup", "(Landroidx/fragment/app/I;Lzd/Q;Lwe/k;)V", "playable", "showContextPopupSongType", "(Lcom/iloen/melon/playback/Playable;Landroidx/fragment/app/I;Ljava/lang/String;Lwe/k;)V", "handleMoreListPopupOnEvent", "(Landroidx/fragment/app/I;Lwe/k;Lzd/Q;Lcom/melon/ui/k2;)V", "Landroid/content/Context;", "context", "Lp8/f;", "action", "getTiaraEventBuilder", "(Landroid/content/Context;Ljava/lang/String;Lwe/k;)V", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/melon/ui/b;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "handleAddPlayUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/b;Landroid/content/Context;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "LPc/d;", "stringProvider", "LPc/d;", "getStringProvider", "()LPc/d;", "setStringProvider", "(LPc/d;)V", "Lcom/iloen/melon/custom/f1;", "k", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "isShowTabAndMiniPlayer", "Z", "()Z", "Companion", "PlaylistSearchAdapter", "SongViewHolder", "SearchBaseItemViewHolder", "TotalSearchViewHolder", "SearchEmptyViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchFragment extends Hilt_PlaylistSearchFragment implements M2, a, k3 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000E\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\f¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$Companion;", "", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;", "newInstance", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;", "", "TAG", "Ljava/lang/String;", "", "TALKBACK_ACTION_DEFAULT", "I", "TALKBACK_ACTION_GO_TO_ALBUM", "TALKBACK_ACTION_MORE_SONG_MENU", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchFragment newInstance(@NotNull PlaylistId playlistId0) {
            q.g(playlistId0, "playlistId");
            PlaylistSearchFragment playlistSearchFragment0 = new PlaylistSearchFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("playlistId", playlistId0);
            playlistSearchFragment0.setArguments(bundle0);
            return playlistSearchFragment0;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$PlaylistSearchAdapter;", "Landroidx/recyclerview/widget/Z;", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class PlaylistSearchAdapter extends Z {
        public final int b;
        public final int c;
        public final PlaylistSearchFragment d;

        public PlaylistSearchAdapter() {
            super(playlistSearchFragment0.m);
            this.b = 2;
            this.c = 3;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            SearchListType searchListType0 = (SearchListType)this.getItem(v);
            if(searchListType0 instanceof SearchWrapperPlayable) {
                return 0;
            }
            if(searchListType0 instanceof EmptyViewType) {
                return this.c;
            }
            if(!(searchListType0 instanceof FooterType)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return this.b;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            q.g(o00, "viewHolder");
            PlaylistSearchFragment playlistSearchFragment0 = PlaylistSearchFragment.this;
            if(o00 instanceof SongViewHolder) {
                Object object0 = this.getItem(v);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.playlist.search.SearchListType.SearchWrapperPlayable");
                Playable playable0 = ((SearchWrapperPlayable)object0).getPlayable();
                Uri uri0 = ((SearchWrapperPlayable)object0).getThumbnailUrl();
                ((SongViewHolder)o00).bindView(((SearchWrapperPlayable)object0), playlistSearchFragment0.getContext());
                ((SongViewHolder)o00).getAdultImg().setVisibility((((SearchWrapperPlayable)object0).isAdult() ? 0 : 8));
                Glide.with(o00.itemView.getContext()).load(((SearchWrapperPlayable)object0).getThumbnailUrl()).into(((SongViewHolder)o00).getAlbumImg());
                b b0 = new b(playlistSearchFragment0, ((SearchWrapperPlayable)object0), v, playable0);
                o00.itemView.setOnClickListener(b0);
                ((SongViewHolder)o00).getMoreIcon().setOnClickListener(new s(playlistSearchFragment0, playable0, uri0, 6));
                ((SongViewHolder)o00).getThumbnailContainer().setOnClickListener(new b(playlistSearchFragment0, ((SearchWrapperPlayable)object0), playable0, v, 1));
                if(((SearchWrapperPlayable)object0).isSelectedForSelectRepeat()) {
                    int v1 = ColorUtils.getColor(playlistSearchFragment0.getContext(), 0x7F0604AD);  // color:white075e
                    o00.itemView.setBackgroundColor(v1);
                }
                else {
                    int v2 = ColorUtils.getColor(playlistSearchFragment0.getContext(), 0x7F06048A);  // color:transparent
                    o00.itemView.setBackgroundColor(v2);
                }
                Integer integer0 = PlaylistCommonSongListComposableKt.getFileTypeDrawableResId(((SearchWrapperPlayable)object0).getFileType());
                if(integer0 == null || ((int)integer0) <= 0) {
                    ViewUtils.hideWhen(((SongViewHolder)o00).getIvContentType(), true);
                }
                else {
                    ViewUtils.showWhen(((SongViewHolder)o00).getIvContentType(), true);
                    ((SongViewHolder)o00).getIvContentType().setImageResource(((int)integer0));
                }
                ((SongViewHolder)o00).setPremiumIcon(((SearchWrapperPlayable)object0).getShowOfflineIcon());
                View view0 = o00.itemView.getRootView();
                c c0 = new c(playlistSearchFragment0, ((SearchWrapperPlayable)object0));
                W.m(view0, d2.c.g, "", c0);
                o00.itemView.getRootView().setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    @Override  // android.view.View$AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                        q.g(view0, "host");
                        q.g(accessibilityNodeInfo0, "info");
                        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                        PlaylistSearchFragment playlistSearchFragment0 = ((SearchWrapperPlayable)object0);
                        String s = null;
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, (playlistSearchFragment0.getContext() == null ? null : "앨범 정보 화면 가기")));
                        if(playlistSearchFragment0.getContext() != null) {
                            s = "곡 메뉴 더보기";
                        }
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, s));
                        String s1 = "";
                        String s2 = playable0.isShowAnimation() ? (playable0.isPlayingAnimation() ? ((StringProviderImpl)playlistSearchFragment0.getStringProvider()).a(0x7F130C5F) : ((StringProviderImpl)playlistSearchFragment0.getStringProvider()).a(0x7F130C5E)) + "," : "";  // string:talkback_state_play "재생중"
                        if(playable0.getShowOfflineIcon()) {
                            s1 = "," + ((StringProviderImpl)playlistSearchFragment0.getStringProvider()).a(0x7F130BAC);  // string:talkback_offline_song "오프라인 재생 곡"
                        }
                        Context context0 = playlistSearchFragment0.getContext();
                        accessibilityNodeInfo0.setContentDescription(s2 + TalkbackUtilKt.getTalkbackInfo(uri0, context0) + s1);
                        accessibilityNodeInfo0.setClassName("android.widget.Button");
                    }

                    @Override  // android.view.View$AccessibilityDelegate
                    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                        q.g(view0, "host");
                        Playable playable0 = uri0;
                        PlaylistSearchFragment playlistSearchFragment0 = ((SearchWrapperPlayable)object0);
                        switch(v) {
                            case 100000001: {
                                playlistSearchFragment0.sendUserEvent(new TalkBackActionGoToAlbum(playable0.getIndexInPlaylist(), playable0));
                                return true;
                            }
                            case 100000002: {
                                PlaylistSearchFragment.access$performShowMoreContextPopup(playlistSearchFragment0, playable0, this.d);
                                return true;
                            }
                            default: {
                                return super.performAccessibilityAction(view0, v, bundle0);
                            }
                        }
                    }
                });
                return;
            }
            if(!(o00 instanceof TotalSearchViewHolder) && o00 instanceof SearchEmptyViewHolder) {
                Object object1 = this.getItem(v);
                q.e(object1, "null cannot be cast to non-null type com.iloen.melon.player.playlist.search.SearchListType.EmptyViewType");
                LogU.debug$default(playlistSearchFragment0.h, "onBindViewHolder - SearchEmptyViewHolder", null, false, 6, null);
                ((SearchEmptyViewHolder)o00).setEmptyDescText(((EmptyViewType)object1));
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            int v1 = 0x7F0A01C1;  // id:btn_total_search
            q.g(viewGroup0, "parent");
            PlaylistSearchFragment playlistSearchFragment0 = PlaylistSearchFragment.this;
            if(v == 0) {
                View view0 = playlistSearchFragment0.getLayoutInflater().inflate(0x7F0D0452, viewGroup0, false);  // layout:list_item_song_cpp_search
                int v2 = 0x7F0A00B3;  // id:artist_container
                if(((Flow)I.C(view0, 0x7F0A00B3)) != null) {  // id:artist_container
                    v2 = 0x7F0A00C2;  // id:artist_tv
                    View view1 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
                    if(((MelonTextView)view1) != null && ((Barrier)I.C(view0, 0x7F0A00F5)) != null) {  // id:barrier
                        v2 = 0x7F0A0547;  // id:icon_19
                        View view2 = I.C(view0, 0x7F0A0547);  // id:icon_19
                        if(((ImageView)view2) != null && ((Flow)I.C(view0, 0x7F0A0577)) != null) {  // id:info_container
                            v2 = 0x7F0A0616;  // id:iv_content_type
                            View view3 = I.C(view0, 0x7F0A0616);  // id:iv_content_type
                            if(((ImageView)view3) != null) {
                                v2 = 0x7F0A0658;  // id:iv_now_playing
                                View view4 = I.C(view0, 0x7F0A0658);  // id:iv_now_playing
                                if(((LottieAnimationView)view4) != null) {
                                    v2 = 0x7F0A0659;  // id:iv_now_playing_bg
                                    View view5 = I.C(view0, 0x7F0A0659);  // id:iv_now_playing_bg
                                    if(((MelonImageView)view5) != null) {
                                        v2 = 0x7F0A0670;  // id:iv_premium_downloaded
                                        View view6 = I.C(view0, 0x7F0A0670);  // id:iv_premium_downloaded
                                        if(((ImageView)view6) != null) {
                                            v2 = 0x7F0A0819;  // id:more_icon
                                            View view7 = I.C(view0, 0x7F0A0819);  // id:more_icon
                                            if(((ImageView)view7) != null && ((Flow)I.C(view0, 0x7F0A0AB5)) != null) {  // id:song_title_container
                                                v2 = 0x7F0A0AB6;  // id:song_title_tv
                                                View view8 = I.C(view0, 0x7F0A0AB6);  // id:song_title_tv
                                                if(((MelonTextView)view8) != null) {
                                                    v2 = 0x7F0A0B72;  // id:thumb_container
                                                    View view9 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                                    if(view9 != null) {
                                                        J8.b b0 = J8.b.b(view9);
                                                        v2 = 0x7F0A0B76;  // id:thumb_frame_container
                                                        View view10 = I.C(view0, 0x7F0A0B76);  // id:thumb_frame_container
                                                        if(((FrameLayout)view10) != null) {
                                                            return new SongViewHolder(playlistSearchFragment0, new v1(((ConstraintLayout)view0), ((MelonTextView)view1), ((ImageView)view2), ((ImageView)view3), ((LottieAnimationView)view4), ((MelonImageView)view5), ((ImageView)view6), ((ImageView)view7), ((MelonTextView)view8), b0, ((FrameLayout)view10)));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v2));
            }
            if(v == this.c) {
                View view11 = playlistSearchFragment0.getLayoutInflater().inflate(0x7F0D044C, viewGroup0, false);  // layout:list_empty_search_layout
                MelonTextView melonTextView0 = (MelonTextView)I.C(view11, 0x7F0A01C1);  // id:btn_total_search
                if(melonTextView0 != null) {
                    v1 = 0x7F0A03AF;  // id:description
                    MelonTextView melonTextView1 = (MelonTextView)I.C(view11, 0x7F0A03AF);  // id:description
                    if(melonTextView1 != null) {
                        return new SearchEmptyViewHolder(playlistSearchFragment0, new s1(((ConstraintLayout)view11), melonTextView0, melonTextView1));
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view11.getResources().getResourceName(v1));
            }
            if(v != this.b) {
                throw new IllegalArgumentException("Invalid viewType: " + v);
            }
            View view12 = playlistSearchFragment0.getLayoutInflater().inflate(0x7F0D044D, viewGroup0, false);  // layout:list_footer_total_search_layout
            MelonTextView melonTextView2 = (MelonTextView)I.C(view12, 0x7F0A01C1);  // id:btn_total_search
            if(melonTextView2 == null) {
                throw new NullPointerException("Missing required view with ID: " + view12.getResources().getResourceName(0x7F0A01C1));  // id:btn_total_search
            }
            return new TotalSearchViewHolder(playlistSearchFragment0, new t1(((ConstraintLayout)view12), melonTextView2));
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b¦\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00158&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u00158&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001D\u001A\u00020\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010!\u001A\u00020\u001E8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0014\u0010#\u001A\u00020\u00028&X¦\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u001C¨\u0006$"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$SearchBaseItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;Landroid/view/View;)V", "Lcom/iloen/melon/player/playlist/search/SearchListType$SearchWrapperPlayable;", "item", "Landroid/content/Context;", "context", "Lie/H;", "bindView", "(Lcom/iloen/melon/player/playlist/search/SearchListType$SearchWrapperPlayable;Landroid/content/Context;)V", "", "showAnimation", "playAnimation", "setPlayingUI", "(ZZ)V", "show", "setPremiumIcon", "(Z)V", "Landroid/widget/TextView;", "getSongName", "()Landroid/widget/TextView;", "songName", "getArtistName", "artistName", "getMoreIcon", "()Landroid/view/View;", "moreIcon", "Lcom/airbnb/lottie/LottieAnimationView;", "getIvNowPlaying", "()Lcom/airbnb/lottie/LottieAnimationView;", "ivNowPlaying", "getIvPremium", "ivPremium", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public abstract class SearchBaseItemViewHolder extends O0 {
        public SearchBaseItemViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            super(view0);
        }

        public final void bindView(@NotNull SearchWrapperPlayable searchListType$SearchWrapperPlayable0, @Nullable Context context0) {
            q.g(searchListType$SearchWrapperPlayable0, "item");
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(searchListType$SearchWrapperPlayable0.getSongName());
            if(searchListType$SearchWrapperPlayable0.getSongNameMatchingIndexInfo() != null) {
                spannableStringBuilder0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(context0, 0x7F060179)), searchListType$SearchWrapperPlayable0.getSongNameMatchingIndexInfo().getStart(), searchListType$SearchWrapperPlayable0.getSongNameMatchingIndexInfo().getEnd(), 33);  // color:green490e
            }
            this.getSongName().setText(spannableStringBuilder0);
            SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(searchListType$SearchWrapperPlayable0.getArtists());
            if(searchListType$SearchWrapperPlayable0.getArtistsMatchingIndexInfo() != null) {
                spannableStringBuilder1.setSpan(new ForegroundColorSpan(ColorUtils.getColor(context0, 0x7F060179)), searchListType$SearchWrapperPlayable0.getArtistsMatchingIndexInfo().getStart(), searchListType$SearchWrapperPlayable0.getArtistsMatchingIndexInfo().getEnd(), 33);  // color:green490e
            }
            this.getArtistName().setText(spannableStringBuilder1);
            this.setPlayingUI(searchListType$SearchWrapperPlayable0.isShowAnimation(), searchListType$SearchWrapperPlayable0.isPlayingAnimation());
        }

        @NotNull
        public abstract TextView getArtistName();

        @NotNull
        public abstract LottieAnimationView getIvNowPlaying();

        @NotNull
        public abstract View getIvPremium();

        @NotNull
        public abstract View getMoreIcon();

        @NotNull
        public abstract TextView getSongName();

        public abstract void setPlayingUI(boolean arg1, boolean arg2);

        public final void setPremiumIcon(boolean z) {
            if(z) {
                this.getIvPremium().setVisibility(0);
                return;
            }
            this.getIvPremium().setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0010\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0013\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001A\u0004\b\u0012\u0010\u000F¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$SearchEmptyViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/s1;", "binding", "<init>", "(Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;LJ8/s1;)V", "Lcom/iloen/melon/player/playlist/search/SearchListType$EmptyViewType;", "type", "Lie/H;", "setEmptyDescText", "(Lcom/iloen/melon/player/playlist/search/SearchListType$EmptyViewType;)V", "Lcom/iloen/melon/custom/MelonTextView;", "a", "Lcom/iloen/melon/custom/MelonTextView;", "getDesc", "()Lcom/iloen/melon/custom/MelonTextView;", "desc", "b", "getBtnTotalSearch", "btnTotalSearch", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchEmptyViewHolder extends O0 {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
                int[] arr_v = new int[SearchEmptyViewTextType.values().length];
                try {
                    arr_v[SearchEmptyViewTextType.EMPTY_KEYWORD.ordinal()] = 1;
                }
                catch(NoSuchFieldError unused_ex) {
                }
                WhenMappings.$EnumSwitchMapping$0 = arr_v;
            }
        }

        public final MelonTextView a;
        public final MelonTextView b;
        public final PlaylistSearchFragment c;
        public static final int d;

        public SearchEmptyViewHolder(@NotNull s1 s10) {
            q.g(s10, "binding");
            this.c = playlistSearchFragment0;
            super(s10.a);
            this.a = s10.c;
            this.b = s10.b;
            com.iloen.melon.player.playlist.search.a a0 = new com.iloen.melon.player.playlist.search.a(playlistSearchFragment0, 1);
            s10.b.setOnClickListener(a0);

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchEmptyViewHolder$1$1", f = "PlaylistSearchFragment.kt", l = {829}, m = "invokeSuspend")
            final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.SearchEmptyViewHolder.1.1 extends i implements n {
                public int r;
                public final PlaylistSearchFragment w;

                public com.iloen.melon.player.playlist.search.PlaylistSearchFragment.SearchEmptyViewHolder.1.1(PlaylistSearchFragment playlistSearchFragment0, Continuation continuation0) {
                    this.w = playlistSearchFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.SearchEmptyViewHolder.1.1(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.SearchEmptyViewHolder.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    PlaylistSearchFragment playlistSearchFragment0 = this.w;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            SharedFlow sharedFlow0 = PlaylistSearchFragment.access$getViewModel(playlistSearchFragment0).getKeyword();
                            this.r = 1;
                            object0 = FlowKt.firstOrNull(sharedFlow0, this);
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
                    H h0 = H.a;
                    if(((CharSequence)object0) == null) {
                        return h0;
                    }
                    Navigator.openSearchKeyword$default(((CharSequence)object0).toString(), null, null, 6, null);
                    PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendMelonTotalSearchClickLog();
                    return h0;
                }
            }

        }

        @NotNull
        public final MelonTextView getBtnTotalSearch() {
            return this.b;
        }

        @NotNull
        public final MelonTextView getDesc() {
            return this.a;
        }

        public final void setEmptyDescText(@NotNull EmptyViewType searchListType$EmptyViewType0) {
            int v;
            q.g(searchListType$EmptyViewType0, "type");
            LogU.debug$default(this.c.h, "setEmptyDescText()", null, false, 6, null);
            Context context0 = this.c.getContext();
            if(context0 != null) {
                int[] arr_v = WhenMappings.$EnumSwitchMapping$0;
                if(arr_v[searchListType$EmptyViewType0.getTextType().ordinal()] != 1) {
                    v = searchListType$EmptyViewType0.isDone() ? 0x7F1307B1 : 0x7F1308F7;  // string:nowplaylist_search_empty_msg "더 많은 검색 결과를 보시려면\n멜론 통합검색을 이용해주세요."
                }
                else if(searchListType$EmptyViewType0.isPlaylistEmpty()) {
                    v = 0x7F1308F8;  // string:search_playlist_empty_list_description "검색할 목록이 없습니다."
                }
                else {
                    v = 0x7F1308E4;  // string:search_bottom_tab_search_empty_alert "검색어를 입력해주세요."
                }
                String s = context0.getString(v);
                this.a.setText(s);
                MelonTextView melonTextView0 = this.b;
                if(arr_v[searchListType$EmptyViewType0.getTextType().ordinal()] == 1) {
                    melonTextView0.setVisibility(8);
                    return;
                }
                melonTextView0.setVisibility(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u0012\u001A\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0015\u001A\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000F\u001A\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001B\u001A\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0017\u0010!\u001A\u00020\u001C8\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u001A\u0010\'\u001A\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&R\u001A\u0010-\u001A\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010,R\u0017\u00100\u001A\u00020\u001C8\u0006¢\u0006\f\n\u0004\b.\u0010\u001E\u001A\u0004\b/\u0010 R\u0017\u00106\u001A\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R\u001A\u00109\u001A\u0002018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00103\u001A\u0004\b8\u00105R\u0017\u0010<\u001A\u0002018\u0006¢\u0006\f\n\u0004\b:\u00103\u001A\u0004\b;\u00105¨\u0006="}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$SongViewHolder;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$SearchBaseItemViewHolder;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;", "LJ8/v1;", "binding", "<init>", "(Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;LJ8/v1;)V", "", "showAnimation", "playAnimation", "Lie/H;", "setPlayingUI", "(ZZ)V", "Lcom/iloen/melon/custom/MelonTextView;", "a", "Lcom/iloen/melon/custom/MelonTextView;", "getSongName", "()Lcom/iloen/melon/custom/MelonTextView;", "songName", "b", "getArtistName", "artistName", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "getThumbnailContainer", "()Landroid/widget/FrameLayout;", "thumbnailContainer", "Lcom/iloen/melon/custom/MelonImageView;", "d", "Lcom/iloen/melon/custom/MelonImageView;", "getAlbumImg", "()Lcom/iloen/melon/custom/MelonImageView;", "albumImg", "Landroid/view/View;", "e", "Landroid/view/View;", "getMoreIcon", "()Landroid/view/View;", "moreIcon", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "getIvNowPlaying", "()Lcom/airbnb/lottie/LottieAnimationView;", "ivNowPlaying", "g", "getIvNowPlayingBg", "ivNowPlayingBg", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "getIvContentType", "()Landroid/widget/ImageView;", "ivContentType", "i", "getIvPremium", "ivPremium", "j", "getAdultImg", "adultImg", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SongViewHolder extends SearchBaseItemViewHolder {
        public final MelonTextView a;
        public final MelonTextView b;
        public final FrameLayout c;
        public final MelonImageView d;
        public final ImageView e;
        public final LottieAnimationView f;
        public final MelonImageView g;
        public final ImageView h;
        public final ImageView i;
        public final ImageView j;

        public SongViewHolder(@NotNull v1 v10) {
            q.g(v10, "binding");
            q.f(v10.a, "getRoot(...)");
            super(v10.a);
            this.a = v10.i;
            this.b = v10.b;
            this.c = v10.k;
            this.d = (MelonImageView)v10.j.c;
            this.e = v10.h;
            this.f = v10.e;
            this.g = v10.f;
            this.h = v10.d;
            this.i = v10.g;
            this.j = v10.c;
        }

        @NotNull
        public final ImageView getAdultImg() {
            return this.j;
        }

        @NotNull
        public final MelonImageView getAlbumImg() {
            return this.d;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        public TextView getArtistName() {
            return this.getArtistName();
        }

        @NotNull
        public MelonTextView getArtistName() {
            return this.b;
        }

        @NotNull
        public final ImageView getIvContentType() {
            return this.h;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        @NotNull
        public LottieAnimationView getIvNowPlaying() {
            return this.f;
        }

        @NotNull
        public final MelonImageView getIvNowPlayingBg() {
            return this.g;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        public View getIvPremium() {
            return this.getIvPremium();
        }

        @NotNull
        public ImageView getIvPremium() {
            return this.i;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        @NotNull
        public View getMoreIcon() {
            return this.e;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        public TextView getSongName() {
            return this.getSongName();
        }

        @NotNull
        public MelonTextView getSongName() {
            return this.a;
        }

        @NotNull
        public final FrameLayout getThumbnailContainer() {
            return this.c;
        }

        @Override  // com.iloen.melon.player.playlist.search.PlaylistSearchFragment$SearchBaseItemViewHolder
        public void setPlayingUI(boolean z, boolean z1) {
            MelonImageView melonImageView0 = this.g;
            if(z) {
                melonImageView0.setVisibility(0);
                this.getIvNowPlaying().setVisibility(0);
                if(z1) {
                    this.getIvNowPlaying().playAnimation();
                    return;
                }
                this.getIvNowPlaying().cancelAnimation();
                return;
            }
            melonImageView0.setVisibility(8);
            this.getIvNowPlaying().setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment$TotalSearchViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/t1;", "binding", "<init>", "(Lcom/iloen/melon/player/playlist/search/PlaylistSearchFragment;LJ8/t1;)V", "Lcom/iloen/melon/custom/MelonTextView;", "a", "Lcom/iloen/melon/custom/MelonTextView;", "getBtnTotalSearch", "()Lcom/iloen/melon/custom/MelonTextView;", "btnTotalSearch", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TotalSearchViewHolder extends O0 {
        public final MelonTextView a;
        public static final int b;

        public TotalSearchViewHolder(@NotNull t1 t10) {
            q.g(t10, "binding");
            super(t10.a);
            this.a = t10.b;
            com.iloen.melon.player.playlist.search.a a0 = new com.iloen.melon.player.playlist.search.a(playlistSearchFragment0, 2);
            t10.b.setOnClickListener(a0);

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchFragment$TotalSearchViewHolder$1$1", f = "PlaylistSearchFragment.kt", l = {812}, m = "invokeSuspend")
            final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.TotalSearchViewHolder.1.1 extends i implements n {
                public int r;
                public final PlaylistSearchFragment w;

                public com.iloen.melon.player.playlist.search.PlaylistSearchFragment.TotalSearchViewHolder.1.1(PlaylistSearchFragment playlistSearchFragment0, Continuation continuation0) {
                    this.w = playlistSearchFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.TotalSearchViewHolder.1.1(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.TotalSearchViewHolder.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    PlaylistSearchFragment playlistSearchFragment0 = this.w;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            SharedFlow sharedFlow0 = PlaylistSearchFragment.access$getViewModel(playlistSearchFragment0).getKeyword();
                            this.r = 1;
                            object0 = FlowKt.firstOrNull(sharedFlow0, this);
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
                    H h0 = H.a;
                    if(((CharSequence)object0) == null) {
                        return h0;
                    }
                    Navigator.openSearchKeyword$default(((CharSequence)object0).toString(), null, null, 6, null);
                    PlaylistSearchFragment.access$getTiaraLogHelper(playlistSearchFragment0).sendMelonTotalSearchClickLog();
                    return h0;
                }
            }

        }

        @NotNull
        public final MelonTextView getBtnTotalSearch() {
            return this.a;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistSearchFragment";
    public final p3 d;
    public final d e;
    public final com.melon.ui.e f;
    public final r g;
    public final LogU h;
    public final H8.i i;
    public Job j;
    public f1 k;
    public final com.iloen.melon.player.playlist.search.PlaylistSearchFragment.scrollListener.1 l;
    public final com.iloen.melon.player.playlist.search.PlaylistSearchFragment.diffUtilCallback.1 m;
    @Inject
    public h playerUiHelper;
    @Inject
    public z playerUseCase;
    @Inject
    public s2 playlistManager;
    @Inject
    public Pc.d stringProvider;

    static {
        PlaylistSearchFragment.Companion = new Companion(null);
        PlaylistSearchFragment.$stable = 8;
    }

    public PlaylistSearchFragment() {
        this.d = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new d(25);
        this.f = new com.melon.ui.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = g.Q(new com.iloen.melon.fragments.mymusic.dna.d(20));
        this.h = LogU.Companion.create("PlaylistSearchFragment", false, Category.UI);
        De.d d0 = kotlin.jvm.internal.I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.special..inlined.activityViewModels.default.1 playlistSearchFragment$special$$inlined$activityViewModels$default$10 = new we.a() {
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
        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.special..inlined.activityViewModels.default.2 playlistSearchFragment$special$$inlined$activityViewModels$default$20 = new we.a(this) {
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
        this.i = new H8.i(d0, playlistSearchFragment$special$$inlined$activityViewModels$default$10, new we.a() {
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
        }, playlistSearchFragment$special$$inlined$activityViewModels$default$20);
        this.k = f1.b;
        this.l = new A0() {
            public final PlaylistSearchFragment a;

            {
                this.a = playlistSearchFragment0;
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                EditText editText1;
                q.g(recyclerView0, "recyclerView");
                PlaylistSearchFragment playlistSearchFragment0 = this.a;
                G2 g20 = PlaylistSearchFragment.access$getBinding(playlistSearchFragment0);
                if(g20 != null) {
                    SearchBarView searchBarView0 = g20.d;
                    if(searchBarView0 != null) {
                        EditText editText0 = searchBarView0.getInputTextView();
                        if(editText0 != null && editText0.isFocused() && v == 1) {
                            Context context0 = playlistSearchFragment0.getContext();
                            G2 g21 = PlaylistSearchFragment.access$getBinding(playlistSearchFragment0);
                            if(g21 == null) {
                                editText1 = null;
                            }
                            else {
                                SearchBarView searchBarView1 = g21.d;
                                editText1 = searchBarView1 == null ? null : searchBarView1.getInputTextView();
                            }
                            InputMethodUtils.hideInputMethod(context0, editText1);
                        }
                    }
                }
                super.onScrollStateChanged(recyclerView0, v);
            }
        };
        this.m = new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.diffUtilCallback.1();  // 初始化器: Ljava/lang/Object;-><init>()V

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\b\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"com/iloen/melon/player/playlist/search/PlaylistSearchFragment$diffUtilCallback$1", "Landroidx/recyclerview/widget/v;", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "oldItem", "newItem", "", "areItemsTheSame", "(Lcom/iloen/melon/player/playlist/search/SearchListType;Lcom/iloen/melon/player/playlist/search/SearchListType;)Z", "areContentsTheSame", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.search.PlaylistSearchFragment.diffUtilCallback.1 extends v {
            public boolean areContentsTheSame(SearchListType searchListType0, SearchListType searchListType1) {
                q.g(searchListType0, "oldItem");
                q.g(searchListType1, "newItem");
                return searchListType0.equals(searchListType1);
            }

            @Override  // androidx.recyclerview.widget.v
            public boolean areContentsTheSame(Object object0, Object object1) {
                return this.areContentsTheSame(((SearchListType)object0), ((SearchListType)object1));
            }

            public boolean areItemsTheSame(SearchListType searchListType0, SearchListType searchListType1) {
                q.g(searchListType0, "oldItem");
                q.g(searchListType1, "newItem");
                return !(searchListType0 instanceof SearchWrapperPlayable) || !(searchListType1 instanceof SearchWrapperPlayable) ? searchListType0.equals(searchListType1) : q.b(((SearchWrapperPlayable)searchListType0).getTrackId(), ((SearchWrapperPlayable)searchListType1).getTrackId());
            }

            @Override  // androidx.recyclerview.widget.v
            public boolean areItemsTheSame(Object object0, Object object1) {
                return this.areItemsTheSame(((SearchListType)object0), ((SearchListType)object1));
            }
        }

    }

    public static final void access$closeSearchMode(PlaylistSearchFragment playlistSearchFragment0) {
        playlistSearchFragment0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.f(playlistSearchFragment0), null, null, new PlaylistSearchFragment.closeSearchMode.1(playlistSearchFragment0, null), 3, null);
    }

    public static final G2 access$getBinding(PlaylistSearchFragment playlistSearchFragment0) {
        return (G2)playlistSearchFragment0.getBinding();
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(PlaylistSearchFragment playlistSearchFragment0) {
        return (PlaylistSharedViewModel)playlistSearchFragment0.i.getValue();
    }

    public static final PlaylistSongBaseTiaraLogHelper access$getTiaraLogHelper(PlaylistSearchFragment playlistSearchFragment0) {
        return ((PlaylistSearchViewModel)playlistSearchFragment0.getViewModel()).getTiaraLogHelper();
    }

    public static final PlaylistSearchViewModel access$getViewModel(PlaylistSearchFragment playlistSearchFragment0) {
        return (PlaylistSearchViewModel)playlistSearchFragment0.getViewModel();
    }

    public static final void access$performShowMoreContextPopup(PlaylistSearchFragment playlistSearchFragment0, Playable playable0, Uri uri0) {
        playlistSearchFragment0.getClass();
        BuildersKt__Builders_commonKt.launch$default(f0.f(playlistSearchFragment0), null, null, new PlaylistSearchFragment.performShowMoreContextPopup.1(playable0, playlistSearchFragment0, uri0, null), 3, null);
    }

    @Override  // com.melon.ui.c0
    @NotNull
    public f1 getInsetHandlingType() {
        return this.k;
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        q.m("playerUiHelper");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        q.m("playlistManager");
        throw null;
    }

    @NotNull
    public final Pc.d getStringProvider() {
        Pc.d d0 = this.stringProvider;
        if(d0 != null) {
            return d0;
        }
        q.m("stringProvider");
        throw null;
    }

    public void getTiaraEventBuilder(@Nullable Context context0, @Nullable String s, @NotNull k k0) {
        q.g(k0, "action");
        this.e.v(context0, s, k0);
    }

    @NotNull
    public G2 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D059C, null, false);  // layout:playlist_search_mode_layout
        int v = 0x7F0A01A7;  // id:btn_search_cancel
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A01A7);  // id:btn_search_cancel
        if(melonTextView0 != null) {
            v = 0x7F0A09D3;  // id:recyclerview
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D3);  // id:recyclerview
            if(recyclerView0 != null) {
                v = 0x7F0A0A36;  // id:search_bar
                SearchBarView searchBarView0 = (SearchBarView)I.C(view0, 0x7F0A0A36);  // id:search_bar
                if(searchBarView0 != null && ((ConstraintLayout)I.C(view0, 0x7F0A0A41)) != null) {  // id:search_input_layout
                    return new G2(((ConstraintLayout)view0), melonTextView0, recyclerView0, searchBarView0);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return PlaylistSearchViewModel.class;
    }

    @Override  // com.melon.ui.a
    public void handleAddPlayUiEvent(@NotNull l0 l00, @NotNull com.melon.ui.b b0, @Nullable Context context0, @NotNull k k0, @NotNull CoroutineScope coroutineScope0) {
        q.g(l00, "fragmentManager");
        q.g(b0, "event");
        q.g(k0, "sendUserEvent");
        q.g(coroutineScope0, "coroutineScope");
        this.f.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public void handleMoreListPopupOnEvent(@NotNull androidx.fragment.app.I i0, @NotNull k k0, @Nullable Q q0, @NotNull k2 k20) {
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        q.g(k20, "event");
        this.e.x(i0, k0, q0, k20);
    }

    @Override  // com.melon.ui.M2
    public void handleMorePopupUiEvent(@NotNull m2 m20, @NotNull androidx.fragment.app.I i0, @Nullable o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.e.handleMorePopupUiEvent(m20, i0, o0);
    }

    @Override  // com.melon.ui.k3
    public void handlePutPopupUiEvent(@NotNull o3 o30, @NotNull androidx.fragment.app.I i0, @Nullable we.a a0, @NotNull k k0, boolean z, @Nullable we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.d.handlePutPopupUiEvent(o30, i0, a0, k0, z, a1);
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    @Override  // com.melon.ui.J0
    public void onDestroyView() {
        G2 g20 = (G2)this.getBinding();
        if(g20 != null) {
            RecyclerView recyclerView0 = g20.c;
            if(recyclerView0 != null) {
                recyclerView0.removeOnScrollListener(this.l);
            }
        }
        super.onDestroyView();
    }

    @Override  // com.melon.ui.c0
    public void onResume() {
        super.onResume();
        if(this.isVisible()) {
            n0.performPvLoggingOnForeground$default(this.getViewModel(), "playlistSearchResults", null, 2, null);
        }
    }

    @Override  // com.melon.ui.c0
    public void onStop() {
        super.onStop();
        Job job0 = this.j;
        View view0 = null;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        Context context0 = this.getContext();
        G2 g20 = (G2)this.getBinding();
        if(g20 != null) {
            SearchBarView searchBarView0 = g20.d;
            if(searchBarView0 != null) {
                view0 = searchBarView0.getInputTextView();
            }
        }
        InputMethodUtils.hideInputMethod(context0, view0);
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof e0) {
            ((PlaylistSharedViewModel)this.i.getValue()).updateFocusingTabTiaraProperty(((e0)i40).a);
            ((PlaylistSearchViewModel)this.getViewModel()).getTiaraLogHelper().setTiaraProperty(((e0)i40).a);
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            h h0 = this.getPlayerUiHelper();
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            h0.e(l00, ((ShowSelectionRepeatInterruptPopup)i40).getOkAction());
            return;
        }
        if(i40 instanceof PlaylistDeleteUiEvent) {
            Object object0 = this.g.getValue();
            Pc.d d0 = this.getStringProvider();
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            ((PlaylistDeleteUiEventHelper)object0).handleUiEvent(((PlaylistDeleteUiEvent)i40), d0, l01, this.getPlayerUiHelper(), new k(0, PlaylistSearchFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((PlaylistSearchFragment)this.receiver).sendUserEvent(e0);
                }
            });
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l02 = this.getChildFragmentManager();
            q.f(l02, "getChildFragmentManager(...)");
            a.f(this, l02, ((com.melon.ui.b)i40), this.getContext(), new k(0, PlaylistSearchFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((PlaylistSearchFragment)this.receiver).sendUserEvent(e0);
                }
            });
            AddResult addResult0 = ((com.melon.ui.b)i40).a;
            if(addResult0 instanceof Success && ((Success)addResult0).getRequestAddResult().b() == PlaylistId.MIX_UP) {
                EventBusHelper.post(EventMixUpPlaylistViewFocus.INSTANCE);
            }
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
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new com.iloen.melon.fragments.mymusic.dna.d(21), new k(0, PlaylistSearchFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((PlaylistSearchFragment)this.receiver).sendUserEvent(e0);
                }
            }, true, 0x20);
            return;
        }
        if(i40 instanceof t4) {
            ToastManager.show(((t4)i40).a);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        G2 g20 = (G2)this.getBinding();
        if(g20 == null) {
            return;
        }
        PlaylistSearchAdapter playlistSearchFragment$PlaylistSearchAdapter0 = new PlaylistSearchAdapter(this);
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(g20.c.getContext());
        g20.c.setLayoutManager(linearLayoutManager0);
        g20.c.setAdapter(playlistSearchFragment$PlaylistSearchAdapter0);
        g20.c.setClipToPadding(false);
        g20.c.addOnScrollListener(this.l);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        this.j = BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(g20, null) {
            public final G2 B;
            public int r;
            public final PlaylistSearchFragment w;

            {
                this.w = playlistSearchFragment0;
                this.B = g20;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.2(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        if(DelayKt.delay(100L, this) == a0) {
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
                InputMethodUtils.showInputMethod(this.w.getContext(), this.B.d.getInputTextView());
                return H.a;
            }
        }, 3, null);
        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.3 playlistSearchFragment$onViewCreated$30 = new V0() {
            public final PlaylistSearchFragment a;
            public final G2 b;

            {
                PlaylistSearchFragment playlistSearchFragment0 = g20;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = playlistSearchFragment0;
                this.b = g20;
            }

            @Override  // com.iloen.melon.custom.Y
            public void onActionClick(InputBarView inputBarView0) {
                q.g(inputBarView0, "view");
            }

            @Override  // com.iloen.melon.custom.Y
            public void onClearClick(InputBarView inputBarView0) {
                q.g(inputBarView0, "view");
                LogU.debug$default(this.a.h, "onClearClick", null, false, 6, null);
                this.search("", false);
                this.b.c.stopScroll();
            }

            @Override  // com.iloen.melon.custom.V0
            public void onClearKeyword(SearchBarView searchBarView0) {
                q.g(searchBarView0, "view");
                LogU.debug$default(this.a.h, "onClearKeyword", null, false, 6, null);
                this.search("", false);
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchClick(SearchBarView searchBarView0, String s) {
                q.g(searchBarView0, "view");
                q.g(s, "keyword");
                LogU.debug$default(this.a.h, "onSearchClick", null, false, 6, null);
                this.search(s, true);
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
                q.g(searchBarView0, "view");
                q.g(s, "keyword");
                LogU.debug$default(this.a.h, "onSearchKeyword", null, false, 6, null);
                this.search(s, false);
            }

            public final void search(String s, boolean z) {
                q.g(s, "keyword");
                PlaylistSearchFragment.access$getViewModel(this.a).updateKeyword(s);
                PlaylistSearchFragment.access$getViewModel(this.a).updateIsDone(z);
            }

            public static void search$default(com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.3 playlistSearchFragment$onViewCreated$30, String s, boolean z, int v, Object object0) {
                if((v & 1) != 0) {
                    s = "";
                }
                playlistSearchFragment$onViewCreated$30.search(s, z);
            }
        };
        g20.d.setOnSearchBarListener(playlistSearchFragment$onViewCreated$30);
        String s = this.getContext() == null ? null : "검색모드 취소";
        ViewUtils.setContentDescriptionWithClassName(g20.b, s, "android.widget.Button", null);
        g20.b.setOnClickListener(new com.iloen.melon.player.playlist.search.a(this, 0));
        playlistSearchFragment$PlaylistSearchAdapter0.registerAdapterDataObserver(new androidx.recyclerview.widget.l0() {
            public final G2 a;

            {
                this.a = g20;
            }

            @Override  // androidx.recyclerview.widget.l0
            public void onChanged() {
                this.a.c.scrollToPosition(0);
            }

            @Override  // androidx.recyclerview.widget.l0
            public void onItemRangeInserted(int v, int v1) {
                this.a.c.scrollToPosition(0);
            }
        });
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(null) {
            public int r;
            public final PlaylistSearchFragment w;

            {
                this.w = playlistSearchFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        t t0 = this.w.getViewLifecycleOwner().getLifecycle();
                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1 playlistSearchFragment$onViewCreated$6$10 = new n(null) {
                            public int r;
                            public final PlaylistSearchFragment w;

                            {
                                this.w = playlistSearchFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = PlaylistSearchFragment.access$getSharedViewModel(this.w).getDrawerTabInfo();
                                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1.1 playlistSearchFragment$onViewCreated$6$1$10 = new n(null) {
                                            public Object r;
                                            public final PlaylistSearchFragment w;

                                            {
                                                this.w = playlistSearchFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(DrawerPlaylistTabInfo drawerPlaylistTabInfo0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.6.1.1)this.create(drawerPlaylistTabInfo0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((DrawerPlaylistTabInfo)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                DrawerPlaylistTabInfo drawerPlaylistTabInfo0 = (DrawerPlaylistTabInfo)this.r;
                                                d5.n.D(object0);
                                                OnChangeDrawerPlaylistInfo playlistSearchUserEvent$OnChangeDrawerPlaylistInfo0 = new OnChangeDrawerPlaylistInfo(drawerPlaylistTabInfo0.getPlaylist());
                                                this.w.sendUserEvent(playlistSearchUserEvent$OnChangeDrawerPlaylistInfo0);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, playlistSearchFragment$onViewCreated$6$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.i(t0, androidx.lifecycle.s.d, playlistSearchFragment$onViewCreated$6$10, this) == a0 ? a0 : H.a;
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
        D d2 = this.getViewLifecycleOwner();
        q.f(d2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d2), null, null, new n(playlistSearchFragment$PlaylistSearchAdapter0, this, null) {
            public final G2 B;
            public final PlaylistSearchAdapter D;
            public int r;
            public final PlaylistSearchFragment w;

            {
                this.w = playlistSearchFragment0;
                this.B = g20;
                this.D = playlistSearchFragment$PlaylistSearchAdapter0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7(this.B, this.D, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        t t0 = this.w.getViewLifecycleOwner().getLifecycle();
                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1 playlistSearchFragment$onViewCreated$7$10 = new n(this.D, this.w, null) {
                            public final G2 B;
                            public final PlaylistSearchAdapter D;
                            public int r;
                            public final PlaylistSearchFragment w;

                            {
                                this.w = playlistSearchFragment0;
                                this.B = g20;
                                this.D = playlistSearchFragment$PlaylistSearchAdapter0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1(this.B, this.D, this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = PlaylistSearchFragment.access$getViewModel(this.w).getUiListStateFlow();
                                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1.1 playlistSearchFragment$onViewCreated$7$1$10 = new n(this.D, this.w, null) {
                                            public final G2 B;
                                            public final PlaylistSearchAdapter D;
                                            public final PlaylistSearchFragment E;
                                            public int r;
                                            public Object w;

                                            {
                                                this.B = g20;
                                                this.D = playlistSearchFragment$PlaylistSearchAdapter0;
                                                this.E = playlistSearchFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1.1(this.B, this.D, this.E, continuation0);
                                                continuation1.w = object0;
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((List)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(List list0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.7.1.1)this.create(list0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                RecyclerView recyclerView0 = this.B.c;
                                                List list0 = (List)this.w;
                                                ne.a a0 = ne.a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        recyclerView0.stopScroll();
                                                        ArrayList arrayList0 = new ArrayList(list0);
                                                        this.D.submitList(arrayList0);
                                                        this.w = list0;
                                                        this.r = 1;
                                                        if(DelayKt.delay(500L, this) == a0) {
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
                                                recyclerView0.announceForAccessibility(list0.size() + (this.E.getContext() == null ? null : "개의 검색결과 제안"));
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, playlistSearchFragment$onViewCreated$7$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.i(t0, androidx.lifecycle.s.d, playlistSearchFragment$onViewCreated$7$10, this) == a0 ? a0 : H.a;
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
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new n(g20, null) {
            public final G2 B;
            public int r;
            public final PlaylistSearchFragment w;

            {
                this.w = playlistSearchFragment0;
                this.B = g20;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        t t0 = this.w.getViewLifecycleOwner().getLifecycle();
                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1 playlistSearchFragment$onViewCreated$8$10 = new n(this.B, null) {
                            public final G2 B;
                            public int r;
                            public final PlaylistSearchFragment w;

                            {
                                this.w = playlistSearchFragment0;
                                this.B = g20;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1(this.w, this.B, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = PlaylistSearchFragment.access$getViewModel(this.w).isDone();
                                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1.1 playlistSearchFragment$onViewCreated$8$1$10 = new n(null) {
                                            public final G2 r;

                                            {
                                                this.r = g20;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.8.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                this.r.c.stopScroll();
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, playlistSearchFragment$onViewCreated$8$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.i(t0, androidx.lifecycle.s.d, playlistSearchFragment$onViewCreated$8$10, this) == a0 ? a0 : H.a;
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
        D d4 = this.getViewLifecycleOwner();
        q.f(d4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d4), null, null, new n(null) {
            public int r;
            public final PlaylistSearchFragment w;

            {
                this.w = playlistSearchFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        t t0 = this.w.getViewLifecycleOwner().getLifecycle();
                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1 playlistSearchFragment$onViewCreated$9$10 = new n(null) {
                            public int r;
                            public final PlaylistSearchFragment w;

                            {
                                this.w = playlistSearchFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        kotlinx.coroutines.flow.Flow flow0 = PlaylistSearchFragment.access$getViewModel(this.w).getSearchCloseEventFlow();
                                        com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1.1 playlistSearchFragment$onViewCreated$9$1$10 = new n(null) {
                                            public final PlaylistSearchFragment r;

                                            {
                                                this.r = playlistSearchFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1.1(this.r, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchFragment.onViewCreated.9.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d5.n.D(object0);
                                                PlaylistSearchFragment.access$closeSearchMode(this.r);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(flow0, playlistSearchFragment$onViewCreated$9$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.i(t0, androidx.lifecycle.s.d, playlistSearchFragment$onViewCreated$9$10, this) == a0 ? a0 : H.a;
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

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
    }

    @Override  // com.melon.ui.c0
    public void setInsetHandlingType(@NotNull f1 f10) {
        q.g(f10, "<set-?>");
        this.k = f10;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void setStringProvider(@NotNull Pc.d d0) {
        q.g(d0, "<set-?>");
        this.stringProvider = d0;
    }

    @Override  // com.melon.ui.k3
    public void showContextMenuAddTo(@NotNull androidx.fragment.app.I i0, @NotNull String s, @NotNull List list0, @Nullable we.a a0, @NotNull k k0, boolean z, @NotNull String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        q.g(s1, "ocrGroupId");
        this.d.showContextMenuAddTo(i0, s, list0, a0, k0, z, s1);
    }

    public void showContextMorePopup(@NotNull androidx.fragment.app.I i0, @NotNull Q q0, @Nullable k k0) {
        q.g(i0, "fragment");
        q.g(q0, "popupType");
        this.e.z(i0, q0, k0);
    }

    public void showContextPopupSongType(@NotNull Playable playable0, @NotNull androidx.fragment.app.I i0, @Nullable String s, @NotNull k k0) {
        q.g(playable0, "playable");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.e.A(playable0, i0, s, k0);
    }
}

