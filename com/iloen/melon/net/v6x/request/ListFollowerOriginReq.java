package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import e1.u;
import va.e0;
import va.o;

public class ListFollowerOriginReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public ListFollowerOriginReq(Context context0, Params listFollowerOriginReq$Params0) {
        super(context0, 0, ListFollowingFollowerRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(listFollowerOriginReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listFollowerOrigin.json";
    }
}

