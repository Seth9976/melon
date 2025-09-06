package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicInformStorageRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class CNTINFO implements Serializable {
            @b("FANCNT")
            public String fanCnt;
            @b("LIKECNT")
            public String likeCnt;
            @b("LYRICHIGHLIGHTCNT")
            public String lyricHighlightCnt;
            @b("MYCHARTWCNT")
            public String myChartwCnt;
            @b("MYPLYLSTCNT")
            public String myPlyLstCnt;
            private static final long serialVersionUID = -3332690235931802050L;

            public CNTINFO() {
                this.likeCnt = "";
                this.myPlyLstCnt = "";
                this.myChartwCnt = "";
                this.fanCnt = "";
                this.lyricHighlightCnt = "";
            }
        }

        public static class MYPROFILE implements Serializable {
            @b("BNRSGMT")
            public String bnrsgmt;
            @b("COVERIMG")
            public String coverImg;
            @b("FEEDNEWYN")
            public String feedNewYN;
            @b("HASFLACSTPROD")
            public boolean hasFlacStProd;
            @b("HIFIPROD")
            public String hifiProd;
            @b("MEMBERDJTYPE")
            public String memberDJType;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("MYPAGEIMGORG")
            public String myPageImgOrg;
            @b("POSTEDITIMG")
            public String postEditImg;
            @b("POSTIMG")
            public String postImg;
            @b("PRODUCTINFO")
            public String productInfo;
            private static final long serialVersionUID = 0x7A77676652AE3C45L;

            public MYPROFILE() {
                this.bnrsgmt = "";
                this.hasFlacStProd = false;
                this.hifiProd = "";
                this.productInfo = "";
                this.memberKey = "";
                this.myPageImg = "";
                this.myPageImgOrg = "";
                this.postImg = "";
                this.postEditImg = "";
                this.coverImg = "";
                this.feedNewYN = "N";
                this.memberDJType = "";
            }
        }

        public static class RECNTPLYLSTINFO implements Serializable {
            public static class RECNTPLYLSTLIST extends ArtistPlayListInfoBase {
                @b("CONTSID")
                public String contsId;
                @b("ISMELONLOGO")
                public boolean isMelonLogo;
                @b("MAINIMGURLS")
                public ArrayList mainImgUrls;
                @b("MAINREPLACE")
                public String mainReplace;
                @b("MAINSUBIMGURL")
                public String mainSubImgUrl;
                @b("MAINTEXT")
                public String mainText;
                @b("MAINTITLE")
                public String mainTitle;
                @b("RANK")
                public String rank;
                @b("SEEDCONTSID")
                public String seedContsId;
                @b("SEEDCONTSTYPECODE")
                public String seedContsTypeCode;
                private static final long serialVersionUID = -1916498565252607330L;
                @b("WRITER")
                public String writer;

                public RECNTPLYLSTLIST() {
                    this.contsId = "";
                    this.seedContsTypeCode = "";
                    this.seedContsId = "";
                    this.mainTitle = "";
                    this.mainReplace = "";
                    this.mainText = "";
                    this.mainImgUrls = null;
                    this.mainSubImgUrl = "";
                    this.rank = "";
                    this.writer = "";
                    this.isMelonLogo = false;
                }
            }

            @b("RECNTPLYLSTLIST")
            public ArrayList recntPlylstList;
            private static final long serialVersionUID = -2992002162600811181L;

            public RECNTPLYLSTINFO() {
                this.recntPlylstList = null;
            }
        }

        public static class RECNTSONGINFO implements Serializable {
            @b("RECNTSONGCOUNT")
            public String recntSongCount;
            @b("RECNTSONGIMGPATH")
            public ArrayList recntSongImgPathList;
            @b("RECNTSONGNAME")
            public String recntSongName;
            private static final long serialVersionUID = 0xB4C2FCF1C73A559CL;

            public RECNTSONGINFO() {
                this.recntSongName = "";
                this.recntSongCount = "";
                this.recntSongImgPathList = null;
            }
        }

        public static class SUMMARYCARDINFO extends LinkInfoBase {
            public static String CARD_TYPE_DNA = "dna";
            public static String CARD_TYPE_GETTITLE = "gettitle";
            public static String CARD_TYPE_LOG = "log";
            public static String CARD_TYPE_MANIA = "mania";
            public static String CARD_TYPE_MMA = "mma";
            public static String TYPE_CIRCLE = "circle";
            public static String TYPE_SQUARE = "square";
            @b("ARTISTNAME")
            public String artistName;
            @b("BGCOLOR")
            public String bgColor;
            @b("BGIMG")
            public String bgImg;
            @b("CARDTYPE")
            public String cardType;
            @b("CONTENTIMG")
            public String contentImg;
            @b("CONTSDETAILIMG")
            public String contsDetailImg;
            @b("CONTSTYPE")
            public String contsType;
            @b("FONTCOLOR")
            public String fontColor;
            @b("ISBLACK")
            public boolean isBlack;
            @b("TEXT1")
            public String text1;
            @b("TEXT2")
            public String text2;
            @b("TEXT3")
            public String text3;

            public SUMMARYCARDINFO() {
                this.bgImg = "";
                this.bgColor = "";
                this.contentImg = "";
                this.text1 = "";
                this.text2 = "";
                this.text3 = "";
                this.artistName = "";
                this.fontColor = "";
                this.isBlack = false;
                this.contsType = "";
                this.contsDetailImg = "";
                this.cardType = "";
            }
        }

        @b("CPLANCODE")
        public String cPlanCode;
        @b("CNTINFO")
        public CNTINFO cntInfo;
        @b("MYPROFILE")
        public MYPROFILE myProfile;
        @b("RECNTPLYLSTINFO")
        public RECNTPLYLSTINFO recntPlylstInfo;
        @b("RECNTSONGINFO")
        public RECNTSONGINFO recntSongInfo;
        private static final long serialVersionUID = 26030535236928710L;
        @b("SUMMARYCARDINFO")
        public SUMMARYCARDINFO summaryCardInfo;

        public RESPONSE() {
            this.recntSongInfo = null;
            this.recntPlylstInfo = null;
            this.summaryCardInfo = null;
            this.cPlanCode = "";
            this.cntInfo = null;
            this.myProfile = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x91A35AE9C4E6167DL;

    public MyMusicInformStorageRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

