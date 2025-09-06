package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;

public class ArtistTemperatureRegMemorialCardRelayReq extends RequestV6_2Req {
    public ArtistTemperatureRegMemorialCardRelayReq(Context context0, String s) {
        super(context0, 1, HttpResponse.class, false);
        this.setJsonString(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/regMemorialCardRelay.json";
    }
}

