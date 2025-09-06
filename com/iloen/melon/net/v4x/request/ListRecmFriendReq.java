package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ListRecmFriendRes;

public class ListRecmFriendReq extends RequestV4Req {
    public static class Params {
        public String lastIndexKey;
        public int pageSize;

    }

    public ListRecmFriendReq(Context context0, Params listRecmFriendReq$Params0) {
        super(context0, 0, ListRecmFriendRes.class);
        this.addMemberKey();
        this.addParams(listRecmFriendReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listRecmFriend.json";
    }
}

