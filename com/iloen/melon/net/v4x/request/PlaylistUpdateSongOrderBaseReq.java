package com.iloen.melon.net.v4x.request;

import android.content.Context;

public class PlaylistUpdateSongOrderBaseReq extends RequestV4Req {
    public static class ParamsBase {
    }

    public PlaylistUpdateSongOrderBaseReq(Context context0, ParamsBase playlistUpdateSongOrderBaseReq$ParamsBase0, Class class0) {
        super(context0, 1, class0);
        this.addMemberKey();
        this.addParams(playlistUpdateSongOrderBaseReq$ParamsBase0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return null;
    }
}

