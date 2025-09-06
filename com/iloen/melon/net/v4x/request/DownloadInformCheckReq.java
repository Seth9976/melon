package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DownloadInformCheckRes;

public class DownloadInformCheckReq extends RequestV4Req {
    public static class ClassCode {
        public static final String DCF = "2";
        public static final String FLAC16 = "3";
        public static final String FLAC24 = "4";
        public static final String MP3 = "1";

        public static String getName(String s) {
            if("1".equals(s)) {
                return "MP3";
            }
            if("2".equals(s)) {
                return "DCF";
            }
            if("3".equals(s)) {
                return "FLAC16";
            }
            return "4".equals(s) ? "FLAC24" : null;
        }
    }

    public static class MyType {
        public static final String DCF_OR_DCF_EXPIRE = "4";
        public static final String FLAC = "101";
        public static final String GIFTBOX = "8";
        public static final String MP3 = "3";
        public static final String SONG = "5";

    }

    public static class ParamItem {
        public String cids;
        public String classCode;
        public String ctype;
        public String memberKey;
        public String menuId;
        public String mytype;

        public ParamItem() {
            this.memberKey = "0";
        }
    }

    public DownloadInformCheckReq(Context context0, ParamItem downloadInformCheckReq$ParamItem0) {
        super(context0, 1, DownloadInformCheckRes.class);
        this.addMemberKey(downloadInformCheckReq$ParamItem0.memberKey);
        this.addParam("cid", downloadInformCheckReq$ParamItem0.cids);
        this.addParam("ctype", downloadInformCheckReq$ParamItem0.ctype);
        this.addParam("menuId", downloadInformCheckReq$ParamItem0.menuId);
        this.addParam("mytype", downloadInformCheckReq$ParamItem0.mytype);
        this.addParam("classCode", downloadInformCheckReq$ParamItem0.classCode);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/download/android/informCheck.json";
    }
}

