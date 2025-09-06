package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ContsInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistTemperatureDetailRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTSINFO extends ContsInfoBase {
            @b("IMGPATH")
            public String imgPath;
            private static final long serialVersionUID = 0x9E38FC544A904705L;

            public CONTSINFO() {
                this.imgPath = "";
            }
        }

        public static class CONTSUSE implements Serializable {
            @b("ALBUMLIKECNT")
            public String albumLikeCnt;
            @b("ALBUMSHARECNT")
            public String albumShareCnt;
            @b("ARTISTSHARECNT")
            public String artistShareCnt;
            @b("AZTCNT")
            public String aztCnt;
            @b("BRAVOCNT")
            public String bravoCnt;
            @b("CONCERTCNT")
            public String concertCnt;
            @b("CONCERTLIKECNT")
            public String concertLikeCnt;
            @b("CONCERTSHARECNT")
            public String concertShareCnt;
            @b("CONTENTSCNT")
            public String contentsCnt;
            @b("LIKECNT")
            public String likeCnt;
            @b("MVCNT")
            public String mvCnt;
            @b("MVLIKECNT")
            public String mvLikeCnt;
            @b("MVSHARECNT")
            public String mvShareCnt;
            @b("PHOTOCNT")
            public String photoCnt;
            @b("PHOTOLIKECNT")
            public String photoLikeCnt;
            @b("PHOTOSHARECNT")
            public String photoShareCnt;
            @b("PLAYLISTCNT")
            public String playlistCnt;
            @b("PLAYLISTLIKECNT")
            public String playlistLikeCnt;
            @b("PLAYLISTSHARECNT")
            public String playlistShareCnt;
            private static final long serialVersionUID = 0x449E96A7E8C8327FL;
            @b("SHARECNT")
            public String shareCnt;
            @b("SHOPCNT")
            public String shopCnt;
            @b("SONGLIKECNT")
            public String songLikeCnt;
            @b("SONGSHARECNT")
            public String songShareCnt;
            @b("STCNT")
            public String stCnt;
            @b("TICKETCNT")
            public String ticketCnt;
            @b("WRITECNT")
            public String writeCnt;

        }

        public static class TIMELINELIST implements Serializable {
            @b("ADDINFO")
            public String addInfo;
            @b("CONTS")
            public CONTSINFO contsInfo;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("DATE")
            public String date;
            private static final long serialVersionUID = 0x8D902917F893125BL;
            @b("TYPE")
            public String type;

        }

        public static class TOPSTREAMINGSONGLIST implements Serializable {
            @b("CNT")
            public String cnt;
            @b("CONTSINFO")
            public CONTSINFO contsInfo;
            private static final long serialVersionUID = 0x4C3B901348FD76BL;

        }

        @b("ARTISTID")
        public String artistId;
        @b("ARTISTIMG")
        public String artistImg;
        @b("ARTISTNAME")
        public String artistName;
        @b("ARTISTYN")
        public String artistYN;
        @b("AVERCONTSUSE")
        public CONTSUSE averContsUse;
        @b("AVGTEMPER")
        public String avgTemper;
        @b("FANDATE")
        public String fanData;
        @b("FANYN")
        public String fanYN;
        @b("GUIDEDESC")
        public String guideDesc;
        @b("GUIDETITLE")
        public String guideTitle;
        @b("MAXCONTSUSE")
        public CONTSUSE maxContsUse;
        @b("MAXTEMPER")
        public String maxTemper;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MESSAGE")
        public String message;
        @b("MINTEMPER")
        public String minTemper;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;
        @b("TIMELINELIST")
        public ArrayList timelineList;
        @b("TODAYDATE")
        public String todayDate;
        @b("TOPSTREAMINGSONGLIST")
        public ArrayList topStreamingSongList;
        @b("TOTALUSERRANK")
        public String totalUserRank;
        @b("USERCONTSUSE")
        public CONTSUSE userContsUse;
        @b("USERRANK")
        public String userRank;
        @b("USERTEMPER")
        public String userTemper;

        public RESPONSE() {
            this.timelineList = null;
            this.topStreamingSongList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

