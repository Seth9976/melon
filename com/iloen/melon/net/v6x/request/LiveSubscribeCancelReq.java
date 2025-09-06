package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveSubscribeCancelRes;

public class LiveSubscribeCancelReq extends RequestV6Req {
    public LiveSubscribeCancelReq(Context context0, String s) {
        super(context0, 0, LiveSubscribeCancelRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/subscribe/cancel.json";
    }
}

