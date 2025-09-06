package com.iloen.melon.player.playlist.music;

import Bc.h;
import H8.i;
import J8.D2;
import R6.d;
import S2.c;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.runtime.l;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventMixUpPlaylistViewFocus;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.PlaylistTab;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEvent;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEventHelper;
import com.iloen.melon.player.playlist.tiara.PlaylistSongBaseTiaraLogHelper;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.I4;
import com.melon.ui.J0;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e0;
import com.melon.ui.e;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.x4;
import d3.g;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;
import zd.Q;

@Metadata(d1 = {"\u0000\u00E4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u0000 v*\b\b\u0000\u0010\u0002*\u00020\u00012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u0007:\u0001vB\u0007\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ!\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0012H\'\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001D\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001F\u0010\tJ\u000F\u0010 \u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b \u0010\tJ\\\u0010,\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020!2\u0006\u0010#\u001A\u00020\"2\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00120&2\u0006\u0010*\u001A\u00020)2\u000E\u0010+\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$H\u0096\u0001\u00A2\u0006\u0004\b,\u0010-Jb\u00104\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"2\u0006\u0010/\u001A\u00020.2\f\u00102\u001A\b\u0012\u0004\u0012\u000201002\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00120&2\u0006\u0010*\u001A\u00020)2\u0006\u00103\u001A\u00020.H\u0096\u0001\u00A2\u0006\u0004\b4\u00105JF\u00109\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u0002062\u0006\u0010#\u001A\u00020\"2$\u00108\u001A \u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0012\u0018\u000107H\u0096\u0001\u00A2\u0006\u0004\b9\u0010:J6\u0010?\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"2\u0006\u0010<\u001A\u00020;2\u0014\u0010>\u001A\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0012\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b?\u0010@J>\u0010B\u001A\u00020\u00122\u0006\u0010A\u001A\u0002012\u0006\u0010#\u001A\u00020\"2\b\u0010/\u001A\u0004\u0018\u00010.2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00120&H\u0096\u0001\u00A2\u0006\u0004\bB\u0010CJ>\u0010D\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00120&2\b\u0010<\u001A\u0004\u0018\u00010;2\u0006\u0010\u001C\u001A\u00020=H\u0096\u0001\u00A2\u0006\u0004\bD\u0010EJ8\u0010J\u001A\u00020\u00122\b\u0010G\u001A\u0004\u0018\u00010F2\b\u0010/\u001A\u0004\u0018\u00010.2\u0012\u0010I\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020H0&H\u0096\u0001\u00A2\u0006\u0004\bJ\u0010KJF\u0010Q\u001A\u00020\u00122\u0006\u0010M\u001A\u00020L2\u0006\u0010\u001C\u001A\u00020N2\b\u0010G\u001A\u0004\u0018\u00010F2\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00120&2\u0006\u0010P\u001A\u00020OH\u0096\u0001\u00A2\u0006\u0004\bQ\u0010RR\"\u0010T\u001A\u00020S8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bT\u0010U\u001A\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010[\u001A\u00020Z8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b[\u0010\\\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001A\u0010f\u001A\u00020a8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\bb\u0010c\u001A\u0004\bd\u0010eR\"\u0010n\u001A\u00020g8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0014\u0010r\u001A\u00020o8DX\u0084\u0004\u00A2\u0006\u0006\u001A\u0004\bp\u0010qR\u001A\u0010s\u001A\u00020)8\u0016X\u0096D\u00A2\u0006\f\n\u0004\bs\u0010t\u001A\u0004\bs\u0010u\u00A8\u0006w"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseFragment;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseViewModel;", "VM", "Lcom/melon/ui/J0;", "LJ8/D2;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/D2;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "UiWhenPlaylistEmpty", "(Landroidx/compose/runtime/l;I)V", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "onResume", "onDestroyView", "Lcom/melon/ui/o3;", "Landroidx/fragment/app/I;", "fragment", "Lkotlin/Function0;", "afterAction", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "", "isNowPlayingList", "afterDismissAction", "handlePutPopupUiEvent", "(Lcom/melon/ui/o3;Landroidx/fragment/app/I;Lwe/a;Lwe/k;ZLwe/a;)V", "", "menuId", "", "Lcom/iloen/melon/playback/Playable;", "playableList", "ocrGroupId", "showContextMenuAddTo", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/util/List;Lwe/a;Lwe/k;ZLjava/lang/String;)V", "Lcom/melon/ui/m2;", "Lkotlin/Function3;", "artistClickLogAction", "handleMorePopupUiEvent", "(Lcom/melon/ui/m2;Landroidx/fragment/app/I;Lwe/o;)V", "Lzd/Q;", "popupType", "Lcom/melon/ui/k2;", "onEvent", "showContextMorePopup", "(Landroidx/fragment/app/I;Lzd/Q;Lwe/k;)V", "playable", "showContextPopupSongType", "(Lcom/iloen/melon/playback/Playable;Landroidx/fragment/app/I;Ljava/lang/String;Lwe/k;)V", "handleMoreListPopupOnEvent", "(Landroidx/fragment/app/I;Lwe/k;Lzd/Q;Lcom/melon/ui/k2;)V", "Landroid/content/Context;", "context", "Lp8/f;", "action", "getTiaraEventBuilder", "(Landroid/content/Context;Ljava/lang/String;Lwe/k;)V", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/melon/ui/b;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "handleAddPlayUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/b;Landroid/content/Context;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "LPc/d;", "stringProvider", "LPc/d;", "getStringProvider", "()LPc/d;", "setStringProvider", "(LPc/d;)V", "Lcom/iloen/melon/utils/log/LogU;", "d", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/custom/f1;", "j", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/PlaylistSongBaseTiaraLogHelper;", "tiaraLogHelper", "isShowTabAndMiniPlayer", "Z", "()Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicPlaylistBaseFragment extends J0 implements M2, a, k3 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MusicPlaylistBaseFragment";
    public final p3 a;
    public final d b;
    public final e c;
    public final LogU d;
    public final i e;
    public final r f;
    public ToolBar g;
    public final r h;
    public final r i;
    public f1 j;
    @Inject
    public h playerUiHelper;
    @Inject
    public Pc.d stringProvider;

    static {
        MusicPlaylistBaseFragment.Companion = new Companion(null);
        MusicPlaylistBaseFragment.$stable = 8;
    }

    public MusicPlaylistBaseFragment() {
        this.a = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new d(25);
        this.c = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.d = LogU.Companion.create("MusicPlaylistBaseFragment", true, Category.UI);
        De.d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.special..inlined.activityViewModels.default.1 musicPlaylistBaseFragment$special$$inlined$activityViewModels$default$10 = new we.a() {
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
        com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.special..inlined.activityViewModels.default.2 musicPlaylistBaseFragment$special$$inlined$activityViewModels$default$20 = new we.a(this) {
            public final we.a f;
            public final androidx.fragment.app.I g;

            {
                this.f = a0;
                this.g = i0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                we.a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    return c0 == null ? this.g.requireActivity().getDefaultViewModelCreationExtras() : c0;
                }
                return this.g.requireActivity().getDefaultViewModelCreationExtras();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.e = new i(d0, musicPlaylistBaseFragment$special$$inlined$activityViewModels$default$10, new we.a() {
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
        }, musicPlaylistBaseFragment$special$$inlined$activityViewModels$default$20);
        this.f = g.Q(new com.iloen.melon.fragments.mymusic.dna.d(18));
        this.h = g.Q(new b(this, 5));
        this.i = g.Q(new b(this, 6));
        this.j = f1.b;
    }

    public abstract void UiWhenPlaylistEmpty(@Nullable l arg1, int arg2);

    public static final PlaylistSharedViewModel access$getSharedViewModel(MusicPlaylistBaseFragment musicPlaylistBaseFragment0) {
        return (PlaylistSharedViewModel)musicPlaylistBaseFragment0.e.getValue();
    }

    public static final MusicPlaylistBaseViewModel access$getViewModel(MusicPlaylistBaseFragment musicPlaylistBaseFragment0) {
        return (MusicPlaylistBaseViewModel)musicPlaylistBaseFragment0.getViewModel();
    }

    @Override  // com.melon.ui.c0
    @NotNull
    public f1 getInsetHandlingType() {
        return this.j;
    }

    @NotNull
    public final LogU getLog() {
        return this.d;
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
        this.b.v(context0, s, k0);
    }

    @NotNull
    public final PlaylistSongBaseTiaraLogHelper getTiaraLogHelper() {
        return ((MusicPlaylistBaseViewModel)this.getViewModel()).getTiaraLogHelper();
    }

    @NotNull
    public D2 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return D2.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.a
    public void handleAddPlayUiEvent(@NotNull l0 l00, @NotNull com.melon.ui.b b0, @Nullable Context context0, @NotNull k k0, @NotNull CoroutineScope coroutineScope0) {
        q.g(l00, "fragmentManager");
        q.g(b0, "event");
        q.g(k0, "sendUserEvent");
        q.g(coroutineScope0, "coroutineScope");
        this.c.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public void handleMoreListPopupOnEvent(@NotNull androidx.fragment.app.I i0, @NotNull k k0, @Nullable Q q0, @NotNull k2 k20) {
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        q.g(k20, "event");
        this.b.x(i0, k0, q0, k20);
    }

    @Override  // com.melon.ui.M2
    public void handleMorePopupUiEvent(@NotNull m2 m20, @NotNull androidx.fragment.app.I i0, @Nullable o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.b.handleMorePopupUiEvent(m20, i0, o0);
    }

    @Override  // com.melon.ui.k3
    public void handlePutPopupUiEvent(@NotNull o3 o30, @NotNull androidx.fragment.app.I i0, @Nullable we.a a0, @NotNull k k0, boolean z, @Nullable we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.a.handlePutPopupUiEvent(o30, i0, a0, k0, z, a1);
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    @Override  // com.melon.ui.J0
    public void onDestroyView() {
        super.onDestroyView();
        this.g = null;
        ((MusicPlaylistBaseViewModel)this.getViewModel()).updateHasToolbarPadding(false);
        ((MusicPlaylistBaseViewModel)this.getViewModel()).setIsDragging(false);
    }

    @Override  // com.melon.ui.c0
    public void onResume() {
        super.onResume();
        if(this.isVisible()) {
            ((PlaylistSharedViewModel)this.e.getValue()).updateControllerVisibility(true);
            ((MusicPlaylistBaseViewModel)this.getViewModel()).unSelectAll();
            ((MusicPlaylistBaseViewModel)this.getViewModel()).performPvLoggingOnForeground();
        }
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        Success musicPlaylistUiState$Success0 = null;
        q.g(i40, "event");
        if(i40 instanceof e0) {
            ((PlaylistSharedViewModel)this.e.getValue()).updateTiaraProperty(PlaylistTab.MUSIC, ((e0)i40).a);
            this.getTiaraLogHelper().setTiaraProperty(((e0)i40).a);
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            h h0 = this.getPlayerUiHelper();
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            h0.e(l00, ((ShowSelectionRepeatInterruptPopup)i40).getOkAction());
            return;
        }
        if(i40 instanceof SortOrderListPopupEvent) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 == null) {
                return;
            }
            Dialog dialog0 = this.getRetainedDialog();
            if(dialog0 != null && dialog0.isShowing()) {
                return;
            }
            Object object0 = this.getViewModel().getUiState().getValue();
            if(object0 instanceof Success) {
                musicPlaylistUiState$Success0 = (Success)object0;
            }
            if(musicPlaylistUiState$Success0 == null) {
                return;
            }
            BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
            bottomSingleFilterListPopup0.setMaxPortraitHeight(((int)(((double)ScreenUtils.getScreenHeight(bottomSingleFilterListPopup0.getContext())) * 0.7)));
            String[] arr_s = (String[])this.i.getValue();
            bottomSingleFilterListPopup0.setFilterItem(e.k.A(Arrays.copyOf(arr_s, arr_s.length)), musicPlaylistUiState$Success0.getSortType().a);
            bottomSingleFilterListPopup0.setTitle("정렬");
            bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.player.playlist.music.d(this));
            this.setRetainDialog(bottomSingleFilterListPopup0);
            bottomSingleFilterListPopup0.show();
            return;
        }
        if(i40 instanceof ShowContextMenuAddToPopup) {
            String s = this.getViewModel().getMenuId();
            List list0 = ((ShowContextMenuAddToPopup)i40).getPlayables();
            com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment.onUiEvent.1 musicPlaylistBaseFragment$onUiEvent$10 = new k(0, MusicPlaylistBaseFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
                }
            };
            k3.c(this, this, s, list0, new com.iloen.melon.player.playlist.music.o(i40, this), musicPlaylistBaseFragment$onUiEvent$10, true, 0x40);
            return;
        }
        if(i40 instanceof PlaylistDeleteUiEvent) {
            Object object1 = this.f.getValue();
            Pc.d d0 = this.getStringProvider();
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            ((PlaylistDeleteUiEventHelper)object1).handleUiEvent(((PlaylistDeleteUiEvent)i40), d0, l01, this.getPlayerUiHelper(), new k(0, MusicPlaylistBaseFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
                }
            });
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l02 = this.getChildFragmentManager();
            q.f(l02, "getChildFragmentManager(...)");
            a.f(this, l02, ((com.melon.ui.b)i40), this.getContext(), new k(0, MusicPlaylistBaseFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
                }
            });
            AddResult addResult0 = ((com.melon.ui.b)i40).a;
            if(addResult0 instanceof com.iloen.melon.playback.playlist.add.AddResult.Success && ((com.iloen.melon.playback.playlist.add.AddResult.Success)addResult0).getRequestAddResult().b() == PlaylistId.MIX_UP) {
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
            k3.d(this, ((o3)i40), this, null, new k(0, MusicPlaylistBaseFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((MusicPlaylistBaseFragment)this.receiver).sendUserEvent(e0);
                }
            }, true, 0x20);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof Lb.b) {
            FragmentActivity fragmentActivity1 = this.getActivity();
            com.iloen.melon.player.playlist.music.e e0 = new com.iloen.melon.player.playlist.music.e(i40, 0);
            PopupHelper.showConfirmPopup(fragmentActivity1, ((Lb.b)i40).a, ((Lb.b)i40).b, e0);
            return;
        }
        if(i40 instanceof Lb.a) {
            FragmentActivity fragmentActivity2 = this.getActivity();
            com.iloen.melon.player.playlist.music.e e1 = new com.iloen.melon.player.playlist.music.e(i40, 1);
            PopupHelper.showAlertPopup(fragmentActivity2, ((Lb.a)i40).a, ((Lb.a)i40).b, e1);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D2 d20 = (D2)this.getBinding();
        if(d20 != null) {
            m0.b b0 = new m0.b(863430522, new com.iloen.melon.player.playlist.music.a(this, 0), true);
            d20.b.setContent(b0);
            D2 d21 = (D2)this.getBinding();
            if(d21 != null) {
                ToolBar toolBar0 = ToolBar.f(((ToolBar)d21.c.c), 1007);
                toolBar0.setOnToolBarListener(new com.iloen.melon.player.playlist.music.d(this));
                this.g = toolBar0;
            }
        }
    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
        Success musicPlaylistUiState$Success0 = null;
        MusicPlaylistUiState musicPlaylistUiState0 = k40 instanceof MusicPlaylistUiState ? ((MusicPlaylistUiState)k40) : null;
        if(musicPlaylistUiState0 != null) {
            if(musicPlaylistUiState0 instanceof Success) {
                musicPlaylistUiState$Success0 = (Success)musicPlaylistUiState0;
            }
            if(musicPlaylistUiState$Success0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: musicPlaylistUiState$Success0.getSongList()) {
                    if(((SongUiState)object0).isSelected()) {
                        arrayList0.add(object0);
                    }
                }
                boolean z = false;
                boolean z1 = false;
                int v = arrayList0.size();
                ToolBar toolBar0 = this.g;
                if(toolBar0 != null) {
                    if(v > 0) {
                        if(!arrayList0.isEmpty()) {
                            for(Object object1: arrayList0) {
                                if(!((SongUiState)object1).getPlayable().isOriginLocal()) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if(!arrayList0.isEmpty()) {
                            for(Object object2: arrayList0) {
                                if(((SongUiState)object2).getPlayable().hasSongId()) {
                                    z1 = true;
                                    break;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                        toolBar0.j(1, z);
                        toolBar0.j(2, z1);
                        toolBar0.setOnToolBarAnimationListener(new MusicPlaylistBaseFragment.updateToolBar.1.1(this));
                        toolBar0.h(true);
                        toolBar0.l(v);
                        return;
                    }
                    toolBar0.setOnToolBarAnimationListener(new MusicPlaylistBaseFragment.updateToolBar.1.2(this));
                    toolBar0.h(false);
                    toolBar0.d();
                }
            }
        }
    }

    @Override  // com.melon.ui.c0
    public void setInsetHandlingType(@NotNull f1 f10) {
        q.g(f10, "<set-?>");
        this.j = f10;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
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
        this.a.showContextMenuAddTo(i0, s, list0, a0, k0, z, s1);
    }

    public void showContextMorePopup(@NotNull androidx.fragment.app.I i0, @NotNull Q q0, @Nullable k k0) {
        q.g(i0, "fragment");
        q.g(q0, "popupType");
        this.b.z(i0, q0, k0);
    }

    public void showContextPopupSongType(@NotNull Playable playable0, @NotNull androidx.fragment.app.I i0, @Nullable String s, @NotNull k k0) {
        q.g(playable0, "playable");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.b.A(playable0, i0, s, k0);
    }
}

