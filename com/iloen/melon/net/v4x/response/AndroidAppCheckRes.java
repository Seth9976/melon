package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class AndroidAppCheckRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("CHKFLAG")
        public String chkflag;
        @b("DPVERSION")
        public String dpVersion;
        @b("MESSAGE")
        public String message;
        @b("NOTIFLAG")
        public String notiflag;
        private static final long serialVersionUID = 0x19F29A74DB10B42BL;
        @b("URL1")
        public String url1;
        @b("URL2")
        public String url2;
        @b("URL3")
        public String url3;

        public Response() {
            this.chkflag = "";
            this.notiflag = "";
            this.dpVersion = "";
            this.message = "";
            this.url1 = "";
            this.url2 = "";
            this.url3 = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x86BD450816D597C6L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

