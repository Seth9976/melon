package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartReportRes;

public class ChartReportReq extends RequestV6Req {
    public ChartReportReq(Context context0, String s) {
        super(context0, 0, ChartReportRes.class, true);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/song/chartReport.json";
    }
}

