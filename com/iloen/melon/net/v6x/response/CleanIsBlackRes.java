package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class CleanIsBlackRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("ISBLACKLIST")
        public boolean isBlackList;
        @b("REDIRECTAPPURL")
        public String redirectAppUrl;
        @b("REDIRECTURL")
        public String redirectUrl;
        private static final long serialVersionUID = 0xD66D801D46D18EC0L;

        public RESPONSE() {
            this.isBlackList = false;
            this.redirectUrl = "";
            this.redirectAppUrl = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 8235620608810970266L;

    public CleanIsBlackRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

