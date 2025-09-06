package com.iloen.melon.net.v6x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v6x.response.FloatingBannerRes;

public class FloatingBannerReq extends RequestV6Req {
    public static class Params {
        public String bans;

    }

    public FloatingBannerReq(Context context0, Params floatingBannerReq$Params0) {
        super(context0, 0, FloatingBannerRes.class);
        this.addMemberKey();
        this.addParams(floatingBannerReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.e;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/v1/banner/BN000011";
    }

    @Override  // com.iloen.melon.net.v6x.request.RequestV6Req
    public String getApiVersionPath() {
        return "";
    }
}

