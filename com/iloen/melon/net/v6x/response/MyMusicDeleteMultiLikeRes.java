package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicDeleteMultiLikeRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("CONTENTSIDS")
        public String contentsids;
        @b("CONTSTYPECODE")
        public String contstypecode;
        private static final long serialVersionUID = 0x6C61F5E4BE9EC8A1L;

        public RESPONSE() {
            this.contstypecode = "";
            this.contentsids = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x87D36DB4E506E00L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

