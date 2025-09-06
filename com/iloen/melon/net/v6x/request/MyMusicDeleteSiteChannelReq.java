package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicDeleteSiteChannelRes;

public class MyMusicDeleteSiteChannelReq extends RequestV6Req {
    public MyMusicDeleteSiteChannelReq(Context context0, String s) {
        super(context0, 1, MyMusicDeleteSiteChannelRes.class);
        this.addMemberKey();
        this.addParam("infoCode", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/deleteSiteChannel.json";
    }
}

