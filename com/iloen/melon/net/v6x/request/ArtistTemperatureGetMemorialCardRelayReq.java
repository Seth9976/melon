package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes;

public class ArtistTemperatureGetMemorialCardRelayReq extends RequestV6_4Req {
    public ArtistTemperatureGetMemorialCardRelayReq(Context context0, String s, String s1) {
        super(context0, 0, ArtistTemperatureGetMemorialCardRelayRes.class);
        this.addParam("limit", s);
        this.addParam("artistId", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/getMemorialCardRelay.json";
    }
}

