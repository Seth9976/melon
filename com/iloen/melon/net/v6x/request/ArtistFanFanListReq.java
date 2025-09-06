package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes;

public class ArtistFanFanListReq extends RequestV6_2Req {
    public ArtistFanFanListReq(Context context0, String s) {
        super(context0, 0, ArtistFanFanListRes.class);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/fan/fanList.json";
    }
}

