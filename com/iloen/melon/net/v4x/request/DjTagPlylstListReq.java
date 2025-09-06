package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjTagPlylstListRes;

public class DjTagPlylstListReq extends RequestV4Req {
    public static class Params {
        public String lastIndexKey;
        public String orderBy;
        public String pageSize;
        public String tagSeq;

    }

    public DjTagPlylstListReq(Context context0, Params djTagPlylstListReq$Params0) {
        super(context0, 0, DjTagPlylstListRes.class, false);
        this.addParams(djTagPlylstListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/tag/plylstlist.json";
    }
}

