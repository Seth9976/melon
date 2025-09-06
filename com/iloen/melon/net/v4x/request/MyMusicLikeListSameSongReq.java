package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameSongRes;

public class MyMusicLikeListSameSongReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeListSameSongReq(Context context0, Params myMusicLikeListSameSongReq$Params0) {
        super(context0, 0, MyMusicLikeListSameSongRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListSameSongReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSameSong.json";
    }
}

