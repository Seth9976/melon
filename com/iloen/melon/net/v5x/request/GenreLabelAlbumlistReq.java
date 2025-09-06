package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.GenreLabelAlbumlistRes;

public class GenreLabelAlbumlistReq extends RequestV5Req {
    public static class Params {
        public String labelSeq;
        public int pageSize;
        public int startIndex;

        public Params() {
            this.labelSeq = "";
        }
    }

    public GenreLabelAlbumlistReq(Context context0, Params genreLabelAlbumlistReq$Params0) {
        super(context0, 0, GenreLabelAlbumlistRes.class, true);
        this.addParams(genreLabelAlbumlistReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/genre/label/albumlist.json";
    }
}

