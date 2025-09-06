package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;

public class AlbumContentsMagazineReq extends RequestV6_1Req {
    public static class Params {
        public String albumId;
        public int pageSize;
        public int startIndex;

    }

    public AlbumContentsMagazineReq(Context context0, Params albumContentsMagazineReq$Params0) {
        super(context0, 0, DetailContentsMagazineRes.class);
        this.addParams(albumContentsMagazineReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/album/contents/magazine.json";
    }
}

