package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPopularListPlylstForEdgeRes;

public class DjPopularListPlylstForEdgeReq extends DjPopularListPlylstBaseReq {
    public DjPopularListPlylstForEdgeReq(Context context0, String s) {
        super(context0, 0, DjPopularListPlylstForEdgeRes.class, false);
        this.addParam("cateCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/popular/listPlylstForEdge.json";
    }
}

