package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicInsertDjTitleRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("DJTITLE")
        public String djTitle;
        @b("MEMBERKEY")
        public String memberKey;
        private static final long serialVersionUID = 0x32B0F394FF63FFEEL;

        public RESPONSE() {
            this.memberKey = "";
            this.djTitle = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2245891241ED780L;

    public MyMusicInsertDjTitleRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

