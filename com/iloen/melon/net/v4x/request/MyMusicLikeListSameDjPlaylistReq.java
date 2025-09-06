package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameDjPlaylistRes;

public class MyMusicLikeListSameDjPlaylistReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeListSameDjPlaylistReq(Context context0, Params myMusicLikeListSameDjPlaylistReq$Params0) {
        super(context0, 0, MyMusicLikeListSameDjPlaylistRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListSameDjPlaylistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSameDjPlaylist.json";
    }
}

