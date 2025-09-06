package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InfoCommerceAndBtnRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class BtnInfo extends BannerBase {
            @b("ISSHOW")
            public boolean isShow;
            @b("LABEL")
            public String label;
            private static final long serialVersionUID = 0x70D1FCAB62E321D0L;

            @Override  // com.iloen.melon.net.v4x.common.BannerBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class MsgInfo extends BannerBase {
            private static final long serialVersionUID = 0xD5337A54E8120557L;

        }

        @b("BTNINFO")
        public BtnInfo btnInfo;
        @b("MSGINFO")
        public MsgInfo msgInfo;
        private static final long serialVersionUID = 0xA4A250F4C7032F2AL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF15E73D1EC7C0951L;

    public InfoCommerceAndBtnRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

