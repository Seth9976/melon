package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.FeedLogsNewsCountRes;

public class FeedLogsNewsCountReq extends RequestV6Req {
    public FeedLogsNewsCountReq(Context context0) {
        super(context0, 0, FeedLogsNewsCountRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/feedlogs/newsCount.json";
    }
}

