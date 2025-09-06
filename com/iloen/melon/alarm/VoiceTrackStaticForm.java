package com.iloen.melon.alarm;

import A7.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\"\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u007F\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010 \u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010!\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\"\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u0081\u0001\u0010$\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010%\u001A\u00020&2\b\u0010\'\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010(\u001A\u00020)H\u00D6\u0001J\t\u0010*\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0010\u00A8\u0006+"}, d2 = {"Lcom/iloen/melon/alarm/VoiceTrackStaticForm;", "", "trackId", "", "trackName", "artistId", "artistName", "albumId", "albumName", "albumImage", "startDate", "endDate", "playTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTrackId", "()Ljava/lang/String;", "getTrackName", "getArtistId", "getArtistName", "getAlbumId", "getAlbumName", "getAlbumImage", "getStartDate", "getEndDate", "getPlayTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceTrackStaticForm {
    public static final int $stable;
    @Nullable
    private final String albumId;
    @Nullable
    private final String albumImage;
    @Nullable
    private final String albumName;
    @Nullable
    private final String artistId;
    @Nullable
    private final String artistName;
    @Nullable
    private final String endDate;
    @Nullable
    private final String playTime;
    @Nullable
    private final String startDate;
    @Nullable
    private final String trackId;
    @Nullable
    private final String trackName;

    public VoiceTrackStaticForm() {
        this(null, null, null, null, null, null, null, null, null, null, 0x3FF, null);
    }

    public VoiceTrackStaticForm(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
        this.trackId = s;
        this.trackName = s1;
        this.artistId = s2;
        this.artistName = s3;
        this.albumId = s4;
        this.albumName = s5;
        this.albumImage = s6;
        this.startDate = s7;
        this.endDate = s8;
        this.playTime = s9;
    }

    public VoiceTrackStaticForm(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            s3 = null;
        }
        if((v & 16) != 0) {
            s4 = null;
        }
        if((v & 0x20) != 0) {
            s5 = null;
        }
        if((v & 0x40) != 0) {
            s6 = null;
        }
        if((v & 0x80) != 0) {
            s7 = null;
        }
        if((v & 0x100) != 0) {
            s8 = null;
        }
        this(s, s1, s2, s3, s4, s5, s6, s7, s8, ((v & 0x200) == 0 ? s9 : null));
    }

    @Nullable
    public final String component1() {
        return this.trackId;
    }

    @Nullable
    public final String component10() {
        return this.playTime;
    }

    @Nullable
    public final String component2() {
        return this.trackName;
    }

    @Nullable
    public final String component3() {
        return this.artistId;
    }

    @Nullable
    public final String component4() {
        return this.artistName;
    }

    @Nullable
    public final String component5() {
        return this.albumId;
    }

    @Nullable
    public final String component6() {
        return this.albumName;
    }

    @Nullable
    public final String component7() {
        return this.albumImage;
    }

    @Nullable
    public final String component8() {
        return this.startDate;
    }

    @Nullable
    public final String component9() {
        return this.endDate;
    }

    @NotNull
    public final VoiceTrackStaticForm copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9) {
        return new VoiceTrackStaticForm(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    public static VoiceTrackStaticForm copy$default(VoiceTrackStaticForm voiceTrackStaticForm0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, int v, Object object0) {
        if((v & 1) != 0) {
            s = voiceTrackStaticForm0.trackId;
        }
        if((v & 2) != 0) {
            s1 = voiceTrackStaticForm0.trackName;
        }
        if((v & 4) != 0) {
            s2 = voiceTrackStaticForm0.artistId;
        }
        if((v & 8) != 0) {
            s3 = voiceTrackStaticForm0.artistName;
        }
        if((v & 16) != 0) {
            s4 = voiceTrackStaticForm0.albumId;
        }
        if((v & 0x20) != 0) {
            s5 = voiceTrackStaticForm0.albumName;
        }
        if((v & 0x40) != 0) {
            s6 = voiceTrackStaticForm0.albumImage;
        }
        if((v & 0x80) != 0) {
            s7 = voiceTrackStaticForm0.startDate;
        }
        if((v & 0x100) != 0) {
            s8 = voiceTrackStaticForm0.endDate;
        }
        if((v & 0x200) != 0) {
            s9 = voiceTrackStaticForm0.playTime;
        }
        return voiceTrackStaticForm0.copy(s, s1, s2, s3, s4, s5, s6, s7, s8, s9);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof VoiceTrackStaticForm)) {
            return false;
        }
        if(!q.b(this.trackId, ((VoiceTrackStaticForm)object0).trackId)) {
            return false;
        }
        if(!q.b(this.trackName, ((VoiceTrackStaticForm)object0).trackName)) {
            return false;
        }
        if(!q.b(this.artistId, ((VoiceTrackStaticForm)object0).artistId)) {
            return false;
        }
        if(!q.b(this.artistName, ((VoiceTrackStaticForm)object0).artistName)) {
            return false;
        }
        if(!q.b(this.albumId, ((VoiceTrackStaticForm)object0).albumId)) {
            return false;
        }
        if(!q.b(this.albumName, ((VoiceTrackStaticForm)object0).albumName)) {
            return false;
        }
        if(!q.b(this.albumImage, ((VoiceTrackStaticForm)object0).albumImage)) {
            return false;
        }
        if(!q.b(this.startDate, ((VoiceTrackStaticForm)object0).startDate)) {
            return false;
        }
        return q.b(this.endDate, ((VoiceTrackStaticForm)object0).endDate) ? q.b(this.playTime, ((VoiceTrackStaticForm)object0).playTime) : false;
    }

    @Nullable
    public final String getAlbumId() {
        return this.albumId;
    }

    @Nullable
    public final String getAlbumImage() {
        return this.albumImage;
    }

    @Nullable
    public final String getAlbumName() {
        return this.albumName;
    }

    @Nullable
    public final String getArtistId() {
        return this.artistId;
    }

    @Nullable
    public final String getArtistName() {
        return this.artistName;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getPlayTime() {
        return this.playTime;
    }

    @Nullable
    public final String getStartDate() {
        return this.startDate;
    }

    @Nullable
    public final String getTrackId() {
        return this.trackId;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.trackId == null ? 0 : this.trackId.hashCode();
        int v2 = this.trackName == null ? 0 : this.trackName.hashCode();
        int v3 = this.artistId == null ? 0 : this.artistId.hashCode();
        int v4 = this.artistName == null ? 0 : this.artistName.hashCode();
        int v5 = this.albumId == null ? 0 : this.albumId.hashCode();
        int v6 = this.albumName == null ? 0 : this.albumName.hashCode();
        int v7 = this.albumImage == null ? 0 : this.albumImage.hashCode();
        int v8 = this.startDate == null ? 0 : this.startDate.hashCode();
        int v9 = this.endDate == null ? 0 : this.endDate.hashCode();
        String s = this.playTime;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("VoiceTrackStaticForm(trackId=", this.trackId, ", trackName=", this.trackName, ", artistId=");
        d.u(stringBuilder0, this.artistId, ", artistName=", this.artistName, ", albumId=");
        d.u(stringBuilder0, this.albumId, ", albumName=", this.albumName, ", albumImage=");
        d.u(stringBuilder0, this.albumImage, ", startDate=", this.startDate, ", endDate=");
        return d.n(stringBuilder0, this.endDate, ", playTime=", this.playTime, ")");
    }
}

