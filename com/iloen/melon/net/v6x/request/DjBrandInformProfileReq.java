package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandInformProfileRes;

public class DjBrandInformProfileReq extends RequestV6_1Req {
    public DjBrandInformProfileReq(Context context0, String s) {
        super(context0, 0, DjBrandInformProfileRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("brandDjKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brand/informProfile.json";
    }
}

