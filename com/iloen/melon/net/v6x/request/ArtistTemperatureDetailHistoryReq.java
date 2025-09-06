package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailHistoryRes;
import e1.u;
import va.e0;
import va.o;

public class ArtistTemperatureDetailHistoryReq extends RequestV6Req {
    public ArtistTemperatureDetailHistoryReq(Context context0, String s, String s1) {
        super(context0, 0, ArtistTemperatureDetailHistoryRes.class, true);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("artistId", s);
        this.addParam("startIdx", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/detail/history.json";
    }
}

