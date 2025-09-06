package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.CheckProductSrcFlagRes;

public class CheckProductSrcFlagReq extends RequestV4Req {
    public static final class SrcType {
        public static final String ANY = "ANY";
        public static final String NONE = "NONE";
        public static final String PPS = "PPS";
        public static final String SONG_FLAC_ST = "SONG_FLAC_ST";
        public static final String SONG_FLAC_ST_POC_CASE = "SONG_FLAC_ST_POC_CASE";

    }

    public CheckProductSrcFlagReq(Context context0, String s) {
        super(context0, 0, CheckProductSrcFlagRes.class);
        this.addMemberKey();
        this.addParam("srcType", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/personal/checkProductSrcFlag.json";
    }
}

