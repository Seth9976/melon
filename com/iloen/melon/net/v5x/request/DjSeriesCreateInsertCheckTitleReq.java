package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjSeriesCreateInsertCheckTitleRes;

public class DjSeriesCreateInsertCheckTitleReq extends RequestV5Req {
    public DjSeriesCreateInsertCheckTitleReq(Context context0, String s) {
        super(context0, 0, DjSeriesCreateInsertCheckTitleRes.class, false);
        this.addParamToValueEncoded("plylstTitle", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/series/create/insertCheckTitle.json";
    }
}

