package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicDnaMainMonthlyLogRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTTOPINFO implements Serializable {
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("BGIMG")
            public String bgImg;
            @b("LISTENCNT")
            public String listenCnt;
            @b("SUBTITLE1")
            public String subTitle1;
            @b("TITLE")
            public String title;

            public ARTISTTOPINFO() {
                this.title = "";
                this.subTitle1 = "";
                this.artistId = "";
                this.listenCnt = "";
                this.bgImg = "";
                this.artistName = "";
                this.artistImg = "";
            }
        }

        public static class CARDINFO implements Serializable {
            public static class CONTENTS implements Serializable {
                public static class TAGLIST extends TagInfoBase {
                    @b("IMGURL")
                    public String imgUrl;
                    @b("ISLIKE")
                    public boolean isLike;

                    public TAGLIST() {
                        this.isLike = false;
                        this.imgUrl = "";
                    }
                }

                public static class TOP100LIST extends SongInfoBase {
                    @b("CURRANK")
                    public String curRank;
                    @b("RANKGAP")
                    public String rankGap;
                    @b("RANKTYPE")
                    public String rankType;

                    public TOP100LIST() {
                        this.curRank = "";
                        this.rankType = "";
                        this.rankGap = "";
                    }
                }

                @b("SONGLIST")
                public ArrayList songList;
                @b("TAGLIST")
                public ArrayList tagList;
                @b("TOP100LIST")
                public ArrayList top100List;

                public CONTENTS() {
                    this.top100List = new ArrayList();
                    this.songList = new ArrayList();
                    this.tagList = new ArrayList();
                }
            }

            @b("BTNTITLE")
            public String btnTitle;
            @b("CONTENTS")
            public CONTENTS contents;
            @b("SCHEME")
            public String scheme;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;

            public CARDINFO() {
                this.title = "";
                this.subTitle = "";
                this.btnTitle = "";
                this.scheme = "";
                this.contents = null;
            }
        }

        public static class GRAPHINFO implements Serializable {
            public static class GRAPHDETAILINFO implements Serializable {
                @b("CNT")
                public String cnt;
                @b("GRAPH")
                public String graph;
                @b("GRAPHDPCNT")
                public String graphDpCnt;

                public GRAPHDETAILINFO() {
                    this.graph = "";
                    this.graphDpCnt = "";
                    this.cnt = "";
                }
            }

            @b("CURMONTH")
            public String curMonth;
            @b("GRAPHDETAILINFO")
            public ArrayList graphDetailInfo;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;

            public GRAPHINFO() {
                this.title = "";
                this.subTitle = "";
                this.curMonth = "";
                this.graphDetailInfo = new ArrayList();
            }
        }

        public static class LIKETOPINFO implements Serializable {
            public static class LIKEIMGINFO implements Serializable {
                @b("CONTSTYPECODE")
                public String contsTypeCode;
                @b("ID")
                public String id;
                @b("ISSERVICE")
                public boolean isService;
                @b("LIKEIMG")
                public String likeImg;
                @b("LIKESCHEME")
                public String likeScheme;
                @b("NAME")
                public String name;

                public LIKEIMGINFO() {
                    this.likeImg = "";
                    this.likeScheme = "";
                    this.contsTypeCode = "";
                    this.id = "";
                    this.name = "";
                    this.isService = true;
                }
            }

            @b("BGIMG")
            public String bgImg;
            @b("LIKEIMGINFO")
            public ArrayList likeImgInfo;
            @b("SHAREDESC")
            public String shareDesc;
            @b("SHARETITLE")
            public String shareTitle;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;

            public LIKETOPINFO() {
                this.title = "";
                this.subTitle = "";
                this.shareTitle = "";
                this.shareDesc = "";
                this.bgImg = "";
                this.likeImgInfo = new ArrayList();
            }
        }

        public static class SONGTOP3INFO implements Serializable {
            @b("BGIMG")
            public String bgImg;
            @b("CONTENTS")
            public SongInfoBase contents;
            @b("STCNT")
            public String stCnt;
            @b("TITLE")
            public String title;

            public SONGTOP3INFO() {
                this.title = "";
                this.stCnt = "";
                this.bgImg = "";
                this.contents = null;
            }
        }

        @b("ARTISTTOPINFO")
        public ARTISTTOPINFO artistTopInfo;
        @b("CARD01INFO")
        public CARDINFO card01Info;
        @b("CARD02INFO")
        public CARDINFO card02Info;
        @b("CURMONTH")
        public String curMonth;
        @b("GRAPHINFO")
        public GRAPHINFO graphInfo;
        @b("LIKETOPINFO")
        public LIKETOPINFO likeTopInfo;
        @b("MONTHFLAG")
        public boolean monthFlag;
        @b("SONGTOP3INFO")
        public SONGTOP3INFO songTop3Info;

        public RESPONSE() {
            this.monthFlag = false;
            this.curMonth = "";
            this.graphInfo = null;
            this.songTop3Info = null;
            this.artistTopInfo = null;
            this.likeTopInfo = null;
            this.card01Info = null;
            this.card02Info = null;
        }
    }

    @b("response")
    public RESPONSE response;

}

