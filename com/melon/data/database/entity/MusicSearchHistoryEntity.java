package com.melon.data.database.entity;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b6\b\u0087\b\u0018\u00002\u00020\u0001Bw\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u000E\u0012\u0006\u0010\u0010\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0015J\t\u00106\u001A\u00020\u0003H\u00C6\u0003J\t\u00107\u001A\u00020\u0005H\u00C6\u0003J\t\u00108\u001A\u00020\u0005H\u00C6\u0003J\t\u00109\u001A\u00020\u0005H\u00C6\u0003J\t\u0010:\u001A\u00020\u0005H\u00C6\u0003J\t\u0010;\u001A\u00020\u0005H\u00C6\u0003J\t\u0010<\u001A\u00020\u0005H\u00C6\u0003J\t\u0010=\u001A\u00020\u0005H\u00C6\u0003J\t\u0010>\u001A\u00020\u0005H\u00C6\u0003J\t\u0010?\u001A\u00020\u000EH\u00C6\u0003J\t\u0010@\u001A\u00020\u000EH\u00C6\u0003J\t\u0010A\u001A\u00020\u0005H\u00C6\u0003J\t\u0010B\u001A\u00020\u0012H\u00C6\u0003J\u008B\u0001\u0010C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u00C6\u0001J\u0013\u0010D\u001A\u00020\u000E2\b\u0010E\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010F\u001A\u00020\u0003H\u00D6\u0001J\t\u0010G\u001A\u00020\u0005H\u00D6\u0001R\u001E\u0010\u0002\u001A\u00020\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001E\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001B\"\u0004\b\u001F\u0010\u001DR\u001E\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u001B\"\u0004\b!\u0010\u001DR\u001E\u0010\b\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u001B\"\u0004\b#\u0010\u001DR\u001E\u0010\t\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u001B\"\u0004\b%\u0010\u001DR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u001B\"\u0004\b\'\u0010\u001DR\u001E\u0010\u000B\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u001B\"\u0004\b)\u0010\u001DR\u001E\u0010\f\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b*\u0010\u001B\"\u0004\b+\u0010\u001DR\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010,\"\u0004\b-\u0010.R\u001E\u0010\u000F\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010,\"\u0004\b/\u0010.R\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b0\u0010\u001B\"\u0004\b1\u0010\u001DR\u001E\u0010\u0011\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u00103\"\u0004\b4\u00105\u00A8\u0006H"}, d2 = {"Lcom/melon/data/database/entity/MusicSearchHistoryEntity;", "", "uid", "", "songId", "", "songName", "albumId", "albumName", "albumImgPath", "artistId", "artistName", "cType", "isService", "", "isAdult", "playTime", "timestamp", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;J)V", "()V", "getUid", "()I", "setUid", "(I)V", "getSongId", "()Ljava/lang/String;", "setSongId", "(Ljava/lang/String;)V", "getSongName", "setSongName", "getAlbumId", "setAlbumId", "getAlbumName", "setAlbumName", "getAlbumImgPath", "setAlbumImgPath", "getArtistId", "setArtistId", "getArtistName", "setArtistName", "getCType", "setCType", "()Z", "setService", "(Z)V", "setAdult", "getPlayTime", "setPlayTime", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicSearchHistoryEntity {
    public static final int $stable = 8;
    @NotNull
    private String albumId;
    @NotNull
    private String albumImgPath;
    @NotNull
    private String albumName;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private String cType;
    private boolean isAdult;
    private boolean isService;
    @NotNull
    private String playTime;
    @NotNull
    private String songId;
    @NotNull
    private String songName;
    private long timestamp;
    private int uid;

    public MusicSearchHistoryEntity() {
        this(0, "", "", "", "", "", "", "", "", false, false, "", 0L);
    }

    public MusicSearchHistoryEntity(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, boolean z, boolean z1, @NotNull String s8, long v1) {
        q.g(s, "songId");
        q.g(s1, "songName");
        q.g(s2, "albumId");
        q.g(s3, "albumName");
        q.g(s4, "albumImgPath");
        q.g(s5, "artistId");
        q.g(s6, "artistName");
        q.g(s7, "cType");
        q.g(s8, "playTime");
        super();
        this.uid = v;
        this.songId = s;
        this.songName = s1;
        this.albumId = s2;
        this.albumName = s3;
        this.albumImgPath = s4;
        this.artistId = s5;
        this.artistName = s6;
        this.cType = s7;
        this.isService = z;
        this.isAdult = z1;
        this.playTime = s8;
        this.timestamp = v1;
    }

    public MusicSearchHistoryEntity(int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, boolean z, boolean z1, String s8, long v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, s, s1, s2, s3, s4, s5, s6, s7, ((v2 & 0x200) == 0 ? z : false), ((v2 & 0x400) == 0 ? z1 : false), s8, ((v2 & 0x1000) == 0 ? v1 : 0L));
    }

    public final int component1() {
        return this.uid;
    }

    public final boolean component10() {
        return this.isService;
    }

    public final boolean component11() {
        return this.isAdult;
    }

    @NotNull
    public final String component12() {
        return this.playTime;
    }

    public final long component13() {
        return this.timestamp;
    }

    @NotNull
    public final String component2() {
        return this.songId;
    }

    @NotNull
    public final String component3() {
        return this.songName;
    }

    @NotNull
    public final String component4() {
        return this.albumId;
    }

    @NotNull
    public final String component5() {
        return this.albumName;
    }

    @NotNull
    public final String component6() {
        return this.albumImgPath;
    }

    @NotNull
    public final String component7() {
        return this.artistId;
    }

    @NotNull
    public final String component8() {
        return this.artistName;
    }

    @NotNull
    public final String component9() {
        return this.cType;
    }

    @NotNull
    public final MusicSearchHistoryEntity copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, boolean z, boolean z1, @NotNull String s8, long v1) {
        q.g(s, "songId");
        q.g(s1, "songName");
        q.g(s2, "albumId");
        q.g(s3, "albumName");
        q.g(s4, "albumImgPath");
        q.g(s5, "artistId");
        q.g(s6, "artistName");
        q.g(s7, "cType");
        q.g(s8, "playTime");
        return new MusicSearchHistoryEntity(v, s, s1, s2, s3, s4, s5, s6, s7, z, z1, s8, v1);
    }

    public static MusicSearchHistoryEntity copy$default(MusicSearchHistoryEntity musicSearchHistoryEntity0, int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, boolean z, boolean z1, String s8, long v1, int v2, Object object0) {
        int v3 = (v2 & 1) == 0 ? v : musicSearchHistoryEntity0.uid;
        String s9 = (v2 & 2) == 0 ? s : musicSearchHistoryEntity0.songId;
        String s10 = (v2 & 4) == 0 ? s1 : musicSearchHistoryEntity0.songName;
        String s11 = (v2 & 8) == 0 ? s2 : musicSearchHistoryEntity0.albumId;
        String s12 = (v2 & 16) == 0 ? s3 : musicSearchHistoryEntity0.albumName;
        String s13 = (v2 & 0x20) == 0 ? s4 : musicSearchHistoryEntity0.albumImgPath;
        String s14 = (v2 & 0x40) == 0 ? s5 : musicSearchHistoryEntity0.artistId;
        String s15 = (v2 & 0x80) == 0 ? s6 : musicSearchHistoryEntity0.artistName;
        String s16 = (v2 & 0x100) == 0 ? s7 : musicSearchHistoryEntity0.cType;
        boolean z2 = (v2 & 0x200) == 0 ? z : musicSearchHistoryEntity0.isService;
        boolean z3 = (v2 & 0x400) == 0 ? z1 : musicSearchHistoryEntity0.isAdult;
        String s17 = (v2 & 0x800) == 0 ? s8 : musicSearchHistoryEntity0.playTime;
        return (v2 & 0x1000) == 0 ? musicSearchHistoryEntity0.copy(v3, s9, s10, s11, s12, s13, s14, s15, s16, z2, z3, s17, v1) : musicSearchHistoryEntity0.copy(v3, s9, s10, s11, s12, s13, s14, s15, s16, z2, z3, s17, musicSearchHistoryEntity0.timestamp);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicSearchHistoryEntity)) {
            return false;
        }
        if(this.uid != ((MusicSearchHistoryEntity)object0).uid) {
            return false;
        }
        if(!q.b(this.songId, ((MusicSearchHistoryEntity)object0).songId)) {
            return false;
        }
        if(!q.b(this.songName, ((MusicSearchHistoryEntity)object0).songName)) {
            return false;
        }
        if(!q.b(this.albumId, ((MusicSearchHistoryEntity)object0).albumId)) {
            return false;
        }
        if(!q.b(this.albumName, ((MusicSearchHistoryEntity)object0).albumName)) {
            return false;
        }
        if(!q.b(this.albumImgPath, ((MusicSearchHistoryEntity)object0).albumImgPath)) {
            return false;
        }
        if(!q.b(this.artistId, ((MusicSearchHistoryEntity)object0).artistId)) {
            return false;
        }
        if(!q.b(this.artistName, ((MusicSearchHistoryEntity)object0).artistName)) {
            return false;
        }
        if(!q.b(this.cType, ((MusicSearchHistoryEntity)object0).cType)) {
            return false;
        }
        if(this.isService != ((MusicSearchHistoryEntity)object0).isService) {
            return false;
        }
        if(this.isAdult != ((MusicSearchHistoryEntity)object0).isAdult) {
            return false;
        }
        return q.b(this.playTime, ((MusicSearchHistoryEntity)object0).playTime) ? this.timestamp == ((MusicSearchHistoryEntity)object0).timestamp : false;
    }

    @NotNull
    public final String getAlbumId() [...] // 潜在的解密器

    @NotNull
    public final String getAlbumImgPath() [...] // 潜在的解密器

    @NotNull
    public final String getAlbumName() [...] // 潜在的解密器

    @NotNull
    public final String getArtistId() [...] // 潜在的解密器

    @NotNull
    public final String getArtistName() [...] // 潜在的解密器

    @NotNull
    public final String getCType() [...] // 潜在的解密器

    @NotNull
    public final String getPlayTime() [...] // 潜在的解密器

    @NotNull
    public final String getSongId() [...] // 潜在的解密器

    @NotNull
    public final String getSongName() [...] // 潜在的解密器

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + x.b(d.e(d.e(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.uid * 0x1F, 0x1F, this.songId), 0x1F, this.songName), 0x1F, this.albumId), 0x1F, this.albumName), 0x1F, this.albumImgPath), 0x1F, this.artistId), 0x1F, this.artistName), 0x1F, this.cType), 0x1F, this.isService), 0x1F, this.isAdult), 0x1F, this.playTime);
    }

    public final boolean isAdult() {
        return this.isAdult;
    }

    public final boolean isService() {
        return this.isService;
    }

    public final void setAdult(boolean z) {
        this.isAdult = z;
    }

    public final void setAlbumId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.albumId = s;
    }

    public final void setAlbumImgPath(@NotNull String s) {
        q.g(s, "<set-?>");
        this.albumImgPath = s;
    }

    public final void setAlbumName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.albumName = s;
    }

    public final void setArtistId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.artistId = s;
    }

    public final void setArtistName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.artistName = s;
    }

    public final void setCType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.cType = s;
    }

    public final void setPlayTime(@NotNull String s) {
        q.g(s, "<set-?>");
        this.playTime = s;
    }

    public final void setService(boolean z) {
        this.isService = z;
    }

    public final void setSongId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.songId = s;
    }

    public final void setSongName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.songName = s;
    }

    public final void setTimestamp(long v) {
        this.timestamp = v;
    }

    public final void setUid(int v) {
        this.uid = v;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.songName;
        String s1 = this.albumId;
        String s2 = this.albumName;
        String s3 = this.albumImgPath;
        String s4 = this.artistId;
        String s5 = this.artistName;
        String s6 = this.cType;
        boolean z = this.isService;
        boolean z1 = this.isAdult;
        String s7 = this.playTime;
        long v = this.timestamp;
        StringBuilder stringBuilder0 = x.o(this.uid, "MusicSearchHistoryEntity(uid=", ", songId=", this.songId, ", songName=");
        d.u(stringBuilder0, s, ", albumId=", s1, ", albumName=");
        d.u(stringBuilder0, s2, ", albumImgPath=", s3, ", artistId=");
        d.u(stringBuilder0, s4, ", artistName=", s5, ", cType=");
        Y.x(stringBuilder0, s6, ", isService=", z, ", isAdult=");
        Y.y(stringBuilder0, z1, ", playTime=", s7, ", timestamp=");
        return x.h(v, ")", stringBuilder0);
    }
}

