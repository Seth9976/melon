package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GiftListGiftBoxReceiveRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class GIFTLIST implements Serializable {
            @b("ALBUMIMG")
            public String albumImg;
            @b("ARTISTLIST")
            public ArrayList artistList;
            @b("EXPIRDATE")
            public String expireDate;
            @b("GIFTCHK")
            public String giftCHK;
            @b("GIFTNO")
            public String giftNo;
            @b("GIFTPRODGUBUN")
            public String giftProdGubun;
            @b("MEMBERSTATUS")
            public String memberStatus;
            @b("MESGCONT")
            public String mesgCont;
            @b("PRODNAME")
            public String prodName;
            @b("RECVDATE")
            public String recvDate;
            @b("RECVDATE2")
            public String recvDate2;
            @b("SENDMEMIMAGE")
            public String sendMemImage;
            @b("SENDMEMNICKNAME")
            public String sendMemNickName;
            @b("SENDUSERMKEY")
            public String sendUserMKey;
            private static final long serialVersionUID = 0xDA937D6EF4CBE4EL;
            @b("SONGCNT")
            public String songCnt;
            @b("SONGNAME")
            public String songName;
            @b("STAUSCODE")
            public String statusCode;
            @b("WITHDRAWYN")
            public String withDrawYn;

            public GIFTLIST() {
                this.artistList = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("GIFTLIST")
        public ArrayList giftList;
        @b("HASMORE")
        public boolean hasMore;
        @b("LASTINDEXKEY")
        public String lastIndexKey;
        private static final long serialVersionUID = 0xDD7FF1E64C991289L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6B275FBE8C63508L;

    public GiftListGiftBoxReceiveRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE giftListGiftBoxReceiveRes$RESPONSE0 = this.response;
        return giftListGiftBoxReceiveRes$RESPONSE0 != null ? giftListGiftBoxReceiveRes$RESPONSE0.giftList : null;
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

