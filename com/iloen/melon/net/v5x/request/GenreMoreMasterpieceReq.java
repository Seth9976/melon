package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes;

public class GenreMoreMasterpieceReq extends RequestV5_1Req {
    public static class Params {
        public String filterTypeCode;
        public String filterTypeFlg;
        public String gnrCode;
        public String gnrContsSeq;
        public int pageSize;
        public int startIndex;

    }

    public GenreMoreMasterpieceReq(Context context0, Params genreMoreMasterpieceReq$Params0) {
        super(context0, 0, GenreMoreMasterpieceRes.class, true);
        this.addParams(genreMoreMasterpieceReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/more/masterpiece.json";
    }
}

