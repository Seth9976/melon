package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesCreateRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class DjSeriesCreateReq extends RequestV6_1Req {
    public DjSeriesCreateReq(Context context0, String s, String s1, String s2, String s3) {
        super(context0, 1, DjSeriesCreateRes.class, false);
        this.addMemberKey();
        this.addParam("seriesTitle", s);
        this.addParam("plylstSeqList", s1);
        this.addParam("seriesPlylstSeq", s2);
        this.addParam("repntImg", s3);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/create.json";
    }
}

