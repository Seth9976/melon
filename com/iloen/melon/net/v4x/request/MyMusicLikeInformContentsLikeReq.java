package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;

public class MyMusicLikeInformContentsLikeReq extends RequestV4Req {
    public static class Params {
        public String actTypeCode;
        public String contsId;
        public String contsTypeCode;

    }

    public MyMusicLikeInformContentsLikeReq(Context context0, Params myMusicLikeInformContentsLikeReq$Params0) {
        super(context0, 0, MyMusicLikeInformContentsLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeInformContentsLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/informContentsLike.json";
    }
}

