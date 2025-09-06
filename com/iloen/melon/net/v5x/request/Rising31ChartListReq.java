package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.Rising31ChartListRes;

public class Rising31ChartListReq extends RequestV5_5Req {
    public Rising31ChartListReq(Context context0) {
        super(context0, 0, Rising31ChartListRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/rising31/songChartList.json";
    }
}

