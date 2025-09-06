package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicLikeUpdateListCastRes;

public class MyMusicLikeUpdateListCastReq extends MyMusicLikeListCastBaseReq {
    public MyMusicLikeUpdateListCastReq(Context context0, Params myMusicLikeListCastBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListCastRes.class);
        this.addMemberKey();
        this.addParams(myMusicLikeListCastBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listCast.json";
    }
}

