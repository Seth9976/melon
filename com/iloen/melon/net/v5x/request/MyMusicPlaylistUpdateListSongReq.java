package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes;

public class MyMusicPlaylistUpdateListSongReq extends PlaylistListSongBaseReq {
    public MyMusicPlaylistUpdateListSongReq(Context context0, Params playlistListSongBaseReq$Params0) {
        super(context0, 0, playlistListSongBaseReq$Params0, MyMusicPlaylistListSongRes.class);
    }

    @Override  // com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/update/listSong.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

