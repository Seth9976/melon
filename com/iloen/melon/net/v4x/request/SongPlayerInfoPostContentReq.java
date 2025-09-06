package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.SongPlayerInfoPostContentRes;

public class SongPlayerInfoPostContentReq extends RequestV4Req {
    public SongPlayerInfoPostContentReq(Context context0, String s, String s1) {
        super(context0, 0, SongPlayerInfoPostContentRes.class);
        this.addParam("contsType", s);
        this.addParam("contsId", s1);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/songplayer/infoPostContent.json";
    }
}

