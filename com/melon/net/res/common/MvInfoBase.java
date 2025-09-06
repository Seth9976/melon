package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0013\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\u0005H\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\u0014\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000F\"\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001F\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b \u0010\u000F¨\u0006\""}, d2 = {"Lcom/melon/net/res/common/MvInfoBase;", "Lcom/melon/net/res/common/SongInfoBase;", "<init>", "()V", "mvId", "", "mvName", "mvImg", "mv169Img", "viewCnt", "hasSong", "", "adultGrade", "commentCnt", "getCommentCnt", "()Ljava/lang/String;", "setCommentCnt", "(Ljava/lang/String;)V", "progName", "epsdName", "mvDesc", "getMvDesc", "setMvDesc", "repArtist", "Lcom/melon/net/res/common/MvInfoBase$REPARTIST;", "hashCode", "", "equals", "other", "", "toString", "mvTitle", "getMvTitle", "REPARTIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MvInfoBase extends SongInfoBase {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/common/MvInfoBase$REPARTIST;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "<init>", "()V", "isBrandDjs", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class REPARTIST extends ArtistsInfoBase {
        public static final int $stable = 8;
        @b("ISBRANDJS")
        public boolean isBrandDjs;

    }

    public static final int $stable = 8;
    @b("ADULTGRADE")
    @Nullable
    public String adultGrade;
    @b("COMMENTCNT")
    @Nullable
    private String commentCnt;
    @b("EPSDNAME")
    @Nullable
    public String epsdName;
    @b("ISSONG")
    public boolean hasSong;
    @b("MV169IMG")
    @Nullable
    public String mv169Img;
    @b("MVDESC")
    @Nullable
    private String mvDesc;
    @b("MVID")
    @Nullable
    public String mvId;
    @b("MVIMG")
    @Nullable
    public String mvImg;
    @b("MVNAME")
    @Nullable
    public String mvName;
    @b("PROGNAME")
    @Nullable
    public String progName;
    @b("REPARTIST")
    @Nullable
    public REPARTIST repArtist;
    @b("VIEWCNT")
    @Nullable
    public String viewCnt;

    @Override  // com.melon.net.res.common.AlbumInfoBase
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!super.equals(object0)) {
            return false;
        }
        if(!this.getClass().equals((object0 == null ? null : object0.getClass()))) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type com.melon.net.res.common.MvInfoBase");
        return q.b(this.mvId, ((MvInfoBase)object0).mvId);
    }

    @Nullable
    public final String getCommentCnt() {
        return this.commentCnt;
    }

    @Nullable
    public final String getMvDesc() {
        return this.mvDesc;
    }

    @NotNull
    public final String getMvTitle() [...] // 潜在的解密器

    @Override  // com.melon.net.res.common.AlbumInfoBase
    public int hashCode() {
        int v = super.hashCode();
        return this.mvId == null ? v * 0x1F : v * 0x1F + this.mvId.hashCode();
    }

    public final void setCommentCnt(@Nullable String s) {
        this.commentCnt = s;
    }

    public final void setMvDesc(@Nullable String s) {
        this.mvDesc = s;
    }

    @Override  // com.melon.net.res.common.SongInfoBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

