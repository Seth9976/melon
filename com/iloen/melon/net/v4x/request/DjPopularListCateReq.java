package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPopularListCateRes;

public class DjPopularListCateReq extends RequestV4Req {
    public DjPopularListCateReq(Context context0) {
        super(context0, 0, DjPopularListCateRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/popular/listCate.json";
    }
}

