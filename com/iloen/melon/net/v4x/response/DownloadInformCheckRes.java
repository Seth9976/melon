package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DownloadInformCheckRes extends ResponseV4Res {
    public static class ErrorCode {
        public static final String EXPIRED = "CD0708";

    }

    public static class ProductType {
        public static final String LIMITESS_DRM = "2";
        public static final String METER_RATE = "0";
        public static final String PERIOD_DRM = "1";

    }

    public static final class Response extends ResponseBase {
        public static class Contents implements Serializable {
            @b("CID")
            public String cid;
            @b("DLOK")
            public String dlok;
            @b("DLTYPE")
            public String dltype;
            @b("PRODCD")
            public String prodcd;
            private static final long serialVersionUID = 0xBFB0F38E989F3C75L;

            public Contents() {
                this.cid = "";
                this.prodcd = "";
                this.dlok = "";
                this.dltype = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CONTENTS")
        public ArrayList contents;
        @b("CTYPE")
        public String ctype;
        @b("ERRORCODE")
        public String errorCode;
        @b("PRODUCT")
        public String product;
        private static final long serialVersionUID = 0x6B3A078C19251CF5L;
        @b("UID")
        public String uid;
        @b("UKEY")
        public String ukey;

        public Response() {
            this.errorCode = "";
            this.ctype = "";
            this.product = "";
            this.uid = "";
            this.ukey = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0xB10DB24562A7BCC3L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

