package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicFriendListInviteUserRes;

public class MyMusicFriendListInviteUserReq extends RequestV4Req {
    public MyMusicFriendListInviteUserReq(Context context0) {
        super(context0, 0, MyMusicFriendListInviteUserRes.class);
        this.addMemberKey();
        this.addParam("startIndex", "1");
        this.addParam("pageSize", "100");
        this.addParam("allYn", "Y");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/listInviteUser.json";
    }
}

