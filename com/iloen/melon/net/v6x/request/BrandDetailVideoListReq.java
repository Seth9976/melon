package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.BrandDetailVideoListRes;

public class BrandDetailVideoListReq extends RequestV6_1Req {
    public static class Params {
        public String brandDjKey;
        public int pageSize;
        public int startIndex;

    }

    public BrandDetailVideoListReq(Context context0, Params brandDetailVideoListReq$Params0) {
        super(context0, 0, BrandDetailVideoListRes.class, false);
        this.addParams(brandDetailVideoListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brandDetail/video/list.json";
    }
}

