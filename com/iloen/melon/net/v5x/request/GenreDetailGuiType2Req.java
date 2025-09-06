package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType2Res;

public class GenreDetailGuiType2Req extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public GenreDetailGuiType2Req(Context context0, Params genreDetailGuiType2Req$Params0) {
        super(context0, 0, GenreDetailGuiType2Res.class, true);
        this.addParams(genreDetailGuiType2Req$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail/guitype2.json";
    }
}

