package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class PostSongKakaoBadgeRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("AGREEURL")
        public String agreeUrl;
        @b("HEADERTOKEN")
        public String headerToken;
        private static final long serialVersionUID = 0x6E25BA3D4C4DF419L;
        @b("STATUSCODE")
        public String statusCode;

        public RESPONSE() {
            this.statusCode = "";
            this.agreeUrl = "";
            this.headerToken = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1ED2F84C2CC55E27L;

    public PostSongKakaoBadgeRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

