package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class PushSetRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 5385200263448289686L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = -1447849127471062409L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

