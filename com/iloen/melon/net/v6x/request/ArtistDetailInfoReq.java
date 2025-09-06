package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes;

public class ArtistDetailInfoReq extends RequestV6_1Req {
    public ArtistDetailInfoReq(Context context0, String s) {
        super(context0, 0, ArtistDetailInfoRes.class, false);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/detail/info.json";
    }
}

