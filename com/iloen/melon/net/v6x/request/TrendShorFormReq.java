package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.TrendShortFormRes;
import e1.u;
import va.e0;
import va.o;

public class TrendShorFormReq extends RequestV6_2Req {
    public TrendShorFormReq(Context context0) {
        super(context0, 0, TrendShortFormRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/trendshortform/list.json";
    }
}

