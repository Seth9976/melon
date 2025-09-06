package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumSongPlayListRes;

public class AlbumSongPlayListReq extends RequestV6_1Req {
    public AlbumSongPlayListReq(Context context0, String s) {
        super(context0, 0, AlbumSongPlayListRes.class);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/song/play/list.json";
    }
}

