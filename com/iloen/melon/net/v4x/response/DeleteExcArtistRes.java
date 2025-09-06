package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DeleteExcArtistRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0x1703B04E664260CBL;

        public Response() {
            this.message = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x72B3CB1B15DC1A61L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

