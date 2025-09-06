package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListPlaylistRes;

public class MyMusicLikeUpdateListPlaylistReq extends LikeListPlaylistBaseReq {
    public MyMusicLikeUpdateListPlaylistReq(Context context0, Params likeListPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listPlaylist.json";
    }
}

