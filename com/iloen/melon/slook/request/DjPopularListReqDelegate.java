package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.v4x.request.DjPopularListPlylstForEdgeReq;

public class DjPopularListReqDelegate extends ListReqDelegateBase {
    public DjPopularListReqDelegate(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public HttpRequest createReq() {
        return new DjPopularListPlylstForEdgeReq(this.context, "all");
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public String getCacheKeySubTag() {
        return "samsung_edge_dj_chart";
    }

    @Override  // com.iloen.melon.slook.request.ListReqDelegateBase
    public int getChartType() {
        return 1;
    }
}

