package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class UpdateUserImgRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("MYPAGEIMGORG")
        public String myPageImgOrg;
        private static final long serialVersionUID = 3983098006880204577L;
        @b("SLEEPTIME")
        public String sleepTime;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x78AD611D2705D8CCL;

    public UpdateUserImgRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

