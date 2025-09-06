package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes;

public class DjSeriesInformReq extends RequestV6_1Req {
    public DjSeriesInformReq(Context context0, String s, boolean z) {
        super(context0, 0, DjSeriesInformRes.class);
        this.addParam("seriesPlylstSeq", s);
        this.addMemberKey();
        if(!z) {
            this.addParam("mode", "all");
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/inform.json";
    }
}

