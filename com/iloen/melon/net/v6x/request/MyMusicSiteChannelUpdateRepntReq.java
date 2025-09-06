package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicSiteChannelUpdateRepntRes;

public class MyMusicSiteChannelUpdateRepntReq extends RequestV6Req {
    public MyMusicSiteChannelUpdateRepntReq(Context context0, String s, String s1) {
        super(context0, 1, MyMusicSiteChannelUpdateRepntRes.class);
        this.addMemberKey();
        this.addParam("infoCode", s);
        this.addParam("repntYn", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/siteChannel/updateRepnt.json";
    }
}

