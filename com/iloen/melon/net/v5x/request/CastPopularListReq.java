package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastPopularListRes;

public class CastPopularListReq extends RequestV5Req {
    public CastPopularListReq(Context context0) {
        super(context0, 0, CastPopularListRes.class, false);
        this.addParam("startIndex", "1");
        this.addParam("pageSize", "30");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/popular/list.json";
    }
}

