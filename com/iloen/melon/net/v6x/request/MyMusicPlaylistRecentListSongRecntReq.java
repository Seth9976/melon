package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistRecentListSongRecntRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicPlaylistRecentListSongRecntReq extends RequestV6Req {
    public MyMusicPlaylistRecentListSongRecntReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistRecentListSongRecntRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("targetMemberKey", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/recent/listSongRecnt.json";
    }

    @Override  // com.iloen.melon.net.v6x.request.RequestV6Req
    public String getApiVersionPath() {
        return "";
    }
}

