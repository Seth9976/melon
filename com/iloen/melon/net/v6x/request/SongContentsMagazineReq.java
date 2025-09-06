package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;

public class SongContentsMagazineReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsMagazineReq(Context context0, Params songContentsMagazineReq$Params0) {
        super(context0, 0, DetailContentsMagazineRes.class);
        this.addParams(songContentsMagazineReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/magazine.json";
    }
}

