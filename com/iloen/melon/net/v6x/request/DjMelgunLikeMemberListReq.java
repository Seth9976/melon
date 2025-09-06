package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjMelgunLikeMemberListRes;

public class DjMelgunLikeMemberListReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public DjMelgunLikeMemberListReq(Context context0, Params djMelgunLikeMemberListReq$Params0) {
        super(context0, 0, DjMelgunLikeMemberListRes.class, true);
        this.addParams(djMelgunLikeMemberListReq$Params0);
        this.addMemberKeyAlwaysDeliver();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/melgun/likemember/list.json";
    }
}

