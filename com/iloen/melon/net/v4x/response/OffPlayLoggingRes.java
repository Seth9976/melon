package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class OffPlayLoggingRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        @b("ERRORCODE")
        public String errorCode;
        @b("ERRORMSG")
        public String errorMsg;
        @b("RESULT")
        public int result;

    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

