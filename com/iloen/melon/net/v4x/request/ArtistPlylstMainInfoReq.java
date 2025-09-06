package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.ArtistPlylstMainInfoRes;

public class ArtistPlylstMainInfoReq extends RequestV4Req {
    public static class Params {
        public String plylstSeq;

    }

    public ArtistPlylstMainInfoReq(Context context0, Params artistPlylstMainInfoReq$Params0) {
        super(context0, 0, ArtistPlylstMainInfoRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParams(artistPlylstMainInfoReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artistplaylist/mainInfo.json";
    }
}

