package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveSubscribeRes;

public class LiveSubscribeReq extends RequestV6Req {
    public LiveSubscribeReq(Context context0, String s) {
        super(context0, 0, LiveSubscribeRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/subscribe.json";
    }
}

