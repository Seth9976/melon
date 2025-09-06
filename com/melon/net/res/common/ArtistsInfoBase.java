package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001A\u00020\u0005H\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u00148\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/melon/net/res/common/ArtistsInfoBase;", "Lcom/melon/net/res/common/MetaInfoBase;", "<init>", "()V", "artistId", "", "getArtistId", "()Ljava/lang/String;", "setArtistId", "(Ljava/lang/String;)V", "artistName", "getArtistName", "setArtistName", "artistImg", "getArtistImg", "setArtistImg", "fanYn", "getFanYn", "setFanYn", "isBrand", "", "()Z", "setBrand", "(Z)V", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistsInfoBase extends MetaInfoBase {
    public static final int $stable = 8;
    @b(alternate = {"artistId"}, value = "ARTISTID")
    @Nullable
    private String artistId;
    @b(alternate = {"artistImg"}, value = "ARTISTIMG")
    @Nullable
    private String artistImg;
    @b(alternate = {"artistName"}, value = "ARTISTNAME")
    @Nullable
    private String artistName;
    @b(alternate = {"fanYn"}, value = "FANYN")
    @NotNull
    private String fanYn;
    @b("ISBRAND")
    private boolean isBrand;

    public ArtistsInfoBase() {
        this.fanYn = "N";
    }

    @Nullable
    public final String getArtistId() {
        return this.artistId;
    }

    @Nullable
    public final String getArtistImg() {
        return this.artistImg;
    }

    @Nullable
    public final String getArtistName() {
        return this.artistName;
    }

    @NotNull
    public final String getFanYn() [...] // 潜在的解密器

    public final boolean isBrand() {
        return this.isBrand;
    }

    public final void setArtistId(@Nullable String s) {
        this.artistId = s;
    }

    public final void setArtistImg(@Nullable String s) {
        this.artistImg = s;
    }

    public final void setArtistName(@Nullable String s) {
        this.artistName = s;
    }

    public final void setBrand(boolean z) {
        this.isBrand = z;
    }

    public final void setFanYn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.fanYn = s;
    }

    @Override  // com.melon.net.res.common.MetaInfoBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

