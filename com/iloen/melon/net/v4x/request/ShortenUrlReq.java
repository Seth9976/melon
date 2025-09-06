package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.response.ShortenUrlRes;

public class ShortenUrlReq extends HttpRequest {
    public ShortenUrlReq(Context context0, String s) {
        super(context0, 0, ShortenUrlRes.class, false);
        this.addParamToValueEncoded("origin", s);
        this.addParam("channelCode", "android");
        this.addParam("v", "1.0");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.b;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/util/shortner/url.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

