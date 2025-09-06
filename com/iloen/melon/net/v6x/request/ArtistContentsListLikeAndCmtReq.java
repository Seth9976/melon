package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistContentsListLikeAndCmtRes;

public class ArtistContentsListLikeAndCmtReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String contsIds;
        public String contsTypeCode;

        public Params() {
            this.artistId = "";
            this.contsIds = "";
            this.contsTypeCode = "";
        }
    }

    public ArtistContentsListLikeAndCmtReq(Context context0, Params artistContentsListLikeAndCmtReq$Params0) {
        super(context0, 0, ArtistContentsListLikeAndCmtRes.class);
        this.addParams(artistContentsListLikeAndCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/list/likeAndCmt.json";
    }
}

