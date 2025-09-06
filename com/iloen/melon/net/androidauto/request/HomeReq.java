package com.iloen.melon.net.androidauto.request;

import android.content.Context;
import com.iloen.melon.net.androidauto.response.HomeRes;

public class HomeReq extends RequestAutoV1Req {
    public HomeReq(Context context0) {
        super(context0, 0, HomeRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/home.json";
    }
}

