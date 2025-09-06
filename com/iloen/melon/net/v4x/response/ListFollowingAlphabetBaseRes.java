package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ListFollowingAlphabetBaseRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST implements Serializable {
            @b("ARTISTID")
            public String artistId;
            @b("FBIMAGEURL")
            public String fbImageUrl;
            @b("FBNICKNAME")
            public String fbNickName;
            @b("FRENDADDORIGIN")
            public String frendAddOrigin;
            @b("GNRNAME")
            public String gnrName;
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
            @b("ISOFFICIAL")
            public boolean isOfficial;
            @b("ISPOWERDJ")
            public boolean isPowerDj;
            @b("MEMBERDJICONTYPE")
            public String memberDjIconType;
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
            private static final long serialVersionUID = 0xC41395D9822B045FL;
            @b("WITHDRAWYN")
            public String withDrawYn;

            public USERLIST() {
                this.memberDjIconType = "";
                this.isOfficial = false;
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0x7F80136D045ABF64L;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.hasMore = false;
            this.userList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB514D435AA99B2BEL;

    public ListFollowingAlphabetBaseRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

