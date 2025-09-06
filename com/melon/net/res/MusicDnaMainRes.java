package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicDnaMainRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class MYCHART implements Serializable {
            @b("LISTTYPE")
            public String listType;
            @b("SONGLIST")
            public ArrayList songList;
            @b("TITLE")
            public String title;

            public MYCHART() {
                this.title = "";
                this.listType = "";
                this.songList = new ArrayList();
            }
        }

        public static class MYDNA implements Serializable {
            public static class CARD implements Serializable {
                @b("DATE")
                public String date;
                @b("DESC")
                public String desc;
                @b("IMGPATH")
                public String imgPath;
                @b("RANK")
                public int rank;
                @b("SHARECONTENTS")
                public String shareContents;
                @b("SHARETITLE")
                public String shareTitle;
                @b("SUBTITLE")
                public String subTitle;
                @b("TITLE")
                public String title;
                @b("TYPECODE")
                public String typeCode;

                public CARD() {
                    this.typeCode = "";
                    this.title = "";
                    this.date = "";
                    this.subTitle = "";
                    this.imgPath = "";
                    this.shareTitle = "";
                    this.shareContents = "";
                    this.desc = "";
                    this.rank = 0;
                }
            }

            @b("CARD")
            public ArrayList card;

            public MYDNA() {
                this.card = new ArrayList();
            }
        }

        public static class MYHISTORY implements Serializable {
            public static class MYHISTORYLIST extends LinkInfoBase {
                @b("IMGPATH")
                public String imgPath;
                @b("TITLE")
                public String title;

                public MYHISTORYLIST() {
                    this.title = "";
                    this.imgPath = "";
                }
            }

            @b("MYHISTORYLIST")
            public ArrayList myHistoryList;
            @b("TITLE")
            public String title;

            public MYHISTORY() {
                this.title = "";
                this.myHistoryList = new ArrayList();
            }
        }

        public static class MYRECENTLIST implements Serializable {
            public static class MYGNRLIST implements Serializable {
                public static class GNRLIST implements Serializable {
                    @b("GNRCODE")
                    public String gnrCode;
                    @b("GNRNAME")
                    public String gnrName;
                    @b("GNRPER")
                    public String gnrPer;

                    public GNRLIST() {
                        this.gnrName = "";
                        this.gnrCode = "";
                        this.gnrPer = "";
                    }
                }

                @b("BGIMG")
                public String bgImg;
                @b("GNRLIST")
                public ArrayList gnrList;
                @b("TITLE")
                public String title;

                public MYGNRLIST() {
                    this.title = "";
                    this.bgImg = "";
                    this.gnrList = new ArrayList();
                }
            }

            public static class RARTIST implements Serializable {
                @b("ARTISTID")
                public String artistId;
                @b("ARTISTIMG")
                public String artistImg;
                @b("ARTISTNAME")
                public String artistName;
                @b("BGIMG")
                public String bgImg;
                @b("COUNT")
                public String count;
                @b("TITLE")
                public String title;

                public RARTIST() {
                    this.artistId = "";
                    this.artistName = "";
                    this.title = "";
                    this.artistImg = "";
                    this.count = "";
                    this.bgImg = "";
                }
            }

            public static class RSONGLIST implements Serializable {
                public static class SONGLIST extends SongInfoBase {
                    @b("CNT")
                    public String cnt;
                    @b("RN")
                    public String rn;

                    public SONGLIST() {
                        this.cnt = "";
                        this.rn = "";
                    }
                }

                @b("BGIMG")
                public String bgImg;
                @b("SONGLIST")
                public ArrayList songList;
                @b("TITLE")
                public String title;
                @b("TOTALSONGCNT")
                public String totalSongCnt;

                public RSONGLIST() {
                    this.title = "";
                    this.bgImg = "";
                    this.totalSongCnt = "";
                    this.songList = new ArrayList();
                }
            }

            @b("MYGNRLIST")
            public MYGNRLIST myGnrList;
            @b("ORDER")
            public ArrayList order;
            @b("RARTIST")
            public RARTIST rArtist;
            @b("RSONGLIST")
            public RSONGLIST rSongList;
            @b("TITLE")
            public String title;

            public MYRECENTLIST() {
                this.title = "";
                this.myGnrList = null;
                this.rArtist = null;
                this.rSongList = null;
                this.order = new ArrayList();
            }
        }

        public static class MYTITLE extends LinkInfoBase {
            public static class TITLES extends LinkInfoBase {
                @b("ARTISTIMG")
                public String artistImg;
                @b("BASIC")
                public boolean basic;
                @b("BGCOLOR")
                public String bgColor;
                @b("BGIMG")
                public String bgImg;
                @b("PER")
                public String per;
                @b("TITLE")
                public String title;
                @b("TYPE")
                public String type;

                public TITLES() {
                    this.type = "";
                    this.title = "";
                    this.bgImg = "";
                    this.bgColor = "";
                    this.artistImg = "";
                    this.per = "";
                    this.basic = false;
                }
            }

            @b("TITLECNT")
            public int titleCnt;
            @b("TITLES")
            public ArrayList titles;

            public MYTITLE() {
                this.titleCnt = 0;
                this.titles = new ArrayList();
            }
        }

        @b("INTRO")
        public String intro;
        @b("MONTHFLAG")
        public boolean monthFlag;
        @b("MYCHART")
        public MYCHART myChart;
        @b("MYDNA")
        public MYDNA myDna;
        @b("MYHISTORY")
        public MYHISTORY myHistory;
        @b("MYRECENTLIST")
        public MYRECENTLIST myRecentList;
        @b("MYTITLE")
        public MYTITLE myTitle;
        @b("TOTCOUNT")
        public String totCount;

        public RESPONSE() {
            this.totCount = "";
            this.intro = "";
            this.monthFlag = false;
            this.myDna = null;
            this.myTitle = null;
            this.myChart = null;
            this.myRecentList = null;
            this.myHistory = null;
        }
    }

    @b("response")
    public RESPONSE response;

}

