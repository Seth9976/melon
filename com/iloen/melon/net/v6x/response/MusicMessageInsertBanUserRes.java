package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MusicMessageInsertBanUserRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MEMBERKEYBAN")
        public String memberkeyban;
        private static final long serialVersionUID = 0x5278C9767789B4FL;

        public RESPONSE() {
            this.memberkeyban = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xC50F6FA8C48A13L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

