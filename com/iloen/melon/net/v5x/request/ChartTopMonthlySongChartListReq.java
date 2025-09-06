package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ChartTopMonthlySongChartListRes;

public class ChartTopMonthlySongChartListReq extends RequestV5Req {
    public static class Params {
        public String isRecom;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
            this.isRecom = "Y";
        }
    }

    public ChartTopMonthlySongChartListReq(Context context0, Params chartTopMonthlySongChartListReq$Params0) {
        super(context0, 0, ChartTopMonthlySongChartListRes.class, true);
        this.addParams(chartTopMonthlySongChartListReq$Params0);
        this.addParam("gnrCode", "DP0000");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/top/monthly/songChartList.json";
    }
}

