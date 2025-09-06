package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveTimedMetaVoteRes;

public class LiveTimedMetaVoteReq extends RequestV6Req {
    public LiveTimedMetaVoteReq(Context context0, String s) {
        super(context0, 0, LiveTimedMetaVoteRes.class);
        this.addParam("logSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/timedmeta/vote.json";
    }
}

