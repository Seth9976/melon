package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.constants.LiveStatusCode;
import com.melon.net.res.common.ResponseBase;
import java.util.Map;

public class LivePlayerRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        @b("LIVESDKINFO")
        public Map liveSdkInfo;
        @b("LIVESTATUSCODE")
        public LiveStatusCode liveStatusCode;
        @b("LOGGINGTOKEN")
        public String loggingToken;
        @b("PLAYTIME")
        public String playTime;
        @b("PREVIEWURL")
        public String previewUrl;

        public Response() {
            this.liveSdkInfo = null;
            this.previewUrl = "";
            this.playTime = "";
            this.liveStatusCode = null;
            this.loggingToken = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x2783D626CC94337BL;

    public LivePlayerRes() {
        this.response = null;
    }
}

