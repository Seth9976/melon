package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesDeleteRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class DjSeriesDeleteReq extends RequestV6_1Req {
    public DjSeriesDeleteReq(Context context0, String s) {
        super(context0, 1, DjSeriesDeleteRes.class, false);
        this.addMemberKey();
        this.addParam("seriesPlylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/delete.json";
    }
}

