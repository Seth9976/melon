package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvLiveOnAirRes;

public class MelonTvLiveOnAirReq extends RequestV4Req {
    public MelonTvLiveOnAirReq(Context context0) {
        super(context0, 0, MelonTvLiveOnAirRes.class, false);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/live/onair.json";
    }
}

