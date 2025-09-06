package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistListRes;

public class MyMusicPlaylistListReq extends PlaylistListBaseReq {
    public MyMusicPlaylistListReq(Context context0, Params playlistListBaseReq$Params0) {
        super(context0, 0, MyMusicPlaylistListRes.class);
        this.addMemberKey();
        this.addParams(playlistListBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/playlist/list.json";
    }
}

