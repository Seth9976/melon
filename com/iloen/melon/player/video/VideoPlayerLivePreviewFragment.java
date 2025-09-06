package com.iloen.melon.player.video;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.ControllerVideoListView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Live;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.ui.popup.context.more.i;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import zd.Q;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000E\u0010\u0003J!\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u001F\u0010\u0019\u001A\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0003¨\u0006\""}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerLivePreviewFragment;", "Lcom/iloen/melon/player/video/VideoPlayerFragmentBase;", "<init>", "()V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "initController", "Lcom/iloen/melon/player/video/VideoStatus;", "status", "initVideoStatusUI", "(Lcom/iloen/melon/player/video/VideoStatus;)V", "performMoreClick", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "setBindSeekBar", "Ljava/util/ArrayList;", "Lcom/iloen/melon/player/video/VideoMoreBottomSheetFragment$VideoMoreItem;", "Lkotlin/collections/ArrayList;", "getMoreBottomSheetItem", "()Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "playable", "Lzd/Q;", "getMoreBottomSheetType", "(Lcom/iloen/melon/playback/Playable;)Lzd/Q;", "onPlaybackComplete", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlayerLivePreviewFragment extends VideoPlayerFragmentBase {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoPlayerLivePreviewFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoPlayerLivePreviewFragment;", "newInstance", "()Lcom/iloen/melon/player/video/VideoPlayerLivePreviewFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoPlayerLivePreviewFragment newInstance() {
            return new VideoPlayerLivePreviewFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        VideoPlayerLivePreviewFragment.Companion = new Companion(null);
        VideoPlayerLivePreviewFragment.$stable = 8;
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
        String s2 = this.getString(0x7F130230);  // string:ctx_live_alarm "라이브 알림 받기"
        q.f(s2, "getString(...)");
        arrayList0.add(new VideoMoreItem(s2, 2, 0, 4, null));
        String s3 = this.getString(0x7F13028A);  // string:ctx_menu_share "공유하기"
        q.f(s3, "getString(...)");
        arrayList0.add(new VideoMoreItem(s3, 5, 0, 4, null));
        return arrayList0;
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    @NotNull
    public Q getMoreBottomSheetType(@NotNull Playable playable0) {
        q.g(playable0, "playable");
        LiveDetailRes liveDetailRes0 = (LiveDetailRes)this.getLiveViewModel().getLiveRes().getValue();
        Response liveDetailRes$Response0 = liveDetailRes0 == null ? null : liveDetailRes0.response;
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.getLiveViewModel().getLivePreviewSubscribeManager().isSubscribe().observe(this.getViewLifecycleOwner(), new VideoPlayerLivePreviewFragment.sam.androidx_lifecycle_Observer.0(new o0(c0, 6)));
        return new i(playable0, liveDetailRes$Response0, c0.a);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initController() {
        CharSequence charSequence0;
        super.initController();
        if(this.getVideoViewModel().isFullScreen()) {
            this.findViewById(0x7F0A0C12).setVisibility(0);  // id:tv_artist
            this.findViewById(0x7F0A0648).setVisibility(0);  // id:iv_live_badge
            View view0 = this.findViewById(0x7F0A0648);  // id:iv_live_badge
            q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
            ((MelonImageView)view0).setImageResource(0x7F0804A3);  // drawable:ic_live_comingsoon_w
        }
        else {
            this.findViewById(0x7F0A0C12).setVisibility(8);  // id:tv_artist
            this.findViewById(0x7F0A0648).setVisibility(8);  // id:iv_live_badge
        }
        this.findViewById(0x7F0A0671).setVisibility(8);  // id:iv_prev
        this.findViewById(0x7F0A0655).setVisibility(8);  // id:iv_next
        this.findViewById(0x7F0A0664).setVisibility(8);  // id:iv_player_chat
        this.findViewById(0x7F0A0663).setVisibility(8);  // id:iv_player_autoplay
        View view1 = this.findViewById(0x7F0A0C55);  // id:tv_current_time
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view1).setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
        View view2 = this.findViewById(0x7F0A0D11);  // id:tv_slash
        q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
        Context context0 = this.getContext();
        if(context0 == null) {
            charSequence0 = null;
        }
        else {
            Resources resources0 = context0.getResources();
            charSequence0 = resources0 == null ? null : resources0.getText(0x7F130A13);  // string:slash "/"
        }
        ((TextView)view2).setText(charSequence0);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void initVideoStatusUI(@NotNull VideoStatus videoStatus0) {
        q.g(videoStatus0, "status");
        super.initVideoStatusUI(videoStatus0);
        if(this.getVideoViewModel().isFullScreen()) {
            this.findViewById(0x7F0A0C12).setVisibility(0);  // id:tv_artist
            this.findViewById(0x7F0A0648).setVisibility(0);  // id:iv_live_badge
            View view0 = this.findViewById(0x7F0A0648);  // id:iv_live_badge
            q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
            ((MelonImageView)view0).setImageResource(0x7F0804A3);  // drawable:ic_live_comingsoon_w
            return;
        }
        this.findViewById(0x7F0A0C12).setVisibility(8);  // id:tv_artist
        this.findViewById(0x7F0A0648).setVisibility(8);  // id:iv_live_badge
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
        if(!this.isForeground()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
            public final VideoPlayerLivePreviewFragment r;

            {
                this.r = videoPlayerLivePreviewFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onPlaybackComplete.1(this.r, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onPlaybackComplete.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                VideoPlayerLivePreviewFragment videoPlayerLivePreviewFragment0 = this.r;
                Playable playable0 = (Playable)videoPlayerLivePreviewFragment0.getVideoViewModel().getCurrentVideoPlayable().getValue();
                H h0 = H.a;
                if(playable0 != null) {
                    FragmentActivity fragmentActivity0 = videoPlayerLivePreviewFragment0.getActivity();
                    if(fragmentActivity0 != null) {
                        AddPlay addAction$AddPlay0 = new AddPlay(false);
                        String s = videoPlayerLivePreviewFragment0.getMenuId();
                        q.f(s, "getMenuId(...)");
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(fragmentActivity0, new AddServerContent(addAction$AddPlay0, false, false, null, new Live("", s, null)), false, 2, null);
                    }
                }
                return h0;
            }
        }, 3, null);
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.mMenuId = "1000002977";
        this.getBinding().c.setVisibility(8);
        View view1 = this.findViewById(0x7F0A0D50);  // id:tv_video_title
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view1).setVisibility(8);
        View view2 = this.findViewById(0x7F0A0C12);  // id:tv_artist
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        ((MelonTextView)view2).setVisibility(8);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(((MelonTextView)view1), ((MelonTextView)view2), null) {
            public final MelonTextView B;
            public final MelonTextView D;
            public int r;
            public final VideoPlayerLivePreviewFragment w;

            {
                this.w = videoPlayerLivePreviewFragment0;
                this.B = melonTextView0;
                this.D = melonTextView1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = this.w.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1.1 videoPlayerLivePreviewFragment$onViewCreated$1$10 = new n(this.B, this.D, null) {
                            public final MelonTextView B;
                            public final MelonTextView D;
                            public int r;
                            public final VideoPlayerLivePreviewFragment w;

                            {
                                this.w = videoPlayerLivePreviewFragment0;
                                this.B = melonTextView0;
                                this.D = melonTextView1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1.1(this.w, this.B, this.D, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = this.w.getVideoViewModel().getVideoStatus();
                                        com.iloen.melon.player.video.VideoPlayerLivePreviewFragment.onViewCreated.1.1.1 videoPlayerLivePreviewFragment$onViewCreated$1$1$10 = new FlowCollector() {
                                            public final VideoPlayerLivePreviewFragment a;
                                            public final MelonTextView b;
                                            public final MelonTextView c;

                                            {
                                                VideoPlayerLivePreviewFragment videoPlayerLivePreviewFragment0 = this.B;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                                MelonTextView melonTextView0 = this.D;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                                this.a = videoPlayerLivePreviewFragment0;
                                                this.b = melonTextView0;
                                                this.c = melonTextView1;
                                            }

                                            public final Object emit(VideoStatus videoStatus0, Continuation continuation0) {
                                                MelonTextView melonTextView0 = this.c;
                                                MelonTextView melonTextView1 = this.b;
                                                if(videoStatus0 == VideoStatus.FullScreen) {
                                                    this.a.getLiveViewModel().getLiveRes().observe(this.a.getViewLifecycleOwner(), new VideoPlayerLivePreviewFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.player.video.n(melonTextView1, melonTextView0, this.a, 6)));
                                                    return H.a;
                                                }
                                                melonTextView1.setVisibility(8);
                                                melonTextView0.setVisibility(8);
                                                return H.a;
                                            }

                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((VideoStatus)object0), continuation0);
                                            }
                                        };
                                        this.r = 1;
                                        if(stateFlow0.collect(videoPlayerLivePreviewFragment$onViewCreated$1$1$10, this) == a0) {
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
                        return f0.j(d0, s.d, videoPlayerLivePreviewFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
        this.showMoreBottomSheet();
    }

    @Override  // com.iloen.melon.player.video.VideoPlayerFragmentBase
    public void setBindSeekBar() {
        View view0 = this.findViewById(0x7F0A0A53);  // id:seekbar_container
        q.e(view0, "null cannot be cast to non-null type android.widget.RelativeLayout");
        ((RelativeLayout)view0).removeAllViews();
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        VideoSeekBarAndDuration videoSeekBarAndDuration0 = new VideoSeekBarAndDuration(context0, null);
        videoSeekBarAndDuration0.setType(Preview.INSTANCE);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        videoSeekBarAndDuration0.initSeekbar(d0, this.getVideoViewModel());
        this.setSeekBarView(videoSeekBarAndDuration0);
        ((RelativeLayout)view0).addView(this.getSeekBarView());
    }
}

