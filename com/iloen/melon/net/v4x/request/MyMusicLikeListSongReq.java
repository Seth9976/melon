package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSongRes;

public class MyMusicLikeListSongReq extends LikeListSongBaseReq {
    public MyMusicLikeListSongReq(Context context0, Params likeListSongBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListSongRes.class);
        this.addMemberKey();
        this.addParams(likeListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listSong.json";
    }
}

