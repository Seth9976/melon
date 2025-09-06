package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes;

public class MelonDjPlaylistListSongReq extends PlaylistListSongBaseReq {
    public MelonDjPlaylistListSongReq(Context context0, Params playlistListSongBaseReq$Params0) {
        super(context0, 0, playlistListSongBaseReq$Params0, MelonDjPlaylistListSongRes.class);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistListSongBaseReq
    public String getApiPath() {
        return "/dj/playlist/listSong.json";
    }
}

