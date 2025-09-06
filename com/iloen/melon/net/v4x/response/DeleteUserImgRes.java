package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DeleteUserImgRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("MYPAGEIMG")
        public String myPageImg;
        @b("MYPAGEIMGORG")
        public String myPageImgOrg;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

