package com.iloen.melon.net.v6x.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TopicInfoBase implements Serializable {
    public static class CMTLIST implements Serializable {
        @b("ARTISTTEMPERATURE")
        public String artistTemperature;
        @b("BESTFLAG")
        public boolean bestFlat;
        @b("CMTCONT")
        public String cmtCont;
        @b("CMTSEQ")
        public String cmtSeq;
        @b("DSPLYUPDTDATE")
        public String diplyUpdtDate;
        @b("DSPLYREGDATE")
        public String dsplyRegDate;
        @b("IMAGEATACHFLAG")
        public boolean imageAtachFlag;
        @b("ISESSENTIAL")
        public boolean isEssentail;
        @b("LINKATACHFLAG")
        public boolean linkAtachFlag;
        @b("MELONDJFLAG")
        public boolean melonDjFlag;
        @b("MELONLABELDJFLAG")
        public boolean melonLabelDjFlag;
        @b("MELONPOWERDJFLAG")
        public boolean melonPowerDjFlag;
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MUSICATACHFLAG")
        public boolean musicAtachFlag;
        @b("RECMFLAG")
        public boolean recmFlag;
        private static final long serialVersionUID = 0x300DE297BD7CA064L;
        @b("TEMPACTFLAG")
        public boolean tempActFlag;
        @b("TEXTATACHFLAG")
        public boolean textatchFlag;
        @b("VDOATACHFLAG")
        public boolean vdoAtachFlag;

        public CMTLIST() {
            this.cmtSeq = "";
            this.cmtCont = "";
            this.dsplyRegDate = "";
            this.diplyUpdtDate = "";
            this.memberKey = "";
            this.memberNickname = "";
            this.artistTemperature = "";
        }
    }

    @b("ALBUMID")
    public String albumId;
    @b("ARTISTLIST")
    public List artistList;
    public List cmtList;
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("GRADATIONURL")
    public String gradationUrl;
    @b("GRADATIONYN")
    public String gradationYn;
    @b("IMAGECNT")
    public String imageCnt;
    @b("IMAGEURL")
    public String imageUrl;
    @b("ISADULT")
    public boolean isAdult;
    @b("ISCMTAVAIL")
    public boolean isCmtAvail;
    public boolean isLike;
    public String likeCnt;
    private static final long serialVersionUID = 0xA57327EB3A673F75L;
    @b("SONGID")
    public String songId;
    @b("SONGNAME")
    public String songName;
    @b("TITLE")
    public String title;
    @b("TOPICCHNLSEQ")
    public String topicChnlSeq;
    @b("TOPICSEQ")
    public String topicSeq;
    public String totalCmtCnt;

    public TopicInfoBase() {
        this.topicSeq = "";
        this.title = "";
        this.contsTypeCode = "";
        this.imageUrl = "";
        this.imageCnt = "";
        this.gradationUrl = "";
        this.gradationYn = "N";
        this.topicChnlSeq = "";
        this.songName = "";
        this.songId = "";
        this.albumId = "";
        this.likeCnt = "";
        this.totalCmtCnt = "";
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

