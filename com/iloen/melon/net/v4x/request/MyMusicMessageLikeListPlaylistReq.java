package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListPlaylistRes;

public class MyMusicMessageLikeListPlaylistReq extends LikeListPlaylistBaseReq {
    public MyMusicMessageLikeListPlaylistReq(Context context0, Params likeListPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/like/listPlaylist.json";
    }
}

