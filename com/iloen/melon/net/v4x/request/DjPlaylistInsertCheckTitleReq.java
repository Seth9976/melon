package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPlaylistInsertCheckTitleRes;

public class DjPlaylistInsertCheckTitleReq extends PlaylistInsertCheckTitleBaseReq {
    public DjPlaylistInsertCheckTitleReq(Context context0, String s) {
        super(context0, s, DjPlaylistInsertCheckTitleRes.class, false);
        this.addParam("plylstTitle", s);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistInsertCheckTitleBaseReq
    public String getApiPath() {
        return "/dj/playlist/insertCheckTitle.json";
    }
}

