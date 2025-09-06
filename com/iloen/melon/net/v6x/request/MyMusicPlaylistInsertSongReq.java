package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInsertSongRes;

public class MyMusicPlaylistInsertSongReq extends PlaylistAddSongBaseReq {
    public MyMusicPlaylistInsertSongReq(Context context0, Params playlistAddSongBaseReq$Params0) {
        super(context0, playlistAddSongBaseReq$Params0, MyMusicPlaylistInsertSongRes.class);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq
    public String getApiPath() {
        return "/mymusic/playlist/insertSong.json";
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq
    public String getMoveType() {
        return "TOP";
    }
}

