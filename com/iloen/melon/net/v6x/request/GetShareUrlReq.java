package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.GetShareUrlRes;

public class GetShareUrlReq extends RequestV6Req {
    public static class Params {
        public String desc;
        public String imgUrl;
        public String landingUrl;
        public String title;

    }

    public GetShareUrlReq(Context context0, Params getShareUrlReq$Params0) {
        super(context0, 0, GetShareUrlRes.class);
        this.addParams(getShareUrlReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/support/sns/getShareUrl.json";
    }
}

