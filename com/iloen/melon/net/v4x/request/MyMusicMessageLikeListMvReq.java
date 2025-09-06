package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicLikeListMvRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicMessageLikeListMvReq extends LikeListMvBaseReq {
    public MyMusicMessageLikeListMvReq(Context context0, Params likeListMvBaseReq$Params0) {
        super(context0, 0, MyMusicLikeListMvRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(likeListMvBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/like/listMv.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

