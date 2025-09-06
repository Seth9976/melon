package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistMusicRecmtrackSongListRes;

public class ArtistMusicRecmtrackSongListReq extends RequestV6_1Req {
    public ArtistMusicRecmtrackSongListReq(Context context0, String s, String s1) {
        super(context0, 0, ArtistMusicRecmtrackSongListRes.class, false);
        this.addParam("artistId", s);
        this.addParam("categoryCode", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/recmtrack/songList.json";
    }
}

