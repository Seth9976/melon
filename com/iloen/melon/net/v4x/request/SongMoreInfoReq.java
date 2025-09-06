package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SongMoreInfoRes;
import com.iloen.melon.net.v6x.request.RequestV6_1Req;

public class SongMoreInfoReq extends RequestV6_1Req {
    public SongMoreInfoReq(Context context0, String s) {
        super(context0, 0, SongMoreInfoRes.class, false);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/moreInfo.json";
    }
}

