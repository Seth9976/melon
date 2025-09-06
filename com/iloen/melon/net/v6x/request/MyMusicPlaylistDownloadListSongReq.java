package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistDownloadListSongRes;

public class MyMusicPlaylistDownloadListSongReq extends RequestV6_1Req {
    public MyMusicPlaylistDownloadListSongReq(Context context0, String s) {
        super(context0, 0, MyMusicPlaylistDownloadListSongRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/download/listSong.json";
    }
}

