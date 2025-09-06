package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.ListCommCodeInfoRes;

public class ListCommCodeInfoReq extends RequestV5Req {
    public ListCommCodeInfoReq(Context context0) {
        super(context0, 1, ListCommCodeInfoRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/support/code/listCommCodeInfo.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

