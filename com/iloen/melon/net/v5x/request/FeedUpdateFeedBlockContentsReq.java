package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.FeedUpdateFeedBlockContentsRes;

public class FeedUpdateFeedBlockContentsReq extends RequestV5Req {
    public static class Params {
        public String blockYn;
        public String contsId;
        public String contsTypeCode;

    }

    public FeedUpdateFeedBlockContentsReq(Context context0, Params feedUpdateFeedBlockContentsReq$Params0) {
        super(context0, 0, FeedUpdateFeedBlockContentsRes.class);
        this.addMemberKey();
        this.addParams(feedUpdateFeedBlockContentsReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/feed/updateFeedBlockContents.json";
    }
}

