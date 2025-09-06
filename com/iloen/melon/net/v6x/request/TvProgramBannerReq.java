package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.request.BannerBaseReq;
import com.iloen.melon.net.v6x.response.TvProgramBannerRes;

public class TvProgramBannerReq extends BannerBaseReq {
    public TvProgramBannerReq(Context context0, String s) {
        super(context0, 0, TvProgramBannerRes.class);
        this.addParam("contsTypeCode", "N10044");
        this.addParam("contsId", s);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/v1/banner/BN000022";
    }
}

