package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistMusicSongFilterListRes;

public class ArtistMusicSongFilterListReq extends RequestV6_1Req {
    public ArtistMusicSongFilterListReq(Context context0, String s) {
        super(context0, 0, ArtistMusicSongFilterListRes.class, false);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/song/filterList.json";
    }
}

