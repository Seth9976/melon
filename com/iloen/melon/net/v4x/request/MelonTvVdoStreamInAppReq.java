package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvVdoStreamInAppRes;

public class MelonTvVdoStreamInAppReq extends RequestV4Req {
    public MelonTvVdoStreamInAppReq(Context context0, String s) {
        super(context0, 0, MelonTvVdoStreamInAppRes.class, false);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/vdo/streamInApp.json";
    }
}

