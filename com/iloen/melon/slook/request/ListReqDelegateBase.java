package com.iloen.melon.slook.request;

import android.content.Context;
import com.iloen.melon.net.HttpRequest;

public abstract class ListReqDelegateBase extends ReqDelegateBase {
    public ListReqDelegateBase(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.slook.request.ReqDelegateBase
    public HttpRequest createReq() {
        return null;
    }

    @Override  // com.iloen.melon.slook.request.ReqDelegateBase
    public String getCacheKeySubTag() {
        return null;
    }

    public abstract int getChartType();
}

