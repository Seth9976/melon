package com.iloen.melon.playback.playlist.add;

import A7.d;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pc.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0002\u0012\u0006\u0010\b\u001A\u00020\u0002\u0012\u0006\u0010\t\u001A\u00020\u0002\u0012\u0006\u0010\n\u001A\u00020\u0002\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0010J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019Jl\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00022\b\b\u0002\u0010\u0007\u001A\u00020\u00022\b\b\u0002\u0010\b\u001A\u00020\u00022\b\b\u0002\u0010\t\u001A\u00020\u00022\b\b\u0002\u0010\n\u001A\u00020\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u0010J\u0010\u0010\u001E\u001A\u00020\u001DH\u00D6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001A\u0010#\u001A\u00020\"2\b\u0010!\u001A\u0004\u0018\u00010 H\u00D6\u0003\u00A2\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010%\u001A\u0004\b&\u0010\u0010R\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010%\u001A\u0004\b\'\u0010\u0010R\u0017\u0010\u0005\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010%\u001A\u0004\b(\u0010\u0010R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010%\u001A\u0004\b)\u0010\u0010R\u0017\u0010\u0007\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010%\u001A\u0004\b*\u0010\u0010R\u0017\u0010\b\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\b\u0010%\u001A\u0004\b+\u0010\u0010R\u0017\u0010\t\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\t\u0010%\u001A\u0004\b,\u0010\u0010R\u0017\u0010\n\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\n\u0010%\u001A\u0004\b-\u0010\u0010R\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010.\u001A\u0004\b/\u0010\u0019\u00A8\u00060"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/DjMalrangRequestInfo;", "Lcom/iloen/melon/playback/playlist/add/MixUpRequestInfo;", "", "mainTitle", "artistName", "artistImg", "songTitle", "playlistId", "poolId", "playlistType", "titleKey", "Lpc/b;", "requestColorType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpc/b;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "()Lpc/b;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpc/b;)Lcom/iloen/melon/playback/playlist/add/DjMalrangRequestInfo;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMainTitle", "getArtistName", "getArtistImg", "getSongTitle", "getPlaylistId", "getPoolId", "getPlaylistType", "getTitleKey", "Lpc/b;", "getRequestColorType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjMalrangRequestInfo implements MixUpRequestInfo {
    public static final int $stable;
    @NotNull
    private final String artistImg;
    @NotNull
    private final String artistName;
    @NotNull
    private final String mainTitle;
    @NotNull
    private final String playlistId;
    @NotNull
    private final String playlistType;
    @NotNull
    private final String poolId;
    @Nullable
    private final b requestColorType;
    @NotNull
    private final String songTitle;
    @NotNull
    private final String titleKey;

    public DjMalrangRequestInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @Nullable b b0) {
        q.g(s, "mainTitle");
        q.g(s1, "artistName");
        q.g(s2, "artistImg");
        q.g(s3, "songTitle");
        q.g(s4, "playlistId");
        q.g(s5, "poolId");
        q.g(s6, "playlistType");
        q.g(s7, "titleKey");
        super();
        this.mainTitle = s;
        this.artistName = s1;
        this.artistImg = s2;
        this.songTitle = s3;
        this.playlistId = s4;
        this.poolId = s5;
        this.playlistType = s6;
        this.titleKey = s7;
        this.requestColorType = b0;
    }

    public DjMalrangRequestInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, b b0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, s3, s4, s5, s6, s7, ((v & 0x100) == 0 ? b0 : null));
    }

    @NotNull
    public final String component1() {
        return this.mainTitle;
    }

    @NotNull
    public final String component2() {
        return this.artistName;
    }

    @NotNull
    public final String component3() {
        return this.artistImg;
    }

    @NotNull
    public final String component4() {
        return this.songTitle;
    }

    @NotNull
    public final String component5() {
        return this.playlistId;
    }

    @NotNull
    public final String component6() {
        return this.poolId;
    }

    @NotNull
    public final String component7() {
        return this.playlistType;
    }

    @NotNull
    public final String component8() {
        return this.titleKey;
    }

    @Nullable
    public final b component9() {
        return this.requestColorType;
    }

    @NotNull
    public final DjMalrangRequestInfo copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @Nullable b b0) {
        q.g(s, "mainTitle");
        q.g(s1, "artistName");
        q.g(s2, "artistImg");
        q.g(s3, "songTitle");
        q.g(s4, "playlistId");
        q.g(s5, "poolId");
        q.g(s6, "playlistType");
        q.g(s7, "titleKey");
        return new DjMalrangRequestInfo(s, s1, s2, s3, s4, s5, s6, s7, b0);
    }

    public static DjMalrangRequestInfo copy$default(DjMalrangRequestInfo djMalrangRequestInfo0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, b b0, int v, Object object0) {
        if((v & 1) != 0) {
            s = djMalrangRequestInfo0.mainTitle;
        }
        if((v & 2) != 0) {
            s1 = djMalrangRequestInfo0.artistName;
        }
        if((v & 4) != 0) {
            s2 = djMalrangRequestInfo0.artistImg;
        }
        if((v & 8) != 0) {
            s3 = djMalrangRequestInfo0.songTitle;
        }
        if((v & 16) != 0) {
            s4 = djMalrangRequestInfo0.playlistId;
        }
        if((v & 0x20) != 0) {
            s5 = djMalrangRequestInfo0.poolId;
        }
        if((v & 0x40) != 0) {
            s6 = djMalrangRequestInfo0.playlistType;
        }
        if((v & 0x80) != 0) {
            s7 = djMalrangRequestInfo0.titleKey;
        }
        if((v & 0x100) != 0) {
            b0 = djMalrangRequestInfo0.requestColorType;
        }
        return djMalrangRequestInfo0.copy(s, s1, s2, s3, s4, s5, s6, s7, b0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DjMalrangRequestInfo)) {
            return false;
        }
        if(!q.b(this.mainTitle, ((DjMalrangRequestInfo)object0).mainTitle)) {
            return false;
        }
        if(!q.b(this.artistName, ((DjMalrangRequestInfo)object0).artistName)) {
            return false;
        }
        if(!q.b(this.artistImg, ((DjMalrangRequestInfo)object0).artistImg)) {
            return false;
        }
        if(!q.b(this.songTitle, ((DjMalrangRequestInfo)object0).songTitle)) {
            return false;
        }
        if(!q.b(this.playlistId, ((DjMalrangRequestInfo)object0).playlistId)) {
            return false;
        }
        if(!q.b(this.poolId, ((DjMalrangRequestInfo)object0).poolId)) {
            return false;
        }
        if(!q.b(this.playlistType, ((DjMalrangRequestInfo)object0).playlistType)) {
            return false;
        }
        return q.b(this.titleKey, ((DjMalrangRequestInfo)object0).titleKey) ? this.requestColorType == ((DjMalrangRequestInfo)object0).requestColorType : false;
    }

    @NotNull
    public final String getArtistImg() {
        return this.artistImg;
    }

    @NotNull
    public final String getArtistName() {
        return this.artistName;
    }

    @NotNull
    public final String getMainTitle() {
        return this.mainTitle;
    }

    @NotNull
    public final String getPlaylistId() {
        return this.playlistId;
    }

    @NotNull
    public final String getPlaylistType() {
        return this.playlistType;
    }

    @NotNull
    public final String getPoolId() {
        return this.poolId;
    }

    @Nullable
    public final b getRequestColorType() {
        return this.requestColorType;
    }

    @NotNull
    public final String getSongTitle() {
        return this.songTitle;
    }

    @NotNull
    public final String getTitleKey() {
        return this.titleKey;
    }

    @Override
    public int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.mainTitle.hashCode() * 0x1F, 0x1F, this.artistName), 0x1F, this.artistImg), 0x1F, this.songTitle), 0x1F, this.playlistId), 0x1F, this.poolId), 0x1F, this.playlistType), 0x1F, this.titleKey);
        return this.requestColorType == null ? v : v + this.requestColorType.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("DjMalrangRequestInfo(mainTitle=", this.mainTitle, ", artistName=", this.artistName, ", artistImg=");
        d.u(stringBuilder0, this.artistImg, ", songTitle=", this.songTitle, ", playlistId=");
        d.u(stringBuilder0, this.playlistId, ", poolId=", this.poolId, ", playlistType=");
        d.u(stringBuilder0, this.playlistType, ", titleKey=", this.titleKey, ", requestColorType=");
        stringBuilder0.append(this.requestColorType);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

