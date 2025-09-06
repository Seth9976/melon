package com.iloen.melon.net.v5x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class StreamingAnalysisRes extends ResponseV5Res {
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
    public com.iloen.melon.net.v4x.response.StreamLoggingRes.RESPONSE response;

}

