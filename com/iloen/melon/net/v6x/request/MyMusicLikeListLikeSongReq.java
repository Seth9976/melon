package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicLikeListLikeSongRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLikeListLikeSongReq extends RequestV6Req {
    public MyMusicLikeListLikeSongReq(Context context0) {
        super(context0, 0, MyMusicLikeListLikeSongRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listLikeSong.json";
    }
}

