package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongContentsSimilarRes;

public class SongContentsSimilarReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsSimilarReq(Context context0, Params songContentsSimilarReq$Params0) {
        super(context0, 0, SongContentsSimilarRes.class);
        this.addParams(songContentsSimilarReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/similar.json";
    }
}

