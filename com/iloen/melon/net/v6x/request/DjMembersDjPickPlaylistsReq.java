package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes;

public class DjMembersDjPickPlaylistsReq extends RequestV6_1Req {
    public DjMembersDjPickPlaylistsReq(Context context0, String s) {
        super(context0, 0, DjMembersDjPickPlaylistsRes.class);
        this.addMemberKey();
        this.addParam("sortBy", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/members/djpick/playlists.json";
    }
}

