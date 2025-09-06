package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res;

public class GenreDetailGuiType4Req extends RequestV5Req {
    public static class Params {
        public String contsTypeCode;
        public String gnrCode;
        public int pageSize;
        public int startIndex;

    }

    public GenreDetailGuiType4Req(Context context0, Params genreDetailGuiType4Req$Params0) {
        super(context0, 0, GenreDetailGuiType4Res.class, true);
        this.addParams(genreDetailGuiType4Req$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/detail/guitype4.json";
    }
}

