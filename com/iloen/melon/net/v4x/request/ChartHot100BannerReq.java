package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.response.ChartHot100BannerRes;
import com.iloen.melon.utils.system.AppUtils;

public class ChartHot100BannerReq extends HttpRequest {
    public ChartHot100BannerReq(Context context0) {
        super(context0, 0, ChartHot100BannerRes.class);
        this.addParam("appVer", AppUtils.getVersionName(context0));
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.e;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/v1/banner/BN000044";
    }
}

