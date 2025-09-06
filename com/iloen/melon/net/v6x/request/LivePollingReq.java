package com.iloen.melon.net.v6x.request;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.LivePollingRes;

public class LivePollingReq extends RequestV6_1Req {
    public LivePollingReq(String s) {
        super(MelonAppBase.instance.getContext(), 0, LivePollingRes.class);
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/polling.json";
    }
}

