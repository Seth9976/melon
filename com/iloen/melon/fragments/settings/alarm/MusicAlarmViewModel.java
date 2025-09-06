package com.iloen.melon.fragments.settings.alarm;

import androidx.lifecycle.c0;
import androidx.lifecycle.m0;
import com.iloen.melon.alarm.MusicAlarmParcelable;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.net.res.VoiceAlarm.Track;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import o8.d;
import o8.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import we.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001A\u0004\u0018\u00010\tH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u0004\u0018\u00010\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u000E2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001C\u001A\u00020\u000E2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001A\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001E\u001A\u00020\u000E\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010 R$\u0010\u0011\u001A\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001A\u00020\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001A\u00020\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010)\u001A\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00101\u001A\u00020\'8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010)\u001A\u0004\b2\u0010+\"\u0004\b3\u0010-R\"\u00105\u001A\u0002048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u00106\u001A\u0004\b5\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\'8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b:\u0010)R\u0011\u0010=\u001A\u00020\f8F\u00A2\u0006\u0006\u001A\u0004\b;\u0010<\u00A8\u0006>"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/MusicAlarmViewModel;", "Landroidx/lifecycle/m0;", "Landroidx/lifecycle/c0;", "savedStateHandle", "<init>", "(Landroidx/lifecycle/c0;)V", "Lcom/iloen/melon/alarm/MusicAlarmParcelable;", "getMusicAlarmSavedState", "()Lcom/iloen/melon/alarm/MusicAlarmParcelable;", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "", "id", "Lie/H;", "setMusicAlarmId", "(I)V", "musicAlarm", "setMusicAlarmSavedState", "(Lcom/iloen/melon/alarm/MusicAlarmParcelable;)V", "Lcom/melon/net/res/VoiceAlarm$Track;", "getVoiceTrackSavedState", "()Lcom/melon/net/res/VoiceAlarm$Track;", "track", "setVoiceTrackSavedState", "(Lcom/melon/net/res/VoiceAlarm$Track;)V", "Lkotlin/Function1;", "action", "trackTiaraEventLog", "(Lwe/k;)V", "sendSaveClickLog", "()V", "Landroidx/lifecycle/c0;", "Lo8/d;", "Lo8/d;", "getMusicAlarm", "()Lo8/d;", "setMusicAlarm", "(Lo8/d;)V", "", "albumImageUrl", "Ljava/lang/String;", "getAlbumImageUrl", "()Ljava/lang/String;", "setAlbumImageUrl", "(Ljava/lang/String;)V", "songName", "getSongName", "setSongName", "artistName", "getArtistName", "setArtistName", "", "isAdult", "Z", "()Z", "setAdult", "(Z)V", "KEY_MUSIC_ALARM_DATA", "getMusicAlarmId", "()I", "musicAlarmId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicAlarmViewModel extends m0 {
    public static final int $stable = 8;
    @NotNull
    private final String KEY_MUSIC_ALARM_DATA;
    @NotNull
    private String albumImageUrl;
    @NotNull
    private String artistName;
    private boolean isAdult;
    @Nullable
    private d musicAlarm;
    @NotNull
    private final c0 savedStateHandle;
    @NotNull
    private String songName;

    public MusicAlarmViewModel(@NotNull c0 c00) {
        q.g(c00, "savedStateHandle");
        super();
        this.savedStateHandle = c00;
        this.albumImageUrl = "";
        this.songName = "";
        this.artistName = "";
        this.KEY_MUSIC_ALARM_DATA = "key_music_alarm_data";
        MusicAlarmParcelable musicAlarmParcelable0 = this.getMusicAlarmSavedState();
        if(musicAlarmParcelable0 != null) {
            this.musicAlarm = e.h(musicAlarmParcelable0);
        }
    }

    @NotNull
    public final String getAlbumImageUrl() {
        return this.albumImageUrl;
    }

    @NotNull
    public final String getArtistName() {
        return this.artistName;
    }

    @Nullable
    public final d getMusicAlarm() {
        return this.musicAlarm;
    }

    public final int getMusicAlarmId() {
        Integer integer0 = (Integer)this.savedStateHandle.a("key_alarm_id");
        return integer0 == null ? 0 : ((int)integer0);
    }

    private final MusicAlarmParcelable getMusicAlarmSavedState() {
        return (MusicAlarmParcelable)this.savedStateHandle.a(this.KEY_MUSIC_ALARM_DATA);
    }

    @NotNull
    public final String getSongName() {
        return this.songName;
    }

    private final f getTiaraEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = "";
        f0.c = "";
        f0.I = "1000003194";
        return f0;
    }

    @Nullable
    public final Track getVoiceTrackSavedState() {
        return (Track)this.savedStateHandle.a("voice_track");
    }

    public final boolean isAdult() {
        return this.isAdult;
    }

    public final void sendSaveClickLog() {
        d d0 = this.musicAlarm;
        if(d0 != null) {
            this.trackTiaraEventLog(new com.iloen.melon.fragments.settings.alarm.g(d0, 1));
        }
    }

    private static final f sendSaveClickLog$lambda$6$lambda$5(d d0, f f0) {
        q.g(f0, "$this$trackTiaraEventLog");
        f0.a = "";
        f0.y = "";
        f0.F = "";
        if(d0.i == 2) {
            Track voiceAlarm$Track0 = d0.m;
            if(voiceAlarm$Track0 != null) {
                f0.b0 = new Builder().id(voiceAlarm$Track0.getTrackId()).type("").name(voiceAlarm$Track0.getTrackName()).build();
            }
        }
        return f0;
    }

    public final void setAdult(boolean z) {
        this.isAdult = z;
    }

    public final void setAlbumImageUrl(@NotNull String s) {
        q.g(s, "<set-?>");
        this.albumImageUrl = s;
    }

    public final void setArtistName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.artistName = s;
    }

    public final void setMusicAlarm(@Nullable d d0) {
        this.musicAlarm = d0;
    }

    public final void setMusicAlarmId(int v) {
        this.savedStateHandle.b(v, "key_alarm_id");
    }

    public final void setMusicAlarmSavedState(@Nullable MusicAlarmParcelable musicAlarmParcelable0) {
        this.savedStateHandle.b(musicAlarmParcelable0, this.KEY_MUSIC_ALARM_DATA);
    }

    public final void setSongName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.songName = s;
    }

    public final void setVoiceTrackSavedState(@Nullable Track voiceAlarm$Track0) {
        this.savedStateHandle.b(voiceAlarm$Track0, "voice_track");
    }

    public final void trackTiaraEventLog(@NotNull k k0) {
        q.g(k0, "action");
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            ((f)k0.invoke(f0)).a().track();
        }
    }
}

