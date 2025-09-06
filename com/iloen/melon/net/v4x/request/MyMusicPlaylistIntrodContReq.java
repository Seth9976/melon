package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistIntrodContRes;

public class MyMusicPlaylistIntrodContReq extends PlaylistIntrodContBaseReq {
    public MyMusicPlaylistIntrodContReq(Context context0, Params playlistIntrodContBaseReq$Params0) {
        super(context0, 0, playlistIntrodContBaseReq$Params0, MyMusicPlaylistIntrodContRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/introdCont.json";
    }
}

