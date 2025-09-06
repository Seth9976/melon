package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPlaylistIntrodContRes;

public class DjPlaylistIntrodContReq extends PlaylistIntrodContBaseReq {
    public DjPlaylistIntrodContReq(Context context0, Params playlistIntrodContBaseReq$Params0) {
        super(context0, 0, playlistIntrodContBaseReq$Params0, DjPlaylistIntrodContRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistIntrodContBaseReq
    public String getApiPath() {
        return "/dj/playlist/introdCont.json";
    }
}

