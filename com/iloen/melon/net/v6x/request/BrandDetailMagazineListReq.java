package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.BrandDetailMagazineListRes;

public class BrandDetailMagazineListReq extends RequestV6_1Req {
    public static class Params {
        public String brandDjKey;
        public int pageSize;
        public int startIndex;

    }

    public BrandDetailMagazineListReq(Context context0, Params brandDetailMagazineListReq$Params0) {
        super(context0, 0, BrandDetailMagazineListRes.class, false);
        this.addParams(brandDetailMagazineListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brandDetail/magazine/list.json";
    }
}

