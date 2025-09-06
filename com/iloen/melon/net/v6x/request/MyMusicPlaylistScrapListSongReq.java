package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistScrapListSongRes;

public class MyMusicPlaylistScrapListSongReq extends RequestV6_1Req {
    public MyMusicPlaylistScrapListSongReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistScrapListSongRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/scrap/listSong.json";
    }
}

