package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001A\u001A\u00020\u0005H\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0016J\u0013\u0010\u001D\u001A\u00020\u00162\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0096\u0002R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\t\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\u000F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u000B\"\u0004\b\u0011\u0010\rR \u0010\u0012\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u000B\"\u0004\b\u0014\u0010\rR\u0012\u0010\u0015\u001A\u00020\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u00020\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/melon/net/res/common/AlbumInfoBase;", "Lcom/melon/net/res/common/ArtistInfoBase;", "<init>", "()V", "albumId", "", "albumName", "albumImg", "albumImgLarge", "albumImgSmall", "getAlbumImgSmall", "()Ljava/lang/String;", "setAlbumImgSmall", "(Ljava/lang/String;)V", "issueDate", "likeCnt", "getLikeCnt", "setLikeCnt", "songCnt", "getSongCnt", "setSongCnt", "canService", "", "totAvrgScore", "", "ptcPnmPrco", "toString", "hashCode", "", "equals", "other", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class AlbumInfoBase extends ArtistInfoBase {
    public static final int $stable = 8;
    @b(alternate = {"albumId"}, value = "ALBUMID")
    @Nullable
    public String albumId;
    @b(alternate = {"albumImg"}, value = "ALBUMIMG")
    @Nullable
    public String albumImg;
    @b(alternate = {"albumImgLarge"}, value = "ALBUMIMGLARGE")
    @Nullable
    public String albumImgLarge;
    @b(alternate = {"albumImgSmall"}, value = "ALBUMIMGSMALL")
    @Nullable
    private String albumImgSmall;
    @b(alternate = {"albumName"}, value = "ALBUMNAME")
    @Nullable
    public String albumName;
    @b(alternate = {"isService"}, value = "ISSERVICE")
    public boolean canService;
    @b(alternate = {"issueDate"}, value = "ISSUEDATE")
    @Nullable
    public String issueDate;
    @b(alternate = {"likeCnt"}, value = "LIKECNT")
    @Nullable
    private String likeCnt;
    @b(alternate = {"ptcPnmPrco"}, value = "PTCPNMPRCO")
    @Nullable
    public String ptcPnmPrco;
    @b(alternate = {"songCnt"}, value = "SONGCNT")
    @Nullable
    private String songCnt;
    @b(alternate = {"totAvrgScore"}, value = "TOTAVRGSCORE")
    public float totAvrgScore;

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        return this.getClass().equals(object0.getClass()) ? q.b(this.albumId, ((AlbumInfoBase)object0).albumId) : false;
    }

    @Nullable
    public final String getAlbumImgSmall() {
        return this.albumImgSmall;
    }

    @Nullable
    public final String getLikeCnt() {
        return this.likeCnt;
    }

    @Nullable
    public final String getSongCnt() {
        return this.songCnt;
    }

    @Override
    public int hashCode() {
        return this.albumId == null ? 0x1F : this.albumId.hashCode() + 0x1F;
    }

    public final void setAlbumImgSmall(@Nullable String s) {
        this.albumImgSmall = s;
    }

    public final void setLikeCnt(@Nullable String s) {
        this.likeCnt = s;
    }

    public final void setSongCnt(@Nullable String s) {
        this.songCnt = s;
    }

    @Override  // com.melon.net.res.common.ArtistInfoBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

