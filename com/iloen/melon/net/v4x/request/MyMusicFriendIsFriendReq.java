package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicFriendIsFriendRes;

public class MyMusicFriendIsFriendReq extends RequestV4Req {
    public static class Params {
        public String targetMemberKey;

    }

    public MyMusicFriendIsFriendReq(Context context0, Params myMusicFriendIsFriendReq$Params0) {
        super(context0, 0, MyMusicFriendIsFriendRes.class);
        this.addMemberKey();
        this.addParams(myMusicFriendIsFriendReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/isFriend.json";
    }
}

