package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ChartTopWeeklySongChartListRes;

public class ChartTopWeeklySongChartListReq extends RequestV5Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
        }
    }

    public ChartTopWeeklySongChartListReq(Context context0, Params chartTopWeeklySongChartListReq$Params0) {
        super(context0, 0, ChartTopWeeklySongChartListRes.class, true);
        this.addParams(chartTopWeeklySongChartListReq$Params0);
        this.addParam("gnrCode", "DP0000");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/top/weekly/songChartList.json";
    }
}

