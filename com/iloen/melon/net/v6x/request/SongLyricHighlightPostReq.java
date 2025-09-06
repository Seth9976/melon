package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes;
import e1.u;
import va.e0;
import va.o;

public class SongLyricHighlightPostReq extends RequestV6_1Req {
    public SongLyricHighlightPostReq(Context context0, String s) {
        super(context0, 0, SongLyricHighlightPostRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("songId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/song/lyric/highlight/post.json";
    }
}

