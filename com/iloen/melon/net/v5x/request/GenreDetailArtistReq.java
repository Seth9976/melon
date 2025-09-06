package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes;

public class GenreDetailArtistReq extends RequestV5Req {
    public GenreDetailArtistReq(Context context0, String s) {
        super(context0, 0, GenreDetailArtistRes.class);
        this.addParam("gnrArtistSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail/artist.json";
    }
}

