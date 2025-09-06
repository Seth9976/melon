package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DailyAlbumChartListRes;

public class DailyAlbumChartListReq extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public String isRecom;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.startIndex = 1;
            this.pageSize = 100;
            this.isRecom = "Y";
            this.gnrCode = "GN2200";
        }
    }

    public DailyAlbumChartListReq(Context context0, Params dailyAlbumChartListReq$Params0) {
        super(context0, 0, DailyAlbumChartListRes.class, true);
        this.addParams(dailyAlbumChartListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/daily/albumChartList.json";
    }
}

