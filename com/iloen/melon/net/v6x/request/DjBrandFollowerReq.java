package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandFollowerRes;

public class DjBrandFollowerReq extends RequestV6_1Req {
    public static class Params {
        public String brandDjKey;
        public int pageSize;
        public int startIndex;

    }

    public DjBrandFollowerReq(Context context0, Params djBrandFollowerReq$Params0) {
        super(context0, 0, DjBrandFollowerRes.class);
        this.addMemberKey();
        this.addParams(djBrandFollowerReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brand/follower/list.json";
    }
}

