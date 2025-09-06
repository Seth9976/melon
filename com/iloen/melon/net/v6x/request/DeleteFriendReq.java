package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DeleteFriendRes;

public class DeleteFriendReq extends RequestV6Req {
    public DeleteFriendReq(Context context0, String s, String s1) {
        super(context0, 0, DeleteFriendRes.class);
        this.addMemberKey();
        this.addParam("targetMemberKey", s);
        this.addParam("menuId", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/deleteFriend.json";
    }
}

