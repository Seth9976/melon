package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.StyleInfoBase;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class SongInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ALBUMINFO extends AlbumInfoBase {
            @b("CTYPE")
            public String cType;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x12C08E2581AEAC08L;

            public ALBUMINFO() {
                this.contsTypeCode = "";
                this.cType = "";
            }
        }

        public static class ArtistInfo extends ArtistInfoBase {
            @b("IMAGETYPE")
            public String imageType;
            private static final long serialVersionUID = 0x2E8916892B988408L;

        }

        public static class BookletImgList implements Serializable {
            @b("BOOKLETIMGNO")
            public String bookletImgNo;
            @b("BOOKLETIMGURL")
            public String bookletImgUrl;
            @b("BOOKLETTHUMBIMGURL")
            public String bookletThumbImgUrl;
            private static final long serialVersionUID = 2103138607254659609L;

            public BookletImgList() {
                this.bookletThumbImgUrl = "";
            }
        }

        public static class STYLELIST extends StyleInfoBase {
            private static final long serialVersionUID = 0x133AE1802DD01658L;

        }

        public static class SongAchievementInfo implements Serializable {
            public static class GenderPercent implements Serializable {
                @b("FEMALE")
                public String female;
                @b("MALE")
                public String male;
                private static final long serialVersionUID = 0x1FF6633E162ED569L;

                public GenderPercent() {
                    this.male = "";
                    this.female = "";
                }
            }

            public static class RecordList implements Serializable {
                @b("RECORD")
                public String record;
                @b("RECORDCODE")
                public String recordCode;
                private static final long serialVersionUID = 0x13560DBA5EAC6F3AL;

                public RecordList() {
                    this.record = "";
                    this.recordCode = "";
                }
            }

            @b("BESTRANK")
            public String bestRank;
            @b("BESTRANKDATE")
            public String bestRankDate;
            @b("GUIDE")
            public String guide;
            @b("INCHARTYN")
            public String inChartYN;
            @b("RECORDLIST")
            public ArrayList recordList;
            private static final long serialVersionUID = 0x33D472F5298F97A2L;
            @b("YESTERDAYCHARTRANK")
            public String yesterdayChartRank;

            public SongAchievementInfo() {
                this.inChartYN = "";
                this.bestRank = "";
                this.bestRankDate = "";
                this.yesterdayChartRank = "";
                this.recordList = null;
                this.guide = "";
            }
        }

        public static class StreamReportInfo implements Serializable {
            public static class com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.StreamReportInfo.GenderPercent implements Serializable {
                @b("FEMALE")
                public String female;
                @b("MALE")
                public String male;
                private static final long serialVersionUID = 0x1FF6633E162ED569L;

                public com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.StreamReportInfo.GenderPercent() {
                    this.male = "";
                    this.female = "";
                }
            }

            @b("AGEPERCENT")
            public ArrayList agePercentList;
            @b("DAILYLISTENERCNT")
            public String dailyListenerCount;
            @b("GENDERPERCENT")
            public com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.StreamReportInfo.GenderPercent genderPercent;
            @b("GUIDE")
            public String guide;
            private static final long serialVersionUID = 0x1FF6641680852F89L;
            @b("TOTALLISTENCNT")
            public String totalAllListenCount;
            @b("TOTALLISTENERCNT")
            public String totalAllListenerCount;

            public StreamReportInfo() {
                this.dailyListenerCount = "";
                this.totalAllListenCount = "";
                this.totalAllListenerCount = "";
                this.guide = "";
                this.genderPercent = null;
                this.agePercentList = null;
            }
        }

        @b("ALBUMINFO")
        public ALBUMINFO albumInfo;
        @b("ARNGRLIST")
        public ArrayList arngrList;
        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("BBSCONTSREFVALUE")
        public String bbsContsRefValue;
        @b("BBSCHANNELSEQ")
        public String bbschannelseq;
        @b("BOOKLETIMGLIST")
        public ArrayList bookletImgList;
        @b("CPLANCODE")
        public String cPlanCode;
        @b("CMPSRLIST")
        public ArrayList cmpsrList;
        @b("CMTCNT")
        public String cmtCnt;
        @b("DUMMYTEXT")
        public String dummyText;
        @b("GENRELIST")
        public ArrayList genreList;
        @b("ISDOLBYATMOS")
        public boolean isDolbyAtmos;
        @b("ISHIGHLIGHTAVAIL")
        public boolean isHightlightAvail;
        @b("LIKECNT")
        public String likeCnt;
        @b("LYRIC")
        public String lyric;
        @b("LYRICTOOLTIPMSG")
        public String lyricToolTipMsg;
        @b("LYSTLIST")
        public ArrayList lystList;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0x6385B8FD5B160C08L;
        @b("SONGACHIEVEMENTINFO")
        public SongAchievementInfo songAchievementInfo;
        @b("SONGFLACINFO")
        public String songFlacInfo;
        @b("SONGINFO")
        public SongInfoBase songInfo;
        @b("STREAMREPORTINFO")
        public StreamReportInfo streamReportInfo;
        @b("STYLELIST")
        public ArrayList styleList;

        public RESPONSE() {
            this.albumInfo = null;
            this.arngrList = null;
            this.artistList = null;
            this.bbschannelseq = "";
            this.bbsContsRefValue = "";
            this.bookletImgList = null;
            this.cmpsrList = null;
            this.cmtCnt = "";
            this.cPlanCode = "";
            this.streamReportInfo = null;
            this.dummyText = "";
            this.isHightlightAvail = false;
            this.lyricToolTipMsg = "";
            this.likeCnt = "";
            this.lyric = "";
            this.lystList = null;
            this.postEditImg = "";
            this.postImg = "";
            this.songAchievementInfo = null;
            this.songFlacInfo = "";
            this.songInfo = null;
            this.genreList = null;
            this.styleList = null;
            this.isDolbyAtmos = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1DDC42A17BDD3305L;

    public SongInfoRes() {
        this.response = null;
    }
}

