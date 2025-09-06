package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjPlaylistDeleteRes;
import e1.u;
import va.e0;
import va.o;

public class DjPlaylistDeleteReq extends RequestV6_1Req {
    public DjPlaylistDeleteReq(Context context0, String s) {
        super(context0, 1, DjPlaylistDeleteRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParam("plylstSeqs", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/playlist/delete.json";
    }
}

