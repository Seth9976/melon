package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicMusicDnaListRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public class DJACT implements Serializable {
            public class DJHASHTAGLIST implements Serializable {
                private static final long serialVersionUID = 0xA8ADE04AB626A429L;
                @b("TAGNAME")
                public String tagName;
                @b("TAGSEQ")
                public String tagSeq;

            }

            @b("DJHASHTAGLIST")
            public ArrayList djHashTagList;
            @b("DJLIKECNT")
            public int djLikeCnt;
            @b("DJMAXLIKEPLAYLISTNAME")
            public String djMaxLikePlayListName;
            @b("DJMAXLIKEPLAYLISTSEQ")
            public String djMaxLikePlayListSeq;
            @b("DJNICKNAME")
            public String djNickName;
            @b("DJPLAYLISTCNT")
            public String djPlayListCnt;
            @b("DJTOP1ARTISTCNT")
            public String djTop1ArtistCnt;
            @b("DJTOP1ARTISTID")
            public String djTop1ArtistId;
            @b("DJTOP1ARTISTIMG")
            public String djTop1ArtistImg;
            @b("DJTOP1ARTISTNAME")
            public String djTop1ArtistName;
            @b("DJTOP1GNR")
            public String djTop1Gnr;
            @b("ISPWRDJ")
            public String isPowerDj;
            @b("PWRDJRSN")
            public String pwrdjrsn;
            private static final long serialVersionUID = 0xA8ADE04AB626A429L;
            @b("TODAYSONGCNT")
            public String todaySongCnt;
            @b("TOPCHARTDPDATE")
            public String topChartDpDate;
            @b("TOPCHARTPLYLSTNAME")
            public String topChartPlyLstName;
            @b("TOPCHARTPLYLSTSEQ")
            public String topChartPlyLstSeq;
            @b("TOPCHARTRANK")
            public String topChartRank;

        }

        public class FAVORARTISTS implements Serializable {
            public class FAVORARTISTSLIST implements Serializable {
                @b("ARTISTID")
                public String artistId;
                @b("ARTISTIMGPATH")
                public String artistImgPath;
                @b("ARTISTLIKECNT")
                public int artistLikeCnt;
                @b("ARTISTNAME")
                public String artistName;
                @b("ARTISTPLAYCNT")
                public int artistPlayCnt;
                @b("ARTISTRANK")
                public int artistRank;
                @b("ARTISTRATIO")
                public int artistRatio;
                @b("ARTISTTEMPERATURE")
                public int artistTemperature;
                @b("NOSONGTXT")
                public String noSongTxt;
                private static final long serialVersionUID = 0x4ACB0530F580CEEDL;
                @b("SONGLIST")
                public ArrayList songList;

            }

            @b("FAVORARTISTSLIST")
            public ArrayList favorArtistsList;
            private static final long serialVersionUID = 0x7DA0808C6CC9DACCL;

        }

        public class FAVORCOMPOSERS implements Serializable {
            public class FAVORCOMPOSERSLIST implements Serializable {
                @b("COMPOSERID")
                public String composerId;
                @b("COMPOSERNAME")
                public String composerName;
                @b("COMPOSERRANK")
                public int composerRank;
                private static final long serialVersionUID = 0xC8E39167D0E8DD95L;

            }

            @b("FAVORCOMPOSERSLIST")
            public ArrayList favoriteComposerList;
            private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

        }

        public class FAVORGNRS implements Serializable {
            public class FAVORGNRSLIST implements Serializable {
                @b("GNRCODE")
                public String gnrCode;
                @b("GNRLIKECNT")
                public int gnrLikeCnt;
                @b("GNRNAME")
                public String gnrName;
                @b("GNRPLAYCNT")
                public int gnrPlayCnt;
                @b("GNRRANK")
                public int gnrRank;
                @b("GNRRATIO")
                public int gnrRatio;
                @b("NOSONGTXT")
                public String noSongTxt;
                private static final long serialVersionUID = 0x4ACB0530F580CEEDL;
                @b("SONGLIST")
                public ArrayList songList;

            }

            @b("FAVORGNRSLIST")
            public ArrayList favorGnrsList;
            private static final long serialVersionUID = 0x7DA0808C6CC9DACCL;

        }

        public class FAVORLABELS implements Serializable {
            public class FAVORLABELSLIST implements Serializable {
                @b("LABELNAME")
                public String labelName;
                @b("LABELRANK")
                public int labelRank;
                private static final long serialVersionUID = 0xC8E39167D0E8DD95L;

            }

            @b("FAVORLABELSLIST")
            public ArrayList favoriteLabelsList;
            private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

        }

        public class FIRSTARTIST implements Serializable {
            public class ALBUMLIST extends AlbumInfoBase {
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

            }

            public class SONGLIST extends SongInfoBase {
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

            }

            @b("ALBUMLIST")
            public ArrayList albumList;
            @b("ARTISTNM")
            public String artistNm;
            @b("LOGTYPE")
            public String logType;
            @b("RECMCONTSTEXTMAIN")
            public String recmContsTextMain;
            @b("RECMCONTSTEXTSUB")
            public String recmContsTextSub;
            private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;
            @b("SONGLIST")
            public ArrayList songList;

        }

        public class FIRSTFAVORGNR implements Serializable {
            public class com.iloen.melon.net.v4x.response.MyMusicMusicDnaListRes.RESPONSE.FIRSTFAVORGNR.ALBUMLIST extends AlbumInfoBase {
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

            }

            public class DJPLAYLIST extends DjPlayListInfoBase {
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

            }

            public class GNRLIST implements Serializable {
                @b("GNRCODE")
                public String gnrCode;
                @b("GNRDPNAME")
                public String gnrDpName;
                @b("GNRNAME")
                public String gnrName;
                @b("GUITYPE")
                public String guiType;
                @b("ISDTLGNR")
                public boolean isDtlGnr;
                @b("MENUCODE")
                public String menuCode;
                @b("MENUNAME")
                public String menuName;
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

            }

            public class RADIOLIST implements Serializable {
                @b("CHNLTYPE")
                public String chnlType;
                @b("CHNLSSEQ")
                public String chnlsSeq;
                @b("GNRCODE")
                public String gnrCode;
                private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;
                @b("THUMBIMG")
                public String thumbImg;
                @b("TITLE")
                public String title;
                @b("VALIDCMTCNT")
                public String validCmtCnt;
                @b("VALIDCNT")
                public String validCnt;

            }

            @b("ALBUMLIST")
            public ArrayList albumList;
            @b("DJPLAYLIST")
            public ArrayList djPlaylist;
            @b("GNCODE")
            public String gnCode;
            @b("GNRLIST")
            public GNRLIST gnrList;
            @b("LOGTYPE")
            public String logType;
            @b("RADIOLIST")
            public ArrayList radioList;
            @b("RECMCONTSTEXTMAIN")
            public String recmContsTextMain;
            @b("RECMCONTSTEXTSUB")
            public String recmContsTextSub;
            private static final long serialVersionUID = 0x2ADADCD9942BF3BDL;

        }

        public class PLAYSTYLE implements Serializable {
            public class OLDSONGINFO extends SongInfoBase {
                private static final long serialVersionUID = 0x2197A79EE10FDA25L;
                @b("SONGPLAYCNTS")
                public int songPlayCnts;
                @b("SONGRANK")
                public String songRank;

            }

            public class SPECTRUMSONGINFO extends SongInfoBase {
                private static final long serialVersionUID = 0x2197A79EE10FDA25L;
                @b("SONGPLAYCNTS")
                public int songPlayCnts;
                @b("SONGRANK")
                public String songRank;

            }

            @b("ISMONTHLYSONGPLAYTOP10TXT")
            public String isMonthlySongPlayTop10Txt;
            @b("ISMONTHLYSONGPLAYTOP1TXT")
            public String isMonthlySongPlayTop1Txt;
            @b("ISOLDSONGPREFERENCEGROUP")
            public boolean isOldSongPreferenceGroup;
            @b("ISVIDEOPREFERENCEGROUP")
            public boolean isVideoPreferenceGroup;
            @b("MONTHLYAVGSONGPLAYCNT")
            public int monthlyAvgSongPlayCnt;
            @b("MONTHLYTOTALAVGSONGPLAYCNT")
            public int monthlyTotalAvgSongPlayCnt;
            @b("OLDSONGTXT")
            public String oldSongTxt;
            @b("OLDSONGINFO")
            public OLDSONGINFO oldsonginfo;
            private static final long serialVersionUID = 0xA8ADE04AB626A429L;
            @b("SPECTRUMSONGPLAYCNT")
            public int spectrumSongPlayCnt;
            @b("SPECTRUMSONGPLAYTXT")
            public String spectrumSongPlayTxt;
            @b("SPECTRUMSONGINFO")
            public SPECTRUMSONGINFO spectrumsonginfo;
            @b("STYLEOFHOURCODE")
            public String styleOfHourCode;
            @b("STYLEOFHOURMAXCNT")
            public int styleOfHourMaxCnt;
            @b("STYLEOFHOURMAXRATIO")
            public int styleOfHourMaxRatio;
            @b("STYLEOFHOURTOTALCNT")
            public int styleOfHourTotalCnt;
            @b("STYLEOFHOURTXT")
            public String styleOfHourTxt;
            @b("STYLEOFTOTALSONGCNT")
            public int styleOfTotalSongCnt;
            @b("STYLEOFTOTALSONGTXT")
            public String styleOfTotalSongTxt;
            @b("STYLEOFWEEKCODE")
            public String styleOfWeekCode;
            @b("STYLEOFWEEKDAYCNT")
            public int styleOfWeekDayCnt;
            @b("STYLEOFWEEKDAYRATIO")
            public int styleOfWeekDayRatio;
            @b("STYLEOFWEEKENDRATIO")
            public int styleOfWeekEndRatio;
            @b("STYLEOFWEEKTXT")
            public String styleOfWeekTxt;
            @b("STYLEOFWEEKENDCNT")
            public int styleOfWeekendCnt;
            @b("STYLEC")
            public String stylec;
            @b("STYLED")
            public String styled;
            @b("STYLEE")
            public String stylee;
            @b("STYLEF")
            public String stylef;
            @b("STYLEG")
            public String styleg;
            @b("STYLEH")
            public String styleh;
            @b("TOP100SONGPLAYRATE")
            public int top100SongPlayRate;
            @b("TOP100SONGPLAYTXT")
            public String top100SongPlayTxt;
            @b("VIDEOLIKECNT")
            public int videoLikeCnt;
            @b("VIDEOPLAYCNT")
            public int videoPlayCnt;
            @b("VIDEOPREFERENCETXT")
            public String videoPreferenceTxt;

        }

        public class com.iloen.melon.net.v4x.response.MyMusicMusicDnaListRes.RESPONSE.SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x2197A79EE10FDA25L;
            @b("SONGPLAYCNTS")
            public String songPlayCnts;
            @b("SONGRANK")
            public String songRank;
            @b("UNPLAYFLAG")
            public String unPlayFlag;
            @b("UNPLAYMSG")
            public String unPlayMsg;

        }

        public static class TOTALPLAY implements Serializable {
            @b("COOKIEMEMBERKEY")
            public String cookieMemberKey;
            @b("JOINDATE")
            public String joinDate;
            @b("LOGDATE")
            public String logDate;
            @b("MEMBERNICKNAME")
            public String memberNickName;
            @b("RETURNTXT1")
            public String returnTxt1;
            @b("RETURNTXT2")
            public String returnTxt2;
            @b("RETURNTXT3")
            public String returnTxt3;
            @b("RETURNTXT4")
            public String returnTxt4;
            private static final long serialVersionUID = -3057510552451647441L;
            @b("TOTALSONGCNT")
            public int totalSongCnt;

        }

        @b("DJACT")
        public DJACT djAct;
        @b("FAVORARTISTS")
        public FAVORARTISTS favorArtists;
        @b("FAVORGNRS")
        public FAVORGNRS favorGnrs;
        @b("FAVORCOMPOSERS")
        public FAVORCOMPOSERS favoriteComposer;
        @b("FAVORLABELS")
        public FAVORLABELS favoriteLabels;
        @b("FIRSTARTIST")
        public FIRSTARTIST firstArtist;
        @b("FIRSTFAVORGNR")
        public FIRSTFAVORGNR firstFavorGnr;
        @b("MANYLISTENSONGFLAG")
        public String manyListenSongFlag;
        @b("PLAYSTYLE")
        public PLAYSTYLE playStyle;
        private static final long serialVersionUID = 0x5576A2D5B6D4CEDDL;
        @b("TOTALPLAY")
        public TOTALPLAY totalplay;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x20CA9D53BE65684CL;

    public MyMusicMusicDnaListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

