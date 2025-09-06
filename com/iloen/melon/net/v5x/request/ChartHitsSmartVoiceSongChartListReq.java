package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.HourlyChartListRes;

public class ChartHitsSmartVoiceSongChartListReq extends RequestV5Req {
    public ChartHitsSmartVoiceSongChartListReq(Context context0) {
        super(context0, 0, HourlyChartListRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hits/smartvoice/songChartList.json";
    }
}

