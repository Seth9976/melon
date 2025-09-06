package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.PhotoInfoBase;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class DetailBaseRes extends ResponseV6Res {
    public static class ALBUM extends AlbumInfoBase {
        private static final long serialVersionUID = 0x73F83F391266AFFEL;

    }

    public static class ALBUMARTISTNOTE extends AlbumInfoBase {
        @b("ARTISTNOTE")
        public String artistNote;
        private static final long serialVersionUID = 0x6F97F1B9B882A0FL;

        public ALBUMARTISTNOTE() {
            this.artistNote = "";
        }
    }

    public static class ARTISTNOTE extends AlbumInfoBase {
        @b("ARTISTNOTE")
        public String artistNote;
        private static final long serialVersionUID = 0xFA69BD5023B66BF1L;

    }

    public static class BANNERLIST extends BannerBase {
        @b("PLAYTIME")
        public String playTime;
        private static final long serialVersionUID = 0x2CDCE40CB6508B5DL;

        public BANNERLIST() {
            this.playTime = "";
        }
    }

    public static class DetailResponseBase extends ResponseBase {
        private static final long serialVersionUID = 0xEFE8B00670B2709L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class MAGAZINE implements Serializable {
        @b("ARTISTLIST")
        public List artistList;
        @b("CATENAME")
        public String cateName;
        @b("CONTSID")
        public String contsId;
        @b("CONTSIMG")
        public String contsImg;
        @b("CONTSNAME")
        public String contsName;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        @b("LINK")
        public LinkInfoBase link;
        private static final long serialVersionUID = 0x97AEFA183A1AA604L;

        public MAGAZINE() {
            this.contsTypeCode = "";
            this.contsId = "";
            this.contsName = "";
            this.contsImg = "";
            this.cateName = "";
            this.artistList = null;
            this.link = null;
        }
    }

    public static class OFFICIALDJSERIESINFO implements Serializable {
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 0xD9381E3921FAEA90L;
        @b("SVCUPDTDATE")
        public String svcUpdtDate;

        public OFFICIALDJSERIESINFO() {
            this.plylstSeq = "";
            this.memberKey = "";
            this.memberNickname = "";
            this.myPageImg = "";
            this.svcUpdtDate = "";
        }
    }

    public static class OPTION extends LinkInfoBase {
        @b("ACTION")
        public String action;
        private static final long serialVersionUID = 0x43B247B4691D10A2L;

        public OPTION() {
            this.action = "";
        }
    }

    public static class PAGE implements Serializable {
        public boolean isEnd;
        private static final long serialVersionUID = 0xED8D86831DC36133L;

        public PAGE() {
            this.isEnd = false;
        }
    }

    public static class PHOTO extends PhotoInfoBase {
        @b("PHOTOIMGSIZEFLG")
        public String photoImgSizeFlg;
        private static final long serialVersionUID = 0xDAE543C6FB465996L;

        public PHOTO() {
            this.photoImgSizeFlg = "";
        }
    }

    public static class PLAYLIST extends DjPlayListInfoBase {
        @b("ISFAME")
        public boolean isFame;
        @b("ISFRIEND")
        public boolean isFriend;
        @b("ISLIKE")
        public boolean isLike;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("ISWEBP")
        public Boolean isWebp;
        @b("ISWITHDRAW")
        public boolean isWithdraw;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("OFFICIALDJSERIESINFO")
        public OFFICIALDJSERIESINFO officialDjSeriesInfo;
        @b("PLAYTIME")
        public String playTime;
        @b("PLYLSTFAMESTR")
        public String plyLstFameStr;
        @b("PLYLSTDESC")
        public String plylstDesc;
        private static final long serialVersionUID = 0x20CA607FA86B80F5L;
        @b("THUMBIMGURL")
        public String thumbImgUrl;
        @b("UPDTDATESTR")
        public String updtDateStr;
        @b("WEBPIMGURL")
        public String webpImgUrl;

        public PLAYLIST() {
            this.thumbImgUrl = "";
            this.plylstDesc = "";
            this.memberDjIconType = "";
            this.isWebp = Boolean.FALSE;
            this.webpImgUrl = "";
        }
    }

    public static class RELATIONCONTENT implements Serializable {
        @b("CONTSID")
        public String contsId;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        @b("DESCRIPTION")
        public String description;
        @b("IMAGEPATH")
        public String imagePath;
        @b("OPTION")
        public OPTION option;
        @b("PLAYTIME")
        public String playTime;
        @b("PLYLSTSEQ")
        public String plylstSeq;
        private static final long serialVersionUID = 0x265693284024F6D8L;
        @b("TITLE")
        public String title;

        public RELATIONCONTENT() {
            this.plylstSeq = "";
            this.contsTypeCode = "";
            this.contsId = "";
            this.title = "";
            this.description = "";
            this.imagePath = "";
            this.playTime = "";
        }
    }

    public static class SONG extends SongInfoBase {
        private static final long serialVersionUID = 0x68F3FB56AD926CD2L;

    }

    public static class STATION implements Serializable {
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b(alternate = {"CASTIMGURL"}, value = "CASTIMG")
        public String castImg;
        @b("CASTSEQ")
        public String castSeq;
        @b("CASTTITLE")
        public String castTitle;
        @b("CREATORNAME")
        public String creatorName;
        @b("ISSTATION")
        public boolean isStation;
        @b("PROGTITLE")
        public String progTitle;
        private static final long serialVersionUID = 0xB73F1219074A7C29L;
        @b("STATSELEMENTS")
        public StatsElementsBase statsElements;
        @b("VERTICALIMGURL")
        public String verticalImgUrl;

        public STATION() {
            this.artistList = null;
        }
    }

    public static class TAG extends TagInfoBase {
        private static final long serialVersionUID = 0x9AE0F2A4B6D1E21CL;

    }

    public static class TICKET extends BannerBase {
        @b("APPSCHEMAURL")
        public String appSchemaUrl;
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("ENDDATE")
        public String endDt;
        @b("LANDINGURL")
        public String landingUrl;
        @b("PLACENAME")
        public String placeName;
        @b("POSTERIMG")
        public String posterImg;
        @b("PRODID")
        public String prodId;
        private static final long serialVersionUID = 0x9B4FB1EF99C7B401L;
        @b("STARTDATE")
        public String startDt;

        public TICKET() {
            this.prodId = "";
            this.posterImg = "";
            this.startDt = "";
            this.endDt = "";
            this.placeName = "";
            this.artistList = null;
            this.landingUrl = "";
            this.appSchemaUrl = "";
        }
    }

    public static class VIDEO extends MvInfoBase {
        private static final long serialVersionUID = 0xACFA1D56BC383C11L;

    }

    @b("LOGGING")
    public String logging;
    private static final long serialVersionUID = 0x45DC16107EF7FE95L;

    public abstract DetailResponseBase getResponseBase();
}

