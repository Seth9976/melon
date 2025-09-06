package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPicksInformRes;

public class DjPicksInformReq extends RequestV4Req {
    public DjPicksInformReq(Context context0, String s) {
        super(context0, 0, DjPicksInformRes.class, false);
        this.addParam("pickId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/picks/inform.json";
    }
}

