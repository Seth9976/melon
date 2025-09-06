package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;

public class SongContentsMvReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsMvReq(Context context0, Params songContentsMvReq$Params0) {
        super(context0, 0, DetailContentsMvRes.class);
        this.addParams(songContentsMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/mv.json";
    }
}

