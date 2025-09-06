package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListUserWithLikeRes;

public class MyMusicLikeListUserWithLikeReq extends RequestV4Req {
    public static class Params {
        public String actTypeCode;
        public String contsId;
        public String contsTypeCode;
        public int pageSize;
        public int startIndex;

    }

    public MyMusicLikeListUserWithLikeReq(Context context0, Params myMusicLikeListUserWithLikeReq$Params0) {
        super(context0, 0, MyMusicLikeListUserWithLikeRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListUserWithLikeReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listUserWithLike.json";
    }
}

