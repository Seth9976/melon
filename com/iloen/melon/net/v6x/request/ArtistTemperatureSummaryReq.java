package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistTemperatureSummaryRes;

public class ArtistTemperatureSummaryReq extends RequestV6_4Req {
    public ArtistTemperatureSummaryReq(Context context0, String s) {
        super(context0, 0, ArtistTemperatureSummaryRes.class);
        this.addMemberKey();
        this.addParam("artistId", s);
        this.addParam("cardRelayLimit", "10");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/summary.json";
    }
}

