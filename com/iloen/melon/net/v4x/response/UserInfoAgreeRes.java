package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class UserInfoAgreeRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        @b("MEMBERKEY")
        public String memberKey;
        private static final long serialVersionUID = 0x2535E641D1BF38FDL;
        @b("THIRDADAGREE")
        public String thirdAdAgree;
        @b("THIRDPROVIDEAGREE")
        public String thirdProvideAgree;

    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x958AFAF9187331E0L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

