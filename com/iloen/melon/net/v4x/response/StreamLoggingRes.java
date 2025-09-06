package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class StreamLoggingRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ERRORCODE")
        public String errorCode;
        @b("ERRORMSG")
        public String errorMsg;
        @b("RESULT")
        public String result;
        private static final long serialVersionUID = 0x9848575600E27078L;

    }

    @b("RESPONSE")
    public RESPONSE response;
    private static final long serialVersionUID = 0x158B9B37D377B580L;

}

