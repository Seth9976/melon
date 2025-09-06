package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LivePlayerRes;

public class LivePlayerReq extends RequestV6Req {
    public LivePlayerReq(Context context0, String s) {
        super(context0, 0, LivePlayerRes.class);
        this.addMemberKey();
        this.addParam("liveSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/player.json";
    }
}

