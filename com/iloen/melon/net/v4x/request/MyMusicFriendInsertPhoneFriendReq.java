package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicFriendInsertPhoneFriendRes;

public class MyMusicFriendInsertPhoneFriendReq extends RequestV4Req {
    public static class Params {
        public String inviteUserId;
        public String invtFrendName;
        public String phoneNumber;
        public String reInviteYn;

        public Params() {
            this.inviteUserId = "";
            this.invtFrendName = "";
            this.phoneNumber = "";
            this.reInviteYn = "";
        }
    }

    public MyMusicFriendInsertPhoneFriendReq(Context context0, Params myMusicFriendInsertPhoneFriendReq$Params0) {
        super(context0, 1, MyMusicFriendInsertPhoneFriendRes.class);
        this.addMemberKey();
        this.addParams(myMusicFriendInsertPhoneFriendReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/friend/insertPhoneFriend.json";
    }
}

