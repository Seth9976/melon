package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartMenuOrderRes;

public class ChartMenuOrderReq extends RequestV6Req {
    public ChartMenuOrderReq(Context context0) {
        super(context0, 0, ChartMenuOrderRes.class, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/menu/order.json";
    }
}

