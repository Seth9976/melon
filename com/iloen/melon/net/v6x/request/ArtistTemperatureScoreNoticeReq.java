package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistTemperatureScoreNoticeRes;
import e1.u;
import va.e0;
import va.o;

public class ArtistTemperatureScoreNoticeReq extends RequestV6Req {
    public ArtistTemperatureScoreNoticeReq(Context context0, String s) {
        super(context0, 0, ArtistTemperatureScoreNoticeRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/temperature/score/notice.json";
    }
}

