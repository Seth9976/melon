package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class ShortenUrlRes extends HttpResponse {
    public static class RESPONSE {
        @b("originUrl")
        public String originUrl;
        @b("shortUrl")
        public String shortUrl;

        public RESPONSE() {
            this.shortUrl = "";
            this.originUrl = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;

    public ShortenUrlRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

