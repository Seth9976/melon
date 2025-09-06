package com.iloen.melon.net.v5x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes;

public class GenreMenuDtlGnrsReq extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public String refcrTypeCode;

    }

    public static final String REFCR_TYPE_ARTIST = "R40013";
    public static final String REFCR_TYPE_MASTERPIECE = "R40012";

    public GenreMenuDtlGnrsReq(Context context0, Params genreMenuDtlGnrsReq$Params0) {
        super(context0, 0, GenreMenuDtlGnrsRes.class, true);
        this.addParam("gnrCode", genreMenuDtlGnrsReq$Params0.gnrCode);
        if(!TextUtils.isEmpty(genreMenuDtlGnrsReq$Params0.refcrTypeCode)) {
            this.addParam("refcrTypeCode", genreMenuDtlGnrsReq$Params0.refcrTypeCode);
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/menu/gnrs.json";
    }
}

