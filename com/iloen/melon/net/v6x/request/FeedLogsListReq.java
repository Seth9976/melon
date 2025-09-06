package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.FeedLogsListRes;

public class FeedLogsListReq extends RequestV6_1Req {
    public static class Params {
        public String isReset;
        public String lastIndexKey;
        public int pageSize;

    }

    public FeedLogsListReq(Context context0, Params feedLogsListReq$Params0) {
        super(context0, 0, FeedLogsListRes.class);
        this.addMemberKey();
        this.addParams(feedLogsListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/feedlogs/lists.json";
    }
}

