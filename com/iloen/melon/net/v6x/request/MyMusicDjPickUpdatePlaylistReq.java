package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicDjPickUpdatePlaylistRes;

public class MyMusicDjPickUpdatePlaylistReq extends RequestV6Req {
    public MyMusicDjPickUpdatePlaylistReq(Context context0, String s) {
        super(context0, 0, MyMusicDjPickUpdatePlaylistRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/djpick/updatePlaylist.json";
    }
}

