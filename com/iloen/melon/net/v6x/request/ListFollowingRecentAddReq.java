package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import e1.u;
import va.e0;
import va.o;

public class ListFollowingRecentAddReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public ListFollowingRecentAddReq(Context context0, Params listFollowingRecentAddReq$Params0) {
        super(context0, 0, ListFollowingFollowerRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(listFollowingRecentAddReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listFollowingRecentAdd.json";
    }
}

