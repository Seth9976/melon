package com.iloen.melon.player.trackzero;

import android.content.Context;
import android.net.Uri;
import android.view.SurfaceHolder;
import b3.Z;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jd.e3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001A\u00020\b2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0015\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0015\u0010\"\u001A\u00020\b2\u0006\u0010!\u001A\u00020 \u00A2\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\b\u00A2\u0006\u0004\b$\u0010%J\r\u0010&\u001A\u00020\b\u00A2\u0006\u0004\b&\u0010%J\r\u0010\'\u001A\u00020\b\u00A2\u0006\u0004\b\'\u0010%J\r\u0010(\u001A\u00020\b\u00A2\u0006\u0004\b(\u0010%J\u0015\u0010*\u001A\u00020\b2\u0006\u0010)\u001A\u00020\u0011\u00A2\u0006\u0004\b*\u0010+J\r\u0010,\u001A\u00020\b\u00A2\u0006\u0004\b,\u0010%J\u001D\u00100\u001A\u00020\b2\u0006\u0010.\u001A\u00020-2\u0006\u0010/\u001A\u00020\u0011\u00A2\u0006\u0004\b0\u00101J%\u00104\u001A\u00020\b2\u0006\u0010.\u001A\u00020-2\u0006\u0010/\u001A\u00020\u00112\u0006\u00103\u001A\u000202\u00A2\u0006\u0004\b4\u00105J\u001B\u00108\u001A\u00020\b2\f\u00107\u001A\b\u0012\u0004\u0012\u00020206\u00A2\u0006\u0004\b8\u00109\u00A8\u0006<"}, d2 = {"Lcom/iloen/melon/player/trackzero/SinglePlayer;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/iloen/melon/player/trackzero/SinglePlayer$SinglePlayerCallback;", "callback", "Lie/H;", "setCallback", "(Lcom/iloen/melon/player/trackzero/SinglePlayer$SinglePlayerCallback;)V", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "getPlaybackError", "()Lcom/google/android/exoplayer2/ExoPlaybackException;", "", "isPlaying", "()Z", "isReadyToPlay", "Landroid/view/SurfaceHolder;", "sh", "setDisplay", "(Landroid/view/SurfaceHolder;)V", "", "getCurrentPosition", "()J", "getDuration", "positionMs", "seekTo", "(J)V", "", "audioVolume", "setVolume", "(F)V", "next", "()V", "previous", "start", "pause", "reset", "stop", "(Z)V", "release", "Landroid/net/Uri;", "uri", "isRepeat", "setDataSource", "(Landroid/net/Uri;Z)V", "", "cacheKey", "setDataSourceWithCustomCacheKey", "(Landroid/net/Uri;ZLjava/lang/String;)V", "", "urlList", "setPlaylistDataSource", "(Ljava/util/List;)V", "Companion", "SinglePlayerCallback", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SinglePlayer {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/player/trackzero/SinglePlayer$Companion;", "", "", "state", "", "stateName", "(I)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String stateName(int v) {
            switch(v) {
                case 1: {
                    return "STATE_IDLE";
                }
                case 2: {
                    return "STATE_BUFFERING";
                }
                case 3: {
                    return "STATE_READY";
                }
                case 4: {
                    return "STATE_ENDED";
                }
                default: {
                    return "illegal state";
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0002H&¢\u0006\u0004\b\u000B\u0010\u0004J\u0017\u0010\u000E\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\fH&¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/trackzero/SinglePlayer$SinglePlayerCallback;", "", "Lie/H;", "onCompletion", "()V", "", "playWhenReady", "", "state", "onPlaybackStateChanged", "(ZI)V", "onPlaybackTransitions", "", "error", "onError", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface SinglePlayerCallback {
        void onCompletion();

        void onError(@NotNull String arg1);

        void onPlaybackStateChanged(boolean arg1, int arg2);

        void onPlaybackTransitions();
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final Context a;
    public final LogU b;
    public ConcatenatingMediaSource c;
    public SinglePlayerCallback d;
    public final r e;
    public final com.iloen.melon.player.trackzero.SinglePlayer.eventListener.1 f;

    static {
        SinglePlayer.Companion = new Companion(null);
        SinglePlayer.$stable = 8;
    }

    public SinglePlayer(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = Z.g("SinglePlayer", true);
        this.e = g.Q(new e3(this, 12));
        this.f = new EventListener() {
            public final SinglePlayer a;

            {
                this.a = singlePlayer0;
            }

            @Override  // com.google.android.exoplayer2.Player$EventListener
            public void onPlayerError(ExoPlaybackException exoPlaybackException0) {
                String s1;
                q.g(exoPlaybackException0, "error");
                String s = "";
                switch(exoPlaybackException0.type) {
                    case 0: {
                        s1 = exoPlaybackException0.getSourceException().getMessage();
                        if(s1 != null) {
                            s = s1;
                        }
                        break;
                    }
                    case 1: {
                        s1 = exoPlaybackException0.getRendererException().getMessage();
                        if(s1 != null) {
                            s = s1;
                        }
                        break;
                    }
                    case 2: {
                        s1 = exoPlaybackException0.getUnexpectedException().getMessage();
                        if(s1 != null) {
                            s = s1;
                        }
                        break;
                    }
                    case 3: 
                    case 4: {
                        s1 = exoPlaybackException0.getMessage();
                        if(s1 != null) {
                            s = s1;
                        }
                        break;
                    }
                    default: {
                        s = "Unknown: " + exoPlaybackException0;
                    }
                }
                SinglePlayer singlePlayer0 = this.a;
                LogU.error$default(singlePlayer0.b, "onPlayerError() error msg : " + s, null, false, 6, null);
                if(singlePlayer0.c == null) {
                label_38:
                    SinglePlayerCallback singlePlayer$SinglePlayerCallback1 = singlePlayer0.d;
                    if(singlePlayer$SinglePlayerCallback1 != null) {
                        singlePlayer$SinglePlayerCallback1.onError(s);
                    }
                }
                else {
                    ConcatenatingMediaSource concatenatingMediaSource0 = singlePlayer0.c;
                    if(concatenatingMediaSource0 != null && concatenatingMediaSource0.getSize() == 0) {
                        goto label_38;
                    }
                    else {
                        ConcatenatingMediaSource concatenatingMediaSource1 = singlePlayer0.c;
                        if(concatenatingMediaSource1 != null) {
                            concatenatingMediaSource1.removeMediaSource(singlePlayer0.b().getCurrentWindowIndex());
                            singlePlayer0.b().setPlayWhenReady(false);
                            if(concatenatingMediaSource1.getSize() > 0) {
                                LogU.debug$default(singlePlayer0.b, "onPlayerError() prepare adjusted items.", null, false, 6, null);
                                singlePlayer0.b().prepare(concatenatingMediaSource1);
                                return;
                            }
                            LogU.debug$default(singlePlayer0.b, "onPlayerError() handle error.", null, false, 6, null);
                            SinglePlayerCallback singlePlayer$SinglePlayerCallback0 = singlePlayer0.d;
                            if(singlePlayer$SinglePlayerCallback0 != null) {
                                singlePlayer$SinglePlayerCallback0.onError(s);
                            }
                        }
                    }
                }
            }

            @Override  // com.google.android.exoplayer2.Player$EventListener
            public void onPlayerStateChanged(boolean z, int v) {
                SinglePlayer singlePlayer0 = this.a;
                switch(v) {
                    case 1: 
                    case 2: 
                    case 3: {
                        SinglePlayerCallback singlePlayer$SinglePlayerCallback0 = singlePlayer0.d;
                        if(singlePlayer$SinglePlayerCallback0 != null) {
                            singlePlayer$SinglePlayerCallback0.onPlaybackStateChanged(z, v);
                            return;
                        }
                        break;
                    }
                    case 4: {
                        SinglePlayerCallback singlePlayer$SinglePlayerCallback1 = singlePlayer0.d;
                        if(singlePlayer$SinglePlayerCallback1 != null) {
                            singlePlayer$SinglePlayerCallback1.onCompletion();
                            return;
                        }
                        break;
                    }
                }
            }

            @Override  // com.google.android.exoplayer2.Player$EventListener
            public void onPositionDiscontinuity(int v) {
                if(v == 0) {
                    SinglePlayerCallback singlePlayer$SinglePlayerCallback0 = SinglePlayer.access$getCallback$p(this.a);
                    if(singlePlayer$SinglePlayerCallback0 != null) {
                        singlePlayer$SinglePlayerCallback0.onPlaybackTransitions();
                    }
                }
            }
        };
    }

    public final BaseMediaSource a(Uri uri0) {
        int v = Util.inferContentType(uri0);
        Context context0 = this.a;
        switch(v) {
            case 2: {
                return new Factory(new DefaultDataSourceFactory(context0, Util.getUserAgent(context0, "TrackZero"))).createMediaSource(uri0);
            }
            case 3: {
                return new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(new CacheDataSourceFactory(ExoVideoCache.Companion.getInstance(context0), new DefaultDataSourceFactory(context0, Util.getUserAgent(context0, "TrackZero")))).createMediaSource(uri0);
            }
            default: {
                LogU.Companion.d("SinglePlayer", "buildMediaSource() DASH, SS are not supported.");
                return null;
            }
        }
    }

    public final SimpleExoPlayer b() {
        return (SimpleExoPlayer)this.e.getValue();
    }

    public final long getCurrentPosition() {
        return this.b().getCurrentPosition();
    }

    public final long getDuration() {
        return this.b().getDuration();
    }

    @Nullable
    public final ExoPlaybackException getPlaybackError() {
        return this.b().getPlaybackError();
    }

    @NotNull
    public final SimpleExoPlayer getPlayer() {
        return this.b();
    }

    public final boolean isPlaying() {
        return this.b().getPlayWhenReady();
    }

    public final boolean isReadyToPlay() {
        return this.b().getPlaybackState() == 3;
    }

    public final void next() {
        if(this.b().hasNext()) {
            this.b().next();
        }
    }

    public final void pause() {
        this.b().setPlayWhenReady(false);
    }

    public final void previous() {
        if(this.b().hasPrevious()) {
            this.b().previous();
        }
    }

    public final void release() {
        this.b().release();
        this.b().removeListener(this.f);
    }

    public final void seekTo(long v) {
        this.b().seekTo(v);
    }

    public final void setCallback(@NotNull SinglePlayerCallback singlePlayer$SinglePlayerCallback0) {
        q.g(singlePlayer$SinglePlayerCallback0, "callback");
        this.d = singlePlayer$SinglePlayerCallback0;
    }

    public final void setDataSource(@NotNull Uri uri0, boolean z) {
        q.g(uri0, "uri");
        BaseMediaSource baseMediaSource0 = this.a(uri0);
        if(baseMediaSource0 != null) {
            l1.B("setDataSource() mediaSource is ready isRepeat : ", z, LogU.Companion, "SinglePlayer");
            if(z) {
                this.b().prepare(new LoopingMediaSource(baseMediaSource0));
                return;
            }
            this.b().prepare(baseMediaSource0);
            return;
        }
        LogU.Companion.e("SinglePlayer", "setDataSource() MediaSource is not available.");
    }

    public final void setDataSourceWithCustomCacheKey(@NotNull Uri uri0, boolean z, @NotNull String s) {
        q.g(uri0, "uri");
        q.g(s, "cacheKey");
        ProgressiveMediaSource progressiveMediaSource0 = null;
        switch(Util.inferContentType(uri0)) {
            case 2: {
                LogU.Companion.d("SinglePlayer", "buildMediaSourceWithCustomCacheKey() HLS Cache is not supported.");
                break;
            }
            case 3: {
                SimpleCache simpleCache0 = ExoVideoCache.Companion.getInstance(this.a);
                String s1 = Util.getUserAgent(this.a, "TrackZero");
                progressiveMediaSource0 = new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(new CacheDataSourceFactory(simpleCache0, new DefaultDataSourceFactory(this.a, s1))).setCustomCacheKey(s).createMediaSource(uri0);
                break;
            }
            default: {
                LogU.Companion.d("SinglePlayer", "buildMediaSourceWithCustomCacheKey() DASH, SS are not supported.");
            }
        }
        if(progressiveMediaSource0 != null) {
            l1.B("setDataSourceWithCustomCacheKey() mediaSource is ready isRepeat : ", z, LogU.Companion, "SinglePlayer");
            if(z) {
                this.b().prepare(new LoopingMediaSource(progressiveMediaSource0));
                return;
            }
            this.b().prepare(progressiveMediaSource0);
            return;
        }
        LogU.Companion.e("SinglePlayer", "setDataSourceWithCustomCacheKey() MediaSource is not available.");
    }

    public final void setDisplay(@Nullable SurfaceHolder surfaceHolder0) {
        this.b().setVideoSurfaceHolder(surfaceHolder0);
    }

    public final void setPlaylistDataSource(@NotNull List list0) {
        q.g(list0, "urlList");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            BaseMediaSource baseMediaSource0 = this.a(Uri.parse(((String)object0)));
            if(baseMediaSource0 != null) {
                arrayList0.add(baseMediaSource0);
            }
        }
        MediaSource[] arr_mediaSource = (MediaSource[])arrayList0.toArray(new MediaSource[0]);
        ConcatenatingMediaSource concatenatingMediaSource0 = new ConcatenatingMediaSource(((MediaSource[])Arrays.copyOf(arr_mediaSource, arr_mediaSource.length)));
        this.b().setShuffleModeEnabled(true);
        this.b().setRepeatMode(2);
        this.b().prepare(concatenatingMediaSource0);
        this.c = concatenatingMediaSource0;
    }

    public final void setVolume(float f) {
        this.b().setVolume(f);
    }

    public final void start() {
        this.b().setPlayWhenReady(true);
    }

    public final void stop(boolean z) {
        this.b().stop(z);
    }
}

