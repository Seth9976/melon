package com.iloen.melon.net.v6x.request;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import va.e0;
import va.o;

public class MyMusicRecentListSongPlystRecentReq extends RequestV6Req {
    public MyMusicRecentListSongPlystRecentReq() {
        super(0, MyMusicRecentPlaylistRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("appVer", AppUtils.getVersionName(MelonAppBase.instance.getContext()));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/recent/listSongPlystRecnt.json";
    }
}

