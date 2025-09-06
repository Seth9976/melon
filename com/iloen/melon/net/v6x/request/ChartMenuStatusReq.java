package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartMenuStatusRes;

public class ChartMenuStatusReq extends RequestV6Req {
    public ChartMenuStatusReq(Context context0) {
        super(context0, 0, ChartMenuStatusRes.class, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/menu/status.json";
    }
}

