package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MixupListRes extends RequestAutoRes {
    public static class LIST {
        @b("CONTSID")
        public String constId;
        @b("CONTSIMG")
        public String constImg;
        @b("CONTSNAME")
        public String constName;
        @b("CONTSTYPECODE")
        public String constTypeCode;
        @b("SUBTITLE")
        public String subtitle;

        public LIST() {
            this.constId = "";
            this.constTypeCode = "";
            this.constImg = "";
            this.constName = "";
            this.subtitle = "";
        }
    }

    public static class RESPONSE extends ResponseBase {
        @b("LIST")
        public ArrayList list;

        public RESPONSE() {
            this.list = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1541D46D3CE90AACL;

}

