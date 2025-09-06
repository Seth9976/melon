package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjBrandBannerRes;

public class DjBrandBannerReq extends RequestV5Req {
    public DjBrandBannerReq(Context context0, String s, String s1) {
        super(context0, 0, DjBrandBannerRes.class, false);
        this.addParam("bannerType", s);
        this.addParam("brandDjKey", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brand/banner.json";
    }
}

