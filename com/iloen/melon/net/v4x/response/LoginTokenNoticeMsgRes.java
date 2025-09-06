package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class LoginTokenNoticeMsgRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public String response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

