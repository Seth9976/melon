package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.FeedLogsListRes;

public class FeedLogsDeleteFeedLogReq extends RequestV6Req {
    public static class Params {
        public String rowKey;

    }

    public FeedLogsDeleteFeedLogReq(Context context0, Params feedLogsDeleteFeedLogReq$Params0) {
        super(context0, 0, FeedLogsListRes.class);
        this.addMemberKey();
        this.addParams(feedLogsDeleteFeedLogReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/feedlogs/deleteFeedLog.json";
    }
}

