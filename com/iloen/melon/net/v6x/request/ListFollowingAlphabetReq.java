package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;

public class ListFollowingAlphabetReq extends RequestV6_1Req {
    public static class Params {
        public String originCode;
        public int pageSize;
        public int startIndex;

    }

    public ListFollowingAlphabetReq(Context context0, Params listFollowingAlphabetReq$Params0) {
        super(context0, 0, ListFollowingFollowerRes.class);
        this.addMemberKey();
        this.addParams(listFollowingAlphabetReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listFollowingAlphabet.json";
    }
}

