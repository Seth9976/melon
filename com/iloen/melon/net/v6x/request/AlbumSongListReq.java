package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;

public class AlbumSongListReq extends RequestV6_2Req {
    public AlbumSongListReq(Context context0, String s) {
        super(context0, 0, AlbumSongListRes.class, true);
        this.addParam("albumId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/song/list.json";
    }
}

