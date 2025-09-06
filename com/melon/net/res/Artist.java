package com.melon.net.res;

import A7.d;
import S7.b;
import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/melon/net/res/Artist;", "", "artistId", "", "artistName", "artistImgPath", "artistThumbImgPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArtistId", "()Ljava/lang/String;", "getArtistName", "getArtistImgPath", "getArtistThumbImgPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class Artist {
    public static final int $stable;
    @b("ARTISTID")
    @NotNull
    private final String artistId;
    @b("ARTISTIMGPATH")
    @NotNull
    private final String artistImgPath;
    @b("ARTISTNAME")
    @NotNull
    private final String artistName;
    @b("ARTISTTHUMBIMGPATH")
    @NotNull
    private final String artistThumbImgPath;

    public Artist() {
        this(null, null, null, null, 15, null);
    }

    public Artist(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "artistId");
        q.g(s1, "artistName");
        q.g(s2, "artistImgPath");
        q.g(s3, "artistThumbImgPath");
        super();
        this.artistId = s;
        this.artistName = s1;
        this.artistImgPath = s2;
        this.artistThumbImgPath = s3;
    }

    public Artist(String s, String s1, String s2, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = "";
        }
        if((v & 2) != 0) {
            s1 = "";
        }
        if((v & 4) != 0) {
            s2 = "";
        }
        if((v & 8) != 0) {
            s3 = "";
        }
        this(s, s1, s2, s3);
    }

    @NotNull
    public final String component1() {
        return this.artistId;
    }

    @NotNull
    public final String component2() {
        return this.artistName;
    }

    @NotNull
    public final String component3() {
        return this.artistImgPath;
    }

    @NotNull
    public final String component4() {
        return this.artistThumbImgPath;
    }

    @NotNull
    public final Artist copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "artistId");
        q.g(s1, "artistName");
        q.g(s2, "artistImgPath");
        q.g(s3, "artistThumbImgPath");
        return new Artist(s, s1, s2, s3);
    }

    public static Artist copy$default(Artist artist0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 1) != 0) {
            s = artist0.artistId;
        }
        if((v & 2) != 0) {
            s1 = artist0.artistName;
        }
        if((v & 4) != 0) {
            s2 = artist0.artistImgPath;
        }
        if((v & 8) != 0) {
            s3 = artist0.artistThumbImgPath;
        }
        return artist0.copy(s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Artist)) {
            return false;
        }
        if(!q.b(this.artistId, ((Artist)object0).artistId)) {
            return false;
        }
        if(!q.b(this.artistName, ((Artist)object0).artistName)) {
            return false;
        }
        return q.b(this.artistImgPath, ((Artist)object0).artistImgPath) ? q.b(this.artistThumbImgPath, ((Artist)object0).artistThumbImgPath) : false;
    }

    @NotNull
    public final String getArtistId() [...] // 潜在的解密器

    @NotNull
    public final String getArtistImgPath() {
        return this.artistImgPath;
    }

    @NotNull
    public final String getArtistName() [...] // 潜在的解密器

    @NotNull
    public final String getArtistThumbImgPath() {
        return this.artistThumbImgPath;
    }

    @Override
    public int hashCode() {
        return this.artistThumbImgPath.hashCode() + x.b(x.b(this.artistId.hashCode() * 0x1F, 0x1F, this.artistName), 0x1F, this.artistImgPath);
    }

    @Override
    @NotNull
    public String toString() {
        return d.n(d.o("Artist(artistId=", this.artistId, ", artistName=", this.artistName, ", artistImgPath="), this.artistImgPath, ", artistThumbImgPath=", this.artistThumbImgPath, ")");
    }
}

