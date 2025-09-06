package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.LikeListSongRes;

public class LikeListSongReq extends RequestV5Req {
    public static class Params {
        public String orderBy;
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public LikeListSongReq(Context context0, Params likeListSongReq$Params0) {
        super(context0, 0, LikeListSongRes.class);
        this.addParams(likeListSongReq$Params0);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/main/like/listSong.json";
    }
}

