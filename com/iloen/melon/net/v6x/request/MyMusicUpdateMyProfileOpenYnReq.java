package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicUpdateMyProfileOpenYnRes;

public class MyMusicUpdateMyProfileOpenYnReq extends RequestV6Req {
    public MyMusicUpdateMyProfileOpenYnReq(Context context0, String s, String s1) {
        super(context0, 1, MyMusicUpdateMyProfileOpenYnRes.class);
        this.addMemberKey();
        this.addParam("openFlagType", s);
        this.addParam("openYn", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/updateMyProfileOpenYn.json";
    }
}

