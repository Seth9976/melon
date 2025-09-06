package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSameAlbumRes;

public class MyMusicLikeListSameAlbumReq extends RequestV4Req {
    public static class Params {
        public int pageSize;
        public int startIndex;
        public String targetMemberKey;

    }

    public MyMusicLikeListSameAlbumReq(Context context0, Params myMusicLikeListSameAlbumReq$Params0) {
        super(context0, 0, MyMusicLikeListSameAlbumRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListSameAlbumReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSameAlbum.json";
    }
}

