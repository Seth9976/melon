package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjBrandLikeMemberRes;

public class DjBrandLikeMemberReq extends RequestV6_1Req {
    public static class Params {
        public String brandDjKey;
        public int pageSize;
        public int startIndex;

    }

    public DjBrandLikeMemberReq(Context context0, Params djBrandLikeMemberReq$Params0) {
        super(context0, 0, DjBrandLikeMemberRes.class);
        this.addMemberKey();
        this.addParams(djBrandLikeMemberReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/brand/likeMember/list.json";
    }
}

