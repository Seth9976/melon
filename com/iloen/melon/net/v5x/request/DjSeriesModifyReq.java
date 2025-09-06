package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesModifyRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class DjSeriesModifyReq extends RequestV6_1Req {
    public DjSeriesModifyReq(Context context0, String s, String s1, String s2, String s3) {
        super(context0, 1, DjSeriesModifyRes.class, false);
        this.addMemberKey();
        this.addParam("seriesTitle", s);
        this.addParam("plylstSeqList", s1);
        this.addParam("seriesPlylstSeq", s2);
        this.addParam("repntImg", s3);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/modify.json";
    }
}

