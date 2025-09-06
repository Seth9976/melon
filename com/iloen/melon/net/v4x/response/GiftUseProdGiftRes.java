package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class GiftUseProdGiftRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("GIFTNO")
        public String giftNo;
        private static final long serialVersionUID = 0x61F88BD8FB7E0C08L;

        public RESPONSE() {
            this.giftNo = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x21D01485CD178B05L;

    public GiftUseProdGiftRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

