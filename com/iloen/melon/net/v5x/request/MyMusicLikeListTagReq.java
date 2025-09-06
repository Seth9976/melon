package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicLikeListTagRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLikeListTagReq extends LikeListTagBaseReq {
    public MyMusicLikeListTagReq(Context context0, Params likeListTagBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListTagRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(likeListTagBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listTag.json";
    }
}

