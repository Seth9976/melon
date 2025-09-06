package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ForuTabRes;

public class StationTabReq extends RequestV6Req {
    public StationTabReq(Context context0) {
        super(context0, 0, ForuTabRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/station/tab.json";
    }
}

