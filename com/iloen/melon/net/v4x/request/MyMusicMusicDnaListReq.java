package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicMusicDnaListRes;

public class MyMusicMusicDnaListReq extends RequestV4Req {
    public MyMusicMusicDnaListReq(Context context0, String s) {
        super(context0, 0, MyMusicMusicDnaListRes.class);
        this.addMemberKey();
        this.addParam("targetMemberKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/musicdna/list.json";
    }
}

