package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastBrandDetailRes;

public class CastBrandDetailReq extends RequestV5Req {
    public static class Params {
        public String brandDjKey;

    }

    public CastBrandDetailReq(Context context0, Params castBrandDetailReq$Params0) {
        super(context0, 0, CastBrandDetailRes.class);
        this.addMemberKey();
        this.addParams(castBrandDetailReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/brand/detail.json";
    }
}

