package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class GetShareUrlRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("SHAREURL")
        public String shareUrl;

        public RESPONSE() {
            this.shareUrl = "";
        }
    }

    @b("response")
    public RESPONSE response;
    @b("SHAREURL")
    public String shareUrl;

    public GetShareUrlRes() {
        this.shareUrl = "";
    }
}

