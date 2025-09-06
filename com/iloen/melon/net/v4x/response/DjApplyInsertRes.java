package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class DjApplyInsertRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ACTION")
        public String action;
        @b("MESSAGE")
        public String message;
        @b("OPTION")
        public String option;
        private static final long serialVersionUID = 0xBB5B796EA0CDC2CEL;

        public RESPONSE() {
            this.option = "";
            this.action = "";
            this.message = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7032C9F3EE623BE4L;

    public DjApplyInsertRes() {
        this.response = null;
    }
}

