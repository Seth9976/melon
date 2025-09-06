package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumSongDownListRes;

public class AlbumSongDownListReq extends RequestV6_1Req {
    public AlbumSongDownListReq(Context context0, String s) {
        super(context0, 0, AlbumSongDownListRes.class);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/song/down/list.json";
    }
}

