package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistMusicReqSongListRes;

public class ArtistMusicReqSongListReq extends RequestV6_2Req {
    public ArtistMusicReqSongListReq(Context context0, String s) {
        super(context0, 0, ArtistMusicReqSongListRes.class, false);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/repSongList.json";
    }
}

