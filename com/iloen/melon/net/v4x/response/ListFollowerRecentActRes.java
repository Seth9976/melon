package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ListFollowerRecentActRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST implements Serializable {
            @b("ARTISTID")
            public String artistId;
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("FBIMAGEURL")
            public String fbImageUrl;
            @b("FBNICKNAME")
            public String fbNickName;
            @b("FRENDADDORIGIN")
            public String frendAddOrigin;
            @b("GNRNAME")
            public String gnrName;
            @b("HIDEYN")
            public String hideYn;
            @b("INVTFRENDNAME")
            public String invtFrendName;
            @b("ISARTIST")
            public boolean isArtist;
            @b("ISDJ")
            public boolean isDj;
            @b("ISESSENTIAL")
            public boolean isEssential;
            @b("ISLABEL")
            public boolean isLabel;
            @b("ISMYFRIEND")
            public boolean isMyFriend;
            @b("ISPOWERDJ")
            public boolean isPowerDj;
            @b("MEMBERDJTYPE")
            public String memberDjType;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNICKNAME")
            public String memberNickName;
            @b("MEMBERSTATUS")
            public String memberStatus;
            @b("MYPAGEIMG")
            public String myPageImg;
            @b("NEWADDFRIENDYN")
            public String newAddFriendYn;
            @b("PHONENUMBER")
            public String phoneNumber;
            @b("PLAYLISTCNT")
            public String playListCnt;
            @b("PROFILESONGARTISTNAME")
            public String profileSongArtistName;
            @b("PROFILESONGID")
            public String profileSongId;
            @b("PROFILESONGNAME")
            public String profileSongName;
            @b("RECENTACTFLG")
            public String recentActFlg;
            private static final long serialVersionUID = 0x8B1BE92FE75EC083L;
            @b("UPDTDATE")
            public String updtDate;
            @b("UPDTDATE2")
            public String updtDate2;
            @b("VISITCNT")
            public String visitCnt;
            @b("WITHDRAWYN")
            public String withDrawYn;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("NEWADDFRIENDCNT")
        public String newAddFriendCnt;
        private static final long serialVersionUID = 0x580B9DA45BCA235EL;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.newAddFriendCnt = "";
            this.hasMore = false;
            this.userList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE3A07B679E3BE4BDL;

    public ListFollowerRecentActRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE listFollowerRecentActRes$RESPONSE0 = this.response;
        return listFollowerRecentActRes$RESPONSE0 != null ? listFollowerRecentActRes$RESPONSE0.userList : null;
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

