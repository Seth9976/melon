package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class GiftInsertGiftBoxKeyRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("GIFTNO")
        public String giftNo;
        private static final long serialVersionUID = 0x3542794274D8DDC0L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x85F385472E1BF0BDL;

    public GiftInsertGiftBoxKeyRes() {
        this.response = null;
    }
}

