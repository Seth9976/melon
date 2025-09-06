package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class InformMyProfileMyMusicRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 1425496404984077130L;

        }

        @b("ADDFRIENDCNT")
        public String addFriendCnt;
        @b("BNRSGMT")
        public String bnrSgmt;
        @b("COVERIMG")
        public String coverImg;
        @b("DNADPNAME")
        public String dnaDpName;
        @b("DNADPTYPE")
        public String dnaDpType;
        @b("FANARTISTNEWYN")
        public String fanArtistNewYn;
        @b("FRIENDCNT")
        public String friendCnt;
        @b("GIFTBOXNEWCNT")
        public String giftBoxNewCnt;
        @b("GIFTBOXNEWFLAG")
        public String giftBoxNewFlag;
        @b("HASFLACSTPROD")
        public boolean hasFlacStProd;
        @b("HIFIPROD")
        public String hifiProd;
        @b("ISDJ")
        public boolean isDj;
        @b("ISESSENTIAL")
        public boolean isEssential;
        @b("ISLABEL")
        public boolean isLabel;
        @b("ISNEWICONSERIES")
        public boolean isNewIconSeries;
        @b("ISNEWICONTAG")
        public boolean isNewIconTag;
        @b("ISPOWERDJ")
        public boolean isPowerDj;
        @b("MANYLISTENSONGOPENFLAG")
        public String manyListenSongOpenFlag;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("MEMBERKEY")
        public String memberKey;
        @b("MEMBERNICKNAME")
        public String memberNickname;
        @b("MUSICMSGNEWCNT")
        public String musicMsgNewCnt;
        @b("MUSICMSGNEWFLAG")
        public String musicMsgNewFlag;
        @b("MYCOVERIMG")
        public String myCoverImg;
        @b("MYPAGEDESC")
        public String myPageDesc;
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("MYPAGEIMGORG")
        public String myPageImgOrg;
        @b("MYLOGNEWYN")
        public String mylogNewYn;
        @b("NEWADDFRIENDCNT")
        public String newAddFriendCnt;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("PRODUCTINFO")
        public String productInfo;
        @b("REALNICKNAME")
        public String realNickName;
        @b("RECNTMVOPENFLAG")
        public String recentMvOpenFlag;
        @b("RECNTSONGOPENFLAG")
        public String recentSongOpenFlag;
        private static final long serialVersionUID = 6047261638060715666L;
        @b("SONGLIST")
        public ArrayList songlist;
        @b("TODAYVISITCNT")
        public String todayVisitCnt;
        @b("TOTVISITCNT")
        public String totalVisitCnt;

        public RESPONSE() {
            this.songlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x20CA9D53BE65684CL;

    public InformMyProfileMyMusicRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

