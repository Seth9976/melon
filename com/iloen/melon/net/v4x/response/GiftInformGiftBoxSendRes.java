package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class GiftInformGiftBoxSendRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("FILETYPE")
            public String fileType;
            private static final long serialVersionUID = 0x2E224736B626C5A5L;

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("EXPIRDATE")
        public String expireDate;
        @b("GIFTNO")
        public String giftNo;
        @b("GIFTPRODGUBUN")
        public String giftProdGubun;
        @b("ISDJ")
        public boolean isDj;
        @b("ISESSENTIAL")
        public boolean isEssential;
        @b("ISLABEL")
        public boolean isLabel;
        @b("ISOFFICIAL")
        public boolean isOfficial;
        @b("ISPOWERDJ")
        public boolean isPowerDj;
        @b("MEMBERDJICONTYPE")
        public String memberDjIconType;
        @b("MEMBERDJTYPE")
        public String memberDjType;
        @b("MESGCONT")
        public String mesgCont;
        @b("PRODID")
        public String prodId;
        @b("PRODNAME")
        public String prodName;
        @b("RECVCNTCTMDNNO")
        public String recvCntCtMdnNo;
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
        private static final long serialVersionUID = 0x8FF45D0B85EEB45FL;
        @b("SONGCNT")
        public String songCnt;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STAUSCODE")
        public String stausCode;

        public RESPONSE() {
            this.songList = null;
            this.memberDjType = "";
            this.memberDjIconType = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE5D823BD582B2F06L;

    public GiftInformGiftBoxSendRes() {
        this.response = null;
    }
}

