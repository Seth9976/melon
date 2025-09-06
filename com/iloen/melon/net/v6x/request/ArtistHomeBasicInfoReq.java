package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes;

public class ArtistHomeBasicInfoReq extends RequestV6_4Req {
    public ArtistHomeBasicInfoReq(Context context0, String s) {
        super(context0, 0, ArtistHomeBasicInfoRes.class, false);
        this.addMemberKey();
        this.addParam("artistId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/home/basicInfo.json";
    }
}

