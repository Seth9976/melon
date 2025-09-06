package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMoreNewMusicRes;

public class GenreMoreNewMusicReq extends RequestV5Req {
    public static class Params {
        public String contsTypeCode;
        public String gnrCode;
        public int pageSize;
        public int startIndex;

    }

    public GenreMoreNewMusicReq(Context context0, Params genreMoreNewMusicReq$Params0) {
        super(context0, 0, GenreMoreNewMusicRes.class, true);
        this.addParams(genreMoreNewMusicReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/more/newmusic.json";
    }
}

