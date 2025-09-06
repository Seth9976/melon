package com.iloen.melon.playback.voicealarm;

import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.net.v4x.response.StreamGetPathRes;
import com.iloen.melon.playback.IPlayer;
import com.iloen.melon.playback.IPlayerEventListener;
import com.iloen.melon.playback.PlayerState;
import com.melon.net.res.VoiceAlarm.Track;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH&\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0014\u0010\u0012J\u000F\u0010\u0015\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0015\u0010\u0012J\u000F\u0010\u0017\u001A\u00020\u0016H&\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H&\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0019H&\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\'\u0010 \u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b\"\u0010\u0010J\u0017\u0010#\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b#\u0010\u0010J\u0019\u0010&\u001A\u00020\u00062\b\u0010%\u001A\u0004\u0018\u00010$H\u0016\u00A2\u0006\u0004\b&\u0010\'J)\u0010*\u001A\u00020\u00062\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010(\u001A\u00020\u00192\u0006\u0010)\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b*\u0010+JC\u00102\u001A\u00020\u00062\b\u0010%\u001A\u0004\u0018\u00010$2\b\u0010-\u001A\u0004\u0018\u00010,2\u0006\u0010.\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00192\u0006\u00101\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b2\u00103J\u0017\u00105\u001A\u00020\u00062\u0006\u00104\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b5\u00106R\u001E\u0010:\u001A\u0004\u0018\u00010$8&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b7\u00108\"\u0004\b9\u0010\'R\u001C\u0010@\u001A\u00020;8&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001E\u0010F\u001A\u0004\u0018\u00010A8&@&X\u00A6\u000E\u00A2\u0006\f\u001A\u0004\bB\u0010C\"\u0004\bD\u0010E\u00A8\u0006G\u00C0\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/voicealarm/VoiceAlarmPlay;", "Lcom/iloen/melon/playback/IPlayerEventListener;", "Lcom/melon/net/res/VoiceAlarm$Track;", "track", "Lkotlin/Function1;", "Lcom/iloen/melon/net/v4x/response/StreamGetPathRes;", "Lie/H;", "onSucess", "getAlarmPath", "(Lcom/melon/net/res/VoiceAlarm$Track;Lwe/k;)V", "res", "completeGetPath", "(Lcom/iloen/melon/net/v4x/response/StreamGetPathRes;)V", "", "url", "startPrepare", "(Ljava/lang/String;)V", "playerInit", "()V", "playerRelease", "stopPlay", "audioFocusLoss", "", "isPlaying", "()Z", "", "getCurrentPosition", "()I", "getDuration", "permil", "position", "trackId", "onPlaybackPositionUpdate", "(IILjava/lang/String;)V", "onPlaybackStart", "onPlaybackStop", "Lcom/iloen/melon/playback/IPlayer;", "player", "onSeekComplete", "(Lcom/iloen/melon/playback/IPlayer;)V", "width", "height", "onDisplayChange", "(Lcom/iloen/melon/playback/IPlayer;II)V", "", "pcm", "pcm_size", "channels", "samplerate", "samplefmt", "onPcm", "(Lcom/iloen/melon/playback/IPlayer;[BIIII)V", "isBuffering", "onBufferingChange", "(Z)V", "getIPlayer", "()Lcom/iloen/melon/playback/IPlayer;", "setIPlayer", "iPlayer", "Lcom/iloen/melon/playback/PlayerState;", "getCurrentState", "()Lcom/iloen/melon/playback/PlayerState;", "setCurrentState", "(Lcom/iloen/melon/playback/PlayerState;)V", "currentState", "Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "getAudioFocusHelper", "()Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "setAudioFocusHelper", "(Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;)V", "audioFocusHelper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface VoiceAlarmPlay extends IPlayerEventListener {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static void getAlarmPath$default(VoiceAlarmPlay voiceAlarmPlay0, Track voiceAlarm$Track0, k k0, int v, Object object0) {
            VoiceAlarmPlay.getAlarmPath$default(voiceAlarmPlay0, voiceAlarm$Track0, k0, v, object0);
        }

        @Deprecated
        public static void onBufferingChange(@NotNull VoiceAlarmPlay voiceAlarmPlay0, boolean z) {
            voiceAlarmPlay0.super.onBufferingChange(z);
        }

        @Deprecated
        public static void onDisplayChange(@NotNull VoiceAlarmPlay voiceAlarmPlay0, @Nullable IPlayer iPlayer0, int v, int v1) {
            voiceAlarmPlay0.super.onDisplayChange(iPlayer0, v, v1);
        }

        @Deprecated
        public static void onPcm(@NotNull VoiceAlarmPlay voiceAlarmPlay0, @Nullable IPlayer iPlayer0, @Nullable byte[] arr_b, int v, int v1, int v2, int v3) {
            voiceAlarmPlay0.super.onPcm(iPlayer0, arr_b, v, v1, v2, v3);
        }

        @Deprecated
        public static void onSeekComplete(@NotNull VoiceAlarmPlay voiceAlarmPlay0, @Nullable IPlayer iPlayer0) {
            voiceAlarmPlay0.super.onSeekComplete(iPlayer0);
        }
    }

    void audioFocusLoss();

    void completeGetPath(@NotNull StreamGetPathRes arg1);

    static H e(StreamGetPathRes streamGetPathRes0) {
        return VoiceAlarmPlay.getAlarmPath$lambda$0(streamGetPathRes0);
    }

    void getAlarmPath(@NotNull Track arg1, @NotNull k arg2);

    static void getAlarmPath$default(VoiceAlarmPlay voiceAlarmPlay0, Track voiceAlarm$Track0, k k0, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAlarmPath");
        }
        if((v & 2) != 0) {
            k0 = new f(23);
        }
        voiceAlarmPlay0.getAlarmPath(voiceAlarm$Track0, k0);
    }

    private static H getAlarmPath$lambda$0(StreamGetPathRes streamGetPathRes0) {
        q.g(streamGetPathRes0, "it");
        return H.a;
    }

    @Nullable
    VoiceTrackAudioFocusHelper getAudioFocusHelper();

    int getCurrentPosition();

    @NotNull
    PlayerState getCurrentState();

    int getDuration();

    @Nullable
    IPlayer getIPlayer();

    boolean isPlaying();

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    default void onBufferingChange(boolean z) {
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    default void onDisplayChange(@Nullable IPlayer iPlayer0, int v, int v1) {
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    default void onPcm(@Nullable IPlayer iPlayer0, @Nullable byte[] arr_b, int v, int v1, int v2, int v3) {
    }

    void onPlaybackPositionUpdate(int arg1, int arg2, @NotNull String arg3);

    void onPlaybackStart(@NotNull String arg1);

    void onPlaybackStop(@NotNull String arg1);

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    default void onSeekComplete(@Nullable IPlayer iPlayer0) {
    }

    void playerInit();

    void playerRelease();

    void setAudioFocusHelper(@Nullable VoiceTrackAudioFocusHelper arg1);

    void setCurrentState(@NotNull PlayerState arg1);

    void setIPlayer(@Nullable IPlayer arg1);

    void startPrepare(@NotNull String arg1);

    void stopPlay();
}

