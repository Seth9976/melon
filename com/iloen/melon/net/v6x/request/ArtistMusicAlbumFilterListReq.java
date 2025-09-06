package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistMusicAlbumFilterListRes;

public class ArtistMusicAlbumFilterListReq extends RequestV6_2Req {
    public ArtistMusicAlbumFilterListReq(Context context0, String s) {
        super(context0, 0, ArtistMusicAlbumFilterListRes.class, false);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/music/album/filterList.json";
    }
}

