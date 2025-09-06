package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicInsertSiteChannelRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MEMBERKEY")
        public String memberKey;
        private static final long serialVersionUID = 0x2BBCCB1261C91FEEL;
        @b("SNSCODE")
        public String snsCode;
        @b("SNSDESC")
        public String snsDesc;
        @b("SNSVAL")
        public String snsVal;

        public RESPONSE() {
            this.memberKey = "";
            this.snsCode = "";
            this.snsVal = "";
            this.snsDesc = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x4EBF62CB9EBB780L;

    public MyMusicInsertSiteChannelRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

