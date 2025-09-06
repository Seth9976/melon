package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.FiveMinuteChartGraphRes;
import com.iloen.melon.net.v6x.request.RequestV6Req;
import java.util.Calendar;

public class FiveChartGraphReq extends RequestV6Req {
    private static final String MINUTE = "minute";

    public FiveChartGraphReq(Context context0) {
        super(context0, 0, FiveMinuteChartGraphRes.class, false);
        this.addParam("minute", String.valueOf(Calendar.getInstance().get(12)));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/hour/five/graph.json?v=4.0";
    }
}

