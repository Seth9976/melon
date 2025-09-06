package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.ArtistFanFollowYnListRes;

public class ArtistFanFollowYnListReq extends RequestV6_1Req {
    public ArtistFanFollowYnListReq(Context context0, String s) {
        super(context0, 0, ArtistFanFollowYnListRes.class);
        this.addMemberKey();
        this.addParam("targetMemberKeys", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/artist/fan/followYnList.json";
    }
}

