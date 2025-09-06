package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MelonTvVdoStreamInAppRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("CID")
        public String cid;
        @b("CTYPE")
        public String ctype;
        private static final long serialVersionUID = 0x80D747A9ECB77510L;

        public RESPONSE() {
            this.ctype = "";
            this.cid = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD7EBDF8FD48836BAL;

    public MelonTvVdoStreamInAppRes() {
        this.response = null;
    }
}

