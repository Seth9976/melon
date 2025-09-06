package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MusicMessageInsertBanUserRes;

public class MusicMessageInsertBanUserReq extends RequestV6Req {
    public static class Params {
        public String memberKeyBan;

        public Params() {
            this.memberKeyBan = "";
        }
    }

    public MusicMessageInsertBanUserReq(Context context0, Params musicMessageInsertBanUserReq$Params0) {
        super(context0, 1, MusicMessageInsertBanUserRes.class);
        this.addMemberKey();
        this.addParams(musicMessageInsertBanUserReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/insertBanUser.json";
    }
}

