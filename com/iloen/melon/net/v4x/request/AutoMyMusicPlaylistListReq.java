package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class AutoMyMusicPlaylistListReq extends MyMusicPlaylistPlayListReq {
    public AutoMyMusicPlaylistListReq(Context context0, Params playlistListBaseReq$Params0) {
        super(context0, playlistListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v4x.request.MyMusicPlaylistPlayListReq
    public String getApiPath() {
        return "/auto/mymusic/playlist/list.json";
    }
}

