package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class LiveInsertLikeCountRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("BUTTONONOFF")
        public Boolean buttonOnOff;
        @b("DUMMYTEXT")
        public String dummyText;
        @b("ISMMA")
        public Boolean isMma;
        private static final long serialVersionUID = 0x86AB3EAFAB7A16DEL;

        public RESPONSE() {
            this.buttonOnOff = Boolean.FALSE;
            this.isMma = Boolean.FALSE;
            this.dummyText = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 4308720458422970495L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

