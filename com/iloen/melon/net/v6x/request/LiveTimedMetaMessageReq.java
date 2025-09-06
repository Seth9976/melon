package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveTimedMetaMessageRes;

public class LiveTimedMetaMessageReq extends RequestV6Req {
    public LiveTimedMetaMessageReq(Context context0, String s) {
        super(context0, 0, LiveTimedMetaMessageRes.class);
        this.addParam("logSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/timedmeta/message.json";
    }
}

