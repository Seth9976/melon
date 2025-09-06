package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongLyricUpdtMsgCheckRes;

public class SongLyricUpdtMsgCheckReq extends RequestV6_1Req {
    public SongLyricUpdtMsgCheckReq(Context context0, String s) {
        super(context0, 0, SongLyricUpdtMsgCheckRes.class);
        this.addMemberKey();
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/lyricUpdtMsg/check.json";
    }
}

