package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class LiveSettleLogRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        @b("ERRORCODE")
        public String errorCode;
        @b("ERRORMSG")
        public String errorMsg;
        @b("RESULT")
        public String result;
        private static final long serialVersionUID = 0xF841FB610FCDABF8L;

    }

    @b("RESPONSE")
    public Response response;
    private static final long serialVersionUID = 0x2780F240E239B803L;

}

