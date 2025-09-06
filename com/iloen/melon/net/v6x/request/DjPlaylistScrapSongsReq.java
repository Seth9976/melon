package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistScrapSongsRes;

public class DjPlaylistScrapSongsReq extends RequestV6_1Req {
    public DjPlaylistScrapSongsReq(Context context0, String s) {
        super(context0, 0, DjPlaylistScrapSongsRes.class);
        this.addMemberKey();
        this.addParam("plylstSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/scrap/songs.json";
    }
}

