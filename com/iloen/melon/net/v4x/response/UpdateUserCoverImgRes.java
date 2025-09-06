package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class UpdateUserCoverImgRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("MYCOVERIMG")
        public String myCoverImg;
        private static final long serialVersionUID = 0x928A42C9E62C3F6DL;
        @b("SLEEPTIME")
        public String sleepTime;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x78AD611D2705D8CCL;

    public UpdateUserCoverImgRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

