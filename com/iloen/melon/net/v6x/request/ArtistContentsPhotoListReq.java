package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes;

public class ArtistContentsPhotoListReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String orderBy;
        public int pageSize;
        public int startIndex;

    }

    public ArtistContentsPhotoListReq(Context context0, Params artistContentsPhotoListReq$Params0) {
        super(context0, 0, ArtistContentsPhotoListRes.class);
        this.addParams(artistContentsPhotoListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/photoList.json";
    }
}

