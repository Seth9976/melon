package com.iloen.melon.fragments.shortform;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.video.VideoListener;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST.MEDIAINFO;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.player.trackzero.SinglePlayer.SinglePlayerCallback;
import com.iloen.melon.player.trackzero.SinglePlayer;
import ie.H;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0005*\u0002-0\b\'\u0018\u0000 32\u00020\u0001:\u00013B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u00020\u00042\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0003J\u001F\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u000F\u0010\u001C\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0003J\r\u0010\u001D\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001D\u0010\u0003J\r\u0010\u001E\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001E\u0010\u0003J\r\u0010\u001F\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001F\u0010\u0003R\"\u0010!\u001A\u00020 8\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001A\u00020\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b(\u0010*\"\u0004\b+\u0010,R\u0014\u0010.\u001A\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102\u00A8\u00064"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment;", "Lcom/iloen/melon/fragments/shortform/TrendShortBaseFragment;", "<init>", "()V", "Lie/H;", "initPlayer", "mute", "unMute", "", "url", "setPath", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onRenderPlayer", "", "width", "height", "onVideoSize", "(II)V", "onResume", "onPause", "onDestroy", "play", "pause", "stop", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "trendPlayer", "Lcom/iloen/melon/player/trackzero/SinglePlayer;", "getTrendPlayer", "()Lcom/iloen/melon/player/trackzero/SinglePlayer;", "setTrendPlayer", "(Lcom/iloen/melon/player/trackzero/SinglePlayer;)V", "", "isVideoRendered", "Z", "()Z", "setVideoRendered", "(Z)V", "com/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$videoListener$1", "videoListener", "Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$videoListener$1;", "com/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$eventListener$1", "eventListener", "Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$eventListener$1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TrendVideoPlayerBaseFragment extends TrendShortBaseFragment {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_POSITION = "argPosition";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendVideoPlayerBaseFragment";
    @NotNull
    private final com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.eventListener.1 eventListener;
    private boolean isVideoRendered;
    public SinglePlayer trendPlayer;
    @NotNull
    private final com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.videoListener.1 videoListener;

    static {
        TrendVideoPlayerBaseFragment.Companion = new Companion(null);
        TrendVideoPlayerBaseFragment.$stable = 8;
    }

    public TrendVideoPlayerBaseFragment() {
        this.videoListener = new VideoListener() {
            @Override  // com.google.android.exoplayer2.video.VideoListener
            public void onRenderedFirstFrame() {
                TrendVideoPlayerBaseFragment.this.onRenderPlayer();
                TrendVideoPlayerBaseFragment.this.setVideoRendered(true);
                VideoListener.super.onRenderedFirstFrame();
            }

            @Override  // com.google.android.exoplayer2.video.VideoListener
            public void onVideoSizeChanged(int v, int v1, int v2, float f) {
                TrendVideoPlayerBaseFragment.this.onVideoSize(v, v1);
                VideoListener.super.onVideoSizeChanged(v, v1, v2, f);
            }
        };
        this.eventListener = new com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.eventListener.1();

        @Metadata(d1 = {"\u0000\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/iloen/melon/fragments/shortform/TrendVideoPlayerBaseFragment$eventListener$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.eventListener.1 implements EventListener {
        }

    }

    @NotNull
    public final SinglePlayer getTrendPlayer() {
        SinglePlayer singlePlayer0 = this.trendPlayer;
        if(singlePlayer0 != null) {
            return singlePlayer0;
        }
        q.m("trendPlayer");
        throw null;
    }

    private final void initPlayer() {
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        SinglePlayer singlePlayer0 = new SinglePlayer(context0);
        singlePlayer0.setCallback(new SinglePlayerCallback() {
            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onCompletion() {
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onError(String s) {
                q.g(s, "error");
                if(TrendVideoPlayerBaseFragment.this.getLifecycle().b() == s.e) {
                    TrendVideoPlayerBaseFragment.this.failToPlayMedia();
                }
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackStateChanged(boolean z, int v) {
            }

            @Override  // com.iloen.melon.player.trackzero.SinglePlayer$SinglePlayerCallback
            public void onPlaybackTransitions() {
            }
        });
        this.setTrendPlayer(singlePlayer0);
        SimpleExoPlayer simpleExoPlayer0 = this.getTrendPlayer().getPlayer();
        simpleExoPlayer0.setVolume(0.0f);
        simpleExoPlayer0.addVideoListener(this.videoListener);
        simpleExoPlayer0.addListener(this.eventListener);
    }

    public final boolean isVideoRendered() {
        return this.isVideoRendered;
    }

    private final void mute() {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().setVolume(0.0f);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.initPlayer();
    }

    @Override  // androidx.fragment.app.I
    public void onDestroy() {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().release();
            this.getTrendPlayer().getPlayer().removeVideoListener(this.videoListener);
            this.getTrendPlayer().getPlayer().removeListener(this.eventListener);
        }
        super.onDestroy();
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        super.onPause();
        this.pause();
    }

    public void onRenderPlayer() {
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        this.play();
    }

    public void onVideoSize(int v, int v1) {
    }

    @Override  // com.iloen.melon.fragments.shortform.TrendShortBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        String s;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        List list0 = (List)this.getViewModel().getList().getValue();
        SLOTLIST trendShortFormRes$Response$SLOTLIST0 = list0 == null ? null : ((SLOTLIST)p.n0(this.getTabPosition(), list0));
        if(trendShortFormRes$Response$SLOTLIST0 == null) {
            s = "";
        }
        else {
            MEDIAINFO trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 = trendShortFormRes$Response$SLOTLIST0.mediaInfo;
            if(trendShortFormRes$Response$SLOTLIST$MEDIAINFO0 == null) {
                s = "";
            }
            else {
                s = trendShortFormRes$Response$SLOTLIST$MEDIAINFO0.path;
                if(s == null) {
                    s = "";
                }
            }
        }
        this.setPath(s);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new n(null) {
            int label;

            {
                TrendVideoPlayerBaseFragment.this = trendVideoPlayerBaseFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1(TrendVideoPlayerBaseFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        D d0 = TrendVideoPlayerBaseFragment.this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1 trendVideoPlayerBaseFragment$onViewCreated$1$10 = new n(null) {
                            int label;

                            {
                                TrendVideoPlayerBaseFragment.this = trendVideoPlayerBaseFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1(TrendVideoPlayerBaseFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = TrendVideoPlayerBaseFragment.this.getViewModel().getSoundAble();
                                        com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1.1 trendVideoPlayerBaseFragment$onViewCreated$1$1$10 = new n(null) {
                                            boolean Z$0;
                                            int label;

                                            {
                                                TrendVideoPlayerBaseFragment.this = trendVideoPlayerBaseFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1.1(TrendVideoPlayerBaseFragment.this, continuation0);
                                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendVideoPlayerBaseFragment.onViewCreated.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                boolean z = this.Z$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                if(z) {
                                                    TrendVideoPlayerBaseFragment.this.unMute();
                                                    return H.a;
                                                }
                                                TrendVideoPlayerBaseFragment.this.mute();
                                                return H.a;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(stateFlow0, trendVideoPlayerBaseFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
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
                        this.label = 1;
                        return f0.j(d0, s.e, trendVideoPlayerBaseFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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
    }

    public final void pause() {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().pause();
        }
    }

    public final void play() {
        if(this.trendPlayer != null) {
            if(this.getTrendPlayer().getPlaybackError() != null) {
                this.failToPlayMedia();
                return;
            }
            this.getTrendPlayer().seekTo(0L);
            this.getTrendPlayer().start();
        }
    }

    private final void setPath(String s) {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().setDataSource(Uri.parse(s), true);
        }
    }

    public final void setTrendPlayer(@NotNull SinglePlayer singlePlayer0) {
        q.g(singlePlayer0, "<set-?>");
        this.trendPlayer = singlePlayer0;
    }

    public final void setVideoRendered(boolean z) {
        this.isVideoRendered = z;
    }

    public final void stop() {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().stop(false);
        }
    }

    private final void unMute() {
        if(this.trendPlayer != null) {
            this.getTrendPlayer().setVolume(1.0f);
        }
    }
}

