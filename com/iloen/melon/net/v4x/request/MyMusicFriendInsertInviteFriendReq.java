package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicFriendInsertInviteFriendRes;

public class MyMusicFriendInsertInviteFriendReq extends RequestV4Req {
    public MyMusicFriendInsertInviteFriendReq(Context context0, String s, String s1, String s2) {
        super(context0, 1, MyMusicFriendInsertInviteFriendRes.class);
        this.addMemberKey();
        this.addParam("targetMemberKey", s);
        this.addParamToValueEncoded("inviteUserId", s1);
        this.addParam("friendOrigin", s2);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/insertInviteFriend.json";
    }
}

