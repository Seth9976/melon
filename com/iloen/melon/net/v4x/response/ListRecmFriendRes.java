package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ListRecmFriendRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST implements Serializable {
            @b("ACTCONTSARTISTID")
            public String actContsArtistId;
            @b("ACTCONTSARTISTIMGPATH")
            public String actContsArtistImgPath;
            @b("ACTCONTSARTISTNAME")
            public String actContsArtistName;
            @b("ACTCONTSID")
            public String actContsId;
            @b("ACTCONTSIMGPATH")
            public String actContsImgPath;
            @b("ACTCONTSNAME")
            public String actContsName;
            @b("ACTCONTSTYPECODE")
            public String actContsTypeCode;
            @b("ALBUMID")
            public String albumId;
            @b("ALBUMIMG")
            public String albumImg;
            @b("ALBUMIMGLARGE")
            public String albumImgLarge;
            @b("ALBUMNAME")
            public String albumName;
            @b("COMMLIKECNT")
            public String commLikeCnt;
            @b("FBIMAGEURL")
            public String fbImgUrl;
            @b("FBNICKNAME")
            public String fbNickName;
            @b("GNRNAME")
            public String gnrName;
            @b("ISADULT")
            public boolean isAdult;
            @b("ISFREE")
            public boolean isFree;
            @b("ISHITSONG")
            public boolean isHitSong;
            @b("ISHOLDBACK")
            public boolean isHoldBack;
            @b("ISMV")
            public boolean isMv;
            @b("ISMYFRIEND")
            public boolean isMyFriend;
            @b("ISPOWERDJ")
            public boolean isPowerDj;
            @b("ISSERVICE")
            public boolean isService;
            @b("ISTITLESONG")
            public boolean isTitleSong;
            @b("ISSUEDATE")
            public String issueDate;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNICKNAME")
            public String memberNickName;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("PLAYLISTCNT")
            public String playListCnt;
            @b("PLAYTIME")
            public String playTime;
            @b("RECMCONTSARTISTID")
            public String recmContsArtistId;
            @b("RECMCONTSARTISTNAME")
            public String recmContsArtistName;
            @b("RECMCONTSGNRCODE")
            public String recmContsGnrCode;
            @b("RECMCONTSGNRNAME")
            public String recmContsGnrName;
            @b("RECMCONTSID")
            public String recmContsId;
            @b("RECMCONTSNAME")
            public String recmContsName;
            @b("RECMCONTSTYPECODE")
            public String recmContsTypeCode;
            @b("RECMDESC")
            public String recmDesc;
            @b("RECMTYPECODE")
            public String recmTypeCode;
            private static final long serialVersionUID = 0x8B1BE92FE75EC083L;
            @b("SONGID")
            public String songId;
            @b("SONGNAME")
            public String songName;
            @b("TARGTACTDESC")
            public String targTactDesc;
            @b("TOTVISITCNT")
            public String totVisitCnt;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LASTINDEXKEY")
        public String lastIndexKey;
        @b("NEWADDFRIENDCNT")
        public String newAddFriendCnt;
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.newAddFriendCnt = "";
            this.lastIndexKey = "1";
            this.hasMore = false;
            this.userList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE3A07B679E3BE4BDL;

    public ListRecmFriendRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE listRecmFriendRes$RESPONSE0 = this.response;
        return listRecmFriendRes$RESPONSE0 != null ? listRecmFriendRes$RESPONSE0.userList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

