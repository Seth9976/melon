package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class ForULocationLogRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        @b("ANDROIDLOGMIN")
        public String androidLogMin;
        @b("ISAGREE")
        public boolean isAgree;

    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

