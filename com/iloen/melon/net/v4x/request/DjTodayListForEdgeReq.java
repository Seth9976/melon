package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjTodayListForEdgeRes;

public class DjTodayListForEdgeReq extends RequestV4Req {
    public DjTodayListForEdgeReq(Context context0) {
        super(context0, 0, DjTodayListForEdgeRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/today/listForEdge.json";
    }
}

