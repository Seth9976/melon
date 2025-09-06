package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes;

public class GenreMoreArtistReq extends RequestV5Req {
    public static class Params {
        public String filterTypeCode;
        public String filterTypeFlg;
        public String gnrCode;
        public String gnrContsSeq;
        public int pageSize;
        public int startIndex;

    }

    public GenreMoreArtistReq(Context context0, Params genreMoreArtistReq$Params0) {
        super(context0, 0, GenreMoreArtistRes.class, true);
        this.addParams(genreMoreArtistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/more/artist.json";
    }
}

