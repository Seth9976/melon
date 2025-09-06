package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMorePlaylistRes;

public class GenreMorePlaylistReq extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public int pageSize;
        public int startIndex;

    }

    public GenreMorePlaylistReq(Context context0, Params genreMorePlaylistReq$Params0) {
        super(context0, 0, GenreMorePlaylistRes.class, true);
        this.addParams(genreMorePlaylistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/more/plylst.json";
    }
}

