package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes;
import e1.u;
import va.e0;
import va.o;

public class MainBottomSlidePopupReq extends BannerBaseReq {
    public static class Params {
        public String bans;

    }

    public MainBottomSlidePopupReq(Context context0) {
        super(context0, 0, MainBottomSlidePopupRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/api/public/bypass/v1/banner/BN000039";
    }
}

