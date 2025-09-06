package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class HomeRes extends RequestAutoRes {
    public static class RESPONSE extends ResponseBase {
        @b("SLOTLIST")
        public ArrayList slotList;

        public RESPONSE() {
            this.slotList = null;
        }
    }

    public static class SLOTLIST {
        @b("APITYPE")
        public String apiType;
        @b("APIURL")
        public String apiUrl;
        @b("IMGURL")
        public String imgUrl;
        @b("TITLE")
        public String title;

        public SLOTLIST() {
            this.title = "";
            this.apiType = "";
            this.apiUrl = "";
            this.imgUrl = "";
        }
    }

    public static final String APITYPE_CHART = "C";
    public static final String APITYPE_MIXUP = "M";
    public static final String APITYPE_NEXTPAGE = "N";
    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x6FA788957DE63AAAL;

}

