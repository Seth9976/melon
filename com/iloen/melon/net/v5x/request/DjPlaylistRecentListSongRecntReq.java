package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.DjPlaylistRecentListSongRecntRes;
import e1.u;
import va.e0;
import va.o;

public class DjPlaylistRecentListSongRecntReq extends RecentListSongRecntBaseReq {
    public DjPlaylistRecentListSongRecntReq(Context context0, Params recentListSongRecntBaseReq$Params0) {
        super(context0, 0, DjPlaylistRecentListSongRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(recentListSongRecntBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/djplaylist/recent/listSongRecnt.json";
    }
}

