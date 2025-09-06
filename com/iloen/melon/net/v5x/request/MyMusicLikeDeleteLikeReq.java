package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicLikeDeleteLikeRes;

public class MyMusicLikeDeleteLikeReq extends RequestV5Req {
    public static class Params {
        public String actTypeCode;
        public String contsId;
        public String contsTypeCode;
        public String menuId;

    }

    public MyMusicLikeDeleteLikeReq(Context context0, Params myMusicLikeDeleteLikeReq$Params0) {
        super(context0, 0, MyMusicLikeDeleteLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeDeleteLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/deleteLike.json";
    }
}

