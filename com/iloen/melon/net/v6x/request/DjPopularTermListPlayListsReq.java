package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPopularTermPlayListsRes;

public class DjPopularTermListPlayListsReq extends RequestV6_1Req {
    private String term;

    public DjPopularTermListPlayListsReq(Context context0, String s) {
        super(context0, 0, DjPopularTermPlayListsRes.class, true);
        this.term = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/popular/" + this.term.toLowerCase() + "/playlists.json";
    }
}

