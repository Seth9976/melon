package com.iloen.melon.player.video;

import A9.f;
import A9.g;
import Cb.k;
import J8.o2;
import U4.F;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakaoent.leonplayer.core.model.data.player.LeonVideoProfile;
import com.melon.ui.popup.b;
import com.melon.ui.popup.context.more.j;
import gc.G;
import gc.l;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import zd.Q;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000F\u0010\n\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000F\u0010\u000B\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\u0003J!\u0010\u0010\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\r\u0010 \u001A\u00020\u0006¢\u0006\u0004\b \u0010\u0003J\u000F\u0010!\u001A\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\u0003¨\u0006#"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerLiveFragment;", "Lcom/iloen/melon/player/video/VideoPlayerFragmentBase;", "<init>", "()V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "setBindSeekBar", "initController", "performMoreClick", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "getMoreBottomSheetItem", "()Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "playable", "Lzd/Q;", "getMoreBottomSheetType", "(Lcom/iloen/melon/playback/Playable;)Lzd/Q;", "Lcom/iloen/melon/player/video/VideoStatus;", "status", "initVideoStatusUI", "(Lcom/iloen/melon/player/video/VideoStatus;)V", "requestHideRotateGuideView", "onPlaybackComplete", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerLiveFragment extends VideoPlayerFragmentBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerLiveFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoPlayerLiveFragment;", "newInstance", "()Lcom/iloen/melon/player/video/VideoPlayerLiveFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoPlayerLiveFragment newInstance() {
            return new VideoPlayerLiveFragment();
        }
    }

    public static final int $stable;
    public RESPONSE B;
    @NotNull
    public static final Companion Companion;
    public Job D;

    static {
        VideoPlayerLiveFragment.Companion = new Companion(null);
        VideoPlayerLiveFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    @NotNull
    public ArrayList getMoreBottomSheetItem() {
        ArrayList arrayList0 = new ArrayList();
        String s = this.getString(0x7F13022F);  // string:ctx_cast "출연진 보기"
        q.f(s, "getString(...)");
        arrayList0.add(new VideoMoreItem(s, 0, 0, 4, null));
        String s1 = this.getString(0x7F13026D);  // string:ctx_menu_mv_program "프로그램 바로가기"
        q.f(s1, "getString(...)");
        arrayList0.add(new VideoMoreItem(s1, 1, 0, 4, null));
        String s2 = this.getString(0x7F1302A1);  // string:ctx_setting_quality "화질 설정"
        q.f(s2, "getString(...)");
        arrayList0.add(new VideoMoreItem(s2, 3, 0, 4, null));
        String s3 = this.getString(0x7F13028A);  // string:ctx_menu_share "공유하기"
        q.f(s3, "getString(...)");
        arrayList0.add(new VideoMoreItem(s3, 5, 0, 4, null));
        return arrayList0;
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    @NotNull
    public Q getMoreBottomSheetType(@NotNull Playable playable0) {
        String s;
        q.g(playable0, "playable");
        LiveDetailRes liveDetailRes0 = (LiveDetailRes)this.getLiveViewModel().getLiveRes().getValue();
        LeonVideoProfile leonVideoProfile0 = null;
        Response liveDetailRes$Response0 = liveDetailRes0 == null ? null : liveDetailRes0.response;
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        G g0 = F.x(context0).a().i;
        if(g0 != null) {
            leonVideoProfile0 = ((l)g0).f.getCurrentVideoProfile();
        }
        if(leonVideoProfile0 == null) {
            s = this.getString(0x7F1310F3);  // string:video_quality_auto "자동"
            q.f(s, "getString(...)");
        }
        else {
            s = leonVideoProfile0.getSimpleName();
            if(s == null) {
                s = this.getString(0x7F1310F3);  // string:video_quality_auto "자동"
                q.f(s, "getString(...)");
            }
        }
        if(g0 != null) {
            List list0 = ((l)g0).f.getCurrentVideoProfiles();
            return list0 == null ? new j(playable0, liveDetailRes$Response0, s, ((boolean)0)) : new j(playable0, liveDetailRes$Response0, s, !list0.isEmpty());
        }
        return new j(playable0, liveDetailRes$Response0, s, ((boolean)0));
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initController() {
        CharSequence charSequence0;
        super.initController();
        this.findViewById(0x7F0A0648).setVisibility(0);  // id:iv_live_badge
        this.findViewById(0x7F0A0671).setVisibility(8);  // id:iv_prev
        this.findViewById(0x7F0A0655).setVisibility(8);  // id:iv_next
        this.findViewById(0x7F0A0663).setVisibility(8);  // id:iv_player_autoplay
        View view0 = this.findViewById(0x7F0A0C55);  // id:tv_current_time
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        Context context0 = this.getContext();
        if(context0 == null) {
            charSequence0 = null;
        }
        else {
            Resources resources0 = context0.getResources();
            charSequence0 = resources0 == null ? null : resources0.getText(0x7F1308BB);  // string:realtime "실시간"
        }
        ((MelonTextView)view0).setText(charSequence0);
        View view1 = this.findViewById(0x7F0A0C55);  // id:tv_current_time
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view1).setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06017C));  // color:green500s_support_high_contrast
        View view2 = this.findViewById(0x7F0A0D11);  // id:tv_slash
        q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view2).setText(null);
        View view3 = this.findViewById(0x7F0A0D30);  // id:tv_time
        q.e(view3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view3).setText(null);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initVideoStatusUI(@NotNull VideoStatus videoStatus0) {
        q.g(videoStatus0, "status");
        super.initVideoStatusUI(videoStatus0);
        if(!((Boolean)this.getLiveViewModel().getPollingAble().getValue()).booleanValue()) {
            this.getBinding().g.t.setVisibility(8);
        }
    }

    public final void o0() {
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment1;
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = this.getSongListBottomSheet();
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        boolean z = ((Boolean)this.getLiveViewModel().getControllerAllVisible().getValue()).booleanValue();
        this.getLiveViewModel().updateControllerAllVisible(Boolean.FALSE);
        RESPONSE liveTimedMetaSongRes$RESPONSE0 = this.B;
        if(liveTimedMetaSongRes$RESPONSE0 == null) {
            videoSongListBottomSheetFragment1 = null;
        }
        else {
            videoSongListBottomSheetFragment1 = new VideoSongListBottomSheetFragment(this.getLiveViewModel(), liveTimedMetaSongRes$RESPONSE0);
            videoSongListBottomSheetFragment1.setParentFragment(this);
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            l0 l00 = fragmentActivity0.getSupportFragmentManager();
            if(l00 != null) {
                if(videoSongListBottomSheetFragment1 != null) {
                    videoSongListBottomSheetFragment1.show(l00, "VideoSongListBottomSheetFragment");
                }
                if(videoSongListBottomSheetFragment1 != null) {
                    videoSongListBottomSheetFragment1.setShowControllerAfterClosing(z);
                }
                this.setSongListBottomSheet(videoSongListBottomSheetFragment1);
            }
        }
        VideoPlayerFragmentBase.sendTiaraLogPlayer$default(this, 0x7F130D45, null, false, 6, null);  // string:tiara_click_copy_live_song_list "선곡표"
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        VideoSongListBottomSheetFragment videoSongListBottomSheetFragment0 = this.getSongListBottomSheet();
        if(videoSongListBottomSheetFragment0 != null) {
            videoSongListBottomSheetFragment0.dismiss();
        }
        LiveViewModel liveViewModel0 = this.getLiveViewModel();
        FragmentActivity fragmentActivity0 = this.getActivity();
        liveViewModel0.updateMultiWindow((fragmentActivity0 == null ? false : fragmentActivity0.isInMultiWindowMode()));
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onPlaybackComplete() {
        if(this.isForeground()) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = this.getString(0x7F1304F7);  // string:live_complecation_popup_discription "종료된 라이브입니다."
            c c0 = new c(this, 4);
            b.d(b.a, l00, s, s1, false, false, false, null, null, null, c0, null, 0x5F8);
            return;
        }
        ToastManager.show(0x7F1304F7);  // string:live_complecation_popup_discription "종료된 라이브입니다."
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.mMenuId = "1000002967";
        View view1 = this.findViewById(0x7F0A0664);  // id:iv_player_chat
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
        int v = 8;
        ((MelonImageView)view1).setVisibility(8);
        View view2 = this.findViewById(0x7F0A0D50);  // id:tv_video_title
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view2).setVisibility(8);
        View view3 = this.findViewById(0x7F0A0DC0);  // id:view_cnt_container
        view3.setVisibility(8);
        View view4 = this.findViewById(0x7F0A0D52);  // id:tv_view_count
        q.e(view4, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        View view5 = this.findViewById(0x7F0A09BF);  // id:reaction_container
        view5.setVisibility(8);
        View view6 = this.findViewById(0x7F0A0CF8);  // id:tv_reaction_count
        q.e(view6, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        View view7 = this.findViewById(0x7F0A0129);  // id:bottom_song_container
        view7.setVisibility(8);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        f0.f(d0).a(new n(((MelonTextView)view2), view3, ((MelonTextView)view4), view7, view5, ((MelonTextView)view6), null) {
            public final MelonTextView B;
            public final View D;
            public final MelonTextView E;
            public final View G;
            public final View I;
            public final MelonTextView M;
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                this.B = melonTextView0;
                this.D = view0;
                this.E = melonTextView1;
                this.G = view1;
                this.I = view2;
                this.M = melonTextView2;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.1(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getVideoViewModel().getControllerState();
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.1.1 videoPlayerLiveFragment$onViewCreated$1$10 = new n(this.B, this.D, this.E, this.G, this.I, this.M, null) {
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                            public static final class WhenMappings {
                                public static final int[] $EnumSwitchMapping$0;

                                static {
                                    int[] arr_v = new int[ControllerStatus.values().length];
                                    try {
                                        arr_v[ControllerStatus.LIVE_FULL.ordinal()] = 1;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[ControllerStatus.LIVE_FULL_LAND.ordinal()] = 2;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                }
                            }

                            public final MelonTextView B;
                            public final View D;
                            public final MelonTextView E;
                            public final View G;
                            public final View I;
                            public final MelonTextView M;
                            public Object r;
                            public final VideoPlayerLiveFragment w;

                            {
                                this.w = videoPlayerLiveFragment0;
                                this.B = melonTextView0;
                                this.D = view0;
                                this.E = melonTextView1;
                                this.G = view1;
                                this.I = view2;
                                this.M = melonTextView2;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.1.1(this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(ControllerStatus controllerStatus0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.1.1)this.create(controllerStatus0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ControllerStatus)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ControllerStatus controllerStatus0 = (ControllerStatus)this.r;
                                d5.n.D(object0);
                                MelonTextView melonTextView0 = this.B;
                                View view0 = this.G;
                                View view1 = this.I;
                                View view2 = this.D;
                                switch(WhenMappings.$EnumSwitchMapping$0[controllerStatus0.ordinal()]) {
                                    case 1: 
                                    case 2: {
                                        VideoPlayerLiveFragment.p0(this.w, controllerStatus0, null, melonTextView0, view2, this.E, 2);
                                        VideoPlayerLiveFragment.r0(this.w, controllerStatus0, null, view0, 2);
                                        VideoPlayerLiveFragment.q0(this.w, controllerStatus0, null, view1, this.M, 2);
                                        Boolean boolean0 = (Boolean)this.w.getVideoViewModel().isLiked().getValue();
                                        this.w.getBinding().e.setChecked((boolean0 == null ? false : boolean0.booleanValue()));
                                        return H.a;
                                    }
                                    default: {
                                        melonTextView0.setVisibility(8);
                                        view2.setVisibility(8);
                                        view1.setVisibility(8);
                                        view0.setVisibility(8);
                                        return H.a;
                                    }
                                }
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoPlayerLiveFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
        });
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(null) {
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getLiveViewModel().getVisibilityRotateGuideView();
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.2.1 videoPlayerLiveFragment$onViewCreated$2$10 = new FlowCollector() {
                            public final VideoPlayerLiveFragment a;

                            {
                                this.a = videoPlayerLiveFragment0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                VideoPlayerLiveFragment videoPlayerLiveFragment0 = this.a;
                                LogU.debug$default(videoPlayerLiveFragment0.getLog(), "visibilityRotateGuideView " + z, null, false, 6, null);
                                videoPlayerLiveFragment0.getBinding().i.setVisibility((z ? 0 : 8));
                                if(z) {
                                    videoPlayerLiveFragment0.requestHideRotateGuideView();
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(videoPlayerLiveFragment$onViewCreated$2$10, this) == a0) {
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
        this.getLiveViewModel().getLiveRes().observe(this.getViewLifecycleOwner(), new VideoPlayerLiveFragment.sam.androidx_lifecycle_Observer.0(new Bd.F(this, ((MelonTextView)view2), view3, ((MelonTextView)view4), 11)));
        this.getLiveViewModel().getLikeCnt().observe(this.getViewLifecycleOwner(), new VideoPlayerLiveFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.n(this, view5, ((MelonTextView)view6), 5)));
        D d2 = this.getViewLifecycleOwner();
        VideoPlayerLiveFragment.sam.androidx_lifecycle_Observer.0 videoPlayerLiveFragment$sam$androidx_lifecycle_Observer$00 = new VideoPlayerLiveFragment.sam.androidx_lifecycle_Observer.0(new s(9, this, view7));
        f.h.observe(d2, videoPlayerLiveFragment$sam$androidx_lifecycle_Observer$00);
        this.getLiveViewModel().isLiked().observe(this.getViewLifecycleOwner(), new VideoPlayerLiveFragment.sam.androidx_lifecycle_Observer.0(new o0(this, 5)));
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(((MelonImageView)view1), null) {
            public final MelonImageView B;
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                this.B = melonImageView0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7.1 videoPlayerLiveFragment$onViewCreated$7$10 = new n(this.B, null) {
                            public final MelonImageView B;
                            public int r;
                            public final VideoPlayerLiveFragment w;

                            {
                                this.w = videoPlayerLiveFragment0;
                                this.B = melonImageView0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7.1(this.w, this.B, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.getLiveViewModel().isFullChatEnable();
                                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.7.1.1 videoPlayerLiveFragment$onViewCreated$7$1$10 = new FlowCollector() {
                                            public final MelonImageView a;

                                            {
                                                this.a = melonImageView0;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                            }

                                            public final Object emit(boolean z, Continuation continuation0) {
                                                this.a.setSelected(z);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoPlayerLiveFragment$onViewCreated$7$1$10, this) == a0) {
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
                        return f0.j(d0, androidx.lifecycle.s.d, videoPlayerLiveFragment$onViewCreated$7$10, this) == a0 ? a0 : H.a;
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
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(((MelonImageView)view1), null) {
            public final MelonImageView B;
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                this.B = melonImageView0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8(this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1 videoPlayerLiveFragment$onViewCreated$8$10 = new n(this.B, null) {
                            public final MelonImageView B;
                            public int r;
                            public final VideoPlayerLiveFragment w;

                            {
                                this.w = videoPlayerLiveFragment0;
                                this.B = melonImageView0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1(this.w, this.B, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.getLiveViewModel().isFullChatCreate();
                                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1.1 videoPlayerLiveFragment$onViewCreated$8$1$10 = new n(null) {
                                            public boolean r;
                                            public final MelonImageView w;

                                            {
                                                this.w = melonImageView0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1.1(this.w, continuation0);
                                                continuation1.r = ((Boolean)object0).booleanValue();
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.8.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                boolean z = this.r;
                                                d5.n.D(object0);
                                                this.w.setVisibility((z ? 0 : 8));
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, videoPlayerLiveFragment$onViewCreated$8$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, androidx.lifecycle.s.d, videoPlayerLiveFragment$onViewCreated$8$10, this) == a0 ? a0 : H.a;
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
        ((MelonImageView)view1).setOnClickListener(new m0(this, 1));
        ImageButton imageButton0 = this.getBinding().c;
        if(((Boolean)this.getLiveViewModel().getFullScreenCheerIconVisibility().getValue()).booleanValue()) {
            v = 0;
        }
        imageButton0.setVisibility(v);
        f0.f(this).a(new n(null) {
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.10(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.10)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getLiveViewModel().getFullScreenCheerIconVisibility();
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.10.1 videoPlayerLiveFragment$onViewCreated$10$10 = new FlowCollector() {
                            public final VideoPlayerLiveFragment a;

                            {
                                this.a = videoPlayerLiveFragment0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                this.a.getBinding().c.setVisibility((z ? 0 : 8));
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(videoPlayerLiveFragment$onViewCreated$10$10, this) == a0) {
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
        });
        o2 o20 = this.getBinding();
        m0 m00 = new m0(this, 2);
        o20.c.setOnClickListener(m00);
        D d3 = this.getViewLifecycleOwner();
        q.f(d3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new n(null) {
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.12(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.12)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getLiveViewModel().getPollingAble();
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.12.1 videoPlayerLiveFragment$onViewCreated$12$10 = new FlowCollector() {
                            public final VideoPlayerLiveFragment a;

                            {
                                this.a = videoPlayerLiveFragment0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                VideoPlayerLiveFragment videoPlayerLiveFragment0 = this.a;
                                if(videoPlayerLiveFragment0.getLiveViewModel().isFullScreen()) {
                                    videoPlayerLiveFragment0.getBinding().g.t.setVisibility((z ? 0 : 8));
                                    videoPlayerLiveFragment0.getBinding().g.l.setVisibility((z ? 0 : 8));
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(videoPlayerLiveFragment$onViewCreated$12$10, this) == a0) {
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
        D d4 = this.getViewLifecycleOwner();
        q.f(d4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d4), null, null, new n(null) {
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.13(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.13)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getLiveViewModel().getViewCnt();
                        com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.13.1 videoPlayerLiveFragment$onViewCreated$13$10 = new n(null) {
                            public Object r;
                            public final VideoPlayerLiveFragment w;

                            {
                                this.w = videoPlayerLiveFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.13.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((String)object0), ((Continuation)object1));
                            }

                            public final Object invoke(String s, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.onViewCreated.13.1)this.create(s, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s = (String)this.r;
                                d5.n.D(object0);
                                o2 o20 = this.w.getBinding();
                                Context context0 = this.w.requireContext();
                                q.f(context0, "requireContext(...)");
                                String s1 = k.a(context0, s);
                                o20.g.s.setText(s1);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoPlayerLiveFragment$onViewCreated$13$10, this) == a0 ? a0 : H.a;
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

    public static void p0(VideoPlayerLiveFragment videoPlayerLiveFragment0, ControllerStatus controllerStatus0, LiveDetailRes liveDetailRes0, TextView textView0, View view0, TextView textView1, int v) {
        if((v & 1) != 0) {
            controllerStatus0 = (ControllerStatus)videoPlayerLiveFragment0.getLiveViewModel().getControllerState().getValue();
        }
        if((v & 2) != 0) {
            liveDetailRes0 = (LiveDetailRes)videoPlayerLiveFragment0.getLiveViewModel().getLiveRes().getValue();
        }
        if(e.k.A(new ControllerStatus[]{ControllerStatus.LIVE_FULL, ControllerStatus.LIVE_FULL_LAND}).contains(controllerStatus0)) {
            if(liveDetailRes0 != null) {
                String s = liveDetailRes0.response.live.liveTitle;
                if(s == null || s.length() == 0) {
                    textView0.setVisibility(8);
                }
                else {
                    textView0.setVisibility((videoPlayerLiveFragment0.getVideoViewModel().isFullScreen() ? 0 : 8));
                    textView0.setText(liveDetailRes0.response.live.liveTitle);
                }
                if(((CharSequence)videoPlayerLiveFragment0.getLiveViewModel().getViewCnt().getValue()).length() == 0) {
                    view0.setVisibility(8);
                    return;
                }
                view0.setVisibility(0);
                String s1 = (String)videoPlayerLiveFragment0.getLiveViewModel().getViewCnt().getValue();
                Context context0 = videoPlayerLiveFragment0.requireContext();
                q.f(context0, "requireContext(...)");
                textView1.setText(k.a(context0, s1));
            }
            return;
        }
        textView0.setVisibility(8);
        view0.setVisibility(8);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void performMoreClick() {
        this.showMoreBottomSheet();
    }

    public static void q0(VideoPlayerLiveFragment videoPlayerLiveFragment0, ControllerStatus controllerStatus0, String s, View view0, TextView textView0, int v) {
        if((v & 1) != 0) {
            controllerStatus0 = (ControllerStatus)videoPlayerLiveFragment0.getLiveViewModel().getControllerState().getValue();
        }
        if((v & 2) != 0) {
            s = (String)videoPlayerLiveFragment0.getLiveViewModel().getLikeCnt().getValue();
        }
        if(e.k.A(new ControllerStatus[]{ControllerStatus.LIVE_FULL, ControllerStatus.LIVE_FULL_LAND}).contains(controllerStatus0)) {
            if(s != null && s.length() != 0) {
                view0.setVisibility(0);
                Context context0 = videoPlayerLiveFragment0.requireContext();
                q.f(context0, "requireContext(...)");
                textView0.setText(k.a(context0, s));
                return;
            }
            view0.setVisibility(8);
            return;
        }
        view0.setVisibility(8);
    }

    public static void r0(VideoPlayerLiveFragment videoPlayerLiveFragment0, ControllerStatus controllerStatus0, RESPONSE liveTimedMetaSongRes$RESPONSE0, View view0, int v) {
        float f1;
        float f;
        if((v & 1) != 0) {
            controllerStatus0 = (ControllerStatus)videoPlayerLiveFragment0.getLiveViewModel().getControllerState().getValue();
        }
        if((v & 2) != 0) {
            liveTimedMetaSongRes$RESPONSE0 = (RESPONSE)f.h.getValue();
        }
        if(e.k.A(new ControllerStatus[]{ControllerStatus.LIVE_FULL, ControllerStatus.LIVE_FULL_LAND}).contains(controllerStatus0)) {
            videoPlayerLiveFragment0.B = liveTimedMetaSongRes$RESPONSE0;
            TextView textView0 = null;
            SONG liveTimedMetaSongRes$SONG0 = liveTimedMetaSongRes$RESPONSE0 == null ? null : g.a(liveTimedMetaSongRes$RESPONSE0);
            if(liveTimedMetaSongRes$SONG0 == null) {
                videoPlayerLiveFragment0.getBinding().b.setVisibility(8);
                videoPlayerLiveFragment0.getBinding().j.setVisibility(8);
            }
            else {
                if(((Boolean)videoPlayerLiveFragment0.getLiveViewModel().getSongListVisibilityOutSideController().getValue()).booleanValue()) {
                    videoPlayerLiveFragment0.getBinding().b.setVisibility(0);
                    videoPlayerLiveFragment0.getBinding().j.setVisibility(0);
                }
                videoPlayerLiveFragment0.getLiveViewModel().requestLikeInfo(videoPlayerLiveFragment0.getContext(), liveTimedMetaSongRes$SONG0.songId);
                f0.f(videoPlayerLiveFragment0).a(new VideoPlayerLiveFragment.initSongListViewOutSideController.1(videoPlayerLiveFragment0, null));
                Context context0 = videoPlayerLiveFragment0.getContext();
                if(context0 != null) {
                    Glide.with(context0).load(liveTimedMetaSongRes$SONG0.albumImg).into(((MelonImageView)videoPlayerLiveFragment0.getBinding().l.c));
                }
                videoPlayerLiveFragment0.getBinding().n.setText(liveTimedMetaSongRes$SONG0.songName);
                o2 o20 = videoPlayerLiveFragment0.getBinding();
                String s = ProtocolUtils.getArtistNames(liveTimedMetaSongRes$SONG0.artistList);
                o20.m.setText(s);
                o2 o21 = videoPlayerLiveFragment0.getBinding();
                boolean z = q.b(videoPlayerLiveFragment0.getLiveViewModel().isLiked().getValue(), Boolean.TRUE);
                o21.e.setChecked(z);
                o2 o22 = videoPlayerLiveFragment0.getBinding();
                com.iloen.melon.player.video.l l0 = new com.iloen.melon.player.video.l(6, videoPlayerLiveFragment0, liveTimedMetaSongRes$SONG0);
                o22.e.setOnClickListener(l0);
                o2 o23 = videoPlayerLiveFragment0.getBinding();
                m0 m00 = new m0(videoPlayerLiveFragment0, 3);
                o23.j.setOnClickListener(m00);
            }
            RESPONSE liveTimedMetaSongRes$RESPONSE1 = videoPlayerLiveFragment0.B;
            ArrayList arrayList0 = liveTimedMetaSongRes$RESPONSE1 == null ? null : liveTimedMetaSongRes$RESPONSE1.songList;
            if(arrayList0 == null || arrayList0.isEmpty()) {
                view0.setVisibility(8);
                return;
            }
            view0.setVisibility(0);
            SONG liveTimedMetaSongRes$SONG1 = liveTimedMetaSongRes$RESPONSE1 == null ? null : g.a(liveTimedMetaSongRes$RESPONSE1);
            if(((Boolean)videoPlayerLiveFragment0.getLiveViewModel().isOrientationPortrait().getValue()).booleanValue()) {
                f = 26.0f;
                f1 = 20.0f;
            }
            else {
                f = 12.0f;
                f1 = 24.0f;
            }
            ViewUtilsKt.setMarginToDp$default(view0, f1, null, f1, f, 2, null);
            if(videoPlayerLiveFragment0.getSongListView() == null) {
                View view1 = ((ViewStub)view0.findViewById(0x7F0A0AF5)).inflate();  // id:stub_song_list
                q.e(view1, "null cannot be cast to non-null type android.widget.RelativeLayout");
                videoPlayerLiveFragment0.setSongListView(((RelativeLayout)view1));
            }
            RelativeLayout relativeLayout0 = videoPlayerLiveFragment0.getSongListView();
            View view2 = relativeLayout0 == null ? null : relativeLayout0.findViewById(0x7F0A0AAE);  // id:song_meta_container
            RelativeLayout relativeLayout1 = videoPlayerLiveFragment0.getSongListView();
            View view3 = relativeLayout1 == null ? null : relativeLayout1.findViewById(0x7F0A0B72);  // id:thumb_container
            MelonImageView melonImageView0 = view3 == null ? null : ((MelonImageView)view3.findViewById(0x7F0A069A));  // id:iv_thumb
            RelativeLayout relativeLayout2 = videoPlayerLiveFragment0.getSongListView();
            MelonTextView melonTextView0 = relativeLayout2 == null ? null : ((MelonTextView)relativeLayout2.findViewById(0x7F0A0D1B));  // id:tv_song_title
            RelativeLayout relativeLayout3 = videoPlayerLiveFragment0.getSongListView();
            MelonTextView melonTextView1 = relativeLayout3 == null ? null : ((MelonTextView)relativeLayout3.findViewById(0x7F0A0D15));  // id:tv_song_artist
            RelativeLayout relativeLayout4 = videoPlayerLiveFragment0.getSongListView();
            if(relativeLayout4 != null) {
                textView0 = (TextView)relativeLayout4.findViewById(0x7F0A0C5D);  // id:tv_default_song_list
            }
            if(liveTimedMetaSongRes$SONG1 == null) {
                if(textView0 != null) {
                    textView0.setVisibility(0);
                }
                if(view3 != null) {
                    view3.setVisibility(8);
                }
                if(view2 != null) {
                    view2.setVisibility(8);
                }
            }
            else {
                if(textView0 != null) {
                    textView0.setVisibility(8);
                }
                if(view3 != null) {
                    view3.setVisibility(0);
                }
                if(view2 != null) {
                    view2.setVisibility(0);
                }
                if(melonImageView0 != null) {
                    Context context1 = videoPlayerLiveFragment0.getContext();
                    if(context1 != null) {
                        Glide.with(context1).load(liveTimedMetaSongRes$SONG1.albumImg).into(melonImageView0);
                    }
                }
                if(melonTextView0 != null) {
                    melonTextView0.setText(liveTimedMetaSongRes$SONG1.songName);
                }
                if(melonTextView1 != null) {
                    melonTextView1.setText(ProtocolUtils.getArtistNames(liveTimedMetaSongRes$SONG1.artistList));
                }
            }
            ((RelativeLayout)view0.findViewById(0x7F0A0AA4)).setOnClickListener(new m0(videoPlayerLiveFragment0, 0));  // id:song_container
            RelativeLayout relativeLayout5 = videoPlayerLiveFragment0.getSongListView();
            if(relativeLayout5 != null) {
                relativeLayout5.setVisibility(0);
            }
            return;
        }
        view0.setVisibility(8);
    }

    public final void requestHideRotateGuideView() {
        Job job0 = this.D;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        this.D = BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final VideoPlayerLiveFragment w;

            {
                this.w = videoPlayerLiveFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLiveFragment.requestHideRotateGuideView.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLiveFragment.requestHideRotateGuideView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        if(DelayKt.delay(6000L, this) == a0) {
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
                this.w.getBinding().i.setVisibility(8);
                return H.a;
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void setBindSeekBar() {
        View view0 = this.findViewById(0x7F0A0A53);  // id:seekbar_container
        q.e(view0, "null cannot be cast to non-null type android.widget.RelativeLayout");
        ((RelativeLayout)view0).removeAllViews();
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        VideoSeekBarAndDuration videoSeekBarAndDuration0 = new VideoSeekBarAndDuration(context0, null);
        videoSeekBarAndDuration0.setType(new Live(false));
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        videoSeekBarAndDuration0.initSeekbar(d0, this.getVideoViewModel());
        this.setSeekBarView(videoSeekBarAndDuration0);
        ((RelativeLayout)view0).addView(this.getSeekBarView());
    }
}

