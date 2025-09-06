package com.iloen.melon.player.video;

import De.d;
import E9.w;
import H8.i;
import J8.n2;
import Qb.z;
import S2.c;
import Ub.s;
import a9.a;
import android.app.PictureInPictureParams.Builder;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.app.o;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.I;
import androidx.fragment.app.j0;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.b;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.y;
import androidx.window.layout.FoldingFeature.Orientation;
import androidx.window.layout.FoldingFeature.State;
import androidx.window.layout.FoldingFeature;
import c2.C0;
import c2.D0;
import c2.E0;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.OutlineTextView;
import com.iloen.melon.fragments.IFragmentContainer;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.player.video.chat.VideoChatViewModel;
import com.iloen.melon.player.video.cheer.CheerAnimationManager;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import d3.g;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import ie.m;
import javax.inject.Inject;
import k8.Y;
import k8.t;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001aB\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u0006\u00A2\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\u0005J\u000F\u0010\r\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001A\u00020\t2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001A2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010\"\u001A\u00020\t2\u0006\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b$\u0010\u0005J\u000F\u0010%\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b%\u0010\u0005J\u000F\u0010&\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b&\u0010\u0005J\u000F\u0010\'\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\'\u0010\u0005J!\u0010,\u001A\u00020+2\b\b\u0002\u0010)\u001A\u00020(2\b\b\u0002\u0010*\u001A\u00020\u0006\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010/\u001A\u00020\t2\u0006\u0010.\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b/\u0010\u0011J\u0017\u00102\u001A\u00020\t2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b2\u00103J\u0017\u00104\u001A\u00020\t2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b4\u00103J\u000F\u00105\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b5\u0010\u000EJ\u0011\u00106\u001A\u0004\u0018\u000100H\u0016\u00A2\u0006\u0004\b6\u00107R\"\u00109\u001A\u0002088\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001A\u00020?8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b@\u0010A\u001A\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001A\u00020F8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bG\u0010H\u001A\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001A\u00020M8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bN\u0010O\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR0\u0010\\\u001A\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\t\u0018\u00010T8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bV\u0010W\u001A\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0011\u0010`\u001A\u00020]8F\u00A2\u0006\u0006\u001A\u0004\b^\u0010_\u00A8\u0006b"}, d2 = {"Lcom/iloen/melon/player/video/VideoMainFrameFragment;", "Lcom/iloen/melon/player/video/FloatingFragment;", "La9/a;", "Lcom/iloen/melon/fragments/IFragmentContainer;", "<init>", "()V", "", "isFullScreen", "openPlaylist", "Lie/H;", "openVideoPlayer", "(ZZ)V", "setMiniPlayerMode", "isFullCover", "()Z", "hasFocus", "onWindowFocusChanged", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onStart", "onStop", "onDestroyView", "onDestroy", "Landroid/util/Rational;", "videoRatio", "isPlaying", "Landroid/app/PictureInPictureParams;", "getPictureInPictureParams", "(Landroid/util/Rational;Z)Landroid/app/PictureInPictureParams;", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroidx/fragment/app/I;", "fragment", "addFragment", "(Landroidx/fragment/app/I;)V", "removeFragment", "onBackPressed", "getCurrentFragment", "()Landroidx/fragment/app/I;", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "LQb/z;", "playerController", "LQb/z;", "getPlayerController", "()LQb/z;", "setPlayerController", "(LQb/z;)V", "LUb/s;", "remotePlayerManager", "LUb/s;", "getRemotePlayerManager", "()LUb/s;", "setRemotePlayerManager", "(LUb/s;)V", "Lkotlin/Function1;", "Lcom/iloen/melon/player/video/VideoStatus;", "f", "Lwe/k;", "getVideoStatusListener", "()Lwe/k;", "setVideoStatusListener", "(Lwe/k;)V", "videoStatusListener", "LJ8/n2;", "getBinding", "()LJ8/n2;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMainFrameFragment extends Hilt_VideoMainFrameFragment implements a, IFragmentContainer {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoMainFrameFragment$Companion;", "", "", "isFullScreen", "Lcom/iloen/melon/player/video/VideoMainFrameFragment;", "newInstance", "(Z)Lcom/iloen/melon/player/video/VideoMainFrameFragment;", "", "TAG", "Ljava/lang/String;", "ARG_IS_FULLSCREEN", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoMainFrameFragment newInstance(boolean z) {
            VideoMainFrameFragment videoMainFrameFragment0 = new VideoMainFrameFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFullScreen", z);
            videoMainFrameFragment0.setArguments(bundle0);
            return videoMainFrameFragment0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[VideoOneDepthContentType.values().length];
            try {
                arr_v[VideoOneDepthContentType.CHAT.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[VideoOneDepthContentType.LIVE_PREVIEW.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[VideoStatus.values().length];
            try {
                arr_v1[VideoStatus.FullScreen.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[VideoStatus.Expand.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v1[VideoStatus.MiniMode.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final int $stable;
    public CheerAnimationManager B;
    @NotNull
    public static final Companion Companion;
    public final com.iloen.melon.player.video.VideoMainFrameFragment.bottomSheetForFocusableCallback.1 D;
    public final Z E;
    public k f;
    public final LogU g;
    public final i h;
    public final i i;
    public n2 j;
    public CoroutineScope k;
    public Job l;
    public I m;
    public I n;
    public String o;
    @Inject
    public z playerController;
    @Inject
    public ob.z playerUseCase;
    @Inject
    public s2 playlistManager;
    public HeightInfoForFocusable r;
    @Inject
    public s remotePlayerManager;
    public Job w;

    static {
        VideoMainFrameFragment.Companion = new Companion(null);
        VideoMainFrameFragment.$stable = 8;
    }

    public VideoMainFrameFragment() {
        this.g = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "VideoMainFrameFragment", false, Category.UI, 2, null);
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.2 videoMainFrameFragment$special$$inlined$viewModels$default$20 = new we.a() {
            public final we.a f;

            {
                this.f = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.f.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(ie.k.c, videoMainFrameFragment$special$$inlined$viewModels$default$20);
        d d0 = kotlin.jvm.internal.I.a.b(LiveViewModel.class);
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.3 videoMainFrameFragment$special$$inlined$viewModels$default$30 = new we.a() {
            public final j f;

            {
                this.f = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.f.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.4 videoMainFrameFragment$special$$inlined$viewModels$default$40 = new we.a(j0) {
            public final we.a f;
            public final j g;

            {
                this.f = a0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                we.a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.h = new i(d0, videoMainFrameFragment$special$$inlined$viewModels$default$30, new we.a(j0) {
            public final I f;
            public final j g;

            {
                this.f = i0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.f.getDefaultViewModelProviderFactory() : o00;
                }
                return this.f.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, videoMainFrameFragment$special$$inlined$viewModels$default$40);
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.7 videoMainFrameFragment$special$$inlined$viewModels$default$70 = new we.a() {
            public final we.a f;

            {
                this.f = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.f.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j1 = g.P(ie.k.c, videoMainFrameFragment$special$$inlined$viewModels$default$70);
        d d1 = kotlin.jvm.internal.I.a.b(VideoChatViewModel.class);
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.8 videoMainFrameFragment$special$$inlined$viewModels$default$80 = new we.a() {
            public final j f;

            {
                this.f = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.f.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.9 videoMainFrameFragment$special$$inlined$viewModels$default$90 = new we.a(j1) {
            public final we.a f;
            public final j g;

            {
                this.f = a0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                we.a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.i = new i(d1, videoMainFrameFragment$special$$inlined$viewModels$default$80, new we.a(j1) {
            public final I f;
            public final j g;

            {
                this.f = i0;
                this.g = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.g.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.f.getDefaultViewModelProviderFactory() : o00;
                }
                return this.f.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, videoMainFrameFragment$special$$inlined$viewModels$default$90);
        this.r = HeightInfoForFocusable.Companion.getEmpty();
        this.D = new i6.a() {
            public final VideoMainFrameFragment a;

            {
                this.a = videoMainFrameFragment0;
            }

            @Override  // i6.a
            public void onSlide(View view0, float f) {
                q.g(view0, "bottomSheet");
                VideoMainFrameFragment videoMainFrameFragment0 = this.a;
                if(!((Boolean)VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).isVideoPortraitRatio().getValue()).booleanValue()) {
                    return;
                }
                VideoMainFrameFragment.access$updateVideoHeightAndSeparatedFragmentBottomMargin(videoMainFrameFragment0, ((int)(((float)VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMaxVideoHeight()) - ((float)(VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMaxVideoHeight() - VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMinVideoHeight())) * f)), ((int)((1.0f - f) * ((float)(VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMaxVideoHeight() - VideoMainFrameFragment.access$getHeightInfoForFocusable$p(videoMainFrameFragment0).getMinVideoHeight())))));
                VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).updateSlideOffset(f);
            }

            @Override  // i6.a
            public void onStateChanged(View view0, int v) {
                q.g(view0, "bottomSheet");
                VideoMainFrameFragment videoMainFrameFragment0 = this.a;
                if(VideoMainFrameFragment.access$getVideoViewModel(videoMainFrameFragment0).getVideoStatus().getValue() == VideoStatus.Expand) {
                    n2 n20 = videoMainFrameFragment0.getBinding();
                    boolean z = e.k.A(new Integer[]{1, 2}).contains(v);
                    n20.o.setInteractionEnabled(!z);
                }
                switch(v) {
                    case 3: {
                        LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "BottomSheet stateChanged, EXPANDED", null, false, 6, null);
                        VideoMainFrameFragment.access$setVideoFocusState(videoMainFrameFragment0, false);
                        return;
                    }
                    case 4: {
                        LogU.debug$default(VideoMainFrameFragment.access$getLog$p(videoMainFrameFragment0), "BottomSheet stateChanged, COLLAPSED", null, false, 6, null);
                        VideoMainFrameFragment.access$setVideoFocusState(videoMainFrameFragment0, true);
                    }
                }
            }
        };
        this.E = new Z(this);

        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.1 extends r implements we.a {
            public final I f;

            public com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.1(I i0) {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final I invoke() {
                return this.f;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.6 extends r implements we.a {
            public final I f;

            public com.iloen.melon.player.video.VideoMainFrameFragment.special..inlined.viewModels.default.6(I i0) {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final I invoke() {
                return this.f;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public static final void access$adjustChatFrameLayout(VideoMainFrameFragment videoMainFrameFragment0, boolean z) {
        int v = -1;
        int v1 = z ? ScreenUtils.dipToPixel(videoMainFrameFragment0.getContext(), 480.0f) : -1;
        if(z) {
            videoMainFrameFragment0.getClass();
        }
        else {
            v = ScreenUtils.dipToPixel(videoMainFrameFragment0.getContext(), 280.0f);
        }
        androidx.constraintlayout.widget.n n0 = new androidx.constraintlayout.widget.n();
        n0.f(videoMainFrameFragment0.getBinding().h);
        n0.l(videoMainFrameFragment0.getBinding().g.getId()).e.c = v;
        n0.l(videoMainFrameFragment0.getBinding().g.getId()).e.d = v1;
        n0.b(videoMainFrameFragment0.getBinding().h);
    }

    public static final HeightInfoForFocusable access$calculateHeightInfoForFocusable(VideoMainFrameFragment videoMainFrameFragment0, BottomSheetState videoViewModel$BottomSheetState0) {
        int v3;
        int v2;
        int v = videoMainFrameFragment0.getBinding().o.getWidth();
        int v1 = videoViewModel$BottomSheetState0.getScreenHeight();
        FoldingFeature foldingFeature0 = videoViewModel$BottomSheetState0.getFoldingFeature();
        if(q.b((foldingFeature0 == null ? null : foldingFeature0.getState()), State.HALF_OPENED)) {
            FoldingFeature foldingFeature1 = videoViewModel$BottomSheetState0.getFoldingFeature();
            FragmentActivity fragmentActivity0 = videoMainFrameFragment0.getActivity();
            q.g(foldingFeature1, "<this>");
            v2 = 0;
            if(fragmentActivity0 != null) {
                if(!fragmentActivity0.isInMultiWindowMode()) {
                    v2 = ScreenUtils.getStatusBarHeight(fragmentActivity0);
                }
                v2 = (q.b(foldingFeature1.getOrientation(), Orientation.VERTICAL) ? foldingFeature1.getBounds().right : foldingFeature1.getBounds().bottom) - v2;
            }
            v3 = v2;
        }
        else if(videoViewModel$BottomSheetState0.isVideoPortraitRatio()) {
            v2 = (int)(((float)v1) * 0.7f);
            v3 = (int)(((float)v) * 9.0f / 16.0f);
        }
        else {
            v2 = (int)(((float)v) * 9.0f / 16.0f);
            v3 = v2;
        }
        HeightInfoForFocusable heightInfoForFocusable0 = new HeightInfoForFocusable(v2, v3, v1 - v2, v1 - v3);
        videoMainFrameFragment0.r = heightInfoForFocusable0;
        ((LiveViewModel)videoMainFrameFragment0.h.getValue()).setLiveBottomSheetMaxHeightForSeparated(heightInfoForFocusable0.getBottomSheetMaxHeight());
        return heightInfoForFocusable0;
    }

    public static final BottomSheetBehavior access$getBottomSheetBehaviorForSeparated(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.n();
    }

    public static final com.iloen.melon.player.video.VideoMainFrameFragment.bottomSheetForFocusableCallback.1 access$getBottomSheetForFocusableCallback$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.D;
    }

    public static final I access$getChatFragmentForFull$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.n;
    }

    public static final VideoChatViewModel access$getChatViewModel(VideoMainFrameFragment videoMainFrameFragment0) {
        return (VideoChatViewModel)videoMainFrameFragment0.i.getValue();
    }

    public static final CheerAnimationManager access$getCheerAnimationManager$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.B;
    }

    public static final I access$getContentFragmentForSeparated$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.m;
    }

    public static final HeightInfoForFocusable access$getHeightInfoForFocusable$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.r;
    }

    public static final LiveViewModel access$getLiveViewModel(VideoMainFrameFragment videoMainFrameFragment0) {
        return (LiveViewModel)videoMainFrameFragment0.h.getValue();
    }

    public static final Job access$getMotionEndingJob$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.w;
    }

    public static final CoroutineScope access$getMotionSceneScope$p(VideoMainFrameFragment videoMainFrameFragment0) {
        return videoMainFrameFragment0.k;
    }

    public static final void access$setChatFragmentForFull$p(VideoMainFrameFragment videoMainFrameFragment0, I i0) {
        videoMainFrameFragment0.n = i0;
    }

    public static final void access$setContentFragmentByType(VideoMainFrameFragment videoMainFrameFragment0, VideoOneDepthContentType videoOneDepthContentType0) {
        if(videoMainFrameFragment0.o().getVideoStatus().getValue() != VideoStatus.Expand) {
            LogU.debug$default(videoMainFrameFragment0.g, "setContentFragmentByType() skipped.", null, false, 6, null);
            return;
        }
        switch(WhenMappings.$EnumSwitchMapping$0[videoOneDepthContentType0.ordinal()]) {
            case 1: {
                if(!(videoMainFrameFragment0.m instanceof VideoChatFragment)) {
                    videoMainFrameFragment0.m(false);
                    videoMainFrameFragment0.m = VideoChatFragment.Companion.newInstance(false);
                    l0 l01 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a1 = com.iloen.melon.utils.a.f(l01, "getChildFragmentManager(...)", l01);
                    int v1 = videoMainFrameFragment0.getBinding().m.getId();
                    I i1 = videoMainFrameFragment0.m;
                    q.d(i1);
                    a1.g(v1, i1, null);
                    a1.k();
                    return;
                }
                break;
            }
            case 2: {
                if(!(videoMainFrameFragment0.m instanceof VideoLivePreviewFragment)) {
                    videoMainFrameFragment0.m(false);
                    videoMainFrameFragment0.m = VideoLivePreviewFragment.Companion.newInstance();
                    l0 l02 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a2 = com.iloen.melon.utils.a.f(l02, "getChildFragmentManager(...)", l02);
                    int v2 = videoMainFrameFragment0.getBinding().m.getId();
                    I i2 = videoMainFrameFragment0.m;
                    q.d(i2);
                    a2.g(v2, i2, null);
                    a2.k();
                    return;
                }
                break;
            }
            default: {
                if(!(videoMainFrameFragment0.m instanceof VideoInfoFragment)) {
                    videoMainFrameFragment0.m(false);
                    videoMainFrameFragment0.m = VideoInfoFragment.Companion.newInstance();
                    l0 l00 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
                    int v = videoMainFrameFragment0.getBinding().m.getId();
                    I i0 = videoMainFrameFragment0.m;
                    q.d(i0);
                    a0.g(v, i0, null);
                    a0.k();
                }
            }
        }
    }

    public static final void access$setContentFragmentForSeparated$p(VideoMainFrameFragment videoMainFrameFragment0, I i0) {
        videoMainFrameFragment0.m = i0;
    }

    public static final void access$setHeightInfoForFocusable(VideoMainFrameFragment videoMainFrameFragment0, HeightInfoForFocusable heightInfoForFocusable0) {
        videoMainFrameFragment0.r = heightInfoForFocusable0;
        ((LiveViewModel)videoMainFrameFragment0.h.getValue()).setLiveBottomSheetMaxHeightForSeparated(heightInfoForFocusable0.getBottomSheetMaxHeight());
    }

    public static final void access$setMotionAboutViews(VideoMainFrameFragment videoMainFrameFragment0, CoroutineScope coroutineScope0) {
        n2 n20 = videoMainFrameFragment0.getBinding();
        VideoMainFrameFragment.setVideoStateAboutViews.1 videoMainFrameFragment$setVideoStateAboutViews$10 = new VideoMainFrameFragment.setVideoStateAboutViews.1(videoMainFrameFragment0);
        n20.o.setTransitionListener(videoMainFrameFragment$setVideoStateAboutViews$10);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new VideoMainFrameFragment.setVideoStateAboutViews.2(videoMainFrameFragment0, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain(), null, new VideoMainFrameFragment.setBottomSheetForSeparated.1(videoMainFrameFragment0, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new VideoMainFrameFragment.setBottomSheetForSeparated.2(videoMainFrameFragment0, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new VideoMainFrameFragment.setMiniPlayerRatio.1(videoMainFrameFragment0, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new VideoMainFrameFragment.setMotionAnimationChangeListener.1(videoMainFrameFragment0, null), 3, null);
    }

    public static final void access$setMotionAnimationEndingJob(VideoMainFrameFragment videoMainFrameFragment0, CoroutineScope coroutineScope0, MotionProgress motionProgress0) {
        Job job0 = videoMainFrameFragment0.w;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        videoMainFrameFragment0.w = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain(), null, new VideoMainFrameFragment.setMotionAnimationEndingJob.1(videoMainFrameFragment0, motionProgress0, null), 2, null);
    }

    public static final void access$setMotionSceneScope$p(VideoMainFrameFragment videoMainFrameFragment0, CoroutineScope coroutineScope0) {
        videoMainFrameFragment0.k = coroutineScope0;
    }

    public static final void access$setPlayerFragmentByType(VideoMainFrameFragment videoMainFrameFragment0, VideoOneDepthContentType videoOneDepthContentType0) {
        I i0 = videoMainFrameFragment0.getChildFragmentManager().D(videoMainFrameFragment0.getBinding().q.getId());
        switch(WhenMappings.$EnumSwitchMapping$0[videoOneDepthContentType0.ordinal()]) {
            case 1: {
                if(!(i0 instanceof VideoPlayerLiveFragment)) {
                    l0 l01 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a1 = com.iloen.melon.utils.a.f(l01, "getChildFragmentManager(...)", l01);
                    a1.g(videoMainFrameFragment0.getBinding().q.getId(), VideoPlayerLiveFragment.Companion.newInstance(), null);
                    a1.m();
                    return;
                }
                break;
            }
            case 2: {
                if(!(i0 instanceof VideoPlayerLivePreviewFragment)) {
                    l0 l02 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a2 = com.iloen.melon.utils.a.f(l02, "getChildFragmentManager(...)", l02);
                    a2.g(videoMainFrameFragment0.getBinding().q.getId(), VideoPlayerLivePreviewFragment.Companion.newInstance(), null);
                    a2.m();
                    return;
                }
                break;
            }
            default: {
                if(!(i0 instanceof VideoPlayerVodFragment)) {
                    l0 l00 = videoMainFrameFragment0.getChildFragmentManager();
                    androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
                    a0.g(videoMainFrameFragment0.getBinding().q.getId(), VideoPlayerVodFragment.Companion.newInstance(), null);
                    a0.m();
                }
            }
        }
    }

    public static final void access$setVideoFocusState(VideoMainFrameFragment videoMainFrameFragment0, boolean z) {
        if(z) {
            videoMainFrameFragment0.o().updateVideoFocusState(true);
            videoMainFrameFragment0.s(videoMainFrameFragment0.r.getMaxVideoHeight(), videoMainFrameFragment0.r.getMaxVideoHeight() - videoMainFrameFragment0.r.getMinVideoHeight());
            return;
        }
        videoMainFrameFragment0.o().updateVideoFocusState(false);
        videoMainFrameFragment0.s(videoMainFrameFragment0.r.getMinVideoHeight(), 0);
    }

    public static final void access$updateSystemUI(VideoMainFrameFragment videoMainFrameFragment0, VideoStatus videoStatus0) {
        Window window0 = null;
        videoMainFrameFragment0.getClass();
        int v = WhenMappings.$EnumSwitchMapping$1[videoStatus0.ordinal()];
        if(v != 1) {
            switch(v) {
                case 2: {
                    FragmentActivity fragmentActivity0 = videoMainFrameFragment0.getActivity();
                    if(fragmentActivity0 != null) {
                        window0 = fragmentActivity0.getWindow();
                    }
                    ScreenUtils.setAppearanceLightStatusBars(window0, !ScreenUtils.isDarkMode(videoMainFrameFragment0.getContext()));
                    videoMainFrameFragment0.q(false);
                    videoMainFrameFragment0.r();
                    videoMainFrameFragment0.t(false);
                    return;
                }
                case 3: {
                    FragmentActivity fragmentActivity1 = videoMainFrameFragment0.getActivity();
                    if(fragmentActivity1 instanceof MusicBrowserActivity) {
                        window0 = (MusicBrowserActivity)fragmentActivity1;
                    }
                    if(window0 != null) {
                        ((MusicBrowserActivity)window0).setRootViewBackgroundColor(ColorUtils.getColor(videoMainFrameFragment0.getContext(), 0x7F06047D));  // color:status_bar_bg
                    }
                    videoMainFrameFragment0.r();
                    videoMainFrameFragment0.postFragmentForegroundEventManually();
                    videoMainFrameFragment0.t(true);
                    return;
                }
                default: {
                    return;
                }
            }
        }
        videoMainFrameFragment0.q(true);
        videoMainFrameFragment0.p();
        videoMainFrameFragment0.t(false);
    }

    public static final void access$updateVideoHeightAndSeparatedFragmentBottomMargin(VideoMainFrameFragment videoMainFrameFragment0, int v, int v1) {
        videoMainFrameFragment0.s(v, v1);
    }

    @Override  // a9.a
    public void addFragment(@NotNull I i0) {
        q.g(i0, "fragment");
        if(i0 instanceof SingleTopStack) {
            int v = this.getChildFragmentManager().J();
            if(v > 0) {
                androidx.fragment.app.a a0 = this.getChildFragmentManager().I(v - 1);
                q.f(a0, "getBackStackEntryAt(...)");
                if(q.b(a0.i, i0.getClass().getName())) {
                    return;
                }
            }
        }
        l0 l00 = this.getChildFragmentManager();
        androidx.fragment.app.a a1 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a1.g(this.getBinding().m.getId(), i0, i0.getClass().getName());
        a1.c(i0.getClass().getName());
        a1.k();
    }

    @NotNull
    public final n2 getBinding() {
        n2 n20 = this.j;
        q.d(n20);
        return n20;
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    @Nullable
    public I getCurrentFragment() {
        return this.getChildFragmentManager().D(this.getBinding().q.getId());
    }

    @NotNull
    public final PictureInPictureParams getPictureInPictureParams(@NotNull Rational rational0, boolean z) {
        q.g(rational0, "videoRatio");
        PictureInPictureParams.Builder pictureInPictureParams$Builder0 = new PictureInPictureParams.Builder();
        Rect rect0 = new Rect();
        this.getBinding().r.getGlobalVisibleRect(rect0);
        com.iloen.melon.player.video.s s0 = new com.iloen.melon.player.video.s(6, rational0, rect0);
        LogConstantsKt.buildDebug(this.g, true, s0);
        pictureInPictureParams$Builder0.setSourceRectHint(rect0);
        pictureInPictureParams$Builder0.setAspectRatio(rational0);
        if(z) {
            com.airbnb.lottie.utils.a.k(pictureInPictureParams$Builder0);
        }
        else {
            com.airbnb.lottie.utils.a.w(pictureInPictureParams$Builder0);
        }
        PictureInPictureParams pictureInPictureParams0 = pictureInPictureParams$Builder0.build();
        q.f(pictureInPictureParams0, "build(...)");
        return pictureInPictureParams0;
    }

    public static PictureInPictureParams getPictureInPictureParams$default(VideoMainFrameFragment videoMainFrameFragment0, Rational rational0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            rational0 = videoMainFrameFragment0.o().getVideoRatio();
        }
        if((v & 2) != 0) {
            z = videoMainFrameFragment0.getPlayerUseCase().n();
        }
        return videoMainFrameFragment0.getPictureInPictureParams(rational0, z);
    }

    @NotNull
    public final z getPlayerController() {
        z z0 = this.playerController;
        if(z0 != null) {
            return z0;
        }
        q.m("playerController");
        throw null;
    }

    @NotNull
    public final ob.z getPlayerUseCase() {
        ob.z z0 = this.playerUseCase;
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
    public final s getRemotePlayerManager() {
        s s0 = this.remotePlayerManager;
        if(s0 != null) {
            return s0;
        }
        q.m("remotePlayerManager");
        throw null;
    }

    @Nullable
    public final k getVideoStatusListener() {
        return this.f;
    }

    @Override  // com.iloen.melon.player.video.FloatingFragment
    public boolean isFullCover() {
        LiveViewModel liveViewModel0 = this.o();
        return liveViewModel0.getCurrentPlaylistId().isVideoType() && !liveViewModel0.isMiniPlayerMode();
    }

    public final void m(boolean z) {
        l0 l00 = this.getChildFragmentManager();
        q.f(l00, "getChildFragmentManager(...)");
        if(z) {
            while(l00.J() > 0 && !(l00.D(this.getBinding().m.getId()) instanceof VideoPlaylistFragment)) {
                l00.X();
            }
            return;
        }
        l00.Y(-1, 1);
    }

    public final BottomSheetBehavior n() {
        BottomSheetBehavior bottomSheetBehavior0 = BottomSheetBehavior.D(this.getBinding().n);
        q.f(bottomSheetBehavior0, "from(...)");
        return bottomSheetBehavior0;
    }

    public final LiveViewModel o() {
        return (LiveViewModel)this.h.getValue();
    }

    @Override  // com.iloen.melon.player.video.FloatingFragment
    public boolean onBackPressed() {
        if(this.isAdded()) {
            if(this.getChildFragmentManager().J() > 0) {
                int v = this.getChildFragmentManager().J();
                if(v > 0) {
                    l0 l00 = this.getChildFragmentManager();
                    androidx.fragment.app.a a0 = o.f(l00, l00);
                    a0.p = true;
                    androidx.fragment.app.a a1 = this.getChildFragmentManager().I(v - 1);
                    q.f(a1, "getBackStackEntryAt(...)");
                    I i0 = this.getChildFragmentManager().E(a1.i);
                    if(i0 != null) {
                        a0.d(i0);
                        a0.f(i0);
                        a0.l(true, true);
                        this.getChildFragmentManager().W(a1.t);
                    }
                }
                return true;
            }
            if(this.o().isExpendedPlayerMode()) {
                this.o().updateCurrentVideoStatus(VideoStatus.MiniMode, "VideoMainFrameFragment - onBackPressed");
                return true;
            }
        }
        return false;
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        a7.c.a().b("VideoMainFrameFragment onConfigurationChanged() - " + this.hashCode());
        FragmentActivity fragmentActivity0 = this.getActivity();
        boolean z = false;
        boolean z1 = fragmentActivity0 == null ? false : fragmentActivity0.isInMultiWindowMode();
        if(configuration0.orientation == 1) {
            z = true;
        }
        else if(z1) {
            this.o().updateCurrentVideoStatus(VideoStatus.FullScreen, "VideoMainFrameFragment - onConfigurationChanged()");
        }
        this.o().updateScreenOrientation(z);
        FoldingFeatureAndScreenLayout videoViewModel$FoldingFeatureAndScreenLayout0 = (FoldingFeatureAndScreenLayout)this.o().getFoldingFeature().getValue();
        if(videoViewModel$FoldingFeatureAndScreenLayout0 != null && videoViewModel$FoldingFeatureAndScreenLayout0.getScreenLayout() == configuration0.screenLayout) {
            return;
        }
        this.o().updateFoldingState(null);
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null && bundle1.getBoolean("argIsFullScreen")) {
            this.o().updateCurrentVideoStatus(VideoStatus.FullScreen, "VideoMainFrameFragment - onCreate()");
        }
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1 videoMainFrameFragment$onCreate$1$10 = new we.n(null) {
                            public int r;
                            public final VideoMainFrameFragment w;

                            {
                                this.w = videoMainFrameFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
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
                                                com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.invokeSuspend..inlined.map.1.2 videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                                    public final Object emit(Object object0, Continuation continuation0) {
                                                        com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.invokeSuspend..inlined.map.1.2.1 videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10;
                                                        if(continuation0 instanceof com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.invokeSuspend..inlined.map.1.2.1) {
                                                            videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.invokeSuspend..inlined.map.1.2.1)continuation0;
                                                            int v = videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10.w;
                                                            if((v & 0x80000000) == 0) {
                                                                videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
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
                                                                videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                                            }
                                                        }
                                                        else {
                                                            videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
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
                                                        Object object1 = videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10.r;
                                                        ne.a a0 = ne.a.a;
                                                        switch(videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10.w) {
                                                            case 0: {
                                                                d5.n.D(object1);
                                                                videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                                return this.a.emit(((fc.a)object0).c, videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                                                Object object0 = this.a.collect(videoMainFrameFragment$onCreate$1$1$invokeSuspend$$inlined$map$1$20, continuation0);
                                                return object0 == ne.a.a ? object0 : H.a;
                                            }
                                        });
                                        com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.2 videoMainFrameFragment$onCreate$1$1$20 = new we.n(null) {
                                            public Object r;
                                            public final VideoMainFrameFragment w;

                                            {
                                                this.w = videoMainFrameFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.2(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((String)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(String s, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onCreate.1.1.2)this.create(s, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                String s = (String)this.r;
                                                d5.n.D(object0);
                                                VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                                                LogU.debug$default(videoMainFrameFragment0.g, "newMediaId: " + s, null, false, 6, null);
                                                if(videoMainFrameFragment0.o == null) {
                                                    LogU.debug$default(videoMainFrameFragment0.g, "lastProcessedMediaId is null, set to: " + s, null, false, 6, null);
                                                    videoMainFrameFragment0.o = s;
                                                    return H.a;
                                                }
                                                if(!q.b(videoMainFrameFragment0.o, s)) {
                                                    LogU.debug$default(videoMainFrameFragment0.g, "mediaId change to " + s + ", also clear back stack", null, false, 6, null);
                                                    videoMainFrameFragment0.o = s;
                                                    videoMainFrameFragment0.m(true);
                                                    return H.a;
                                                }
                                                LogU.debug$default(videoMainFrameFragment0.g, "same mediaId " + s, null, false, 6, null);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(flow0, videoMainFrameFragment$onCreate$1$1$20, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, androidx.lifecycle.s.d, videoMainFrameFragment$onCreate$1$10, this) == a0 ? a0 : H.a;
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
        a7.c.a().b("VideoMainFrameFragment onCreate() - " + this.hashCode());
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D04E3, viewGroup0, false);  // layout:melon_video_main_frame_layout
        int v = 0x7F0A0111;  // id:border_line
        View view1 = De.I.C(view0, 0x7F0A0111);  // id:border_line
        if(view1 != null) {
            v = 0x7F0A0120;  // id:bottom_margin_view
            View view2 = De.I.C(view0, 0x7F0A0120);  // id:bottom_margin_view
            if(view2 != null) {
                v = 0x7F0A02D8;  // id:cnt_tv_anim
                View view3 = De.I.C(view0, 0x7F0A02D8);  // id:cnt_tv_anim
                if(((OutlineTextView)view3) != null) {
                    v = 0x7F0A03D7;  // id:divider_for_landscape
                    View view4 = De.I.C(view0, 0x7F0A03D7);  // id:divider_for_landscape
                    if(((Guideline)view4) != null) {
                        v = 0x7F0A047F;  // id:explode_anim
                        View view5 = De.I.C(view0, 0x7F0A047F);  // id:explode_anim
                        if(((LottieAnimationView)view5) != null) {
                            v = 0x7F0A04E3;  // id:full_chat_frame
                            View view6 = De.I.C(view0, 0x7F0A04E3);  // id:full_chat_frame
                            if(((FragmentContainerView)view6) != null) {
                                v = 0x7F0A04E4;  // id:full_frame_container
                                View view7 = De.I.C(view0, 0x7F0A04E4);  // id:full_frame_container
                                if(((ConstraintLayout)view7) != null) {
                                    v = 0x7F0A052B;  // id:heart_anim
                                    View view8 = De.I.C(view0, 0x7F0A052B);  // id:heart_anim
                                    if(((LottieAnimationView)view8) != null && ((ConstraintLayout)De.I.C(view0, 0x7F0A07C6)) != null) {  // id:main_area
                                        v = 0x7F0A07CE;  // id:main_seekbar
                                        View view9 = De.I.C(view0, 0x7F0A07CE);  // id:main_seekbar
                                        if(((VideoSeekBarAndDuration)view9) != null) {
                                            v = 0x7F0A07CF;  // id:main_transition_area
                                            View view10 = De.I.C(view0, 0x7F0A07CF);  // id:main_transition_area
                                            if(((ConstraintLayout)view10) != null) {
                                                v = 0x7F0A080A;  // id:minimum_height_area
                                                View view11 = De.I.C(view0, 0x7F0A080A);  // id:minimum_height_area
                                                if(view11 != null && ((RelativeLayout)De.I.C(view0, 0x7F0A0A53)) != null) {  // id:seekbar_container
                                                    v = 0x7F0A0A66;  // id:separated_frame
                                                    View view12 = De.I.C(view0, 0x7F0A0A66);  // id:separated_frame
                                                    if(((FragmentContainerView)view12) != null && ((CoordinatorLayout)De.I.C(view0, 0x7F0A0A67)) != null) {  // id:separated_frame_coordinator
                                                        v = 0x7F0A0A68;  // id:separated_frame_wrapper
                                                        View view13 = De.I.C(view0, 0x7F0A0A68);  // id:separated_frame_wrapper
                                                        if(((RelativeLayout)view13) != null) {
                                                            v = 0x7F0A0DB5;  // id:video_mini_player
                                                            View view14 = De.I.C(view0, 0x7F0A0DB5);  // id:video_mini_player
                                                            if(((VideoMiniPlayer)view14) != null) {
                                                                v = 0x7F0A0DB7;  // id:video_player_container
                                                                View view15 = De.I.C(view0, 0x7F0A0DB7);  // id:video_player_container
                                                                if(((FragmentContainerView)view15) != null) {
                                                                    v = 0x7F0A0DB8;  // id:video_player_frame
                                                                    View view16 = De.I.C(view0, 0x7F0A0DB8);  // id:video_player_frame
                                                                    if(((CardView)view16) != null) {
                                                                        this.j = new n2(((VideoMotionLayout)view0), view1, view2, ((OutlineTextView)view3), ((Guideline)view4), ((LottieAnimationView)view5), ((FragmentContainerView)view6), ((ConstraintLayout)view7), ((LottieAnimationView)view8), ((VideoSeekBarAndDuration)view9), ((ConstraintLayout)view10), view11, ((FragmentContainerView)view12), ((RelativeLayout)view13), ((VideoMotionLayout)view0), ((VideoMiniPlayer)view14), ((FragmentContainerView)view15), ((CardView)view16));
                                                                        n2 n20 = this.getBinding();
                                                                        q.f(n20.a, "getRoot(...)");
                                                                        return n20.a;
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        LogU.debug$default(this.g, "onDestroy()", null, false, 6, null);
        CoroutineScope coroutineScope0 = this.k;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "Fragment destroyed", null, 2, null);
        }
        Job job0 = this.l;
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "Fragment onDestroy", null, 2, null);
        }
        i i0 = this.i;
        if(((VideoChatViewModel)i0.getValue()).isConnected()) {
            ((VideoChatViewModel)i0.getValue()).disconnect();
        }
        if(Y.z(MelonAppBase.Companion) && !this.o().getCurrentPlaylistId().isVideoType()) {
            this.startActivity(new Intent(this.getContext(), MusicBrowserActivity.class));
        }
        if(!this.o().isMiniPlayerMode()) {
            this.postFragmentForegroundEventManually();
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            PictureInPictureParams.Builder pictureInPictureParams$Builder0 = new PictureInPictureParams.Builder();
            com.airbnb.lottie.utils.a.w(pictureInPictureParams$Builder0);
            PictureInPictureParams pictureInPictureParams0 = pictureInPictureParams$Builder0.build();
            q.f(pictureInPictureParams0, "build(...)");
            fragmentActivity0.setPictureInPictureParams(pictureInPictureParams0);
        }
        super.onDestroy();
        a7.c.a().b("VideoMainFrameFragment onDestroy() - " + this.hashCode());
    }

    @Override  // androidx.fragment.app.I
    public void onDestroyView() {
        LogU.debug$default(this.g, "onDestroyView()", null, false, 6, null);
        CoroutineScope coroutineScope0 = this.k;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "View destroyed", null, 2, null);
        }
        Job job0 = this.l;
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "View onDestroyView", null, 2, null);
        }
        CheerAnimationManager cheerAnimationManager0 = this.B;
        if(cheerAnimationManager0 != null) {
            cheerAnimationManager0.clear();
        }
        this.r();
        this.n().t0.remove(this.D);
        super.onDestroyView();
        this.j = null;
        a7.c.a().b("VideoMainFrameFragment onDestroyView() - " + this.hashCode());
    }

    @Override  // androidx.fragment.app.I
    public void onPictureInPictureModeChanged(boolean z) {
        super.onPictureInPictureModeChanged(z);
        MelonAppBase.Companion.getClass();
        t.a().setAppPip(z);
        this.o().onPictureInPictureModeChanged(z);
        if(z) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            Pipable pipable0 = fragmentActivity0 instanceof Pipable ? ((Pipable)fragmentActivity0) : null;
            if(pipable0 != null) {
                pipable0.onPipModeOn();
            }
        }
        if(!z && this.getLifecycle().b() == androidx.lifecycle.s.c) {
            Context context0 = this.getContext();
            if(context0 != null) {
                q.g(Actor.Normal, "actor");
                Intent intent0 = w.u("com.iloen.melon.intent.action.playservice.pause").putExtra("com.iloen.melon.intent.extra.actor", Actor.Normal).setData(new Uri.Builder().appendPath("Normal").build());
                q.f(intent0, "setData(...)");
                ServiceUtilKt.startForegroundServiceWithLog(context0, intent0, "VideoMainFrameFragment.onPictureInPictureModeChanged");
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onStart() {
        super.onStart();
        n2 n20 = this.getBinding();
        y y0 = f0.f(this);
        n20.p.startControllerUI(y0);
        a7.c.a().b("VideoMainFrameFragment onStart() - " + this.hashCode());
    }

    @Override  // androidx.fragment.app.I
    public void onStop() {
        super.onStop();
        this.getBinding().p.stopControllerUI();
        a7.c.a().b("VideoMainFrameFragment onStop() - " + this.hashCode());
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.o().updateScreenOrientation(ScreenUtils.isOrientationPortrait(this.getContext()));
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new VideoMainFrameFragment.initFoldableFeature.1(this, null), 2, null);
        this.getChildFragmentManager().o.add(this.E);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new VideoMainFrameFragment.setChildFragments.1(this, null), 3, null);
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new VideoMainFrameFragment.setChildFragments.2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new VideoMainFrameFragment.setFullChatFragment.1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new VideoMainFrameFragment.setFullChatFragment.2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new VideoMainFrameFragment.setFullChatFragment.3(this, null), 3, null);
        CheerAnimationManager cheerAnimationManager0 = this.B;
        if(cheerAnimationManager0 != null) {
            cheerAnimationManager0.clear();
        }
        n2 n20 = this.getBinding();
        n2 n21 = this.getBinding();
        n2 n22 = this.getBinding();
        this.B = new CheerAnimationManager(n20.i, n21.f, n22.d, this);
        ((LiveViewModel)this.h.getValue()).getHeartAnimationEvent().observe(this.getViewLifecycleOwner(), new VideoMainFrameFragmentKt.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.Y(this, 1)));
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new VideoMainFrameFragment.setCheerView.2(this, null), 3, null);
        n2 n23 = this.getBinding();
        D d2 = this.getViewLifecycleOwner();
        q.f(d2, "getViewLifecycleOwner(...)");
        LiveViewModel liveViewModel0 = this.o();
        n23.j.initSeekbar(d2, liveViewModel0);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new VideoMainFrameFragment.setMotionLayout.1(this, null), 2, null);
        n2 n24 = this.getBinding();
        a0 a00 = new a0(this);
        n24.o.addOnLayoutChangeListener(a00);
        this.o().getOrientationSetter().observe(this.getViewLifecycleOwner(), new VideoMainFrameFragmentKt.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.Y(this, 0)));
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2.1 videoMainFrameFragment$onViewCreated$2$10 = new we.n(null) {
                            public int r;
                            public final VideoMainFrameFragment w;

                            {
                                this.w = videoMainFrameFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.o().getVideoStatus();
                                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.2.1.1 videoMainFrameFragment$onViewCreated$2$1$10 = new FlowCollector() {
                                            public final VideoMainFrameFragment a;

                                            {
                                                this.a = videoMainFrameFragment0;
                                            }

                                            public final Object emit(VideoStatus videoStatus0, Continuation continuation0) {
                                                k k0 = this.a.getVideoStatusListener();
                                                if(k0 != null) {
                                                    k0.invoke(videoStatus0);
                                                }
                                                return H.a;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((VideoStatus)object0), continuation0);
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoMainFrameFragment$onViewCreated$2$1$10, this) == a0) {
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
                        };
                        this.r = 1;
                        return f0.j(d0, androidx.lifecycle.s.d, videoMainFrameFragment$onViewCreated$2$10, this) == a0 ? a0 : H.a;
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
        BuildersKt__Builders_commonKt.launch$default(f0.f(d4), null, null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.o().getCurrentVideoPlayable();
                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1 videoMainFrameFragment$onViewCreated$3$10 = new we.n(null) {
                            public Object r;
                            public final VideoMainFrameFragment w;

                            {
                                this.w = videoMainFrameFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Playable)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Playable playable0 = (Playable)this.r;
                                d5.n.D(object0);
                                VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                                Job job0 = videoMainFrameFragment0.l;
                                if(job0 != null) {
                                    JobKt__JobKt.cancel$default(job0, "change playable", null, 2, null);
                                }
                                VideoMainFrameFragment.access$getChatViewModel(videoMainFrameFragment0).disconnect();
                                H h0 = H.a;
                                if(playable0 != null && playable0.getLiveSeq() != null && playable0.isOnAir()) {
                                    videoMainFrameFragment0.l = BuildersKt__Builders_commonKt.launch$default(f0.f(videoMainFrameFragment0), null, null, new we.n(playable0, null) {
                                        public final Playable B;
                                        public int r;
                                        public final VideoMainFrameFragment w;

                                        {
                                            this.w = videoMainFrameFragment0;
                                            this.B = playable0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1.1(this.w, this.B, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            ne.a a0 = ne.a.a;
                                            switch(this.r) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    D d0 = this.w.getViewLifecycleOwner();
                                                    q.f(d0, "getViewLifecycleOwner(...)");
                                                    com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1.1.1 videoMainFrameFragment$onViewCreated$3$1$1$10 = new we.n(this.B, null) {
                                                        public final Playable B;
                                                        public int r;
                                                        public final VideoMainFrameFragment w;

                                                        {
                                                            this.w = videoMainFrameFragment0;
                                                            this.B = playable0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1.1.1(this.w, this.B, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.3.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            ne.a a0 = ne.a.a;
                                                            switch(this.r) {
                                                                case 0: {
                                                                    d5.n.D(object0);
                                                                    VideoMainFrameFragment.access$getChatViewModel(this.w).clearMessageList(true);
                                                                    VideoChatViewModel videoChatViewModel0 = VideoMainFrameFragment.access$getChatViewModel(this.w);
                                                                    q.f("", "getLiveSeq(...)");
                                                                    this.r = 1;
                                                                    return videoChatViewModel0.joinChatRoom("", this) == a0 ? a0 : H.a;
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
                                                    return f0.j(d0, androidx.lifecycle.s.c, videoMainFrameFragment$onViewCreated$3$1$1$10, this) == a0 ? a0 : H.a;
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
                                return h0;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoMainFrameFragment$onViewCreated$3$10, this) == a0 ? a0 : H.a;
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
        D d5 = this.getViewLifecycleOwner();
        q.f(d5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d5), null, null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.4(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = VideoMainFrameFragment.access$getChatViewModel(this.w).getUseChatSdkInfo();
                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.4.1 videoMainFrameFragment$onViewCreated$4$10 = new FlowCollector() {
                            public final VideoMainFrameFragment a;

                            {
                                this.a = videoMainFrameFragment0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                VideoMainFrameFragment.access$getLiveViewModel(this.a).updateHasLiveChat(z);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(videoMainFrameFragment$onViewCreated$4$10, this) == a0) {
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
        D d6 = this.getViewLifecycleOwner();
        q.f(d6, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d6), null, null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5.1 videoMainFrameFragment$onViewCreated$5$10 = new we.n(null) {
                            public int r;
                            public final VideoMainFrameFragment w;

                            {
                                this.w = videoMainFrameFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.o().isOrientationPortrait();
                                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.5.1.1 videoMainFrameFragment$onViewCreated$5$1$10 = new FlowCollector() {
                                            public final VideoMainFrameFragment a;

                                            {
                                                this.a = videoMainFrameFragment0;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                            }

                                            public final Object emit(boolean z, Continuation continuation0) {
                                                VideoMainFrameFragment.access$adjustChatFrameLayout(this.a, z);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoMainFrameFragment$onViewCreated$5$1$10, this) == a0) {
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
                        };
                        this.r = 1;
                        return f0.j(d0, androidx.lifecycle.s.d, videoMainFrameFragment$onViewCreated$5$10, this) == a0 ? a0 : H.a;
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
        D d7 = this.getViewLifecycleOwner();
        q.f(d7, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d7), Dispatchers.getMain(), null, new we.n(null) {
            public int r;
            public final VideoMainFrameFragment w;

            {
                this.w = videoMainFrameFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1 videoMainFrameFragment$onViewCreated$6$10 = new we.n(null) {
                            public int r;
                            public final VideoMainFrameFragment w;

                            {
                                this.w = videoMainFrameFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Flow flow0 = FlowKt.distinctUntilChanged(FlowKt.combine(this.w.o().isVideoPortraitRatio(), this.w.getPlayerUseCase().h(), new we.o(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                            public boolean r;
                                            public boolean w;

                                            @Override  // we.o
                                            public Object invoke(Object object0, Object object1, Object object2) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Boolean)object1).booleanValue(), ((Continuation)object2));
                                            }

                                            public final Object invoke(boolean z, boolean z1, Continuation continuation0) {
                                                com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1.1 videoMainFrameFragment$onViewCreated$6$1$10 = new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                                videoMainFrameFragment$onViewCreated$6$1$10.r = z;
                                                videoMainFrameFragment$onViewCreated$6$1$10.w = z1;
                                                return videoMainFrameFragment$onViewCreated$6$1$10.invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                boolean z = this.r;
                                                boolean z1 = this.w;
                                                d5.n.D(object0);
                                                return new m(Boolean.valueOf(z), Boolean.valueOf(z1));
                                            }
                                        }));
                                        com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1.2 videoMainFrameFragment$onViewCreated$6$1$20 = new we.n(null) {
                                            public Object r;
                                            public final VideoMainFrameFragment w;

                                            {
                                                this.w = videoMainFrameFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1.2(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(m m0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoMainFrameFragment.onViewCreated.6.1.2)this.create(m0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((m)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                m m0 = (m)this.r;
                                                d5.n.D(object0);
                                                VideoMainFrameFragment videoMainFrameFragment0 = this.w;
                                                Object object1 = m0.b;
                                                LogU.debug$default(videoMainFrameFragment0.g, "update PictureInPictureParams, isVideoPortrait: " + m0.a + ", isPlaying: " + object1, null, false, 6, null);
                                                FragmentActivity fragmentActivity0 = videoMainFrameFragment0.getActivity();
                                                if(fragmentActivity0 != null) {
                                                    fragmentActivity0.setPictureInPictureParams(VideoMainFrameFragment.getPictureInPictureParams$default(videoMainFrameFragment0, null, ((Boolean)object1).booleanValue(), 1, null));
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(flow0, videoMainFrameFragment$onViewCreated$6$1$20, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, androidx.lifecycle.s.d, videoMainFrameFragment$onViewCreated$6$10, this) == a0 ? a0 : H.a;
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
        a7.c.a().b("VideoMainFrameFragment onViewCreated() - " + this.hashCode());
        this.o().collectPipPvLog();
    }

    @Override  // com.iloen.melon.player.video.FloatingFragment
    public void onWindowFocusChanged(boolean z) {
    }

    public final void openVideoPlayer(boolean z, boolean z1) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(z, z1, null) {
            public final boolean B;
            public final VideoMainFrameFragment r;
            public final boolean w;

            {
                this.r = videoMainFrameFragment0;
                this.w = z;
                this.B = z1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMainFrameFragment.openVideoPlayer.1(this.r, this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMainFrameFragment.openVideoPlayer.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                VideoMainFrameFragment videoMainFrameFragment0 = this.r;
                if(videoMainFrameFragment0.isAdded() && videoMainFrameFragment0.getContext() != null) {
                    videoMainFrameFragment0.o().updateCurrentVideoStatus((this.w ? VideoStatus.FullScreen : VideoStatus.Expand), "VideoMainFrameFragment - openVideoPlayer");
                    if(this.B) {
                        n2 n20 = videoMainFrameFragment0.getBinding();
                        com.iloen.melon.player.video.q q0 = new com.iloen.melon.player.video.q(videoMainFrameFragment0, 1);
                        n20.o.post(q0);
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    public static void openVideoPlayer$default(VideoMainFrameFragment videoMainFrameFragment0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z1 = false;
        }
        videoMainFrameFragment0.openVideoPlayer(z, z1);
    }

    public final void p() {
        D0 d00;
        LogU.debug$default(this.g, "hideSystemUi()", null, false, 6, null);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Window window0 = fragmentActivity0.getWindow();
            if(window0 != null) {
                b b0 = new b(this.getBinding().a);
                int v = Build.VERSION.SDK_INT;
                if(v >= 35) {
                    d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v >= 30) {
                    d00 = new D0(window0, b0);
                }
                else {
                    d00 = new C0(window0, b0);
                }
                d00.G(0x20F);
                d00.S();
            }
        }
    }

    public final void q(boolean z) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
        if(musicBrowserActivity0 != null) {
            musicBrowserActivity0.setRootViewBackgroundColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F06002F : 0x7F06047D)));  // color:black
            if(z) {
                musicBrowserActivity0.setMainContainerWindowInsetsListener(new e(22));
                return;
            }
            musicBrowserActivity0.setMainContainerWindowInsetsListener(new e(23));
        }
    }

    public final void r() {
        D0 d00;
        LogU.debug$default(this.g, "showSystemUi()", null, false, 6, null);
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Window window0 = fragmentActivity0.getWindow();
            if(window0 != null) {
                b b0 = new b(this.getBinding().a);
                int v = Build.VERSION.SDK_INT;
                if(v >= 35) {
                    d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v >= 30) {
                    d00 = new D0(window0, b0);
                }
                else {
                    d00 = new C0(window0, b0);
                }
                d00.U(0x207);
            }
        }
    }

    @Override  // a9.a
    public void removeFragment(@NotNull I i0) {
        q.g(i0, "fragment");
        l0 l00 = this.getChildFragmentManager();
        q.f(l00, "getChildFragmentManager(...)");
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
        a0.f(i0);
        a0.m();
        l0 l01 = this.getChildFragmentManager();
        l01.getClass();
        l01.x(new j0(l01, -1, 0), false);
    }

    public final void s(int v, int v1) {
        if(!((Boolean)this.o().isVideoPortraitRatio().getValue()).booleanValue() && !VideoViewModelKt.isHalfOpened(((FoldingFeatureAndScreenLayout)this.o().getFoldingFeature().getValue()))) {
            v = 0;
        }
        androidx.constraintlayout.widget.n n0 = new androidx.constraintlayout.widget.n();
        n0.g(this.getBinding().o.getConstraintSet(0x7F0A0471));  // id:expand
        n0.l(this.getBinding().k.getId()).e.d = v;
        this.getBinding().o.updateState(0x7F0A0471, n0);  // id:expand
        View view0 = this.getBinding().c;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).height = v1;
        view0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
    }

    public final void setMiniPlayerMode() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null && fragmentActivity0.isInPictureInPictureMode()) {
            LogU.debug$default(this.g, "setMiniPlayerMode() - Skipped because now we are in pip.", null, false, 6, null);
            return;
        }
        this.o().updateCurrentVideoStatus(VideoStatus.MiniMode, "VideoMainFrameFragment - setMiniPlayer");
    }

    public final void setPlayerController(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerController = z0;
    }

    public final void setPlayerUseCase(@NotNull ob.z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void setRemotePlayerManager(@NotNull s s0) {
        q.g(s0, "<set-?>");
        this.remotePlayerManager = s0;
    }

    public final void setVideoStatusListener(@Nullable k k0) {
        this.f = k0;
    }

    public final void t(boolean z) {
        if(z) {
            n2 n20 = this.getBinding();
            float f = (float)ViewUtilsKt.dpToPx(4);
            n20.r.setRadius(f);
            this.getBinding().b.setVisibility(0);
            this.getBinding().r.setImportantForAccessibility(4);
            return;
        }
        this.getBinding().r.setRadius(0.0f);
        this.getBinding().b.setVisibility(8);
        this.getBinding().r.setImportantForAccessibility(1);
    }
}

