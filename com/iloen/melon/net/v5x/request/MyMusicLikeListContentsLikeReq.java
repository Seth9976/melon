package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes;

public class MyMusicLikeListContentsLikeReq extends RequestV5Req {
    public static class Params {
        public String actTypeCode;
        public String contsIds;
        public String contsTypeCode;

    }

    public MyMusicLikeListContentsLikeReq(Context context0, Params myMusicLikeListContentsLikeReq$Params0) {
        super(context0, 0, MyMusicLikeListContentsLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListContentsLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listContentsLike.json";
    }
}

