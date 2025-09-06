package com.iloen.melon.net.androidauto.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MyMusicHomeRes extends RequestAutoRes {
    public static class RESPONSE extends ResponseBase {
        @b("SLOTLIST")
        public ArrayList slotList;

        public RESPONSE() {
            this.slotList = null;
        }
    }

    public static class SLOTLIST {
        @b("APIKEY")
        public String apiKey;
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
            this.apiKey = "";
            this.apiUrl = "";
            this.imgUrl = "";
        }
    }

    public static final String APIKEY_DJ = "dj";
    public static final String APIKEY_LIKE = "like";
    public static final String APIKEY_NORMAL = "normal";
    public static final String APIKEY_RECENT = "recent";
    public static final String APITYPE_NEXTPAGE = "N";
    public static final String APITYPE_PLAY = "P";
    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x886A7F7AC3411CB4L;

}

