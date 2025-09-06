package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsStationRes;

public class ArtistContentsStationListReq extends RequestV6_1Req {
    public ArtistContentsStationListReq(Context context0, String s) {
        super(context0, 0, ArtistDetailContentsStationRes.class);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/contents/stationList.json";
    }
}

