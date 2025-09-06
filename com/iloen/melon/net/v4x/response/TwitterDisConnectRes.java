package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class TwitterDisConnectRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ERRORCODE")
        public String errorCode;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;
        @b("STATUS")
        public String status;

    }

    @b("response")
    public RESPONSE response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

