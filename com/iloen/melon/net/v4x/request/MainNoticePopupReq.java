package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes;

public class MainNoticePopupReq extends BannerBaseReq {
    public static class Params {
        public String notibannings;

    }

    public MainNoticePopupReq(Context context0, Params mainNoticePopupReq$Params0) {
        super(context0, 0, MainNoticePopupRes.class);
        this.addParams(mainNoticePopupReq$Params0);
        this.addParam("bnrSgmt", "");
    }

    @Override  // com.iloen.melon.net.v4x.request.BannerBaseReq
    public String domain() {
        return M.a;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/main/noticepopup.json";
    }
}

