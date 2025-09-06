package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ListFollowerRecentActRes;

public class ListFollowerRecentActReq extends RequestV4_1Req {
    public static class Params {
        public String originCode;
        public int pageSize;
        public int startIndex;

    }

    public ListFollowerRecentActReq(Context context0, Params listFollowerRecentActReq$Params0) {
        super(context0, 0, ListFollowerRecentActRes.class);
        this.addMemberKey();
        this.addParams(listFollowerRecentActReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listFollowerRecentAct.json";
    }
}

