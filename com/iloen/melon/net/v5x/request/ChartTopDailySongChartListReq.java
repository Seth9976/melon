package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ChartTopDailySongChartListRes;

public class ChartTopDailySongChartListReq extends RequestV5Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
        }
    }

    public ChartTopDailySongChartListReq(Context context0, Params chartTopDailySongChartListReq$Params0) {
        super(context0, 0, ChartTopDailySongChartListRes.class, true);
        this.addParams(chartTopDailySongChartListReq$Params0);
        this.addParam("grnCode", "DP0000");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/top/daily/songChartList.json";
    }
}

