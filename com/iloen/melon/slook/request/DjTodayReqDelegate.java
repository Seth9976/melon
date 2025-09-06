package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.request.DjTodayListForEdgeReq;

public class DjTodayReqDelegate extends ReqDelegateBase {
    public DjTodayReqDelegate(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.slook.request.ReqDelegateBase
    public HttpRequest createReq() {
        return new DjTodayListForEdgeReq(this.context);
    }

    @Override  // com.iloen.melon.slook.request.ReqDelegateBase
    public String getCacheKeySubTag() {
        return "samsung_edge_dj_today";
    }
}

