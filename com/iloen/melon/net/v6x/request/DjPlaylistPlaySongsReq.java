package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistPlaySongsRes;

public class DjPlaylistPlaySongsReq extends RequestV6_1Req {
    public DjPlaylistPlaySongsReq(Context context0, String s) {
        super(context0, 0, DjPlaylistPlaySongsRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/play/songs.json";
    }
}

