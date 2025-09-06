package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;

public class AlbumContentsMvReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsMvReq(Context context0, Params albumContentsMvReq$Params0) {
        super(context0, 0, DetailContentsMvRes.class);
        this.addParams(albumContentsMvReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/mv.json";
    }
}

