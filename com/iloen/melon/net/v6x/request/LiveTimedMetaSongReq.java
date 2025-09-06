package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes;

public class LiveTimedMetaSongReq extends RequestV6Req {
    public LiveTimedMetaSongReq(Context context0, String s) {
        super(context0, 0, LiveTimedMetaSongRes.class);
        this.addParam("logSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/timedmeta/song.json";
    }
}

