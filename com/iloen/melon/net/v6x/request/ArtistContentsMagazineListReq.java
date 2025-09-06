package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;

public class ArtistContentsMagazineListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public ArtistContentsMagazineListReq(Context context0, Params artistContentsMagazineListReq$Params0) {
        super(context0, 0, DetailContentsMagazineRes.class);
        this.addParams(artistContentsMagazineListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/magazineList.json";
    }
}

