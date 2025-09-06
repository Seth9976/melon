package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class AlbumInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMINFO extends AlbumInfoBase {
            @b("CTYPE")
            public String cType;
            @b("CONTSTYPECODE")
            public String contsTypeCode;

            public ALBUMINFO() {
                this.contsTypeCode = "";
                this.cType = "";
            }
        }

        public static class ARTISTNOTEINFO extends AlbumInfoBase {
            @b("ARTISTNOTE")
            public String artistNote;

            public ARTISTNOTEINFO() {
                this.artistNote = "";
            }
        }

        public static class BOOKLETIMGLIST implements Serializable {
            @b("BOOKLETIMGNO")
            public String bookletImgNo;
            @b("BOOKLETIMGURL")
            public String bookletImgUrl;
            @b("BOOKLETTHUMBIMGURL")
            public String bookletThumbImgUrl;

            public BOOKLETIMGLIST() {
                this.bookletImgNo = "";
                this.bookletImgUrl = "";
                this.bookletThumbImgUrl = "";
            }
        }

        public static class CREDITLIST implements Serializable {
            @b("ARTISTNAME")
            public String artistName;
            @b("ROLENAME")
            public String roleName;

        }

        public static class MILLIONSINFO implements Serializable {
            @b("ACCUMDATA")
            public String accumData;
            @b("ISCOUNTING")
            public String isCounting;
            @b("LINK")
            public LinkInfoBase link;
            @b("REACHINGINFO")
            public String reachingInfo;

            public MILLIONSINFO() {
                this.isCounting = "N";
                this.reachingInfo = "";
                this.accumData = "";
                this.link = null;
            }
        }

        public static class OPENHIRISINGINFO extends SPOTLIGHTINFO {
            @b("BUTTONBGCOLOR")
            public String buttonBgColor;
            @b("BUTTONFONTCOLOR")
            public String buttonFontColor;
            @b("HIRISINGSEQ")
            public String hiRisingSeq;

            public OPENHIRISINGINFO() {
                this.hiRisingSeq = "";
                this.buttonBgColor = "";
                this.buttonFontColor = "";
            }
        }

        public static class OPENSPOTLIGHTINFO extends SPOTLIGHTINFO {
            @b("BUTTONBGCOLOR")
            public String buttonBgColor;
            @b("BUTTONFONTCOLOR")
            public String buttonFontColor;
            @b("SPOTLIGHTSEQ")
            public String spotlightSeq;

            public OPENSPOTLIGHTINFO() {
                this.spotlightSeq = "";
                this.buttonBgColor = "";
                this.buttonFontColor = "";
            }
        }

        public static class PREVHIRISINGINFO extends SPOTLIGHTINFO {
            @b("HIRISINGSEQ")
            public String hiRisingSeq;
            @b("IMAGEBGCOLOR")
            public String imageBgColor;
            @b("IMAGEURL")
            public String imageUrl;
            @b("LOGOIMAGEURL")
            public String logoImageUrl;
            @b("REGDATE")
            public String regDate;
            @b("TITLE")
            public String title;

            public PREVHIRISINGINFO() {
                this.hiRisingSeq = "";
                this.title = "";
                this.imageUrl = "";
                this.logoImageUrl = "";
                this.imageBgColor = "";
                this.regDate = "";
            }
        }

        public static class PREVSPOTLIGHTINFO extends SPOTLIGHTINFO {
            @b("IMAGEBGCOLOR")
            public String imageBgColor;
            @b("IMAGEURL")
            public String imageUrl;
            @b("LOGOIMAGEURL")
            public String logoImageUrl;
            @b("REGDATE")
            public String regDate;
            @b("SPOTLIGHTSEQ")
            public String spotlightSeq;
            @b("TITLE")
            public String title;

            public PREVSPOTLIGHTINFO() {
                this.spotlightSeq = "";
                this.title = "";
                this.imageUrl = "";
                this.logoImageUrl = "";
                this.imageBgColor = "";
                this.regDate = "";
            }
        }

        public static class SPOTLIGHTINFO implements Serializable {
            @b("LINK")
            public LinkInfoBase link;

            public SPOTLIGHTINFO() {
                this.link = null;
            }
        }

        public static class TOTAVRGSCOREINFO implements Serializable {
            @b("PTCPNMPRCO")
            public String ptCpnMprco;
            @b("TEXT")
            public String text;
            @b("TITLE")
            public String title;
            @b("TOTAVRGSCORE")
            public String totAvrgScore;

            public TOTAVRGSCOREINFO() {
                this.ptCpnMprco = "";
                this.text = "";
                this.title = "";
                this.totAvrgScore = "";
            }
        }

        @b("ALBUMFLACINFO")
        public String albumFlacInfo;
        @b("ALBUMINFO")
        public ALBUMINFO albumInfo;
        @b("ALBUMMESSAGE")
        public String albumMessage;
        @b("ALBUMPRICE")
        public String albumPrice;
        @b("ALBUMPRICEFLAC16")
        public String albumPriceFlac16;
        @b("ALBUMPRICEFLAC24")
        public String albumPriceFlac24;
        @b("ALBUMTYPE")
        public String albumType;
        @b("ARTISTNOTEALLBUTTONFLAG")
        public boolean artistNoteAllButtonFlag;
        @b("ARTISTNOTEINFO")
        public ARTISTNOTEINFO artistNoteInfo;
        @b("BBSCONTSREFVALUE")
        public String bbsContsRefValue;
        @b("BBSCHANNELSEQ")
        public String bbschannelseq;
        @b("BOOKLETIMGLIST")
        public ArrayList bookletImgList;
        @b("CPLANCODE")
        public String cPlanCode;
        @b("CREDITLIST")
        public ArrayList creditList;
        @b("DUMMYTEXT")
        public String dummyText;
        @b("GENRELIST")
        public ArrayList genreList;
        @b("HIRISINGBUTTONFLAG")
        public String hiRisingButtonFlag;
        @b("ISDOLBYATMOS")
        public boolean isDolbyAtmos;
        @b("ISMASTERPIECE")
        public boolean isMasterPiece;
        @b("ISSUEDATE")
        public String issueDate;
        @b("LIKECNT")
        public String likeCnt;
        @b("MILLIONSINFO")
        public MILLIONSINFO millionsinfo;
        @b("OPENHIRISINGINFO")
        public OPENHIRISINGINFO openHiRisingInfo;
        @b("OPENSPOTLIGHTINFO")
        public OPENSPOTLIGHTINFO openSpotLightInfo;
        @b("PLANCNPY")
        public String planCnpy;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("PREVHIRISINGINFOLIST")
        public ArrayList prevHiRisingInfoList;
        @b("PREVSPOTLIGHTINFOLIST")
        public ArrayList prevSpotLightInfoList;
        @b("REPORT")
        public String report;
        @b("REPORTPREVIEW")
        public String reportPreview;
        @b("SELLCNPY")
        public String sellCnpy;
        @b("SPOTLIGHTBUTTONFLAG")
        public String spotLightButtonFlag;
        @b("TITLESONGINFO")
        public SongInfoBase titleSong;
        @b("TOTAVRGSCOREINFO")
        public TOTAVRGSCOREINFO totAvrgScoreInfo;

        public RESPONSE() {
            this.albumFlacInfo = "";
            this.albumType = "";
            this.artistNoteInfo = null;
            this.artistNoteAllButtonFlag = false;
            this.bbschannelseq = "";
            this.bbsContsRefValue = "";
            this.cPlanCode = "";
            this.dummyText = "";
            this.genreList = null;
            this.isMasterPiece = false;
            this.issueDate = "";
            this.likeCnt = "";
            this.planCnpy = "";
            this.postEditImg = "";
            this.postImg = "";
            this.report = "";
            this.reportPreview = "";
            this.sellCnpy = "";
            this.albumPrice = "";
            this.albumPriceFlac16 = "";
            this.albumPriceFlac24 = "";
            this.albumMessage = "";
            this.bookletImgList = null;
            this.creditList = null;
            this.isDolbyAtmos = false;
            this.spotLightButtonFlag = "N";
            this.prevSpotLightInfoList = null;
            this.openSpotLightInfo = null;
            this.hiRisingButtonFlag = "N";
            this.prevHiRisingInfoList = null;
            this.openHiRisingInfo = null;
            this.millionsinfo = null;
        }
    }

    @b("response")
    public RESPONSE response;

    public AlbumInfoRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

