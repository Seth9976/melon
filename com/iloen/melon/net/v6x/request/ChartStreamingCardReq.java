package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ChartStreamingCardRes;

public class ChartStreamingCardReq extends RequestV6Req {
    public ChartStreamingCardReq(Context context0, String s) {
        super(context0, 0, ChartStreamingCardRes.class);
        this.addMemberKey();
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/chart/streaming/card.json";
    }
}

