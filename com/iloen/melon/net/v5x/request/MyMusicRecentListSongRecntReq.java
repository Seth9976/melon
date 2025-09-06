package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicRecentListSongRecntRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicRecentListSongRecntReq extends RecentListSongRecntBaseReq {
    public MyMusicRecentListSongRecntReq(Context context0, Params recentListSongRecntBaseReq$Params0) {
        super(context0, 0, MyMusicRecentListSongRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParams(recentListSongRecntBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/recent/listSongRecnt.json";
    }
}

