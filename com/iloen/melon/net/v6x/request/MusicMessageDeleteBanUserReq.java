package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;

public class MusicMessageDeleteBanUserReq extends RequestV6Req {
    public static class Params {
        public String memberKeyBan;

        public Params() {
            this.memberKeyBan = "";
        }
    }

    public MusicMessageDeleteBanUserReq(Context context0, Params musicMessageDeleteBanUserReq$Params0) {
        super(context0, 1, MusicMessageDeleteBanUserRes.class);
        this.addMemberKey();
        this.addParams(musicMessageDeleteBanUserReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/deleteBanUser.json";
    }
}

