package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.types.StringIds;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001A\u00020\u0005H\u0016J\u0006\u0010\u001A\u001A\u00020\u001BJ\u0006\u0010\u001C\u001A\u00020\u0005R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\u000F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR \u0010\u0012\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR&\u0010\u0015\u001A\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00178\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2 = {"Lcom/melon/net/res/common/ArtistInfoBase;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "<init>", "()V", "nationality", "", "getNationality", "()Ljava/lang/String;", "setNationality", "(Ljava/lang/String;)V", "gender", "getGender", "setGender", "actType", "actGenre", "fanCnt", "getFanCnt", "setFanCnt", "artistNews", "getArtistNews", "setArtistNews", "artistList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newIconYn", "toString", "getArtistIds", "Lcom/iloen/melon/types/StringIds;", "getArtistNames", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistInfoBase extends ArtistsInfoBase {
    public static final int $stable = 8;
    @b(alternate = {"actGenre"}, value = "ACTGENRE")
    @Nullable
    public String actGenre;
    @b(alternate = {"actType"}, value = "ACTTYPE")
    @Nullable
    public String actType;
    @b(alternate = {"artistList"}, value = "ARTISTLIST")
    @Nullable
    public ArrayList artistList;
    @b(alternate = {"artistNews"}, value = "ARTISTNEWS")
    @Nullable
    private String artistNews;
    @b(alternate = {"fanCnt"}, value = "FANCNT")
    @Nullable
    private String fanCnt;
    @b(alternate = {"gender"}, value = "GENDER")
    @Nullable
    private String gender;
    @b(alternate = {"nationality"}, value = "NATIONALITY")
    @Nullable
    private String nationality;
    @b(alternate = {"newIconYn"}, value = "NEWICONYN")
    @NotNull
    public String newIconYn;

    public ArtistInfoBase() {
        this.newIconYn = "N";
    }

    @NotNull
    public final StringIds getArtistIds() {
        StringIds stringIds0 = ProtocolUtils.getArtistIds(this.artistList);
        q.f(stringIds0, "getArtistIds(...)");
        return stringIds0;
    }

    @NotNull
    public final String getArtistNames() {
        String s = ProtocolUtils.getArtistNames(this.artistList);
        return s == null ? "" : s;
    }

    @Nullable
    public final String getArtistNews() {
        return this.artistNews;
    }

    @Nullable
    public final String getFanCnt() {
        return this.fanCnt;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final String getNationality() {
        return this.nationality;
    }

    public final void setArtistNews(@Nullable String s) {
        this.artistNews = s;
    }

    public final void setFanCnt(@Nullable String s) {
        this.fanCnt = s;
    }

    public final void setGender(@Nullable String s) {
        this.gender = s;
    }

    public final void setNationality(@Nullable String s) {
        this.nationality = s;
    }

    @Override  // com.melon.net.res.common.ArtistsInfoBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

