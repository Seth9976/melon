package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartHot100ListRes;

public class ChartHot100ListReq extends RequestV6Req {
    public static final String TYPE_D100 = "D100";
    public static final String TYPE_D30 = "D30";

    public ChartHot100ListReq(Context context0, String s) {
        super(context0, 0, ChartHot100ListRes.class, true);
        this.addParam("chartType", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hot100/list.json";
    }
}

