package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPicksListRes;

public class DjPicksListReq extends RequestV4Req {
    public DjPicksListReq(Context context0) {
        super(context0, 0, DjPicksListRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/picks/list.json";
    }
}

