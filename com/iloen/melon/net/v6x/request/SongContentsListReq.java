package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongContentsListRes;

public class SongContentsListReq extends RequestV6_1Req {
    public SongContentsListReq(Context context0, String s) {
        super(context0, 0, SongContentsListRes.class);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/contents/list.json";
    }
}

