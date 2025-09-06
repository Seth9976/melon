package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.MyMusicPlaylistListSongRes;

public class MyMusicPlaylistDetailListSongReq extends PlaylistListSongBaseReq {
    public MyMusicPlaylistDetailListSongReq(Context context0, Params playlistListSongBaseReq$Params0) {
        super(context0, 0, playlistListSongBaseReq$Params0, MyMusicPlaylistListSongRes.class);
    }

    @Override  // com.iloen.melon.net.v5x.request.PlaylistListSongBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/detail/listSong.json";
    }

    @Override  // com.iloen.melon.net.v5x.request.RequestV5_1Req
    public String getApiVersionPath() {
        return "";
    }
}

