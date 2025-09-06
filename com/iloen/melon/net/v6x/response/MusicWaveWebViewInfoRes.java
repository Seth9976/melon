package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class MusicWaveWebViewInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("ID")
        public String id;
        private static final long serialVersionUID = 0xA67FA9B2A7CA306L;
        @b("TYPE")
        public String type;
        @b("WEBVIEWURL")
        public String webViewUrl;
        @b("WEBVIEWURLWITHOUTPLAY")
        public String webViewUrlWithoutPlay;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x27C4F960992BCFA1L;

    public MusicWaveWebViewInfoRes() {
        this.response = null;
    }
}

