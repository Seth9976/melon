package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstRes;

public class DjPopularListPlylstReq extends DjPopularListPlylstBaseReq {
    public DjPopularListPlylstReq(Context context0, String s) {
        super(context0, 0, DjPopularListPlylstRes.class, false);
        this.addParam("cateCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/popular/listPlylst.json";
    }
}

