package com.iloen.melon.player.video;

import De.I;
import J8.K3;
import Ma.m;
import Qb.z;
import U4.F;
import U4.x;
import Ub.q;
import Ub.s;
import Ub.t;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.session.v;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RepeatingImageButton;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.StateView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.playback.VideoControllerHelper;
import d3.g;
import hc.l;
import ie.H;
import ie.r;
import java.util.List;
import k8.Y;
import k8.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import pd.i;
import we.n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001E2\u00020\u00012\u00020\u0002:\u0001\u001EB\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u000BJ\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001B\u0010\u001D\u001A\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/player/video/VideoMiniPlayer;", "Landroid/widget/FrameLayout;", "Lpd/i;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lie/H;", "onDetachedFromWindow", "()V", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "startControllerUI", "(Lkotlinx/coroutines/CoroutineScope;)V", "stopControllerUI", "Lcom/iloen/melon/playback/StateView;", "view", "", "onViewPreClick", "(Lcom/iloen/melon/playback/StateView;)Z", "onViewPostClick", "(Lcom/iloen/melon/playback/StateView;)V", "Lcom/iloen/melon/player/video/LiveViewModel;", "b", "Lie/j;", "getViewModel", "()Lcom/iloen/melon/player/video/LiveViewModel;", "viewModel", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoMiniPlayer extends FrameLayout implements i {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoMiniPlayer$Companion;", "", "", "TIARAKOG_PLAYERTYPE_MINIPLAYER", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final K3 a;
    public final r b;
    public CompletableJob c;
    public final z d;
    public final q e;
    public final l f;
    public final s g;
    public final VideoControllerHelper h;
    public final LogU i;

    static {
        VideoMiniPlayer.Companion = new Companion(null);
        VideoMiniPlayer.$stable = 8;
    }

    public VideoMiniPlayer(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        kotlin.jvm.internal.q.g(context0, "context");
        kotlin.jvm.internal.q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D08E6, this, false);  // layout:video_mini_player_layout
        this.addView(view0);
        int v = 0x7F0A00F5;  // id:barrier
        if(((Barrier)I.C(view0, 0x7F0A00F5)) != null) {  // id:barrier
            v = 0x7F0A014B;  // id:btn_close
            View view1 = I.C(view0, 0x7F0A014B);  // id:btn_close
            if(((ImageView)view1) != null) {
                v = 0x7F0A0175;  // id:btn_mini_next
                View view2 = I.C(view0, 0x7F0A0175);  // id:btn_mini_next
                if(((RepeatingImageButton)view2) != null) {
                    v = 0x7F0A0176;  // id:btn_mini_play
                    View view3 = I.C(view0, 0x7F0A0176);  // id:btn_mini_play
                    if(((ImageView)view3) != null) {
                        v = 0x7F0A04EA;  // id:gap_videoplayer
                        View view4 = I.C(view0, 0x7F0A04EA);  // id:gap_videoplayer
                        if(view4 != null) {
                            v = 0x7F0A054D;  // id:icon_live
                            View view5 = I.C(view0, 0x7F0A054D);  // id:icon_live
                            if(((ImageView)view5) != null) {
                                v = 0x7F0A0920;  // id:play_progress
                                View view6 = I.C(view0, 0x7F0A0920);  // id:play_progress
                                if(((ProgressBar)view6) != null && ((Flow)I.C(view0, 0x7F0A0B96)) != null) {  // id:title_container
                                    v = 0x7F0A0CB6;  // id:tv_mini_artist
                                    View view7 = I.C(view0, 0x7F0A0CB6);  // id:tv_mini_artist
                                    if(((MelonTextView)view7) != null) {
                                        v = 0x7F0A0CB7;  // id:tv_mini_song
                                        View view8 = I.C(view0, 0x7F0A0CB7);  // id:tv_mini_song
                                        if(((MelonTextView)view8) != null) {
                                            this.a = new K3(((ConstraintLayout)view0), ((ImageView)view1), ((RepeatingImageButton)view2), ((ImageView)view3), view4, ((ImageView)view5), ((ConstraintLayout)view0), ((ProgressBar)view6), ((MelonTextView)view7), ((MelonTextView)view8));
                                            this.b = g.Q(new c(this, 2));
                                            this.d = (z)((o)(((m)Y.e(context0, m.class)))).t.get();
                                            F.z(context0);
                                            this.e = F.x(context0);
                                            this.f = ((o)(((Ma.o)Y.e(context0, Ma.o.class)))).l();
                                            this.g = (s)((o)(((m)Y.e(context0, m.class)))).z.get();
                                            VideoControllerHelper videoControllerHelper0 = new VideoControllerHelper(context0);
                                            this.h = videoControllerHelper0;
                                            this.i = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "VideoMiniPlayer", false, null, 6, null);
                                            StateView stateView0 = StateView.getToggleView(((ImageView)view3), 0x7F080217, 0x7F080218);  // drawable:btn_miniplayer_pause
                                            kotlin.jvm.internal.q.f(stateView0, "getToggleView(...)");
                                            videoControllerHelper0.a(2, stateView0);
                                            StateView stateView1 = StateView.getView(((RepeatingImageButton)view2));
                                            kotlin.jvm.internal.q.f(stateView1, "getView(...)");
                                            videoControllerHelper0.a(1, stateView1);
                                            StateView stateView2 = StateView.getView(((ProgressBar)view6));
                                            kotlin.jvm.internal.q.f(stateView2, "getView(...)");
                                            videoControllerHelper0.a(14, stateView2);
                                            ((ImageView)view1).setOnClickListener(new e0(this, 0));
                                            Cb.i.b(((ConstraintLayout)view0), new e0(this, 1));
                                            ((ConstraintLayout)view0).setAccessibilityDelegate(new VideoMiniPlayer.bindControllerHelper.4(this));
                                            return;
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

    public static void a(VideoMiniPlayer videoMiniPlayer0) {
        videoMiniPlayer0.getViewModel().changeToDefaultPlaylist();
        videoMiniPlayer0.c(0x7F130D6E, TiaraLogType.DEFAULT);  // string:tiara_click_copy_player_closeminiplayer "미니플레이어 닫기"
    }

    public static final void access$handlePlaybackStateChanged(VideoMiniPlayer videoMiniPlayer0, int v) {
        String s2;
        List list0;
        String s = "";
        Playable playable0 = (Playable)videoMiniPlayer0.getViewModel().getCurrentVideoPlayable().getValue();
        K3 k30 = videoMiniPlayer0.a;
        int v1 = 8;
        if(playable0 == null) {
            k30.g.setText("곡 목록이 없습니다.");
            int v2 = ColorUtils.getColor(k30.g.getContext(), 0x7F060160);  // color:gray600s_support_high_contrast
            k30.g.setTextColor(v2);
            k30.f.setVisibility(8);
            return;
        }
        boolean z = !playable0.isLiveContent();
        String s1 = null;
        if(playable0.isLiveContent()) {
            LiveDetailRes liveDetailRes0 = (LiveDetailRes)videoMiniPlayer0.getViewModel().getLiveRes().getValue();
            if(liveDetailRes0 == null) {
                list0 = null;
            }
            else {
                Response liveDetailRes$Response0 = liveDetailRes0.response;
                if(liveDetailRes$Response0 == null) {
                    list0 = null;
                }
                else {
                    Live liveDetailRes$Response$Live0 = liveDetailRes$Response0.live;
                    list0 = liveDetailRes$Response$Live0 == null ? null : liveDetailRes$Response$Live0.artistList;
                }
            }
            s2 = ProtocolUtils.getArtistNames(list0);
        }
        else {
            s2 = "";
        }
        String s3 = videoMiniPlayer0.f.a();
        if(s3.length() != 0) {
            s = s3;
        }
        else if(s2 != null) {
            s = s2;
        }
        k30.g.setText("알 수 없는 곡");
        k30.g.setTextColor(ColorUtils.getColor(k30.g.getContext(), 0x7F06016D));  // color:gray900s
        MelonTextView melonTextView0 = k30.f;
        if(s.length() == 0) {
            melonTextView0.setVisibility(8);
        }
        else {
            melonTextView0.setText(s);
            melonTextView0.setVisibility(0);
        }
        int v3 = playable0.isOnAir() ? 0 : 8;
        k30.d.setVisibility(v3);
        RepeatingImageButton repeatingImageButton0 = k30.b;
        if(!playable0.isLiveContent()) {
            v1 = 0;
        }
        repeatingImageButton0.setVisibility(v1);
        ConstraintLayout constraintLayout0 = k30.e;
        StringBuilder stringBuilder0 = x.p("", ", ");
        if(((t)videoMiniPlayer0.g).c()) {
            stringBuilder0.append((videoMiniPlayer0.getContext() == null ? null : "연결중:"));
        }
        else {
            stringBuilder0.append("아티스트");
            stringBuilder0.append(":");
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", ");
        if(!playable0.isOnAir()) {
            if(!playable0.isLivePreView()) {
                if(videoMiniPlayer0.getContext() != null) {
                    s1 = "영상";
                }
            }
            else if(videoMiniPlayer0.getContext() != null) {
                s1 = "라이브 미리보기";
            }
        }
        else if(videoMiniPlayer0.getContext() != null) {
            s1 = "라이브";
        }
        stringBuilder0.append(s1);
        constraintLayout0.setContentDescription(stringBuilder0);
    }

    public static void b(VideoMiniPlayer videoMiniPlayer0) {
        videoMiniPlayer0.getViewModel().updateCurrentVideoStatus(VideoStatus.Expand, "VideoMiniPlayer - onClick");
    }

    public final void c(int v, TiaraLogType videoPlayerFragmentBase$TiaraLogType0) {
        Object object0 = this.getViewModel().getCurrentVideoPlayable().getValue();
        if(((Playable)object0) == null) {
            return;
        }
        boolean z = ((Playable)object0).isLiveContent();
        boolean z1 = ((Playable)object0).isOnAir();
        e1.m.F(new b0(this, videoPlayerFragmentBase$TiaraLogType0, ((Playable)object0).isLivePreView(), z1, v, z, ((Playable)object0))).track();
    }

    private final LiveViewModel getViewModel() {
        return (LiveViewModel)this.b.getValue();
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CompletableJob completableJob0 = this.c;
        if(completableJob0 != null) {
            DefaultImpls.cancel$default(completableJob0, null, 1, null);
        }
        LogU.info$default(this.h.b, "onUiDestroy()", null, false, 6, null);
        this.h.l.clear();
    }

    @Override  // pd.i
    public void onViewPostClick(@NotNull StateView stateView0) {
        kotlin.jvm.internal.q.g(stateView0, "view");
    }

    @Override  // pd.i
    public boolean onViewPreClick(@NotNull StateView stateView0) {
        kotlin.jvm.internal.q.g(stateView0, "view");
        switch(stateView0.getId()) {
            case 1: {
                this.c(0x7F130D74, TiaraLogType.DEFAULT);  // string:tiara_click_copy_player_next "다음"
                return false;
            }
            case 2: {
                v v0 = this.d.h();
                if((v0 == null ? false : v0.isPlaying())) {
                    this.c(0x7F130D76, TiaraLogType.DEFAULT);  // string:tiara_click_copy_player_pause "멈춤"
                    return false;
                }
                this.c(0x7F130D77, TiaraLogType.PLAY_VIDEO);  // string:tiara_click_copy_player_play "재생"
                return false;
            }
            default: {
                return false;
            }
        }
    }

    public final void startControllerUI(@NotNull CoroutineScope coroutineScope0) {
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutineScope");
        LogU.info$default(this.i, "startControllerUI()", null, false, 6, null);
        this.h.k = this;
        this.h.c();
        CompletableJob completableJob0 = this.c;
        if(completableJob0 != null) {
            DefaultImpls.cancel$default(completableJob0, null, 1, null);
        }
        CompletableJob completableJob1 = JobKt__JobKt.Job$default(null, 1, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain().plus(completableJob1), null, new n(null) {
            public int r;
            public final VideoMiniPlayer w;

            {
                this.w = videoMiniPlayer0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getViewModel().isVideoPortraitRatio();
                        com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.1.1 videoMiniPlayer$startControllerUI$2$1$10 = new n(null) {
                            public boolean r;
                            public final VideoMiniPlayer w;

                            {
                                this.w = videoMiniPlayer0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.1.1(this.w, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                d5.n.D(object0);
                                View view0 = this.w.a.c;
                                kotlin.jvm.internal.q.f(view0, "gapVideoplayer");
                                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                                if(viewGroup$LayoutParams0 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                                }
                                viewGroup$LayoutParams0.width = ViewUtilsKt.dpToPx((z ? 36.0f : 62.0f));
                                view0.setLayoutParams(viewGroup$LayoutParams0);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoMiniPlayer$startControllerUI$2$1$10, this) == a0 ? a0 : H.a;
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
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
            public int r;
            public final VideoMiniPlayer w;

            {
                this.w = videoMiniPlayer0;
                super(2, continuation0);
            }

            public static final Object access$invokeSuspend$handlePlaybackStateChanged(VideoMiniPlayer videoMiniPlayer0, int v, Continuation continuation0) {
                VideoMiniPlayer.access$handlePlaybackStateChanged(videoMiniPlayer0, v);
                return H.a;
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        kotlinx.coroutines.flow.Flow flow0 = FlowKt.distinctUntilChanged(new kotlinx.coroutines.flow.Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.invokeSuspend..inlined.map.1.2 videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.invokeSuspend..inlined.map.1.2.1 videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.invokeSuspend..inlined.map.1.2.1) {
                                            videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10.w;
                                            if((v & 0x80000000) == 0) {
                                                videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
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
                                                videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
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
                                        Object object1 = videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10.r;
                                        a a0 = a.a;
                                        switch(videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10.w) {
                                            case 0: {
                                                d5.n.D(object1);
                                                videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                return this.a.emit(new Integer(((fc.a)object0).a), videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                                Object object0 = this.a.collect(videoMiniPlayer$startControllerUI$2$2$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == a.a ? object0 : H.a;
                            }
                        });
                        com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.2 videoMiniPlayer$startControllerUI$2$2$20 = new n(4, VideoMiniPlayer.class, this.w, "handlePlaybackStateChanged", "handlePlaybackStateChanged(I)V") {  // 初始化器: Lkotlin/jvm/internal/a;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                            public final Object invoke(int v, Continuation continuation0) {
                                return com.iloen.melon.player.video.VideoMiniPlayer.startControllerUI.2.2.access$invokeSuspend$handlePlaybackStateChanged(((VideoMiniPlayer)this.receiver), v, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoMiniPlayer$startControllerUI$2$2$20, this) == a0 ? a0 : H.a;
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
        this.c = completableJob1;
    }

    public final void stopControllerUI() {
        VideoControllerHelper videoControllerHelper0 = this.h;
        videoControllerHelper0.k = null;
        LogU.info$default(videoControllerHelper0.b, "onUiStop()", null, false, 6, null);
        CoroutineScope coroutineScope0 = videoControllerHelper0.i;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "cancelCollectControllerState() Cancel", null, 2, null);
        }
        videoControllerHelper0.i = null;
        CompletableJob completableJob0 = this.c;
        if(completableJob0 != null) {
            DefaultImpls.cancel$default(completableJob0, null, 1, null);
        }
    }
}

