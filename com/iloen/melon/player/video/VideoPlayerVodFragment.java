package com.iloen.melon.player.video;

import J8.o2;
import P4.a;
import Ub.u;
import Ub.v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.ControllerVideoListView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.context.more.m;
import ie.H;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.d;
import we.n;
import zd.Q;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J!\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u001A\u001A\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerVodFragment;", "Lcom/iloen/melon/player/video/VideoPlayerFragmentBase;", "<init>", "()V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "initController", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "setBindSeekBar", "onPlaybackComplete", "performMoreClick", "Lcom/iloen/melon/player/video/VideoStatus;", "status", "initVideoStatusUI", "(Lcom/iloen/melon/player/video/VideoStatus;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "getMoreBottomSheetItem", "()Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "playable", "Lzd/Q;", "getMoreBottomSheetType", "(Lcom/iloen/melon/playback/Playable;)Lzd/Q;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerVodFragment extends VideoPlayerFragmentBase {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerVodFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoPlayerVodFragment;", "newInstance", "()Lcom/iloen/melon/player/video/VideoPlayerVodFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoPlayerVodFragment newInstance() {
            return new VideoPlayerVodFragment();
        }
    }

    public static final int $stable;
    public Job B;
    @NotNull
    public static final Companion Companion;

    static {
        VideoPlayerVodFragment.Companion = new Companion(null);
        VideoPlayerVodFragment.$stable = 8;
    }

    public static final void access$updateMetaData(VideoPlayerVodFragment videoPlayerVodFragment0, Playable playable0) {
        if(playable0 == null) {
            videoPlayerVodFragment0.getClass();
            return;
        }
        videoPlayerVodFragment0.getBinding().g.r.setText("");
        o2 o20 = videoPlayerVodFragment0.getBinding();
        Context context0 = videoPlayerVodFragment0.getContext();
        Map map0 = playable0.getArtists();
        String s = StringUtils.INSTANCE.getArtistFormat(context0, map0, 2);
        o20.g.p.setText(s);
        if(videoPlayerVodFragment0.getVideoViewModel().isFullScreen()) {
            videoPlayerVodFragment0.getBinding().g.g.setVisibility((playable0.isAdult() ? 0 : 8));
        }
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    @NotNull
    public ArrayList getMoreBottomSheetItem() {
        ArrayList arrayList0 = new ArrayList();
        String s = this.getString(0x7F130239);  // string:ctx_menu_artist_info "아티스트 채널"
        q.f(s, "getString(...)");
        arrayList0.add(new VideoMoreItem(s, 6, 0, 4, null));
        String s1 = this.getString(0x7F13026D);  // string:ctx_menu_mv_program "프로그램 바로가기"
        q.f(s1, "getString(...)");
        arrayList0.add(new VideoMoreItem(s1, 1, 0, 4, null));
        String s2 = this.getString(0x7F130287);  // string:ctx_menu_repeat "반복 재생"
        q.f(s2, "getString(...)");
        arrayList0.add(new VideoMoreItem(s2, 7, 0, 4, null));
        String s3 = this.getString(0x7F130247);  // string:ctx_menu_download "다운로드"
        q.f(s3, "getString(...)");
        arrayList0.add(new VideoMoreItem(s3, 4, 0, 4, null));
        String s4 = this.getString(0x7F13028A);  // string:ctx_menu_share "공유하기"
        q.f(s4, "getString(...)");
        arrayList0.add(new VideoMoreItem(s4, 5, 0, 4, null));
        return arrayList0;
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    @NotNull
    public Q getMoreBottomSheetType(@NotNull Playable playable0) {
        RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE0;
        q.g(playable0, "playable");
        d d0 = (d)this.getVideoViewModel().getVdoGetMvProgInfoRes().getValue();
        u u0 = null;
        if(d0 == null) {
            melonTvVdoGetMvProgInfoRes$RESPONSE0 = null;
        }
        else {
            MelonTvVdoGetMvProgInfoRes melonTvVdoGetMvProgInfoRes0 = (MelonTvVdoGetMvProgInfoRes)d0.b;
            melonTvVdoGetMvProgInfoRes$RESPONSE0 = melonTvVdoGetMvProgInfoRes0 == null ? null : melonTvVdoGetMvProgInfoRes0.response;
        }
        Context context0 = this.getContext();
        if(context0 != null) {
            u0 = a.t(context0);
        }
        return u0 == null ? new m(playable0, melonTvVdoGetMvProgInfoRes$RESPONSE0, false) : new m(playable0, melonTvVdoGetMvProgInfoRes$RESPONSE0, ((v)u0).b());
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initController() {
        CharSequence charSequence0;
        super.initController();
        int v = 8;
        this.findViewById(0x7F0A0C12).setVisibility((this.getVideoViewModel().isFullScreen() ? 0 : 8));  // id:tv_artist
        this.findViewById(0x7F0A0648).setVisibility(8);  // id:iv_live_badge
        this.findViewById(0x7F0A0671).setVisibility(0);  // id:iv_prev
        this.findViewById(0x7F0A0655).setVisibility(0);  // id:iv_next
        this.findViewById(0x7F0A0664).setVisibility(8);  // id:iv_player_chat
        this.findViewById(0x7F0A0663).setVisibility(0);  // id:iv_player_autoplay
        View view0 = this.findViewById(0x7F0A0C55);  // id:tv_current_time
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view0).setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
        View view1 = this.findViewById(0x7F0A0D11);  // id:tv_slash
        q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
        Context context0 = this.getContext();
        if(context0 == null) {
            charSequence0 = null;
        }
        else {
            Resources resources0 = context0.getResources();
            charSequence0 = resources0 == null ? null : resources0.getText(0x7F130A13);  // string:slash "/"
        }
        ((TextView)view1).setText(charSequence0);
        if(this.getVideoViewModel().isFullScreen()) {
            View view2 = this.findViewById(0x7F0A05E0);  // id:iv_19_badge
            q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
            Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
            if(playable0 == null) {
                ((ImageView)view2).setVisibility(8);
            }
            else {
                if(playable0.isAdult()) {
                    v = 0;
                }
                ((ImageView)view2).setVisibility(v);
            }
        }
        Job job0 = this.B;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        this.B = BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final VideoPlayerVodFragment w;

            {
                this.w = videoPlayerVodFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1 videoPlayerVodFragment$initController$1$10 = new n(null) {
                            public int r;
                            public final VideoPlayerVodFragment w;

                            {
                                this.w = videoPlayerVodFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.getVideoViewModel().getCurrentVideoPlayable();
                                        com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1.1 videoPlayerVodFragment$initController$1$1$10 = new n(null) {
                                            public Object r;
                                            public final VideoPlayerVodFragment w;

                                            {
                                                this.w = videoPlayerVodFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1.1(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.initController.1.1.1)this.create(playable0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Playable)object0), ((Continuation)object1));
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                Playable playable0 = (Playable)this.r;
                                                d5.n.D(object0);
                                                VideoPlayerVodFragment.access$updateMetaData(this.w, playable0);
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(stateFlow0, videoPlayerVodFragment$initController$1$1$10, this) == a0 ? a0 : H.a;
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
                        return f0.j(d0, s.e, videoPlayerVodFragment$initController$1$10, this) == a0 ? a0 : H.a;
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

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initVideoStatusUI(@NotNull VideoStatus videoStatus0) {
        q.g(videoStatus0, "status");
        super.initVideoStatusUI(videoStatus0);
        if(videoStatus0 == VideoStatus.FullScreen) {
            Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
            if(playable0 != null) {
                this.getBinding().g.g.setVisibility((playable0.isAdult() ? 0 : 8));
            }
        }
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ControllerVideoListView controllerVideoListView0 = this.getVideoListView();
        if(controllerVideoListView0 != null) {
            controllerVideoListView0.a();
        }
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onPlaybackComplete() {
        ie.m m0;
        if(!this.isForeground()) {
            return;
        }
        if(this.getVideoViewModel().isMiniPlayerMode()) {
            m0 = new ie.m(Boolean.TRUE, "MiniPlayer Mode");
        }
        else {
            m0 = ((v)this.vodRepeatManager).b() ? new ie.m(Boolean.TRUE, "Repeat One") : new ie.m(Boolean.FALSE, "");
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(this, ((String)m0.b), null) {
            public final VideoPlayerVodFragment B;
            public final String D;
            public int r;
            public final boolean w;

            {
                this.w = z;
                this.B = videoPlayerVodFragment0;
                this.D = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerVodFragment.onPlaybackComplete.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.onPlaybackComplete.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        VideoPlayerVodFragment videoPlayerVodFragment0 = this.B;
                        if(this.w) {
                            LogConstantsKt.debugOnlyDebugMode(videoPlayerVodFragment0.getLog(), "handlePlaybackComplete() Next video immediately, reason: " + this.D);
                            z z0 = videoPlayerVodFragment0.getPlayerUseCase();
                            this.r = 1;
                            if(z0.r(this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            this.r = 2;
                            if(videoPlayerVodFragment0.showEndingView(this) == a0) {
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
        }, 3, null);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.mMenuId = "1000002968";
        this.getBinding().c.setVisibility(8);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final VideoPlayerVodFragment w;

            {
                this.w = videoPlayerVodFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getVideoViewModel().getRequestVdoRelateListSubscription();
                        this.r = 1;
                        return FlowKt.collect(stateFlow0, this) == a0 ? a0 : H.a;
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
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(null) {
            public int r;
            public final VideoPlayerVodFragment w;

            {
                this.w = videoPlayerVodFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = this.w.getVideoViewModel().isPip();
                        com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.2.1 videoPlayerVodFragment$onViewCreated$2$10 = new n(null) {
                            public boolean r;
                            public final VideoPlayerVodFragment w;

                            {
                                this.w = videoPlayerVodFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.2.1(this.w, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerVodFragment.onViewCreated.2.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                d5.n.D(object0);
                                if(z) {
                                    this.w.hideEndingView1AndDoAutoCnt();
                                }
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoPlayerVodFragment$onViewCreated$2$10, this) == a0 ? a0 : H.a;
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

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void performMoreClick() {
        Playable playable0 = (Playable)this.getVideoViewModel().getCurrentVideoPlayable().getValue();
        if(playable0 == null) {
            return;
        }
        String s = playable0.getMvid();
        if(playable0.isOriginLocal()) {
            ToastManager.showShort(0x7F1310EF);  // string:video_local_mv_more_toast_message "스트리밍 중인 비디오만 상세정보 확인이 가능합니다."
            return;
        }
        if(s != null && s.length() != 0) {
            LogU.debug$default(this.getLog(), "requestVideoInfo - showProgressDialog", null, false, 6, null);
            this.showProgressDialog();
            this.getVideoViewModel().requestVideoInfo(s);
        }
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void setBindSeekBar() {
        View view0 = this.findViewById(0x7F0A0A53);  // id:seekbar_container
        q.e(view0, "null cannot be cast to non-null type android.widget.RelativeLayout");
        ((RelativeLayout)view0).removeAllViews();
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        VideoSeekBarAndDuration videoSeekBarAndDuration0 = new VideoSeekBarAndDuration(context0, null);
        videoSeekBarAndDuration0.setType(Vod.INSTANCE);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        videoSeekBarAndDuration0.initSeekbar(d0, this.getVideoViewModel());
        this.setSeekBarView(videoSeekBarAndDuration0);
        ((RelativeLayout)view0).addView(this.getSeekBarView());
    }
}

