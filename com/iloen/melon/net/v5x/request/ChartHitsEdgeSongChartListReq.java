package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ChartHitsEdgeSongChartListRes;

public class ChartHitsEdgeSongChartListReq extends RequestV5Req {
    public ChartHitsEdgeSongChartListReq(Context context0) {
        super(context0, 0, ChartHitsEdgeSongChartListRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hits/edge/songChartList.json";
    }
}

