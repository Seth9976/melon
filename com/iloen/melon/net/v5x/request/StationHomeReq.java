package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.StationHomeRes;

public class StationHomeReq extends RequestV5Req {
    public StationHomeReq(Context context0) {
        super(context0, 0, StationHomeRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/station/home.json";
    }
}

