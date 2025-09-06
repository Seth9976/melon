package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GiftListUserByGiftBoxRes extends ResponseV4Res implements ResponseAdapter {
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
            @b("GIFTNO")
            public String giftNo;
            @b("ISARTIST")
            public boolean isArtist;
            @b("ISDJ")
            public boolean isDj;
            @b("ISESSENTIAL")
            public boolean isEssential;
            @b("ISMYFRIEND")
            public String isMyFriend;
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
            @b("PHONENUMBER")
            public String phoneNumber;
            @b("REPTTYPE")
            public String reptType;
            @b("SENDDATE")
            public String sendDate;
            private static final long serialVersionUID = 0x55B0267B76C2C4FL;
            @b("STAUSCODE")
            public String stausCode;
            @b("WITHDRAWYN")
            public String withdrawYn;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("LASTINDEXKEY")
        public String lastIndexKey;
        private static final long serialVersionUID = 0x2C8B5CBD4FECA6DDL;
        @b("USERLIST")
        public ArrayList userList;

        public RESPONSE() {
            this.userList = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -7858973295299090730L;

    public GiftListUserByGiftBoxRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE giftListUserByGiftBoxRes$RESPONSE0 = this.response;
        return giftListUserByGiftBoxRes$RESPONSE0 != null ? giftListUserByGiftBoxRes$RESPONSE0.userList : null;
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
}

