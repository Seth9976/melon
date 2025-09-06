package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SearchIntentListRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("LANDAPPSCHEME")
        public String landAppScheme;
        @b("PLAYAPPSCHEME")
        public String playAppScheme;

        public Response() {
            this.playAppScheme = "";
            this.landAppScheme = "";
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

