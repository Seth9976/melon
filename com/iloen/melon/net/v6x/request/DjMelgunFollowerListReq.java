package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjMelgunFollowerListRes;

public class DjMelgunFollowerListReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public DjMelgunFollowerListReq(Context context0, Params djMelgunFollowerListReq$Params0) {
        super(context0, 0, DjMelgunFollowerListRes.class, true);
        this.addParams(djMelgunFollowerListReq$Params0);
        this.addMemberKeyAlwaysDeliver();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/melgun/follower/list.json";
    }
}

