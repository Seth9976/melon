package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartTop100ListRes;

public class ChartTop100ListReq extends RequestV6Req {
    public ChartTop100ListReq(Context context0) {
        super(context0, 0, ChartTop100ListRes.class, true);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/ent/songChartList.json";
    }
}

