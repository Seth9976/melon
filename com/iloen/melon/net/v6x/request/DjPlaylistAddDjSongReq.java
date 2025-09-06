package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPlaylistAddDjSongRes;

public class DjPlaylistAddDjSongReq extends PlaylistAddSongBaseReq {
    public DjPlaylistAddDjSongReq(Context context0, Params playlistAddSongBaseReq$Params0) {
        super(context0, playlistAddSongBaseReq$Params0, DjPlaylistAddDjSongRes.class);
    }

    @Override  // com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq
    public String getApiPath() {
        return "/dj/playlist/song/add.json";
    }

    // 去混淆评级： 低(30)
    @Override  // com.iloen.melon.net.v6x.request.PlaylistAddSongBaseReq
    public String getMoveType() {
        return "TOP";
    }
}

