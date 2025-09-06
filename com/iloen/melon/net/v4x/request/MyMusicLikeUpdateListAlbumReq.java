package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeUpdateListAlbumRes;

public class MyMusicLikeUpdateListAlbumReq extends LikeListAlbumBaseReq {
    public MyMusicLikeUpdateListAlbumReq(Context context0, Params likeListAlbumBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListAlbumRes.class);
        this.addMemberKey();
        this.addParams(likeListAlbumBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listAlbum.json";
    }
}

