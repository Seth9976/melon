package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DjPlaylistDeleteRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("PLYLSTSEQ")
        public String plylstseq;
        @b("PLYLSTTYPECODE")
        public String plylsttypecode;
        private static final long serialVersionUID = 2538036075467013506L;

        public RESPONSE() {
            this.plylsttypecode = "";
            this.plylstseq = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2602F6CF80ABD439L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

