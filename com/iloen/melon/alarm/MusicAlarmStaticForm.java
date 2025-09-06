package com.iloen.melon.alarm;

import A7.d;
import U4.x;
import android.content.Context;
import androidx.appcompat.app.o;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.VolumeUtils.Companion;
import com.iloen.melon.utils.system.VolumeUtils;
import java.util.Arrays;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\b\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\u0004\b\u0011\u0010\u0012J\t\u00100\u001A\u00020\u0003H\u00C6\u0003J\t\u00101\u001A\u00020\u0003H\u00C6\u0003J\t\u00102\u001A\u00020\u0003H\u00C6\u0003J\t\u00103\u001A\u00020\u0003H\u00C6\u0003J\t\u00104\u001A\u00020\bH\u00C6\u0003J\t\u00105\u001A\u00020\nH\u00C6\u0003J\t\u00106\u001A\u00020\bH\u00C6\u0003J\t\u00107\u001A\u00020\u0003H\u00C6\u0003J\u000B\u00108\u001A\u0004\u0018\u00010\u000EH\u00C6\u0003J\u000B\u00109\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003Jq\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u00C6\u0001J\u0013\u0010;\u001A\u00020\b2\b\u0010<\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010=\u001A\u00020\u0003H\u00D6\u0001J\t\u0010>\u001A\u00020?H\u00D6\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001A\u0010\u0005\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0014\"\u0004\b\u001A\u0010\u0016R\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0014\"\u0004\b\u001C\u0010\u0016R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u001A\u0010\t\u001A\u00020\nX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001A\u0010\u000B\u001A\u00020\bX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u001D\"\u0004\b%\u0010\u001FR\u001A\u0010\f\u001A\u00020\u0003X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0014\"\u0004\b\'\u0010\u0016R\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/alarm/MusicAlarmStaticForm;", "", "id", "", "hour", "minute", "volume", "isOn", "", "weekDays", "", "oneTimeAlarm", "soundType", "song", "Lcom/iloen/melon/alarm/SongStaticForm;", "voiceTrack", "Lcom/iloen/melon/alarm/VoiceTrackStaticForm;", "<init>", "(IIIIZ[ZZILcom/iloen/melon/alarm/SongStaticForm;Lcom/iloen/melon/alarm/VoiceTrackStaticForm;)V", "getId", "()I", "setId", "(I)V", "getHour", "setHour", "getMinute", "setMinute", "getVolume", "setVolume", "()Z", "setOn", "(Z)V", "getWeekDays", "()[Z", "setWeekDays", "([Z)V", "getOneTimeAlarm", "setOneTimeAlarm", "getSoundType", "setSoundType", "getSong", "()Lcom/iloen/melon/alarm/SongStaticForm;", "setSong", "(Lcom/iloen/melon/alarm/SongStaticForm;)V", "getVoiceTrack", "()Lcom/iloen/melon/alarm/VoiceTrackStaticForm;", "setVoiceTrack", "(Lcom/iloen/melon/alarm/VoiceTrackStaticForm;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicAlarmStaticForm {
    public static final int $stable = 8;
    private int hour;
    private int id;
    private boolean isOn;
    private int minute;
    private boolean oneTimeAlarm;
    @Nullable
    private SongStaticForm song;
    private int soundType;
    @Nullable
    private VoiceTrackStaticForm voiceTrack;
    private int volume;
    @NotNull
    private boolean[] weekDays;

    public MusicAlarmStaticForm() {
        this(0, 0, 0, 0, false, null, false, 0, null, null, 0x3FF, null);
    }

    public MusicAlarmStaticForm(int v, int v1, int v2, int v3, boolean z, @NotNull boolean[] arr_z, boolean z1, int v4, @Nullable SongStaticForm songStaticForm0, @Nullable VoiceTrackStaticForm voiceTrackStaticForm0) {
        q.g(arr_z, "weekDays");
        super();
        this.id = v;
        this.hour = v1;
        this.minute = v2;
        this.volume = v3;
        this.isOn = z;
        this.weekDays = arr_z;
        this.oneTimeAlarm = z1;
        this.soundType = v4;
        this.song = songStaticForm0;
        this.voiceTrack = voiceTrackStaticForm0;
    }

    public MusicAlarmStaticForm(int v, int v1, int v2, int v3, boolean z, boolean[] arr_z, boolean z1, int v4, SongStaticForm songStaticForm0, VoiceTrackStaticForm voiceTrackStaticForm0, int v5, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v5 & 1) != 0) {
            v = 0;
        }
        if((v5 & 2) != 0) {
            v1 = 0;
        }
        if((v5 & 4) != 0) {
            v2 = 0;
        }
        if((v5 & 8) != 0) {
            MelonAppBase.Companion.getClass();
            Context context0 = t.a().getContext();
            v3 = Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null) / 2;
        }
        if((v5 & 16) != 0) {
            z = true;
        }
        if((v5 & 0x20) != 0) {
            arr_z = new boolean[7];
        }
        if((v5 & 0x40) != 0) {
            z1 = false;
        }
        if((v5 & 0x80) != 0) {
            v4 = 0;
        }
        if((v5 & 0x100) != 0) {
            songStaticForm0 = null;
        }
        this(v, v1, v2, v3, z, arr_z, z1, v4, songStaticForm0, ((v5 & 0x200) == 0 ? voiceTrackStaticForm0 : null));
    }

    public final int component1() {
        return this.id;
    }

    @Nullable
    public final VoiceTrackStaticForm component10() {
        return this.voiceTrack;
    }

    public final int component2() {
        return this.hour;
    }

    public final int component3() {
        return this.minute;
    }

    public final int component4() {
        return this.volume;
    }

    public final boolean component5() {
        return this.isOn;
    }

    @NotNull
    public final boolean[] component6() {
        return this.weekDays;
    }

    public final boolean component7() {
        return this.oneTimeAlarm;
    }

    public final int component8() {
        return this.soundType;
    }

    @Nullable
    public final SongStaticForm component9() {
        return this.song;
    }

    @NotNull
    public final MusicAlarmStaticForm copy(int v, int v1, int v2, int v3, boolean z, @NotNull boolean[] arr_z, boolean z1, int v4, @Nullable SongStaticForm songStaticForm0, @Nullable VoiceTrackStaticForm voiceTrackStaticForm0) {
        q.g(arr_z, "weekDays");
        return new MusicAlarmStaticForm(v, v1, v2, v3, z, arr_z, z1, v4, songStaticForm0, voiceTrackStaticForm0);
    }

    public static MusicAlarmStaticForm copy$default(MusicAlarmStaticForm musicAlarmStaticForm0, int v, int v1, int v2, int v3, boolean z, boolean[] arr_z, boolean z1, int v4, SongStaticForm songStaticForm0, VoiceTrackStaticForm voiceTrackStaticForm0, int v5, Object object0) {
        if((v5 & 1) != 0) {
            v = musicAlarmStaticForm0.id;
        }
        if((v5 & 2) != 0) {
            v1 = musicAlarmStaticForm0.hour;
        }
        if((v5 & 4) != 0) {
            v2 = musicAlarmStaticForm0.minute;
        }
        if((v5 & 8) != 0) {
            v3 = musicAlarmStaticForm0.volume;
        }
        if((v5 & 16) != 0) {
            z = musicAlarmStaticForm0.isOn;
        }
        if((v5 & 0x20) != 0) {
            arr_z = musicAlarmStaticForm0.weekDays;
        }
        if((v5 & 0x40) != 0) {
            z1 = musicAlarmStaticForm0.oneTimeAlarm;
        }
        if((v5 & 0x80) != 0) {
            v4 = musicAlarmStaticForm0.soundType;
        }
        if((v5 & 0x100) != 0) {
            songStaticForm0 = musicAlarmStaticForm0.song;
        }
        if((v5 & 0x200) != 0) {
            voiceTrackStaticForm0 = musicAlarmStaticForm0.voiceTrack;
        }
        return musicAlarmStaticForm0.copy(v, v1, v2, v3, z, arr_z, z1, v4, songStaticForm0, voiceTrackStaticForm0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicAlarmStaticForm)) {
            return false;
        }
        if(this.id != ((MusicAlarmStaticForm)object0).id) {
            return false;
        }
        if(this.hour != ((MusicAlarmStaticForm)object0).hour) {
            return false;
        }
        if(this.minute != ((MusicAlarmStaticForm)object0).minute) {
            return false;
        }
        if(this.volume != ((MusicAlarmStaticForm)object0).volume) {
            return false;
        }
        if(this.isOn != ((MusicAlarmStaticForm)object0).isOn) {
            return false;
        }
        if(!q.b(this.weekDays, ((MusicAlarmStaticForm)object0).weekDays)) {
            return false;
        }
        if(this.oneTimeAlarm != ((MusicAlarmStaticForm)object0).oneTimeAlarm) {
            return false;
        }
        if(this.soundType != ((MusicAlarmStaticForm)object0).soundType) {
            return false;
        }
        return q.b(this.song, ((MusicAlarmStaticForm)object0).song) ? q.b(this.voiceTrack, ((MusicAlarmStaticForm)object0).voiceTrack) : false;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getId() {
        return this.id;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final boolean getOneTimeAlarm() {
        return this.oneTimeAlarm;
    }

    @Nullable
    public final SongStaticForm getSong() {
        return this.song;
    }

    public final int getSoundType() {
        return this.soundType;
    }

    @Nullable
    public final VoiceTrackStaticForm getVoiceTrack() {
        return this.voiceTrack;
    }

    public final int getVolume() {
        return this.volume;
    }

    @NotNull
    public final boolean[] getWeekDays() {
        return this.weekDays;
    }

    @Override
    public int hashCode() {
        int v = d.e(d.b(this.volume, d.b(this.minute, d.b(this.hour, this.id * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F, this.isOn);
        int v1 = d.e((Arrays.hashCode(this.weekDays) + v) * 0x1F, 0x1F, this.oneTimeAlarm);
        int v2 = d.b(this.soundType, v1, 0x1F);
        int v3 = 0;
        int v4 = this.song == null ? 0 : this.song.hashCode();
        VoiceTrackStaticForm voiceTrackStaticForm0 = this.voiceTrack;
        if(voiceTrackStaticForm0 != null) {
            v3 = voiceTrackStaticForm0.hashCode();
        }
        return (v2 + v4) * 0x1F + v3;
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setHour(int v) {
        this.hour = v;
    }

    public final void setId(int v) {
        this.id = v;
    }

    public final void setMinute(int v) {
        this.minute = v;
    }

    public final void setOn(boolean z) {
        this.isOn = z;
    }

    public final void setOneTimeAlarm(boolean z) {
        this.oneTimeAlarm = z;
    }

    public final void setSong(@Nullable SongStaticForm songStaticForm0) {
        this.song = songStaticForm0;
    }

    public final void setSoundType(int v) {
        this.soundType = v;
    }

    public final void setVoiceTrack(@Nullable VoiceTrackStaticForm voiceTrackStaticForm0) {
        this.voiceTrack = voiceTrackStaticForm0;
    }

    public final void setVolume(int v) {
        this.volume = v;
    }

    public final void setWeekDays(@NotNull boolean[] arr_z) {
        q.g(arr_z, "<set-?>");
        this.weekDays = arr_z;
    }

    @Override
    @NotNull
    public String toString() {
        int v = this.id;
        int v1 = this.hour;
        int v2 = this.minute;
        int v3 = this.volume;
        boolean z = this.isOn;
        String s = Arrays.toString(this.weekDays);
        boolean z1 = this.oneTimeAlarm;
        int v4 = this.soundType;
        SongStaticForm songStaticForm0 = this.song;
        VoiceTrackStaticForm voiceTrackStaticForm0 = this.voiceTrack;
        StringBuilder stringBuilder0 = o.t(v, v1, "MusicAlarmStaticForm(id=", ", hour=", ", minute=");
        x.x(stringBuilder0, v2, ", volume=", v3, ", isOn=");
        Y.y(stringBuilder0, z, ", weekDays=", s, ", oneTimeAlarm=");
        stringBuilder0.append(z1);
        stringBuilder0.append(", soundType=");
        stringBuilder0.append(v4);
        stringBuilder0.append(", song=");
        stringBuilder0.append(songStaticForm0);
        stringBuilder0.append(", voiceTrack=");
        stringBuilder0.append(voiceTrackStaticForm0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

