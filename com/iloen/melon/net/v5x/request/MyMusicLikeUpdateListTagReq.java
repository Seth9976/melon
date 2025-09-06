package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicLikeUpdateListTagRes;

public class MyMusicLikeUpdateListTagReq extends LikeListTagBaseReq {
    public MyMusicLikeUpdateListTagReq(Context context0, Params likeListTagBaseReq$Params0) {
        super(context0, 0, MyMusicLikeUpdateListTagRes.class);
        this.addMemberKey();
        this.addParams(likeListTagBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/update/listTag.json";
    }
}

