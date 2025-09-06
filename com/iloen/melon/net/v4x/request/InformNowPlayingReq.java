package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.InformNowPlayingRes;

public class InformNowPlayingReq extends RequestV4Req {
    public InformNowPlayingReq(Context context0, String s) {
        super(context0, 0, InformNowPlayingRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParam("nowPlaySeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/nowplaying/nowplaying/informNowPlaying.json";
    }
}

