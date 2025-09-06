package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayListRes;

public class MyMusicPlaylistPlayListReq extends PlaylistListBaseReq {
    public MyMusicPlaylistPlayListReq(Context context0, Params playlistListBaseReq$Params0) {
        super(context0, 0, MyMusicPlaylistPlayListRes.class);
        this.addMemberKey();
        this.addParams(playlistListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/play/list.json";
    }
}

