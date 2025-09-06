package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsStationRes;

public class AlbumContentsStationReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsStationReq(Context context0, Params albumContentsStationReq$Params0) {
        super(context0, 0, DetailContentsStationRes.class);
        this.addParams(albumContentsStationReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/station.json";
    }
}

