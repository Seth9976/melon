package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001A\u00020\u0005H\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R \u0010\b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\fR\u0014\u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R&\u0010\u0018\u001A\u0016\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001A\u0018\u0001`\u001B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R \u0010\u001C\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\n\"\u0004\b\u001E\u0010\fR \u0010\u001F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\n\"\u0004\b!\u0010\fR \u0010\"\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u0012\u0010%\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010&\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\'\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010(\u001A\u00020\u00128\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+\u00A8\u0006-"}, d2 = {"Lcom/melon/net/res/common/SongInfoBase;", "Lcom/melon/net/res/common/AlbumInfoBase;", "<init>", "()V", "songId", "", "songName", "playTime", "cdNo", "getCdNo", "()Ljava/lang/String;", "setCdNo", "(Ljava/lang/String;)V", "trackNo", "getTrackNo", "setTrackNo", "cType", "isAdult", "", "isFree", "isHitSong", "isHoldback", "isTitleSong", "hasMv", "genreList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/common/GenreInfoBase;", "Lkotlin/collections/ArrayList;", "composer", "getComposer", "setComposer", "movement", "getMovement", "setMovement", "eduProviderCd", "getEduProviderCd", "setEduProviderCd", "isFlacAvail", "isFlac16Avail", "isFlac24Avail", "isOrigin", "()Z", "setOrigin", "(Z)V", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class SongInfoBase extends AlbumInfoBase {
    public static final int $stable = 8;
    @b(alternate = {"cType"}, value = "CTYPE")
    @Nullable
    public String cType;
    @b(alternate = {"cdNo"}, value = "CDNO")
    @Nullable
    private String cdNo;
    @b(alternate = {"composer"}, value = "COMPOSER")
    @Nullable
    private String composer;
    @b(alternate = {"eduProviderCd"}, value = "EDUPROVIDERCD")
    @Nullable
    private String eduProviderCd;
    @b(alternate = {"genreList"}, value = "GENRELIST")
    @Nullable
    public ArrayList genreList;
    @b("ISMV")
    public boolean hasMv;
    @b(alternate = {"isAdult"}, value = "ISADULT")
    public boolean isAdult;
    @b(alternate = {"isFlac16Avail"}, value = "ISFLAC16AVAIL")
    public boolean isFlac16Avail;
    @b(alternate = {"isFlac24Avail"}, value = "ISFLAC24AVAIL")
    public boolean isFlac24Avail;
    @b(alternate = {"isFlacAvail"}, value = "ISFLACAVAIL")
    public boolean isFlacAvail;
    @b(alternate = {"isFree"}, value = "ISFREE")
    public boolean isFree;
    @b(alternate = {"isHitSong"}, value = "ISHITSONG")
    public boolean isHitSong;
    @b(alternate = {"isHoldback"}, value = "ISHOLDBACK")
    public boolean isHoldback;
    @b(alternate = {"isOrigin"}, value = "ISORIGIN")
    private boolean isOrigin;
    @b(alternate = {"isTitleSong"}, value = "ISTITLESONG")
    public boolean isTitleSong;
    @b(alternate = {"movement"}, value = "MOVEMENT")
    @Nullable
    private String movement;
    @b(alternate = {"playTime"}, value = "PLAYTIME")
    @Nullable
    public String playTime;
    @b(alternate = {"songId"}, value = "SONGID")
    @Nullable
    public String songId;
    @b(alternate = {"songName"}, value = "SONGNAME")
    @Nullable
    public String songName;
    @b(alternate = {"trackNo"}, value = "TRACKNO")
    @Nullable
    private String trackNo;

    @Nullable
    public final String getCdNo() {
        return this.cdNo;
    }

    @Nullable
    public final String getComposer() {
        return this.composer;
    }

    @Nullable
    public final String getEduProviderCd() {
        return this.eduProviderCd;
    }

    @Nullable
    public final String getMovement() {
        return this.movement;
    }

    @Nullable
    public final String getTrackNo() {
        return this.trackNo;
    }

    public final boolean isOrigin() {
        return this.isOrigin;
    }

    public final void setCdNo(@Nullable String s) {
        this.cdNo = s;
    }

    public final void setComposer(@Nullable String s) {
        this.composer = s;
    }

    public final void setEduProviderCd(@Nullable String s) {
        this.eduProviderCd = s;
    }

    public final void setMovement(@Nullable String s) {
        this.movement = s;
    }

    public final void setOrigin(boolean z) {
        this.isOrigin = z;
    }

    public final void setTrackNo(@Nullable String s) {
        this.trackNo = s;
    }

    @Override  // com.melon.net.res.common.AlbumInfoBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

