package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveSubscribeInsertRes;

public class LiveSubscribeInsertReq extends RequestV6Req {
    public LiveSubscribeInsertReq(Context context0, String s) {
        super(context0, 0, LiveSubscribeInsertRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/subscribe/insert.json";
    }
}

