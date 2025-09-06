package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.FeedLogsResetCountRes;

public class FeedLogsResetCountReq extends RequestV6Req {
    public FeedLogsResetCountReq(Context context0) {
        super(context0, 0, FeedLogsResetCountRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/feedlogs/resetCount.json";
    }
}

