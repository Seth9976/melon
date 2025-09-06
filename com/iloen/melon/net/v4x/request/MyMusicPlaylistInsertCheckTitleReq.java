package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInsertCheckTitleRes;

public class MyMusicPlaylistInsertCheckTitleReq extends PlaylistInsertCheckTitleBaseReq {
    public MyMusicPlaylistInsertCheckTitleReq(Context context0, String s) {
        super(context0, s, MyMusicPlaylistInsertCheckTitleRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistInsertCheckTitleBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/insertCheckTitle.json";
    }
}

