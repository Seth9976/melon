package com.iloen.melon.player.playlist;

import Bc.h;
import Cc.x2;
import De.d;
import H0.e;
import H8.i;
import J8.H2;
import J8.i1;
import M6.B;
import R6.c;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.Barrier;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.s;
import androidx.viewpager.widget.j;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventCurPlaylistViewFocus;
import com.iloen.melon.eventbus.EventMixUpPlaylistViewFocus;
import com.iloen.melon.eventbus.EventPlaylistViewFocus;
import com.iloen.melon.eventbus.EventSongPlaylistViewFocus;
import com.iloen.melon.fragments.IFragmentContainer;
import com.iloen.melon.fragments.IPagerFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInformCntCheckReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.L3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.x3;
import e.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kc.D2;
import kc.Y2;
import kc.d3;
import kc.e1;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import vb.t;
import we.a;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u00B0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 ^2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0001^B\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\r\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000E\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u000BJ\u000F\u0010\u0010\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000BJ\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000BJ\u0015\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010!\u001A\u00020 2\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001A\u00020 2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020 H\u0016\u00A2\u0006\u0004\b\'\u0010\bJ\u0017\u0010*\u001A\u00020 2\u0006\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020 H\u0016\u00A2\u0006\u0004\b,\u0010\bJ\u000F\u0010-\u001A\u00020 H\u0016\u00A2\u0006\u0004\b-\u0010\bJ\u0017\u00100\u001A\u00020 2\u0006\u0010/\u001A\u00020.H\u0016\u00A2\u0006\u0004\b0\u00101J\u0017\u00103\u001A\u00020 2\u0006\u0010/\u001A\u000202H\u0007\u00A2\u0006\u0004\b3\u00104JV\u0010@\u001A\u00020 2\u0006\u0010/\u001A\u0002052\u0006\u00106\u001A\u00020\u00112\b\u00108\u001A\u0004\u0018\u0001072\u0006\u00109\u001A\u00020\t2\u000E\u0010<\u001A\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0012\u0010?\u001A\u000E\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020 0=H\u0096\u0001\u00A2\u0006\u0004\b@\u0010AR\"\u0010C\u001A\u00020B8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bC\u0010D\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001A\u00020I8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR \u0010<\u001A\b\u0012\u0004\u0012\u00020;0:8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bP\u0010Q\u001A\u0004\bR\u0010SR\"\u0010[\u001A\u00020T8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001A\u0010\\\u001A\u00020\t8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b\\\u0010]\u001A\u0004\b\\\u0010\u000B\u00A8\u0006_"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainFragment;", "Lcom/melon/ui/J0;", "Lcom/iloen/melon/player/playlist/PlaylistMainViewModel;", "LJ8/i1;", "", "Lcom/iloen/melon/fragments/IPagerFragment;", "Lcom/iloen/melon/fragments/IFragmentContainer;", "<init>", "()V", "", "isPlaylistFragment", "()Z", "isPlayerFragment", "isBringToFrontFragment", "isUseLoopViewPager", "isOffscreenLimitPager", "excludingTagArguments", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "shouldOnResume", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/i1;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "onStart", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onStop", "onDestroyView", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "Lcom/iloen/melon/eventbus/EventPlaylistViewFocus;", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPlaylistViewFocus;)V", "Lcom/melon/ui/x3;", "fragment", "Landroid/app/Activity;", "activity", "isLoginUser", "Le/b;", "Landroid/content/Intent;", "searchFriendActivityResultLauncher", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "handleShareSNSPopupUiEvent", "(Lcom/melon/ui/x3;Landroidx/fragment/app/I;Landroid/app/Activity;ZLe/b;Lwe/k;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "LCc/x2;", "playBgColorExtractor", "LCc/x2;", "getPlayBgColorExtractor", "()LCc/x2;", "setPlayBgColorExtractor", "(LCc/x2;)V", "l", "Le/b;", "getSearchFriendActivityResultLauncher", "()Le/b;", "Lcom/iloen/melon/custom/f1;", "m", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "isShowTabAndMiniPlayer", "Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistMainFragment extends Hilt_PlaylistMainFragment implements IFragmentContainer, IPagerFragment {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainFragment$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[PlaylistMainHeaderBtnState.values().length];
            try {
                arr_v[PlaylistMainHeaderBtnState.SEARCH.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistMainHeaderBtnState.PLAYLIST_ADD.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[PlaylistMainHeaderBtnState.NONE.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[M.values().length];
            try {
                arr_v1[33] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[34] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistMainFragment";
    public final c d;
    public final LogU e;
    public Job f;
    public final i g;
    public PlaylistViewPagerAdapter h;
    public final r i;
    public final r j;
    public final String k;
    public final b l;
    public f1 m;
    public final g n;
    @Inject
    public x2 playBgColorExtractor;
    @Inject
    public h playerUiHelper;

    static {
        PlaylistMainFragment.Companion = new Companion(null);
        PlaylistMainFragment.$stable = 8;
    }

    public PlaylistMainFragment() {
        this.d = new c(26);
        LogU logU0 = new LogU("PlaylistMainFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.e = logU0;
        d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.PlaylistMainFragment.special..inlined.activityViewModels.default.1 playlistMainFragment$special$$inlined$activityViewModels$default$10 = new a() {
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
        com.iloen.melon.player.playlist.PlaylistMainFragment.special..inlined.activityViewModels.default.2 playlistMainFragment$special$$inlined$activityViewModels$default$20 = new a(this) {
            public final a f;
            public final androidx.fragment.app.I g;

            {
                this.f = a0;
                this.g = i0;
                super(0);
            }

            @NotNull
            public final S2.c invoke() {
                a a0 = this.f;
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
        this.g = new i(d0, playlistMainFragment$special$$inlined$activityViewModels$default$10, new a() {
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
        }, playlistMainFragment$special$$inlined$activityViewModels$default$20);
        this.i = d3.g.Q(new k(this, 5));
        this.j = d3.g.Q(new k(this, 12));
        this.k = "PlaylistMainFragment";
        this.l = e.T(this, new we.k(0, PlaylistMainFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Pc.e)object0));
                return H.a;
            }

            public final void invoke(Pc.e e0) {
                q.g(e0, "p0");
                PlaylistMainFragment.access$sendUserEvent(((PlaylistMainFragment)this.receiver), e0);
            }
        });
        this.m = f1.b;
        this.n = new g(this, 0);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.PlaylistMainFragment$playlistPopupListener$1$1", f = "PlaylistMainFragment.kt", l = {684}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1 extends oe.i implements n {
            public int r;
            public final PlaylistMainFragment w;

            public com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1(PlaylistMainFragment playlistMainFragment0, Continuation continuation0) {
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        h h0 = this.w.getPlayerUiHelper();
                        l0 l00 = this.w.getChildFragmentManager();
                        q.f(l00, "getChildFragmentManager(...)");
                        s2 s20 = PlaylistMainFragment.access$getPlaylistManager(this.w);
                        k k0 = new k(this.w, 0);
                        this.r = 1;
                        return h0.f(l00, s20, k0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.player.playlist.PlaylistMainFragment$playlistPopupListener$1$1$1$1", f = "PlaylistMainFragment.kt", l = {689}, m = "invokeSuspend")
                final class com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1.1.1 extends oe.i implements n {
                    public int r;
                    public final PlaylistMainFragment w;

                    public com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1.1.1(PlaylistMainFragment playlistMainFragment0, Continuation continuation0) {
                        this.w = playlistMainFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1.1.1(this.w, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.PlaylistMainFragment.playlistPopupListener.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        PlaylistMainFragment playlistMainFragment0 = this.w;
                        switch(this.r) {
                            case 0: {
                                d5.n.D(object0);
                                d3 d30 = (d3)PlaylistMainFragment.access$getPlaylistManager(playlistMainFragment0);
                                D2 d20 = new D2(d30, null);
                                B b0 = ListenableFutureKt.future$default(d30.b, null, null, d20, 3, null);
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
                        d3 d31 = (d3)PlaylistMainFragment.access$getPlaylistManager(playlistMainFragment0);
                        Y2 y20 = new Y2(d31, !((Boolean)object0).booleanValue(), false, null);
                        ListenableFutureKt.future$default(d31.b, null, null, y20, 3, null);
                        return H.a;
                    }
                }

            }
        }

    }

    public static final i1 access$getBinding(PlaylistMainFragment playlistMainFragment0) {
        return (i1)playlistMainFragment0.getBinding();
    }

    public static final s2 access$getPlaylistManager(PlaylistMainFragment playlistMainFragment0) {
        return ((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getPlaylistManager();
    }

    public static final String access$getTabTitle(PlaylistMainFragment playlistMainFragment0, Integer integer0) {
        playlistMainFragment0.getClass();
        if(integer0 != null && ((int)integer0) == 0) {
            return ((StringProviderImpl)playlistMainFragment0.p()).a(0x7F130A39);  // string:smart_playlist_song_title "재생목록"
        }
        if(integer0 != null && ((int)integer0) == 1) {
            return ((StringProviderImpl)playlistMainFragment0.p()).a(0x7F130A17);  // string:smart_drawer_playlist_title "음악서랍"
        }
        if(integer0 != null && ((int)integer0) == 2) {
            return ((Boolean)((PlaylistMainViewModel)playlistMainFragment0.getViewModel()).getMixUpIsDjMalrangStateFlow().getValue()).booleanValue() ? ((StringProviderImpl)playlistMainFragment0.p()).a(0x7F130A14) : ((StringProviderImpl)playlistMainFragment0.p()).a(0x7F130A18);  // string:smart_dj_malrang_playlist_title "DJ말랑이"
        }
        return "";
    }

    public static final PlaylistMainViewModel access$getViewModel(PlaylistMainFragment playlistMainFragment0) {
        return (PlaylistMainViewModel)playlistMainFragment0.getViewModel();
    }

    public static final void access$onViewCreated$scrollToTab(i1 i10, H2 h20, H2 h21, D6.i i0) {
        if(i0 == null) {
            return;
        }
        D5.a a0 = new D5.a(i0, h20, h21, i10, 20);
        i10.i.post(a0);
    }

    public static final void access$showController(PlaylistMainFragment playlistMainFragment0, boolean z) {
        Job job0 = playlistMainFragment0.f;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        playlistMainFragment0.f = BuildersKt__Builders_commonKt.launch$default(f0.f(playlistMainFragment0), null, null, new PlaylistMainFragment.showController.1(playlistMainFragment0, z, null), 3, null);
    }

    public static final void access$updateHeaderBtnState(PlaylistMainFragment playlistMainFragment0, PlaylistMainHeaderBtnState playlistMainHeaderBtnState0) {
        i1 i10 = (i1)playlistMainFragment0.getBinding();
        if(i10 != null) {
            FrameLayout frameLayout0 = i10.b;
            FrameLayout frameLayout1 = i10.g;
            switch(WhenMappings.$EnumSwitchMapping$0[playlistMainHeaderBtnState0.ordinal()]) {
                case 1: {
                    frameLayout1.setVisibility(0);
                    frameLayout0.setVisibility(8);
                    break;
                }
                case 2: {
                    frameLayout1.setVisibility(8);
                    frameLayout0.setVisibility(0);
                    return;
                }
                case 3: {
                    frameLayout1.setVisibility(8);
                    frameLayout0.setVisibility(8);
                    return;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }

    public final void checkWithMakePlaylist() {
        if(!((PlaylistMainViewModel)this.getViewModel()).isLoginUser()) {
            Navigator.openLoginView(f.f);
            return;
        }
        RequestBuilder.newInstance(new MyMusicPlaylistInformCntCheckReq(this.getContext())).tag(this.k).listener(new com.iloen.melon.player.playlist.f(this, 0)).errorListener(new com.iloen.melon.fragments.musicmessage.e(20)).request();
    }

    @Override  // com.melon.ui.c0
    public boolean excludingTagArguments() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    @Nullable
    public androidx.fragment.app.I getCurrentFragment() {
        PlaylistViewPagerAdapter playlistViewPagerAdapter0 = this.h;
        if(playlistViewPagerAdapter0 != null) {
            PlaylistViewPagerBaseFragment playlistViewPagerBaseFragment0 = playlistViewPagerAdapter0.getRegisteredFragment(this.o().getFocusingTab().getIndex());
            return playlistViewPagerBaseFragment0 == null ? null : playlistViewPagerBaseFragment0.getCurrentFragment();
        }
        return null;
    }

    @Override  // com.melon.ui.c0
    @NotNull
    public f1 getInsetHandlingType() {
        return this.m;
    }

    @NotNull
    public final x2 getPlayBgColorExtractor() {
        x2 x20 = this.playBgColorExtractor;
        if(x20 != null) {
            return x20;
        }
        q.m("playBgColorExtractor");
        throw null;
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
    public b getSearchFriendActivityResultLauncher() {
        return this.l;
    }

    @NotNull
    public i1 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02BC, null, false);  // layout:fragment_pager_playlist
        int v = 0x7F0A0073;  // id:add_playlist_btn
        View view1 = De.I.C(view0, 0x7F0A0073);  // id:add_playlist_btn
        if(((FrameLayout)view1) != null) {
            v = 0x7F0A00AB;  // id:appbar_layout
            View view2 = De.I.C(view0, 0x7F0A00AB);  // id:appbar_layout
            if(((AppBarLayout)view2) != null && ((Barrier)De.I.C(view0, 0x7F0A00F5)) != null && ((Barrier)De.I.C(view0, 0x7F0A0142)) != null) {  // id:barrier
                v = 0x7F0A02CA;  // id:close_btn
                View view3 = De.I.C(view0, 0x7F0A02CA);  // id:close_btn
                if(((FrameLayout)view3) != null) {
                    v = 0x7F0A0927;  // id:player_controller_container
                    View view4 = De.I.C(view0, 0x7F0A0927);  // id:player_controller_container
                    if(((ComposeView)view4) != null) {
                        v = 0x7F0A0932;  // id:playlist_bg_compose_view
                        View view5 = De.I.C(view0, 0x7F0A0932);  // id:playlist_bg_compose_view
                        if(((ComposeView)view5) != null) {
                            v = 0x7F0A0A39;  // id:search_btn
                            View view6 = De.I.C(view0, 0x7F0A0A39);  // id:search_btn
                            if(((FrameLayout)view6) != null) {
                                v = 0x7F0A0B14;  // id:tab_layout
                                View view7 = De.I.C(view0, 0x7F0A0B14);  // id:tab_layout
                                if(((TabLayout)view7) != null) {
                                    v = 0x7F0A0B16;  // id:tab_scroll_view
                                    View view8 = De.I.C(view0, 0x7F0A0B16);  // id:tab_scroll_view
                                    if(((HorizontalScrollView)view8) != null) {
                                        v = 0x7F0A0DD6;  // id:viewpager
                                        View view9 = De.I.C(view0, 0x7F0A0DD6);  // id:viewpager
                                        if(((NonSwipeableViewPager)view9) != null) {
                                            return new i1(((CoordinatorLayout)view0), ((FrameLayout)view1), ((AppBarLayout)view2), ((FrameLayout)view3), ((ComposeView)view4), ((ComposeView)view5), ((FrameLayout)view6), ((TabLayout)view7), ((HorizontalScrollView)view8), ((NonSwipeableViewPager)view9));
                                        }
                                    }
                                }
                            }
                        }
                    }
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
        return PlaylistMainViewModel.class;
    }

    public void handleShareSNSPopupUiEvent(@NotNull x3 x30, @NotNull androidx.fragment.app.I i0, @Nullable Activity activity0, boolean z, @Nullable b b0, @NotNull we.k k0) {
        q.g(x30, "event");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        this.d.getClass();
        c.h(x30, i0, activity0, z, b0, k0);
    }

    @Override  // com.melon.ui.c0
    public boolean isBringToFrontFragment() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.IPagerFragment
    public boolean isOffscreenLimitPager() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public boolean isPlayerFragment() {
        return false;
    }

    @Override  // com.melon.ui.c0
    public boolean isPlaylistFragment() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.IPagerFragment
    public boolean isUseLoopViewPager() {
        return false;
    }

    public final H2 n(String s) {
        LayoutInflater layoutInflater0 = this.getLayoutInflater();
        i1 i10 = (i1)this.getBinding();
        View view0 = layoutInflater0.inflate(0x7F0D059D, (i10 == null ? null : i10.h), false);  // layout:playlist_tabview
        CheckableTextView checkableTextView0 = (CheckableTextView)De.I.C(view0, 0x7F0A0B8D);  // id:title
        if(checkableTextView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0B8D));  // id:title
        }
        H2 h20 = new H2(((FrameLayout)view0), checkableTextView0);
        checkableTextView0.setText(s);
        return h20;
    }

    public final PlaylistSharedViewModel o() {
        return (PlaylistSharedViewModel)this.g.getValue();
    }

    @Override  // com.melon.ui.J0
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        i1 i10 = (i1)this.getBinding();
        if(i10 != null) {
            AppBarLayout appBarLayout0 = i10.c;
            if(appBarLayout0 != null) {
                int v = ScreenUtils.getStatusBarHeight(this.getContext());
                appBarLayout0.setPadding(appBarLayout0.getPaddingLeft(), v, appBarLayout0.getPaddingRight(), appBarLayout0.getPaddingBottom());
            }
        }
    }

    @Override  // com.melon.ui.J0
    public void onDestroyView() {
        super.onDestroyView();
        PlaylistViewPagerAdapter playlistViewPagerAdapter0 = this.h;
        if(playlistViewPagerAdapter0 != null) {
            playlistViewPagerAdapter0.clear();
        }
        this.h = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPlaylistViewFocus eventPlaylistViewFocus0) {
        q.g(eventPlaylistViewFocus0, "event");
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(this, null) {
            public final EventPlaylistViewFocus r;
            public final PlaylistMainFragment w;

            {
                this.r = eventPlaylistViewFocus0;
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onEventMainThread.1(this.r, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onEventMainThread.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                EventPlaylistViewFocus eventPlaylistViewFocus0 = this.r;
                PlaylistMainFragment playlistMainFragment0 = this.w;
                if(eventPlaylistViewFocus0 instanceof EventCurPlaylistViewFocus) {
                    playlistMainFragment0.o().updateFocusingTabToCurrentPlaylist();
                    return H.a;
                }
                if(eventPlaylistViewFocus0 instanceof EventSongPlaylistViewFocus) {
                    playlistMainFragment0.o().updateFocusingTab(PlaylistTab.MUSIC);
                    return H.a;
                }
                if(!(eventPlaylistViewFocus0 instanceof EventMixUpPlaylistViewFocus)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                playlistMainFragment0.o().updateFocusingTab(PlaylistTab.MIX_UP);
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.melon.ui.c0
    public void onStart() {
        super.onStart();
        EventBusHelper.register(this);
        com.melon.playlist.b b0 = (com.melon.playlist.b)((d3)((PlaylistMainViewModel)this.getViewModel()).getPlaylistManager()).a;
        e1 e10 = new e1(b0, null);
        BuildersKt__Builders_commonKt.launch$default(b0.m, null, null, e10, 3, null);
    }

    @Override  // com.melon.ui.c0
    public void onStop() {
        super.onStop();
        EventBusHelper.unregister(this);
        this.dismissRetainedPopup();
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof x3) {
            this.handleShareSNSPopupUiEvent(((x3)i40), this, this.getActivity(), ((PlaylistMainViewModel)this.getViewModel()).isLoginUser(), this.getSearchFriendActivityResultLauncher(), new we.k(0, PlaylistMainFragment.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Pc.e)object0));
                    return H.a;
                }

                public final void invoke(Pc.e e0) {
                    q.g(e0, "p0");
                    ((PlaylistMainFragment)this.receiver).sendUserEvent(e0);
                }
            });
        }
    }

    @Override  // com.melon.ui.J0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        ((PlaylistMainViewModel)this.getViewModel()).updateTiaraProperty(((StringProviderImpl)this.p()).a(0x7F130E55), "", "");  // string:tiara_common_section_playlist "재생목록"
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        String s = null;
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final PlaylistMainFragment w;

            {
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1 playlistMainFragment$onViewCreated$1$10 = new n(null) {
                            public int r;
                            public final PlaylistMainFragment w;

                            {
                                this.w = playlistMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Flow flow0 = ((d3)PlaylistMainFragment.access$getPlaylistManager(this.w)).i();
                                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1.1 playlistMainFragment$onViewCreated$1$1$10 = new n(null) {
                                            public Object r;
                                            public final PlaylistMainFragment w;

                                            {
                                                this.w = playlistMainFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.1.1.1)this.create(playlistId0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                PlaylistId playlistId0 = (PlaylistId)this.r;
                                                d5.n.D(object0);
                                                PlaylistMainFragment playlistMainFragment0 = this.w;
                                                if(!playlistMainFragment0.o().isValidPlaylistId(playlistId0)) {
                                                    e.w(playlistMainFragment0);
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(flow0, playlistMainFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, s.e, playlistMainFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
        Q4.a a0 = this.getBinding();
        if(((i1)a0) == null) {
            return;
        }
        FrameLayout frameLayout0 = ((i1)a0).d;
        TabLayout tabLayout0 = ((i1)a0).h;
        NonSwipeableViewPager nonSwipeableViewPager0 = ((i1)a0).j;
        m0.b b0 = new m0.b(0x29417DF, new com.iloen.melon.player.playlist.e(this, 3), true);
        ((i1)a0).f.setContent(b0);
        int v = ScreenUtils.getStatusBarHeight(this.getContext());
        int v1 = ((i1)a0).c.getPaddingLeft();
        int v2 = ((i1)a0).c.getPaddingRight();
        int v3 = ((i1)a0).c.getPaddingBottom();
        ((i1)a0).c.setPadding(v1, v, v2, v3);
        if(this.h == null) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            this.h = new PlaylistViewPagerAdapter(l00);
        }
        nonSwipeableViewPager0.setAdapter(this.h);
        tabLayout0.setupWithViewPager(nonSwipeableViewPager0);
        H2 h20 = this.n(((StringProviderImpl)this.p()).a(0x7F130A39));  // string:smart_playlist_song_title "재생목록"
        H2 h21 = this.n(((StringProviderImpl)this.p()).a(0x7F130A17));  // string:smart_drawer_playlist_title "음악서랍"
        H2 h22 = this.n("");
        q.f(h20.a, "getRoot(...)");
        q.f(h21.a, "getRoot(...)");
        q.f(h22.a, "getRoot(...)");
        View[] arr_view = {h20.a, h21.a, h22.a};
        i1 i10 = (i1)this.getBinding();
        if(i10 != null) {
            int v5 = 0;
            for(int v4 = 0; v5 < 3; ++v4) {
                View view1 = arr_view[v5];
                D6.i i0 = i10.h.g(v4);
                if(i0 != null) {
                    i0.e = view1;
                    i0.a();
                }
                ++v5;
            }
        }
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(this, null) {
            public final H2 B;
            public int r;
            public final PlaylistMainFragment w;

            {
                this.w = playlistMainFragment0;
                this.B = h20;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.3(this.B, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = PlaylistMainFragment.access$getViewModel(this.w).getMixUpIsDjMalrangStateFlow();
                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.3.1 playlistMainFragment$onViewCreated$3$10 = new n(this.w, null) {
                            public final PlaylistMainFragment B;
                            public boolean r;
                            public final H2 w;

                            {
                                this.w = h20;
                                this.B = playlistMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.3.1(this.w, this.B, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.3.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                d5.n.D(object0);
                                String s = ((StringProviderImpl)this.B.p()).a((z ? 0x7F130A14 : 0x7F130A18));  // string:smart_dj_malrang_playlist_title "DJ말랑이"
                                this.w.b.setText(s);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, playlistMainFragment$onViewCreated$3$10, this) == a0 ? a0 : H.a;
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
        List list0 = e.k.A(new H2[]{h20, h21, h22});
        this.r(list0);
        nonSwipeableViewPager0.post(new com.iloen.melon.player.playlist.i(this));
        D d2 = this.getViewLifecycleOwner();
        q.f(d2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d2), null, null, new n(((i1)a0), h20, h21, null) {
            public final i1 B;
            public final H2 D;
            public final H2 E;
            public int r;
            public final PlaylistMainFragment w;

            {
                this.w = playlistMainFragment0;
                this.B = i10;
                this.D = h20;
                this.E = h21;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5(this.w, this.B, this.D, this.E, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1 playlistMainFragment$onViewCreated$5$10 = new n(this.B, this.D, this.E, null) {
                            public final i1 B;
                            public final H2 D;
                            public final H2 E;
                            public int r;
                            public final PlaylistMainFragment w;

                            {
                                this.w = playlistMainFragment0;
                                this.B = i10;
                                this.D = h20;
                                this.E = h21;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1(this.w, this.B, this.D, this.E, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.o().getFocusingTabFlow();
                                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1.1 playlistMainFragment$onViewCreated$5$1$10 = new n(this.D, this.E, null) {
                                            public final H2 B;
                                            public final H2 D;
                                            public Object r;
                                            public final i1 w;

                                            {
                                                this.w = i10;
                                                this.B = h20;
                                                this.D = h21;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1.1(this.w, this.B, this.D, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(PlaylistTab playlistTab0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.5.1.1)this.create(playlistTab0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((PlaylistTab)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                PlaylistTab playlistTab0 = (PlaylistTab)this.r;
                                                d5.n.D(object0);
                                                int v = playlistTab0.getIndex();
                                                this.w.j.setCurrentItem(v);
                                                Kc.g g0 = new Kc.g(this.w, v, this.B, this.D, 6);
                                                this.w.h.post(g0);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, playlistMainFragment$onViewCreated$5$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, s.d, playlistMainFragment$onViewCreated$5$10, this) == a0 ? a0 : H.a;
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
        nonSwipeableViewPager0.addOnPageChangeListener(new j() {
            public final PlaylistMainFragment a;
            public final List b;

            {
                PlaylistMainFragment playlistMainFragment0 = list0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = playlistMainFragment0;
                this.b = list0;
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrollStateChanged(int v) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageScrolled(int v, float f, int v1) {
            }

            @Override  // androidx.viewpager.widget.j
            public void onPageSelected(int v) {
                PlaylistMainFragment playlistMainFragment0 = this.a;
                playlistMainFragment0.r(this.b);
                PlaylistTab playlistTab0 = playlistMainFragment0.o().getFocusingTab();
                playlistMainFragment0.o().updateFocusingTabByIndex(v);
                if(playlistTab0.getIndex() != v) {
                    playlistMainFragment0.q().logClickTab(playlistTab0, PlaylistMainFragment.access$getTabTitle(playlistMainFragment0, v));
                }
            }
        });
        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.7 playlistMainFragment$onViewCreated$70 = new D6.e() {
            public final PlaylistMainFragment a;
            public final i1 b;
            public final H2 c;
            public final H2 d;

            {
                PlaylistMainFragment playlistMainFragment0 = (i1)a0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                i1 i10 = h20;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                H2 h20 = h21;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.a = playlistMainFragment0;
                this.b = i10;
                this.c = h20;
                this.d = h21;
            }

            @Override  // D6.d
            public void onTabReselected(D6.i i0) {
                LogU.debug$default(this.a.e, "onTabReselected: " + (i0 == null ? null : i0.d), null, false, 6, null);
                PlaylistMainFragment.access$onViewCreated$scrollToTab(this.b, this.c, this.d, i0);
                this.a.o().reselectTab();
                PlaylistMainTiaraLogHelper.logClickTab$default(this.a.q(), null, PlaylistMainFragment.access$getTabTitle(this.a, (i0 == null ? null : i0.d)), 1, null);
            }

            @Override  // D6.d
            public void onTabSelected(D6.i i0) {
                LogU.debug$default(this.a.e, "onTabSelected: " + (i0 == null ? null : i0.d), null, false, 6, null);
            }

            @Override  // D6.d
            public void onTabUnselected(D6.i i0) {
            }
        };
        ArrayList arrayList0 = tabLayout0.k0;
        if(!arrayList0.contains(playlistMainFragment$onViewCreated$70)) {
            arrayList0.add(playlistMainFragment$onViewCreated$70);
        }
        com.iloen.melon.player.playlist.j j0 = new com.iloen.melon.player.playlist.j(this, 0);
        ((i1)a0).g.setOnClickListener(j0);
        com.iloen.melon.player.playlist.j j1 = new com.iloen.melon.player.playlist.j(this, 1);
        ((i1)a0).b.setOnClickListener(j1);
        frameLayout0.setOnClickListener(new com.iloen.melon.player.playlist.j(this, 2));
        m0.b b1 = new m0.b(1053529736, new com.iloen.melon.player.playlist.e(this, 0), true);
        ((i1)a0).e.setContent(b1);
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new n(null) {
            public int r;
            public final PlaylistMainFragment w;

            {
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1 playlistMainFragment$onViewCreated$12$10 = new n(null) {
                            public Object r;
                            public final PlaylistMainFragment w;

                            {
                                this.w = playlistMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                                d5.n.D(object0);
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                                    public int r;
                                    public final PlaylistMainFragment w;

                                    {
                                        this.w = playlistMainFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.1(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                d5.n.D(object0);
                                                StateFlow stateFlow0 = this.w.o().getVisibilityController();
                                                com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.1.1 playlistMainFragment$onViewCreated$12$1$1$10 = new n(null) {
                                                    public boolean r;
                                                    public final PlaylistMainFragment w;

                                                    {
                                                        this.w = playlistMainFragment0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.1.1(this.w, continuation0);
                                                        continuation1.r = ((Boolean)object0).booleanValue();
                                                        return continuation1;
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(boolean z, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        boolean z = this.r;
                                                        d5.n.D(object0);
                                                        PlaylistMainFragment.access$showController(this.w, z);
                                                        return H.a;
                                                    }
                                                };
                                                this.r = 1;
                                                return FlowKt.collectLatest(stateFlow0, playlistMainFragment$onViewCreated$12$1$1$10, this) == a0 ? a0 : H.a;
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
                                    public final PlaylistMainFragment w;

                                    {
                                        this.w = playlistMainFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.2(this.w, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.r) {
                                            case 0: {
                                                d5.n.D(object0);
                                                StateFlow stateFlow0 = this.w.o().getHeaderBtnState();
                                                com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.2.1 playlistMainFragment$onViewCreated$12$1$2$10 = new n(null) {
                                                    public Object r;
                                                    public final PlaylistMainFragment w;

                                                    {
                                                        this.w = playlistMainFragment0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        Continuation continuation1 = new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.2.1(this.w, continuation0);
                                                        continuation1.r = object0;
                                                        return continuation1;
                                                    }

                                                    public final Object invoke(PlaylistMainHeaderBtnState playlistMainHeaderBtnState0, Continuation continuation0) {
                                                        return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.12.1.2.1)this.create(playlistMainHeaderBtnState0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((PlaylistMainHeaderBtnState)object0), ((Continuation)object1));
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        PlaylistMainHeaderBtnState playlistMainHeaderBtnState0 = (PlaylistMainHeaderBtnState)this.r;
                                                        d5.n.D(object0);
                                                        PlaylistMainFragment.access$updateHeaderBtnState(this.w, playlistMainHeaderBtnState0);
                                                        return H.a;
                                                    }
                                                };
                                                this.r = 1;
                                                return FlowKt.collectLatest(stateFlow0, playlistMainFragment$onViewCreated$12$1$2$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, s.d, playlistMainFragment$onViewCreated$12$10, this) == a0 ? a0 : H.a;
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
            public final PlaylistMainFragment w;

            {
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.13(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.13)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        SharedFlow sharedFlow0 = this.w.o().getActivityResultEvent();
                        com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.13.1 playlistMainFragment$onViewCreated$13$10 = new FlowCollector() {
                            public final PlaylistMainFragment a;

                            {
                                this.a = playlistMainFragment0;
                            }

                            // 去混淆评级： 低(23)
                            public final Object emit(NewActivityEvent playlistSharedViewModel$NewActivityEvent0, Continuation continuation0) {
                                if(!(playlistSharedViewModel$NewActivityEvent0 instanceof SharePlayable)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                Playable playable0 = ((SharePlayable)playlistSharedViewModel$NewActivityEvent0).getPlayable();
                                q.f("", "getSongidString(...)");
                                q.f("", "getSongName(...)");
                                L3 l30 = new L3(new t("", "", "", l1.n("", "getAlbumid(...)", playable0, "getArtistNames(...)")));
                                this.a.sendUserEvent(l30);
                                return H.a;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((NewActivityEvent)object0), continuation0);
                            }
                        };
                        this.r = 1;
                        if(sharedFlow0.collect(playlistMainFragment$onViewCreated$13$10, this) == a0) {
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
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }, 3, null);
        if(this.getContext() != null) {
            s = "재생목록 닫기";
        }
        ViewUtils.setContentDescriptionWithButtonClassName(frameLayout0, s);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.playlist.PlaylistMainFragment$onViewCreated$8$1", f = "PlaylistMainFragment.kt", l = {334}, m = "invokeSuspend")
        final class com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.8.1 extends oe.i implements n {
            public int r;
            public final PlaylistMainFragment w;

            public com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.8.1(PlaylistMainFragment playlistMainFragment0, Continuation continuation0) {
                this.w = playlistMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.8.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.8.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        PlaylistSharedViewModel playlistSharedViewModel0 = this.w.o();
                        this.r = 1;
                        return playlistSharedViewModel0.updateFocusingTabContentToSearch(this) == a0 ? a0 : H.a;
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

    public final Pc.d p() {
        return ((PlaylistMainViewModel)this.getViewModel()).getStringProvider();
    }

    public final PlaylistMainTiaraLogHelper q() {
        return (PlaylistMainTiaraLogHelper)this.j.getValue();
    }

    public final void r(List list0) {
        i1 i10 = (i1)this.getBinding();
        if(i10 != null) {
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    com.iloen.melon.player.playlist.h h0 = new com.iloen.melon.player.playlist.h(((H2)object0), i10, v);
                    ((H2)object0).b.post(h0);
                    ++v;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
    }

    @Override  // com.melon.ui.c0
    public void setInsetHandlingType(@NotNull f1 f10) {
        q.g(f10, "<set-?>");
        this.m = f10;
    }

    public final void setPlayBgColorExtractor(@NotNull x2 x20) {
        q.g(x20, "<set-?>");
        this.playBgColorExtractor = x20;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    @Override  // com.melon.ui.c0
    public boolean shouldOnResume() {
        PlaylistId playlistId0 = ((d3)((PlaylistMainViewModel)this.getViewModel()).getPlaylistManager()).j();
        return playlistId0 == null || this.o().isValidPlaylistId(playlistId0);
    }
}

