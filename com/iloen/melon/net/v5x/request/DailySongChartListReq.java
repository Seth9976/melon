package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DailySongChartListRes;

public class DailySongChartListReq extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
            this.gnrCode = "DP0000";
        }
    }

    public DailySongChartListReq(Context context0, Params dailySongChartListReq$Params0) {
        super(context0, 0, DailySongChartListRes.class, true);
        this.addParams(dailySongChartListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/daily/songChartList.json";
    }
}

