package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;

public class MyMusicMessageLikeListAlbumReq extends LikeListAlbumBaseReq {
    public MyMusicMessageLikeListAlbumReq(Context context0, Params likeListAlbumBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListAlbumRes.class);
        this.addMemberKey();
        this.addParams(likeListAlbumBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/like/listAlbum.json";
    }
}

