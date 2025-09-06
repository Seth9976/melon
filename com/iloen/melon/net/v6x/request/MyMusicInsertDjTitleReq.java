package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicInsertDjTitleRes;

public class MyMusicInsertDjTitleReq extends RequestV6Req {
    public MyMusicInsertDjTitleReq(Context context0, String s) {
        super(context0, 0, MyMusicInsertDjTitleRes.class);
        this.addMemberKey();
        this.addParam("djTitle", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/insertDjTitle.json";
    }
}

