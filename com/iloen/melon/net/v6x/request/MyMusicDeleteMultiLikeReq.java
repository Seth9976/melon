package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicDeleteMultiLikeRes;

public class MyMusicDeleteMultiLikeReq extends RequestV6Req {
    public static class Params {
        public String contentsIds;
        public String contsTypeCode;
        public String menuId;

    }

    public MyMusicDeleteMultiLikeReq(Context context0, Params myMusicDeleteMultiLikeReq$Params0) {
        super(context0, 0, MyMusicDeleteMultiLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicDeleteMultiLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/deleteMultiLike.json";
    }
}

