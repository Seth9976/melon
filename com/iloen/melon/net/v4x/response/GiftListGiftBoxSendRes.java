package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class GiftListGiftBoxSendRes extends ResponseV4Res implements ResponseAdapter {
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
            @b("MESGCONT")
            public String mesgCont;
            @b("PRODNAME")
            public String prodName;
            @b("RECVCNTCTMDNNO")
            public String recvCntCtmdnNo;
            @b("RECVMEMIMAGE")
            public String recvMemImage;
            @b("RECVMEMNICKNAME")
            public String recvMemNickName;
            @b("RECVUSERMKEY")
            public String recvUserMKey;
            @b("REPTTYPE")
            public String reptType;
            @b("SENDDATE")
            public String sendDate;
            @b("SENDDATE2")
            public String sendDate2;
            private static final long serialVersionUID = 0xDA937D6EF4CBE4EL;
            @b("SONGCNT")
            public String songCnt;
            @b("SONGNAME")
            public String songName;
            @b("STAUSCODE")
            public String statusCode;

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
        private static final long serialVersionUID = 0xB467D7A4593143B5L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF39DF1B937AFB61L;

    public GiftListGiftBoxSendRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE giftListGiftBoxSendRes$RESPONSE0 = this.response;
        return giftListGiftBoxSendRes$RESPONSE0 != null ? giftListGiftBoxSendRes$RESPONSE0.giftList : null;
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

