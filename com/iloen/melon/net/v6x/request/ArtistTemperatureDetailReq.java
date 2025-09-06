package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes;
import e1.u;
import va.e0;
import va.o;

public class ArtistTemperatureDetailReq extends RequestV6_4Req {
    public ArtistTemperatureDetailReq(Context context0, String s, boolean z) {
        super(context0, 0, ArtistTemperatureDetailRes.class, true);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("artistId", s);
        this.addParam("addPvLog", String.valueOf(z));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/detail.json";
    }
}

