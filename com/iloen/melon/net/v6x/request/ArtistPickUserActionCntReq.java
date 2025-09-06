package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistPickUserActionCntRes;

public class ArtistPickUserActionCntReq extends RequestV6_1Req {
    public static class Params {
        public String artistPickSeqs;

    }

    public ArtistPickUserActionCntReq(Context context0, String s) {
        super(context0, 0, ArtistPickUserActionCntRes.class);
        this.addParam("artistPickSeqs", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/artistPickUserActionCnt.json";
    }
}

