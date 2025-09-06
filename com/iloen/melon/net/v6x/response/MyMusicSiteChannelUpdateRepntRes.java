package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class MyMusicSiteChannelUpdateRepntRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("MEMBERKEY")
        public String memberKey;
        @b("REPNTYN")
        public String repntYn;
        private static final long serialVersionUID = 4875813670030509064L;
        @b("SNSCODE")
        public String snsCode;

        public RESPONSE() {
            this.memberKey = "";
            this.snsCode = "";
            this.repntYn = "N";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7870A093A8B8F32EL;

    public MyMusicSiteChannelUpdateRepntRes() {
        this.response = null;
    }
}

