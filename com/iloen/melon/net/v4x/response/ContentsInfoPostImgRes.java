package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class ContentsInfoPostImgRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

