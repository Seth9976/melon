package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsStationRes;

public class SongContentsStationReq extends RequestV6_1Req {
    public static class Params {
        public int pageSize;
        public String songId;
        public int startIndex;

    }

    public SongContentsStationReq(Context context0, Params songContentsStationReq$Params0) {
        super(context0, 0, DetailContentsStationRes.class);
        this.addParams(songContentsStationReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/station.json";
    }
}

