package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes;

public class MyMusicInformProfileReq extends RequestV6_6Req {
    public MyMusicInformProfileReq(Context context0, String s) {
        super(context0, 0, MyMusicInformProfileRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("targetMemberKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/informProfile.json";
    }
}

