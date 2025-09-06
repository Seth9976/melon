package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.request.BannerBaseReq;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes;

public class PromotionContentsBannerReq extends BannerBaseReq {
    public static class Param {
        public String contsId;
        public String contsType;

    }

    public PromotionContentsBannerReq(Context context0, Param promotionContentsBannerReq$Param0) {
        super(context0, 0, PromotionContentsBannerRes.class);
        this.addMemberKey();
        this.addParam("contsTypeCode", promotionContentsBannerReq$Param0.contsType);
        this.addParam("contsId", promotionContentsBannerReq$Param0.contsId);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/v1/group/banner/BNG00003";
    }
}

