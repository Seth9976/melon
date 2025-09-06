package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes;

public class CastEpsdDetailReq extends RequestV6Req {
    public CastEpsdDetailReq(Context context0, String s) {
        super(context0, 0, CastEpsdDetailRes.class);
        this.addParam("castSeq", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cast/epsd/detail.json";
    }
}

