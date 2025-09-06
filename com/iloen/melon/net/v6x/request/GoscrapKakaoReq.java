package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v6x.response.GoscrapKakaoRes;

public class GoscrapKakaoReq extends HttpRequest {
    public GoscrapKakaoReq(Context context0, String s) {
        super(context0, 1, GoscrapKakaoRes.class, false);
        this.setJsonString(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return "https://goscrap.kakao.com";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/scrap/v7";
    }
}

