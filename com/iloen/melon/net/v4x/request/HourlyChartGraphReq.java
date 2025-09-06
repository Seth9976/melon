package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.OneHourChartGraphRes;
import com.iloen.melon.net.v6x.request.RequestV6Req;
import java.util.Calendar;

public class HourlyChartGraphReq extends RequestV6Req {
    private static final String MINUTE = "minute";

    public HourlyChartGraphReq(Context context0) {
        super(context0, 0, OneHourChartGraphRes.class, false);
        this.addParam("minute", String.valueOf(Calendar.getInstance().get(12)));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hour/graph.json.json?v=4.0";
    }
}

