package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;

public class ListFollowingOriginReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public ListFollowingOriginReq(Context context0, Params listFollowingOriginReq$Params0) {
        super(context0, 0, ListFollowingFollowerRes.class);
        this.addMemberKey();
        this.addParams(listFollowingOriginReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listFollowingOrigin.json";
    }
}

