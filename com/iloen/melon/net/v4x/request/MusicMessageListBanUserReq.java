package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes;

public class MusicMessageListBanUserReq extends RequestV4_1Req {
    public static class Params {
        public int pageSize;
        public int startIndex;

    }

    public MusicMessageListBanUserReq(Context context0, Params musicMessageListBanUserReq$Params0) {
        super(context0, 0, MusicMessageListBanUserRes.class);
        this.addMemberKey();
        this.addParams(musicMessageListBanUserReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/listBanUser.json";
    }
}

