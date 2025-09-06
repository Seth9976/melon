package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class GiftInformProdGiftBoxRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("PRODAMTS")
        public String prodAmts;
        @b("PRODID")
        public String prodId;
        @b("PRODNAME")
        public String prodName;
        @b("PRODTYPECODE")
        public String prodTypeCode;
        @b("SELLTYPECODE")
        public String sellTypeCode;
        private static final long serialVersionUID = 0x9123AEF3D23F342AL;
        @b("SVCPROVDPRID")
        public String svcProvdPrid;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDF135A657110190EL;

    public GiftInformProdGiftBoxRes() {
        this.response = null;
    }
}

