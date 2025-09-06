package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq.Params;
import com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq;
import com.iloen.melon.net.v6x.response.PlaylistUpdateBaseRes;

public class DjPlaylistUpdateReq extends PlaylistUpdateBaseReq {
    public DjPlaylistUpdateReq(Context context0, Params playlistUpdateBaseReq$Params0) {
        super(context0, playlistUpdateBaseReq$Params0, PlaylistUpdateBaseRes.class);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistUpdateBaseReq
    public String getApiPath() {
        return "/dj/playlist/update.json";
    }
}

