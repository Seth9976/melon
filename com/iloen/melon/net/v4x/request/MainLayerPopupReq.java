package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MainLayerPopupRes;

public class MainLayerPopupReq extends BannerBaseReq {
    public static class Params {
        public String bans;

    }

    public MainLayerPopupReq(Context context0, Params mainLayerPopupReq$Params0) {
        super(context0, 0, MainLayerPopupRes.class);
        this.addMemberKey();
        this.addParams(mainLayerPopupReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/v1/banner/BN000001";
    }
}

