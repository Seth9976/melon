package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes;

public class MelonTvTodayReq extends RequestV5_1Req {
    public MelonTvTodayReq(Context context0) {
        super(context0, 0, MelonTvTodayRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/today.json";
    }
}

