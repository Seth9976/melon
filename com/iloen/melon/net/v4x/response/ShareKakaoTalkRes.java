package com.iloen.melon.net.v4x.response;

import S7.b;
import com.google.gson.t;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class ShareKakaoTalkRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ARGS")
        public t args;
        private static final long serialVersionUID = 0x2CC479F9434689F6L;
        @b("TEMPLATEID")
        public String templateId;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E88E24AEL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

