package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ListRes extends RequestAutoRes {
    public static class LIST {
        @b("APIURL")
        public String apiUrl;
        @b("CONTSID")
        public String constId;
        @b("CONTSTYPECODE")
        public String constTypeCode;
        @b("IMGURL")
        public String imgUrl;
        @b("SUBTITLE")
        public String subtitle;
        @b("TITLE")
        public String title;

        public LIST() {
            this.constId = "";
            this.constTypeCode = "";
            this.title = "";
            this.subtitle = "";
            this.imgUrl = "";
            this.apiUrl = "";
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

