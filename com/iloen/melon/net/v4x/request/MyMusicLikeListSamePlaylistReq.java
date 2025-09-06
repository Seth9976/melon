package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSamePlaylistRes;

public class MyMusicLikeListSamePlaylistReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeListSamePlaylistReq(Context context0, Params myMusicLikeListSamePlaylistReq$Params0) {
        super(context0, 0, MyMusicLikeListSamePlaylistRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListSamePlaylistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSamePlaylist.json";
    }
}

