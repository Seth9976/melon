package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayDeleteSongRes;

public class MyMusicPlaylistPlayDeleteSongReq extends PlaylistDeleteSongBaseReq {
    public MyMusicPlaylistPlayDeleteSongReq(Context context0, Params playlistDeleteSongBaseReq$Params0) {
        super(context0, playlistDeleteSongBaseReq$Params0, MyMusicPlaylistPlayDeleteSongRes.class);
    }

    public MyMusicPlaylistPlayDeleteSongReq(Params playlistDeleteSongBaseReq$Params0) {
        super(playlistDeleteSongBaseReq$Params0, MyMusicPlaylistPlayDeleteSongRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistDeleteSongBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/play/deleteSong.json";
    }
}

