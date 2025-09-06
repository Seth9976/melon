package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistContentsInfoLikeAndCmtRes;

public class ArtistContentsInfoLikeAndCmtReq extends RequestV6_1Req {
    public static class Params {
        public String artistId;
        public String contsId;
        public String contsTypeCode;

        public Params() {
            this.artistId = "";
            this.contsId = "";
            this.contsTypeCode = "";
        }
    }

    public ArtistContentsInfoLikeAndCmtReq(Context context0, Params artistContentsInfoLikeAndCmtReq$Params0) {
        super(context0, 0, ArtistContentsInfoLikeAndCmtRes.class);
        this.addParams(artistContentsInfoLikeAndCmtReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/info/likeAndCmt.json";
    }
}

