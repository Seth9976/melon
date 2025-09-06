package com.iloen.melon.net.v6x.request;

import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicLikeListLikeSongPlystReq extends RequestV6Req {
    public MyMusicLikeListLikeSongPlystReq() {
        super(0, MyMusicLikePlaylistRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/like/listLikeSongPlyst.json";
    }
}

