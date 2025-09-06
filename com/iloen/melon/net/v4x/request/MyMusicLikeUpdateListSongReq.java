package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListSongRes;

public class MyMusicLikeUpdateListSongReq extends LikeListSongBaseReq {
    public MyMusicLikeUpdateListSongReq(Context context0, Params likeListSongBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListSongRes.class);
        this.addMemberKey();
        this.addParams(likeListSongBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listSong.json";
    }
}

