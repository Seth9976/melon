package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MelonTvLiveListRes;

public class MelonTvLiveListReq extends RequestV4Req {
    public MelonTvLiveListReq(Context context0) {
        super(context0, 0, MelonTvLiveListRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/melontv/live/list.json";
    }
}

