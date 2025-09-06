package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsSeriesRes;

public class AlbumContentsSeriesReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsSeriesReq(Context context0, Params albumContentsSeriesReq$Params0) {
        super(context0, 0, AlbumDetailContentsSeriesRes.class);
        this.addParams(albumContentsSeriesReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/series.json";
    }
}

