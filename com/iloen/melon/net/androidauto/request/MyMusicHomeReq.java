package com.iloen.melon.net.androidauto.request;

import android.content.Context;
import com.iloen.melon.net.androidauto.response.MyMusicHomeRes;

public class MyMusicHomeReq extends RequestAutoV1Req {
    public MyMusicHomeReq(Context context0) {
        super(context0, 0, MyMusicHomeRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/home.json";
    }
}

