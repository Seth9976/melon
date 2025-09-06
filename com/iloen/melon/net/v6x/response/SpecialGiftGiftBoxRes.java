package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;

public class SpecialGiftGiftBoxRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class GIFTBOX extends LinkInfoBase {
            private static final long serialVersionUID = 0x2DDF8E90A0607494L;

        }

        @b("GIFTBOX")
        public GIFTBOX giftBox;
        @b("HADGIFTS")
        public boolean hadGifts;
        private static final long serialVersionUID = 0x764238CF24544793L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5A950A9C8A3414E7L;

    public SpecialGiftGiftBoxRes() {
        this.response = null;
    }
}

