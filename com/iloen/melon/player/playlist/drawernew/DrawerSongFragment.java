package com.iloen.melon.player.playlist.drawernew;

import Bc.h;
import H8.i;
import J8.D2;
import K.m;
import Q0.k0;
import R6.d;
import S2.c;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.runtime.p;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.s;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventMixUpPlaylistViewFocus;
import com.iloen.melon.eventbus.EventSongPlaylistViewFocus;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddResult.Success;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.PlaylistTab;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEvent;
import com.iloen.melon.player.playlist.common.PlaylistDeleteUiEventHelper;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListItemData;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e0;
import com.melon.ui.e;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.o1;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.q4;
import com.melon.ui.t4;
import com.melon.ui.u4;
import com.melon.ui.x4;
import d3.g;
import ie.H;
import ie.r;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import nc.C0;
import nc.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;
import we.o;
import zd.Q;

@Metadata(d1 = {"\u0000\u00DE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 q2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0001qB\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\tH\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0019\u0010\bJ\u000F\u0010\u001A\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001A\u0010\bJ\u000F\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010 \u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J\u0017\u0010$\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b&\u0010\bJ\\\u00102\u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020\'2\u0006\u0010)\u001A\u00020(2\u000E\u0010+\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010*2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00120,2\u0006\u00100\u001A\u00020/2\u000E\u00101\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010*H\u0096\u0001\u00A2\u0006\u0004\b2\u00103Jb\u00109\u001A\u00020\u00122\u0006\u0010)\u001A\u00020(2\u0006\u00104\u001A\u00020\u001B2\f\u00107\u001A\b\u0012\u0004\u0012\u000206052\u000E\u0010+\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010*2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00120,2\u0006\u00100\u001A\u00020/2\u0006\u00108\u001A\u00020\u001BH\u0096\u0001\u00A2\u0006\u0004\b9\u0010:JF\u0010>\u001A\u00020\u00122\u0006\u0010\u001F\u001A\u00020;2\u0006\u0010)\u001A\u00020(2$\u0010=\u001A \u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0012\u0018\u00010<H\u0096\u0001\u00A2\u0006\u0004\b>\u0010?J6\u0010D\u001A\u00020\u00122\u0006\u0010)\u001A\u00020(2\u0006\u0010A\u001A\u00020@2\u0014\u0010C\u001A\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u0012\u0018\u00010,H\u0096\u0001\u00A2\u0006\u0004\bD\u0010EJ>\u0010G\u001A\u00020\u00122\u0006\u0010F\u001A\u0002062\u0006\u0010)\u001A\u00020(2\b\u00104\u001A\u0004\u0018\u00010\u001B2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00120,H\u0096\u0001\u00A2\u0006\u0004\bG\u0010HJ>\u0010I\u001A\u00020\u00122\u0006\u0010)\u001A\u00020(2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00120,2\b\u0010A\u001A\u0004\u0018\u00010@2\u0006\u0010\u001F\u001A\u00020BH\u0096\u0001\u00A2\u0006\u0004\bI\u0010JJ8\u0010O\u001A\u00020\u00122\b\u0010L\u001A\u0004\u0018\u00010K2\b\u00104\u001A\u0004\u0018\u00010\u001B2\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020M0,H\u0096\u0001\u00A2\u0006\u0004\bO\u0010PJF\u0010V\u001A\u00020\u00122\u0006\u0010R\u001A\u00020Q2\u0006\u0010\u001F\u001A\u00020S2\b\u0010L\u001A\u0004\u0018\u00010K2\u0012\u0010.\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00120,2\u0006\u0010U\u001A\u00020TH\u0096\u0001\u00A2\u0006\u0004\bV\u0010WR\"\u0010Y\u001A\u00020X8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001A\u00020_8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b`\u0010a\u001A\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010m\u001A\u00020f8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001A\u0010n\u001A\u00020/8\u0016X\u0096D\u00A2\u0006\f\n\u0004\bn\u0010o\u001A\u0004\bn\u0010p\u00A8\u0006r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragment;", "Lcom/melon/ui/o1;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragmentViewModel;", "LJ8/D2;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/D2;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "updateFragment", "onResume", "", "getPvDummyLogAction", "()Ljava/lang/String;", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "onDestroyView", "Lcom/melon/ui/o3;", "Landroidx/fragment/app/I;", "fragment", "Lkotlin/Function0;", "afterAction", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "", "isNowPlayingList", "afterDismissAction", "handlePutPopupUiEvent", "(Lcom/melon/ui/o3;Landroidx/fragment/app/I;Lwe/a;Lwe/k;ZLwe/a;)V", "menuId", "", "Lcom/iloen/melon/playback/Playable;", "playableList", "ocrGroupId", "showContextMenuAddTo", "(Landroidx/fragment/app/I;Ljava/lang/String;Ljava/util/List;Lwe/a;Lwe/k;ZLjava/lang/String;)V", "Lcom/melon/ui/m2;", "Lkotlin/Function3;", "artistClickLogAction", "handleMorePopupUiEvent", "(Lcom/melon/ui/m2;Landroidx/fragment/app/I;Lwe/o;)V", "Lzd/Q;", "popupType", "Lcom/melon/ui/k2;", "onEvent", "showContextMorePopup", "(Landroidx/fragment/app/I;Lzd/Q;Lwe/k;)V", "playable", "showContextPopupSongType", "(Lcom/iloen/melon/playback/Playable;Landroidx/fragment/app/I;Ljava/lang/String;Lwe/k;)V", "handleMoreListPopupOnEvent", "(Landroidx/fragment/app/I;Lwe/k;Lzd/Q;Lcom/melon/ui/k2;)V", "Landroid/content/Context;", "context", "Lp8/f;", "action", "getTiaraEventBuilder", "(Landroid/content/Context;Ljava/lang/String;Lwe/k;)V", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/melon/ui/b;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "handleAddPlayUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/b;Landroid/content/Context;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "LPc/d;", "stringProvider", "LPc/d;", "getStringProvider", "()LPc/d;", "setStringProvider", "(LPc/d;)V", "Lcom/iloen/melon/custom/f1;", "k", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "isShowTabAndMiniPlayer", "Z", "()Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongFragment extends Hilt_DrawerSongFragment implements M2, a, k3 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragment$Companion;", "", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragment;", "newInstance", "()Lcom/iloen/melon/player/playlist/drawernew/DrawerSongFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DrawerSongFragment newInstance() {
            return new DrawerSongFragment();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[PlaylistId.values().length];
            try {
                arr_v[PlaylistId.MIX_UP.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistId.DRAWER.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DrawerSongFragment";
    public final p3 d;
    public final d e;
    public final e f;
    public final LogU g;
    public final i h;
    public ToolBar i;
    public final r j;
    public f1 k;
    @Inject
    public h playerUiHelper;
    @Inject
    public Pc.d stringProvider;

    static {
        DrawerSongFragment.Companion = new Companion(null);
        DrawerSongFragment.$stable = 8;
    }

    public DrawerSongFragment() {
        this.d = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new d(25);
        this.f = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "DrawerSongFragment", false, Category.UI, 2, null);
        De.d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.special..inlined.activityViewModels.default.1 drawerSongFragment$special$$inlined$activityViewModels$default$10 = new we.a() {
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
        com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.special..inlined.activityViewModels.default.2 drawerSongFragment$special$$inlined$activityViewModels$default$20 = new we.a(this) {
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
        this.h = new i(d0, drawerSongFragment$special$$inlined$activityViewModels$default$10, new we.a() {
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
        }, drawerSongFragment$special$$inlined$activityViewModels$default$20);
        this.j = g.Q(new com.iloen.melon.fragments.mymusic.dna.d(15));
        this.k = f1.b;
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(DrawerSongFragment drawerSongFragment0) {
        return (PlaylistSharedViewModel)drawerSongFragment0.h.getValue();
    }

    public static final DrawerSongTiaraLogHelper access$getTiaraLogHelper(DrawerSongFragment drawerSongFragment0) {
        return ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getTiaraLogHelper();
    }

    public static final DrawerSongFragmentViewModel access$getViewModel(DrawerSongFragment drawerSongFragment0) {
        return (DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel();
    }

    public static final void access$updateToolBar(DrawerSongFragment drawerSongFragment0, int v) {
        ToolBar toolBar0 = drawerSongFragment0.i;
        if(toolBar0 != null) {
            if(v > 0) {
                toolBar0.setOnToolBarAnimationListener(new DrawerSongFragment.updateToolBar.1.1(drawerSongFragment0));
                toolBar0.h(true);
                toolBar0.l(v);
                return;
            }
            toolBar0.setOnToolBarAnimationListener(new DrawerSongFragment.updateToolBar.1.2(drawerSongFragment0));
            toolBar0.h(false);
            toolBar0.d();
        }
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

    @Override  // com.melon.ui.o1
    @NotNull
    public String getPvDummyLogAction() {
        return ((DrawerSongFragmentViewModel)this.getViewModel()).getPvDummyLogAction();
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
    public D2 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return D2.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return DrawerSongFragmentViewModel.class;
    }

    @Override  // com.melon.ui.a
    public void handleAddPlayUiEvent(@NotNull l0 l00, @NotNull b b0, @Nullable Context context0, @NotNull k k0, @NotNull CoroutineScope coroutineScope0) {
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

    @Override  // com.melon.ui.o1
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        nc.a a0 = ((DrawerPlaylistTabInfo)((PlaylistSharedViewModel)this.h.getValue()).getDrawerTabInfo().getValue()).getPlaylist();
        ((DrawerSongFragmentViewModel)this.getViewModel()).updateInternalPlaylist(a0, "DrawerSongFragment, onCreate");
    }

    @Override  // com.melon.ui.J0
    public void onDestroyView() {
        super.onDestroyView();
        this.i = null;
        ((DrawerSongFragmentViewModel)this.getViewModel()).updateHasToolbarPadding(false);
        ((DrawerSongFragmentViewModel)this.getViewModel()).setIsDragging(false);
    }

    @Override  // com.melon.ui.c0
    public void onResume() {
        super.onResume();
        if(this.isVisible()) {
            ((DrawerSongFragmentViewModel)this.getViewModel()).onFragmentResumed();
            ((PlaylistSharedViewModel)this.h.getValue()).updateControllerVisibility(true);
        }
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof e0) {
            ((PlaylistSharedViewModel)this.h.getValue()).updateTiaraProperty(PlaylistTab.DRAWER, ((e0)i40).a);
            ((DrawerSongFragmentViewModel)this.getViewModel()).getTiaraLogHelper().setTiaraProperty(((e0)i40).a);
            return;
        }
        if(i40 instanceof OpenDrawerBottomSheet) {
            l0 l00 = this.getChildFragmentManager();
            com.iloen.melon.player.playlist.drawernew.k k0 = new com.iloen.melon.player.playlist.drawernew.k(this, 0);
            if(l00 == null || Y.z(MelonAppBase.Companion) || l00.T() || l00.K) {
                return;
            }
            l00.C();
            if(com.melon.ui.popup.b.b(l00, "DrawerBtmSheetFragment", null, null, 12) != null) {
                return;
            }
            DrawerBtmSheetFragment.Companion.newInstance(k0).show(l00, "DrawerBtmSheetFragment");
            return;
        }
        if(i40 instanceof OnShowMorePopup) {
            int v = ((OnShowMorePopup)i40).getIndex();
            boolean z = ((OnShowMorePopup)i40).isOwner();
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new DrawerSongFragment.showMorePopup.1(this, v, z, null), 3, null);
            return;
        }
        if(i40 instanceof Lb.b) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            l l0 = new l(i40, 0);
            PopupHelper.showConfirmPopup(fragmentActivity0, ((Lb.b)i40).a, ((Lb.b)i40).b, l0);
            return;
        }
        if(i40 instanceof Lb.a) {
            FragmentActivity fragmentActivity1 = this.getActivity();
            l l1 = new l(i40, 1);
            PopupHelper.showAlertPopup(fragmentActivity1, ((Lb.a)i40).a, ((Lb.a)i40).b, l1);
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            h h0 = this.getPlayerUiHelper();
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            h0.e(l01, ((ShowSelectionRepeatInterruptPopup)i40).getOkAction());
            return;
        }
        if(i40 instanceof PlaylistDeleteUiEvent) {
            Object object0 = this.j.getValue();
            Pc.d d0 = this.getStringProvider();
            l0 l02 = this.getChildFragmentManager();
            q.f(l02, "getChildFragmentManager(...)");
            ((PlaylistDeleteUiEventHelper)object0).handleUiEvent(((PlaylistDeleteUiEvent)i40), d0, l02, this.getPlayerUiHelper(), new k(0, DrawerSongFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((DrawerSongFragment)this.receiver).sendUserEvent(e0);
                }
            });
            return;
        }
        if(i40 instanceof b) {
            l0 l03 = this.getChildFragmentManager();
            q.f(l03, "getChildFragmentManager(...)");
            a.f(this, l03, ((b)i40), this.getContext(), new k(0, DrawerSongFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((DrawerSongFragment)this.receiver).sendUserEvent(e0);
                }
            });
            AddResult addResult0 = ((b)i40).a;
            if(addResult0 instanceof Success && ((Success)addResult0).getRequestAddResult().b() == PlaylistId.MIX_UP) {
                EventBusHelper.post(EventMixUpPlaylistViewFocus.INSTANCE);
            }
            return;
        }
        if(i40 instanceof u4) {
            Navigator.openUrl("", ((u4)i40).a, OpenType.FullScreen, ((u4)i40).b);
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new com.iloen.melon.player.playlist.drawernew.h(this, 6), new k(0, DrawerSongFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((DrawerSongFragment)this.receiver).sendUserEvent(e0);
                }
            }, false, 0x20);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof q4) {
            l0 l04 = this.getChildFragmentManager();
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l04, ((q4)i40).a, ((q4)i40).b, false, false, false, null, null, ((q4)i40).d, null, null, 0x6F8);
            return;
        }
        if(i40 instanceof t4) {
            ToastManager.show(((t4)i40).a);
            return;
        }
        if(i40 instanceof OnChangeLandingPlaylist) {
            if(this.isResumed()) {
                int v1 = WhenMappings.$EnumSwitchMapping$0[((OnChangeLandingPlaylist)i40).getLandingPlaylistId().ordinal()];
                if(v1 == 1) {
                    EventBusHelper.post(EventMixUpPlaylistViewFocus.INSTANCE);
                }
                else if(v1 != 2) {
                    EventBusHelper.post(EventSongPlaylistViewFocus.INSTANCE);
                }
            }
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
                public int r;
                public final DrawerSongFragment w;

                {
                    this.w = drawerSongFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.8(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.8)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            PlaylistSharedViewModel playlistSharedViewModel0 = DrawerSongFragment.access$getSharedViewModel(this.w);
                            this.r = 1;
                            return playlistSharedViewModel0.updateDrawerTabContentToPlaylistList(this) == a0 ? a0 : H.a;
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
        super.onUiEvent(i40);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.drawernew.DrawerSongFragment$onUiEvent$1$1", f = "DrawerSongFragment.kt", l = {200}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.1.1 extends oe.i implements n {
            public final DrawerPlaylistTabInfo B;
            public int r;
            public final DrawerSongFragment w;

            public com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.1.1(DrawerSongFragment drawerSongFragment0, DrawerPlaylistTabInfo drawerPlaylistTabInfo0, Continuation continuation0) {
                this.w = drawerSongFragment0;
                this.B = drawerPlaylistTabInfo0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.1.1(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onUiEvent.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        PlaylistSharedViewModel playlistSharedViewModel0 = DrawerSongFragment.access$getSharedViewModel(this.w);
                        this.r = 1;
                        return playlistSharedViewModel0.updateDrawerTabContentToSongWithTabInfo(this.B, this) == a0 ? a0 : H.a;
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

    }

    @Override  // com.melon.ui.J0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        boolean z;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final DrawerSongFragment w;

            {
                this.w = drawerSongFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1 drawerSongFragment$onViewCreated$1$10 = new n(null) {
                            public Object r;
                            public final DrawerSongFragment w;

                            {
                                this.w = drawerSongFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                                d5.n.D(object0);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                                    public int r;
                                    public final DrawerSongFragment w;

                                    {
                                        this.w = drawerSongFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                d5.n.D(object0);
                                                Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                                                    @Override  // kotlinx.coroutines.flow.Flow
                                                    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                                        com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.invokeSuspend..inlined.map.1.2 drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                                            public final Object emit(Object object0, Continuation continuation0) {
                                                                com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.invokeSuspend..inlined.map.1.2.1 drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10;
                                                                if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.invokeSuspend..inlined.map.1.2.1) {
                                                                    drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.invokeSuspend..inlined.map.1.2.1)continuation0;
                                                                    int v = drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10.w;
                                                                    if((v & 0x80000000) == 0) {
                                                                        drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                                            public Object r;
                                                                            public int w;

                                                                            @Override  // oe.a
                                                                            public final Object invokeSuspend(Object object0) {
                                                                                this.r = object0;
                                                                                this.w |= 0x80000000;
                                                                                return continuation0.emit(null, this);
                                                                            }
                                                                        };
                                                                    }
                                                                    else {
                                                                        drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                                                    }
                                                                }
                                                                else {
                                                                    drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                                        public Object r;
                                                                        public int w;

                                                                        @Override  // oe.a
                                                                        public final Object invokeSuspend(Object object0) {
                                                                            this.r = object0;
                                                                            this.w |= 0x80000000;
                                                                            return continuation0.emit(null, this);
                                                                        }
                                                                    };
                                                                }
                                                                Object object1 = drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10.r;
                                                                ne.a a0 = ne.a.a;
                                                                switch(drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10.w) {
                                                                    case 0: {
                                                                        d5.n.D(object1);
                                                                        int v1 = 0;
                                                                        if(!(((List)object0) instanceof Collection) || !((List)object0).isEmpty()) {
                                                                            for(Object object2: ((List)object0)) {
                                                                                if(((DrawerSongListItemData)object2).isSelected()) {
                                                                                    ++v1;
                                                                                    if(v1 < 0) {
                                                                                        e.k.N();
                                                                                        throw null;
                                                                                    }
                                                                                    if(false) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                                        return this.a.emit(new Integer(v1), drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                                                                    }
                                                                    case 1: {
                                                                        d5.n.D(object1);
                                                                        return H.a;
                                                                    }
                                                                    default: {
                                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        Object object0 = this.a.collect(drawerSongFragment$onViewCreated$1$1$1$invokeSuspend$$inlined$map$1$20, continuation0);
                                                        return object0 == ne.a.a ? object0 : H.a;
                                                    }
                                                });
                                                com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.2 drawerSongFragment$onViewCreated$1$1$1$20 = new n(null) {
                                                    public int r;
                                                    public final DrawerSongFragment w;

                                                    {
                                                        this.w = drawerSongFragment0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.2(this.w, continuation0);
                                                        continuation1.r = ((Number)object0).intValue();
                                                        return continuation1;
                                                    }

                                                    public final Object invoke(int v, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.onViewCreated.1.1.1.2)this.create(v, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        int v = this.r;
                                                        d5.n.D(object0);
                                                        DrawerSongFragment.access$updateToolBar(this.w, v);
                                                        return H.a;
                                                    }
                                                };
                                                this.r = 1;
                                                return FlowKt.collectLatest(flow0, drawerSongFragment$onViewCreated$1$1$1$20, this) == a0 ? a0 : H.a;
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
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return f0.j(d0, s.d, drawerSongFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
        D2 d20 = (D2)this.getBinding();
        if(d20 != null) {
            ToolBar toolBar0 = (ToolBar)d20.c.c;
            nc.a a0 = (nc.a)((DrawerSongFragmentViewModel)this.getViewModel()).getInternalPlaylist().getValue();
            if(a0 == null) {
                z = false;
            }
            else {
                C0 c00 = ((u0)a0).I();
                if(c00 == null) {
                    z = false;
                }
                else {
                    DrawerPlaylistInfo drawerPlaylistInfo0 = c00.g;
                    z = drawerPlaylistInfo0 == null ? false : drawerPlaylistInfo0.isOwner();
                }
            }
            ToolBar toolBar1 = ToolBar.f(toolBar0, (z ? 1007 : 1009));
            toolBar1.setOnToolBarListener(new j(this));
            this.i = toolBar1;
        }
    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
        D2 d20 = (D2)this.getBinding();
        if(d20 == null) {
            return;
        }
        m0.b b0 = new m0.b(0x56FDE70C, new com.iloen.melon.player.playlist.drawernew.a(this, k40, 3), true);
        d20.b.setContent(b0);

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.renderUi.lambda.39.lambda.38.lambda.37.lambda.36..inlined.noRippleClickable-YQRRFTQ.default.1 implements o {
            public com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.renderUi.lambda.39.lambda.38.lambda.37.lambda.36..inlined.noRippleClickable-YQRRFTQ.default.1(boolean z, String s, int v) {
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((r0.q)object0), ((androidx.compose.runtime.l)object1), ((Number)object2).intValue());
            }

            public final r0.q invoke(r0.q q0, androidx.compose.runtime.l l0, int v) {
                q.g(q0, "$this$composed");
                ((p)l0).a0(0x1FF03545);
                w0.h h0 = (w0.h)((p)l0).k(k0.i);
                m m0 = ((p)l0).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)l0));
                }
                X0.i i0 = new X0.i(this.c);
                com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.renderUi.lambda.39.lambda.38.lambda.37.lambda.36..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerSongFragment$renderUi$lambda$39$lambda$38$lambda$37$lambda$36$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                    @Override  // we.a
                    public Object invoke() {
                        this.invoke();
                        return H.a;
                    }

                    public final void invoke() {
                        w0.h.a(this.a);
                    }
                };
                r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, this.a, this.b, i0, drawerSongFragment$renderUi$lambda$39$lambda$38$lambda$37$lambda$36$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                ((p)l0).p(false);
                return q1;
            }
        }

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

    public final void updateFragment() {
        nc.a a0 = ((DrawerPlaylistTabInfo)((PlaylistSharedViewModel)this.h.getValue()).getDrawerTabInfo().getValue()).getPlaylist();
        ((DrawerSongFragmentViewModel)this.getViewModel()).updateInternalPlaylist(a0, "DrawerSongFragment, updateFragment");
        o1.loadPage$default(this, true, null, 2, null);
    }
}

