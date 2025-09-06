package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListDjPlaylistRes;

public class MyMusicLikeUpdateListDjPlaylistReq extends LikeListDjPlaylistBaseReq {
    public MyMusicLikeUpdateListDjPlaylistReq(Context context0, Params likeListDjPlaylistBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListDjPlaylistRes.class);
        this.addMemberKey();
        this.addParams(likeListDjPlaylistBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listDjPlaylist.json";
    }
}

