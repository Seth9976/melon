package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.sns.model.ShareLinkData;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class ArtistContentsArtistTopicInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTINFO implements Serializable {
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            private static final long serialVersionUID = 0xC012D23C84EE0863L;

            public ARTISTINFO() {
                this.artistId = "";
                this.artistName = "";
                this.artistImg = "";
            }
        }

        public static class TOPICCONTENTSLIST implements Serializable {
            @b("ADULTGRADE")
            public String adultGrade;
            @b("ALBUMID")
            public String albumID;
            @b("ARTISTLIST")
            public List artistList;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("IMAGEURL")
            public String imageUrl;
            @b("ISADULT")
            public boolean isAdult;
            public boolean isLinkTagFetched;
            public String linkDesc;
            public String linkHost;
            public String linkImage;
            public String linkTitle;
            @b("LINKURL")
            public String linkUrl;
            @b("MVID")
            public String mvID;
            @b("MVNAME")
            public String mvName;
            @b("PLAYTIME")
            public String playTime;
            private static final long serialVersionUID = 0xB213EB7C9C803D49L;
            @b("SONGID")
            public String songID;
            @b("SONGNAME")
            public String songName;
            @b("TEXT")
            public String text;

            public TOPICCONTENTSLIST() {
                this.contsTypeCode = "";
                this.imageUrl = "";
                this.text = "";
                this.mvName = "";
                this.mvID = "";
                this.adultGrade = "";
                this.playTime = "";
                this.songID = "";
                this.albumID = "";
                this.songName = "";
                this.linkUrl = "";
                this.linkImage = "";
                this.linkTitle = "";
                this.linkDesc = "";
                this.linkHost = "";
            }
        }

        public static class TOPICINFO implements Serializable {
            @b("CMTDSPLYDATE")
            public String cmtDsPlyDate;
            @b("DSPLYDATE")
            public String dsPlyDate;
            @b("ISCMTAVAIL")
            public boolean isCmtAvail;
            public boolean isLike;
            public String likeCnt;
            private static final long serialVersionUID = 0x19412E6F7457C4A1L;
            @b("TITLE")
            public String title;
            @b("TOPICSEQ")
            public String topicSeq;
            public String totalCmtCnt;

            public TOPICINFO() {
                this.topicSeq = "";
                this.title = "";
                this.dsPlyDate = "";
                this.cmtDsPlyDate = "";
                this.likeCnt = "";
                this.totalCmtCnt = "";
            }
        }

        @b("ARTISTINFO")
        public ARTISTINFO artistInfo;
        private static final long serialVersionUID = 0x2D768AB557FDDC3L;
        @b("SNSINFO")
        public ShareLinkData snsInfo;
        @b("TOPICCHNLSEQ")
        public String topicChnlSeq;
        @b("TOPICCONTENTSLIST")
        public List topicContentsList;
        @b("TOPICINFO")
        public TOPICINFO topicInfo;

        public RESPONSE() {
            this.topicChnlSeq = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -2921970620867310836L;

    public ArtistContentsArtistTopicInfoRes() {
        this.response = null;
    }
}

