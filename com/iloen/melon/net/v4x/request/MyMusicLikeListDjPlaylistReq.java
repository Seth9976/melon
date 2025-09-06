package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListDjPlaylistRes;

public class MyMusicLikeListDjPlaylistReq extends LikeListDjPlaylistBaseReq {
    public MyMusicLikeListDjPlaylistReq(Context context0, Params likeListDjPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListDjPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListDjPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listDjPlaylist.json";
    }
}

