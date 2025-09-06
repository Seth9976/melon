package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.DjTagSearchRecommendsRes;
import e1.u;
import va.e0;
import va.o;

public class DjTagSearchRecommendsReq extends RequestV6_1Req {
    public DjTagSearchRecommendsReq(Context context0) {
        super(context0, 0, DjTagSearchRecommendsRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/tag/search/recommends.json";
    }
}

