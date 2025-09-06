package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesModifyListPlylstRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class DjSeriesModifyListPlylstReq extends RequestV6_1Req {
    public DjSeriesModifyListPlylstReq(Context context0, String s) {
        super(context0, 0, DjSeriesModifyListPlylstRes.class, false);
        this.addMemberKey();
        this.addParam("seriesPlylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/modify/listPlylst.json";
    }
}

