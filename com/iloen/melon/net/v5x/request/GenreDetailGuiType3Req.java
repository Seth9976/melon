package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res;

public class GenreDetailGuiType3Req extends RequestV5Req {
    public static class Params {
        public String gnrCode;
        public int pageSize;
        public int startIndex;

    }

    public GenreDetailGuiType3Req(Context context0, Params genreDetailGuiType3Req$Params0) {
        super(context0, 0, GenreDetailGuiType3Res.class, true);
        this.addParams(genreDetailGuiType3Req$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail/guitype3.json";
    }
}

