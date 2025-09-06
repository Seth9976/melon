package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesPlylstAddRes;

public class DjSeriesPlylstAddReq extends RequestV5Req {
    public DjSeriesPlylstAddReq(Context context0, String s, String s1) {
        super(context0, 0, DjSeriesPlylstAddRes.class, false);
        this.addMemberKey();
        this.addParam("plylstTypeCode", "M20002");
        this.addParam("plylstSeqList", s);
        this.addParam("seriesPlylstSeq", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/plylst/add.json";
    }
}

