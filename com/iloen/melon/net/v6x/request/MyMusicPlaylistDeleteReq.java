package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistDeleteRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistDeleteReq extends RequestV6_1Req {
    public MyMusicPlaylistDeleteReq(Context context0, String s) {
        super(context0, 1, MyMusicPlaylistDeleteRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstSeqs", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/delete.json";
    }
}

