package com.iloen.melon.playback.playlist.musicwave;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0014\u001A\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveNextSongInfo;", "", "songId", "", "songName", "artistName", "imgUrl", "cType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSongId", "()Ljava/lang/String;", "getSongName", "getArtistName", "getImgUrl", "getCType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveNextSongInfo {
    public static final int $stable;
    @Nullable
    private final String artistName;
    @Nullable
    private final String cType;
    @Nullable
    private final String imgUrl;
    @Nullable
    private final String songId;
    @Nullable
    private final String songName;

    public MusicWaveNextSongInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
        this.songId = s;
        this.songName = s1;
        this.artistName = s2;
        this.imgUrl = s3;
        this.cType = s4;
    }

    @Nullable
    public final String component1() {
        return this.songId;
    }

    @Nullable
    public final String component2() {
        return this.songName;
    }

    @Nullable
    public final String component3() {
        return this.artistName;
    }

    @Nullable
    public final String component4() {
        return this.imgUrl;
    }

    @Nullable
    public final String component5() {
        return this.cType;
    }

    @NotNull
    public final MusicWaveNextSongInfo copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
        return new MusicWaveNextSongInfo(s, s1, s2, s3, s4);
    }

    public static MusicWaveNextSongInfo copy$default(MusicWaveNextSongInfo musicWaveNextSongInfo0, String s, String s1, String s2, String s3, String s4, int v, Object object0) {
        if((v & 1) != 0) {
            s = musicWaveNextSongInfo0.songId;
        }
        if((v & 2) != 0) {
            s1 = musicWaveNextSongInfo0.songName;
        }
        if((v & 4) != 0) {
            s2 = musicWaveNextSongInfo0.artistName;
        }
        if((v & 8) != 0) {
            s3 = musicWaveNextSongInfo0.imgUrl;
        }
        if((v & 16) != 0) {
            s4 = musicWaveNextSongInfo0.cType;
        }
        return musicWaveNextSongInfo0.copy(s, s1, s2, s3, s4);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicWaveNextSongInfo)) {
            return false;
        }
        if(!q.b(this.songId, ((MusicWaveNextSongInfo)object0).songId)) {
            return false;
        }
        if(!q.b(this.songName, ((MusicWaveNextSongInfo)object0).songName)) {
            return false;
        }
        if(!q.b(this.artistName, ((MusicWaveNextSongInfo)object0).artistName)) {
            return false;
        }
        return q.b(this.imgUrl, ((MusicWaveNextSongInfo)object0).imgUrl) ? q.b(this.cType, ((MusicWaveNextSongInfo)object0).cType) : false;
    }

    @Nullable
    public final String getArtistName() {
        return this.artistName;
    }

    @Nullable
    public final String getCType() {
        return this.cType;
    }

    @Nullable
    public final String getImgUrl() {
        return this.imgUrl;
    }

    @Nullable
    public final String getSongId() {
        return this.songId;
    }

    @Nullable
    public final String getSongName() {
        return this.songName;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.songId == null ? 0 : this.songId.hashCode();
        int v2 = this.songName == null ? 0 : this.songName.hashCode();
        int v3 = this.artistName == null ? 0 : this.artistName.hashCode();
        int v4 = this.imgUrl == null ? 0 : this.imgUrl.hashCode();
        String s = this.cType;
        if(s != null) {
            v = s.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("MusicWaveNextSongInfo(songId=", this.songId, ", songName=", this.songName, ", artistName=");
        d.u(stringBuilder0, this.artistName, ", imgUrl=", this.imgUrl, ", cType=");
        return x.m(stringBuilder0, this.cType, ")");
    }
}

