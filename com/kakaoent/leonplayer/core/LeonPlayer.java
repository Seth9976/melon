package com.kakaoent.leonplayer.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonConfiguration;
import com.kakaoent.leonplayer.core.model.data.player.LeonMediaTime;
import com.kakaoent.leonplayer.core.model.data.player.LeonVideoProfile;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 d2\u00020\u0001:\u0001dJ\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0002H&\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH&\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000FH&\u00A2\u0006\u0004\b\r\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0012\u0010\nJ\u000F\u0010\u0013\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0013\u0010\nJ\u000F\u0010\u0014\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0014\u0010\nJ\u000F\u0010\u0015\u001A\u00020\u0004H&\u00A2\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u001C\u0010\u0019J\u0017\u0010\u001E\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u001E\u0010\u0019J#\u0010\"\u001A\u00020\u00042\u0012\u0010!\u001A\n\u0012\u0006\b\u0001\u0012\u00020 0\u001F\"\u00020 H&\u00A2\u0006\u0004\b\"\u0010#J#\u0010$\u001A\u00020\u00042\u0012\u0010!\u001A\n\u0012\u0006\b\u0001\u0012\u00020 0\u001F\"\u00020 H&\u00A2\u0006\u0004\b$\u0010#J\u0017\u0010&\u001A\u00020\u00042\u0006\u0010%\u001A\u00020\u0016H&\u00A2\u0006\u0004\b&\u0010\u0019J\u0017\u0010\'\u001A\u00020\u00042\u0006\u0010%\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\'\u0010\u0019J\u0019\u0010)\u001A\u00020\u00042\b\u0010(\u001A\u0004\u0018\u00010\u000FH&\u00A2\u0006\u0004\b)\u0010\u0011J\u0019\u0010,\u001A\u0004\u0018\u00010+2\u0006\u0010*\u001A\u00020\u0016H&\u00A2\u0006\u0004\b,\u0010-R\u0014\u00101\u001A\u00020.8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b/\u00100R\u001C\u00107\u001A\u0002028&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\u001C\u0010=\u001A\u0002088&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001C\u0010A\u001A\u00020\u00168&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b>\u0010?\"\u0004\b@\u0010\u0019R\u001C\u0010D\u001A\u0002088&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\bB\u0010:\"\u0004\bC\u0010<R\u0014\u0010F\u001A\u00020\u00168&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bE\u0010?R\u0014\u0010H\u001A\u00020\u00168&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bG\u0010?R\u0014\u0010L\u001A\u00020I8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bJ\u0010KR\u0014\u0010N\u001A\u00020I8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bM\u0010KR\u0014\u0010P\u001A\u00020I8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bO\u0010KR\u0014\u0010T\u001A\u00020Q8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bR\u0010SR\u0014\u0010U\u001A\u0002088&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bU\u0010:R\u0014\u0010V\u001A\u0002088&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bV\u0010:R\u001A\u0010[\u001A\b\u0012\u0004\u0012\u00020X0W8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\bY\u0010ZR\u001A\u0010^\u001A\b\u0012\u0004\u0012\u00020\\0W8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b]\u0010ZR\u001E\u0010c\u001A\u0004\u0018\u00010\\8&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b_\u0010`\"\u0004\ba\u0010b\u00A8\u0006e"}, d2 = {"Lcom/kakaoent/leonplayer/core/LeonPlayer;", "", "Landroid/view/SurfaceView;", "surfaceView", "Lie/H;", "setSurfaceView", "(Landroid/view/SurfaceView;)V", "getSurfaceView", "()Landroid/view/SurfaceView;", "releasePlayer", "()V", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "configuration", "configure", "(Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;)V", "", "jsonFormatString", "(Ljava/lang/String;)V", "prepare", "play", "pause", "reset", "", "msec", "forward", "(I)V", "backward", "offset", "seek", "bitrate", "preferredPeakBitRate", "", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "listeners", "addPlayerEventListeners", "([Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;)V", "removePlayerEventListeners", "index", "selectMediaTrack", "deselectMediaTrack", "id", "setVideoProfileId", "position", "Landroid/graphics/Bitmap;", "getThumbnailPreview", "(I)Landroid/graphics/Bitmap;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "getPlayerState", "()Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "playerState", "", "getVolume", "()F", "setVolume", "(F)V", "volume", "", "getMute", "()Z", "setMute", "(Z)V", "mute", "getRate", "()I", "setRate", "rate", "getLoop", "setLoop", "loop", "getVideoWidth", "videoWidth", "getVideoHeight", "videoHeight", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "getCurrentTime", "()Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "currentTime", "getBufferedTime", "bufferedTime", "getLiveTime", "liveTime", "", "getTotalPlayTime", "()J", "totalPlayTime", "isPlaying", "isBuffering", "", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTrack;", "getMediaTracks", "()Ljava/util/List;", "mediaTracks", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "getCurrentVideoProfiles", "currentVideoProfiles", "getCurrentVideoProfile", "()Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "setCurrentVideoProfile", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;)V", "currentVideoProfile", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonPlayer {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/LeonPlayer$Companion;", "", "()V", "create", "Lcom/kakaoent/leonplayer/core/LeonPlayer;", "context", "Landroid/content/Context;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final LeonPlayer create(@NotNull Context context0) {
            q.g(context0, "context");
            return new LeonPlayerImpl(context0);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        LeonPlayer.Companion = Companion.$$INSTANCE;
    }

    void addPlayerEventListeners(@NotNull LeonPlayerEventListener[] arg1);

    void backward(int arg1);

    void configure(@NotNull LeonConfiguration arg1);

    void configure(@NotNull String arg1);

    void deselectMediaTrack(int arg1);

    void forward(int arg1);

    @NotNull
    LeonMediaTime getBufferedTime();

    @NotNull
    LeonMediaTime getCurrentTime();

    @Nullable
    LeonVideoProfile getCurrentVideoProfile();

    @NotNull
    List getCurrentVideoProfiles();

    @NotNull
    LeonMediaTime getLiveTime();

    boolean getLoop();

    @NotNull
    List getMediaTracks();

    boolean getMute();

    @NotNull
    LeonPlayerState getPlayerState();

    int getRate();

    @Nullable
    SurfaceView getSurfaceView();

    @Nullable
    Bitmap getThumbnailPreview(int arg1);

    long getTotalPlayTime();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isBuffering();

    boolean isPlaying();

    void pause();

    void play();

    void preferredPeakBitRate(int arg1);

    void prepare();

    void releasePlayer();

    void removePlayerEventListeners(@NotNull LeonPlayerEventListener[] arg1);

    void reset();

    void seek(int arg1);

    void selectMediaTrack(int arg1);

    void setCurrentVideoProfile(@Nullable LeonVideoProfile arg1);

    void setLoop(boolean arg1);

    void setMute(boolean arg1);

    void setRate(int arg1);

    void setSurfaceView(@Nullable SurfaceView arg1);

    void setVideoProfileId(@Nullable String arg1);

    void setVolume(float arg1);
}

