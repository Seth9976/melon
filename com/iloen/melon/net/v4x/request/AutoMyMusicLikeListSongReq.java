package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class AutoMyMusicLikeListSongReq extends MyMusicLikeListSongReq {
    public AutoMyMusicLikeListSongReq(Context context0, Params likeListSongBaseReq$Params0) {
        super(context0, likeListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v4x.request.MyMusicLikeListSongReq
    public String getApiPath() {
        return "/auto/mymusic/like/listSong.json";
    }
}

