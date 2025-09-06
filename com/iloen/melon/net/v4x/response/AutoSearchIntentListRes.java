package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class AutoSearchIntentListRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("PLAYAPPSCHEME")
        public String playAppScheme;

        public Response() {
            this.playAppScheme = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

