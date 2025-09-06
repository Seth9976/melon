package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLikeListCastReq extends MyMusicLikeListCastBaseReq {
    public MyMusicLikeListCastReq(Context context0, Params myMusicLikeListCastBaseReq$Params0) {
        super(context0, 0, MyMusicCastListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(myMusicLikeListCastBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listCast.json";
    }
}

