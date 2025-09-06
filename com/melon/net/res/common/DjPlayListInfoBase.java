package com.melon.net.res.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0019\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010I\u001A\u00020\u0005H\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R \u0010\u0007\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000BR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000BR\u0012\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001A\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001B\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001C\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010\u001D\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010\u001E\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\t\"\u0004\b&\u0010\u000BR\u0014\u0010\'\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u0010(\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010!\"\u0004\b*\u0010#R\u0014\u0010+\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R&\u0010,\u001A\u0016\u0012\u0004\u0012\u00020.\u0018\u00010-j\n\u0012\u0004\u0012\u00020.\u0018\u0001`/8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001E\u00100\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b0\u0010!\"\u0004\b1\u0010#R \u00102\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b3\u0010\t\"\u0004\b4\u0010\u000BR\u0012\u00105\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R \u00106\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\t\"\u0004\b8\u0010\u000BR\u0014\u00109\u001A\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010;\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u0012\u0010<\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R \u0010=\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010\t\"\u0004\b?\u0010\u000BR\u001E\u0010@\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b@\u0010!\"\u0004\bA\u0010#R\u0012\u0010B\u001A\u00020\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0002\n\u0000R\u001A\u0010C\u001A\u00020DX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010H\u00A8\u0006J"}, d2 = {"Lcom/melon/net/res/common/DjPlayListInfoBase;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "plylstseq", "", "plylsttitle", "plylsttitleorg", "getPlylsttitleorg", "()Ljava/lang/String;", "setPlylsttitleorg", "(Ljava/lang/String;)V", "ownermemberkey", "ownernickname", "withdrawyn", "thumbimg", "adminrecmyn", "getAdminrecmyn", "setAdminrecmyn", "delposblyn", "getDelposblyn", "setDelposblyn", "fameregyn", "likecnt", "songcnt", "dpdate", "upyn", "newyn", "delYn", "adminOpenYn", "isdj", "", "getIsdj", "()Z", "setIsdj", "(Z)V", "ownermypageimg", "getOwnermypageimg", "setOwnermypageimg", "viewcnt", "ispowerdj", "getIspowerdj", "setIspowerdj", "contsTypeCode", "taglist", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "Lkotlin/collections/ArrayList;", "isEssential", "setEssential", "memberDjType", "getMemberDjType", "setMemberDjType", "seriesYn", "seriesPlylstSeq", "getSeriesPlylstSeq", "setSeriesPlylstSeq", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "dimYn", "withOfficialSeries", "withOfficialSeriesTitle", "getWithOfficialSeriesTitle", "setWithOfficialSeriesTitle", "isOpen", "setOpen", "isFullLine", "index", "", "getIndex", "()I", "setIndex", "(I)V", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class DjPlayListInfoBase extends ResponseBase {
    public static final int $stable = 8;
    @b("ADMINOPENYN")
    @NotNull
    public String adminOpenYn;
    @b("ADMINRECMYN")
    @NotNull
    private String adminrecmyn;
    @b(alternate = {"contsTypeCode"}, value = "CONTSTYPECODE")
    @Nullable
    public String contsTypeCode;
    @b("DELYN")
    @NotNull
    public String delYn;
    @b("DELPOSBLYN")
    @NotNull
    private String delposblyn;
    @b("DIMYN")
    @NotNull
    public String dimYn;
    @b("DPDATE")
    @Nullable
    public String dpdate;
    @b("FAMEREGYN")
    @NotNull
    public String fameregyn;
    private int index;
    @b("ISESSENTIAL")
    private boolean isEssential;
    public boolean isFullLine;
    @b("ISOPEN")
    private boolean isOpen;
    @b("ISDJ")
    private boolean isdj;
    @b("ISPOWERDJ")
    private boolean ispowerdj;
    @b(alternate = {"likeCnt"}, value = "LIKECNT")
    @Nullable
    public String likecnt;
    @b("MEMBERDJTYPE")
    @Nullable
    private String memberDjType;
    @b(alternate = {"newYn"}, value = "NEWYN")
    @NotNull
    public String newyn;
    @b(alternate = {"ownerMemberKey"}, value = "OWNERMEMBERKEY")
    @Nullable
    public String ownermemberkey;
    @b("OWNERMYPAGEIMG")
    @Nullable
    private String ownermypageimg;
    @b(alternate = {"ownerNickname"}, value = "OWNERNICKNAME")
    @Nullable
    public String ownernickname;
    @b(alternate = {"plylstSeq"}, value = "PLYLSTSEQ")
    @Nullable
    public String plylstseq;
    @b(alternate = {"plylstTitle"}, value = "PLYLSTTITLE")
    @Nullable
    public String plylsttitle;
    @b(alternate = {"plylstTitleOrg"}, value = "PLYLSTTITLEORG")
    @Nullable
    private String plylsttitleorg;
    @b("SERIESPLYLSTSEQ")
    @Nullable
    private String seriesPlylstSeq;
    @b("SERIESYN")
    @NotNull
    public String seriesYn;
    @b(alternate = {"songCnt"}, value = "SONGCNT")
    @Nullable
    public String songcnt;
    @b("STATSELEMENTS")
    @Nullable
    public StatsElementsBase statsElements;
    @b("TAGLIST")
    @Nullable
    public ArrayList taglist;
    @b(alternate = {"thumbImg"}, value = "THUMBIMG")
    @Nullable
    public String thumbimg;
    @b("UPYN")
    @NotNull
    public String upyn;
    @b("VIEWCNT")
    @Nullable
    public String viewcnt;
    @b("WITHOFFICIALSERIES")
    public boolean withOfficialSeries;
    @b("WITHOFFICIALSERIESTITLE")
    @Nullable
    private String withOfficialSeriesTitle;
    @b("WITHDRAWYN")
    @NotNull
    public String withdrawyn;

    public DjPlayListInfoBase() {
        this.withdrawyn = "N";
        this.adminrecmyn = "N";
        this.delposblyn = "N";
        this.fameregyn = "N";
        this.upyn = "N";
        this.newyn = "N";
        this.delYn = "N";
        this.adminOpenYn = "N";
        this.seriesYn = "N";
        this.dimYn = "N";
    }

    @NotNull
    public final String getAdminrecmyn() {
        return this.adminrecmyn;
    }

    @NotNull
    public final String getDelposblyn() {
        return this.delposblyn;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getIsdj() {
        return this.isdj;
    }

    public final boolean getIspowerdj() {
        return this.ispowerdj;
    }

    @Nullable
    public final String getMemberDjType() {
        return this.memberDjType;
    }

    @Nullable
    public final String getOwnermypageimg() {
        return this.ownermypageimg;
    }

    @Nullable
    public final String getPlylsttitleorg() {
        return this.plylsttitleorg;
    }

    @Nullable
    public final String getSeriesPlylstSeq() {
        return this.seriesPlylstSeq;
    }

    @Nullable
    public final String getWithOfficialSeriesTitle() {
        return this.withOfficialSeriesTitle;
    }

    public final boolean isEssential() {
        return this.isEssential;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setAdminrecmyn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.adminrecmyn = s;
    }

    public final void setDelposblyn(@NotNull String s) {
        q.g(s, "<set-?>");
        this.delposblyn = s;
    }

    public final void setEssential(boolean z) {
        this.isEssential = z;
    }

    public final void setIndex(int v) {
        this.index = v;
    }

    public final void setIsdj(boolean z) {
        this.isdj = z;
    }

    public final void setIspowerdj(boolean z) {
        this.ispowerdj = z;
    }

    public final void setMemberDjType(@Nullable String s) {
        this.memberDjType = s;
    }

    public final void setOpen(boolean z) {
        this.isOpen = z;
    }

    public final void setOwnermypageimg(@Nullable String s) {
        this.ownermypageimg = s;
    }

    public final void setPlylsttitleorg(@Nullable String s) {
        this.plylsttitleorg = s;
    }

    public final void setSeriesPlylstSeq(@Nullable String s) {
        this.seriesPlylstSeq = s;
    }

    public final void setWithOfficialSeriesTitle(@Nullable String s) {
        this.withOfficialSeriesTitle = s;
    }

    @Override  // com.melon.net.res.common.ResponseBase
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

